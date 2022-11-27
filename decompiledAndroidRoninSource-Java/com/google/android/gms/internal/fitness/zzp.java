package com.google.android.gms.internal.fitness;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.fitness.FitnessOptions;

public final class zzp
  extends zzn<zzbt>
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Fitness.BLE_API", new zzr(), CLIENT_KEY);
  private static final Api.ClientKey<zzp> CLIENT_KEY = new Api.ClientKey();
  public static final Api<FitnessOptions> zzew = new Api("Fitness.BLE_CLIENT", new zzt(null), CLIENT_KEY);
  
  private zzp(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 59, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitBleApi";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.fitness.BleApi";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */