package com.google.android.gms.location;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;
import com.google.android.gms.internal.location.zzc;

public final class zzw
  extends zza
  implements zzu
{
  zzw(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.ILocationCallback");
  }
  
  public final void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramLocationAvailability);
    transactOneway(2, localParcel);
  }
  
  public final void onLocationResult(LocationResult paramLocationResult)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramLocationResult);
    transactOneway(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */