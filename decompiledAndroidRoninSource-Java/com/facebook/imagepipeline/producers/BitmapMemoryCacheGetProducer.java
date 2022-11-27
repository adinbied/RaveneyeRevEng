package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;

public class BitmapMemoryCacheGetProducer
  extends BitmapMemoryCacheProducer
{
  private static final String ORIGIN_SUBCATEGORY = "pipe_ui";
  public static final String PRODUCER_NAME = "BitmapMemoryCacheGetProducer";
  
  public BitmapMemoryCacheGetProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    super(paramMemoryCache, paramCacheKeyFactory, paramProducer);
  }
  
  protected String getOriginSubcategory()
  {
    return "pipe_ui";
  }
  
  protected String getProducerName()
  {
    return "BitmapMemoryCacheGetProducer";
  }
  
  protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, CacheKey paramCacheKey, boolean paramBoolean)
  {
    return paramConsumer;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\BitmapMemoryCacheGetProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */