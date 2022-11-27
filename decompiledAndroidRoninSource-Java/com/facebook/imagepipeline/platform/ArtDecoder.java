package com.facebook.imagepipeline.platform;

import android.graphics.BitmapFactory.Options;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

public class ArtDecoder
  extends DefaultDecoder
{
  public ArtDecoder(BitmapPool paramBitmapPool, int paramInt, Pools.SynchronizedPool paramSynchronizedPool)
  {
    super(paramBitmapPool, paramInt, paramSynchronizedPool);
  }
  
  public int getBitmapSize(int paramInt1, int paramInt2, BitmapFactory.Options paramOptions)
  {
    return BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, paramOptions.inPreferredConfig);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\ArtDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */