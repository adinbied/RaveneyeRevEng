package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zziv
  implements Runnable
{
  zziv(zzio paramzzio, zzn paramzzn) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzb);
    if (localzzej == null)
    {
      this.zzb.zzq().zze().zza("Failed to reset data on the service: not connected to service");
      return;
    }
    try
    {
      localzzej.zzd(this.zza);
    }
    catch (RemoteException localRemoteException)
    {
      this.zzb.zzq().zze().zza("Failed to reset data on the service: remote exception", localRemoteException);
    }
    zzio.zze(this.zzb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zziv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */