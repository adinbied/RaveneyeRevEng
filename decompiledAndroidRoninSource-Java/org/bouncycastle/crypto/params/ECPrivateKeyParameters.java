package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class ECPrivateKeyParameters
  extends ECKeyParameters
{
  BigInteger d;
  
  public ECPrivateKeyParameters(BigInteger paramBigInteger, ECDomainParameters paramECDomainParameters)
  {
    super(true, paramECDomainParameters);
    this.d = paramBigInteger;
  }
  
  public BigInteger getD()
  {
    return this.d;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ECPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */