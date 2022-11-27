package com.google.android.gms.measurement;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzfm;
import com.google.android.gms.measurement.internal.zzfn;

public final class AppMeasurementReceiver
  extends WakefulBroadcastReceiver
  implements zzfm
{
  private zzfn zza;
  
  public final BroadcastReceiver.PendingResult doGoAsync()
  {
    return goAsync();
  }
  
  public final void doStartService(Context paramContext, Intent paramIntent)
  {
    startWakefulService(paramContext, paramIntent);
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    if (this.zza == null) {
      this.zza = new zzfn(this);
    }
    this.zza.zza(paramContext, paramIntent);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\AppMeasurementReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */