package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;
import com.google.android.gms.location.ActivityTransitionRequest;

public final class zze
  implements ActivityRecognitionApi
{
  public final PendingResult<Status> removeActivityUpdates(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzg(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult<Status> requestActivityUpdates(GoogleApiClient paramGoogleApiClient, long paramLong, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzf(this, paramGoogleApiClient, paramLong, paramPendingIntent));
  }
  
  public final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzi(this, paramGoogleApiClient, paramPendingIntent));
  }
  
  public final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, ActivityTransitionRequest paramActivityTransitionRequest, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzh(this, paramGoogleApiClient, paramActivityTransitionRequest, paramPendingIntent));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zze.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */