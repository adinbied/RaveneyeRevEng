package com.google.android.gms.internal.measurement;

public final class zznp
  implements zznq
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Long> zzc;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.collection.efficient_engagement_reporting_enabled_2", true);
    zzb = localzzdm.zza("measurement.collection.redundant_engagement_removal_enabled", false);
    zzc = localzzdm.zza("measurement.id.collection.redundant_engagement_removal_enabled", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zzb.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zznp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */