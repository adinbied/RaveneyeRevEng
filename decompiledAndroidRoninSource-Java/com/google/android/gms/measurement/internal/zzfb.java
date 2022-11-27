package com.google.android.gms.measurement.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.android.gms.common.internal.Preconditions;

class zzfb
  extends BroadcastReceiver
{
  private static final String zza = zzfb.class.getName();
  private final zzki zzb;
  private boolean zzc;
  private boolean zzd;
  
  zzfb(zzki paramzzki)
  {
    Preconditions.checkNotNull(paramzzki);
    this.zzb = paramzzki;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    this.zzb.zzn();
    paramContext = paramIntent.getAction();
    this.zzb.zzq().zzw().zza("NetworkBroadcastReceiver received action", paramContext);
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(paramContext))
    {
      boolean bool = this.zzb.zzd().zze();
      if (this.zzd != bool)
      {
        this.zzd = bool;
        this.zzb.zzp().zza(new zzfa(this, bool));
      }
      return;
    }
    this.zzb.zzq().zzh().zza("NetworkBroadcastReceiver received unknown action", paramContext);
  }
  
  public final void zza()
  {
    this.zzb.zzn();
    this.zzb.zzp().zzc();
    if (this.zzc) {
      return;
    }
    this.zzb.zzm().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    this.zzd = this.zzb.zzd().zze();
    this.zzb.zzq().zzw().zza("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.zzd));
    this.zzc = true;
  }
  
  public final void zzb()
  {
    this.zzb.zzn();
    this.zzb.zzp().zzc();
    this.zzb.zzp().zzc();
    if (!this.zzc) {
      return;
    }
    this.zzb.zzq().zzw().zza("Unregistering connectivity change receiver");
    this.zzc = false;
    this.zzd = false;
    Context localContext = this.zzb.zzm();
    try
    {
      localContext.unregisterReceiver(this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.zzb.zzq().zze().zza("Failed to unregister the network broadcast receiver", localIllegalArgumentException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */