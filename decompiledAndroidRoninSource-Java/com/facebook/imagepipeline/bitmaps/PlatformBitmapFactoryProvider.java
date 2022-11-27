package com.facebook.imagepipeline.bitmaps;

import android.os.Build.VERSION;
import com.facebook.imagepipeline.core.CloseableReferenceFactory;
import com.facebook.imagepipeline.memory.PoolFactory;
import com.facebook.imagepipeline.platform.PlatformDecoder;

public class PlatformBitmapFactoryProvider
{
  public static PlatformBitmapFactory buildPlatformBitmapFactory(PoolFactory paramPoolFactory, PlatformDecoder paramPlatformDecoder, CloseableReferenceFactory paramCloseableReferenceFactory)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new ArtBitmapFactory(paramPoolFactory.getBitmapPool(), paramCloseableReferenceFactory);
    }
    if (Build.VERSION.SDK_INT >= 11) {
      return new HoneycombBitmapFactory(new EmptyJpegGenerator(paramPoolFactory.getPooledByteBufferFactory()), paramPlatformDecoder, paramCloseableReferenceFactory);
    }
    return new GingerbreadBitmapFactory();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\bitmaps\PlatformBitmapFactoryProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */