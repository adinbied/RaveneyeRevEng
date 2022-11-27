package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.DataUpdateListenerRegistrationRequest;
import com.google.android.gms.fitness.request.DataUpdateRequest;
import com.google.android.gms.fitness.result.DataReadResponse;
import com.google.android.gms.internal.fitness.zzag;
import com.google.android.gms.internal.fitness.zzdj;
import com.google.android.gms.tasks.Task;

public class HistoryClient
  extends GoogleApi<FitnessOptions>
{
  private static final HistoryApi zzv = new zzdj();
  
  HistoryClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzag.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  HistoryClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzag.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<Void> deleteData(DataDeleteRequest paramDataDeleteRequest)
  {
    return PendingResultUtil.toVoidTask(zzv.deleteData(asGoogleApiClient(), paramDataDeleteRequest));
  }
  
  public Task<Void> insertData(DataSet paramDataSet)
  {
    return PendingResultUtil.toVoidTask(zzv.insertData(asGoogleApiClient(), paramDataSet));
  }
  
  public Task<DataSet> readDailyTotal(DataType paramDataType)
  {
    return PendingResultUtil.toTask(zzv.readDailyTotal(asGoogleApiClient(), paramDataType), zzi.zzf);
  }
  
  public Task<DataSet> readDailyTotalFromLocalDevice(DataType paramDataType)
  {
    return PendingResultUtil.toTask(zzv.readDailyTotalFromLocalDevice(asGoogleApiClient(), paramDataType), zzj.zzf);
  }
  
  public Task<DataReadResponse> readData(DataReadRequest paramDataReadRequest)
  {
    return PendingResultUtil.toResponseTask(zzv.readData(asGoogleApiClient(), paramDataReadRequest), new DataReadResponse());
  }
  
  public Task<Void> registerDataUpdateListener(DataUpdateListenerRegistrationRequest paramDataUpdateListenerRegistrationRequest)
  {
    return PendingResultUtil.toVoidTask(zzv.registerDataUpdateListener(asGoogleApiClient(), paramDataUpdateListenerRegistrationRequest));
  }
  
  public Task<Void> unregisterDataUpdateListener(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzv.unregisterDataUpdateListener(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task<Void> updateData(DataUpdateRequest paramDataUpdateRequest)
  {
    return PendingResultUtil.toVoidTask(zzv.updateData(asGoogleApiClient(), paramDataUpdateRequest));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\HistoryClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */