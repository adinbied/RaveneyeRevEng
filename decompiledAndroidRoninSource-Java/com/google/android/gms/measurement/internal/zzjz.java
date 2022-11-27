package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.util.Clock;

final class zzjz
{
  private zzjy zzb;
  
  zzjz(zzju paramzzju) {}
  
  final void zza()
  {
    this.zza.zzc();
    if (this.zzb != null) {
      zzju.zzb(this.zza).removeCallbacks(this.zzb);
    }
    if (this.zza.zzs().zza(zzat.zzbu)) {
      this.zza.zzr().zzr.zza(false);
    }
  }
  
  final void zza(long paramLong)
  {
    this.zzb = new zzjy(this, this.zza.zzl().currentTimeMillis(), paramLong);
    zzju.zzb(this.zza).postDelayed(this.zzb, 2000L);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */