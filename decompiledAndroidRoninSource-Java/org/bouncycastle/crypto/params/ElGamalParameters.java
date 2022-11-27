package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class ElGamalParameters
  implements CipherParameters
{
  private BigInteger g;
  private int l;
  private BigInteger p;
  
  public ElGamalParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramBigInteger1, paramBigInteger2, 0);
  }
  
  public ElGamalParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt)
  {
    this.g = paramBigInteger2;
    this.p = paramBigInteger1;
    this.l = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ElGamalParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (ElGamalParameters)paramObject;
    bool1 = bool2;
    if (((ElGamalParameters)paramObject).getP().equals(this.p))
    {
      bool1 = bool2;
      if (((ElGamalParameters)paramObject).getG().equals(this.g))
      {
        bool1 = bool2;
        if (((ElGamalParameters)paramObject).getL() == this.l) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public BigInteger getG()
  {
    return this.g;
  }
  
  public int getL()
  {
    return this.l;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public int hashCode()
  {
    return (getP().hashCode() ^ getG().hashCode()) + this.l;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ElGamalParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */