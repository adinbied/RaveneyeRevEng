package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;

public class DebugOverlayImageOriginListener
  implements ImageOriginListener
{
  private int mImageOrigin = 1;
  
  public int getImageOrigin()
  {
    return this.mImageOrigin;
  }
  
  public void onImageLoaded(String paramString1, int paramInt, boolean paramBoolean, String paramString2)
  {
    this.mImageOrigin = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\drawee\backends\pipeline\debug\DebugOverlayImageOriginListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */