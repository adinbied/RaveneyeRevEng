package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

final class zzjj
  implements Runnable
{
  zzjj(zzio paramzzio, AtomicReference paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean, zzn paramzzn) {}
  
  public final void run()
  {
    try
    {
      synchronized (this.zza)
      {
        zzej localzzej = zzio.zzd(this.zzg);
        if (localzzej == null)
        {
          this.zzg.zzq().zze().zza("(legacy) Failed to get user properties; not connected to service", zzer.zza(this.zzb), this.zzc, this.zzd);
          this.zza.set(Collections.emptyList());
        }
        try
        {
          this.zza.notify();
          return;
        }
        finally {}
        if (TextUtils.isEmpty(this.zzb)) {
          this.zza.set(localzzej.zza(this.zzc, this.zzd, this.zze, this.zzf));
        } else {
          this.zza.set(localzzej.zza(this.zzb, this.zzc, this.zzd, this.zze));
        }
        zzio.zze(this.zzg);
        this.zza.notify();
      }
      this.zza.notify();
    }
    catch (RemoteException localRemoteException)
    {
      this.zzg.zzq().zze().zza("(legacy) Failed to get user properties; remote exception", zzer.zza(this.zzb), this.zzc, localRemoteException);
      this.zza.set(Collections.emptyList());
      this.zza.notify();
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzjj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */