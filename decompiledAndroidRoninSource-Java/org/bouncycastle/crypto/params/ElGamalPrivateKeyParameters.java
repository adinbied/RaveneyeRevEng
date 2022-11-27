package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ElGamalPrivateKeyParameters
  extends ElGamalKeyParameters
{
  private BigInteger x;
  
  public ElGamalPrivateKeyParameters(BigInteger paramBigInteger, ElGamalParameters paramElGamalParameters)
  {
    super(true, paramElGamalParameters);
    this.x = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ElGamalPrivateKeyParameters)) {
      return false;
    }
    if (!((ElGamalPrivateKeyParameters)paramObject).getX().equals(this.x)) {
      return false;
    }
    return super.equals(paramObject);
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return getX().hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ElGamalPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */