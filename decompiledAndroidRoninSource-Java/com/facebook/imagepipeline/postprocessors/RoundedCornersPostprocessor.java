package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

public class RoundedCornersPostprocessor
  extends BasePostprocessor
{
  @Nullable
  private CacheKey mCacheKey;
  
  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null) {
      this.mCacheKey = new SimpleCacheKey("RoundedCornersPostprocessor");
    }
    return this.mCacheKey;
  }
  
  public void process(Bitmap paramBitmap)
  {
    int i = Math.min(paramBitmap.getHeight(), paramBitmap.getWidth());
    NativeRoundingFilter.addRoundedCorners(paramBitmap, i / 2, i / 3, i / 4, i / 5);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\postprocessors\RoundedCornersPostprocessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */