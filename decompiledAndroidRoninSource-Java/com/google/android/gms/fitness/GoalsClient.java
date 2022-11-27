package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.Goal;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.internal.fitness.zzab;
import com.google.android.gms.internal.fitness.zzdg;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class GoalsClient
  extends GoogleApi<FitnessOptions>
{
  private static final GoalsApi zzo = new zzdg();
  
  GoalsClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzab.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  GoalsClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzab.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<List<Goal>> readCurrentGoals(GoalsReadRequest paramGoalsReadRequest)
  {
    return PendingResultUtil.toTask(zzo.readCurrentGoals(asGoogleApiClient(), paramGoalsReadRequest), zzh.zzf);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\GoalsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */