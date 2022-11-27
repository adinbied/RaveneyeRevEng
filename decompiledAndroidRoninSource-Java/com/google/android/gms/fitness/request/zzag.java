package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zza;
import com.google.android.gms.internal.fitness.zzc;

public final class zzag
  extends zza
  implements zzae
{
  zzag(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.request.IBleScanCallback");
  }
  
  public final void onDeviceFound(BleDevice paramBleDevice)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramBleDevice);
    transactOneway(1, localParcel);
  }
  
  public final void onScanStopped()
    throws RemoteException
  {
    transactOneway(2, obtainAndWriteInterfaceToken());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */