package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zad
  implements zac
{
  public final PendingResult<Status> zaa(GoogleApiClient paramGoogleApiClient)
  {
    return paramGoogleApiClient.execute(new zae(this, paramGoogleApiClient));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\service\zad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */