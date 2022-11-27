package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

final class zzis
  implements Runnable
{
  zzis(zzio paramzzio, AtomicReference paramAtomicReference, zzn paramzzn, boolean paramBoolean) {}
  
  public final void run()
  {
    try
    {
      synchronized (this.zza)
      {
        zzej localzzej = zzio.zzd(this.zzd);
        if (localzzej == null) {
          this.zzd.zzq().zze().zza("Failed to get all user properties; not connected to service");
        }
        try
        {
          this.zza.notify();
          return;
        }
        finally {}
        this.zza.set(localzzej.zza(this.zzb, this.zzc));
        zzio.zze(this.zzd);
        this.zza.notify();
      }
      this.zza.notify();
    }
    catch (RemoteException localRemoteException)
    {
      this.zzd.zzq().zze().zza("Failed to get all user properties; remote exception", localRemoteException);
      this.zza.notify();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzis.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */