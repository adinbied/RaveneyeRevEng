package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class NafL2RMultiplier
  extends AbstractECMultiplier
{
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    int[] arrayOfInt = WNafUtil.generateCompactNaf(paramBigInteger);
    ECPoint localECPoint1 = paramECPoint.normalize();
    ECPoint localECPoint2 = localECPoint1.negate();
    paramECPoint = paramECPoint.getCurve().getInfinity();
    int i = arrayOfInt.length;
    for (;;)
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      int j = arrayOfInt[i];
      if (j >> 16 < 0) {
        paramBigInteger = localECPoint2;
      } else {
        paramBigInteger = localECPoint1;
      }
      paramECPoint = paramECPoint.twicePlus(paramBigInteger).timesPow2(j & 0xFFFF);
    }
    return paramECPoint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\NafL2RMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */