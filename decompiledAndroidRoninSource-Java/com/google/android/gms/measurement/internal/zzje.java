package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzje
  implements Runnable
{
  zzje(zzio paramzzio, boolean paramBoolean1, boolean paramBoolean2, zzw paramzzw1, zzn paramzzn, zzw paramzzw2) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzf);
    if (localzzej == null)
    {
      this.zzf.zzq().zze().zza("Discarding data. Failed to send conditional user property to service");
      return;
    }
    if (this.zza)
    {
      zzio localzzio = this.zzf;
      zzw localzzw;
      if (this.zzb) {
        localzzw = null;
      } else {
        localzzw = this.zzc;
      }
      localzzio.zza(localzzej, localzzw, this.zzd);
    }
    else
    {
      try
      {
        if (TextUtils.isEmpty(this.zze.zza)) {
          localzzej.zza(this.zzc, this.zzd);
        } else {
          localzzej.zza(this.zzc);
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.zzf.zzq().zze().zza("Failed to send conditional user property to the service", localRemoteException);
      }
    }
    zzio.zze(this.zzf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzje.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */