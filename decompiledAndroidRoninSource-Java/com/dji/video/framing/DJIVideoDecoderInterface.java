package com.dji.video.framing;

import android.content.Context;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder;
import com.dji.video.framing.internal.decoder.DJIVideoDecoder.VideoDecoderEventListener;
import com.dji.video.framing.internal.decoder.decoderinterface.IReceiveDataCallback;
import com.dji.video.framing.internal.opengl.surface.SurfaceInterface;
import com.dji.video.framing.internal.parser.VideoStreamParseController;

public abstract interface DJIVideoDecoderInterface
{
  public abstract Context getContext();
  
  public abstract DJIVideoDecoder getDJIVideoDecoder();
  
  public abstract VideoStreamParseController getParseController();
  
  public abstract void initDJIVideoDecoder(Context paramContext, SurfaceInterface paramSurfaceInterface);
  
  public abstract void initDJIVideoDecoder(Context paramContext, boolean paramBoolean, SurfaceInterface paramSurfaceInterface);
  
  public abstract void postStartDecodeEvent();
  
  public abstract void release();
  
  public abstract void setPause(boolean paramBoolean);
  
  public abstract void setReceiverDataCallback(IReceiveDataCallback paramIReceiveDataCallback);
  
  public abstract void setRecordingCacheSizeLimit(int paramInt);
  
  public abstract void setSurface(SurfaceInterface paramSurfaceInterface);
  
  public abstract void setVideoDecoderEventListener(DJIVideoDecoder.VideoDecoderEventListener paramVideoDecoderEventListener);
  
  public abstract void setVideoRecordFilSavedListener(VideoRecordFilSavedListener paramVideoRecordFilSavedListener);
  
  public abstract void startVideoRecording(String paramString);
  
  public abstract void stopVideoRecording();
  
  public static abstract interface IVideoRecordInfo {}
  
  public static abstract interface VideoRecordFilSavedListener
  {
    public abstract void onRecordingFileError(int paramInt);
    
    public abstract void onRecordingFileSaved(DJIVideoDecoderInterface.IVideoRecordInfo paramIVideoRecordInfo);
    
    public abstract void onRecordingFileStart(DJIVideoDecoderInterface.IVideoRecordInfo paramIVideoRecordInfo);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\DJIVideoDecoderInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */