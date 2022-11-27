package com.facebook.imagepipeline.cache;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;

public class DefaultEncodedMemoryCacheParamsSupplier
  implements Supplier<MemoryCacheParams>
{
  private static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
  private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
  private static final long PARAMS_CHECK_INTERVAL_MS = TimeUnit.MINUTES.toMillis(5L);
  
  private int getMaxCacheSize()
  {
    int i = (int)Math.min(Runtime.getRuntime().maxMemory(), 2147483647L);
    if (i < 16777216) {
      return 1048576;
    }
    if (i < 33554432) {
      return 2097152;
    }
    return 4194304;
  }
  
  public MemoryCacheParams get()
  {
    int i = getMaxCacheSize();
    return new MemoryCacheParams(i, Integer.MAX_VALUE, i, Integer.MAX_VALUE, i / 8, PARAMS_CHECK_INTERVAL_MS);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\DefaultEncodedMemoryCacheParamsSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */