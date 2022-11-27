package com.xiaomi.push;

import android.os.Looper;

public class ao
{
  public static void a()
  {
    if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
      return;
    }
    throw new RuntimeException("can't do this on ui thread");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ao.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */