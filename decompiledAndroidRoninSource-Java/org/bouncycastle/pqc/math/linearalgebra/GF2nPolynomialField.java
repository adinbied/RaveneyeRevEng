package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import java.util.Vector;

public class GF2nPolynomialField
  extends GF2nField
{
  private boolean isPentanomial = false;
  private boolean isTrinomial = false;
  private int[] pc = new int[3];
  GF2Polynomial[] squaringMatrix;
  private int tc;
  
  public GF2nPolynomialField(int paramInt, SecureRandom paramSecureRandom)
  {
    super(paramSecureRandom);
    if (paramInt >= 3)
    {
      this.mDegree = paramInt;
      computeFieldPolynomial();
      computeSquaringMatrix();
      this.fields = new Vector();
      this.matrices = new Vector();
      return;
    }
    throw new IllegalArgumentException("k must be at least 3");
  }
  
  public GF2nPolynomialField(int paramInt, SecureRandom paramSecureRandom, GF2Polynomial paramGF2Polynomial)
    throws RuntimeException
  {
    super(paramSecureRandom);
    if (paramInt >= 3)
    {
      if (paramGF2Polynomial.getLength() == paramInt + 1)
      {
        if (paramGF2Polynomial.isIrreducible())
        {
          this.mDegree = paramInt;
          this.fieldPolynomial = paramGF2Polynomial;
          computeSquaringMatrix();
          int j = 2;
          int i = 1;
          while (i < this.fieldPolynomial.getLength() - 1)
          {
            paramInt = j;
            if (this.fieldPolynomial.testBit(i))
            {
              j += 1;
              if (j == 3) {
                this.tc = i;
              }
              paramInt = j;
              if (j <= 5)
              {
                this.pc[(j - 3)] = i;
                paramInt = j;
              }
            }
            i += 1;
            j = paramInt;
          }
          if (j == 3) {
            this.isTrinomial = true;
          }
          if (j == 5) {
            this.isPentanomial = true;
          }
          this.fields = new Vector();
          this.matrices = new Vector();
          return;
        }
        throw new RuntimeException();
      }
      throw new RuntimeException();
    }
    throw new IllegalArgumentException("degree must be at least 3");
  }
  
  public GF2nPolynomialField(int paramInt, SecureRandom paramSecureRandom, boolean paramBoolean)
  {
    super(paramSecureRandom);
    if (paramInt >= 3)
    {
      this.mDegree = paramInt;
      if (paramBoolean) {
        computeFieldPolynomial();
      } else {
        computeFieldPolynomial2();
      }
      computeSquaringMatrix();
      this.fields = new Vector();
      this.matrices = new Vector();
      return;
    }
    throw new IllegalArgumentException("k must be at least 3");
  }
  
  private void computeSquaringMatrix()
  {
    GF2Polynomial[] arrayOfGF2Polynomial1 = new GF2Polynomial[this.mDegree - 1];
    this.squaringMatrix = new GF2Polynomial[this.mDegree];
    int k = 0;
    int i = 0;
    int j;
    for (;;)
    {
      GF2Polynomial[] arrayOfGF2Polynomial2 = this.squaringMatrix;
      j = k;
      if (i >= arrayOfGF2Polynomial2.length) {
        break;
      }
      arrayOfGF2Polynomial2[i] = new GF2Polynomial(this.mDegree, "ZERO");
      i += 1;
    }
    while (j < this.mDegree - 1)
    {
      arrayOfGF2Polynomial1[j] = new GF2Polynomial(1, "ONE").shiftLeft(this.mDegree + j).remainder(this.fieldPolynomial);
      j += 1;
    }
    i = 1;
    while (i <= Math.abs(this.mDegree >> 1))
    {
      j = 1;
      while (j <= this.mDegree)
      {
        if (arrayOfGF2Polynomial1[(this.mDegree - (i << 1))].testBit(this.mDegree - j)) {
          this.squaringMatrix[(j - 1)].setBit(this.mDegree - i);
        }
        j += 1;
      }
      i += 1;
    }
    i = Math.abs(this.mDegree >> 1) + 1;
    while (i <= this.mDegree)
    {
      this.squaringMatrix[((i << 1) - this.mDegree - 1)].setBit(this.mDegree - i);
      i += 1;
    }
  }
  
  private boolean testPentanomials()
  {
    this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
    this.fieldPolynomial.setBit(0);
    this.fieldPolynomial.setBit(this.mDegree);
    int i = 1;
    boolean bool1 = false;
    while ((i <= this.mDegree - 3) && (!bool1))
    {
      this.fieldPolynomial.setBit(i);
      int j = i + 1;
      int m;
      for (int k = j; (k <= this.mDegree - 2) && (!bool1); k = m)
      {
        this.fieldPolynomial.setBit(k);
        m = k + 1;
        int n = m;
        while ((n <= this.mDegree - 1) && (!bool1))
        {
          this.fieldPolynomial.setBit(n);
          int i1;
          if ((this.mDegree & 0x1) != 0) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          int i2;
          if ((i & 0x1) != 0) {
            i2 = 1;
          } else {
            i2 = 0;
          }
          int i3;
          if ((k & 0x1) != 0) {
            i3 = 1;
          } else {
            i3 = 0;
          }
          int i4;
          if ((n & 0x1) != 0) {
            i4 = 1;
          } else {
            i4 = 0;
          }
          if ((i1 | i2 | i3 | i4) != 0)
          {
            boolean bool2 = this.fieldPolynomial.isIrreducible();
            bool1 = bool2;
            if (bool2)
            {
              this.isPentanomial = true;
              int[] arrayOfInt = this.pc;
              arrayOfInt[0] = i;
              arrayOfInt[1] = k;
              arrayOfInt[2] = n;
              return bool2;
            }
          }
          this.fieldPolynomial.resetBit(n);
          n += 1;
        }
        this.fieldPolynomial.resetBit(k);
      }
      this.fieldPolynomial.resetBit(i);
      i = j;
    }
    return bool1;
  }
  
  private boolean testRandom()
  {
    this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
    do
    {
      this.fieldPolynomial.randomize();
      this.fieldPolynomial.setBit(this.mDegree);
      this.fieldPolynomial.setBit(0);
    } while (!this.fieldPolynomial.isIrreducible());
    return true;
  }
  
  private boolean testTrinomials()
  {
    this.fieldPolynomial = new GF2Polynomial(this.mDegree + 1);
    GF2Polynomial localGF2Polynomial = this.fieldPolynomial;
    boolean bool = false;
    localGF2Polynomial.setBit(0);
    this.fieldPolynomial.setBit(this.mDegree);
    int i = 1;
    while ((i < this.mDegree) && (!bool))
    {
      this.fieldPolynomial.setBit(i);
      bool = this.fieldPolynomial.isIrreducible();
      if (bool)
      {
        this.isTrinomial = true;
        this.tc = i;
        return bool;
      }
      this.fieldPolynomial.resetBit(i);
      bool = this.fieldPolynomial.isIrreducible();
      i += 1;
    }
    return bool;
  }
  
  protected void computeCOBMatrix(GF2nField paramGF2nField)
  {
    if (this.mDegree == paramGF2nField.mDegree)
    {
      boolean bool = paramGF2nField instanceof GF2nONBField;
      if (bool)
      {
        paramGF2nField.computeCOBMatrix(this);
        return;
      }
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
      Object localObject;
      if ((localGF2nElement instanceof GF2nONBElement))
      {
        localObject = new GF2nONBElement[this.mDegree];
        localObject[(this.mDegree - 1)] = GF2nONBElement.ONE((GF2nONBField)paramGF2nField);
      }
      else
      {
        localObject = new GF2nPolynomialElement[this.mDegree];
        localObject[(this.mDegree - 1)] = GF2nPolynomialElement.ONE((GF2nPolynomialField)paramGF2nField);
      }
      localObject[(this.mDegree - 2)] = localGF2nElement;
      i = this.mDegree - 3;
      while (i >= 0)
      {
        localObject[i] = ((GF2nElement)localObject[(i + 1)].multiply(localGF2nElement));
        i -= 1;
      }
      int j;
      if (bool)
      {
        i = 0;
        while (i < this.mDegree)
        {
          j = 0;
          while (j < this.mDegree)
          {
            if (localObject[i].testBit(this.mDegree - j - 1)) {
              arrayOfGF2Polynomial[(this.mDegree - j - 1)].setBit(this.mDegree - i - 1);
            }
            j += 1;
          }
          i += 1;
        }
      }
      i = 0;
      while (i < this.mDegree)
      {
        j = 0;
        while (j < this.mDegree)
        {
          if (localObject[i].testBit(j)) {
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
    throw new IllegalArgumentException("GF2nPolynomialField.computeCOBMatrix: B1 has a different degree and thus cannot be coverted to!");
  }
  
  protected void computeFieldPolynomial()
  {
    if (testTrinomials()) {
      return;
    }
    if (testPentanomials()) {
      return;
    }
    testRandom();
  }
  
  protected void computeFieldPolynomial2()
  {
    if (testTrinomials()) {
      return;
    }
    if (testPentanomials()) {
      return;
    }
    testRandom();
  }
  
  public int[] getPc()
    throws RuntimeException
  {
    if (this.isPentanomial)
    {
      int[] arrayOfInt = new int[3];
      System.arraycopy(this.pc, 0, arrayOfInt, 0, 3);
      return arrayOfInt;
    }
    throw new RuntimeException();
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
        localObject = new GF2nPolynomialElement(this, this.random);
        GF2nPolynomial localGF2nPolynomial = new GF2nPolynomial(2, GF2nPolynomialElement.ZERO(this));
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
  
  public GF2Polynomial getSquaringVector(int paramInt)
  {
    return new GF2Polynomial(this.squaringMatrix[paramInt]);
  }
  
  public int getTc()
    throws RuntimeException
  {
    if (this.isTrinomial) {
      return this.tc;
    }
    throw new RuntimeException();
  }
  
  public boolean isPentanomial()
  {
    return this.isPentanomial;
  }
  
  public boolean isTrinomial()
  {
    return this.isTrinomial;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nPolynomialField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */