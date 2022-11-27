package org.bouncycastle.math.ec;

import java.math.BigInteger;

public abstract class WNafUtil
{
  private static final int[] DEFAULT_WINDOW_SIZE_CUTOFFS = { 13, 41, 121, 337, 897, 2305 };
  private static final byte[] EMPTY_BYTES = new byte[0];
  private static final int[] EMPTY_INTS = new int[0];
  private static final ECPoint[] EMPTY_POINTS = new ECPoint[0];
  public static final String PRECOMP_NAME = "bc_wnaf";
  
  public static int[] generateCompactNaf(BigInteger paramBigInteger)
  {
    if (paramBigInteger.bitLength() >>> 16 == 0)
    {
      if (paramBigInteger.signum() == 0) {
        return EMPTY_INTS;
      }
      BigInteger localBigInteger = paramBigInteger.shiftLeft(1).add(paramBigInteger);
      int i1 = localBigInteger.bitLength();
      int n = i1 >> 1;
      int[] arrayOfInt = new int[n];
      localBigInteger = localBigInteger.xor(paramBigInteger);
      int k = 0;
      int j = 0;
      int i = 1;
      while (i < i1 - 1)
      {
        if (!localBigInteger.testBit(i))
        {
          j += 1;
        }
        else
        {
          int m;
          if (paramBigInteger.testBit(i)) {
            m = -1;
          } else {
            m = 1;
          }
          arrayOfInt[k] = (j | m << 16);
          i += 1;
          k += 1;
          j = 1;
        }
        i += 1;
      }
      i = k + 1;
      arrayOfInt[k] = (0x10000 | j);
      paramBigInteger = arrayOfInt;
      if (n > i) {
        paramBigInteger = trim(arrayOfInt, i);
      }
      return paramBigInteger;
    }
    throw new IllegalArgumentException("'k' must have bitlength < 2^16");
  }
  
  public static int[] generateCompactWindowNaf(int paramInt, BigInteger paramBigInteger)
  {
    if (paramInt == 2) {
      return generateCompactNaf(paramBigInteger);
    }
    if ((paramInt >= 2) && (paramInt <= 16))
    {
      if (paramBigInteger.bitLength() >>> 16 == 0)
      {
        if (paramBigInteger.signum() == 0) {
          return EMPTY_INTS;
        }
        int n = paramBigInteger.bitLength() / paramInt + 1;
        int[] arrayOfInt = new int[n];
        int i1 = 1 << paramInt;
        int i = 0;
        int k = 0;
        int i2 = 0;
        while (i <= paramBigInteger.bitLength()) {
          if (paramBigInteger.testBit(i) == i2)
          {
            i += 1;
          }
          else
          {
            paramBigInteger = paramBigInteger.shiftRight(i);
            int m = paramBigInteger.intValue() & i1 - 1;
            int j = m;
            if (i2 != 0) {
              j = m + 1;
            }
            if ((j & i1 >>> 1) != 0) {
              i2 = 1;
            } else {
              i2 = 0;
            }
            m = j;
            if (i2 != 0) {
              m = j - i1;
            }
            j = i;
            if (k > 0) {
              j = i - 1;
            }
            arrayOfInt[k] = (j | m << 16);
            i = paramInt;
            k += 1;
          }
        }
        paramBigInteger = arrayOfInt;
        if (n > k) {
          paramBigInteger = trim(arrayOfInt, k);
        }
        return paramBigInteger;
      }
      throw new IllegalArgumentException("'k' must have bitlength < 2^16");
    }
    throw new IllegalArgumentException("'width' must be in the range [2, 16]");
  }
  
  public static byte[] generateJSF(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
  {
    int i4 = Math.max(paramBigInteger1.bitLength(), paramBigInteger2.bitLength()) + 1;
    byte[] arrayOfByte = new byte[i4];
    int i1 = 0;
    int n = 0;
    int k = 0;
    int m = 0;
    Object localObject1 = paramBigInteger1;
    for (;;)
    {
      if (((i1 | n) == 0) && (((BigInteger)localObject1).bitLength() <= k) && (paramBigInteger2.bitLength() <= k))
      {
        paramBigInteger1 = arrayOfByte;
        if (i4 > m) {
          paramBigInteger1 = trim(arrayOfByte, m);
        }
        return paramBigInteger1;
      }
      int i3 = (((BigInteger)localObject1).intValue() >>> k) + i1 & 0x7;
      int i5 = (paramBigInteger2.intValue() >>> k) + n & 0x7;
      int j = i3 & 0x1;
      int i = j;
      if (j != 0)
      {
        j -= (i3 & 0x2);
        i = j;
        if (i3 + j == 4)
        {
          i = j;
          if ((i5 & 0x3) == 2) {
            i = -j;
          }
        }
      }
      int i2 = i5 & 0x1;
      j = i2;
      if (i2 != 0)
      {
        i2 -= (i5 & 0x2);
        j = i2;
        if (i5 + i2 == 4)
        {
          j = i2;
          if ((i3 & 0x3) == 2) {
            j = -i2;
          }
        }
      }
      i2 = i1;
      if (i1 << 1 == i + 1) {
        i2 = i1 ^ 0x1;
      }
      i3 = n;
      if (n << 1 == j + 1) {
        i3 = n ^ 0x1;
      }
      n = k + 1;
      k = n;
      Object localObject2 = localObject1;
      paramBigInteger1 = paramBigInteger2;
      if (n == 30)
      {
        localObject2 = ((BigInteger)localObject1).shiftRight(30);
        paramBigInteger1 = paramBigInteger2.shiftRight(30);
        k = 0;
      }
      arrayOfByte[m] = ((byte)(i << 4 | j & 0xF));
      m += 1;
      i1 = i2;
      n = i3;
      localObject1 = localObject2;
      paramBigInteger2 = paramBigInteger1;
    }
  }
  
  public static byte[] generateNaf(BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() == 0) {
      return EMPTY_BYTES;
    }
    BigInteger localBigInteger = paramBigInteger.shiftLeft(1).add(paramBigInteger);
    int k = localBigInteger.bitLength() - 1;
    byte[] arrayOfByte = new byte[k];
    localBigInteger = localBigInteger.xor(paramBigInteger);
    int j;
    for (int i = 1; i < k; i = j + 1)
    {
      j = i;
      if (localBigInteger.testBit(i))
      {
        if (paramBigInteger.testBit(i)) {
          j = -1;
        } else {
          j = 1;
        }
        arrayOfByte[(i - 1)] = ((byte)j);
        j = i + 1;
      }
    }
    arrayOfByte[(k - 1)] = 1;
    return arrayOfByte;
  }
  
  public static byte[] generateWindowNaf(int paramInt, BigInteger paramBigInteger)
  {
    if (paramInt == 2) {
      return generateNaf(paramBigInteger);
    }
    if ((paramInt >= 2) && (paramInt <= 8))
    {
      if (paramBigInteger.signum() == 0) {
        return EMPTY_BYTES;
      }
      int n = paramBigInteger.bitLength() + 1;
      byte[] arrayOfByte = new byte[n];
      int i1 = 1 << paramInt;
      int i = 0;
      int k = 0;
      int i2 = 0;
      while (i <= paramBigInteger.bitLength()) {
        if (paramBigInteger.testBit(i) == i2)
        {
          i += 1;
        }
        else
        {
          paramBigInteger = paramBigInteger.shiftRight(i);
          int m = paramBigInteger.intValue() & i1 - 1;
          int j = m;
          if (i2 != 0) {
            j = m + 1;
          }
          if ((j & i1 >>> 1) != 0) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          m = j;
          if (i2 != 0) {
            m = j - i1;
          }
          j = i;
          if (k > 0) {
            j = i - 1;
          }
          i = k + j;
          arrayOfByte[i] = ((byte)m);
          k = i + 1;
          i = paramInt;
        }
      }
      paramBigInteger = arrayOfByte;
      if (n > k) {
        paramBigInteger = trim(arrayOfByte, k);
      }
      return paramBigInteger;
    }
    throw new IllegalArgumentException("'width' must be in the range [2, 8]");
  }
  
  public static int getNafWeight(BigInteger paramBigInteger)
  {
    if (paramBigInteger.signum() == 0) {
      return 0;
    }
    return paramBigInteger.shiftLeft(1).add(paramBigInteger).xor(paramBigInteger).bitCount();
  }
  
  public static WNafPreCompInfo getWNafPreCompInfo(ECPoint paramECPoint)
  {
    return getWNafPreCompInfo(paramECPoint.getCurve().getPreCompInfo(paramECPoint, "bc_wnaf"));
  }
  
  public static WNafPreCompInfo getWNafPreCompInfo(PreCompInfo paramPreCompInfo)
  {
    if ((paramPreCompInfo != null) && ((paramPreCompInfo instanceof WNafPreCompInfo))) {
      return (WNafPreCompInfo)paramPreCompInfo;
    }
    return new WNafPreCompInfo();
  }
  
  public static int getWindowSize(int paramInt)
  {
    return getWindowSize(paramInt, DEFAULT_WINDOW_SIZE_CUTOFFS);
  }
  
  public static int getWindowSize(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    while ((i < paramArrayOfInt.length) && (paramInt >= paramArrayOfInt[i])) {
      i += 1;
    }
    return i + 2;
  }
  
  public static ECPoint mapPointWithPrecomp(ECPoint paramECPoint, int paramInt, boolean paramBoolean, ECPointMap paramECPointMap)
  {
    ECCurve localECCurve = paramECPoint.getCurve();
    Object localObject1 = precompute(paramECPoint, paramInt, paramBoolean);
    paramECPoint = paramECPointMap.map(paramECPoint);
    WNafPreCompInfo localWNafPreCompInfo = getWNafPreCompInfo(localECCurve.getPreCompInfo(paramECPoint, "bc_wnaf"));
    Object localObject2 = ((WNafPreCompInfo)localObject1).getTwice();
    if (localObject2 != null) {
      localWNafPreCompInfo.setTwice(paramECPointMap.map((ECPoint)localObject2));
    }
    localObject2 = ((WNafPreCompInfo)localObject1).getPreComp();
    int j = localObject2.length;
    localObject1 = new ECPoint[j];
    int i = 0;
    paramInt = 0;
    while (paramInt < localObject2.length)
    {
      localObject1[paramInt] = paramECPointMap.map(localObject2[paramInt]);
      paramInt += 1;
    }
    localWNafPreCompInfo.setPreComp((ECPoint[])localObject1);
    if (paramBoolean)
    {
      paramECPointMap = new ECPoint[j];
      paramInt = i;
      while (paramInt < j)
      {
        paramECPointMap[paramInt] = localObject1[paramInt].negate();
        paramInt += 1;
      }
      localWNafPreCompInfo.setPreCompNeg(paramECPointMap);
    }
    localECCurve.setPreCompInfo(paramECPoint, "bc_wnaf", localWNafPreCompInfo);
    return paramECPoint;
  }
  
  public static WNafPreCompInfo precompute(ECPoint paramECPoint, int paramInt, boolean paramBoolean)
  {
    ECCurve localECCurve = paramECPoint.getCurve();
    WNafPreCompInfo localWNafPreCompInfo = getWNafPreCompInfo(localECCurve.getPreCompInfo(paramECPoint, "bc_wnaf"));
    int k = 0;
    int m = 1 << Math.max(0, paramInt - 2);
    Object localObject1 = localWNafPreCompInfo.getPreComp();
    if (localObject1 == null)
    {
      localObject1 = EMPTY_POINTS;
      paramInt = 0;
    }
    else
    {
      paramInt = localObject1.length;
    }
    Object localObject2 = localObject1;
    int i;
    Object localObject3;
    if (paramInt < m)
    {
      ECPoint[] arrayOfECPoint = resizeTable((ECPoint[])localObject1, m);
      if (m == 1)
      {
        arrayOfECPoint[0] = paramECPoint.normalize();
        localObject2 = arrayOfECPoint;
      }
      else
      {
        if (paramInt == 0)
        {
          arrayOfECPoint[0] = paramECPoint;
          i = 1;
        }
        else
        {
          i = paramInt;
        }
        Object localObject4 = null;
        ECFieldElement localECFieldElement = null;
        if (m == 2)
        {
          arrayOfECPoint[1] = paramECPoint.threeTimes();
        }
        else
        {
          ECPoint localECPoint = localWNafPreCompInfo.getTwice();
          localObject4 = arrayOfECPoint[(i - 1)];
          localObject3 = localECPoint;
          int j = i;
          localObject1 = localECFieldElement;
          localObject2 = localObject4;
          if (localECPoint == null)
          {
            localECPoint = arrayOfECPoint[0].twice();
            localWNafPreCompInfo.setTwice(localECPoint);
            localObject3 = localECPoint;
            j = i;
            localObject1 = localECFieldElement;
            localObject2 = localObject4;
            if (!localECPoint.isInfinity())
            {
              localObject3 = localECPoint;
              j = i;
              localObject1 = localECFieldElement;
              localObject2 = localObject4;
              if (ECAlgorithms.isFpCurve(localECCurve))
              {
                localObject3 = localECPoint;
                j = i;
                localObject1 = localECFieldElement;
                localObject2 = localObject4;
                if (localECCurve.getFieldSize() >= 64)
                {
                  j = localECCurve.getCoordinateSystem();
                  if ((j != 2) && (j != 3) && (j != 4))
                  {
                    localObject3 = localECPoint;
                    j = i;
                    localObject1 = localECFieldElement;
                    localObject2 = localObject4;
                  }
                  else
                  {
                    localObject1 = localECPoint.getZCoord(0);
                    localObject3 = localECCurve.createPoint(localECPoint.getXCoord().toBigInteger(), localECPoint.getYCoord().toBigInteger());
                    localObject2 = ((ECFieldElement)localObject1).square();
                    localECFieldElement = ((ECFieldElement)localObject2).multiply((ECFieldElement)localObject1);
                    localObject2 = ((ECPoint)localObject4).scaleX((ECFieldElement)localObject2).scaleY(localECFieldElement);
                    if (paramInt == 0) {
                      arrayOfECPoint[0] = localObject2;
                    }
                    j = i;
                  }
                }
              }
            }
          }
          for (;;)
          {
            localObject4 = localObject1;
            if (j >= m) {
              break;
            }
            localObject2 = ((ECPoint)localObject2).add((ECPoint)localObject3);
            arrayOfECPoint[j] = localObject2;
            j += 1;
          }
        }
        localECCurve.normalizeAll(arrayOfECPoint, paramInt, m - paramInt, (ECFieldElement)localObject4);
        localObject2 = arrayOfECPoint;
      }
    }
    localWNafPreCompInfo.setPreComp((ECPoint[])localObject2);
    if (paramBoolean)
    {
      localObject3 = localWNafPreCompInfo.getPreCompNeg();
      if (localObject3 == null)
      {
        localObject1 = new ECPoint[m];
        paramInt = k;
      }
      else
      {
        i = localObject3.length;
        paramInt = i;
        localObject1 = localObject3;
        if (i < m)
        {
          localObject1 = resizeTable((ECPoint[])localObject3, m);
          paramInt = i;
        }
      }
      while (paramInt < m)
      {
        localObject1[paramInt] = localObject2[paramInt].negate();
        paramInt += 1;
      }
      localWNafPreCompInfo.setPreCompNeg((ECPoint[])localObject1);
    }
    localECCurve.setPreCompInfo(paramECPoint, "bc_wnaf", localWNafPreCompInfo);
    return localWNafPreCompInfo;
  }
  
  private static ECPoint[] resizeTable(ECPoint[] paramArrayOfECPoint, int paramInt)
  {
    ECPoint[] arrayOfECPoint = new ECPoint[paramInt];
    System.arraycopy(paramArrayOfECPoint, 0, arrayOfECPoint, 0, paramArrayOfECPoint.length);
    return arrayOfECPoint;
  }
  
  private static byte[] trim(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  private static int[] trim(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    return arrayOfInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\WNafUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */