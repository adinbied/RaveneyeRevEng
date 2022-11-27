package org.msgpack.value.impl;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
import org.msgpack.core.MessagePack;
import org.msgpack.core.MessageStringCodingException;
import org.msgpack.value.ImmutableRawValue;

public abstract class AbstractImmutableRawValue
  extends AbstractImmutableValue
  implements ImmutableRawValue
{
  private static final char[] HEX_TABLE = "0123456789ABCDEF".toCharArray();
  private volatile CharacterCodingException codingException;
  protected final byte[] data;
  private volatile String decodedStringCache;
  
  public AbstractImmutableRawValue(String paramString)
  {
    this.decodedStringCache = paramString;
    this.data = paramString.getBytes(MessagePack.UTF8);
  }
  
  public AbstractImmutableRawValue(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
  }
  
  static void appendJsonString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append("\"");
    int j = 0;
    while (j < paramString.length())
    {
      int i = paramString.charAt(j);
      if (i < 32) {
        switch (i)
        {
        case 11: 
        default: 
          escapeChar(paramStringBuilder, i);
          break;
        case 13: 
          paramStringBuilder.append("\\r");
          break;
        case 12: 
          paramStringBuilder.append("\\f");
          break;
        case 10: 
          paramStringBuilder.append("\\n");
          break;
        case 9: 
          paramStringBuilder.append("\\t");
          break;
        case 8: 
          paramStringBuilder.append("\\b");
          break;
        }
      } else if (i <= 127)
      {
        if (i != 34)
        {
          if (i != 92) {
            paramStringBuilder.append(i);
          } else {
            paramStringBuilder.append("\\\\");
          }
        }
        else {
          paramStringBuilder.append("\\\"");
        }
      }
      else if ((i >= 55296) && (i <= 57343)) {
        escapeChar(paramStringBuilder, i);
      } else {
        paramStringBuilder.append(i);
      }
      j += 1;
    }
    paramStringBuilder.append("\"");
  }
  
  private void decodeString()
  {
    synchronized (this.data)
    {
      if (this.decodedStringCache != null) {
        return;
      }
      try
      {
        this.decodedStringCache = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPORT).onUnmappableCharacter(CodingErrorAction.REPORT).decode(asByteBuffer()).toString();
      }
      catch (CharacterCodingException localCharacterCodingException1) {}
      try
      {
        this.decodedStringCache = MessagePack.UTF8.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE).decode(asByteBuffer()).toString();
        this.codingException = localCharacterCodingException1;
        return;
      }
      catch (CharacterCodingException localCharacterCodingException2)
      {
        throw new MessageStringCodingException(localCharacterCodingException2);
      }
    }
  }
  
  private static void escapeChar(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder.append("\\u");
    paramStringBuilder.append(HEX_TABLE[(paramInt >> 12 & 0xF)]);
    paramStringBuilder.append(HEX_TABLE[(paramInt >> 8 & 0xF)]);
    paramStringBuilder.append(HEX_TABLE[(paramInt >> 4 & 0xF)]);
    paramStringBuilder.append(HEX_TABLE[(paramInt & 0xF)]);
  }
  
  public byte[] asByteArray()
  {
    byte[] arrayOfByte = this.data;
    return Arrays.copyOf(arrayOfByte, arrayOfByte.length);
  }
  
  public ByteBuffer asByteBuffer()
  {
    return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
  }
  
  public ImmutableRawValue asRawValue()
  {
    return this;
  }
  
  public String asString()
  {
    if (this.decodedStringCache == null) {
      decodeString();
    }
    if (this.codingException == null) {
      return this.decodedStringCache;
    }
    throw new MessageStringCodingException(this.codingException);
  }
  
  public String toJson()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendJsonString(localStringBuilder, toString());
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    if (this.decodedStringCache == null) {
      decodeString();
    }
    return this.decodedStringCache;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\AbstractImmutableRawValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */