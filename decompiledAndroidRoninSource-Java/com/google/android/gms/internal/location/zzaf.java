package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.GeofencingRequest.Builder;
import com.google.android.gms.location.zzal;
import java.util.List;

public final class zzaf
  implements GeofencingApi
{
  private final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, zzal paramzzal)
  {
    return paramGoogleApiClient.execute(new zzah(this, paramGoogleApiClient, paramzzal));
  }
  
  public final PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent)
  {
    return paramGoogleApiClient.execute(new zzag(this, paramGoogleApiClient, paramGeofencingRequest, paramPendingIntent));
  }
  
  @Deprecated
  public final PendingResult<Status> addGeofences(GoogleApiClient paramGoogleApiClient, List<Geofence> paramList, PendingIntent paramPendingIntent)
  {
    GeofencingRequest.Builder localBuilder = new GeofencingRequest.Builder();
    localBuilder.addGeofences(paramList);
    localBuilder.setInitialTrigger(5);
    return addGeofences(paramGoogleApiClient, localBuilder.build(), paramPendingIntent);
  }
  
  public final PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent)
  {
    return zza(paramGoogleApiClient, zzal.zza(paramPendingIntent));
  }
  
  public final PendingResult<Status> removeGeofences(GoogleApiClient paramGoogleApiClient, List<String> paramList)
  {
    return zza(paramGoogleApiClient, zzal.zza(paramList));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\location\zzaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */