package org.bouncycastle.jce.spec;

import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;

public class ElGamalParameterSpec
  implements AlgorithmParameterSpec
{
  private BigInteger g;
  private BigInteger p;
  
  public ElGamalParameterSpec(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this.p = paramBigInteger1;
    this.g = paramBigInteger2;
  }
  
  public BigInteger getG()
  {
    return this.g;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ElGamalParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */