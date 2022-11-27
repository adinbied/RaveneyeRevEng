package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public abstract class zzcr
  extends zzb
  implements zzcq
{
  public zzcr()
  {
    super("com.google.android.gms.fitness.internal.IStatusCallback");
  }
  
  public static zzcq zzj(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IStatusCallback");
    if ((localIInterface instanceof zzcq)) {
      return (zzcq)localIInterface;
    }
    return new zzcs(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      onResult((Status)zzc.zza(paramParcel1, Status.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzcr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */