package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzdm
{
  final Uri zza;
  final String zzb;
  final String zzc;
  private final String zzd = null;
  private final boolean zze;
  private final boolean zzf;
  private final boolean zzg;
  private final boolean zzh;
  @Nullable
  private final zzdw<Context, Boolean> zzi;
  
  public zzdm(Uri paramUri)
  {
    this(null, paramUri, "", "", false, false, false, false, null);
  }
  
  private zzdm(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, @Nullable zzdw<Context, Boolean> paramzzdw)
  {
    this.zza = paramUri;
    this.zzb = paramString2;
    this.zzc = paramString3;
    this.zze = false;
    this.zzf = false;
    this.zzg = false;
    this.zzh = false;
    this.zzi = null;
  }
  
  public final zzdh<Double> zza(String paramString, double paramDouble)
  {
    return zzdh.zza(this, paramString, -3.0D, true);
  }
  
  public final zzdh<Long> zza(String paramString, long paramLong)
  {
    return zzdh.zza(this, paramString, paramLong, true);
  }
  
  public final zzdh<String> zza(String paramString1, String paramString2)
  {
    return zzdh.zza(this, paramString1, paramString2, true);
  }
  
  public final zzdh<Boolean> zza(String paramString, boolean paramBoolean)
  {
    return zzdh.zza(this, paramString, paramBoolean, true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */