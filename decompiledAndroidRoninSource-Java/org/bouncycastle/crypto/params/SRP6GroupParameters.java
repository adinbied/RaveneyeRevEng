package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class SRP6GroupParameters
{
  private BigInteger N;
  private BigInteger g;
  
  public SRP6GroupParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.N = paramBigInteger1;
    this.g = paramBigInteger2;
  }
  
  public BigInteger getG()
  {
    return this.g;
  }
  
  public BigInteger getN()
  {
    return this.N;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\SRP6GroupParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */