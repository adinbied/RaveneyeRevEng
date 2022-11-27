package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import com.google.android.gms.tasks.Task;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.installations.FirebaseInstallationsApi;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdManager
  implements InstallIdProvider
{
  public static final String DEFAULT_VERSION_NAME = "0.0";
  private static final String FORWARD_SLASH_REGEX = Pattern.quote("/");
  private static final Pattern ID_PATTERN = Pattern.compile("[^\\p{Alnum}]");
  static final String PREFKEY_ADVERTISING_ID = "crashlytics.advertising.id";
  static final String PREFKEY_FIREBASE_IID = "firebase.installation.id";
  static final String PREFKEY_INSTALLATION_UUID = "crashlytics.installation.id";
  static final String PREFKEY_LEGACY_INSTALLATION_UUID = "crashlytics.installation.id";
  private final Context appContext;
  private final String appIdentifier;
  private String crashlyticsInstallId;
  private final FirebaseInstallationsApi firebaseInstallationsApi;
  private final InstallerPackageNameProvider installerPackageNameProvider;
  
  public IdManager(Context paramContext, String paramString, FirebaseInstallationsApi paramFirebaseInstallationsApi)
  {
    if (paramContext != null)
    {
      if (paramString != null)
      {
        this.appContext = paramContext;
        this.appIdentifier = paramString;
        this.firebaseInstallationsApi = paramFirebaseInstallationsApi;
        this.installerPackageNameProvider = new InstallerPackageNameProvider();
        return;
      }
      throw new IllegalArgumentException("appIdentifier must not be null");
    }
    throw new IllegalArgumentException("appContext must not be null");
  }
  
  private String createAndStoreIid(String paramString, SharedPreferences paramSharedPreferences)
  {
    try
    {
      String str = formatId(UUID.randomUUID().toString());
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Created new Crashlytics IID: ");
      localStringBuilder.append(str);
      localLogger.d(localStringBuilder.toString());
      paramSharedPreferences.edit().putString("crashlytics.installation.id", str).putString("firebase.installation.id", paramString).apply();
      return str;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private static String formatId(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return ID_PATTERN.matcher(paramString).replaceAll("").toLowerCase(Locale.US);
  }
  
  private void migrateLegacyId(String paramString1, String paramString2, SharedPreferences paramSharedPreferences1, SharedPreferences paramSharedPreferences2)
  {
    try
    {
      Logger localLogger = Logger.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Migrating legacy Crashlytics IID: ");
      localStringBuilder.append(paramString1);
      localLogger.d(localStringBuilder.toString());
      paramSharedPreferences1.edit().putString("crashlytics.installation.id", paramString1).putString("firebase.installation.id", paramString2).apply();
      paramSharedPreferences2.edit().remove("crashlytics.installation.id").remove("crashlytics.advertising.id").apply();
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private String removeForwardSlashesIn(String paramString)
  {
    return paramString.replaceAll(FORWARD_SLASH_REGEX, "");
  }
  
  public String getAppIdentifier()
  {
    return this.appIdentifier;
  }
  
  public String getCrashlyticsInstallId()
  {
    for (;;)
    {
      try
      {
        if (this.crashlyticsInstallId != null)
        {
          localObject1 = this.crashlyticsInstallId;
          return (String)localObject1;
        }
        SharedPreferences localSharedPreferences = CommonUtils.getSharedPrefs(this.appContext);
        Object localObject1 = this.firebaseInstallationsApi.getId();
        Object localObject5 = localSharedPreferences.getString("firebase.installation.id", null);
        try
        {
          localObject1 = (String)Utils.awaitEvenIfOnMainThread((Task)localObject1);
        }
        catch (Exception localException)
        {
          Logger.getLogger().d("Failed to retrieve installation id", localException);
          if (localObject5 == null) {
            break label286;
          }
        }
        Object localObject2 = localObject5;
        Object localObject6;
        if (localObject5 == null)
        {
          localObject5 = CommonUtils.getLegacySharedPrefs(this.appContext);
          localObject6 = ((SharedPreferences)localObject5).getString("crashlytics.installation.id", null);
          Logger localLogger = Logger.getLogger();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("No cached FID; legacy id is ");
          localStringBuilder.append((String)localObject6);
          localLogger.d(localStringBuilder.toString());
          if (localObject6 == null)
          {
            this.crashlyticsInstallId = createAndStoreIid((String)localObject2, localSharedPreferences);
          }
          else
          {
            this.crashlyticsInstallId = ((String)localObject6);
            migrateLegacyId((String)localObject6, (String)localObject2, localSharedPreferences, (SharedPreferences)localObject5);
          }
          localObject2 = this.crashlyticsInstallId;
          return (String)localObject2;
        }
        if (((String)localObject5).equals(localObject2))
        {
          this.crashlyticsInstallId = localSharedPreferences.getString("crashlytics.installation.id", null);
          localObject5 = Logger.getLogger();
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append("Found matching FID, using Crashlytics IID: ");
          ((StringBuilder)localObject6).append(this.crashlyticsInstallId);
          ((Logger)localObject5).d(((StringBuilder)localObject6).toString());
          if (this.crashlyticsInstallId == null) {
            this.crashlyticsInstallId = createAndStoreIid((String)localObject2, localSharedPreferences);
          }
        }
        else
        {
          this.crashlyticsInstallId = createAndStoreIid((String)localObject2, localSharedPreferences);
        }
        localObject2 = this.crashlyticsInstallId;
        return (String)localObject2;
      }
      finally {}
      label286:
      Object localObject4 = null;
    }
  }
  
  public String getInstallerPackageName()
  {
    return this.installerPackageNameProvider.getInstallerPackageName(this.appContext);
  }
  
  public String getModelName()
  {
    return String.format(Locale.US, "%s/%s", new Object[] { removeForwardSlashesIn(Build.MANUFACTURER), removeForwardSlashesIn(Build.MODEL) });
  }
  
  public String getOsBuildVersionString()
  {
    return removeForwardSlashesIn(Build.VERSION.INCREMENTAL);
  }
  
  public String getOsDisplayVersionString()
  {
    return removeForwardSlashesIn(Build.VERSION.RELEASE);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\IdManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */