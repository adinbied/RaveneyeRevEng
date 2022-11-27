package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.zzao;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class FirebaseMessaging
{
  public static final String INSTANCE_ID_SCOPE = "FCM";
  static TransportFactory zza;
  private final Context zzb;
  private final FirebaseInstanceId zzc;
  private final Task<zzab> zzd;
  
  FirebaseMessaging(FirebaseApp paramFirebaseApp, FirebaseInstanceId paramFirebaseInstanceId, UserAgentPublisher paramUserAgentPublisher, HeartBeatInfo paramHeartBeatInfo, FirebaseInstallationsApi paramFirebaseInstallationsApi, TransportFactory paramTransportFactory)
  {
    zza = paramTransportFactory;
    this.zzc = paramFirebaseInstanceId;
    paramTransportFactory = paramFirebaseApp.getApplicationContext();
    this.zzb = paramTransportFactory;
    paramFirebaseApp = zzab.zza(paramFirebaseApp, paramFirebaseInstanceId, new zzao(paramTransportFactory), paramUserAgentPublisher, paramHeartBeatInfo, paramFirebaseInstallationsApi, this.zzb, zzi.zza(), new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("Firebase-Messaging-Topics-Io")));
    this.zzd = paramFirebaseApp;
    paramFirebaseApp.addOnSuccessListener(zzi.zzb(), new zzk(this));
  }
  
  public static FirebaseMessaging getInstance()
  {
    try
    {
      FirebaseMessaging localFirebaseMessaging = getInstance(FirebaseApp.getInstance());
      return localFirebaseMessaging;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  static FirebaseMessaging getInstance(FirebaseApp paramFirebaseApp)
  {
    try
    {
      paramFirebaseApp = (FirebaseMessaging)paramFirebaseApp.get(FirebaseMessaging.class);
      return paramFirebaseApp;
    }
    finally
    {
      paramFirebaseApp = finally;
      throw paramFirebaseApp;
    }
  }
  
  public boolean deliveryMetricsExportToBigQueryEnabled()
  {
    return zzr.zza();
  }
  
  public boolean isAutoInitEnabled()
  {
    return this.zzc.zzh();
  }
  
  public void send(RemoteMessage paramRemoteMessage)
  {
    if (!TextUtils.isEmpty(paramRemoteMessage.getTo()))
    {
      Intent localIntent1 = new Intent("com.google.android.gcm.intent.SEND");
      Intent localIntent2 = new Intent();
      localIntent2.setPackage("com.google.example.invalidpackage");
      localIntent1.putExtra("app", PendingIntent.getBroadcast(this.zzb, 0, localIntent2, 0));
      localIntent1.setPackage("com.google.android.gms");
      localIntent1.putExtras(paramRemoteMessage.zza);
      this.zzb.sendOrderedBroadcast(localIntent1, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
      return;
    }
    throw new IllegalArgumentException("Missing 'to'");
  }
  
  public void setAutoInitEnabled(boolean paramBoolean)
  {
    this.zzc.zzb(paramBoolean);
  }
  
  public void setDeliveryMetricsExportToBigQuery(boolean paramBoolean)
  {
    zzr.zza(paramBoolean);
  }
  
  public Task<Void> subscribeToTopic(String paramString)
  {
    return this.zzd.onSuccessTask(new zzm(paramString));
  }
  
  public Task<Void> unsubscribeFromTopic(String paramString)
  {
    return this.zzd.onSuccessTask(new zzl(paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\FirebaseMessaging.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */