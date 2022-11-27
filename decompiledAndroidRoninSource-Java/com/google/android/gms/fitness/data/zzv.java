package com.google.android.gms.fitness.data;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.fitness.zza;
import com.google.android.gms.internal.fitness.zzc;

public final class zzv
  extends zza
  implements zzt
{
  zzv(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.data.IDataSourceListener");
  }
  
  public final void zzc(DataPoint paramDataPoint)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataPoint);
    transactOneway(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\zzv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */