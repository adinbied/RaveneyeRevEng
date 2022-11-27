package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class FixedPointCombMultiplier
  extends AbstractECMultiplier
{
  protected int getWidthForCombSize(int paramInt)
  {
    if (paramInt > 257) {
      return 6;
    }
    return 5;
  }
  
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    ECCurve localECCurve = paramECPoint.getCurve();
    int i = FixedPointUtil.getCombSize(localECCurve);
    if (paramBigInteger.bitLength() <= i)
    {
      FixedPointPreCompInfo localFixedPointPreCompInfo = FixedPointUtil.precompute(paramECPoint, getWidthForCombSize(i));
      ECPoint[] arrayOfECPoint = localFixedPointPreCompInfo.getPreComp();
      int n = localFixedPointPreCompInfo.getWidth();
      int i1 = (i + n - 1) / n;
      paramECPoint = localECCurve.getInfinity();
      int j = 0;
      while (j < i1)
      {
        int k = n * i1 - 1 - j;
        i = 0;
        while (k >= 0)
        {
          int m = i << 1;
          i = m;
          if (paramBigInteger.testBit(k)) {
            i = m | 0x1;
          }
          k -= i1;
        }
        paramECPoint = paramECPoint.twicePlus(arrayOfECPoint[i]);
        j += 1;
      }
      return paramECPoint.add(localFixedPointPreCompInfo.getOffset());
    }
    throw new IllegalStateException("fixed-point comb doesn't support scalars larger than the curve order");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\FixedPointCombMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */