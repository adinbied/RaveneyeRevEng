package com.squareup.wire;

import java.io.IOException;
import okio.BufferedSink;
import okio.ByteString;

public final class ProtoWriter
{
  private final BufferedSink sink;
  
  public ProtoWriter(BufferedSink paramBufferedSink)
  {
    this.sink = paramBufferedSink;
  }
  
  static int decodeZigZag32(int paramInt)
  {
    return -(paramInt & 0x1) ^ paramInt >>> 1;
  }
  
  static long decodeZigZag64(long paramLong)
  {
    return -(paramLong & 1L) ^ paramLong >>> 1;
  }
  
  static int encodeZigZag32(int paramInt)
  {
    return paramInt >> 31 ^ paramInt << 1;
  }
  
  static long encodeZigZag64(long paramLong)
  {
    return paramLong >> 63 ^ paramLong << 1;
  }
  
  static int int32Size(int paramInt)
  {
    if (paramInt >= 0) {
      return varint32Size(paramInt);
    }
    return 10;
  }
  
  private static int makeTag(int paramInt, FieldEncoding paramFieldEncoding)
  {
    return paramInt << 3 | paramFieldEncoding.value;
  }
  
  static int tagSize(int paramInt)
  {
    return varint32Size(makeTag(paramInt, FieldEncoding.VARINT));
  }
  
  static int utf8Length(String paramString)
  {
    int m = paramString.length();
    int j = 0;
    int i = 0;
    while (j < m)
    {
      int k = paramString.charAt(j);
      if (k < 128) {}
      do
      {
        do
        {
          i += 1;
          break label114;
          if (k < 2048)
          {
            i += 2;
            break label114;
          }
          if ((k < 55296) || (k > 57343)) {
            break;
          }
        } while (k > 56319);
        k = j + 1;
      } while ((k >= m) || (paramString.charAt(k) < 56320) || (paramString.charAt(k) > 57343));
      i += 4;
      j = k;
      break label114;
      i += 3;
      label114:
      j += 1;
    }
    return i;
  }
  
  static int varint32Size(int paramInt)
  {
    if ((paramInt & 0xFFFFFF80) == 0) {
      return 1;
    }
    if ((paramInt & 0xC000) == 0) {
      return 2;
    }
    if ((0xFFE00000 & paramInt) == 0) {
      return 3;
    }
    if ((paramInt & 0xF0000000) == 0) {
      return 4;
    }
    return 5;
  }
  
  static int varint64Size(long paramLong)
  {
    if ((0xFFFFFFFFFFFFFF80 & paramLong) == 0L) {
      return 1;
    }
    if ((0xFFFFFFFFFFFFC000 & paramLong) == 0L) {
      return 2;
    }
    if ((0xFFFFFFFFFFE00000 & paramLong) == 0L) {
      return 3;
    }
    if ((0xFFFFFFFFF0000000 & paramLong) == 0L) {
      return 4;
    }
    if ((0xFFFFFFF800000000 & paramLong) == 0L) {
      return 5;
    }
    if ((0xFFFFFC0000000000 & paramLong) == 0L) {
      return 6;
    }
    if ((0xFFFE000000000000 & paramLong) == 0L) {
      return 7;
    }
    if ((0xFF00000000000000 & paramLong) == 0L) {
      return 8;
    }
    if ((paramLong & 0x8000000000000000) == 0L) {
      return 9;
    }
    return 10;
  }
  
  public void writeBytes(ByteString paramByteString)
    throws IOException
  {
    this.sink.write(paramByteString);
  }
  
  public void writeFixed32(int paramInt)
    throws IOException
  {
    this.sink.writeIntLe(paramInt);
  }
  
  public void writeFixed64(long paramLong)
    throws IOException
  {
    this.sink.writeLongLe(paramLong);
  }
  
  void writeSignedVarint32(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      writeVarint32(paramInt);
      return;
    }
    writeVarint64(paramInt);
  }
  
  public void writeString(String paramString)
    throws IOException
  {
    this.sink.writeUtf8(paramString);
  }
  
  public void writeTag(int paramInt, FieldEncoding paramFieldEncoding)
    throws IOException
  {
    writeVarint32(makeTag(paramInt, paramFieldEncoding));
  }
  
  public void writeVarint32(int paramInt)
    throws IOException
  {
    while ((paramInt & 0xFFFFFF80) != 0)
    {
      this.sink.writeByte(paramInt & 0x7F | 0x80);
      paramInt >>>= 7;
    }
    this.sink.writeByte(paramInt);
  }
  
  public void writeVarint64(long paramLong)
    throws IOException
  {
    while ((0xFFFFFFFFFFFFFF80 & paramLong) != 0L)
    {
      this.sink.writeByte((int)paramLong & 0x7F | 0x80);
      paramLong >>>= 7;
    }
    this.sink.writeByte((int)paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\squareup\wire\ProtoWriter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */