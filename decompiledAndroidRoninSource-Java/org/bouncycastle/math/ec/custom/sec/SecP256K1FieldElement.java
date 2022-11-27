package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public class SecP256K1FieldElement
  extends ECFieldElement
{
  public static final BigInteger Q = SecP256K1Curve.q;
  protected int[] x;
  
  public SecP256K1FieldElement()
  {
    this.x = Nat256.create();
  }
  
  public SecP256K1FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP256K1Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP256K1FieldElement");
  }
  
  protected SecP256K1FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    SecP256K1Field.add(this.x, ((SecP256K1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat256.create();
    SecP256K1Field.addOne(this.x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    Mod.invert(SecP256K1Field.P, ((SecP256K1FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP256K1Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP256K1FieldElement)) {
      return false;
    }
    paramObject = (SecP256K1FieldElement)paramObject;
    return Nat256.eq(this.x, ((SecP256K1FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP256K1Field";
  }
  
  public int getFieldSize()
  {
    return Q.bitLength();
  }
  
  public int hashCode()
  {
    return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 8);
  }
  
  public ECFieldElement invert()
  {
    int[] arrayOfInt = Nat256.create();
    Mod.invert(SecP256K1Field.P, this.x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public boolean isOne()
  {
    return Nat256.isOne(this.x);
  }
  
  public boolean isZero()
  {
    return Nat256.isZero(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    SecP256K1Field.multiply(this.x, ((SecP256K1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat256.create();
    SecP256K1Field.negate(this.x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat256.isZero(arrayOfInt1))
    {
      if (Nat256.isOne(arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt2 = Nat256.create();
      SecP256K1Field.square(arrayOfInt1, arrayOfInt2);
      SecP256K1Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = Nat256.create();
      SecP256K1Field.square(arrayOfInt2, arrayOfInt3);
      SecP256K1Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = Nat256.create();
      SecP256K1Field.squareN(arrayOfInt3, 3, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP256K1Field.squareN(arrayOfInt4, 3, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP256K1Field.squareN(arrayOfInt4, 2, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      int[] arrayOfInt5 = Nat256.create();
      SecP256K1Field.squareN(arrayOfInt4, 11, arrayOfInt5);
      SecP256K1Field.multiply(arrayOfInt5, arrayOfInt4, arrayOfInt5);
      SecP256K1Field.squareN(arrayOfInt5, 22, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      int[] arrayOfInt6 = Nat256.create();
      SecP256K1Field.squareN(arrayOfInt4, 44, arrayOfInt6);
      SecP256K1Field.multiply(arrayOfInt6, arrayOfInt4, arrayOfInt6);
      int[] arrayOfInt7 = Nat256.create();
      SecP256K1Field.squareN(arrayOfInt6, 88, arrayOfInt7);
      SecP256K1Field.multiply(arrayOfInt7, arrayOfInt6, arrayOfInt7);
      SecP256K1Field.squareN(arrayOfInt7, 44, arrayOfInt6);
      SecP256K1Field.multiply(arrayOfInt6, arrayOfInt4, arrayOfInt6);
      SecP256K1Field.squareN(arrayOfInt6, 3, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP256K1Field.squareN(arrayOfInt4, 23, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt5, arrayOfInt4);
      SecP256K1Field.squareN(arrayOfInt4, 6, arrayOfInt4);
      SecP256K1Field.multiply(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      SecP256K1Field.squareN(arrayOfInt4, 2, arrayOfInt4);
      SecP256K1Field.square(arrayOfInt4, arrayOfInt2);
      if (Nat256.eq(arrayOfInt1, arrayOfInt2)) {
        return new SecP256K1FieldElement(arrayOfInt4);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat256.create();
    SecP256K1Field.square(this.x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    SecP256K1Field.subtract(this.x, ((SecP256K1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP256K1FieldElement(arrayOfInt);
  }
  
  public boolean testBitZero()
  {
    int[] arrayOfInt = this.x;
    boolean bool = false;
    if (Nat256.getBit(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger toBigInteger()
  {
    return Nat256.toBigInteger(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP256K1FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */