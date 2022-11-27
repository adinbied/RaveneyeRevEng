package com.huawei.hianalytics.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.Pair;
import com.huawei.hianalytics.g.b;
import com.huawei.hianalytics.util.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class c
{
  public static String a()
  {
    Object localObject = "";
    try
    {
      str = (String)Class.forName("com.huawei.android.os.BuildEx").getMethod("getUDID", new Class[0]).invoke(null, new Object[0]);
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      String str;
      for (;;) {}
    }
    catch (AndroidRuntimeException localAndroidRuntimeException2)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException2)
    {
      for (;;) {}
    }
    catch (IllegalAccessException localIllegalAccessException2)
    {
      for (;;) {}
    }
    catch (IllegalArgumentException localIllegalArgumentException2)
    {
      for (;;) {}
    }
    catch (InvocationTargetException localInvocationTargetException2)
    {
      label38:
      label43:
      for (;;) {}
    }
    try
    {
      b.b("HianalyticsSDK", "getUDID success");
      return str;
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      break label63;
    }
    catch (AndroidRuntimeException localAndroidRuntimeException1)
    {
      break label58;
    }
    catch (NoSuchMethodException localNoSuchMethodException1)
    {
      break label53;
    }
    catch (IllegalAccessException localIllegalAccessException1)
    {
      break label48;
    }
    catch (IllegalArgumentException localIllegalArgumentException1)
    {
      break label43;
    }
    catch (InvocationTargetException localInvocationTargetException1)
    {
      break label38;
    }
    localObject = str;
    break label68;
    localObject = str;
    break label74;
    label48:
    localObject = str;
    break label80;
    label53:
    localObject = str;
    break label86;
    label58:
    localObject = str;
    break label92;
    label63:
    localObject = str;
    break label98;
    label68:
    str = "getUDID method invoke failed : InvocationTargetException";
    break label101;
    label74:
    str = "getUDID method invoke failed : Illegal ArgumentException";
    break label101;
    label80:
    str = "getUDID method invoke failed : Illegal AccessException";
    break label101;
    label86:
    str = "getUDID method invoke failed : NoSuchMethodException";
    break label101;
    label92:
    str = "getUDID getudid failed, RuntimeException is AndroidRuntimeException";
    break label101;
    label98:
    str = "getUDID method invoke failed";
    label101:
    b.c("HianalyticsSDK", str);
    return (String)localObject;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return paramContext.getPackageName();
  }
  
  public static String b()
  {
    return e.b("ro.build.version.emui", "");
  }
  
  public static String b(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(a(paramContext), 0).versionName;
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    b.c("HianalyticsSDK", "getVersion(): The package name is not correct!");
    return "";
  }
  
  public static String c(Context paramContext)
  {
    if (e.a(paramContext, "android.permission.READ_PHONE_STATE")) {
      return "";
    }
    try
    {
      paramContext = (TelephonyManager)paramContext.getSystemService("phone");
      if (paramContext == null) {
        break label40;
      }
      paramContext = paramContext.getDeviceId();
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      label40:
      for (;;) {}
    }
    b.d("HianalyticsSDK", "getDeviceID Incorrect permissions!");
    return "";
  }
  
  public static String d(Context paramContext)
  {
    if (paramContext == null) {
      return "";
    }
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
  
  public static String e(Context paramContext)
  {
    String str = Build.SERIAL;
    if ((!TextUtils.isEmpty(str)) && (!str.equalsIgnoreCase("unknown"))) {
      return str;
    }
    return h(paramContext);
  }
  
  public static String f(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext == null) || (paramContext.metaData == null)) {
        break label69;
      }
      paramContext = paramContext.metaData.get("CHANNEL");
      if (paramContext == null) {
        break label69;
      }
      paramContext = paramContext.toString();
      int i = paramContext.length();
      if (i > 256) {
        return "Unknown";
      }
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      label69:
      for (;;) {}
    }
    b.c("HianalyticsSDK", "getChannel(): The packageName is not correct!");
    return "Unknown";
  }
  
  public static Pair<String, String> g(Context paramContext)
  {
    if (e.a(paramContext, "android.permission.READ_PHONE_STATE"))
    {
      b.c("HianalyticsSDK", "getMccAndMnc() Pair value is empty");
      return new Pair("", "");
    }
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return new Pair("", "");
    }
    if (paramContext.getSimState() != 5) {
      return new Pair("", "");
    }
    paramContext = paramContext.getNetworkOperator();
    if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.equals(paramContext, "null")))
    {
      if (paramContext.length() > 3) {
        return new Pair(paramContext.substring(0, 3), paramContext.substring(3));
      }
      return new Pair("", "");
    }
    return new Pair("", "");
  }
  
  private static String h(Context paramContext)
  {
    b.a("HianalyticsSDK", "getSerial : is executed.");
    if (paramContext == null) {
      return "";
    }
    if (paramContext.checkSelfPermission("android.permission.READ_PHONE_STATE") != 0) {
      return "";
    }
    try
    {
      paramContext = Build.getSerial();
      return paramContext;
    }
    catch (SecurityException paramContext)
    {
      for (;;) {}
    }
    b.c("HianalyticsSDK", "getSerial() Incorrect permissions!");
    return "";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */