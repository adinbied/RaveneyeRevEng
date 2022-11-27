package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;

public class UptimeClock
  implements Clock
{
  public long getTime()
  {
    return SystemClock.elapsedRealtime();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\runtime\time\UptimeClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */