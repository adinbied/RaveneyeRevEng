package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;

public class Bitmaps
{
  static {}
  
  public static void copyBitmap(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    Bitmap.Config localConfig1 = paramBitmap2.getConfig();
    Bitmap.Config localConfig2 = paramBitmap1.getConfig();
    boolean bool2 = true;
    boolean bool1;
    if (localConfig1 == localConfig2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    Preconditions.checkArgument(paramBitmap1.isMutable());
    if (paramBitmap1.getWidth() == paramBitmap2.getWidth()) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    if (paramBitmap1.getHeight() == paramBitmap2.getHeight()) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    Preconditions.checkArgument(bool1);
    nativeCopyBitmap(paramBitmap1, paramBitmap1.getRowBytes(), paramBitmap2, paramBitmap2.getRowBytes(), paramBitmap1.getHeight());
  }
  
  private static native void nativeCopyBitmap(Bitmap paramBitmap1, int paramInt1, Bitmap paramBitmap2, int paramInt2, int paramInt3);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\Bitmaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */