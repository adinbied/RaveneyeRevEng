package com.google.android.gms.measurement.internal;

final class zzgk
  implements Runnable
{
  zzgk(zzfw paramzzfw, zzkr paramzzkr, zzn paramzzn) {}
  
  public final void run()
  {
    zzfw.zza(this.zzc).zzr();
    if (this.zza.zza() == null)
    {
      zzfw.zza(this.zzc).zzb(this.zza, this.zzb);
      return;
    }
    zzfw.zza(this.zzc).zza(this.zza, this.zzb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */