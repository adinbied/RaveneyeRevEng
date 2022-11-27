package com.facebook.imagepipeline.producers;

import android.graphics.Bitmap;
import android.os.Build.VERSION;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.util.ExceptionWithNoStacktrace;
import com.facebook.common.util.UriUtil;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.core.ImagePipelineConfig;
import com.facebook.imagepipeline.core.ImagePipelineExperiments;
import com.facebook.imagepipeline.decoder.DecodeException;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.decoder.ProgressiveJpegParser;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.image.ImmutableQualityInfo;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.DownsampleUtil;
import com.facebook.imageutils.BitmapUtil;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

public class DecodeProducer
  implements Producer<CloseableReference<CloseableImage>>
{
  public static final String ENCODED_IMAGE_SIZE = "encodedImageSize";
  public static final String EXTRA_BITMAP_BYTES = "byteCount";
  public static final String EXTRA_BITMAP_SIZE = "bitmapSize";
  public static final String EXTRA_HAS_GOOD_QUALITY = "hasGoodQuality";
  public static final String EXTRA_IMAGE_FORMAT_NAME = "imageFormat";
  public static final String EXTRA_IS_FINAL = "isFinal";
  private static final int MAX_BITMAP_SIZE = 104857600;
  public static final String PRODUCER_NAME = "DecodeProducer";
  public static final String REQUESTED_IMAGE_SIZE = "requestedImageSize";
  public static final String SAMPLE_SIZE = "sampleSize";
  private final ByteArrayPool mByteArrayPool;
  private final CloseableReferenceFactory mCloseableReferenceFactory;
  private final boolean mDecodeCancellationEnabled;
  private final boolean mDownsampleEnabled;
  private final boolean mDownsampleEnabledForNetwork;
  private final Executor mExecutor;
  private final ImageDecoder mImageDecoder;
  private final Producer<EncodedImage> mInputProducer;
  private final int mMaxBitmapSize;
  private final ProgressiveJpegConfig mProgressiveJpegConfig;
  @Nullable
  private final Runnable mReclaimMemoryRunnable;
  private final Supplier<Boolean> mRecoverFromDecoderOOM;
  
  public DecodeProducer(ByteArrayPool paramByteArrayPool, Executor paramExecutor, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Producer<EncodedImage> paramProducer, int paramInt, CloseableReferenceFactory paramCloseableReferenceFactory, @Nullable Runnable paramRunnable, Supplier<Boolean> paramSupplier)
  {
    this.mByteArrayPool = ((ByteArrayPool)Preconditions.checkNotNull(paramByteArrayPool));
    this.mExecutor = ((Executor)Preconditions.checkNotNull(paramExecutor));
    this.mImageDecoder = ((ImageDecoder)Preconditions.checkNotNull(paramImageDecoder));
    this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramProgressiveJpegConfig));
    this.mDownsampleEnabled = paramBoolean1;
    this.mDownsampleEnabledForNetwork = paramBoolean2;
    this.mInputProducer = ((Producer)Preconditions.checkNotNull(paramProducer));
    this.mDecodeCancellationEnabled = paramBoolean3;
    this.mMaxBitmapSize = paramInt;
    this.mCloseableReferenceFactory = paramCloseableReferenceFactory;
    this.mReclaimMemoryRunnable = paramRunnable;
    this.mRecoverFromDecoderOOM = paramSupplier;
  }
  
  public void produceResults(Consumer<CloseableReference<CloseableImage>> paramConsumer, ProducerContext paramProducerContext)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("DecodeProducer#produceResults");
      }
      if (!UriUtil.isNetworkUri(paramProducerContext.getImageRequest().getSourceUri())) {
        paramConsumer = new LocalImagesProgressiveDecoder(paramConsumer, paramProducerContext, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
      } else {
        paramConsumer = new NetworkImagesProgressiveDecoder(paramConsumer, paramProducerContext, new ProgressiveJpegParser(this.mByteArrayPool), this.mProgressiveJpegConfig, this.mDecodeCancellationEnabled, this.mMaxBitmapSize);
      }
      this.mInputProducer.produceResults(paramConsumer, paramProducerContext);
      return;
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
  
  private class LocalImagesProgressiveDecoder
    extends DecodeProducer.ProgressiveDecoder
  {
    public LocalImagesProgressiveDecoder(ProducerContext paramProducerContext, boolean paramBoolean, int paramInt)
    {
      super(paramProducerContext, paramBoolean, paramInt, i);
    }
    
    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return paramEncodedImage.getSize();
    }
    
    protected QualityInfo getQualityInfo()
    {
      return ImmutableQualityInfo.of(0, false, false);
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, int paramInt)
    {
      try
      {
        boolean bool = isNotLast(paramInt);
        if (bool) {
          return false;
        }
        bool = super.updateDecodeJob(paramEncodedImage, paramInt);
        return bool;
      }
      finally {}
    }
  }
  
  private class NetworkImagesProgressiveDecoder
    extends DecodeProducer.ProgressiveDecoder
  {
    private int mLastScheduledScanNumber;
    private final ProgressiveJpegConfig mProgressiveJpegConfig;
    private final ProgressiveJpegParser mProgressiveJpegParser;
    
    public NetworkImagesProgressiveDecoder(ProducerContext paramProducerContext, ProgressiveJpegParser paramProgressiveJpegParser, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean, int paramInt)
    {
      super(paramProducerContext, paramProgressiveJpegParser, paramInt, i);
      this.mProgressiveJpegParser = ((ProgressiveJpegParser)Preconditions.checkNotNull(paramProgressiveJpegConfig));
      this.mProgressiveJpegConfig = ((ProgressiveJpegConfig)Preconditions.checkNotNull(paramBoolean));
      this.mLastScheduledScanNumber = 0;
    }
    
    protected int getIntermediateImageEndOffset(EncodedImage paramEncodedImage)
    {
      return this.mProgressiveJpegParser.getBestScanEndOffset();
    }
    
    protected QualityInfo getQualityInfo()
    {
      return this.mProgressiveJpegConfig.getQualityInfo(this.mProgressiveJpegParser.getBestScanNumber());
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, int paramInt)
    {
      try
      {
        boolean bool1 = super.updateDecodeJob(paramEncodedImage, paramInt);
        if (((isNotLast(paramInt)) || (statusHasFlag(paramInt, 8))) && (!statusHasFlag(paramInt, 4)) && (EncodedImage.isValid(paramEncodedImage)) && (paramEncodedImage.getImageFormat() == DefaultImageFormats.JPEG))
        {
          boolean bool2 = this.mProgressiveJpegParser.parseMoreData(paramEncodedImage);
          if (!bool2) {
            return false;
          }
          paramInt = this.mProgressiveJpegParser.getBestScanNumber();
          int i = this.mLastScheduledScanNumber;
          if (paramInt <= i) {
            return false;
          }
          if (paramInt < this.mProgressiveJpegConfig.getNextScanNumberToDecode(this.mLastScheduledScanNumber))
          {
            bool2 = this.mProgressiveJpegParser.isEndMarkerRead();
            if (!bool2) {
              return false;
            }
          }
          this.mLastScheduledScanNumber = paramInt;
        }
        return bool1;
      }
      finally {}
    }
  }
  
  private abstract class ProgressiveDecoder
    extends DelegatingConsumer<EncodedImage, CloseableReference<CloseableImage>>
  {
    private static final int DECODE_EXCEPTION_MESSAGE_NUM_HEADER_BYTES = 10;
    private final String TAG = "ProgressiveDecoder";
    private final ImageDecodeOptions mImageDecodeOptions;
    private boolean mIsFinished;
    private final JobScheduler mJobScheduler;
    private final ProducerContext mProducerContext;
    private final ProducerListener2 mProducerListener;
    
    public ProgressiveDecoder(ProducerContext paramProducerContext, final boolean paramBoolean, final int paramInt)
    {
      super();
      this.mProducerContext = paramBoolean;
      this.mProducerListener = paramBoolean.getProducerListener();
      this.mImageDecodeOptions = paramBoolean.getImageRequest().getImageDecodeOptions();
      this.mIsFinished = false;
      final int i;
      paramProducerContext = new JobScheduler.JobRunnable()
      {
        public void run(EncodedImage paramAnonymousEncodedImage, int paramAnonymousInt)
        {
          if (paramAnonymousEncodedImage != null)
          {
            DecodeProducer.ProgressiveDecoder.this.mProducerContext.setExtra("image_format", paramAnonymousEncodedImage.getImageFormat().getName());
            if ((DecodeProducer.this.mDownsampleEnabled) || (!BaseConsumer.statusHasFlag(paramAnonymousInt, 16)))
            {
              ImageRequest localImageRequest = paramBoolean.getImageRequest();
              if ((DecodeProducer.this.mDownsampleEnabledForNetwork) || (!UriUtil.isNetworkUri(localImageRequest.getSourceUri()))) {
                paramAnonymousEncodedImage.setSampleSize(DownsampleUtil.determineSampleSize(localImageRequest.getRotationOptions(), localImageRequest.getResizeOptions(), paramAnonymousEncodedImage, i));
              }
            }
            if (paramBoolean.getImagePipelineConfig().getExperiments().shouldDownsampleIfLargeBitmap()) {
              DecodeProducer.ProgressiveDecoder.this.maybeIncreaseSampleSize(paramAnonymousEncodedImage);
            }
            DecodeProducer.ProgressiveDecoder.this.doDecode(paramAnonymousEncodedImage, paramAnonymousInt);
          }
        }
      };
      this.mJobScheduler = new JobScheduler(DecodeProducer.this.mExecutor, paramProducerContext, this.mImageDecodeOptions.minDecodeIntervalMs);
      this.mProducerContext.addCallbacks(new BaseProducerContextCallbacks()
      {
        public void onCancellationRequested()
        {
          if (paramInt) {
            DecodeProducer.ProgressiveDecoder.this.handleCancellation();
          }
        }
        
        public void onIsIntermediateResultExpectedChanged()
        {
          if (DecodeProducer.ProgressiveDecoder.this.mProducerContext.isIntermediateResultExpected()) {
            DecodeProducer.ProgressiveDecoder.this.mJobScheduler.scheduleJob();
          }
        }
      });
    }
    
    private void doDecode(EncodedImage paramEncodedImage, int paramInt)
    {
      int i = paramInt;
      if ((paramEncodedImage.getImageFormat() != DefaultImageFormats.JPEG) && (isNotLast(paramInt))) {
        return;
      }
      Object localObject1;
      Object localObject3;
      String str2;
      String str3;
      boolean bool1;
      boolean bool2;
      Object localObject4;
      if (!isFinished())
      {
        if (!EncodedImage.isValid(paramEncodedImage)) {
          return;
        }
        localObject1 = paramEncodedImage.getImageFormat();
        if (localObject1 != null) {
          localObject1 = ((ImageFormat)localObject1).getName();
        } else {
          localObject1 = "unknown";
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramEncodedImage.getWidth());
        ((StringBuilder)localObject3).append("x");
        ((StringBuilder)localObject3).append(paramEncodedImage.getHeight());
        str2 = ((StringBuilder)localObject3).toString();
        str3 = String.valueOf(paramEncodedImage.getSampleSize());
        bool1 = isLast(paramInt);
        if ((bool1) && (!statusHasFlag(i, 8))) {
          paramInt = 1;
        } else {
          paramInt = 0;
        }
        bool2 = statusHasFlag(i, 4);
        localObject3 = this.mProducerContext.getImageRequest().getResizeOptions();
        if (localObject3 != null)
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(((ResizeOptions)localObject3).width);
          ((StringBuilder)localObject4).append("x");
          ((StringBuilder)localObject4).append(((ResizeOptions)localObject3).height);
          localObject3 = ((StringBuilder)localObject4).toString();
        }
        else
        {
          localObject3 = "unknown";
        }
        try
        {
          l = this.mJobScheduler.getQueuedTime();
          String str1 = String.valueOf(this.mProducerContext.getImageRequest().getSourceUri());
          if ((paramInt == 0) && (!bool2)) {
            j = getIntermediateImageEndOffset(paramEncodedImage);
          } else {
            j = paramEncodedImage.getSize();
          }
        }
        finally
        {
          long l;
          int j;
          EncodedImage.closeSafely(paramEncodedImage);
        }
        localObject4 = getQualityInfo();
      }
      for (;;)
      {
        localObject4 = ImmutableQualityInfo.FULL_QUALITY;
        this.mProducerListener.onProducerStart(this.mProducerContext, "DecodeProducer");
        try
        {
          CloseableImage localCloseableImage = internalDecode(paramEncodedImage, j, (QualityInfo)localObject4);
          try
          {
            j = paramEncodedImage.getSampleSize();
            paramInt = i;
            if (j != 1) {
              paramInt = i | 0x10;
            }
            localObject1 = getExtraMap(localCloseableImage, l, (QualityInfo)localObject4, bool1, (String)localObject1, str2, (String)localObject3, str3);
            this.mProducerListener.onProducerFinishWithSuccess(this.mProducerContext, "DecodeProducer", (Map)localObject1);
            setImageExtras(paramEncodedImage, localCloseableImage);
            handleResult(localCloseableImage, paramInt);
            EncodedImage.closeSafely(paramEncodedImage);
            return;
          }
          catch (Exception localException1) {}
          EncodedImage localEncodedImage;
          localObject1 = getExtraMap(localDecodeException, l, (QualityInfo)localObject4, bool1, (String)localObject1, str2, (String)localObject3, str3);
        }
        catch (Exception localException2)
        {
          localCloseableImage = null;
        }
        catch (DecodeException localDecodeException)
        {
          localEncodedImage = localDecodeException.getEncodedImage();
          FLog.w("ProgressiveDecoder", "%s, {uri: %s, firstEncodedBytes: %s, length: %d}", new Object[] { localDecodeException.getMessage(), localException2, localEncodedImage.getFirstBytesAsHexString(10), Integer.valueOf(localEncodedImage.getSize()) });
          throw localDecodeException;
        }
        this.mProducerListener.onProducerFinishWithFailure(this.mProducerContext, "DecodeProducer", localException2, (Map)localObject1);
        handleError(localException2);
        EncodedImage.closeSafely(paramEncodedImage);
        return;
        return;
        if (paramInt == 0) {
          if (!bool2) {
            break;
          }
        }
      }
    }
    
    @Nullable
    private Map<String, String> getExtraMap(@Nullable CloseableImage paramCloseableImage, long paramLong, QualityInfo paramQualityInfo, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
    {
      if (!this.mProducerListener.requiresExtraMap(this.mProducerContext, "DecodeProducer")) {
        return null;
      }
      String str1 = String.valueOf(paramLong);
      paramQualityInfo = String.valueOf(paramQualityInfo.isOfGoodEnoughQuality());
      String str2 = String.valueOf(paramBoolean);
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        paramCloseableImage = ((CloseableStaticBitmap)paramCloseableImage).getUnderlyingBitmap();
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramCloseableImage.getWidth());
        ((StringBuilder)localObject).append("x");
        ((StringBuilder)localObject).append(paramCloseableImage.getHeight());
        String str3 = ((StringBuilder)localObject).toString();
        localObject = new HashMap(8);
        ((Map)localObject).put("bitmapSize", str3);
        ((Map)localObject).put("queueTime", str1);
        ((Map)localObject).put("hasGoodQuality", paramQualityInfo);
        ((Map)localObject).put("isFinal", str2);
        ((Map)localObject).put("encodedImageSize", paramString2);
        ((Map)localObject).put("imageFormat", paramString1);
        ((Map)localObject).put("requestedImageSize", paramString3);
        ((Map)localObject).put("sampleSize", paramString4);
        if (Build.VERSION.SDK_INT >= 12)
        {
          paramQualityInfo = new StringBuilder();
          paramQualityInfo.append(paramCloseableImage.getByteCount());
          paramQualityInfo.append("");
          ((Map)localObject).put("byteCount", paramQualityInfo.toString());
        }
        return ImmutableMap.copyOf((Map)localObject);
      }
      paramCloseableImage = new HashMap(7);
      paramCloseableImage.put("queueTime", str1);
      paramCloseableImage.put("hasGoodQuality", paramQualityInfo);
      paramCloseableImage.put("isFinal", str2);
      paramCloseableImage.put("encodedImageSize", paramString2);
      paramCloseableImage.put("imageFormat", paramString1);
      paramCloseableImage.put("requestedImageSize", paramString3);
      paramCloseableImage.put("sampleSize", paramString4);
      return ImmutableMap.copyOf(paramCloseableImage);
    }
    
    private void handleCancellation()
    {
      maybeFinish(true);
      getConsumer().onCancellation();
    }
    
    private void handleError(Throwable paramThrowable)
    {
      maybeFinish(true);
      getConsumer().onFailure(paramThrowable);
    }
    
    private void handleResult(CloseableImage paramCloseableImage, int paramInt)
    {
      paramCloseableImage = DecodeProducer.this.mCloseableReferenceFactory.create(paramCloseableImage);
      try
      {
        maybeFinish(isLast(paramInt));
        getConsumer().onNewResult(paramCloseableImage, paramInt);
        return;
      }
      finally
      {
        CloseableReference.closeSafely(paramCloseableImage);
      }
    }
    
    private CloseableImage internalDecode(EncodedImage paramEncodedImage, int paramInt, QualityInfo paramQualityInfo)
    {
      int i;
      if ((DecodeProducer.this.mReclaimMemoryRunnable != null) && (((Boolean)DecodeProducer.this.mRecoverFromDecoderOOM.get()).booleanValue())) {
        i = 1;
      } else {
        i = 0;
      }
      try
      {
        CloseableImage localCloseableImage = DecodeProducer.this.mImageDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, this.mImageDecodeOptions);
        return localCloseableImage;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (i != 0)
        {
          DecodeProducer.this.mReclaimMemoryRunnable.run();
          System.gc();
          return DecodeProducer.this.mImageDecoder.decode(paramEncodedImage, paramInt, paramQualityInfo, this.mImageDecodeOptions);
        }
        throw localOutOfMemoryError;
      }
    }
    
    private boolean isFinished()
    {
      try
      {
        boolean bool = this.mIsFinished;
        return bool;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    private void maybeFinish(boolean paramBoolean)
    {
      if (paramBoolean) {}
      try
      {
        if (!this.mIsFinished)
        {
          getConsumer().onProgressUpdate(1.0F);
          this.mIsFinished = true;
          this.mJobScheduler.clearJob();
          return;
        }
        return;
      }
      finally {}
    }
    
    private void maybeIncreaseSampleSize(EncodedImage paramEncodedImage)
    {
      if (paramEncodedImage.getImageFormat() != DefaultImageFormats.JPEG) {
        return;
      }
      paramEncodedImage.setSampleSize(DownsampleUtil.determineSampleSizeJPEG(paramEncodedImage, BitmapUtil.getPixelSizeForBitmapConfig(this.mImageDecodeOptions.bitmapConfig), 104857600));
    }
    
    private void setImageExtras(EncodedImage paramEncodedImage, CloseableImage paramCloseableImage)
    {
      this.mProducerContext.setExtra("encoded_width", Integer.valueOf(paramEncodedImage.getWidth()));
      this.mProducerContext.setExtra("encoded_height", Integer.valueOf(paramEncodedImage.getHeight()));
      this.mProducerContext.setExtra("encoded_size", Integer.valueOf(paramEncodedImage.getSize()));
      if ((paramCloseableImage instanceof CloseableBitmap))
      {
        paramEncodedImage = ((CloseableBitmap)paramCloseableImage).getUnderlyingBitmap();
        if (paramEncodedImage == null) {
          paramEncodedImage = null;
        } else {
          paramEncodedImage = paramEncodedImage.getConfig();
        }
        this.mProducerContext.setExtra("bitmap_config", String.valueOf(paramEncodedImage));
      }
      if (paramCloseableImage != null) {
        paramCloseableImage.setImageExtras(this.mProducerContext.getExtras());
      }
    }
    
    protected abstract int getIntermediateImageEndOffset(EncodedImage paramEncodedImage);
    
    protected abstract QualityInfo getQualityInfo();
    
    public void onCancellationImpl()
    {
      handleCancellation();
    }
    
    public void onFailureImpl(Throwable paramThrowable)
    {
      handleError(paramThrowable);
    }
    
    public void onNewResultImpl(EncodedImage paramEncodedImage, int paramInt)
    {
      try
      {
        if (FrescoSystrace.isTracing()) {
          FrescoSystrace.beginSection("DecodeProducer#onNewResultImpl");
        }
        boolean bool1 = isLast(paramInt);
        if (bool1)
        {
          if (paramEncodedImage == null)
          {
            handleError(new ExceptionWithNoStacktrace("Encoded image is null."));
            return;
          }
          if (!paramEncodedImage.isValid())
          {
            handleError(new ExceptionWithNoStacktrace("Encoded image is not valid."));
            return;
          }
        }
        boolean bool2 = updateDecodeJob(paramEncodedImage, paramInt);
        if (!bool2) {
          return;
        }
        bool2 = statusHasFlag(paramInt, 4);
        if ((bool1) || (bool2) || (this.mProducerContext.isIntermediateResultExpected())) {
          this.mJobScheduler.scheduleJob();
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
    
    protected void onProgressUpdateImpl(float paramFloat)
    {
      super.onProgressUpdateImpl(paramFloat * 0.99F);
    }
    
    protected boolean updateDecodeJob(EncodedImage paramEncodedImage, int paramInt)
    {
      return this.mJobScheduler.updateJob(paramEncodedImage, paramInt);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\DecodeProducer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */