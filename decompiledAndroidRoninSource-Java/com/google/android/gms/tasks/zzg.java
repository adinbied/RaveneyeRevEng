package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzg<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;
  private OnCanceledListener zzj;
  
  public zzg(Executor paramExecutor, OnCanceledListener paramOnCanceledListener)
  {
    this.zzd = paramExecutor;
    this.zzj = paramOnCanceledListener;
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzj = null;
      return;
    }
  }
  
  public final void onComplete(Task arg1)
  {
    if (???.isCanceled()) {
      synchronized (this.mLock)
      {
        if (this.zzj == null) {
          return;
        }
        this.zzd.execute(new zzh(this));
        return;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */