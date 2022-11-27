package com.google.android.gms.internal.fitness;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.GoalsResult;

public final class zzbs
  extends zza
  implements zzbq
{
  zzbs(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.fitness.internal.IGoalsReadCallback");
  }
  
  public final void zza(GoalsResult paramGoalsResult)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramGoalsResult);
    transactOneway(1, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzbs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */