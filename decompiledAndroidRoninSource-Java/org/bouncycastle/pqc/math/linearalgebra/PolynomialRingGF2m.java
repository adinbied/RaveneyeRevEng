package org.bouncycastle.pqc.math.linearalgebra;

public class PolynomialRingGF2m
{
  private GF2mField field;
  private PolynomialGF2mSmallM p;
  protected PolynomialGF2mSmallM[] sqMatrix;
  protected PolynomialGF2mSmallM[] sqRootMatrix;
  
  public PolynomialRingGF2m(GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    this.field = paramGF2mField;
    this.p = paramPolynomialGF2mSmallM;
    computeSquaringMatrix();
    computeSquareRootMatrix();
  }
  
  private void computeSquareRootMatrix()
  {
    int n = this.p.getDegree();
    PolynomialGF2mSmallM[] arrayOfPolynomialGF2mSmallM = new PolynomialGF2mSmallM[n];
    int i = n - 1;
    int j = i;
    while (j >= 0)
    {
      arrayOfPolynomialGF2mSmallM[j] = new PolynomialGF2mSmallM(this.sqMatrix[j]);
      j -= 1;
    }
    this.sqRootMatrix = new PolynomialGF2mSmallM[n];
    while (i >= 0)
    {
      this.sqRootMatrix[i] = new PolynomialGF2mSmallM(this.field, i);
      i -= 1;
    }
    j = 0;
    while (j < n)
    {
      int k;
      if (arrayOfPolynomialGF2mSmallM[j].getCoefficient(j) == 0)
      {
        i = j + 1;
        k = 0;
        while (i < n)
        {
          int m = i;
          if (arrayOfPolynomialGF2mSmallM[i].getCoefficient(j) != 0)
          {
            swapColumns(arrayOfPolynomialGF2mSmallM, j, i);
            swapColumns(this.sqRootMatrix, j, i);
            m = n;
            k = 1;
          }
          i = m + 1;
        }
        if (k == 0) {
          throw new ArithmeticException("Squaring matrix is not invertible.");
        }
      }
      i = arrayOfPolynomialGF2mSmallM[j].getCoefficient(j);
      i = this.field.inverse(i);
      arrayOfPolynomialGF2mSmallM[j].multThisWithElement(i);
      this.sqRootMatrix[j].multThisWithElement(i);
      i = 0;
      while (i < n)
      {
        if (i != j)
        {
          k = arrayOfPolynomialGF2mSmallM[i].getCoefficient(j);
          if (k != 0)
          {
            PolynomialGF2mSmallM localPolynomialGF2mSmallM1 = arrayOfPolynomialGF2mSmallM[j].multWithElement(k);
            PolynomialGF2mSmallM localPolynomialGF2mSmallM2 = this.sqRootMatrix[j].multWithElement(k);
            arrayOfPolynomialGF2mSmallM[i].addToThis(localPolynomialGF2mSmallM1);
            this.sqRootMatrix[i].addToThis(localPolynomialGF2mSmallM2);
          }
        }
        i += 1;
      }
      j += 1;
    }
  }
  
  private void computeSquaringMatrix()
  {
    int m = this.p.getDegree();
    this.sqMatrix = new PolynomialGF2mSmallM[m];
    int i = 0;
    int j;
    Object localObject;
    for (;;)
    {
      int k = m >> 1;
      j = k;
      if (i >= k) {
        break;
      }
      j = i << 1;
      localObject = new int[j + 1];
      localObject[j] = 1;
      this.sqMatrix[i] = new PolynomialGF2mSmallM(this.field, (int[])localObject);
      i += 1;
    }
    while (j < m)
    {
      i = j << 1;
      localObject = new int[i + 1];
      localObject[i] = 1;
      localObject = new PolynomialGF2mSmallM(this.field, (int[])localObject);
      this.sqMatrix[j] = ((PolynomialGF2mSmallM)localObject).mod(this.p);
      j += 1;
    }
  }
  
  private static void swapColumns(PolynomialGF2mSmallM[] paramArrayOfPolynomialGF2mSmallM, int paramInt1, int paramInt2)
  {
    PolynomialGF2mSmallM localPolynomialGF2mSmallM = paramArrayOfPolynomialGF2mSmallM[paramInt1];
    paramArrayOfPolynomialGF2mSmallM[paramInt1] = paramArrayOfPolynomialGF2mSmallM[paramInt2];
    paramArrayOfPolynomialGF2mSmallM[paramInt2] = localPolynomialGF2mSmallM;
  }
  
  public PolynomialGF2mSmallM[] getSquareRootMatrix()
  {
    return this.sqRootMatrix;
  }
  
  public PolynomialGF2mSmallM[] getSquaringMatrix()
  {
    return this.sqMatrix;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\PolynomialRingGF2m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */