package com.google.android.gms.internal.measurement;

public final class zzlz
  implements zzma
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Long> zzb;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.service.directly_maybe_log_error_events", false);
    zzb = localzzdm.zza("measurement.id.service.directly_maybe_log_error_events", 0L);
  }
  
  public final boolean zza()
  {
    return true;
  }
  
  public final boolean zzb()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzlz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */