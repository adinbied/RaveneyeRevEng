package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

@Deprecated
public abstract class LegacyInternalGmsClient<T extends IInterface>
  extends GmsClient<T>
{
  private final GmsClientEventManager zags;
  
  public LegacyInternalGmsClient(Context paramContext, int paramInt, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramContext.getMainLooper(), paramInt, paramClientSettings);
    paramContext = new GmsClientEventManager(paramContext.getMainLooper(), this);
    this.zags = paramContext;
    paramContext.registerConnectionCallbacks(paramConnectionCallbacks);
    this.zags.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void checkAvailabilityAndConnect()
  {
    this.zags.enableCallbacks();
    super.checkAvailabilityAndConnect();
  }
  
  public void disconnect()
  {
    this.zags.disableCallbacks();
    super.disconnect();
  }
  
  public int getMinApkVersion()
  {
    return super.getMinApkVersion();
  }
  
  public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return this.zags.isConnectionCallbacksRegistered(paramConnectionCallbacks);
  }
  
  public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return this.zags.isConnectionFailedListenerRegistered(paramOnConnectionFailedListener);
  }
  
  public void onConnectedLocked(T paramT)
  {
    super.onConnectedLocked(paramT);
    this.zags.onConnectionSuccess(getConnectionHint());
  }
  
  public void onConnectionFailed(ConnectionResult paramConnectionResult)
  {
    super.onConnectionFailed(paramConnectionResult);
    this.zags.onConnectionFailure(paramConnectionResult);
  }
  
  public void onConnectionSuspended(int paramInt)
  {
    super.onConnectionSuspended(paramInt);
    this.zags.onUnintentionalDisconnection(paramInt);
  }
  
  public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zags.registerConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zags.registerConnectionFailedListener(paramOnConnectionFailedListener);
  }
  
  public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    this.zags.unregisterConnectionCallbacks(paramConnectionCallbacks);
  }
  
  public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    this.zags.unregisterConnectionFailedListener(paramOnConnectionFailedListener);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\LegacyInternalGmsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */