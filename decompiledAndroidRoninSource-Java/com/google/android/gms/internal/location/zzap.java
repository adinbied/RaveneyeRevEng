package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.zzal;

public final class zzap
  extends zza
  implements zzao
{
  zzap(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
  }
  
  public final Location zza(String paramString)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    ((Parcel)localObject).writeString(paramString);
    paramString = transactAndReadException(21, (Parcel)localObject);
    localObject = (Location)zzc.zza(paramString, Location.CREATOR);
    paramString.recycle();
    return (Location)localObject;
  }
  
  public final void zza(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    localParcel.writeLong(paramLong);
    zzc.zza(localParcel, true);
    zzc.zza(localParcel, paramPendingIntent);
    transactAndReadExceptionReturnVoid(5, localParcel);
  }
  
  public final void zza(PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramPendingIntent);
    zzc.zza(localParcel, paramIStatusCallback);
    transactAndReadExceptionReturnVoid(73, localParcel);
  }
  
  public final void zza(Location paramLocation)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramLocation);
    transactAndReadExceptionReturnVoid(13, localParcel);
  }
  
  public final void zza(zzaj paramzzaj)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzaj);
    transactAndReadExceptionReturnVoid(67, localParcel);
  }
  
  public final void zza(zzbf paramzzbf)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzbf);
    transactAndReadExceptionReturnVoid(59, localParcel);
  }
  
  public final void zza(zzo paramzzo)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzo);
    transactAndReadExceptionReturnVoid(75, localParcel);
  }
  
  public final void zza(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent, IStatusCallback paramIStatusCallback)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramActivityTransitionRequest);
    zzc.zza(localParcel, paramPendingIntent);
    zzc.zza(localParcel, paramIStatusCallback);
    transactAndReadExceptionReturnVoid(72, localParcel);
  }
  
  public final void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, zzam paramzzam)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramGeofencingRequest);
    zzc.zza(localParcel, paramPendingIntent);
    zzc.zza(localParcel, paramzzam);
    transactAndReadExceptionReturnVoid(57, localParcel);
  }
  
  public final void zza(LocationSettingsRequest paramLocationSettingsRequest, zzaq paramzzaq, String paramString)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramLocationSettingsRequest);
    zzc.zza(localParcel, paramzzaq);
    localParcel.writeString(paramString);
    transactAndReadExceptionReturnVoid(63, localParcel);
  }
  
  public final void zza(zzal paramzzal, zzam paramzzam)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramzzal);
    zzc.zza(localParcel, paramzzam);
    transactAndReadExceptionReturnVoid(74, localParcel);
  }
  
  public final void zza(boolean paramBoolean)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramBoolean);
    transactAndReadExceptionReturnVoid(12, localParcel);
  }
  
  public final LocationAvailability zzb(String paramString)
    throws RemoteException
  {
    Object localObject = obtainAndWriteInterfaceToken();
    ((Parcel)localObject).writeString(paramString);
    paramString = transactAndReadException(34, (Parcel)localObject);
    localObject = (LocationAvailability)zzc.zza(paramString, LocationAvailability.CREATOR);
    paramString.recycle();
    return (LocationAvailability)localObject;
  }
  
  public final void zzb(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    Parcel localParcel = obtainAndWriteInterfaceToken();
    zzc.zza(localParcel, paramPendingIntent);
    transactAndReadExceptionReturnVoid(6, localParcel);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */