package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.zzaj;
import com.google.android.gms.fitness.request.zzbj;
import com.google.android.gms.fitness.request.zzbn;

public final class zzcc
  extends zza
  implements zzcb
{
  zzcc(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
  }
  
  public final void zza(zzaj paramzzaj)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzaj);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }
  
  public final void zza(zzbj paramzzbj)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbj);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void zza(zzbn paramzzbn)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbn);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzcc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */