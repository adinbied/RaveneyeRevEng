package com.google.android.gms.measurement;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzjv;

public final class AppMeasurementJobService
  extends JobService
  implements zzjv
{
  private zzjr<AppMeasurementJobService> zza;
  
  private final zzjr<AppMeasurementJobService> zza()
  {
    if (this.zza == null) {
      this.zza = new zzjr(this);
    }
    return this.zza;
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
  
  public final boolean onStartJob(JobParameters paramJobParameters)
  {
    return zza().zza(paramJobParameters);
  }
  
  public final boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
  
  public final boolean onUnbind(Intent paramIntent)
  {
    return zza().zzb(paramIntent);
  }
  
  public final void zza(JobParameters paramJobParameters, boolean paramBoolean)
  {
    jobFinished(paramJobParameters, false);
  }
  
  public final void zza(Intent paramIntent) {}
  
  public final boolean zza(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementJobService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */