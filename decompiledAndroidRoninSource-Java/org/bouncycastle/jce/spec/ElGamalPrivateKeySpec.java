package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ElGamalPrivateKeySpec
  extends ElGamalKeySpec
{
  private BigInteger x;
  
  public ElGamalPrivateKeySpec(BigInteger paramBigInteger, ElGamalParameterSpec paramElGamalParameterSpec)
  {
    super(paramElGamalParameterSpec);
    this.x = paramBigInteger;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ElGamalPrivateKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */