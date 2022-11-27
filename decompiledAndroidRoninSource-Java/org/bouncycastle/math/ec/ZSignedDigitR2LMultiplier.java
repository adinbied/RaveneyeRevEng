package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class ZSignedDigitR2LMultiplier
  extends AbstractECMultiplier
{
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    ECPoint localECPoint1 = paramECPoint.getCurve().getInfinity();
    int j = paramBigInteger.bitLength();
    int i = paramBigInteger.getLowestSetBit();
    for (paramECPoint = paramECPoint.timesPow2(i);; paramECPoint = paramECPoint.twice())
    {
      i += 1;
      if (i >= j) {
        break;
      }
      ECPoint localECPoint2;
      if (paramBigInteger.testBit(i)) {
        localECPoint2 = paramECPoint;
      } else {
        localECPoint2 = paramECPoint.negate();
      }
      localECPoint1 = localECPoint1.add(localECPoint2);
    }
    return localECPoint1.add(paramECPoint);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ZSignedDigitR2LMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */