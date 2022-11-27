package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class DSAParameters
  implements CipherParameters
{
  private BigInteger g;
  private BigInteger p;
  private BigInteger q;
  private DSAValidationParameters validation;
  
  public DSAParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.g = paramBigInteger3;
    this.p = paramBigInteger1;
    this.q = paramBigInteger2;
  }
  
  public DSAParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, DSAValidationParameters paramDSAValidationParameters)
  {
    this.g = paramBigInteger3;
    this.p = paramBigInteger1;
    this.q = paramBigInteger2;
    this.validation = paramDSAValidationParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DSAParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DSAParameters)paramObject;
    bool1 = bool2;
    if (((DSAParameters)paramObject).getP().equals(this.p))
    {
      bool1 = bool2;
      if (((DSAParameters)paramObject).getQ().equals(this.q))
      {
        bool1 = bool2;
        if (((DSAParameters)paramObject).getG().equals(this.g)) {
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
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public BigInteger getQ()
  {
    return this.q;
  }
  
  public DSAValidationParameters getValidationParameters()
  {
    return this.validation;
  }
  
  public int hashCode()
  {
    return getP().hashCode() ^ getQ().hashCode() ^ getG().hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */