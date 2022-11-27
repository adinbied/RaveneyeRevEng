package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzy
  extends zza
  implements zzw
{
  zzy(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  public final void zza(Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = a_();
    zzb.zza(localParcel, paramBundle);
    zzb(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */