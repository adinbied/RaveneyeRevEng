package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public final class StringCodec
  implements MessageCodec<String>
{
  public static final StringCodec INSTANCE = new StringCodec();
  private static final Charset UTF8 = Charset.forName("UTF8");
  
  public String decodeMessage(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  public ByteBuffer encodeMessage(String paramString)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\StringCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */