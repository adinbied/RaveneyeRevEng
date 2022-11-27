package org.msgpack.value;

import java.math.BigInteger;
import org.msgpack.core.MessageFormat;

public abstract interface IntegerValue
  extends NumberValue
{
  public abstract BigInteger asBigInteger();
  
  public abstract byte asByte();
  
  public abstract int asInt();
  
  public abstract long asLong();
  
  public abstract short asShort();
  
  public abstract boolean isInByteRange();
  
  public abstract boolean isInIntRange();
  
  public abstract boolean isInLongRange();
  
  public abstract boolean isInShortRange();
  
  public abstract MessageFormat mostSuccinctMessageFormat();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\IntegerValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */