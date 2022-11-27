package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzq;

abstract class zzaj
{
  private static volatile Handler zzb;
  private final zzgq zza;
  private final Runnable zzc;
  private volatile long zzd;
  
  zzaj(zzgq paramzzgq)
  {
    Preconditions.checkNotNull(paramzzgq);
    this.zza = paramzzgq;
    this.zzc = new zzai(this, paramzzgq);
  }
  
  private final Handler zzd()
  {
    if (zzb != null) {
      return zzb;
    }
    try
    {
      if (zzb == null) {
        zzb = new zzq(this.zza.zzm().getMainLooper());
      }
      Handler localHandler = zzb;
      return localHandler;
    }
    finally {}
  }
  
  public abstract void zza();
  
  public final void zza(long paramLong)
  {
    zzc();
    if (paramLong >= 0L)
    {
      this.zzd = this.zza.zzl().currentTimeMillis();
      if (!zzd().postDelayed(this.zzc, paramLong)) {
        this.zza.zzq().zze().zza("Failed to schedule delayed post. time", Long.valueOf(paramLong));
      }
    }
  }
  
  public final boolean zzb()
  {
    return this.zzd != 0L;
  }
  
  final void zzc()
  {
    this.zzd = 0L;
    zzd().removeCallbacks(this.zzc);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzaj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */