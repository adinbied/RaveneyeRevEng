package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;

public abstract interface ImageCacheStatsTracker
{
  public abstract void onBitmapCacheHit(CacheKey paramCacheKey);
  
  public abstract void onBitmapCacheMiss(CacheKey paramCacheKey);
  
  public abstract void onBitmapCachePut(CacheKey paramCacheKey);
  
  public abstract void onDiskCacheGetFail(CacheKey paramCacheKey);
  
  public abstract void onDiskCacheHit(CacheKey paramCacheKey);
  
  public abstract void onDiskCacheMiss(CacheKey paramCacheKey);
  
  public abstract void onDiskCachePut(CacheKey paramCacheKey);
  
  public abstract void onMemoryCacheHit(CacheKey paramCacheKey);
  
  public abstract void onMemoryCacheMiss(CacheKey paramCacheKey);
  
  public abstract void onMemoryCachePut(CacheKey paramCacheKey);
  
  public abstract void onStagingAreaHit(CacheKey paramCacheKey);
  
  public abstract void onStagingAreaMiss(CacheKey paramCacheKey);
  
  public abstract void registerBitmapMemoryCache(MemoryCache<?, ?> paramMemoryCache);
  
  public abstract void registerEncodedMemoryCache(MemoryCache<?, ?> paramMemoryCache);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\ImageCacheStatsTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */