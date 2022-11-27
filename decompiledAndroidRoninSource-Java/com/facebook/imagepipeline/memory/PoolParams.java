package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;
import com.facebook.common.internal.Preconditions;
import javax.annotation.Nullable;

public class PoolParams
{
  public static final int IGNORE_THREADS = -1;
  public String bitmapPoolType;
  public final SparseIntArray bucketSizes;
  public boolean fixBucketsReinitialization;
  public final int maxBucketSize;
  public final int maxNumThreads;
  public final int maxSizeHardCap;
  public final int maxSizeSoftCap;
  public final int minBucketSize;
  
  public PoolParams(int paramInt1, int paramInt2, @Nullable SparseIntArray paramSparseIntArray)
  {
    this(paramInt1, paramInt2, paramSparseIntArray, 0, Integer.MAX_VALUE, -1);
  }
  
  public PoolParams(int paramInt1, int paramInt2, @Nullable SparseIntArray paramSparseIntArray, int paramInt3, int paramInt4, int paramInt5)
  {
    boolean bool;
    if ((paramInt1 >= 0) && (paramInt2 >= paramInt1)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    this.maxSizeSoftCap = paramInt1;
    this.maxSizeHardCap = paramInt2;
    this.bucketSizes = paramSparseIntArray;
    this.minBucketSize = paramInt3;
    this.maxBucketSize = paramInt4;
    this.maxNumThreads = paramInt5;
  }
  
  public PoolParams(int paramInt, @Nullable SparseIntArray paramSparseIntArray)
  {
    this(paramInt, paramInt, paramSparseIntArray, 0, Integer.MAX_VALUE, -1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\PoolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */