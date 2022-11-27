package com.facebook.imagepipeline.drawable;

import android.graphics.drawable.Drawable;
import com.facebook.imagepipeline.image.CloseableImage;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract interface DrawableFactory
{
  @Nullable
  public abstract Drawable createDrawable(@Nonnull CloseableImage paramCloseableImage);
  
  public abstract boolean supportsImageType(@Nonnull CloseableImage paramCloseableImage);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\drawable\DrawableFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */