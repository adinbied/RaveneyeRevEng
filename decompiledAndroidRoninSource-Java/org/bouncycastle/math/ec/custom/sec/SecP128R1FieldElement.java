package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.Arrays;

public class SecP128R1FieldElement
  extends ECFieldElement
{
  public static final BigInteger Q = SecP128R1Curve.q;
  protected int[] x;
  
  public SecP128R1FieldElement()
  {
    this.x = Nat128.create();
  }
  
  public SecP128R1FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP128R1Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP128R1FieldElement");
  }
  
  protected SecP128R1FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat128.create();
    SecP128R1Field.add(this.x, ((SecP128R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat128.create();
    SecP128R1Field.addOne(this.x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat128.create();
    Mod.invert(SecP128R1Field.P, ((SecP128R1FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP128R1Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP128R1FieldElement)) {
      return false;
    }
    paramObject = (SecP128R1FieldElement)paramObject;
    return Nat128.eq(this.x, ((SecP128R1FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP128R1Field";
  }
  
  public int getFieldSize()
  {
    return Q.bitLength();
  }
  
  public int hashCode()
  {
    return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 4);
  }
  
  public ECFieldElement invert()
  {
    int[] arrayOfInt = Nat128.create();
    Mod.invert(SecP128R1Field.P, this.x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public boolean isOne()
  {
    return Nat128.isOne(this.x);
  }
  
  public boolean isZero()
  {
    return Nat128.isZero(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat128.create();
    SecP128R1Field.multiply(this.x, ((SecP128R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat128.create();
    SecP128R1Field.negate(this.x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat128.isZero(arrayOfInt1))
    {
      if (Nat128.isOne(arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt2 = Nat128.create();
      SecP128R1Field.square(arrayOfInt1, arrayOfInt2);
      SecP128R1Field.multiply(arrayOfInt2, arrayOfInt1, arrayOfInt2);
      int[] arrayOfInt3 = Nat128.create();
      SecP128R1Field.squareN(arrayOfInt2, 2, arrayOfInt3);
      SecP128R1Field.multiply(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      int[] arrayOfInt4 = Nat128.create();
      SecP128R1Field.squareN(arrayOfInt3, 4, arrayOfInt4);
      SecP128R1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP128R1Field.squareN(arrayOfInt4, 2, arrayOfInt3);
      SecP128R1Field.multiply(arrayOfInt3, arrayOfInt2, arrayOfInt3);
      SecP128R1Field.squareN(arrayOfInt3, 10, arrayOfInt2);
      SecP128R1Field.multiply(arrayOfInt2, arrayOfInt3, arrayOfInt2);
      SecP128R1Field.squareN(arrayOfInt2, 10, arrayOfInt4);
      SecP128R1Field.multiply(arrayOfInt4, arrayOfInt3, arrayOfInt4);
      SecP128R1Field.square(arrayOfInt4, arrayOfInt3);
      SecP128R1Field.multiply(arrayOfInt3, arrayOfInt1, arrayOfInt3);
      SecP128R1Field.squareN(arrayOfInt3, 95, arrayOfInt3);
      SecP128R1Field.square(arrayOfInt3, arrayOfInt4);
      if (Nat128.eq(arrayOfInt1, arrayOfInt4)) {
        return new SecP128R1FieldElement(arrayOfInt3);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat128.create();
    SecP128R1Field.square(this.x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat128.create();
    SecP128R1Field.subtract(this.x, ((SecP128R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP128R1FieldElement(arrayOfInt);
  }
  
  public boolean testBitZero()
  {
    int[] arrayOfInt = this.x;
    boolean bool = false;
    if (Nat128.getBit(arrayOfInt, 0) == 1) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger toBigInteger()
  {
    return Nat128.toBigInteger(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP128R1FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */