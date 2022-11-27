package com.google.android.gms.internal.measurement;

public final class zzom
  implements zzoj
{
  private static final zzdh<Long> zza;
  private static final zzdh<Long> zzb;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.id.max_bundles_per_iteration", 0L);
    zzb = localzzdm.zza("measurement.max_bundles_per_iteration", 2L);
  }
  
  public final long zza()
  {
    return ((Long)zzb.zzc()).longValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */