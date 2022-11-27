package com.google.firebase.installations.local;

import android.content.Context;
import com.google.firebase.FirebaseApp;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;

public class PersistedInstallation
{
  private static final String AUTH_TOKEN_KEY = "AuthToken";
  private static final String EXPIRES_IN_SECONDS_KEY = "ExpiresInSecs";
  private static final String FIREBASE_INSTALLATION_ID_KEY = "Fid";
  private static final String FIS_ERROR_KEY = "FisError";
  private static final String PERSISTED_STATUS_KEY = "Status";
  private static final String REFRESH_TOKEN_KEY = "RefreshToken";
  private static final String SETTINGS_FILE_NAME_PREFIX = "PersistedInstallation";
  private static final String TOKEN_CREATION_TIME_IN_SECONDS_KEY = "TokenCreationEpochInSecs";
  private final File dataFile;
  private final FirebaseApp firebaseApp;
  
  public PersistedInstallation(FirebaseApp paramFirebaseApp)
  {
    File localFile = paramFirebaseApp.getApplicationContext().getFilesDir();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PersistedInstallation.");
    localStringBuilder.append(paramFirebaseApp.getPersistenceKey());
    localStringBuilder.append(".json");
    this.dataFile = new File(localFile, localStringBuilder.toString());
    this.firebaseApp = paramFirebaseApp;
  }
  
  /* Error */
  private JSONObject readJSONFromFile()
  {
    // Byte code:
    //   0: new 89	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 90	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_3
    //   8: sipush 16384
    //   11: newarray <illegal type>
    //   13: astore 4
    //   15: new 92	java/io/FileInputStream
    //   18: dup
    //   19: aload_0
    //   20: getfield 78	com/google/firebase/installations/local/PersistedInstallation:dataFile	Ljava/io/File;
    //   23: invokespecial 95	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   26: astore_2
    //   27: aload_2
    //   28: aload 4
    //   30: iconst_0
    //   31: sipush 16384
    //   34: invokevirtual 99	java/io/FileInputStream:read	([BII)I
    //   37: istore_1
    //   38: iload_1
    //   39: ifge +21 -> 60
    //   42: new 101	org/json/JSONObject
    //   45: dup
    //   46: aload_3
    //   47: invokevirtual 102	java/io/ByteArrayOutputStream:toString	()Ljava/lang/String;
    //   50: invokespecial 105	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   53: astore_3
    //   54: aload_2
    //   55: invokevirtual 108	java/io/FileInputStream:close	()V
    //   58: aload_3
    //   59: areturn
    //   60: aload_3
    //   61: aload 4
    //   63: iconst_0
    //   64: iload_1
    //   65: invokevirtual 112	java/io/ByteArrayOutputStream:write	([BII)V
    //   68: goto -41 -> 27
    //   71: astore_3
    //   72: aload_2
    //   73: invokevirtual 108	java/io/FileInputStream:close	()V
    //   76: aload_3
    //   77: athrow
    //   78: new 101	org/json/JSONObject
    //   81: dup
    //   82: invokespecial 113	org/json/JSONObject:<init>	()V
    //   85: areturn
    //   86: astore_2
    //   87: goto -9 -> 78
    //   90: astore_2
    //   91: goto -15 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	PersistedInstallation
    //   37	28	1	i	int
    //   26	47	2	localFileInputStream	java.io.FileInputStream
    //   86	1	2	localIOException	IOException
    //   90	1	2	localObject1	Object
    //   7	54	3	localObject2	Object
    //   71	6	3	localObject3	Object
    //   13	49	4	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	38	71	finally
    //   42	54	71	finally
    //   60	68	71	finally
    //   15	27	86	java/io/IOException
    //   15	27	86	org/json/JSONException
    //   54	58	86	java/io/IOException
    //   54	58	86	org/json/JSONException
    //   76	78	86	java/io/IOException
    //   76	78	86	org/json/JSONException
    //   72	76	90	finally
  }
  
  public void clearForTesting()
  {
    this.dataFile.delete();
  }
  
  public PersistedInstallationEntry insertOrUpdatePersistedInstallationEntry(PersistedInstallationEntry paramPersistedInstallationEntry)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("Fid", paramPersistedInstallationEntry.getFirebaseInstallationId());
      localJSONObject.put("Status", paramPersistedInstallationEntry.getRegistrationStatus().ordinal());
      localJSONObject.put("AuthToken", paramPersistedInstallationEntry.getAuthToken());
      localJSONObject.put("RefreshToken", paramPersistedInstallationEntry.getRefreshToken());
      localJSONObject.put("TokenCreationEpochInSecs", paramPersistedInstallationEntry.getTokenCreationEpochInSecs());
      localJSONObject.put("ExpiresInSecs", paramPersistedInstallationEntry.getExpiresInSecs());
      localJSONObject.put("FisError", paramPersistedInstallationEntry.getFisError());
      File localFile = File.createTempFile("PersistedInstallation", "tmp", this.firebaseApp.getApplicationContext().getFilesDir());
      FileOutputStream localFileOutputStream = new FileOutputStream(localFile);
      localFileOutputStream.write(localJSONObject.toString().getBytes("UTF-8"));
      localFileOutputStream.close();
      if (localFile.renameTo(this.dataFile)) {
        return paramPersistedInstallationEntry;
      }
      throw new IOException("unable to rename the tmpfile to PersistedInstallation");
    }
    catch (JSONException|IOException localJSONException) {}
    return paramPersistedInstallationEntry;
  }
  
  public PersistedInstallationEntry readPersistedInstallationEntryValue()
  {
    Object localObject = readJSONFromFile();
    String str1 = ((JSONObject)localObject).optString("Fid", null);
    int i = ((JSONObject)localObject).optInt("Status", RegistrationStatus.ATTEMPT_MIGRATION.ordinal());
    String str2 = ((JSONObject)localObject).optString("AuthToken", null);
    String str3 = ((JSONObject)localObject).optString("RefreshToken", null);
    long l1 = ((JSONObject)localObject).optLong("TokenCreationEpochInSecs", 0L);
    long l2 = ((JSONObject)localObject).optLong("ExpiresInSecs", 0L);
    localObject = ((JSONObject)localObject).optString("FisError", null);
    return PersistedInstallationEntry.builder().setFirebaseInstallationId(str1).setRegistrationStatus(RegistrationStatus.values()[i]).setAuthToken(str2).setRefreshToken(str3).setTokenCreationEpochInSecs(l1).setExpiresInSecs(l2).setFisError((String)localObject).build();
  }
  
  public static enum RegistrationStatus
  {
    static
    {
      REGISTERED = new RegistrationStatus("REGISTERED", 3);
      RegistrationStatus localRegistrationStatus = new RegistrationStatus("REGISTER_ERROR", 4);
      REGISTER_ERROR = localRegistrationStatus;
      $VALUES = new RegistrationStatus[] { ATTEMPT_MIGRATION, NOT_GENERATED, UNREGISTERED, REGISTERED, localRegistrationStatus };
    }
    
    private RegistrationStatus() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\local\PersistedInstallation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */