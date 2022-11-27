package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

public class OreoDecoder
  extends DefaultDecoder
{
  public OreoDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    super(paramBitmapPool, paramInt, paramSynchronizedPool);
  }
  
  private static boolean hasColorGamutMismatch(BitmapFactory.Options paramOptions)
  {
    return (paramOptions.outColorSpace != null) && (paramOptions.outColorSpace.isWideGamut()) && (paramOptions.inPreferredConfig != Bitmap.Config.RGBA_F16);
  }
  
  public int getBitmapSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    if (hasColorGamutMismatch(paramOptions)) {
      return paramInt1 * paramInt2 * 8;
    }
    return BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, paramOptions.inPreferredConfig);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\OreoDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */