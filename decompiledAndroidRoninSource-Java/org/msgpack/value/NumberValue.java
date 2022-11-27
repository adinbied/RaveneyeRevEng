package org.msgpack.value;

import java.math.BigInteger;

public abstract interface NumberValue
  extends Value
{
  public abstract BigInteger toBigInteger();
  
  public abstract byte toByte();
  
  public abstract double toDouble();
  
  public abstract float toFloat();
  
  public abstract int toInt();
  
  public abstract long toLong();
  
  public abstract short toShort();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\NumberValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */