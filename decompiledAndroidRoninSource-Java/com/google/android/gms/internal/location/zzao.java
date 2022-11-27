package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

public abstract interface zzao
  extends IInterface
{
  public abstract Location zza(String paramString)
    throws RemoteException;
  
  public abstract void zza(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void zza(PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback)
    throws RemoteException;
  
  public abstract void zza(Location paramLocation)
    throws RemoteException;
  
  public abstract void zza(zzaj paramzzaj)
    throws RemoteException;
  
  public abstract void zza(zzbf paramzzbf)
    throws RemoteException;
  
  public abstract void zza(zzo paramzzo)
    throws RemoteException;
  
  public abstract void zza(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback)
    throws RemoteException;
  
  public abstract void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzam paramzzam)
    throws RemoteException;
  
  public abstract void zza(LocationSettingsRequest paramLocationSettingsRequest, zzaq paramzzaq, String paramString)
    throws RemoteException;
  
  public abstract void zza(zzal paramzzal, zzam paramzzam)
    throws RemoteException;
  
  public abstract void zza(boolean paramBoolean)
    throws RemoteException;
  
  public abstract LocationAvailability zzb(String paramString)
    throws RemoteException;
  
  public abstract void zzb(PendingIntent paramPendingIntent)
    throws RemoteException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */