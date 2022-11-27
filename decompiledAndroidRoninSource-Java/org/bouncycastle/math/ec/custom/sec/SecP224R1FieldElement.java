package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Mod;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat224;
import org.bouncycastle.util.Arrays;

public class SecP224R1FieldElement
  extends ECFieldElement
{
  public static final BigInteger Q = SecP224R1Curve.q;
  protected int[] x;
  
  public SecP224R1FieldElement()
  {
    this.x = Nat224.create();
  }
  
  public SecP224R1FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.compareTo(Q) < 0))
    {
      this.x = SecP224R1Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecP224R1FieldElement");
  }
  
  protected SecP224R1FieldElement(int[] paramArrayOfInt)
  {
    this.x = paramArrayOfInt;
  }
  
  private static void RM(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5, int[] paramArrayOfInt6, int[] paramArrayOfInt7)
  {
    SecP224R1Field.multiply(paramArrayOfInt5, paramArrayOfInt3, paramArrayOfInt7);
    SecP224R1Field.multiply(paramArrayOfInt7, paramArrayOfInt1, paramArrayOfInt7);
    SecP224R1Field.multiply(paramArrayOfInt4, paramArrayOfInt2, paramArrayOfInt6);
    SecP224R1Field.add(paramArrayOfInt6, paramArrayOfInt7, paramArrayOfInt6);
    SecP224R1Field.multiply(paramArrayOfInt4, paramArrayOfInt3, paramArrayOfInt7);
    Nat224.copy(paramArrayOfInt6, paramArrayOfInt4);
    SecP224R1Field.multiply(paramArrayOfInt5, paramArrayOfInt2, paramArrayOfInt5);
    SecP224R1Field.add(paramArrayOfInt5, paramArrayOfInt7, paramArrayOfInt5);
    SecP224R1Field.square(paramArrayOfInt5, paramArrayOfInt6);
    SecP224R1Field.multiply(paramArrayOfInt6, paramArrayOfInt1, paramArrayOfInt6);
  }
  
  private static void RP(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4, int[] paramArrayOfInt5)
  {
    Nat224.copy(paramArrayOfInt1, paramArrayOfInt4);
    int[] arrayOfInt1 = Nat224.create();
    int[] arrayOfInt2 = Nat224.create();
    int i = 0;
    while (i < 7)
    {
      Nat224.copy(paramArrayOfInt2, arrayOfInt1);
      Nat224.copy(paramArrayOfInt3, arrayOfInt2);
      int j = 1 << i;
      for (;;)
      {
        j -= 1;
        if (j < 0) {
          break;
        }
        RS(paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5);
      }
      RM(paramArrayOfInt1, arrayOfInt1, arrayOfInt2, paramArrayOfInt2, paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt5);
      i += 1;
    }
  }
  
  private static void RS(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int[] paramArrayOfInt4)
  {
    SecP224R1Field.multiply(paramArrayOfInt2, paramArrayOfInt1, paramArrayOfInt2);
    SecP224R1Field.twice(paramArrayOfInt2, paramArrayOfInt2);
    SecP224R1Field.square(paramArrayOfInt1, paramArrayOfInt4);
    SecP224R1Field.add(paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt1);
    SecP224R1Field.multiply(paramArrayOfInt3, paramArrayOfInt4, paramArrayOfInt3);
    SecP224R1Field.reduce32(Nat.shiftUpBits(7, paramArrayOfInt3, 2, 0), paramArrayOfInt3);
  }
  
  private static boolean isSquare(int[] paramArrayOfInt)
  {
    int[] arrayOfInt1 = Nat224.create();
    int[] arrayOfInt2 = Nat224.create();
    Nat224.copy(paramArrayOfInt, arrayOfInt1);
    int i = 0;
    while (i < 7)
    {
      Nat224.copy(arrayOfInt1, arrayOfInt2);
      SecP224R1Field.squareN(arrayOfInt1, 1 << i, arrayOfInt1);
      SecP224R1Field.multiply(arrayOfInt1, arrayOfInt2, arrayOfInt1);
      i += 1;
    }
    SecP224R1Field.squareN(arrayOfInt1, 95, arrayOfInt1);
    return Nat224.isOne(arrayOfInt1);
  }
  
  private static boolean trySqrt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt1 = Nat224.create();
    Nat224.copy(paramArrayOfInt2, arrayOfInt1);
    paramArrayOfInt2 = Nat224.create();
    paramArrayOfInt2[0] = 1;
    int[] arrayOfInt2 = Nat224.create();
    RP(paramArrayOfInt1, arrayOfInt1, paramArrayOfInt2, arrayOfInt2, paramArrayOfInt3);
    paramArrayOfInt1 = Nat224.create();
    int[] arrayOfInt3 = Nat224.create();
    int i = 1;
    while (i < 96)
    {
      Nat224.copy(arrayOfInt1, paramArrayOfInt1);
      Nat224.copy(paramArrayOfInt2, arrayOfInt3);
      RS(arrayOfInt1, paramArrayOfInt2, arrayOfInt2, paramArrayOfInt3);
      if (Nat224.isZero(arrayOfInt1))
      {
        Mod.invert(SecP224R1Field.P, arrayOfInt3, paramArrayOfInt3);
        SecP224R1Field.multiply(paramArrayOfInt3, paramArrayOfInt1, paramArrayOfInt3);
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    SecP224R1Field.add(this.x, ((SecP224R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement addOne()
  {
    int[] arrayOfInt = Nat224.create();
    SecP224R1Field.addOne(this.x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    Mod.invert(SecP224R1Field.P, ((SecP224R1FieldElement)paramECFieldElement).x, arrayOfInt);
    SecP224R1Field.multiply(arrayOfInt, this.x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecP224R1FieldElement)) {
      return false;
    }
    paramObject = (SecP224R1FieldElement)paramObject;
    return Nat224.eq(this.x, ((SecP224R1FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecP224R1Field";
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
    Mod.invert(SecP224R1Field.P, this.x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
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
    SecP224R1Field.multiply(this.x, ((SecP224R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement negate()
  {
    int[] arrayOfInt = Nat224.create();
    SecP224R1Field.negate(this.x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement sqrt()
  {
    int[] arrayOfInt1 = this.x;
    if (!Nat224.isZero(arrayOfInt1))
    {
      if (Nat224.isOne(arrayOfInt1)) {
        return this;
      }
      int[] arrayOfInt4 = Nat224.create();
      SecP224R1Field.negate(arrayOfInt1, arrayOfInt4);
      int[] arrayOfInt2 = Mod.random(SecP224R1Field.P);
      int[] arrayOfInt3 = Nat224.create();
      boolean bool = isSquare(arrayOfInt1);
      SecP224R1FieldElement localSecP224R1FieldElement = null;
      if (!bool) {
        return null;
      }
      while (!trySqrt(arrayOfInt4, arrayOfInt2, arrayOfInt3)) {
        SecP224R1Field.addOne(arrayOfInt2, arrayOfInt2);
      }
      SecP224R1Field.square(arrayOfInt3, arrayOfInt2);
      if (Nat224.eq(arrayOfInt1, arrayOfInt2)) {
        localSecP224R1FieldElement = new SecP224R1FieldElement(arrayOfInt3);
      }
      return localSecP224R1FieldElement;
    }
    return this;
  }
  
  public ECFieldElement square()
  {
    int[] arrayOfInt = Nat224.create();
    SecP224R1Field.square(this.x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    int[] arrayOfInt = Nat224.create();
    SecP224R1Field.subtract(this.x, ((SecP224R1FieldElement)paramECFieldElement).x, arrayOfInt);
    return new SecP224R1FieldElement(arrayOfInt);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP224R1FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */