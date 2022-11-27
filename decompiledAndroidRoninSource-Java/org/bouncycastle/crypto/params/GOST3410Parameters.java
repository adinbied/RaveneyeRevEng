package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class GOST3410Parameters
  implements CipherParameters
{
  private BigInteger a;
  private BigInteger p;
  private BigInteger q;
  private GOST3410ValidationParameters validation;
  
  public GOST3410Parameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.p = paramBigInteger1;
    this.q = paramBigInteger2;
    this.a = paramBigInteger3;
  }
  
  public GOST3410Parameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, GOST3410ValidationParameters paramGOST3410ValidationParameters)
  {
    this.a = paramBigInteger3;
    this.p = paramBigInteger1;
    this.q = paramBigInteger2;
    this.validation = paramGOST3410ValidationParameters;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof GOST3410Parameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (GOST3410Parameters)paramObject;
    bool1 = bool2;
    if (((GOST3410Parameters)paramObject).getP().equals(this.p))
    {
      bool1 = bool2;
      if (((GOST3410Parameters)paramObject).getQ().equals(this.q))
      {
        bool1 = bool2;
        if (((GOST3410Parameters)paramObject).getA().equals(this.a)) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public BigInteger getA()
  {
    return this.a;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public BigInteger getQ()
  {
    return this.q;
  }
  
  public GOST3410ValidationParameters getValidationParameters()
  {
    return this.validation;
  }
  
  public int hashCode()
  {
    return this.p.hashCode() ^ this.q.hashCode() ^ this.a.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\GOST3410Parameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */