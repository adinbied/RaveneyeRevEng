package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import org.bouncycastle.crypto.CipherParameters;

public class DHParameters
  implements CipherParameters
{
  private static final int DEFAULT_MINIMUM_LENGTH = 160;
  private BigInteger g;
  private BigInteger j;
  private int l;
  private int m;
  private BigInteger p;
  private BigInteger q;
  private DHValidationParameters validation;
  
  public DHParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    this(paramBigInteger1, paramBigInteger2, null, 0);
  }
  
  public DHParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, 0);
  }
  
  public DHParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, int paramInt)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, getDefaultMParam(paramInt), paramInt, null, null);
  }
  
  public DHParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, int paramInt1, int paramInt2)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, paramInt1, paramInt2, null, null);
  }
  
  public DHParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, int paramInt1, int paramInt2, BigInteger paramBigInteger4, DHValidationParameters paramDHValidationParameters)
  {
    if (paramInt2 != 0) {
      if (paramInt2 <= paramBigInteger1.bitLength())
      {
        if (paramInt2 < paramInt1) {
          throw new IllegalArgumentException("when l value specified, it may not be less than m value");
        }
      }
      else {
        throw new IllegalArgumentException("when l value specified, it must satisfy 2^(l-1) <= p");
      }
    }
    this.g = paramBigInteger2;
    this.p = paramBigInteger1;
    this.q = paramBigInteger3;
    this.m = paramInt1;
    this.l = paramInt2;
    this.j = paramBigInteger4;
    this.validation = paramDHValidationParameters;
  }
  
  public DHParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, BigInteger paramBigInteger4, DHValidationParameters paramDHValidationParameters)
  {
    this(paramBigInteger1, paramBigInteger2, paramBigInteger3, 160, 0, paramBigInteger4, paramDHValidationParameters);
  }
  
  private static int getDefaultMParam(int paramInt)
  {
    if (paramInt == 0) {
      return 160;
    }
    if (paramInt < 160) {
      return paramInt;
    }
    return 160;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (DHParameters)paramObject;
    if (getQ() != null)
    {
      if (!getQ().equals(((DHParameters)paramObject).getQ())) {
        return false;
      }
    }
    else if (((DHParameters)paramObject).getQ() != null) {
      return false;
    }
    bool1 = bool2;
    if (((DHParameters)paramObject).getP().equals(this.p))
    {
      bool1 = bool2;
      if (((DHParameters)paramObject).getG().equals(this.g)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public BigInteger getG()
  {
    return this.g;
  }
  
  public BigInteger getJ()
  {
    return this.j;
  }
  
  public int getL()
  {
    return this.l;
  }
  
  public int getM()
  {
    return this.m;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public BigInteger getQ()
  {
    return this.q;
  }
  
  public DHValidationParameters getValidationParameters()
  {
    return this.validation;
  }
  
  public int hashCode()
  {
    int k = getP().hashCode();
    int n = getG().hashCode();
    int i;
    if (getQ() != null) {
      i = getQ().hashCode();
    } else {
      i = 0;
    }
    return k ^ n ^ i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DHParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */