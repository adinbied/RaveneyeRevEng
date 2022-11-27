package com.facebook.imagepipeline.producers;

import com.facebook.common.internal.ImmutableList;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.util.TriState;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.transcoder.ImageTranscodeResult;
import com.facebook.imagepipeline.transcoder.ImageTranscoder;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.JpegTranscoderUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class ResizeAndRotateProducer
  implements Producer<EncodedImage>
{
  private static final String INPUT_IMAGE_FORMAT = "Image format";
  static final int MIN_TRANSFORM_INTERVAL_MS = 100;
  private static final String ORIGINAL_SIZE_KEY = "Original size";
  private static final String PRODUCER_NAME = "ResizeAndRotateProducer";
  private static final String REQUESTED_SIZE_KEY = "Requested size";
  private static final String TRANSCODER_ID = "Transcoder id";
  private static final String TRANSCODING_RESULT = "Transcoding result";
  private final Executor mExecutor;
  private final ImageTranscoderFactory mImageTranscoderFactory;
  private final Producer<EncodedImage> mInputProducer;
  private final boolean mIsResizingEnabled;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  
  public ResizeAndRotateProducer(Executor paramExecutor, PooledByteBufferFactory paramPooledByteBufferFactory, Producer<EncodedImage> paramProducer, boolean paramBoolean, ImageTranscoderFactory paramImageTranscoderFactory)
  {
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mPooledByteBufferFactory = ((PooledByteBufferFactory)Preconditions.checkNotNull(paramPooledByteBufferFactory));
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mImageTranscoderFactory = ((ImageTranscoderFactory)Preconditions.checkNotNull(paramImageTranscoderFactory));
    this.mIsResizingEnabled = paramBoolean;
  }
  
  private static boolean shouldRotate(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    return (!paramRotationOptions.canDeferUntilRendered()) && ((JpegTranscoderUtils.getRotationAngle(paramRotationOptions, paramEncodedImage) != 0) || (shouldRotateUsingExifOrientation(paramRotationOptions, paramEncodedImage)));
  }
  
  private static boolean shouldRotateUsingExifOrientation(RotationOptions paramRotationOptions, EncodedImage paramEncodedImage)
  {
    if ((paramRotationOptions.rotationEnabled()) && (!paramRotationOptions.canDeferUntilRendered())) {
      return JpegTranscoderUtils.INVERTED_EXIF_ORIENTATIONS.contains(Integer.valueOf(paramEncodedImage.getExifOrientation()));
    }
    paramEncodedImage.setExifOrientation(0);
    return false;
  }
  
  private static TriState shouldTransform(ImageRequest paramImageRequest, EncodedImage paramEncodedImage, ImageTranscoder paramImageTranscoder)
  {
    if ((paramEncodedImage != null) && (paramEncodedImage.getImageFormat() != ImageFormat.UNKNOWN))
    {
      if (!paramImageTranscoder.canTranscode(paramEncodedImage.getImageFormat())) {
        return TriState.NO;
      }
      boolean bool;
      if ((!shouldRotate(paramImageRequest.getRotationOptions(), paramEncodedImage)) && (!paramImageTranscoder.canResize(paramEncodedImage, paramImageRequest.getRotationOptions(), paramImageRequest.getResizeOptions()))) {
        bool = false;
      } else {
        bool = true;
      }
      return TriState.valueOf(bool);
    }
    return TriState.UNSET;
  }
  
  public void produceResults(Consumer<EncodedImage> paramConsumer, ProducerContext paramProducerContext)
  {
    this.mInputProducer.produceResults(new TransformingConsumer(paramConsumer, paramProducerContext, this.mIsResizingEnabled, this.mImageTranscoderFactory), paramProducerContext);
  }
  
  private class TransformingConsumer
    extends DelegatingConsumer<EncodedImage, EncodedImage>
  {
    private final ImageTranscoderFactory mImageTranscoderFactory;
    private boolean mIsCancelled = false;
    private final boolean mIsResizingEnabled;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    
    TransformingConsumer(final ProducerContext paramProducerContext, boolean paramBoolean, ImageTranscoderFactory paramImageTranscoderFactory)
    {
      super();
      this.mProducerContext = paramBoolean;
      paramBoolean = paramBoolean.getImageRequest().getResizingAllowedOverride();
      if (paramBoolean != null) {
        paramImageTranscoderFactory = paramBoolean.booleanValue();
      }
      this.mIsResizingEnabled = paramImageTranscoderFactory;
      ImageTranscoderFactory localImageTranscoderFactory;
      this.mImageTranscoderFactory = localImageTranscoderFactory;
      paramBoolean = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt)
        {
          ResizeAndRotateProducer.TransformingConsumer localTransformingConsumer = ResizeAndRotateProducer.TransformingConsumer.this;
          localTransformingConsumer.doTransform(paramAnonymousEncodedImage, paramAnonymousInt, (ImageTranscoder)Preconditions.checkNotNull(localTransformingConsumer.mImageTranscoderFactory.createImageTranscoder(paramAnonymousEncodedImage.getImageFormat(), ResizeAndRotateProducer.TransformingConsumer.this.mIsResizingEnabled)));
        }
      };
      this.mJobScheduler = new JobScheduler(ResizeAndRotateProducer.this.mExecutor, paramBoolean, 100);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.clearJob();
          ResizeAndRotateProducer.TransformingConsumer.access$602(ResizeAndRotateProducer.TransformingConsumer.this, true);
          paramProducerContext.onCancellation();
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          if (ResizeAndRotateProducer.TransformingConsumer.this.mProducerContext.isIntermediateResultExpected()) {
            ResizeAndRotateProducer.TransformingConsumer.this.mJobScheduler.scheduleJob();
          }
        }
      });
    }
    
    /* Error */
    private void doTransform(EncodedImage paramEncodedImage, int paramInt, ImageTranscoder paramImageTranscoder)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   4: invokeinterface 102 1 0
      //   9: aload_0
      //   10: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   13: ldc 104
      //   15: invokeinterface 110 3 0
      //   20: aload_0
      //   21: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   24: invokeinterface 40 1 0
      //   29: astore 11
      //   31: aload_0
      //   32: getfield 27	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:this$0	Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;
      //   35: invokestatic 114	com/facebook/imagepipeline/producers/ResizeAndRotateProducer:access$800	(Lcom/facebook/imagepipeline/producers/ResizeAndRotateProducer;)Lcom/facebook/common/memory/PooledByteBufferFactory;
      //   38: invokeinterface 120 1 0
      //   43: astore 9
      //   45: aconst_null
      //   46: astore 8
      //   48: aload 8
      //   50: astore 7
      //   52: iload_2
      //   53: istore 4
      //   55: aload_3
      //   56: aload_1
      //   57: aload 9
      //   59: aload 11
      //   61: invokevirtual 124	com/facebook/imagepipeline/request/ImageRequest:getRotationOptions	()Lcom/facebook/imagepipeline/common/RotationOptions;
      //   64: aload 11
      //   66: invokevirtual 128	com/facebook/imagepipeline/request/ImageRequest:getResizeOptions	()Lcom/facebook/imagepipeline/common/ResizeOptions;
      //   69: aconst_null
      //   70: bipush 85
      //   72: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   75: invokeinterface 140 7 0
      //   80: astore 10
      //   82: aload 8
      //   84: astore 7
      //   86: iload_2
      //   87: istore 4
      //   89: aload 10
      //   91: invokevirtual 146	com/facebook/imagepipeline/transcoder/ImageTranscodeResult:getTranscodeStatus	()I
      //   94: iconst_2
      //   95: if_icmpeq +201 -> 296
      //   98: aload 8
      //   100: astore 7
      //   102: iload_2
      //   103: istore 4
      //   105: aload_0
      //   106: aload_1
      //   107: aload 11
      //   109: invokevirtual 128	com/facebook/imagepipeline/request/ImageRequest:getResizeOptions	()Lcom/facebook/imagepipeline/common/ResizeOptions;
      //   112: aload 10
      //   114: aload_3
      //   115: invokeinterface 150 1 0
      //   120: invokespecial 154	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getExtraMap	(Lcom/facebook/imagepipeline/image/EncodedImage;Lcom/facebook/imagepipeline/common/ResizeOptions;Lcom/facebook/imagepipeline/transcoder/ImageTranscodeResult;Ljava/lang/String;)Ljava/util/Map;
      //   123: astore_1
      //   124: aload_1
      //   125: astore 7
      //   127: iload_2
      //   128: istore 4
      //   130: aload 9
      //   132: invokevirtual 160	com/facebook/common/memory/PooledByteBufferOutputStream:toByteBuffer	()Lcom/facebook/common/memory/PooledByteBuffer;
      //   135: invokestatic 166	com/facebook/common/references/CloseableReference:of	(Ljava/io/Closeable;)Lcom/facebook/common/references/CloseableReference;
      //   138: astore_3
      //   139: iload_2
      //   140: istore 5
      //   142: new 168	com/facebook/imagepipeline/image/EncodedImage
      //   145: dup
      //   146: aload_3
      //   147: invokespecial 171	com/facebook/imagepipeline/image/EncodedImage:<init>	(Lcom/facebook/common/references/CloseableReference;)V
      //   150: astore 7
      //   152: iload_2
      //   153: istore 5
      //   155: aload 7
      //   157: getstatic 177	com/facebook/imageformat/DefaultImageFormats:JPEG	Lcom/facebook/imageformat/ImageFormat;
      //   160: invokevirtual 181	com/facebook/imagepipeline/image/EncodedImage:setImageFormat	(Lcom/facebook/imageformat/ImageFormat;)V
      //   163: iload_2
      //   164: istore 6
      //   166: aload 7
      //   168: invokevirtual 185	com/facebook/imagepipeline/image/EncodedImage:parseMetaData	()V
      //   171: iload_2
      //   172: istore 6
      //   174: aload_0
      //   175: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   178: invokeinterface 102 1 0
      //   183: aload_0
      //   184: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   187: ldc 104
      //   189: aload_1
      //   190: invokeinterface 189 4 0
      //   195: iload_2
      //   196: istore 4
      //   198: iload_2
      //   199: istore 6
      //   201: aload 10
      //   203: invokevirtual 146	com/facebook/imagepipeline/transcoder/ImageTranscodeResult:getTranscodeStatus	()I
      //   206: iconst_1
      //   207: if_icmpeq +9 -> 216
      //   210: iload_2
      //   211: bipush 16
      //   213: ior
      //   214: istore 4
      //   216: iload 4
      //   218: istore 6
      //   220: aload_0
      //   221: invokevirtual 193	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   224: aload 7
      //   226: iload 4
      //   228: invokeinterface 199 3 0
      //   233: iload 4
      //   235: istore 5
      //   237: aload 7
      //   239: invokestatic 203	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   242: aload_1
      //   243: astore 7
      //   245: aload_3
      //   246: invokestatic 205	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   249: aload 9
      //   251: invokevirtual 208	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   254: return
      //   255: astore 8
      //   257: iload 6
      //   259: istore 5
      //   261: aload 7
      //   263: invokestatic 203	com/facebook/imagepipeline/image/EncodedImage:closeSafely	(Lcom/facebook/imagepipeline/image/EncodedImage;)V
      //   266: iload 6
      //   268: istore 5
      //   270: aload 8
      //   272: athrow
      //   273: astore 8
      //   275: aload_1
      //   276: astore 7
      //   278: iload 5
      //   280: istore 4
      //   282: aload_3
      //   283: invokestatic 205	com/facebook/common/references/CloseableReference:closeSafely	(Lcom/facebook/common/references/CloseableReference;)V
      //   286: aload_1
      //   287: astore 7
      //   289: iload 5
      //   291: istore 4
      //   293: aload 8
      //   295: athrow
      //   296: aload 8
      //   298: astore 7
      //   300: iload_2
      //   301: istore 4
      //   303: new 210	java/lang/RuntimeException
      //   306: dup
      //   307: ldc -44
      //   309: invokespecial 215	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   312: athrow
      //   313: astore_1
      //   314: goto +51 -> 365
      //   317: astore_1
      //   318: aload_0
      //   319: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   322: invokeinterface 102 1 0
      //   327: aload_0
      //   328: getfield 34	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:mProducerContext	Lcom/facebook/imagepipeline/producers/ProducerContext;
      //   331: ldc 104
      //   333: aload_1
      //   334: aload 7
      //   336: invokeinterface 219 5 0
      //   341: iload 4
      //   343: invokestatic 223	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:isLast	(I)Z
      //   346: ifeq +13 -> 359
      //   349: aload_0
      //   350: invokevirtual 193	com/facebook/imagepipeline/producers/ResizeAndRotateProducer$TransformingConsumer:getConsumer	()Lcom/facebook/imagepipeline/producers/Consumer;
      //   353: aload_1
      //   354: invokeinterface 227 2 0
      //   359: aload 9
      //   361: invokevirtual 208	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   364: return
      //   365: aload 9
      //   367: invokevirtual 208	com/facebook/common/memory/PooledByteBufferOutputStream:close	()V
      //   370: aload_1
      //   371: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	372	0	this	TransformingConsumer
      //   0	372	1	paramEncodedImage	EncodedImage
      //   0	372	2	paramInt	int
      //   0	372	3	paramImageTranscoder	ImageTranscoder
      //   53	289	4	i	int
      //   140	150	5	j	int
      //   164	103	6	k	int
      //   50	285	7	localObject1	Object
      //   46	53	8	localObject2	Object
      //   255	16	8	localObject3	Object
      //   273	24	8	localObject4	Object
      //   43	323	9	localPooledByteBufferOutputStream	com.facebook.common.memory.PooledByteBufferOutputStream
      //   80	122	10	localImageTranscodeResult	ImageTranscodeResult
      //   29	79	11	localImageRequest	ImageRequest
      // Exception table:
      //   from	to	target	type
      //   166	171	255	finally
      //   174	195	255	finally
      //   201	210	255	finally
      //   220	233	255	finally
      //   142	152	273	finally
      //   155	163	273	finally
      //   237	242	273	finally
      //   261	266	273	finally
      //   270	273	273	finally
      //   55	82	313	finally
      //   89	98	313	finally
      //   105	124	313	finally
      //   130	139	313	finally
      //   245	249	313	finally
      //   282	286	313	finally
      //   293	296	313	finally
      //   303	313	313	finally
      //   318	359	313	finally
      //   55	82	317	java/lang/Exception
      //   89	98	317	java/lang/Exception
      //   105	124	317	java/lang/Exception
      //   130	139	317	java/lang/Exception
      //   245	249	317	java/lang/Exception
      //   282	286	317	java/lang/Exception
      //   293	296	317	java/lang/Exception
      //   303	313	317	java/lang/Exception
    }
    
    private void forwardNewResult(EncodedImage paramEncodedImage, int paramInt, ImageFormat paramImageFormat)
    {
      if ((paramImageFormat != DefaultImageFormats.JPEG) && (paramImageFormat != DefaultImageFormats.HEIF)) {
        paramEncodedImage = getNewResultForImagesWithoutExifData(paramEncodedImage);
      } else {
        paramEncodedImage = getNewResultsForJpegOrHeif(paramEncodedImage);
      }
      getConsumer().onNewResult(paramEncodedImage, paramInt);
    }
    
    @Nullable
    private EncodedImage getCloneWithRotationApplied(EncodedImage paramEncodedImage, int paramInt)
    {
      paramEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      if (paramEncodedImage != null) {
        paramEncodedImage.setRotationAngle(paramInt);
      }
      return paramEncodedImage;
    }
    
    @Nullable
    private Map<String, String> getExtraMap(EncodedImage paramEncodedImage, @Nullable ResizeOptions paramResizeOptions, @Nullable ImageTranscodeResult paramImageTranscodeResult, @Nullable String paramString)
    {
      if (!this.mProducerContext.getProducerListener().requiresExtraMap(this.mProducerContext, "ResizeAndRotateProducer")) {
        return null;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramEncodedImage.getWidth());
      ((StringBuilder)localObject1).append("x");
      ((StringBuilder)localObject1).append(paramEncodedImage.getHeight());
      localObject1 = ((StringBuilder)localObject1).toString();
      if (paramResizeOptions != null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramResizeOptions.width);
        ((StringBuilder)localObject2).append("x");
        ((StringBuilder)localObject2).append(paramResizeOptions.height);
        paramResizeOptions = ((StringBuilder)localObject2).toString();
      }
      else
      {
        paramResizeOptions = "Unspecified";
      }
      Object localObject2 = new HashMap();
      ((Map)localObject2).put("Image format", String.valueOf(paramEncodedImage.getImageFormat()));
      ((Map)localObject2).put("Original size", localObject1);
      ((Map)localObject2).put("Requested size", paramResizeOptions);
      ((Map)localObject2).put("queueTime", String.valueOf(this.mJobScheduler.getQueuedTime()));
      ((Map)localObject2).put("Transcoder id", paramString);
      ((Map)localObject2).put("Transcoding result", String.valueOf(paramImageTranscodeResult));
      return ImmutableMap.copyOf((Map)localObject2);
    }
    
    @Nullable
    private EncodedImage getNewResultForImagesWithoutExifData(EncodedImage paramEncodedImage)
    {
      RotationOptions localRotationOptions = this.mProducerContext.getImageRequest().getRotationOptions();
      EncodedImage localEncodedImage = paramEncodedImage;
      if (!localRotationOptions.useImageMetadata())
      {
        localEncodedImage = paramEncodedImage;
        if (localRotationOptions.rotationEnabled()) {
          localEncodedImage = getCloneWithRotationApplied(paramEncodedImage, localRotationOptions.getForcedAngle());
        }
      }
      return localEncodedImage;
    }
    
    @Nullable
    private EncodedImage getNewResultsForJpegOrHeif(EncodedImage paramEncodedImage)
    {
      EncodedImage localEncodedImage = paramEncodedImage;
      if (!this.mProducerContext.getImageRequest().getRotationOptions().canDeferUntilRendered())
      {
        localEncodedImage = paramEncodedImage;
        if (paramEncodedImage.getRotationAngle() != 0)
        {
          localEncodedImage = paramEncodedImage;
          if (paramEncodedImage.getRotationAngle() != -1) {
            localEncodedImage = getCloneWithRotationApplied(paramEncodedImage, 0);
          }
        }
      }
      return localEncodedImage;
    }
    
    protected void onNewResultImpl(@Nullable EncodedImage paramEncodedImage, int paramInt)
    {
      if (this.mIsCancelled) {
        return;
      }
      boolean bool = isLast(paramInt);
      if (paramEncodedImage == null)
      {
        if (bool) {
          getConsumer().onNewResult(null, 1);
        }
        return;
      }
      ImageFormat localImageFormat = paramEncodedImage.getImageFormat();
      TriState localTriState = ResizeAndRotateProducer.shouldTransform(this.mProducerContext.getImageRequest(), paramEncodedImage, (ImageTranscoder)Preconditions.checkNotNull(this.mImageTranscoderFactory.createImageTranscoder(localImageFormat, this.mIsResizingEnabled)));
      if ((!bool) && (localTriState == TriState.UNSET)) {
        return;
      }
      if (localTriState != TriState.YES)
      {
        forwardNewResult(paramEncodedImage, paramInt, localImageFormat);
        return;
      }
      if (!this.mJobScheduler.updateJob(paramEncodedImage, paramInt)) {
        return;
      }
      if ((bool) || (this.mProducerContext.isIntermediateResultExpected())) {
        this.mJobScheduler.scheduleJob();
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\ResizeAndRotateProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */