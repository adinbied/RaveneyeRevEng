package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public abstract class zzci
  extends zzb
  implements zzch
{
  public zzci()
  {
    super("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
  }
  
  public static zzch zzg(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
    if ((localIInterface instanceof zzch)) {
      return (zzch)localIInterface;
    }
    return new zzcj(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((ListSubscriptionsResult)zzc.zza(paramParcel1, ListSubscriptionsResult.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzci.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */