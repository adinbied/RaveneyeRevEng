package com.google.firebase.messaging;

import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzab;
import com.google.firebase.iid.zzaw;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FirebaseMessagingService
  extends zzf
{
  private static final Queue<String> zza = new ArrayDeque(10);
  
  public void onDeletedMessages() {}
  
  public void onMessageReceived(RemoteMessage paramRemoteMessage) {}
  
  public void onMessageSent(String paramString) {}
  
  public void onNewToken(String paramString) {}
  
  public void onSendError(String paramString, Exception paramException) {}
  
  protected final Intent zza(Intent paramIntent)
  {
    return zzaw.zza().zzb();
  }
  
  public final boolean zzb(Intent paramIntent)
  {
    PendingIntent localPendingIntent;
    if ("com.google.firebase.messaging.NOTIFICATION_OPEN".equals(paramIntent.getAction()))
    {
      localPendingIntent = (PendingIntent)paramIntent.getParcelableExtra("pending_intent");
      if (localPendingIntent == null) {}
    }
    try
    {
      localPendingIntent.send();
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      for (;;) {}
    }
    Log.e("FirebaseMessaging", "Notification pending intent canceled");
    if (zzr.zzd(paramIntent)) {
      zzr.zza(paramIntent);
    }
    return true;
    return false;
  }
  
  public final void zzc(Intent paramIntent)
  {
    Object localObject1 = paramIntent.getAction();
    if ((!"com.google.android.c2dm.intent.RECEIVE".equals(localObject1)) && (!"com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(localObject1)))
    {
      if ("com.google.firebase.messaging.NOTIFICATION_DISMISS".equals(localObject1))
      {
        if (zzr.zzd(paramIntent)) {
          zzr.zzb(paramIntent);
        }
      }
      else
      {
        if ("com.google.firebase.messaging.NEW_TOKEN".equals(localObject1))
        {
          onNewToken(paramIntent.getStringExtra("token"));
          return;
        }
        paramIntent = String.valueOf(paramIntent.getAction());
        if (paramIntent.length() != 0) {
          paramIntent = "Unknown intent action: ".concat(paramIntent);
        } else {
          paramIntent = new String("Unknown intent action: ");
        }
        Log.d("FirebaseMessaging", paramIntent);
      }
      return;
    }
    Object localObject2 = paramIntent.getStringExtra("google.message_id");
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject1 = Tasks.forResult(null);
    }
    else
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("google.message_id", (String)localObject2);
      localObject1 = zzab.zza(this).zza(2, (Bundle)localObject1);
    }
    boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
    int j = 0;
    if (bool) {}
    int i;
    for (;;)
    {
      i = 0;
      break;
      if (zza.contains(localObject2))
      {
        if (Log.isLoggable("FirebaseMessaging", 3))
        {
          localObject2 = String.valueOf(localObject2);
          if (((String)localObject2).length() != 0) {
            localObject2 = "Received duplicate message: ".concat((String)localObject2);
          } else {
            localObject2 = new String("Received duplicate message: ");
          }
          Log.d("FirebaseMessaging", (String)localObject2);
        }
        i = 1;
        break;
      }
      if (zza.size() >= 10) {
        zza.remove();
      }
      zza.add(localObject2);
    }
    if (i == 0)
    {
      Object localObject3 = paramIntent.getStringExtra("message_type");
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "gcm";
      }
      switch (((String)localObject2).hashCode())
      {
      default: 
        break;
      case 814800675: 
        if (((String)localObject2).equals("send_event")) {
          i = 2;
        }
        break;
      case 814694033: 
        if (((String)localObject2).equals("send_error")) {
          i = 3;
        }
        break;
      case 102161: 
        if (((String)localObject2).equals("gcm")) {
          i = j;
        }
        break;
      case -2062414158: 
        if (((String)localObject2).equals("deleted_messages")) {
          i = 1;
        }
        break;
      }
      i = -1;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              paramIntent = String.valueOf(localObject2);
              if (paramIntent.length() != 0) {
                paramIntent = "Received message with unknown type: ".concat(paramIntent);
              } else {
                paramIntent = new String("Received message with unknown type: ");
              }
              Log.w("FirebaseMessaging", paramIntent);
            }
            else
            {
              localObject3 = paramIntent.getStringExtra("google.message_id");
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = paramIntent.getStringExtra("message_id");
              }
              onSendError((String)localObject2, new SendException(paramIntent.getStringExtra("error")));
            }
          }
          else {
            onMessageSent(paramIntent.getStringExtra("google.message_id"));
          }
        }
        else {
          onDeletedMessages();
        }
      }
      else
      {
        if (zzr.zzd(paramIntent)) {
          zzr.zza(paramIntent, null);
        }
        if (zzr.zze(paramIntent))
        {
          localObject2 = FirebaseMessaging.zza;
          if (localObject2 != null) {
            zzr.zza(paramIntent, ((TransportFactory)localObject2).getTransport("FCM_CLIENT_EVENT_LOGGING", String.class, Encoding.of("json"), zzp.zza));
          } else {
            Log.e("FirebaseMessaging", "TransportFactory is null. Skip exporting message delivery metrics to Big Query");
          }
        }
        localObject3 = paramIntent.getExtras();
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).remove("androidx.contentpager.content.wakelockid");
        Object localObject4;
        if (zzt.zza((Bundle)localObject2))
        {
          localObject4 = new zzt((Bundle)localObject2);
          localObject3 = Executors.newSingleThreadExecutor(new NamedThreadFactory("Firebase-Messaging-Network-Io"));
          localObject4 = new zzc(this, (zzt)localObject4, (Executor)localObject3);
        }
        try
        {
          bool = ((zzc)localObject4).zza();
          if (bool)
          {
            ((ExecutorService)localObject3).shutdown();
          }
          else
          {
            ((ExecutorService)localObject3).shutdown();
            if (zzr.zzd(paramIntent)) {
              zzr.zzc(paramIntent);
            }
          }
        }
        finally
        {
          ((ExecutorService)localObject3).shutdown();
        }
      }
    }
    try
    {
      Tasks.await((Task)localObject1, TimeUnit.SECONDS.toMillis(1L), TimeUnit.MILLISECONDS);
      return;
    }
    catch (TimeoutException paramIntent) {}catch (InterruptedException paramIntent) {}catch (ExecutionException paramIntent) {}
    paramIntent = String.valueOf(paramIntent);
    localObject1 = new StringBuilder(String.valueOf(paramIntent).length() + 20);
    ((StringBuilder)localObject1).append("Message ack failed: ");
    ((StringBuilder)localObject1).append(paramIntent);
    Log.w("FirebaseMessaging", ((StringBuilder)localObject1).toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\FirebaseMessagingService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */