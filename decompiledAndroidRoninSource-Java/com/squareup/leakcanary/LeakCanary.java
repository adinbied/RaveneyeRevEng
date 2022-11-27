package com.squareup.leakcanary;

import android.app.Application;
import android.content.Context;

public final class LeakCanary
{
  private LeakCanary()
  {
    throw new AssertionError();
  }
  
  public static RefWatcher install(Application paramApplication)
  {
    return RefWatcher.DISABLED;
  }
  
  public static boolean isInAnalyzerProcess(Context paramContext)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\leakcanary\LeakCanary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */