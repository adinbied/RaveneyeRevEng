package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.zzah;
import com.google.android.gms.fitness.request.zzbh;
import com.google.android.gms.fitness.request.zzbl;
import com.google.android.gms.fitness.request.zze;

public final class zzbu
  extends zza
  implements zzbt
{
  zzbu(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitBleApi");
  }
  
  public final void zza(StartBleScanRequest paramStartBleScanRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramStartBleScanRequest);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void zza(zzah paramzzah)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzah);
    transactAndReadExceptionReturnVoid(5, localParcel);
  }
  
  public final void zza(zzbh paramzzbh)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbh);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
  
  public final void zza(zzbl paramzzbl)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbl);
    transactAndReadExceptionReturnVoid(4, localParcel);
  }
  
  public final void zza(zze paramzze)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzze);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzbu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */