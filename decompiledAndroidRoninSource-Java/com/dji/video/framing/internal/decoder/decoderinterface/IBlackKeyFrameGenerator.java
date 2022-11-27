package com.dji.video.framing.internal.decoder.decoderinterface;

import com.dji.video.framing.internal.VideoFrame;

public abstract interface IBlackKeyFrameGenerator
{
  public abstract VideoFrame genFakeKeyFrame(VideoFrame paramVideoFrame);
  
  public abstract boolean isGdrStartFrame(VideoFrame paramVideoFrame);
  
  public abstract boolean needGenFakeKeyFrame(VideoFrame paramVideoFrame);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\decoderinterface\IBlackKeyFrameGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */