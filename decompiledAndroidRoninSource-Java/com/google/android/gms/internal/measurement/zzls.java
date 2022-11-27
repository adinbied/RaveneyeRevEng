package com.google.android.gms.internal.measurement;

public final class zzls
  implements zzlp
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  private static final zzdh<Long> zzd;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.client.ad_impression", true);
    zzb = localzzdm.zza("measurement.service.separate_public_internal_event_blacklisting", false);
    zzc = localzzdm.zza("measurement.service.ad_impression", false);
    zzd = localzzdm.zza("measurement.id.service.ad_impression", 0L);
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
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzls.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */