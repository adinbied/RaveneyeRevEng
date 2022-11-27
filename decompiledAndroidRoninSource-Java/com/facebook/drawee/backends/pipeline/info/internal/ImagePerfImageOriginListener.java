package com.facebook.drawee.backends.pipeline.info.internal;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import com.facebook.drawee.backends.pipeline.info.ImagePerfMonitor;
import com.facebook.drawee.backends.pipeline.info.ImagePerfState;

public class ImagePerfImageOriginListener
  implements ImageOriginListener
{
  private final ImagePerfMonitor mImagePerfMonitor;
  private final ImagePerfState mImagePerfState;
  
  public ImagePerfImageOriginListener(ImagePerfState paramImagePerfState, ImagePerfMonitor paramImagePerfMonitor)
  {
    this.mImagePerfState = paramImagePerfState;
    this.mImagePerfMonitor = paramImagePerfMonitor;
  }
  
  public void onImageLoaded(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    this.mImagePerfState.setImageOrigin(paramInt);
    this.mImagePerfState.setUltimateProducerName(paramString2);
    this.mImagePerfMonitor.notifyStatusUpdated(this.mImagePerfState, 1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\info\internal\ImagePerfImageOriginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */