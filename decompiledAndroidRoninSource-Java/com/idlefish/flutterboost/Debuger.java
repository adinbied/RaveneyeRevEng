package com.idlefish.flutterboost;

import com.idlefish.flutterboost.log.AndroidLog;
import com.idlefish.flutterboost.log.ILog;

public class Debuger
{
  private static final Debuger DEBUG = new Debuger();
  private static final String TAG = "FlutterBoost#";
  private static ILog sLog = new AndroidLog();
  private static boolean sSafeMode = false;
  
  private static boolean canThrowError()
  {
    return (isDebug()) && (!sSafeMode);
  }
  
  public static void exception(String paramString)
  {
    if (!canThrowError())
    {
      sLog.e("FlutterBoost#", "exception", new RuntimeException(paramString));
      return;
    }
    throw new RuntimeException(paramString);
  }
  
  public static void exception(Throwable paramThrowable)
  {
    if (!canThrowError())
    {
      sLog.e("FlutterBoost#", "exception", paramThrowable);
      return;
    }
    throw new RuntimeException(paramThrowable);
  }
  
  public static boolean isDebug()
  {
    try
    {
      boolean bool = FlutterBoost.instance().platform().isDebug();
      return bool;
    }
    finally
    {
      for (;;) {}
    }
    return false;
  }
  
  public static void log(String paramString)
  {
    DEBUG.print(paramString);
  }
  
  /* Error */
  private void print(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void setLog(ILog paramILog)
  {
    if (paramILog != null) {
      sLog = paramILog;
    }
  }
  
  public static void setSafeMode(boolean paramBoolean)
  {
    sSafeMode = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\Debuger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */