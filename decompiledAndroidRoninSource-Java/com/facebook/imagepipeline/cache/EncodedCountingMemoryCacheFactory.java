package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.common.memory.PooledByteBuffer;

public class EncodedCountingMemoryCacheFactory
{
  public static CountingMemoryCache<CacheKey, PooledByteBuffer> get(Supplier<MemoryCacheParams> paramSupplier, MemoryTrimmableRegistry paramMemoryTrimmableRegistry)
  {
    paramSupplier = new CountingMemoryCache(new ValueDescriptor()new NativeMemoryCacheTrimStrategy
    {
      public int getSizeInBytes(PooledByteBuffer paramAnonymousPooledByteBuffer)
      {
        return paramAnonymousPooledByteBuffer.size();
      }
    }, new NativeMemoryCacheTrimStrategy(), paramSupplier, null);
    paramMemoryTrimmableRegistry.registerMemoryTrimmable(paramSupplier);
    return paramSupplier;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\EncodedCountingMemoryCacheFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */