package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

final class zzjc
  implements Runnable
{
  zzjc(zzio paramzzio, zzn paramzzn) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzb);
    if (localzzej == null)
    {
      this.zzb.zzq().zze().zza("Failed to send consent settings to service");
      return;
    }
    try
    {
      localzzej.zze(this.zza);
      zzio.zze(this.zzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzb.zzq().zze().zza("Failed to send consent settings to the service", localRemoteException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */