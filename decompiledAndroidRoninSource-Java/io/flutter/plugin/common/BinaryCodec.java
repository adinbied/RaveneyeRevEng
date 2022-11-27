package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public final class BinaryCodec
  implements MessageCodec<ByteBuffer>
{
  public static final BinaryCodec INSTANCE = new BinaryCodec();
  
  public ByteBuffer decodeMessage(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
  
  public ByteBuffer encodeMessage(ByteBuffer paramByteBuffer)
  {
    return paramByteBuffer;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\BinaryCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */