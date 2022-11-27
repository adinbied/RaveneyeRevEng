package com.google.android.gms.internal.fitness;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.RecordingApi;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.fitness.data.Subscription.zza;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

public final class zzdt
  implements RecordingApi
{
  private final PendingResult<Status> zza(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    return paramGoogleApiClient.enqueue(new zzdw(this, paramGoogleApiClient, paramSubscription));
  }
  
  public final PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.enqueue(new zzdu(this, paramGoogleApiClient));
  }
  
  public final PendingResult<ListSubscriptionsResult> listSubscriptions(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return paramGoogleApiClient.enqueue(new zzdv(this, paramGoogleApiClient, paramDataType));
  }
  
  public final PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return zza(paramGoogleApiClient, new Subscription.zza().zza(paramDataSource).zzr());
  }
  
  public final PendingResult<Status> subscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return zza(paramGoogleApiClient, new Subscription.zza().zza(paramDataType).zzr());
  }
  
  public final PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, DataSource paramDataSource)
  {
    return paramGoogleApiClient.execute(new zzdy(this, paramGoogleApiClient, paramDataSource));
  }
  
  public final PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, DataType paramDataType)
  {
    return paramGoogleApiClient.execute(new zzdx(this, paramGoogleApiClient, paramDataType));
  }
  
  public final PendingResult<Status> unsubscribe(GoogleApiClient paramGoogleApiClient, Subscription paramSubscription)
  {
    if (paramSubscription.getDataType() == null) {
      return unsubscribe(paramGoogleApiClient, paramSubscription.getDataSource());
    }
    return unsubscribe(paramGoogleApiClient, paramSubscription.getDataType());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\fitness\zzdt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */