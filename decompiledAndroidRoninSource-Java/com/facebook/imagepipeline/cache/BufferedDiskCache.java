package com.facebook.imagepipeline.cache;

import bolts.Task;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBufferFactory;
import com.facebook.common.memory.PooledByteStreams;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.instrumentation.FrescoInstrumenter;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.Nullable;

public class BufferedDiskCache
{
  private static final Class<?> TAG = BufferedDiskCache.class;
  private final FileCache mFileCache;
  private final ImageCacheStatsTracker mImageCacheStatsTracker;
  private final PooledByteBufferFactory mPooledByteBufferFactory;
  private final PooledByteStreams mPooledByteStreams;
  private final Executor mReadExecutor;
  private final StagingArea mStagingArea;
  private final Executor mWriteExecutor;
  
  public BufferedDiskCache(FileCache paramFileCache, PooledByteBufferFactory paramPooledByteBufferFactory, PooledByteStreams paramPooledByteStreams, Executor paramExecutor1, Executor paramExecutor2, ImageCacheStatsTracker paramImageCacheStatsTracker)
  {
    this.mFileCache = paramFileCache;
    this.mPooledByteBufferFactory = paramPooledByteBufferFactory;
    this.mPooledByteStreams = paramPooledByteStreams;
    this.mReadExecutor = paramExecutor1;
    this.mWriteExecutor = paramExecutor2;
    this.mImageCacheStatsTracker = paramImageCacheStatsTracker;
    this.mStagingArea = StagingArea.getInstance();
  }
  
  private boolean checkInStagingAreaAndFileCache(CacheKey paramCacheKey)
  {
    EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
    if (localEncodedImage != null)
    {
      localEncodedImage.close();
      FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
      this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
      return true;
    }
    FLog.v(TAG, "Did not find image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaMiss(paramCacheKey);
    try
    {
      boolean bool = this.mFileCache.hasKey(paramCacheKey);
      return bool;
    }
    catch (Exception paramCacheKey)
    {
      for (;;) {}
    }
    return false;
  }
  
  private Task<Boolean> containsAsync(final CacheKey paramCacheKey)
  {
    try
    {
      Task localTask = Task.call(new Callable()
      {
        public Boolean call()
          throws Exception
        {
          Object localObject1 = FrescoInstrumenter.onBeginWork(this.val$token, null);
          try
          {
            boolean bool = BufferedDiskCache.this.checkInStagingAreaAndFileCache(paramCacheKey);
            FrescoInstrumenter.onEndWork(localObject1);
            return Boolean.valueOf(bool);
          }
          finally
          {
            try
            {
              FrescoInstrumenter.markFailure(this.val$token, localThrowable);
              throw localThrowable;
            }
            finally
            {
              FrescoInstrumenter.onEndWork(localObject1);
            }
          }
        }
      }, this.mReadExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.getUriString() });
      return Task.forError(localException);
    }
  }
  
  private Task<EncodedImage> foundPinnedImage(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
    this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
    return Task.forResult(paramEncodedImage);
  }
  
  private Task<EncodedImage> getAsync(final CacheKey paramCacheKey, final AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      paramAtomicBoolean = Task.call(new Callable()
      {
        @Nullable
        public EncodedImage call()
          throws Exception
        {
          localObject4 = FrescoInstrumenter.onBeginWork(this.val$token, null);
          for (;;)
          {
            try
            {
              if (!paramAtomicBoolean.get())
              {
                localObject1 = BufferedDiskCache.this.mStagingArea.get(paramCacheKey);
                if (localObject1 != null)
                {
                  FLog.v(BufferedDiskCache.TAG, "Found image for %s in staging area", paramCacheKey.getUriString());
                  BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaHit(paramCacheKey);
                }
                else
                {
                  FLog.v(BufferedDiskCache.TAG, "Did not find image for %s in staging area", paramCacheKey.getUriString());
                  BufferedDiskCache.this.mImageCacheStatsTracker.onStagingAreaMiss(paramCacheKey);
                }
              }
            }
            finally
            {
              try
              {
                Object localObject1;
                CloseableReference localCloseableReference;
                FrescoInstrumenter.markFailure(this.val$token, localThrowable);
                throw localThrowable;
              }
              finally
              {
                FrescoInstrumenter.onEndWork(localObject4);
              }
            }
            try
            {
              localObject1 = BufferedDiskCache.this.readFromDiskCache(paramCacheKey);
              if (localObject1 == null)
              {
                FrescoInstrumenter.onEndWork(localObject4);
                return null;
              }
              localCloseableReference = CloseableReference.of((Closeable)localObject1);
              try
              {
                localObject1 = new EncodedImage(localCloseableReference);
                CloseableReference.closeSafely(localCloseableReference);
                if (Thread.interrupted())
                {
                  FLog.v(BufferedDiskCache.TAG, "Host thread was interrupted, decreasing reference count");
                  if (localObject1 != null) {
                    ((EncodedImage)localObject1).close();
                  }
                  throw new InterruptedException();
                }
                return (EncodedImage)localObject1;
              }
              finally
              {
                CloseableReference.closeSafely(localCloseableReference);
              }
            }
            catch (Exception localException) {}
          }
          FrescoInstrumenter.onEndWork(localObject4);
          return null;
          throw new CancellationException();
        }
      }, this.mReadExecutor);
      return paramAtomicBoolean;
    }
    catch (Exception paramAtomicBoolean)
    {
      FLog.w(TAG, paramAtomicBoolean, "Failed to schedule disk-cache read for %s", new Object[] { paramCacheKey.getUriString() });
    }
    return Task.forError(paramAtomicBoolean);
  }
  
  /* Error */
  @Nullable
  private com.facebook.common.memory.PooledByteBuffer readFromDiskCache(CacheKey paramCacheKey)
    throws IOException
  {
    // Byte code:
    //   0: getstatic 38	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   3: ldc -72
    //   5: aload_1
    //   6: invokeinterface 113 1 0
    //   11: invokestatic 119	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   14: aload_0
    //   15: getfield 45	com/facebook/imagepipeline/cache/BufferedDiskCache:mFileCache	Lcom/facebook/cache/disk/FileCache;
    //   18: aload_1
    //   19: invokeinterface 188 2 0
    //   24: astore_3
    //   25: aload_3
    //   26: ifnonnull +29 -> 55
    //   29: getstatic 38	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   32: ldc -66
    //   34: aload_1
    //   35: invokeinterface 113 1 0
    //   40: invokestatic 119	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   43: aload_0
    //   44: getfield 55	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   47: aload_1
    //   48: invokeinterface 193 2 0
    //   53: aconst_null
    //   54: areturn
    //   55: getstatic 38	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   58: ldc -61
    //   60: aload_1
    //   61: invokeinterface 113 1 0
    //   66: invokestatic 119	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   69: aload_0
    //   70: getfield 55	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   73: aload_1
    //   74: invokeinterface 198 2 0
    //   79: aload_3
    //   80: invokeinterface 204 1 0
    //   85: astore_2
    //   86: aload_0
    //   87: getfield 47	com/facebook/imagepipeline/cache/BufferedDiskCache:mPooledByteBufferFactory	Lcom/facebook/common/memory/PooledByteBufferFactory;
    //   90: aload_2
    //   91: aload_3
    //   92: invokeinterface 208 1 0
    //   97: l2i
    //   98: invokeinterface 214 3 0
    //   103: astore_3
    //   104: aload_2
    //   105: invokevirtual 217	java/io/InputStream:close	()V
    //   108: getstatic 38	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   111: ldc -37
    //   113: aload_1
    //   114: invokeinterface 113 1 0
    //   119: invokestatic 119	com/facebook/common/logging/FLog:v	(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;)V
    //   122: aload_3
    //   123: areturn
    //   124: astore_3
    //   125: aload_2
    //   126: invokevirtual 217	java/io/InputStream:close	()V
    //   129: aload_3
    //   130: athrow
    //   131: astore_2
    //   132: getstatic 38	com/facebook/imagepipeline/cache/BufferedDiskCache:TAG	Ljava/lang/Class;
    //   135: aload_2
    //   136: ldc -35
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: dup
    //   143: iconst_0
    //   144: aload_1
    //   145: invokeinterface 113 1 0
    //   150: aastore
    //   151: invokestatic 160	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   154: aload_0
    //   155: getfield 55	com/facebook/imagepipeline/cache/BufferedDiskCache:mImageCacheStatsTracker	Lcom/facebook/imagepipeline/cache/ImageCacheStatsTracker;
    //   158: aload_1
    //   159: invokeinterface 224 2 0
    //   164: aload_2
    //   165: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	this	BufferedDiskCache
    //   0	166	1	paramCacheKey	CacheKey
    //   85	41	2	localInputStream	java.io.InputStream
    //   131	34	2	localIOException	IOException
    //   24	99	3	localObject1	Object
    //   124	6	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   86	104	124	finally
    //   0	25	131	java/io/IOException
    //   29	53	131	java/io/IOException
    //   55	86	131	java/io/IOException
    //   104	122	131	java/io/IOException
    //   125	131	131	java/io/IOException
  }
  
  private void writeToDiskCache(CacheKey paramCacheKey, final EncodedImage paramEncodedImage)
  {
    FLog.v(TAG, "About to write to disk-cache for key %s", paramCacheKey.getUriString());
    try
    {
      this.mFileCache.insert(paramCacheKey, new WriterCallback()
      {
        public void write(OutputStream paramAnonymousOutputStream)
          throws IOException
        {
          BufferedDiskCache.this.mPooledByteStreams.copy(paramEncodedImage.getInputStream(), paramAnonymousOutputStream);
        }
      });
      this.mImageCacheStatsTracker.onDiskCachePut(paramCacheKey);
      FLog.v(TAG, "Successful disk-cache write for key %s", paramCacheKey.getUriString());
      return;
    }
    catch (IOException paramEncodedImage)
    {
      FLog.w(TAG, paramEncodedImage, "Failed to write to disk-cache for key %s", new Object[] { paramCacheKey.getUriString() });
    }
  }
  
  public void addKeyForAsyncProbing(CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    this.mFileCache.probe(paramCacheKey);
  }
  
  public Task<Void> clearAll()
  {
    this.mStagingArea.clearAll();
    final Object localObject = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_clearAll");
    try
    {
      localObject = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          Object localObject1 = FrescoInstrumenter.onBeginWork(localObject, null);
          try
          {
            BufferedDiskCache.this.mStagingArea.clearAll();
            BufferedDiskCache.this.mFileCache.clearAll();
            FrescoInstrumenter.onEndWork(localObject1);
            return null;
          }
          finally
          {
            try
            {
              FrescoInstrumenter.markFailure(localObject, localThrowable);
              throw localThrowable;
            }
            finally
            {
              FrescoInstrumenter.onEndWork(localObject1);
            }
          }
        }
      }, this.mWriteExecutor);
      return (Task<Void>)localObject;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache clear", new Object[0]);
      return Task.forError(localException);
    }
  }
  
  public Task<Boolean> contains(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey)) {
      return Task.forResult(Boolean.valueOf(true));
    }
    return containsAsync(paramCacheKey);
  }
  
  public boolean containsSync(CacheKey paramCacheKey)
  {
    return (this.mStagingArea.containsKey(paramCacheKey)) || (this.mFileCache.hasKeySync(paramCacheKey));
  }
  
  public boolean diskCheckSync(CacheKey paramCacheKey)
  {
    if (containsSync(paramCacheKey)) {
      return true;
    }
    return checkInStagingAreaAndFileCache(paramCacheKey);
  }
  
  public Task<EncodedImage> get(CacheKey paramCacheKey, AtomicBoolean paramAtomicBoolean)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("BufferedDiskCache#get");
      }
      EncodedImage localEncodedImage = this.mStagingArea.get(paramCacheKey);
      if (localEncodedImage != null)
      {
        paramCacheKey = foundPinnedImage(paramCacheKey, localEncodedImage);
        return paramCacheKey;
      }
      paramCacheKey = getAsync(paramCacheKey, paramAtomicBoolean);
      return paramCacheKey;
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
  
  public long getSize()
  {
    return this.mFileCache.getSize();
  }
  
  public Task<Void> probe(final CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    try
    {
      Task localTask = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          Object localObject1 = FrescoInstrumenter.onBeginWork(this.val$token, null);
          try
          {
            BufferedDiskCache.this.mFileCache.probe(paramCacheKey);
            return null;
          }
          finally
          {
            FrescoInstrumenter.onEndWork(localObject1);
          }
        }
      }, this.mWriteExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache probe for %s", new Object[] { paramCacheKey.getUriString() });
      return Task.forError(localException);
    }
  }
  
  public void put(final CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("BufferedDiskCache#put");
      }
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      this.mStagingArea.put(paramCacheKey, paramEncodedImage);
      final EncodedImage localEncodedImage = EncodedImage.cloneOrNull(paramEncodedImage);
      try
      {
        final Object localObject = FrescoInstrumenter.onBeforeSubmitWork("BufferedDiskCache_putAsync");
        this.mWriteExecutor.execute(new Runnable()
        {
          public void run()
          {
            Object localObject1 = FrescoInstrumenter.onBeginWork(localObject, null);
            try
            {
              BufferedDiskCache.this.writeToDiskCache(paramCacheKey, localEncodedImage);
              BufferedDiskCache.this.mStagingArea.remove(paramCacheKey, localEncodedImage);
              EncodedImage.closeSafely(localEncodedImage);
              FrescoInstrumenter.onEndWork(localObject1);
              return;
            }
            finally
            {
              try
              {
                FrescoInstrumenter.markFailure(localObject, localThrowable);
                throw localThrowable;
              }
              finally
              {
                BufferedDiskCache.this.mStagingArea.remove(paramCacheKey, localEncodedImage);
                EncodedImage.closeSafely(localEncodedImage);
                FrescoInstrumenter.onEndWork(localObject1);
              }
            }
          }
        });
      }
      catch (Exception localException)
      {
        FLog.w(TAG, localException, "Failed to schedule disk-cache write for %s", new Object[] { paramCacheKey.getUriString() });
        this.mStagingArea.remove(paramCacheKey, paramEncodedImage);
        EncodedImage.closeSafely(localEncodedImage);
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
  
  public Task<Void> remove(final CacheKey paramCacheKey)
  {
    Preconditions.checkNotNull(paramCacheKey);
    this.mStagingArea.remove(paramCacheKey);
    try
    {
      Task localTask = Task.call(new Callable()
      {
        public Void call()
          throws Exception
        {
          Object localObject1 = FrescoInstrumenter.onBeginWork(this.val$token, null);
          try
          {
            BufferedDiskCache.this.mStagingArea.remove(paramCacheKey);
            BufferedDiskCache.this.mFileCache.remove(paramCacheKey);
            FrescoInstrumenter.onEndWork(localObject1);
            return null;
          }
          finally
          {
            try
            {
              FrescoInstrumenter.markFailure(this.val$token, localThrowable);
              throw localThrowable;
            }
            finally
            {
              FrescoInstrumenter.onEndWork(localObject1);
            }
          }
        }
      }, this.mWriteExecutor);
      return localTask;
    }
    catch (Exception localException)
    {
      FLog.w(TAG, localException, "Failed to schedule disk-cache remove for %s", new Object[] { paramCacheKey.getUriString() });
      return Task.forError(localException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\BufferedDiskCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */