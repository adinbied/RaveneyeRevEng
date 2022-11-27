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

public final class zzab
  extends zzn<zzbx>
{
  public static final Api<Api.ApiOptions.NoOptions> API = new Api("Fitness.GOALS_API", new zzad(null), CLIENT_KEY);
  private static final Api.ClientKey<zzab> CLIENT_KEY = new Api.ClientKey();
  public static final Api<FitnessOptions> zzew = new Api("Fitness.GOALS_CLIENT", new zzaf(null), CLIENT_KEY);
  
  private zzab(Context paramContext, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, 125, paramConnectionCallbacks, paramOnConnectionFailedListener, paramClientSettings);
  }
  
  public final int getMinApkVersion()
  {
    return 12451000;
  }
  
  public final String getServiceDescriptor()
  {
    return "com.google.android.gms.fitness.internal.IGoogleFitGoalsApi";
  }
  
  public final String getStartServiceAction()
  {
    return "com.google.android.gms.fitness.GoalsApi";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */