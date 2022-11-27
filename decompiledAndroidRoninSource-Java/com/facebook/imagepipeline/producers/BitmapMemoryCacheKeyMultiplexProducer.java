package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class BitmapMemoryCacheKeyMultiplexProducer
  extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, CloseableReference<CloseableImage>>
{
  private final CacheKeyFactory mCacheKeyFactory;
  
  public BitmapMemoryCacheKeyMultiplexProducer(CacheKeyFactory paramCacheKeyFactory, Producer paramProducer)
  {
    super(paramProducer, "BitmapMemoryCacheKeyMultiplexProducer", "multiplex_bmp_cnt");
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }
  
  public CloseableReference<CloseableImage> cloneOrNull(CloseableReference<CloseableImage> paramCloseableReference)
  {
    return CloseableReference.cloneOrNull(paramCloseableReference);
  }
  
  protected Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext paramProducerContext)
  {
    return Pair.create(this.mCacheKeyFactory.getBitmapCacheKey(paramProducerContext.getImageRequest(), paramProducerContext.getCallerContext()), paramProducerContext.getLowestPermittedRequestLevel());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\BitmapMemoryCacheKeyMultiplexProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */