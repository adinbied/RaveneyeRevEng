package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.AbstractFp;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat160;

public class SecP160R1Point
  extends ECPoint.AbstractFp
{
  public SecP160R1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
  }
  
  public SecP160R1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
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
  
  SecP160R1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
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
    Object localObject2 = (SecP160R1FieldElement)this.x;
    Object localObject3 = (SecP160R1FieldElement)this.y;
    Object localObject4 = (SecP160R1FieldElement)paramECPoint.getXCoord();
    Object localObject1 = (SecP160R1FieldElement)paramECPoint.getYCoord();
    SecP160R1FieldElement localSecP160R1FieldElement1 = (SecP160R1FieldElement)this.zs[0];
    SecP160R1FieldElement localSecP160R1FieldElement2 = (SecP160R1FieldElement)paramECPoint.getZCoord(0);
    int[] arrayOfInt1 = Nat160.createExt();
    int[] arrayOfInt2 = Nat160.create();
    int[] arrayOfInt3 = Nat160.create();
    int[] arrayOfInt4 = Nat160.create();
    boolean bool1 = localSecP160R1FieldElement1.isOne();
    if (bool1)
    {
      paramECPoint = ((SecP160R1FieldElement)localObject4).x;
      localObject1 = ((SecP160R1FieldElement)localObject1).x;
    }
    else
    {
      SecP160R1Field.square(localSecP160R1FieldElement1.x, arrayOfInt3);
      SecP160R1Field.multiply(arrayOfInt3, ((SecP160R1FieldElement)localObject4).x, arrayOfInt2);
      SecP160R1Field.multiply(arrayOfInt3, localSecP160R1FieldElement1.x, arrayOfInt3);
      SecP160R1Field.multiply(arrayOfInt3, ((SecP160R1FieldElement)localObject1).x, arrayOfInt3);
      paramECPoint = arrayOfInt2;
      localObject1 = arrayOfInt3;
    }
    boolean bool2 = localSecP160R1FieldElement2.isOne();
    if (bool2)
    {
      localObject2 = ((SecP160R1FieldElement)localObject2).x;
      localObject3 = ((SecP160R1FieldElement)localObject3).x;
    }
    else
    {
      SecP160R1Field.square(localSecP160R1FieldElement2.x, arrayOfInt4);
      SecP160R1Field.multiply(arrayOfInt4, ((SecP160R1FieldElement)localObject2).x, arrayOfInt1);
      SecP160R1Field.multiply(arrayOfInt4, localSecP160R1FieldElement2.x, arrayOfInt4);
      SecP160R1Field.multiply(arrayOfInt4, ((SecP160R1FieldElement)localObject3).x, arrayOfInt4);
      localObject2 = arrayOfInt1;
      localObject3 = arrayOfInt4;
    }
    localObject4 = Nat160.create();
    SecP160R1Field.subtract((int[])localObject2, paramECPoint, (int[])localObject4);
    SecP160R1Field.subtract((int[])localObject3, (int[])localObject1, arrayOfInt2);
    if (Nat160.isZero((int[])localObject4))
    {
      if (Nat160.isZero(arrayOfInt2)) {
        return twice();
      }
      return localECCurve.getInfinity();
    }
    SecP160R1Field.square((int[])localObject4, arrayOfInt3);
    paramECPoint = Nat160.create();
    SecP160R1Field.multiply(arrayOfInt3, (int[])localObject4, paramECPoint);
    SecP160R1Field.multiply(arrayOfInt3, (int[])localObject2, arrayOfInt3);
    SecP160R1Field.negate(paramECPoint, paramECPoint);
    Nat160.mul((int[])localObject3, paramECPoint, arrayOfInt1);
    SecP160R1Field.reduce32(Nat160.addBothTo(arrayOfInt3, arrayOfInt3, paramECPoint), paramECPoint);
    localObject1 = new SecP160R1FieldElement(arrayOfInt4);
    SecP160R1Field.square(arrayOfInt2, ((SecP160R1FieldElement)localObject1).x);
    SecP160R1Field.subtract(((SecP160R1FieldElement)localObject1).x, paramECPoint, ((SecP160R1FieldElement)localObject1).x);
    paramECPoint = new SecP160R1FieldElement(paramECPoint);
    SecP160R1Field.subtract(arrayOfInt3, ((SecP160R1FieldElement)localObject1).x, paramECPoint.x);
    SecP160R1Field.multiplyAddToExt(paramECPoint.x, arrayOfInt2, arrayOfInt1);
    SecP160R1Field.reduce(arrayOfInt1, paramECPoint.x);
    localObject2 = new SecP160R1FieldElement((int[])localObject4);
    if (!bool1) {
      SecP160R1Field.multiply(((SecP160R1FieldElement)localObject2).x, localSecP160R1FieldElement1.x, ((SecP160R1FieldElement)localObject2).x);
    }
    if (!bool2) {
      SecP160R1Field.multiply(((SecP160R1FieldElement)localObject2).x, localSecP160R1FieldElement2.x, ((SecP160R1FieldElement)localObject2).x);
    }
    bool1 = this.withCompression;
    return new SecP160R1Point(localECCurve, (ECFieldElement)localObject1, paramECPoint, new ECFieldElement[] { localObject2 }, bool1);
  }
  
  protected ECPoint detach()
  {
    return new SecP160R1Point(null, getAffineXCoord(), getAffineYCoord());
  }
  
  public ECPoint negate()
  {
    if (isInfinity()) {
      return this;
    }
    return new SecP160R1Point(this.curve, this.x, this.y.negate(), this.zs, this.withCompression);
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
    SecP160R1FieldElement localSecP160R1FieldElement1 = (SecP160R1FieldElement)this.y;
    if (localSecP160R1FieldElement1.isZero()) {
      return localECCurve.getInfinity();
    }
    SecP160R1FieldElement localSecP160R1FieldElement3 = (SecP160R1FieldElement)this.x;
    SecP160R1FieldElement localSecP160R1FieldElement2 = (SecP160R1FieldElement)this.zs[0];
    int[] arrayOfInt1 = Nat160.create();
    Object localObject2 = Nat160.create();
    int[] arrayOfInt2 = Nat160.create();
    SecP160R1Field.square(localSecP160R1FieldElement1.x, arrayOfInt2);
    int[] arrayOfInt3 = Nat160.create();
    SecP160R1Field.square(arrayOfInt2, arrayOfInt3);
    boolean bool = localSecP160R1FieldElement2.isOne();
    Object localObject1 = localSecP160R1FieldElement2.x;
    if (!bool)
    {
      SecP160R1Field.square(localSecP160R1FieldElement2.x, (int[])localObject2);
      localObject1 = localObject2;
    }
    SecP160R1Field.subtract(localSecP160R1FieldElement3.x, (int[])localObject1, arrayOfInt1);
    SecP160R1Field.add(localSecP160R1FieldElement3.x, (int[])localObject1, (int[])localObject2);
    SecP160R1Field.multiply((int[])localObject2, arrayOfInt1, (int[])localObject2);
    SecP160R1Field.reduce32(Nat160.addBothTo((int[])localObject2, (int[])localObject2, (int[])localObject2), (int[])localObject2);
    SecP160R1Field.multiply(arrayOfInt2, localSecP160R1FieldElement3.x, arrayOfInt2);
    SecP160R1Field.reduce32(Nat.shiftUpBits(5, arrayOfInt2, 2, 0), arrayOfInt2);
    SecP160R1Field.reduce32(Nat.shiftUpBits(5, arrayOfInt3, 3, 0, arrayOfInt1), arrayOfInt1);
    localObject1 = new SecP160R1FieldElement(arrayOfInt3);
    SecP160R1Field.square((int[])localObject2, ((SecP160R1FieldElement)localObject1).x);
    SecP160R1Field.subtract(((SecP160R1FieldElement)localObject1).x, arrayOfInt2, ((SecP160R1FieldElement)localObject1).x);
    SecP160R1Field.subtract(((SecP160R1FieldElement)localObject1).x, arrayOfInt2, ((SecP160R1FieldElement)localObject1).x);
    localSecP160R1FieldElement3 = new SecP160R1FieldElement(arrayOfInt2);
    SecP160R1Field.subtract(arrayOfInt2, ((SecP160R1FieldElement)localObject1).x, localSecP160R1FieldElement3.x);
    SecP160R1Field.multiply(localSecP160R1FieldElement3.x, (int[])localObject2, localSecP160R1FieldElement3.x);
    SecP160R1Field.subtract(localSecP160R1FieldElement3.x, arrayOfInt1, localSecP160R1FieldElement3.x);
    localObject2 = new SecP160R1FieldElement((int[])localObject2);
    SecP160R1Field.twice(localSecP160R1FieldElement1.x, ((SecP160R1FieldElement)localObject2).x);
    if (!bool) {
      SecP160R1Field.multiply(((SecP160R1FieldElement)localObject2).x, localSecP160R1FieldElement2.x, ((SecP160R1FieldElement)localObject2).x);
    }
    bool = this.withCompression;
    return new SecP160R1Point(localECCurve, (ECFieldElement)localObject1, localSecP160R1FieldElement3, new ECFieldElement[] { localObject2 }, bool);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP160R1Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */