package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzmj;
import java.util.concurrent.atomic.AtomicReference;

final class zziu
  implements Runnable
{
  zziu(zzio paramzzio, AtomicReference paramAtomicReference, zzn paramzzn) {}
  
  public final void run()
  {
    try
    {
      synchronized (this.zza)
      {
        if ((zzmj.zzb()) && (this.zzc.zzs().zza(zzat.zzcg)) && (!this.zzc.zzr().zzw().zze()))
        {
          this.zzc.zzq().zzj().zza("Analytics storage consent denied; will not get app instance id");
          this.zzc.zze().zza(null);
          this.zzc.zzr().zzj.zza(null);
          this.zza.set(null);
        }
        try
        {
          this.zza.notify();
          return;
        }
        finally {}
        Object localObject1 = zzio.zzd(this.zzc);
        if (localObject1 == null)
        {
          this.zzc.zzq().zze().zza("Failed to get app instance id");
          this.zza.notify();
          return;
        }
        this.zza.set(((zzej)localObject1).zzc(this.zzb));
        localObject1 = (String)this.zza.get();
        if (localObject1 != null)
        {
          this.zzc.zze().zza((String)localObject1);
          this.zzc.zzr().zzj.zza((String)localObject1);
        }
        zzio.zze(this.zzc);
        this.zza.notify();
      }
      this.zza.notify();
    }
    catch (RemoteException localRemoteException)
    {
      this.zzc.zzq().zze().zza("Failed to get app instance id", localRemoteException);
      this.zza.notify();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zziu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */