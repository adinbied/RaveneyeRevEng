package org.msgpack.value.impl;

import java.io.IOException;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableNilValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableNilValueImpl
  extends AbstractImmutableValue
  implements ImmutableNilValue
{
  private static ImmutableNilValue instance = new ImmutableNilValueImpl();
  
  public static ImmutableNilValue get()
  {
    return instance;
  }
  
  public ImmutableNilValue asNilValue()
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
    return ((Value)paramObject).isNilValue();
  }
  
  public ValueType getValueType()
  {
    return ValueType.NIL;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public ImmutableNilValue immutableValue()
  {
    return this;
  }
  
  public String toJson()
  {
    return "null";
  }
  
  public String toString()
  {
    return toJson();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packNil();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableNilValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */