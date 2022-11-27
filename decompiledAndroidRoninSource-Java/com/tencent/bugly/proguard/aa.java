package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;

public final class aa
  implements Runnable
{
  private final Handler a;
  private final String b;
  private long c;
  private final long d;
  private boolean e;
  private long f;
  
  aa(Handler paramHandler, String paramString, long paramLong)
  {
    this.a = paramHandler;
    this.b = paramString;
    this.c = paramLong;
    this.d = paramLong;
    this.e = true;
  }
  
  public final void a()
  {
    if (!this.e) {
      return;
    }
    this.e = false;
    this.f = SystemClock.uptimeMillis();
    this.a.post(this);
  }
  
  public final void a(long paramLong)
  {
    this.c = Long.MAX_VALUE;
  }
  
  public final boolean b()
  {
    return (!this.e) && (SystemClock.uptimeMillis() > this.f + this.c);
  }
  
  public final int c()
  {
    if (this.e) {
      return 0;
    }
    if (SystemClock.uptimeMillis() - this.f < this.c) {
      return 1;
    }
    return 3;
  }
  
  public final String d()
  {
    return this.b;
  }
  
  public final Looper e()
  {
    return this.a.getLooper();
  }
  
  public final void run()
  {
    this.e = true;
    this.c = this.d;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\aa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */