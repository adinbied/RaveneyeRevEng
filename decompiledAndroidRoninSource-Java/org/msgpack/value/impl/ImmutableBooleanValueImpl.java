package org.msgpack.value.impl;

import java.io.IOException;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.BooleanValue;
import org.msgpack.value.ImmutableBooleanValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableBooleanValueImpl
  extends AbstractImmutableValue
  implements ImmutableBooleanValue
{
  public static final ImmutableBooleanValue FALSE = new ImmutableBooleanValueImpl(false);
  public static final ImmutableBooleanValue TRUE = new ImmutableBooleanValueImpl(true);
  private final boolean value;
  
  private ImmutableBooleanValueImpl(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public ImmutableBooleanValue asBooleanValue()
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
    if (!((Value)paramObject).isBooleanValue()) {
      return false;
    }
    return this.value == ((Value)paramObject).asBooleanValue().getBoolean();
  }
  
  public boolean getBoolean()
  {
    return this.value;
  }
  
  public ValueType getValueType()
  {
    return ValueType.BOOLEAN;
  }
  
  public int hashCode()
  {
    if (this.value) {
      return 1231;
    }
    return 1237;
  }
  
  public ImmutableBooleanValue immutableValue()
  {
    return this;
  }
  
  public String toJson()
  {
    return Boolean.toString(this.value);
  }
  
  public String toString()
  {
    return toJson();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packBoolean(this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableBooleanValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */