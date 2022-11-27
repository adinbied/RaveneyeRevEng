package org.bouncycastle.math.ec;

import java.math.BigInteger;

class Tnaf
{
  private static final BigInteger MINUS_ONE = ECConstants.ONE.negate();
  private static final BigInteger MINUS_THREE;
  private static final BigInteger MINUS_TWO = ECConstants.TWO.negate();
  public static final byte POW_2_WIDTH = 16;
  public static final byte WIDTH = 4;
  public static final ZTauElement[] alpha0;
  public static final byte[][] alpha0Tnaf;
  public static final ZTauElement[] alpha1 = { null, new ZTauElement(ECConstants.ONE, ECConstants.ZERO), null, new ZTauElement(MINUS_THREE, ECConstants.ONE), null, new ZTauElement(MINUS_ONE, ECConstants.ONE), null, new ZTauElement(ECConstants.ONE, ECConstants.ONE), null };
  public static final byte[][] alpha1Tnaf = { null, { 1 }, null, { -1, 0, 1 }, null, { 1, 0, 1 }, null, { -1, 0, 0, -1 } };
  
  static
  {
    MINUS_THREE = ECConstants.THREE.negate();
    Object localObject1 = new ZTauElement(ECConstants.ONE, ECConstants.ZERO);
    Object localObject2 = new ZTauElement(MINUS_THREE, MINUS_ONE);
    BigInteger localBigInteger = MINUS_ONE;
    alpha0 = new ZTauElement[] { null, localObject1, null, localObject2, null, new ZTauElement(localBigInteger, localBigInteger), null, new ZTauElement(ECConstants.ONE, MINUS_ONE), null };
    localObject1 = new byte[] { 1 };
    localObject2 = new byte[] { -1, 0, 0, 1 };
    alpha0Tnaf = new byte[][] { null, localObject1, null, { -1, 0, 1 }, null, { 1, 0, 1 }, null, localObject2 };
  }
  
  public static SimpleBigDecimal approximateDivisionByN(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3, byte paramByte, int paramInt1, int paramInt2)
  {
    int i = (paramInt1 + 5) / 2 + paramInt2;
    paramBigInteger1 = paramBigInteger2.multiply(paramBigInteger1.shiftRight(paramInt1 - i - 2 + paramByte));
    paramBigInteger3 = paramBigInteger1.add(paramBigInteger3.multiply(paramBigInteger1.shiftRight(paramInt1)));
    paramByte = i - paramInt2;
    paramBigInteger2 = paramBigInteger3.shiftRight(paramByte);
    paramBigInteger1 = paramBigInteger2;
    if (paramBigInteger3.testBit(paramByte - 1)) {
      paramBigInteger1 = paramBigInteger2.add(ECConstants.ONE);
    }
    return new SimpleBigDecimal(paramBigInteger1, paramInt2);
  }
  
  public static BigInteger[] getLucas(byte paramByte, int paramInt, boolean paramBoolean)
  {
    if ((paramByte != 1) && (paramByte != -1)) {
      throw new IllegalArgumentException("mu must be 1 or -1");
    }
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = ECConstants.TWO;
      localObject1 = BigInteger.valueOf(paramByte);
    }
    else
    {
      localObject2 = ECConstants.ZERO;
      localObject1 = ECConstants.ONE;
    }
    int i = 1;
    while (i < paramInt)
    {
      if (paramByte == 1) {
        localObject3 = localObject1;
      } else {
        localObject3 = ((BigInteger)localObject1).negate();
      }
      localObject2 = ((BigInteger)localObject3).subtract(((BigInteger)localObject2).shiftLeft(1));
      i += 1;
      Object localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
    return new BigInteger[] { localObject2, localObject1 };
  }
  
  public static byte getMu(int paramInt)
  {
    if (paramInt == 0) {
      paramInt = -1;
    } else {
      paramInt = 1;
    }
    return (byte)paramInt;
  }
  
  public static byte getMu(ECCurve.AbstractF2m paramAbstractF2m)
  {
    if (paramAbstractF2m.isKoblitz())
    {
      if (paramAbstractF2m.getA().isZero()) {
        return -1;
      }
      return 1;
    }
    throw new IllegalArgumentException("No Koblitz curve (ABC), TNAF multiplication not possible");
  }
  
  public static byte getMu(ECFieldElement paramECFieldElement)
  {
    int i;
    if (paramECFieldElement.isZero()) {
      i = -1;
    } else {
      i = 1;
    }
    return (byte)i;
  }
  
  public static ECPoint.AbstractF2m[] getPreComp(ECPoint.AbstractF2m paramAbstractF2m, byte paramByte)
  {
    byte[][] arrayOfByte;
    if (paramByte == 0) {
      arrayOfByte = alpha0Tnaf;
    } else {
      arrayOfByte = alpha1Tnaf;
    }
    ECPoint.AbstractF2m[] arrayOfAbstractF2m = new ECPoint.AbstractF2m[arrayOfByte.length + 1 >>> 1];
    arrayOfAbstractF2m[0] = paramAbstractF2m;
    byte b = arrayOfByte.length;
    paramByte = 3;
    while (paramByte < b)
    {
      arrayOfAbstractF2m[(paramByte >>> 1)] = multiplyFromTnaf(paramAbstractF2m, arrayOfByte[paramByte]);
      paramByte += 2;
    }
    paramAbstractF2m.getCurve().normalizeAll(arrayOfAbstractF2m);
    return arrayOfAbstractF2m;
  }
  
  protected static int getShiftsForCofactor(BigInteger paramBigInteger)
  {
    if (paramBigInteger != null)
    {
      if (paramBigInteger.equals(ECConstants.TWO)) {
        return 1;
      }
      if (paramBigInteger.equals(ECConstants.FOUR)) {
        return 2;
      }
    }
    throw new IllegalArgumentException("h (Cofactor) must be 2 or 4");
  }
  
  public static BigInteger[] getSi(int paramInt1, int paramInt2, BigInteger paramBigInteger)
  {
    byte b = getMu(paramInt2);
    int i = getShiftsForCofactor(paramBigInteger);
    paramBigInteger = getLucas(b, paramInt1 + 3 - paramInt2, false);
    if (b == 1)
    {
      paramBigInteger[0] = paramBigInteger[0].negate();
      paramBigInteger[1] = paramBigInteger[1].negate();
    }
    return new BigInteger[] { ECConstants.ONE.add(paramBigInteger[1]).shiftRight(i), ECConstants.ONE.add(paramBigInteger[0]).shiftRight(i).negate() };
  }
  
  public static BigInteger[] getSi(ECCurve.AbstractF2m paramAbstractF2m)
  {
    if (paramAbstractF2m.isKoblitz())
    {
      int i = paramAbstractF2m.getFieldSize();
      int j = paramAbstractF2m.getA().toBigInteger().intValue();
      byte b = getMu(j);
      int k = getShiftsForCofactor(paramAbstractF2m.getCofactor());
      paramAbstractF2m = getLucas(b, i + 3 - j, false);
      if (b == 1)
      {
        paramAbstractF2m[0] = paramAbstractF2m[0].negate();
        paramAbstractF2m[1] = paramAbstractF2m[1].negate();
      }
      return new BigInteger[] { ECConstants.ONE.add(paramAbstractF2m[1]).shiftRight(k), ECConstants.ONE.add(paramAbstractF2m[0]).shiftRight(k).negate() };
    }
    throw new IllegalArgumentException("si is defined for Koblitz curves only");
  }
  
  public static BigInteger getTw(byte paramByte, int paramInt)
  {
    if (paramInt == 4)
    {
      if (paramByte == 1) {
        return BigInteger.valueOf(6L);
      }
      return BigInteger.valueOf(10L);
    }
    BigInteger[] arrayOfBigInteger = getLucas(paramByte, paramInt, false);
    BigInteger localBigInteger1 = ECConstants.ZERO.setBit(paramInt);
    BigInteger localBigInteger2 = arrayOfBigInteger[1].modInverse(localBigInteger1);
    return ECConstants.TWO.multiply(arrayOfBigInteger[0]).multiply(localBigInteger2).mod(localBigInteger1);
  }
  
  public static ECPoint.AbstractF2m multiplyFromTnaf(ECPoint.AbstractF2m paramAbstractF2m, byte[] paramArrayOfByte)
  {
    Object localObject1 = (ECPoint.AbstractF2m)paramAbstractF2m.getCurve().getInfinity();
    ECPoint.AbstractF2m localAbstractF2m = (ECPoint.AbstractF2m)paramAbstractF2m.negate();
    int j = paramArrayOfByte.length - 1;
    int i = 0;
    while (j >= 0)
    {
      int k = i + 1;
      int m = paramArrayOfByte[j];
      Object localObject2 = localObject1;
      i = k;
      if (m != 0)
      {
        localObject2 = ((ECPoint.AbstractF2m)localObject1).tauPow(k);
        if (m > 0) {
          localObject1 = paramAbstractF2m;
        } else {
          localObject1 = localAbstractF2m;
        }
        localObject2 = (ECPoint.AbstractF2m)((ECPoint.AbstractF2m)localObject2).add((ECPoint)localObject1);
        i = 0;
      }
      j -= 1;
      localObject1 = localObject2;
    }
    paramAbstractF2m = (ECPoint.AbstractF2m)localObject1;
    if (i > 0) {
      paramAbstractF2m = ((ECPoint.AbstractF2m)localObject1).tauPow(i);
    }
    return paramAbstractF2m;
  }
  
  public static ECPoint.AbstractF2m multiplyRTnaf(ECPoint.AbstractF2m paramAbstractF2m, BigInteger paramBigInteger)
  {
    Object localObject = (ECCurve.AbstractF2m)paramAbstractF2m.getCurve();
    int i = ((ECCurve.AbstractF2m)localObject).getFieldSize();
    int j = ((ECCurve.AbstractF2m)localObject).getA().toBigInteger().intValue();
    byte b = getMu(j);
    localObject = ((ECCurve.AbstractF2m)localObject).getSi();
    return multiplyTnaf(paramAbstractF2m, partModReduction(paramBigInteger, i, (byte)j, (BigInteger[])localObject, b, (byte)10));
  }
  
  public static ECPoint.AbstractF2m multiplyTnaf(ECPoint.AbstractF2m paramAbstractF2m, ZTauElement paramZTauElement)
  {
    return multiplyFromTnaf(paramAbstractF2m, tauAdicNaf(getMu(((ECCurve.AbstractF2m)paramAbstractF2m.getCurve()).getA()), paramZTauElement));
  }
  
  public static BigInteger norm(byte paramByte, ZTauElement paramZTauElement)
  {
    BigInteger localBigInteger2 = paramZTauElement.u.multiply(paramZTauElement.u);
    BigInteger localBigInteger3 = paramZTauElement.u.multiply(paramZTauElement.v);
    BigInteger localBigInteger1 = paramZTauElement.v.multiply(paramZTauElement.v).shiftLeft(1);
    if (paramByte == 1) {}
    for (paramZTauElement = localBigInteger2.add(localBigInteger3);; paramZTauElement = localBigInteger2.subtract(localBigInteger3))
    {
      return paramZTauElement.add(localBigInteger1);
      if (paramByte != -1) {
        break;
      }
    }
    throw new IllegalArgumentException("mu must be 1 or -1");
  }
  
  public static SimpleBigDecimal norm(byte paramByte, SimpleBigDecimal paramSimpleBigDecimal1, SimpleBigDecimal paramSimpleBigDecimal2)
  {
    SimpleBigDecimal localSimpleBigDecimal = paramSimpleBigDecimal1.multiply(paramSimpleBigDecimal1);
    paramSimpleBigDecimal1 = paramSimpleBigDecimal1.multiply(paramSimpleBigDecimal2);
    paramSimpleBigDecimal2 = paramSimpleBigDecimal2.multiply(paramSimpleBigDecimal2).shiftLeft(1);
    if (paramByte == 1) {}
    for (paramSimpleBigDecimal1 = localSimpleBigDecimal.add(paramSimpleBigDecimal1);; paramSimpleBigDecimal1 = localSimpleBigDecimal.subtract(paramSimpleBigDecimal1))
    {
      return paramSimpleBigDecimal1.add(paramSimpleBigDecimal2);
      if (paramByte != -1) {
        break;
      }
    }
    throw new IllegalArgumentException("mu must be 1 or -1");
  }
  
  public static ZTauElement partModReduction(BigInteger paramBigInteger, int paramInt, byte paramByte1, BigInteger[] paramArrayOfBigInteger, byte paramByte2, byte paramByte3)
  {
    BigInteger localBigInteger;
    if (paramByte2 == 1) {
      localBigInteger = paramArrayOfBigInteger[0].add(paramArrayOfBigInteger[1]);
    } else {
      localBigInteger = paramArrayOfBigInteger[0].subtract(paramArrayOfBigInteger[1]);
    }
    Object localObject = getLucas(paramByte2, paramInt, true)[1];
    localObject = round(approximateDivisionByN(paramBigInteger, paramArrayOfBigInteger[0], (BigInteger)localObject, paramByte1, paramInt, paramByte3), approximateDivisionByN(paramBigInteger, paramArrayOfBigInteger[1], (BigInteger)localObject, paramByte1, paramInt, paramByte3), paramByte2);
    return new ZTauElement(paramBigInteger.subtract(localBigInteger.multiply(((ZTauElement)localObject).u)).subtract(BigInteger.valueOf(2L).multiply(paramArrayOfBigInteger[1]).multiply(((ZTauElement)localObject).v)), paramArrayOfBigInteger[1].multiply(((ZTauElement)localObject).u).subtract(paramArrayOfBigInteger[0].multiply(((ZTauElement)localObject).v)));
  }
  
  public static ZTauElement round(SimpleBigDecimal paramSimpleBigDecimal1, SimpleBigDecimal paramSimpleBigDecimal2, byte paramByte)
  {
    int i = paramSimpleBigDecimal1.getScale();
    if (paramSimpleBigDecimal2.getScale() == i)
    {
      int k = -1;
      int j = 1;
      if ((paramByte != 1) && (paramByte != -1)) {
        throw new IllegalArgumentException("mu must be 1 or -1");
      }
      BigInteger localBigInteger1 = paramSimpleBigDecimal1.round();
      BigInteger localBigInteger2 = paramSimpleBigDecimal2.round();
      SimpleBigDecimal localSimpleBigDecimal1 = paramSimpleBigDecimal1.subtract(localBigInteger1);
      paramSimpleBigDecimal2 = paramSimpleBigDecimal2.subtract(localBigInteger2);
      paramSimpleBigDecimal1 = localSimpleBigDecimal1.add(localSimpleBigDecimal1);
      if (paramByte == 1) {
        paramSimpleBigDecimal1 = paramSimpleBigDecimal1.add(paramSimpleBigDecimal2);
      } else {
        paramSimpleBigDecimal1 = paramSimpleBigDecimal1.subtract(paramSimpleBigDecimal2);
      }
      SimpleBigDecimal localSimpleBigDecimal3 = paramSimpleBigDecimal2.add(paramSimpleBigDecimal2).add(paramSimpleBigDecimal2);
      SimpleBigDecimal localSimpleBigDecimal2 = localSimpleBigDecimal3.add(paramSimpleBigDecimal2);
      if (paramByte == 1)
      {
        paramSimpleBigDecimal2 = localSimpleBigDecimal1.subtract(localSimpleBigDecimal3);
        localSimpleBigDecimal1 = localSimpleBigDecimal1.add(localSimpleBigDecimal2);
      }
      else
      {
        paramSimpleBigDecimal2 = localSimpleBigDecimal1.add(localSimpleBigDecimal3);
        localSimpleBigDecimal1 = localSimpleBigDecimal1.subtract(localSimpleBigDecimal2);
      }
      int n = paramSimpleBigDecimal1.compareTo(ECConstants.ONE);
      i = 0;
      int m = 0;
      if (n >= 0)
      {
        if (paramSimpleBigDecimal2.compareTo(MINUS_ONE) >= 0) {
          break label209;
        }
      }
      else
      {
        i = m;
        if (localSimpleBigDecimal1.compareTo(ECConstants.TWO) < 0) {
          break label206;
        }
      }
      i = paramByte;
      label206:
      j = 0;
      label209:
      if (paramSimpleBigDecimal1.compareTo(MINUS_ONE) < 0) {
        if (paramSimpleBigDecimal2.compareTo(ECConstants.ONE) < 0) {
          break label251;
        }
      } else {
        if (localSimpleBigDecimal1.compareTo(MINUS_TWO) >= 0) {
          break label247;
        }
      }
      i = (byte)-paramByte;
      label247:
      k = j;
      label251:
      return new ZTauElement(localBigInteger1.add(BigInteger.valueOf(k)), localBigInteger2.add(BigInteger.valueOf(i)));
    }
    throw new IllegalArgumentException("lambda0 and lambda1 do not have same scale");
  }
  
  public static ECPoint.AbstractF2m tau(ECPoint.AbstractF2m paramAbstractF2m)
  {
    return paramAbstractF2m.tau();
  }
  
  public static byte[] tauAdicNaf(byte paramByte, ZTauElement paramZTauElement)
  {
    if ((paramByte != 1) && (paramByte != -1)) {
      throw new IllegalArgumentException("mu must be 1 or -1");
    }
    int i = norm(paramByte, paramZTauElement).bitLength();
    if (i > 30) {
      i += 4;
    } else {
      i = 34;
    }
    byte[] arrayOfByte = new byte[i];
    Object localObject = paramZTauElement.u;
    BigInteger localBigInteger = paramZTauElement.v;
    int j = 0;
    i = 0;
    paramZTauElement = (ZTauElement)localObject;
    for (;;)
    {
      if ((paramZTauElement.equals(ECConstants.ZERO)) && (localBigInteger.equals(ECConstants.ZERO)))
      {
        i = j + 1;
        paramZTauElement = new byte[i];
        System.arraycopy(arrayOfByte, 0, paramZTauElement, 0, i);
        return paramZTauElement;
      }
      if (paramZTauElement.testBit(0))
      {
        arrayOfByte[i] = ((byte)ECConstants.TWO.subtract(paramZTauElement.subtract(localBigInteger.shiftLeft(1)).mod(ECConstants.FOUR)).intValue());
        if (arrayOfByte[i] == 1) {
          paramZTauElement = paramZTauElement.clearBit(0);
        } else {
          paramZTauElement = paramZTauElement.add(ECConstants.ONE);
        }
        j = i;
        localObject = paramZTauElement;
      }
      else
      {
        arrayOfByte[i] = 0;
        localObject = paramZTauElement;
      }
      paramZTauElement = ((BigInteger)localObject).shiftRight(1);
      if (paramByte == 1) {
        paramZTauElement = localBigInteger.add(paramZTauElement);
      } else {
        paramZTauElement = localBigInteger.subtract(paramZTauElement);
      }
      localBigInteger = ((BigInteger)localObject).shiftRight(1).negate();
      i += 1;
    }
  }
  
  public static byte[] tauAdicWNaf(byte paramByte1, ZTauElement paramZTauElement, byte paramByte2, BigInteger paramBigInteger1, BigInteger paramBigInteger2, ZTauElement[] paramArrayOfZTauElement)
  {
    if ((paramByte1 != 1) && (paramByte1 != -1)) {
      throw new IllegalArgumentException("mu must be 1 or -1");
    }
    int j = norm(paramByte1, paramZTauElement).bitLength();
    if (j > 30) {
      paramByte2 = j + 4 + paramByte2;
    } else {
      paramByte2 += 34;
    }
    byte[] arrayOfByte = new byte[paramByte2];
    BigInteger localBigInteger3 = paramBigInteger1.shiftRight(1);
    BigInteger localBigInteger1 = paramZTauElement.u;
    paramZTauElement = paramZTauElement.v;
    paramByte2 = 0;
    for (;;)
    {
      if ((localBigInteger1.equals(ECConstants.ZERO)) && (paramZTauElement.equals(ECConstants.ZERO))) {
        return arrayOfByte;
      }
      Object localObject;
      if (localBigInteger1.testBit(0))
      {
        BigInteger localBigInteger2 = localBigInteger1.add(paramZTauElement.multiply(paramBigInteger2)).mod(paramBigInteger1);
        localObject = localBigInteger2;
        if (localBigInteger2.compareTo(localBigInteger3) >= 0) {
          localObject = localBigInteger2.subtract(paramBigInteger1);
        }
        int i = (byte)((BigInteger)localObject).intValue();
        arrayOfByte[paramByte2] = i;
        int k;
        if (i < 0)
        {
          k = (byte)-i;
          j = 0;
        }
        else
        {
          j = 1;
          k = i;
        }
        if (j != 0)
        {
          localBigInteger1 = localBigInteger1.subtract(paramArrayOfZTauElement[k].u);
          localObject = paramZTauElement.subtract(paramArrayOfZTauElement[k].v);
          paramZTauElement = localBigInteger1;
        }
        else
        {
          localBigInteger1 = localBigInteger1.add(paramArrayOfZTauElement[k].u);
          localObject = paramZTauElement.add(paramArrayOfZTauElement[k].v);
          paramZTauElement = localBigInteger1;
        }
      }
      else
      {
        arrayOfByte[paramByte2] = 0;
        localObject = paramZTauElement;
        paramZTauElement = localBigInteger1;
      }
      localBigInteger1 = paramZTauElement.shiftRight(1);
      if (paramByte1 == 1) {
        localBigInteger1 = ((BigInteger)localObject).add(localBigInteger1);
      } else {
        localBigInteger1 = ((BigInteger)localObject).subtract(localBigInteger1);
      }
      paramZTauElement = paramZTauElement.shiftRight(1).negate();
      paramByte2 += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\Tnaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */