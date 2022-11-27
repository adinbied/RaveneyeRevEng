package com.google.firebase.installations.remote;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.heartbeatinfo.HeartBeatInfo.HeartBeat;
import com.google.firebase.installations.FirebaseInstallationsException;
import com.google.firebase.installations.FirebaseInstallationsException.Status;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class FirebaseInstallationServiceClient
{
  private static final String ACCEPT_HEADER_KEY = "Accept";
  private static final String API_KEY_HEADER = "x-goog-api-key";
  private static final String CACHE_CONTROL_DIRECTIVE = "no-cache";
  private static final String CACHE_CONTROL_HEADER_KEY = "Cache-Control";
  private static final String CONTENT_ENCODING_HEADER_KEY = "Content-Encoding";
  private static final String CONTENT_TYPE_HEADER_KEY = "Content-Type";
  private static final String CREATE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations";
  private static final String DELETE_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s";
  private static final Pattern EXPIRATION_TIMESTAMP_PATTERN = Pattern.compile("[0-9]+s");
  private static final String FIREBASE_INSTALLATIONS_API_DOMAIN = "firebaseinstallations.googleapis.com";
  private static final String FIREBASE_INSTALLATIONS_API_VERSION = "v1";
  private static final String FIREBASE_INSTALLATIONS_ID_HEARTBEAT_TAG = "fire-installations-id";
  private static final String FIREBASE_INSTALLATION_AUTH_VERSION = "FIS_v2";
  private static final String FIS_TAG = "Firebase-Installations";
  private static final String GENERATE_AUTH_TOKEN_REQUEST_RESOURCE_NAME_FORMAT = "projects/%s/installations/%s/authTokens:generate";
  private static final String GZIP_CONTENT_ENCODING = "gzip";
  private static final String HEART_BEAT_HEADER = "x-firebase-client-log-type";
  private static final String JSON_CONTENT_TYPE = "application/json";
  private static final int MAX_RETRIES = 1;
  private static final int NETWORK_TIMEOUT_MILLIS = 10000;
  static final String PARSING_EXPIRATION_TIME_ERROR_MESSAGE = "Invalid Expiration Timestamp.";
  private static final String SDK_VERSION_PREFIX = "a:";
  private static final String USER_AGENT_HEADER = "x-firebase-client";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private static final String X_ANDROID_CERT_HEADER_KEY = "X-Android-Cert";
  private static final String X_ANDROID_IID_MIGRATION_KEY = "x-goog-fis-android-iid-migration-auth";
  private static final String X_ANDROID_PACKAGE_HEADER_KEY = "X-Android-Package";
  private final Context context;
  private final HeartBeatInfo heartbeatInfo;
  private final UserAgentPublisher userAgentPublisher;
  
  public FirebaseInstallationServiceClient(Context paramContext, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo)
  {
    this.context = paramContext;
    this.userAgentPublisher = paramUserAgentPublisher;
    this.heartbeatInfo = paramHeartBeatInfo;
  }
  
  private static String availableFirebaseOptions(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      paramString1 = "";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString1);
      paramString1 = localStringBuilder.toString();
    }
    return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", new Object[] { paramString2, paramString3, paramString1 });
  }
  
  private static JSONObject buildCreateFirebaseInstallationRequestBody(String paramString1, String paramString2)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("fid", paramString1);
      localJSONObject.put("appId", paramString2);
      localJSONObject.put("authVersion", "FIS_v2");
      localJSONObject.put("sdkVersion", "a:16.3.3");
      return localJSONObject;
    }
    catch (JSONException paramString1)
    {
      throw new IllegalStateException(paramString1);
    }
  }
  
  private static JSONObject buildGenerateAuthTokenRequestBody()
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONObject1.put("sdkVersion", "a:16.3.3");
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("installation", localJSONObject1);
      return localJSONObject2;
    }
    catch (JSONException localJSONException)
    {
      throw new IllegalStateException(localJSONException);
    }
  }
  
  private String getFingerprintHashForPackage()
  {
    try
    {
      Object localObject = AndroidUtilsLight.getPackageCertificateHashBytes(this.context, this.context.getPackageName());
      if (localObject == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Could not get fingerprint hash for package: ");
        ((StringBuilder)localObject).append(this.context.getPackageName());
        Log.e("ContentValues", ((StringBuilder)localObject).toString());
        return null;
      }
      localObject = Hex.bytesToStringUppercase((byte[])localObject, false);
      return (String)localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No such package: ");
      localStringBuilder.append(this.context.getPackageName());
      Log.e("ContentValues", localStringBuilder.toString(), localNameNotFoundException);
    }
    return null;
  }
  
  private URL getFullyQualifiedRequestUri(String paramString)
    throws FirebaseInstallationsException
  {
    try
    {
      paramString = new URL(String.format("https://%s/%s/%s", new Object[] { "firebaseinstallations.googleapis.com", "v1", paramString }));
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      throw new FirebaseInstallationsException(paramString.getMessage(), FirebaseInstallationsException.Status.UNAVAILABLE);
    }
  }
  
  private static byte[] getJsonBytes(JSONObject paramJSONObject)
    throws IOException
  {
    return paramJSONObject.toString().getBytes("UTF-8");
  }
  
  private static void logBadConfigError()
  {
    Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
  }
  
  private static void logFisCommunicationError(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2, String paramString3)
  {
    paramHttpURLConnection = readErrorResponse(paramHttpURLConnection);
    if (!TextUtils.isEmpty(paramHttpURLConnection))
    {
      Log.w("Firebase-Installations", paramHttpURLConnection);
      Log.w("Firebase-Installations", availableFirebaseOptions(paramString1, paramString2, paramString3));
    }
  }
  
  private HttpURLConnection openHttpURLConnection(URL paramURL, String paramString)
    throws FirebaseInstallationsException
  {
    try
    {
      paramURL = (HttpURLConnection)paramURL.openConnection();
      paramURL.setConnectTimeout(10000);
      paramURL.setUseCaches(false);
      paramURL.setReadTimeout(10000);
      paramURL.addRequestProperty("Content-Type", "application/json");
      paramURL.addRequestProperty("Accept", "application/json");
      paramURL.addRequestProperty("Content-Encoding", "gzip");
      paramURL.addRequestProperty("Cache-Control", "no-cache");
      paramURL.addRequestProperty("X-Android-Package", this.context.getPackageName());
      Object localObject = this.heartbeatInfo;
      if ((localObject != null) && (this.userAgentPublisher != null))
      {
        localObject = ((HeartBeatInfo)localObject).getHeartBeatCode("fire-installations-id");
        if (localObject != HeartBeatInfo.HeartBeat.NONE)
        {
          paramURL.addRequestProperty("x-firebase-client", this.userAgentPublisher.getUserAgent());
          paramURL.addRequestProperty("x-firebase-client-log-type", Integer.toString(((HeartBeatInfo.HeartBeat)localObject).getCode()));
        }
      }
      paramURL.addRequestProperty("X-Android-Cert", getFingerprintHashForPackage());
      paramURL.addRequestProperty("x-goog-api-key", paramString);
      return paramURL;
    }
    catch (IOException paramURL)
    {
      for (;;) {}
    }
    throw new FirebaseInstallationsException("Firebase Installations Service is unavailable. Please try again later.", FirebaseInstallationsException.Status.UNAVAILABLE);
  }
  
  static long parseTokenExpirationTimestamp(String paramString)
  {
    Preconditions.checkArgument(EXPIRATION_TIMESTAMP_PATTERN.matcher(paramString).matches(), "Invalid Expiration Timestamp.");
    if ((paramString != null) && (paramString.length() != 0)) {
      return Long.parseLong(paramString.substring(0, paramString.length() - 1));
    }
    return 0L;
  }
  
  private InstallationResponse readCreateResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    paramHttpURLConnection = paramHttpURLConnection.getInputStream();
    JsonReader localJsonReader = new JsonReader(new InputStreamReader(paramHttpURLConnection, UTF_8));
    TokenResult.Builder localBuilder = TokenResult.builder();
    InstallationResponse.Builder localBuilder1 = InstallationResponse.builder();
    localJsonReader.beginObject();
    while (localJsonReader.hasNext())
    {
      String str = localJsonReader.nextName();
      if (str.equals("name"))
      {
        localBuilder1.setUri(localJsonReader.nextString());
      }
      else if (str.equals("fid"))
      {
        localBuilder1.setFid(localJsonReader.nextString());
      }
      else if (str.equals("refreshToken"))
      {
        localBuilder1.setRefreshToken(localJsonReader.nextString());
      }
      else if (str.equals("authToken"))
      {
        localJsonReader.beginObject();
        while (localJsonReader.hasNext())
        {
          str = localJsonReader.nextName();
          if (str.equals("token")) {
            localBuilder.setToken(localJsonReader.nextString());
          } else if (str.equals("expiresIn")) {
            localBuilder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(localJsonReader.nextString()));
          } else {
            localJsonReader.skipValue();
          }
        }
        localBuilder1.setAuthToken(localBuilder.build());
        localJsonReader.endObject();
      }
      else
      {
        localJsonReader.skipValue();
      }
    }
    localJsonReader.endObject();
    localJsonReader.close();
    paramHttpURLConnection.close();
    return localBuilder1.setResponseCode(InstallationResponse.ResponseCode.OK).build();
  }
  
  /* Error */
  private static String readErrorResponse(HttpURLConnection paramHttpURLConnection)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 463	java/net/HttpURLConnection:getErrorStream	()Ljava/io/InputStream;
    //   4: astore_1
    //   5: aload_1
    //   6: ifnonnull +5 -> 11
    //   9: aconst_null
    //   10: areturn
    //   11: new 465	java/io/BufferedReader
    //   14: dup
    //   15: new 360	java/io/InputStreamReader
    //   18: dup
    //   19: aload_1
    //   20: getstatic 111	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:UTF_8	Ljava/nio/charset/Charset;
    //   23: invokespecial 363	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   26: invokespecial 466	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   29: astore_1
    //   30: new 134	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   37: astore_2
    //   38: aload_1
    //   39: invokevirtual 469	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   42: astore_3
    //   43: aload_3
    //   44: ifnull +19 -> 63
    //   47: aload_2
    //   48: aload_3
    //   49: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload_2
    //   54: bipush 10
    //   56: invokevirtual 472	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: goto -22 -> 38
    //   63: ldc_w 474
    //   66: iconst_3
    //   67: anewarray 4	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: aload_0
    //   73: invokevirtual 477	java/net/HttpURLConnection:getResponseCode	()I
    //   76: invokestatic 481	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   79: aastore
    //   80: dup
    //   81: iconst_1
    //   82: aload_0
    //   83: invokevirtual 484	java/net/HttpURLConnection:getResponseMessage	()Ljava/lang/String;
    //   86: aastore
    //   87: dup
    //   88: iconst_2
    //   89: aload_2
    //   90: aastore
    //   91: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   94: astore_0
    //   95: aload_1
    //   96: invokevirtual 485	java/io/BufferedReader:close	()V
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_1
    //   103: invokevirtual 485	java/io/BufferedReader:close	()V
    //   106: aload_0
    //   107: athrow
    //   108: aload_1
    //   109: invokevirtual 485	java/io/BufferedReader:close	()V
    //   112: aconst_null
    //   113: areturn
    //   114: astore_0
    //   115: goto -7 -> 108
    //   118: astore_1
    //   119: aload_0
    //   120: areturn
    //   121: astore_1
    //   122: goto -16 -> 106
    //   125: astore_0
    //   126: aconst_null
    //   127: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	paramHttpURLConnection	HttpURLConnection
    //   4	105	1	localObject	Object
    //   118	1	1	localIOException1	IOException
    //   121	1	1	localIOException2	IOException
    //   37	53	2	localStringBuilder	StringBuilder
    //   42	7	3	str	String
    // Exception table:
    //   from	to	target	type
    //   30	38	101	finally
    //   38	43	101	finally
    //   47	60	101	finally
    //   63	95	101	finally
    //   30	38	114	java/io/IOException
    //   38	43	114	java/io/IOException
    //   47	60	114	java/io/IOException
    //   63	95	114	java/io/IOException
    //   95	99	118	java/io/IOException
    //   102	106	121	java/io/IOException
    //   108	112	125	java/io/IOException
  }
  
  private TokenResult readGenerateAuthTokenResponse(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    paramHttpURLConnection = paramHttpURLConnection.getInputStream();
    JsonReader localJsonReader = new JsonReader(new InputStreamReader(paramHttpURLConnection, UTF_8));
    TokenResult.Builder localBuilder = TokenResult.builder();
    localJsonReader.beginObject();
    while (localJsonReader.hasNext())
    {
      String str = localJsonReader.nextName();
      if (str.equals("token")) {
        localBuilder.setToken(localJsonReader.nextString());
      } else if (str.equals("expiresIn")) {
        localBuilder.setTokenExpirationTimestamp(parseTokenExpirationTimestamp(localJsonReader.nextString()));
      } else {
        localJsonReader.skipValue();
      }
    }
    localJsonReader.endObject();
    localJsonReader.close();
    paramHttpURLConnection.close();
    return localBuilder.setResponseCode(TokenResult.ResponseCode.OK).build();
  }
  
  private void writeFIDCreateRequestBodyToOutputStream(HttpURLConnection paramHttpURLConnection, String paramString1, String paramString2)
    throws IOException
  {
    writeRequestBodyToOutputStream(paramHttpURLConnection, getJsonBytes(buildCreateFirebaseInstallationRequestBody(paramString1, paramString2)));
  }
  
  private void writeGenerateAuthTokenRequestBodyToOutputStream(HttpURLConnection paramHttpURLConnection)
    throws IOException
  {
    writeRequestBodyToOutputStream(paramHttpURLConnection, getJsonBytes(buildGenerateAuthTokenRequestBody()));
  }
  
  /* Error */
  private static void writeRequestBodyToOutputStream(java.net.URLConnection paramURLConnection, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 515	java/net/URLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   4: astore_0
    //   5: aload_0
    //   6: ifnull +37 -> 43
    //   9: new 517	java/util/zip/GZIPOutputStream
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 520	java/util/zip/GZIPOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   17: astore_2
    //   18: aload_2
    //   19: aload_1
    //   20: invokevirtual 524	java/util/zip/GZIPOutputStream:write	([B)V
    //   23: aload_2
    //   24: invokevirtual 525	java/util/zip/GZIPOutputStream:close	()V
    //   27: aload_0
    //   28: invokevirtual 528	java/io/OutputStream:close	()V
    //   31: return
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 525	java/util/zip/GZIPOutputStream:close	()V
    //   37: aload_0
    //   38: invokevirtual 528	java/io/OutputStream:close	()V
    //   41: aload_1
    //   42: athrow
    //   43: new 248	java/io/IOException
    //   46: dup
    //   47: ldc_w 530
    //   50: invokespecial 531	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: athrow
    //   54: astore_0
    //   55: return
    //   56: astore_0
    //   57: goto -16 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	paramURLConnection	java.net.URLConnection
    //   0	60	1	paramArrayOfByte	byte[]
    //   17	17	2	localGZIPOutputStream	java.util.zip.GZIPOutputStream
    // Exception table:
    //   from	to	target	type
    //   18	23	32	finally
    //   23	31	54	java/io/IOException
    //   33	41	56	java/io/IOException
  }
  
  /* Error */
  public InstallationResponse createFirebaseInstallation(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
    throws FirebaseInstallationsException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_0
    //   4: ldc 26
    //   6: iconst_1
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_3
    //   13: aastore
    //   14: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   17: invokespecial 535	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:getFullyQualifiedRequestUri	(Ljava/lang/String;)Ljava/net/URL;
    //   20: astore 9
    //   22: iload 6
    //   24: iconst_1
    //   25: if_icmpgt +163 -> 188
    //   28: aload_0
    //   29: aload 9
    //   31: aload_1
    //   32: invokespecial 537	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:openHttpURLConnection	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   35: astore 8
    //   37: aload 8
    //   39: ldc_w 539
    //   42: invokevirtual 542	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   45: aload 8
    //   47: iconst_1
    //   48: invokevirtual 545	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   51: aload 5
    //   53: ifnull +12 -> 65
    //   56: aload 8
    //   58: ldc 80
    //   60: aload 5
    //   62: invokevirtual 290	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: aload_0
    //   66: aload 8
    //   68: aload_2
    //   69: aload 4
    //   71: invokespecial 547	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:writeFIDCreateRequestBodyToOutputStream	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload 8
    //   76: invokevirtual 477	java/net/HttpURLConnection:getResponseCode	()I
    //   79: istore 7
    //   81: iload 7
    //   83: sipush 200
    //   86: if_icmpne +19 -> 105
    //   89: aload_0
    //   90: aload 8
    //   92: invokespecial 549	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:readCreateResponse	(Ljava/net/HttpURLConnection;)Lcom/google/firebase/installations/remote/InstallationResponse;
    //   95: astore 10
    //   97: aload 8
    //   99: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   102: aload 10
    //   104: areturn
    //   105: aload 8
    //   107: aload 4
    //   109: aload_1
    //   110: aload_3
    //   111: invokestatic 554	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logFisCommunicationError	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   114: iload 7
    //   116: sipush 429
    //   119: if_icmpeq +47 -> 166
    //   122: iload 7
    //   124: sipush 500
    //   127: if_icmplt +14 -> 141
    //   130: iload 7
    //   132: sipush 600
    //   135: if_icmpge +6 -> 141
    //   138: goto +28 -> 166
    //   141: invokestatic 556	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logBadConfigError	()V
    //   144: invokestatic 377	com/google/firebase/installations/remote/InstallationResponse:builder	()Lcom/google/firebase/installations/remote/InstallationResponse$Builder;
    //   147: getstatic 559	com/google/firebase/installations/remote/InstallationResponse$ResponseCode:BAD_CONFIG	Lcom/google/firebase/installations/remote/InstallationResponse$ResponseCode;
    //   150: invokevirtual 457	com/google/firebase/installations/remote/InstallationResponse$Builder:setResponseCode	(Lcom/google/firebase/installations/remote/InstallationResponse$ResponseCode;)Lcom/google/firebase/installations/remote/InstallationResponse$Builder;
    //   153: invokevirtual 460	com/google/firebase/installations/remote/InstallationResponse$Builder:build	()Lcom/google/firebase/installations/remote/InstallationResponse;
    //   156: astore 10
    //   158: aload 8
    //   160: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   163: aload 10
    //   165: areturn
    //   166: iload 6
    //   168: iconst_1
    //   169: iadd
    //   170: istore 6
    //   172: aload 8
    //   174: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   177: goto -155 -> 22
    //   180: astore_1
    //   181: aload 8
    //   183: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   186: aload_1
    //   187: athrow
    //   188: new 222	com/google/firebase/installations/FirebaseInstallationsException
    //   191: dup
    //   192: ldc_w 320
    //   195: getstatic 240	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   198: invokespecial 243	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   201: athrow
    //   202: astore 10
    //   204: goto -38 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	207	0	this	FirebaseInstallationServiceClient
    //   0	207	1	paramString1	String
    //   0	207	2	paramString2	String
    //   0	207	3	paramString3	String
    //   0	207	4	paramString4	String
    //   0	207	5	paramString5	String
    //   1	170	6	i	int
    //   79	57	7	j	int
    //   35	147	8	localHttpURLConnection	HttpURLConnection
    //   20	10	9	localURL	URL
    //   95	69	10	localInstallationResponse	InstallationResponse
    //   202	1	10	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   37	51	180	finally
    //   56	65	180	finally
    //   65	81	180	finally
    //   89	97	180	finally
    //   105	114	180	finally
    //   141	158	180	finally
    //   37	51	202	java/io/IOException
    //   56	65	202	java/io/IOException
    //   65	81	202	java/io/IOException
    //   89	97	202	java/io/IOException
    //   105	114	202	java/io/IOException
    //   141	158	202	java/io/IOException
  }
  
  /* Error */
  public void deleteFirebaseInstallation(String paramString1, String paramString2, String paramString3, String paramString4)
    throws FirebaseInstallationsException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: ldc 29
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_3
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: aastore
    //   18: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 535	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:getFullyQualifiedRequestUri	(Ljava/lang/String;)Ljava/net/URL;
    //   24: astore 7
    //   26: iload 5
    //   28: iconst_1
    //   29: if_icmpgt +165 -> 194
    //   32: aload_0
    //   33: aload 7
    //   35: aload_1
    //   36: invokespecial 537	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:openHttpURLConnection	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   39: astore_2
    //   40: aload_2
    //   41: ldc_w 563
    //   44: invokevirtual 542	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   47: new 134	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   54: astore 8
    //   56: aload 8
    //   58: ldc_w 565
    //   61: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 8
    //   67: aload 4
    //   69: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w 567
    //   77: aload 8
    //   79: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 290	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_2
    //   86: invokevirtual 477	java/net/HttpURLConnection:getResponseCode	()I
    //   89: istore 6
    //   91: iload 6
    //   93: sipush 200
    //   96: if_icmpeq +86 -> 182
    //   99: iload 6
    //   101: sipush 401
    //   104: if_icmpeq +78 -> 182
    //   107: iload 6
    //   109: sipush 404
    //   112: if_icmpne +6 -> 118
    //   115: goto +67 -> 182
    //   118: aload_2
    //   119: aconst_null
    //   120: aload_1
    //   121: aload_3
    //   122: invokestatic 554	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logFisCommunicationError	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: iload 6
    //   127: sipush 429
    //   130: if_icmpeq +39 -> 169
    //   133: iload 6
    //   135: sipush 500
    //   138: if_icmplt +14 -> 152
    //   141: iload 6
    //   143: sipush 600
    //   146: if_icmpge +6 -> 152
    //   149: goto +20 -> 169
    //   152: invokestatic 556	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logBadConfigError	()V
    //   155: new 222	com/google/firebase/installations/FirebaseInstallationsException
    //   158: dup
    //   159: ldc_w 569
    //   162: getstatic 571	com/google/firebase/installations/FirebaseInstallationsException$Status:BAD_CONFIG	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   165: invokespecial 243	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   168: athrow
    //   169: iload 5
    //   171: iconst_1
    //   172: iadd
    //   173: istore 5
    //   175: aload_2
    //   176: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   179: goto -153 -> 26
    //   182: aload_2
    //   183: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   186: return
    //   187: astore_1
    //   188: aload_2
    //   189: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   192: aload_1
    //   193: athrow
    //   194: new 222	com/google/firebase/installations/FirebaseInstallationsException
    //   197: dup
    //   198: ldc_w 320
    //   201: getstatic 240	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   204: invokespecial 243	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   207: athrow
    //   208: astore 8
    //   210: goto -41 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	213	0	this	FirebaseInstallationServiceClient
    //   0	213	1	paramString1	String
    //   0	213	2	paramString2	String
    //   0	213	3	paramString3	String
    //   0	213	4	paramString4	String
    //   1	173	5	i	int
    //   89	58	6	j	int
    //   24	10	7	localURL	URL
    //   54	24	8	localStringBuilder	StringBuilder
    //   208	1	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   40	91	187	finally
    //   118	125	187	finally
    //   152	169	187	finally
    //   40	91	208	java/io/IOException
    //   118	125	208	java/io/IOException
    //   152	169	208	java/io/IOException
  }
  
  /* Error */
  public TokenResult generateAuthToken(String paramString1, String paramString2, String paramString3, String paramString4)
    throws FirebaseInstallationsException
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: ldc 49
    //   6: iconst_2
    //   7: anewarray 4	java/lang/Object
    //   10: dup
    //   11: iconst_0
    //   12: aload_3
    //   13: aastore
    //   14: dup
    //   15: iconst_1
    //   16: aload_2
    //   17: aastore
    //   18: invokestatic 153	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   21: invokespecial 535	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:getFullyQualifiedRequestUri	(Ljava/lang/String;)Ljava/net/URL;
    //   24: astore 7
    //   26: iload 5
    //   28: iconst_1
    //   29: if_icmpgt +180 -> 209
    //   32: aload_0
    //   33: aload 7
    //   35: aload_1
    //   36: invokespecial 537	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:openHttpURLConnection	(Ljava/net/URL;Ljava/lang/String;)Ljava/net/HttpURLConnection;
    //   39: astore_2
    //   40: aload_2
    //   41: ldc_w 539
    //   44: invokevirtual 542	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   47: new 134	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 135	java/lang/StringBuilder:<init>	()V
    //   54: astore 8
    //   56: aload 8
    //   58: ldc_w 565
    //   61: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 8
    //   67: aload 4
    //   69: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_2
    //   74: ldc_w 567
    //   77: aload 8
    //   79: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokevirtual 290	java/net/HttpURLConnection:addRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_0
    //   86: aload_2
    //   87: invokespecial 575	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:writeGenerateAuthTokenRequestBodyToOutputStream	(Ljava/net/HttpURLConnection;)V
    //   90: aload_2
    //   91: invokevirtual 477	java/net/HttpURLConnection:getResponseCode	()I
    //   94: istore 6
    //   96: iload 6
    //   98: sipush 200
    //   101: if_icmpne +17 -> 118
    //   104: aload_0
    //   105: aload_2
    //   106: invokespecial 577	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:readGenerateAuthTokenResponse	(Ljava/net/HttpURLConnection;)Lcom/google/firebase/installations/remote/TokenResult;
    //   109: astore 8
    //   111: aload_2
    //   112: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   115: aload 8
    //   117: areturn
    //   118: aload_2
    //   119: aconst_null
    //   120: aload_1
    //   121: aload_3
    //   122: invokestatic 554	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logFisCommunicationError	(Ljava/net/HttpURLConnection;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   125: iload 6
    //   127: sipush 401
    //   130: if_icmpeq +51 -> 181
    //   133: iload 6
    //   135: sipush 404
    //   138: if_icmpne +90 -> 228
    //   141: goto +40 -> 181
    //   144: invokestatic 556	com/google/firebase/installations/remote/FirebaseInstallationServiceClient:logBadConfigError	()V
    //   147: invokestatic 372	com/google/firebase/installations/remote/TokenResult:builder	()Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   150: getstatic 579	com/google/firebase/installations/remote/TokenResult$ResponseCode:BAD_CONFIG	Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;
    //   153: invokevirtual 495	com/google/firebase/installations/remote/TokenResult$Builder:setResponseCode	(Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;)Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   156: invokevirtual 434	com/google/firebase/installations/remote/TokenResult$Builder:build	()Lcom/google/firebase/installations/remote/TokenResult;
    //   159: astore 8
    //   161: aload_2
    //   162: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   165: aload 8
    //   167: areturn
    //   168: iload 5
    //   170: iconst_1
    //   171: iadd
    //   172: istore 5
    //   174: aload_2
    //   175: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   178: goto -152 -> 26
    //   181: invokestatic 372	com/google/firebase/installations/remote/TokenResult:builder	()Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   184: getstatic 582	com/google/firebase/installations/remote/TokenResult$ResponseCode:AUTH_ERROR	Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;
    //   187: invokevirtual 495	com/google/firebase/installations/remote/TokenResult$Builder:setResponseCode	(Lcom/google/firebase/installations/remote/TokenResult$ResponseCode;)Lcom/google/firebase/installations/remote/TokenResult$Builder;
    //   190: invokevirtual 434	com/google/firebase/installations/remote/TokenResult$Builder:build	()Lcom/google/firebase/installations/remote/TokenResult;
    //   193: astore 8
    //   195: aload_2
    //   196: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   199: aload 8
    //   201: areturn
    //   202: astore_1
    //   203: aload_2
    //   204: invokevirtual 552	java/net/HttpURLConnection:disconnect	()V
    //   207: aload_1
    //   208: athrow
    //   209: new 222	com/google/firebase/installations/FirebaseInstallationsException
    //   212: dup
    //   213: ldc_w 320
    //   216: getstatic 240	com/google/firebase/installations/FirebaseInstallationsException$Status:UNAVAILABLE	Lcom/google/firebase/installations/FirebaseInstallationsException$Status;
    //   219: invokespecial 243	com/google/firebase/installations/FirebaseInstallationsException:<init>	(Ljava/lang/String;Lcom/google/firebase/installations/FirebaseInstallationsException$Status;)V
    //   222: athrow
    //   223: astore 8
    //   225: goto -57 -> 168
    //   228: iload 6
    //   230: sipush 429
    //   233: if_icmpeq -65 -> 168
    //   236: iload 6
    //   238: sipush 500
    //   241: if_icmplt -97 -> 144
    //   244: iload 6
    //   246: sipush 600
    //   249: if_icmpge -105 -> 144
    //   252: goto -84 -> 168
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	255	0	this	FirebaseInstallationServiceClient
    //   0	255	1	paramString1	String
    //   0	255	2	paramString2	String
    //   0	255	3	paramString3	String
    //   0	255	4	paramString4	String
    //   1	172	5	i	int
    //   94	156	6	j	int
    //   24	10	7	localURL	URL
    //   54	146	8	localObject	Object
    //   223	1	8	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   40	96	202	finally
    //   104	111	202	finally
    //   118	125	202	finally
    //   144	161	202	finally
    //   181	195	202	finally
    //   40	96	223	java/io/IOException
    //   104	111	223	java/io/IOException
    //   118	125	223	java/io/IOException
    //   144	161	223	java/io/IOException
    //   181	195	223	java/io/IOException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\remote\FirebaseInstallationServiceClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */