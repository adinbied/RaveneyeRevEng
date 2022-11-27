package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzae;

public final class zzgz
{
  final Context zza;
  String zzb;
  String zzc;
  String zzd;
  Boolean zze;
  long zzf;
  zzae zzg;
  boolean zzh = true;
  Long zzi;
  
  public zzgz(Context paramContext, zzae paramzzae, Long paramLong)
  {
    Preconditions.checkNotNull(paramContext);
    paramContext = paramContext.getApplicationContext();
    Preconditions.checkNotNull(paramContext);
    this.zza = paramContext;
    this.zzi = paramLong;
    if (paramzzae != null)
    {
      this.zzg = paramzzae;
      this.zzb = paramzzae.zzf;
      this.zzc = paramzzae.zze;
      this.zzd = paramzzae.zzd;
      this.zzh = paramzzae.zzc;
      this.zzf = paramzzae.zzb;
      if (paramzzae.zzg != null) {
        this.zze = Boolean.valueOf(paramzzae.zzg.getBoolean("dataCollectionDefaultEnabled", true));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */