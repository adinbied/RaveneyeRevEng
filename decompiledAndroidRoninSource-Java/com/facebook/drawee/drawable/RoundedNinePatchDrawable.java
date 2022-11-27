package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.drawable.NinePatchDrawable;
import com.facebook.imagepipeline.systrace.FrescoSystrace;

public class RoundedNinePatchDrawable
  extends RoundedDrawable
{
  public RoundedNinePatchDrawable(NinePatchDrawable paramNinePatchDrawable)
  {
    super(paramNinePatchDrawable);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.beginSection("RoundedNinePatchDrawable#draw");
    }
    if (!shouldRound())
    {
      super.draw(paramCanvas);
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
      return;
    }
    updateTransform();
    updatePath();
    paramCanvas.clipPath(this.mPath);
    super.draw(paramCanvas);
    if (FrescoSystrace.isTracing()) {
      FrescoSystrace.endSection();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\drawable\RoundedNinePatchDrawable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */