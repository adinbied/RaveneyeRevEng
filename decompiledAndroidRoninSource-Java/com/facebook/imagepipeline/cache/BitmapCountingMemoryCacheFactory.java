package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nullable;

public class BitmapCountingMemoryCacheFactory
{
  public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry, @Nullable CountingMemoryCache.EntryStateObserver<CacheKey> paramEntryStateObserver)
  {
    return get(paramSupplier, paramMemoryTrimmableRegistry, new BitmapMemoryCacheTrimStrategy(), paramEntryStateObserver);
  }
  
  public static CountingMemoryCache<CacheKey, CloseableImage> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry, MemoryCache.CacheTrimStrategy paramCacheTrimStrategy, @Nullable CountingMemoryCache.EntryStateObserver<CacheKey> paramEntryStateObserver)
  {
    paramSupplier = new CountingMemoryCache(new ValueDescriptor()
    {
      public int getSizeInBytes(CloseableImage paramAnonymousCloseableImage)
      {
        return paramAnonymousCloseableImage.getSizeInBytes();
      }
    }, paramCacheTrimStrategy, paramSupplier, paramEntryStateObserver);
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(paramSupplier);
    return paramSupplier;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\BitmapCountingMemoryCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */