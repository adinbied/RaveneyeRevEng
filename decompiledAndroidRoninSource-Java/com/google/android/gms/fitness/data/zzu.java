package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fitness.zzb;
import com.google.android.gms.internal.fitness.zzc;

public abstract class zzu
  extends zzb
  implements zzt
{
  public zzu()
  {
    super("com.google.android.gms.fitness.data.IDataSourceListener");
  }
  
  public static zzt zza(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.data.IDataSourceListener");
    if ((localIInterface instanceof zzt)) {
      return (zzt)localIInterface;
    }
    return new zzv(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zzc((DataPoint)zzc.zza(paramParcel1, DataPoint.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\zzu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */