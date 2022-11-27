package com.google.android.gms.fitness;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResponse;
import com.google.android.gms.internal.fitness.zzay;
import com.google.android.gms.internal.fitness.zzee;
import com.google.android.gms.tasks.Task;
import java.util.List;

public class SessionsClient
  extends GoogleApi<FitnessOptions>
{
  private static final SessionsApi zzab = new zzee();
  
  SessionsClient(Activity paramActivity, FitnessOptions paramFitnessOptions)
  {
    super(paramActivity, zzay.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  SessionsClient(Context paramContext, FitnessOptions paramFitnessOptions)
  {
    super(paramContext, zzay.zzew, paramFitnessOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
  }
  
  public Task<Void> insertSession(SessionInsertRequest paramSessionInsertRequest)
  {
    return PendingResultUtil.toVoidTask(zzab.insertSession(asGoogleApiClient(), paramSessionInsertRequest));
  }
  
  public Task<SessionReadResponse> readSession(SessionReadRequest paramSessionReadRequest)
  {
    return PendingResultUtil.toResponseTask(zzab.readSession(asGoogleApiClient(), paramSessionReadRequest), new SessionReadResponse());
  }
  
  public Task<Void> registerForSessions(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzab.registerForSessions(asGoogleApiClient(), paramPendingIntent));
  }
  
  public Task<Void> startSession(Session paramSession)
  {
    return PendingResultUtil.toVoidTask(zzab.startSession(asGoogleApiClient(), paramSession));
  }
  
  public Task<List<Session>> stopSession(String paramString)
  {
    return PendingResultUtil.toTask(zzab.stopSession(asGoogleApiClient(), paramString), zzp.zzf);
  }
  
  public Task<Void> unregisterForSessions(PendingIntent paramPendingIntent)
  {
    return PendingResultUtil.toVoidTask(zzab.unregisterForSessions(asGoogleApiClient(), paramPendingIntent));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\SessionsClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */