package com.google.android.gms.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;

public abstract interface GoalsApi
{
  public abstract PendingResult<GoalsResult> readCurrentGoals(GoogleApiClient paramGoogleApiClient, GoalsReadRequest paramGoalsReadRequest);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\GoalsApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */