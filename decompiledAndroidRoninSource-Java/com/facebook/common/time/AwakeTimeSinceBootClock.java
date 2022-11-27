package com.facebook.common.time;

import android.os.SystemClock;

public class AwakeTimeSinceBootClock
  implements MonotonicClock, MonotonicNanoClock
{
  private static final AwakeTimeSinceBootClock INSTANCE = new AwakeTimeSinceBootClock();
  
  public static AwakeTimeSinceBootClock get()
  {
    return INSTANCE;
  }
  
  public long now()
  {
    return SystemClock.uptimeMillis();
  }
  
  public long nowNanos()
  {
    return System.nanoTime();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\time\AwakeTimeSinceBootClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */