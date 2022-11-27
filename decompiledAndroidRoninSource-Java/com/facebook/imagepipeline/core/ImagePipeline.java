package com.facebook.imagepipeline.core;

import android.net.Uri;
import bolts.Continuation;
import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.callercontext.CallerContextVerifier;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Objects.ToStringHelper;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Predicate;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.datasource.DataSources;
import com.facebook.datasource.SimpleDataSource;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.datasource.ProducerToDataSourceAdapter;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.listener.ForwardingRequestListener;
import com.facebook.imagepipeline.listener.ForwardingRequestListener2;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.listener.RequestListener2;
import com.facebook.imagepipeline.producers.InternalRequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequest.CacheChoice;
import com.facebook.imagepipeline.request.ImageRequest.RequestLevel;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nullable;

public class ImagePipeline
{
  private static final CancellationException PREFETCH_EXCEPTION = new CancellationException("Prefetching is not enabled");
  private final MemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
  private final CacheKeyFactory mCacheKeyFactory;
  @Nullable
  private final CallerContextVerifier mCallerContextVerifier;
  private final ImagePipelineConfig mConfig;
  private final MemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
  private AtomicLong mIdCounter = new AtomicLong();
  private final Supplier<Boolean> mIsPrefetchEnabledSupplier;
  private final Supplier<Boolean> mLazyDataSource;
  private final BufferedDiskCache mMainBufferedDiskCache;
  private final ProducerSequenceFactory mProducerSequenceFactory;
  private final RequestListener mRequestListener;
  private final RequestListener2 mRequestListener2;
  private final BufferedDiskCache mSmallImageBufferedDiskCache;
  private final Supplier<Boolean> mSuppressBitmapPrefetchingSupplier;
  private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;
  
  public ImagePipeline(ProducerSequenceFactory paramProducerSequenceFactory, Set<RequestListener> paramSet, Set<RequestListener2> paramSet1, Supplier<Boolean> paramSupplier1, MemoryCache<CacheKey, CloseableImage> paramMemoryCache, MemoryCache<CacheKey, PooledByteBuffer> paramMemoryCache1, BufferedDiskCache paramBufferedDiskCache1, BufferedDiskCache paramBufferedDiskCache2, CacheKeyFactory paramCacheKeyFactory, ThreadHandoffProducerQueue paramThreadHandoffProducerQueue, Supplier<Boolean> paramSupplier2, Supplier<Boolean> paramSupplier3, @Nullable CallerContextVerifier paramCallerContextVerifier, ImagePipelineConfig paramImagePipelineConfig)
  {
    this.mProducerSequenceFactory = paramProducerSequenceFactory;
    this.mRequestListener = new ForwardingRequestListener(paramSet);
    this.mRequestListener2 = new ForwardingRequestListener2(paramSet1);
    this.mIsPrefetchEnabledSupplier = paramSupplier1;
    this.mBitmapMemoryCache = paramMemoryCache;
    this.mEncodedMemoryCache = paramMemoryCache1;
    this.mMainBufferedDiskCache = paramBufferedDiskCache1;
    this.mSmallImageBufferedDiskCache = paramBufferedDiskCache2;
    this.mCacheKeyFactory = paramCacheKeyFactory;
    this.mThreadHandoffProducerQueue = paramThreadHandoffProducerQueue;
    this.mSuppressBitmapPrefetchingSupplier = paramSupplier2;
    this.mLazyDataSource = paramSupplier3;
    this.mCallerContextVerifier = paramCallerContextVerifier;
    this.mConfig = paramImagePipelineConfig;
  }
  
  private Predicate<CacheKey> predicateForUri(final Uri paramUri)
  {
    new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        return paramAnonymousCacheKey.containsUri(paramUri);
      }
    };
  }
  
  private DataSource<Void> prefetchToBitmapCache(ImageRequest paramImageRequest, Object paramObject, Priority paramPriority)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }
    for (;;)
    {
      try
      {
        Object localObject = paramImageRequest.shouldDecodePrefetches();
        if (localObject != null)
        {
          if (((Boolean)localObject).booleanValue()) {
            break label116;
          }
          bool = true;
        }
        else
        {
          bool = ((Boolean)this.mSuppressBitmapPrefetchingSupplier.get()).booleanValue();
        }
        if (bool) {
          localObject = this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest);
        } else {
          localObject = this.mProducerSequenceFactory.getDecodedImagePrefetchProducerSequence(paramImageRequest);
        }
        paramImageRequest = submitPrefetchRequest((Producer)localObject, paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramPriority);
        return paramImageRequest;
      }
      catch (Exception paramImageRequest)
      {
        return DataSources.immediateFailedDataSource(paramImageRequest);
      }
      label116:
      boolean bool = false;
    }
  }
  
  /* Error */
  private <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject, @Nullable RequestListener paramRequestListener, @Nullable String paramString)
  {
    // Byte code:
    //   0: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   3: ifeq +8 -> 11
    //   6: ldc -77
    //   8: invokestatic 182	com/facebook/imagepipeline/systrace/FrescoSystrace:beginSection	(Ljava/lang/String;)V
    //   11: new 184	com/facebook/imagepipeline/producers/InternalRequestListener
    //   14: dup
    //   15: aload_0
    //   16: aload_2
    //   17: aload 5
    //   19: invokevirtual 188	com/facebook/imagepipeline/core/ImagePipeline:getRequestListenerForRequest	(Lcom/facebook/imagepipeline/request/ImageRequest;Lcom/facebook/imagepipeline/listener/RequestListener;)Lcom/facebook/imagepipeline/listener/RequestListener;
    //   22: aload_0
    //   23: getfield 89	com/facebook/imagepipeline/core/ImagePipeline:mRequestListener2	Lcom/facebook/imagepipeline/listener/RequestListener2;
    //   26: invokespecial 191	com/facebook/imagepipeline/producers/InternalRequestListener:<init>	(Lcom/facebook/imagepipeline/listener/RequestListener;Lcom/facebook/imagepipeline/listener/RequestListener2;)V
    //   29: astore 5
    //   31: aload_0
    //   32: getfield 109	com/facebook/imagepipeline/core/ImagePipeline:mCallerContextVerifier	Lcom/facebook/callercontext/CallerContextVerifier;
    //   35: astore 8
    //   37: aload 8
    //   39: ifnull +13 -> 52
    //   42: aload 8
    //   44: aload 4
    //   46: iconst_0
    //   47: invokeinterface 197 3 0
    //   52: aload_2
    //   53: invokevirtual 201	com/facebook/imagepipeline/request/ImageRequest:getLowestPermittedRequestLevel	()Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;
    //   56: aload_3
    //   57: invokestatic 205	com/facebook/imagepipeline/request/ImageRequest$RequestLevel:getMax	(Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;)Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;
    //   60: astore_3
    //   61: aload_0
    //   62: invokevirtual 209	com/facebook/imagepipeline/core/ImagePipeline:generateUniqueFutureId	()Ljava/lang/String;
    //   65: astore 8
    //   67: aload_2
    //   68: invokevirtual 212	com/facebook/imagepipeline/request/ImageRequest:getProgressiveRenderingEnabled	()Z
    //   71: ifne +100 -> 171
    //   74: aload_2
    //   75: invokevirtual 216	com/facebook/imagepipeline/request/ImageRequest:getSourceUri	()Landroid/net/Uri;
    //   78: invokestatic 222	com/facebook/common/util/UriUtil:isNetworkUri	(Landroid/net/Uri;)Z
    //   81: ifne +84 -> 165
    //   84: goto +87 -> 171
    //   87: aload_1
    //   88: new 224	com/facebook/imagepipeline/producers/SettableProducerContext
    //   91: dup
    //   92: aload_2
    //   93: aload 8
    //   95: aload 6
    //   97: aload 5
    //   99: aload 4
    //   101: aload_3
    //   102: iconst_0
    //   103: iload 7
    //   105: aload_2
    //   106: invokevirtual 228	com/facebook/imagepipeline/request/ImageRequest:getPriority	()Lcom/facebook/imagepipeline/common/Priority;
    //   109: aload_0
    //   110: getfield 111	com/facebook/imagepipeline/core/ImagePipeline:mConfig	Lcom/facebook/imagepipeline/core/ImagePipelineConfig;
    //   113: invokespecial 231	com/facebook/imagepipeline/producers/SettableProducerContext:<init>	(Lcom/facebook/imagepipeline/request/ImageRequest;Ljava/lang/String;Ljava/lang/String;Lcom/facebook/imagepipeline/producers/ProducerListener2;Ljava/lang/Object;Lcom/facebook/imagepipeline/request/ImageRequest$RequestLevel;ZZLcom/facebook/imagepipeline/common/Priority;Lcom/facebook/imagepipeline/core/ImagePipelineConfig;)V
    //   116: aload 5
    //   118: invokestatic 237	com/facebook/imagepipeline/datasource/CloseableProducerToDataSourceAdapter:create	(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/SettableProducerContext;Lcom/facebook/imagepipeline/listener/RequestListener2;)Lcom/facebook/datasource/DataSource;
    //   121: astore_1
    //   122: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   125: ifeq +6 -> 131
    //   128: invokestatic 240	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   131: aload_1
    //   132: areturn
    //   133: astore_1
    //   134: goto +20 -> 154
    //   137: astore_1
    //   138: aload_1
    //   139: invokestatic 144	com/facebook/datasource/DataSources:immediateFailedDataSource	(Ljava/lang/Throwable;)Lcom/facebook/datasource/DataSource;
    //   142: astore_1
    //   143: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   146: ifeq +6 -> 152
    //   149: invokestatic 240	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   152: aload_1
    //   153: areturn
    //   154: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   157: ifeq +6 -> 163
    //   160: invokestatic 240	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   163: aload_1
    //   164: athrow
    //   165: iconst_0
    //   166: istore 7
    //   168: goto -81 -> 87
    //   171: iconst_1
    //   172: istore 7
    //   174: goto -87 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	this	ImagePipeline
    //   0	177	1	paramProducer	Producer<CloseableReference<T>>
    //   0	177	2	paramImageRequest	ImageRequest
    //   0	177	3	paramRequestLevel	ImageRequest.RequestLevel
    //   0	177	4	paramObject	Object
    //   0	177	5	paramRequestListener	RequestListener
    //   0	177	6	paramString	String
    //   103	70	7	bool	boolean
    //   35	59	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   52	84	133	finally
    //   87	122	133	finally
    //   138	143	133	finally
    //   52	84	137	java/lang/Exception
    //   87	122	137	java/lang/Exception
  }
  
  private DataSource<Void> submitPrefetchRequest(Producer<Void> paramProducer, ImageRequest paramImageRequest, ImageRequest.RequestLevel paramRequestLevel, Object paramObject, Priority paramPriority)
  {
    InternalRequestListener localInternalRequestListener = new InternalRequestListener(getRequestListenerForRequest(paramImageRequest, null), this.mRequestListener2);
    CallerContextVerifier localCallerContextVerifier = this.mCallerContextVerifier;
    if (localCallerContextVerifier != null) {
      localCallerContextVerifier.verifyCallerContext(paramObject, true);
    }
    try
    {
      paramRequestLevel = ImageRequest.RequestLevel.getMax(paramImageRequest.getLowestPermittedRequestLevel(), paramRequestLevel);
      paramProducer = ProducerToDataSourceAdapter.create(paramProducer, new SettableProducerContext(paramImageRequest, generateUniqueFutureId(), localInternalRequestListener, paramObject, paramRequestLevel, true, false, paramPriority, this.mConfig), localInternalRequestListener);
      return paramProducer;
    }
    catch (Exception paramProducer) {}
    return DataSources.immediateFailedDataSource(paramProducer);
  }
  
  public void clearCaches()
  {
    clearMemoryCaches();
    clearDiskCaches();
  }
  
  public void clearDiskCaches()
  {
    this.mMainBufferedDiskCache.clearAll();
    this.mSmallImageBufferedDiskCache.clearAll();
  }
  
  public void clearMemoryCaches()
  {
    Predicate local5 = new Predicate()
    {
      public boolean apply(CacheKey paramAnonymousCacheKey)
      {
        return true;
      }
    };
    this.mBitmapMemoryCache.removeAll(local5);
    this.mEncodedMemoryCache.removeAll(local5);
  }
  
  public void evictFromCache(Uri paramUri)
  {
    evictFromMemoryCache(paramUri);
    evictFromDiskCache(paramUri);
  }
  
  public void evictFromDiskCache(Uri paramUri)
  {
    evictFromDiskCache(ImageRequest.fromUri(paramUri));
  }
  
  public void evictFromDiskCache(ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    this.mMainBufferedDiskCache.remove(paramImageRequest);
    this.mSmallImageBufferedDiskCache.remove(paramImageRequest);
  }
  
  public void evictFromMemoryCache(Uri paramUri)
  {
    paramUri = predicateForUri(paramUri);
    this.mBitmapMemoryCache.removeAll(paramUri);
    this.mEncodedMemoryCache.removeAll(paramUri);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.FULL_FETCH);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, @Nullable RequestListener paramRequestListener)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.FULL_FETCH, paramRequestListener);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel, null);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, @Nullable RequestListener paramRequestListener)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel, paramRequestListener, null);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchDecodedImage(ImageRequest paramImageRequest, Object paramObject, ImageRequest.RequestLevel paramRequestLevel, @Nullable RequestListener paramRequestListener, @Nullable String paramString)
  {
    try
    {
      paramImageRequest = submitFetchRequest(this.mProducerSequenceFactory.getDecodedImageProducerSequence(paramImageRequest), paramImageRequest, paramRequestLevel, paramObject, paramRequestListener, paramString);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchEncodedImage(paramImageRequest, paramObject, null);
  }
  
  public DataSource<CloseableReference<PooledByteBuffer>> fetchEncodedImage(ImageRequest paramImageRequest, Object paramObject, @Nullable RequestListener paramRequestListener)
  {
    Preconditions.checkNotNull(paramImageRequest.getSourceUri());
    try
    {
      Producer localProducer = this.mProducerSequenceFactory.getEncodedImageProducerSequence(paramImageRequest);
      ImageRequest localImageRequest = paramImageRequest;
      if (paramImageRequest.getResizeOptions() != null) {
        localImageRequest = ImageRequestBuilder.fromRequest(paramImageRequest).setResizeOptions(null).build();
      }
      paramImageRequest = submitFetchRequest(localProducer, localImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramRequestListener, null);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public DataSource<CloseableReference<CloseableImage>> fetchImageFromBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return fetchDecodedImage(paramImageRequest, paramObject, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE);
  }
  
  public String generateUniqueFutureId()
  {
    return String.valueOf(this.mIdCounter.getAndIncrement());
  }
  
  public MemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache()
  {
    return this.mBitmapMemoryCache;
  }
  
  @Nullable
  public CacheKey getCacheKey(@Nullable ImageRequest paramImageRequest, @Nullable Object paramObject)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("ImagePipeline#getCacheKey");
    }
    CacheKeyFactory localCacheKeyFactory = this.mCacheKeyFactory;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localCacheKeyFactory != null)
    {
      localObject1 = localObject2;
      if (paramImageRequest != null) {
        if (paramImageRequest.getPostprocessor() != null) {
          localObject1 = localCacheKeyFactory.getPostprocessedBitmapCacheKey(paramImageRequest, paramObject);
        } else {
          localObject1 = localCacheKeyFactory.getBitmapCacheKey(paramImageRequest, paramObject);
        }
      }
    }
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
    return (CacheKey)localObject1;
  }
  
  public CacheKeyFactory getCacheKeyFactory()
  {
    return this.mCacheKeyFactory;
  }
  
  @Nullable
  public CloseableReference<CloseableImage> getCachedImage(@Nullable CacheKey paramCacheKey)
  {
    MemoryCache localMemoryCache = this.mBitmapMemoryCache;
    if (localMemoryCache != null)
    {
      if (paramCacheKey == null) {
        return null;
      }
      paramCacheKey = localMemoryCache.get(paramCacheKey);
      if ((paramCacheKey != null) && (!((CloseableImage)paramCacheKey.get()).getQualityInfo().isOfFullQuality()))
      {
        paramCacheKey.close();
        return null;
      }
      return paramCacheKey;
    }
    return null;
  }
  
  public RequestListener getCombinedRequestListener(@Nullable RequestListener paramRequestListener)
  {
    if (paramRequestListener == null) {
      return this.mRequestListener;
    }
    return new ForwardingRequestListener(new RequestListener[] { this.mRequestListener, paramRequestListener });
  }
  
  public ImagePipelineConfig getConfig()
  {
    return this.mConfig;
  }
  
  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject, final ImageRequest.RequestLevel paramRequestLevel)
  {
    new Supplier()
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        return ImagePipeline.this.fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }
  
  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject, final ImageRequest.RequestLevel paramRequestLevel, @Nullable final RequestListener paramRequestListener)
  {
    new Supplier()
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        return ImagePipeline.this.fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel, paramRequestListener);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }
  
  public Supplier<DataSource<CloseableReference<CloseableImage>>> getDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject, final ImageRequest.RequestLevel paramRequestLevel, @Nullable final RequestListener paramRequestListener, @Nullable final String paramString)
  {
    new Supplier()
    {
      public DataSource<CloseableReference<CloseableImage>> get()
      {
        return ImagePipeline.this.fetchDecodedImage(paramImageRequest, paramObject, paramRequestLevel, paramRequestListener, paramString);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }
  
  public Supplier<DataSource<CloseableReference<PooledByteBuffer>>> getEncodedImageDataSourceSupplier(final ImageRequest paramImageRequest, final Object paramObject)
  {
    new Supplier()
    {
      public DataSource<CloseableReference<PooledByteBuffer>> get()
      {
        return ImagePipeline.this.fetchEncodedImage(paramImageRequest, paramObject);
      }
      
      public String toString()
      {
        return Objects.toStringHelper(this).add("uri", paramImageRequest.getSourceUri()).toString();
      }
    };
  }
  
  public ProducerSequenceFactory getProducerSequenceFactory()
  {
    return this.mProducerSequenceFactory;
  }
  
  public RequestListener getRequestListenerForRequest(ImageRequest paramImageRequest, @Nullable RequestListener paramRequestListener)
  {
    if (paramRequestListener == null)
    {
      if (paramImageRequest.getRequestListener() == null) {
        return this.mRequestListener;
      }
      return new ForwardingRequestListener(new RequestListener[] { this.mRequestListener, paramImageRequest.getRequestListener() });
    }
    if (paramImageRequest.getRequestListener() == null) {
      return new ForwardingRequestListener(new RequestListener[] { this.mRequestListener, paramRequestListener });
    }
    return new ForwardingRequestListener(new RequestListener[] { this.mRequestListener, paramRequestListener, paramImageRequest.getRequestListener() });
  }
  
  public long getUsedDiskCacheSize()
  {
    return this.mMainBufferedDiskCache.getSize() + this.mSmallImageBufferedDiskCache.getSize();
  }
  
  public boolean hasCachedImage(@Nullable CacheKey paramCacheKey)
  {
    MemoryCache localMemoryCache = this.mBitmapMemoryCache;
    if ((localMemoryCache != null) && (paramCacheKey != null)) {
      return localMemoryCache.contains(paramCacheKey);
    }
    return false;
  }
  
  public boolean isInBitmapMemoryCache(Uri paramUri)
  {
    if (paramUri == null) {
      return false;
    }
    paramUri = predicateForUri(paramUri);
    return this.mBitmapMemoryCache.contains(paramUri);
  }
  
  public boolean isInBitmapMemoryCache(ImageRequest paramImageRequest)
  {
    if (paramImageRequest == null) {
      return false;
    }
    paramImageRequest = this.mCacheKeyFactory.getBitmapCacheKey(paramImageRequest, null);
    paramImageRequest = this.mBitmapMemoryCache.get(paramImageRequest);
    try
    {
      boolean bool = CloseableReference.isValid(paramImageRequest);
      return bool;
    }
    finally
    {
      CloseableReference.closeSafely(paramImageRequest);
    }
  }
  
  public DataSource<Boolean> isInDiskCache(Uri paramUri)
  {
    return isInDiskCache(ImageRequest.fromUri(paramUri));
  }
  
  public DataSource<Boolean> isInDiskCache(final ImageRequest paramImageRequest)
  {
    paramImageRequest = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    final SimpleDataSource localSimpleDataSource = SimpleDataSource.create();
    this.mMainBufferedDiskCache.contains(paramImageRequest).continueWithTask(new Continuation()
    {
      public Task<Boolean> then(Task<Boolean> paramAnonymousTask)
        throws Exception
      {
        if ((!paramAnonymousTask.isCancelled()) && (!paramAnonymousTask.isFaulted()) && (((Boolean)paramAnonymousTask.getResult()).booleanValue())) {
          return Task.forResult(Boolean.valueOf(true));
        }
        return ImagePipeline.this.mSmallImageBufferedDiskCache.contains(paramImageRequest);
      }
    }).continueWith(new Continuation()
    {
      public Void then(Task<Boolean> paramAnonymousTask)
        throws Exception
      {
        SimpleDataSource localSimpleDataSource = localSimpleDataSource;
        boolean bool;
        if ((!paramAnonymousTask.isCancelled()) && (!paramAnonymousTask.isFaulted()) && (((Boolean)paramAnonymousTask.getResult()).booleanValue())) {
          bool = true;
        } else {
          bool = false;
        }
        localSimpleDataSource.setResult(Boolean.valueOf(bool));
        return null;
      }
    });
    return localSimpleDataSource;
  }
  
  public boolean isInDiskCacheSync(Uri paramUri)
  {
    return (isInDiskCacheSync(paramUri, ImageRequest.CacheChoice.SMALL)) || (isInDiskCacheSync(paramUri, ImageRequest.CacheChoice.DEFAULT));
  }
  
  public boolean isInDiskCacheSync(Uri paramUri, ImageRequest.CacheChoice paramCacheChoice)
  {
    return isInDiskCacheSync(ImageRequestBuilder.newBuilderWithSource(paramUri).setCacheChoice(paramCacheChoice).build());
  }
  
  public boolean isInDiskCacheSync(ImageRequest paramImageRequest)
  {
    CacheKey localCacheKey = this.mCacheKeyFactory.getEncodedCacheKey(paramImageRequest, null);
    paramImageRequest = paramImageRequest.getCacheChoice();
    int i = 9.$SwitchMap$com$facebook$imagepipeline$request$ImageRequest$CacheChoice[paramImageRequest.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return false;
      }
      return this.mSmallImageBufferedDiskCache.diskCheckSync(localCacheKey);
    }
    return this.mMainBufferedDiskCache.diskCheckSync(localCacheKey);
  }
  
  public Supplier<Boolean> isLazyDataSource()
  {
    return this.mLazyDataSource;
  }
  
  public boolean isPaused()
  {
    return this.mThreadHandoffProducerQueue.isQueueing();
  }
  
  public void pause()
  {
    this.mThreadHandoffProducerQueue.startQueueing();
  }
  
  public DataSource<Void> prefetchToBitmapCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return prefetchToBitmapCache(paramImageRequest, paramObject, Priority.MEDIUM);
  }
  
  @Deprecated
  public DataSource<Void> prefetchToBitmapCacheWithHighPriority(ImageRequest paramImageRequest, Object paramObject)
  {
    return prefetchToBitmapCache(paramImageRequest, paramObject, Priority.HIGH);
  }
  
  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return prefetchToDiskCache(paramImageRequest, paramObject, Priority.MEDIUM);
  }
  
  public DataSource<Void> prefetchToDiskCache(ImageRequest paramImageRequest, Object paramObject, Priority paramPriority)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }
    try
    {
      paramImageRequest = submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramPriority);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public DataSource<Void> prefetchToEncodedCache(ImageRequest paramImageRequest, Object paramObject)
  {
    return prefetchToEncodedCache(paramImageRequest, paramObject, Priority.MEDIUM);
  }
  
  public DataSource<Void> prefetchToEncodedCache(ImageRequest paramImageRequest, Object paramObject, Priority paramPriority)
  {
    if (!((Boolean)this.mIsPrefetchEnabledSupplier.get()).booleanValue()) {
      return DataSources.immediateFailedDataSource(PREFETCH_EXCEPTION);
    }
    try
    {
      paramImageRequest = submitPrefetchRequest(this.mProducerSequenceFactory.getEncodedImagePrefetchProducerSequence(paramImageRequest), paramImageRequest, ImageRequest.RequestLevel.FULL_FETCH, paramObject, paramPriority);
      return paramImageRequest;
    }
    catch (Exception paramImageRequest) {}
    return DataSources.immediateFailedDataSource(paramImageRequest);
  }
  
  public void resume()
  {
    this.mThreadHandoffProducerQueue.stopQueuing();
  }
  
  /* Error */
  public <T> DataSource<CloseableReference<T>> submitFetchRequest(Producer<CloseableReference<T>> paramProducer, SettableProducerContext paramSettableProducerContext, RequestListener paramRequestListener)
  {
    // Byte code:
    //   0: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   3: ifeq +8 -> 11
    //   6: ldc -77
    //   8: invokestatic 182	com/facebook/imagepipeline/systrace/FrescoSystrace:beginSection	(Ljava/lang/String;)V
    //   11: aload_1
    //   12: aload_2
    //   13: new 184	com/facebook/imagepipeline/producers/InternalRequestListener
    //   16: dup
    //   17: aload_3
    //   18: aload_0
    //   19: getfield 89	com/facebook/imagepipeline/core/ImagePipeline:mRequestListener2	Lcom/facebook/imagepipeline/listener/RequestListener2;
    //   22: invokespecial 191	com/facebook/imagepipeline/producers/InternalRequestListener:<init>	(Lcom/facebook/imagepipeline/listener/RequestListener;Lcom/facebook/imagepipeline/listener/RequestListener2;)V
    //   25: invokestatic 237	com/facebook/imagepipeline/datasource/CloseableProducerToDataSourceAdapter:create	(Lcom/facebook/imagepipeline/producers/Producer;Lcom/facebook/imagepipeline/producers/SettableProducerContext;Lcom/facebook/imagepipeline/listener/RequestListener2;)Lcom/facebook/datasource/DataSource;
    //   28: astore_1
    //   29: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   32: ifeq +6 -> 38
    //   35: invokestatic 240	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   38: aload_1
    //   39: areturn
    //   40: astore_1
    //   41: goto +20 -> 61
    //   44: astore_1
    //   45: aload_1
    //   46: invokestatic 144	com/facebook/datasource/DataSources:immediateFailedDataSource	(Ljava/lang/Throwable;)Lcom/facebook/datasource/DataSource;
    //   49: astore_1
    //   50: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   53: ifeq +6 -> 59
    //   56: invokestatic 240	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   59: aload_1
    //   60: areturn
    //   61: invokestatic 177	com/facebook/imagepipeline/systrace/FrescoSystrace:isTracing	()Z
    //   64: ifeq +6 -> 70
    //   67: invokestatic 240	com/facebook/imagepipeline/systrace/FrescoSystrace:endSection	()V
    //   70: aload_1
    //   71: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	72	0	this	ImagePipeline
    //   0	72	1	paramProducer	Producer<CloseableReference<T>>
    //   0	72	2	paramSettableProducerContext	SettableProducerContext
    //   0	72	3	paramRequestListener	RequestListener
    // Exception table:
    //   from	to	target	type
    //   11	29	40	finally
    //   45	50	40	finally
    //   11	29	44	java/lang/Exception
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\core\ImagePipeline.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */