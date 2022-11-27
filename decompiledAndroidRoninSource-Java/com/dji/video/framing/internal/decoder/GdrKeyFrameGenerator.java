package com.dji.video.framing.internal.decoder;

import android.content.Context;
import com.dji.video.framing.internal.VideoFrame;
import com.dji.video.framing.internal.decoder.decoderinterface.IBlackKeyFrameGenerator;

public class GdrKeyFrameGenerator
  implements IBlackKeyFrameGenerator
{
  private static final String TAG = "GdrKeyFrameGenerator";
  private Context mContext;
  private KeyFrameResCallback mKeyFrameResCallback;
  
  public GdrKeyFrameGenerator(Context paramContext, KeyFrameResCallback paramKeyFrameResCallback)
  {
    this.mContext = paramContext.getApplicationContext();
    this.mKeyFrameResCallback = paramKeyFrameResCallback;
  }
  
  private byte[] getDefaultKeyFrame(int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public VideoFrame genFakeKeyFrame(VideoFrame paramVideoFrame)
  {
    return null;
  }
  
  public boolean isGdrStartFrame(VideoFrame paramVideoFrame)
  {
    return false;
  }
  
  public boolean needGenFakeKeyFrame(VideoFrame paramVideoFrame)
  {
    return false;
  }
  
  public static abstract interface KeyFrameResCallback
  {
    public abstract int getKeyFrameResID(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\GdrKeyFrameGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */