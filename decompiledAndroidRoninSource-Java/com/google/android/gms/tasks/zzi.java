package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzi<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;
  private OnCompleteListener<TResult> zzl;
  
  public zzi(Executor paramExecutor, OnCompleteListener<TResult> paramOnCompleteListener)
  {
    this.zzd = paramExecutor;
    this.zzl = paramOnCompleteListener;
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzl = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    synchronized (this.mLock)
    {
      if (this.zzl == null) {
        return;
      }
      this.zzd.execute(new zzj(this, paramTask));
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */