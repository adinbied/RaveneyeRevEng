package com.xiaomi.mipush.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;

public class m
{
  private static int a = -1;
  
  public static an a(Context paramContext)
  {
    try
    {
      if ((paramContext.getPackageManager().getServiceInfo(new ComponentName("com.huawei.hwid", "com.huawei.hms.core.service.HMSCoreService"), 128) != null) && (a()))
      {
        paramContext = an.a;
        return paramContext;
      }
      return an.f;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return an.f;
  }
  
  private static boolean a()
  {
    try
    {
      String str = (String)ba.a("android.os.SystemProperties", "get", new Object[] { "ro.build.hw_emui_api_level", "" });
      if (!TextUtils.isEmpty(str))
      {
        int i = Integer.parseInt(str);
        if (i >= 9) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      b.a(localException);
    }
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = ba.a(ba.a("com.google.android.gms.common.GoogleApiAvailability", "getInstance", new Object[0]), "isGooglePlayServicesAvailable", new Object[] { paramContext });
    Object localObject = ba.a("com.google.android.gms.common.ConnectionResult", "SUCCESS");
    if ((localObject != null) && ((localObject instanceof Integer)))
    {
      int i = ((Integer)Integer.class.cast(localObject)).intValue();
      if (paramContext != null) {
        if ((paramContext instanceof Integer))
        {
          if (((Integer)Integer.class.cast(paramContext)).intValue() == i) {
            i = 1;
          } else {
            i = 0;
          }
          a = i;
        }
        else
        {
          a = 0;
          b.c("google service is not avaliable");
        }
      }
      paramContext = new StringBuilder();
      paramContext.append("is google service can be used");
      if (a > 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramContext.append(bool1);
      b.c(paramContext.toString());
      boolean bool1 = bool2;
      if (a > 0) {
        bool1 = true;
      }
      return bool1;
    }
    b.c("google service is not avaliable");
    a = 0;
    return false;
  }
  
  public static boolean b(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = ba.a("com.xiaomi.assemble.control.COSPushManager", "isSupportPush", new Object[] { paramContext });
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext instanceof Boolean)) {
        bool1 = ((Boolean)Boolean.class.cast(paramContext)).booleanValue();
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("color os push  is avaliable ? :");
    paramContext.append(bool1);
    b.c(paramContext.toString());
    return bool1;
  }
  
  public static boolean c(Context paramContext)
  {
    boolean bool2 = false;
    paramContext = ba.a("com.xiaomi.assemble.control.FTOSPushManager", "isSupportPush", new Object[] { paramContext });
    boolean bool1 = bool2;
    if (paramContext != null)
    {
      bool1 = bool2;
      if ((paramContext instanceof Boolean)) {
        bool1 = ((Boolean)Boolean.class.cast(paramContext)).booleanValue();
      }
    }
    paramContext = new StringBuilder();
    paramContext.append("fun touch os push  is avaliable ? :");
    paramContext.append(bool1);
    b.c(paramContext.toString());
    return bool1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\mipush\sdk\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */