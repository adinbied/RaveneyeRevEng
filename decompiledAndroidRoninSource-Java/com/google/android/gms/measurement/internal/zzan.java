package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

final class zzan
{
  final String zza;
  final String zzb;
  final long zzc;
  final long zzd;
  final long zze;
  final long zzf;
  final long zzg;
  final Long zzh;
  final Long zzi;
  final Long zzj;
  final Boolean zzk;
  
  zzan(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, Long paramLong6, Long paramLong7, Long paramLong8, Boolean paramBoolean)
  {
    Preconditions.checkNotEmpty(paramString1);
    Preconditions.checkNotEmpty(paramString2);
    boolean bool2 = true;
    boolean bool1;
    if (paramLong1 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong2 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong3 >= 0L) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramLong5 >= 0L) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    this.zza = paramString1;
    this.zzb = paramString2;
    this.zzc = paramLong1;
    this.zzd = paramLong2;
    this.zze = paramLong3;
    this.zzf = paramLong4;
    this.zzg = paramLong5;
    this.zzh = paramLong6;
    this.zzi = paramLong7;
    this.zzj = paramLong8;
    this.zzk = paramBoolean;
  }
  
  zzan(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, Long paramLong5, Long paramLong6, Long paramLong7, Boolean paramBoolean)
  {
    this(paramString1, paramString2, 0L, 0L, 0L, paramLong3, 0L, null, null, null, null);
  }
  
  final zzan zza(long paramLong)
  {
    return new zzan(this.zza, this.zzb, this.zzc, this.zzd, this.zze, paramLong, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk);
  }
  
  final zzan zza(long paramLong1, long paramLong2)
  {
    return new zzan(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, paramLong1, Long.valueOf(paramLong2), this.zzi, this.zzj, this.zzk);
  }
  
  final zzan zza(Long paramLong1, Long paramLong2, Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (!paramBoolean.booleanValue())) {
      paramBoolean = null;
    }
    return new zzan(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, this.zzg, this.zzh, paramLong1, paramLong2, paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */