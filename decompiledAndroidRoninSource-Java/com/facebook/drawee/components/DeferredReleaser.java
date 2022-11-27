package com.facebook.drawee.components;

import android.os.Looper;
import javax.annotation.Nullable;

public abstract class DeferredReleaser
{
  @Nullable
  private static DeferredReleaser sInstance;
  
  public static DeferredReleaser getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new DeferredReleaserConcurrentImpl();
      }
      DeferredReleaser localDeferredReleaser = sInstance;
      return localDeferredReleaser;
    }
    finally {}
  }
  
  static boolean isOnUiThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public abstract void cancelDeferredRelease(Releasable paramReleasable);
  
  public abstract void scheduleDeferredRelease(Releasable paramReleasable);
  
  public static abstract interface Releasable
  {
    public abstract void release();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\components\DeferredReleaser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */