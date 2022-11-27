package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;
import com.google.android.gms.fitness.result.DataReadResult;
import java.util.List;

public final class zzdj
  implements HistoryApi
{
  private final PendingResult<DailyTotalResult> zza(GoogleApiClient paramGoogleApiClient, DataType paramDataType, boolean paramBoolean)
  {
    return paramGoogleApiClient.enqueue(new zzdq(this, paramGoogleApiClient, paramDataType, paramBoolean));
  }
  
  public final PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, DataDeleteRequest paramDataDeleteRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdl(this, paramGoogleApiClient, paramDataDeleteRequest));
  }
  
  public final PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, DataSet paramDataSet)
  {
    Preconditions.checkNotNull(paramDataSet, "Must set the data set");
    Preconditions.checkState(paramDataSet.getDataPoints().isEmpty() ^ true, "Cannot use an empty data set");
    Preconditions.checkNotNull(paramDataSet.getDataSource().zzi(), "Must set the app package name for the data source");
    return paramGoogleApiClient.enqueue(new zzdk(this, paramGoogleApiClient, paramDataSet, false));
  }
  
  public final PendingResult<DailyTotalResult> readDailyTotal(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return zza(paramGoogleApiClient, paramDataType, false);
  }
  
  public final PendingResult<DailyTotalResult> readDailyTotalFromLocalDevice(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return zza(paramGoogleApiClient, paramDataType, true);
  }
  
  public final PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, DataReadRequest paramDataReadRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdp(this, paramGoogleApiClient, paramDataReadRequest));
  }
  
  public final PendingResult<Status> registerDataUpdateListener(GoogleApiClient paramGoogleApiClient, DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdn(this, paramGoogleApiClient, paramDataUpdateListenerRegistrationRequest));
  }
  
  public final PendingResult<Status> unregisterDataUpdateListener(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzdo(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult<Status> updateData(GoogleApiClient paramGoogleApiClient, DataUpdateRequest paramDataUpdateRequest)
  {
    Preconditions.checkNotNull(paramDataUpdateRequest.getDataSet(), "Must set the data set");
    Preconditions.checkNotZero(paramDataUpdateRequest.zzu(), "Must set a non-zero value for startTimeMillis/startTime");
    Preconditions.checkNotZero(paramDataUpdateRequest.zzv(), "Must set a non-zero value for endTimeMillis/endTime");
    return paramGoogleApiClient.enqueue(new zzdm(this, paramGoogleApiClient, paramDataUpdateRequest));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzdj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */