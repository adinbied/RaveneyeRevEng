package com.google.android.gms.common.util.concurrent;

import android.os.Process;

final class zza
  implements Runnable
{
  private final int priority;
  private final Runnable zzhu;
  
  public zza(Runnable paramRunnable, int paramInt)
  {
    this.zzhu = paramRunnable;
    this.priority = paramInt;
  }
  
  public final void run()
  {
    Process.setThreadPriority(this.priority);
    this.zzhu.run();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\concurrent\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */