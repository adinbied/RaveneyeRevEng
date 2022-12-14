package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DSAPublicKeyParameters
  extends DSAKeyParameters
{
  private static final BigInteger ONE = BigInteger.valueOf(1L);
  private static final BigInteger TWO = BigInteger.valueOf(2L);
  private BigInteger y = validate(paramBigInteger, paramDSAParameters);
  
  public DSAPublicKeyParameters(BigInteger paramBigInteger, DSAParameters paramDSAParameters)
  {
    super(false, paramDSAParameters);
  }
  
  private BigInteger validate(BigInteger paramBigInteger, DSAParameters paramDSAParameters)
  {
    if (paramDSAParameters != null)
    {
      if ((TWO.compareTo(paramBigInteger) <= 0) && (paramDSAParameters.getP().subtract(TWO).compareTo(paramBigInteger) >= 0) && (ONE.equals(paramBigInteger.modPow(paramDSAParameters.getQ(), paramDSAParameters.getP())))) {
        return paramBigInteger;
      }
      throw new IllegalArgumentException("y value does not appear to be in correct group");
    }
    return paramBigInteger;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */