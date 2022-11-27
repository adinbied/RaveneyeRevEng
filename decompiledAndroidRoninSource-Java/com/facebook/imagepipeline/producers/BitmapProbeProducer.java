package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class BitmapProbeProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String PRODUCER_NAME = "BitmapProbeProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public BitmapProbeProducer(MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, BoundedLinkedHashSet<CacheKey> paramBoundedLinkedHashSet1, BoundedLinkedHashSet<CacheKey> paramBoundedLinkedHashSet2, Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    this.mEncodedMemoryCache = paramMemoryCache;
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mEncodedMemoryCacheHistory = paramBoundedLinkedHashSet1;
    this.mDiskCacheHistory = paramBoundedLinkedHashSet2;
    this.mInputProducer = paramProducer;
  }
  
  protected String getProducerName()
  {
    return "BitmapProbeProducer";
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("BitmapProbeProducer#produceResults");
      }
      ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
      localProducerListener2.onProducerStart(paramProducerContext, getProducerName());
      paramConsumer = new ProbeConsumer(paramConsumer, paramProducerContext, this.mEncodedMemoryCache, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory);
      localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, "BitmapProbeProducer", null);
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("mInputProducer.produceResult");
      }
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
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
  }
  
  private static class ProbeConsumer
    extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
    private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
    private final ProducerContext mProducerContext;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;
    
    public ProbeConsumer(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, BoundedLinkedHashSet<CacheKey> paramBoundedLinkedHashSet1, BoundedLinkedHashSet<CacheKey> paramBoundedLinkedHashSet2)
    {
      super();
      this.mProducerContext = paramProducerContext;
      this.mEncodedMemoryCache = paramMemoryCache;
      this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
      this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
      this.mCacheKeyFactory = paramCacheKeyFactory;
      this.mEncodedMemoryCacheHistory = paramBoundedLinkedHashSet1;
      this.mDiskCacheHistory = paramBoundedLinkedHashSet2;
    }
    
    public void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      for (;;)
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("BitmapProbeProducer#onNewResultImpl");
          }
          if ((!isNotLast(paramInt)) && (paramCloseableReference != null) && (!statusHasAnyFlag(paramInt, 8)))
          {
            Object localObject = this.mProducerContext.getImageRequest();
            CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject, this.mProducerContext.getCallerContext());
            if (this.mProducerContext.getExtra("origin").equals("memory_bitmap"))
            {
              if ((this.mProducerContext.getImagePipelineConfig().getExperiments().isEncodedMemoryCacheProbingEnabled()) && (!this.mEncodedMemoryCacheHistory.contains(localCacheKey)))
              {
                this.mEncodedMemoryCache.probe(localCacheKey);
                this.mEncodedMemoryCacheHistory.add(localCacheKey);
              }
              if ((this.mProducerContext.getImagePipelineConfig().getExperiments().isDiskCacheProbingEnabled()) && (!this.mDiskCacheHistory.contains(localCacheKey)))
              {
                if (((ImageRequest)localObject).getCacheChoice() != ImageRequest.CacheChoice.SMALL) {
                  break label273;
                }
                i = 1;
                if (i != 0) {
                  localObject = this.mSmallImageBufferedDiskCache;
                } else {
                  localObject = this.mDefaultBufferedDiskCache;
                }
                ((BufferedDiskCache)localObject).addKeyForAsyncProbing(localCacheKey);
                this.mDiskCacheHistory.add(localCacheKey);
              }
            }
            getConsumer().onNewResult(paramCloseableReference, paramInt);
          }
          else
          {
            getConsumer().onNewResult(paramCloseableReference, paramInt);
            return;
          }
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
        label273:
        int i = 0;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\BitmapProbeProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */