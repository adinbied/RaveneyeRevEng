package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

class SafeLoggingExecutor
  implements Executor
{
  private final Executor delegate;
  
  SafeLoggingExecutor(Executor paramExecutor)
  {
    this.delegate = paramExecutor;
  }
  
  public void execute(Runnable paramRunnable)
  {
    this.delegate.execute(new SafeLoggingRunnable(paramRunnable));
  }
  
  static class SafeLoggingRunnable
    implements Runnable
  {
    private final Runnable delegate;
    
    SafeLoggingRunnable(Runnable paramRunnable)
    {
      this.delegate = paramRunnable;
    }
    
    public void run()
    {
      try
      {
        this.delegate.run();
        return;
      }
      catch (Exception localException)
      {
        Logging.e("Executor", "Background execution failure.", localException);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\SafeLoggingExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */