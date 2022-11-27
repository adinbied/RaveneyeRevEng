package com.google.android.gms.internal.measurement;

public final class zzmq
  implements zzmn
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  private static final zzdh<Long> zzd;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.sdk.dynamite.allow_remote_dynamite3", false);
    zzb = localzzdm.zza("measurement.collection.init_params_control_enabled", true);
    zzc = localzzdm.zza("measurement.sdk.dynamite.use_dynamite3", true);
    zzd = localzzdm.zza("measurement.id.sdk.dynamite.use_dynamite", 0L);
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzmq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */