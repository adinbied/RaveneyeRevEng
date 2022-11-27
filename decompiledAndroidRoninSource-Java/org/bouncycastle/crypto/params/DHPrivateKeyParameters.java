package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPrivateKeyParameters
  extends DHKeyParameters
{
  private BigInteger x;
  
  public DHPrivateKeyParameters(BigInteger paramBigInteger, DHParameters paramDHParameters)
  {
    super(true, paramDHParameters);
    this.x = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHPrivateKeyParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (((DHPrivateKeyParameters)paramObject).getX().equals(this.x))
    {
      bool1 = bool2;
      if (super.equals(paramObject)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
  
  public int hashCode()
  {
    return this.x.hashCode() ^ super.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DHPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */