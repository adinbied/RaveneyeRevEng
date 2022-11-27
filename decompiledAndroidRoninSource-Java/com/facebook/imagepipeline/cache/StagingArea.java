package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class StagingArea
{
  private static final Class<?> TAG = StagingArea.class;
  private Map<CacheKey, EncodedImage> mMap = new HashMap();
  
  public static StagingArea getInstance()
  {
    return new StagingArea();
  }
  
  private void logStats()
  {
    try
    {
      FLog.v(TAG, "Count = %d", Integer.valueOf(this.mMap.size()));
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void clearAll()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.mMap.values());
      this.mMap.clear();
      int i = 0;
      while (i < localArrayList.size())
      {
        EncodedImage localEncodedImage = (EncodedImage)localArrayList.get(i);
        if (localEncodedImage != null) {
          localEncodedImage.close();
        }
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean containsKey(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 80	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_0
    //   8: getfield 23	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 83 2 0
    //   17: istore_2
    //   18: iload_2
    //   19: ifne +7 -> 26
    //   22: aload_0
    //   23: monitorexit
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: getfield 23	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   30: aload_1
    //   31: invokeinterface 85 2 0
    //   36: checkcast 69	com/facebook/imagepipeline/image/EncodedImage
    //   39: astore_3
    //   40: aload_3
    //   41: monitorenter
    //   42: aload_3
    //   43: invokestatic 89	com/facebook/imagepipeline/image/EncodedImage:isValid	(Lcom/facebook/imagepipeline/image/EncodedImage;)Z
    //   46: ifne +61 -> 107
    //   49: aload_0
    //   50: getfield 23	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   53: aload_1
    //   54: invokeinterface 92 2 0
    //   59: pop
    //   60: getstatic 14	com/facebook/imagepipeline/cache/StagingArea:TAG	Ljava/lang/Class;
    //   63: ldc 94
    //   65: iconst_3
    //   66: anewarray 4	java/lang/Object
    //   69: dup
    //   70: iconst_0
    //   71: aload_3
    //   72: invokestatic 100	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   75: invokestatic 41	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   78: aastore
    //   79: dup
    //   80: iconst_1
    //   81: aload_1
    //   82: invokeinterface 106 1 0
    //   87: aastore
    //   88: dup
    //   89: iconst_2
    //   90: aload_1
    //   91: invokestatic 100	java/lang/System:identityHashCode	(Ljava/lang/Object;)I
    //   94: invokestatic 41	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   97: aastore
    //   98: invokestatic 110	com/facebook/common/logging/FLog:w	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)V
    //   101: aload_3
    //   102: monitorexit
    //   103: aload_0
    //   104: monitorexit
    //   105: iconst_0
    //   106: ireturn
    //   107: aload_3
    //   108: monitorexit
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_1
    //   112: ireturn
    //   113: astore_1
    //   114: aload_3
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: monitorexit
    //   121: aload_1
    //   122: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	StagingArea
    //   0	123	1	paramCacheKey	CacheKey
    //   17	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   42	103	113	finally
    //   107	109	113	finally
    //   114	116	113	finally
    //   2	18	118	finally
    //   26	42	118	finally
    //   116	118	118	finally
  }
  
  @Nullable
  public EncodedImage get(CacheKey paramCacheKey)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      EncodedImage localEncodedImage2 = (EncodedImage)this.mMap.get(paramCacheKey);
      EncodedImage localEncodedImage1 = localEncodedImage2;
      if (localEncodedImage2 != null) {
        try
        {
          if (!EncodedImage.isValid(localEncodedImage2))
          {
            this.mMap.remove(paramCacheKey);
            FLog.w(TAG, "Found closed reference %d for key %s (%d)", new Object[] { Integer.valueOf(System.identityHashCode(localEncodedImage2)), paramCacheKey.getUriString(), Integer.valueOf(System.identityHashCode(paramCacheKey)) });
            return null;
          }
          localEncodedImage1 = EncodedImage.cloneOrNull(localEncodedImage2);
        }
        finally {}
      }
      return localEncodedImage1;
    }
    finally {}
  }
  
  public void put(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage.closeSafely((EncodedImage)this.mMap.put(paramCacheKey, EncodedImage.cloneOrNull(paramEncodedImage)));
      logStats();
      return;
    }
    finally
    {
      paramCacheKey = finally;
      throw paramCacheKey;
    }
  }
  
  /* Error */
  public boolean remove(CacheKey paramCacheKey)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 80	com/facebook/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 23	com/facebook/imagepipeline/cache/StagingArea:mMap	Ljava/util/Map;
    //   11: aload_1
    //   12: invokeinterface 92 2 0
    //   17: checkcast 69	com/facebook/imagepipeline/image/EncodedImage
    //   20: astore_1
    //   21: aload_0
    //   22: monitorexit
    //   23: aload_1
    //   24: ifnonnull +5 -> 29
    //   27: iconst_0
    //   28: ireturn
    //   29: aload_1
    //   30: invokevirtual 135	com/facebook/imagepipeline/image/EncodedImage:isValid	()Z
    //   33: istore_2
    //   34: aload_1
    //   35: invokevirtual 72	com/facebook/imagepipeline/image/EncodedImage:close	()V
    //   38: iload_2
    //   39: ireturn
    //   40: astore_3
    //   41: aload_1
    //   42: invokevirtual 72	com/facebook/imagepipeline/image/EncodedImage:close	()V
    //   45: aload_3
    //   46: athrow
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	StagingArea
    //   0	52	1	paramCacheKey	CacheKey
    //   33	6	2	bool	boolean
    //   40	6	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   29	34	40	finally
    //   7	23	47	finally
    //   48	50	47	finally
  }
  
  public boolean remove(CacheKey paramCacheKey, EncodedImage paramEncodedImage)
  {
    try
    {
      Preconditions.checkNotNull(paramCacheKey);
      Preconditions.checkNotNull(paramEncodedImage);
      Preconditions.checkArgument(EncodedImage.isValid(paramEncodedImage));
      EncodedImage localEncodedImage = (EncodedImage)this.mMap.get(paramCacheKey);
      if (localEncodedImage == null) {
        return false;
      }
      CloseableReference localCloseableReference = localEncodedImage.getByteBufferRef();
      paramEncodedImage = paramEncodedImage.getByteBufferRef();
      if ((localCloseableReference != null) && (paramEncodedImage != null)) {
        try
        {
          if (localCloseableReference.get() == paramEncodedImage.get())
          {
            this.mMap.remove(paramCacheKey);
            CloseableReference.closeSafely(paramEncodedImage);
            CloseableReference.closeSafely(localCloseableReference);
            EncodedImage.closeSafely(localEncodedImage);
            logStats();
            return true;
          }
        }
        finally
        {
          CloseableReference.closeSafely(paramEncodedImage);
          CloseableReference.closeSafely(localCloseableReference);
          EncodedImage.closeSafely(localEncodedImage);
        }
      }
      CloseableReference.closeSafely(paramEncodedImage);
      CloseableReference.closeSafely(localCloseableReference);
      EncodedImage.closeSafely(localEncodedImage);
      return false;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\StagingArea.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */