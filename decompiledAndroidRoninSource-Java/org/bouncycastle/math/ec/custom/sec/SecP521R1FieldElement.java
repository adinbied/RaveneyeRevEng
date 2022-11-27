package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.util.Arrays;

public class SecP521R1FieldElement
  extends ECFieldElement
{
  public static final BigInteger Q = SecP521R1Curve.q;
  protected int[] x;
  
  public SecP521R1FieldElement()
  {
    this.x = Nat.create(17);
  }
  
  public SecP521R1FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP521R1Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP521R1FieldElement");
  }
  
  protected SecP521R1FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(17);
    SecP521R1Field.add(this.x, ((SecP521R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat.create(17);
    SecP521R1Field.addOne(this.x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(17);
    Mod.invert(SecP521R1Field.P, ((SecP521R1FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP521R1Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP521R1FieldElement)) {
      return false;
    }
    paramObject = (SecP521R1FieldElement)paramObject;
    return Nat.eq(17, this.x, ((SecP521R1FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP521R1Field";
  }
  
  public int getFieldSize()
  {
    return Q.bitLength();
  }
  
  public int hashCode()
  {
    return Q.hashCode() ^ Arrays.hashCode(this.x, 0, 17);
  }
  
  public ECFieldElement invert()
  {
    int[] arrayOfInt = Nat.create(17);
    Mod.invert(SecP521R1Field.P, this.x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public boolean isOne()
  {
    return Nat.isOne(17, this.x);
  }
  
  public boolean isZero()
  {
    return Nat.isZero(17, this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(17);
    SecP521R1Field.multiply(this.x, ((SecP521R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat.create(17);
    SecP521R1Field.negate(this.x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat.isZero(17, arrayOfInt1))
    {
      if (Nat.isOne(17, arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt2 = Nat.create(17);
      int[] arrayOfInt3 = Nat.create(17);
      SecP521R1Field.squareN(arrayOfInt1, 519, arrayOfInt2);
      SecP521R1Field.square(arrayOfInt2, arrayOfInt3);
      if (Nat.eq(17, arrayOfInt1, arrayOfInt3)) {
        return new SecP521R1FieldElement(arrayOfInt2);
      }
      return null;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat.create(17);
    SecP521R1Field.square(this.x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat.create(17);
    SecP521R1Field.subtract(this.x, ((SecP521R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP521R1FieldElement(arrayOfInt);
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
    return Nat.toBigInteger(17, this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP521R1FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */