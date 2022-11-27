package com.dji.video.framing.internal.decoder.decoderinterface;

import com.dji.video.framing.internal.decoder.DJIVideoDecoder.VideoDecoderState;

public abstract interface IDecoderStateListener
{
  public abstract void onStateChange(DJIVideoDecoder.VideoDecoderState paramVideoDecoderState);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\decoderinterface\IDecoderStateListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */