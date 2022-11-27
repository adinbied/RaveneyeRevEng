package com.google.firebase.messaging;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.iid.zzbc;
import com.google.firebase.iid.zzbd;
import java.util.concurrent.ExecutorService;

public abstract class zzf
  extends Service
{
  private final ExecutorService zza = zza.zza().zza(new NamedThreadFactory("Firebase-Messaging-Intent-Handle"), com.google.android.gms.internal.firebase_messaging.zzf.zzb);
  private Binder zzb;
  private final Object zzc = new Object();
  private int zzd;
  private int zze = 0;
  
  private final Task<Void> zze(Intent paramIntent)
  {
    if (zzb(paramIntent)) {
      return Tasks.forResult(null);
    }
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    this.zza.execute(new zzh(this, paramIntent, localTaskCompletionSource));
    return localTaskCompletionSource.getTask();
  }
  
  private final void zzf(Intent arg1)
  {
    if (??? != null) {
      zzbd.zza(???);
    }
    synchronized (this.zzc)
    {
      int i = this.zze - 1;
      this.zze = i;
      if (i == 0) {
        stopSelfResult(this.zzd);
      }
      return;
    }
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3)) {
        Log.d("EnhancedIntentService", "Service received bind request");
      }
      if (this.zzb == null) {
        this.zzb = new zzbc(new zze(this));
      }
      paramIntent = this.zzb;
      return paramIntent;
    }
    finally {}
  }
  
  public void onDestroy()
  {
    this.zza.shutdown();
    super.onDestroy();
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.zzc)
    {
      this.zzd = paramInt2;
      this.zze += 1;
      ??? = zza(paramIntent);
      if (??? == null)
      {
        zzf(paramIntent);
        return 2;
      }
      ??? = zze((Intent)???);
      if (((Task)???).isComplete())
      {
        zzf(paramIntent);
        return 2;
      }
      ((Task)???).addOnCompleteListener(zzg.zza, new zzj(this, paramIntent));
      return 3;
    }
  }
  
  protected Intent zza(Intent paramIntent)
  {
    return paramIntent;
  }
  
  public boolean zzb(Intent paramIntent)
  {
    return false;
  }
  
  public abstract void zzc(Intent paramIntent);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */