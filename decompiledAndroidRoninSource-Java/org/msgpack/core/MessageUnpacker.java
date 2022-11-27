package org.msgpack.core;

import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.msgpack.core.buffer.MessageBuffer;
import org.msgpack.core.buffer.MessageBufferInput;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueFactory;
import org.msgpack.value.ValueType;
import org.msgpack.value.Variable;

public class MessageUnpacker
  implements Closeable
{
  private static final MessageBuffer EMPTY_BUFFER = MessageBuffer.wrap(new byte[0]);
  private static final String EMPTY_STRING = "";
  private final CodingErrorAction actionOnMalformedString;
  private final CodingErrorAction actionOnUnmappableString;
  private final boolean allowReadingBinaryAsString;
  private final boolean allowReadingStringAsBinary;
  private MessageBuffer buffer = EMPTY_BUFFER;
  private CharBuffer decodeBuffer;
  private StringBuilder decodeStringBuffer;
  private CharsetDecoder decoder;
  private MessageBufferInput in;
  private int nextReadPosition;
  private final MessageBuffer numberBuffer = MessageBuffer.allocate(8);
  private int position;
  private final int stringDecoderBufferSize;
  private final int stringSizeLimit;
  private long totalReadBytes;
  
  protected MessageUnpacker(MessageBufferInput paramMessageBufferInput, MessagePack.UnpackerConfig paramUnpackerConfig)
  {
    this.in = ((MessageBufferInput)Preconditions.checkNotNull(paramMessageBufferInput, "MessageBufferInput is null"));
    this.allowReadingStringAsBinary = paramUnpackerConfig.getAllowReadingStringAsBinary();
    this.allowReadingBinaryAsString = paramUnpackerConfig.getAllowReadingBinaryAsString();
    this.actionOnMalformedString = paramUnpackerConfig.getActionOnMalformedString();
    this.actionOnUnmappableString = paramUnpackerConfig.getActionOnUnmappableString();
    this.stringSizeLimit = paramUnpackerConfig.getStringSizeLimit();
    this.stringDecoderBufferSize = paramUnpackerConfig.getStringDecoderBufferSize();
  }
  
  private String decodeStringFastPath(int paramInt)
  {
    if ((this.actionOnMalformedString == CodingErrorAction.REPLACE) && (this.actionOnUnmappableString == CodingErrorAction.REPLACE))
    {
      localObject = new String(this.buffer.array(), this.buffer.arrayOffset() + this.position, paramInt, MessagePack.UTF8);
      this.position += paramInt;
      return (String)localObject;
    }
    resetDecoder();
    Object localObject = this.buffer.sliceAsByteBuffer();
    ((ByteBuffer)localObject).limit(this.position + paramInt);
    ((ByteBuffer)localObject).position(this.position);
    try
    {
      localObject = this.decoder.decode((ByteBuffer)localObject);
      this.position += paramInt;
      return ((CharBuffer)localObject).toString();
    }
    catch (CharacterCodingException localCharacterCodingException)
    {
      throw new MessageStringCodingException(localCharacterCodingException);
    }
  }
  
  private MessageBuffer getNextBuffer()
    throws IOException
  {
    MessageBuffer localMessageBuffer = this.in.next();
    if (localMessageBuffer != null)
    {
      this.totalReadBytes += this.buffer.size();
      return localMessageBuffer;
    }
    throw new MessageInsufficientBufferException();
  }
  
  private void handleCoderError(CoderResult paramCoderResult)
    throws CharacterCodingException
  {
    if (((paramCoderResult.isMalformed()) && (this.actionOnMalformedString == CodingErrorAction.REPORT)) || ((paramCoderResult.isUnmappable()) && (this.actionOnUnmappableString == CodingErrorAction.REPORT))) {
      paramCoderResult.throwException();
    }
  }
  
  private void nextBuffer()
    throws IOException
  {
    this.buffer = getNextBuffer();
    this.position = 0;
  }
  
  private static MessageIntegerOverflowException overflowI16(short paramShort)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf(paramShort));
  }
  
  private static MessageIntegerOverflowException overflowI32(int paramInt)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf(paramInt));
  }
  
  private static MessageIntegerOverflowException overflowI64(long paramLong)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf(paramLong));
  }
  
  private static MessageIntegerOverflowException overflowU16(short paramShort)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf(paramShort & 0xFFFF));
  }
  
  private static MessageIntegerOverflowException overflowU32(int paramInt)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf((paramInt & 0x7FFFFFFF) + 2147483648L));
  }
  
  private static MessageSizeException overflowU32Size(int paramInt)
  {
    return new MessageSizeException((paramInt & 0x7FFFFFFF) + 2147483648L);
  }
  
  private static MessageIntegerOverflowException overflowU64(long paramLong)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf(paramLong + Long.MAX_VALUE + 1L).setBit(63));
  }
  
  private static MessageIntegerOverflowException overflowU8(byte paramByte)
  {
    return new MessageIntegerOverflowException(BigInteger.valueOf(paramByte & 0xFF));
  }
  
  private MessageBuffer prepareNumberBuffer(int paramInt)
    throws IOException
  {
    int j = this.buffer.size();
    int i = this.position;
    j -= i;
    if (j >= paramInt)
    {
      this.nextReadPosition = i;
      this.position = (i + paramInt);
      return this.buffer;
    }
    if (j > 0)
    {
      this.numberBuffer.putBytes(0, this.buffer.array(), this.buffer.arrayOffset() + this.position, j);
      i = paramInt - j;
      paramInt = j + 0;
    }
    else
    {
      j = 0;
      i = paramInt;
      paramInt = j;
    }
    for (;;)
    {
      nextBuffer();
      j = this.buffer.size();
      if (j >= i)
      {
        this.numberBuffer.putBytes(paramInt, this.buffer.array(), this.buffer.arrayOffset(), i);
        this.position = i;
        this.nextReadPosition = 0;
        return this.numberBuffer;
      }
      this.numberBuffer.putBytes(paramInt, this.buffer.array(), this.buffer.arrayOffset(), j);
      i -= j;
      paramInt += j;
    }
  }
  
  private byte readByte()
    throws IOException
  {
    int i = this.buffer.size();
    int j = this.position;
    byte b;
    if (i > j)
    {
      b = this.buffer.getByte(j);
      this.position += 1;
      return b;
    }
    nextBuffer();
    if (this.buffer.size() > 0)
    {
      b = this.buffer.getByte(0);
      this.position = 1;
      return b;
    }
    return readByte();
  }
  
  private double readDouble()
    throws IOException
  {
    return prepareNumberBuffer(8).getDouble(this.nextReadPosition);
  }
  
  private float readFloat()
    throws IOException
  {
    return prepareNumberBuffer(4).getFloat(this.nextReadPosition);
  }
  
  private int readInt()
    throws IOException
  {
    return prepareNumberBuffer(4).getInt(this.nextReadPosition);
  }
  
  private long readLong()
    throws IOException
  {
    return prepareNumberBuffer(8).getLong(this.nextReadPosition);
  }
  
  private int readNextLength16()
    throws IOException
  {
    return readShort() & 0xFFFF;
  }
  
  private int readNextLength32()
    throws IOException
  {
    int i = readInt();
    if (i >= 0) {
      return i;
    }
    throw overflowU32Size(i);
  }
  
  private int readNextLength8()
    throws IOException
  {
    return readByte() & 0xFF;
  }
  
  private short readShort()
    throws IOException
  {
    return prepareNumberBuffer(2).getShort(this.nextReadPosition);
  }
  
  private void resetDecoder()
  {
    Object localObject = this.decoder;
    if (localObject == null)
    {
      this.decodeBuffer = CharBuffer.allocate(this.stringDecoderBufferSize);
      this.decoder = MessagePack.UTF8.newDecoder().onMalformedInput(this.actionOnMalformedString).onUnmappableCharacter(this.actionOnUnmappableString);
    }
    else
    {
      ((CharsetDecoder)localObject).reset();
    }
    localObject = this.decodeStringBuffer;
    if (localObject == null)
    {
      this.decodeStringBuffer = new StringBuilder();
      return;
    }
    ((StringBuilder)localObject).setLength(0);
  }
  
  private void skipPayload(int paramInt)
    throws IOException
  {
    for (;;)
    {
      int j = this.buffer.size();
      int i = this.position;
      j -= i;
      if (j >= paramInt)
      {
        this.position = (i + paramInt);
        return;
      }
      this.position = (i + j);
      paramInt -= j;
      nextBuffer();
    }
  }
  
  private int tryReadBinaryHeader(byte paramByte)
    throws IOException
  {
    switch (paramByte)
    {
    default: 
      return -1;
    case -58: 
      return readNextLength32();
    case -59: 
      return readNextLength16();
    }
    return readNextLength8();
  }
  
  private int tryReadStringHeader(byte paramByte)
    throws IOException
  {
    switch (paramByte)
    {
    default: 
      return -1;
    case -37: 
      return readNextLength32();
    case -38: 
      return readNextLength16();
    }
    return readNextLength8();
  }
  
  private static MessagePackException unexpected(String paramString, byte paramByte)
  {
    Object localObject = MessageFormat.valueOf(paramByte);
    if (localObject == MessageFormat.NEVER_USED) {
      return new MessageNeverUsedFormatException(String.format("Expected %s, but encountered 0xC1 \"NEVER_USED\" byte", new Object[] { paramString }));
    }
    localObject = ((MessageFormat)localObject).getValueType().name();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((String)localObject).substring(0, 1));
    localStringBuilder.append(((String)localObject).substring(1).toLowerCase());
    return new MessageTypeException(String.format("Expected %s, but got %s (%02x)", new Object[] { paramString, localStringBuilder.toString(), Byte.valueOf(paramByte) }));
  }
  
  private static int utf8MultibyteCharacterSize(byte paramByte)
  {
    return Integer.numberOfLeadingZeros((paramByte & 0xFF) << 24);
  }
  
  public void close()
    throws IOException
  {
    this.buffer = EMPTY_BUFFER;
    this.position = 0;
    this.in.close();
  }
  
  public MessageFormat getNextFormat()
    throws IOException
  {
    if (hasNext()) {
      return MessageFormat.valueOf(this.buffer.getByte(this.position));
    }
    throw new MessageInsufficientBufferException();
  }
  
  public long getTotalReadBytes()
  {
    return this.totalReadBytes + this.position;
  }
  
  public boolean hasNext()
    throws IOException
  {
    while (this.buffer.size() <= this.position)
    {
      MessageBuffer localMessageBuffer = this.in.next();
      if (localMessageBuffer == null) {
        return false;
      }
      this.totalReadBytes += this.buffer.size();
      this.buffer = localMessageBuffer;
      this.position = 0;
    }
    return true;
  }
  
  public void readPayload(ByteBuffer paramByteBuffer)
    throws IOException
  {
    for (;;)
    {
      int i = paramByteBuffer.remaining();
      int k = this.buffer.size();
      int j = this.position;
      k -= j;
      if (k >= i)
      {
        this.buffer.getBytes(j, i, paramByteBuffer);
        this.position += i;
        return;
      }
      this.buffer.getBytes(j, k, paramByteBuffer);
      this.position += k;
      nextBuffer();
    }
  }
  
  public void readPayload(byte[] paramArrayOfByte)
    throws IOException
  {
    readPayload(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void readPayload(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    readPayload(ByteBuffer.wrap(paramArrayOfByte, paramInt1, paramInt2));
  }
  
  public byte[] readPayload(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = new byte[paramInt];
    readPayload(arrayOfByte);
    return arrayOfByte;
  }
  
  public MessageBuffer readPayloadAsReference(int paramInt)
    throws IOException
  {
    int i = this.buffer.size();
    int j = this.position;
    if (i - j >= paramInt)
    {
      localMessageBuffer = this.buffer.slice(j, paramInt);
      this.position += paramInt;
      return localMessageBuffer;
    }
    MessageBuffer localMessageBuffer = MessageBuffer.allocate(paramInt);
    readPayload(localMessageBuffer.sliceAsByteBuffer());
    return localMessageBuffer;
  }
  
  public MessageBufferInput reset(MessageBufferInput paramMessageBufferInput)
    throws IOException
  {
    paramMessageBufferInput = (MessageBufferInput)Preconditions.checkNotNull(paramMessageBufferInput, "MessageBufferInput is null");
    MessageBufferInput localMessageBufferInput = this.in;
    this.in = paramMessageBufferInput;
    this.buffer = EMPTY_BUFFER;
    this.position = 0;
    this.totalReadBytes = 0L;
    return localMessageBufferInput;
  }
  
  public void skipValue()
    throws IOException
  {
    int j = 1;
    while (j > 0)
    {
      byte b = readByte();
      MessageFormat localMessageFormat = MessageFormat.valueOf(b);
      int i;
      switch (1.$SwitchMap$org$msgpack$core$MessageFormat[localMessageFormat.ordinal()])
      {
      default: 
        break;
      case 36: 
        throw new MessageNeverUsedFormatException("Encountered 0xC1 \"NEVER_USED\" byte");
      case 35: 
        i = readNextLength32();
        break;
      case 34: 
        i = readNextLength16();
        break;
      case 33: 
        i = readNextLength32();
        break;
      case 32: 
        i = readNextLength16();
        break;
      case 31: 
        skipPayload(readNextLength32() + 1);
        break;
      case 30: 
        skipPayload(readNextLength16() + 1);
        break;
      case 29: 
        skipPayload(readNextLength8() + 1);
        break;
      case 28: 
        skipPayload(17);
        break;
      case 27: 
        skipPayload(9);
        break;
      case 26: 
        skipPayload(5);
        break;
      case 25: 
        skipPayload(3);
        break;
      case 24: 
        skipPayload(2);
        break;
      case 22: 
      case 23: 
        skipPayload(readNextLength32());
        break;
      case 20: 
      case 21: 
        skipPayload(readNextLength16());
        break;
      case 18: 
      case 19: 
        skipPayload(readNextLength8());
        break;
      case 15: 
      case 16: 
      case 17: 
        skipPayload(8);
        break;
      case 12: 
      case 13: 
      case 14: 
        skipPayload(4);
        break;
      case 10: 
      case 11: 
        skipPayload(2);
        break;
      case 8: 
      case 9: 
        skipPayload(1);
        break;
      case 7: 
        skipPayload(b & 0x1F);
        break;
      case 6: 
        i = b & 0xF;
        break;
      case 5: 
        i = b & 0xF;
      }
      i *= 2;
      j += i;
      j -= 1;
    }
  }
  
  public int unpackArrayHeader()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixedArray(b)) {
      return b & 0xF;
    }
    if (b != -36)
    {
      if (b == -35) {
        return readNextLength32();
      }
      throw unexpected("Array", b);
    }
    return readNextLength16();
  }
  
  public BigInteger unpackBigInteger()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixInt(b)) {
      return BigInteger.valueOf(b);
    }
    switch (b)
    {
    default: 
      throw unexpected("Integer", b);
    case -45: 
      return BigInteger.valueOf(readLong());
    case -46: 
      return BigInteger.valueOf(readInt());
    case -47: 
      return BigInteger.valueOf(readShort());
    case -48: 
      return BigInteger.valueOf(readByte());
    case -49: 
      long l = readLong();
      if (l < 0L) {
        return BigInteger.valueOf(l + Long.MAX_VALUE + 1L).setBit(63);
      }
      return BigInteger.valueOf(l);
    case -50: 
      int i = readInt();
      if (i < 0) {
        return BigInteger.valueOf((i & 0x7FFFFFFF) + 2147483648L);
      }
      return BigInteger.valueOf(i);
    case -51: 
      return BigInteger.valueOf(readShort() & 0xFFFF);
    }
    return BigInteger.valueOf(readByte() & 0xFF);
  }
  
  public int unpackBinaryHeader()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixedRaw(b)) {
      return b & 0x1F;
    }
    int i = tryReadBinaryHeader(b);
    if (i >= 0) {
      return i;
    }
    if (this.allowReadingStringAsBinary)
    {
      i = tryReadStringHeader(b);
      if (i >= 0) {
        return i;
      }
    }
    throw unexpected("Binary", b);
  }
  
  public boolean unpackBoolean()
    throws IOException
  {
    byte b = readByte();
    if (b == -62) {
      return false;
    }
    if (b == -61) {
      return true;
    }
    throw unexpected("boolean", b);
  }
  
  public byte unpackByte()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixInt(b)) {
      return b;
    }
    long l;
    int i;
    short s;
    switch (b)
    {
    default: 
      throw unexpected("Integer", b);
    case -45: 
      l = readLong();
      if ((l < -128L) || (l > 127L)) {
        break;
      }
    case -46: 
    case -47: 
    case -48: 
    case -49: 
      do
      {
        return (byte)(int)l;
        throw overflowI64(l);
        i = readInt();
        if ((i >= -128) && (i <= 127)) {
          return (byte)i;
        }
        throw overflowI32(i);
        s = readShort();
        if ((s >= -128) && (s <= 127)) {
          return (byte)s;
        }
        throw overflowI16(s);
        return readByte();
        l = readLong();
      } while ((l >= 0L) && (l <= 127L));
      throw overflowU64(l);
    case -50: 
      i = readInt();
      if ((i >= 0) && (i <= 127)) {
        return (byte)i;
      }
      throw overflowU32(i);
    case -51: 
      s = readShort();
      if ((s >= 0) && (s <= 127)) {
        return (byte)s;
      }
      throw overflowU16(s);
    }
    b = readByte();
    if (b >= 0) {
      return b;
    }
    throw overflowU8(b);
  }
  
  public double unpackDouble()
    throws IOException
  {
    byte b = readByte();
    if (b != -54)
    {
      if (b == -53) {
        return readDouble();
      }
      throw unexpected("Float", b);
    }
    return readFloat();
  }
  
  public ExtensionTypeHeader unpackExtensionTypeHeader()
    throws IOException
  {
    byte b = readByte();
    switch (b)
    {
    default: 
      switch (b)
      {
      default: 
        throw unexpected("Ext", b);
      case -40: 
        return new ExtensionTypeHeader(readByte(), 16);
      case -41: 
        return new ExtensionTypeHeader(readByte(), 8);
      case -42: 
        return new ExtensionTypeHeader(readByte(), 4);
      case -43: 
        return new ExtensionTypeHeader(readByte(), 2);
      }
      return new ExtensionTypeHeader(readByte(), 1);
    case -55: 
      localMessageBuffer = prepareNumberBuffer(5);
      i = localMessageBuffer.getInt(this.nextReadPosition);
      if (i >= 0) {
        return new ExtensionTypeHeader(localMessageBuffer.getByte(this.nextReadPosition + 4), i);
      }
      throw overflowU32Size(i);
    case -56: 
      localMessageBuffer = prepareNumberBuffer(3);
      i = localMessageBuffer.getShort(this.nextReadPosition);
      return new ExtensionTypeHeader(localMessageBuffer.getByte(this.nextReadPosition + 2), i & 0xFFFF);
    }
    MessageBuffer localMessageBuffer = prepareNumberBuffer(2);
    int i = localMessageBuffer.getByte(this.nextReadPosition);
    return new ExtensionTypeHeader(localMessageBuffer.getByte(this.nextReadPosition + 1), i & 0xFF);
  }
  
  public float unpackFloat()
    throws IOException
  {
    byte b = readByte();
    if (b != -54)
    {
      if (b == -53) {
        return (float)readDouble();
      }
      throw unexpected("Float", b);
    }
    return readFloat();
  }
  
  public int unpackInt()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixInt(b)) {
      return b;
    }
    long l;
    switch (b)
    {
    default: 
      throw unexpected("Integer", b);
    case -45: 
      l = readLong();
      if ((l >= -2147483648L) && (l <= 2147483647L)) {
        return (int)l;
      }
      throw overflowI64(l);
    case -46: 
      return readInt();
    case -47: 
      return readShort();
    case -48: 
      return readByte();
    case -49: 
      l = readLong();
      if ((l >= 0L) && (l <= 2147483647L)) {
        return (int)l;
      }
      throw overflowU64(l);
    case -50: 
      int i = readInt();
      if (i >= 0) {
        return i;
      }
      throw overflowU32(i);
    case -51: 
      return readShort() & 0xFFFF;
    }
    return readByte() & 0xFF;
  }
  
  public long unpackLong()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixInt(b)) {
      return b;
    }
    switch (b)
    {
    default: 
      throw unexpected("Integer", b);
    case -45: 
      return readLong();
    case -46: 
      return readInt();
    case -47: 
      return readShort();
    case -48: 
      return readByte();
    case -49: 
      long l = readLong();
      if (l >= 0L) {
        return l;
      }
      throw overflowU64(l);
    case -50: 
      int i = readInt();
      if (i < 0) {
        return (i & 0x7FFFFFFF) + 2147483648L;
      }
      return i;
    case -51: 
      return readShort() & 0xFFFF;
    }
    return readByte() & 0xFF;
  }
  
  public int unpackMapHeader()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixedMap(b)) {
      return b & 0xF;
    }
    if (b != -34)
    {
      if (b == -33) {
        return readNextLength32();
      }
      throw unexpected("Map", b);
    }
    return readNextLength16();
  }
  
  public void unpackNil()
    throws IOException
  {
    byte b = readByte();
    if (b == -64) {
      return;
    }
    throw unexpected("Nil", b);
  }
  
  public int unpackRawStringHeader()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixedRaw(b)) {
      return b & 0x1F;
    }
    int i = tryReadStringHeader(b);
    if (i >= 0) {
      return i;
    }
    if (this.allowReadingBinaryAsString)
    {
      i = tryReadBinaryHeader(b);
      if (i >= 0) {
        return i;
      }
    }
    throw unexpected("String", b);
  }
  
  public short unpackShort()
    throws IOException
  {
    byte b = readByte();
    if (MessagePack.Code.isFixInt(b)) {
      return (short)b;
    }
    long l;
    int i;
    switch (b)
    {
    default: 
      throw unexpected("Integer", b);
    case -45: 
      l = readLong();
      if ((l >= -32768L) && (l <= 32767L)) {
        i = (int)l;
      }
      break;
    }
    for (;;)
    {
      return (short)i;
      throw overflowI64(l);
      i = readInt();
      if ((i >= 32768) && (i <= 32767)) {
        return (short)i;
      }
      throw overflowI32(i);
      return readShort();
      i = readByte();
      continue;
      l = readLong();
      if ((l >= 0L) && (l <= 32767L)) {
        break;
      }
      throw overflowU64(l);
      i = readInt();
      if ((i >= 0) && (i <= 32767)) {
        return (short)i;
      }
      throw overflowU32(i);
      short s = readShort();
      if (s >= 0) {
        return s;
      }
      throw overflowU16(s);
      i = readByte() & 0xFF;
    }
  }
  
  public String unpackString()
    throws IOException
  {
    int i = unpackRawStringHeader();
    if (i == 0) {
      return "";
    }
    if (i <= this.stringSizeLimit)
    {
      if (this.buffer.size() - this.position >= i) {
        return decodeStringFastPath(i);
      }
      resetDecoder();
      for (;;)
      {
        if (i > 0) {}
        try
        {
          int k = this.buffer.size() - this.position;
          if (k >= i)
          {
            this.decodeStringBuffer.append(decodeStringFastPath(i));
          }
          else
          {
            if (k == 0)
            {
              nextBuffer();
              continue;
            }
            ByteBuffer localByteBuffer = this.buffer.sliceAsByteBuffer(this.position, k);
            int j = localByteBuffer.position();
            this.decodeBuffer.clear();
            CoderResult localCoderResult = this.decoder.decode(localByteBuffer, this.decodeBuffer, false);
            int m = localByteBuffer.position() - j;
            this.position += m;
            j = i - m;
            this.decodeStringBuffer.append(this.decodeBuffer.flip());
            if (localCoderResult.isError()) {
              handleCoderError(localCoderResult);
            }
            i = j;
            if (!localCoderResult.isUnderflow()) {
              continue;
            }
            i = j;
            if (m >= k) {
              continue;
            }
            localByteBuffer = ByteBuffer.allocate(utf8MultibyteCharacterSize(this.buffer.getByte(this.position)));
            this.buffer.getBytes(this.position, this.buffer.size() - this.position, localByteBuffer);
            for (;;)
            {
              nextBuffer();
              i = localByteBuffer.remaining();
              if (this.buffer.size() >= i)
              {
                this.buffer.getBytes(0, i, localByteBuffer);
                this.position = i;
                localByteBuffer.position(0);
                this.decodeBuffer.clear();
                localCoderResult = this.decoder.decode(localByteBuffer, this.decodeBuffer, false);
                if (localCoderResult.isError()) {
                  handleCoderError(localCoderResult);
                }
                if ((!localCoderResult.isOverflow()) && ((!localCoderResult.isUnderflow()) || (localByteBuffer.position() >= localByteBuffer.limit())))
                {
                  i = j - localByteBuffer.limit();
                  this.decodeStringBuffer.append(this.decodeBuffer.flip());
                  break;
                }
                try
                {
                  localCoderResult.throwException();
                  throw new MessageFormatException("Unexpected UTF-8 multibyte sequence");
                }
                catch (Exception localException)
                {
                  throw new MessageFormatException("Unexpected UTF-8 multibyte sequence", localException);
                }
              }
              this.buffer.getBytes(0, this.buffer.size(), localException);
              this.position = this.buffer.size();
            }
          }
          String str = this.decodeStringBuffer.toString();
          return str;
        }
        catch (CharacterCodingException localCharacterCodingException)
        {
          throw new MessageStringCodingException(localCharacterCodingException);
        }
      }
    }
    throw new MessageSizeException(String.format("cannot unpack a String of size larger than %,d: %,d", new Object[] { Integer.valueOf(this.stringSizeLimit), Integer.valueOf(i) }), i);
  }
  
  public ImmutableValue unpackValue()
    throws IOException
  {
    Object localObject = getNextFormat();
    int k = 1.$SwitchMap$org$msgpack$value$ValueType[localObject.getValueType().ordinal()];
    int j = 0;
    int i = 0;
    switch (k)
    {
    default: 
      throw new MessageNeverUsedFormatException("Unknown value type");
    case 9: 
      localObject = unpackExtensionTypeHeader();
      return ValueFactory.newExtension(((ExtensionTypeHeader)localObject).getType(), readPayload(((ExtensionTypeHeader)localObject).getLength()));
    case 8: 
      j = unpackMapHeader() * 2;
      localObject = new Value[j];
      while (i < j)
      {
        localObject[i] = unpackValue();
        i += 1;
        localObject[i] = unpackValue();
        i += 1;
      }
      return ValueFactory.newMap((Value[])localObject, true);
    case 7: 
      k = unpackArrayHeader();
      localObject = new Value[k];
      i = j;
      while (i < k)
      {
        localObject[i] = unpackValue();
        i += 1;
      }
      return ValueFactory.newArray((Value[])localObject, true);
    case 6: 
      return ValueFactory.newBinary(readPayload(unpackBinaryHeader()), true);
    case 5: 
      return ValueFactory.newString(readPayload(unpackRawStringHeader()), true);
    case 4: 
      return ValueFactory.newFloat(unpackDouble());
    case 3: 
      if (1.$SwitchMap$org$msgpack$core$MessageFormat[localObject.ordinal()] != 16) {
        return ValueFactory.newInteger(unpackLong());
      }
      return ValueFactory.newInteger(unpackBigInteger());
    case 2: 
      return ValueFactory.newBoolean(unpackBoolean());
    }
    readByte();
    return ValueFactory.newNil();
  }
  
  public Variable unpackValue(Variable paramVariable)
    throws IOException
  {
    Object localObject = getNextFormat();
    int k = 1.$SwitchMap$org$msgpack$value$ValueType[localObject.getValueType().ordinal()];
    int j = 0;
    int i = 0;
    switch (k)
    {
    default: 
      throw new MessageFormatException("Unknown value type");
    case 9: 
      localObject = unpackExtensionTypeHeader();
      paramVariable.setExtensionValue(((ExtensionTypeHeader)localObject).getType(), readPayload(((ExtensionTypeHeader)localObject).getLength()));
      return paramVariable;
    case 8: 
      j = unpackMapHeader();
      localObject = new HashMap();
      while (i < j)
      {
        ((Map)localObject).put(unpackValue(), unpackValue());
        i += 1;
      }
      paramVariable.setMapValue((Map)localObject);
      return paramVariable;
    case 7: 
      k = unpackArrayHeader();
      localObject = new ArrayList(k);
      i = j;
      while (i < k)
      {
        ((List)localObject).add(unpackValue());
        i += 1;
      }
      paramVariable.setArrayValue((List)localObject);
      return paramVariable;
    case 6: 
      paramVariable.setBinaryValue(readPayload(unpackBinaryHeader()));
      return paramVariable;
    case 5: 
      paramVariable.setStringValue(readPayload(unpackRawStringHeader()));
      return paramVariable;
    case 4: 
      paramVariable.setFloatValue(unpackDouble());
      return paramVariable;
    case 3: 
      if (1.$SwitchMap$org$msgpack$core$MessageFormat[localObject.ordinal()] != 16)
      {
        paramVariable.setIntegerValue(unpackLong());
        return paramVariable;
      }
      paramVariable.setIntegerValue(unpackBigInteger());
      return paramVariable;
    case 2: 
      paramVariable.setBooleanValue(unpackBoolean());
      return paramVariable;
    }
    readByte();
    paramVariable.setNilValue();
    return paramVariable;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageUnpacker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */