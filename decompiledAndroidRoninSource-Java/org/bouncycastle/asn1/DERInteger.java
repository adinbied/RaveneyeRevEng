package org.bouncycastle.asn1;

import java.math.BigInteger;

public class DERInteger
  extends ASN1Integer
{
  public DERInteger(long paramLong)
  {
    super(paramLong);
  }
  
  public DERInteger(BigInteger paramBigInteger)
  {
    super(paramBigInteger);
  }
  
  public DERInteger(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte, true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\DERInteger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */