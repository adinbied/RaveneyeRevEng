package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transport;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.google.firebase.iid.FirebaseInstanceId;

public final class zzr
{
  private static final DataEncoder zza = new JsonDataEncoderBuilder().registerEncoder(FirelogAnalyticsEvent.zza.class, new FirelogAnalyticsEvent.zzc()).registerEncoder(FirelogAnalyticsEvent.class, new FirelogAnalyticsEvent.zzb()).build();
  
  public static void zza(Intent paramIntent)
  {
    if (paramIntent != null) {
      if ("1".equals(paramIntent.getStringExtra("google.c.a.tc")))
      {
        AnalyticsConnector localAnalyticsConnector = (AnalyticsConnector)FirebaseApp.getInstance().get(AnalyticsConnector.class);
        if (Log.isLoggable("FirebaseMessaging", 3)) {
          Log.d("FirebaseMessaging", "Received event with track-conversion=true. Setting user property and reengagement event");
        }
        if (localAnalyticsConnector != null)
        {
          String str = paramIntent.getStringExtra("google.c.a.c_id");
          localAnalyticsConnector.setUserProperty("fcm", "_ln", str);
          Bundle localBundle = new Bundle();
          localBundle.putString("source", "Firebase");
          localBundle.putString("medium", "notification");
          localBundle.putString("campaign", str);
          localAnalyticsConnector.logEvent("fcm", "_cmp", localBundle);
        }
        else
        {
          Log.w("FirebaseMessaging", "Unable to set user property for conversion tracking:  analytics library is missing");
        }
      }
      else if (Log.isLoggable("FirebaseMessaging", 3))
      {
        Log.d("FirebaseMessaging", "Received event with track-conversion=false. Do not set user property");
      }
    }
    zza("_no", paramIntent);
  }
  
  public static void zza(Intent paramIntent, Transport<String> paramTransport)
  {
    zza("_nr", paramIntent);
    if (paramTransport != null) {
      paramIntent = new FirelogAnalyticsEvent.zza(new FirelogAnalyticsEvent("MESSAGE_DELIVERED", paramIntent));
    }
    try
    {
      paramTransport.send(Event.ofTelemetry(zza.encode(paramIntent)));
      return;
    }
    catch (EncodingException paramIntent)
    {
      for (;;) {}
    }
    Log.d("FirebaseMessaging", "Failed to encode big query analytics payload. Skip sending");
  }
  
  private static void zza(String paramString, Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    String str1 = paramIntent.getStringExtra("google.c.a.c_id");
    if (str1 != null) {
      localBundle.putString("_nmid", str1);
    }
    str1 = paramIntent.getStringExtra("google.c.a.c_l");
    if (str1 != null) {
      localBundle.putString("_nmn", str1);
    }
    str1 = paramIntent.getStringExtra("google.c.a.m_l");
    if (!TextUtils.isEmpty(str1)) {
      localBundle.putString("label", str1);
    }
    str1 = paramIntent.getStringExtra("google.c.a.m_c");
    if (!TextUtils.isEmpty(str1)) {
      localBundle.putString("message_channel", str1);
    }
    str1 = zzl(paramIntent);
    if (str1 != null) {
      localBundle.putString("_nt", str1);
    }
    str1 = paramIntent.getStringExtra("google.c.a.ts");
    if (str1 != null) {
      try
      {
        localBundle.putInt("_nmt", Integer.parseInt(str1));
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", localNumberFormatException1);
      }
    }
    String str2;
    if (paramIntent.hasExtra("google.c.a.udt")) {
      str2 = paramIntent.getStringExtra("google.c.a.udt");
    } else {
      str2 = null;
    }
    if (str2 != null) {
      try
      {
        localBundle.putInt("_ndt", Integer.parseInt(str2));
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", localNumberFormatException2);
      }
    }
    if ((paramIntent.getExtras() != null) && (zzt.zza(paramIntent.getExtras()))) {
      paramIntent = "display";
    } else {
      paramIntent = "data";
    }
    if (("_nr".equals(paramString)) || ("_nf".equals(paramString))) {
      localBundle.putString("_nmc", paramIntent);
    }
    if (Log.isLoggable("FirebaseMessaging", 3))
    {
      paramIntent = String.valueOf(localBundle);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 37 + String.valueOf(paramIntent).length());
      localStringBuilder.append("Logging to scion event=");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" scionPayload=");
      localStringBuilder.append(paramIntent);
      Log.d("FirebaseMessaging", localStringBuilder.toString());
    }
    paramIntent = (AnalyticsConnector)FirebaseApp.getInstance().get(AnalyticsConnector.class);
    if (paramIntent != null)
    {
      paramIntent.logEvent("fcm", paramString, localBundle);
      return;
    }
    Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
  }
  
  static void zza(boolean paramBoolean)
  {
    FirebaseApp.getInstance().getApplicationContext().getSharedPreferences("com.google.firebase.messaging", 0).edit().putBoolean("export_to_big_query", paramBoolean).apply();
  }
  
  static boolean zza()
  {
    for (;;)
    {
      try
      {
        FirebaseApp.getInstance();
        localObject1 = FirebaseApp.getInstance().getApplicationContext();
        localObject2 = ((Context)localObject1).getSharedPreferences("com.google.firebase.messaging", 0);
        if (((SharedPreferences)localObject2).contains("export_to_big_query")) {
          return ((SharedPreferences)localObject2).getBoolean("export_to_big_query", false);
        }
      }
      catch (IllegalStateException localIllegalStateException)
      {
        Object localObject1;
        Object localObject2;
        continue;
      }
      try
      {
        localObject2 = ((Context)localObject1).getPackageManager();
        if (localObject2 != null)
        {
          localObject1 = ((PackageManager)localObject2).getApplicationInfo(((Context)localObject1).getPackageName(), 128);
          if ((localObject1 != null) && (((ApplicationInfo)localObject1).metaData != null) && (((ApplicationInfo)localObject1).metaData.containsKey("delivery_metrics_exported_to_big_query_enabled")))
          {
            boolean bool = ((ApplicationInfo)localObject1).metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
            return bool;
          }
        }
        return false;
      }
      catch (PackageManager.NameNotFoundException localNameNotFoundException) {}
    }
    Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
    return false;
    return false;
  }
  
  static String zzb()
  {
    return FirebaseApp.getInstance().getApplicationContext().getPackageName();
  }
  
  public static void zzb(Intent paramIntent)
  {
    zza("_nd", paramIntent);
  }
  
  static String zzc()
  {
    return FirebaseInstanceId.getInstance(FirebaseApp.getInstance()).getId();
  }
  
  public static void zzc(Intent paramIntent)
  {
    zza("_nf", paramIntent);
  }
  
  static String zzd()
  {
    Object localObject = FirebaseApp.getInstance();
    String str = ((FirebaseApp)localObject).getOptions().getGcmSenderId();
    if (str != null) {
      return str;
    }
    localObject = ((FirebaseApp)localObject).getOptions().getApplicationId();
    if (!((String)localObject).startsWith("1:")) {
      return (String)localObject;
    }
    localObject = ((String)localObject).split(":");
    if (localObject.length < 2) {
      return null;
    }
    localObject = localObject[1];
    if (((String)localObject).isEmpty()) {
      return null;
    }
    return (String)localObject;
  }
  
  public static boolean zzd(Intent paramIntent)
  {
    if ((paramIntent != null) && (!zzn(paramIntent))) {
      return "1".equals(paramIntent.getStringExtra("google.c.a.e"));
    }
    return false;
  }
  
  public static boolean zze(Intent paramIntent)
  {
    if ((paramIntent != null) && (!zzn(paramIntent))) {
      return zza();
    }
    return false;
  }
  
  static int zzf(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras().get("google.ttl");
    if ((paramIntent instanceof Integer)) {
      return ((Integer)paramIntent).intValue();
    }
    if ((paramIntent instanceof String)) {}
    try
    {
      int i = Integer.parseInt((String)paramIntent);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      StringBuilder localStringBuilder;
      for (;;) {}
    }
    paramIntent = String.valueOf(paramIntent);
    localStringBuilder = new StringBuilder(String.valueOf(paramIntent).length() + 13);
    localStringBuilder.append("Invalid TTL: ");
    localStringBuilder.append(paramIntent);
    Log.w("FirebaseMessaging", localStringBuilder.toString());
    return 0;
  }
  
  static String zzg(Intent paramIntent)
  {
    return paramIntent.getStringExtra("collapse_key");
  }
  
  static String zzh(Intent paramIntent)
  {
    return paramIntent.getStringExtra("google.c.a.c_l");
  }
  
  static String zzi(Intent paramIntent)
  {
    return paramIntent.getStringExtra("google.c.a.m_l");
  }
  
  static String zzj(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("google.message_id");
    String str1 = str2;
    if (str2 == null) {
      str1 = paramIntent.getStringExtra("message_id");
    }
    return str1;
  }
  
  static String zzk(Intent paramIntent)
  {
    if ((paramIntent.getExtras() != null) && (zzt.zza(paramIntent.getExtras()))) {
      return "DISPLAY_NOTIFICATION";
    }
    return "DATA_MESSAGE";
  }
  
  static String zzl(Intent paramIntent)
  {
    paramIntent = paramIntent.getStringExtra("from");
    if ((paramIntent != null) && (paramIntent.startsWith("/topics/"))) {
      return paramIntent;
    }
    return null;
  }
  
  static int zzm(Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("google.delivered_priority");
    String str1 = str2;
    if (str2 == null)
    {
      if ("1".equals(paramIntent.getStringExtra("google.priority_reduced"))) {
        return 2;
      }
      str1 = paramIntent.getStringExtra("google.priority");
    }
    if ("high".equals(str1)) {
      return 1;
    }
    if ("normal".equals(str1)) {
      return 2;
    }
    return 0;
  }
  
  private static boolean zzn(Intent paramIntent)
  {
    return "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(paramIntent.getAction());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */