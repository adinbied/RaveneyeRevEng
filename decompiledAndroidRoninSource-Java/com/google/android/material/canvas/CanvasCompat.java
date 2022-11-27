package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build.VERSION;

public class CanvasCompat
{
  public static int saveLayerAlpha(Canvas paramCanvas, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return paramCanvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt);
    }
    return paramCanvas.saveLayerAlpha(paramFloat1, paramFloat2, paramFloat3, paramFloat4, paramInt, 31);
  }
  
  public static int saveLayerAlpha(Canvas paramCanvas, RectF paramRectF, int paramInt)
  {
    if (Build.VERSION.SDK_INT > 21) {
      return paramCanvas.saveLayerAlpha(paramRectF, paramInt);
    }
    return paramCanvas.saveLayerAlpha(paramRectF, paramInt, 31);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\material\canvas\CanvasCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */