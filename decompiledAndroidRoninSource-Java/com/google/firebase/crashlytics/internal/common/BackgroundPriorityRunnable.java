package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

public abstract class BackgroundPriorityRunnable
  implements Runnable
{
  protected abstract void onRun();
  
  public final void run()
  {
    Process.setThreadPriority(10);
    onRun();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\BackgroundPriorityRunnable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */