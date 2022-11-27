package com.facebook.imagepipeline.postprocessors;

import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.InPlaceRoundFilter;
import com.facebook.imagepipeline.filter.XferRoundFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import javax.annotation.Nullable;

public class RoundPostprocessor
  extends BasePostprocessor
{
  private static final boolean ENABLE_ANTI_ALIASING = true;
  private static final boolean canUseXferRoundFilter = ;
  @Nullable
  private CacheKey mCacheKey;
  private final boolean mEnableAntiAliasing;
  
  public RoundPostprocessor()
  {
    this(true);
  }
  
  public RoundPostprocessor(boolean paramBoolean)
  {
    this.mEnableAntiAliasing = paramBoolean;
  }
  
  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null) {
      if (canUseXferRoundFilter) {
        this.mCacheKey = new SimpleCacheKey("XferRoundFilter");
      } else {
        this.mCacheKey = new SimpleCacheKey("InPlaceRoundFilter");
      }
    }
    return this.mCacheKey;
  }
  
  public void process(Bitmap paramBitmap)
  {
    InPlaceRoundFilter.roundBitmapInPlace(paramBitmap);
  }
  
  public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    Preconditions.checkNotNull(paramBitmap1);
    Preconditions.checkNotNull(paramBitmap2);
    if (canUseXferRoundFilter)
    {
      XferRoundFilter.xferRoundBitmap(paramBitmap1, paramBitmap2, this.mEnableAntiAliasing);
      return;
    }
    super.process(paramBitmap1, paramBitmap2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\postprocessors\RoundPostprocessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */