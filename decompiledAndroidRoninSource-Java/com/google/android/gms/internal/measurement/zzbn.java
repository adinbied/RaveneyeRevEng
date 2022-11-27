package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.RemoteException;

final class zzbn
  extends zzag.zzb
{
  zzbn(zzag paramzzag, Long paramLong, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramzzag);
  }
  
  final void zza()
    throws RemoteException
  {
    Long localLong = this.zzc;
    long l;
    if (localLong == null) {
      l = this.zza;
    } else {
      l = localLong.longValue();
    }
    zzag.zzc(this.zzi).logEvent(this.zzd, this.zze, this.zzf, this.zzg, this.zzh, l);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */