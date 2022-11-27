package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.location.zzaf;
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zzbk;
import com.google.android.gms.internal.location.zzq;

public class LocationServices
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  private static final Api.AbstractClientBuilder<zzaz, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzaz> CLIENT_KEY = new Api.ClientKey();
  @Deprecated
  public static final FusedLocationProviderApi FusedLocationApi = new zzq();
  @Deprecated
  public static final GeofencingApi GeofencingApi = new zzaf();
  @Deprecated
  public static final SettingsApi SettingsApi = new zzbk();
  
  static
  {
    zzad localzzad = new zzad();
    CLIENT_BUILDER = localzzad;
    API = new Api("LocationServices.API", localzzad, CLIENT_KEY);
  }
  
  public static FusedLocationProviderClient getFusedLocationProviderClient(Activity paramActivity)
  {
    return new FusedLocationProviderClient(paramActivity);
  }
  
  public static FusedLocationProviderClient getFusedLocationProviderClient(Context paramContext)
  {
    return new FusedLocationProviderClient(paramContext);
  }
  
  public static GeofencingClient getGeofencingClient(Activity paramActivity)
  {
    return new GeofencingClient(paramActivity);
  }
  
  public static GeofencingClient getGeofencingClient(Context paramContext)
  {
    return new GeofencingClient(paramContext);
  }
  
  public static SettingsClient getSettingsClient(Activity paramActivity)
  {
    return new SettingsClient(paramActivity);
  }
  
  public static SettingsClient getSettingsClient(Context paramContext)
  {
    return new SettingsClient(paramContext);
  }
  
  public static zzaz zza(GoogleApiClient paramGoogleApiClient)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramGoogleApiClient != null) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1, "GoogleApiClient parameter is required.");
    paramGoogleApiClient = (zzaz)paramGoogleApiClient.getClient(CLIENT_KEY);
    if (paramGoogleApiClient != null) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "GoogleApiClient is not configured to use the LocationServices.API Api. Pass thisinto GoogleApiClient.Builder#addApi() to use this feature.");
    return paramGoogleApiClient;
  }
  
  public static abstract class zza<R extends Result>
    extends BaseImplementation.ApiMethodImpl<R, zzaz>
  {
    public zza(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\LocationServices.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */