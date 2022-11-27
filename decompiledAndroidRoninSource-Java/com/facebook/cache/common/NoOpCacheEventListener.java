package com.facebook.cache.common;

import javax.annotation.Nullable;

public class NoOpCacheEventListener
  implements CacheEventListener
{
  @Nullable
  private static NoOpCacheEventListener sInstance;
  
  public static NoOpCacheEventListener getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new NoOpCacheEventListener();
      }
      NoOpCacheEventListener localNoOpCacheEventListener = sInstance;
      return localNoOpCacheEventListener;
    }
    finally {}
  }
  
  public void onCleared() {}
  
  public void onEviction(CacheEvent paramCacheEvent) {}
  
  public void onHit(CacheEvent paramCacheEvent) {}
  
  public void onMiss(CacheEvent paramCacheEvent) {}
  
  public void onReadException(CacheEvent paramCacheEvent) {}
  
  public void onWriteAttempt(CacheEvent paramCacheEvent) {}
  
  public void onWriteException(CacheEvent paramCacheEvent) {}
  
  public void onWriteSuccess(CacheEvent paramCacheEvent) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\common\NoOpCacheEventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */