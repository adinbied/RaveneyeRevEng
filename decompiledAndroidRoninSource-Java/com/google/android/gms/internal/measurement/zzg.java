package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;

public abstract class zzg
  extends zzc
  implements zzd
{
  public static zzd zza(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    if ((localIInterface instanceof zzd)) {
      return (zzd)localIInterface;
    }
    return new zzf(paramIBinder);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */