package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public class NativeBlurFilter
{
  static {}
  
  public static void iterativeBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    Preconditions.checkNotNull(paramBitmap);
    boolean bool2 = true;
    boolean bool1;
    if (paramInt1 > 0) {
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
    nativeIterativeBoxBlur(paramBitmap, paramInt1, paramInt2);
  }
  
  private static native void nativeIterativeBoxBlur(Bitmap paramBitmap, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeBlurFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */