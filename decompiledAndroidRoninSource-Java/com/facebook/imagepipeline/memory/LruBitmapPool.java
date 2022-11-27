package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;

public class LruBitmapPool
  implements BitmapPool
{
  private int mCurrentSize;
  private int mMaxBitmapSize;
  private final int mMaxPoolSize;
  private final PoolStatsTracker mPoolStatsTracker;
  protected final PoolBackend<Bitmap> mStrategy = new BitmapPoolBackend();
  
  public LruBitmapPool(int paramInt1, int paramInt2, PoolStatsTracker paramPoolStatsTracker, @Nullable MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
  {
    this.mMaxPoolSize = paramInt1;
    this.mMaxBitmapSize = paramInt2;
    this.mPoolStatsTracker = paramPoolStatsTracker;
    if (paramMemoryTrimmableRegistry != null) {
      paramMemoryTrimmableRegistry.registerMemoryTrimmable(this);
    }
  }
  
  private Bitmap alloc(int paramInt)
  {
    this.mPoolStatsTracker.onAlloc(paramInt);
    return Bitmap.createBitmap(1, paramInt, Bitmap.Config.ALPHA_8);
  }
  
  private void trimTo(int paramInt)
  {
    try
    {
      while (this.mCurrentSize > paramInt)
      {
        Bitmap localBitmap = (Bitmap)this.mStrategy.pop();
        if (localBitmap == null) {
          break;
        }
        int i = this.mStrategy.getSize(localBitmap);
        this.mCurrentSize -= i;
        this.mPoolStatsTracker.onFree(i);
      }
      return;
    }
    finally {}
  }
  
  public Bitmap get(int paramInt)
  {
    try
    {
      if (this.mCurrentSize > this.mMaxPoolSize) {
        trimTo(this.mMaxPoolSize);
      }
      Bitmap localBitmap = (Bitmap)this.mStrategy.get(paramInt);
      if (localBitmap != null)
      {
        paramInt = this.mStrategy.getSize(localBitmap);
        this.mCurrentSize -= paramInt;
        this.mPoolStatsTracker.onValueReuse(paramInt);
        return localBitmap;
      }
      localBitmap = alloc(paramInt);
      return localBitmap;
    }
    finally {}
  }
  
  public void release(Bitmap paramBitmap)
  {
    int i = this.mStrategy.getSize(paramBitmap);
    if (i <= this.mMaxBitmapSize)
    {
      this.mPoolStatsTracker.onValueRelease(i);
      this.mStrategy.put(paramBitmap);
      try
      {
        this.mCurrentSize += i;
        return;
      }
      finally {}
    }
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType)
  {
    trimTo((int)(this.mMaxPoolSize * (1.0D - paramMemoryTrimType.getSuggestedTrimRatio())));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\LruBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */