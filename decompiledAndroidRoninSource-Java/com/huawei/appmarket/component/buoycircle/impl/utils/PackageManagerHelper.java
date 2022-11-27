package com.huawei.appmarket.component.buoycircle.impl.utils;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.huawei.appmarket.component.buoycircle.impl.log.BuoyLog;
import java.util.Iterator;
import java.util.List;

public class PackageManagerHelper
{
  public static final int ERROR_PID = -1;
  private static final String TAG = "PackageManagerHelper";
  private final PackageManager mPM;
  
  public PackageManagerHelper(Context paramContext)
  {
    this.mPM = paramContext.getPackageManager();
  }
  
  public static int getPid(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (!TextUtils.isEmpty(paramString)))
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null)
      {
        BuoyLog.w("PackageManagerHelper", "activityManager = null");
        return -1;
      }
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext != null)
      {
        if (paramContext.size() == 0) {
          return -1;
        }
        paramContext = paramContext.iterator();
        while (paramContext.hasNext())
        {
          ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.next();
          if (paramString.equals(localRunningAppProcessInfo.processName)) {
            return localRunningAppProcessInfo.pid;
          }
        }
      }
      return -1;
    }
    paramContext = new StringBuilder();
    paramContext.append("packageName = ");
    paramContext.append(paramString);
    BuoyLog.w("PackageManagerHelper", paramContext.toString());
    return -1;
  }
  
  public static boolean isBackground(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return false;
    }
    String str = paramString;
    if (TextUtils.isEmpty(paramString))
    {
      BuoyLog.i("PackageManagerHelper", "packageName is empty, get packageName from context");
      str = paramContext.getPackageName();
    }
    try
    {
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.getRunningAppProcesses();
      if (paramContext == null) {
        return false;
      }
      paramContext = paramContext.iterator();
      int i;
      do
      {
        do
        {
          if (!paramContext.hasNext()) {
            break;
          }
          paramString = (ActivityManager.RunningAppProcessInfo)paramContext.next();
        } while (!paramString.processName.equals(str));
        i = paramString.importance;
      } while (i <= 200);
      return true;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    BuoyLog.e("PackageManagerHelper", "check the app isBackground meet exception");
    return false;
  }
  
  public PackageStates getPackageStates(String paramString)
  {
    return null;
  }
  
  public int getPackageVersionCode(String paramString)
  {
    return 0;
  }
  
  public boolean hasProvider(String paramString1, String paramString2)
  {
    return false;
  }
  
  public static enum PackageStates
  {
    static
    {
      DISABLED = new PackageStates("DISABLED", 1);
      PackageStates localPackageStates = new PackageStates("NOT_INSTALLED", 2);
      NOT_INSTALLED = localPackageStates;
      $VALUES = new PackageStates[] { ENABLED, DISABLED, localPackageStates };
    }
    
    private PackageStates() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\utils\PackageManagerHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */