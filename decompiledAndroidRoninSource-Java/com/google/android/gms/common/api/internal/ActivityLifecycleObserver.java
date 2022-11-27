package com.google.android.gms.common.api.internal;

import android.app.Activity;

public abstract class ActivityLifecycleObserver
{
  public static final ActivityLifecycleObserver of(Activity paramActivity)
  {
    return new zaa(paramActivity);
  }
  
  public abstract ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\ActivityLifecycleObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */