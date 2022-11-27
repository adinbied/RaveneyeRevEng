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

public final class zzag
  extends zzn<zzbz>
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Fitness.API", new zzai(null), CLIENT_KEY);
  private static final Api.ClientKey<zzag> CLIENT_KEY = new Api.ClientKey();
  public static final Api<FitnessOptions> zzew = new Api("Fitness.CLIENT", new zzak(null), CLIENT_KEY);
  
  private zzag(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 57, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitHistoryApi";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.fitness.HistoryApi";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */