package com.facebook.imagepipeline.producers;

import com.facebook.cache.common.CacheKey;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class DiskCacheWriteProducer
  implements Producer<EncodedImage>
{
  static final String PRODUCER_NAME = "DiskCacheWriteProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final Producer<EncodedImage> mInputProducer;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public DiskCacheWriteProducer(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramProducerContext.putOriginExtra("disk", "nil-result_write");
      paramConsumer.onNewResult(null, 1);
      return;
    }
    Object localObject = paramConsumer;
    if (paramProducerContext.getImageRequest().isDiskCacheEnabled()) {
      localObject = new DiskCacheWriteConsumer(paramConsumer, paramProducerContext, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, null);
    }
    this.mInputProducer.produceResults((Consumer)localObject, paramProducerContext);
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    maybeStartInputProducer(paramConsumer, paramProducerContext);
  }
  
  private static class DiskCacheWriteConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final CacheKeyFactory mCacheKeyFactory;
    private final BufferedDiskCache mDefaultBufferedDiskCache;
    private final ProducerContext mProducerContext;
    private final BufferedDiskCache mSmallImageBufferedDiskCache;
    
    private DiskCacheWriteConsumer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory)
    {
      super();
      this.mProducerContext = paramProducerContext;
      this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
      this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
      this.mCacheKeyFactory = paramCacheKeyFactory;
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      this.mProducerContext.getProducerListener().onProducerStart(this.mProducerContext, "DiskCacheWriteProducer");
      if ((!isNotLast(paramInt)) && (paramEncodedImage != null) && (!statusHasAnyFlag(paramInt, 10)) && (paramEncodedImage.getImageFormat() != ImageFormat.UNKNOWN))
      {
        ImageRequest localImageRequest = this.mProducerContext.getImageRequest();
        CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(localImageRequest, this.mProducerContext.getCallerContext());
        if (localImageRequest.getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
          this.mSmallImageBufferedDiskCache.put(localCacheKey, paramEncodedImage);
        } else {
          this.mDefaultBufferedDiskCache.put(localCacheKey, paramEncodedImage);
        }
        this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, "DiskCacheWriteProducer", null);
        getConsumer().onNewResult(paramEncodedImage, paramInt);
        return;
      }
      this.mProducerContext.getProducerListener().onProducerFinishWithSuccess(this.mProducerContext, "DiskCacheWriteProducer", null);
      getConsumer().onNewResult(paramEncodedImage, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\DiskCacheWriteProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */