package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

public abstract class zzbf
  extends zzb
  implements zzbe
{
  public zzbf()
  {
    super("com.google.android.gms.fitness.internal.IDailyTotalCallback");
  }
  
  public static zzbe zzb(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.fitness.internal.IDailyTotalCallback");
    if ((localIInterface instanceof zzbe)) {
      return (zzbe)localIInterface;
    }
    return new zzbg(paramIBinder);
  }
  
  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    if (paramInt1 == 1)
    {
      zza((DailyTotalResult)zzc.zza(paramParcel1, DailyTotalResult.CREATOR));
      return true;
    }
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzbf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */