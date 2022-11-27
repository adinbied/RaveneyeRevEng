package com.google.android.gms.measurement.internal;

final class zzgp
  implements Runnable
{
  zzgp(zzfw paramzzfw, String paramString1, String paramString2, String paramString3, long paramLong) {}
  
  public final void run()
  {
    Object localObject = this.zza;
    if (localObject == null)
    {
      zzfw.zza(this.zze).zzu().zzu().zza(this.zzb, null);
      return;
    }
    localObject = new zzig(this.zzc, (String)localObject, this.zzd);
    zzfw.zza(this.zze).zzu().zzu().zza(this.zzb, (zzig)localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */