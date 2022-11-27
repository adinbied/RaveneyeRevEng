package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.fitness.GoalsApi;
import com.google.android.gms.fitness.request.GoalsReadRequest;
import com.google.android.gms.fitness.result.GoalsResult;

public final class zzdg
  implements GoalsApi
{
  public final PendingResult<GoalsResult> readCurrentGoals(GoogleApiClient paramGoogleApiClient, GoalsReadRequest paramGoalsReadRequest)
  {
    return paramGoogleApiClient.enqueue(new zzdh(this, paramGoogleApiClient, paramGoalsReadRequest));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzdg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */