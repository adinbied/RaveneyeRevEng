package org.bouncycastle.math.ec;

import java.math.BigInteger;

public abstract class AbstractECMultiplier
  implements ECMultiplier
{
  public ECPoint multiply(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    int i = paramBigInteger.signum();
    if ((i != 0) && (!paramECPoint.isInfinity()))
    {
      paramECPoint = multiplyPositive(paramECPoint, paramBigInteger.abs());
      if (i <= 0) {
        paramECPoint = paramECPoint.negate();
      }
      return ECAlgorithms.validatePoint(paramECPoint);
    }
    return paramECPoint.getCurve().getInfinity();
  }
  
  protected abstract ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\AbstractECMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */