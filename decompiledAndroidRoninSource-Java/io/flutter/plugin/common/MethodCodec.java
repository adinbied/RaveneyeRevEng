package io.flutter.plugin.common;

import java.nio.ByteBuffer;

public abstract interface MethodCodec
{
  public abstract Object decodeEnvelope(ByteBuffer paramByteBuffer);
  
  public abstract MethodCall decodeMethodCall(ByteBuffer paramByteBuffer);
  
  public abstract ByteBuffer encodeErrorEnvelope(String paramString1, String paramString2, Object paramObject);
  
  public abstract ByteBuffer encodeMethodCall(MethodCall paramMethodCall);
  
  public abstract ByteBuffer encodeSuccessEnvelope(Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\MethodCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */