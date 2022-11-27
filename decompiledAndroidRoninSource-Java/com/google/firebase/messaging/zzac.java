package com.google.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

final class zzac
  extends BroadcastReceiver
{
  private zzad zzb;
  
  public zzac(zzad paramzzad1, zzad paramzzad2)
  {
    this.zzb = paramzzad2;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    try
    {
      paramIntent = this.zzb;
      if (paramIntent == null) {
        return;
      }
      boolean bool = zzad.zza(this.zzb);
      if (!bool) {
        return;
      }
      if (zzad.zza()) {
        Log.d("FirebaseMessaging", "Connectivity changed. Starting background sync.");
      }
      zzad.zzb(this.zzb).zza(this.zzb, 0L);
      paramContext.unregisterReceiver(this);
      this.zzb = null;
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\messaging\zzac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */