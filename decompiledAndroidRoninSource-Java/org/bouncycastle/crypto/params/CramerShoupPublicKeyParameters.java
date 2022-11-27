package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPublicKeyParameters
  extends CramerShoupKeyParameters
{
  private BigInteger c;
  private BigInteger d;
  private BigInteger h;
  
  public CramerShoupPublicKeyParameters(CramerShoupParameters paramCramerShoupParameters, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    super(false, paramCramerShoupParameters);
    this.c = paramBigInteger1;
    this.d = paramBigInteger2;
    this.h = paramBigInteger3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof CramerShoupPublicKeyParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    CramerShoupPublicKeyParameters localCramerShoupPublicKeyParameters = (CramerShoupPublicKeyParameters)paramObject;
    bool1 = bool2;
    if (localCramerShoupPublicKeyParameters.getC().equals(this.c))
    {
      bool1 = bool2;
      if (localCramerShoupPublicKeyParameters.getD().equals(this.d))
      {
        bool1 = bool2;
        if (localCramerShoupPublicKeyParameters.getH().equals(this.h))
        {
          bool1 = bool2;
          if (super.equals(paramObject)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public BigInteger getC()
  {
    return this.c;
  }
  
  public BigInteger getD()
  {
    return this.d;
  }
  
  public BigInteger getH()
  {
    return this.h;
  }
  
  public int hashCode()
  {
    return this.c.hashCode() ^ this.d.hashCode() ^ this.h.hashCode() ^ super.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\CramerShoupPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */