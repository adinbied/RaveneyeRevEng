package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzo<TResult, TContinuationResult>
  implements OnCanceledListener, OnFailureListener, OnSuccessListener<TContinuationResult>, zzq<TResult>
{
  private final Executor zzd;
  private final zzu<TContinuationResult> zzf;
  private final SuccessContinuation<TResult, TContinuationResult> zzr;
  
  public zzo(Executor paramExecutor, SuccessContinuation<TResult, TContinuationResult> paramSuccessContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzd = paramExecutor;
    this.zzr = paramSuccessContinuation;
    this.zzf = paramzzu;
  }
  
  public final void cancel()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void onCanceled()
  {
    this.zzf.zza();
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    this.zzd.execute(new zzp(this, paramTask));
  }
  
  public final void onFailure(Exception paramException)
  {
    this.zzf.setException(paramException);
  }
  
  public final void onSuccess(TContinuationResult paramTContinuationResult)
  {
    this.zzf.setResult(paramTContinuationResult);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */