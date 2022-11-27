package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.nativecode.WebpTranscoder;
import com.facebook.imagepipeline.nativecode.WebpTranscoderFactory;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class WebpTranscodeProducer
  implements Producer<EncodedImage>
{
  private static final int DEFAULT_JPEG_QUALITY = 80;
  public static final String PRODUCER_NAME = "WebpTranscodeProducer";
  private final Executor mExecutor;
  private final Producer<EncodedImage> mInputProducer;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public WebpTranscodeProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, Producer<EncodedImage> paramProducer)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mPooledByteBufferFactory = ((PooledByteBufferFactory)Preconditions.checkNotNull(paramPooledByteBufferFactory));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
  }
  
  private static void doTranscode(EncodedImage paramEncodedImage, PooledByteBufferOutputStream paramPooledByteBufferOutputStream)
    throws Exception
  {
    InputStream localInputStream = paramEncodedImage.getInputStream();
    ImageFormat localImageFormat = ImageFormatChecker.getImageFormat_WrapIOException(localInputStream);
    if ((localImageFormat != DefaultImageFormats.WEBP_SIMPLE) && (localImageFormat != DefaultImageFormats.WEBP_EXTENDED))
    {
      if ((localImageFormat != DefaultImageFormats.WEBP_LOSSLESS) && (localImageFormat != DefaultImageFormats.WEBP_EXTENDED_WITH_ALPHA)) {
        throw new IllegalArgumentException("Wrong image format");
      }
      WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToPng(localInputStream, paramPooledByteBufferOutputStream);
      paramEncodedImage.setImageFormat(DefaultImageFormats.PNG);
      return;
    }
    WebpTranscoderFactory.getWebpTranscoder().transcodeWebpToJpeg(localInputStream, paramPooledByteBufferOutputStream, 80);
    paramEncodedImage.setImageFormat(DefaultImageFormats.JPEG);
  }
  
  private static TriState shouldTranscode(EncodedImage paramEncodedImage)
  {
    Preconditions.checkNotNull(paramEncodedImage);
    paramEncodedImage = ImageFormatChecker.getImageFormat_WrapIOException(paramEncodedImage.getInputStream());
    if (DefaultImageFormats.isStaticWebpFormat(paramEncodedImage))
    {
      WebpTranscoder localWebpTranscoder = WebpTranscoderFactory.getWebpTranscoder();
      if (localWebpTranscoder == null) {
        return TriState.NO;
      }
      return TriState.valueOf(localWebpTranscoder.isWebpNativelySupported(paramEncodedImage) ^ true);
    }
    if (paramEncodedImage == ImageFormat.UNKNOWN) {
      return TriState.UNSET;
    }
    return TriState.NO;
  }
  
  private void transcodeLastResult(final EncodedImage paramEncodedImage, Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    Preconditions.checkNotNull(paramEncodedImage);
    paramEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
    paramEncodedImage = new StatefulProducerRunnable(paramConsumer, paramProducerContext.getProducerListener(), paramProducerContext, "WebpTranscodeProducer")
    {
      protected void disposeResult(EncodedImage paramAnonymousEncodedImage)
      {
        EncodedImage.closeSafely(paramAnonymousEncodedImage);
      }
      
      /* Error */
      protected EncodedImage getResult()
        throws Exception
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 18	com/facebook/imagepipeline/producers/WebpTranscodeProducer$1:this$0	Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;
        //   4: invokestatic 42	com/facebook/imagepipeline/producers/WebpTranscodeProducer:access$200	(Lcom/facebook/imagepipeline/producers/WebpTranscodeProducer;)Lcom/facebook/common/memory/PooledByteBufferFactory;
        //   7: invokeinterface 48 1 0
        //   12: astore_1
        //   13: aload_0
        //   14: getfield 20	com/facebook/imagepipeline/producers/WebpTranscodeProducer$1:val$encodedImageCopy	Lcom/facebook/imagepipeline/image/EncodedImage;
        //   17: aload_1
        //   18: invokestatic 52	com/facebook/imagepipeline/producers/WebpTranscodeProducer:access$300	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/common/memory/PooledByteBufferOutputStream;)V
        //   21: aload_1
        //   22: invokevirtual 58	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
        //   25: invokestatic 64	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
        //   28: astore_2
        //   29: new 28	com/facebook/imagepipeline/image/EncodedImage
        //   32: dup
        //   33: aload_2
        //   34: invokespecial 67	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
        //   37: astore_3
        //   38: aload_3
        //   39: aload_0
        //   40: getfield 20	com/facebook/imagepipeline/producers/WebpTranscodeProducer$1:val$encodedImageCopy	Lcom/facebook/imagepipeline/image/EncodedImage;
        //   43: invokevirtual 70	com/facebook/imagepipeline/image/EncodedImage:copyMetaDataFrom	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
        //   46: aload_2
        //   47: invokestatic 72	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   50: aload_1
        //   51: invokevirtual 76	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
        //   54: aload_3
        //   55: areturn
        //   56: astore_3
        //   57: aload_2
        //   58: invokestatic 72	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
        //   61: aload_3
        //   62: athrow
        //   63: astore_2
        //   64: aload_1
        //   65: invokevirtual 76	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
        //   68: aload_2
        //   69: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	70	0	this	1
        //   12	53	1	localPooledByteBufferOutputStream	PooledByteBufferOutputStream
        //   28	30	2	localCloseableReference	com.facebook.common.references.CloseableReference
        //   63	6	2	localObject1	Object
        //   37	18	3	localEncodedImage	EncodedImage
        //   56	6	3	localObject2	Object
        // Exception table:
        //   from	to	target	type
        //   29	46	56	finally
        //   13	29	63	finally
        //   46	50	63	finally
        //   57	63	63	finally
      }
      
      protected void onCancellation()
      {
        EncodedImage.closeSafely(paramEncodedImage);
        super.onCancellation();
      }
      
      protected void onFailure(Exception paramAnonymousException)
      {
        EncodedImage.closeSafely(paramEncodedImage);
        super.onFailure(paramAnonymousException);
      }
      
      protected void onSuccess(EncodedImage paramAnonymousEncodedImage)
      {
        EncodedImage.closeSafely(paramEncodedImage);
        super.onSuccess(paramAnonymousEncodedImage);
      }
    };
    this.mExecutor.execute(paramEncodedImage);
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new WebpTranscodeConsumer(paramConsumer, paramProducerContext), paramProducerContext);
  }
  
  private class WebpTranscodeConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final ProducerContext mContext;
    private TriState mShouldTranscodeWhenFinished;
    
    public WebpTranscodeConsumer(ProducerContext paramProducerContext)
    {
      super();
      ProducerContext localProducerContext;
      this.mContext = localProducerContext;
      this.mShouldTranscodeWhenFinished = TriState.UNSET;
    }
    
    protected void onNewResultImpl(@Nullable EncodedImage paramEncodedImage, int paramInt)
    {
      if ((this.mShouldTranscodeWhenFinished == TriState.UNSET) && (paramEncodedImage != null)) {
        this.mShouldTranscodeWhenFinished = WebpTranscodeProducer.shouldTranscode(paramEncodedImage);
      }
      if (this.mShouldTranscodeWhenFinished == TriState.NO)
      {
        getConsumer().onNewResult(paramEncodedImage, paramInt);
        return;
      }
      if (isLast(paramInt))
      {
        if ((this.mShouldTranscodeWhenFinished == TriState.YES) && (paramEncodedImage != null))
        {
          WebpTranscodeProducer.this.transcodeLastResult(paramEncodedImage, getConsumer(), this.mContext);
          return;
        }
        getConsumer().onNewResult(paramEncodedImage, paramInt);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\WebpTranscodeProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */