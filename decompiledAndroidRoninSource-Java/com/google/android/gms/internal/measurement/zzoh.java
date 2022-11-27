package com.google.android.gms.internal.measurement;

public final class zzoh
  implements zzoi
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Boolean> zzb;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.sdk.screen.manual_screen_view_logging", true);
    zzb = localzzdm.zza("measurement.sdk.screen.disabling_automatic_reporting", true);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzoh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */