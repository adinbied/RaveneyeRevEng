package com.huawei.hms.support.api.push.a.c;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.c.h;
import java.util.Date;

public class d
{
  private static int a;
  
  public static Notification a(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Notification.Builder localBuilder = new Notification.Builder(paramContext);
    b.a(paramContext, localBuilder, parama);
    int i = paramContext.getApplicationInfo().labelRes;
    localBuilder.setTicker(parama.l());
    localBuilder.setWhen(System.currentTimeMillis());
    localBuilder.setAutoCancel(true);
    localBuilder.setDefaults(1);
    if ((parama.n() != null) && (!"".equals(parama.n()))) {
      localBuilder.setContentTitle(parama.n());
    } else {
      localBuilder.setContentTitle(paramContext.getResources().getString(i));
    }
    localBuilder.setContentText(parama.l());
    localBuilder.setContentIntent(a(paramContext, parama, paramString, paramInt1, paramInt2));
    localBuilder.setDeleteIntent(b(paramContext, parama, paramString, paramInt1, paramInt3));
    paramString = b.b(paramContext, parama);
    if (paramString != null) {
      localBuilder.setLargeIcon(paramString);
    }
    if (Build.VERSION.SDK_INT >= 26) {
      localBuilder.setChannelId("HwPushChannelID");
    }
    a(paramContext, localBuilder, parama);
    b(paramContext, localBuilder, parama);
    if (f.a(paramContext, localBuilder, paramInt1, parama, paramString) == null)
    {
      com.huawei.hms.support.log.a.c("PushSelfShowLog", "builder is null after add style.");
      return null;
    }
    return localBuilder.getNotification();
  }
  
  private static PendingIntent a(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    localIntent.putExtra("selfshow_info", parama.c()).putExtra("selfshow_token", parama.d()).putExtra("selfshow_event_id", "1").putExtra("extra_encrypt_data", paramString).putExtra("selfshow_notify_id", paramInt1).setPackage(paramContext.getPackageName()).setFlags(268435456);
    return PendingIntent.getBroadcast(paramContext, paramInt2, localIntent, 134217728);
  }
  
  private static void a(Context paramContext, Notification.Builder paramBuilder, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ("com.huawei.android.pushagent".equals(paramContext.getPackageName()))
    {
      paramContext = new Bundle();
      parama = parama.i();
      if (!TextUtils.isEmpty(parama))
      {
        paramContext.putString("hw_origin_sender_package_name", parama);
        paramBuilder.setExtras(paramContext);
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent, long paramLong, int paramInt)
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("enter setDelayAlarm(intent:");
      ((StringBuilder)localObject).append(paramIntent.toURI());
      ((StringBuilder)localObject).append(" interval:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("ms, context:");
      ((StringBuilder)localObject).append(paramContext);
      com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject).toString());
      localObject = (AlarmManager)paramContext.getSystemService("alarm");
      if (localObject == null) {
        break label123;
      }
      paramContext = PendingIntent.getBroadcast(paramContext, paramInt, paramIntent, 134217728);
      ((AlarmManager)localObject).set(0, System.currentTimeMillis() + paramLong, paramContext);
      return;
    }
    catch (RuntimeException paramContext)
    {
      for (;;) {}
    }
    catch (Exception paramContext)
    {
      label123:
      for (;;) {}
    }
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "set DelayAlarm error");
    return;
    com.huawei.hms.support.log.a.c("PushSelfShowLog", "set DelayAlarm error");
  }
  
  public static void a(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama, String paramString)
  {
    if ((paramContext != null) && (parama != null)) {}
    for (;;)
    {
      int i;
      int j;
      int k;
      int m;
      try
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" showNotification , the msg id = ");
        ((StringBuilder)localObject).append(parama.a());
        com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject).toString());
        if (a == 0)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramContext.getPackageName());
          ((StringBuilder)localObject).append(new Date().toString());
          a = ((StringBuilder)localObject).toString().hashCode();
        }
        if (TextUtils.isEmpty(parama.e()))
        {
          i = a + 1;
          a = i;
          j = i + 1;
          a = j;
          k = j + 1;
          a = k;
          m = k + 1;
          a = m;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(parama.i());
          ((StringBuilder)localObject).append(parama.e());
          i = ((StringBuilder)localObject).toString().hashCode();
          j = a + 1;
          a = j;
          k = j + 1;
          a = k;
          m = k + 1;
          a = m;
        }
      }
      finally {}
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyId:");
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(",openNotifyId:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(",delNotifyId:");
      ((StringBuilder)localObject).append(k);
      ((StringBuilder)localObject).append(",alarmNotifyId:");
      ((StringBuilder)localObject).append(m);
      com.huawei.hms.support.log.a.a("PushSelfShowLog", ((StringBuilder)localObject).toString());
      localObject = null;
      if (com.huawei.hms.support.api.push.a.d.a.a()) {
        localObject = a(paramContext, parama, paramString, i, j, k);
      }
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      if ((localNotificationManager != null) && (localObject != null))
      {
        if (Build.VERSION.SDK_INT >= 26) {
          localNotificationManager.createNotificationChannel(new NotificationChannel("HwPushChannelID", paramContext.getString(h.c("hms_push_channel")), 3));
        }
        localNotificationManager.notify(i, (Notification)localObject);
        if (parama.f() > 0)
        {
          localObject = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
          ((Intent)localObject).putExtra("selfshow_info", parama.c()).putExtra("selfshow_token", parama.d()).putExtra("selfshow_event_id", "-1").putExtra("extra_encrypt_data", paramString).putExtra("selfshow_notify_id", i).setPackage(paramContext.getPackageName()).setFlags(32);
          a(paramContext, (Intent)localObject, parama.f(), m);
          paramContext = new StringBuilder();
          paramContext.append("setDelayAlarm alarmNotityId");
          paramContext.append(m);
          paramContext.append(" and intent is ");
          paramContext.append(((Intent)localObject).toURI());
          com.huawei.hms.support.log.a.a("PushSelfShowLog", paramContext.toString());
        }
      }
      return;
      return;
    }
  }
  
  private static PendingIntent b(Context paramContext, com.huawei.hms.support.api.push.a.b.a parama, String paramString, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent("com.huawei.intent.action.PUSH_DELAY_NOTIFY");
    localIntent.putExtra("selfshow_info", parama.c()).putExtra("selfshow_token", parama.d()).putExtra("selfshow_event_id", "2").putExtra("selfshow_notify_id", paramInt1).setPackage(paramContext.getPackageName()).putExtra("extra_encrypt_data", paramString).setFlags(268435456);
    return PendingIntent.getBroadcast(paramContext, paramInt2, localIntent, 134217728);
  }
  
  private static void b(Context paramContext, Notification.Builder paramBuilder, com.huawei.hms.support.api.push.a.b.a parama)
  {
    if ((com.huawei.hms.support.api.push.b.a.a.a.a() >= 11) && (com.huawei.hms.support.api.push.a.d.a.c(paramContext)))
    {
      Bundle localBundle = new Bundle();
      parama = parama.i();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("the package name of notification is:");
      localStringBuilder.append(parama);
      com.huawei.hms.support.log.a.b("PushSelfShowLog", localStringBuilder.toString());
      if (!TextUtils.isEmpty(parama))
      {
        paramContext = com.huawei.hms.support.api.push.a.d.a.a(paramContext, parama);
        parama = new StringBuilder();
        parama.append("the app name is:");
        parama.append(paramContext);
        com.huawei.hms.support.log.a.b("PushSelfShowLog", parama.toString());
        if (paramContext != null) {
          localBundle.putCharSequence("android.extraAppName", paramContext);
        }
      }
      paramBuilder.setExtras(localBundle);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\push\a\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */