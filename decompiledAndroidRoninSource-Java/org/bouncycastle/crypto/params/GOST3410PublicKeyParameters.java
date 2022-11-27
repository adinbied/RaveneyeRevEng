package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PublicKeyParameters
  extends GOST3410KeyParameters
{
  private BigInteger y;
  
  public GOST3410PublicKeyParameters(BigInteger paramBigInteger, GOST3410Parameters paramGOST3410Parameters)
  {
    super(false, paramGOST3410Parameters);
    this.y = paramBigInteger;
  }
  
  public BigInteger getY()
  {
    return this.y;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\GOST3410PublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */