package com.facebook.imagepipeline.bitmaps;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.BitmapPool;
import com.facebook.imageutils.BitmapUtil;

public class ArtBitmapFactory
  extends PlatformBitmapFactory
{
  private final BitmapPool mBitmapPool;
  private final CloseableReferenceFactory mCloseableReferenceFactory;
  
  public ArtBitmapFactory(BitmapPool paramBitmapPool, CloseableReferenceFactory paramCloseableReferenceFactory)
  {
    this.mBitmapPool = paramBitmapPool;
    this.mCloseableReferenceFactory = paramCloseableReferenceFactory;
  }
  
  public CloseableReference<Bitmap> createBitmapInternal(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    int i = BitmapUtil.getSizeInByteForBitmap(paramInt1, paramInt2, paramConfig);
    Bitmap localBitmap = (Bitmap)this.mBitmapPool.get(i);
    boolean bool;
    if (localBitmap.getAllocationByteCount() >= paramInt1 * paramInt2 * BitmapUtil.getPixelSizeForBitmapConfig(paramConfig)) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool);
    localBitmap.reconfigure(paramInt1, paramInt2, paramConfig);
    return this.mCloseableReferenceFactory.create(localBitmap, this.mBitmapPool);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\ArtBitmapFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */