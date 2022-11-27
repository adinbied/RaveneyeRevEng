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
import com.google.android.gms.internal.location.zzaz;
import com.google.android.gms.internal.location.zze;

public class ActivityRecognition
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  @Deprecated
  public static final ActivityRecognitionApi ActivityRecognitionApi = new zze();
  private static final Api.AbstractClientBuilder<zzaz, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zzaz> CLIENT_KEY = new Api.ClientKey();
  public static final String CLIENT_NAME = "activity_recognition";
  
  static
  {
    zza localzza = new zza();
    CLIENT_BUILDER = localzza;
    API = new Api("ActivityRecognition.API", localzza, CLIENT_KEY);
  }
  
  public static ActivityRecognitionClient getClient(Activity paramActivity)
  {
    return new ActivityRecognitionClient(paramActivity);
  }
  
  public static ActivityRecognitionClient getClient(Context paramContext)
  {
    return new ActivityRecognitionClient(paramContext);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\ActivityRecognition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */