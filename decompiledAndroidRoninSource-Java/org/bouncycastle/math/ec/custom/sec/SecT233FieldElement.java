package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat256;
import org.bouncycastle.util.Arrays;

public class SecT233FieldElement
  extends ECFieldElement
{
  protected long[] x;
  
  public SecT233FieldElement()
  {
    this.x = Nat256.create64();
  }
  
  public SecT233FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 233))
    {
      this.x = SecT233Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT233FieldElement");
  }
  
  protected SecT233FieldElement(long[] paramArrayOfLong)
  {
    this.x = paramArrayOfLong;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.add(this.x, ((SecT233FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
  }
  
  public ECFieldElement addOne()
  {
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.addOne(this.x, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
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
    if (!(paramObject instanceof SecT233FieldElement)) {
      return false;
    }
    paramObject = (SecT233FieldElement)paramObject;
    return Nat256.eq64(this.x, ((SecT233FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecT233Field";
  }
  
  public int getFieldSize()
  {
    return 233;
  }
  
  public int getK1()
  {
    return 74;
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
    return 233;
  }
  
  public int getRepresentation()
  {
    return 2;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.x, 0, 4) ^ 0x238DDA;
  }
  
  public ECFieldElement invert()
  {
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.invert(this.x, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
  }
  
  public boolean isOne()
  {
    return Nat256.isOne64(this.x);
  }
  
  public boolean isZero()
  {
    return Nat256.isZero64(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.multiply(this.x, ((SecT233FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
  }
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiplyPlusProduct(paramECFieldElement1, paramECFieldElement2, paramECFieldElement3);
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT233FieldElement)paramECFieldElement1).x;
    paramECFieldElement2 = ((SecT233FieldElement)paramECFieldElement2).x;
    long[] arrayOfLong2 = ((SecT233FieldElement)paramECFieldElement3).x;
    paramECFieldElement3 = Nat256.createExt64();
    SecT233Field.multiplyAddToExt(arrayOfLong1, paramECFieldElement1, paramECFieldElement3);
    SecT233Field.multiplyAddToExt(paramECFieldElement2, arrayOfLong2, paramECFieldElement3);
    paramECFieldElement1 = Nat256.create64();
    SecT233Field.reduce(paramECFieldElement3, paramECFieldElement1);
    return new SecT233FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement negate()
  {
    return this;
  }
  
  public ECFieldElement sqrt()
  {
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.sqrt(this.x, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
  }
  
  public ECFieldElement square()
  {
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.square(this.x, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
  }
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return squarePlusProduct(paramECFieldElement1, paramECFieldElement2);
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT233FieldElement)paramECFieldElement1).x;
    long[] arrayOfLong2 = ((SecT233FieldElement)paramECFieldElement2).x;
    paramECFieldElement2 = Nat256.createExt64();
    SecT233Field.squareAddToExt(arrayOfLong1, paramECFieldElement2);
    SecT233Field.multiplyAddToExt(paramECFieldElement1, arrayOfLong2, paramECFieldElement2);
    paramECFieldElement1 = Nat256.create64();
    SecT233Field.reduce(paramECFieldElement2, paramECFieldElement1);
    return new SecT233FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = Nat256.create64();
    SecT233Field.squareN(this.x, paramInt, arrayOfLong);
    return new SecT233FieldElement(arrayOfLong);
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
    return Nat256.toBigInteger64(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT233FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */