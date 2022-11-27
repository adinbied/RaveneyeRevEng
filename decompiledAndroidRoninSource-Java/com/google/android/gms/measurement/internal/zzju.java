package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzq;

public final class zzju
  extends zzg
{
  protected final zzkc zza = new zzkc(this);
  protected final zzka zzb = new zzka(this);
  private Handler zzc;
  private final zzjz zzd = new zzjz(this);
  
  zzju(zzfv paramzzfv)
  {
    super(paramzzfv);
  }
  
  private final void zzaa()
  {
    zzc();
    if (this.zzc == null) {
      this.zzc = new zzq(Looper.getMainLooper());
    }
  }
  
  private final void zzb(long paramLong)
  {
    zzc();
    zzaa();
    zzq().zzw().zza("Activity resumed, time", Long.valueOf(paramLong));
    if (zzs().zza(zzat.zzbu))
    {
      if ((zzs().zzh().booleanValue()) || (zzr().zzr.zza())) {
        this.zzb.zza(paramLong);
      }
      this.zzd.zza();
    }
    else
    {
      this.zzd.zza();
      if (zzs().zzh().booleanValue()) {
        this.zzb.zza(paramLong);
      }
    }
    zzkc localzzkc = this.zza;
    localzzkc.zza.zzc();
    if (localzzkc.zza.zzy.zzaa())
    {
      if (!localzzkc.zza.zzs().zza(zzat.zzbu)) {
        localzzkc.zza.zzr().zzr.zza(false);
      }
      localzzkc.zza(localzzkc.zza.zzl().currentTimeMillis(), false);
    }
  }
  
  private final void zzc(long paramLong)
  {
    zzc();
    zzaa();
    zzq().zzw().zza("Activity paused, time", Long.valueOf(paramLong));
    this.zzd.zza(paramLong);
    if (zzs().zzh().booleanValue()) {
      this.zzb.zzb(paramLong);
    }
    zzkc localzzkc = this.zza;
    if (!localzzkc.zza.zzs().zza(zzat.zzbu)) {
      localzzkc.zza.zzr().zzr.zza(true);
    }
  }
  
  final long zza(long paramLong)
  {
    return this.zzb.zzc(paramLong);
  }
  
  public final boolean zza(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    return this.zzb.zza(paramBoolean1, paramBoolean2, paramLong);
  }
  
  protected final boolean zzy()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzju.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */