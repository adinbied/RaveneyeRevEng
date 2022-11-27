package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import javax.annotation.Nullable;

final class zzba
  extends BroadcastReceiver
{
  @Nullable
  private zzbb zza;
  
  public zzba(zzbb paramzzbb)
  {
    this.zza = paramzzbb;
  }
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = this.zza;
    if (paramContext == null) {
      return;
    }
    if (!paramContext.zzb()) {
      return;
    }
    if (FirebaseInstanceId.zzd()) {
      Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
    }
    FirebaseInstanceId.zza(this.zza, 0L);
    this.zza.zza().unregisterReceiver(this);
    this.zza = null;
  }
  
  public final void zza()
  {
    if (FirebaseInstanceId.zzd()) {
      Log.d("FirebaseInstanceId", "Connectivity change received registered");
    }
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.zza.zza().registerReceiver(this, localIntentFilter);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */