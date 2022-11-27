package org.msgpack.value.impl;

import java.io.IOException;
import java.util.Arrays;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.StringValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableStringValueImpl
  extends AbstractImmutableRawValue
  implements ImmutableStringValue
{
  public ImmutableStringValueImpl(String paramString)
  {
    super(paramString);
  }
  
  public ImmutableStringValueImpl(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public ImmutableStringValue asStringValue()
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
    if (!((Value)paramObject).isStringValue()) {
      return false;
    }
    if ((paramObject instanceof ImmutableStringValueImpl))
    {
      paramObject = (ImmutableStringValueImpl)paramObject;
      return Arrays.equals(this.data, ((ImmutableStringValueImpl)paramObject).data);
    }
    return Arrays.equals(this.data, ((Value)paramObject).asStringValue().asByteArray());
  }
  
  public ValueType getValueType()
  {
    return ValueType.STRING;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.data);
  }
  
  public ImmutableStringValue immutableValue()
  {
    return this;
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packRawStringHeader(this.data.length);
    paramMessagePacker.writePayload(this.data);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableStringValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */