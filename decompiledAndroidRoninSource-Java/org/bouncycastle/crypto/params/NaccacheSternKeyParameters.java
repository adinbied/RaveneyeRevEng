package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class NaccacheSternKeyParameters
  extends AsymmetricKeyParameter
{
  private BigInteger g;
  int lowerSigmaBound;
  private BigInteger n;
  
  public NaccacheSternKeyParameters(boolean paramBoolean, BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    super(paramBoolean);
    this.g = paramBigInteger1;
    this.n = paramBigInteger2;
    this.lowerSigmaBound = paramInt;
  }
  
  public BigInteger getG()
  {
    return this.g;
  }
  
  public int getLowerSigmaBound()
  {
    return this.lowerSigmaBound;
  }
  
  public BigInteger getModulus()
  {
    return this.n;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\NaccacheSternKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */