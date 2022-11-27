package com.google.android.gms.internal.base;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public class zab
  extends Binder
  implements IInterface
{
  private static zad zac;
  
  protected zab(String paramString)
  {
    attachInterface(this, paramString);
  }
  
  public IBinder asBinder()
  {
    return this;
  }
  
  protected boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    return false;
  }
  
  public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    boolean bool;
    if (paramInt1 > 16777215)
    {
      bool = super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
    }
    else
    {
      paramParcel1.enforceInterface(getInterfaceDescriptor());
      bool = false;
    }
    if (bool) {
      return true;
    }
    return dispatchTransaction(paramInt1, paramParcel1, paramParcel2, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\base\zab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */