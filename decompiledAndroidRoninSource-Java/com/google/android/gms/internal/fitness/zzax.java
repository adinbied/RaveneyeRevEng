package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

abstract class zzax
  extends zzav<Status>
{
  zzax(GoogleApiClient paramGoogleApiClient)
  {
    super(paramGoogleApiClient);
  }
  
  protected Status zza(Status paramStatus)
  {
    Preconditions.checkArgument(paramStatus.isSuccess() ^ true);
    return paramStatus;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzax.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */