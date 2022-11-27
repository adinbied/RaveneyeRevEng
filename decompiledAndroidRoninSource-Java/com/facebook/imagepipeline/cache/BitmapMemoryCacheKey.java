package com.facebook.imagepipeline.cache;

import android.net.Uri;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.time.RealtimeSinceBootClock;
import com.facebook.common.util.HashCodeUtil;
import com.facebook.imagepipeline.common.ImageDecodeOptions;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.common.RotationOptions;
import java.util.Locale;
import javax.annotation.Nullable;

public class BitmapMemoryCacheKey
  implements CacheKey
{
  private final long mCacheTime;
  private final Object mCallerContext;
  private final int mHash;
  private final ImageDecodeOptions mImageDecodeOptions;
  @Nullable
  private final CacheKey mPostprocessorCacheKey;
  @Nullable
  private final String mPostprocessorName;
  @Nullable
  private final ResizeOptions mResizeOptions;
  private final RotationOptions mRotationOptions;
  private final String mSourceString;
  
  public BitmapMemoryCacheKey(String paramString1, @Nullable ResizeOptions paramResizeOptions, RotationOptions paramRotationOptions, ImageDecodeOptions paramImageDecodeOptions, @Nullable CacheKey paramCacheKey, @Nullable String paramString2, Object paramObject)
  {
    this.mSourceString = ((String)Preconditions.checkNotNull(paramString1));
    this.mResizeOptions = paramResizeOptions;
    this.mRotationOptions = paramRotationOptions;
    this.mImageDecodeOptions = paramImageDecodeOptions;
    this.mPostprocessorCacheKey = paramCacheKey;
    this.mPostprocessorName = paramString2;
    int j = paramString1.hashCode();
    int i;
    if (paramResizeOptions != null) {
      i = paramResizeOptions.hashCode();
    } else {
      i = 0;
    }
    this.mHash = HashCodeUtil.hashCode(Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(paramRotationOptions.hashCode()), this.mImageDecodeOptions, this.mPostprocessorCacheKey, paramString2);
    this.mCallerContext = paramObject;
    this.mCacheTime = RealtimeSinceBootClock.get().now();
  }
  
  public boolean containsUri(Uri paramUri)
  {
    return getUriString().contains(paramUri.toString());
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof BitmapMemoryCacheKey;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (BitmapMemoryCacheKey)paramObject;
    bool1 = bool2;
    if (this.mHash == ((BitmapMemoryCacheKey)paramObject).mHash)
    {
      bool1 = bool2;
      if (this.mSourceString.equals(((BitmapMemoryCacheKey)paramObject).mSourceString))
      {
        bool1 = bool2;
        if (Objects.equal(this.mResizeOptions, ((BitmapMemoryCacheKey)paramObject).mResizeOptions))
        {
          bool1 = bool2;
          if (Objects.equal(this.mRotationOptions, ((BitmapMemoryCacheKey)paramObject).mRotationOptions))
          {
            bool1 = bool2;
            if (Objects.equal(this.mImageDecodeOptions, ((BitmapMemoryCacheKey)paramObject).mImageDecodeOptions))
            {
              bool1 = bool2;
              if (Objects.equal(this.mPostprocessorCacheKey, ((BitmapMemoryCacheKey)paramObject).mPostprocessorCacheKey))
              {
                bool1 = bool2;
                if (Objects.equal(this.mPostprocessorName, ((BitmapMemoryCacheKey)paramObject).mPostprocessorName)) {
                  bool1 = true;
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public Object getCallerContext()
  {
    return this.mCallerContext;
  }
  
  public long getInBitmapCacheSince()
  {
    return this.mCacheTime;
  }
  
  @Nullable
  public String getPostprocessorName()
  {
    return this.mPostprocessorName;
  }
  
  public String getUriString()
  {
    return this.mSourceString;
  }
  
  public int hashCode()
  {
    return this.mHash;
  }
  
  public boolean isResourceIdForDebugging()
  {
    return false;
  }
  
  public String toString()
  {
    return String.format((Locale)null, "%s_%s_%s_%s_%s_%s_%d", new Object[] { this.mSourceString, this.mResizeOptions, this.mRotationOptions, this.mImageDecodeOptions, this.mPostprocessorCacheKey, this.mPostprocessorName, Integer.valueOf(this.mHash) });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\cache\BitmapMemoryCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */