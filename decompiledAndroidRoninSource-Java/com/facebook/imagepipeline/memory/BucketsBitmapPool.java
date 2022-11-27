package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import javax.annotation.Nullable;

public class BucketsBitmapPool
  extends BasePool<Bitmap>
  implements BitmapPool
{
  public BucketsBitmapPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker, boolean paramBoolean)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker, paramBoolean);
    initialize();
  }
  
  protected Bitmap alloc(int paramInt)
  {
    return Bitmap.createBitmap(1, (int)Math.ceil(paramInt / 2.0D), Bitmap.Config.RGB_565);
  }
  
  protected void free(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    paramBitmap.recycle();
  }
  
  protected int getBucketedSize(int paramInt)
  {
    return paramInt;
  }
  
  protected int getBucketedSizeForValue(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    return paramBitmap.getAllocationByteCount();
  }
  
  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
  
  @Nullable
  protected Bitmap getValue(Bucket<Bitmap> paramBucket)
  {
    paramBucket = (Bitmap)super.getValue(paramBucket);
    if (paramBucket != null) {
      paramBucket.eraseColor(0);
    }
    return paramBucket;
  }
  
  protected boolean isReusable(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    return (!paramBitmap.isRecycled()) && (paramBitmap.isMutable());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BucketsBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */