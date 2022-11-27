package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.AbstractF2m;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

public class SecT571R1Point
  extends ECPoint.AbstractF2m
{
  public SecT571R1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
  }
  
  public SecT571R1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
  {
    super(paramECCurve, paramECFieldElement1, paramECFieldElement2);
    int j = 1;
    int i;
    if (paramECFieldElement1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (paramECFieldElement2 != null) {
      j = 0;
    }
    if (i == j)
    {
      this.withCompression = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("Exactly one of the field elements is null");
  }
  
  SecT571R1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
  {
    super(paramECCurve, paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement);
    this.withCompression = paramBoolean;
  }
  
  public ECPoint add(ECPoint paramECPoint)
  {
    if (isInfinity()) {
      return paramECPoint;
    }
    if (paramECPoint.isInfinity()) {
      return this;
    }
    ECCurve localECCurve = getCurve();
    Object localObject4 = (SecT571FieldElement)this.x;
    SecT571FieldElement localSecT571FieldElement4 = (SecT571FieldElement)paramECPoint.getRawXCoord();
    if (((SecT571FieldElement)localObject4).isZero())
    {
      if (localSecT571FieldElement4.isZero()) {
        return localECCurve.getInfinity();
      }
      return paramECPoint.add(this);
    }
    SecT571FieldElement localSecT571FieldElement1 = (SecT571FieldElement)this.y;
    SecT571FieldElement localSecT571FieldElement2 = (SecT571FieldElement)this.zs[0];
    SecT571FieldElement localSecT571FieldElement3 = (SecT571FieldElement)paramECPoint.getRawYCoord();
    Object localObject3 = (SecT571FieldElement)paramECPoint.getZCoord(0);
    long[] arrayOfLong4 = Nat576.create64();
    long[] arrayOfLong2 = Nat576.create64();
    long[] arrayOfLong5 = Nat576.create64();
    long[] arrayOfLong3 = Nat576.create64();
    if (localSecT571FieldElement2.isOne()) {
      paramECPoint = null;
    } else {
      paramECPoint = SecT571Field.precompMultiplicand(localSecT571FieldElement2.x);
    }
    Object localObject1;
    Object localObject2;
    if (paramECPoint == null)
    {
      localObject1 = localSecT571FieldElement4.x;
      localObject2 = localSecT571FieldElement3.x;
    }
    else
    {
      SecT571Field.multiplyPrecomp(localSecT571FieldElement4.x, paramECPoint, arrayOfLong2);
      SecT571Field.multiplyPrecomp(localSecT571FieldElement3.x, paramECPoint, arrayOfLong3);
      localObject1 = arrayOfLong2;
      localObject2 = arrayOfLong3;
    }
    if (((SecT571FieldElement)localObject3).isOne()) {
      localObject3 = null;
    } else {
      localObject3 = SecT571Field.precompMultiplicand(((SecT571FieldElement)localObject3).x);
    }
    localObject4 = ((SecT571FieldElement)localObject4).x;
    long[] arrayOfLong1;
    if (localObject3 == null)
    {
      arrayOfLong1 = localSecT571FieldElement1.x;
    }
    else
    {
      SecT571Field.multiplyPrecomp((long[])localObject4, (long[])localObject3, arrayOfLong4);
      SecT571Field.multiplyPrecomp(localSecT571FieldElement1.x, (long[])localObject3, arrayOfLong5);
      localObject4 = arrayOfLong4;
      arrayOfLong1 = arrayOfLong5;
    }
    SecT571Field.add(arrayOfLong1, (long[])localObject2, arrayOfLong5);
    SecT571Field.add((long[])localObject4, (long[])localObject1, arrayOfLong3);
    if (Nat576.isZero64(arrayOfLong3))
    {
      if (Nat576.isZero64(arrayOfLong5)) {
        return twice();
      }
      return localECCurve.getInfinity();
    }
    if (localSecT571FieldElement4.isZero())
    {
      localObject1 = normalize();
      paramECPoint = (SecT571FieldElement)((ECPoint)localObject1).getXCoord();
      localObject1 = ((ECPoint)localObject1).getYCoord();
      localObject3 = ((ECFieldElement)localObject1).add(localSecT571FieldElement3).divide(paramECPoint);
      localObject2 = (SecT571FieldElement)((ECFieldElement)localObject3).square().add((ECFieldElement)localObject3).add(paramECPoint).addOne();
      if (((SecT571FieldElement)localObject2).isZero()) {
        return new SecT571R1Point(localECCurve, (ECFieldElement)localObject2, SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
      }
      paramECPoint = (SecT571FieldElement)((ECFieldElement)localObject3).multiply(paramECPoint.add((ECFieldElement)localObject2)).add((ECFieldElement)localObject2).add((ECFieldElement)localObject1).divide((ECFieldElement)localObject2).add((ECFieldElement)localObject2);
      localObject1 = (SecT571FieldElement)localECCurve.fromBigInteger(ECConstants.ONE);
      localObject3 = paramECPoint;
    }
    else
    {
      SecT571Field.square(arrayOfLong3, arrayOfLong3);
      arrayOfLong1 = SecT571Field.precompMultiplicand(arrayOfLong5);
      SecT571Field.multiplyPrecomp((long[])localObject4, arrayOfLong1, arrayOfLong4);
      SecT571Field.multiplyPrecomp((long[])localObject1, arrayOfLong1, arrayOfLong2);
      localObject1 = new SecT571FieldElement(arrayOfLong4);
      SecT571Field.multiply(arrayOfLong4, arrayOfLong2, ((SecT571FieldElement)localObject1).x);
      if (((SecT571FieldElement)localObject1).isZero()) {
        return new SecT571R1Point(localECCurve, (ECFieldElement)localObject1, SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
      }
      localObject2 = new SecT571FieldElement(arrayOfLong5);
      SecT571Field.multiplyPrecomp(arrayOfLong3, arrayOfLong1, ((SecT571FieldElement)localObject2).x);
      if (localObject3 != null) {
        SecT571Field.multiplyPrecomp(((SecT571FieldElement)localObject2).x, (long[])localObject3, ((SecT571FieldElement)localObject2).x);
      }
      localObject4 = Nat576.createExt64();
      SecT571Field.add(arrayOfLong2, arrayOfLong3, arrayOfLong3);
      SecT571Field.squareAddToExt(arrayOfLong3, (long[])localObject4);
      SecT571Field.add(localSecT571FieldElement1.x, localSecT571FieldElement2.x, arrayOfLong3);
      SecT571Field.multiplyAddToExt(arrayOfLong3, ((SecT571FieldElement)localObject2).x, (long[])localObject4);
      localObject3 = new SecT571FieldElement(arrayOfLong3);
      SecT571Field.reduce((long[])localObject4, ((SecT571FieldElement)localObject3).x);
      if (paramECPoint != null) {
        SecT571Field.multiplyPrecomp(((SecT571FieldElement)localObject2).x, paramECPoint, ((SecT571FieldElement)localObject2).x);
      }
      paramECPoint = (ECPoint)localObject1;
      localObject1 = localObject2;
      localObject2 = paramECPoint;
    }
    boolean bool = this.withCompression;
    return new SecT571R1Point(localECCurve, (ECFieldElement)localObject2, (ECFieldElement)localObject3, new ECFieldElement[] { localObject1 }, bool);
  }
  
  protected ECPoint detach()
  {
    return new SecT571R1Point(null, getAffineXCoord(), getAffineYCoord());
  }
  
  protected boolean getCompressionYTilde()
  {
    ECFieldElement localECFieldElement = getRawXCoord();
    boolean bool2 = localECFieldElement.isZero();
    boolean bool1 = false;
    if (bool2) {
      return false;
    }
    if (getRawYCoord().testBitZero() != localECFieldElement.testBitZero()) {
      bool1 = true;
    }
    return bool1;
  }
  
  public ECFieldElement getYCoord()
  {
    Object localObject = this.x;
    ECFieldElement localECFieldElement1 = this.y;
    if (!isInfinity())
    {
      if (((ECFieldElement)localObject).isZero()) {
        return localECFieldElement1;
      }
      localECFieldElement1 = localECFieldElement1.add((ECFieldElement)localObject).multiply((ECFieldElement)localObject);
      ECFieldElement localECFieldElement2 = this.zs[0];
      localObject = localECFieldElement1;
      if (!localECFieldElement2.isOne()) {
        localObject = localECFieldElement1.divide(localECFieldElement2);
      }
      return (ECFieldElement)localObject;
    }
    return localECFieldElement1;
  }
  
  public ECPoint negate()
  {
    if (isInfinity()) {
      return this;
    }
    ECFieldElement localECFieldElement1 = this.x;
    if (localECFieldElement1.isZero()) {
      return this;
    }
    ECFieldElement localECFieldElement3 = this.y;
    ECFieldElement localECFieldElement2 = this.zs[0];
    ECCurve localECCurve = this.curve;
    localECFieldElement3 = localECFieldElement3.add(localECFieldElement2);
    boolean bool = this.withCompression;
    return new SecT571R1Point(localECCurve, localECFieldElement1, localECFieldElement3, new ECFieldElement[] { localECFieldElement2 }, bool);
  }
  
  public ECPoint twice()
  {
    if (isInfinity()) {
      return this;
    }
    ECCurve localECCurve = getCurve();
    SecT571FieldElement localSecT571FieldElement = (SecT571FieldElement)this.x;
    if (localSecT571FieldElement.isZero()) {
      return localECCurve.getInfinity();
    }
    Object localObject6 = (SecT571FieldElement)this.y;
    Object localObject3 = (SecT571FieldElement)this.zs[0];
    Object localObject5 = Nat576.create64();
    Object localObject1 = Nat576.create64();
    Object localObject2;
    if (((SecT571FieldElement)localObject3).isOne()) {
      localObject2 = null;
    } else {
      localObject2 = SecT571Field.precompMultiplicand(((SecT571FieldElement)localObject3).x);
    }
    Object localObject4 = ((SecT571FieldElement)localObject6).x;
    if (localObject2 == null)
    {
      localObject3 = ((SecT571FieldElement)localObject3).x;
    }
    else
    {
      SecT571Field.multiplyPrecomp((long[])localObject4, (long[])localObject2, (long[])localObject5);
      SecT571Field.square(((SecT571FieldElement)localObject3).x, (long[])localObject1);
      localObject4 = localObject5;
      localObject3 = localObject1;
    }
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.square(((SecT571FieldElement)localObject6).x, arrayOfLong);
    SecT571Field.addBothTo((long[])localObject4, (long[])localObject3, arrayOfLong);
    if (Nat576.isZero64(arrayOfLong)) {
      return new SecT571R1Point(localECCurve, new SecT571FieldElement(arrayOfLong), SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
    }
    localObject6 = Nat576.createExt64();
    SecT571Field.multiplyAddToExt(arrayOfLong, (long[])localObject4, (long[])localObject6);
    localObject4 = new SecT571FieldElement((long[])localObject5);
    SecT571Field.square(arrayOfLong, ((SecT571FieldElement)localObject4).x);
    localObject5 = new SecT571FieldElement(arrayOfLong);
    if (localObject2 != null) {
      SecT571Field.multiply(((SecT571FieldElement)localObject5).x, (long[])localObject3, ((SecT571FieldElement)localObject5).x);
    }
    localObject3 = localSecT571FieldElement.x;
    if (localObject2 == null)
    {
      localObject2 = localObject3;
    }
    else
    {
      SecT571Field.multiplyPrecomp((long[])localObject3, (long[])localObject2, (long[])localObject1);
      localObject2 = localObject1;
    }
    SecT571Field.squareAddToExt((long[])localObject2, (long[])localObject6);
    SecT571Field.reduce((long[])localObject6, (long[])localObject1);
    SecT571Field.addBothTo(((SecT571FieldElement)localObject4).x, ((SecT571FieldElement)localObject5).x, (long[])localObject1);
    localObject1 = new SecT571FieldElement((long[])localObject1);
    boolean bool = this.withCompression;
    return new SecT571R1Point(localECCurve, (ECFieldElement)localObject4, (ECFieldElement)localObject1, new ECFieldElement[] { localObject5 }, bool);
  }
  
  public ECPoint twicePlus(ECPoint paramECPoint)
  {
    if (isInfinity()) {
      return paramECPoint;
    }
    if (paramECPoint.isInfinity()) {
      return twice();
    }
    ECCurve localECCurve = getCurve();
    Object localObject2 = (SecT571FieldElement)this.x;
    if (((SecT571FieldElement)localObject2).isZero()) {
      return paramECPoint;
    }
    SecT571FieldElement localSecT571FieldElement2 = (SecT571FieldElement)paramECPoint.getRawXCoord();
    SecT571FieldElement localSecT571FieldElement1 = (SecT571FieldElement)paramECPoint.getZCoord(0);
    if ((!localSecT571FieldElement2.isZero()) && (localSecT571FieldElement1.isOne()))
    {
      Object localObject3 = (SecT571FieldElement)this.y;
      SecT571FieldElement localSecT571FieldElement3 = (SecT571FieldElement)this.zs[0];
      localSecT571FieldElement1 = (SecT571FieldElement)paramECPoint.getRawYCoord();
      Object localObject1 = Nat576.create64();
      long[] arrayOfLong1 = Nat576.create64();
      long[] arrayOfLong2 = Nat576.create64();
      long[] arrayOfLong3 = Nat576.create64();
      SecT571Field.square(((SecT571FieldElement)localObject2).x, (long[])localObject1);
      SecT571Field.square(((SecT571FieldElement)localObject3).x, arrayOfLong1);
      SecT571Field.square(localSecT571FieldElement3.x, arrayOfLong2);
      SecT571Field.multiply(((SecT571FieldElement)localObject3).x, localSecT571FieldElement3.x, arrayOfLong3);
      SecT571Field.addBothTo(arrayOfLong2, arrayOfLong1, arrayOfLong3);
      localObject3 = SecT571Field.precompMultiplicand(arrayOfLong2);
      SecT571Field.multiplyPrecomp(localSecT571FieldElement1.x, (long[])localObject3, arrayOfLong2);
      SecT571Field.add(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      localObject2 = Nat576.createExt64();
      SecT571Field.multiplyAddToExt(arrayOfLong2, arrayOfLong3, (long[])localObject2);
      SecT571Field.multiplyPrecompAddToExt((long[])localObject1, (long[])localObject3, (long[])localObject2);
      SecT571Field.reduce((long[])localObject2, arrayOfLong2);
      SecT571Field.multiplyPrecomp(localSecT571FieldElement2.x, (long[])localObject3, (long[])localObject1);
      SecT571Field.add((long[])localObject1, arrayOfLong3, arrayOfLong1);
      SecT571Field.square(arrayOfLong1, arrayOfLong1);
      if (Nat576.isZero64(arrayOfLong1))
      {
        if (Nat576.isZero64(arrayOfLong2)) {
          return paramECPoint.twice();
        }
        return localECCurve.getInfinity();
      }
      if (Nat576.isZero64(arrayOfLong2)) {
        return new SecT571R1Point(localECCurve, new SecT571FieldElement(arrayOfLong2), SecT571R1Curve.SecT571R1_B_SQRT, this.withCompression);
      }
      paramECPoint = new SecT571FieldElement();
      SecT571Field.square(arrayOfLong2, paramECPoint.x);
      SecT571Field.multiply(paramECPoint.x, (long[])localObject1, paramECPoint.x);
      localSecT571FieldElement2 = new SecT571FieldElement((long[])localObject1);
      SecT571Field.multiply(arrayOfLong2, arrayOfLong1, localSecT571FieldElement2.x);
      SecT571Field.multiplyPrecomp(localSecT571FieldElement2.x, (long[])localObject3, localSecT571FieldElement2.x);
      localObject1 = new SecT571FieldElement(arrayOfLong1);
      SecT571Field.add(arrayOfLong2, arrayOfLong1, ((SecT571FieldElement)localObject1).x);
      SecT571Field.square(((SecT571FieldElement)localObject1).x, ((SecT571FieldElement)localObject1).x);
      Nat.zero64(18, (long[])localObject2);
      SecT571Field.multiplyAddToExt(((SecT571FieldElement)localObject1).x, arrayOfLong3, (long[])localObject2);
      SecT571Field.addOne(localSecT571FieldElement1.x, arrayOfLong3);
      SecT571Field.multiplyAddToExt(arrayOfLong3, localSecT571FieldElement2.x, (long[])localObject2);
      SecT571Field.reduce((long[])localObject2, ((SecT571FieldElement)localObject1).x);
      boolean bool = this.withCompression;
      return new SecT571R1Point(localECCurve, paramECPoint, (ECFieldElement)localObject1, new ECFieldElement[] { localSecT571FieldElement2 }, bool);
    }
    return twice().add(paramECPoint);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT571R1Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */