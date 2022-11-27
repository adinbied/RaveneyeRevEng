package com.google.android.gms.internal.fitness;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.SessionsApi;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import java.util.concurrent.TimeUnit;

public final class zzee
  implements SessionsApi
{
  public final PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, SessionInsertRequest paramSessionInsertRequest)
  {
    return paramGoogleApiClient.enqueue(new zzeh(this, paramGoogleApiClient, paramSessionInsertRequest));
  }
  
  public final PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, SessionReadRequest paramSessionReadRequest)
  {
    return paramGoogleApiClient.enqueue(new zzei(this, paramGoogleApiClient, paramSessionReadRequest));
  }
  
  public final PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzej(this, paramGoogleApiClient, paramPendingIntent, 0));
  }
  
  public final PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, Session paramSession)
  {
    Preconditions.checkNotNull(paramSession, "Session cannot be null");
    boolean bool;
    if (paramSession.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "Cannot start a session which has already ended");
    return paramGoogleApiClient.execute(new zzef(this, paramGoogleApiClient, paramSession));
  }
  
  public final PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.execute(new zzeg(this, paramGoogleApiClient, null, paramString));
  }
  
  public final PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzek(this, paramGoogleApiClient, paramPendingIntent));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzee.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */