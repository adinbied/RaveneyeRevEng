package io.flutter.plugin.common;

import java.nio.ByteBuffer;
import org.json.JSONObject;

public final class JSONMethodCodec
  implements MethodCodec
{
  public static final JSONMethodCodec INSTANCE = new JSONMethodCodec();
  
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
  
  Object unwrapNull(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject == JSONObject.NULL) {
      localObject = null;
    }
    return localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\JSONMethodCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */