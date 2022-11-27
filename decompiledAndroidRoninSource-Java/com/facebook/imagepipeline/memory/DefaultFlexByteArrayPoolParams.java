package com.facebook.imagepipeline.memory;

import android.util.SparseIntArray;

public class DefaultFlexByteArrayPoolParams
{
  public static final int DEFAULT_MAX_BYTE_ARRAY_SIZE = 4194304;
  public static final int DEFAULT_MAX_NUM_THREADS = Runtime.getRuntime().availableProcessors();
  private static final int DEFAULT_MIN_BYTE_ARRAY_SIZE = 131072;
  
  public static SparseIntArray generateBuckets(int paramInt1, int paramInt2, int paramInt3)
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    while (paramInt1 <= paramInt2)
    {
      localSparseIntArray.put(paramInt1, paramInt3);
      paramInt1 *= 2;
    }
    return localSparseIntArray;
  }
  
  public static PoolParams get()
  {
    int i = DEFAULT_MAX_NUM_THREADS;
    return new PoolParams(4194304, i * 4194304, generateBuckets(131072, 4194304, i), 131072, 4194304, DEFAULT_MAX_NUM_THREADS);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\DefaultFlexByteArrayPoolParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */