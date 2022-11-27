package io.flutter.plugin.common;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public class StandardMessageCodec
  implements MessageCodec<Object>
{
  private static final byte BIGINT = 5;
  private static final byte BYTE_ARRAY = 8;
  private static final byte DOUBLE = 6;
  private static final byte DOUBLE_ARRAY = 11;
  private static final byte FALSE = 2;
  public static final StandardMessageCodec INSTANCE = new StandardMessageCodec();
  private static final byte INT = 3;
  private static final byte INT_ARRAY = 9;
  private static final byte LIST = 12;
  private static final boolean LITTLE_ENDIAN;
  private static final byte LONG = 4;
  private static final byte LONG_ARRAY = 10;
  private static final byte MAP = 13;
  private static final byte NULL = 0;
  private static final byte STRING = 7;
  private static final String TAG = "StandardMessageCodec#";
  private static final byte TRUE = 1;
  private static final Charset UTF8 = Charset.forName("UTF8");
  
  static
  {
    boolean bool;
    if (ByteOrder.nativeOrder() == ByteOrder.LITTLE_ENDIAN) {
      bool = true;
    } else {
      bool = false;
    }
    LITTLE_ENDIAN = bool;
  }
  
  protected static final void readAlignment(ByteBuffer paramByteBuffer, int paramInt)
  {
    int i = paramByteBuffer.position() % paramInt;
    if (i != 0) {
      paramByteBuffer.position(paramByteBuffer.position() + paramInt - i);
    }
  }
  
  protected static final byte[] readBytes(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = new byte[readSize(paramByteBuffer)];
    paramByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  protected static final int readSize(ByteBuffer paramByteBuffer)
  {
    if (paramByteBuffer.hasRemaining())
    {
      int i = paramByteBuffer.get() & 0xFF;
      if (i < 254) {
        return i;
      }
      if (i == 254) {
        return paramByteBuffer.getChar();
      }
      return paramByteBuffer.getInt();
    }
    throw new IllegalArgumentException("Message corrupted");
  }
  
  protected static final void writeAlignment(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    int j = paramByteArrayOutputStream.size() % paramInt;
    if (j != 0)
    {
      int i = 0;
      while (i < paramInt - j)
      {
        paramByteArrayOutputStream.write(0);
        i += 1;
      }
    }
  }
  
  protected static final void writeBytes(ByteArrayOutputStream paramByteArrayOutputStream, byte[] paramArrayOfByte)
  {
    writeSize(paramByteArrayOutputStream, paramArrayOfByte.length);
    paramByteArrayOutputStream.write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  protected static final void writeChar(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write(paramInt);
      paramByteArrayOutputStream.write(paramInt >>> 8);
      return;
    }
    paramByteArrayOutputStream.write(paramInt >>> 8);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  protected static final void writeDouble(ByteArrayOutputStream paramByteArrayOutputStream, double paramDouble)
  {
    writeLong(paramByteArrayOutputStream, Double.doubleToLongBits(paramDouble));
  }
  
  protected static final void writeInt(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write(paramInt);
      paramByteArrayOutputStream.write(paramInt >>> 8);
      paramByteArrayOutputStream.write(paramInt >>> 16);
      paramByteArrayOutputStream.write(paramInt >>> 24);
      return;
    }
    paramByteArrayOutputStream.write(paramInt >>> 24);
    paramByteArrayOutputStream.write(paramInt >>> 16);
    paramByteArrayOutputStream.write(paramInt >>> 8);
    paramByteArrayOutputStream.write(paramInt);
  }
  
  protected static final void writeLong(ByteArrayOutputStream paramByteArrayOutputStream, long paramLong)
  {
    if (LITTLE_ENDIAN)
    {
      paramByteArrayOutputStream.write((byte)(int)paramLong);
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 8));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 16));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 24));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 32));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 40));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 48));
      paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 56));
      return;
    }
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 56));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 48));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 40));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 32));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 24));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 16));
    paramByteArrayOutputStream.write((byte)(int)(paramLong >>> 8));
    paramByteArrayOutputStream.write((byte)(int)paramLong);
  }
  
  protected static final void writeSize(ByteArrayOutputStream paramByteArrayOutputStream, int paramInt)
  {
    if (paramInt < 254)
    {
      paramByteArrayOutputStream.write(paramInt);
      return;
    }
    if (paramInt <= 65535)
    {
      paramByteArrayOutputStream.write(254);
      writeChar(paramByteArrayOutputStream, paramInt);
      return;
    }
    paramByteArrayOutputStream.write(255);
    writeInt(paramByteArrayOutputStream, paramInt);
  }
  
  public Object decodeMessage(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  public ByteBuffer encodeMessage(Object paramObject)
  {
    return null;
  }
  
  protected final Object readValue(ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  protected Object readValueOfType(byte paramByte, ByteBuffer paramByteBuffer)
  {
    return null;
  }
  
  /* Error */
  protected void writeValue(ByteArrayOutputStream arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class ExposedByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    byte[] buffer()
    {
      return this.buf;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\StandardMessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */