package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.internal.Preconditions;

public final class zzfj
{
  private final String zza;
  private final String zzb;
  private boolean zzc;
  private String zzd;
  
  public zzfj(zzfd paramzzfd, String paramString1, String paramString2)
  {
    Preconditions.checkNotEmpty(paramString1);
    this.zza = paramString1;
    this.zzb = null;
  }
  
  public final String zza()
  {
    if (!this.zzc)
    {
      this.zzc = true;
      this.zzd = this.zze.zzf().getString(this.zza, null);
    }
    return this.zzd;
  }
  
  public final void zza(String paramString)
  {
    SharedPreferences.Editor localEditor = this.zze.zzf().edit();
    localEditor.putString(this.zza, paramString);
    localEditor.apply();
    this.zzd = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */