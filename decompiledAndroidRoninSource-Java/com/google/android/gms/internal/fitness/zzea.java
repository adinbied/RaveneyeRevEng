package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.SensorsApi;
import com.google.android.gms.fitness.data.zzt;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.request.zzan;
import com.google.android.gms.fitness.result.DataSourcesResult;

public final class zzea
  implements SensorsApi
{
  private final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zzt paramzzt, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzed(this, paramGoogleApiClient, paramzzt, paramPendingIntent));
  }
  
  private final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, zzt paramzzt, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.enqueue(new zzec(this, paramGoogleApiClient, paramSensorRequest, paramzzt, paramPendingIntent));
  }
  
  public final PendingResult<Status> add(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, paramSensorRequest, null, paramPendingIntent);
  }
  
  public final PendingResult<Status> add(GoogleApiClient paramGoogleApiClient, SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener)
  {
    return zza(paramGoogleApiClient, paramSensorRequest, zzan.zzw().zza(paramOnDataPointListener, paramGoogleApiClient.getLooper()), null);
  }
  
  public final PendingResult<DataSourcesResult> findDataSources(GoogleApiClient paramGoogleApiClient, DataSourcesRequest paramDataSourcesRequest)
  {
    return paramGoogleApiClient.enqueue(new zzeb(this, paramGoogleApiClient, paramDataSourcesRequest));
  }
  
  public final PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, null, paramPendingIntent);
  }
  
  public final PendingResult<Status> remove(GoogleApiClient paramGoogleApiClient, OnDataPointListener paramOnDataPointListener)
  {
    paramOnDataPointListener = zzan.zzw().zzb(paramOnDataPointListener, paramGoogleApiClient.getLooper());
    if (paramOnDataPointListener == null) {
      return PendingResults.immediatePendingResult(Status.RESULT_SUCCESS, paramGoogleApiClient);
    }
    return zza(paramGoogleApiClient, paramOnDataPointListener, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */