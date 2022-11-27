package com.huawei.hms.support.api.push.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public abstract class a
{
  private static int a = -1;
  private static final Object b = new Object();
  
  public static boolean a()
  {
    try
    {
      Object localObject = Class.forName("huawei.cust.HwCfgFilePolicy");
      int i = ((Integer)((Class)localObject).getDeclaredField("CUST_TYPE_CONFIG").get(localObject)).intValue();
      localObject = (File)((Class)localObject).getDeclaredMethod("getCfgFile", new Class[] { String.class, Integer.TYPE }).invoke(localObject, new Object[] { "jars/hwpush.jar", Integer.valueOf(i) });
      if ((localObject == null) || (!((File)localObject).exists())) {
        break label175;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get push cust File path is ");
      localStringBuilder.append(((File)localObject).getAbsolutePath());
      com.huawei.hms.support.log.a.a("CommFun", localStringBuilder.toString());
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    catch (SecurityException localSecurityException)
    {
      for (;;) {}
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label175:
      for (;;) {}
    }
    com.huawei.hms.support.log.a.d("CommFun", "check cust exist push InvocationTargetException.");
    return false;
    com.huawei.hms.support.log.a.d("CommFun", "check cust exist push IllegalAccessException.");
    return false;
    com.huawei.hms.support.log.a.d("CommFun", "check cust exist push IllegalArgumentException.");
    return false;
    com.huawei.hms.support.log.a.d("CommFun", "check cust exist push NoSuchMethodException.");
    return false;
    com.huawei.hms.support.log.a.d("CommFun", "check cust exist push NoSuchFieldException.");
    return false;
    com.huawei.hms.support.log.a.d("CommFun", "check cust exist push SecurityException.");
    return false;
    com.huawei.hms.support.log.a.d("CommFun", "HwCfgFilePolicy ClassNotFoundException");
    return false;
  }
  
  public static boolean a(Context paramContext)
  {
    ??? = new StringBuilder();
    ((StringBuilder)???).append("existFrameworkPush:");
    ((StringBuilder)???).append(a);
    com.huawei.hms.support.log.a.a("CommFun", ((StringBuilder)???).toString());
    synchronized (b)
    {
      int i = a;
      boolean bool2 = false;
      boolean bool1 = false;
      if (-1 != i)
      {
        if (1 == a) {
          bool1 = true;
        }
        return bool1;
      }
      if (c(paramContext)) {
        a = 1;
      } else {
        a = 0;
      }
      bool1 = bool2;
      if (1 == a) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0).versionName;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getApkVersionName error");
      localStringBuilder.append(paramContext.getMessage());
      com.huawei.hms.support.log.a.d("CommFun", localStringBuilder.toString());
      break label62;
      com.huawei.hms.support.log.a.a("CommFun", "package not exist");
      return "0.0";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label62:
      for (;;) {}
    }
  }
  
  private static boolean c(Context paramContext)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("existFrameworkPush:");
    ((StringBuilder)localObject).append(a);
    com.huawei.hms.support.log.a.a("CommFun", ((StringBuilder)localObject).toString());
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("/system/framework/");
      ((StringBuilder)localObject).append("hwpush.jar");
      localObject = new File(((StringBuilder)localObject).toString());
      boolean bool = a();
      if (bool)
      {
        com.huawei.hms.support.log.a.a("CommFun", "push jarFile is exist");
      }
      else
      {
        if (!((File)localObject).isFile()) {
          break label155;
        }
        com.huawei.hms.support.log.a.a("CommFun", "push jarFile is exist");
      }
      paramContext = paramContext.getPackageManager().queryIntentServices(new Intent().setClassName("android", "com.huawei.android.pushagentproxy.PushService"), 128);
      if ((paramContext != null) && (!paramContext.isEmpty()))
      {
        com.huawei.hms.support.log.a.b("CommFun", "framework push exist, use framework push first");
        return true;
      }
      com.huawei.hms.support.log.a.b("CommFun", "framework push not exist, need vote apk or sdk to support pushservice");
      label155:
      return false;
    }
    catch (Exception paramContext)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get Apk version faild ,Exception e= ");
      ((StringBuilder)localObject).append(paramContext.toString());
      com.huawei.hms.support.log.a.d("CommFun", ((StringBuilder)localObject).toString());
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */