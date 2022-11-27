package com.dji.video.framing.internal.opengl.surface;

import android.graphics.Bitmap;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import com.dji.video.framing.internal.decoder.common.FrameFovType;
import com.dji.video.framing.internal.decoder.decoderinterface.IDJIVideoDecoder;
import com.dji.video.framing.internal.opengl.renderer.GLMonoChromeRender.Filter;

public abstract interface SurfaceInterface
  extends SurfaceTexture.OnFrameAvailableListener
{
  public abstract void destroy();
  
  public abstract void enableLutRender(boolean paramBoolean);
  
  public abstract void enableMonoChromeRender(boolean paramBoolean);
  
  public abstract void enableOverExposureWarning(boolean paramBoolean, int paramInt);
  
  public abstract void enablePseudoRender(boolean paramBoolean);
  
  public abstract void getBitmap(int paramInt1, int paramInt2, BitmapCallback paramBitmapCallback);
  
  public abstract int getExtraAsyncRenderInterval(String paramString);
  
  public abstract Surface getInputSurface();
  
  public abstract long getLastExtraDrawTime(String paramString);
  
  public abstract boolean getPeakFocusEnable();
  
  public abstract float getPeakFocusThreshold();
  
  public abstract byte[] getRgbaData(int paramInt1, int paramInt2);
  
  public abstract int getSecondaryOutputInterval(String paramString);
  
  public abstract byte[] getYuvData(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void init(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void init(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void init(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void reSizeSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void resetSurface(Object paramObject);
  
  public abstract void resizeSurface(int paramInt1, int paramInt2);
  
  public abstract void setDistortion(boolean paramBoolean);
  
  public abstract void setExtraAsyncRenderInterval(String paramString, int paramInt);
  
  public abstract boolean setExtraAsyncRenderSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void setLutBmp(Bitmap paramBitmap);
  
  public abstract void setMonoChromeRender(GLMonoChromeRender.Filter paramFilter);
  
  public abstract void setPeakFocusEnable(boolean paramBoolean);
  
  public abstract void setPeakFocusThreshold(float paramFloat);
  
  public abstract void setSecondaryOutputInterval(String paramString, int paramInt);
  
  public abstract void setSecondaryOutputSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setVideoDecoder(IDJIVideoDecoder paramIDJIVideoDecoder);
  
  public abstract void setYUVScale(float paramFloat);
  
  public abstract void toBlack();
  
  public abstract void toGray();
  
  public abstract void updateFrameInfo(int paramInt1, int paramInt2, int paramInt3, FrameFovType paramFrameFovType);
  
  public static abstract interface BitmapCallback
  {
    public abstract void onResult(Bitmap paramBitmap);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\opengl\surface\SurfaceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */