package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.internal.measurement.zzg;

public final class zzfl
  implements ServiceConnection
{
  private final String zzb;
  
  zzfl(zzfi paramzzfi, String paramString)
  {
    this.zzb = paramString;
  }
  
  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    if (paramIBinder == null)
    {
      this.zza.zza.zzq().zzh().zza("Install Referrer connection returned with null binder");
      return;
    }
    try
    {
      paramComponentName = zzg.zza(paramIBinder);
      if (paramComponentName == null)
      {
        this.zza.zza.zzq().zzh().zza("Install Referrer Service implementation was not found");
        return;
      }
      this.zza.zza.zzq().zzw().zza("Install Referrer Service connected");
      this.zza.zza.zzp().zza(new zzfk(this, paramComponentName, this));
      return;
    }
    catch (Exception paramComponentName)
    {
      this.zza.zza.zzq().zzh().zza("Exception occurred while calling Install Referrer API", paramComponentName);
    }
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.zza.zza.zzq().zzw().zza("Install Referrer Service disconnected");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzfl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */