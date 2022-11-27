package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfh
{
  private final String zza;
  private final long zzb;
  private boolean zzc;
  private long zzd;
  
  public zzfh(zzfd paramzzfd, String paramString, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zza = paramString;
    this.zzb = paramLong;
  }
  
  public final long zza()
  {
    if (!this.zzc)
    {
      this.zzc = true;
      this.zzd = this.zze.zzf().getLong(this.zza, this.zzb);
    }
    return this.zzd;
  }
  
  public final void zza(long paramLong)
  {
    SharedPreferences.Editor localEditor = this.zze.zzf().edit();
    localEditor.putLong(this.zza, paramLong);
    localEditor.apply();
    this.zzd = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */