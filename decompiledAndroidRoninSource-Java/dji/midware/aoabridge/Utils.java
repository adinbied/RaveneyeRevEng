package dji.midware.aoabridge;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Utils
{
  public static Context getAppContext()
  {
    try
    {
      Application localApplication = (Application)Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[])null);
      return localApplication;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public static String getIp()
  {
    WifiManager localWifiManager = (WifiManager)getAppContext().getSystemService("wifi");
    if (!localWifiManager.isWifiEnabled()) {
      return null;
    }
    return intToIp(localWifiManager.getConnectionInfo().getIpAddress());
  }
  
  private static String intToIp(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 8 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 16 & 0xFF);
    localStringBuilder.append(".");
    localStringBuilder.append(paramInt >> 24 & 0xFF);
    return localStringBuilder.toString();
  }
  
  public static boolean isAppInstalled(String paramString)
  {
    Object localObject = getAppContext().getPackageManager();
    int i = 0;
    localObject = ((PackageManager)localObject).getInstalledPackages(0);
    ArrayList localArrayList = new ArrayList();
    if (localObject != null) {
      while (i < ((List)localObject).size())
      {
        localArrayList.add(((PackageInfo)((List)localObject).get(i)).packageName);
        i += 1;
      }
    }
    return localArrayList.contains(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\aoabridge\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */