package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DataReadResult;

public abstract class zzbi
  extends zzb
  implements zzbh
{
  public zzbi()
  {
    super("com.google.android.gms.fitness.internal.IDataReadCallback");
  }
  
  public static zzbh zzc(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDataReadCallback");
    if ((localIInterface instanceof zzbh)) {
      return (zzbh)localIInterface;
    }
    return new zzbj(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((DataReadResult)zzc.zza(paramParcel1, DataReadResult.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzbi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */