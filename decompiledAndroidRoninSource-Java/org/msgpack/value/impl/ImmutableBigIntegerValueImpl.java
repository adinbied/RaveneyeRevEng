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

public class ImmutableBigIntegerValueImpl
  extends AbstractImmutableValue
  implements ImmutableIntegerValue
{
  private static final BigInteger BYTE_MAX;
  private static final BigInteger BYTE_MIN = BigInteger.valueOf(-128L);
  private static final BigInteger INT_MAX;
  private static final BigInteger INT_MIN;
  private static final BigInteger LONG_MAX = BigInteger.valueOf(Long.MAX_VALUE);
  private static final BigInteger LONG_MIN;
  private static final BigInteger SHORT_MAX;
  private static final BigInteger SHORT_MIN;
  private final BigInteger value;
  
  static
  {
    BYTE_MAX = BigInteger.valueOf(127L);
    SHORT_MIN = BigInteger.valueOf(-32768L);
    SHORT_MAX = BigInteger.valueOf(32767L);
    INT_MIN = BigInteger.valueOf(-2147483648L);
    INT_MAX = BigInteger.valueOf(2147483647L);
    LONG_MIN = BigInteger.valueOf(Long.MIN_VALUE);
  }
  
  public ImmutableBigIntegerValueImpl(BigInteger paramBigInteger)
  {
    this.value = paramBigInteger;
  }
  
  public static MessageFormat mostSuccinctMessageFormat(IntegerValue paramIntegerValue)
  {
    if (paramIntegerValue.isInByteRange()) {
      return MessageFormat.INT8;
    }
    if (paramIntegerValue.isInShortRange()) {
      return MessageFormat.INT16;
    }
    if (paramIntegerValue.isInIntRange()) {
      return MessageFormat.INT32;
    }
    if (paramIntegerValue.isInLongRange()) {
      return MessageFormat.INT64;
    }
    return MessageFormat.UINT64;
  }
  
  public BigInteger asBigInteger()
  {
    return this.value;
  }
  
  public byte asByte()
  {
    if (isInByteRange()) {
      return this.value.byteValue();
    }
    throw new MessageIntegerOverflowException(this.value);
  }
  
  public int asInt()
  {
    if (isInIntRange()) {
      return this.value.intValue();
    }
    throw new MessageIntegerOverflowException(this.value);
  }
  
  public ImmutableIntegerValue asIntegerValue()
  {
    return this;
  }
  
  public long asLong()
  {
    if (isInLongRange()) {
      return this.value.longValue();
    }
    throw new MessageIntegerOverflowException(this.value);
  }
  
  public ImmutableNumberValue asNumberValue()
  {
    return this;
  }
  
  public short asShort()
  {
    if (isInShortRange()) {
      return this.value.shortValue();
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
    return this.value.equals(((IntegerValue)paramObject).toBigInteger());
  }
  
  public ValueType getValueType()
  {
    return ValueType.INTEGER;
  }
  
  public int hashCode()
  {
    if ((INT_MIN.compareTo(this.value) <= 0) && (this.value.compareTo(INT_MAX) <= 0)) {}
    for (long l = this.value.longValue();; l ^= l >>> 32)
    {
      return (int)l;
      if ((LONG_MIN.compareTo(this.value) > 0) || (this.value.compareTo(LONG_MAX) > 0)) {
        break;
      }
      l = this.value.longValue();
    }
    return this.value.hashCode();
  }
  
  public ImmutableIntegerValue immutableValue()
  {
    return this;
  }
  
  public boolean isInByteRange()
  {
    return (this.value.compareTo(BYTE_MIN) >= 0) && (this.value.compareTo(BYTE_MAX) <= 0);
  }
  
  public boolean isInIntRange()
  {
    return (this.value.compareTo(INT_MIN) >= 0) && (this.value.compareTo(INT_MAX) <= 0);
  }
  
  public boolean isInLongRange()
  {
    return (this.value.compareTo(LONG_MIN) >= 0) && (this.value.compareTo(LONG_MAX) <= 0);
  }
  
  public boolean isInShortRange()
  {
    return (this.value.compareTo(SHORT_MIN) >= 0) && (this.value.compareTo(SHORT_MAX) <= 0);
  }
  
  public MessageFormat mostSuccinctMessageFormat()
  {
    return mostSuccinctMessageFormat(this);
  }
  
  public BigInteger toBigInteger()
  {
    return this.value;
  }
  
  public byte toByte()
  {
    return this.value.byteValue();
  }
  
  public double toDouble()
  {
    return this.value.doubleValue();
  }
  
  public float toFloat()
  {
    return this.value.floatValue();
  }
  
  public int toInt()
  {
    return this.value.intValue();
  }
  
  public String toJson()
  {
    return this.value.toString();
  }
  
  public long toLong()
  {
    return this.value.longValue();
  }
  
  public short toShort()
  {
    return this.value.shortValue();
  }
  
  public String toString()
  {
    return toJson();
  }
  
  public void writeTo(MessagePacker paramMessagePacker)
    throws IOException
  {
    paramMessagePacker.packBigInteger(this.value);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\impl\ImmutableBigIntegerValueImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */