package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class ZSignedDigitL2RMultiplier
  extends AbstractECMultiplier
{
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    paramECPoint = paramECPoint.normalize();
    ECPoint localECPoint3 = paramECPoint.negate();
    int i = paramBigInteger.bitLength();
    int j = paramBigInteger.getLowestSetBit();
    ECPoint localECPoint2;
    for (ECPoint localECPoint1 = paramECPoint;; localECPoint1 = localECPoint1.twicePlus(localECPoint2))
    {
      i -= 1;
      if (i <= j) {
        break;
      }
      if (paramBigInteger.testBit(i)) {
        localECPoint2 = paramECPoint;
      } else {
        localECPoint2 = localECPoint3;
      }
    }
    return localECPoint1.timesPow2(j);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ZSignedDigitL2RMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */