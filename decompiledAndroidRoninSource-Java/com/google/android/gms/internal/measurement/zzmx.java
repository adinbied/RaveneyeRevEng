package com.google.android.gms.internal.measurement;

public final class zzmx
  implements zzmy
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  private static final zzdh<Boolean> zzd;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
    zzb = localzzdm.zza("measurement.audience.refresh_event_count_filters_timestamp", false);
    zzc = localzzdm.zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
    zzd = localzzdm.zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
  }
  
  public final boolean zza()
  {
    return true;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzmx.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */