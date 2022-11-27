package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import java.security.SecureRandom;

public final class zzfg
{
  private final String zza;
  private final String zzb;
  private final String zzc;
  private final long zzd;
  
  private zzfg(zzfd paramzzfd, String paramString, long paramLong)
  {
    Preconditions.checkNotEmpty(paramString);
    boolean bool;
    if (paramLong > 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    this.zza = String.valueOf(paramString).concat(":start");
    this.zzb = String.valueOf(paramString).concat(":count");
    this.zzc = String.valueOf(paramString).concat(":value");
    this.zzd = paramLong;
  }
  
  private final void zzb()
  {
    this.zze.zzc();
    long l = this.zze.zzl().currentTimeMillis();
    SharedPreferences.Editor localEditor = this.zze.zzf().edit();
    localEditor.remove(this.zzb);
    localEditor.remove(this.zzc);
    localEditor.putLong(this.zza, l);
    localEditor.apply();
  }
  
  private final long zzc()
  {
    return this.zze.zzf().getLong(this.zza, 0L);
  }
  
  public final Pair<String, Long> zza()
  {
    this.zze.zzc();
    this.zze.zzc();
    long l1 = zzc();
    if (l1 == 0L)
    {
      zzb();
      l1 = 0L;
    }
    else
    {
      l1 = Math.abs(l1 - this.zze.zzl().currentTimeMillis());
    }
    long l2 = this.zzd;
    if (l1 < l2) {
      return null;
    }
    if (l1 > l2 << 1)
    {
      zzb();
      return null;
    }
    String str = this.zze.zzf().getString(this.zzc, null);
    l1 = this.zze.zzf().getLong(this.zzb, 0L);
    zzb();
    if ((str != null) && (l1 > 0L)) {
      return new Pair(str, Long.valueOf(l1));
    }
    return zzfd.zza;
  }
  
  public final void zza(String paramString, long paramLong)
  {
    this.zze.zzc();
    if (zzc() == 0L) {
      zzb();
    }
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    long l = this.zze.zzf().getLong(this.zzb, 0L);
    if (l <= 0L)
    {
      paramString = this.zze.zzf().edit();
      paramString.putString(this.zzc, str);
      paramString.putLong(this.zzb, 1L);
      paramString.apply();
      return;
    }
    paramLong = this.zze.zzo().zzg().nextLong();
    l += 1L;
    int i;
    if ((paramLong & 0x7FFFFFFFFFFFFFFF) < Long.MAX_VALUE / l) {
      i = 1;
    } else {
      i = 0;
    }
    paramString = this.zze.zzf().edit();
    if (i != 0) {
      paramString.putString(this.zzc, str);
    }
    paramString.putLong(this.zzb, l);
    paramString.apply();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */