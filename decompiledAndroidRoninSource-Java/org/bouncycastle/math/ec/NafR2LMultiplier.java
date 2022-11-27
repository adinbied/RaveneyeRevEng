package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class NafR2LMultiplier
  extends AbstractECMultiplier
{
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    int[] arrayOfInt = WNafUtil.generateCompactNaf(paramBigInteger);
    Object localObject = paramECPoint.getCurve().getInfinity();
    int i = 0;
    int j = 0;
    paramBigInteger = paramECPoint;
    paramECPoint = (ECPoint)localObject;
    while (i < arrayOfInt.length)
    {
      int k = arrayOfInt[i];
      paramBigInteger = paramBigInteger.timesPow2(j + (k & 0xFFFF));
      if (k >> 16 < 0) {
        localObject = paramBigInteger.negate();
      } else {
        localObject = paramBigInteger;
      }
      paramECPoint = paramECPoint.add((ECPoint)localObject);
      i += 1;
      j = 1;
    }
    return paramECPoint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\NafR2LMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */