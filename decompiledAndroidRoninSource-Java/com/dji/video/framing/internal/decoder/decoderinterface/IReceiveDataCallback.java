package com.dji.video.framing.internal.decoder.decoderinterface;

public abstract interface IReceiveDataCallback
{
  public abstract void oneFrameComeIn();
  
  public abstract void resetVideoSurface(int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\decoderinterface\IReceiveDataCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */