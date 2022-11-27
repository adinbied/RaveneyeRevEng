package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class ECPrivateKeySpec
  extends ECKeySpec
{
  private BigInteger d;
  
  public ECPrivateKeySpec(BigInteger paramBigInteger, ECParameterSpec paramECParameterSpec)
  {
    super(paramECParameterSpec);
    this.d = paramBigInteger;
  }
  
  public BigInteger getD()
  {
    return this.d;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\ECPrivateKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */