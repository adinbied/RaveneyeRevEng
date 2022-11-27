package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.ColorSpace;
import android.graphics.Rect;
import com.facebook.common.references.CloseableReference;
import com.facebook.imagepipeline.image.EncodedImage;
import javax.annotation.Nullable;

public abstract interface PlatformDecoder
{
  public abstract CloseableReference<Bitmap> decodeFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect);
  
  public abstract CloseableReference<Bitmap> decodeFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, @Nullable ColorSpace paramColorSpace);
  
  public abstract CloseableReference<Bitmap> decodeJPEGFromEncodedImage(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt);
  
  public abstract CloseableReference<Bitmap> decodeJPEGFromEncodedImageWithColorSpace(EncodedImage paramEncodedImage, Bitmap.Config paramConfig, @Nullable Rect paramRect, int paramInt, @Nullable ColorSpace paramColorSpace);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\platform\PlatformDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */