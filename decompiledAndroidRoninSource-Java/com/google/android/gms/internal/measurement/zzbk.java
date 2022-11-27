package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzgw;
import java.util.List;

final class zzbk
  extends zzag.zzb
{
  zzbk(zzag paramzzag, zzgw paramzzgw)
  {
    super(paramzzag);
  }
  
  final void zza()
    throws RemoteException
  {
    int i = 0;
    while (i < zzag.zzd(this.zzd).size())
    {
      if (this.zzc.equals(((Pair)zzag.zzd(this.zzd).get(i)).first))
      {
        localPair = (Pair)zzag.zzd(this.zzd).get(i);
        break label76;
      }
      i += 1;
    }
    Pair localPair = null;
    label76:
    if (localPair == null)
    {
      Log.w(zzag.zzb(this.zzd), "OnEventListener had not been registered.");
      return;
    }
    zzag.zzc(this.zzd).unregisterOnMeasurementEventListener((zzab)localPair.second);
    zzag.zzd(this.zzd).remove(localPair);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */