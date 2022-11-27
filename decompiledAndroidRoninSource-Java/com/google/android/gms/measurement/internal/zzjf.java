package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;

final class zzjf
  implements Runnable
{
  zzjf(zzio paramzzio, boolean paramBoolean1, boolean paramBoolean2, zzar paramzzar, zzn paramzzn, String paramString) {}
  
  public final void run()
  {
    zzej localzzej = zzio.zzd(this.zzf);
    if (localzzej == null)
    {
      this.zzf.zzq().zze().zza("Discarding data. Failed to send event to service");
      return;
    }
    if (this.zza)
    {
      zzio localzzio = this.zzf;
      zzar localzzar;
      if (this.zzb) {
        localzzar = null;
      } else {
        localzzar = this.zzc;
      }
      localzzio.zza(localzzej, localzzar, this.zzd);
    }
    else
    {
      try
      {
        if (TextUtils.isEmpty(this.zze)) {
          localzzej.zza(this.zzc, this.zzd);
        } else {
          localzzej.zza(this.zzc, this.zze, this.zzf.zzq().zzx());
        }
      }
      catch (RemoteException localRemoteException)
      {
        this.zzf.zzq().zze().zza("Failed to send event to the service", localRemoteException);
      }
    }
    zzio.zze(this.zzf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */