package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.ec.ECFieldElement;
import org.bouncycastle.math.raw.Nat576;
import org.bouncycastle.util.Arrays;

public class SecT571FieldElement
  extends ECFieldElement
{
  protected long[] x;
  
  public SecT571FieldElement()
  {
    this.x = Nat576.create64();
  }
  
  public SecT571FieldElement(BigInteger paramBigInteger)
  {
    if ((paramBigInteger != null) && (paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 571))
    {
      this.x = SecT571Field.fromBigInteger(paramBigInteger);
      return;
    }
    throw new IllegalArgumentException("x value invalid for SecT571FieldElement");
  }
  
  protected SecT571FieldElement(long[] paramArrayOfLong)
  {
    this.x = paramArrayOfLong;
  }
  
  public ECFieldElement add(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.add(this.x, ((SecT571FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
  }
  
  public ECFieldElement addOne()
  {
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.addOne(this.x, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
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
    if (!(paramObject instanceof SecT571FieldElement)) {
      return false;
    }
    paramObject = (SecT571FieldElement)paramObject;
    return Nat576.eq64(this.x, ((SecT571FieldElement)paramObject).x);
  }
  
  public String getFieldName()
  {
    return "SecT571Field";
  }
  
  public int getFieldSize()
  {
    return 571;
  }
  
  public int getK1()
  {
    return 2;
  }
  
  public int getK2()
  {
    return 5;
  }
  
  public int getK3()
  {
    return 10;
  }
  
  public int getM()
  {
    return 571;
  }
  
  public int getRepresentation()
  {
    return 3;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.x, 0, 9) ^ 0x5724CC;
  }
  
  public ECFieldElement invert()
  {
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.invert(this.x, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
  }
  
  public boolean isOne()
  {
    return Nat576.isOne64(this.x);
  }
  
  public boolean isZero()
  {
    return Nat576.isZero64(this.x);
  }
  
  public ECFieldElement multiply(ECFieldElement paramECFieldElement)
  {
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.multiply(this.x, ((SecT571FieldElement)paramECFieldElement).x, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
  }
  
  public ECFieldElement multiplyMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    return multiplyPlusProduct(paramECFieldElement1, paramECFieldElement2, paramECFieldElement3);
  }
  
  public ECFieldElement multiplyPlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2, ECFieldElement paramECFieldElement3)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT571FieldElement)paramECFieldElement1).x;
    paramECFieldElement2 = ((SecT571FieldElement)paramECFieldElement2).x;
    long[] arrayOfLong2 = ((SecT571FieldElement)paramECFieldElement3).x;
    paramECFieldElement3 = Nat576.createExt64();
    SecT571Field.multiplyAddToExt(arrayOfLong1, paramECFieldElement1, paramECFieldElement3);
    SecT571Field.multiplyAddToExt(paramECFieldElement2, arrayOfLong2, paramECFieldElement3);
    paramECFieldElement1 = Nat576.create64();
    SecT571Field.reduce(paramECFieldElement3, paramECFieldElement1);
    return new SecT571FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement negate()
  {
    return this;
  }
  
  public ECFieldElement sqrt()
  {
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.sqrt(this.x, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
  }
  
  public ECFieldElement square()
  {
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.square(this.x, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
  }
  
  public ECFieldElement squareMinusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    return squarePlusProduct(paramECFieldElement1, paramECFieldElement2);
  }
  
  public ECFieldElement squarePlusProduct(ECFieldElement paramECFieldElement1, ECFieldElement paramECFieldElement2)
  {
    long[] arrayOfLong1 = this.x;
    paramECFieldElement1 = ((SecT571FieldElement)paramECFieldElement1).x;
    long[] arrayOfLong2 = ((SecT571FieldElement)paramECFieldElement2).x;
    paramECFieldElement2 = Nat576.createExt64();
    SecT571Field.squareAddToExt(arrayOfLong1, paramECFieldElement2);
    SecT571Field.multiplyAddToExt(paramECFieldElement1, arrayOfLong2, paramECFieldElement2);
    paramECFieldElement1 = Nat576.create64();
    SecT571Field.reduce(paramECFieldElement2, paramECFieldElement1);
    return new SecT571FieldElement(paramECFieldElement1);
  }
  
  public ECFieldElement squarePow(int paramInt)
  {
    if (paramInt < 1) {
      return this;
    }
    long[] arrayOfLong = Nat576.create64();
    SecT571Field.squareN(this.x, paramInt, arrayOfLong);
    return new SecT571FieldElement(arrayOfLong);
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
    return Nat576.toBigInteger64(this.x);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT571FieldElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */