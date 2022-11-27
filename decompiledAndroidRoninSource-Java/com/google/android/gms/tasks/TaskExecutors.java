package com.google.android.gms.tasks;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

public final class TaskExecutors
{
  public static final Executor MAIN_THREAD = new zza();
  static final Executor zzw = new zzt();
  
  private static final class zza
    implements Executor
  {
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    
    public final void execute(Runnable paramRunnable)
    {
      this.mHandler.post(paramRunnable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\tasks\TaskExecutors.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */