package com.facebook.imagepipeline.filter;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;

public final class XferRoundFilter
{
  public static boolean canUseXferRoundFilter()
  {
    return Build.VERSION.SDK_INT >= 12;
  }
  
  public static void xferRoundBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramBitmap2);
    Preconditions.checkNotNull(paramBitmap1);
    paramBitmap1.setHasAlpha(true);
    Paint localPaint2;
    Paint localPaint1;
    if (paramBoolean)
    {
      localPaint2 = new Paint(1);
      localPaint1 = new Paint(1);
    }
    else
    {
      localPaint2 = new Paint();
      localPaint1 = new Paint();
    }
    localPaint2.setColor(-16777216);
    localPaint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
    paramBitmap1 = new Canvas(paramBitmap1);
    float f1 = paramBitmap2.getWidth() / 2.0F;
    float f2 = paramBitmap2.getHeight() / 2.0F;
    paramBitmap1.drawCircle(f1, f2, Math.min(f1, f2), localPaint2);
    paramBitmap1.drawBitmap(paramBitmap2, 0.0F, 0.0F, localPaint1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\filter\XferRoundFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */