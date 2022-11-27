package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.ConfigApi;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.result.DataTypeResult;

public final class zzdb
  implements ConfigApi
{
  public final PendingResult<DataTypeResult> createCustomDataType(GoogleApiClient paramGoogleApiClient, DataTypeCreateRequest paramDataTypeCreateRequest)
  {
    return paramGoogleApiClient.execute(new zzdc(this, paramGoogleApiClient, paramDataTypeCreateRequest));
  }
  
  public final PendingResult<Status> disableFit(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new zzde(this, paramGoogleApiClient));
  }
  
  public final PendingResult<DataTypeResult> readDataType(GoogleApiClient paramGoogleApiClient, String paramString)
  {
    return paramGoogleApiClient.enqueue(new zzdd(this, paramGoogleApiClient, paramString));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzdb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */