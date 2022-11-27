package com.google.android.gms.measurement;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Intent;
import android.os.IBinder;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjv;

public final class AppMeasurementService
  extends Service
  implements zzjv
{
  private zzjr<AppMeasurementService> zza;
  
  private final zzjr<AppMeasurementService> zza()
  {
    if (this.zza == null) {
      this.zza = new zzjr(this);
    }
    return this.zza;
  }
  
  public final IBinder onBind(Intent paramIntent)
  {
    return zza().zza(paramIntent);
  }
  
  public final void onCreate()
  {
    super.onCreate();
    zza().zza();
  }
  
  public final void onDestroy()
  {
    zza().zzb();
    super.onDestroy();
  }
  
  public final void onRebind(Intent paramIntent)
  {
    zza().zzc(paramIntent);
  }
  
  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    return zza().zza(paramIntent, paramInt1, paramInt2);
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    return zza().zzb(paramIntent);
  }
  
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    throw new UnsupportedOperationException();
  }
  
  public final void zza(Intent paramIntent)
  {
    AppMeasurementReceiver.completeWakefulIntent(paramIntent);
  }
  
  public final boolean zza(int paramInt)
  {
    return stopSelfResult(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */