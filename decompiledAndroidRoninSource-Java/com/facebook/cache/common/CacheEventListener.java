package com.facebook.cache.common;

public abstract interface CacheEventListener
{
  public abstract void onCleared();
  
  public abstract void onEviction(CacheEvent paramCacheEvent);
  
  public abstract void onHit(CacheEvent paramCacheEvent);
  
  public abstract void onMiss(CacheEvent paramCacheEvent);
  
  public abstract void onReadException(CacheEvent paramCacheEvent);
  
  public abstract void onWriteAttempt(CacheEvent paramCacheEvent);
  
  public abstract void onWriteException(CacheEvent paramCacheEvent);
  
  public abstract void onWriteSuccess(CacheEvent paramCacheEvent);
  
  public static enum EvictionReason
  {
    static
    {
      EvictionReason localEvictionReason = new EvictionReason("CACHE_MANAGER_TRIMMED", 3);
      CACHE_MANAGER_TRIMMED = localEvictionReason;
      $VALUES = new EvictionReason[] { CACHE_FULL, CONTENT_STALE, USER_FORCED, localEvictionReason };
    }
    
    private EvictionReason() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\CacheEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */