package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.SimpleClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class SimpleClientAdapter<T extends IInterface>
  extends GmsClient<T>
{
  private final Api.SimpleClient<T> zapg;
  
  public SimpleClientAdapter(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings, Api.SimpleClient<T> paramSimpleClient)
  {
    super(paramContext, paramLooper, paramInt, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
    this.zapg = paramSimpleClient;
  }
  
  protected T createServiceInterface(IBinder paramIBinder)
  {
    return this.zapg.createServiceInterface(paramIBinder);
  }
  
  public Api.SimpleClient<T> getClient()
  {
    return this.zapg;
  }
  
  public int getMinApkVersion()
  {
    return super.getMinApkVersion();
  }
  
  protected String getServiceDescriptor()
  {
    return this.zapg.getServiceDescriptor();
  }
  
  protected String getStartServiceAction()
  {
    return this.zapg.getStartServiceAction();
  }
  
  protected void onSetConnectState(int paramInt, T paramT)
  {
    this.zapg.setState(paramInt, paramT);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\SimpleClientAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */