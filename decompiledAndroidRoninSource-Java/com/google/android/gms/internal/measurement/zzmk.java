package com.google.android.gms.internal.measurement;

public final class zzmk
  implements zzmh
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Long> zzc;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.service.configurable_service_limits", true);
    zzb = localzzdm.zza("measurement.client.configurable_service_limits", true);
    zzc = localzzdm.zza("measurement.id.service.configurable_service_limits", 0L);
  }
  
  public final boolean zza()
  {
    return true;
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
  
  public final boolean zzc()
  {
    return ((Boolean)zzb.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzmk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */