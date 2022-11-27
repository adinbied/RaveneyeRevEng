package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPublicKeyParameters
  extends ElGamalKeyParameters
{
  private BigInteger y;
  
  public ElGamalPublicKeyParameters(BigInteger paramBigInteger, ElGamalParameters paramElGamalParameters)
  {
    super(false, paramElGamalParameters);
    this.y = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof ElGamalPublicKeyParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (((ElGamalPublicKeyParameters)paramObject).getY().equals(this.y))
    {
      bool1 = bool2;
      if (super.equals(paramObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    return this.y.hashCode() ^ super.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ElGamalPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */