package com.google.android.gms.internal.measurement;

public final class zzme
  implements zzmb
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Long> zzb;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.sdk.attribution.cache", true);
    zzb = localzzdm.zza("measurement.sdk.attribution.cache.ttl", 604800000L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
  
  public final long zzb()
  {
    return ((Long)zzb.zzc()).longValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzme.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */