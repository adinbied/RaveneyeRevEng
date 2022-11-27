package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class zzz
  extends zzc
  implements zzw
{
  public zzz()
  {
    super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((Bundle)zzb.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */