package com.google.android.gms.common.wrappers;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.util.PlatformVersion;

public class InstantApps
{
  private static Context zzhv;
  private static Boolean zzhw;
  
  public static boolean isInstantApp(Context paramContext)
  {
    for (;;)
    {
      Context localContext;
      boolean bool;
      try
      {
        localContext = paramContext.getApplicationContext();
        if ((zzhv != null) && (zzhw != null) && (zzhv == localContext))
        {
          bool = zzhw.booleanValue();
          return bool;
        }
        zzhw = null;
        if (PlatformVersion.isAtLeastO()) {
          zzhw = Boolean.valueOf(localContext.getPackageManager().isInstantApp());
        }
      }
      finally {}
      try
      {
        paramContext.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
        zzhw = Boolean.valueOf(true);
      }
      catch (ClassNotFoundException paramContext) {}
    }
    zzhw = Boolean.valueOf(false);
    zzhv = localContext;
    bool = zzhw.booleanValue();
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\wrappers\InstantApps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */