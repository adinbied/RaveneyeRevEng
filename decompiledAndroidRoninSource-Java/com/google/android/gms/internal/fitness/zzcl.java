package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

public abstract class zzcl
  extends zzb
  implements zzck
{
  public zzcl()
  {
    super("com.google.android.gms.fitness.internal.ISessionReadCallback");
  }
  
  public static zzck zzh(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.ISessionReadCallback");
    if ((localIInterface instanceof zzck)) {
      return (zzck)localIInterface;
    }
    return new zzcm(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((SessionReadResult)zzc.zza(paramParcel1, SessionReadResult.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzcl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */