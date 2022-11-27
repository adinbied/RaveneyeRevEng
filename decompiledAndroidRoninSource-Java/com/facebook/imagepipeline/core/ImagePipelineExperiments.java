package com.facebook.imagepipeline.core;

import android.content.Context;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.webp.WebpBitmapFactory;
import com.facebook.common.webp.WebpBitmapFactory.WebpErrorLogger;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;

public class ImagePipelineExperiments
{
  private final int mBitmapCloseableRefType;
  private boolean mBitmapPrepareToDrawForPrefetch;
  private final int mBitmapPrepareToDrawMaxSizeBytes;
  private final int mBitmapPrepareToDrawMinSizeBytes;
  private final boolean mDecodeCancellationEnabled;
  private boolean mDownsampleIfLargeBitmap;
  private final boolean mDownscaleFrameToDrawableDimensions;
  private boolean mEncodedCacheEnabled;
  private final boolean mEnsureTranscoderLibraryLoaded;
  private final boolean mExperimentalThreadHandoffQueueEnabled;
  private final boolean mGingerbreadDecoderEnabled;
  private final boolean mIsDiskCacheProbingEnabled;
  private final boolean mIsEncodedMemoryCacheProbingEnabled;
  private boolean mKeepCancelledFetchAsLowPriority;
  private final Supplier<Boolean> mLazyDataSource;
  private final int mMaxBitmapSize;
  private final long mMemoryType;
  private final boolean mNativeCodeDisabled;
  private final boolean mPartialImageCachingEnabled;
  private final ProducerFactoryMethod mProducerFactoryMethod;
  private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
  private final int mTrackedKeysSize;
  private final boolean mUseBitmapPrepareToDraw;
  private final boolean mUseDownsamplingRatioForResizing;
  private final WebpBitmapFactory mWebpBitmapFactory;
  private final WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
  private final boolean mWebpSupportEnabled;
  
  private ImagePipelineExperiments(Builder paramBuilder)
  {
    this.mWebpSupportEnabled = paramBuilder.mWebpSupportEnabled;
    this.mWebpErrorLogger = paramBuilder.mWebpErrorLogger;
    this.mDecodeCancellationEnabled = paramBuilder.mDecodeCancellationEnabled;
    this.mWebpBitmapFactory = paramBuilder.mWebpBitmapFactory;
    this.mUseDownsamplingRatioForResizing = paramBuilder.mUseDownsamplingRatioForResizing;
    this.mUseBitmapPrepareToDraw = paramBuilder.mUseBitmapPrepareToDraw;
    this.mBitmapPrepareToDrawMinSizeBytes = paramBuilder.mBitmapPrepareToDrawMinSizeBytes;
    this.mBitmapPrepareToDrawMaxSizeBytes = paramBuilder.mBitmapPrepareToDrawMaxSizeBytes;
    this.mBitmapPrepareToDrawForPrefetch = paramBuilder.mBitmapPrepareToDrawForPrefetch;
    this.mMaxBitmapSize = paramBuilder.mMaxBitmapSize;
    this.mNativeCodeDisabled = paramBuilder.mNativeCodeDisabled;
    this.mPartialImageCachingEnabled = paramBuilder.mPartialImageCachingEnabled;
    if (paramBuilder.mProducerFactoryMethod == null) {
      this.mProducerFactoryMethod = new DefaultProducerFactoryMethod();
    } else {
      this.mProducerFactoryMethod = paramBuilder.mProducerFactoryMethod;
    }
    this.mLazyDataSource = paramBuilder.mLazyDataSource;
    this.mGingerbreadDecoderEnabled = paramBuilder.mGingerbreadDecoderEnabled;
    this.mDownscaleFrameToDrawableDimensions = paramBuilder.mDownscaleFrameToDrawableDimensions;
    this.mBitmapCloseableRefType = paramBuilder.mBitmapCloseableRefType;
    this.mSuppressBitmapPrefetchingSupplier = paramBuilder.mSuppressBitmapPrefetchingSupplier;
    this.mExperimentalThreadHandoffQueueEnabled = paramBuilder.mExperimentalThreadHandoffQueueEnabled;
    this.mMemoryType = paramBuilder.mMemoryType;
    this.mKeepCancelledFetchAsLowPriority = paramBuilder.mKeepCancelledFetchAsLowPriority;
    this.mDownsampleIfLargeBitmap = paramBuilder.mDownsampleIfLargeBitmap;
    this.mEncodedCacheEnabled = paramBuilder.mEncodedCacheEnabled;
    this.mEnsureTranscoderLibraryLoaded = paramBuilder.mEnsureTranscoderLibraryLoaded;
    this.mIsEncodedMemoryCacheProbingEnabled = paramBuilder.mIsEncodedMemoryCacheProbingEnabled;
    this.mIsDiskCacheProbingEnabled = paramBuilder.mIsDiskCacheProbingEnabled;
    this.mTrackedKeysSize = paramBuilder.mTrackedKeysSize;
  }
  
  public static Builder newBuilder(ImagePipelineConfig.Builder paramBuilder)
  {
    return new Builder(paramBuilder);
  }
  
  public int getBitmapCloseableRefType()
  {
    return this.mBitmapCloseableRefType;
  }
  
  public boolean getBitmapPrepareToDrawForPrefetch()
  {
    return this.mBitmapPrepareToDrawForPrefetch;
  }
  
  public int getBitmapPrepareToDrawMaxSizeBytes()
  {
    return this.mBitmapPrepareToDrawMaxSizeBytes;
  }
  
  public int getBitmapPrepareToDrawMinSizeBytes()
  {
    return this.mBitmapPrepareToDrawMinSizeBytes;
  }
  
  public int getMaxBitmapSize()
  {
    return this.mMaxBitmapSize;
  }
  
  public long getMemoryType()
  {
    return this.mMemoryType;
  }
  
  public ProducerFactoryMethod getProducerFactoryMethod()
  {
    return this.mProducerFactoryMethod;
  }
  
  public Supplier<Boolean> getSuppressBitmapPrefetchingSupplier()
  {
    return this.mSuppressBitmapPrefetchingSupplier;
  }
  
  public int getTrackedKeysSize()
  {
    return this.mTrackedKeysSize;
  }
  
  public boolean getUseBitmapPrepareToDraw()
  {
    return this.mUseBitmapPrepareToDraw;
  }
  
  public boolean getUseDownsamplingRatioForResizing()
  {
    return this.mUseDownsamplingRatioForResizing;
  }
  
  public WebpBitmapFactory getWebpBitmapFactory()
  {
    return this.mWebpBitmapFactory;
  }
  
  public WebpBitmapFactory.WebpErrorLogger getWebpErrorLogger()
  {
    return this.mWebpErrorLogger;
  }
  
  public boolean isDecodeCancellationEnabled()
  {
    return this.mDecodeCancellationEnabled;
  }
  
  public boolean isDiskCacheProbingEnabled()
  {
    return this.mIsDiskCacheProbingEnabled;
  }
  
  public boolean isEncodedCacheEnabled()
  {
    return this.mEncodedCacheEnabled;
  }
  
  public boolean isEncodedMemoryCacheProbingEnabled()
  {
    return this.mIsEncodedMemoryCacheProbingEnabled;
  }
  
  public boolean isEnsureTranscoderLibraryLoaded()
  {
    return this.mEnsureTranscoderLibraryLoaded;
  }
  
  public boolean isExperimentalThreadHandoffQueueEnabled()
  {
    return this.mExperimentalThreadHandoffQueueEnabled;
  }
  
  public boolean isGingerbreadDecoderEnabled()
  {
    return this.mGingerbreadDecoderEnabled;
  }
  
  public Supplier<Boolean> isLazyDataSource()
  {
    return this.mLazyDataSource;
  }
  
  public boolean isNativeCodeDisabled()
  {
    return this.mNativeCodeDisabled;
  }
  
  public boolean isPartialImageCachingEnabled()
  {
    return this.mPartialImageCachingEnabled;
  }
  
  public boolean isWebpSupportEnabled()
  {
    return this.mWebpSupportEnabled;
  }
  
  public boolean shouldDownsampleIfLargeBitmap()
  {
    return this.mDownsampleIfLargeBitmap;
  }
  
  public boolean shouldDownscaleFrameToDrawableDimensions()
  {
    return this.mDownscaleFrameToDrawableDimensions;
  }
  
  public boolean shouldKeepCancelledFetchAsLowPriority()
  {
    return this.mKeepCancelledFetchAsLowPriority;
  }
  
  public static class Builder
  {
    public int mBitmapCloseableRefType;
    public boolean mBitmapPrepareToDrawForPrefetch = false;
    private int mBitmapPrepareToDrawMaxSizeBytes = 0;
    private int mBitmapPrepareToDrawMinSizeBytes = 0;
    private final ImagePipelineConfig.Builder mConfigBuilder;
    private boolean mDecodeCancellationEnabled = false;
    public boolean mDownsampleIfLargeBitmap;
    public boolean mDownscaleFrameToDrawableDimensions;
    public boolean mEncodedCacheEnabled = true;
    public boolean mEnsureTranscoderLibraryLoaded = true;
    public boolean mExperimentalThreadHandoffQueueEnabled;
    public boolean mGingerbreadDecoderEnabled;
    private boolean mIsDiskCacheProbingEnabled = false;
    private boolean mIsEncodedMemoryCacheProbingEnabled = false;
    private boolean mKeepCancelledFetchAsLowPriority;
    public Supplier<Boolean> mLazyDataSource;
    private int mMaxBitmapSize = 2048;
    public long mMemoryType = 0L;
    private boolean mNativeCodeDisabled = false;
    private boolean mPartialImageCachingEnabled = false;
    private ImagePipelineExperiments.ProducerFactoryMethod mProducerFactoryMethod;
    public Supplier<Boolean> mSuppressBitmapPrefetchingSupplier = Suppliers.of(Boolean.valueOf(false));
    private int mTrackedKeysSize = 20;
    private boolean mUseBitmapPrepareToDraw = false;
    private boolean mUseDownsamplingRatioForResizing = false;
    private WebpBitmapFactory mWebpBitmapFactory;
    private WebpBitmapFactory.WebpErrorLogger mWebpErrorLogger;
    private boolean mWebpSupportEnabled = false;
    
    public Builder(ImagePipelineConfig.Builder paramBuilder)
    {
      this.mConfigBuilder = paramBuilder;
    }
    
    public ImagePipelineExperiments build()
    {
      return new ImagePipelineExperiments(this, null);
    }
    
    public boolean isPartialImageCachingEnabled()
    {
      return this.mPartialImageCachingEnabled;
    }
    
    public ImagePipelineConfig.Builder setBitmapCloseableRefType(int paramInt)
    {
      this.mBitmapCloseableRefType = paramInt;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setBitmapPrepareToDraw(boolean paramBoolean1, int paramInt1, int paramInt2, boolean paramBoolean2)
    {
      this.mUseBitmapPrepareToDraw = paramBoolean1;
      this.mBitmapPrepareToDrawMinSizeBytes = paramInt1;
      this.mBitmapPrepareToDrawMaxSizeBytes = paramInt2;
      this.mBitmapPrepareToDrawForPrefetch = paramBoolean2;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setDecodeCancellationEnabled(boolean paramBoolean)
    {
      this.mDecodeCancellationEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setDownsampleIfLargeBitmap(boolean paramBoolean)
    {
      this.mDownsampleIfLargeBitmap = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setEncodedCacheEnabled(boolean paramBoolean)
    {
      this.mEncodedCacheEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setEnsureTranscoderLibraryLoaded(boolean paramBoolean)
    {
      this.mEnsureTranscoderLibraryLoaded = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setExperimentalMemoryType(long paramLong)
    {
      this.mMemoryType = paramLong;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setExperimentalThreadHandoffQueueEnabled(boolean paramBoolean)
    {
      this.mExperimentalThreadHandoffQueueEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setGingerbreadDecoderEnabled(boolean paramBoolean)
    {
      this.mGingerbreadDecoderEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setIsDiskCacheProbingEnabled(boolean paramBoolean)
    {
      this.mIsDiskCacheProbingEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setIsEncodedMemoryCacheProbingEnabled(boolean paramBoolean)
    {
      this.mIsEncodedMemoryCacheProbingEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setKeepCancelledFetchAsLowPriority(boolean paramBoolean)
    {
      this.mKeepCancelledFetchAsLowPriority = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setLazyDataSource(Supplier<Boolean> paramSupplier)
    {
      this.mLazyDataSource = paramSupplier;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setMaxBitmapSize(int paramInt)
    {
      this.mMaxBitmapSize = paramInt;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setNativeCodeDisabled(boolean paramBoolean)
    {
      this.mNativeCodeDisabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setPartialImageCachingEnabled(boolean paramBoolean)
    {
      this.mPartialImageCachingEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setProducerFactoryMethod(ImagePipelineExperiments.ProducerFactoryMethod paramProducerFactoryMethod)
    {
      this.mProducerFactoryMethod = paramProducerFactoryMethod;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setShouldDownscaleFrameToDrawableDimensions(boolean paramBoolean)
    {
      this.mDownscaleFrameToDrawableDimensions = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setSuppressBitmapPrefetchingSupplier(Supplier<Boolean> paramSupplier)
    {
      this.mSuppressBitmapPrefetchingSupplier = paramSupplier;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setTrackedKeysSize(int paramInt)
    {
      this.mTrackedKeysSize = paramInt;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setUseDownsampligRatioForResizing(boolean paramBoolean)
    {
      this.mUseDownsamplingRatioForResizing = paramBoolean;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setWebpBitmapFactory(WebpBitmapFactory paramWebpBitmapFactory)
    {
      this.mWebpBitmapFactory = paramWebpBitmapFactory;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setWebpErrorLogger(WebpBitmapFactory.WebpErrorLogger paramWebpErrorLogger)
    {
      this.mWebpErrorLogger = paramWebpErrorLogger;
      return this.mConfigBuilder;
    }
    
    public ImagePipelineConfig.Builder setWebpSupportEnabled(boolean paramBoolean)
    {
      this.mWebpSupportEnabled = paramBoolean;
      return this.mConfigBuilder;
    }
  }
  
  public static class DefaultProducerFactoryMethod
    implements ImagePipelineExperiments.ProducerFactoryMethod
  {
    public ProducerFactory createProducerFactory(Context paramContext, ByteArrayPool paramByteArrayPool, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ExecutorSupplier paramExecutorSupplier, PooledByteBufferFactory paramPooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, PlatformBitmapFactory paramPlatformBitmapFactory, int paramInt1, int paramInt2, boolean paramBoolean4, int paramInt3, CloseableReferenceFactory paramCloseableReferenceFactory, boolean paramBoolean5, int paramInt4)
    {
      return new ProducerFactory(paramContext, paramByteArrayPool, paramImageDecoder, paramProgressiveJpegConfig, paramBoolean1, paramBoolean2, paramBoolean3, paramExecutorSupplier, paramPooledByteBufferFactory, paramMemoryCache, paramMemoryCache1, paramBufferedDiskCache1, paramBufferedDiskCache2, paramCacheKeyFactory, paramPlatformBitmapFactory, paramInt1, paramInt2, paramBoolean4, paramInt3, paramCloseableReferenceFactory, paramBoolean5, paramInt4);
    }
  }
  
  public static abstract interface ProducerFactoryMethod
  {
    public abstract ProducerFactory createProducerFactory(Context paramContext, ByteArrayPool paramByteArrayPool, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ExecutorSupplier paramExecutorSupplier, PooledByteBufferFactory paramPooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, PlatformBitmapFactory paramPlatformBitmapFactory, int paramInt1, int paramInt2, boolean paramBoolean4, int paramInt3, CloseableReferenceFactory paramCloseableReferenceFactory, boolean paramBoolean5, int paramInt4);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ImagePipelineExperiments.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */