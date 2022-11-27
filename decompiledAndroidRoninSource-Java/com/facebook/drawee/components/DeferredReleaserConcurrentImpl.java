package com.facebook.drawee.components;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

class DeferredReleaserConcurrentImpl
  extends DeferredReleaser
{
  private final Object mLock = new Object();
  private ArrayList<DeferredReleaser.Releasable> mPendingReleasables = new ArrayList();
  private ArrayList<DeferredReleaser.Releasable> mTempList = new ArrayList();
  private final Handler mUiHandler = new Handler(Looper.getMainLooper());
  private final Runnable releaseRunnable = new Runnable()
  {
    public void run()
    {
      synchronized (DeferredReleaserConcurrentImpl.this.mLock)
      {
        ArrayList localArrayList = DeferredReleaserConcurrentImpl.this.mTempList;
        DeferredReleaserConcurrentImpl.access$102(DeferredReleaserConcurrentImpl.this, DeferredReleaserConcurrentImpl.this.mPendingReleasables);
        DeferredReleaserConcurrentImpl.access$202(DeferredReleaserConcurrentImpl.this, localArrayList);
        int i = 0;
        int j = DeferredReleaserConcurrentImpl.this.mTempList.size();
        while (i < j)
        {
          ((DeferredReleaser.Releasable)DeferredReleaserConcurrentImpl.this.mTempList.get(i)).release();
          i += 1;
        }
        DeferredReleaserConcurrentImpl.this.mTempList.clear();
        return;
      }
    }
  };
  
  public void cancelDeferredRelease(DeferredReleaser.Releasable paramReleasable)
  {
    synchronized (this.mLock)
    {
      this.mPendingReleasables.remove(paramReleasable);
      return;
    }
  }
  
  public void scheduleDeferredRelease(DeferredReleaser.Releasable paramReleasable)
  {
    if (!isOnUiThread())
    {
      paramReleasable.release();
      return;
    }
    for (;;)
    {
      synchronized (this.mLock)
      {
        if (this.mPendingReleasables.contains(paramReleasable)) {
          return;
        }
        this.mPendingReleasables.add(paramReleasable);
        int j = this.mPendingReleasables.size();
        i = 1;
        if (j == 1)
        {
          if (i != 0) {
            this.mUiHandler.post(this.releaseRunnable);
          }
          return;
        }
      }
      int i = 0;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\components\DeferredReleaserConcurrentImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */