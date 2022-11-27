package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzjh
  implements Runnable
{
  zzjh(zzio paramzzio, AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, zzn paramzzn) {}
  
  public final void run()
  {
    try
    {
      synchronized (this.zza)
      {
        zzej localzzej = zzio.zzd(this.zzf);
        if (localzzej == null)
        {
          this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; not connected to service", zzer.zza(this.zzb), this.zzc, this.zzd);
          this.zza.set(Collections.emptyList());
        }
        try
        {
          this.zza.notify();
          return;
        }
        finally {}
        if (TextUtils.isEmpty(this.zzb)) {
          this.zza.set(localzzej.zza(this.zzc, this.zzd, this.zze));
        } else {
          this.zza.set(localzzej.zza(this.zzb, this.zzc, this.zzd));
        }
        zzio.zze(this.zzf);
        this.zza.notify();
      }
      this.zza.notify();
    }
    catch (RemoteException localRemoteException)
    {
      this.zzf.zzq().zze().zza("(legacy) Failed to get conditional properties; remote exception", zzer.zza(this.zzb), this.zzc, localRemoteException);
      this.zza.set(Collections.emptyList());
      this.zza.notify();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjh.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */