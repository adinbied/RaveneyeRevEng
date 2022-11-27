package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Vector;

public class GF2nONBField
  extends GF2nField
{
  private static final int MAXLONG = 64;
  private int mBit;
  private int mLength;
  int[][] mMult;
  private int mType;
  
  public GF2nONBField(int paramInt, SecureRandom paramSecureRandom)
    throws RuntimeException
  {
    super(paramSecureRandom);
    if (paramInt >= 3)
    {
      this.mDegree = paramInt;
      this.mLength = (this.mDegree / 64);
      paramInt = this.mDegree & 0x3F;
      this.mBit = paramInt;
      if (paramInt == 0) {
        this.mBit = 64;
      } else {
        this.mLength += 1;
      }
      computeType();
      if (this.mType < 3)
      {
        this.mMult = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.mDegree, 2 }));
        paramInt = 0;
        while (paramInt < this.mDegree)
        {
          paramSecureRandom = this.mMult;
          paramSecureRandom[paramInt][0] = -1;
          paramSecureRandom[paramInt][1] = -1;
          paramInt += 1;
        }
        computeMultMatrix();
        computeFieldPolynomial();
        this.fields = new Vector();
        this.matrices = new Vector();
        return;
      }
      paramSecureRandom = new StringBuilder();
      paramSecureRandom.append("\nThe type of this field is ");
      paramSecureRandom.append(this.mType);
      throw new RuntimeException(paramSecureRandom.toString());
    }
    throw new IllegalArgumentException("k must be at least 3");
  }
  
  private void computeMultMatrix()
  {
    int i = this.mType;
    if ((i & 0x7) != 0)
    {
      int i2 = i * this.mDegree + 1;
      Object localObject = new int[i2];
      i = this.mType;
      if (i == 1) {
        i = 1;
      } else if (i == 2) {
        i = i2 - 1;
      } else {
        i = elementOfOrder(i, i2);
      }
      int m = 0;
      int j = 1;
      int k;
      for (;;)
      {
        k = this.mType;
        if (m >= k) {
          break;
        }
        k = j;
        int n = 0;
        while (n < this.mDegree)
        {
          localObject[k] = n;
          int i1 = (k << 1) % i2;
          k = i1;
          if (i1 < 0) {
            k = i1 + i2;
          }
          n += 1;
        }
        k = j * i % i2;
        j = k;
        if (k < 0) {
          j = k + i2;
        }
        m += 1;
      }
      int[][] arrayOfInt;
      if (k == 1)
      {
        for (i = 1; i < i2 - 1; i = j)
        {
          arrayOfInt = this.mMult;
          j = i + 1;
          if (arrayOfInt[localObject[j]][0] == -1) {
            arrayOfInt[localObject[j]][0] = localObject[(i2 - i)];
          } else {
            arrayOfInt[localObject[j]][1] = localObject[(i2 - i)];
          }
        }
        j = this.mDegree >> 1;
        i = 1;
        while (i <= j)
        {
          localObject = this.mMult;
          k = i - 1;
          if (localObject[k][0] == -1) {
            localObject[k][0] = (j + i - 1);
          } else {
            localObject[k][1] = (j + i - 1);
          }
          localObject = this.mMult;
          m = j + i - 1;
          if (localObject[m][0] == -1) {
            localObject[m][0] = k;
          } else {
            localObject[m][1] = k;
          }
          i += 1;
        }
      }
      if (k == 2)
      {
        for (i = 1; i < i2 - 1; i = j)
        {
          arrayOfInt = this.mMult;
          j = i + 1;
          if (arrayOfInt[localObject[j]][0] == -1) {
            arrayOfInt[localObject[j]][0] = localObject[(i2 - i)];
          } else {
            arrayOfInt[localObject[j]][1] = localObject[(i2 - i)];
          }
        }
        return;
      }
      throw new RuntimeException("only type 1 or type 2 implemented");
    }
    throw new RuntimeException("bisher nur fuer Gausssche Normalbasen implementiert");
  }
  
  private void computeType()
    throws RuntimeException
  {
    if ((this.mDegree & 0x7) != 0)
    {
      this.mType = 1;
      int i = 0;
      while (i != 1)
      {
        int j = this.mType * this.mDegree + 1;
        if (IntegerFunctions.isPrime(j))
        {
          i = IntegerFunctions.order(2, j);
          i = IntegerFunctions.gcd(this.mType * this.mDegree / i, this.mDegree);
        }
        this.mType += 1;
      }
      i = this.mType - 1;
      this.mType = i;
      if (i == 1)
      {
        i = (this.mDegree << 1) + 1;
        if (IntegerFunctions.isPrime(i))
        {
          i = IntegerFunctions.order(2, i);
          if (IntegerFunctions.gcd((this.mDegree << 1) / i, this.mDegree) == 1) {
            this.mType += 1;
          }
        }
      }
      return;
    }
    throw new RuntimeException("The extension degree is divisible by 8!");
  }
  
  private int elementOfOrder(int paramInt1, int paramInt2)
  {
    Random localRandom = new Random();
    int i = 0;
    int j;
    for (;;)
    {
      j = i;
      if (i != 0) {
        break;
      }
      i = localRandom.nextInt();
      k = paramInt2 - 1;
      j = i % k;
      i = j;
      if (j < 0) {
        i = j + k;
      }
    }
    int k = IntegerFunctions.order(j, paramInt2);
    i = j;
    if (k % paramInt1 == 0) {
      if (k == 0)
      {
        i = j;
      }
      else
      {
        i = paramInt1 / k;
        paramInt1 = 2;
        paramInt2 = j;
        while (paramInt1 <= i)
        {
          paramInt2 *= j;
          paramInt1 += 1;
        }
        return paramInt2;
      }
    }
    for (;;)
    {
      j = i;
      if (i != 0) {
        break;
      }
      i = localRandom.nextInt();
      k = paramInt2 - 1;
      j = i % k;
      i = j;
      if (j < 0) {
        i = j + k;
      }
    }
  }
  
  protected void computeCOBMatrix(GF2nField paramGF2nField)
  {
    if (this.mDegree == paramGF2nField.mDegree)
    {
      GF2Polynomial[] arrayOfGF2Polynomial = new GF2Polynomial[this.mDegree];
      int i = 0;
      while (i < this.mDegree)
      {
        arrayOfGF2Polynomial[i] = new GF2Polynomial(this.mDegree);
        i += 1;
      }
      GF2nElement localGF2nElement;
      do
      {
        localGF2nElement = paramGF2nField.getRandomRoot(this.fieldPolynomial);
      } while (localGF2nElement.isZero());
      GF2nPolynomialElement[] arrayOfGF2nPolynomialElement = new GF2nPolynomialElement[this.mDegree];
      arrayOfGF2nPolynomialElement[0] = ((GF2nElement)localGF2nElement.clone());
      i = 1;
      while (i < this.mDegree)
      {
        arrayOfGF2nPolynomialElement[i] = arrayOfGF2nPolynomialElement[(i - 1)].square();
        i += 1;
      }
      i = 0;
      while (i < this.mDegree)
      {
        int j = 0;
        while (j < this.mDegree)
        {
          if (arrayOfGF2nPolynomialElement[i].testBit(j)) {
            arrayOfGF2Polynomial[(this.mDegree - j - 1)].setBit(this.mDegree - i - 1);
          }
          j += 1;
        }
        i += 1;
      }
      this.fields.addElement(paramGF2nField);
      this.matrices.addElement(arrayOfGF2Polynomial);
      paramGF2nField.fields.addElement(this);
      paramGF2nField.matrices.addElement(invertMatrix(arrayOfGF2Polynomial));
      return;
    }
    throw new IllegalArgumentException("GF2nField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
  }
  
  protected void computeFieldPolynomial()
  {
    int i = this.mType;
    Object localObject3;
    if (i == 1)
    {
      localObject3 = new GF2Polynomial(this.mDegree + 1, "ALL");
      this.fieldPolynomial = ((GF2Polynomial)localObject3);
      return;
    }
    if (i == 2)
    {
      Object localObject2 = new GF2Polynomial(this.mDegree + 1, "ONE");
      Object localObject1 = new GF2Polynomial(this.mDegree + 1, "X");
      ((GF2Polynomial)localObject1).addToThis((GF2Polynomial)localObject2);
      i = 1;
      for (;;)
      {
        localObject3 = localObject1;
        if (i >= this.mDegree) {
          break;
        }
        localObject3 = ((GF2Polynomial)localObject1).shiftLeft();
        ((GF2Polynomial)localObject3).addToThis((GF2Polynomial)localObject2);
        i += 1;
        localObject2 = localObject1;
        localObject1 = localObject3;
      }
    }
  }
  
  int getONBBit()
  {
    return this.mBit;
  }
  
  int getONBLength()
  {
    return this.mLength;
  }
  
  protected GF2nElement getRandomRoot(GF2Polynomial paramGF2Polynomial)
  {
    paramGF2Polynomial = new GF2nPolynomial(paramGF2Polynomial, this);
    while (paramGF2Polynomial.getDegree() > 1)
    {
      Object localObject;
      int i;
      int j;
      do
      {
        localObject = new GF2nONBElement(this, this.random);
        GF2nPolynomial localGF2nPolynomial = new GF2nPolynomial(2, GF2nONBElement.ZERO(this));
        localGF2nPolynomial.set(1, (GF2nElement)localObject);
        localObject = new GF2nPolynomial(localGF2nPolynomial);
        i = 1;
        while (i <= this.mDegree - 1)
        {
          localObject = ((GF2nPolynomial)localObject).multiplyAndReduce((GF2nPolynomial)localObject, paramGF2Polynomial).add(localGF2nPolynomial);
          i += 1;
        }
        localObject = ((GF2nPolynomial)localObject).gcd(paramGF2Polynomial);
        i = ((GF2nPolynomial)localObject).getDegree();
        j = paramGF2Polynomial.getDegree();
      } while ((i == 0) || (i == j));
      if (i << 1 > j) {
        paramGF2Polynomial = paramGF2Polynomial.quotient((GF2nPolynomial)localObject);
      } else {
        paramGF2Polynomial = new GF2nPolynomial((GF2nPolynomial)localObject);
      }
    }
    return paramGF2Polynomial.at(0);
  }
  
  int[][] invMatrix(int[][] paramArrayOfInt)
  {
    int i = this.mDegree;
    int j = this.mDegree;
    int k = 0;
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, j });
    arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.mDegree, this.mDegree });
    j = 0;
    for (;;)
    {
      i = k;
      if (j >= this.mDegree) {
        break;
      }
      arrayOfInt[j][j] = 1;
      j += 1;
    }
    while (i < this.mDegree)
    {
      j = i;
      while (j < this.mDegree)
      {
        paramArrayOfInt[(this.mDegree - 1 - i)][j] = paramArrayOfInt[i][i];
        j += 1;
      }
      i += 1;
    }
    return (int[][])null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nONBField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */