package com.facebook.imagepipeline.memory;

import android.graphics.Bitmap;
import com.facebook.common.logging.FLog;
import com.facebook.imageutils.BitmapUtil;
import javax.annotation.Nullable;

public class BitmapPoolBackend
  extends LruBucketsPoolBackend<Bitmap>
{
  private static final String TAG = "BitmapPoolBackend";
  
  @Nullable
  public Bitmap get(int paramInt)
  {
    Bitmap localBitmap = (Bitmap)super.get(paramInt);
    if ((localBitmap != null) && (isReusable(localBitmap)))
    {
      localBitmap.eraseColor(0);
      return localBitmap;
    }
    return null;
  }
  
  public int getSize(Bitmap paramBitmap)
  {
    return BitmapUtil.getSizeInBytes(paramBitmap);
  }
  
  protected boolean isReusable(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return false;
    }
    if (paramBitmap.isRecycled())
    {
      FLog.wtf("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", new Object[] { paramBitmap });
      return false;
    }
    if (!paramBitmap.isMutable())
    {
      FLog.wtf("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", new Object[] { paramBitmap });
      return false;
    }
    return true;
  }
  
  public void put(Bitmap paramBitmap)
  {
    if (isReusable(paramBitmap)) {
      super.put(paramBitmap);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\memory\BitmapPoolBackend.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */