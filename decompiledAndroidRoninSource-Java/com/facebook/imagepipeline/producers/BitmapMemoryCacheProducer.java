package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.HasImageMetadata;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;

public class BitmapMemoryCacheProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  private static final String ORIGIN_SUBCATEGORY = "pipe_bg";
  public static final String PRODUCER_NAME = "BitmapMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final MemoryCache<CacheKey, CloseableImage> mMemoryCache;
  
  public BitmapMemoryCacheProducer(MemoryCache<CacheKey, CloseableImage> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  private static void maybeSetExtrasFromCloseableImage(HasImageMetadata paramHasImageMetadata, ProducerContext paramProducerContext)
  {
    paramProducerContext.putExtras(paramHasImageMetadata.getExtras());
  }
  
  protected String getOriginSubcategory()
  {
    return "pipe_bg";
  }
  
  protected String getProducerName()
  {
    return "BitmapMemoryCacheProducer";
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    for (;;)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("BitmapMemoryCacheProducer#produceResults");
        }
        ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
        localProducerListener2.onProducerStart(paramProducerContext, getProducerName());
        localObject1 = paramProducerContext.getImageRequest();
        Object localObject2 = paramProducerContext.getCallerContext();
        Object localObject3 = this.mCacheKeyFactory.getBitmapCacheKey((ImageRequest)localObject1, localObject2);
        CloseableReference localCloseableReference = this.mMemoryCache.get(localObject3);
        localObject2 = null;
        if (localCloseableReference != null)
        {
          maybeSetExtrasFromCloseableImage((HasImageMetadata)localCloseableReference.get(), paramProducerContext);
          boolean bool = ((CloseableImage)localCloseableReference.get()).getQualityInfo().isOfFullQuality();
          if (bool)
          {
            String str = getProducerName();
            if (!localProducerListener2.requiresExtraMap(paramProducerContext, getProducerName())) {
              break label455;
            }
            localObject1 = ImmutableMap.of("cached_value_found", "true");
            localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, str, (Map)localObject1);
            localProducerListener2.onUltimateProducerReached(paramProducerContext, getProducerName(), true);
            paramProducerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
            paramConsumer.onProgressUpdate(1.0F);
          }
          paramConsumer.onNewResult(localCloseableReference, BaseConsumer.simpleStatusForIsLast(bool));
          localCloseableReference.close();
          if (bool) {
            return;
          }
        }
        int i = paramProducerContext.getLowestPermittedRequestLevel().getValue();
        int j = ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue();
        if (i >= j)
        {
          localObject2 = getProducerName();
          if (!localProducerListener2.requiresExtraMap(paramProducerContext, getProducerName())) {
            break label461;
          }
          localObject1 = ImmutableMap.of("cached_value_found", "false");
          localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, (String)localObject2, (Map)localObject1);
          localProducerListener2.onUltimateProducerReached(paramProducerContext, getProducerName(), false);
          paramProducerContext.putOriginExtra("memory_bitmap", getOriginSubcategory());
          paramConsumer.onNewResult(null, 1);
          return;
        }
        localObject1 = wrapConsumer(paramConsumer, (CacheKey)localObject3, paramProducerContext.getImageRequest().isMemoryCacheEnabled());
        localObject3 = getProducerName();
        paramConsumer = (Consumer<CloseableReference<CloseableImage>>)localObject2;
        if (localProducerListener2.requiresExtraMap(paramProducerContext, getProducerName())) {
          paramConsumer = ImmutableMap.of("cached_value_found", "false");
        }
        localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, (String)localObject3, paramConsumer);
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("mInputProducer.produceResult");
        }
        this.mInputProducer.produceResults((Consumer)localObject1, paramProducerContext);
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
        return;
      }
      finally
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
      label455:
      Object localObject1 = null;
      continue;
      label461:
      localObject1 = null;
    }
  }
  
  protected Consumer<CloseableReference<CloseableImage>> wrapConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, final CacheKey paramCacheKey, final boolean paramBoolean)
  {
    new DelegatingConsumer(paramConsumer)
    {
      public void onNewResultImpl(CloseableReference<CloseableImage> paramAnonymousCloseableReference, int paramAnonymousInt)
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("BitmapMemoryCacheProducer#onNewResultImpl");
          }
          boolean bool = isLast(paramAnonymousInt);
          CloseableReference localCloseableReference = null;
          if (paramAnonymousCloseableReference == null)
          {
            if (bool) {
              getConsumer().onNewResult(null, paramAnonymousInt);
            }
            return;
          }
          if ((!((CloseableImage)paramAnonymousCloseableReference.get()).isStateful()) && (!statusHasFlag(paramAnonymousInt, 8)))
          {
            Object localObject;
            if (!bool)
            {
              localObject = BitmapMemoryCacheProducer.this.mMemoryCache.get(paramCacheKey);
              if (localObject != null) {
                try
                {
                  QualityInfo localQualityInfo1 = ((CloseableImage)paramAnonymousCloseableReference.get()).getQualityInfo();
                  QualityInfo localQualityInfo2 = ((CloseableImage)((CloseableReference)localObject).get()).getQualityInfo();
                  if (!localQualityInfo2.isOfFullQuality())
                  {
                    int i = localQualityInfo2.getQuality();
                    int j = localQualityInfo1.getQuality();
                    if (i < j)
                    {
                      CloseableReference.closeSafely((CloseableReference)localObject);
                      break label207;
                    }
                  }
                  getConsumer().onNewResult(localObject, paramAnonymousInt);
                  CloseableReference.closeSafely((CloseableReference)localObject);
                  return;
                }
                finally
                {
                  CloseableReference.closeSafely((CloseableReference)localObject);
                }
              }
            }
            label207:
            if (paramBoolean) {
              localCloseableReference = BitmapMemoryCacheProducer.this.mMemoryCache.cache(paramCacheKey, paramAnonymousCloseableReference);
            }
            if (bool) {}
            try
            {
              getConsumer().onProgressUpdate(1.0F);
              localObject = getConsumer();
              if (localCloseableReference != null) {
                paramAnonymousCloseableReference = localCloseableReference;
              }
              ((Consumer)localObject).onNewResult(paramAnonymousCloseableReference, paramAnonymousInt);
              CloseableReference.closeSafely(localCloseableReference);
              return;
            }
            finally
            {
              CloseableReference.closeSafely(localCloseableReference);
            }
          }
          getConsumer().onNewResult(paramAnonymousCloseableReference, paramAnonymousInt);
          return;
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\BitmapMemoryCacheProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */