package org.bouncycastle.crypto.params;

import java.math.BigInteger;

public class GOST3410PrivateKeyParameters
  extends GOST3410KeyParameters
{
  private BigInteger x;
  
  public GOST3410PrivateKeyParameters(BigInteger paramBigInteger, GOST3410Parameters paramGOST3410Parameters)
  {
    super(true, paramGOST3410Parameters);
    this.x = paramBigInteger;
  }
  
  public BigInteger getX()
  {
    return this.x;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\GOST3410PrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */