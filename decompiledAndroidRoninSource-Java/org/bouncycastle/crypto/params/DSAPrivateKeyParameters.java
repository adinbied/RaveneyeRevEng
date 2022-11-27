package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class DSAPrivateKeyParameters
  extends DSAKeyParameters
{
  private BigInteger x;
  
  public DSAPrivateKeyParameters(BigInteger paramBigInteger, DSAParameters paramDSAParameters)
  {
    super(true, paramDSAParameters);
    this.x = paramBigInteger;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */