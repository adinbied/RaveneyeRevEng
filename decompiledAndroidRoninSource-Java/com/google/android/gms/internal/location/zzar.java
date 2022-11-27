package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzar
  extends zzb
  implements zzaq
{
  public zzar()
  {
    super("com.google.android.gms.location.internal.ISettingsCallbacks");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((LocationSettingsResult)zzc.zza(paramParcel1, LocationSettingsResult.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzar.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */