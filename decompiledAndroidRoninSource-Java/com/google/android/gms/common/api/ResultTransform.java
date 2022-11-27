package com.google.android.gms.common.api;

import com.google.android.gms.common.api.internal.zacd;

public abstract class ResultTransform<R extends Result, S extends Result>
{
  public final PendingResult<S> createFailedResult(Status paramStatus)
  {
    return new zacd(paramStatus);
  }
  
  public Status onFailure(Status paramStatus)
  {
    return paramStatus;
  }
  
  public abstract PendingResult<S> onSuccess(R paramR);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\ResultTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */