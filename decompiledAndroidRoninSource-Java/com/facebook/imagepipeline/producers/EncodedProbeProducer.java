package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class EncodedProbeProducer
  implements Producer<EncodedImage>
{
  public static final String PRODUCER_NAME = "EncodedProbeProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
  private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
  private final Producer<EncodedImage> mInputProducer;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public EncodedProbeProducer(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, BoundedLinkedHashSet paramBoundedLinkedHashSet1, BoundedLinkedHashSet paramBoundedLinkedHashSet2, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mEncodedMemoryCacheHistory = paramBoundedLinkedHashSet1;
    this.mDiskCacheHistory = paramBoundedLinkedHashSet2;
    this.mInputProducer = paramProducer;
  }
  
  protected String getProducerName()
  {
    return "EncodedProbeProducer";
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("EncodedProbeProducer#produceResults");
      }
      ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
      localProducerListener2.onProducerStart(paramProducerContext, getProducerName());
      paramConsumer = new ProbeConsumer(paramConsumer, paramProducerContext, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory);
      localProducerListener2.onProducerFinishWithSuccess(paramProducerContext, "EncodedProbeProducer", null);
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
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
    private final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
    private final ProducerContext mProducerContext;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;
    
    public ProbeConsumer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, BoundedLinkedHashSet<CacheKey> paramBoundedLinkedHashSet1, BoundedLinkedHashSet<CacheKey> paramBoundedLinkedHashSet2)
    {
      super();
      this.mProducerContext = paramProducerContext;
      this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
      this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
      this.mCacheKeyFactory = paramCacheKeyFactory;
      this.mEncodedMemoryCacheHistory = paramBoundedLinkedHashSet1;
      this.mDiskCacheHistory = paramBoundedLinkedHashSet2;
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      for (;;)
      {
        try
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("EncodedProbeProducer#onNewResultImpl");
          }
          if ((!isNotLast(paramInt)) && (paramEncodedImage != null) && (!statusHasAnyFlag(paramInt, 10)) && (paramEncodedImage.getImageFormat() != ImageFormat.UNKNOWN))
          {
            Object localObject = this.mProducerContext.getImageRequest();
            CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject, this.mProducerContext.getCallerContext());
            this.mEncodedMemoryCacheHistory.add(localCacheKey);
            if (this.mProducerContext.getExtra("origin").equals("memory_encoded"))
            {
              if (!this.mDiskCacheHistory.contains(localCacheKey))
              {
                if (((ImageRequest)localObject).getCacheChoice() != ImageRequest.CacheChoice.SMALL) {
                  break label256;
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
            else if (this.mProducerContext.getExtra("origin").equals("disk")) {
              this.mDiskCacheHistory.add(localCacheKey);
            }
            getConsumer().onNewResult(paramEncodedImage, paramInt);
          }
          else
          {
            getConsumer().onNewResult(paramEncodedImage, paramInt);
            return;
          }
        }
        finally
        {
          if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
          }
        }
        label256:
        int i = 0;
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\EncodedProbeProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */