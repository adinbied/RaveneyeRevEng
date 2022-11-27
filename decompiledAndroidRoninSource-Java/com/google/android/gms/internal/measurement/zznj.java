package com.google.android.gms.internal.measurement;

public final class zznj
  implements zznk
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  private static final zzdh<Boolean> zzc;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.client.sessions.check_on_reset_and_enable2", true);
    zzb = localzzdm.zza("measurement.client.sessions.check_on_startup", true);
    zzc = localzzdm.zza("measurement.client.sessions.start_session_before_view_screen", true);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zznj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */