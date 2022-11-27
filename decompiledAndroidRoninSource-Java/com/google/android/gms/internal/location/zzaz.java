package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.api.internal.StatusCallback;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.ActivityTransitionRequest;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.zzal;
import javax.annotation.Nullable;

public final class zzaz
  extends zzk
{
  private final zzas zzde = new zzas(paramContext, this.zzcb);
  
  public zzaz(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString)
  {
    this(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, ClientSettings.createDefault(paramContext));
  }
  
  public zzaz(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, String paramString, @Nullable ClientSettings paramClientSettings)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, paramString, paramClientSettings);
  }
  
  public final void disconnect()
  {
    synchronized (this.zzde)
    {
      boolean bool = isConnected();
      if (bool) {
        try
        {
          this.zzde.removeAllListeners();
          this.zzde.zzb();
        }
        catch (Exception localException)
        {
          Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", localException);
        }
      }
      super.disconnect();
      return;
    }
  }
  
  public final Location getLastLocation()
    throws RemoteException
  {
    return this.zzde.getLastLocation();
  }
  
  public final LocationAvailability zza()
    throws RemoteException
  {
    return this.zzde.zza();
  }
  
  public final void zza(long paramLong, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    checkConnected();
    Preconditions.checkNotNull(paramPendingIntent);
    boolean bool;
    if (paramLong >= 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "detectionIntervalMillis must be >= 0");
    ((zzao)getService()).zza(paramLong, true, paramPendingIntent);
  }
  
  public final void zza(PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder)
    throws RemoteException
  {
    checkConnected();
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    paramResultHolder = new StatusCallback(paramResultHolder);
    ((zzao)getService()).zza(paramPendingIntent, paramResultHolder);
  }
  
  public final void zza(PendingIntent paramPendingIntent, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzde.zza(paramPendingIntent, paramzzaj);
  }
  
  public final void zza(Location paramLocation)
    throws RemoteException
  {
    this.zzde.zza(paramLocation);
  }
  
  public final void zza(ListenerHolder.ListenerKey<LocationListener> paramListenerKey, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzde.zza(paramListenerKey, paramzzaj);
  }
  
  public final void zza(zzaj paramzzaj)
    throws RemoteException
  {
    this.zzde.zza(paramzzaj);
  }
  
  public final void zza(zzbd paramzzbd, ListenerHolder<LocationCallback> paramListenerHolder, zzaj paramzzaj)
    throws RemoteException
  {
    synchronized (this.zzde)
    {
      this.zzde.zza(paramzzbd, paramListenerHolder, paramzzaj);
      return;
    }
  }
  
  public final void zza(ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder)
    throws RemoteException
  {
    checkConnected();
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    paramResultHolder = new StatusCallback(paramResultHolder);
    ((zzao)getService()).zza(paramActivityTransitionRequest, paramPendingIntent, paramResultHolder);
  }
  
  public final void zza(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, BaseImplementation.ResultHolder<Status> paramResultHolder)
    throws RemoteException
  {
    checkConnected();
    Preconditions.checkNotNull(paramGeofencingRequest, "geofencingRequest can't be null.");
    Preconditions.checkNotNull(paramPendingIntent, "PendingIntent must be specified.");
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    paramResultHolder = new zzba(paramResultHolder);
    ((zzao)getService()).zza(paramGeofencingRequest, paramPendingIntent, paramResultHolder);
  }
  
  public final void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzde.zza(paramLocationRequest, paramPendingIntent, paramzzaj);
  }
  
  public final void zza(LocationRequest paramLocationRequest, ListenerHolder<LocationListener> paramListenerHolder, zzaj paramzzaj)
    throws RemoteException
  {
    synchronized (this.zzde)
    {
      this.zzde.zza(paramLocationRequest, paramListenerHolder, paramzzaj);
      return;
    }
  }
  
  public final void zza(LocationSettingsRequest paramLocationSettingsRequest, BaseImplementation.ResultHolder<LocationSettingsResult> paramResultHolder, @Nullable String paramString)
    throws RemoteException
  {
    checkConnected();
    boolean bool2 = true;
    boolean bool1;
    if (paramLocationSettingsRequest != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "locationSettingsRequest can't be null nor empty.");
    if (paramResultHolder != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "listener can't be null.");
    paramResultHolder = new zzbc(paramResultHolder);
    ((zzao)getService()).zza(paramLocationSettingsRequest, paramResultHolder, paramString);
  }
  
  public final void zza(zzal paramzzal, BaseImplementation.ResultHolder<Status> paramResultHolder)
    throws RemoteException
  {
    checkConnected();
    Preconditions.checkNotNull(paramzzal, "removeGeofencingRequest can't be null.");
    Preconditions.checkNotNull(paramResultHolder, "ResultHolder not provided.");
    paramResultHolder = new zzbb(paramResultHolder);
    ((zzao)getService()).zza(paramzzal, paramResultHolder);
  }
  
  public final void zza(boolean paramBoolean)
    throws RemoteException
  {
    this.zzde.zza(paramBoolean);
  }
  
  public final void zzb(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    checkConnected();
    Preconditions.checkNotNull(paramPendingIntent);
    ((zzao)getService()).zzb(paramPendingIntent);
  }
  
  public final void zzb(ListenerHolder.ListenerKey<LocationCallback> paramListenerKey, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzde.zzb(paramListenerKey, paramzzaj);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzaz.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */