package org.msgpack.value.impl;

import java.io.IOException;
import java.math.BigInteger;
import org.msgpack.core.MessageFormat;
import org.msgpack.core.MessageIntegerOverflowException;
import org.msgpack.core.MessagePacker;
import org.msgpack.value.ImmutableIntegerValue;
import org.msgpack.value.ImmutableNumberValue;
import org.msgpack.value.IntegerValue;
import org.msgpack.value.Value;
import org.msgpack.value.ValueType;

public class ImmutableLongValueImpl
  extends AbstractImmutableValue
  implements ImmutableIntegerValue
{
  private static final long BYTE_MAX = 127L;
  private static final long BYTE_MIN = -128L;
  private static final long INT_MAX = 2147483647L;
  private static final long INT_MIN = -2147483648L;
  private static final long SHORT_MAX = 32767L;
  private static final long SHORT_MIN = -32768L;
  private final long value;
  
  public ImmutableLongValueImpl(long paramLong)
  {
    this.value = paramLong;
  }
  
  public BigInteger asBigInteger()
  {
    return BigInteger.valueOf(this.value);
  }
  
  public byte asByte()
  {
    if (isInByteRange()) {
      return (byte)(int)this.value;
    }
    throw new MessageIntegerOverflowException(this.value);
  }
  
  public int asInt()
  {
    if (isInIntRange()) {
      return (int)this.value;
    }
    throw new MessageIntegerOverflowException(this.value);
  }
  
  public ImmutableIntegerValue asIntegerValue()
  {
    return this;
  }
  
  public long asLong()
  {
    return this.value;
  }
  
  public ImmutableNumberValue asNumberValue()
  {
    return this;
  }
  
  public short asShort()
  {
    if (isInShortRange()) {
      return (short)(int)this.value;
    }
    throw new MessageIntegerOverflowException(this.value);
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
    if (!((Value)paramObject).isIntegerValue()) {
      return false;
    }
    paramObject = ((Value)paramObject).asIntegerValue();
    if (!((IntegerValue)paramObject).isInLongRange()) {
      return false;
    }
    return this.value == ((IntegerValue)paramObject).toLong();
  }
  
  public ValueType getValueType()
  {
    return ValueType.INTEGER;
  }
  
  public int hashCode()
  {
    long l = this.value;
    if ((-2147483648L <= l) && (l <= 2147483647L)) {
      return (int)l;
    }
    l = this.value;
    return (int)(l ^ l >>> 32);
  }
  
  public ImmutableIntegerValue immutableValue()
  {
    return this;
  }
  
  public boolean isInByteRange()
  {
    long l = this.value;
    return (-128L <= l) && (l <= 127L);
  }
  
  public boolean isInIntRange()
  {
    long l = this.value;
    return (-2147483648L <= l) && (l <= 2147483647L);
  }
  
  public boolean isInLongRange()
  {
    return true;
  }
  
  public boolean isInShortRange()
  {
    long l = this.value;
    return (-32768L <= l) && (l <= 32767L);
  }
  
  public MessageFormat mostSuccinctMessageFormat()
  {
    return ImmutableBigIntegerValueImpl.mostSuccinctMessageFormat(this);
  }
  
  public BigInteger toBigInteger()
  {
    return BigInteger.valueOf(this.value);
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
    return Long.toString(this.value);
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
    return toJson();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packLong(this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableLongValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */