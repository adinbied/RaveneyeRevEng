package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Map;

public class EncodedMemoryCacheProducer
  implements Producer<EncodedImage>
{
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "EncodedMemoryCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final Producer<EncodedImage> mInputProducer;
  private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
  
  public EncodedMemoryCacheProducer(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mMemoryCache = paramMemoryCache;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    for (;;)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("EncodedMemoryCacheProducer#produceResults");
        }
        ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
        localProducerListener2.onProducerStart(paramProducerContext, "EncodedMemoryCacheProducer");
        Object localObject = paramProducerContext.getImageRequest();
        CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject, paramProducerContext.getCallerContext());
        CloseableReference localCloseableReference = this.mMemoryCache.get(localCacheKey);
        EncodedImage localEncodedImage = null;
        localObject = null;
        if (localCloseableReference != null) {}
        try
        {
          localEncodedImage = new EncodedImage(localCloseableReference);
          try
          {
            if (localProducerListener2.requiresExtraMap(paramProducerContext, "EncodedMemoryCacheProducer")) {
              localObject = ImmutableMap.of("cached_value_found", "true");
            }
            localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, "EncodedMemoryCacheProducer", (Map)localObject);
            localProducerListener2.onUltimateProducerReached(paramProducerContext, "EncodedMemoryCacheProducer", true);
            paramProducerContext.putOriginExtra("memory_encoded");
            paramConsumer.onProgressUpdate(1.0F);
            paramConsumer.onNewResult(localEncodedImage, 1);
            EncodedImage.closeSafely(localEncodedImage);
            CloseableReference.closeSafely(localCloseableReference);
            return;
          }
          finally {}
          int i = paramProducerContext.getLowestPermittedRequestLevel().getValue();
          int j = ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue();
          if (i >= j)
          {
            if (localProducerListener2.requiresExtraMap(paramProducerContext, "EncodedMemoryCacheProducer"))
            {
              localObject = ImmutableMap.of("cached_value_found", "false");
              localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, "EncodedMemoryCacheProducer", (Map)localObject);
              localProducerListener2.onUltimateProducerReached(paramProducerContext, "EncodedMemoryCacheProducer", false);
              paramProducerContext.putOriginExtra("memory_encoded", "nil-result");
              paramConsumer.onNewResult(null, 1);
              CloseableReference.closeSafely(localCloseableReference);
            }
          }
          else
          {
            boolean bool = paramProducerContext.getImageRequest().isMemoryCacheEnabled();
            localObject = new EncodedMemoryCacheConsumer(paramConsumer, this.mMemoryCache, localCacheKey, bool, paramProducerContext.getImagePipelineConfig().getExperiments().isEncodedCacheEnabled());
            paramConsumer = localEncodedImage;
            if (localProducerListener2.requiresExtraMap(paramProducerContext, "EncodedMemoryCacheProducer")) {
              paramConsumer = ImmutableMap.of("cached_value_found", "false");
            }
            localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, "EncodedMemoryCacheProducer", paramConsumer);
            this.mInputProducer.produceResults((Consumer)localObject, paramProducerContext);
            CloseableReference.closeSafely(localCloseableReference);
            return;
          }
        }
        finally
        {
          CloseableReference.closeSafely(localCloseableReference);
        }
        localObject = null;
      }
      finally
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
    }
  }
  
  private static class EncodedMemoryCacheConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final boolean mEncodedCacheEnabled;
    private final boolean mIsMemoryCacheEnabled;
    private final MemoryCache<CacheKey, PooledByteBuffer> mMemoryCache;
    private final CacheKey mRequestedCacheKey;
    
    public EncodedMemoryCacheConsumer(Consumer<EncodedImage> paramConsumer, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, CacheKey paramCacheKey, boolean paramBoolean1, boolean paramBoolean2)
    {
      super();
      this.mMemoryCache = paramMemoryCache;
      this.mRequestedCacheKey = paramCacheKey;
      this.mIsMemoryCacheEnabled = paramBoolean1;
      this.mEncodedCacheEnabled = paramBoolean2;
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("EncodedMemoryCacheProducer#onNewResultImpl");
        }
        if ((!isNotLast(paramInt)) && (paramEncodedImage != null) && (!statusHasAnyFlag(paramInt, 10)) && (paramEncodedImage.getImageFormat() != ImageFormat.UNKNOWN))
        {
          CloseableReference localCloseableReference = paramEncodedImage.getByteBufferRef();
          if (localCloseableReference != null)
          {
            EncodedImage localEncodedImage = null;
            Object localObject = localEncodedImage;
            try
            {
              if (this.mEncodedCacheEnabled)
              {
                localObject = localEncodedImage;
                if (this.mIsMemoryCacheEnabled) {
                  localObject = this.mMemoryCache.cache(this.mRequestedCacheKey, localCloseableReference);
                }
              }
              CloseableReference.closeSafely(localCloseableReference);
              if (localObject != null) {
                try
                {
                  localEncodedImage = new EncodedImage((CloseableReference)localObject);
                  localEncodedImage.copyMetaDataFrom(paramEncodedImage);
                  CloseableReference.closeSafely((CloseableReference)localObject);
                  try
                  {
                    getConsumer().onProgressUpdate(1.0F);
                    getConsumer().onNewResult(localEncodedImage, paramInt);
                    EncodedImage.closeSafely(localEncodedImage);
                    return;
                  }
                  finally {}
                  paramEncodedImage = finally;
                }
                finally
                {
                  CloseableReference.closeSafely((CloseableReference)localObject);
                }
              }
              getConsumer().onNewResult(paramEncodedImage, paramInt);
            }
            finally
            {
              CloseableReference.closeSafely(localCloseableReference);
            }
          }
          return;
        }
        getConsumer().onNewResult(paramEncodedImage, paramInt);
        return;
      }
      finally
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\EncodedMemoryCacheProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */