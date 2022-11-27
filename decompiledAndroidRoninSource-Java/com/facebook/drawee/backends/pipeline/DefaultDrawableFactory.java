package com.facebook.drawee.backends.pipeline;

import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.OrientedDrawable;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.CloseableStaticBitmap;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import javax.annotation.Nullable;

public class DefaultDrawableFactory
  implements DrawableFactory
{
  @Nullable
  private final DrawableFactory mAnimatedDrawableFactory;
  private final Resources mResources;
  
  public DefaultDrawableFactory(Resources paramResources, @Nullable DrawableFactory paramDrawableFactory)
  {
    this.mResources = paramResources;
    this.mAnimatedDrawableFactory = paramDrawableFactory;
  }
  
  private static boolean hasTransformableExifOrientation(CloseableStaticBitmap paramCloseableStaticBitmap)
  {
    return (paramCloseableStaticBitmap.getExifOrientation() != 1) && (paramCloseableStaticBitmap.getExifOrientation() != 0);
  }
  
  private static boolean hasTransformableRotationAngle(CloseableStaticBitmap paramCloseableStaticBitmap)
  {
    return (paramCloseableStaticBitmap.getRotationAngle() != 0) && (paramCloseableStaticBitmap.getRotationAngle() != -1);
  }
  
  @Nullable
  public Drawable createDrawable(CloseableImage paramCloseableImage)
  {
    try
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.beginSection("DefaultDrawableFactory#createDrawable");
      }
      if ((paramCloseableImage instanceof CloseableStaticBitmap))
      {
        paramCloseableImage = (CloseableStaticBitmap)paramCloseableImage;
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(this.mResources, paramCloseableImage.getUnderlyingBitmap());
        if (!hasTransformableRotationAngle(paramCloseableImage))
        {
          boolean bool = hasTransformableExifOrientation(paramCloseableImage);
          if (!bool) {
            return localBitmapDrawable;
          }
        }
        paramCloseableImage = new OrientedDrawable(localBitmapDrawable, paramCloseableImage.getRotationAngle(), paramCloseableImage.getExifOrientation());
        return paramCloseableImage;
      }
      if ((this.mAnimatedDrawableFactory != null) && (this.mAnimatedDrawableFactory.supportsImageType(paramCloseableImage)))
      {
        paramCloseableImage = this.mAnimatedDrawableFactory.createDrawable(paramCloseableImage);
        return paramCloseableImage;
      }
      return null;
    }
    finally
    {
      if (FrescoSystrace.isTracing()) {
        FrescoSystrace.endSection();
      }
    }
  }
  
  public boolean supportsImageType(CloseableImage paramCloseableImage)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\DefaultDrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */