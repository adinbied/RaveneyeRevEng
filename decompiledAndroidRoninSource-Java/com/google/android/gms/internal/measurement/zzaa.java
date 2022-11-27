package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzaa
  extends zzc
  implements zzab
{
  public zzaa()
  {
    super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2) {
        return false;
      }
      paramInt1 = zza();
      paramParcel2.writeNoException();
      paramParcel2.writeInt(paramInt1);
      return true;
    }
    zza(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzb.zza(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */