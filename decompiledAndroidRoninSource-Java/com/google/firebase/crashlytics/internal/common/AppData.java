package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;

class AppData
{
  public final String buildId;
  public final String googleAppId;
  public final String installerPackageName;
  public final String packageName;
  public final String versionCode;
  public final String versionName;
  
  public AppData(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    this.googleAppId = paramString1;
    this.buildId = paramString2;
    this.installerPackageName = paramString3;
    this.packageName = paramString4;
    this.versionCode = paramString5;
    this.versionName = paramString6;
  }
  
  public static AppData create(Context paramContext, IdManager paramIdManager, String paramString1, String paramString2)
    throws PackageManager.NameNotFoundException
  {
    String str1 = paramContext.getPackageName();
    paramIdManager = paramIdManager.getInstallerPackageName();
    paramContext = paramContext.getPackageManager().getPackageInfo(str1, 0);
    String str2 = Integer.toString(paramContext.versionCode);
    if (paramContext.versionName == null) {
      paramContext = "0.0";
    } else {
      paramContext = paramContext.versionName;
    }
    return new AppData(paramString1, paramString2, paramIdManager, str1, str2, paramContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\AppData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */