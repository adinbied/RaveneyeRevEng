package com.facebook.imagepipeline.cache;

import java.util.concurrent.TimeUnit;

public class MemoryCacheParams
{
  public final int maxCacheEntries;
  public final int maxCacheEntrySize;
  public final int maxCacheSize;
  public final int maxEvictionQueueEntries;
  public final int maxEvictionQueueSize;
  public final long paramsCheckIntervalMs;
  
  public MemoryCacheParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, TimeUnit.MINUTES.toMillis(5L));
  }
  
  public MemoryCacheParams(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong)
  {
    this.maxCacheSize = paramInt1;
    this.maxCacheEntries = paramInt2;
    this.maxEvictionQueueSize = paramInt3;
    this.maxEvictionQueueEntries = paramInt4;
    this.maxCacheEntrySize = paramInt5;
    this.paramsCheckIntervalMs = paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\MemoryCacheParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */