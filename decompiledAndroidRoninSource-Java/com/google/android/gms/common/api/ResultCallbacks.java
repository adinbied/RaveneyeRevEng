package com.google.android.gms.common.api;

import android.util.Log;

public abstract class ResultCallbacks<R extends Result>
  implements ResultCallback<R>
{
  public abstract void onFailure(Status paramStatus);
  
  public final void onResult(R paramR)
  {
    Status localStatus = paramR.getStatus();
    if (localStatus.isSuccess())
    {
      onSuccess(paramR);
      return;
    }
    onFailure(localStatus);
    if ((paramR instanceof Releasable)) {
      try
      {
        ((Releasable)paramR).release();
        return;
      }
      catch (RuntimeException localRuntimeException)
      {
        paramR = String.valueOf(paramR);
        StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramR).length() + 18);
        localStringBuilder.append("Unable to release ");
        localStringBuilder.append(paramR);
        Log.w("ResultCallbacks", localStringBuilder.toString(), localRuntimeException);
      }
    }
  }
  
  public abstract void onSuccess(R paramR);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\ResultCallbacks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */