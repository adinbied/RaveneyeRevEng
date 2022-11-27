package com.google.firebase.messaging;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Color;
import android.graphics.drawable.AdaptiveIconDrawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.core.app.NotificationCompat.BigTextStyle;
import androidx.core.app.NotificationCompat.Builder;
import androidx.core.content.ContextCompat;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzb
{
  private static final AtomicInteger zza = new AtomicInteger((int)SystemClock.elapsedRealtime());
  
  private static int zza(PackageManager paramPackageManager, Resources paramResources, String paramString1, String paramString2, Bundle paramBundle)
  {
    int i;
    if (!TextUtils.isEmpty(paramString2))
    {
      i = paramResources.getIdentifier(paramString2, "drawable", paramString1);
      if ((i != 0) && (zza(paramResources, i))) {
        return i;
      }
      i = paramResources.getIdentifier(paramString2, "mipmap", paramString1);
      if ((i != 0) && (zza(paramResources, i))) {
        return i;
      }
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString2).length() + 61);
      localStringBuilder.append("Icon resource ");
      localStringBuilder.append(paramString2);
      localStringBuilder.append(" not found. Notification will use default icon.");
      Log.w("FirebaseMessaging", localStringBuilder.toString());
    }
    int j = paramBundle.getInt("com.google.firebase.messaging.default_notification_icon", 0);
    if (j != 0)
    {
      i = j;
      if (zza(paramResources, j)) {}
    }
    else
    {
      try
      {
        i = paramPackageManager.getApplicationInfo(paramString1, 0).icon;
      }
      catch (PackageManager.NameNotFoundException paramPackageManager)
      {
        paramPackageManager = String.valueOf(paramPackageManager);
        paramString1 = new StringBuilder(String.valueOf(paramPackageManager).length() + 35);
        paramString1.append("Couldn't get own application info: ");
        paramString1.append(paramPackageManager);
        Log.w("FirebaseMessaging", paramString1.toString());
        i = j;
      }
    }
    if (i != 0)
    {
      j = i;
      if (zza(paramResources, i)) {}
    }
    else
    {
      j = 17301651;
    }
    return j;
  }
  
  private static PendingIntent zza(Context paramContext, Intent paramIntent)
  {
    return PendingIntent.getBroadcast(paramContext, zza.incrementAndGet(), new Intent("com.google.firebase.MESSAGING_EVENT").setComponent(new ComponentName(paramContext, "com.google.firebase.iid.FirebaseInstanceIdReceiver")).putExtra("wrapped_intent", paramIntent), 1073741824);
  }
  
  private static Bundle zza(PackageManager paramPackageManager, String paramString)
  {
    try
    {
      paramPackageManager = paramPackageManager.getApplicationInfo(paramString, 128);
      if ((paramPackageManager != null) && (paramPackageManager.metaData != null))
      {
        paramPackageManager = paramPackageManager.metaData;
        return paramPackageManager;
      }
    }
    catch (PackageManager.NameNotFoundException paramPackageManager)
    {
      paramPackageManager = String.valueOf(paramPackageManager);
      paramString = new StringBuilder(String.valueOf(paramPackageManager).length() + 35);
      paramString.append("Couldn't get own application info: ");
      paramString.append(paramPackageManager);
      Log.w("FirebaseMessaging", paramString.toString());
    }
    return Bundle.EMPTY;
  }
  
  static zza zza(Context paramContext, zzt paramzzt)
  {
    Bundle localBundle = zza(paramContext.getPackageManager(), paramContext.getPackageName());
    Object localObject2 = paramContext.getPackageName();
    String str = zzb(paramContext, paramzzt.zza("gcm.n.android_channel_id"), localBundle);
    Object localObject1 = paramContext.getResources();
    PackageManager localPackageManager = paramContext.getPackageManager();
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext, str);
    str = paramzzt.zza((Resources)localObject1, (String)localObject2, "gcm.n.title");
    if (!TextUtils.isEmpty(str)) {
      localBuilder.setContentTitle(str);
    }
    str = paramzzt.zza((Resources)localObject1, (String)localObject2, "gcm.n.body");
    if (!TextUtils.isEmpty(str))
    {
      localBuilder.setContentText(str);
      localBuilder.setStyle(new NotificationCompat.BigTextStyle().bigText(str));
    }
    localBuilder.setSmallIcon(zza(localPackageManager, (Resources)localObject1, (String)localObject2, paramzzt.zza("gcm.n.icon"), localBundle));
    Object localObject3 = paramzzt.zzb();
    boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
    str = null;
    if (bool)
    {
      localObject1 = null;
    }
    else if ((!"default".equals(localObject3)) && (((Resources)localObject1).getIdentifier((String)localObject3, "raw", (String)localObject2) != 0))
    {
      localObject1 = new StringBuilder(String.valueOf(localObject2).length() + 24 + String.valueOf(localObject3).length());
      ((StringBuilder)localObject1).append("android.resource://");
      ((StringBuilder)localObject1).append((String)localObject2);
      ((StringBuilder)localObject1).append("/raw/");
      ((StringBuilder)localObject1).append((String)localObject3);
      localObject1 = Uri.parse(((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject1 = RingtoneManager.getDefaultUri(2);
    }
    if (localObject1 != null) {
      localBuilder.setSound((Uri)localObject1);
    }
    localObject1 = paramzzt.zza("gcm.n.click_action");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = new Intent((String)localObject1);
      ((Intent)localObject1).setPackage((String)localObject2);
      ((Intent)localObject1).setFlags(268435456);
    }
    else
    {
      localObject3 = paramzzt.zza();
      if (localObject3 != null)
      {
        localObject1 = new Intent("android.intent.action.VIEW");
        ((Intent)localObject1).setPackage((String)localObject2);
        ((Intent)localObject1).setData((Uri)localObject3);
      }
      else
      {
        localObject1 = localPackageManager.getLaunchIntentForPackage((String)localObject2);
        if (localObject1 == null) {
          Log.w("FirebaseMessaging", "No activity found to launch app");
        }
      }
    }
    if (localObject1 == null)
    {
      localObject1 = null;
    }
    else
    {
      ((Intent)localObject1).addFlags(67108864);
      ((Intent)localObject1).putExtras(paramzzt.zze());
      localObject2 = PendingIntent.getActivity(paramContext, zza.incrementAndGet(), (Intent)localObject1, 1073741824);
      localObject1 = localObject2;
      if (paramzzt.zzb("google.c.a.e")) {
        localObject1 = zza(paramContext, new Intent("com.google.firebase.messaging.NOTIFICATION_OPEN").putExtras(paramzzt.zzf()).putExtra("pending_intent", (Parcelable)localObject2));
      }
    }
    localBuilder.setContentIntent((PendingIntent)localObject1);
    if (!paramzzt.zzb("google.c.a.e")) {
      localObject1 = null;
    } else {
      localObject1 = zza(paramContext, new Intent("com.google.firebase.messaging.NOTIFICATION_DISMISS").putExtras(paramzzt.zzf()));
    }
    if (localObject1 != null) {
      localBuilder.setDeleteIntent((PendingIntent)localObject1);
    }
    paramContext = zza(paramContext, paramzzt.zza("gcm.n.color"), localBundle);
    if (paramContext != null) {
      localBuilder.setColor(paramContext.intValue());
    }
    bool = paramzzt.zzb("gcm.n.sticky");
    int j = 1;
    localBuilder.setAutoCancel(bool ^ true);
    localBuilder.setLocalOnly(paramzzt.zzb("gcm.n.local_only"));
    paramContext = paramzzt.zza("gcm.n.ticker");
    if (paramContext != null) {
      localBuilder.setTicker(paramContext);
    }
    localObject1 = paramzzt.zzc("gcm.n.notification_priority");
    if (localObject1 == null) {}
    for (;;)
    {
      paramContext = null;
      break;
      if (((Integer)localObject1).intValue() >= -2)
      {
        paramContext = (Context)localObject1;
        if (((Integer)localObject1).intValue() <= 2) {
          break;
        }
      }
      paramContext = String.valueOf(localObject1);
      localObject1 = new StringBuilder(String.valueOf(paramContext).length() + 72);
      ((StringBuilder)localObject1).append("notificationPriority is invalid ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(". Skipping setting notificationPriority.");
      Log.w("FirebaseMessaging", ((StringBuilder)localObject1).toString());
    }
    if (paramContext != null) {
      localBuilder.setPriority(paramContext.intValue());
    }
    localObject1 = paramzzt.zzc("gcm.n.visibility");
    if (localObject1 == null) {}
    for (;;)
    {
      paramContext = null;
      break;
      if (((Integer)localObject1).intValue() >= -1)
      {
        paramContext = (Context)localObject1;
        if (((Integer)localObject1).intValue() <= 1) {
          break;
        }
      }
      paramContext = String.valueOf(localObject1);
      localObject1 = new StringBuilder(String.valueOf(paramContext).length() + 53);
      ((StringBuilder)localObject1).append("visibility is invalid: ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(". Skipping setting visibility.");
      Log.w("NotificationParams", ((StringBuilder)localObject1).toString());
    }
    if (paramContext != null) {
      localBuilder.setVisibility(paramContext.intValue());
    }
    paramContext = paramzzt.zzc("gcm.n.notification_count");
    if (paramContext == null)
    {
      paramContext = str;
    }
    else if (paramContext.intValue() < 0)
    {
      paramContext = String.valueOf(paramContext);
      localObject1 = new StringBuilder(String.valueOf(paramContext).length() + 67);
      ((StringBuilder)localObject1).append("notificationCount is invalid: ");
      ((StringBuilder)localObject1).append(paramContext);
      ((StringBuilder)localObject1).append(". Skipping setting notificationCount.");
      Log.w("FirebaseMessaging", ((StringBuilder)localObject1).toString());
      paramContext = str;
    }
    if (paramContext != null) {
      localBuilder.setNumber(paramContext.intValue());
    }
    paramContext = paramzzt.zzd("gcm.n.event_time");
    if (paramContext != null)
    {
      localBuilder.setShowWhen(true);
      localBuilder.setWhen(paramContext.longValue());
    }
    paramContext = paramzzt.zzc();
    if (paramContext != null) {
      localBuilder.setVibrate(paramContext);
    }
    paramContext = paramzzt.zzd();
    if (paramContext != null) {
      localBuilder.setLights(paramContext[0], paramContext[1], paramContext[2]);
    }
    if (!paramzzt.zzb("gcm.n.default_sound")) {
      j = 0;
    }
    int i = j;
    if (paramzzt.zzb("gcm.n.default_vibrate_timings")) {
      i = j | 0x2;
    }
    j = i;
    if (paramzzt.zzb("gcm.n.default_light_settings")) {
      j = i | 0x4;
    }
    localBuilder.setDefaults(j);
    paramContext = paramzzt.zza("gcm.n.tag");
    if (TextUtils.isEmpty(paramContext))
    {
      long l = SystemClock.uptimeMillis();
      paramContext = new StringBuilder(37);
      paramContext.append("FCM-Notification:");
      paramContext.append(l);
      paramContext = paramContext.toString();
    }
    return new zza(localBuilder, paramContext, 0);
  }
  
  private static Integer zza(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return null;
    }
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      i = Color.parseColor(paramString);
      return Integer.valueOf(i);
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      int i;
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 56);
    localStringBuilder.append("Color is invalid: ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(". Notification will use default color.");
    Log.w("FirebaseMessaging", localStringBuilder.toString());
    i = paramBundle.getInt("com.google.firebase.messaging.default_notification_color", 0);
    if (i != 0) {}
    try
    {
      i = ContextCompat.getColor(paramContext, i);
      return Integer.valueOf(i);
    }
    catch (Resources.NotFoundException paramContext)
    {
      for (;;) {}
    }
    Log.w("FirebaseMessaging", "Cannot find the color resource referenced in AndroidManifest.");
    return null;
  }
  
  private static boolean zza(Resources paramResources, int paramInt)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return true;
    }
    try
    {
      if ((paramResources.getDrawable(paramInt, null) instanceof AdaptiveIconDrawable))
      {
        paramResources = new StringBuilder(77);
        paramResources.append("Adaptive icons cannot be used in notifications. Ignoring icon id: ");
        paramResources.append(paramInt);
        Log.e("FirebaseMessaging", paramResources.toString());
        return false;
      }
      return true;
    }
    catch (Resources.NotFoundException paramResources)
    {
      for (;;) {}
    }
    paramResources = new StringBuilder(66);
    paramResources.append("Couldn't find resource ");
    paramResources.append(paramInt);
    paramResources.append(", treating it as an invalid icon");
    Log.e("FirebaseMessaging", paramResources.toString());
    return false;
  }
  
  private static String zzb(Context paramContext, String paramString, Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT < 26) {
      return null;
    }
    try
    {
      int i = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 0).targetSdkVersion;
      if (i < 26) {
        return null;
      }
      NotificationManager localNotificationManager = (NotificationManager)paramContext.getSystemService(NotificationManager.class);
      if (!TextUtils.isEmpty(paramString))
      {
        if (localNotificationManager.getNotificationChannel(paramString) != null) {
          return paramString;
        }
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 122);
        localStringBuilder.append("Notification Channel requested (");
        localStringBuilder.append(paramString);
        localStringBuilder.append(") has not been created by the app. Manifest configuration, or default, value will be used.");
        Log.w("FirebaseMessaging", localStringBuilder.toString());
      }
      paramString = paramBundle.getString("com.google.firebase.messaging.default_notification_channel_id");
      if (!TextUtils.isEmpty(paramString))
      {
        if (localNotificationManager.getNotificationChannel(paramString) != null) {
          return paramString;
        }
        Log.w("FirebaseMessaging", "Notification Channel set in AndroidManifest.xml has not been created by the app. Default value will be used.");
      }
      else
      {
        Log.w("FirebaseMessaging", "Missing Default Notification Channel metadata in AndroidManifest. Default value will be used.");
      }
      if (localNotificationManager.getNotificationChannel("fcm_fallback_notification_channel") == null) {
        localNotificationManager.createNotificationChannel(new NotificationChannel("fcm_fallback_notification_channel", paramContext.getString(paramContext.getResources().getIdentifier("fcm_fallback_notification_channel_label", "string", paramContext.getPackageName())), 3));
      }
      return "fcm_fallback_notification_channel";
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */