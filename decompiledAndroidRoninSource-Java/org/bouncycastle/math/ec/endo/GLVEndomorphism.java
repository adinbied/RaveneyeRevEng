package org.bouncycastle.math.ec.endo;

import java.math.BigInteger;

public abstract interface GLVEndomorphism
  extends ECEndomorphism
{
  public abstract BigInteger[] decomposeScalar(BigInteger paramBigInteger);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\endo\GLVEndomorphism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */