package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

public final class zzg
  extends zza
  implements zze
{
  zzg(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
  }
  
  public final String getId()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(1, obtainAndWriteInterfaceToken());
    String str = localParcel.readString();
    localParcel.recycle();
    return str;
  }
  
  public final boolean zzb(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, true);
    localParcel = transactAndReadException(2, localParcel);
    paramBoolean = zzc.zza(localParcel);
    localParcel.recycle();
    return paramBoolean;
  }
  
  public final boolean zzc()
    throws RemoteException
  {
    Parcel localParcel = transactAndReadException(6, obtainAndWriteInterfaceToken());
    boolean bool = zzc.zza(localParcel);
    localParcel.recycle();
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\ads_identifier\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */