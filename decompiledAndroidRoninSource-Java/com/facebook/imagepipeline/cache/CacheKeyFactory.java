package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.request.ImageRequest;
import javax.annotation.Nullable;

public abstract interface CacheKeyFactory
{
  public abstract CacheKey getBitmapCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject);
  
  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, Uri paramUri, @Nullable Object paramObject);
  
  public abstract CacheKey getEncodedCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject);
  
  public abstract CacheKey getPostprocessedBitmapCacheKey(ImageRequest paramImageRequest, @Nullable Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\CacheKeyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */