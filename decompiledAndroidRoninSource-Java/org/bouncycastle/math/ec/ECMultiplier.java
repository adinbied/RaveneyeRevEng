package org.bouncycastle.math.ec;

import java.math.BigInteger;

public abstract interface ECMultiplier
{
  public abstract ECPoint multiply(ECPoint paramECPoint, BigInteger paramBigInteger);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ECMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */