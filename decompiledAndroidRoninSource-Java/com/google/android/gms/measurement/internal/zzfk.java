package com.google.android.gms.measurement.internal;

import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.internal.measurement.zzna;

final class zzfk
  implements Runnable
{
  zzfk(zzfl paramzzfl, zzd paramzzd, ServiceConnection paramServiceConnection) {}
  
  public final void run()
  {
    zzfi localzzfi = this.zzc.zza;
    Object localObject1 = zzfl.zza(this.zzc);
    Object localObject2 = this.zza;
    ServiceConnection localServiceConnection = this.zzb;
    localObject2 = localzzfi.zza((String)localObject1, (zzd)localObject2);
    localzzfi.zza.zzp().zzc();
    if (localObject2 != null)
    {
      long l1 = ((Bundle)localObject2).getLong("install_begin_timestamp_seconds", 0L) * 1000L;
      if (l1 == 0L)
      {
        localzzfi.zza.zzq().zzh().zza("Service response is missing Install Referrer install timestamp");
      }
      else
      {
        localObject1 = ((Bundle)localObject2).getString("install_referrer");
        if ((localObject1 != null) && (!((String)localObject1).isEmpty()))
        {
          localzzfi.zza.zzq().zzw().zza("InstallReferrer API result", localObject1);
          Object localObject3 = localzzfi.zza.zzh();
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() != 0) {
            localObject1 = "?".concat((String)localObject1);
          } else {
            localObject1 = new String("?");
          }
          localObject1 = ((zzkw)localObject3).zza(Uri.parse((String)localObject1));
          if (localObject1 == null)
          {
            localzzfi.zza.zzq().zze().zza("No campaign params defined in Install Referrer result");
          }
          else
          {
            localObject3 = ((Bundle)localObject1).getString("medium");
            int i;
            if ((localObject3 != null) && (!"(not set)".equalsIgnoreCase((String)localObject3)) && (!"organic".equalsIgnoreCase((String)localObject3))) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              long l2 = ((Bundle)localObject2).getLong("referrer_click_timestamp_seconds", 0L) * 1000L;
              if (l2 == 0L) {
                localzzfi.zza.zzq().zze().zza("Install Referrer is missing click timestamp for ad campaign");
              } else {
                ((Bundle)localObject1).putLong("click_timestamp", l2);
              }
            }
            else if (l1 == localzzfi.zza.zzb().zzi.zza())
            {
              localzzfi.zza.zzq().zzw().zza("Install Referrer campaign has already been logged");
            }
            else if ((!zzna.zzb()) || (!localzzfi.zza.zza().zza(zzat.zzbs)) || (localzzfi.zza.zzaa()))
            {
              localzzfi.zza.zzb().zzi.zza(l1);
              localzzfi.zza.zzq().zzw().zza("Logging Install Referrer campaign from sdk with ", "referrer API");
              ((Bundle)localObject1).putString("_cis", "referrer API");
              localzzfi.zza.zzg().zza("auto", "_cmp", (Bundle)localObject1);
            }
          }
        }
        else
        {
          localzzfi.zza.zzq().zze().zza("No referrer defined in Install Referrer response");
        }
      }
    }
    if (localServiceConnection != null) {
      ConnectionTracker.getInstance().unbindService(localzzfi.zza.zzm(), localServiceConnection);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */