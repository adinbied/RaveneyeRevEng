package com.google.android.gms.internal.fitness;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.request.zzg;
import com.google.android.gms.fitness.request.zzk;
import com.google.android.gms.fitness.request.zzw;

public abstract interface zzbz
  extends IInterface
{
  public abstract void zza(DataDeleteRequest paramDataDeleteRequest)
    throws RemoteException;
  
  public abstract void zza(DataReadRequest paramDataReadRequest)
    throws RemoteException;
  
  public abstract void zza(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
    throws RemoteException;
  
  public abstract void zza(DataUpdateRequest paramDataUpdateRequest)
    throws RemoteException;
  
  public abstract void zza(zzg paramzzg)
    throws RemoteException;
  
  public abstract void zza(zzk paramzzk)
    throws RemoteException;
  
  public abstract void zza(zzw paramzzw)
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzbz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */