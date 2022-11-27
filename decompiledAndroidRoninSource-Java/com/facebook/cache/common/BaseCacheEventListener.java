package com.facebook.cache.common;

public class BaseCacheEventListener
  implements CacheEventListener
{
  public void onCleared() {}
  
  public void onEviction(CacheEvent paramCacheEvent) {}
  
  public void onHit(CacheEvent paramCacheEvent) {}
  
  public void onMiss(CacheEvent paramCacheEvent) {}
  
  public void onReadException(CacheEvent paramCacheEvent) {}
  
  public void onWriteAttempt(CacheEvent paramCacheEvent) {}
  
  public void onWriteException(CacheEvent paramCacheEvent) {}
  
  public void onWriteSuccess(CacheEvent paramCacheEvent) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\BaseCacheEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */