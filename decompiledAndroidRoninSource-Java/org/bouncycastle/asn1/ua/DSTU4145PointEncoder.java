package org.bouncycastle.asn1.ua;

import java.math.BigInteger;
import java.util.Random;
import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;

public abstract class DSTU4145PointEncoder
{
  public static ECPoint decodePoint(ECCurve paramECCurve, byte[] paramArrayOfByte)
  {
    ECFieldElement localECFieldElement2 = paramECCurve.fromBigInteger(BigInteger.valueOf(paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0x1));
    paramArrayOfByte = paramECCurve.fromBigInteger(new BigInteger(1, paramArrayOfByte));
    Object localObject = paramArrayOfByte;
    if (!trace(paramArrayOfByte).equals(paramECCurve.getA())) {
      localObject = paramArrayOfByte.addOne();
    }
    paramArrayOfByte = null;
    if (((ECFieldElement)localObject).isZero())
    {
      paramArrayOfByte = paramECCurve.getB().sqrt();
    }
    else
    {
      ECFieldElement localECFieldElement1 = solveQuadraticEquation(paramECCurve, ((ECFieldElement)localObject).square().invert().multiply(paramECCurve.getB()).add(paramECCurve.getA()).add((ECFieldElement)localObject));
      if (localECFieldElement1 != null)
      {
        paramArrayOfByte = localECFieldElement1;
        if (!trace(localECFieldElement1).equals(localECFieldElement2)) {
          paramArrayOfByte = localECFieldElement1.addOne();
        }
        paramArrayOfByte = ((ECFieldElement)localObject).multiply(paramArrayOfByte);
      }
    }
    if (paramArrayOfByte != null) {
      return paramECCurve.validatePoint(((ECFieldElement)localObject).toBigInteger(), paramArrayOfByte.toBigInteger());
    }
    throw new IllegalArgumentException("Invalid point compression");
  }
  
  public static byte[] encodePoint(ECPoint paramECPoint)
  {
    paramECPoint = paramECPoint.normalize();
    ECFieldElement localECFieldElement = paramECPoint.getAffineXCoord();
    byte[] arrayOfByte = localECFieldElement.getEncoded();
    if (!localECFieldElement.isZero())
    {
      if (trace(paramECPoint.getAffineYCoord().divide(localECFieldElement)).isOne())
      {
        i = arrayOfByte.length - 1;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] | 0x1));
        return arrayOfByte;
      }
      int i = arrayOfByte.length - 1;
      arrayOfByte[i] = ((byte)(arrayOfByte[i] & 0xFE));
    }
    return arrayOfByte;
  }
  
  private static ECFieldElement solveQuadraticEquation(ECCurve paramECCurve, ECFieldElement paramECFieldElement)
  {
    if (paramECFieldElement.isZero()) {
      return paramECFieldElement;
    }
    ECFieldElement localECFieldElement3 = paramECCurve.fromBigInteger(ECConstants.ZERO);
    Random localRandom = new Random();
    int j = paramECFieldElement.getFieldSize();
    ECFieldElement localECFieldElement1;
    do
    {
      ECFieldElement localECFieldElement4 = paramECCurve.fromBigInteger(new BigInteger(j, localRandom));
      int i = 1;
      ECFieldElement localECFieldElement2 = paramECFieldElement;
      localECFieldElement1 = localECFieldElement3;
      while (i <= j - 1)
      {
        localECFieldElement2 = localECFieldElement2.square();
        localECFieldElement1 = localECFieldElement1.square().add(localECFieldElement2.multiply(localECFieldElement4));
        localECFieldElement2 = localECFieldElement2.add(paramECFieldElement);
        i += 1;
      }
      if (!localECFieldElement2.isZero()) {
        return null;
      }
    } while (localECFieldElement1.square().add(localECFieldElement1).isZero());
    return localECFieldElement1;
  }
  
  private static ECFieldElement trace(ECFieldElement paramECFieldElement)
  {
    int i = 1;
    ECFieldElement localECFieldElement = paramECFieldElement;
    while (i < paramECFieldElement.getFieldSize())
    {
      localECFieldElement = localECFieldElement.square().add(paramECFieldElement);
      i += 1;
    }
    return localECFieldElement;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn\\ua\DSTU4145PointEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */