package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.ResourceReleaser;
import com.facebook.imageutils.BitmapUtil;

public class BitmapCounter
{
  private int mCount;
  private final int mMaxCount;
  private final int mMaxSize;
  private long mSize;
  private final ResourceReleaser<Bitmap> mUnpooledBitmapsReleaser;
  
  public BitmapCounter(int paramInt1, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 > 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt2 > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    this.mMaxCount = paramInt1;
    this.mMaxSize = paramInt2;
    this.mUnpooledBitmapsReleaser = new ResourceReleaser()
    {
      public void release(Bitmap paramAnonymousBitmap)
      {
        try
        {
          BitmapCounter.this.decrease(paramAnonymousBitmap);
          return;
        }
        finally
        {
          paramAnonymousBitmap.recycle();
        }
      }
    };
  }
  
  public void decrease(Bitmap paramBitmap)
  {
    for (;;)
    {
      try
      {
        int i = BitmapUtil.getSizeInBytes(paramBitmap);
        if (this.mCount > 0)
        {
          bool = true;
          Preconditions.checkArgument(bool, "No bitmaps registered.");
          long l = i;
          if (l > this.mSize) {
            break label105;
          }
          bool = true;
          Preconditions.checkArgument(bool, "Bitmap size bigger than the total registered size: %d, %d", new Object[] { Integer.valueOf(i), Long.valueOf(this.mSize) });
          this.mSize -= l;
          this.mCount -= 1;
          return;
        }
      }
      finally {}
      boolean bool = false;
      continue;
      label105:
      bool = false;
    }
  }
  
  public int getCount()
  {
    try
    {
      int i = this.mCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getMaxCount()
  {
    try
    {
      int i = this.mMaxCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public int getMaxSize()
  {
    try
    {
      int i = this.mMaxSize;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public ResourceReleaser<Bitmap> getReleaser()
  {
    return this.mUnpooledBitmapsReleaser;
  }
  
  public long getSize()
  {
    try
    {
      long l = this.mSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean increase(Bitmap paramBitmap)
  {
    try
    {
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      if (this.mCount < this.mMaxCount)
      {
        long l1 = this.mSize;
        long l2 = i;
        if (l1 + l2 <= this.mMaxSize)
        {
          this.mCount += 1;
          this.mSize += l2;
          return true;
        }
      }
      return false;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BitmapCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */