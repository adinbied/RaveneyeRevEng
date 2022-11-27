package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DHPublicKeyParameters
  extends DHKeyParameters
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private BigInteger y = validate(paramBigInteger, paramDHParameters);
  
  public DHPublicKeyParameters(BigInteger paramBigInteger, DHParameters paramDHParameters)
  {
    super(false, paramDHParameters);
  }
  
  private BigInteger validate(BigInteger paramBigInteger, DHParameters paramDHParameters)
  {
    if (paramBigInteger != null)
    {
      if ((paramBigInteger.compareTo(TWO) >= 0) && (paramBigInteger.compareTo(paramDHParameters.getP().subtract(TWO)) <= 0))
      {
        if (paramDHParameters.getQ() != null)
        {
          if (ONE.equals(paramBigInteger.modPow(paramDHParameters.getQ(), paramDHParameters.getP()))) {
            return paramBigInteger;
          }
          throw new IllegalArgumentException("Y value does not appear to be in correct group");
        }
        return paramBigInteger;
      }
      throw new IllegalArgumentException("invalid DH public key");
    }
    throw new NullPointerException("y value cannot be null");
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof DHPublicKeyParameters;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    bool1 = bool2;
    if (((DHPublicKeyParameters)paramObject).getY().equals(this.y))
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DHPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */