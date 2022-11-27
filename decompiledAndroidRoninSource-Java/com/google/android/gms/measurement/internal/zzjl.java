package com.google.android.gms.measurement.internal;

final class zzjl
  implements Runnable
{
  zzjl(zzji paramzzji, zzej paramzzej) {}
  
  public final void run()
  {
    synchronized (this.zzb)
    {
      zzji.zza(this.zzb, false);
      if (!this.zzb.zza.zzaa())
      {
        this.zzb.zza.zzq().zzw().zza("Connected to service");
        this.zzb.zza.zza(this.zza);
      }
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */