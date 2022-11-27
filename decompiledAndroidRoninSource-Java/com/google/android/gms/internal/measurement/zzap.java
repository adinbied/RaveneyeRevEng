package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

final class zzap
  extends zzag.zzb
{
  zzap(zzag paramzzag, Boolean paramBoolean)
  {
    super(paramzzag);
  }
  
  final void zza()
    throws RemoteException
  {
    if (this.zzc != null)
    {
      zzag.zzc(this.zzd).setMeasurementEnabled(this.zzc.booleanValue(), this.zza);
      return;
    }
    zzag.zzc(this.zzd).clearMeasurementEnabled(this.zza);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */