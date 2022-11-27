package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessorRunner;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class PostprocessorProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String NAME = "PostprocessorProducer";
  static final String POSTPROCESSOR = "Postprocessor";
  private final PlatformBitmapFactory mBitmapFactory;
  private final Executor mExecutor;
  private final Producer<CloseableReference<CloseableImage>> mInputProducer;
  
  public PostprocessorProducer(Producer<CloseableReference<CloseableImage>> paramProducer, PlatformBitmapFactory paramPlatformBitmapFactory, Executor paramExecutor)
  {
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mBitmapFactory = paramPlatformBitmapFactory;
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    ProducerListener2 localProducerListener2 = paramProducerContext.getProducerListener();
    Postprocessor localPostprocessor = paramProducerContext.getImageRequest().getPostprocessor();
    paramConsumer = new PostprocessorConsumer(paramConsumer, localProducerListener2, localPostprocessor, paramProducerContext);
    if ((localPostprocessor instanceof RepeatedPostprocessor)) {
      paramConsumer = new RepeatedPostprocessorConsumer(paramConsumer, (RepeatedPostprocessor)localPostprocessor, paramProducerContext, null);
    } else {
      paramConsumer = new SingleUsePostprocessorConsumer(paramConsumer, null);
    }
    this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
  }
  
  private class PostprocessorConsumer
    extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private boolean mIsClosed;
    private boolean mIsDirty = false;
    private boolean mIsPostProcessingRunning = false;
    private final ProducerListener2 mListener;
    private final Postprocessor mPostprocessor;
    private final ProducerContext mProducerContext;
    @Nullable
    private CloseableReference<CloseableImage> mSourceImageRef = null;
    private int mStatus = 0;
    
    public PostprocessorConsumer(ProducerListener2 paramProducerListener2, Postprocessor paramPostprocessor, ProducerContext paramProducerContext)
    {
      super();
      this.mListener = paramPostprocessor;
      this.mPostprocessor = paramProducerContext;
      ProducerContext localProducerContext;
      this.mProducerContext = localProducerContext;
      localProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          PostprocessorProducer.PostprocessorConsumer.this.maybeNotifyOnCancellation();
        }
      });
    }
    
    private void clearRunningAndStartIfDirty()
    {
      try
      {
        this.mIsPostProcessingRunning = false;
        boolean bool = setRunningIfDirtyAndNotRunning();
        if (bool) {
          submitPostprocessing();
        }
        return;
      }
      finally {}
    }
    
    private boolean close()
    {
      try
      {
        if (this.mIsClosed) {
          return false;
        }
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = null;
        this.mIsClosed = true;
        CloseableReference.closeSafely(localCloseableReference);
        return true;
      }
      finally {}
    }
    
    /* Error */
    private void doPostprocessing(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 109	com/facebook/common/references/CloseableReference:isValid	(Lcom/facebook/common/references/CloseableReference;)Z
      //   4: invokestatic 115	com/facebook/common/internal/Preconditions:checkArgument	(Z)V
      //   7: aload_0
      //   8: aload_1
      //   9: invokevirtual 119	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
      //   12: checkcast 121	com/facebook/imagepipeline/image/CloseableImage
      //   15: invokespecial 125	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:shouldPostprocess	(Lcom/facebook/imagepipeline/image/CloseableImage;)Z
      //   18: ifne +10 -> 28
      //   21: aload_0
      //   22: aload_1
      //   23: iload_2
      //   24: invokespecial 128	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:maybeNotifyOnNewResult	(Lcom/facebook/common/references/CloseableReference;I)V
      //   27: return
      //   28: aload_0
      //   29: getfield 47	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mListener	Lcom/facebook/imagepipeline/producers/ProducerListener2;
      //   32: aload_0
      //   33: getfield 51	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   36: ldc -126
      //   38: invokeinterface 136 3 0
      //   43: aconst_null
      //   44: astore 4
      //   46: aload 4
      //   48: astore_3
      //   49: aload_0
      //   50: aload_1
      //   51: invokevirtual 119	com/facebook/common/references/CloseableReference:get	()Ljava/lang/Object;
      //   54: checkcast 121	com/facebook/imagepipeline/image/CloseableImage
      //   57: invokespecial 140	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:postprocessInternal	(Lcom/facebook/imagepipeline/image/CloseableImage;)Lcom/facebook/common/references/CloseableReference;
      //   60: astore_1
      //   61: aload_1
      //   62: astore_3
      //   63: aload_0
      //   64: getfield 47	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mListener	Lcom/facebook/imagepipeline/producers/ProducerListener2;
      //   67: aload_0
      //   68: getfield 51	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   71: ldc -126
      //   73: aload_0
      //   74: aload_0
      //   75: getfield 47	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mListener	Lcom/facebook/imagepipeline/producers/ProducerListener2;
      //   78: aload_0
      //   79: getfield 51	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   82: aload_0
      //   83: getfield 49	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mPostprocessor	Lcom/facebook/imagepipeline/request/Postprocessor;
      //   86: invokespecial 144	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:getExtraMap	(Lcom/facebook/imagepipeline/producers/ProducerListener2;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/imagepipeline/request/Postprocessor;)Ljava/util/Map;
      //   89: invokeinterface 148 4 0
      //   94: aload_1
      //   95: astore_3
      //   96: aload_0
      //   97: aload_1
      //   98: iload_2
      //   99: invokespecial 128	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:maybeNotifyOnNewResult	(Lcom/facebook/common/references/CloseableReference;I)V
      //   102: aload_1
      //   103: invokestatic 103	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   106: return
      //   107: astore_1
      //   108: goto +52 -> 160
      //   111: astore_1
      //   112: aload 4
      //   114: astore_3
      //   115: aload_0
      //   116: getfield 47	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mListener	Lcom/facebook/imagepipeline/producers/ProducerListener2;
      //   119: aload_0
      //   120: getfield 51	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   123: ldc -126
      //   125: aload_1
      //   126: aload_0
      //   127: aload_0
      //   128: getfield 47	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mListener	Lcom/facebook/imagepipeline/producers/ProducerListener2;
      //   131: aload_0
      //   132: getfield 51	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   135: aload_0
      //   136: getfield 49	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:mPostprocessor	Lcom/facebook/imagepipeline/request/Postprocessor;
      //   139: invokespecial 144	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:getExtraMap	(Lcom/facebook/imagepipeline/producers/ProducerListener2;Lcom/facebook/imagepipeline/producers/ProducerContext;Lcom/facebook/imagepipeline/request/Postprocessor;)Ljava/util/Map;
      //   142: invokeinterface 152 5 0
      //   147: aload 4
      //   149: astore_3
      //   150: aload_0
      //   151: aload_1
      //   152: invokespecial 156	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:maybeNotifyOnFailure	(Ljava/lang/Throwable;)V
      //   155: aconst_null
      //   156: invokestatic 103	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   159: return
      //   160: aload_3
      //   161: invokestatic 103	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   164: aload_1
      //   165: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	166	0	this	PostprocessorConsumer
      //   0	166	1	paramCloseableReference	CloseableReference<CloseableImage>
      //   0	166	2	paramInt	int
      //   48	113	3	localObject1	Object
      //   44	104	4	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   49	61	107	finally
      //   63	94	107	finally
      //   96	102	107	finally
      //   115	147	107	finally
      //   150	155	107	finally
      //   49	61	111	java/lang/Exception
    }
    
    @Nullable
    private Map<String, String> getExtraMap(ProducerListener2 paramProducerListener2, ProducerContext paramProducerContext, Postprocessor paramPostprocessor)
    {
      if (!paramProducerListener2.requiresExtraMap(paramProducerContext, "PostprocessorProducer")) {
        return null;
      }
      return ImmutableMap.of("Postprocessor", paramPostprocessor.getName());
    }
    
    private boolean isClosed()
    {
      try
      {
        boolean bool = this.mIsClosed;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void maybeNotifyOnCancellation()
    {
      if (close()) {
        getConsumer().onCancellation();
      }
    }
    
    private void maybeNotifyOnFailure(Throwable paramThrowable)
    {
      if (close()) {
        getConsumer().onFailure(paramThrowable);
      }
    }
    
    private void maybeNotifyOnNewResult(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      boolean bool = isLast(paramInt);
      if (((!bool) && (!isClosed())) || ((bool) && (close()))) {
        getConsumer().onNewResult(paramCloseableReference, paramInt);
      }
    }
    
    private CloseableReference<CloseableImage> postprocessInternal(CloseableImage paramCloseableImage)
    {
      CloseableStaticBitmap localCloseableStaticBitmap = (CloseableStaticBitmap)paramCloseableImage;
      Object localObject = localCloseableStaticBitmap.getUnderlyingBitmap();
      localObject = this.mPostprocessor.process((Bitmap)localObject, PostprocessorProducer.this.mBitmapFactory);
      int i = localCloseableStaticBitmap.getRotationAngle();
      int j = localCloseableStaticBitmap.getExifOrientation();
      try
      {
        paramCloseableImage = new CloseableStaticBitmap((CloseableReference)localObject, paramCloseableImage.getQualityInfo(), i, j);
        paramCloseableImage.setImageExtras(localCloseableStaticBitmap.getExtras());
        paramCloseableImage = CloseableReference.of(paramCloseableImage);
        return paramCloseableImage;
      }
      finally
      {
        CloseableReference.closeSafely((CloseableReference)localObject);
      }
    }
    
    private boolean setRunningIfDirtyAndNotRunning()
    {
      try
      {
        if ((!this.mIsClosed) && (this.mIsDirty) && (!this.mIsPostProcessingRunning) && (CloseableReference.isValid(this.mSourceImageRef)))
        {
          this.mIsPostProcessingRunning = true;
          return true;
        }
        return false;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private boolean shouldPostprocess(CloseableImage paramCloseableImage)
    {
      return paramCloseableImage instanceof CloseableStaticBitmap;
    }
    
    private void submitPostprocessing()
    {
      PostprocessorProducer.this.mExecutor.execute(new Runnable()
      {
        /* Error */
        public void run()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   4: astore_2
          //   5: aload_2
          //   6: monitorenter
          //   7: aload_0
          //   8: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   11: invokestatic 28	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:access$300	(Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;)Lcom/facebook/common/references/CloseableReference;
          //   14: astore_3
          //   15: aload_0
          //   16: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   19: invokestatic 32	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:access$400	(Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;)I
          //   22: istore_1
          //   23: aload_0
          //   24: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   27: aconst_null
          //   28: invokestatic 36	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:access$302	(Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
          //   31: pop
          //   32: aload_0
          //   33: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   36: iconst_0
          //   37: invokestatic 40	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:access$502	(Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;Z)Z
          //   40: pop
          //   41: aload_2
          //   42: monitorexit
          //   43: aload_3
          //   44: invokestatic 46	com/facebook/common/references/CloseableReference:isValid	(Lcom/facebook/common/references/CloseableReference;)Z
          //   47: ifeq +26 -> 73
          //   50: aload_0
          //   51: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   54: aload_3
          //   55: iload_1
          //   56: invokestatic 50	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:access$600	(Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;Lcom/facebook/common/references/CloseableReference;I)V
          //   59: aload_3
          //   60: invokestatic 54	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   63: goto +10 -> 73
          //   66: astore_2
          //   67: aload_3
          //   68: invokestatic 54	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
          //   71: aload_2
          //   72: athrow
          //   73: aload_0
          //   74: getfield 20	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer$2:this$1	Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;
          //   77: invokestatic 57	com/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer:access$700	(Lcom/facebook/imagepipeline/producers/PostprocessorProducer$PostprocessorConsumer;)V
          //   80: return
          //   81: astore_3
          //   82: aload_2
          //   83: monitorexit
          //   84: aload_3
          //   85: athrow
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	86	0	this	2
          //   22	34	1	i	int
          //   4	38	2	localPostprocessorConsumer	PostprocessorProducer.PostprocessorConsumer
          //   66	17	2	localObject1	Object
          //   14	54	3	localCloseableReference	CloseableReference
          //   81	4	3	localObject2	Object
          // Exception table:
          //   from	to	target	type
          //   50	59	66	finally
          //   7	43	81	finally
          //   82	84	81	finally
        }
      });
    }
    
    private void updateSourceImageRef(@Nullable CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      try
      {
        if (this.mIsClosed) {
          return;
        }
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = CloseableReference.cloneOrNull(paramCloseableReference);
        this.mStatus = paramInt;
        this.mIsDirty = true;
        boolean bool = setRunningIfDirtyAndNotRunning();
        CloseableReference.closeSafely(localCloseableReference);
        if (bool) {
          submitPostprocessing();
        }
        return;
      }
      finally {}
    }
    
    protected void onCancellationImpl()
    {
      maybeNotifyOnCancellation();
    }
    
    protected void onFailureImpl(Throwable paramThrowable)
    {
      maybeNotifyOnFailure(paramThrowable);
    }
    
    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (!CloseableReference.isValid(paramCloseableReference))
      {
        if (isLast(paramInt)) {
          maybeNotifyOnNewResult(null, paramInt);
        }
        return;
      }
      updateSourceImageRef(paramCloseableReference, paramInt);
    }
  }
  
  class RepeatedPostprocessorConsumer
    extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
    implements RepeatedPostprocessorRunner
  {
    private boolean mIsClosed = false;
    @Nullable
    private CloseableReference<CloseableImage> mSourceImageRef = null;
    
    private RepeatedPostprocessorConsumer(PostprocessorProducer.PostprocessorConsumer paramPostprocessorConsumer, RepeatedPostprocessor paramRepeatedPostprocessor, ProducerContext paramProducerContext)
    {
      super();
      paramRepeatedPostprocessor.setCallback(this);
      paramProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          if (PostprocessorProducer.RepeatedPostprocessorConsumer.this.close()) {
            PostprocessorProducer.RepeatedPostprocessorConsumer.this.getConsumer().onCancellation();
          }
        }
      });
    }
    
    private boolean close()
    {
      try
      {
        if (this.mIsClosed) {
          return false;
        }
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = null;
        this.mIsClosed = true;
        CloseableReference.closeSafely(localCloseableReference);
        return true;
      }
      finally {}
    }
    
    private void setSourceImageRef(CloseableReference<CloseableImage> paramCloseableReference)
    {
      try
      {
        if (this.mIsClosed) {
          return;
        }
        CloseableReference localCloseableReference = this.mSourceImageRef;
        this.mSourceImageRef = CloseableReference.cloneOrNull(paramCloseableReference);
        CloseableReference.closeSafely(localCloseableReference);
        return;
      }
      finally {}
    }
    
    /* Error */
    private void updateInternal()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 29	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:mIsClosed	Z
      //   6: ifeq +6 -> 12
      //   9: aload_0
      //   10: monitorexit
      //   11: return
      //   12: aload_0
      //   13: getfield 31	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:mSourceImageRef	Lcom/facebook/common/references/CloseableReference;
      //   16: invokestatic 67	com/facebook/common/references/CloseableReference:cloneOrNull	(Lcom/facebook/common/references/CloseableReference;)Lcom/facebook/common/references/CloseableReference;
      //   19: astore_1
      //   20: aload_0
      //   21: monitorexit
      //   22: aload_0
      //   23: invokevirtual 75	com/facebook/imagepipeline/producers/PostprocessorProducer$RepeatedPostprocessorConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   26: aload_1
      //   27: iconst_0
      //   28: invokeinterface 81 3 0
      //   33: aload_1
      //   34: invokestatic 62	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   37: return
      //   38: astore_2
      //   39: aload_1
      //   40: invokestatic 62	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   43: aload_2
      //   44: athrow
      //   45: astore_1
      //   46: aload_0
      //   47: monitorexit
      //   48: aload_1
      //   49: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	50	0	this	RepeatedPostprocessorConsumer
      //   19	21	1	localCloseableReference	CloseableReference
      //   45	4	1	localObject1	Object
      //   38	6	2	localObject2	Object
      // Exception table:
      //   from	to	target	type
      //   22	33	38	finally
      //   2	11	45	finally
      //   12	22	45	finally
      //   46	48	45	finally
    }
    
    protected void onCancellationImpl()
    {
      if (close()) {
        getConsumer().onCancellation();
      }
    }
    
    protected void onFailureImpl(Throwable paramThrowable)
    {
      if (close()) {
        getConsumer().onFailure(paramThrowable);
      }
    }
    
    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (isNotLast(paramInt)) {
        return;
      }
      setSourceImageRef(paramCloseableReference);
      updateInternal();
    }
    
    public void update()
    {
      try
      {
        updateInternal();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  class SingleUsePostprocessorConsumer
    extends DelegatingConsumer<CloseableReference<CloseableImage>, CloseableReference<CloseableImage>>
  {
    private SingleUsePostprocessorConsumer(PostprocessorProducer.PostprocessorConsumer paramPostprocessorConsumer)
    {
      super();
    }
    
    protected void onNewResultImpl(CloseableReference<CloseableImage> paramCloseableReference, int paramInt)
    {
      if (isNotLast(paramInt)) {
        return;
      }
      getConsumer().onNewResult(paramCloseableReference, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\PostprocessorProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */