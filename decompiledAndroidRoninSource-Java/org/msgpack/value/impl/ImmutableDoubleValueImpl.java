package org.msgpack.value.impl;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.FloatValue;
import org.msgpack.value.ImmutableFloatValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableDoubleValueImpl
  extends AbstractImmutableValue
  implements ImmutableFloatValue
{
  private final double value;
  
  public ImmutableDoubleValueImpl(double paramDouble)
  {
    this.value = paramDouble;
  }
  
  public ImmutableFloatValue asFloatValue()
  {
    return this;
  }
  
  public ImmutableNumberValue asNumberValue()
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
    if (!((Value)paramObject).isFloatValue()) {
      return false;
    }
    return this.value == ((Value)paramObject).asFloatValue().toDouble();
  }
  
  public ValueType getValueType()
  {
    return ValueType.FLOAT;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.value);
    return (int)(l ^ l >>> 32);
  }
  
  public ImmutableDoubleValueImpl immutableValue()
  {
    return this;
  }
  
  public BigInteger toBigInteger()
  {
    return new BigDecimal(this.value).toBigInteger();
  }
  
  public byte toByte()
  {
    return (byte)(int)this.value;
  }
  
  public double toDouble()
  {
    return this.value;
  }
  
  public float toFloat()
  {
    return (float)this.value;
  }
  
  public int toInt()
  {
    return (int)this.value;
  }
  
  public String toJson()
  {
    if ((!Double.isNaN(this.value)) && (!Double.isInfinite(this.value))) {
      return Double.toString(this.value);
    }
    return "null";
  }
  
  public long toLong()
  {
    return this.value;
  }
  
  public short toShort()
  {
    return (short)(int)this.value;
  }
  
  public String toString()
  {
    return Double.toString(this.value);
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packDouble(this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableDoubleValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */