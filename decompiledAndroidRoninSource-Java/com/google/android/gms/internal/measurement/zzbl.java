package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.measurement.internal.zzgw;
import java.util.List;

final class zzbl
  extends zzag.zzb
{
  zzbl(zzag paramzzag, zzgw paramzzgw)
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
        Log.w(zzag.zzb(this.zzd), "OnEventListener already registered.");
        return;
      }
      i += 1;
    }
    zzag.zzd localzzd = new zzag.zzd(this.zzc);
    zzag.zzd(this.zzd).add(new Pair(this.zzc, localzzd));
    zzag.zzc(this.zzd).registerOnMeasurementEventListener(localzzd);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */