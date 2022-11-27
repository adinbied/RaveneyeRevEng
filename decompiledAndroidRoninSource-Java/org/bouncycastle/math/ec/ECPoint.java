package org.bouncycastle.math.ec;

import java.math.BigInteger;
import java.util.Hashtable;

public abstract class ECPoint
{
  protected static ECFieldElement[] EMPTY_ZS = new ECFieldElement[0];
  protected ECCurve curve;
  protected Hashtable preCompTable = null;
  protected boolean withCompression;
  protected ECFieldElement x;
  protected ECFieldElement y;
  protected ECFieldElement[] zs;
  
  protected ECPoint(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    this(paramECCurve, paramECFieldElement1, paramECFieldElement2, getInitialZCoords(paramECCurve));
  }
  
  protected ECPoint(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement)
  {
    this.curve = paramECCurve;
    this.x = paramECFieldElement1;
    this.y = paramECFieldElement2;
    this.zs = paramArrayOfECFieldElement;
  }
  
  protected static ECFieldElement[] getInitialZCoords(ECCurve paramECCurve)
  {
    int i;
    if (paramECCurve == null) {
      i = 0;
    } else {
      i = paramECCurve.getCoordinateSystem();
    }
    if ((i != 0) && (i != 5))
    {
      ECFieldElement localECFieldElement = paramECCurve.fromBigInteger(ECConstants.ONE);
      if ((i != 1) && (i != 2)) {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 6) {
              throw new IllegalArgumentException("unknown coordinate system");
            }
          }
          else {
            return new ECFieldElement[] { localECFieldElement, paramECCurve.getA() };
          }
        }
        else {
          return new ECFieldElement[] { localECFieldElement, localECFieldElement, localECFieldElement };
        }
      }
      return new ECFieldElement[] { localECFieldElement };
    }
    return EMPTY_ZS;
  }
  
  public abstract ECPoint add(ECPoint paramECPoint);
  
  protected void checkNormalized()
  {
    if (isNormalized()) {
      return;
    }
    throw new IllegalStateException("point not in normal form");
  }
  
  protected ECPoint createScaledPoint(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return getCurve().createRawPoint(getRawXCoord().multiply(paramECFieldElement1), getRawYCoord().multiply(paramECFieldElement2), this.withCompression);
  }
  
  protected abstract ECPoint detach();
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof ECPoint)) {
      return false;
    }
    return equals((ECPoint)paramObject);
  }
  
  public boolean equals(ECPoint paramECPoint)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    if (paramECPoint == null) {
      return false;
    }
    Object localObject1 = getCurve();
    Object localObject2 = paramECPoint.getCurve();
    int i;
    if (localObject1 == null) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (localObject2 == null) {
      j = 1;
    } else {
      j = 0;
    }
    boolean bool4 = isInfinity();
    boolean bool5 = paramECPoint.isInfinity();
    if ((!bool4) && (!bool5))
    {
      if ((i == 0) || (j == 0))
      {
        if (i != 0) {
          paramECPoint = paramECPoint.normalize();
        }
      }
      else
      {
        localObject1 = this;
        break label163;
      }
      if (j != 0)
      {
        localObject1 = normalize();
      }
      else
      {
        if (!((ECCurve)localObject1).equals((ECCurve)localObject2)) {
          return false;
        }
        localObject2 = new ECPoint[2];
        localObject2[0] = this;
        localObject2[1] = ((ECCurve)localObject1).importPoint(paramECPoint);
        ((ECCurve)localObject1).normalizeAll((ECPoint[])localObject2);
        localObject1 = localObject2[0];
        paramECPoint = localObject2[1];
      }
      label163:
      bool1 = bool2;
      if (((ECPoint)localObject1).getXCoord().equals(paramECPoint.getXCoord()))
      {
        bool1 = bool2;
        if (((ECPoint)localObject1).getYCoord().equals(paramECPoint.getYCoord())) {
          bool1 = true;
        }
      }
      return bool1;
    }
    boolean bool1 = bool3;
    if (bool4)
    {
      bool1 = bool3;
      if (bool5) {
        if ((i == 0) && (j == 0))
        {
          bool1 = bool3;
          if (!((ECCurve)localObject1).equals((ECCurve)localObject2)) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public ECFieldElement getAffineXCoord()
  {
    checkNormalized();
    return getXCoord();
  }
  
  public ECFieldElement getAffineYCoord()
  {
    checkNormalized();
    return getYCoord();
  }
  
  protected abstract boolean getCompressionYTilde();
  
  public ECCurve getCurve()
  {
    return this.curve;
  }
  
  protected int getCurveCoordinateSystem()
  {
    ECCurve localECCurve = this.curve;
    if (localECCurve == null) {
      return 0;
    }
    return localECCurve.getCoordinateSystem();
  }
  
  public final ECPoint getDetachedPoint()
  {
    return normalize().detach();
  }
  
  public byte[] getEncoded()
  {
    return getEncoded(this.withCompression);
  }
  
  public byte[] getEncoded(boolean paramBoolean)
  {
    if (isInfinity()) {
      return new byte[1];
    }
    Object localObject = normalize();
    byte[] arrayOfByte1 = ((ECPoint)localObject).getXCoord().getEncoded();
    if (paramBoolean)
    {
      arrayOfByte2 = new byte[arrayOfByte1.length + 1];
      int i;
      if (((ECPoint)localObject).getCompressionYTilde()) {
        i = 3;
      } else {
        i = 2;
      }
      arrayOfByte2[0] = ((byte)i);
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
      return arrayOfByte2;
    }
    localObject = ((ECPoint)localObject).getYCoord().getEncoded();
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length + localObject.length + 1];
    arrayOfByte2[0] = 4;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
    System.arraycopy(localObject, 0, arrayOfByte2, arrayOfByte1.length + 1, localObject.length);
    return arrayOfByte2;
  }
  
  public final ECFieldElement getRawXCoord()
  {
    return this.x;
  }
  
  public final ECFieldElement getRawYCoord()
  {
    return this.y;
  }
  
  protected final ECFieldElement[] getRawZCoords()
  {
    return this.zs;
  }
  
  public ECFieldElement getX()
  {
    return normalize().getXCoord();
  }
  
  public ECFieldElement getXCoord()
  {
    return this.x;
  }
  
  public ECFieldElement getY()
  {
    return normalize().getYCoord();
  }
  
  public ECFieldElement getYCoord()
  {
    return this.y;
  }
  
  public ECFieldElement getZCoord(int paramInt)
  {
    if (paramInt >= 0)
    {
      ECFieldElement[] arrayOfECFieldElement = this.zs;
      if (paramInt < arrayOfECFieldElement.length) {
        return arrayOfECFieldElement[paramInt];
      }
    }
    return null;
  }
  
  public ECFieldElement[] getZCoords()
  {
    ECFieldElement[] arrayOfECFieldElement1 = this.zs;
    int i = arrayOfECFieldElement1.length;
    if (i == 0) {
      return EMPTY_ZS;
    }
    ECFieldElement[] arrayOfECFieldElement2 = new ECFieldElement[i];
    System.arraycopy(arrayOfECFieldElement1, 0, arrayOfECFieldElement2, 0, i);
    return arrayOfECFieldElement2;
  }
  
  public int hashCode()
  {
    Object localObject = getCurve();
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = ((ECCurve)localObject).hashCode();
    }
    int j = i;
    if (!isInfinity())
    {
      localObject = normalize();
      j = i ^ ((ECPoint)localObject).getXCoord().hashCode() * 17 ^ ((ECPoint)localObject).getYCoord().hashCode() * 257;
    }
    return j;
  }
  
  public boolean isCompressed()
  {
    return this.withCompression;
  }
  
  public boolean isInfinity()
  {
    Object localObject = this.x;
    boolean bool2 = false;
    boolean bool1;
    if ((localObject != null) && (this.y != null))
    {
      localObject = this.zs;
      bool1 = bool2;
      if (localObject.length > 0)
      {
        bool1 = bool2;
        if (!localObject[0].isZero()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean isNormalized()
  {
    int i = getCurveCoordinateSystem();
    boolean bool = false;
    if ((i == 0) || (i == 5) || (isInfinity()) || (this.zs[0].isOne())) {
      bool = true;
    }
    return bool;
  }
  
  public boolean isValid()
  {
    if (isInfinity()) {
      return true;
    }
    if (getCurve() != null)
    {
      if (!satisfiesCurveEquation()) {
        return false;
      }
      if (!satisfiesCofactor()) {
        return false;
      }
    }
    return true;
  }
  
  public ECPoint multiply(BigInteger paramBigInteger)
  {
    return getCurve().getMultiplier().multiply(this, paramBigInteger);
  }
  
  public abstract ECPoint negate();
  
  public ECPoint normalize()
  {
    if (isInfinity()) {
      return this;
    }
    int i = getCurveCoordinateSystem();
    if ((i != 0) && (i != 5))
    {
      ECFieldElement localECFieldElement = getZCoord(0);
      if (localECFieldElement.isOne()) {
        return this;
      }
      return normalize(localECFieldElement.invert());
    }
    return this;
  }
  
  ECPoint normalize(ECFieldElement paramECFieldElement)
  {
    int i = getCurveCoordinateSystem();
    if (i != 1) {
      if ((i != 2) && (i != 3) && (i != 4))
      {
        if (i != 6) {
          throw new IllegalStateException("not a projective coordinate system");
        }
      }
      else
      {
        ECFieldElement localECFieldElement = paramECFieldElement.square();
        return createScaledPoint(localECFieldElement, localECFieldElement.multiply(paramECFieldElement));
      }
    }
    return createScaledPoint(paramECFieldElement, paramECFieldElement);
  }
  
  protected boolean satisfiesCofactor()
  {
    BigInteger localBigInteger = this.curve.getCofactor();
    return (localBigInteger == null) || (localBigInteger.equals(ECConstants.ONE)) || (!ECAlgorithms.referenceMultiply(this, localBigInteger).isInfinity());
  }
  
  protected abstract boolean satisfiesCurveEquation();
  
  public ECPoint scaleX(ECFieldElement paramECFieldElement)
  {
    if (isInfinity()) {
      return this;
    }
    return getCurve().createRawPoint(getRawXCoord().multiply(paramECFieldElement), getRawYCoord(), getRawZCoords(), this.withCompression);
  }
  
  public ECPoint scaleY(ECFieldElement paramECFieldElement)
  {
    if (isInfinity()) {
      return this;
    }
    return getCurve().createRawPoint(getRawXCoord(), getRawYCoord().multiply(paramECFieldElement), getRawZCoords(), this.withCompression);
  }
  
  public abstract ECPoint subtract(ECPoint paramECPoint);
  
  public ECPoint threeTimes()
  {
    return twicePlus(this);
  }
  
  public ECPoint timesPow2(int paramInt)
  {
    if (paramInt >= 0)
    {
      for (ECPoint localECPoint = this;; localECPoint = localECPoint.twice())
      {
        paramInt -= 1;
        if (paramInt < 0) {
          break;
        }
      }
      return localECPoint;
    }
    throw new IllegalArgumentException("'e' cannot be negative");
  }
  
  public String toString()
  {
    if (isInfinity()) {
      return "INF";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append('(');
    localStringBuffer.append(getRawXCoord());
    localStringBuffer.append(',');
    localStringBuffer.append(getRawYCoord());
    int i = 0;
    while (i < this.zs.length)
    {
      localStringBuffer.append(',');
      localStringBuffer.append(this.zs[i]);
      i += 1;
    }
    localStringBuffer.append(')');
    return localStringBuffer.toString();
  }
  
  public abstract ECPoint twice();
  
  public ECPoint twicePlus(ECPoint paramECPoint)
  {
    return twice().add(paramECPoint);
  }
  
  public static abstract class AbstractF2m
    extends ECPoint
  {
    protected AbstractF2m(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      super(paramECFieldElement1, paramECFieldElement2);
    }
    
    protected AbstractF2m(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement)
    {
      super(paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement);
    }
    
    protected boolean satisfiesCurveEquation()
    {
      Object localObject2 = getCurve();
      ECFieldElement localECFieldElement3 = this.x;
      ECFieldElement localECFieldElement1 = ((ECCurve)localObject2).getA();
      Object localObject1 = ((ECCurve)localObject2).getB();
      int i = ((ECCurve)localObject2).getCoordinateSystem();
      if (i == 6)
      {
        localObject3 = this.zs[0];
        boolean bool = ((ECFieldElement)localObject3).isOne();
        if (localECFieldElement3.isZero())
        {
          localObject4 = this.y.square();
          localObject2 = localObject1;
          if (!bool) {
            localObject2 = ((ECFieldElement)localObject1).multiply(((ECFieldElement)localObject3).square());
          }
          return localObject4.equals(localObject2);
        }
        localObject2 = this.y;
        localObject4 = localECFieldElement3.square();
        if (bool)
        {
          localObject2 = ((ECFieldElement)localObject2).square().add((ECFieldElement)localObject2).add(localECFieldElement1);
          localObject3 = ((ECFieldElement)localObject4).square().add((ECFieldElement)localObject1);
          localObject1 = localObject2;
          localObject2 = localObject3;
        }
        else
        {
          localECFieldElement3 = ((ECFieldElement)localObject3).square();
          localECFieldElement2 = localECFieldElement3.square();
          localObject3 = ((ECFieldElement)localObject2).add((ECFieldElement)localObject3).multiplyPlusProduct((ECFieldElement)localObject2, localECFieldElement1, localECFieldElement3);
          localObject2 = ((ECFieldElement)localObject4).squarePlusProduct((ECFieldElement)localObject1, localECFieldElement2);
          localObject1 = localObject3;
        }
        return ((ECFieldElement)localObject1).multiply((ECFieldElement)localObject4).equals(localObject2);
      }
      localObject2 = this.y;
      ECFieldElement localECFieldElement2 = ((ECFieldElement)localObject2).add(localECFieldElement3).multiply((ECFieldElement)localObject2);
      localObject2 = localECFieldElement1;
      Object localObject3 = localObject1;
      Object localObject4 = localECFieldElement2;
      if (i != 0) {
        if (i == 1)
        {
          ECFieldElement localECFieldElement4 = this.zs[0];
          localObject2 = localECFieldElement1;
          localObject3 = localObject1;
          localObject4 = localECFieldElement2;
          if (!localECFieldElement4.isOne())
          {
            localObject3 = localECFieldElement4.multiply(localECFieldElement4.square());
            localObject4 = localECFieldElement2.multiply(localECFieldElement4);
            localObject2 = localECFieldElement1.multiply(localECFieldElement4);
            localObject3 = ((ECFieldElement)localObject1).multiply((ECFieldElement)localObject3);
          }
        }
        else
        {
          throw new IllegalStateException("unsupported coordinate system");
        }
      }
      return localObject4.equals(localECFieldElement3.add((ECFieldElement)localObject2).multiply(localECFieldElement3.square()).add((ECFieldElement)localObject3));
    }
    
    public ECPoint scaleX(ECFieldElement paramECFieldElement)
    {
      if (isInfinity()) {
        return this;
      }
      int i = getCurveCoordinateSystem();
      if (i != 5)
      {
        if (i != 6) {
          return super.scaleX(paramECFieldElement);
        }
        localECFieldElement2 = getRawXCoord();
        ECFieldElement localECFieldElement3 = getRawYCoord();
        localObject = getRawZCoords()[0];
        localECFieldElement1 = localECFieldElement2.multiply(paramECFieldElement.square());
        localECFieldElement2 = localECFieldElement3.add(localECFieldElement2).add(localECFieldElement1);
        paramECFieldElement = ((ECFieldElement)localObject).multiply(paramECFieldElement);
        localObject = getCurve();
        boolean bool = this.withCompression;
        return ((ECCurve)localObject).createRawPoint(localECFieldElement1, localECFieldElement2, new ECFieldElement[] { paramECFieldElement }, bool);
      }
      ECFieldElement localECFieldElement1 = getRawXCoord();
      Object localObject = getRawYCoord();
      ECFieldElement localECFieldElement2 = localECFieldElement1.multiply(paramECFieldElement);
      paramECFieldElement = ((ECFieldElement)localObject).add(localECFieldElement1).divide(paramECFieldElement).add(localECFieldElement2);
      return getCurve().createRawPoint(localECFieldElement1, paramECFieldElement, getRawZCoords(), this.withCompression);
    }
    
    public ECPoint scaleY(ECFieldElement paramECFieldElement)
    {
      if (isInfinity()) {
        return this;
      }
      int i = getCurveCoordinateSystem();
      if ((i != 5) && (i != 6)) {
        return super.scaleY(paramECFieldElement);
      }
      ECFieldElement localECFieldElement = getRawXCoord();
      paramECFieldElement = getRawYCoord().add(localECFieldElement).multiply(paramECFieldElement).add(localECFieldElement);
      return getCurve().createRawPoint(localECFieldElement, paramECFieldElement, getRawZCoords(), this.withCompression);
    }
    
    public ECPoint subtract(ECPoint paramECPoint)
    {
      if (paramECPoint.isInfinity()) {
        return this;
      }
      return add(paramECPoint.negate());
    }
    
    public AbstractF2m tau()
    {
      if (isInfinity()) {
        return this;
      }
      Object localObject = getCurve();
      int i = ((ECCurve)localObject).getCoordinateSystem();
      ECFieldElement localECFieldElement2 = this.x;
      ECFieldElement localECFieldElement3;
      ECFieldElement localECFieldElement1;
      boolean bool;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 5) {
            break label122;
          }
          if (i != 6) {
            throw new IllegalStateException("unsupported coordinate system");
          }
        }
        localECFieldElement3 = this.y;
        localECFieldElement1 = this.zs[0];
        localECFieldElement2 = localECFieldElement2.square();
        localECFieldElement3 = localECFieldElement3.square();
        localECFieldElement1 = localECFieldElement1.square();
        bool = this.withCompression;
      }
      for (localObject = ((ECCurve)localObject).createRawPoint(localECFieldElement2, localECFieldElement3, new ECFieldElement[] { localECFieldElement1 }, bool);; localObject = ((ECCurve)localObject).createRawPoint(localECFieldElement2.square(), localECFieldElement1.square(), this.withCompression))
      {
        return (AbstractF2m)localObject;
        label122:
        localECFieldElement1 = this.y;
      }
    }
    
    public AbstractF2m tauPow(int paramInt)
    {
      if (isInfinity()) {
        return this;
      }
      Object localObject = getCurve();
      int i = ((ECCurve)localObject).getCoordinateSystem();
      ECFieldElement localECFieldElement2 = this.x;
      ECFieldElement localECFieldElement3;
      ECFieldElement localECFieldElement1;
      boolean bool;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 5) {
            break label130;
          }
          if (i != 6) {
            throw new IllegalStateException("unsupported coordinate system");
          }
        }
        localECFieldElement3 = this.y;
        localECFieldElement1 = this.zs[0];
        localECFieldElement2 = localECFieldElement2.squarePow(paramInt);
        localECFieldElement3 = localECFieldElement3.squarePow(paramInt);
        localECFieldElement1 = localECFieldElement1.squarePow(paramInt);
        bool = this.withCompression;
      }
      for (localObject = ((ECCurve)localObject).createRawPoint(localECFieldElement2, localECFieldElement3, new ECFieldElement[] { localECFieldElement1 }, bool);; localObject = ((ECCurve)localObject).createRawPoint(localECFieldElement2.squarePow(paramInt), localECFieldElement1.squarePow(paramInt), this.withCompression))
      {
        return (AbstractF2m)localObject;
        label130:
        localECFieldElement1 = this.y;
      }
    }
  }
  
  public static abstract class AbstractFp
    extends ECPoint
  {
    protected AbstractFp(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      super(paramECFieldElement1, paramECFieldElement2);
    }
    
    protected AbstractFp(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement)
    {
      super(paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement);
    }
    
    protected boolean getCompressionYTilde()
    {
      return getAffineYCoord().testBitZero();
    }
    
    protected boolean satisfiesCurveEquation()
    {
      ECFieldElement localECFieldElement6 = this.x;
      Object localObject = this.y;
      ECFieldElement localECFieldElement4 = this.curve.getA();
      ECFieldElement localECFieldElement3 = this.curve.getB();
      ECFieldElement localECFieldElement5 = ((ECFieldElement)localObject).square();
      int i = getCurveCoordinateSystem();
      ECFieldElement localECFieldElement2 = localECFieldElement5;
      localObject = localECFieldElement4;
      ECFieldElement localECFieldElement1 = localECFieldElement3;
      if (i != 0)
      {
        ECFieldElement localECFieldElement7;
        if (i != 1)
        {
          if ((i != 2) && (i != 3) && (i != 4)) {
            throw new IllegalStateException("unsupported coordinate system");
          }
          localECFieldElement7 = this.zs[0];
          localECFieldElement2 = localECFieldElement5;
          localObject = localECFieldElement4;
          localECFieldElement1 = localECFieldElement3;
          if (!localECFieldElement7.isOne())
          {
            localECFieldElement1 = localECFieldElement7.square();
            localObject = localECFieldElement1.square();
            localECFieldElement1 = localECFieldElement1.multiply((ECFieldElement)localObject);
            localObject = localECFieldElement4.multiply((ECFieldElement)localObject);
            localECFieldElement1 = localECFieldElement3.multiply(localECFieldElement1);
            localECFieldElement2 = localECFieldElement5;
          }
        }
        else
        {
          localECFieldElement7 = this.zs[0];
          localECFieldElement2 = localECFieldElement5;
          localObject = localECFieldElement4;
          localECFieldElement1 = localECFieldElement3;
          if (!localECFieldElement7.isOne())
          {
            localObject = localECFieldElement7.square();
            localECFieldElement1 = localECFieldElement7.multiply((ECFieldElement)localObject);
            localECFieldElement2 = localECFieldElement5.multiply(localECFieldElement7);
            localObject = localECFieldElement4.multiply((ECFieldElement)localObject);
            localECFieldElement1 = localECFieldElement3.multiply(localECFieldElement1);
          }
        }
      }
      return localECFieldElement2.equals(localECFieldElement6.square().add((ECFieldElement)localObject).multiply(localECFieldElement6).add(localECFieldElement1));
    }
    
    public ECPoint subtract(ECPoint paramECPoint)
    {
      if (paramECPoint.isInfinity()) {
        return this;
      }
      return add(paramECPoint.negate());
    }
  }
  
  public static class F2m
    extends ECPoint.AbstractF2m
  {
    public F2m(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
    }
    
    public F2m(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
    {
      super(paramECFieldElement1, paramECFieldElement2);
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
        if (paramECFieldElement1 != null)
        {
          ECFieldElement.F2m.checkFieldElements(this.x, this.y);
          if (paramECCurve != null) {
            ECFieldElement.F2m.checkFieldElements(this.x, this.curve.getA());
          }
        }
        this.withCompression = paramBoolean;
        return;
      }
      throw new IllegalArgumentException("Exactly one of the field elements is null");
    }
    
    F2m(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
    {
      super(paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement);
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
      int i = localECCurve.getCoordinateSystem();
      Object localObject1 = this.x;
      ECFieldElement localECFieldElement2 = paramECPoint.x;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 6)
          {
            if (((ECFieldElement)localObject1).isZero())
            {
              if (localECFieldElement2.isZero()) {
                return localECCurve.getInfinity();
              }
              return paramECPoint.add(this);
            }
            localECFieldElement3 = this.y;
            localECFieldElement5 = this.zs[0];
            localECFieldElement4 = paramECPoint.y;
            localECFieldElement6 = paramECPoint.zs[0];
            bool1 = localECFieldElement5.isOne();
            if (!bool1)
            {
              paramECPoint = localECFieldElement2.multiply(localECFieldElement5);
              localObject2 = localECFieldElement4.multiply(localECFieldElement5);
            }
            else
            {
              paramECPoint = localECFieldElement2;
              localObject2 = localECFieldElement4;
            }
            boolean bool2 = localECFieldElement6.isOne();
            if (!bool2)
            {
              localObject1 = ((ECFieldElement)localObject1).multiply(localECFieldElement6);
              localECFieldElement1 = localECFieldElement3.multiply(localECFieldElement6);
            }
            else
            {
              localECFieldElement1 = localECFieldElement3;
            }
            localECFieldElement7 = localECFieldElement1.add((ECFieldElement)localObject2);
            localObject2 = ((ECFieldElement)localObject1).add(paramECPoint);
            if (((ECFieldElement)localObject2).isZero())
            {
              if (localECFieldElement7.isZero()) {
                return twice();
              }
              return localECCurve.getInfinity();
            }
            if (localECFieldElement2.isZero())
            {
              paramECPoint = normalize();
              localObject1 = paramECPoint.getXCoord();
              localObject2 = paramECPoint.getYCoord();
              localECFieldElement1 = ((ECFieldElement)localObject2).add(localECFieldElement4).divide((ECFieldElement)localObject1);
              paramECPoint = localECFieldElement1.square().add(localECFieldElement1).add((ECFieldElement)localObject1).add(localECCurve.getA());
              if (paramECPoint.isZero()) {
                return new F2m(localECCurve, paramECPoint, localECCurve.getB().sqrt(), this.withCompression);
              }
              localObject2 = localECFieldElement1.multiply(((ECFieldElement)localObject1).add(paramECPoint)).add(paramECPoint).add((ECFieldElement)localObject2).divide(paramECPoint).add(paramECPoint);
              localObject1 = localECCurve.fromBigInteger(ECConstants.ONE);
            }
            else
            {
              localECFieldElement1 = ((ECFieldElement)localObject2).square();
              localObject2 = localECFieldElement7.multiply((ECFieldElement)localObject1);
              localObject1 = localECFieldElement7.multiply(paramECPoint);
              localObject2 = ((ECFieldElement)localObject2).multiply((ECFieldElement)localObject1);
              if (((ECFieldElement)localObject2).isZero()) {
                return new F2m(localECCurve, (ECFieldElement)localObject2, localECCurve.getB().sqrt(), this.withCompression);
              }
              paramECPoint = localECFieldElement7.multiply(localECFieldElement1);
              if (!bool2) {
                paramECPoint = paramECPoint.multiply(localECFieldElement6);
              }
              localECFieldElement1 = ((ECFieldElement)localObject1).add(localECFieldElement1).squarePlusProduct(paramECPoint, localECFieldElement3.add(localECFieldElement5));
              localObject1 = paramECPoint;
              if (!bool1) {
                localObject1 = paramECPoint.multiply(localECFieldElement5);
              }
              paramECPoint = (ECPoint)localObject2;
              localObject2 = localECFieldElement1;
            }
            bool1 = this.withCompression;
            return new F2m(localECCurve, paramECPoint, (ECFieldElement)localObject2, new ECFieldElement[] { localObject1 }, bool1);
          }
          throw new IllegalStateException("unsupported coordinate system");
        }
        localECFieldElement1 = this.y;
        localObject2 = this.zs[0];
        ECFieldElement localECFieldElement4 = paramECPoint.y;
        ECFieldElement localECFieldElement3 = paramECPoint.zs[0];
        boolean bool1 = localECFieldElement3.isOne();
        localECFieldElement4 = ((ECFieldElement)localObject2).multiply(localECFieldElement4);
        if (bool1) {
          paramECPoint = localECFieldElement1;
        } else {
          paramECPoint = localECFieldElement1.multiply(localECFieldElement3);
        }
        localECFieldElement4 = localECFieldElement4.add(paramECPoint);
        localECFieldElement2 = ((ECFieldElement)localObject2).multiply(localECFieldElement2);
        if (bool1) {
          paramECPoint = (ECPoint)localObject1;
        } else {
          paramECPoint = ((ECFieldElement)localObject1).multiply(localECFieldElement3);
        }
        ECFieldElement localECFieldElement6 = localECFieldElement2.add(paramECPoint);
        if (localECFieldElement6.isZero())
        {
          if (localECFieldElement4.isZero()) {
            return twice();
          }
          return localECCurve.getInfinity();
        }
        localECFieldElement2 = localECFieldElement6.square();
        ECFieldElement localECFieldElement5 = localECFieldElement2.multiply(localECFieldElement6);
        if (bool1) {
          paramECPoint = (ECPoint)localObject2;
        } else {
          paramECPoint = ((ECFieldElement)localObject2).multiply(localECFieldElement3);
        }
        ECFieldElement localECFieldElement8 = localECFieldElement4.add(localECFieldElement6);
        ECFieldElement localECFieldElement9 = localECFieldElement8.multiplyPlusProduct(localECFieldElement4, localECFieldElement2, localECCurve.getA()).multiply(paramECPoint).add(localECFieldElement5);
        ECFieldElement localECFieldElement7 = localECFieldElement6.multiply(localECFieldElement9);
        if (bool1) {
          localObject2 = localECFieldElement2;
        } else {
          localObject2 = localECFieldElement2.multiply(localECFieldElement3);
        }
        localObject1 = localECFieldElement4.multiplyPlusProduct((ECFieldElement)localObject1, localECFieldElement6, localECFieldElement1).multiplyPlusProduct((ECFieldElement)localObject2, localECFieldElement8, localECFieldElement9);
        paramECPoint = localECFieldElement5.multiply(paramECPoint);
        bool1 = this.withCompression;
        return new F2m(localECCurve, localECFieldElement7, (ECFieldElement)localObject1, new ECFieldElement[] { paramECPoint }, bool1);
      }
      Object localObject2 = this.y;
      ECFieldElement localECFieldElement1 = paramECPoint.y;
      paramECPoint = ((ECFieldElement)localObject1).add(localECFieldElement2);
      localECFieldElement1 = ((ECFieldElement)localObject2).add(localECFieldElement1);
      if (paramECPoint.isZero())
      {
        if (localECFieldElement1.isZero()) {
          return twice();
        }
        return localECCurve.getInfinity();
      }
      localECFieldElement1 = localECFieldElement1.divide(paramECPoint);
      paramECPoint = localECFieldElement1.square().add(localECFieldElement1).add(paramECPoint).add(localECCurve.getA());
      return new F2m(localECCurve, paramECPoint, localECFieldElement1.multiply(((ECFieldElement)localObject1).add(paramECPoint)).add(paramECPoint).add((ECFieldElement)localObject2), this.withCompression);
    }
    
    protected ECPoint detach()
    {
      return new F2m(null, getAffineXCoord(), getAffineYCoord());
    }
    
    protected boolean getCompressionYTilde()
    {
      ECFieldElement localECFieldElement1 = getRawXCoord();
      boolean bool2 = localECFieldElement1.isZero();
      boolean bool1 = false;
      if (bool2) {
        return false;
      }
      ECFieldElement localECFieldElement2 = getRawYCoord();
      int i = getCurveCoordinateSystem();
      if ((i != 5) && (i != 6)) {
        return localECFieldElement2.divide(localECFieldElement1).testBitZero();
      }
      if (localECFieldElement2.testBitZero() != localECFieldElement1.testBitZero()) {
        bool1 = true;
      }
      return bool1;
    }
    
    public ECFieldElement getYCoord()
    {
      int i = getCurveCoordinateSystem();
      if ((i != 5) && (i != 6)) {
        return this.y;
      }
      Object localObject = this.x;
      ECFieldElement localECFieldElement1 = this.y;
      if (!isInfinity())
      {
        if (((ECFieldElement)localObject).isZero()) {
          return localECFieldElement1;
        }
        localECFieldElement1 = localECFieldElement1.add((ECFieldElement)localObject).multiply((ECFieldElement)localObject);
        localObject = localECFieldElement1;
        if (6 == i)
        {
          ECFieldElement localECFieldElement2 = this.zs[0];
          localObject = localECFieldElement1;
          if (!localECFieldElement2.isOne()) {
            localObject = localECFieldElement1.divide(localECFieldElement2);
          }
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
      int i = getCurveCoordinateSystem();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 5)
          {
            if (i == 6)
            {
              localECFieldElement3 = this.y;
              localECFieldElement2 = this.zs[0];
              localECCurve = this.curve;
              localECFieldElement3 = localECFieldElement3.add(localECFieldElement2);
              bool = this.withCompression;
              return new F2m(localECCurve, localECFieldElement1, localECFieldElement3, new ECFieldElement[] { localECFieldElement2 }, bool);
            }
            throw new IllegalStateException("unsupported coordinate system");
          }
          localECFieldElement2 = this.y;
          return new F2m(this.curve, localECFieldElement1, localECFieldElement2.addOne(), this.withCompression);
        }
        ECFieldElement localECFieldElement3 = this.y;
        localECFieldElement2 = this.zs[0];
        ECCurve localECCurve = this.curve;
        localECFieldElement3 = localECFieldElement3.add(localECFieldElement1);
        boolean bool = this.withCompression;
        return new F2m(localECCurve, localECFieldElement1, localECFieldElement3, new ECFieldElement[] { localECFieldElement2 }, bool);
      }
      ECFieldElement localECFieldElement2 = this.y;
      return new F2m(this.curve, localECFieldElement1, localECFieldElement2.add(localECFieldElement1), this.withCompression);
    }
    
    public ECPoint twice()
    {
      if (isInfinity()) {
        return this;
      }
      ECCurve localECCurve = getCurve();
      Object localObject1 = this.x;
      if (((ECFieldElement)localObject1).isZero()) {
        return localECCurve.getInfinity();
      }
      int i = localECCurve.getCoordinateSystem();
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 6)
          {
            ECFieldElement localECFieldElement5 = this.y;
            ECFieldElement localECFieldElement6 = this.zs[0];
            bool = localECFieldElement6.isOne();
            if (bool) {
              localECFieldElement1 = localECFieldElement5;
            } else {
              localECFieldElement1 = localECFieldElement5.multiply(localECFieldElement6);
            }
            if (bool) {
              localECFieldElement2 = localECFieldElement6;
            } else {
              localECFieldElement2 = localECFieldElement6.square();
            }
            localECFieldElement4 = localECCurve.getA();
            if (bool) {
              localECFieldElement3 = localECFieldElement4;
            } else {
              localECFieldElement3 = localECFieldElement4.multiply(localECFieldElement2);
            }
            ECFieldElement localECFieldElement7 = localECFieldElement5.square().add(localECFieldElement1).add(localECFieldElement3);
            if (localECFieldElement7.isZero()) {
              return new F2m(localECCurve, localECFieldElement7, localECCurve.getB().sqrt(), this.withCompression);
            }
            ECFieldElement localECFieldElement8 = localECFieldElement7.square();
            if (bool) {
              localObject2 = localECFieldElement7;
            } else {
              localObject2 = localECFieldElement7.multiply(localECFieldElement2);
            }
            ECFieldElement localECFieldElement9 = localECCurve.getB();
            if (localECFieldElement9.bitLength() < localECCurve.getFieldSize() >> 1)
            {
              localECFieldElement1 = localECFieldElement5.add((ECFieldElement)localObject1).square();
              if (localECFieldElement9.isOne()) {
                localObject1 = localECFieldElement3.add(localECFieldElement2).square();
              } else {
                localObject1 = localECFieldElement3.squarePlusProduct(localECFieldElement9, localECFieldElement2.square());
              }
              localECFieldElement1 = localECFieldElement1.add(localECFieldElement7).add(localECFieldElement2).multiply(localECFieldElement1).add((ECFieldElement)localObject1).add(localECFieldElement8);
              if (!localECFieldElement4.isZero())
              {
                localObject1 = localECFieldElement1;
                if (localECFieldElement4.isOne()) {
                  break label389;
                }
                localObject1 = localECFieldElement1.add(localECFieldElement4.addOne().multiply((ECFieldElement)localObject2));
                break label389;
              }
            }
            else
            {
              if (!bool) {
                localObject1 = ((ECFieldElement)localObject1).multiply(localECFieldElement6);
              }
              localECFieldElement1 = ((ECFieldElement)localObject1).squarePlusProduct(localECFieldElement7, localECFieldElement1).add(localECFieldElement8);
            }
            localObject1 = localECFieldElement1.add((ECFieldElement)localObject2);
            label389:
            bool = this.withCompression;
            return new F2m(localECCurve, localECFieldElement8, (ECFieldElement)localObject1, new ECFieldElement[] { localObject2 }, bool);
          }
          throw new IllegalStateException("unsupported coordinate system");
        }
        localECFieldElement1 = this.y;
        ECFieldElement localECFieldElement2 = this.zs[0];
        boolean bool = localECFieldElement2.isOne();
        if (bool) {
          localObject2 = localObject1;
        } else {
          localObject2 = ((ECFieldElement)localObject1).multiply(localECFieldElement2);
        }
        if (!bool) {
          localECFieldElement1 = localECFieldElement1.multiply(localECFieldElement2);
        }
        localObject1 = ((ECFieldElement)localObject1).square();
        localECFieldElement2 = ((ECFieldElement)localObject1).add(localECFieldElement1);
        localECFieldElement1 = ((ECFieldElement)localObject2).square();
        ECFieldElement localECFieldElement3 = localECFieldElement2.add((ECFieldElement)localObject2);
        ECFieldElement localECFieldElement4 = localECFieldElement3.multiplyPlusProduct(localECFieldElement2, localECFieldElement1, localECCurve.getA());
        localECFieldElement2 = ((ECFieldElement)localObject2).multiply(localECFieldElement4);
        localObject1 = ((ECFieldElement)localObject1).square().multiplyPlusProduct((ECFieldElement)localObject2, localECFieldElement4, localECFieldElement3);
        localObject2 = ((ECFieldElement)localObject2).multiply(localECFieldElement1);
        bool = this.withCompression;
        return new F2m(localECCurve, localECFieldElement2, (ECFieldElement)localObject1, new ECFieldElement[] { localObject2 }, bool);
      }
      Object localObject2 = this.y.divide((ECFieldElement)localObject1).add((ECFieldElement)localObject1);
      ECFieldElement localECFieldElement1 = ((ECFieldElement)localObject2).square().add((ECFieldElement)localObject2).add(localECCurve.getA());
      return new F2m(localECCurve, localECFieldElement1, ((ECFieldElement)localObject1).squarePlusProduct(localECFieldElement1, ((ECFieldElement)localObject2).addOne()), this.withCompression);
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
      if (localECCurve.getCoordinateSystem() != 6) {
        return twice().add(paramECPoint);
      }
      ECFieldElement localECFieldElement2 = paramECPoint.x;
      ECFieldElement localECFieldElement3 = paramECPoint.zs[0];
      if ((!localECFieldElement2.isZero()) && (localECFieldElement3.isOne()))
      {
        localECFieldElement3 = this.y;
        ECFieldElement localECFieldElement7 = this.zs[0];
        ECFieldElement localECFieldElement4 = paramECPoint.y;
        ECFieldElement localECFieldElement5 = localECFieldElement1.square();
        ECFieldElement localECFieldElement6 = localECFieldElement3.square();
        localECFieldElement1 = localECFieldElement7.square();
        localECFieldElement3 = localECFieldElement3.multiply(localECFieldElement7);
        localECFieldElement3 = localECCurve.getA().multiply(localECFieldElement1).add(localECFieldElement6).add(localECFieldElement3);
        localECFieldElement4 = localECFieldElement4.addOne();
        localECFieldElement5 = localECCurve.getA().add(localECFieldElement4).multiply(localECFieldElement1).add(localECFieldElement6).multiplyPlusProduct(localECFieldElement3, localECFieldElement5, localECFieldElement1);
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
          return new F2m(localECCurve, localECFieldElement5, localECCurve.getB().sqrt(), this.withCompression);
        }
        paramECPoint = localECFieldElement5.square().multiply(localECFieldElement6);
        localECFieldElement1 = localECFieldElement5.multiply(localECFieldElement2).multiply(localECFieldElement1);
        localECFieldElement2 = localECFieldElement5.add(localECFieldElement2).square().multiplyPlusProduct(localECFieldElement3, localECFieldElement4, localECFieldElement1);
        boolean bool = this.withCompression;
        return new F2m(localECCurve, paramECPoint, localECFieldElement2, new ECFieldElement[] { localECFieldElement1 }, bool);
      }
      return twice().add(paramECPoint);
    }
  }
  
  public static class Fp
    extends ECPoint.AbstractFp
  {
    public Fp(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      this(paramECCurve, paramECFieldElement1, paramECFieldElement2, false);
    }
    
    public Fp(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, boolean paramBoolean)
    {
      super(paramECFieldElement1, paramECFieldElement2);
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
    
    Fp(ECCurve paramECCurve, ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement[] paramArrayOfECFieldElement, boolean paramBoolean)
    {
      super(paramECFieldElement1, paramECFieldElement2, paramArrayOfECFieldElement);
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
      int i = localECCurve.getCoordinateSystem();
      Object localObject1 = this.x;
      Object localObject2 = this.y;
      Object localObject3 = paramECPoint.x;
      ECFieldElement localECFieldElement1 = paramECPoint.y;
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i != 2) && (i != 4)) {
            throw new IllegalStateException("unsupported coordinate system");
          }
          localObject4 = this.zs[0];
          ECFieldElement localECFieldElement4 = paramECPoint.zs[0];
          bool1 = ((ECFieldElement)localObject4).isOne();
          if ((!bool1) && (localObject4.equals(localECFieldElement4)))
          {
            paramECPoint = ((ECFieldElement)localObject1).subtract((ECFieldElement)localObject3);
            localECFieldElement1 = ((ECFieldElement)localObject2).subtract(localECFieldElement1);
            if (paramECPoint.isZero())
            {
              if (localECFieldElement1.isZero()) {
                return twice();
              }
              return localECCurve.getInfinity();
            }
            localECFieldElement2 = paramECPoint.square();
            localObject1 = ((ECFieldElement)localObject1).multiply(localECFieldElement2);
            localObject3 = ((ECFieldElement)localObject3).multiply(localECFieldElement2);
            localECFieldElement2 = ((ECFieldElement)localObject1).subtract((ECFieldElement)localObject3).multiply((ECFieldElement)localObject2);
            localObject2 = localECFieldElement1.square().subtract((ECFieldElement)localObject1).subtract((ECFieldElement)localObject3);
            localObject1 = ((ECFieldElement)localObject1).subtract((ECFieldElement)localObject2).multiply(localECFieldElement1).subtract(localECFieldElement2);
            localObject4 = paramECPoint.multiply((ECFieldElement)localObject4);
          }
          do
          {
            localObject3 = null;
            paramECPoint = (ECPoint)localObject4;
            localObject4 = localObject3;
            break;
            if (!bool1)
            {
              paramECPoint = ((ECFieldElement)localObject4).square();
              localObject3 = paramECPoint.multiply((ECFieldElement)localObject3);
              localECFieldElement1 = paramECPoint.multiply((ECFieldElement)localObject4).multiply(localECFieldElement1);
            }
            bool2 = localECFieldElement4.isOne();
            if (!bool2)
            {
              paramECPoint = localECFieldElement4.square();
              localObject1 = paramECPoint.multiply((ECFieldElement)localObject1);
              localObject2 = paramECPoint.multiply(localECFieldElement4).multiply((ECFieldElement)localObject2);
            }
            localECFieldElement2 = ((ECFieldElement)localObject1).subtract((ECFieldElement)localObject3);
            paramECPoint = ((ECFieldElement)localObject2).subtract(localECFieldElement1);
            if (localECFieldElement2.isZero())
            {
              if (paramECPoint.isZero()) {
                return twice();
              }
              return localECCurve.getInfinity();
            }
            localECFieldElement3 = localECFieldElement2.square();
            localObject3 = localECFieldElement3.multiply(localECFieldElement2);
            localObject1 = localECFieldElement3.multiply((ECFieldElement)localObject1);
            localECFieldElement1 = paramECPoint.square().add((ECFieldElement)localObject3).subtract(two((ECFieldElement)localObject1));
            localObject3 = ((ECFieldElement)localObject1).subtract(localECFieldElement1).multiplyMinusProduct(paramECPoint, (ECFieldElement)localObject3, (ECFieldElement)localObject2);
            if (!bool1) {
              paramECPoint = localECFieldElement2.multiply((ECFieldElement)localObject4);
            } else {
              paramECPoint = localECFieldElement2;
            }
            if (!bool2) {
              paramECPoint = paramECPoint.multiply(localECFieldElement4);
            }
            localObject4 = paramECPoint;
            localObject2 = localECFieldElement1;
            localObject1 = localObject3;
          } while (paramECPoint != localECFieldElement2);
          localObject4 = localECFieldElement3;
          localObject1 = localObject3;
          localObject2 = localECFieldElement1;
          if (i == 4)
          {
            localECFieldElement1 = calculateJacobianModifiedW(paramECPoint, (ECFieldElement)localObject4);
            localObject3 = new ECFieldElement[2];
            localObject3[0] = paramECPoint;
            localObject3[1] = localECFieldElement1;
            paramECPoint = (ECPoint)localObject3;
          }
          else
          {
            paramECPoint = new ECFieldElement[] { paramECPoint };
          }
          return new Fp(localECCurve, (ECFieldElement)localObject2, (ECFieldElement)localObject1, paramECPoint, this.withCompression);
        }
        Object localObject4 = this.zs[0];
        paramECPoint = paramECPoint.zs[0];
        boolean bool1 = ((ECFieldElement)localObject4).isOne();
        boolean bool2 = paramECPoint.isOne();
        if (!bool1) {
          localECFieldElement1 = localECFieldElement1.multiply((ECFieldElement)localObject4);
        }
        if (!bool2) {
          localObject2 = ((ECFieldElement)localObject2).multiply(paramECPoint);
        }
        localECFieldElement1 = localECFieldElement1.subtract((ECFieldElement)localObject2);
        if (!bool1) {
          localObject3 = ((ECFieldElement)localObject3).multiply((ECFieldElement)localObject4);
        }
        if (!bool2) {
          localObject1 = ((ECFieldElement)localObject1).multiply(paramECPoint);
        }
        localObject3 = ((ECFieldElement)localObject3).subtract((ECFieldElement)localObject1);
        if (((ECFieldElement)localObject3).isZero())
        {
          if (localECFieldElement1.isZero()) {
            return twice();
          }
          return localECCurve.getInfinity();
        }
        if (!bool1) {
          if (bool2) {
            paramECPoint = (ECPoint)localObject4;
          } else {
            paramECPoint = ((ECFieldElement)localObject4).multiply(paramECPoint);
          }
        }
        ECFieldElement localECFieldElement2 = ((ECFieldElement)localObject3).square();
        localObject4 = localECFieldElement2.multiply((ECFieldElement)localObject3);
        localECFieldElement2 = localECFieldElement2.multiply((ECFieldElement)localObject1);
        ECFieldElement localECFieldElement3 = localECFieldElement1.square().multiply(paramECPoint).subtract((ECFieldElement)localObject4).subtract(two(localECFieldElement2));
        localObject1 = ((ECFieldElement)localObject3).multiply(localECFieldElement3);
        localObject2 = localECFieldElement2.subtract(localECFieldElement3).multiplyMinusProduct(localECFieldElement1, (ECFieldElement)localObject2, (ECFieldElement)localObject4);
        paramECPoint = ((ECFieldElement)localObject4).multiply(paramECPoint);
        bool1 = this.withCompression;
        return new Fp(localECCurve, (ECFieldElement)localObject1, (ECFieldElement)localObject2, new ECFieldElement[] { paramECPoint }, bool1);
      }
      paramECPoint = ((ECFieldElement)localObject3).subtract((ECFieldElement)localObject1);
      localECFieldElement1 = localECFieldElement1.subtract((ECFieldElement)localObject2);
      if (paramECPoint.isZero())
      {
        if (localECFieldElement1.isZero()) {
          return twice();
        }
        return localECCurve.getInfinity();
      }
      paramECPoint = localECFieldElement1.divide(paramECPoint);
      localObject3 = paramECPoint.square().subtract((ECFieldElement)localObject1).subtract((ECFieldElement)localObject3);
      return new Fp(localECCurve, (ECFieldElement)localObject3, paramECPoint.multiply(((ECFieldElement)localObject1).subtract((ECFieldElement)localObject3)).subtract((ECFieldElement)localObject2), this.withCompression);
    }
    
    protected ECFieldElement calculateJacobianModifiedW(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
    {
      ECFieldElement localECFieldElement2 = getCurve().getA();
      if (!localECFieldElement2.isZero())
      {
        if (paramECFieldElement1.isOne()) {
          return localECFieldElement2;
        }
        ECFieldElement localECFieldElement1 = paramECFieldElement2;
        if (paramECFieldElement2 == null) {
          localECFieldElement1 = paramECFieldElement1.square();
        }
        paramECFieldElement1 = localECFieldElement1.square();
        paramECFieldElement2 = localECFieldElement2.negate();
        if (paramECFieldElement2.bitLength() < localECFieldElement2.bitLength()) {
          return paramECFieldElement1.multiply(paramECFieldElement2).negate();
        }
        return paramECFieldElement1.multiply(localECFieldElement2);
      }
      return localECFieldElement2;
    }
    
    protected ECPoint detach()
    {
      return new Fp(null, getAffineXCoord(), getAffineYCoord());
    }
    
    protected ECFieldElement doubleProductFromSquares(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3, ECFieldElement paramECFieldElement4)
    {
      return paramECFieldElement1.add(paramECFieldElement2).square().subtract(paramECFieldElement3).subtract(paramECFieldElement4);
    }
    
    protected ECFieldElement eight(ECFieldElement paramECFieldElement)
    {
      return four(two(paramECFieldElement));
    }
    
    protected ECFieldElement four(ECFieldElement paramECFieldElement)
    {
      return two(two(paramECFieldElement));
    }
    
    protected ECFieldElement getJacobianModifiedW()
    {
      Object localObject2 = this.zs[1];
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = this.zs;
        localObject1 = calculateJacobianModifiedW(this.zs[0], null);
        localObject2[1] = localObject1;
      }
      return (ECFieldElement)localObject1;
    }
    
    public ECFieldElement getZCoord(int paramInt)
    {
      if ((paramInt == 1) && (4 == getCurveCoordinateSystem())) {
        return getJacobianModifiedW();
      }
      return super.getZCoord(paramInt);
    }
    
    public ECPoint negate()
    {
      if (isInfinity()) {
        return this;
      }
      ECCurve localECCurve = getCurve();
      if (localECCurve.getCoordinateSystem() != 0) {
        return new Fp(localECCurve, this.x, this.y.negate(), this.zs, this.withCompression);
      }
      return new Fp(localECCurve, this.x, this.y.negate(), this.withCompression);
    }
    
    protected ECFieldElement three(ECFieldElement paramECFieldElement)
    {
      return two(paramECFieldElement).add(paramECFieldElement);
    }
    
    public ECPoint threeTimes()
    {
      if (isInfinity()) {
        return this;
      }
      ECFieldElement localECFieldElement1 = this.y;
      if (localECFieldElement1.isZero()) {
        return this;
      }
      ECCurve localECCurve = getCurve();
      int i = localECCurve.getCoordinateSystem();
      if (i != 0)
      {
        if (i != 4) {
          return twice().add(this);
        }
        return twiceJacobianModified(false).add(this);
      }
      ECFieldElement localECFieldElement2 = this.x;
      ECFieldElement localECFieldElement5 = two(localECFieldElement1);
      ECFieldElement localECFieldElement3 = localECFieldElement5.square();
      ECFieldElement localECFieldElement4 = three(localECFieldElement2.square()).add(getCurve().getA());
      ECFieldElement localECFieldElement6 = localECFieldElement4.square();
      localECFieldElement6 = three(localECFieldElement2).multiply(localECFieldElement3).subtract(localECFieldElement6);
      if (localECFieldElement6.isZero()) {
        return getCurve().getInfinity();
      }
      localECFieldElement5 = localECFieldElement6.multiply(localECFieldElement5).invert();
      localECFieldElement4 = localECFieldElement6.multiply(localECFieldElement5).multiply(localECFieldElement4);
      localECFieldElement3 = localECFieldElement3.square().multiply(localECFieldElement5).subtract(localECFieldElement4);
      localECFieldElement4 = localECFieldElement3.subtract(localECFieldElement4).multiply(localECFieldElement4.add(localECFieldElement3)).add(localECFieldElement2);
      return new Fp(localECCurve, localECFieldElement4, localECFieldElement2.subtract(localECFieldElement4).multiply(localECFieldElement3).subtract(localECFieldElement1), this.withCompression);
    }
    
    public ECPoint timesPow2(int paramInt)
    {
      if (paramInt >= 0)
      {
        if (paramInt != 0)
        {
          if (isInfinity()) {
            return this;
          }
          if (paramInt == 1) {
            return twice();
          }
          ECCurve localECCurve = getCurve();
          ECFieldElement localECFieldElement2 = this.y;
          if (localECFieldElement2.isZero()) {
            return localECCurve.getInfinity();
          }
          int j = localECCurve.getCoordinateSystem();
          ECFieldElement localECFieldElement3 = localECCurve.getA();
          Object localObject4 = this.x;
          if (this.zs.length < 1) {
            localObject2 = localECCurve.fromBigInteger(ECConstants.ONE);
          } else {
            localObject2 = this.zs[0];
          }
          ECFieldElement localECFieldElement1 = localECFieldElement2;
          Object localObject1 = localECFieldElement3;
          Object localObject3 = localObject4;
          if (!((ECFieldElement)localObject2).isOne())
          {
            localECFieldElement1 = localECFieldElement2;
            localObject1 = localECFieldElement3;
            localObject3 = localObject4;
            if (j != 0)
            {
              if (j != 1)
              {
                if (j != 2)
                {
                  if (j == 4)
                  {
                    localObject1 = getJacobianModifiedW();
                    localECFieldElement1 = localECFieldElement2;
                    localObject3 = localObject4;
                    break label229;
                  }
                  throw new IllegalStateException("unsupported coordinate system");
                }
                localObject1 = null;
                localECFieldElement1 = localECFieldElement2;
                localObject3 = localObject4;
              }
              else
              {
                localObject1 = ((ECFieldElement)localObject2).square();
                localObject3 = ((ECFieldElement)localObject4).multiply((ECFieldElement)localObject2);
                localECFieldElement1 = localECFieldElement2.multiply((ECFieldElement)localObject1);
              }
              localObject1 = calculateJacobianModifiedW((ECFieldElement)localObject2, (ECFieldElement)localObject1);
            }
          }
          label229:
          int i = 0;
          localObject4 = localObject3;
          localObject3 = localObject1;
          localObject1 = localObject2;
          while (i < paramInt)
          {
            if (localECFieldElement1.isZero()) {
              return localECCurve.getInfinity();
            }
            localECFieldElement3 = three(((ECFieldElement)localObject4).square());
            localECFieldElement2 = two(localECFieldElement1);
            localObject2 = localECFieldElement2.multiply(localECFieldElement1);
            ECFieldElement localECFieldElement4 = two(((ECFieldElement)localObject4).multiply((ECFieldElement)localObject2));
            ECFieldElement localECFieldElement5 = two(((ECFieldElement)localObject2).square());
            localObject2 = localObject3;
            localECFieldElement1 = localECFieldElement3;
            if (!((ECFieldElement)localObject3).isZero())
            {
              localECFieldElement1 = localECFieldElement3.add((ECFieldElement)localObject3);
              localObject2 = two(localECFieldElement5.multiply((ECFieldElement)localObject3));
            }
            localObject4 = localECFieldElement1.square().subtract(two(localECFieldElement4));
            localECFieldElement1 = localECFieldElement1.multiply(localECFieldElement4.subtract((ECFieldElement)localObject4)).subtract(localECFieldElement5);
            if (((ECFieldElement)localObject1).isOne()) {
              localObject1 = localECFieldElement2;
            } else {
              localObject1 = localECFieldElement2.multiply((ECFieldElement)localObject1);
            }
            i += 1;
            localObject3 = localObject2;
          }
          if (j != 0)
          {
            if (j != 1)
            {
              if (j != 2)
              {
                if (j == 4)
                {
                  bool = this.withCompression;
                  return new Fp(localECCurve, (ECFieldElement)localObject4, localECFieldElement1, new ECFieldElement[] { localObject1, localObject3 }, bool);
                }
                throw new IllegalStateException("unsupported coordinate system");
              }
              bool = this.withCompression;
              return new Fp(localECCurve, (ECFieldElement)localObject4, localECFieldElement1, new ECFieldElement[] { localObject1 }, bool);
            }
            localObject2 = ((ECFieldElement)localObject4).multiply((ECFieldElement)localObject1);
            localObject1 = ((ECFieldElement)localObject1).multiply(((ECFieldElement)localObject1).square());
            boolean bool = this.withCompression;
            return new Fp(localECCurve, (ECFieldElement)localObject2, localECFieldElement1, new ECFieldElement[] { localObject1 }, bool);
          }
          Object localObject2 = ((ECFieldElement)localObject1).invert();
          localObject1 = ((ECFieldElement)localObject2).square();
          localObject2 = ((ECFieldElement)localObject1).multiply((ECFieldElement)localObject2);
          return new Fp(localECCurve, ((ECFieldElement)localObject4).multiply((ECFieldElement)localObject1), localECFieldElement1.multiply((ECFieldElement)localObject2), this.withCompression);
        }
        return this;
      }
      throw new IllegalArgumentException("'e' cannot be negative");
    }
    
    public ECPoint twice()
    {
      if (isInfinity()) {
        return this;
      }
      ECCurve localECCurve = getCurve();
      ECFieldElement localECFieldElement2 = this.y;
      if (localECFieldElement2.isZero()) {
        return localECCurve.getInfinity();
      }
      int i = localECCurve.getCoordinateSystem();
      ECFieldElement localECFieldElement4 = this.x;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i == 4) {
              return twiceJacobianModified(true);
            }
            throw new IllegalStateException("unsupported coordinate system");
          }
          localECFieldElement3 = this.zs[0];
          bool = localECFieldElement3.isOne();
          localECFieldElement6 = localECFieldElement2.square();
          localECFieldElement5 = localECFieldElement6.square();
          localObject = localECCurve.getA();
          ECFieldElement localECFieldElement7 = ((ECFieldElement)localObject).negate();
          if (localECFieldElement7.toBigInteger().equals(BigInteger.valueOf(3L)))
          {
            if (bool) {
              localObject = localECFieldElement3;
            } else {
              localObject = localECFieldElement3.square();
            }
            localObject = three(localECFieldElement4.add((ECFieldElement)localObject).multiply(localECFieldElement4.subtract((ECFieldElement)localObject)));
            localECFieldElement1 = localECFieldElement6.multiply(localECFieldElement4);
          }
          else
          {
            localECFieldElement1 = three(localECFieldElement4.square());
            if (bool) {}
            for (;;)
            {
              localObject = localECFieldElement1.add((ECFieldElement)localObject);
              break label270;
              if (((ECFieldElement)localObject).isZero()) {
                break;
              }
              ECFieldElement localECFieldElement8 = localECFieldElement3.square().square();
              if (localECFieldElement7.bitLength() < ((ECFieldElement)localObject).bitLength())
              {
                localObject = localECFieldElement1.subtract(localECFieldElement8.multiply(localECFieldElement7));
                break label270;
              }
              localObject = localECFieldElement8.multiply((ECFieldElement)localObject);
            }
            localObject = localECFieldElement1;
            label270:
            localECFieldElement1 = localECFieldElement4.multiply(localECFieldElement6);
          }
          localECFieldElement1 = four(localECFieldElement1);
          localECFieldElement4 = ((ECFieldElement)localObject).square().subtract(two(localECFieldElement1));
          localECFieldElement5 = localECFieldElement1.subtract(localECFieldElement4).multiply((ECFieldElement)localObject).subtract(eight(localECFieldElement5));
          localECFieldElement1 = two(localECFieldElement2);
          localObject = localECFieldElement1;
          if (!bool) {
            localObject = localECFieldElement1.multiply(localECFieldElement3);
          }
          bool = this.withCompression;
          return new Fp(localECCurve, localECFieldElement4, localECFieldElement5, new ECFieldElement[] { localObject }, bool);
        }
        ECFieldElement localECFieldElement5 = this.zs[0];
        boolean bool = localECFieldElement5.isOne();
        localECFieldElement1 = localECCurve.getA();
        localObject = localECFieldElement1;
        if (!localECFieldElement1.isZero())
        {
          localObject = localECFieldElement1;
          if (!bool) {
            localObject = localECFieldElement1.multiply(localECFieldElement5.square());
          }
        }
        ECFieldElement localECFieldElement3 = ((ECFieldElement)localObject).add(three(localECFieldElement4.square()));
        if (bool) {
          localObject = localECFieldElement2;
        } else {
          localObject = localECFieldElement2.multiply(localECFieldElement5);
        }
        if (bool) {
          localECFieldElement1 = localECFieldElement2.square();
        } else {
          localECFieldElement1 = ((ECFieldElement)localObject).multiply(localECFieldElement2);
        }
        localECFieldElement5 = four(localECFieldElement4.multiply(localECFieldElement1));
        ECFieldElement localECFieldElement6 = localECFieldElement3.square().subtract(two(localECFieldElement5));
        localECFieldElement4 = two((ECFieldElement)localObject);
        localECFieldElement2 = localECFieldElement6.multiply(localECFieldElement4);
        localECFieldElement1 = two(localECFieldElement1);
        localECFieldElement3 = localECFieldElement5.subtract(localECFieldElement6).multiply(localECFieldElement3).subtract(two(localECFieldElement1.square()));
        if (bool) {
          localECFieldElement1 = two(localECFieldElement1);
        } else {
          localECFieldElement1 = localECFieldElement4.square();
        }
        localObject = two(localECFieldElement1).multiply((ECFieldElement)localObject);
        bool = this.withCompression;
        return new Fp(localECCurve, localECFieldElement2, localECFieldElement3, new ECFieldElement[] { localObject }, bool);
      }
      Object localObject = three(localECFieldElement4.square()).add(getCurve().getA()).divide(two(localECFieldElement2));
      ECFieldElement localECFieldElement1 = ((ECFieldElement)localObject).square().subtract(two(localECFieldElement4));
      return new Fp(localECCurve, localECFieldElement1, ((ECFieldElement)localObject).multiply(localECFieldElement4.subtract(localECFieldElement1)).subtract(localECFieldElement2), this.withCompression);
    }
    
    protected Fp twiceJacobianModified(boolean paramBoolean)
    {
      ECFieldElement localECFieldElement3 = this.x;
      ECFieldElement localECFieldElement5 = this.y;
      Object localObject = this.zs[0];
      ECFieldElement localECFieldElement1 = getJacobianModifiedW();
      ECFieldElement localECFieldElement4 = three(localECFieldElement3.square()).add(localECFieldElement1);
      ECFieldElement localECFieldElement2 = two(localECFieldElement5);
      localECFieldElement5 = localECFieldElement2.multiply(localECFieldElement5);
      ECFieldElement localECFieldElement6 = two(localECFieldElement3.multiply(localECFieldElement5));
      localECFieldElement3 = localECFieldElement4.square().subtract(two(localECFieldElement6));
      localECFieldElement5 = two(localECFieldElement5.square());
      localECFieldElement4 = localECFieldElement4.multiply(localECFieldElement6.subtract(localECFieldElement3)).subtract(localECFieldElement5);
      if (paramBoolean) {
        localECFieldElement1 = two(localECFieldElement5.multiply(localECFieldElement1));
      } else {
        localECFieldElement1 = null;
      }
      if (!((ECFieldElement)localObject).isOne()) {
        localECFieldElement2 = localECFieldElement2.multiply((ECFieldElement)localObject);
      }
      localObject = getCurve();
      paramBoolean = this.withCompression;
      return new Fp((ECCurve)localObject, localECFieldElement3, localECFieldElement4, new ECFieldElement[] { localECFieldElement2, localECFieldElement1 }, paramBoolean);
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
      ECFieldElement localECFieldElement1 = this.y;
      if (localECFieldElement1.isZero()) {
        return paramECPoint;
      }
      ECCurve localECCurve = getCurve();
      int i = localECCurve.getCoordinateSystem();
      if (i != 0)
      {
        if (i != 4) {
          return twice().add(paramECPoint);
        }
        return twiceJacobianModified(false).add(paramECPoint);
      }
      ECFieldElement localECFieldElement2 = this.x;
      ECFieldElement localECFieldElement3 = paramECPoint.x;
      ECFieldElement localECFieldElement4 = paramECPoint.y;
      paramECPoint = localECFieldElement3.subtract(localECFieldElement2);
      ECFieldElement localECFieldElement5 = localECFieldElement4.subtract(localECFieldElement1);
      if (paramECPoint.isZero())
      {
        if (localECFieldElement5.isZero()) {
          return threeTimes();
        }
        return this;
      }
      localECFieldElement4 = paramECPoint.square();
      ECFieldElement localECFieldElement6 = localECFieldElement5.square();
      ECFieldElement localECFieldElement7 = localECFieldElement4.multiply(two(localECFieldElement2).add(localECFieldElement3)).subtract(localECFieldElement6);
      if (localECFieldElement7.isZero()) {
        return localECCurve.getInfinity();
      }
      localECFieldElement6 = localECFieldElement7.multiply(paramECPoint).invert();
      localECFieldElement5 = localECFieldElement7.multiply(localECFieldElement6).multiply(localECFieldElement5);
      paramECPoint = two(localECFieldElement1).multiply(localECFieldElement4).multiply(paramECPoint).multiply(localECFieldElement6).subtract(localECFieldElement5);
      localECFieldElement3 = paramECPoint.subtract(localECFieldElement5).multiply(localECFieldElement5.add(paramECPoint)).add(localECFieldElement3);
      return new Fp(localECCurve, localECFieldElement3, localECFieldElement2.subtract(localECFieldElement3).multiply(paramECPoint).subtract(localECFieldElement1), this.withCompression);
    }
    
    protected ECFieldElement two(ECFieldElement paramECFieldElement)
    {
      return paramECFieldElement.add(paramECFieldElement);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\ECPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */