package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.request.zzax;
import com.google.android.gms.fitness.request.zzaz;
import com.google.android.gms.fitness.request.zzbb;
import com.google.android.gms.fitness.request.zzbd;

public final class zzcg
  extends zza
  implements zzcf
{
  zzcg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoogleFitSessionsApi");
  }
  
  public final void zza(SessionInsertRequest paramSessionInsertRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramSessionInsertRequest);
    transactAndReadExceptionReturnVoid(3, localParcel);
  }
  
  public final void zza(SessionReadRequest paramSessionReadRequest)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramSessionReadRequest);
    transactAndReadExceptionReturnVoid(4, localParcel);
  }
  
  public final void zza(zzax paramzzax)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzax);
    transactAndReadExceptionReturnVoid(5, localParcel);
  }
  
  public final void zza(zzaz paramzzaz)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzaz);
    transactAndReadExceptionReturnVoid(1, localParcel);
  }
  
  public final void zza(zzbb paramzzbb)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbb);
    transactAndReadExceptionReturnVoid(2, localParcel);
  }
  
  public final void zza(zzbd paramzzbd)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbd);
    transactAndReadExceptionReturnVoid(6, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzcg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */