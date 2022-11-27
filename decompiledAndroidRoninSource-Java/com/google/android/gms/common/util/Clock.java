package com.google.android.gms.common.util;

public abstract interface Clock
{
  public abstract long currentThreadTimeMillis();
  
  public abstract long currentTimeMillis();
  
  public abstract long elapsedRealtime();
  
  public abstract long nanoTime();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\Clock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */