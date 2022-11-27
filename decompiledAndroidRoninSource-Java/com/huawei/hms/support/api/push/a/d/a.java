package com.huawei.hms.support.api.push.a.d;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class a
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  
  public static long a(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l1 = 0L;
    try
    {
      paramString = new Date();
      int j = paramString.getHours() * 2 + paramString.getMinutes() / 30;
      str = str.concat(str);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("startIndex is ");
      localStringBuilder.append(j);
      localStringBuilder.append(",ap is:");
      localStringBuilder.append(str);
      localStringBuilder.append(",length is:");
      localStringBuilder.append(str.length());
      com.huawei.hms.support.log.a.b("PushSelfShowLog", localStringBuilder.toString());
      int k = str.length();
      int i = j;
      while (i < k)
      {
        if (str.charAt(i) != '0')
        {
          long l2 = ((i - j) * 30 - paramString.getMinutes() % 30) * 60000L;
          paramString = new StringBuilder();
          paramString.append("startIndex is:");
          paramString.append(j);
          paramString.append(" i is:");
          paramString.append(i);
          paramString.append(" delay:");
          paramString.append(l2);
          com.huawei.hms.support.log.a.a("PushSelfShowLog", paramString.toString());
          if (l2 >= 0L) {
            l1 = l2;
          }
          return l1;
        }
        i += 1;
      }
      return 0L;
    }
    catch (Exception paramString)
    {
      com.huawei.hms.support.log.a.a("PushSelfShowLog", "error ", paramString);
    }
  }
  
  public static Boolean a(Context paramContext, String paramString, Intent paramIntent)
  {
    try
    {
      paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 0);
      if ((paramContext != null) && (paramContext.size() > 0))
      {
        int j = paramContext.size();
        int i = 0;
        while (i < j)
        {
          if ((((ResolveInfo)paramContext.get(i)).activityInfo != null) && (paramString.equals(((ResolveInfo)paramContext.get(i)).activityInfo.applicationInfo.packageName))) {
            return Boolean.valueOf(true);
          }
          i += 1;
        }
      }
      return Boolean.valueOf(false);
    }
    catch (Exception paramContext)
    {
      com.huawei.hms.support.log.a.a("PushSelfShowLog", paramContext.toString(), paramContext);
    }
  }
  
  public static String a(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager();
      paramContext = paramContext.getApplicationLabel(paramContext.getApplicationInfo(paramString, 128)).toString();
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      for (;;) {}
    }
    paramContext = new StringBuilder();
    paramContext.append("get the app name of package:");
    paramContext.append(paramString);
    paramContext.append(" failed.");
    com.huawei.hms.support.log.a.b("PushSelfShowLog", paramContext.toString());
    return null;
  }
  
  public static void a(Context paramContext, int paramInt)
  {
    if (paramContext == null)
    {
      com.huawei.hms.support.log.a.d("PushSelfShowLog", "context is null");
      return;
    }
    try
    {
      paramContext = (NotificationManager)paramContext.getSystemService("notification");
      if (paramContext != null)
      {
        paramContext.cancel(paramInt);
        return;
      }
    }
    catch (Exception paramContext)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("removeNotifiCationById err:");
      localStringBuilder.append(paramContext.toString());
      com.huawei.hms.support.log.a.d("PushSelfShowLog", localStringBuilder.toString());
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enter setAPDelayAlarm(intent:");
      ((StringBuilder)localObject).append(paramIntent.toURI());
      ((StringBuilder)localObject).append(" interval:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("ms, context:");
      ((StringBuilder)localObject).append(paramContext);
      com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject).toString());
      localObject = (AlarmManager)paramContext.getSystemService("alarm");
      if (localObject == null) {
        break label128;
      }
      paramContext = PendingIntent.getBroadcast(paramContext, new SecureRandom().nextInt(), paramIntent, 0);
      ((AlarmManager)localObject).set(0, System.currentTimeMillis() + paramLong, paramContext);
      return;
    }
    catch (RuntimeException paramContext)
    {
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      label128:
      for (;;) {}
    }
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "set DelayAlarm error");
    return;
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "set DelayAlarm error");
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 11;
  }
  
  public static boolean a(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.SENDTO");
    localIntent.setPackage("com.android.email");
    localIntent.setData(Uri.fromParts("mailto", "xxxx@xxxx.com", null));
    paramContext = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
    return (paramContext != null) && (paramContext.size() != 0);
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    if (paramContext == null)
    {
      com.huawei.hms.support.log.a.b("PushSelfShowLog", "context is null");
      return false;
    }
    if (paramIntent == null)
    {
      com.huawei.hms.support.log.a.b("PushSelfShowLog", "intent is null");
      return false;
    }
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 640);
    if ((paramContext != null) && (paramContext.size() != 0))
    {
      boolean bool = ((ResolveInfo)paramContext.get(0)).activityInfo.exported;
      paramIntent = new StringBuilder();
      paramIntent.append("exportedFlag:");
      paramIntent.append(bool);
      com.huawei.hms.support.log.a.b("PushSelfShowLog", paramIntent.toString());
      paramContext = ((ResolveInfo)paramContext.get(0)).activityInfo.permission;
      paramIntent = new StringBuilder();
      paramIntent.append("need permission:");
      paramIntent.append(paramContext);
      com.huawei.hms.support.log.a.b("PushSelfShowLog", paramIntent.toString());
      if (!bool) {
        return false;
      }
      if (TextUtils.isEmpty(paramContext)) {
        return true;
      }
      return "com.huawei.pushagent.permission.LAUNCH_ACTIVITY".equals(paramContext);
    }
    com.huawei.hms.support.log.a.d("PushSelfShowLog", "no activity exist, may be system Err!! pkgName:");
    return false;
  }
  
  public static Intent b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getPackageManager();
    try
    {
      paramContext = paramContext.getLaunchIntentForPackage(paramString);
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    paramContext = new StringBuilder();
    paramContext.append(paramString);
    paramContext.append("not have launch activity");
    com.huawei.hms.support.log.a.c("PushSelfShowLog", paramContext.toString());
    return null;
  }
  
  public static void b(Context paramContext, Intent paramIntent)
  {
    try
    {
      AlarmManager localAlarmManager = (AlarmManager)paramContext.getSystemService("alarm");
      boolean bool = paramIntent.hasExtra("selfshow_notify_id");
      int i = 0;
      if (bool) {
        i = paramIntent.getIntExtra("selfshow_notify_id", 0) + 3;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setDelayAlarm(cancel) alarmNotityId ");
      localStringBuilder.append(i);
      localStringBuilder.append(" and intent is ");
      localStringBuilder.append(paramIntent.toURI());
      com.huawei.hms.support.log.a.a("PushSelfShowLog", localStringBuilder.toString());
      paramIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
      paramIntent.setPackage(paramContext.getPackageName()).setFlags(32);
      paramContext = PendingIntent.getBroadcast(paramContext, i, paramIntent, 536870912);
      if ((paramContext != null) && (localAlarmManager != null))
      {
        com.huawei.hms.support.log.a.a("PushSelfShowLog", "  alarm cancel");
        localAlarmManager.cancel(paramContext);
        return;
      }
      com.huawei.hms.support.log.a.a("PushSelfShowLog", "alarm not exist");
      return;
    }
    catch (Exception paramContext)
    {
      paramIntent = new StringBuilder();
      paramIntent.append("cancelAlarm err:");
      paramIntent.append(paramContext.toString());
      com.huawei.hms.support.log.a.d("PushSelfShowLog", paramIntent.toString());
    }
  }
  
  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 16;
  }
  
  public static boolean b(Context paramContext)
  {
    return "com.huawei.android.pushagent".equals(paramContext.getPackageName());
  }
  
  public static boolean c(Context paramContext)
  {
    return "com.huawei.hwid".equals(paramContext.getPackageName());
  }
  
  public static boolean c(Context paramContext, String paramString)
  {
    if ((paramContext != null) && (paramString != null)) {
      if ("".equals(paramString)) {
        return false;
      }
    }
    try
    {
      if (paramContext.getPackageManager().getApplicationInfo(paramString, 8192) == null) {
        return false;
      }
      paramContext = new StringBuilder();
      paramContext.append(paramString);
      paramContext.append(" is installed");
      com.huawei.hms.support.log.a.a("PushSelfShowLog", paramContext.toString());
      return true;
    }
    catch (Exception paramContext) {}
    return false;
    return false;
  }
  
  public static void d(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      com.huawei.hms.support.log.a.b("PushSelfShowLog", "url is null.");
      return;
    }
    try
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(paramString));
      localIntent.setFlags(402653184);
      Object localObject = paramContext.getPackageManager().queryIntentActivities(localIntent, 0);
      String str = null;
      Iterator localIterator = ((List)localObject).iterator();
      do
      {
        paramString = str;
        if (!localIterator.hasNext()) {
          break;
        }
        paramString = ((ResolveInfo)localIterator.next()).activityInfo.packageName;
      } while (!e(paramContext, paramString));
      str = paramString;
      if (paramString == null)
      {
        localObject = ((List)localObject).iterator();
        do
        {
          str = paramString;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          str = ((ResolveInfo)((Iterator)localObject).next()).activityInfo.packageName;
        } while (!"com.android.browser".equalsIgnoreCase(str));
      }
      if (str != null) {
        localIntent.setPackage(str);
      }
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("start browser activity failed, exception:");
      paramString.append(paramContext.getMessage());
      com.huawei.hms.support.log.a.d("PushSelfShowLog", paramString.toString());
    }
  }
  
  public static boolean e(Context paramContext, String paramString)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    paramContext.getPackageManager().getPreferredActivities(localArrayList1, localArrayList2, paramString);
    return localArrayList2.size() > 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */