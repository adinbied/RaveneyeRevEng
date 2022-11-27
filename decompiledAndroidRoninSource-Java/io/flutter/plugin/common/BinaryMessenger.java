package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public abstract interface BinaryMessenger
{
  public abstract void send(String paramString, ByteBuffer paramByteBuffer);
  
  public abstract void send(String paramString, ByteBuffer paramByteBuffer, BinaryReply paramBinaryReply);
  
  public abstract void setMessageHandler(String paramString, BinaryMessageHandler paramBinaryMessageHandler);
  
  public static abstract interface BinaryMessageHandler
  {
    public abstract void onMessage(ByteBuffer paramByteBuffer, BinaryMessenger.BinaryReply paramBinaryReply);
  }
  
  public static abstract interface BinaryReply
  {
    public abstract void reply(ByteBuffer paramByteBuffer);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\BinaryMessenger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */