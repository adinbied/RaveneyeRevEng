package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;

public class SettingsClient
  extends GoogleApi<Api.ApiOptions.NoOptions>
{
  public SettingsClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new ApiExceptionMapper());
  }
  
  public SettingsClient(Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new ApiExceptionMapper());
  }
  
  public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest paramLocationSettingsRequest)
  {
    return PendingResultUtil.toResponseTask(LocationServices.SettingsApi.checkLocationSettings(asGoogleApiClient(), paramLocationSettingsRequest), new LocationSettingsResponse());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\SettingsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */