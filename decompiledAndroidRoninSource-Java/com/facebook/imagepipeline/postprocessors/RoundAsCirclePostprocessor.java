package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.imagepipeline.nativecode.NativeRoundingFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

public class RoundAsCirclePostprocessor
  extends BasePostprocessor
{
  private static final boolean ENABLE_ANTI_ALIASING = true;
  @Nullable
  private CacheKey mCacheKey;
  private final boolean mEnableAntiAliasing;
  
  public RoundAsCirclePostprocessor()
  {
    this(true);
  }
  
  public RoundAsCirclePostprocessor(boolean paramBoolean)
  {
    this.mEnableAntiAliasing = paramBoolean;
  }
  
  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null) {
      if (this.mEnableAntiAliasing) {
        this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor#AntiAliased");
      } else {
        this.mCacheKey = new SimpleCacheKey("RoundAsCirclePostprocessor");
      }
    }
    return this.mCacheKey;
  }
  
  public void process(Bitmap paramBitmap)
  {
    NativeRoundingFilter.toCircleFast(paramBitmap, this.mEnableAntiAliasing);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\postprocessors\RoundAsCirclePostprocessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */