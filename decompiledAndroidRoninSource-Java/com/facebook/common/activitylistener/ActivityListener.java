package com.facebook.common.activitylistener;

import android.app.Activity;

public abstract interface ActivityListener
{
  public static final int MAX_PRIORITY = 10;
  public static final int MIN_PRIORITY = 1;
  
  public abstract int getPriority();
  
  public abstract void onActivityCreate(Activity paramActivity);
  
  public abstract void onDestroy(Activity paramActivity);
  
  public abstract void onPause(Activity paramActivity);
  
  public abstract void onResume(Activity paramActivity);
  
  public abstract void onStart(Activity paramActivity);
  
  public abstract void onStop(Activity paramActivity);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\activitylistener\ActivityListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */