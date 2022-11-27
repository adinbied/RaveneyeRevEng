package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.MemoryTrimmableRegistry;

public class GenericByteArrayPool
  extends BasePool<byte[]>
  implements ByteArrayPool
{
  private final int[] mBucketSizes;
  
  public GenericByteArrayPool(MemoryTrimmableRegistry paramMemoryTrimmableRegistry, PoolParams paramPoolParams, PoolStatsTracker paramPoolStatsTracker)
  {
    super(paramMemoryTrimmableRegistry, paramPoolParams, paramPoolStatsTracker);
    paramMemoryTrimmableRegistry = paramPoolParams.bucketSizes;
    this.mBucketSizes = new int[paramMemoryTrimmableRegistry.size()];
    int i = 0;
    while (i < paramMemoryTrimmableRegistry.size())
    {
      this.mBucketSizes[i] = paramMemoryTrimmableRegistry.keyAt(i);
      i += 1;
    }
    initialize();
  }
  
  protected byte[] alloc(int paramInt)
  {
    return new byte[paramInt];
  }
  
  protected void free(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
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
  
  protected int getBucketedSizeForValue(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    return paramArrayOfByte.length;
  }
  
  public int getMinBufferSize()
  {
    return this.mBucketSizes[0];
  }
  
  protected int getSizeInBytes(int paramInt)
  {
    return paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\GenericByteArrayPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */