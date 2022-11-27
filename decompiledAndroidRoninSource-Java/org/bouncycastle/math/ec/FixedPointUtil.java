package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class FixedPointUtil
{
  public static final String PRECOMP_NAME = "bc_fixed_point";
  
  public static int getCombSize(ECCurve paramECCurve)
  {
    BigInteger localBigInteger = paramECCurve.getOrder();
    if (localBigInteger == null) {
      return paramECCurve.getFieldSize() + 1;
    }
    return localBigInteger.bitLength();
  }
  
  public static FixedPointPreCompInfo getFixedPointPreCompInfo(PreCompInfo paramPreCompInfo)
  {
    if ((paramPreCompInfo != null) && ((paramPreCompInfo instanceof FixedPointPreCompInfo))) {
      return (FixedPointPreCompInfo)paramPreCompInfo;
    }
    return new FixedPointPreCompInfo();
  }
  
  public static FixedPointPreCompInfo precompute(ECPoint paramECPoint, int paramInt)
  {
    ECCurve localECCurve = paramECPoint.getCurve();
    int m = 1 << paramInt;
    FixedPointPreCompInfo localFixedPointPreCompInfo = getFixedPointPreCompInfo(localECCurve.getPreCompInfo(paramECPoint, "bc_fixed_point"));
    ECPoint[] arrayOfECPoint1 = localFixedPointPreCompInfo.getPreComp();
    if ((arrayOfECPoint1 == null) || (arrayOfECPoint1.length < m))
    {
      int j = (getCombSize(localECCurve) + paramInt - 1) / paramInt;
      arrayOfECPoint1 = new ECPoint[paramInt + 1];
      arrayOfECPoint1[0] = paramECPoint;
      int i = 1;
      while (i < paramInt)
      {
        arrayOfECPoint1[i] = arrayOfECPoint1[(i - 1)].timesPow2(j);
        i += 1;
      }
      arrayOfECPoint1[paramInt] = arrayOfECPoint1[0].subtract(arrayOfECPoint1[1]);
      localECCurve.normalizeAll(arrayOfECPoint1);
      ECPoint[] arrayOfECPoint2 = new ECPoint[m];
      arrayOfECPoint2[0] = arrayOfECPoint1[0];
      i = paramInt - 1;
      while (i >= 0)
      {
        ECPoint localECPoint = arrayOfECPoint1[i];
        int k = 1 << i;
        j = k;
        while (j < m)
        {
          arrayOfECPoint2[j] = arrayOfECPoint2[(j - k)].add(localECPoint);
          j += (k << 1);
        }
        i -= 1;
      }
      localECCurve.normalizeAll(arrayOfECPoint2);
      localFixedPointPreCompInfo.setOffset(arrayOfECPoint1[paramInt]);
      localFixedPointPreCompInfo.setPreComp(arrayOfECPoint2);
      localFixedPointPreCompInfo.setWidth(paramInt);
      localECCurve.setPreCompInfo(paramECPoint, "bc_fixed_point", localFixedPointPreCompInfo);
    }
    return localFixedPointPreCompInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\FixedPointUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */