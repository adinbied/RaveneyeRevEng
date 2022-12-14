package org.msgpack.value.impl;

import org.msgpack.core.MessageTypeCastException;
import org.msgpack.value.ImmutableArrayValue;
import org.msgpack.value.ImmutableBinaryValue;
import org.msgpack.value.ImmutableBooleanValue;
import org.msgpack.value.ImmutableExtensionValue;
import org.msgpack.value.ImmutableFloatValue;
import org.msgpack.value.ImmutableIntegerValue;
import org.msgpack.value.ImmutableMapValue;
import org.msgpack.value.ImmutableNilValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.ImmutableRawValue;
import org.msgpack.value.ImmutableStringValue;
import org.msgpack.value.ImmutableValue;
import org.msgpack.value.ValueType;

abstract class AbstractImmutableValue
  implements ImmutableValue
{
  public ImmutableArrayValue asArrayValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableBinaryValue asBinaryValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableBooleanValue asBooleanValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableExtensionValue asExtensionValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableFloatValue asFloatValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableIntegerValue asIntegerValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableMapValue asMapValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableNilValue asNilValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableNumberValue asNumberValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableRawValue asRawValue()
  {
    throw new MessageTypeCastException();
  }
  
  public ImmutableStringValue asStringValue()
  {
    throw new MessageTypeCastException();
  }
  
  public boolean isArrayValue()
  {
    return getValueType().isArrayType();
  }
  
  public boolean isBinaryValue()
  {
    return getValueType().isBinaryType();
  }
  
  public boolean isBooleanValue()
  {
    return getValueType().isBooleanType();
  }
  
  public boolean isExtensionValue()
  {
    return getValueType().isExtensionType();
  }
  
  public boolean isFloatValue()
  {
    return getValueType().isFloatType();
  }
  
  public boolean isIntegerValue()
  {
    return getValueType().isIntegerType();
  }
  
  public boolean isMapValue()
  {
    return getValueType().isMapType();
  }
  
  public boolean isNilValue()
  {
    return getValueType().isNilType();
  }
  
  public boolean isNumberValue()
  {
    return getValueType().isNumberType();
  }
  
  public boolean isRawValue()
  {
    return getValueType().isRawType();
  }
  
  public boolean isStringValue()
  {
    return getValueType().isStringType();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\AbstractImmutableValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */