package com.huawei.hms.c;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources.NotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.huawei.hms.support.log.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class j
{
  public static Activity a(Activity paramActivity1, Activity paramActivity2)
  {
    Activity localActivity;
    if (paramActivity1 != null)
    {
      localActivity = paramActivity1;
      if (!paramActivity1.isFinishing()) {}
    }
    else
    {
      if ((paramActivity2 != null) && (!paramActivity2.isFinishing())) {
        return paramActivity2;
      }
      localActivity = null;
    }
    return localActivity;
  }
  
  public static String a(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      a.d("Util", "In getMetaDataAppId, Failed to get 'PackageManager' instance.");
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
      a.d("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
      return "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    a.d("Util", "In getMetaDataAppId, Failed to read meta data for the AppID.");
    return "";
    return paramContext;
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (paramContext == null)
    {
      a.d("Util", "In getAppName, context is null.");
      return "";
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      a.d("Util", "In getAppName, Failed to get 'PackageManager' instance.");
      return "";
    }
    String str = paramString;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        str = paramContext.getPackageName();
      }
      paramContext = localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(str, 0));
      if (paramContext == null) {
        return "";
      }
      paramContext = paramContext.toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException|Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    a.d("Util", "In getAppName, Failed to get app name.");
    return "";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getDeclaredMethod("get", new Class[] { String.class, String.class }).invoke(localObject, new Object[] { paramString1, paramString2 });
      return (String)localObject;
    }
    catch (ClassNotFoundException|NoSuchMethodException|IllegalAccessException|IllegalArgumentException|InvocationTargetException|ClassCastException localClassNotFoundException)
    {
      Object localObject;
      for (;;) {}
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("An exception occurred while reading: getSystemProperties:");
    ((StringBuilder)localObject).append(paramString1);
    a.d("Util", ((StringBuilder)localObject).toString());
    return paramString2;
  }
  
  public static void a(Context paramContext, ServiceConnection paramServiceConnection)
  {
    try
    {
      paramContext.unbindService(paramServiceConnection);
      return;
    }
    catch (Exception paramContext)
    {
      paramServiceConnection = new StringBuilder();
      paramServiceConnection.append("On unBindServiceException:");
      paramServiceConnection.append(paramContext.getMessage());
      a.d("Util", paramServiceConnection.toString());
    }
  }
  
  public static boolean a()
  {
    String str = b();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    str = c();
    if (!TextUtils.isEmpty(str)) {
      return str.toLowerCase(Locale.US).contains("cn");
    }
    str = d();
    if (!TextUtils.isEmpty(str)) {
      return "cn".equalsIgnoreCase(str);
    }
    return false;
  }
  
  public static boolean a(Activity paramActivity)
  {
    return (paramActivity.getWindow().getAttributes().flags & 0x400) == 1024;
  }
  
  private static boolean a(String paramString)
  {
    return Pattern.compile("(^([0-9]{1,2}.){2}[0-9]{1,2}$)|(^([0-9]{1,2}.){3}[0-9]{1,3}$)").matcher(paramString).find();
  }
  
  public static int b(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      a.d("Util", "In getHmsVersion, Failed to get 'PackageManager' instance.");
      return 0;
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.get("com.huawei.hms.version");
        if (paramContext != null)
        {
          paramContext = String.valueOf(paramContext);
          if (!TextUtils.isEmpty(paramContext)) {
            return b(paramContext);
          }
        }
      }
      a.d("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
      return 0;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    a.d("Util", "In getHmsVersion, Failed to read meta data for the HMS VERSION.");
    return 0;
  }
  
  private static int b(String paramString)
  {
    if (a(paramString))
    {
      paramString = paramString.split("\\.");
      if (paramString.length < 3) {
        return 0;
      }
      int j = Integer.parseInt(paramString[0]) * 10000000 + Integer.parseInt(paramString[1]) * 100000 + Integer.parseInt(paramString[2]) * 1000;
      int i = j;
      if (paramString.length == 4) {
        i = j + Integer.parseInt(paramString[3]);
      }
      return i;
    }
    return 0;
  }
  
  private static String b()
  {
    return a("ro.product.locale.region", "");
  }
  
  private static String c()
  {
    return a("ro.product.locale", "");
  }
  
  public static String c(Context paramContext)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      a.d("Util", "In getMetaDataCpId, Failed to get 'PackageManager' instance.");
      return "";
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null))
      {
        paramContext = paramContext.metaData.getString("com.huawei.hms.client.cpid", "");
        if (paramContext.startsWith("cpid=")) {
          return paramContext.substring(5);
        }
      }
      a.d("Util", "In getMetaDataCpId, Failed to read meta data for the CpId.");
      return "";
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    a.d("Util", "In getMetaDataCpId, Failed to read meta data for the CpId.");
    return "";
  }
  
  private static String d()
  {
    Locale localLocale = Locale.getDefault();
    if (localLocale != null) {
      return localLocale.getCountry();
    }
    return "";
  }
  
  public static boolean d(Context paramContext)
  {
    if (paramContext == null)
    {
      a.d("Util", "In getBiSetting, context is null.");
      return false;
    }
    PackageManager localPackageManager = paramContext.getPackageManager();
    if (localPackageManager == null)
    {
      a.d("Util", "In getBiSetting, Failed to get 'PackageManager' instance.");
      return false;
    }
    try
    {
      paramContext = localPackageManager.getApplicationInfo(paramContext.getPackageName(), 128);
      if ((paramContext != null) && (paramContext.metaData != null)) {
        return paramContext.metaData.getBoolean("com.huawei.hms.client.bi.setting");
      }
      a.d("Util", "In getBiSetting, Failed to read meta data for the CpId.");
      return false;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    a.d("Util", "In getBiSetting, Failed to read meta data for the CpId.");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\c\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */