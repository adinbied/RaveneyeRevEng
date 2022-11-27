package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Closeables;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public abstract class LocalFetchProducer
  implements Producer<EncodedImage>
{
  private final Executor mExecutor;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  protected LocalFetchProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory)
  {
    this.mExecutor = paramExecutor;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
  }
  
  protected EncodedImage getByteBufferBackedEncodedImage(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    Object localObject1 = null;
    if (paramInt <= 0) {}
    try
    {
      Object localObject2 = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(paramInputStream));
      localObject1 = localObject2;
      break label46;
      localObject2 = CloseableReference.of(this.mPooledByteBufferFactory.newByteBuffer(paramInputStream, paramInt));
      localObject1 = localObject2;
      label46:
      localObject2 = localObject1;
      localObject1 = localObject2;
      EncodedImage localEncodedImage = new EncodedImage((CloseableReference)localObject2);
      return localEncodedImage;
    }
    finally
    {
      Closeables.closeQuietly(paramInputStream);
      CloseableReference.closeSafely((CloseableReference)localObject1);
    }
  }
  
  protected abstract EncodedImage getEncodedImage(ImageRequest paramImageRequest)
    throws IOException;
  
  protected EncodedImage getEncodedImage(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return getByteBufferBackedEncodedImage(paramInputStream, paramInt);
  }
  
  protected abstract String getProducerName();
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, final ProducerContext paramProducerContext)
  {
    final ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
    final ImageRequest localImageRequest = paramProducerContext.getImageRequest();
    paramProducerContext.putOriginExtra("local", "fetch");
    paramConsumer = new StatefulProducerRunnable(paramConsumer, localProducerListener2, paramProducerContext, getProducerName())
    {
      protected void disposeResult(EncodedImage paramAnonymousEncodedImage)
      {
        EncodedImage.closeSafely(paramAnonymousEncodedImage);
      }
      
      @Nullable
      protected EncodedImage getResult()
        throws Exception
      {
        EncodedImage localEncodedImage = LocalFetchProducer.this.getEncodedImage(localImageRequest);
        if (localEncodedImage == null)
        {
          localProducerListener2.onUltimateProducerReached(paramProducerContext, LocalFetchProducer.this.getProducerName(), false);
          paramProducerContext.putOriginExtra("local");
          return null;
        }
        localEncodedImage.parseMetaData();
        localProducerListener2.onUltimateProducerReached(paramProducerContext, LocalFetchProducer.this.getProducerName(), true);
        paramProducerContext.putOriginExtra("local");
        return localEncodedImage;
      }
    };
    paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
    {
      public void onCancellationRequested()
      {
        paramConsumer.cancel();
      }
    });
    this.mExecutor.execute(paramConsumer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\LocalFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */