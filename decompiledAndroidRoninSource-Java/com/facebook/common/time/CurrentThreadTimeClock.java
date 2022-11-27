package com.facebook.common.time;

import android.os.SystemClock;

public class CurrentThreadTimeClock
  implements Clock
{
  public long now()
  {
    return SystemClock.currentThreadTimeMillis();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\time\CurrentThreadTimeClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */