package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import com.google.android.gms.measurement.internal.zzgx;

final class zzbc
  extends zzag.zzb
{
  zzbc(zzag paramzzag, zzgx paramzzgx)
  {
    super(paramzzag);
  }
  
  final void zza()
    throws RemoteException
  {
    zzag.zzc(this.zzd).setEventInterceptor(new zzag.zza(this.zzc));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */