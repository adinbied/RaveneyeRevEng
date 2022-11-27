package com.google.android.gms.measurement.internal;

final class zzhw
  implements Runnable
{
  zzhw(zzgy paramzzgy, boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool1 = this.zzb.zzy.zzaa();
    boolean bool2 = this.zzb.zzy.zzz();
    this.zzb.zzy.zza(this.zza);
    if (bool2 == this.zza) {
      this.zzb.zzy.zzq().zzw().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
    }
    if ((this.zzb.zzy.zzaa() == bool1) || (this.zzb.zzy.zzaa() != this.zzb.zzy.zzz())) {
      this.zzb.zzy.zzq().zzj().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(bool1));
    }
    zzgy.zza(this.zzb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzhw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */