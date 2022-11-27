package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import javax.annotation.Nullable;

public class DefaultCacheKeyFactory
  implements CacheKeyFactory
{
  private static DefaultCacheKeyFactory sInstance;
  
  public static DefaultCacheKeyFactory getInstance()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new DefaultCacheKeyFactory();
      }
      DefaultCacheKeyFactory localDefaultCacheKeyFactory = sInstance;
      return localDefaultCacheKeyFactory;
    }
    finally {}
  }
  
  public CacheKey getBitmapCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject)
  {
    return new BitmapMemoryCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString(), paramImageRequest.getResizeOptions(), paramImageRequest.getRotationOptions(), paramImageRequest.getImageDecodeOptions(), null, null, paramObject);
  }
  
  protected Uri getCacheKeySourceUri(Uri paramUri)
  {
    return paramUri;
  }
  
  public CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Uri paramUri, @Nullable Object paramObject)
  {
    return new SimpleCacheKey(getCacheKeySourceUri(paramUri).toString());
  }
  
  public CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject)
  {
    return getEncodedCacheKey(paramImageRequest, paramImageRequest.getSourceUri(), paramObject);
  }
  
  public CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject)
  {
    Object localObject = paramImageRequest.getPostprocessor();
    CacheKey localCacheKey;
    if (localObject != null)
    {
      localCacheKey = ((Postprocessor)localObject).getPostprocessorCacheKey();
      localObject = localObject.getClass().getName();
    }
    else
    {
      localCacheKey = null;
      localObject = localCacheKey;
    }
    return new BitmapMemoryCacheKey(getCacheKeySourceUri(paramImageRequest.getSourceUri()).toString(), paramImageRequest.getResizeOptions(), paramImageRequest.getRotationOptions(), paramImageRequest.getImageDecodeOptions(), localCacheKey, (String)localObject, paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\DefaultCacheKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */