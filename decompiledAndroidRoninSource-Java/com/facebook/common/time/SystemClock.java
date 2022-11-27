package com.facebook.common.time;

public class SystemClock
  implements Clock
{
  private static final SystemClock INSTANCE = new SystemClock();
  
  public static SystemClock get()
  {
    return INSTANCE;
  }
  
  public long now()
  {
    return System.currentTimeMillis();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\time\SystemClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */