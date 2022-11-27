package com.google.android.gms.fitness.request;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

public abstract interface zzae
  extends IInterface
{
  public abstract void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException;
  
  public abstract void onScanStopped()
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */