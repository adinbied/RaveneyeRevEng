package org.bouncycastle.math.ec;

import java.math.BigInteger;

public class MixedNafR2LMultiplier
  extends AbstractECMultiplier
{
  protected int additionCoord;
  protected int doublingCoord;
  
  public MixedNafR2LMultiplier()
  {
    this(2, 4);
  }
  
  public MixedNafR2LMultiplier(int paramInt1, int paramInt2)
  {
    this.additionCoord = paramInt1;
    this.doublingCoord = paramInt2;
  }
  
  protected ECCurve configureCurve(ECCurve paramECCurve, int paramInt)
  {
    if (paramECCurve.getCoordinateSystem() == paramInt) {
      return paramECCurve;
    }
    if (paramECCurve.supportsCoordinateSystem(paramInt)) {
      return paramECCurve.configure().setCoordinateSystem(paramInt).create();
    }
    paramECCurve = new StringBuilder();
    paramECCurve.append("Coordinate system ");
    paramECCurve.append(paramInt);
    paramECCurve.append(" not supported by this curve");
    throw new IllegalArgumentException(paramECCurve.toString());
  }
  
  protected ECPoint multiplyPositive(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    ECCurve localECCurve1 = paramECPoint.getCurve();
    ECCurve localECCurve2 = configureCurve(localECCurve1, this.additionCoord);
    Object localObject = configureCurve(localECCurve1, this.doublingCoord);
    int[] arrayOfInt = WNafUtil.generateCompactNaf(paramBigInteger);
    paramBigInteger = localECCurve2.getInfinity();
    localObject = ((ECCurve)localObject).importPoint(paramECPoint);
    int i = 0;
    paramECPoint = paramBigInteger;
    int j = 0;
    for (paramBigInteger = (BigInteger)localObject; i < arrayOfInt.length; paramBigInteger = (BigInteger)localObject)
    {
      int k = arrayOfInt[i];
      localObject = paramBigInteger.timesPow2(j + (k & 0xFFFF));
      ECPoint localECPoint = localECCurve2.importPoint((ECPoint)localObject);
      paramBigInteger = localECPoint;
      if (k >> 16 < 0) {
        paramBigInteger = localECPoint.negate();
      }
      paramECPoint = paramECPoint.add(paramBigInteger);
      i += 1;
      j = 1;
    }
    return localECCurve1.importPoint(paramECPoint);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\MixedNafR2LMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */