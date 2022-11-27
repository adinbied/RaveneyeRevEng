package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;

final class zzkf
{
  private final Clock zza;
  private long zzb;
  
  public zzkf(Clock paramClock)
  {
    Preconditions.checkNotNull(paramClock);
    this.zza = paramClock;
  }
  
  public final void zza()
  {
    this.zzb = this.zza.elapsedRealtime();
  }
  
  public final boolean zza(long paramLong)
  {
    if (this.zzb == 0L) {
      return true;
    }
    return this.zza.elapsedRealtime() - this.zzb >= 3600000L;
  }
  
  public final void zzb()
  {
    this.zzb = 0L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzkf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */