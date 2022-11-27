package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;
import org.bouncycastle.util.Arrays;

public class SecT131FieldElement
  extends ECFieldElement
{
  protected long[] x;
  
  public SecT131FieldElement()
  {
    this.x = Nat192.create64();
  }
  
  public SecT131FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 131))
    {
      this.x = SecT131Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT131FieldElement");
  }
  
  protected SecT131FieldElement(long[] paramArrayOfLong)
  {
    this.x = paramArrayOfLong;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.add(this.x, ((SecT131FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
  }
  
  public ECFieldElement addOne()
  {
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.addOne(this.x, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
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
    if (!(paramObject instanceof SecT131FieldElement)) {
      return false;
    }
    paramObject = (SecT131FieldElement)paramObject;
    return Nat192.eq64(this.x, ((SecT131FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecT131Field";
  }
  
  public int getFieldSize()
  {
    return 131;
  }
  
  public int getK1()
  {
    return 2;
  }
  
  public int getK2()
  {
    return 3;
  }
  
  public int getK3()
  {
    return 8;
  }
  
  public int getM()
  {
    return 131;
  }
  
  public int getRepresentation()
  {
    return 3;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.x, 0, 3) ^ 0x202F8;
  }
  
  public ECFieldElement invert()
  {
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.invert(this.x, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
  }
  
  public boolean isOne()
  {
    return Nat192.isOne64(this.x);
  }
  
  public boolean isZero()
  {
    return Nat192.isZero64(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.multiply(this.x, ((SecT131FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
  }
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiplyPlusProduct(paramECFieldElement1, paramECFieldElement2, paramECFieldElement3);
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT131FieldElement)paramECFieldElement1).x;
    paramECFieldElement2 = ((SecT131FieldElement)paramECFieldElement2).x;
    long[] arrayOfLong2 = ((SecT131FieldElement)paramECFieldElement3).x;
    paramECFieldElement3 = Nat.create64(5);
    SecT131Field.multiplyAddToExt(arrayOfLong1, paramECFieldElement1, paramECFieldElement3);
    SecT131Field.multiplyAddToExt(paramECFieldElement2, arrayOfLong2, paramECFieldElement3);
    paramECFieldElement1 = Nat192.create64();
    SecT131Field.reduce(paramECFieldElement3, paramECFieldElement1);
    return new SecT131FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement negate()
  {
    return this;
  }
  
  public ECFieldElement sqrt()
  {
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.sqrt(this.x, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
  }
  
  public ECFieldElement square()
  {
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.square(this.x, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
  }
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return squarePlusProduct(paramECFieldElement1, paramECFieldElement2);
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT131FieldElement)paramECFieldElement1).x;
    long[] arrayOfLong2 = ((SecT131FieldElement)paramECFieldElement2).x;
    paramECFieldElement2 = Nat.create64(5);
    SecT131Field.squareAddToExt(arrayOfLong1, paramECFieldElement2);
    SecT131Field.multiplyAddToExt(paramECFieldElement1, arrayOfLong2, paramECFieldElement2);
    paramECFieldElement1 = Nat192.create64();
    SecT131Field.reduce(paramECFieldElement2, paramECFieldElement1);
    return new SecT131FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = Nat192.create64();
    SecT131Field.squareN(this.x, paramInt, arrayOfLong);
    return new SecT131FieldElement(arrayOfLong);
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
    return Nat192.toBigInteger64(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT131FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */