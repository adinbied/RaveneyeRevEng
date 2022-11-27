package com.facebook.imagepipeline.core;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Suppliers;
import com.facebook.common.memory.ByteArrayPool;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.cache.BoundedLinkedHashSet;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.decoder.ProgressiveJpegConfig;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.producers.AddImageTransformMetaDataProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.BitmapPrepareProducer;
import com.facebook.imagepipeline.producers.BitmapProbeProducer;
import com.facebook.imagepipeline.producers.BranchOnSeparateImagesProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.DiskCacheWriteProducer;
import com.facebook.imagepipeline.producers.EncodedCacheKeyMultiplexProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.EncodedProbeProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalExifThumbnailProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.NullProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessorProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.facebook.imagepipeline.producers.ResizeAndRotateProducer;
import com.facebook.imagepipeline.producers.SwallowResultProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducer;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThrottlingProducer;
import com.facebook.imagepipeline.producers.ThumbnailBranchProducer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.producers.WebpTranscodeProducer;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;

public class ProducerFactory
{
  private static final int MAX_SIMULTANEOUS_REQUESTS = 5;
  protected AssetManager mAssetManager;
  protected final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  protected boolean mBitmapPrepareToDrawForPrefetch;
  protected final int mBitmapPrepareToDrawMaxSizeBytes;
  protected final int mBitmapPrepareToDrawMinSizeBytes;
  protected final ByteArrayPool mByteArrayPool;
  protected final CacheKeyFactory mCacheKeyFactory;
  protected final CloseableReferenceFactory mCloseableReferenceFactory;
  protected ContentResolver mContentResolver;
  protected final boolean mDecodeCancellationEnabled;
  protected final BufferedDiskCache mDefaultBufferedDiskCache;
  protected final BoundedLinkedHashSet<CacheKey> mDiskCacheHistory;
  protected final boolean mDownsampleEnabled;
  protected final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  protected final BoundedLinkedHashSet<CacheKey> mEncodedMemoryCacheHistory;
  protected final ExecutorSupplier mExecutorSupplier;
  protected final ImageDecoder mImageDecoder;
  protected final boolean mKeepCancelledFetchAsLowPriority;
  protected final int mMaxBitmapSize;
  protected final PlatformBitmapFactory mPlatformBitmapFactory;
  protected final PooledByteBufferFactory mPooledByteBufferFactory;
  protected final ProgressiveJpegConfig mProgressiveJpegConfig;
  protected final boolean mResizeAndRotateEnabledForNetwork;
  protected Resources mResources;
  protected final BufferedDiskCache mSmallImageBufferedDiskCache;
  
  public ProducerFactory(Context paramContext, ByteArrayPool paramByteArrayPool, ImageDecoder paramImageDecoder, ProgressiveJpegConfig paramProgressiveJpegConfig, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, ExecutorSupplier paramExecutorSupplier, PooledByteBufferFactory paramPooledByteBufferFactory, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, PlatformBitmapFactory paramPlatformBitmapFactory, int paramInt1, int paramInt2, boolean paramBoolean4, int paramInt3, CloseableReferenceFactory paramCloseableReferenceFactory, boolean paramBoolean5, int paramInt4)
  {
    this.mContentResolver = paramContext.getApplicationContext().getContentResolver();
    this.mResources = paramContext.getApplicationContext().getResources();
    this.mAssetManager = paramContext.getApplicationContext().getAssets();
    this.mByteArrayPool = paramByteArrayPool;
    this.mImageDecoder = paramImageDecoder;
    this.mProgressiveJpegConfig = paramProgressiveJpegConfig;
    this.mDownsampleEnabled = paramBoolean1;
    this.mResizeAndRotateEnabledForNetwork = paramBoolean2;
    this.mDecodeCancellationEnabled = paramBoolean3;
    this.mExecutorSupplier = paramExecutorSupplier;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mDefaultBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mPlatformBitmapFactory = paramPlatformBitmapFactory;
    this.mEncodedMemoryCacheHistory = new BoundedLinkedHashSet(paramInt4);
    this.mDiskCacheHistory = new BoundedLinkedHashSet(paramInt4);
    this.mBitmapPrepareToDrawMinSizeBytes = paramInt1;
    this.mBitmapPrepareToDrawMaxSizeBytes = paramInt2;
    this.mBitmapPrepareToDrawForPrefetch = paramBoolean4;
    this.mMaxBitmapSize = paramInt3;
    this.mCloseableReferenceFactory = paramCloseableReferenceFactory;
    this.mKeepCancelledFetchAsLowPriority = paramBoolean5;
  }
  
  public static AddImageTransformMetaDataProducer newAddImageTransformMetaDataProducer(Producer<EncodedImage> paramProducer)
  {
    return new AddImageTransformMetaDataProducer(paramProducer);
  }
  
  public static BranchOnSeparateImagesProducer newBranchOnSeparateImagesProducer(Producer<EncodedImage> paramProducer1, Producer<EncodedImage> paramProducer2)
  {
    return new BranchOnSeparateImagesProducer(paramProducer1, paramProducer2);
  }
  
  public static <T> NullProducer<T> newNullProducer()
  {
    return new NullProducer();
  }
  
  public static <T> SwallowResultProducer<T> newSwallowResultProducer(Producer<T> paramProducer)
  {
    return new SwallowResultProducer(paramProducer);
  }
  
  public <T> ThreadHandoffProducer<T> newBackgroundThreadHandoffProducer(Producer<T> paramProducer, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue)
  {
    return new ThreadHandoffProducer(paramProducer, paramThreadHandoffProducerQueue);
  }
  
  public BitmapMemoryCacheGetProducer newBitmapMemoryCacheGetProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheGetProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public BitmapMemoryCacheKeyMultiplexProducer newBitmapMemoryCacheKeyMultiplexProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheKeyMultiplexProducer(this.mCacheKeyFactory, paramProducer);
  }
  
  public BitmapMemoryCacheProducer newBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public BitmapPrepareProducer newBitmapPrepareProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapPrepareProducer(paramProducer, this.mBitmapPrepareToDrawMinSizeBytes, this.mBitmapPrepareToDrawMaxSizeBytes, this.mBitmapPrepareToDrawForPrefetch);
  }
  
  public BitmapProbeProducer newBitmapProbeProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new BitmapProbeProducer(this.mEncodedMemoryCache, this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, paramProducer);
  }
  
  public DataFetchProducer newDataFetchProducer()
  {
    return new DataFetchProducer(this.mPooledByteBufferFactory);
  }
  
  public DecodeProducer newDecodeProducer(Producer<EncodedImage> paramProducer)
  {
    return new DecodeProducer(this.mByteArrayPool, this.mExecutorSupplier.forDecode(), this.mImageDecoder, this.mProgressiveJpegConfig, this.mDownsampleEnabled, this.mResizeAndRotateEnabledForNetwork, this.mDecodeCancellationEnabled, paramProducer, this.mMaxBitmapSize, this.mCloseableReferenceFactory, null, Suppliers.BOOLEAN_FALSE);
  }
  
  public DiskCacheReadProducer newDiskCacheReadProducer(Producer<EncodedImage> paramProducer)
  {
    return new DiskCacheReadProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public DiskCacheWriteProducer newDiskCacheWriteProducer(Producer<EncodedImage> paramProducer)
  {
    return new DiskCacheWriteProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public EncodedCacheKeyMultiplexProducer newEncodedCacheKeyMultiplexProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedCacheKeyMultiplexProducer(this.mCacheKeyFactory, this.mKeepCancelledFetchAsLowPriority, paramProducer);
  }
  
  public EncodedMemoryCacheProducer newEncodedMemoryCacheProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedMemoryCacheProducer(this.mEncodedMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public EncodedProbeProducer newEncodedProbeProducer(Producer<EncodedImage> paramProducer)
  {
    return new EncodedProbeProducer(this.mDefaultBufferedDiskCache, this.mSmallImageBufferedDiskCache, this.mCacheKeyFactory, this.mEncodedMemoryCacheHistory, this.mDiskCacheHistory, paramProducer);
  }
  
  public LocalAssetFetchProducer newLocalAssetFetchProducer()
  {
    return new LocalAssetFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mAssetManager);
  }
  
  public LocalContentUriFetchProducer newLocalContentUriFetchProducer()
  {
    return new LocalContentUriFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }
  
  public LocalContentUriThumbnailFetchProducer newLocalContentUriThumbnailFetchProducer()
  {
    return new LocalContentUriThumbnailFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }
  
  public LocalExifThumbnailProducer newLocalExifThumbnailProducer()
  {
    return new LocalExifThumbnailProducer(this.mExecutorSupplier.forThumbnailProducer(), this.mPooledByteBufferFactory, this.mContentResolver);
  }
  
  public LocalFileFetchProducer newLocalFileFetchProducer()
  {
    return new LocalFileFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory);
  }
  
  public LocalResourceFetchProducer newLocalResourceFetchProducer()
  {
    return new LocalResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mResources);
  }
  
  public LocalVideoThumbnailProducer newLocalVideoThumbnailProducer()
  {
    return new LocalVideoThumbnailProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mContentResolver);
  }
  
  public Producer<EncodedImage> newNetworkFetchProducer(NetworkFetcher paramNetworkFetcher)
  {
    return new NetworkFetchProducer(this.mPooledByteBufferFactory, this.mByteArrayPool, paramNetworkFetcher);
  }
  
  public PartialDiskCacheProducer newPartialDiskCacheProducer(Producer<EncodedImage> paramProducer)
  {
    return new PartialDiskCacheProducer(this.mDefaultBufferedDiskCache, this.mCacheKeyFactory, this.mPooledByteBufferFactory, this.mByteArrayPool, paramProducer);
  }
  
  public PostprocessedBitmapMemoryCacheProducer newPostprocessorBitmapMemoryCacheProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new PostprocessedBitmapMemoryCacheProducer(this.mBitmapMemoryCache, this.mCacheKeyFactory, paramProducer);
  }
  
  public PostprocessorProducer newPostprocessorProducer(Producer<CloseableReference<CloseableImage>> paramProducer)
  {
    return new PostprocessorProducer(paramProducer, this.mPlatformBitmapFactory, this.mExecutorSupplier.forBackgroundTasks());
  }
  
  public QualifiedResourceFetchProducer newQualifiedResourceFetchProducer()
  {
    return new QualifiedResourceFetchProducer(this.mExecutorSupplier.forLocalStorageRead(), this.mPooledByteBufferFactory, this.mContentResolver);
  }
  
  public ResizeAndRotateProducer newResizeAndRotateProducer(Producer<EncodedImage> paramProducer, boolean paramBoolean, ImageTranscoderFactory paramImageTranscoderFactory)
  {
    return new ResizeAndRotateProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, paramProducer, paramBoolean, paramImageTranscoderFactory);
  }
  
  public <T> ThrottlingProducer<T> newThrottlingProducer(Producer<T> paramProducer)
  {
    return new ThrottlingProducer(5, this.mExecutorSupplier.forLightweightBackgroundTasks(), paramProducer);
  }
  
  public ThumbnailBranchProducer newThumbnailBranchProducer(ThumbnailProducer<EncodedImage>[] paramArrayOfThumbnailProducer)
  {
    return new ThumbnailBranchProducer(paramArrayOfThumbnailProducer);
  }
  
  public WebpTranscodeProducer newWebpTranscodeProducer(Producer<EncodedImage> paramProducer)
  {
    return new WebpTranscodeProducer(this.mExecutorSupplier.forBackgroundTasks(), this.mPooledByteBufferFactory, paramProducer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ProducerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */