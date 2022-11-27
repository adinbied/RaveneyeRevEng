package com.google.android.gms.measurement.internal;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PersistableBundle;
import com.google.android.gms.common.internal.Preconditions;

public final class zzjr<T extends Context,  extends zzjv>
{
  private final T zza;
  
  public zzjr(T paramT)
  {
    Preconditions.checkNotNull(paramT);
    this.zza = paramT;
  }
  
  private final void zza(Runnable paramRunnable)
  {
    zzki localzzki = zzki.zza(this.zza);
    localzzki.zzp().zza(new zzjs(this, localzzki, paramRunnable));
  }
  
  private final zzer zzc()
  {
    return zzfv.zza(this.zza, null, null).zzq();
  }
  
  public final int zza(Intent paramIntent, int paramInt1, int paramInt2)
  {
    zzer localzzer = zzfv.zza(this.zza, null, null).zzq();
    if (paramIntent == null)
    {
      localzzer.zzh().zza("AppMeasurementService started with null intent");
      return 2;
    }
    String str = paramIntent.getAction();
    localzzer.zzw().zza("Local AppMeasurementService called. startId, action", Integer.valueOf(paramInt2), str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      zza(new zzjq(this, paramInt2, localzzer, paramIntent));
    }
    return 2;
  }
  
  public final IBinder zza(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzc().zze().zza("onBind called with null intent");
      return null;
    }
    paramIntent = paramIntent.getAction();
    if ("com.google.android.gms.measurement.START".equals(paramIntent)) {
      return new zzfw(zzki.zza(this.zza));
    }
    zzc().zzh().zza("onBind received unknown action", paramIntent);
    return null;
  }
  
  public final void zza()
  {
    zzfv.zza(this.zza, null, null).zzq().zzw().zza("Local AppMeasurementService is starting up");
  }
  
  public final boolean zza(JobParameters paramJobParameters)
  {
    zzer localzzer = zzfv.zza(this.zza, null, null).zzq();
    String str = paramJobParameters.getExtras().getString("action");
    localzzer.zzw().zza("Local AppMeasurementJobService called. action", str);
    if ("com.google.android.gms.measurement.UPLOAD".equals(str)) {
      zza(new zzjt(this, localzzer, paramJobParameters));
    }
    return true;
  }
  
  public final void zzb()
  {
    zzfv.zza(this.zza, null, null).zzq().zzw().zza("Local AppMeasurementService is shutting down");
  }
  
  public final boolean zzb(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzc().zze().zza("onUnbind called with null intent");
      return true;
    }
    paramIntent = paramIntent.getAction();
    zzc().zzw().zza("onUnbind called for intent. action", paramIntent);
    return true;
  }
  
  public final void zzc(Intent paramIntent)
  {
    if (paramIntent == null)
    {
      zzc().zze().zza("onRebind called with null intent");
      return;
    }
    paramIntent = paramIntent.getAction();
    zzc().zzw().zza("onRebind called. action", paramIntent);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */