package com.dji.video.framing.internal.decoder.decoderinterface;

import java.nio.ByteBuffer;

public abstract interface IYuvDataCallback
{
  public abstract void onYuvDataReceived(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framing\internal\decoder\decoderinterface\IYuvDataCallback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */