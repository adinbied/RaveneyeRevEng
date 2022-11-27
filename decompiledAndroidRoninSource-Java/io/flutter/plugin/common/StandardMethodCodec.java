package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public final class StandardMethodCodec
  implements MethodCodec
{
  public static final StandardMethodCodec INSTANCE = new StandardMethodCodec(StandardMessageCodec.INSTANCE);
  private final StandardMessageCodec messageCodec;
  
  public StandardMethodCodec(StandardMessageCodec paramStandardMessageCodec)
  {
    this.messageCodec = paramStandardMessageCodec;
  }
  
  public Object decodeEnvelope(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  public MethodCall decodeMethodCall(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  public ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject)
  {
    return null;
  }
  
  public ByteBuffer encodeMethodCall(MethodCall paramMethodCall)
  {
    return null;
  }
  
  public ByteBuffer encodeSuccessEnvelope(Object paramObject)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\StandardMethodCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */