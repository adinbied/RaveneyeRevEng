package org.bouncycastle.math.ec.custom.sec;

import org.bouncycastle.math.ec.ECConstants;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.ec.ECPoint;
import org.bouncycastle.math.ec.ECPoint.AbstractF2m;

public class SecT239K1Point
  extends ECPoint.AbstractF2m
{
  public SecT239K1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
  }
  
  public SecT239K1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
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
  
  SecT239K1Point(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
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
    Object localObject2 = this.x;
    ECFieldElement localECFieldElement3 = paramECPoint.getRawXCoord();
    if (((ECFieldElement)localObject2).isZero())
    {
      if (localECFieldElement3.isZero()) {
        return localECCurve.getInfinity();
      }
      return paramECPoint.add(this);
    }
    ECFieldElement localECFieldElement1 = this.y;
    ECFieldElement localECFieldElement4 = this.zs[0];
    ECFieldElement localECFieldElement2 = paramECPoint.getRawYCoord();
    ECFieldElement localECFieldElement5 = paramECPoint.getZCoord(0);
    boolean bool1 = localECFieldElement4.isOne();
    if (!bool1)
    {
      paramECPoint = localECFieldElement3.multiply(localECFieldElement4);
      localObject1 = localECFieldElement2.multiply(localECFieldElement4);
    }
    else
    {
      paramECPoint = localECFieldElement3;
      localObject1 = localECFieldElement2;
    }
    boolean bool2 = localECFieldElement5.isOne();
    if (!bool2)
    {
      localObject2 = ((ECFieldElement)localObject2).multiply(localECFieldElement5);
      localObject3 = localECFieldElement1.multiply(localECFieldElement5);
    }
    else
    {
      localObject3 = localECFieldElement1;
    }
    Object localObject3 = ((ECFieldElement)localObject3).add((ECFieldElement)localObject1);
    Object localObject1 = ((ECFieldElement)localObject2).add(paramECPoint);
    if (((ECFieldElement)localObject1).isZero())
    {
      if (((ECFieldElement)localObject3).isZero()) {
        return twice();
      }
      return localECCurve.getInfinity();
    }
    if (localECFieldElement3.isZero())
    {
      localObject1 = normalize();
      paramECPoint = ((ECPoint)localObject1).getXCoord();
      localObject1 = ((ECPoint)localObject1).getYCoord();
      localObject3 = ((ECFieldElement)localObject1).add(localECFieldElement2).divide(paramECPoint);
      localObject2 = ((ECFieldElement)localObject3).square().add((ECFieldElement)localObject3).add(paramECPoint);
      if (((ECFieldElement)localObject2).isZero()) {
        return new SecT239K1Point(localECCurve, (ECFieldElement)localObject2, localECCurve.getB(), this.withCompression);
      }
      paramECPoint = ((ECFieldElement)localObject3).multiply(paramECPoint.add((ECFieldElement)localObject2)).add((ECFieldElement)localObject2).add((ECFieldElement)localObject1).divide((ECFieldElement)localObject2).add((ECFieldElement)localObject2);
      localObject1 = localECCurve.fromBigInteger(ECConstants.ONE);
      localObject3 = paramECPoint;
    }
    else
    {
      localObject1 = ((ECFieldElement)localObject1).square();
      localObject2 = ((ECFieldElement)localObject3).multiply((ECFieldElement)localObject2);
      localECFieldElement2 = ((ECFieldElement)localObject3).multiply(paramECPoint);
      localObject2 = ((ECFieldElement)localObject2).multiply(localECFieldElement2);
      if (((ECFieldElement)localObject2).isZero()) {
        return new SecT239K1Point(localECCurve, (ECFieldElement)localObject2, localECCurve.getB(), this.withCompression);
      }
      paramECPoint = ((ECFieldElement)localObject3).multiply((ECFieldElement)localObject1);
      if (!bool2) {
        paramECPoint = paramECPoint.multiply(localECFieldElement5);
      }
      localObject3 = localECFieldElement2.add((ECFieldElement)localObject1).squarePlusProduct(paramECPoint, localECFieldElement1.add(localECFieldElement4));
      localObject1 = paramECPoint;
      if (!bool1) {
        localObject1 = paramECPoint.multiply(localECFieldElement4);
      }
      paramECPoint = (ECPoint)localObject2;
      localObject2 = paramECPoint;
    }
    bool1 = this.withCompression;
    return new SecT239K1Point(localECCurve, (ECFieldElement)localObject2, (ECFieldElement)localObject3, new ECFieldElement[] { localObject1 }, bool1);
  }
  
  protected ECPoint detach()
  {
    return new SecT239K1Point(null, getAffineXCoord(), getAffineYCoord());
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
    return new SecT239K1Point(localECCurve, localECFieldElement1, localECFieldElement3, new ECFieldElement[] { localECFieldElement2 }, bool);
  }
  
  public ECPoint twice()
  {
    if (isInfinity()) {
      return this;
    }
    ECCurve localECCurve = getCurve();
    ECFieldElement localECFieldElement5 = this.x;
    if (localECFieldElement5.isZero()) {
      return localECCurve.getInfinity();
    }
    ECFieldElement localECFieldElement6 = this.y;
    ECFieldElement localECFieldElement2 = this.zs[0];
    boolean bool = localECFieldElement2.isOne();
    ECFieldElement localECFieldElement3;
    if (bool) {
      localECFieldElement3 = localECFieldElement2;
    } else {
      localECFieldElement3 = localECFieldElement2.square();
    }
    if (bool) {
      localECFieldElement1 = localECFieldElement6.square().add(localECFieldElement6);
    } else {
      localECFieldElement1 = localECFieldElement6.add(localECFieldElement2).multiply(localECFieldElement6);
    }
    if (localECFieldElement1.isZero()) {
      return new SecT239K1Point(localECCurve, localECFieldElement1, localECCurve.getB(), this.withCompression);
    }
    ECFieldElement localECFieldElement7 = localECFieldElement1.square();
    ECFieldElement localECFieldElement4;
    if (bool) {
      localECFieldElement4 = localECFieldElement1;
    } else {
      localECFieldElement4 = localECFieldElement1.multiply(localECFieldElement3);
    }
    localECFieldElement5 = localECFieldElement6.add(localECFieldElement5).square();
    if (!bool) {
      localECFieldElement2 = localECFieldElement3.square();
    }
    ECFieldElement localECFieldElement1 = localECFieldElement5.add(localECFieldElement1).add(localECFieldElement3).multiply(localECFieldElement5).add(localECFieldElement2).add(localECFieldElement7).add(localECFieldElement4);
    bool = this.withCompression;
    return new SecT239K1Point(localECCurve, localECFieldElement7, localECFieldElement1, new ECFieldElement[] { localECFieldElement4 }, bool);
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
    ECFieldElement localECFieldElement1 = this.x;
    if (localECFieldElement1.isZero()) {
      return paramECPoint;
    }
    ECFieldElement localECFieldElement2 = paramECPoint.getRawXCoord();
    ECFieldElement localECFieldElement3 = paramECPoint.getZCoord(0);
    if ((!localECFieldElement2.isZero()) && (localECFieldElement3.isOne()))
    {
      localECFieldElement3 = this.y;
      ECFieldElement localECFieldElement7 = this.zs[0];
      ECFieldElement localECFieldElement4 = paramECPoint.getRawYCoord();
      ECFieldElement localECFieldElement5 = localECFieldElement1.square();
      ECFieldElement localECFieldElement6 = localECFieldElement3.square();
      localECFieldElement1 = localECFieldElement7.square();
      localECFieldElement3 = localECFieldElement6.add(localECFieldElement3.multiply(localECFieldElement7));
      localECFieldElement4 = localECFieldElement4.addOne();
      localECFieldElement5 = localECFieldElement4.multiply(localECFieldElement1).add(localECFieldElement6).multiplyPlusProduct(localECFieldElement3, localECFieldElement5, localECFieldElement1);
      localECFieldElement6 = localECFieldElement2.multiply(localECFieldElement1);
      localECFieldElement2 = localECFieldElement6.add(localECFieldElement3).square();
      if (localECFieldElement2.isZero())
      {
        if (localECFieldElement5.isZero()) {
          return paramECPoint.twice();
        }
        return localECCurve.getInfinity();
      }
      if (localECFieldElement5.isZero()) {
        return new SecT239K1Point(localECCurve, localECFieldElement5, localECCurve.getB(), this.withCompression);
      }
      paramECPoint = localECFieldElement5.square().multiply(localECFieldElement6);
      localECFieldElement1 = localECFieldElement5.multiply(localECFieldElement2).multiply(localECFieldElement1);
      localECFieldElement2 = localECFieldElement5.add(localECFieldElement2).square().multiplyPlusProduct(localECFieldElement3, localECFieldElement4, localECFieldElement1);
      boolean bool = this.withCompression;
      return new SecT239K1Point(localECCurve, paramECPoint, localECFieldElement2, new ECFieldElement[] { localECFieldElement1 }, bool);
    }
    return twice().add(paramECPoint);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT239K1Point.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */