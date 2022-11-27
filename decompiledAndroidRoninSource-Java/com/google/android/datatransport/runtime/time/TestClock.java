package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

public class TestClock
  implements Clock
{
  private final AtomicLong timestamp;
  
  public TestClock(long paramLong)
  {
    this.timestamp = new AtomicLong(paramLong);
  }
  
  public void advance(long paramLong)
  {
    if (paramLong >= 0L)
    {
      this.timestamp.addAndGet(paramLong);
      return;
    }
    throw new IllegalArgumentException("cannot advance time backwards.");
  }
  
  public long getTime()
  {
    return this.timestamp.get();
  }
  
  public void tick()
  {
    advance(1L);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\time\TestClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */