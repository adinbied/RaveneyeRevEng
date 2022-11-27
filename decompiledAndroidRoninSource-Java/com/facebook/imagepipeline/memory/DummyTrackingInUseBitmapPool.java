package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Sets;
import com.facebook.common.memory.MemoryTrimType;
import java.util.Set;

public class DummyTrackingInUseBitmapPool
  implements BitmapPool
{
  private final Set<Bitmap> mInUseValues = Sets.newIdentityHashSet();
  
  public Bitmap get(int paramInt)
  {
    Bitmap localBitmap = Bitmap.createBitmap(1, (int)Math.ceil(paramInt / 2.0D), Bitmap.Config.RGB_565);
    this.mInUseValues.add(localBitmap);
    return localBitmap;
  }
  
  public void release(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    this.mInUseValues.remove(paramBitmap);
    paramBitmap.recycle();
  }
  
  public void trim(MemoryTrimType paramMemoryTrimType) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\DummyTrackingInUseBitmapPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */