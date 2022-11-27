package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.AbstractFp;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;

public class SecP224K1Point
  extends ECPoint.AbstractFp
{
  public SecP224K1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
  }
  
  public SecP224K1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
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
  
  SecP224K1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
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
    if (this == paramECPoint) {
      return twice();
    }
    ECCurve localECCurve = getCurve();
    Object localObject2 = (SecP224K1FieldElement)this.x;
    Object localObject3 = (SecP224K1FieldElement)this.y;
    Object localObject4 = (SecP224K1FieldElement)paramECPoint.getXCoord();
    Object localObject1 = (SecP224K1FieldElement)paramECPoint.getYCoord();
    SecP224K1FieldElement localSecP224K1FieldElement1 = (SecP224K1FieldElement)this.zs[0];
    SecP224K1FieldElement localSecP224K1FieldElement2 = (SecP224K1FieldElement)paramECPoint.getZCoord(0);
    int[] arrayOfInt1 = Nat224.createExt();
    int[] arrayOfInt2 = Nat224.create();
    int[] arrayOfInt3 = Nat224.create();
    int[] arrayOfInt4 = Nat224.create();
    boolean bool1 = localSecP224K1FieldElement1.isOne();
    if (bool1)
    {
      paramECPoint = ((SecP224K1FieldElement)localObject4).x;
      localObject1 = ((SecP224K1FieldElement)localObject1).x;
    }
    else
    {
      SecP224K1Field.square(localSecP224K1FieldElement1.x, arrayOfInt3);
      SecP224K1Field.multiply(arrayOfInt3, ((SecP224K1FieldElement)localObject4).x, arrayOfInt2);
      SecP224K1Field.multiply(arrayOfInt3, localSecP224K1FieldElement1.x, arrayOfInt3);
      SecP224K1Field.multiply(arrayOfInt3, ((SecP224K1FieldElement)localObject1).x, arrayOfInt3);
      paramECPoint = arrayOfInt2;
      localObject1 = arrayOfInt3;
    }
    boolean bool2 = localSecP224K1FieldElement2.isOne();
    if (bool2)
    {
      localObject2 = ((SecP224K1FieldElement)localObject2).x;
      localObject3 = ((SecP224K1FieldElement)localObject3).x;
    }
    else
    {
      SecP224K1Field.square(localSecP224K1FieldElement2.x, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, ((SecP224K1FieldElement)localObject2).x, arrayOfInt1);
      SecP224K1Field.multiply(arrayOfInt4, localSecP224K1FieldElement2.x, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, ((SecP224K1FieldElement)localObject3).x, arrayOfInt4);
      localObject2 = arrayOfInt1;
      localObject3 = arrayOfInt4;
    }
    localObject4 = Nat224.create();
    SecP224K1Field.subtract((int[])localObject2, paramECPoint, (int[])localObject4);
    SecP224K1Field.subtract((int[])localObject3, (int[])localObject1, arrayOfInt2);
    if (Nat224.isZero((int[])localObject4))
    {
      if (Nat224.isZero(arrayOfInt2)) {
        return twice();
      }
      return localECCurve.getInfinity();
    }
    SecP224K1Field.square((int[])localObject4, arrayOfInt3);
    paramECPoint = Nat224.create();
    SecP224K1Field.multiply(arrayOfInt3, (int[])localObject4, paramECPoint);
    SecP224K1Field.multiply(arrayOfInt3, (int[])localObject2, arrayOfInt3);
    SecP224K1Field.negate(paramECPoint, paramECPoint);
    Nat224.mul((int[])localObject3, paramECPoint, arrayOfInt1);
    SecP224K1Field.reduce32(Nat224.addBothTo(arrayOfInt3, arrayOfInt3, paramECPoint), paramECPoint);
    localObject1 = new SecP224K1FieldElement(arrayOfInt4);
    SecP224K1Field.square(arrayOfInt2, ((SecP224K1FieldElement)localObject1).x);
    SecP224K1Field.subtract(((SecP224K1FieldElement)localObject1).x, paramECPoint, ((SecP224K1FieldElement)localObject1).x);
    paramECPoint = new SecP224K1FieldElement(paramECPoint);
    SecP224K1Field.subtract(arrayOfInt3, ((SecP224K1FieldElement)localObject1).x, paramECPoint.x);
    SecP224K1Field.multiplyAddToExt(paramECPoint.x, arrayOfInt2, arrayOfInt1);
    SecP224K1Field.reduce(arrayOfInt1, paramECPoint.x);
    localObject2 = new SecP224K1FieldElement((int[])localObject4);
    if (!bool1) {
      SecP224K1Field.multiply(((SecP224K1FieldElement)localObject2).x, localSecP224K1FieldElement1.x, ((SecP224K1FieldElement)localObject2).x);
    }
    if (!bool2) {
      SecP224K1Field.multiply(((SecP224K1FieldElement)localObject2).x, localSecP224K1FieldElement2.x, ((SecP224K1FieldElement)localObject2).x);
    }
    bool1 = this.withCompression;
    return new SecP224K1Point(localECCurve, (ECFieldElement)localObject1, paramECPoint, new ECFieldElement[] { localObject2 }, bool1);
  }
  
  protected ECPoint detach()
  {
    return new SecP224K1Point(null, getAffineXCoord(), getAffineYCoord());
  }
  
  public ECPoint negate()
  {
    if (isInfinity()) {
      return this;
    }
    return new SecP224K1Point(this.curve, this.x, this.y.negate(), this.zs, this.withCompression);
  }
  
  public ECPoint threeTimes()
  {
    if (!isInfinity())
    {
      if (this.y.isZero()) {
        return this;
      }
      return twice().add(this);
    }
    return this;
  }
  
  public ECPoint twice()
  {
    if (isInfinity()) {
      return this;
    }
    ECCurve localECCurve = getCurve();
    SecP224K1FieldElement localSecP224K1FieldElement1 = (SecP224K1FieldElement)this.y;
    if (localSecP224K1FieldElement1.isZero()) {
      return localECCurve.getInfinity();
    }
    Object localObject2 = (SecP224K1FieldElement)this.x;
    SecP224K1FieldElement localSecP224K1FieldElement2 = (SecP224K1FieldElement)this.zs[0];
    Object localObject1 = Nat224.create();
    SecP224K1Field.square(localSecP224K1FieldElement1.x, (int[])localObject1);
    Object localObject3 = Nat224.create();
    SecP224K1Field.square((int[])localObject1, (int[])localObject3);
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.square(((SecP224K1FieldElement)localObject2).x, arrayOfInt);
    SecP224K1Field.reduce32(Nat224.addBothTo(arrayOfInt, arrayOfInt, arrayOfInt), arrayOfInt);
    SecP224K1Field.multiply((int[])localObject1, ((SecP224K1FieldElement)localObject2).x, (int[])localObject1);
    SecP224K1Field.reduce32(Nat.shiftUpBits(7, (int[])localObject1, 2, 0), (int[])localObject1);
    localObject2 = Nat224.create();
    SecP224K1Field.reduce32(Nat.shiftUpBits(7, (int[])localObject3, 3, 0, (int[])localObject2), (int[])localObject2);
    localObject3 = new SecP224K1FieldElement((int[])localObject3);
    SecP224K1Field.square(arrayOfInt, ((SecP224K1FieldElement)localObject3).x);
    SecP224K1Field.subtract(((SecP224K1FieldElement)localObject3).x, (int[])localObject1, ((SecP224K1FieldElement)localObject3).x);
    SecP224K1Field.subtract(((SecP224K1FieldElement)localObject3).x, (int[])localObject1, ((SecP224K1FieldElement)localObject3).x);
    SecP224K1FieldElement localSecP224K1FieldElement3 = new SecP224K1FieldElement((int[])localObject1);
    SecP224K1Field.subtract((int[])localObject1, ((SecP224K1FieldElement)localObject3).x, localSecP224K1FieldElement3.x);
    SecP224K1Field.multiply(localSecP224K1FieldElement3.x, arrayOfInt, localSecP224K1FieldElement3.x);
    SecP224K1Field.subtract(localSecP224K1FieldElement3.x, (int[])localObject2, localSecP224K1FieldElement3.x);
    localObject1 = new SecP224K1FieldElement(arrayOfInt);
    SecP224K1Field.twice(localSecP224K1FieldElement1.x, ((SecP224K1FieldElement)localObject1).x);
    if (!localSecP224K1FieldElement2.isOne()) {
      SecP224K1Field.multiply(((SecP224K1FieldElement)localObject1).x, localSecP224K1FieldElement2.x, ((SecP224K1FieldElement)localObject1).x);
    }
    boolean bool = this.withCompression;
    return new SecP224K1Point(localECCurve, (ECFieldElement)localObject3, localSecP224K1FieldElement3, new ECFieldElement[] { localObject1 }, bool);
  }
  
  public ECPoint twicePlus(ECPoint paramECPoint)
  {
    if (this == paramECPoint) {
      return threeTimes();
    }
    if (isInfinity()) {
      return paramECPoint;
    }
    if (paramECPoint.isInfinity()) {
      return twice();
    }
    if (this.y.isZero()) {
      return paramECPoint;
    }
    return twice().add(paramECPoint);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP224K1Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */