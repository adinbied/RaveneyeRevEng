package com.huawei.appmarket.component.buoycircle.impl.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;

public class Util
{
  private static final String META_APPID_NAME = "com.huawei.hms.client.appid";
  private static final String META_APPID_NAME_PREFIX = "appid=";
  private static final String TAG = "Util";
  
  public static String getBuildVersion()
  {
    return String.valueOf(Build.DISPLAY);
  }
  
  public static String getDeviceModel()
  {
    return Build.MODEL;
  }
  
  public static String getMetaDataAppId(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      BuoyLog.e("Util", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
      return "";
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.client.appid");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!paramContext.startsWith("appid=")) {
            return paramContext;
          }
          return paramContext.substring(6);
        }
      }
      BuoyLog.e("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
      return "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    BuoyLog.e("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
    return "";
    return paramContext;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */