package com.google.android.gms.common.util;

import android.os.SystemClock;

public class DefaultClock
  implements Clock
{
  private static final DefaultClock zzgm = new DefaultClock();
  
  public static Clock getInstance()
  {
    return zzgm;
  }
  
  public long currentThreadTimeMillis()
  {
    return SystemClock.currentThreadTimeMillis();
  }
  
  public long currentTimeMillis()
  {
    return System.currentTimeMillis();
  }
  
  public long elapsedRealtime()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public long nanoTime()
  {
    return System.nanoTime();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\DefaultClock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */