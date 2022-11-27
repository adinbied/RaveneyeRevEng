package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.internal.fitness.zzb;
import com.google.android.gms.internal.fitness.zzc;

public abstract class zzaf
  extends zzb
  implements zzae
{
  public zzaf()
  {
    super("com.google.android.gms.fitness.request.IBleScanCallback");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      onScanStopped();
      return true;
    }
    onDeviceFound((BleDevice)zzc.zza(paramParcel1, BleDevice.CREATOR));
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\request\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */