package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import com.facebook.common.internal.Preconditions;

public class NativeRoundingFilter
{
  static {}
  
  public static void addRoundedCorners(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    nativeAddRoundedCornersFilter(paramBitmap, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  private static native void nativeAddRoundedCornersFilter(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  private static native void nativeToCircleFastFilter(Bitmap paramBitmap, boolean paramBoolean);
  
  private static native void nativeToCircleFilter(Bitmap paramBitmap, boolean paramBoolean);
  
  private static native void nativeToCircleWithBorderFilter(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean);
  
  public static void toCircle(Bitmap paramBitmap)
  {
    toCircle(paramBitmap, false);
  }
  
  public static void toCircle(Bitmap paramBitmap, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativeToCircleFilter(paramBitmap, paramBoolean);
  }
  
  public static void toCircleFast(Bitmap paramBitmap)
  {
    toCircleFast(paramBitmap, false);
  }
  
  public static void toCircleFast(Bitmap paramBitmap, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativeToCircleFastFilter(paramBitmap, paramBoolean);
  }
  
  public static void toCircleWithBorder(Bitmap paramBitmap, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramBitmap);
    nativeToCircleWithBorderFilter(paramBitmap, paramInt1, paramInt2, paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\NativeRoundingFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */