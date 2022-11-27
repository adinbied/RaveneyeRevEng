package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.zzao;
import com.google.android.gms.fitness.request.zzar;

public final class zzce
  extends zza
  implements zzcd
{
  zzce(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
  }
  
  public final void zza(DataSourcesRequest paramDataSourcesRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataSourcesRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void zza(zzao paramzzao)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzao);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
  
  public final void zza(zzar paramzzar)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzar);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzce.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */