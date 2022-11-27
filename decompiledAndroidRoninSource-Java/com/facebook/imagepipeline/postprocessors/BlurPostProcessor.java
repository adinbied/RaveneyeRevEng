package com.facebook.imagepipeline.postprocessors;

import android.content.Context;
import android.graphics.Bitmap;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.common.internal.Preconditions;
import com.facebook.imagepipeline.filter.IterativeBoxBlurFilter;
import com.facebook.imagepipeline.filter.RenderScriptBlurFilter;
import com.facebook.imagepipeline.request.BasePostprocessor;
import java.util.Locale;
import javax.annotation.Nullable;

public class BlurPostProcessor
  extends BasePostprocessor
{
  private static final int DEFAULT_ITERATIONS = 3;
  private static final boolean canUseRenderScript = ;
  private final int mBlurRadius;
  private CacheKey mCacheKey;
  private final Context mContext;
  private final int mIterations;
  
  public BlurPostProcessor(int paramInt, Context paramContext)
  {
    this(paramInt, paramContext, 3);
  }
  
  public BlurPostProcessor(int paramInt1, Context paramContext, int paramInt2)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt1 > 0) && (paramInt1 <= 25)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramInt2 > 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    Preconditions.checkNotNull(paramContext);
    this.mIterations = paramInt2;
    this.mBlurRadius = paramInt1;
    this.mContext = paramContext;
  }
  
  @Nullable
  public CacheKey getPostprocessorCacheKey()
  {
    if (this.mCacheKey == null)
    {
      String str;
      if (canUseRenderScript) {
        str = String.format((Locale)null, "IntrinsicBlur;%d", new Object[] { Integer.valueOf(this.mBlurRadius) });
      } else {
        str = String.format((Locale)null, "IterativeBoxBlur;%d;%d", new Object[] { Integer.valueOf(this.mIterations), Integer.valueOf(this.mBlurRadius) });
      }
      this.mCacheKey = new SimpleCacheKey(str);
    }
    return this.mCacheKey;
  }
  
  public void process(Bitmap paramBitmap)
  {
    IterativeBoxBlurFilter.boxBlurBitmapInPlace(paramBitmap, this.mIterations, this.mBlurRadius);
  }
  
  public void process(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (canUseRenderScript)
    {
      RenderScriptBlurFilter.blurBitmap(paramBitmap1, paramBitmap2, this.mContext, this.mBlurRadius);
      return;
    }
    super.process(paramBitmap1, paramBitmap2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\postprocessors\BlurPostProcessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */