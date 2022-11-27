package com.facebook.imagepipeline.producers;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;

public class EncodedCacheKeyMultiplexProducer
  extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, EncodedImage>
{
  private final CacheKeyFactory mCacheKeyFactory;
  
  public EncodedCacheKeyMultiplexProducer(CacheKeyFactory paramCacheKeyFactory, boolean paramBoolean, Producer paramProducer)
  {
    super(paramProducer, "EncodedCacheKeyMultiplexProducer", "multiplex_enc_cnt", paramBoolean);
    this.mCacheKeyFactory = paramCacheKeyFactory;
  }
  
  public EncodedImage cloneOrNull(EncodedImage paramEncodedImage)
  {
    return EncodedImage.cloneOrNull(paramEncodedImage);
  }
  
  protected Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext paramProducerContext)
  {
    return Pair.create(this.mCacheKeyFactory.getEncodedCacheKey(paramProducerContext.getImageRequest(), paramProducerContext.getCallerContext()), paramProducerContext.getLowestPermittedRequestLevel());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\EncodedCacheKeyMultiplexProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */