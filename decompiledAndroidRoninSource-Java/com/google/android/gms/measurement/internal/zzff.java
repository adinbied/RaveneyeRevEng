package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzff
{
  private final String zza;
  private final boolean zzb;
  private boolean zzc;
  private boolean zzd;
  
  public zzff(zzfd paramzzfd, String paramString, boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString);
    this.zza = paramString;
    this.zzb = paramBoolean;
  }
  
  public final void zza(boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = this.zze.zzf().edit();
    localEditor.putBoolean(this.zza, paramBoolean);
    localEditor.apply();
    this.zzd = paramBoolean;
  }
  
  public final boolean zza()
  {
    if (!this.zzc)
    {
      this.zzc = true;
      this.zzd = this.zze.zzf().getBoolean(this.zza, this.zzb);
    }
    return this.zzd;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzff.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */