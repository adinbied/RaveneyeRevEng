package com.google.firebase.iid;

import android.os.IBinder;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzw
  implements zzx
{
  private final IBinder zza;
  
  zzw(IBinder paramIBinder)
  {
    this.zza = paramIBinder;
  }
  
  public final IBinder asBinder()
  {
    return this.zza;
  }
  
  public final void zza(Message paramMessage)
    throws RemoteException
  {
    Parcel localParcel = Parcel.obtain();
    localParcel.writeInterfaceToken("com.google.android.gms.iid.IMessengerCompat");
    localParcel.writeInt(1);
    paramMessage.writeToParcel(localParcel, 0);
    try
    {
      this.zza.transact(1, localParcel, null, 1);
      return;
    }
    finally
    {
      localParcel.recycle();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\iid\zzw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */