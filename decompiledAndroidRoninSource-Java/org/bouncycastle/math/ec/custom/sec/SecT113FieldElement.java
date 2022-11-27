package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat128;
import org.bouncycastle.util.Arrays;

public class SecT113FieldElement
  extends ECFieldElement
{
  protected long[] x;
  
  public SecT113FieldElement()
  {
    this.x = Nat128.create64();
  }
  
  public SecT113FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 113))
    {
      this.x = SecT113Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT113FieldElement");
  }
  
  protected SecT113FieldElement(long[] paramArrayOfLong)
  {
    this.x = paramArrayOfLong;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.add(this.x, ((SecT113FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
  }
  
  public ECFieldElement addOne()
  {
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.addOne(this.x, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
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
    if (!(paramObject instanceof SecT113FieldElement)) {
      return false;
    }
    paramObject = (SecT113FieldElement)paramObject;
    return Nat128.eq64(this.x, ((SecT113FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecT113Field";
  }
  
  public int getFieldSize()
  {
    return 113;
  }
  
  public int getK1()
  {
    return 9;
  }
  
  public int getK2()
  {
    return 0;
  }
  
  public int getK3()
  {
    return 0;
  }
  
  public int getM()
  {
    return 113;
  }
  
  public int getRepresentation()
  {
    return 2;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.x, 0, 2) ^ 0x1B971;
  }
  
  public ECFieldElement invert()
  {
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.invert(this.x, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
  }
  
  public boolean isOne()
  {
    return Nat128.isOne64(this.x);
  }
  
  public boolean isZero()
  {
    return Nat128.isZero64(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.multiply(this.x, ((SecT113FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
  }
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiplyPlusProduct(paramECFieldElement1, paramECFieldElement2, paramECFieldElement3);
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT113FieldElement)paramECFieldElement1).x;
    paramECFieldElement2 = ((SecT113FieldElement)paramECFieldElement2).x;
    long[] arrayOfLong2 = ((SecT113FieldElement)paramECFieldElement3).x;
    paramECFieldElement3 = Nat128.createExt64();
    SecT113Field.multiplyAddToExt(arrayOfLong1, paramECFieldElement1, paramECFieldElement3);
    SecT113Field.multiplyAddToExt(paramECFieldElement2, arrayOfLong2, paramECFieldElement3);
    paramECFieldElement1 = Nat128.create64();
    SecT113Field.reduce(paramECFieldElement3, paramECFieldElement1);
    return new SecT113FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement negate()
  {
    return this;
  }
  
  public ECFieldElement sqrt()
  {
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.sqrt(this.x, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
  }
  
  public ECFieldElement square()
  {
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.square(this.x, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
  }
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return squarePlusProduct(paramECFieldElement1, paramECFieldElement2);
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT113FieldElement)paramECFieldElement1).x;
    long[] arrayOfLong2 = ((SecT113FieldElement)paramECFieldElement2).x;
    paramECFieldElement2 = Nat128.createExt64();
    SecT113Field.squareAddToExt(arrayOfLong1, paramECFieldElement2);
    SecT113Field.multiplyAddToExt(paramECFieldElement1, arrayOfLong2, paramECFieldElement2);
    paramECFieldElement1 = Nat128.create64();
    SecT113Field.reduce(paramECFieldElement2, paramECFieldElement1);
    return new SecT113FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = Nat128.create64();
    SecT113Field.squareN(this.x, paramInt, arrayOfLong);
    return new SecT113FieldElement(arrayOfLong);
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
    return Nat128.toBigInteger64(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT113FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */