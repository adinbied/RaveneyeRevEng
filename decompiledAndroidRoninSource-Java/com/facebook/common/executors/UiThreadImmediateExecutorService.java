package com.facebook.common.executors;

import android.os.Handler;
import android.os.Looper;
import javax.annotation.Nullable;

public class UiThreadImmediateExecutorService
  extends HandlerExecutorServiceImpl
{
  @Nullable
  private static UiThreadImmediateExecutorService sInstance;
  
  private UiThreadImmediateExecutorService()
  {
    super(new Handler(Looper.getMainLooper()));
  }
  
  public static UiThreadImmediateExecutorService getInstance()
  {
    if (sInstance == null) {
      sInstance = new UiThreadImmediateExecutorService();
    }
    return sInstance;
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (isHandlerThread())
    {
      paramRunnable.run();
      return;
    }
    super.execute(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\executors\UiThreadImmediateExecutorService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */