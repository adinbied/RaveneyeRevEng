package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.RemoteException;

final class zziz
  implements Runnable
{
  zziz(zzio paramzzio, zzig paramzzig) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzb);
    if (localzzej == null)
    {
      this.zzb.zzq().zze().zza("Failed to send current screen to service");
      return;
    }
    try
    {
      if (this.zza == null) {
        localzzej.zza(0L, null, null, this.zzb.zzm().getPackageName());
      } else {
        localzzej.zza(this.zza.zzc, this.zza.zza, this.zza.zzb, this.zzb.zzm().getPackageName());
      }
      zzio.zze(this.zzb);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      this.zzb.zzq().zze().zza("Failed to send current screen to the service", localRemoteException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zziz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */