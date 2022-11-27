package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.internal.fitness.zzdb;
import com.google.android.gms.internal.fitness.zzv;
import com.google.android.gms.tasks.Task;

public class ConfigClient
  extends GoogleApi<FitnessOptions>
{
  private static final ConfigApi zzj = new zzdb();
  
  ConfigClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzv.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  ConfigClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzv.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<DataType> createCustomDataType(DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return PendingResultUtil.toTask(zzj.createCustomDataType(asGoogleApiClient(), paramDataTypeCreateRequest), zzd.zzf);
  }
  
  public Task<Void> disableFit()
  {
    return PendingResultUtil.toVoidTask(zzj.disableFit(asGoogleApiClient()));
  }
  
  public Task<DataType> readDataType(String paramString)
  {
    return PendingResultUtil.toTask(zzj.readDataType(asGoogleApiClient(), paramString), zze.zzf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\ConfigClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */