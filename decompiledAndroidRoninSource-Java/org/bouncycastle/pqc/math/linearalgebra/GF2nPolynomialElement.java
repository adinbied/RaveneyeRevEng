package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;
import java.util.Random;

public class GF2nPolynomialElement
  extends GF2nElement
{
  private static final int[] bitMask = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456, 536870912, 1073741824, Integer.MIN_VALUE, 0 };
  private GF2Polynomial polynomial;
  
  public GF2nPolynomialElement(GF2nPolynomialElement paramGF2nPolynomialElement)
  {
    this.mField = paramGF2nPolynomialElement.mField;
    this.mDegree = paramGF2nPolynomialElement.mDegree;
    this.polynomial = new GF2Polynomial(paramGF2nPolynomialElement.polynomial);
  }
  
  public GF2nPolynomialElement(GF2nPolynomialField paramGF2nPolynomialField, Random paramRandom)
  {
    this.mField = paramGF2nPolynomialField;
    this.mDegree = this.mField.getDegree();
    this.polynomial = new GF2Polynomial(this.mDegree);
    randomize(paramRandom);
  }
  
  public GF2nPolynomialElement(GF2nPolynomialField paramGF2nPolynomialField, GF2Polynomial paramGF2Polynomial)
  {
    this.mField = paramGF2nPolynomialField;
    this.mDegree = this.mField.getDegree();
    paramGF2nPolynomialField = new GF2Polynomial(paramGF2Polynomial);
    this.polynomial = paramGF2nPolynomialField;
    paramGF2nPolynomialField.expandN(this.mDegree);
  }
  
  public GF2nPolynomialElement(GF2nPolynomialField paramGF2nPolynomialField, byte[] paramArrayOfByte)
  {
    this.mField = paramGF2nPolynomialField;
    this.mDegree = this.mField.getDegree();
    paramGF2nPolynomialField = new GF2Polynomial(this.mDegree, paramArrayOfByte);
    this.polynomial = paramGF2nPolynomialField;
    paramGF2nPolynomialField.expandN(this.mDegree);
  }
  
  public GF2nPolynomialElement(GF2nPolynomialField paramGF2nPolynomialField, int[] paramArrayOfInt)
  {
    this.mField = paramGF2nPolynomialField;
    this.mDegree = this.mField.getDegree();
    paramArrayOfInt = new GF2Polynomial(this.mDegree, paramArrayOfInt);
    this.polynomial = paramArrayOfInt;
    paramArrayOfInt.expandN(paramGF2nPolynomialField.mDegree);
  }
  
  public static GF2nPolynomialElement ONE(GF2nPolynomialField paramGF2nPolynomialField)
  {
    return new GF2nPolynomialElement(paramGF2nPolynomialField, new GF2Polynomial(paramGF2nPolynomialField.getDegree(), new int[] { 1 }));
  }
  
  public static GF2nPolynomialElement ZERO(GF2nPolynomialField paramGF2nPolynomialField)
  {
    return new GF2nPolynomialElement(paramGF2nPolynomialField, new GF2Polynomial(paramGF2nPolynomialField.getDegree()));
  }
  
  private GF2Polynomial getGF2Polynomial()
  {
    return new GF2Polynomial(this.polynomial);
  }
  
  private GF2nPolynomialElement halfTrace()
    throws RuntimeException
  {
    if ((this.mDegree & 0x1) != 0)
    {
      GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
      int i = 1;
      while (i <= this.mDegree - 1 >> 1)
      {
        localGF2nPolynomialElement.squareThis();
        localGF2nPolynomialElement.squareThis();
        localGF2nPolynomialElement.addToThis(this);
        i += 1;
      }
      return localGF2nPolynomialElement;
    }
    throw new RuntimeException();
  }
  
  private void randomize(Random paramRandom)
  {
    this.polynomial.expandN(this.mDegree);
    this.polynomial.randomize(paramRandom);
  }
  
  private void reducePentanomialBitwise(int[] paramArrayOfInt)
  {
    int j = this.mDegree;
    int k = paramArrayOfInt[2];
    int m = this.mDegree;
    int n = paramArrayOfInt[1];
    int i1 = this.mDegree;
    int i2 = paramArrayOfInt[0];
    int i = this.polynomial.getLength() - 1;
    while (i >= this.mDegree)
    {
      if (this.polynomial.testBit(i))
      {
        this.polynomial.xorBit(i);
        this.polynomial.xorBit(i - (j - k));
        this.polynomial.xorBit(i - (m - n));
        this.polynomial.xorBit(i - (i1 - i2));
        this.polynomial.xorBit(i - this.mDegree);
      }
      i -= 1;
    }
    this.polynomial.reduceN();
    this.polynomial.expandN(this.mDegree);
  }
  
  private void reduceThis()
  {
    if ((this.polynomial.getLength() <= this.mDegree) || (((GF2nPolynomialField)this.mField).isTrinomial())) {}
    try
    {
      int i = ((GF2nPolynomialField)this.mField).getTc();
      if ((this.mDegree - i > 32) && (this.polynomial.getLength() <= this.mDegree << 1))
      {
        this.polynomial.reduceTrinomial(this.mDegree, i);
        return;
      }
      reduceTrinomialBitwise(i);
      return;
    }
    catch (RuntimeException localRuntimeException1)
    {
      for (;;) {}
    }
    throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a trinomial");
    if (((GF2nPolynomialField)this.mField).isPentanomial()) {}
    try
    {
      localObject = ((GF2nPolynomialField)this.mField).getPc();
      if ((this.mDegree - localObject[2] > 32) && (this.polynomial.getLength() <= this.mDegree << 1))
      {
        this.polynomial.reducePentanomial(this.mDegree, (int[])localObject);
        return;
      }
      reducePentanomialBitwise((int[])localObject);
      return;
    }
    catch (RuntimeException localRuntimeException2)
    {
      Object localObject;
      for (;;) {}
    }
    throw new RuntimeException("GF2nPolynomialElement.reduce: the field polynomial is not a pentanomial");
    localObject = this.polynomial.remainder(this.mField.getFieldPolynomial());
    this.polynomial = ((GF2Polynomial)localObject);
    ((GF2Polynomial)localObject).expandN(this.mDegree);
    return;
    if (this.polynomial.getLength() < this.mDegree) {
      this.polynomial.expandN(this.mDegree);
    }
  }
  
  private void reduceTrinomialBitwise(int paramInt)
  {
    int j = this.mDegree;
    int i = this.polynomial.getLength() - 1;
    while (i >= this.mDegree)
    {
      if (this.polynomial.testBit(i))
      {
        this.polynomial.xorBit(i);
        this.polynomial.xorBit(i - (j - paramInt));
        this.polynomial.xorBit(i - this.mDegree);
      }
      i -= 1;
    }
    this.polynomial.reduceN();
    this.polynomial.expandN(this.mDegree);
  }
  
  public GFElement add(GFElement paramGFElement)
    throws RuntimeException
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.addToThis(paramGFElement);
    return localGF2nPolynomialElement;
  }
  
  public void addToThis(GFElement paramGFElement)
    throws RuntimeException
  {
    if ((paramGFElement instanceof GF2nPolynomialElement))
    {
      GF2nField localGF2nField = this.mField;
      paramGFElement = (GF2nPolynomialElement)paramGFElement;
      if (localGF2nField.equals(paramGFElement.mField))
      {
        this.polynomial.addToThis(paramGFElement.polynomial);
        return;
      }
      throw new RuntimeException();
    }
    throw new RuntimeException();
  }
  
  void assignOne()
  {
    this.polynomial.assignOne();
  }
  
  void assignZero()
  {
    this.polynomial.assignZero();
  }
  
  public Object clone()
  {
    return new GF2nPolynomialElement(this);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2nPolynomialElement)) {
        return false;
      }
      paramObject = (GF2nPolynomialElement)paramObject;
      if ((this.mField != ((GF2nPolynomialElement)paramObject).mField) && (!this.mField.getFieldPolynomial().equals(((GF2nPolynomialElement)paramObject).mField.getFieldPolynomial()))) {
        return false;
      }
      return this.polynomial.equals(((GF2nPolynomialElement)paramObject).polynomial);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.mField.hashCode() + this.polynomial.hashCode();
  }
  
  public GF2nElement increase()
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.increaseThis();
    return localGF2nPolynomialElement;
  }
  
  public void increaseThis()
  {
    this.polynomial.increaseThis();
  }
  
  public GFElement invert()
    throws ArithmeticException
  {
    return invertMAIA();
  }
  
  public GF2nPolynomialElement invertEEA()
    throws ArithmeticException
  {
    if (!isZero())
    {
      Object localObject4 = new GF2Polynomial(this.mDegree + 32, "ONE");
      ((GF2Polynomial)localObject4).reduceN();
      Object localObject3 = new GF2Polynomial(this.mDegree + 32);
      ((GF2Polynomial)localObject3).reduceN();
      Object localObject2 = getGF2Polynomial();
      Object localObject1 = this.mField.getFieldPolynomial();
      ((GF2Polynomial)localObject2).reduceN();
      while (!((GF2Polynomial)localObject2).isOne())
      {
        ((GF2Polynomial)localObject2).reduceN();
        ((GF2Polynomial)localObject1).reduceN();
        int j = ((GF2Polynomial)localObject2).getLength() - ((GF2Polynomial)localObject1).getLength();
        Object localObject8 = localObject4;
        Object localObject7 = localObject3;
        Object localObject6 = localObject2;
        Object localObject5 = localObject1;
        int i = j;
        if (j < 0)
        {
          i = -j;
          ((GF2Polynomial)localObject4).reduceN();
          localObject5 = localObject2;
          localObject6 = localObject1;
          localObject7 = localObject4;
          localObject8 = localObject3;
        }
        ((GF2Polynomial)localObject6).shiftLeftAddThis((GF2Polynomial)localObject5, i);
        ((GF2Polynomial)localObject8).shiftLeftAddThis((GF2Polynomial)localObject7, i);
        localObject4 = localObject8;
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
      }
      ((GF2Polynomial)localObject4).reduceN();
      return new GF2nPolynomialElement((GF2nPolynomialField)this.mField, (GF2Polynomial)localObject4);
    }
    throw new ArithmeticException();
  }
  
  public GF2nPolynomialElement invertMAIA()
    throws ArithmeticException
  {
    if (!isZero())
    {
      Object localObject4 = new GF2Polynomial(this.mDegree, "ONE");
      Object localObject3 = new GF2Polynomial(this.mDegree);
      Object localObject2 = getGF2Polynomial();
      Object localObject1 = this.mField.getFieldPolynomial();
      for (;;)
      {
        if (!((GF2Polynomial)localObject2).testBit(0))
        {
          ((GF2Polynomial)localObject2).shiftRightThis();
          if (((GF2Polynomial)localObject4).testBit(0)) {
            ((GF2Polynomial)localObject4).addToThis(this.mField.getFieldPolynomial());
          }
          ((GF2Polynomial)localObject4).shiftRightThis();
        }
        else
        {
          if (((GF2Polynomial)localObject2).isOne()) {
            return new GF2nPolynomialElement((GF2nPolynomialField)this.mField, (GF2Polynomial)localObject4);
          }
          ((GF2Polynomial)localObject2).reduceN();
          ((GF2Polynomial)localObject1).reduceN();
          Object localObject8 = localObject4;
          Object localObject7 = localObject3;
          Object localObject6 = localObject2;
          Object localObject5 = localObject1;
          if (((GF2Polynomial)localObject2).getLength() < ((GF2Polynomial)localObject1).getLength())
          {
            localObject5 = localObject2;
            localObject6 = localObject1;
            localObject7 = localObject4;
            localObject8 = localObject3;
          }
          ((GF2Polynomial)localObject6).addToThis((GF2Polynomial)localObject5);
          ((GF2Polynomial)localObject8).addToThis((GF2Polynomial)localObject7);
          localObject4 = localObject8;
          localObject3 = localObject7;
          localObject2 = localObject6;
          localObject1 = localObject5;
        }
      }
    }
    throw new ArithmeticException();
  }
  
  public GF2nPolynomialElement invertSquare()
    throws ArithmeticException
  {
    if (!isZero())
    {
      int m = this.mField.getDegree() - 1;
      GF2nPolynomialElement localGF2nPolynomialElement1 = new GF2nPolynomialElement(this);
      localGF2nPolynomialElement1.polynomial.expandN((this.mDegree << 1) + 32);
      localGF2nPolynomialElement1.polynomial.reduceN();
      int j = IntegerFunctions.floorLog(m) - 1;
      int i = 1;
      while (j >= 0)
      {
        GF2nPolynomialElement localGF2nPolynomialElement2 = new GF2nPolynomialElement(localGF2nPolynomialElement1);
        int k = 1;
        while (k <= i)
        {
          localGF2nPolynomialElement2.squareThisPreCalc();
          k += 1;
        }
        localGF2nPolynomialElement1.multiplyThisBy(localGF2nPolynomialElement2);
        k = i << 1;
        i = k;
        if ((bitMask[j] & m) != 0)
        {
          localGF2nPolynomialElement1.squareThisPreCalc();
          localGF2nPolynomialElement1.multiplyThisBy(this);
          i = k + 1;
        }
        j -= 1;
      }
      localGF2nPolynomialElement1.squareThisPreCalc();
      return localGF2nPolynomialElement1;
    }
    throw new ArithmeticException();
  }
  
  public boolean isOne()
  {
    return this.polynomial.isOne();
  }
  
  public boolean isZero()
  {
    return this.polynomial.isZero();
  }
  
  public GFElement multiply(GFElement paramGFElement)
    throws RuntimeException
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.multiplyThisBy(paramGFElement);
    return localGF2nPolynomialElement;
  }
  
  public void multiplyThisBy(GFElement paramGFElement)
    throws RuntimeException
  {
    if ((paramGFElement instanceof GF2nPolynomialElement))
    {
      GF2nField localGF2nField = this.mField;
      GF2nPolynomialElement localGF2nPolynomialElement = (GF2nPolynomialElement)paramGFElement;
      if (localGF2nField.equals(localGF2nPolynomialElement.mField))
      {
        if (equals(paramGFElement))
        {
          squareThis();
          return;
        }
        this.polynomial = this.polynomial.multiply(localGF2nPolynomialElement.polynomial);
        reduceThis();
        return;
      }
      throw new RuntimeException();
    }
    throw new RuntimeException();
  }
  
  public GF2nPolynomialElement power(int paramInt)
  {
    if (paramInt == 1) {
      return new GF2nPolynomialElement(this);
    }
    GF2nPolynomialElement localGF2nPolynomialElement1 = ONE((GF2nPolynomialField)this.mField);
    if (paramInt == 0) {
      return localGF2nPolynomialElement1;
    }
    GF2nPolynomialElement localGF2nPolynomialElement2 = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement2.polynomial.expandN((localGF2nPolynomialElement2.mDegree << 1) + 32);
    localGF2nPolynomialElement2.polynomial.reduceN();
    int i = 0;
    while (i < this.mDegree)
    {
      if ((1 << i & paramInt) != 0) {
        localGF2nPolynomialElement1.multiplyThisBy(localGF2nPolynomialElement2);
      }
      localGF2nPolynomialElement2.square();
      i += 1;
    }
    return localGF2nPolynomialElement1;
  }
  
  public GF2nElement solveQuadraticEquation()
    throws RuntimeException
  {
    if (isZero()) {
      return ZERO((GF2nPolynomialField)this.mField);
    }
    if ((this.mDegree & 0x1) == 1) {
      return halfTrace();
    }
    GF2nPolynomialElement localGF2nPolynomialElement2;
    GF2nPolynomialElement localGF2nPolynomialElement3;
    do
    {
      GF2nPolynomialElement localGF2nPolynomialElement1 = new GF2nPolynomialElement((GF2nPolynomialField)this.mField, new Random());
      localGF2nPolynomialElement2 = ZERO((GF2nPolynomialField)this.mField);
      localGF2nPolynomialElement3 = (GF2nPolynomialElement)localGF2nPolynomialElement1.clone();
      int i = 1;
      while (i < this.mDegree)
      {
        localGF2nPolynomialElement2.squareThis();
        localGF2nPolynomialElement3.squareThis();
        localGF2nPolynomialElement2.addToThis(localGF2nPolynomialElement3.multiply(this));
        localGF2nPolynomialElement3.addToThis(localGF2nPolynomialElement1);
        i += 1;
      }
    } while (localGF2nPolynomialElement3.isZero());
    if (equals(localGF2nPolynomialElement2.square().add(localGF2nPolynomialElement2))) {
      return localGF2nPolynomialElement2;
    }
    throw new RuntimeException();
  }
  
  public GF2nElement square()
  {
    return squarePreCalc();
  }
  
  public GF2nPolynomialElement squareBitwise()
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.squareThisBitwise();
    localGF2nPolynomialElement.reduceThis();
    return localGF2nPolynomialElement;
  }
  
  public GF2nPolynomialElement squareMatrix()
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.squareThisMatrix();
    localGF2nPolynomialElement.reduceThis();
    return localGF2nPolynomialElement;
  }
  
  public GF2nPolynomialElement squarePreCalc()
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.squareThisPreCalc();
    localGF2nPolynomialElement.reduceThis();
    return localGF2nPolynomialElement;
  }
  
  public GF2nElement squareRoot()
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    localGF2nPolynomialElement.squareRootThis();
    return localGF2nPolynomialElement;
  }
  
  public void squareRootThis()
  {
    this.polynomial.expandN((this.mDegree << 1) + 32);
    this.polynomial.reduceN();
    int i = 0;
    while (i < this.mField.getDegree() - 1)
    {
      squareThis();
      i += 1;
    }
  }
  
  public void squareThis()
  {
    squareThisPreCalc();
  }
  
  public void squareThisBitwise()
  {
    this.polynomial.squareThisBitwise();
    reduceThis();
  }
  
  public void squareThisMatrix()
  {
    GF2Polynomial localGF2Polynomial = new GF2Polynomial(this.mDegree);
    int i = 0;
    while (i < this.mDegree)
    {
      if (this.polynomial.vectorMult(((GF2nPolynomialField)this.mField).squaringMatrix[(this.mDegree - i - 1)])) {
        localGF2Polynomial.setBit(i);
      }
      i += 1;
    }
    this.polynomial = localGF2Polynomial;
  }
  
  public void squareThisPreCalc()
  {
    this.polynomial.squareThisPreCalc();
    reduceThis();
  }
  
  boolean testBit(int paramInt)
  {
    return this.polynomial.testBit(paramInt);
  }
  
  public boolean testRightmostBit()
  {
    return this.polynomial.testBit(0);
  }
  
  public byte[] toByteArray()
  {
    return this.polynomial.toByteArray();
  }
  
  public BigInteger toFlexiBigInt()
  {
    return this.polynomial.toFlexiBigInt();
  }
  
  public String toString()
  {
    return this.polynomial.toString(16);
  }
  
  public String toString(int paramInt)
  {
    return this.polynomial.toString(paramInt);
  }
  
  public int trace()
  {
    GF2nPolynomialElement localGF2nPolynomialElement = new GF2nPolynomialElement(this);
    int i = 1;
    while (i < this.mDegree)
    {
      localGF2nPolynomialElement.squareThis();
      localGF2nPolynomialElement.addToThis(this);
      i += 1;
    }
    if (localGF2nPolynomialElement.isOne()) {
      return 1;
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nPolynomialElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */