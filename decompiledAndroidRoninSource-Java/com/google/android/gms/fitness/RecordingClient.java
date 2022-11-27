package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.fitness.zzam;
import com.google.android.gms.internal.fitness.zzdt;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class RecordingClient
  extends GoogleApi<FitnessOptions>
{
  private static final RecordingApi zzw = new zzdt();
  
  RecordingClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzam.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  RecordingClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzam.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<List<Subscription>> listSubscriptions()
  {
    return PendingResultUtil.toTask(zzw.listSubscriptions(asGoogleApiClient()), zzk.zzf);
  }
  
  public Task<List<Subscription>> listSubscriptions(DataType paramDataType)
  {
    return PendingResultUtil.toTask(zzw.listSubscriptions(asGoogleApiClient(), paramDataType), zzl.zzf);
  }
  
  public Task<Void> subscribe(DataSource paramDataSource)
  {
    return PendingResultUtil.toVoidTask(zzw.subscribe(asGoogleApiClient(), paramDataSource));
  }
  
  public Task<Void> subscribe(DataType paramDataType)
  {
    return PendingResultUtil.toVoidTask(zzw.subscribe(asGoogleApiClient(), paramDataType));
  }
  
  public Task<Void> unsubscribe(DataSource paramDataSource)
  {
    return PendingResultUtil.toVoidTask(zzw.unsubscribe(asGoogleApiClient(), paramDataSource));
  }
  
  public Task<Void> unsubscribe(DataType paramDataType)
  {
    return PendingResultUtil.toVoidTask(zzw.unsubscribe(asGoogleApiClient(), paramDataType));
  }
  
  public Task<Void> unsubscribe(Subscription paramSubscription)
  {
    return PendingResultUtil.toVoidTask(zzw.unsubscribe(asGoogleApiClient(), paramSubscription));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\RecordingClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */