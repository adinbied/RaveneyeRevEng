package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzc<TResult, TContinuationResult>
  implements zzq<TResult>
{
  private final Executor zzd;
  private final Continuation<TResult, TContinuationResult> zze;
  private final zzu<TContinuationResult> zzf;
  
  public zzc(Executor paramExecutor, Continuation<TResult, TContinuationResult> paramContinuation, zzu<TContinuationResult> paramzzu)
  {
    this.zzd = paramExecutor;
    this.zze = paramContinuation;
    this.zzf = paramzzu;
  }
  
  public final void cancel()
  {
    throw new UnsupportedOperationException();
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    this.zzd.execute(new zzd(this, paramTask));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */