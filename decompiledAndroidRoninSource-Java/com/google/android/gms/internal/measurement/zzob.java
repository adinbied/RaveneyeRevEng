package com.google.android.gms.internal.measurement;

public final class zzob
  implements zzoc
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  private static final zzdh<Boolean> zzd;
  private static final zzdh<Long> zze;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
    zzb = localzzdm.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
    zzc = localzzdm.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
    zzd = localzzdm.zza("measurement.sdk.collection.last_gclid_from_referrer2", false);
    zze = localzzdm.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zzb.zzc()).booleanValue();
  }
  
  public final boolean zzc()
  {
    return ((Boolean)zzc.zzc()).booleanValue();
  }
  
  public final boolean zzd()
  {
    return ((Boolean)zzd.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */