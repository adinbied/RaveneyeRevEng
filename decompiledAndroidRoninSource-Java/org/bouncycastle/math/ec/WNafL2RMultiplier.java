package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class WNafL2RMultiplier
  extends AbstractECMultiplier
{
  protected int getWindowSize(int paramInt)
  {
    return WNafUtil.getWindowSize(paramInt);
  }
  
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    int k = Math.max(2, Math.min(16, getWindowSize(paramBigInteger.bitLength())));
    Object localObject = WNafUtil.precompute(paramECPoint, k, true);
    ECPoint[] arrayOfECPoint = ((WNafPreCompInfo)localObject).getPreComp();
    localObject = ((WNafPreCompInfo)localObject).getPreCompNeg();
    int[] arrayOfInt = WNafUtil.generateCompactWindowNaf(k, paramBigInteger);
    paramECPoint = paramECPoint.getCurve().getInfinity();
    int j = arrayOfInt.length;
    int i = j;
    int m;
    if (j > 1)
    {
      j -= 1;
      i = arrayOfInt[j];
      int n = i >> 16;
      i &= 0xFFFF;
      m = Math.abs(n);
      if (n < 0) {
        paramECPoint = (ECPoint)localObject;
      } else {
        paramECPoint = arrayOfECPoint;
      }
      if (m << 2 < 1 << k)
      {
        n = LongArray.bitLengths[m];
        int i1 = k - n;
        paramECPoint = paramECPoint[((1 << k - 1) - 1 >>> 1)].add(paramECPoint[(((m ^ 1 << n - 1) << i1) + 1 >>> 1)]);
        i -= i1;
      }
      else
      {
        paramECPoint = paramECPoint[(m >>> 1)];
      }
      paramECPoint = paramECPoint.timesPow2(i);
      i = j;
    }
    while (i > 0)
    {
      i -= 1;
      j = arrayOfInt[i];
      k = j >> 16;
      m = Math.abs(k);
      if (k < 0) {
        paramBigInteger = (BigInteger)localObject;
      } else {
        paramBigInteger = arrayOfECPoint;
      }
      paramECPoint = paramECPoint.twicePlus(paramBigInteger[(m >>> 1)]).timesPow2(j & 0xFFFF);
    }
    return paramECPoint;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\WNafL2RMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */