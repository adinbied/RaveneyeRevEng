package com.dji.video.framing.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

public class BackgroundLooper
{
  private static volatile BackgroundLooper looper;
  public Handler handler;
  public HandlerThread handlerThread;
  
  private BackgroundLooper()
  {
    HandlerThread localHandlerThread = new HandlerThread("dji_background_thread");
    this.handlerThread = localHandlerThread;
    localHandlerThread.start();
    this.handler = new Handler(this.handlerThread.getLooper());
  }
  
  public static BackgroundLooper get()
  {
    if (looper == null) {
      try
      {
        if (looper == null) {
          looper = new BackgroundLooper();
        }
      }
      finally {}
    }
    return looper;
  }
  
  public static Looper getLooper()
  {
    return get().handlerThread.getLooper();
  }
  
  public static void post(Runnable paramRunnable)
  {
    get().handler.post(paramRunnable);
  }
  
  public static void postDelayed(Runnable paramRunnable, long paramLong)
  {
    get().handler.postDelayed(paramRunnable, paramLong);
  }
  
  public static void remove(Runnable paramRunnable)
  {
    get().handler.removeCallbacks(paramRunnable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\BackgroundLooper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */