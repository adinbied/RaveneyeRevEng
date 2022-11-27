package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class RSAPrivateCrtKeyParameters
  extends RSAKeyParameters
{
  private BigInteger dP;
  private BigInteger dQ;
  private BigInteger e;
  private BigInteger p;
  private BigInteger q;
  private BigInteger qInv;
  
  public RSAPrivateCrtKeyParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5, BigInteger paramBigInteger6, BigInteger paramBigInteger7, BigInteger paramBigInteger8)
  {
    super(true, paramBigInteger1, paramBigInteger3);
    this.e = paramBigInteger2;
    this.p = paramBigInteger4;
    this.q = paramBigInteger5;
    this.dP = paramBigInteger6;
    this.dQ = paramBigInteger7;
    this.qInv = paramBigInteger8;
  }
  
  public BigInteger getDP()
  {
    return this.dP;
  }
  
  public BigInteger getDQ()
  {
    return this.dQ;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public BigInteger getPublicExponent()
  {
    return this.e;
  }
  
  public BigInteger getQ()
  {
    return this.q;
  }
  
  public BigInteger getQInv()
  {
    return this.qInv;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\RSAPrivateCrtKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */