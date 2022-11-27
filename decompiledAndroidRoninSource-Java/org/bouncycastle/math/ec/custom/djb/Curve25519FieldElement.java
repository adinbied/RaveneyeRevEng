package org.bouncycastle.math.ec.custom.djb;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public class Curve25519FieldElement
  extends ECFieldElement
{
  private static final int[] PRECOMP_POW2 = { 1242472624, -991028441, -1389370248, 792926214, 1039914919, 726466713, 1338105611, 730014848 };
  public static final BigInteger Q = Curve25519.q;
  protected int[] x;
  
  public Curve25519FieldElement()
  {
    this.x = Nat256.create();
  }
  
  public Curve25519FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = Curve25519Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for Curve25519FieldElement");
  }
  
  protected Curve25519FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    Curve25519Field.add(this.x, ((Curve25519FieldElement)paramECFieldElement).x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat256.create();
    Curve25519Field.addOne(this.x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    Mod.invert(Curve25519Field.P, ((Curve25519FieldElement)paramECFieldElement).x, arrayOfInt);
    Curve25519Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Curve25519FieldElement)) {
      return false;
    }
    paramObject = (Curve25519FieldElement)paramObject;
    return Nat256.eq(this.x, ((Curve25519FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "Curve25519Field";
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
    Mod.invert(Curve25519Field.P, this.x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
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
    Curve25519Field.multiply(this.x, ((Curve25519FieldElement)paramECFieldElement).x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat256.create();
    Curve25519Field.negate(this.x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
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
      Curve25519Field.square(arrayOfInt1, arrayOfInt2);
      Curve25519Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      Curve25519Field.square(arrayOfInt2, arrayOfInt2);
      Curve25519Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = Nat256.create();
      Curve25519Field.square(arrayOfInt2, arrayOfInt3);
      Curve25519Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      int[] arrayOfInt4 = Nat256.create();
      Curve25519Field.squareN(arrayOfInt3, 3, arrayOfInt4);
      Curve25519Field.multiply(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      Curve25519Field.squareN(arrayOfInt4, 4, arrayOfInt2);
      Curve25519Field.multiply(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      Curve25519Field.squareN(arrayOfInt2, 4, arrayOfInt4);
      Curve25519Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      Curve25519Field.squareN(arrayOfInt4, 15, arrayOfInt3);
      Curve25519Field.multiply(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      Curve25519Field.squareN(arrayOfInt3, 30, arrayOfInt4);
      Curve25519Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      Curve25519Field.squareN(arrayOfInt4, 60, arrayOfInt3);
      Curve25519Field.multiply(arrayOfInt3, arrayOfInt4, arrayOfInt3);
      Curve25519Field.squareN(arrayOfInt3, 11, arrayOfInt4);
      Curve25519Field.multiply(arrayOfInt4, arrayOfInt2, arrayOfInt4);
      Curve25519Field.squareN(arrayOfInt4, 120, arrayOfInt2);
      Curve25519Field.multiply(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      Curve25519Field.square(arrayOfInt2, arrayOfInt2);
      Curve25519Field.square(arrayOfInt2, arrayOfInt3);
      if (Nat256.eq(arrayOfInt1, arrayOfInt3)) {
        return new Curve25519FieldElement(arrayOfInt2);
      }
      Curve25519Field.multiply(arrayOfInt2, PRECOMP_POW2, arrayOfInt2);
      Curve25519Field.square(arrayOfInt2, arrayOfInt3);
      if (Nat256.eq(arrayOfInt1, arrayOfInt3)) {
        return new Curve25519FieldElement(arrayOfInt2);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat256.create();
    Curve25519Field.square(this.x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat256.create();
    Curve25519Field.subtract(this.x, ((Curve25519FieldElement)paramECFieldElement).x, arrayOfInt);
    return new Curve25519FieldElement(arrayOfInt);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\djb\Curve25519FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */