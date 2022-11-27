package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import java.util.Map;

public class PostprocessedBitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String PRODUCER_NAME = "PostprocessedBitmapMemoryCacheProducer";
  static final String VALUE_FOUND = "cached_value_found";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  
  public PostprocessedBitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  protected String getProducerName()
  {
    return "PostprocessedBitmapMemoryCacheProducer";
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
    Object localObject1 = paramProducerContext.getImageRequest();
    Object localObject2 = paramProducerContext.getCallerContext();
    Object localObject4 = ((ImageRequest)localObject1).getPostprocessor();
    if ((localObject4 != null) && (((Postprocessor)localObject4).getPostprocessorCacheKey() != null))
    {
      localProducerListener2.onProducerStart(paramProducerContext, getProducerName());
      CacheKey localCacheKey = this.mCacheKeyFactory.getPostprocessedBitmapCacheKey((ImageRequest)localObject1, localObject2);
      Object localObject3 = this.mMemoryCache.get(localCacheKey);
      localObject1 = null;
      localObject2 = null;
      if (localObject3 != null)
      {
        localObject4 = getProducerName();
        localObject1 = localObject2;
        if (localProducerListener2.requiresExtraMap(paramProducerContext, getProducerName())) {
          localObject1 = ImmutableMap.of("cached_value_found", "true");
        }
        localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, (String)localObject4, (Map)localObject1);
        localProducerListener2.onUltimateProducerReached(paramProducerContext, "PostprocessedBitmapMemoryCacheProducer", true);
        paramProducerContext.putOriginExtra("memory_bitmap", "postprocessed");
        paramConsumer.onProgressUpdate(1.0F);
        paramConsumer.onNewResult(localObject3, 1);
        ((CloseableReference)localObject3).close();
        return;
      }
      boolean bool1 = localObject4 instanceof RepeatedPostprocessor;
      boolean bool2 = paramProducerContext.getImageRequest().isMemoryCacheEnabled();
      localObject2 = new CachedPostprocessorConsumer(paramConsumer, localCacheKey, bool1, this.mMemoryCache, bool2);
      localObject3 = getProducerName();
      paramConsumer = (Consumer<CloseableReference<CloseableImage>>)localObject1;
      if (localProducerListener2.requiresExtraMap(paramProducerContext, getProducerName())) {
        paramConsumer = ImmutableMap.of("cached_value_found", "false");
      }
      localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, (String)localObject3, paramConsumer);
      this.mInputProducer.produceResults((Consumer)localObject2, paramProducerContext);
      return;
    }
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
  
  public static class CachedPostprocessorConsumer
    extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private final CacheKey mCacheKey;
    private final boolean mIsMemoryCachedEnabled;
    private final boolean mIsRepeatedProcessor;
    private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
    
    public CachedPostprocessorConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, CacheKey paramCacheKey, boolean paramBoolean1, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, boolean paramBoolean2)
    {
      super();
      this.mCacheKey = paramCacheKey;
      this.mIsRepeatedProcessor = paramBoolean1;
      this.mMemoryCache = paramMemoryCache;
      this.mIsMemoryCachedEnabled = paramBoolean2;
    }
    
    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      CloseableReference localCloseableReference = null;
      if (paramCloseableReference == null)
      {
        if (isLast(paramInt)) {
          getConsumer().onNewResult(null, paramInt);
        }
        return;
      }
      if ((isNotLast(paramInt)) && (!this.mIsRepeatedProcessor)) {
        return;
      }
      if (this.mIsMemoryCachedEnabled) {
        localCloseableReference = this.mMemoryCache.cache(this.mCacheKey, paramCloseableReference);
      }
      try
      {
        getConsumer().onProgressUpdate(1.0F);
        Consumer localConsumer = getConsumer();
        if (localCloseableReference != null) {
          paramCloseableReference = localCloseableReference;
        }
        localConsumer.onNewResult(paramCloseableReference, paramInt);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(localCloseableReference);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\PostprocessedBitmapMemoryCacheProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */