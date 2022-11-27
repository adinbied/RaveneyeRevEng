package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;

public class CramerShoupParameters
  implements CipherParameters
{
  private Digest H;
  private BigInteger g1;
  private BigInteger g2;
  private BigInteger p;
  
  public CramerShoupParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, Digest paramDigest)
  {
    this.p = paramBigInteger1;
    this.g1 = paramBigInteger2;
    this.g2 = paramBigInteger3;
    this.H = paramDigest;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (CramerShoupParameters)paramObject;
    bool1 = bool2;
    if (((CramerShoupParameters)paramObject).getP().equals(this.p))
    {
      bool1 = bool2;
      if (((CramerShoupParameters)paramObject).getG1().equals(this.g1))
      {
        bool1 = bool2;
        if (((CramerShoupParameters)paramObject).getG2().equals(this.g2)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public BigInteger getG1()
  {
    return this.g1;
  }
  
  public BigInteger getG2()
  {
    return this.g2;
  }
  
  public Digest getH()
  {
    this.H.reset();
    return this.H;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public int hashCode()
  {
    return getP().hashCode() ^ getG1().hashCode() ^ getG2().hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\CramerShoupParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */