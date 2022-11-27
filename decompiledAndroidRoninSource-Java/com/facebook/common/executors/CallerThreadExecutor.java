package com.facebook.common.executors;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.TimeUnit;

public class CallerThreadExecutor
  extends AbstractExecutorService
{
  private static final CallerThreadExecutor sInstance = new CallerThreadExecutor();
  
  public static CallerThreadExecutor getInstance()
  {
    return sInstance;
  }
  
  public boolean awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    return true;
  }
  
  public void execute(Runnable paramRunnable)
  {
    paramRunnable.run();
  }
  
  public boolean isShutdown()
  {
    return false;
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public void shutdown() {}
  
  public List<Runnable> shutdownNow()
  {
    shutdown();
    return Collections.emptyList();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\executors\CallerThreadExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */