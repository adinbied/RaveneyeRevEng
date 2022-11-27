package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zznh;
import com.google.android.gms.internal.measurement.zznm;

final class zzka
{
  private long zza;
  private long zzb;
  private final zzaj zzc = new zzkd(this, this.zzd.zzy);
  
  public zzka(zzju paramzzju)
  {
    long l = paramzzju.zzl().elapsedRealtime();
    this.zza = l;
    this.zzb = l;
  }
  
  private final void zzc()
  {
    this.zzd.zzc();
    zza(false, false, this.zzd.zzl().elapsedRealtime());
    this.zzd.zzd().zza(this.zzd.zzl().elapsedRealtime());
  }
  
  final void zza()
  {
    this.zzc.zzc();
    this.zza = 0L;
    this.zzb = 0L;
  }
  
  final void zza(long paramLong)
  {
    this.zzd.zzc();
    this.zzc.zzc();
    this.zza = paramLong;
    this.zzb = paramLong;
  }
  
  public final boolean zza(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    this.zzd.zzc();
    this.zzd.zzv();
    if ((!zznh.zzb()) || (!this.zzd.zzs().zza(zzat.zzbp)) || (this.zzd.zzy.zzaa())) {
      this.zzd.zzr().zzp.zza(this.zzd.zzl().currentTimeMillis());
    }
    long l2 = paramLong - this.zza;
    if ((!paramBoolean1) && (l2 < 1000L))
    {
      this.zzd.zzq().zzw().zza("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(l2));
      return false;
    }
    long l1 = l2;
    if (this.zzd.zzs().zza(zzat.zzas))
    {
      l1 = l2;
      if (!paramBoolean2) {
        if ((zznm.zzb()) && (this.zzd.zzs().zza(zzat.zzau))) {
          l1 = zzc(paramLong);
        } else {
          l1 = zzb();
        }
      }
    }
    this.zzd.zzq().zzw().zza("Recording user engagement, ms", Long.valueOf(l1));
    Bundle localBundle = new Bundle();
    localBundle.putLong("_et", l1);
    paramBoolean1 = this.zzd.zzs().zzh().booleanValue();
    zzij.zza(this.zzd.zzh().zza(paramBoolean1 ^ true), localBundle, true);
    if ((this.zzd.zzs().zza(zzat.zzas)) && (!this.zzd.zzs().zza(zzat.zzat)) && (paramBoolean2)) {
      localBundle.putLong("_fr", 1L);
    }
    if ((!this.zzd.zzs().zza(zzat.zzat)) || (!paramBoolean2)) {
      this.zzd.zze().zza("auto", "_e", localBundle);
    }
    this.zza = paramLong;
    this.zzc.zzc();
    this.zzc.zza(3600000L);
    return true;
  }
  
  final long zzb()
  {
    long l1 = this.zzd.zzl().elapsedRealtime();
    long l2 = this.zzb;
    this.zzb = l1;
    return l1 - l2;
  }
  
  final void zzb(long paramLong)
  {
    this.zzc.zzc();
  }
  
  final long zzc(long paramLong)
  {
    long l = this.zzb;
    this.zzb = paramLong;
    return paramLong - l;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzka.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */