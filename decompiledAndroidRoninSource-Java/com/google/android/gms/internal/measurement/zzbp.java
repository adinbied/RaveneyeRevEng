package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbp
  extends zzag.zzb
{
  zzbp(zzag.zzc paramzzc, Bundle paramBundle, Activity paramActivity)
  {
    super(paramzzc.zza);
  }
  
  final void zza()
    throws RemoteException
  {
    Bundle localBundle1;
    if (this.zzc != null)
    {
      Bundle localBundle2 = new Bundle();
      localBundle1 = localBundle2;
      if (this.zzc.containsKey("com.google.app_measurement.screen_service"))
      {
        Object localObject = this.zzc.get("com.google.app_measurement.screen_service");
        localBundle1 = localBundle2;
        if ((localObject instanceof Bundle))
        {
          localBundle2.putBundle("com.google.app_measurement.screen_service", (Bundle)localObject);
          localBundle1 = localBundle2;
        }
      }
    }
    else
    {
      localBundle1 = null;
    }
    zzag.zzc(this.zze.zza).onActivityCreated(ObjectWrapper.wrap(this.zzd), localBundle1, this.zzb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */