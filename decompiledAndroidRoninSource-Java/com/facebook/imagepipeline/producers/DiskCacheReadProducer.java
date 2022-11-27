package com.facebook.imagepipeline.producers;

import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class DiskCacheReadProducer
  implements Producer<EncodedImage>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_CACHED_VALUE_FOUND = "cached_value_found";
  public static final String PRODUCER_NAME = "DiskCacheProducer";
  private final CacheKeyFactory mCacheKeyFactory;
  private final BufferedDiskCache mDefaultBufferedDiskCache;
  private final Producer<EncodedImage> mInputProducer;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public DiskCacheReadProducer(BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, Producer<EncodedImage> paramProducer)
  {
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mInputProducer = paramProducer;
  }
  
  @Nullable
  static Map<String, String> getExtraMap(ProducerListener2 paramProducerListener2, ProducerContext paramProducerContext, boolean paramBoolean, int paramInt)
  {
    if (!paramProducerListener2.requiresExtraMap(paramProducerContext, "DiskCacheProducer")) {
      return null;
    }
    if (paramBoolean) {
      return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean), "encodedImageSize", String.valueOf(paramInt));
    }
    return ImmutableMap.of("cached_value_found", String.valueOf(paramBoolean));
  }
  
  private static boolean isTaskCancelled(Task<?> paramTask)
  {
    return (paramTask.isCancelled()) || ((paramTask.isFaulted()) && ((paramTask.getError() instanceof CancellationException)));
  }
  
  private void maybeStartInputProducer(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    if (paramProducerContext.getLowestPermittedRequestLevel().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue())
    {
      paramProducerContext.putOriginExtra("disk", "nil-result_read");
      paramConsumer.onNewResult(null, 1);
      return;
    }
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
  
  private Continuation<EncodedImage, Void> onFinishDiskReads(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext)
  {
    new Continuation()
    {
      public Void then(Task<EncodedImage> paramAnonymousTask)
        throws Exception
      {
        if (DiskCacheReadProducer.isTaskCancelled(paramAnonymousTask))
        {
          this.val$listener.onProducerFinishWithCancellation(paramProducerContext, "DiskCacheProducer", null);
          paramConsumer.onCancellation();
          return null;
        }
        if (paramAnonymousTask.isFaulted())
        {
          this.val$listener.onProducerFinishWithFailure(paramProducerContext, "DiskCacheProducer", paramAnonymousTask.getError(), null);
          DiskCacheReadProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
          return null;
        }
        paramAnonymousTask = (EncodedImage)paramAnonymousTask.getResult();
        if (paramAnonymousTask != null)
        {
          localObject = this.val$listener;
          ProducerContext localProducerContext = paramProducerContext;
          ((ProducerListener2)localObject).onProducerFinishWithSuccess(localProducerContext, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap((ProducerListener2)localObject, localProducerContext, true, paramAnonymousTask.getSize()));
          this.val$listener.onUltimateProducerReached(paramProducerContext, "DiskCacheProducer", true);
          paramProducerContext.putOriginExtra("disk");
          paramConsumer.onProgressUpdate(1.0F);
          paramConsumer.onNewResult(paramAnonymousTask, 1);
          paramAnonymousTask.close();
          return null;
        }
        paramAnonymousTask = this.val$listener;
        Object localObject = paramProducerContext;
        paramAnonymousTask.onProducerFinishWithSuccess((ProducerContext)localObject, "DiskCacheProducer", DiskCacheReadProducer.getExtraMap(paramAnonymousTask, (ProducerContext)localObject, false, 0));
        DiskCacheReadProducer.this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
        return null;
      }
    };
  }
  
  private void subscribeTaskForRequestCancellation(final AtomicBoolean paramAtomicBoolean, ProducerContext paramProducerContext)
  {
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramAtomicBoolean.set(true);
      }
    });
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    Object localObject = paramProducerContext.getImageRequest();
    if (!((ImageRequest)localObject).isDiskCacheEnabled())
    {
      maybeStartInputProducer(paramConsumer, paramProducerContext);
      return;
    }
    paramProducerContext.getProducerListener().onProducerStart(paramProducerContext, "DiskCacheProducer");
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey((ImageRequest)localObject, paramProducerContext.getCallerContext());
    int i;
    if (((ImageRequest)localObject).getCacheChoice() == ImageRequest.CacheChoice.SMALL) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      localObject = this.mSmallImageBufferedDiskCache;
    } else {
      localObject = this.mDefaultBufferedDiskCache;
    }
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(false);
    ((BufferedDiskCache)localObject).get(localCacheKey, localAtomicBoolean).continueWith(onFinishDiskReads(paramConsumer, paramProducerContext));
    subscribeTaskForRequestCancellation(localAtomicBoolean, paramProducerContext);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\DiskCacheReadProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */