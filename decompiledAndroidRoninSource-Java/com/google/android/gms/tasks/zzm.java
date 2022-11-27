package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

final class zzm<TResult>
  implements zzq<TResult>
{
  private final Object mLock = new Object();
  private final Executor zzd;
  private OnSuccessListener<? super TResult> zzp;
  
  public zzm(Executor paramExecutor, OnSuccessListener<? super TResult> paramOnSuccessListener)
  {
    this.zzd = paramExecutor;
    this.zzp = paramOnSuccessListener;
  }
  
  public final void cancel()
  {
    synchronized (this.mLock)
    {
      this.zzp = null;
      return;
    }
  }
  
  public final void onComplete(Task<TResult> paramTask)
  {
    if (paramTask.isSuccessful()) {
      synchronized (this.mLock)
      {
        if (this.zzp == null) {
          return;
        }
        this.zzd.execute(new zzn(this, paramTask));
        return;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */