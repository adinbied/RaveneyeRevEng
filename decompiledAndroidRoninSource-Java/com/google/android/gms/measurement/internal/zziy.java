package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;

final class zziy
  implements Runnable
{
  zziy(zzio paramzzio, Bundle paramBundle, zzn paramzzn) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzc);
    if (localzzej == null)
    {
      this.zzc.zzq().zze().zza("Failed to send default event parameters to service");
      return;
    }
    try
    {
      localzzej.zza(this.zza, this.zzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzc.zzq().zze().zza("Failed to send default event parameters to service", localRemoteException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zziy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */