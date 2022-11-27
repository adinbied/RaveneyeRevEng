package com.google.android.gms.location;

import android.os.IInterface;
import android.os.RemoteException;

public abstract interface zzu
  extends IInterface
{
  public abstract void onLocationAvailability(LocationAvailability paramLocationAvailability)
    throws RemoteException;
  
  public abstract void onLocationResult(LocationResult paramLocationResult)
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */