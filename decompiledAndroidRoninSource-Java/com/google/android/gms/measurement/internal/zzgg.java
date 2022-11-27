package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzmj;

final class zzgg
  implements Runnable
{
  zzgg(zzfw paramzzfw, zzn paramzzn) {}
  
  public final void run()
  {
    zzfw.zza(this.zzb).zzr();
    zzki localzzki = zzfw.zza(this.zzb);
    zzn localzzn = this.zza;
    if ((zzmj.zzb()) && (localzzki.zzb().zza(zzat.zzci)))
    {
      localzzki.zzp().zzc();
      localzzki.zzn();
      Preconditions.checkNotEmpty(localzzn.zza);
      zzad localzzad1 = zzad.zza(localzzn.zzw);
      zzad localzzad2 = localzzki.zza(localzzn.zza);
      localzzki.zza(localzzn.zza, localzzad1);
      if (localzzad1.zza(localzzad2)) {
        localzzki.zza(localzzn);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */