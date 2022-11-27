package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzk<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;
  private OnFailureListener zzn;
  
  public zzk(Executor paramExecutor, OnFailureListener paramOnFailureListener)
  {
    this.zzd = paramExecutor;
    this.zzn = paramOnFailureListener;
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzn = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    if ((!paramTask.isSuccessful()) && (!paramTask.isCanceled())) {
      synchronized (this.mLock)
      {
        if (this.zzn == null) {
          return;
        }
        this.zzd.execute(new zzl(this, paramTask));
        return;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */