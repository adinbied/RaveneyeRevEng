package org.bouncycastle.crypto.params;

import java.math.BigInteger;
import java.util.Vector;

public class NaccacheSternPrivateKeyParameters
  extends NaccacheSternKeyParameters
{
  private BigInteger phi_n;
  private Vector smallPrimes;
  
  public NaccacheSternPrivateKeyParameters(BigInteger paramBigInteger1, BigInteger paramBigInteger2, int paramInt, Vector paramVector, BigInteger paramBigInteger3)
  {
    super(true, paramBigInteger1, paramBigInteger2, paramInt);
    this.smallPrimes = paramVector;
    this.phi_n = paramBigInteger3;
  }
  
  public BigInteger getPhi_n()
  {
    return this.phi_n;
  }
  
  public Vector getSmallPrimes()
  {
    return this.smallPrimes;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\NaccacheSternPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */