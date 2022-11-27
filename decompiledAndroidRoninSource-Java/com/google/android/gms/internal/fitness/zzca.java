package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.zzg;
import com.google.android.gms.fitness.request.zzk;
import com.google.android.gms.fitness.request.zzw;

public final class zzca
  extends zza
  implements zzbz
{
  zzca(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
  }
  
  public final void zza(DataDeleteRequest paramDataDeleteRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataDeleteRequest);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }
  
  public final void zza(DataReadRequest paramDataReadRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataReadRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void zza(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataUpdateListenerRegistrationRequest);
    transactAndReadExceptionReturnVoid(10, localParcel);
  }
  
  public final void zza(DataUpdateRequest paramDataUpdateRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramDataUpdateRequest);
    transactAndReadExceptionReturnVoid(9, localParcel);
  }
  
  public final void zza(zzg paramzzg)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzg);
    transactAndReadExceptionReturnVoid(7, localParcel);
  }
  
  public final void zza(zzk paramzzk)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzk);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
  
  public final void zza(zzw paramzzw)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzw);
    transactAndReadExceptionReturnVoid(11, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzca.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */