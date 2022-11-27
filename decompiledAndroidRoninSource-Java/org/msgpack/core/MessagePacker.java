package org.msgpack.core;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferOutput;
import org.msgpack.value.Value;

public class MessagePacker
  implements Closeable
{
  private static final int UTF_8_MAX_CHAR_SIZE = 6;
  private MessageBuffer buffer;
  private final int bufferFlushThreshold;
  private CharsetEncoder encoder;
  protected MessageBufferOutput out;
  private int position;
  private final int smallStringOptimizationThreshold;
  private final boolean str8FormatSupport;
  private long totalFlushBytes;
  
  protected MessagePacker(MessageBufferOutput paramMessageBufferOutput, MessagePack.PackerConfig paramPackerConfig)
  {
    this.out = ((MessageBufferOutput)Preconditions.checkNotNull(paramMessageBufferOutput, "MessageBufferOutput is null"));
    this.smallStringOptimizationThreshold = paramPackerConfig.getSmallStringOptimizationThreshold();
    this.bufferFlushThreshold = paramPackerConfig.getBufferFlushThreshold();
    this.str8FormatSupport = paramPackerConfig.isStr8FormatSupport();
    this.position = 0;
    this.totalFlushBytes = 0L;
  }
  
  private int encodeStringToBufferAt(int paramInt, String paramString)
  {
    prepareEncoder();
    Object localObject = this.buffer;
    localObject = ((MessageBuffer)localObject).sliceAsByteBuffer(paramInt, ((MessageBuffer)localObject).size() - paramInt);
    paramInt = ((ByteBuffer)localObject).position();
    paramString = CharBuffer.wrap(paramString);
    paramString = this.encoder.encode(paramString, (ByteBuffer)localObject, true);
    if (paramString.isError()) {
      try
      {
        paramString.throwException();
      }
      catch (CharacterCodingException paramString)
      {
        throw new MessageStringCodingException(paramString);
      }
    }
    if (paramString.isUnderflow())
    {
      if (paramString.isOverflow()) {
        return -1;
      }
      if (!this.encoder.flush((ByteBuffer)localObject).isUnderflow()) {
        return -1;
      }
      return ((ByteBuffer)localObject).position() - paramInt;
    }
    return -1;
  }
  
  private void ensureCapacity(int paramInt)
    throws IOException
  {
    MessageBuffer localMessageBuffer = this.buffer;
    if (localMessageBuffer == null)
    {
      this.buffer = this.out.next(paramInt);
      return;
    }
    if (this.position + paramInt >= localMessageBuffer.size())
    {
      flushBuffer();
      this.buffer = this.out.next(paramInt);
    }
  }
  
  private void flushBuffer()
    throws IOException
  {
    this.out.writeBuffer(this.position);
    this.buffer = null;
    this.totalFlushBytes += this.position;
    this.position = 0;
  }
  
  private void packStringWithGetBytes(String paramString)
    throws IOException
  {
    paramString = paramString.getBytes(MessagePack.UTF8);
    packRawStringHeader(paramString.length);
    addPayload(paramString);
  }
  
  private void prepareEncoder()
  {
    if (this.encoder == null) {
      this.encoder = MessagePack.UTF8.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }
    this.encoder.reset();
  }
  
  private void writeByte(byte paramByte)
    throws IOException
  {
    ensureCapacity(1);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte);
  }
  
  private void writeByteAndByte(byte paramByte1, byte paramByte2)
    throws IOException
  {
    ensureCapacity(2);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte1);
    localMessageBuffer = this.buffer;
    i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte2);
  }
  
  private void writeByteAndDouble(byte paramByte, double paramDouble)
    throws IOException
  {
    ensureCapacity(9);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte);
    this.buffer.putDouble(this.position, paramDouble);
    this.position += 8;
  }
  
  private void writeByteAndFloat(byte paramByte, float paramFloat)
    throws IOException
  {
    ensureCapacity(5);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte);
    this.buffer.putFloat(this.position, paramFloat);
    this.position += 4;
  }
  
  private void writeByteAndInt(byte paramByte, int paramInt)
    throws IOException
  {
    ensureCapacity(5);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte);
    this.buffer.putInt(this.position, paramInt);
    this.position += 4;
  }
  
  private void writeByteAndLong(byte paramByte, long paramLong)
    throws IOException
  {
    ensureCapacity(9);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte);
    this.buffer.putLong(this.position, paramLong);
    this.position += 8;
  }
  
  private void writeByteAndShort(byte paramByte, short paramShort)
    throws IOException
  {
    ensureCapacity(3);
    MessageBuffer localMessageBuffer = this.buffer;
    int i = this.position;
    this.position = (i + 1);
    localMessageBuffer.putByte(i, paramByte);
    this.buffer.putShort(this.position, paramShort);
    this.position += 2;
  }
  
  private void writeInt(int paramInt)
    throws IOException
  {
    ensureCapacity(4);
    this.buffer.putInt(this.position, paramInt);
    this.position += 4;
  }
  
  private void writeLong(long paramLong)
    throws IOException
  {
    ensureCapacity(8);
    this.buffer.putLong(this.position, paramLong);
    this.position += 8;
  }
  
  private void writeShort(short paramShort)
    throws IOException
  {
    ensureCapacity(2);
    this.buffer.putShort(this.position, paramShort);
    this.position += 2;
  }
  
  public MessagePacker addPayload(byte[] paramArrayOfByte)
    throws IOException
  {
    return addPayload(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public MessagePacker addPayload(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.buffer.size();
    int j = this.position;
    if ((i - j >= paramInt2) && (paramInt2 <= this.bufferFlushThreshold))
    {
      this.buffer.putBytes(j, paramArrayOfByte, paramInt1, paramInt2);
      this.position += paramInt2;
      return this;
    }
    flush();
    this.out.add(paramArrayOfByte, paramInt1, paramInt2);
    this.totalFlushBytes += paramInt2;
    return this;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      flush();
      return;
    }
    finally
    {
      this.out.close();
    }
  }
  
  public void flush()
    throws IOException
  {
    if (this.position > 0) {
      flushBuffer();
    }
    this.out.flush();
  }
  
  public long getTotalWrittenBytes()
  {
    return this.totalFlushBytes + this.position;
  }
  
  public MessagePacker packArrayHeader(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      if (paramInt < 16)
      {
        writeByte((byte)(paramInt | 0xFFFFFF90));
        return this;
      }
      if (paramInt < 65536)
      {
        writeByteAndShort((byte)-36, (short)paramInt);
        return this;
      }
      writeByteAndInt((byte)-35, paramInt);
      return this;
    }
    throw new IllegalArgumentException("array size must be >= 0");
  }
  
  public MessagePacker packBigInteger(BigInteger paramBigInteger)
    throws IOException
  {
    if (paramBigInteger.bitLength() <= 63)
    {
      packLong(paramBigInteger.longValue());
      return this;
    }
    if ((paramBigInteger.bitLength() == 64) && (paramBigInteger.signum() == 1))
    {
      writeByteAndLong((byte)-49, paramBigInteger.longValue());
      return this;
    }
    throw new IllegalArgumentException("MessagePack cannot serialize BigInteger larger than 2^64-1");
  }
  
  public MessagePacker packBinaryHeader(int paramInt)
    throws IOException
  {
    if (paramInt < 256)
    {
      writeByteAndByte((byte)-60, (byte)paramInt);
      return this;
    }
    if (paramInt < 65536)
    {
      writeByteAndShort((byte)-59, (short)paramInt);
      return this;
    }
    writeByteAndInt((byte)-58, paramInt);
    return this;
  }
  
  public MessagePacker packBoolean(boolean paramBoolean)
    throws IOException
  {
    byte b;
    if (paramBoolean) {
      b = -61;
    } else {
      b = -62;
    }
    writeByte(b);
    return this;
  }
  
  public MessagePacker packByte(byte paramByte)
    throws IOException
  {
    if (paramByte < -32)
    {
      writeByteAndByte((byte)-48, paramByte);
      return this;
    }
    writeByte(paramByte);
    return this;
  }
  
  public MessagePacker packDouble(double paramDouble)
    throws IOException
  {
    writeByteAndDouble((byte)-53, paramDouble);
    return this;
  }
  
  public MessagePacker packExtensionTypeHeader(byte paramByte, int paramInt)
    throws IOException
  {
    if (paramInt < 256)
    {
      if ((paramInt > 0) && ((paramInt - 1 & paramInt) == 0))
      {
        if (paramInt == 1)
        {
          writeByteAndByte((byte)-44, paramByte);
          return this;
        }
        if (paramInt == 2)
        {
          writeByteAndByte((byte)-43, paramByte);
          return this;
        }
        if (paramInt == 4)
        {
          writeByteAndByte((byte)-42, paramByte);
          return this;
        }
        if (paramInt == 8)
        {
          writeByteAndByte((byte)-41, paramByte);
          return this;
        }
        if (paramInt == 16)
        {
          writeByteAndByte((byte)-40, paramByte);
          return this;
        }
        writeByteAndByte((byte)-57, (byte)paramInt);
        writeByte(paramByte);
        return this;
      }
      writeByteAndByte((byte)-57, (byte)paramInt);
      writeByte(paramByte);
      return this;
    }
    if (paramInt < 65536)
    {
      writeByteAndShort((byte)-56, (short)paramInt);
      writeByte(paramByte);
      return this;
    }
    writeByteAndInt((byte)-55, paramInt);
    writeByte(paramByte);
    return this;
  }
  
  public MessagePacker packFloat(float paramFloat)
    throws IOException
  {
    writeByteAndFloat((byte)-54, paramFloat);
    return this;
  }
  
  public MessagePacker packInt(int paramInt)
    throws IOException
  {
    if (paramInt < -32)
    {
      if (paramInt < 32768)
      {
        writeByteAndInt((byte)-46, paramInt);
        return this;
      }
      if (paramInt < -128)
      {
        writeByteAndShort((byte)-47, (short)paramInt);
        return this;
      }
      writeByteAndByte((byte)-48, (byte)paramInt);
      return this;
    }
    if (paramInt < 128)
    {
      writeByte((byte)paramInt);
      return this;
    }
    if (paramInt < 256)
    {
      writeByteAndByte((byte)-52, (byte)paramInt);
      return this;
    }
    if (paramInt < 65536)
    {
      writeByteAndShort((byte)-51, (short)paramInt);
      return this;
    }
    writeByteAndInt((byte)-50, paramInt);
    return this;
  }
  
  public MessagePacker packLong(long paramLong)
    throws IOException
  {
    if (paramLong < -32L)
    {
      if (paramLong < -32768L)
      {
        if (paramLong < -2147483648L)
        {
          writeByteAndLong((byte)-45, paramLong);
          return this;
        }
        writeByteAndInt((byte)-46, (int)paramLong);
        return this;
      }
      if (paramLong < -128L)
      {
        writeByteAndShort((byte)-47, (short)(int)paramLong);
        return this;
      }
      writeByteAndByte((byte)-48, (byte)(int)paramLong);
      return this;
    }
    if (paramLong < 128L)
    {
      writeByte((byte)(int)paramLong);
      return this;
    }
    if (paramLong < 65536L)
    {
      if (paramLong < 256L)
      {
        writeByteAndByte((byte)-52, (byte)(int)paramLong);
        return this;
      }
      writeByteAndShort((byte)-51, (short)(int)paramLong);
      return this;
    }
    if (paramLong < 4294967296L)
    {
      writeByteAndInt((byte)-50, (int)paramLong);
      return this;
    }
    writeByteAndLong((byte)-49, paramLong);
    return this;
  }
  
  public MessagePacker packMapHeader(int paramInt)
    throws IOException
  {
    if (paramInt >= 0)
    {
      if (paramInt < 16)
      {
        writeByte((byte)(paramInt | 0xFFFFFF80));
        return this;
      }
      if (paramInt < 65536)
      {
        writeByteAndShort((byte)-34, (short)paramInt);
        return this;
      }
      writeByteAndInt((byte)-33, paramInt);
      return this;
    }
    throw new IllegalArgumentException("map size must be >= 0");
  }
  
  public MessagePacker packNil()
    throws IOException
  {
    writeByte((byte)-64);
    return this;
  }
  
  public MessagePacker packRawStringHeader(int paramInt)
    throws IOException
  {
    if (paramInt < 32)
    {
      writeByte((byte)(paramInt | 0xFFFFFFA0));
      return this;
    }
    if ((this.str8FormatSupport) && (paramInt < 256))
    {
      writeByteAndByte((byte)-39, (byte)paramInt);
      return this;
    }
    if (paramInt < 65536)
    {
      writeByteAndShort((byte)-38, (short)paramInt);
      return this;
    }
    writeByteAndInt((byte)-37, paramInt);
    return this;
  }
  
  public MessagePacker packShort(short paramShort)
    throws IOException
  {
    if (paramShort < -32)
    {
      if (paramShort < -128)
      {
        writeByteAndShort((byte)-47, paramShort);
        return this;
      }
      writeByteAndByte((byte)-48, (byte)paramShort);
      return this;
    }
    if (paramShort < 128)
    {
      writeByte((byte)paramShort);
      return this;
    }
    if (paramShort < 256)
    {
      writeByteAndByte((byte)-52, (byte)paramShort);
      return this;
    }
    writeByteAndShort((byte)-51, paramShort);
    return this;
  }
  
  public MessagePacker packString(String paramString)
    throws IOException
  {
    if (paramString.length() <= 0)
    {
      packRawStringHeader(0);
      return this;
    }
    if (paramString.length() < this.smallStringOptimizationThreshold)
    {
      packStringWithGetBytes(paramString);
      return this;
    }
    int i;
    int j;
    if (paramString.length() < 256)
    {
      ensureCapacity(paramString.length() * 6 + 2 + 1);
      i = encodeStringToBufferAt(this.position + 2, paramString);
      if (i >= 0)
      {
        if ((this.str8FormatSupport) && (i < 256))
        {
          paramString = this.buffer;
          j = this.position;
          this.position = (j + 1);
          paramString.putByte(j, (byte)-39);
          paramString = this.buffer;
          j = this.position;
          this.position = (j + 1);
          paramString.putByte(j, (byte)i);
          this.position += i;
          return this;
        }
        if (i < 65536)
        {
          paramString = this.buffer;
          paramString.putBytes(this.position + 3, paramString.array(), this.buffer.arrayOffset() + this.position + 2, i);
          paramString = this.buffer;
          j = this.position;
          this.position = (j + 1);
          paramString.putByte(j, (byte)-38);
          this.buffer.putShort(this.position, (short)i);
          j = this.position + 2;
          this.position = j;
          this.position = (j + i);
          return this;
        }
        throw new IllegalArgumentException("Unexpected UTF-8 encoder state");
      }
    }
    else if (paramString.length() < 65536)
    {
      ensureCapacity(paramString.length() * 6 + 3 + 2);
      i = encodeStringToBufferAt(this.position + 3, paramString);
      if (i >= 0)
      {
        if (i < 65536)
        {
          paramString = this.buffer;
          j = this.position;
          this.position = (j + 1);
          paramString.putByte(j, (byte)-38);
          this.buffer.putShort(this.position, (short)i);
          j = this.position + 2;
          this.position = j;
          this.position = (j + i);
          return this;
        }
        if (i < 1)
        {
          paramString = this.buffer;
          paramString.putBytes(this.position + 5, paramString.array(), this.buffer.arrayOffset() + this.position + 3, i);
          paramString = this.buffer;
          j = this.position;
          this.position = (j + 1);
          paramString.putByte(j, (byte)-37);
          this.buffer.putInt(this.position, i);
          j = this.position + 4;
          this.position = j;
          this.position = (j + i);
          return this;
        }
        throw new IllegalArgumentException("Unexpected UTF-8 encoder state");
      }
    }
    packStringWithGetBytes(paramString);
    return this;
  }
  
  public MessagePacker packValue(Value paramValue)
    throws IOException
  {
    paramValue.writeTo(this);
    return this;
  }
  
  public MessageBufferOutput reset(MessageBufferOutput paramMessageBufferOutput)
    throws IOException
  {
    paramMessageBufferOutput = (MessageBufferOutput)Preconditions.checkNotNull(paramMessageBufferOutput, "MessageBufferOutput is null");
    flush();
    MessageBufferOutput localMessageBufferOutput = this.out;
    this.out = paramMessageBufferOutput;
    this.totalFlushBytes = 0L;
    return localMessageBufferOutput;
  }
  
  public MessagePacker writePayload(byte[] paramArrayOfByte)
    throws IOException
  {
    return writePayload(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public MessagePacker writePayload(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.buffer.size();
    int j = this.position;
    if ((i - j >= paramInt2) && (paramInt2 <= this.bufferFlushThreshold))
    {
      this.buffer.putBytes(j, paramArrayOfByte, paramInt1, paramInt2);
      this.position += paramInt2;
      return this;
    }
    flush();
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.totalFlushBytes += paramInt2;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessagePacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */