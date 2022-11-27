package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzad
  extends zza
  implements zzab
{
  zzad(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  public final int zza()
    throws RemoteException
  {
    Parcel localParcel = zza(2, a_());
    int i = localParcel.readInt();
    localParcel.recycle();
    return i;
  }
  
  public final void zza(String paramString1, String paramString2, Bundle paramBundle, long paramLong)
    throws RemoteException
  {
    Parcel localParcel = a_();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzb.zza(localParcel, paramBundle);
    localParcel.writeLong(paramLong);
    zzb(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */