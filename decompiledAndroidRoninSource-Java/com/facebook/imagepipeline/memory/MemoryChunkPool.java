package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimmableRegistry;

public abstract class MemoryChunkPool
  extends BasePool<MemoryChunk>
{
  private final int[] mBucketSizes;
  
  MemoryChunkPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    paramMemoryTrimmableRegistry = paramPoolParams.bucketSizes;
    this.mBucketSizes = new int[paramMemoryTrimmableRegistry.size()];
    int i = 0;
    for (;;)
    {
      paramPoolParams = this.mBucketSizes;
      if (i >= paramPoolParams.length) {
        break;
      }
      paramPoolParams[i] = paramMemoryTrimmableRegistry.keyAt(i);
      i += 1;
    }
    initialize();
  }
  
  protected abstract MemoryChunk alloc(int paramInt);
  
  protected void free(MemoryChunk paramMemoryChunk)
  {
    Preconditions.checkNotNull(paramMemoryChunk);
    paramMemoryChunk.close();
  }
  
  protected int getBucketedSize(int paramInt)
  {
    if (paramInt > 0)
    {
      int[] arrayOfInt = this.mBucketSizes;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        if (k >= paramInt) {
          return k;
        }
        i += 1;
      }
      return paramInt;
    }
    throw new BasePool.InvalidSizeException(Integer.valueOf(paramInt));
  }
  
  protected int getBucketedSizeForValue(MemoryChunk paramMemoryChunk)
  {
    Preconditions.checkNotNull(paramMemoryChunk);
    return paramMemoryChunk.getSize();
  }
  
  int getMinBufferSize()
  {
    return this.mBucketSizes[0];
  }
  
  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
  
  protected boolean isReusable(MemoryChunk paramMemoryChunk)
  {
    Preconditions.checkNotNull(paramMemoryChunk);
    return paramMemoryChunk.isClosed() ^ true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\MemoryChunkPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */