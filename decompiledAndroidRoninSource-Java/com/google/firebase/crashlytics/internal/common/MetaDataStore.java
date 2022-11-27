package com.google.firebase.crashlytics.internal.common;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class MetaDataStore
{
  private static final String KEYDATA_SUFFIX = "keys";
  private static final String KEY_USER_ID = "userId";
  private static final String METADATA_EXT = ".meta";
  private static final String USERDATA_SUFFIX = "user";
  private static final Charset UTF_8 = Charset.forName("UTF-8");
  private final File filesDir;
  
  public MetaDataStore(File paramFile)
  {
    this.filesDir = paramFile;
  }
  
  private static Map<String, String> jsonToKeysData(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramString.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, valueOrNull(paramString, str));
    }
    return localHashMap;
  }
  
  private static UserMetadata jsonToUserData(String paramString)
    throws JSONException
  {
    paramString = new JSONObject(paramString);
    UserMetadata localUserMetadata = new UserMetadata();
    localUserMetadata.setUserId(valueOrNull(paramString, "userId"));
    return localUserMetadata;
  }
  
  private static String keysDataToJson(Map<String, String> paramMap)
    throws JSONException
  {
    return new JSONObject(paramMap).toString();
  }
  
  private static String userDataToJson(UserMetadata paramUserMetadata)
    throws JSONException
  {
    new JSONObject() {}.toString();
  }
  
  private static String valueOrNull(JSONObject paramJSONObject, String paramString)
  {
    boolean bool = paramJSONObject.isNull(paramString);
    String str = null;
    if (!bool) {
      str = paramJSONObject.optString(paramString, null);
    }
    return str;
  }
  
  public File getKeysFileForSession(String paramString)
  {
    File localFile = this.filesDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("keys");
    localStringBuilder.append(".meta");
    return new File(localFile, localStringBuilder.toString());
  }
  
  public File getUserDataFileForSession(String paramString)
  {
    File localFile = this.filesDir;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("user");
    localStringBuilder.append(".meta");
    return new File(localFile, localStringBuilder.toString());
  }
  
  /* Error */
  public Map<String, String> readKeyData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 135	com/google/firebase/crashlytics/internal/common/MetaDataStore:getKeysFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 138	java/io/File:exists	()Z
    //   10: ifne +7 -> 17
    //   13: invokestatic 144	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   16: areturn
    //   17: aconst_null
    //   18: astore 4
    //   20: aconst_null
    //   21: astore_1
    //   22: new 146	java/io/FileInputStream
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   30: astore_2
    //   31: aload_2
    //   32: invokestatic 154	com/google/firebase/crashlytics/internal/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   35: invokestatic 156	com/google/firebase/crashlytics/internal/common/MetaDataStore:jsonToKeysData	(Ljava/lang/String;)Ljava/util/Map;
    //   38: astore_1
    //   39: aload_2
    //   40: ldc -98
    //   42: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   45: aload_1
    //   46: areturn
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: astore_2
    //   52: goto +36 -> 88
    //   55: astore_3
    //   56: goto +11 -> 67
    //   59: astore_2
    //   60: goto +28 -> 88
    //   63: astore_3
    //   64: aload 4
    //   66: astore_2
    //   67: aload_2
    //   68: astore_1
    //   69: invokestatic 168	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   72: ldc -86
    //   74: aload_3
    //   75: invokevirtual 174	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   78: aload_2
    //   79: ldc -98
    //   81: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   84: invokestatic 144	java/util/Collections:emptyMap	()Ljava/util/Map;
    //   87: areturn
    //   88: aload_1
    //   89: ldc -98
    //   91: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   94: aload_2
    //   95: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	96	0	this	MetaDataStore
    //   0	96	1	paramString	String
    //   5	47	2	localObject1	Object
    //   59	1	2	localObject2	Object
    //   66	29	2	localObject3	Object
    //   47	4	3	localObject4	Object
    //   55	1	3	localException1	Exception
    //   63	12	3	localException2	Exception
    //   18	47	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   31	39	47	finally
    //   31	39	55	java/lang/Exception
    //   22	31	59	finally
    //   69	78	59	finally
    //   22	31	63	java/lang/Exception
  }
  
  /* Error */
  public UserMetadata readUserData(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 177	com/google/firebase/crashlytics/internal/common/MetaDataStore:getUserDataFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore_2
    //   6: aload_2
    //   7: invokevirtual 138	java/io/File:exists	()Z
    //   10: ifne +11 -> 21
    //   13: new 86	com/google/firebase/crashlytics/internal/common/UserMetadata
    //   16: dup
    //   17: invokespecial 87	com/google/firebase/crashlytics/internal/common/UserMetadata:<init>	()V
    //   20: areturn
    //   21: aconst_null
    //   22: astore 4
    //   24: aconst_null
    //   25: astore_1
    //   26: new 146	java/io/FileInputStream
    //   29: dup
    //   30: aload_2
    //   31: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   34: astore_2
    //   35: aload_2
    //   36: invokestatic 154	com/google/firebase/crashlytics/internal/common/CommonUtils:streamToString	(Ljava/io/InputStream;)Ljava/lang/String;
    //   39: invokestatic 179	com/google/firebase/crashlytics/internal/common/MetaDataStore:jsonToUserData	(Ljava/lang/String;)Lcom/google/firebase/crashlytics/internal/common/UserMetadata;
    //   42: astore_1
    //   43: aload_2
    //   44: ldc -98
    //   46: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   49: aload_1
    //   50: areturn
    //   51: astore_3
    //   52: aload_2
    //   53: astore_1
    //   54: aload_3
    //   55: astore_2
    //   56: goto +40 -> 96
    //   59: astore_3
    //   60: goto +11 -> 71
    //   63: astore_2
    //   64: goto +32 -> 96
    //   67: astore_3
    //   68: aload 4
    //   70: astore_2
    //   71: aload_2
    //   72: astore_1
    //   73: invokestatic 168	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   76: ldc -86
    //   78: aload_3
    //   79: invokevirtual 174	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   82: aload_2
    //   83: ldc -98
    //   85: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   88: new 86	com/google/firebase/crashlytics/internal/common/UserMetadata
    //   91: dup
    //   92: invokespecial 87	com/google/firebase/crashlytics/internal/common/UserMetadata:<init>	()V
    //   95: areturn
    //   96: aload_1
    //   97: ldc -98
    //   99: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   102: aload_2
    //   103: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	MetaDataStore
    //   0	104	1	paramString	String
    //   5	51	2	localObject1	Object
    //   63	1	2	localObject2	Object
    //   70	33	2	localObject3	Object
    //   51	4	3	localObject4	Object
    //   59	1	3	localException1	Exception
    //   67	12	3	localException2	Exception
    //   22	47	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   35	43	51	finally
    //   35	43	59	java/lang/Exception
    //   26	35	63	finally
    //   73	82	63	finally
    //   26	35	67	java/lang/Exception
  }
  
  /* Error */
  public void writeKeyData(String paramString, Map<String, String> paramMap)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 135	com/google/firebase/crashlytics/internal/common/MetaDataStore:getKeysFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_3
    //   13: astore_1
    //   14: aload_2
    //   15: invokestatic 183	com/google/firebase/crashlytics/internal/common/MetaDataStore:keysDataToJson	(Ljava/util/Map;)Ljava/lang/String;
    //   18: astore 6
    //   20: aload_3
    //   21: astore_1
    //   22: new 185	java/io/BufferedWriter
    //   25: dup
    //   26: new 187	java/io/OutputStreamWriter
    //   29: dup
    //   30: new 189	java/io/FileOutputStream
    //   33: dup
    //   34: aload 5
    //   36: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: getstatic 35	com/google/firebase/crashlytics/internal/common/MetaDataStore:UTF_8	Ljava/nio/charset/Charset;
    //   42: invokespecial 193	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   45: invokespecial 196	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   48: astore_2
    //   49: aload_2
    //   50: aload 6
    //   52: invokevirtual 201	java/io/Writer:write	(Ljava/lang/String;)V
    //   55: aload_2
    //   56: invokevirtual 204	java/io/Writer:flush	()V
    //   59: aload_2
    //   60: ldc -50
    //   62: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   65: return
    //   66: astore_3
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto +33 -> 104
    //   74: astore_3
    //   75: goto +11 -> 86
    //   78: astore_2
    //   79: goto +25 -> 104
    //   82: astore_3
    //   83: aload 4
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: invokestatic 168	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   91: ldc -48
    //   93: aload_3
    //   94: invokevirtual 174	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload_2
    //   98: ldc -50
    //   100: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   103: return
    //   104: aload_1
    //   105: ldc -50
    //   107: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MetaDataStore
    //   0	112	1	paramString	String
    //   0	112	2	paramMap	Map<String, String>
    //   11	10	3	localObject1	Object
    //   66	4	3	localObject2	Object
    //   74	1	3	localException1	Exception
    //   82	12	3	localException2	Exception
    //   8	76	4	localObject3	Object
    //   5	30	5	localFile	File
    //   18	33	6	str	String
    // Exception table:
    //   from	to	target	type
    //   49	59	66	finally
    //   49	59	74	java/lang/Exception
    //   14	20	78	finally
    //   22	49	78	finally
    //   88	97	78	finally
    //   14	20	82	java/lang/Exception
    //   22	49	82	java/lang/Exception
  }
  
  /* Error */
  public void writeUserData(String paramString, UserMetadata paramUserMetadata)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 177	com/google/firebase/crashlytics/internal/common/MetaDataStore:getUserDataFileForSession	(Ljava/lang/String;)Ljava/io/File;
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aconst_null
    //   11: astore_3
    //   12: aload_3
    //   13: astore_1
    //   14: aload_2
    //   15: invokestatic 213	com/google/firebase/crashlytics/internal/common/MetaDataStore:userDataToJson	(Lcom/google/firebase/crashlytics/internal/common/UserMetadata;)Ljava/lang/String;
    //   18: astore 6
    //   20: aload_3
    //   21: astore_1
    //   22: new 185	java/io/BufferedWriter
    //   25: dup
    //   26: new 187	java/io/OutputStreamWriter
    //   29: dup
    //   30: new 189	java/io/FileOutputStream
    //   33: dup
    //   34: aload 5
    //   36: invokespecial 190	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   39: getstatic 35	com/google/firebase/crashlytics/internal/common/MetaDataStore:UTF_8	Ljava/nio/charset/Charset;
    //   42: invokespecial 193	java/io/OutputStreamWriter:<init>	(Ljava/io/OutputStream;Ljava/nio/charset/Charset;)V
    //   45: invokespecial 196	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   48: astore_2
    //   49: aload_2
    //   50: aload 6
    //   52: invokevirtual 201	java/io/Writer:write	(Ljava/lang/String;)V
    //   55: aload_2
    //   56: invokevirtual 204	java/io/Writer:flush	()V
    //   59: aload_2
    //   60: ldc -98
    //   62: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   65: return
    //   66: astore_3
    //   67: aload_2
    //   68: astore_1
    //   69: aload_3
    //   70: astore_2
    //   71: goto +33 -> 104
    //   74: astore_3
    //   75: goto +11 -> 86
    //   78: astore_2
    //   79: goto +25 -> 104
    //   82: astore_3
    //   83: aload 4
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: invokestatic 168	com/google/firebase/crashlytics/internal/Logger:getLogger	()Lcom/google/firebase/crashlytics/internal/Logger;
    //   91: ldc -41
    //   93: aload_3
    //   94: invokevirtual 174	com/google/firebase/crashlytics/internal/Logger:e	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   97: aload_2
    //   98: ldc -98
    //   100: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   103: return
    //   104: aload_1
    //   105: ldc -98
    //   107: invokestatic 162	com/google/firebase/crashlytics/internal/common/CommonUtils:closeOrLog	(Ljava/io/Closeable;Ljava/lang/String;)V
    //   110: aload_2
    //   111: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	MetaDataStore
    //   0	112	1	paramString	String
    //   0	112	2	paramUserMetadata	UserMetadata
    //   11	10	3	localObject1	Object
    //   66	4	3	localObject2	Object
    //   74	1	3	localException1	Exception
    //   82	12	3	localException2	Exception
    //   8	76	4	localObject3	Object
    //   5	30	5	localFile	File
    //   18	33	6	str	String
    // Exception table:
    //   from	to	target	type
    //   49	59	66	finally
    //   49	59	74	java/lang/Exception
    //   14	20	78	finally
    //   22	49	78	finally
    //   88	97	78	finally
    //   14	20	82	java/lang/Exception
    //   22	49	82	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\MetaDataStore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */