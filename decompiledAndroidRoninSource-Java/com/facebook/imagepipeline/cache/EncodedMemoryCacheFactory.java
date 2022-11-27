package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedMemoryCacheFactory
{
  public static InstrumentedMemoryCache<CacheKey, PooledByteBuffer> get(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    paramImageCacheStatsTracker.registerEncodedMemoryCache(paramMemoryCache);
    new InstrumentedMemoryCache(paramMemoryCache, new MemoryCacheTracker()
    {
      public void onCacheHit(CacheKey paramAnonymousCacheKey)
      {
        this.val$imageCacheStatsTracker.onMemoryCacheHit(paramAnonymousCacheKey);
      }
      
      public void onCacheMiss(CacheKey paramAnonymousCacheKey)
      {
        this.val$imageCacheStatsTracker.onMemoryCacheMiss(paramAnonymousCacheKey);
      }
      
      public void onCachePut(CacheKey paramAnonymousCacheKey)
      {
        this.val$imageCacheStatsTracker.onMemoryCachePut(paramAnonymousCacheKey);
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\EncodedMemoryCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */