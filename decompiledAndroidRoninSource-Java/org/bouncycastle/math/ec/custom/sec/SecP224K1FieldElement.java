package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;

public class SecP224K1FieldElement
  extends ECFieldElement
{
  private static final int[] PRECOMP_POW2 = { 868209154, -587542221, 579297866, -1014948952, -1470801668, 514782679, -1897982644 };
  public static final BigInteger Q = SecP224K1Curve.q;
  protected int[] x;
  
  public SecP224K1FieldElement()
  {
    this.x = Nat224.create();
  }
  
  public SecP224K1FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP224K1Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP224K1FieldElement");
  }
  
  protected SecP224K1FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.add(this.x, ((SecP224K1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.addOne(this.x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    Mod.invert(SecP224K1Field.P, ((SecP224K1FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP224K1Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP224K1FieldElement)) {
      return false;
    }
    paramObject = (SecP224K1FieldElement)paramObject;
    return Nat224.eq(this.x, ((SecP224K1FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP224K1Field";
  }
  
  public int getFieldSize()
  {
    return Q.bitLength();
  }
  
  public int hashCode()
  {
    return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 7);
  }
  
  public ECFieldElement invert()
  {
    int[] arrayOfInt = Nat224.create();
    Mod.invert(SecP224K1Field.P, this.x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public boolean isOne()
  {
    return Nat224.isOne(this.x);
  }
  
  public boolean isZero()
  {
    return Nat224.isZero(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.multiply(this.x, ((SecP224K1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.negate(this.x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat224.isZero(arrayOfInt1))
    {
      if (Nat224.isOne(arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt2 = Nat224.create();
      SecP224K1Field.square(arrayOfInt1, arrayOfInt2);
      SecP224K1Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      SecP224K1Field.square(arrayOfInt2, arrayOfInt2);
      SecP224K1Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = Nat224.create();
      SecP224K1Field.square(arrayOfInt2, arrayOfInt3);
      SecP224K1Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = Nat224.create();
      SecP224K1Field.squareN(arrayOfInt3, 4, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      int[] arrayOfInt5 = Nat224.create();
      SecP224K1Field.squareN(arrayOfInt4, 3, arrayOfInt5);
      SecP224K1Field.multiply(arrayOfInt5, arrayOfInt2, arrayOfInt5);
      SecP224K1Field.squareN(arrayOfInt5, 8, arrayOfInt5);
      SecP224K1Field.multiply(arrayOfInt5, arrayOfInt4, arrayOfInt5);
      SecP224K1Field.squareN(arrayOfInt5, 4, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP224K1Field.squareN(arrayOfInt4, 19, arrayOfInt3);
      SecP224K1Field.multiply(arrayOfInt3, arrayOfInt5, arrayOfInt3);
      int[] arrayOfInt6 = Nat224.create();
      SecP224K1Field.squareN(arrayOfInt3, 42, arrayOfInt6);
      SecP224K1Field.multiply(arrayOfInt6, arrayOfInt3, arrayOfInt6);
      SecP224K1Field.squareN(arrayOfInt6, 23, arrayOfInt3);
      SecP224K1Field.multiply(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      SecP224K1Field.squareN(arrayOfInt3, 84, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt6, arrayOfInt4);
      SecP224K1Field.squareN(arrayOfInt4, 20, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      SecP224K1Field.squareN(arrayOfInt4, 3, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      SecP224K1Field.squareN(arrayOfInt4, 2, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt1, arrayOfInt4);
      SecP224K1Field.squareN(arrayOfInt4, 4, arrayOfInt4);
      SecP224K1Field.multiply(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      SecP224K1Field.square(arrayOfInt4, arrayOfInt4);
      SecP224K1Field.square(arrayOfInt4, arrayOfInt6);
      if (Nat224.eq(arrayOfInt1, arrayOfInt6)) {
        return new SecP224K1FieldElement(arrayOfInt4);
      }
      SecP224K1Field.multiply(arrayOfInt4, PRECOMP_POW2, arrayOfInt4);
      SecP224K1Field.square(arrayOfInt4, arrayOfInt6);
      if (Nat224.eq(arrayOfInt1, arrayOfInt6)) {
        return new SecP224K1FieldElement(arrayOfInt4);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.square(this.x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    SecP224K1Field.subtract(this.x, ((SecP224K1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP224K1FieldElement(arrayOfInt);
  }
  
  public boolean testBitZero()
  {
    int[] arrayOfInt = this.x;
    boolean bool = false;
    if (Nat224.getBit(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger toBigInteger()
  {
    return Nat224.toBigInteger(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP224K1FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */