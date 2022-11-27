package com.google.android.gms.internal.measurement;

public final class zzly
  implements zzlv
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.androidId.delete_feature", true);
    zzb = localzzdm.zza("measurement.log_androidId_enabled", false);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzly.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */