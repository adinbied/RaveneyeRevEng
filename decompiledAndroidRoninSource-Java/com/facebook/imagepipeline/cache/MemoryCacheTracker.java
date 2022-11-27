package com.facebook.imagepipeline.cache;

public abstract interface MemoryCacheTracker<K>
{
  public abstract void onCacheHit(K paramK);
  
  public abstract void onCacheMiss(K paramK);
  
  public abstract void onCachePut(K paramK);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\MemoryCacheTracker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */