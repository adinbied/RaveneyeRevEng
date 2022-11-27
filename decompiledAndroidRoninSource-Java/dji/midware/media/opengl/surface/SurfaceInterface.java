package dji.midware.media.opengl.surface;

import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.view.Surface;
import dji.midware.media.DJIVideoDecoder;
import dji.midware.media.transcode.online.DecoderListener;

public abstract interface SurfaceInterface
  extends SurfaceTexture.OnFrameAvailableListener
{
  public abstract void destroy();
  
  public abstract void enableOverExposureWarning(boolean paramBoolean, int paramInt);
  
  public abstract void getBitmap(int paramInt1, int paramInt2, GLYUVSurface.BitmapCallback paramBitmapCallback);
  
  public abstract Surface getInputSurface();
  
  public abstract long getLastExtraDrawTime(String paramString);
  
  public abstract boolean getPeakFocusEnable();
  
  public abstract float getPeakFocusThreshold();
  
  public abstract byte[] getRgbaData(int paramInt1, int paramInt2);
  
  public abstract int getSecondaryOutputInterval(String paramString);
  
  public abstract void init(Object paramObject, int paramInt1, int paramInt2);
  
  public abstract void init(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void init(Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void reSizeSurface(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void resetSurface(Object paramObject);
  
  public abstract void resizeSurface(int paramInt1, int paramInt2);
  
  public abstract void setPeakFocusEnable(boolean paramBoolean);
  
  public abstract void setPeakFocusThreshold(float paramFloat);
  
  public abstract void setSecondaryOutputInterval(String paramString, int paramInt);
  
  public abstract void setSecondaryOutputSurface(String paramString, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract void setVideoDataListener(DecoderListener paramDecoderListener);
  
  public abstract void setVideoDecoder(DJIVideoDecoder paramDJIVideoDecoder);
  
  public abstract void setYUVScale(float paramFloat);
  
  public abstract void toGray();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\opengl\surface\SurfaceInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */