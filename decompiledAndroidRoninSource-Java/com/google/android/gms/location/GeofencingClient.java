package com.google.android.gms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ApiExceptionMapper;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class GeofencingClient
  extends GoogleApi<Api.ApiOptions.NoOptions>
{
  public GeofencingClient(Activity paramActivity)
  {
    super(paramActivity, LocationServices.API, null, new ApiExceptionMapper());
  }
  
  public GeofencingClient(Context paramContext)
  {
    super(paramContext, LocationServices.API, null, new ApiExceptionMapper());
  }
  
  public Task<Void> addGeofences(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(LocationServices.GeofencingApi.addGeofences(asGoogleApiClient(), paramGeofencingRequest, paramPendingIntent));
  }
  
  public Task<Void> removeGeofences(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(LocationServices.GeofencingApi.removeGeofences(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task<Void> removeGeofences(List<String> paramList)
  {
    return PendingResultUtil.toVoidTask(LocationServices.GeofencingApi.removeGeofences(asGoogleApiClient(), paramList));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\location\GeofencingClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */