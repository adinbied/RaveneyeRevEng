package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapMemoryCacheFactory
{
  public static InstrumentedMemoryCache<CacheKey, CloseableImage> get(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    paramImageCacheStatsTracker.registerBitmapMemoryCache(paramMemoryCache);
    new InstrumentedMemoryCache(paramMemoryCache, new MemoryCacheTracker()
    {
      public void onCacheHit(CacheKey paramAnonymousCacheKey)
      {
        this.val$imageCacheStatsTracker.onBitmapCacheHit(paramAnonymousCacheKey);
      }
      
      public void onCacheMiss(CacheKey paramAnonymousCacheKey)
      {
        this.val$imageCacheStatsTracker.onBitmapCacheMiss(paramAnonymousCacheKey);
      }
      
      public void onCachePut(CacheKey paramAnonymousCacheKey)
      {
        this.val$imageCacheStatsTracker.onBitmapCachePut(paramAnonymousCacheKey);
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\BitmapMemoryCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */