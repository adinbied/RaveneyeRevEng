package com.google.android.gms.internal.measurement;

public final class zzml
  implements zzmm
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  private static final zzdh<Long> zzd;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.client.consent_state_v1", false);
    zzb = localzzdm.zza("measurement.client.3p_consent_state_v1", false);
    zzc = localzzdm.zza("measurement.service.consent_state_v1_W36", false);
    zzd = localzzdm.zza("measurement.service.storage_consent_support_version", 203590L);
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
  
  public final boolean zzd()
  {
    return ((Boolean)zzc.zzc()).booleanValue();
  }
  
  public final long zze()
  {
    return ((Long)zzd.zzc()).longValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzml.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */