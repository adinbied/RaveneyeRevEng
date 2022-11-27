package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.memory.MemoryTrimType;

public class DummyBitmapPool
  implements BitmapPool
{
  public Bitmap get(int paramInt)
  {
    return Bitmap.createBitmap(1, (int)Math.ceil(paramInt / 2.0D), Bitmap.Config.RGB_565);
  }
  
  public void release(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    paramBitmap.recycle();
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\DummyBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */