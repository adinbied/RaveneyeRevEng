package com.facebook.drawee.debug.listener;

import android.graphics.drawable.Animatable;
import com.facebook.drawee.controller.BaseControllerListener;
import javax.annotation.Nullable;

public class ImageLoadingTimeControllerListener
  extends BaseControllerListener
{
  private long mFinalImageSetTimeMs = -1L;
  @Nullable
  private ImageLoadingTimeListener mImageLoadingTimeListener;
  private long mRequestSubmitTimeMs = -1L;
  
  public ImageLoadingTimeControllerListener(@Nullable ImageLoadingTimeListener paramImageLoadingTimeListener)
  {
    this.mImageLoadingTimeListener = paramImageLoadingTimeListener;
  }
  
  public void onFinalImageSet(String paramString, @Nullable Object paramObject, @Nullable Animatable paramAnimatable)
  {
    long l = System.currentTimeMillis();
    this.mFinalImageSetTimeMs = l;
    paramString = this.mImageLoadingTimeListener;
    if (paramString != null) {
      paramString.onFinalImageSet(l - this.mRequestSubmitTimeMs);
    }
  }
  
  public void onSubmit(String paramString, Object paramObject)
  {
    this.mRequestSubmitTimeMs = System.currentTimeMillis();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\debug\listener\ImageLoadingTimeControllerListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */