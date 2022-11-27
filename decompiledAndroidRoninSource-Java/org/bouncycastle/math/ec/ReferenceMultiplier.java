package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class ReferenceMultiplier
  extends AbstractECMultiplier
{
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    return ECAlgorithms.referenceMultiply(paramECPoint, paramBigInteger);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ReferenceMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */