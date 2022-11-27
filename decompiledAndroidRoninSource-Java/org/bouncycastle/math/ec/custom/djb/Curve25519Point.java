package org.bouncycastle.math.ec.custom.djb;

import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.AbstractFp;
import org.bouncycastle.math.raw.Nat256;

public class Curve25519Point
  extends ECPoint.AbstractFp
{
  public Curve25519Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
  }
  
  public Curve25519Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
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
  
  Curve25519Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
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
    Object localObject2 = (Curve25519FieldElement)this.x;
    Object localObject3 = (Curve25519FieldElement)this.y;
    Curve25519FieldElement localCurve25519FieldElement1 = (Curve25519FieldElement)this.zs[0];
    Object localObject4 = (Curve25519FieldElement)paramECPoint.getXCoord();
    Object localObject1 = (Curve25519FieldElement)paramECPoint.getYCoord();
    Curve25519FieldElement localCurve25519FieldElement2 = (Curve25519FieldElement)paramECPoint.getZCoord(0);
    int[] arrayOfInt1 = Nat256.createExt();
    int[] arrayOfInt2 = Nat256.create();
    int[] arrayOfInt3 = Nat256.create();
    int[] arrayOfInt4 = Nat256.create();
    boolean bool1 = localCurve25519FieldElement1.isOne();
    if (bool1)
    {
      paramECPoint = ((Curve25519FieldElement)localObject4).x;
      localObject1 = ((Curve25519FieldElement)localObject1).x;
    }
    else
    {
      Curve25519Field.square(localCurve25519FieldElement1.x, arrayOfInt3);
      Curve25519Field.multiply(arrayOfInt3, ((Curve25519FieldElement)localObject4).x, arrayOfInt2);
      Curve25519Field.multiply(arrayOfInt3, localCurve25519FieldElement1.x, arrayOfInt3);
      Curve25519Field.multiply(arrayOfInt3, ((Curve25519FieldElement)localObject1).x, arrayOfInt3);
      paramECPoint = arrayOfInt2;
      localObject1 = arrayOfInt3;
    }
    boolean bool2 = localCurve25519FieldElement2.isOne();
    if (bool2)
    {
      localObject2 = ((Curve25519FieldElement)localObject2).x;
      localObject3 = ((Curve25519FieldElement)localObject3).x;
    }
    else
    {
      Curve25519Field.square(localCurve25519FieldElement2.x, arrayOfInt4);
      Curve25519Field.multiply(arrayOfInt4, ((Curve25519FieldElement)localObject2).x, arrayOfInt1);
      Curve25519Field.multiply(arrayOfInt4, localCurve25519FieldElement2.x, arrayOfInt4);
      Curve25519Field.multiply(arrayOfInt4, ((Curve25519FieldElement)localObject3).x, arrayOfInt4);
      localObject2 = arrayOfInt1;
      localObject3 = arrayOfInt4;
    }
    localObject4 = Nat256.create();
    Curve25519Field.subtract((int[])localObject2, paramECPoint, (int[])localObject4);
    Curve25519Field.subtract((int[])localObject3, (int[])localObject1, arrayOfInt2);
    if (Nat256.isZero((int[])localObject4))
    {
      if (Nat256.isZero(arrayOfInt2)) {
        return twice();
      }
      return localECCurve.getInfinity();
    }
    paramECPoint = Nat256.create();
    Curve25519Field.square((int[])localObject4, paramECPoint);
    int[] arrayOfInt5 = Nat256.create();
    Curve25519Field.multiply(paramECPoint, (int[])localObject4, arrayOfInt5);
    Curve25519Field.multiply(paramECPoint, (int[])localObject2, arrayOfInt3);
    Curve25519Field.negate(arrayOfInt5, arrayOfInt5);
    Nat256.mul((int[])localObject3, arrayOfInt5, arrayOfInt1);
    Curve25519Field.reduce27(Nat256.addBothTo(arrayOfInt3, arrayOfInt3, arrayOfInt5), arrayOfInt5);
    localObject1 = new Curve25519FieldElement(arrayOfInt4);
    Curve25519Field.square(arrayOfInt2, ((Curve25519FieldElement)localObject1).x);
    Curve25519Field.subtract(((Curve25519FieldElement)localObject1).x, arrayOfInt5, ((Curve25519FieldElement)localObject1).x);
    localObject2 = new Curve25519FieldElement(arrayOfInt5);
    Curve25519Field.subtract(arrayOfInt3, ((Curve25519FieldElement)localObject1).x, ((Curve25519FieldElement)localObject2).x);
    Curve25519Field.multiplyAddToExt(((Curve25519FieldElement)localObject2).x, arrayOfInt2, arrayOfInt1);
    Curve25519Field.reduce(arrayOfInt1, ((Curve25519FieldElement)localObject2).x);
    localObject3 = new Curve25519FieldElement((int[])localObject4);
    if (!bool1) {
      Curve25519Field.multiply(((Curve25519FieldElement)localObject3).x, localCurve25519FieldElement1.x, ((Curve25519FieldElement)localObject3).x);
    }
    if (!bool2) {
      Curve25519Field.multiply(((Curve25519FieldElement)localObject3).x, localCurve25519FieldElement2.x, ((Curve25519FieldElement)localObject3).x);
    }
    if ((!bool1) || (!bool2)) {
      paramECPoint = null;
    }
    paramECPoint = calculateJacobianModifiedW((Curve25519FieldElement)localObject3, paramECPoint);
    bool1 = this.withCompression;
    return new Curve25519Point(localECCurve, (ECFieldElement)localObject1, (ECFieldElement)localObject2, new ECFieldElement[] { localObject3, paramECPoint }, bool1);
  }
  
  protected Curve25519FieldElement calculateJacobianModifiedW(Curve25519FieldElement paramCurve25519FieldElement, int[] paramArrayOfInt)
  {
    Curve25519FieldElement localCurve25519FieldElement1 = (Curve25519FieldElement)getCurve().getA();
    if (paramCurve25519FieldElement.isOne()) {
      return localCurve25519FieldElement1;
    }
    Curve25519FieldElement localCurve25519FieldElement2 = new Curve25519FieldElement();
    int[] arrayOfInt = paramArrayOfInt;
    if (paramArrayOfInt == null)
    {
      arrayOfInt = localCurve25519FieldElement2.x;
      Curve25519Field.square(paramCurve25519FieldElement.x, arrayOfInt);
    }
    Curve25519Field.square(arrayOfInt, localCurve25519FieldElement2.x);
    Curve25519Field.multiply(localCurve25519FieldElement2.x, localCurve25519FieldElement1.x, localCurve25519FieldElement2.x);
    return localCurve25519FieldElement2;
  }
  
  protected ECPoint detach()
  {
    return new Curve25519Point(null, getAffineXCoord(), getAffineYCoord());
  }
  
  protected Curve25519FieldElement getJacobianModifiedW()
  {
    Object localObject2 = (Curve25519FieldElement)this.zs[1];
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = this.zs;
      localObject1 = calculateJacobianModifiedW((Curve25519FieldElement)this.zs[0], null);
      localObject2[1] = localObject1;
    }
    return (Curve25519FieldElement)localObject1;
  }
  
  public ECFieldElement getZCoord(int paramInt)
  {
    if (paramInt == 1) {
      return getJacobianModifiedW();
    }
    return super.getZCoord(paramInt);
  }
  
  public ECPoint negate()
  {
    if (isInfinity()) {
      return this;
    }
    return new Curve25519Point(getCurve(), this.x, this.y.negate(), this.zs, this.withCompression);
  }
  
  public ECPoint threeTimes()
  {
    if (isInfinity()) {
      return this;
    }
    if (this.y.isZero()) {
      return this;
    }
    return twiceJacobianModified(false).add(this);
  }
  
  public ECPoint twice()
  {
    if (isInfinity()) {
      return this;
    }
    ECCurve localECCurve = getCurve();
    if (this.y.isZero()) {
      return localECCurve.getInfinity();
    }
    return twiceJacobianModified(true);
  }
  
  protected Curve25519Point twiceJacobianModified(boolean paramBoolean)
  {
    Curve25519FieldElement localCurve25519FieldElement2 = (Curve25519FieldElement)this.x;
    Object localObject3 = (Curve25519FieldElement)this.y;
    Curve25519FieldElement localCurve25519FieldElement1 = (Curve25519FieldElement)this.zs[0];
    Object localObject1 = getJacobianModifiedW();
    Object localObject4 = Nat256.create();
    Curve25519Field.square(localCurve25519FieldElement2.x, (int[])localObject4);
    Curve25519Field.reduce27(Nat256.addBothTo((int[])localObject4, (int[])localObject4, (int[])localObject4) + Nat256.addTo(((Curve25519FieldElement)localObject1).x, (int[])localObject4), (int[])localObject4);
    int[] arrayOfInt1 = Nat256.create();
    Curve25519Field.twice(((Curve25519FieldElement)localObject3).x, arrayOfInt1);
    Object localObject2 = Nat256.create();
    Curve25519Field.multiply(arrayOfInt1, ((Curve25519FieldElement)localObject3).x, (int[])localObject2);
    int[] arrayOfInt2 = Nat256.create();
    Curve25519Field.multiply((int[])localObject2, localCurve25519FieldElement2.x, arrayOfInt2);
    Curve25519Field.twice(arrayOfInt2, arrayOfInt2);
    localObject3 = Nat256.create();
    Curve25519Field.square((int[])localObject2, (int[])localObject3);
    Curve25519Field.twice((int[])localObject3, (int[])localObject3);
    localObject2 = new Curve25519FieldElement((int[])localObject2);
    Curve25519Field.square((int[])localObject4, ((Curve25519FieldElement)localObject2).x);
    Curve25519Field.subtract(((Curve25519FieldElement)localObject2).x, arrayOfInt2, ((Curve25519FieldElement)localObject2).x);
    Curve25519Field.subtract(((Curve25519FieldElement)localObject2).x, arrayOfInt2, ((Curve25519FieldElement)localObject2).x);
    localCurve25519FieldElement2 = new Curve25519FieldElement(arrayOfInt2);
    Curve25519Field.subtract(arrayOfInt2, ((Curve25519FieldElement)localObject2).x, localCurve25519FieldElement2.x);
    Curve25519Field.multiply(localCurve25519FieldElement2.x, (int[])localObject4, localCurve25519FieldElement2.x);
    Curve25519Field.subtract(localCurve25519FieldElement2.x, (int[])localObject3, localCurve25519FieldElement2.x);
    localObject4 = new Curve25519FieldElement(arrayOfInt1);
    if (!Nat256.isOne(localCurve25519FieldElement1.x)) {
      Curve25519Field.multiply(((Curve25519FieldElement)localObject4).x, localCurve25519FieldElement1.x, ((Curve25519FieldElement)localObject4).x);
    }
    localCurve25519FieldElement1 = null;
    if (paramBoolean)
    {
      localCurve25519FieldElement1 = new Curve25519FieldElement((int[])localObject3);
      Curve25519Field.multiply(localCurve25519FieldElement1.x, ((Curve25519FieldElement)localObject1).x, localCurve25519FieldElement1.x);
      Curve25519Field.twice(localCurve25519FieldElement1.x, localCurve25519FieldElement1.x);
    }
    localObject1 = getCurve();
    paramBoolean = this.withCompression;
    return new Curve25519Point((ECCurve)localObject1, (ECFieldElement)localObject2, localCurve25519FieldElement2, new ECFieldElement[] { localObject4, localCurve25519FieldElement1 }, paramBoolean);
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
    return twiceJacobianModified(false).add(paramECPoint);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\djb\Curve25519Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */