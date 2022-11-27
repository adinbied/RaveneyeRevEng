package org.msgpack.value.impl;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ExtensionValue;
import org.msgpack.value.ImmutableExtensionValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableExtensionValueImpl
  extends AbstractImmutableValue
  implements ImmutableExtensionValue
{
  private final byte[] data;
  private final byte type;
  
  public ImmutableExtensionValueImpl(byte paramByte, byte[] paramArrayOfByte)
  {
    this.type = paramByte;
    this.data = paramArrayOfByte;
  }
  
  public ImmutableExtensionValue asExtensionValue()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Value)) {
      return false;
    }
    paramObject = (Value)paramObject;
    if (!((Value)paramObject).isExtensionValue()) {
      return false;
    }
    paramObject = ((Value)paramObject).asExtensionValue();
    return (this.type == ((ExtensionValue)paramObject).getType()) && (Arrays.equals(this.data, ((ExtensionValue)paramObject).getData()));
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public byte getType()
  {
    return this.type;
  }
  
  public ValueType getValueType()
  {
    return ValueType.EXTENSION;
  }
  
  public int hashCode()
  {
    int j = this.type + 31;
    byte[] arrayOfByte = this.data;
    int k = arrayOfByte.length;
    int i = 0;
    while (i < k)
    {
      j = j * 31 + arrayOfByte[i];
      i += 1;
    }
    return j;
  }
  
  public ImmutableExtensionValue immutableValue()
  {
    return this;
  }
  
  public String toJson()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    localStringBuilder.append(Byte.toString(this.type));
    localStringBuilder.append(",\"");
    byte[] arrayOfByte = this.data;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toString(arrayOfByte[i], 16));
      i += 1;
    }
    localStringBuilder.append("\"]");
    return localStringBuilder.toString();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('(');
    localStringBuilder.append(Byte.toString(this.type));
    localStringBuilder.append(",0x");
    byte[] arrayOfByte = this.data;
    int j = arrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(Integer.toString(arrayOfByte[i], 16));
      i += 1;
    }
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packExtensionTypeHeader(this.type, this.data.length);
    paramMessagePacker.writePayload(this.data);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableExtensionValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */