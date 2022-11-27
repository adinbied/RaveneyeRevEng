package com.google.android.gms.tasks;

import java.util.ArrayDeque;
import java.util.Queue;

final class zzr<TResult>
{
  private final Object mLock = new Object();
  private Queue<zzq<TResult>> zzt;
  private boolean zzu;
  
  public final void zza(Task<TResult> paramTask)
  {
    synchronized (this.mLock)
    {
      if ((this.zzt != null) && (!this.zzu))
      {
        this.zzu = true;
        synchronized (this.mLock)
        {
          zzq localzzq = (zzq)this.zzt.poll();
          if (localzzq == null)
          {
            this.zzu = false;
            return;
          }
          localzzq.onComplete(paramTask);
        }
      }
      return;
    }
  }
  
  public final void zza(zzq<TResult> paramzzq)
  {
    synchronized (this.mLock)
    {
      if (this.zzt == null) {
        this.zzt = new ArrayDeque();
      }
      this.zzt.add(paramzzq);
      return;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\zzr.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */