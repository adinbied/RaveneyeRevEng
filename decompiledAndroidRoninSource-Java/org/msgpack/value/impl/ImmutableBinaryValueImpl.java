package org.msgpack.value.impl;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.BinaryValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableBinaryValueImpl
  extends AbstractImmutableRawValue
  implements ImmutableBinaryValue
{
  public ImmutableBinaryValueImpl(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public ImmutableBinaryValue asBinaryValue()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Value)) {
      return false;
    }
    paramObject = (Value)paramObject;
    if (!((Value)paramObject).isBinaryValue()) {
      return false;
    }
    if ((paramObject instanceof ImmutableBinaryValueImpl))
    {
      paramObject = (ImmutableBinaryValueImpl)paramObject;
      return Arrays.equals(this.data, ((ImmutableBinaryValueImpl)paramObject).data);
    }
    return Arrays.equals(this.data, ((Value)paramObject).asBinaryValue().asByteArray());
  }
  
  public ValueType getValueType()
  {
    return ValueType.BINARY;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.data);
  }
  
  public ImmutableBinaryValue immutableValue()
  {
    return this;
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packBinaryHeader(this.data.length);
    paramMessagePacker.writePayload(this.data);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableBinaryValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */