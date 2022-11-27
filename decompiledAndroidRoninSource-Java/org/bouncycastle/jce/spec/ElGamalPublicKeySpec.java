package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPublicKeySpec
  extends ElGamalKeySpec
{
  private BigInteger y;
  
  public ElGamalPublicKeySpec(BigInteger paramBigInteger, ElGamalParameterSpec paramElGamalParameterSpec)
  {
    super(paramElGamalParameterSpec);
    this.y = paramBigInteger;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ElGamalPublicKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */