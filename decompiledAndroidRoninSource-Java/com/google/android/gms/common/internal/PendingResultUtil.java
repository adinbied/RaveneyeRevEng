package com.google.android.gms.common.internal;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

public class PendingResultUtil
{
  private static final zaa zaou = new zai();
  
  public static <R extends Result, T extends Response<R>> Task<T> toResponseTask(PendingResult<R> paramPendingResult, T paramT)
  {
    return toTask(paramPendingResult, new zak(paramT));
  }
  
  public static <R extends Result, T> Task<T> toTask(PendingResult<R> paramPendingResult, ResultConverter<R, T> paramResultConverter)
  {
    zaa localzaa = zaou;
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramPendingResult.addStatusListener(new zaj(paramPendingResult, localTaskCompletionSource, paramResultConverter, localzaa));
    return localTaskCompletionSource.getTask();
  }
  
  public static <R extends Result> Task<Void> toVoidTask(PendingResult<R> paramPendingResult)
  {
    return toTask(paramPendingResult, new zal());
  }
  
  public static abstract interface ResultConverter<R extends Result, T>
  {
    public abstract T convert(R paramR);
  }
  
  public static abstract interface zaa
  {
    public abstract ApiException zaf(Status paramStatus);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\internal\PendingResultUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */