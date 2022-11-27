package org.bouncycastle.math.ec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.endo.GLVEndomorphism;
import org.bouncycastle.math.field.FiniteField;
import org.bouncycastle.math.field.PolynomialExtensionField;

public class ECAlgorithms
{
  static ECPoint implShamirsTrickJsf(ECPoint paramECPoint1, BigInteger paramBigInteger1, ECPoint paramECPoint2, BigInteger paramBigInteger2)
  {
    Object localObject2 = paramECPoint1.getCurve();
    ECPoint localECPoint1 = ((ECCurve)localObject2).getInfinity();
    ECPoint localECPoint2 = paramECPoint1.add(paramECPoint2);
    ECPoint localECPoint3 = paramECPoint1.subtract(paramECPoint2);
    Object localObject1 = new ECPoint[4];
    localObject1[0] = paramECPoint2;
    localObject1[1] = localECPoint3;
    localObject1[2] = paramECPoint1;
    localObject1[3] = localECPoint2;
    ((ECCurve)localObject2).normalizeAll((ECPoint[])localObject1);
    paramECPoint2 = localObject1[3].negate();
    localObject2 = localObject1[2].negate();
    localECPoint2 = localObject1[1].negate();
    localECPoint3 = localObject1[0].negate();
    Object localObject3 = localObject1[0];
    Object localObject4 = localObject1[1];
    Object localObject5 = localObject1[2];
    localObject1 = localObject1[3];
    paramBigInteger1 = WNafUtil.generateJSF(paramBigInteger1, paramBigInteger2);
    int i = paramBigInteger1.length;
    int j;
    for (paramECPoint1 = localECPoint1;; paramECPoint1 = paramECPoint1.twicePlus(new ECPoint[] { paramECPoint2, localObject2, localECPoint2, localECPoint3, localECPoint1, localObject3, localObject4, localObject5, localObject1 }[((j << 24 >> 28) * 3 + 4 + (j << 28 >> 28))]))
    {
      i -= 1;
      if (i < 0) {
        break;
      }
      j = paramBigInteger1[i];
    }
    return paramECPoint1;
  }
  
  static ECPoint implShamirsTrickWNaf(ECPoint paramECPoint1, BigInteger paramBigInteger1, ECPoint paramECPoint2, BigInteger paramBigInteger2)
  {
    int i = paramBigInteger1.signum();
    int j = 0;
    if (i < 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBigInteger2.signum() < 0) {
      j = 1;
    }
    BigInteger localBigInteger1 = paramBigInteger1.abs();
    BigInteger localBigInteger2 = paramBigInteger2.abs();
    int k = Math.max(2, Math.min(16, WNafUtil.getWindowSize(localBigInteger1.bitLength())));
    int m = Math.max(2, Math.min(16, WNafUtil.getWindowSize(localBigInteger2.bitLength())));
    WNafPreCompInfo localWNafPreCompInfo = WNafUtil.precompute(paramECPoint1, k, true);
    paramBigInteger2 = WNafUtil.precompute(paramECPoint2, m, true);
    if (i != 0) {
      paramECPoint1 = localWNafPreCompInfo.getPreCompNeg();
    } else {
      paramECPoint1 = localWNafPreCompInfo.getPreComp();
    }
    if (j != 0) {
      paramBigInteger1 = paramBigInteger2.getPreCompNeg();
    } else {
      paramBigInteger1 = paramBigInteger2.getPreComp();
    }
    if (i != 0) {
      paramECPoint2 = localWNafPreCompInfo.getPreComp();
    } else {
      paramECPoint2 = localWNafPreCompInfo.getPreCompNeg();
    }
    if (j != 0) {
      paramBigInteger2 = paramBigInteger2.getPreComp();
    } else {
      paramBigInteger2 = paramBigInteger2.getPreCompNeg();
    }
    return implShamirsTrickWNaf(paramECPoint1, paramECPoint2, WNafUtil.generateWindowNaf(k, localBigInteger1), paramBigInteger1, paramBigInteger2, WNafUtil.generateWindowNaf(m, localBigInteger2));
  }
  
  static ECPoint implShamirsTrickWNaf(ECPoint paramECPoint, BigInteger paramBigInteger1, ECPointMap paramECPointMap, BigInteger paramBigInteger2)
  {
    int i = paramBigInteger1.signum();
    int j = 0;
    if (i < 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramBigInteger2.signum() < 0) {
      j = 1;
    }
    BigInteger localBigInteger1 = paramBigInteger1.abs();
    BigInteger localBigInteger2 = paramBigInteger2.abs();
    int k = Math.max(2, Math.min(16, WNafUtil.getWindowSize(Math.max(localBigInteger1.bitLength(), localBigInteger2.bitLength()))));
    paramBigInteger1 = WNafUtil.mapPointWithPrecomp(paramECPoint, k, true, paramECPointMap);
    paramECPointMap = WNafUtil.getWNafPreCompInfo(paramECPoint);
    paramBigInteger2 = WNafUtil.getWNafPreCompInfo(paramBigInteger1);
    if (i != 0) {
      paramECPoint = paramECPointMap.getPreCompNeg();
    } else {
      paramECPoint = paramECPointMap.getPreComp();
    }
    if (j != 0) {
      paramBigInteger1 = paramBigInteger2.getPreCompNeg();
    } else {
      paramBigInteger1 = paramBigInteger2.getPreComp();
    }
    if (i != 0) {
      paramECPointMap = paramECPointMap.getPreComp();
    } else {
      paramECPointMap = paramECPointMap.getPreCompNeg();
    }
    if (j != 0) {
      paramBigInteger2 = paramBigInteger2.getPreComp();
    } else {
      paramBigInteger2 = paramBigInteger2.getPreCompNeg();
    }
    return implShamirsTrickWNaf(paramECPoint, paramECPointMap, WNafUtil.generateWindowNaf(k, localBigInteger1), paramBigInteger1, paramBigInteger2, WNafUtil.generateWindowNaf(k, localBigInteger2));
  }
  
  private static ECPoint implShamirsTrickWNaf(ECPoint[] paramArrayOfECPoint1, ECPoint[] paramArrayOfECPoint2, byte[] paramArrayOfByte1, ECPoint[] paramArrayOfECPoint3, ECPoint[] paramArrayOfECPoint4, byte[] paramArrayOfByte2)
  {
    int i = Math.max(paramArrayOfByte1.length, paramArrayOfByte2.length);
    ECPoint localECPoint2 = paramArrayOfECPoint1[0].getCurve().getInfinity();
    int k = i - 1;
    ECPoint localECPoint1 = localECPoint2;
    i = 0;
    while (k >= 0)
    {
      int j;
      if (k < paramArrayOfByte1.length) {
        j = paramArrayOfByte1[k];
      } else {
        j = 0;
      }
      int m;
      if (k < paramArrayOfByte2.length) {
        m = paramArrayOfByte2[k];
      } else {
        m = 0;
      }
      if ((j | m) == 0)
      {
        i += 1;
      }
      else
      {
        if (j != 0)
        {
          int n = Math.abs(j);
          if (j < 0) {
            localObject1 = paramArrayOfECPoint2;
          } else {
            localObject1 = paramArrayOfECPoint1;
          }
          localObject1 = localECPoint2.add(localObject1[(n >>> 1)]);
        }
        else
        {
          localObject1 = localECPoint2;
        }
        Object localObject2 = localObject1;
        if (m != 0)
        {
          j = Math.abs(m);
          if (m < 0) {
            localObject2 = paramArrayOfECPoint4;
          } else {
            localObject2 = paramArrayOfECPoint3;
          }
          localObject2 = ((ECPoint)localObject1).add(localObject2[(j >>> 1)]);
        }
        j = i;
        Object localObject1 = localECPoint1;
        if (i > 0)
        {
          localObject1 = localECPoint1.timesPow2(i);
          j = 0;
        }
        localECPoint1 = ((ECPoint)localObject1).twicePlus((ECPoint)localObject2);
        i = j;
      }
      k -= 1;
    }
    paramArrayOfECPoint1 = localECPoint1;
    if (i > 0) {
      paramArrayOfECPoint1 = localECPoint1.timesPow2(i);
    }
    return paramArrayOfECPoint1;
  }
  
  static ECPoint implSumOfMultiplies(ECPoint[] paramArrayOfECPoint, ECPointMap paramECPointMap, BigInteger[] paramArrayOfBigInteger)
  {
    int j = paramArrayOfECPoint.length;
    int i = j << 1;
    boolean[] arrayOfBoolean = new boolean[i];
    WNafPreCompInfo[] arrayOfWNafPreCompInfo = new WNafPreCompInfo[i];
    byte[][] arrayOfByte = new byte[i][];
    i = 0;
    while (i < j)
    {
      int k = i << 1;
      int m = k + 1;
      BigInteger localBigInteger1 = paramArrayOfBigInteger[k];
      int i1;
      if (localBigInteger1.signum() < 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      arrayOfBoolean[k] = i1;
      localBigInteger1 = localBigInteger1.abs();
      BigInteger localBigInteger2 = paramArrayOfBigInteger[m];
      if (localBigInteger2.signum() < 0) {
        i1 = 1;
      } else {
        i1 = 0;
      }
      arrayOfBoolean[m] = i1;
      localBigInteger2 = localBigInteger2.abs();
      int n = Math.max(2, Math.min(16, WNafUtil.getWindowSize(Math.max(localBigInteger1.bitLength(), localBigInteger2.bitLength()))));
      ECPoint localECPoint1 = paramArrayOfECPoint[i];
      ECPoint localECPoint2 = WNafUtil.mapPointWithPrecomp(localECPoint1, n, true, paramECPointMap);
      arrayOfWNafPreCompInfo[k] = WNafUtil.getWNafPreCompInfo(localECPoint1);
      arrayOfWNafPreCompInfo[m] = WNafUtil.getWNafPreCompInfo(localECPoint2);
      arrayOfByte[k] = WNafUtil.generateWindowNaf(n, localBigInteger1);
      arrayOfByte[m] = WNafUtil.generateWindowNaf(n, localBigInteger2);
      i += 1;
    }
    return implSumOfMultiplies(arrayOfBoolean, arrayOfWNafPreCompInfo, arrayOfByte);
  }
  
  static ECPoint implSumOfMultiplies(ECPoint[] paramArrayOfECPoint, BigInteger[] paramArrayOfBigInteger)
  {
    int j = paramArrayOfECPoint.length;
    boolean[] arrayOfBoolean = new boolean[j];
    WNafPreCompInfo[] arrayOfWNafPreCompInfo = new WNafPreCompInfo[j];
    byte[][] arrayOfByte = new byte[j][];
    int i = 0;
    while (i < j)
    {
      BigInteger localBigInteger = paramArrayOfBigInteger[i];
      int m;
      if (localBigInteger.signum() < 0) {
        m = 1;
      } else {
        m = 0;
      }
      arrayOfBoolean[i] = m;
      localBigInteger = localBigInteger.abs();
      int k = Math.max(2, Math.min(16, WNafUtil.getWindowSize(localBigInteger.bitLength())));
      arrayOfWNafPreCompInfo[i] = WNafUtil.precompute(paramArrayOfECPoint[i], k, true);
      arrayOfByte[i] = WNafUtil.generateWindowNaf(k, localBigInteger);
      i += 1;
    }
    return implSumOfMultiplies(arrayOfBoolean, arrayOfWNafPreCompInfo, arrayOfByte);
  }
  
  private static ECPoint implSumOfMultiplies(boolean[] paramArrayOfBoolean, WNafPreCompInfo[] paramArrayOfWNafPreCompInfo, byte[][] paramArrayOfByte)
  {
    int n = paramArrayOfByte.length;
    int i = 0;
    int j = 0;
    while (i < n)
    {
      j = Math.max(j, paramArrayOfByte[i].length);
      i += 1;
    }
    ECPoint localECPoint2 = paramArrayOfWNafPreCompInfo[0].getPreComp()[0].getCurve().getInfinity();
    int k = j - 1;
    ECPoint localECPoint1 = localECPoint2;
    i = 0;
    while (k >= 0)
    {
      Object localObject1 = localECPoint2;
      j = 0;
      Object localObject2;
      while (j < n)
      {
        localObject2 = paramArrayOfByte[j];
        int m;
        if (k < localObject2.length) {
          m = localObject2[k];
        } else {
          m = 0;
        }
        localObject2 = localObject1;
        if (m != 0)
        {
          int i1 = Math.abs(m);
          localObject2 = paramArrayOfWNafPreCompInfo[j];
          int i2;
          if (m < 0) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          if (i2 == paramArrayOfBoolean[j]) {
            localObject2 = ((WNafPreCompInfo)localObject2).getPreComp();
          } else {
            localObject2 = ((WNafPreCompInfo)localObject2).getPreCompNeg();
          }
          localObject2 = ((ECPoint)localObject1).add(localObject2[(i1 >>> 1)]);
        }
        j += 1;
        localObject1 = localObject2;
      }
      if (localObject1 == localECPoint2)
      {
        i += 1;
      }
      else
      {
        j = i;
        localObject2 = localECPoint1;
        if (i > 0)
        {
          localObject2 = localECPoint1.timesPow2(i);
          j = 0;
        }
        localECPoint1 = ((ECPoint)localObject2).twicePlus((ECPoint)localObject1);
        i = j;
      }
      k -= 1;
    }
    paramArrayOfBoolean = localECPoint1;
    if (i > 0) {
      paramArrayOfBoolean = localECPoint1.timesPow2(i);
    }
    return paramArrayOfBoolean;
  }
  
  static ECPoint implSumOfMultipliesGLV(ECPoint[] paramArrayOfECPoint, BigInteger[] paramArrayOfBigInteger, GLVEndomorphism paramGLVEndomorphism)
  {
    int k = 0;
    Object localObject1 = paramArrayOfECPoint[0].getCurve().getOrder();
    int m = paramArrayOfECPoint.length;
    int n = m << 1;
    BigInteger[] arrayOfBigInteger = new BigInteger[n];
    int i = 0;
    int j = 0;
    Object localObject2;
    while (i < m)
    {
      localObject2 = paramGLVEndomorphism.decomposeScalar(paramArrayOfBigInteger[i].mod((BigInteger)localObject1));
      int i1 = j + 1;
      arrayOfBigInteger[j] = localObject2[0];
      j = i1 + 1;
      arrayOfBigInteger[i1] = localObject2[1];
      i += 1;
    }
    paramArrayOfBigInteger = paramGLVEndomorphism.getPointMap();
    if (paramGLVEndomorphism.hasEfficientPointMap()) {
      return implSumOfMultiplies(paramArrayOfECPoint, paramArrayOfBigInteger, arrayOfBigInteger);
    }
    paramGLVEndomorphism = new ECPoint[n];
    j = 0;
    i = k;
    while (i < m)
    {
      localObject1 = paramArrayOfECPoint[i];
      localObject2 = paramArrayOfBigInteger.map((ECPoint)localObject1);
      k = j + 1;
      paramGLVEndomorphism[j] = localObject1;
      j = k + 1;
      paramGLVEndomorphism[k] = localObject2;
      i += 1;
    }
    return implSumOfMultiplies(paramGLVEndomorphism, arrayOfBigInteger);
  }
  
  public static ECPoint importPoint(ECCurve paramECCurve, ECPoint paramECPoint)
  {
    if (paramECCurve.equals(paramECPoint.getCurve())) {
      return paramECCurve.importPoint(paramECPoint);
    }
    throw new IllegalArgumentException("Point must be on the same curve");
  }
  
  public static boolean isF2mCurve(ECCurve paramECCurve)
  {
    return isF2mField(paramECCurve.getField());
  }
  
  public static boolean isF2mField(FiniteField paramFiniteField)
  {
    return (paramFiniteField.getDimension() > 1) && (paramFiniteField.getCharacteristic().equals(ECConstants.TWO)) && ((paramFiniteField instanceof PolynomialExtensionField));
  }
  
  public static boolean isFpCurve(ECCurve paramECCurve)
  {
    return isFpField(paramECCurve.getField());
  }
  
  public static boolean isFpField(FiniteField paramFiniteField)
  {
    return paramFiniteField.getDimension() == 1;
  }
  
  public static void montgomeryTrick(ECFieldElement[] paramArrayOfECFieldElement, int paramInt1, int paramInt2)
  {
    montgomeryTrick(paramArrayOfECFieldElement, paramInt1, paramInt2, null);
  }
  
  public static void montgomeryTrick(ECFieldElement[] paramArrayOfECFieldElement, int paramInt1, int paramInt2, ECFieldElement paramECFieldElement)
  {
    ECFieldElement[] arrayOfECFieldElement = new ECFieldElement[paramInt2];
    ECFieldElement localECFieldElement = paramArrayOfECFieldElement[paramInt1];
    int i = 0;
    arrayOfECFieldElement[0] = localECFieldElement;
    for (;;)
    {
      i += 1;
      if (i >= paramInt2) {
        break;
      }
      arrayOfECFieldElement[i] = arrayOfECFieldElement[(i - 1)].multiply(paramArrayOfECFieldElement[(paramInt1 + i)]);
    }
    paramInt2 = i - 1;
    if (paramECFieldElement != null) {
      arrayOfECFieldElement[paramInt2] = arrayOfECFieldElement[paramInt2].multiply(paramECFieldElement);
    }
    paramECFieldElement = arrayOfECFieldElement[paramInt2].invert();
    while (paramInt2 > 0)
    {
      i = paramInt2 - 1;
      paramInt2 += paramInt1;
      localECFieldElement = paramArrayOfECFieldElement[paramInt2];
      paramArrayOfECFieldElement[paramInt2] = arrayOfECFieldElement[i].multiply(paramECFieldElement);
      paramECFieldElement = paramECFieldElement.multiply(localECFieldElement);
      paramInt2 = i;
    }
    paramArrayOfECFieldElement[paramInt1] = paramECFieldElement;
  }
  
  public static ECPoint referenceMultiply(ECPoint paramECPoint, BigInteger paramBigInteger)
  {
    BigInteger localBigInteger = paramBigInteger.abs();
    ECPoint localECPoint2 = paramECPoint.getCurve().getInfinity();
    int j = localBigInteger.bitLength();
    ECPoint localECPoint1 = localECPoint2;
    if (j > 0)
    {
      localECPoint1 = localECPoint2;
      if (localBigInteger.testBit(0)) {
        localECPoint1 = paramECPoint;
      }
      int i = 1;
      localECPoint2 = paramECPoint;
      for (paramECPoint = localECPoint1;; paramECPoint = localECPoint1)
      {
        localECPoint1 = paramECPoint;
        if (i >= j) {
          break;
        }
        localECPoint2 = localECPoint2.twice();
        localECPoint1 = paramECPoint;
        if (localBigInteger.testBit(i)) {
          localECPoint1 = paramECPoint.add(localECPoint2);
        }
        i += 1;
      }
    }
    paramECPoint = localECPoint1;
    if (paramBigInteger.signum() < 0) {
      paramECPoint = localECPoint1.negate();
    }
    return paramECPoint;
  }
  
  public static ECPoint shamirsTrick(ECPoint paramECPoint1, BigInteger paramBigInteger1, ECPoint paramECPoint2, BigInteger paramBigInteger2)
  {
    return validatePoint(implShamirsTrickJsf(paramECPoint1, paramBigInteger1, importPoint(paramECPoint1.getCurve(), paramECPoint2), paramBigInteger2));
  }
  
  public static ECPoint sumOfMultiplies(ECPoint[] paramArrayOfECPoint, BigInteger[] paramArrayOfBigInteger)
  {
    if ((paramArrayOfECPoint != null) && (paramArrayOfBigInteger != null) && (paramArrayOfECPoint.length == paramArrayOfBigInteger.length))
    {
      int j = paramArrayOfECPoint.length;
      int i = 1;
      if (j >= 1)
      {
        j = paramArrayOfECPoint.length;
        if (j != 1)
        {
          if (j != 2)
          {
            ECPoint localECPoint = paramArrayOfECPoint[0];
            ECCurve localECCurve = localECPoint.getCurve();
            ECPoint[] arrayOfECPoint = new ECPoint[j];
            arrayOfECPoint[0] = localECPoint;
            while (i < j)
            {
              arrayOfECPoint[i] = importPoint(localECCurve, paramArrayOfECPoint[i]);
              i += 1;
            }
            paramArrayOfECPoint = localECCurve.getEndomorphism();
            if ((paramArrayOfECPoint instanceof GLVEndomorphism)) {
              return validatePoint(implSumOfMultipliesGLV(arrayOfECPoint, paramArrayOfBigInteger, (GLVEndomorphism)paramArrayOfECPoint));
            }
            return validatePoint(implSumOfMultiplies(arrayOfECPoint, paramArrayOfBigInteger));
          }
          return sumOfTwoMultiplies(paramArrayOfECPoint[0], paramArrayOfBigInteger[0], paramArrayOfECPoint[1], paramArrayOfBigInteger[1]);
        }
        return paramArrayOfECPoint[0].multiply(paramArrayOfBigInteger[0]);
      }
    }
    throw new IllegalArgumentException("point and scalar arrays should be non-null, and of equal, non-zero, length");
  }
  
  public static ECPoint sumOfTwoMultiplies(ECPoint paramECPoint1, BigInteger paramBigInteger1, ECPoint paramECPoint2, BigInteger paramBigInteger2)
  {
    Object localObject = paramECPoint1.getCurve();
    paramECPoint2 = importPoint((ECCurve)localObject, paramECPoint2);
    if (((localObject instanceof ECCurve.AbstractF2m)) && (((ECCurve.AbstractF2m)localObject).isKoblitz())) {
      paramECPoint1 = paramECPoint1.multiply(paramBigInteger1).add(paramECPoint2.multiply(paramBigInteger2));
    }
    for (;;)
    {
      return validatePoint(paramECPoint1);
      localObject = ((ECCurve)localObject).getEndomorphism();
      if ((localObject instanceof GLVEndomorphism))
      {
        localObject = (GLVEndomorphism)localObject;
        paramECPoint1 = implSumOfMultipliesGLV(new ECPoint[] { paramECPoint1, paramECPoint2 }, new BigInteger[] { paramBigInteger1, paramBigInteger2 }, (GLVEndomorphism)localObject);
      }
      else
      {
        paramECPoint1 = implShamirsTrickWNaf(paramECPoint1, paramBigInteger1, paramECPoint2, paramBigInteger2);
      }
    }
  }
  
  public static ECPoint validatePoint(ECPoint paramECPoint)
  {
    if (paramECPoint.isValid()) {
      return paramECPoint;
    }
    throw new IllegalArgumentException("Invalid point");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ECAlgorithms.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */