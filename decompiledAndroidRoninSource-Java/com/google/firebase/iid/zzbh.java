package com.google.firebase.iid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class zzbh
  implements ServiceConnection
{
  private final Context zza;
  private final Intent zzb;
  private final ScheduledExecutorService zzc;
  private final Queue<zzbg> zzd = new ArrayDeque();
  private zzbc zze;
  private boolean zzf = false;
  
  public zzbh(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
  }
  
  private zzbh(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zza = paramContext.getApplicationContext();
    this.zzb = new Intent(paramString).setPackage(this.zza.getPackageName());
    this.zzc = paramScheduledExecutorService;
  }
  
  private final void zza()
  {
    for (;;)
    {
      try
      {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
          Log.d("FirebaseInstanceId", "flush queue called");
        }
        if (!this.zzd.isEmpty())
        {
          if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "found intent to be delivered");
          }
          Object localObject1;
          if ((this.zze != null) && (this.zze.isBinderAlive()))
          {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
              Log.d("FirebaseInstanceId", "binder is alive, sending the intent.");
            }
            localObject1 = (zzbg)this.zzd.poll();
            this.zze.zza((zzbg)localObject1);
            continue;
          }
          if (Log.isLoggable("FirebaseInstanceId", 3))
          {
            if (!this.zzf)
            {
              bool = true;
              localObject1 = new StringBuilder(39);
              ((StringBuilder)localObject1).append("binder is dead. start connection? ");
              ((StringBuilder)localObject1).append(bool);
              Log.d("FirebaseInstanceId", ((StringBuilder)localObject1).toString());
            }
          }
          else if (!this.zzf)
          {
            this.zzf = true;
            try
            {
              bool = ConnectionTracker.getInstance().bindService(this.zza, this.zzb, this, 65);
              if (bool) {
                return;
              }
              Log.e("FirebaseInstanceId", "binding to the service failed");
            }
            catch (SecurityException localSecurityException)
            {
              Log.e("FirebaseInstanceId", "Exception while binding the service", localSecurityException);
            }
            this.zzf = false;
            zzb();
          }
        }
        else
        {
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  private final void zzb()
  {
    while (!this.zzd.isEmpty()) {
      ((zzbg)this.zzd.poll()).zzb();
    }
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      if (Log.isLoggable("FirebaseInstanceId", 3))
      {
        paramComponentName = String.valueOf(paramComponentName);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramComponentName).length() + 20);
        localStringBuilder.append("onServiceConnected: ");
        localStringBuilder.append(paramComponentName);
        Log.d("FirebaseInstanceId", localStringBuilder.toString());
      }
      this.zzf = false;
      if (!(paramIBinder instanceof zzbc))
      {
        paramComponentName = String.valueOf(paramIBinder);
        paramIBinder = new StringBuilder(String.valueOf(paramComponentName).length() + 28);
        paramIBinder.append("Invalid service connection: ");
        paramIBinder.append(paramComponentName);
        Log.e("FirebaseInstanceId", paramIBinder.toString());
        zzb();
        return;
      }
      this.zze = ((zzbc)paramIBinder);
      zza();
      return;
    }
    finally {}
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("FirebaseInstanceId", 3))
    {
      paramComponentName = String.valueOf(paramComponentName);
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramComponentName).length() + 23);
      localStringBuilder.append("onServiceDisconnected: ");
      localStringBuilder.append(paramComponentName);
      Log.d("FirebaseInstanceId", localStringBuilder.toString());
    }
    zza();
  }
  
  public final Task<Void> zza(Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("FirebaseInstanceId", 3)) {
        Log.d("FirebaseInstanceId", "new intent queued in the bind-strategy delivery");
      }
      paramIntent = new zzbg(paramIntent);
      ScheduledExecutorService localScheduledExecutorService = this.zzc;
      ScheduledFuture localScheduledFuture = localScheduledExecutorService.schedule(new zzbj(paramIntent), 9000L, TimeUnit.MILLISECONDS);
      paramIntent.zza().addOnCompleteListener(localScheduledExecutorService, new zzbi(localScheduledFuture));
      this.zzd.add(paramIntent);
      zza();
      paramIntent = paramIntent.zza();
      return paramIntent;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzbh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */