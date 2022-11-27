package org.msgpack.core;

import java.math.BigInteger;

public class MessageIntegerOverflowException
  extends MessageTypeException
{
  private final BigInteger bigInteger;
  
  public MessageIntegerOverflowException(long paramLong)
  {
    this(BigInteger.valueOf(paramLong));
  }
  
  public MessageIntegerOverflowException(String paramString, BigInteger paramBigInteger)
  {
    super(paramString);
    this.bigInteger = paramBigInteger;
  }
  
  public MessageIntegerOverflowException(BigInteger paramBigInteger)
  {
    this.bigInteger = paramBigInteger;
  }
  
  public BigInteger getBigInteger()
  {
    return this.bigInteger;
  }
  
  public String getMessage()
  {
    return this.bigInteger.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\MessageIntegerOverflowException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */