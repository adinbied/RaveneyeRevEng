package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.pm.PackageManager;

class InstallerPackageNameProvider
{
  private static final String NO_INSTALLER_PACKAGE_NAME = "";
  private String installerPackageName;
  
  private static String loadInstallerPackageName(Context paramContext)
  {
    String str = paramContext.getPackageManager().getInstallerPackageName(paramContext.getPackageName());
    paramContext = str;
    if (str == null) {
      paramContext = "";
    }
    return paramContext;
  }
  
  String getInstallerPackageName(Context paramContext)
  {
    try
    {
      if (this.installerPackageName == null) {
        this.installerPackageName = loadInstallerPackageName(paramContext);
      }
      if ("".equals(this.installerPackageName)) {
        paramContext = null;
      } else {
        paramContext = this.installerPackageName;
      }
      return paramContext;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\InstallerPackageNameProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */