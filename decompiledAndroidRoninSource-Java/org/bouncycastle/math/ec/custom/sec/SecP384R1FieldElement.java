package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

public class SecP384R1FieldElement
  extends ECFieldElement
{
  public static final BigInteger Q = SecP384R1Curve.q;
  protected int[] x;
  
  public SecP384R1FieldElement()
  {
    this.x = Nat.create(12);
  }
  
  public SecP384R1FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP384R1Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP384R1FieldElement");
  }
  
  protected SecP384R1FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(12);
    SecP384R1Field.add(this.x, ((SecP384R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat.create(12);
    SecP384R1Field.addOne(this.x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(12);
    Mod.invert(SecP384R1Field.P, ((SecP384R1FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP384R1Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP384R1FieldElement)) {
      return false;
    }
    paramObject = (SecP384R1FieldElement)paramObject;
    return Nat.eq(12, this.x, ((SecP384R1FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP384R1Field";
  }
  
  public int getFieldSize()
  {
    return Q.bitLength();
  }
  
  public int hashCode()
  {
    return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 12);
  }
  
  public ECFieldElement invert()
  {
    int[] arrayOfInt = Nat.create(12);
    Mod.invert(SecP384R1Field.P, this.x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public boolean isOne()
  {
    return Nat.isOne(12, this.x);
  }
  
  public boolean isZero()
  {
    return Nat.isZero(12, this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(12);
    SecP384R1Field.multiply(this.x, ((SecP384R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat.create(12);
    SecP384R1Field.negate(this.x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat.isZero(12, arrayOfInt1))
    {
      if (Nat.isOne(12, arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt2 = Nat.create(12);
      int[] arrayOfInt3 = Nat.create(12);
      int[] arrayOfInt4 = Nat.create(12);
      int[] arrayOfInt5 = Nat.create(12);
      SecP384R1Field.square(arrayOfInt1, arrayOfInt2);
      SecP384R1Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      SecP384R1Field.squareN(arrayOfInt2, 2, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      SecP384R1Field.square(arrayOfInt3, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 5, arrayOfInt4);
      SecP384R1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP384R1Field.squareN(arrayOfInt4, 5, arrayOfInt5);
      SecP384R1Field.multiply(arrayOfInt5, arrayOfInt3, arrayOfInt5);
      SecP384R1Field.squareN(arrayOfInt5, 15, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt5, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 2, arrayOfInt4);
      SecP384R1Field.multiply(arrayOfInt2, arrayOfInt4, arrayOfInt2);
      SecP384R1Field.squareN(arrayOfInt4, 28, arrayOfInt4);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 60, arrayOfInt4);
      SecP384R1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP384R1Field.squareN(arrayOfInt4, 120, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 15, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt5, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 33, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 64, arrayOfInt3);
      SecP384R1Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      SecP384R1Field.squareN(arrayOfInt3, 30, arrayOfInt2);
      SecP384R1Field.square(arrayOfInt2, arrayOfInt3);
      if (Nat.eq(12, arrayOfInt1, arrayOfInt3)) {
        return new SecP384R1FieldElement(arrayOfInt2);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat.create(12);
    SecP384R1Field.square(this.x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(12);
    SecP384R1Field.subtract(this.x, ((SecP384R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP384R1FieldElement(arrayOfInt);
  }
  
  public boolean testBitZero()
  {
    int[] arrayOfInt = this.x;
    boolean bool = false;
    if (Nat.getBit(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger toBigInteger()
  {
    return Nat.toBigInteger(12, this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP384R1FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */