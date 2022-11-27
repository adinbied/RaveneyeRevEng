package org.msgpack.value;

import java.io.IOException;
import org.msgpack.core.MessagePacker;

public abstract interface Value
{
  public abstract ArrayValue asArrayValue();
  
  public abstract BinaryValue asBinaryValue();
  
  public abstract BooleanValue asBooleanValue();
  
  public abstract ExtensionValue asExtensionValue();
  
  public abstract FloatValue asFloatValue();
  
  public abstract IntegerValue asIntegerValue();
  
  public abstract MapValue asMapValue();
  
  public abstract NilValue asNilValue();
  
  public abstract NumberValue asNumberValue();
  
  public abstract RawValue asRawValue();
  
  public abstract StringValue asStringValue();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract ValueType getValueType();
  
  public abstract ImmutableValue immutableValue();
  
  public abstract boolean isArrayValue();
  
  public abstract boolean isBinaryValue();
  
  public abstract boolean isBooleanValue();
  
  public abstract boolean isExtensionValue();
  
  public abstract boolean isFloatValue();
  
  public abstract boolean isIntegerValue();
  
  public abstract boolean isMapValue();
  
  public abstract boolean isNilValue();
  
  public abstract boolean isNumberValue();
  
  public abstract boolean isRawValue();
  
  public abstract boolean isStringValue();
  
  public abstract String toJson();
  
  public abstract void writeTo(MessagePacker paramMessagePacker)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\Value.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */