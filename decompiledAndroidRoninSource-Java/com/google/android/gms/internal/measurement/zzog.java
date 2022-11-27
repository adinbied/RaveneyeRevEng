package com.google.android.gms.internal.measurement;

public final class zzog
  implements zzod
{
  private static final zzdh<Long> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  private static final zzdh<Boolean> zzd;
  private static final zzdh<Long> zze;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.id.lifecycle.app_in_background_parameter", 0L);
    zzb = localzzdm.zza("measurement.lifecycle.app_backgrounded_engagement", false);
    zzc = localzzdm.zza("measurement.lifecycle.app_backgrounded_tracking", true);
    zzd = localzzdm.zza("measurement.lifecycle.app_in_background_parameter", false);
    zze = localzzdm.zza("measurement.id.lifecycle.app_backgrounded_tracking", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zzb.zzc()).booleanValue();
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zzd.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */