package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteBufferOutputStream;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

public class NetworkFetchProducer
  implements Producer<EncodedImage>
{
  public static final String INTERMEDIATE_RESULT_PRODUCER_EVENT = "intermediate_result";
  public static final String PRODUCER_NAME = "NetworkFetchProducer";
  private static final int READ_SIZE = 16384;
  static final long TIME_BETWEEN_PARTIAL_RESULTS_MS = 100L;
  private final ByteArrayPool mByteArrayPool;
  private final NetworkFetcher mNetworkFetcher;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public NetworkFetchProducer(PooledByteBufferFactory paramPooledByteBufferFactory, ByteArrayPool paramByteArrayPool, NetworkFetcher paramNetworkFetcher)
  {
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mByteArrayPool = paramByteArrayPool;
    this.mNetworkFetcher = paramNetworkFetcher;
  }
  
  protected static float calculateProgress(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 0) {
      return paramInt1 / paramInt2;
    }
    return 1.0F - (float)Math.exp(-paramInt1 / 50000.0D);
  }
  
  @Nullable
  private Map<String, String> getExtraMap(FetchState paramFetchState, int paramInt)
  {
    if (!paramFetchState.getListener().requiresExtraMap(paramFetchState.getContext(), "NetworkFetchProducer")) {
      return null;
    }
    return this.mNetworkFetcher.getExtraMap(paramFetchState, paramInt);
  }
  
  /* Error */
  protected static void notifyConsumer(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, int paramInt, @Nullable com.facebook.imagepipeline.common.BytesRange paramBytesRange, Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 97	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
    //   4: invokestatic 103	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
    //   7: astore 6
    //   9: aconst_null
    //   10: astore_0
    //   11: new 105	com/facebook/imagepipeline/image/EncodedImage
    //   14: dup
    //   15: aload 6
    //   17: invokespecial 108	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
    //   20: astore 5
    //   22: aload 5
    //   24: aload_2
    //   25: invokevirtual 112	com/facebook/imagepipeline/image/EncodedImage:setBytesRange	(Lcom/facebook/imagepipeline/common/BytesRange;)V
    //   28: aload 5
    //   30: invokevirtual 115	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
    //   33: aload 4
    //   35: getstatic 121	com/facebook/imagepipeline/image/EncodedImageOrigin:NETWORK	Lcom/facebook/imagepipeline/image/EncodedImageOrigin;
    //   38: invokeinterface 127 2 0
    //   43: aload_3
    //   44: aload 5
    //   46: iload_1
    //   47: invokeinterface 133 3 0
    //   52: aload 5
    //   54: invokestatic 137	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   57: aload 6
    //   59: invokestatic 139	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   62: return
    //   63: astore_2
    //   64: aload 5
    //   66: astore_0
    //   67: goto +4 -> 71
    //   70: astore_2
    //   71: aload_0
    //   72: invokestatic 137	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
    //   75: aload 6
    //   77: invokestatic 139	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	paramPooledByteBufferOutputStream	PooledByteBufferOutputStream
    //   0	82	1	paramInt	int
    //   0	82	2	paramBytesRange	com.facebook.imagepipeline.common.BytesRange
    //   0	82	3	paramConsumer	Consumer<EncodedImage>
    //   0	82	4	paramProducerContext	ProducerContext
    //   20	45	5	localEncodedImage	EncodedImage
    //   7	69	6	localCloseableReference	com.facebook.common.references.CloseableReference
    // Exception table:
    //   from	to	target	type
    //   22	52	63	finally
    //   11	22	70	finally
  }
  
  private void onCancellation(FetchState paramFetchState)
  {
    paramFetchState.getListener().onProducerFinishWithCancellation(paramFetchState.getContext(), "NetworkFetchProducer", null);
    paramFetchState.getConsumer().onCancellation();
  }
  
  private void onFailure(FetchState paramFetchState, Throwable paramThrowable)
  {
    paramFetchState.getListener().onProducerFinishWithFailure(paramFetchState.getContext(), "NetworkFetchProducer", paramThrowable, null);
    paramFetchState.getListener().onUltimateProducerReached(paramFetchState.getContext(), "NetworkFetchProducer", false);
    paramFetchState.getContext().putOriginExtra("network");
    paramFetchState.getConsumer().onFailure(paramThrowable);
  }
  
  private boolean shouldPropagateIntermediateResults(FetchState paramFetchState)
  {
    if (!paramFetchState.getContext().isIntermediateResultExpected()) {
      return false;
    }
    return this.mNetworkFetcher.shouldPropagate(paramFetchState);
  }
  
  protected long getSystemUptime()
  {
    return SystemClock.uptimeMillis();
  }
  
  protected void handleFinalResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    Map localMap = getExtraMap(paramFetchState, paramPooledByteBufferOutputStream.size());
    ProducerListener2 localProducerListener2 = paramFetchState.getListener();
    localProducerListener2.onProducerFinishWithSuccess(paramFetchState.getContext(), "NetworkFetchProducer", localMap);
    localProducerListener2.onUltimateProducerReached(paramFetchState.getContext(), "NetworkFetchProducer", true);
    paramFetchState.getContext().putOriginExtra("network");
    notifyConsumer(paramPooledByteBufferOutputStream, paramFetchState.getOnNewResultStatusFlags() | 0x1, paramFetchState.getResponseBytesRange(), paramFetchState.getConsumer(), paramFetchState.getContext());
  }
  
  protected void maybeHandleIntermediateResult(PooledByteBufferOutputStream paramPooledByteBufferOutputStream, FetchState paramFetchState)
  {
    long l = getSystemUptime();
    if ((shouldPropagateIntermediateResults(paramFetchState)) && (l - paramFetchState.getLastIntermediateResultTimeMs() >= 100L))
    {
      paramFetchState.setLastIntermediateResultTimeMs(l);
      paramFetchState.getListener().onProducerEvent(paramFetchState.getContext(), "NetworkFetchProducer", "intermediate_result");
      notifyConsumer(paramPooledByteBufferOutputStream, paramFetchState.getOnNewResultStatusFlags(), paramFetchState.getResponseBytesRange(), paramFetchState.getConsumer(), paramFetchState.getContext());
    }
  }
  
  protected void onResponse(FetchState paramFetchState, InputStream paramInputStream, int paramInt)
    throws IOException
  {
    PooledByteBufferOutputStream localPooledByteBufferOutputStream;
    if (paramInt > 0) {
      localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream(paramInt);
    } else {
      localPooledByteBufferOutputStream = this.mPooledByteBufferFactory.newOutputStream();
    }
    byte[] arrayOfByte = (byte[])this.mByteArrayPool.get(16384);
    try
    {
      for (;;)
      {
        int i = paramInputStream.read(arrayOfByte);
        if (i < 0) {
          break;
        }
        if (i > 0)
        {
          localPooledByteBufferOutputStream.write(arrayOfByte, 0, i);
          maybeHandleIntermediateResult(localPooledByteBufferOutputStream, paramFetchState);
          float f = calculateProgress(localPooledByteBufferOutputStream.size(), paramInt);
          paramFetchState.getConsumer().onProgressUpdate(f);
        }
      }
      this.mNetworkFetcher.onFetchCompletion(paramFetchState, localPooledByteBufferOutputStream.size());
      handleFinalResult(localPooledByteBufferOutputStream, paramFetchState);
      return;
    }
    finally
    {
      this.mByteArrayPool.release(arrayOfByte);
      localPooledByteBufferOutputStream.close();
    }
  }
  
  public void produceResults(final Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    paramProducerContext.getProducerListener().onProducerStart(paramProducerContext, "NetworkFetchProducer");
    paramConsumer = this.mNetworkFetcher.createFetchState(paramConsumer, paramProducerContext);
    this.mNetworkFetcher.fetch(paramConsumer, new NetworkFetcher.Callback()
    {
      public void onCancellation()
      {
        NetworkFetchProducer.this.onCancellation(paramConsumer);
      }
      
      public void onFailure(Throwable paramAnonymousThrowable)
      {
        NetworkFetchProducer.this.onFailure(paramConsumer, paramAnonymousThrowable);
      }
      
      public void onResponse(InputStream paramAnonymousInputStream, int paramAnonymousInt)
        throws IOException
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("NetworkFetcher->onResponse");
        }
        NetworkFetchProducer.this.onResponse(paramConsumer, paramAnonymousInputStream, paramAnonymousInt);
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.endSection();
        }
      }
    });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\NetworkFetchProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */