package com.facebook.imageutils;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.os.Build.VERSION;
import android.util.Pair;
import androidx.core.util.Pools.SynchronizedPool;
import com.facebook.common.internal.Preconditions;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

public final class BitmapUtil
{
  public static final int ALPHA_8_BYTES_PER_PIXEL = 1;
  public static final int ARGB_4444_BYTES_PER_PIXEL = 2;
  public static final int ARGB_8888_BYTES_PER_PIXEL = 4;
  private static final Pools.SynchronizedPool<ByteBuffer> DECODE_BUFFERS = new Pools.SynchronizedPool(12);
  private static final int DECODE_BUFFER_SIZE = 16384;
  public static final float MAX_BITMAP_SIZE = 2048.0F;
  private static final int POOL_SIZE = 12;
  public static final int RGBA_F16_BYTES_PER_PIXEL = 8;
  public static final int RGB_565_BYTES_PER_PIXEL = 2;
  
  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(Uri paramUri)
  {
    Preconditions.checkNotNull(paramUri);
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramUri.getPath(), localOptions);
    if ((localOptions.outWidth != -1) && (localOptions.outHeight != -1)) {
      return new Pair(Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight));
    }
    return null;
  }
  
  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream);
    ByteBuffer localByteBuffer2 = (ByteBuffer)DECODE_BUFFERS.acquire();
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocate(16384);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      localOptions.inTempStorage = localByteBuffer1.array();
      localByteBuffer2 = null;
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream = localByteBuffer2;
      if (localOptions.outWidth != -1) {
        if (localOptions.outHeight == -1) {
          paramInputStream = localByteBuffer2;
        } else {
          paramInputStream = new Pair(Integer.valueOf(localOptions.outWidth), Integer.valueOf(localOptions.outHeight));
        }
      }
      return paramInputStream;
    }
    finally
    {
      DECODE_BUFFERS.release(localByteBuffer1);
    }
  }
  
  @Nullable
  public static Pair<Integer, Integer> decodeDimensions(byte[] paramArrayOfByte)
  {
    return decodeDimensions(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public static ImageMetaData decodeDimensionsAndColorSpace(InputStream paramInputStream)
  {
    Preconditions.checkNotNull(paramInputStream);
    ByteBuffer localByteBuffer2 = (ByteBuffer)DECODE_BUFFERS.acquire();
    ByteBuffer localByteBuffer1 = localByteBuffer2;
    if (localByteBuffer2 == null) {
      localByteBuffer1 = ByteBuffer.allocate(16384);
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      localOptions.inTempStorage = localByteBuffer1.array();
      localByteBuffer2 = null;
      BitmapFactory.decodeStream(paramInputStream, null, localOptions);
      paramInputStream = localByteBuffer2;
      if (Build.VERSION.SDK_INT >= 26) {
        paramInputStream = localOptions.outColorSpace;
      }
      paramInputStream = new ImageMetaData(localOptions.outWidth, localOptions.outHeight, paramInputStream);
      return paramInputStream;
    }
    finally
    {
      DECODE_BUFFERS.release(localByteBuffer1);
    }
  }
  
  public static int getPixelSizeForBitmapConfig(Bitmap.Config paramConfig)
  {
    int i = 1.$SwitchMap$android$graphics$Bitmap$Config[paramConfig.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if ((i != 3) && (i != 4))
        {
          if (i == 5) {
            return 8;
          }
          throw new UnsupportedOperationException("The provided Bitmap.Config is not supported");
        }
        return 2;
      }
      return 1;
    }
    return 4;
  }
  
  public static int getSizeInByteForBitmap(int paramInt1, int paramInt2, Bitmap.Config paramConfig)
  {
    return paramInt1 * paramInt2 * getPixelSizeForBitmapConfig(paramConfig);
  }
  
  public static int getSizeInBytes(@Nullable Bitmap paramBitmap)
  {
    if (paramBitmap == null) {
      return 0;
    }
    if (Build.VERSION.SDK_INT > 19) {}
    try
    {
      int i = paramBitmap.getAllocationByteCount();
      return i;
    }
    catch (NullPointerException localNullPointerException)
    {
      for (;;) {}
    }
    if (Build.VERSION.SDK_INT >= 12) {
      return paramBitmap.getByteCount();
    }
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imageutils\BitmapUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */