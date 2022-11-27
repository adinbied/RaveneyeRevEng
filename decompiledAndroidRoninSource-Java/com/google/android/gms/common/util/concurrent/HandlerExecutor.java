package com.google.android.gms.common.util.concurrent;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.common.zze;
import java.util.concurrent.Executor;

public class HandlerExecutor
  implements Executor
{
  private final Handler handler;
  
  public HandlerExecutor(Looper paramLooper)
  {
    this.handler = new zze(paramLooper);
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.handler.post(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\HandlerExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */