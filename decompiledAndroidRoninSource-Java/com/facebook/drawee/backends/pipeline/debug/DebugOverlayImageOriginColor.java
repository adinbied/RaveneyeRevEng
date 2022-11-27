package com.facebook.drawee.backends.pipeline.debug;

import android.util.SparseIntArray;

public class DebugOverlayImageOriginColor
{
  private static final SparseIntArray IMAGE_ORIGIN_COLOR_MAP;
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray(7);
    IMAGE_ORIGIN_COLOR_MAP = localSparseIntArray;
    localSparseIntArray.append(1, -7829368);
    IMAGE_ORIGIN_COLOR_MAP.append(2, -65536);
    IMAGE_ORIGIN_COLOR_MAP.append(3, 65280);
    IMAGE_ORIGIN_COLOR_MAP.append(4, 65280);
    IMAGE_ORIGIN_COLOR_MAP.append(5, -16711936);
    IMAGE_ORIGIN_COLOR_MAP.append(6, -16711936);
    IMAGE_ORIGIN_COLOR_MAP.append(7, -16711936);
  }
  
  public static int getImageOriginColor(int paramInt)
  {
    return IMAGE_ORIGIN_COLOR_MAP.get(paramInt, -1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\debug\DebugOverlayImageOriginColor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */