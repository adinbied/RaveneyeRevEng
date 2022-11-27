package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.location.zza;
import com.google.android.gms.internal.location.zzc;

public final class zzz
  extends zza
  implements zzx
{
  zzz(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.ILocationListener");
  }
  
  public final void onLocationChanged(Location paramLocation)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramLocation);
    transactOneway(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */