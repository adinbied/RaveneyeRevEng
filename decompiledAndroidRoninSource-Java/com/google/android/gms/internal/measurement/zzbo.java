package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzbo
  extends zzag.zzb
{
  zzbo(zzag.zzc paramzzc, Activity paramActivity)
  {
    super(paramzzc.zza);
  }
  
  final void zza()
    throws RemoteException
  {
    zzag.zzc(this.zzd.zza).onActivityStarted(ObjectWrapper.wrap(this.zzc), this.zzb);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzbo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */