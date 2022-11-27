package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat320;
import org.bouncycastle.util.Arrays;

public class SecT283FieldElement
  extends ECFieldElement
{
  protected long[] x;
  
  public SecT283FieldElement()
  {
    this.x = Nat320.create64();
  }
  
  public SecT283FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 283))
    {
      this.x = SecT283Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT283FieldElement");
  }
  
  protected SecT283FieldElement(long[] paramArrayOfLong)
  {
    this.x = paramArrayOfLong;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.add(this.x, ((SecT283FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public ECFieldElement addOne()
  {
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.addOne(this.x, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public ECFieldElement divide(ECFieldElement paramECFieldElement)
  {
    return multiply(paramECFieldElement.invert());
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof SecT283FieldElement)) {
      return false;
    }
    paramObject = (SecT283FieldElement)paramObject;
    return Nat320.eq64(this.x, ((SecT283FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecT283Field";
  }
  
  public int getFieldSize()
  {
    return 283;
  }
  
  public int getK1()
  {
    return 5;
  }
  
  public int getK2()
  {
    return 7;
  }
  
  public int getK3()
  {
    return 12;
  }
  
  public int getM()
  {
    return 283;
  }
  
  public int getRepresentation()
  {
    return 3;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.x, 0, 5) ^ 0x2B33AB;
  }
  
  public ECFieldElement invert()
  {
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.invert(this.x, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public boolean isOne()
  {
    return Nat320.isOne64(this.x);
  }
  
  public boolean isZero()
  {
    return Nat320.isZero64(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.multiply(this.x, ((SecT283FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiplyPlusProduct(paramECFieldElement1, paramECFieldElement2, paramECFieldElement3);
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT283FieldElement)paramECFieldElement1).x;
    paramECFieldElement2 = ((SecT283FieldElement)paramECFieldElement2).x;
    long[] arrayOfLong2 = ((SecT283FieldElement)paramECFieldElement3).x;
    paramECFieldElement3 = Nat.create64(9);
    SecT283Field.multiplyAddToExt(arrayOfLong1, paramECFieldElement1, paramECFieldElement3);
    SecT283Field.multiplyAddToExt(paramECFieldElement2, arrayOfLong2, paramECFieldElement3);
    paramECFieldElement1 = Nat320.create64();
    SecT283Field.reduce(paramECFieldElement3, paramECFieldElement1);
    return new SecT283FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement negate()
  {
    return this;
  }
  
  public ECFieldElement sqrt()
  {
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.sqrt(this.x, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public ECFieldElement square()
  {
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.square(this.x, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return squarePlusProduct(paramECFieldElement1, paramECFieldElement2);
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT283FieldElement)paramECFieldElement1).x;
    long[] arrayOfLong2 = ((SecT283FieldElement)paramECFieldElement2).x;
    paramECFieldElement2 = Nat.create64(9);
    SecT283Field.squareAddToExt(arrayOfLong1, paramECFieldElement2);
    SecT283Field.multiplyAddToExt(paramECFieldElement1, arrayOfLong2, paramECFieldElement2);
    paramECFieldElement1 = Nat320.create64();
    SecT283Field.reduce(paramECFieldElement2, paramECFieldElement1);
    return new SecT283FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = Nat320.create64();
    SecT283Field.squareN(this.x, paramInt, arrayOfLong);
    return new SecT283FieldElement(arrayOfLong);
  }
  
  public ECFieldElement subtract(ECFieldElement paramECFieldElement)
  {
    return add(paramECFieldElement);
  }
  
  public boolean testBitZero()
  {
    long[] arrayOfLong = this.x;
    boolean bool = false;
    if ((arrayOfLong[0] & 1L) != 0L) {
      bool = true;
    }
    return bool;
  }
  
  public BigInteger toBigInteger()
  {
    return Nat320.toBigInteger64(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT283FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */