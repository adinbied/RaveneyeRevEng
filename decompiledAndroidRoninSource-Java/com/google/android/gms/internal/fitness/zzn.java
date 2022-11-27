package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.fitness.zzg;
import java.util.Set;

public abstract class zzn<T extends IInterface>
  extends GmsClient<T>
{
  protected zzn(Context paramContext, Looper paramLooper, int paramInt, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener, ClientSettings paramClientSettings)
  {
    super(paramContext, paramLooper, paramInt, paramClientSettings, paramConnectionCallbacks, paramOnConnectionFailedListener);
  }
  
  public abstract T createServiceInterface(IBinder paramIBinder);
  
  public int getMinApkVersion()
  {
    return 12451000;
  }
  
  public abstract String getServiceDescriptor();
  
  public abstract String getStartServiceAction();
  
  public boolean requiresAccount()
  {
    return true;
  }
  
  public boolean requiresSignIn()
  {
    return !DeviceProperties.isWearable(getContext());
  }
  
  protected Set<Scope> validateScopes(Set<Scope> paramSet)
  {
    return zzg.zza(paramSet);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */