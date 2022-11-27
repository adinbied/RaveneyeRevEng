package com.facebook.imagepipeline.filter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import com.facebook.common.internal.Preconditions;

public abstract class RenderScriptBlurFilter
{
  public static final int BLUR_MAX_RADIUS = 25;
  
  public static void blurBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, Context paramContext, int paramInt)
  {
    Preconditions.checkNotNull(paramBitmap1);
    Preconditions.checkNotNull(paramBitmap2);
    Preconditions.checkNotNull(paramContext);
    boolean bool;
    if ((paramInt > 0) && (paramInt <= 25)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    Context localContext = null;
    try
    {
      paramContext = RenderScript.create(paramContext);
      localContext = paramContext;
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(paramContext, Element.U8_4(paramContext));
      localContext = paramContext;
      paramBitmap2 = Allocation.createFromBitmap(paramContext, paramBitmap2);
      localContext = paramContext;
      Allocation localAllocation = Allocation.createFromBitmap(paramContext, paramBitmap1);
      localContext = paramContext;
      localScriptIntrinsicBlur.setRadius(paramInt);
      localContext = paramContext;
      localScriptIntrinsicBlur.setInput(paramBitmap2);
      localContext = paramContext;
      localScriptIntrinsicBlur.forEach(localAllocation);
      localContext = paramContext;
      localAllocation.copyTo(paramBitmap1);
      localContext = paramContext;
      localScriptIntrinsicBlur.destroy();
      localContext = paramContext;
      paramBitmap2.destroy();
      localContext = paramContext;
      localAllocation.destroy();
      return;
    }
    finally
    {
      if (localContext != null) {
        localContext.destroy();
      }
    }
  }
  
  public static boolean canUseRenderScript()
  {
    return Build.VERSION.SDK_INT >= 17;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\filter\RenderScriptBlurFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */