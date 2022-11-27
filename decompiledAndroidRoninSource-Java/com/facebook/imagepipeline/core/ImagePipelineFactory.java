package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build.VERSION;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoderConfig;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ExperimentalThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import javax.annotation.Nullable;

public class ImagePipelineFactory
{
  private static final Class<?> TAG = ImagePipelineFactory.class;
  private static boolean sForceSinglePipelineInstance;
  private static ImagePipeline sImagePipeline;
  private static ImagePipelineFactory sInstance;
  private AnimatedFactory mAnimatedFactory;
  private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
  private InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final CloseableReferenceFactory mCloseableReferenceFactory;
  private final ImagePipelineConfig mConfig;
  private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
  private InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private ImageDecoder mImageDecoder;
  private ImagePipeline mImagePipeline;
  private ImageTranscoderFactory mImageTranscoderFactory;
  private BufferedDiskCache mMainBufferedDiskCache;
  private FileCache mMainFileCache;
  private PlatformBitmapFactory mPlatformBitmapFactory;
  private PlatformDecoder mPlatformDecoder;
  private ProducerFactory mProducerFactory;
  private ProducerSequenceFactory mProducerSequenceFactory;
  private BufferedDiskCache mSmallImageBufferedDiskCache;
  private FileCache mSmallImageFileCache;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  
  public ImagePipelineFactory(ImagePipelineConfig paramImagePipelineConfig)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("ImagePipelineConfig()");
    }
    Object localObject = (ImagePipelineConfig)Preconditions.checkNotNull(paramImagePipelineConfig);
    this.mConfig = ((ImagePipelineConfig)localObject);
    if (((ImagePipelineConfig)localObject).getExperiments().isExperimentalThreadHandoffQueueEnabled()) {
      localObject = new ExperimentalThreadHandoffProducerQueueImpl(paramImagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
    } else {
      localObject = new ThreadHandoffProducerQueueImpl(paramImagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
    }
    this.mThreadHandoffProducerQueue = ((ThreadHandoffProducerQueue)localObject);
    CloseableReference.setDisableCloseableReferencesForBitmaps(paramImagePipelineConfig.getExperiments().getBitmapCloseableRefType());
    this.mCloseableReferenceFactory = new CloseableReferenceFactory(paramImagePipelineConfig.getCloseableReferenceLeakTracker());
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
  
  private ImagePipeline createImagePipeline()
  {
    return new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getRequestListener2s(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getSuppressBitmapPrefetchingSupplier(), this.mConfig.getExperiments().isLazyDataSource(), this.mConfig.getCallerContextVerifier(), this.mConfig);
  }
  
  @Nullable
  private AnimatedFactory getAnimatedFactory()
  {
    if (this.mAnimatedFactory == null) {
      this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.mConfig.getExperiments().shouldDownscaleFrameToDrawableDimensions());
    }
    return this.mAnimatedFactory;
  }
  
  private ImageDecoder getImageDecoder()
  {
    if (this.mImageDecoder == null) {
      if (this.mConfig.getImageDecoder() != null)
      {
        this.mImageDecoder = this.mConfig.getImageDecoder();
      }
      else
      {
        Object localObject = getAnimatedFactory();
        ImageDecoder localImageDecoder = null;
        if (localObject != null)
        {
          localImageDecoder = ((AnimatedFactory)localObject).getGifDecoder(this.mConfig.getBitmapConfig());
          localObject = ((AnimatedFactory)localObject).getWebPDecoder(this.mConfig.getBitmapConfig());
        }
        else
        {
          localObject = null;
        }
        if (this.mConfig.getImageDecoderConfig() == null)
        {
          this.mImageDecoder = new DefaultImageDecoder(localImageDecoder, (ImageDecoder)localObject, getPlatformDecoder());
        }
        else
        {
          this.mImageDecoder = new DefaultImageDecoder(localImageDecoder, (ImageDecoder)localObject, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
          ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
        }
      }
    }
    return this.mImageDecoder;
  }
  
  private ImageTranscoderFactory getImageTranscoderFactory()
  {
    if (this.mImageTranscoderFactory == null) {
      if ((this.mConfig.getImageTranscoderFactory() == null) && (this.mConfig.getImageTranscoderType() == null) && (this.mConfig.getExperiments().isNativeCodeDisabled())) {
        this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize());
      } else {
        this.mImageTranscoderFactory = new MultiImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize(), this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.getImageTranscoderFactory(), this.mConfig.getImageTranscoderType(), this.mConfig.getExperiments().isEnsureTranscoderLibraryLoaded());
      }
    }
    return this.mImageTranscoderFactory;
  }
  
  public static ImagePipelineFactory getInstance()
  {
    return (ImagePipelineFactory)Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
  }
  
  private ProducerFactory getProducerFactory()
  {
    if (this.mProducerFactory == null) {
      this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.getExperiments().getMaxBitmapSize(), getCloseableReferenceFactory(), this.mConfig.getExperiments().shouldKeepCancelledFetchAsLowPriority(), this.mConfig.getExperiments().getTrackedKeysSize());
    }
    return this.mProducerFactory;
  }
  
  private ProducerSequenceFactory getProducerSequenceFactory()
  {
    boolean bool;
    if ((Build.VERSION.SDK_INT >= 24) && (this.mConfig.getExperiments().getUseBitmapPrepareToDraw())) {
      bool = true;
    } else {
      bool = false;
    }
    if (this.mProducerSequenceFactory == null) {
      this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.isDownsampleEnabled(), bool, this.mConfig.getExperiments().isPartialImageCachingEnabled(), this.mConfig.isDiskCacheEnabled(), getImageTranscoderFactory(), this.mConfig.getExperiments().isEncodedMemoryCacheProbingEnabled(), this.mConfig.getExperiments().isDiskCacheProbingEnabled());
    }
    return this.mProducerSequenceFactory;
  }
  
  private BufferedDiskCache getSmallImageBufferedDiskCache()
  {
    if (this.mSmallImageBufferedDiskCache == null) {
      this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    }
    return this.mSmallImageBufferedDiskCache;
  }
  
  public static boolean hasBeenInitialized()
  {
    try
    {
      ImagePipelineFactory localImagePipelineFactory = sInstance;
      boolean bool;
      if (localImagePipelineFactory != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static void initialize(Context paramContext)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
      }
      initialize(ImagePipelineConfig.newBuilder(paramContext).build());
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return;
    }
    finally {}
  }
  
  public static void initialize(ImagePipelineConfig paramImagePipelineConfig)
  {
    try
    {
      if (sInstance != null) {
        FLog.w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
      }
      sInstance = new ImagePipelineFactory(paramImagePipelineConfig);
      return;
    }
    finally {}
  }
  
  public static void initialize(ImagePipelineConfig paramImagePipelineConfig, boolean paramBoolean)
  {
    try
    {
      if (sInstance != null) {
        FLog.w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
      }
      sForceSinglePipelineInstance = paramBoolean;
      sInstance = new ImagePipelineFactory(paramImagePipelineConfig);
      return;
    }
    finally {}
  }
  
  public static void setInstance(ImagePipelineFactory paramImagePipelineFactory)
  {
    sInstance = paramImagePipelineFactory;
  }
  
  public static void shutDown()
  {
    try
    {
      if (sInstance != null)
      {
        sInstance.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
        sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
        sInstance = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  @Nullable
  public DrawableFactory getAnimatedDrawableFactory(Context paramContext)
  {
    AnimatedFactory localAnimatedFactory = getAnimatedFactory();
    if (localAnimatedFactory == null) {
      return null;
    }
    return localAnimatedFactory.getAnimatedDrawableFactory(paramContext);
  }
  
  public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache()
  {
    if (this.mBitmapCountingMemoryCache == null) {
      this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy(), this.mConfig.getBitmapMemoryCacheEntryStateObserver());
    }
    return this.mBitmapCountingMemoryCache;
  }
  
  public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    if (this.mBitmapMemoryCache == null)
    {
      Object localObject;
      if (this.mConfig.getBitmapCacheOverride() != null) {
        localObject = this.mConfig.getBitmapCacheOverride();
      } else {
        localObject = getBitmapCountingMemoryCache();
      }
      this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get((MemoryCache)localObject, this.mConfig.getImageCacheStatsTracker());
    }
    return this.mBitmapMemoryCache;
  }
  
  public CloseableReferenceFactory getCloseableReferenceFactory()
  {
    return this.mCloseableReferenceFactory;
  }
  
  public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache()
  {
    if (this.mEncodedCountingMemoryCache == null) {
      this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
    }
    return this.mEncodedCountingMemoryCache;
  }
  
  public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache()
  {
    if (this.mEncodedMemoryCache == null)
    {
      Object localObject;
      if (this.mConfig.getEncodedMemoryCacheOverride() != null) {
        localObject = this.mConfig.getEncodedMemoryCacheOverride();
      } else {
        localObject = getEncodedCountingMemoryCache();
      }
      this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get((MemoryCache)localObject, this.mConfig.getImageCacheStatsTracker());
    }
    return this.mEncodedMemoryCache;
  }
  
  public ImagePipeline getImagePipeline()
  {
    if (sForceSinglePipelineInstance)
    {
      if (sImagePipeline == null)
      {
        ImagePipeline localImagePipeline = createImagePipeline();
        sImagePipeline = localImagePipeline;
        this.mImagePipeline = localImagePipeline;
      }
      return sImagePipeline;
    }
    if (this.mImagePipeline == null) {
      this.mImagePipeline = createImagePipeline();
    }
    return this.mImagePipeline;
  }
  
  public BufferedDiskCache getMainBufferedDiskCache()
  {
    if (this.mMainBufferedDiskCache == null) {
      this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
    }
    return this.mMainBufferedDiskCache;
  }
  
  public FileCache getMainFileCache()
  {
    if (this.mMainFileCache == null)
    {
      DiskCacheConfig localDiskCacheConfig = this.mConfig.getMainDiskCacheConfig();
      this.mMainFileCache = this.mConfig.getFileCacheFactory().get(localDiskCacheConfig);
    }
    return this.mMainFileCache;
  }
  
  public PlatformBitmapFactory getPlatformBitmapFactory()
  {
    if (this.mPlatformBitmapFactory == null) {
      this.mPlatformBitmapFactory = PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
    }
    return this.mPlatformBitmapFactory;
  }
  
  public PlatformDecoder getPlatformDecoder()
  {
    if (this.mPlatformDecoder == null) {
      this.mPlatformDecoder = PlatformDecoderFactory.buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isGingerbreadDecoderEnabled());
    }
    return this.mPlatformDecoder;
  }
  
  public FileCache getSmallImageFileCache()
  {
    if (this.mSmallImageFileCache == null)
    {
      DiskCacheConfig localDiskCacheConfig = this.mConfig.getSmallImageDiskCacheConfig();
      this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(localDiskCacheConfig);
    }
    return this.mSmallImageFileCache;
  }
  
  @Nullable
  public String reportData()
  {
    return Objects.toStringHelper("ImagePipelineFactory").add("bitmapCountingMemoryCache", this.mBitmapCountingMemoryCache.reportData()).add("encodedCountingMemoryCache", this.mEncodedCountingMemoryCache.reportData()).toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ImagePipelineFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */