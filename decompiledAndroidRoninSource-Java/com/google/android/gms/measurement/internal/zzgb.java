package com.google.android.gms.measurement.internal;

final class zzgb
  implements Runnable
{
  zzgb(zzfw paramzzfw, zzw paramzzw, zzn paramzzn) {}
  
  public final void run()
  {
    zzfw.zza(this.zzc).zzr();
    if (this.zza.zzc.zza() == null)
    {
      zzfw.zza(this.zzc).zzb(this.zza, this.zzb);
      return;
    }
    zzfw.zza(this.zzc).zza(this.zza, this.zzb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */