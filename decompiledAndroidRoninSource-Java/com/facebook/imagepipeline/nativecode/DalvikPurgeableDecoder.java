package com.facebook.imagepipeline.nativecode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import android.graphics.Rect;
import android.os.Build.VERSION;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Throwables;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.common.TooManyBitmapsException;
import com.facebook.imagepipeline.image.EncodedImage;
import com.facebook.imagepipeline.memory.BitmapCounter;
import com.facebook.imagepipeline.memory.BitmapCounterProvider;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imageutils.BitmapUtil;
import java.util.Locale;
import javax.annotation.Nullable;

public abstract class DalvikPurgeableDecoder
  implements PlatformDecoder
{
  protected static final byte[] EOI = { -1, -39 };
  private final BitmapCounter mUnpooledBitmapsCounter = BitmapCounterProvider.get();
  
  static {}
  
  public static boolean endsWithEOI(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt)
  {
    paramCloseableReference = (PooledByteBuffer)paramCloseableReference.get();
    return (paramInt >= 2) && (paramCloseableReference.read(paramInt - 2) == -1) && (paramCloseableReference.read(paramInt - 1) == -39);
  }
  
  public static BitmapFactory.Options getBitmapFactoryOptions(int paramInt, Bitmap.Config paramConfig)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inDither = true;
    localOptions.inPreferredConfig = paramConfig;
    localOptions.inPurgeable = true;
    localOptions.inInputShareable = true;
    localOptions.inSampleSize = paramInt;
    if (Build.VERSION.SDK_INT >= 11) {
      localOptions.inMutable = true;
    }
    return localOptions;
  }
  
  private static native void nativePinBitmap(Bitmap paramBitmap);
  
  protected abstract Bitmap decodeByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, BitmapFactory.Options paramOptions);
  
  public CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect)
  {
    return decodeFromEncodedImageWithColorSpace(paramEncodedImage, paramConfig, paramRect, null);
  }
  
  public CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, @Nullable ColorSpace paramColorSpace)
  {
    paramConfig = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    if (Build.VERSION.SDK_INT >= 26) {
      OreoUtils.setColorSpace(paramConfig, paramColorSpace);
    }
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      paramConfig = pinBitmap(decodeByteArrayAsPurgeable(paramEncodedImage, paramConfig));
      return paramConfig;
    }
    finally
    {
      CloseableReference.closeSafely(paramEncodedImage);
    }
  }
  
  protected abstract Bitmap decodeJPEGByteArrayAsPurgeable(CloseableReference<PooledByteBuffer> paramCloseableReference, int paramInt, BitmapFactory.Options paramOptions);
  
  public CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt)
  {
    return decodeJPEGFromEncodedImageWithColorSpace(paramEncodedImage, paramConfig, paramRect, paramInt, null);
  }
  
  public CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt, @Nullable ColorSpace paramColorSpace)
  {
    paramConfig = getBitmapFactoryOptions(paramEncodedImage.getSampleSize(), paramConfig);
    if (Build.VERSION.SDK_INT >= 26) {
      OreoUtils.setColorSpace(paramConfig, paramColorSpace);
    }
    paramEncodedImage = paramEncodedImage.getByteBufferRef();
    Preconditions.checkNotNull(paramEncodedImage);
    try
    {
      paramConfig = pinBitmap(decodeJPEGByteArrayAsPurgeable(paramEncodedImage, paramInt, paramConfig));
      return paramConfig;
    }
    finally
    {
      CloseableReference.closeSafely(paramEncodedImage);
    }
  }
  
  public CloseableReference<Bitmap> pinBitmap(Bitmap paramBitmap)
  {
    Preconditions.checkNotNull(paramBitmap);
    try
    {
      nativePinBitmap(paramBitmap);
      if (this.mUnpooledBitmapsCounter.increase(paramBitmap)) {
        return CloseableReference.of(paramBitmap, this.mUnpooledBitmapsCounter.getReleaser());
      }
      int i = BitmapUtil.getSizeInBytes(paramBitmap);
      paramBitmap.recycle();
      throw new TooManyBitmapsException(String.format(Locale.US, "Attempted to pin a bitmap of size %d bytes. The current pool count is %d, the current pool size is %d bytes. The current pool max count is %d, the current pool max size is %d bytes.", new Object[] { Integer.valueOf(i), Integer.valueOf(this.mUnpooledBitmapsCounter.getCount()), Long.valueOf(this.mUnpooledBitmapsCounter.getSize()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxCount()), Integer.valueOf(this.mUnpooledBitmapsCounter.getMaxSize()) }));
    }
    catch (Exception localException)
    {
      paramBitmap.recycle();
      throw Throwables.propagate(localException);
    }
  }
  
  private static class OreoUtils
  {
    static void setColorSpace(BitmapFactory.Options paramOptions, @Nullable ColorSpace paramColorSpace)
    {
      ColorSpace localColorSpace = paramColorSpace;
      if (paramColorSpace == null) {
        localColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
      }
      paramOptions.inPreferredColorSpace = localColorSpace;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\nativecode\DalvikPurgeableDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */