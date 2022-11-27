package com.google.android.gms.internal.measurement;

public final class zzos
  implements zzop
{
  private static final zzdh<Boolean> zza;
  private static final zzdh<Double> zzb;
  private static final zzdh<Long> zzc;
  private static final zzdh<Long> zzd;
  private static final zzdh<String> zze;
  
  static
  {
    zzdm localzzdm = new zzdm(zzde.zza("com.google.android.gms.measurement"));
    zza = localzzdm.zza("measurement.test.boolean_flag", false);
    zzb = localzzdm.zza("measurement.test.double_flag", -3.0D);
    zzc = localzzdm.zza("measurement.test.int_flag", -2L);
    zzd = localzzdm.zza("measurement.test.long_flag", -1L);
    zze = localzzdm.zza("measurement.test.string_flag", "---");
  }
  
  public final boolean zza()
  {
    return ((Boolean)zza.zzc()).booleanValue();
  }
  
  public final double zzb()
  {
    return ((Double)zzb.zzc()).doubleValue();
  }
  
  public final long zzc()
  {
    return ((Long)zzc.zzc()).longValue();
  }
  
  public final long zzd()
  {
    return ((Long)zzd.zzc()).longValue();
  }
  
  public final String zze()
  {
    return (String)zze.zzc();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzos.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */