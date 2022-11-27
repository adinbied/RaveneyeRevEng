package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzf
  extends zza
  implements zzd
{
  zzf(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
  }
  
  public final Bundle zza(Bundle paramBundle)
    throws RemoteException
  {
    Object localObject = a_();
    zzb.zza((Parcel)localObject, paramBundle);
    paramBundle = zza(1, (Parcel)localObject);
    localObject = (Bundle)zzb.zza(paramBundle, Bundle.CREATOR);
    paramBundle.recycle();
    return (Bundle)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */