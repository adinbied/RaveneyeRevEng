package com.facebook.drawee.backends.pipeline.info;

import com.facebook.imagepipeline.listener.BaseRequestListener;
import javax.annotation.Nullable;

public class ImageOriginRequestListener
  extends BaseRequestListener
{
  private String mControllerId;
  @Nullable
  private final ImageOriginListener mImageOriginLister;
  
  public ImageOriginRequestListener(String paramString, @Nullable ImageOriginListener paramImageOriginListener)
  {
    this.mImageOriginLister = paramImageOriginListener;
    init(paramString);
  }
  
  public void init(String paramString)
  {
    this.mControllerId = paramString;
  }
  
  public void onUltimateProducerReached(String paramString1, String paramString2, boolean paramBoolean)
  {
    paramString1 = this.mImageOriginLister;
    if (paramString1 != null) {
      paramString1.onImageLoaded(this.mControllerId, ImageOriginUtils.mapProducerNameToImageOrigin(paramString2), paramBoolean, paramString2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\ImageOriginRequestListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */