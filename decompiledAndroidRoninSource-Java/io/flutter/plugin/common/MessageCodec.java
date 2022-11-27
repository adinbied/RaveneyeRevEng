package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public abstract interface MessageCodec<T>
{
  public abstract T decodeMessage(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuffer encodeMessage(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\MessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */