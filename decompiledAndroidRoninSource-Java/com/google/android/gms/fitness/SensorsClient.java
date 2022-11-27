package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.internal.fitness.zzas;
import com.google.android.gms.internal.fitness.zzea;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class SensorsClient
  extends GoogleApi<FitnessOptions>
{
  private static final SensorsApi zzx = new zzea();
  
  SensorsClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzas.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  SensorsClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzas.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<Void> add(SensorRequest paramSensorRequest, PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzx.add(asGoogleApiClient(), paramSensorRequest, paramPendingIntent));
  }
  
  public Task<Void> add(SensorRequest paramSensorRequest, OnDataPointListener paramOnDataPointListener)
  {
    paramOnDataPointListener = registerListener(paramOnDataPointListener, OnDataPointListener.class.getSimpleName());
    return doRegisterEventListener(new zzn(this, paramOnDataPointListener, paramOnDataPointListener, paramSensorRequest), new zzo(this, paramOnDataPointListener.getListenerKey(), paramOnDataPointListener));
  }
  
  public Task<List<DataSource>> findDataSources(DataSourcesRequest paramDataSourcesRequest)
  {
    return PendingResultUtil.toTask(zzx.findDataSources(asGoogleApiClient(), paramDataSourcesRequest), zzm.zzf);
  }
  
  public Task<Void> remove(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzx.remove(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task<Boolean> remove(OnDataPointListener paramOnDataPointListener)
  {
    return doUnregisterEventListener(ListenerHolders.createListenerKey(paramOnDataPointListener, OnDataPointListener.class.getSimpleName()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\SensorsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */