package com.facebook.imagepipeline.animated.factory;

import android.content.Context;
import android.graphics.Bitmap.Config;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import javax.annotation.Nullable;

public abstract interface AnimatedFactory
{
  @Nullable
  public abstract DrawableFactory getAnimatedDrawableFactory(Context paramContext);
  
  @Nullable
  public abstract ImageDecoder getGifDecoder(Bitmap.Config paramConfig);
  
  @Nullable
  public abstract ImageDecoder getWebPDecoder(Bitmap.Config paramConfig);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\animated\factory\AnimatedFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */