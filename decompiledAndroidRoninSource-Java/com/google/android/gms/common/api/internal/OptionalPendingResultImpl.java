package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResult.StatusListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.TransformedResult;
import java.util.concurrent.TimeUnit;

public final class OptionalPendingResultImpl<R extends Result>
  extends OptionalPendingResult<R>
{
  private final BasePendingResult<R> zajq;
  
  public OptionalPendingResultImpl(PendingResult<R> paramPendingResult)
  {
    this.zajq = ((BasePendingResult)paramPendingResult);
  }
  
  public final void addStatusListener(PendingResult.StatusListener paramStatusListener)
  {
    this.zajq.addStatusListener(paramStatusListener);
  }
  
  public final R await()
  {
    return this.zajq.await();
  }
  
  public final R await(long paramLong, TimeUnit paramTimeUnit)
  {
    return this.zajq.await(paramLong, paramTimeUnit);
  }
  
  public final void cancel()
  {
    this.zajq.cancel();
  }
  
  public final R get()
  {
    if (isDone()) {
      return await(0L, TimeUnit.MILLISECONDS);
    }
    throw new IllegalStateException("Result is not available. Check that isDone() returns true before calling get().");
  }
  
  public final boolean isCanceled()
  {
    return this.zajq.isCanceled();
  }
  
  public final boolean isDone()
  {
    return this.zajq.isReady();
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback)
  {
    this.zajq.setResultCallback(paramResultCallback);
  }
  
  public final void setResultCallback(ResultCallback<? super R> paramResultCallback, long paramLong, TimeUnit paramTimeUnit)
  {
    this.zajq.setResultCallback(paramResultCallback, paramLong, paramTimeUnit);
  }
  
  public final <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform)
  {
    return this.zajq.then(paramResultTransform);
  }
  
  public final Integer zam()
  {
    return this.zajq.zam();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\OptionalPendingResultImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */