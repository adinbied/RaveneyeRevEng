package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class CramerShoupPrivateKeyParameters
  extends CramerShoupKeyParameters
{
  private CramerShoupPublicKeyParameters pk;
  private BigInteger x1;
  private BigInteger x2;
  private BigInteger y1;
  private BigInteger y2;
  private BigInteger z;
  
  public CramerShoupPrivateKeyParameters(CramerShoupParameters paramCramerShoupParameters, BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, BigInteger paramBigInteger5)
  {
    super(true, paramCramerShoupParameters);
    this.x1 = paramBigInteger1;
    this.x2 = paramBigInteger2;
    this.y1 = paramBigInteger3;
    this.y2 = paramBigInteger4;
    this.z = paramBigInteger5;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof CramerShoupPrivateKeyParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    CramerShoupPrivateKeyParameters localCramerShoupPrivateKeyParameters = (CramerShoupPrivateKeyParameters)paramObject;
    bool1 = bool2;
    if (localCramerShoupPrivateKeyParameters.getX1().equals(this.x1))
    {
      bool1 = bool2;
      if (localCramerShoupPrivateKeyParameters.getX2().equals(this.x2))
      {
        bool1 = bool2;
        if (localCramerShoupPrivateKeyParameters.getY1().equals(this.y1))
        {
          bool1 = bool2;
          if (localCramerShoupPrivateKeyParameters.getY2().equals(this.y2))
          {
            bool1 = bool2;
            if (localCramerShoupPrivateKeyParameters.getZ().equals(this.z))
            {
              bool1 = bool2;
              if (super.equals(paramObject)) {
                bool1 = true;
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public CramerShoupPublicKeyParameters getPk()
  {
    return this.pk;
  }
  
  public BigInteger getX1()
  {
    return this.x1;
  }
  
  public BigInteger getX2()
  {
    return this.x2;
  }
  
  public BigInteger getY1()
  {
    return this.y1;
  }
  
  public BigInteger getY2()
  {
    return this.y2;
  }
  
  public BigInteger getZ()
  {
    return this.z;
  }
  
  public int hashCode()
  {
    return this.x1.hashCode() ^ this.x2.hashCode() ^ this.y1.hashCode() ^ this.y2.hashCode() ^ this.z.hashCode() ^ super.hashCode();
  }
  
  public void setPk(CramerShoupPublicKeyParameters paramCramerShoupPublicKeyParameters)
  {
    this.pk = paramCramerShoupPublicKeyParameters;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\CramerShoupPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */