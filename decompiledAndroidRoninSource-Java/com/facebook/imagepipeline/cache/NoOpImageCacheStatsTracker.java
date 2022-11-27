package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public class NoOpImageCacheStatsTracker
  implements ImageCacheStatsTracker
{
  private static NoOpImageCacheStatsTracker sInstance;
  
  public static NoOpImageCacheStatsTracker getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpImageCacheStatsTracker();
      }
      NoOpImageCacheStatsTracker localNoOpImageCacheStatsTracker = sInstance;
      return localNoOpImageCacheStatsTracker;
    }
    finally {}
  }
  
  public void onBitmapCacheHit(CacheKey paramCacheKey) {}
  
  public void onBitmapCacheMiss(CacheKey paramCacheKey) {}
  
  public void onBitmapCachePut(CacheKey paramCacheKey) {}
  
  public void onDiskCacheGetFail(CacheKey paramCacheKey) {}
  
  public void onDiskCacheHit(CacheKey paramCacheKey) {}
  
  public void onDiskCacheMiss(CacheKey paramCacheKey) {}
  
  public void onDiskCachePut(CacheKey paramCacheKey) {}
  
  public void onMemoryCacheHit(CacheKey paramCacheKey) {}
  
  public void onMemoryCacheMiss(CacheKey paramCacheKey) {}
  
  public void onMemoryCachePut(CacheKey paramCacheKey) {}
  
  public void onStagingAreaHit(CacheKey paramCacheKey) {}
  
  public void onStagingAreaMiss(CacheKey paramCacheKey) {}
  
  public void registerBitmapMemoryCache(MemoryCache<?, ?> paramMemoryCache) {}
  
  public void registerEncodedMemoryCache(MemoryCache<?, ?> paramMemoryCache) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\NoOpImageCacheStatsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */