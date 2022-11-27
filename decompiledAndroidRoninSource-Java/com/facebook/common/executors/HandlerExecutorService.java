package com.facebook.common.executors;

import java.util.concurrent.ScheduledExecutorService;

public abstract interface HandlerExecutorService
  extends ScheduledExecutorService
{
  public abstract boolean isHandlerThread();
  
  public abstract void quit();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\executors\HandlerExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */