package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat160;
import org.bouncycastle.util.Arrays;

public class SecP160R2FieldElement
  extends ECFieldElement
{
  public static final BigInteger Q = SecP160R2Curve.q;
  protected int[] x;
  
  public SecP160R2FieldElement()
  {
    this.x = Nat160.create();
  }
  
  public SecP160R2FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP160R2Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP160R2FieldElement");
  }
  
  protected SecP160R2FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat160.create();
    SecP160R2Field.add(this.x, ((SecP160R2FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat160.create();
    SecP160R2Field.addOne(this.x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat160.create();
    Mod.invert(SecP160R2Field.P, ((SecP160R2FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP160R2Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP160R2FieldElement)) {
      return false;
    }
    paramObject = (SecP160R2FieldElement)paramObject;
    return Nat160.eq(this.x, ((SecP160R2FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP160R2Field";
  }
  
  public int getFieldSize()
  {
    return Q.bitLength();
  }
  
  public int hashCode()
  {
    return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 5);
  }
  
  public ECFieldElement invert()
  {
    int[] arrayOfInt = Nat160.create();
    Mod.invert(SecP160R2Field.P, this.x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public boolean isOne()
  {
    return Nat160.isOne(this.x);
  }
  
  public boolean isZero()
  {
    return Nat160.isZero(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat160.create();
    SecP160R2Field.multiply(this.x, ((SecP160R2FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat160.create();
    SecP160R2Field.negate(this.x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat160.isZero(arrayOfInt1))
    {
      if (Nat160.isOne(arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt2 = Nat160.create();
      SecP160R2Field.square(arrayOfInt1, arrayOfInt2);
      SecP160R2Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = Nat160.create();
      SecP160R2Field.square(arrayOfInt2, arrayOfInt3);
      SecP160R2Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = Nat160.create();
      SecP160R2Field.square(arrayOfInt3, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      int[] arrayOfInt5 = Nat160.create();
      SecP160R2Field.squareN(arrayOfInt4, 3, arrayOfInt5);
      SecP160R2Field.multiply(arrayOfInt5, arrayOfInt3, arrayOfInt5);
      SecP160R2Field.squareN(arrayOfInt5, 7, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 3, arrayOfInt5);
      SecP160R2Field.multiply(arrayOfInt5, arrayOfInt3, arrayOfInt5);
      int[] arrayOfInt6 = Nat160.create();
      SecP160R2Field.squareN(arrayOfInt5, 14, arrayOfInt6);
      SecP160R2Field.multiply(arrayOfInt6, arrayOfInt4, arrayOfInt6);
      SecP160R2Field.squareN(arrayOfInt6, 31, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt6, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 62, arrayOfInt6);
      SecP160R2Field.multiply(arrayOfInt6, arrayOfInt4, arrayOfInt6);
      SecP160R2Field.squareN(arrayOfInt6, 3, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 18, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 2, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 3, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 6, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP160R2Field.squareN(arrayOfInt4, 2, arrayOfInt4);
      SecP160R2Field.multiply(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      SecP160R2Field.square(arrayOfInt4, arrayOfInt2);
      if (Nat160.eq(arrayOfInt1, arrayOfInt2)) {
        return new SecP160R2FieldElement(arrayOfInt4);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat160.create();
    SecP160R2Field.square(this.x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat160.create();
    SecP160R2Field.subtract(this.x, ((SecP160R2FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP160R2FieldElement(arrayOfInt);
  }
  
  public boolean testBitZero()
  {
    int[] arrayOfInt = this.x;
    boolean bool = false;
    if (Nat160.getBit(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger toBigInteger()
  {
    return Nat160.toBigInteger(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP160R2FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */