package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.zzaa;
import com.google.android.gms.fitness.request.zzs;

public final class zzbw
  extends zza
  implements zzbv
{
  zzbw(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
  }
  
  public final void zza(DataTypeCreateRequest paramDataTypeCreateRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataTypeCreateRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void zza(zzaa paramzzaa)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzaa);
    transactAndReadExceptionReturnVoid(22, localParcel);
  }
  
  public final void zza(zzs paramzzs)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzs);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzbw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */