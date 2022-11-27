package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public final class BackgroundDetector
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final BackgroundDetector zzat = new BackgroundDetector();
  private final AtomicBoolean zzau = new AtomicBoolean();
  private final AtomicBoolean zzav = new AtomicBoolean();
  private final ArrayList<BackgroundStateChangeListener> zzaw = new ArrayList();
  private boolean zzax = false;
  
  public static BackgroundDetector getInstance()
  {
    return zzat;
  }
  
  public static void initialize(Application paramApplication)
  {
    synchronized (zzat)
    {
      if (!zzat.zzax)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzat);
        paramApplication.registerComponentCallbacks(zzat);
        zzat.zzax = true;
      }
      return;
    }
  }
  
  private final void onBackgroundStateChanged(boolean paramBoolean)
  {
    synchronized (zzat)
    {
      ArrayList localArrayList = (ArrayList)this.zzaw;
      int j = localArrayList.size();
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localArrayList.get(i);
        i += 1;
        ((BackgroundStateChangeListener)localObject2).onBackgroundStateChanged(paramBoolean);
      }
      return;
    }
  }
  
  public final void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    synchronized (zzat)
    {
      this.zzaw.add(paramBackgroundStateChangeListener);
      return;
    }
  }
  
  public final boolean isInBackground()
  {
    return this.zzau.get();
  }
  
  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.zzau.compareAndSet(true, false);
    this.zzav.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
  }
  
  public final void onActivityDestroyed(Activity paramActivity) {}
  
  public final void onActivityPaused(Activity paramActivity) {}
  
  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.zzau.compareAndSet(true, false);
    this.zzav.set(true);
    if (bool) {
      onBackgroundStateChanged(false);
    }
  }
  
  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public final void onActivityStarted(Activity paramActivity) {}
  
  public final void onActivityStopped(Activity paramActivity) {}
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory() {}
  
  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.zzau.compareAndSet(false, true)))
    {
      this.zzav.set(true);
      onBackgroundStateChanged(true);
    }
  }
  
  public final boolean readCurrentStateIfPossible(boolean paramBoolean)
  {
    if (!this.zzav.get()) {
      if (PlatformVersion.isAtLeastJellyBean())
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
        ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
        if ((!this.zzav.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100)) {
          this.zzau.set(true);
        }
      }
      else
      {
        return paramBoolean;
      }
    }
    return isInBackground();
  }
  
  public static abstract interface BackgroundStateChangeListener
  {
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\BackgroundDetector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */