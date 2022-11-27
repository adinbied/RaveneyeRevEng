package com.google.android.gms.internal.measurement;

public final class zzdq
{
  private final boolean zza;
  
  public zzdq(zzdt paramzzdt)
  {
    zzeb.zza(paramzzdt, "BuildInfo must be non-null");
    this.zza = (paramzzdt.zza() ^ true);
  }
  
  public final boolean zza(String paramString)
  {
    zzeb.zza(paramString, "flagName must not be null");
    if (!this.zza) {
      return true;
    }
    return ((zzfe)zzds.zza.zza()).zza(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzdq.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */