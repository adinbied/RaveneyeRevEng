package com.google.android.gms.measurement.internal;

final class zzit
  implements Runnable
{
  zzit(zzio paramzzio, boolean paramBoolean, zzkr paramzzkr, zzn paramzzn) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzd);
    if (localzzej == null)
    {
      this.zzd.zzq().zze().zza("Discarding data. Failed to set user property");
      return;
    }
    zzio localzzio = this.zzd;
    zzkr localzzkr;
    if (this.zza) {
      localzzkr = null;
    } else {
      localzzkr = this.zzb;
    }
    localzzio.zza(localzzej, localzzkr, this.zzc);
    zzio.zze(this.zzd);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */