package com.google.android.gms.internal.fitness;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.service.FitnessSensorServiceRequest;

public abstract class zzez
  extends zzb
  implements zzey
{
  public zzez()
  {
    super("com.google.android.gms.fitness.internal.service.IFitnessSensorService");
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 3) {
          return false;
        }
        zza((zzew)zzc.zza(paramParcel1, zzew.CREATOR), zzcr.zzj(paramParcel1.readStrongBinder()));
        return true;
      }
      zza((FitnessSensorServiceRequest)zzc.zza(paramParcel1, FitnessSensorServiceRequest.CREATOR), zzcr.zzj(paramParcel1.readStrongBinder()));
      return true;
    }
    zza((zzeu)zzc.zza(paramParcel1, zzeu.CREATOR), zzbl.zzd(paramParcel1.readStrongBinder()));
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzez.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */