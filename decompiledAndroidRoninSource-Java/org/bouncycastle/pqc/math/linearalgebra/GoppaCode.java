package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

public final class GoppaCode
{
  public static MaMaPe computeSystematicForm(GF2Matrix paramGF2Matrix, SecureRandom paramSecureRandom)
  {
    int j = paramGF2Matrix.getNumColumns();
    Object localObject1 = null;
    Permutation localPermutation;
    GF2Matrix localGF2Matrix1;
    GF2Matrix localGF2Matrix2;
    int i;
    do
    {
      localPermutation = new Permutation(j, paramSecureRandom);
      localGF2Matrix1 = (GF2Matrix)paramGF2Matrix.rightMultiply(localPermutation);
      localGF2Matrix2 = localGF2Matrix1.getLeftSubMatrix();
      i = 1;
      try
      {
        localObject2 = (GF2Matrix)localGF2Matrix2.computeInverse();
      }
      catch (ArithmeticException localArithmeticException)
      {
        Object localObject2;
        for (;;) {}
      }
      i = 0;
      localObject2 = localObject1;
      localObject1 = localObject2;
    } while (i == 0);
    return new MaMaPe(localGF2Matrix2, ((GF2Matrix)((GF2Matrix)localObject2).rightMultiply(localGF2Matrix1)).getRightSubMatrix(), localPermutation);
  }
  
  public static GF2Matrix createCanonicalCheckMatrix(GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM)
  {
    int m = paramGF2mField.getDegree();
    int n = 1 << m;
    int i1 = paramPolynomialGF2mSmallM.getDegree();
    int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1, n });
    int[][] arrayOfInt2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1, n });
    int i = 0;
    while (i < n)
    {
      arrayOfInt2[0][i] = paramGF2mField.inverse(paramPolynomialGF2mSmallM.evaluateAt(i));
      i += 1;
    }
    i = 1;
    int j;
    while (i < i1)
    {
      j = 0;
      while (j < n)
      {
        arrayOfInt2[i][j] = paramGF2mField.mult(arrayOfInt2[(i - 1)][j], j);
        j += 1;
      }
      i += 1;
    }
    i = 0;
    int k;
    while (i < i1)
    {
      j = 0;
      while (j < n)
      {
        k = 0;
        while (k <= i)
        {
          arrayOfInt1[i][j] = paramGF2mField.add(arrayOfInt1[i][j], paramGF2mField.mult(arrayOfInt2[k][j], paramPolynomialGF2mSmallM.getCoefficient(i1 + k - i)));
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    paramGF2mField = (int[][])Array.newInstance(Integer.TYPE, new int[] { i1 * m, n + 31 >>> 5 });
    i = 0;
    while (i < n)
    {
      int i2 = i >>> 5;
      j = 0;
      while (j < i1)
      {
        int i3 = arrayOfInt1[j][i];
        k = 0;
        while (k < m)
        {
          if ((i3 >>> k & 0x1) != 0)
          {
            paramPolynomialGF2mSmallM = paramGF2mField[((j + 1) * m - k - 1)];
            paramPolynomialGF2mSmallM[i2] ^= 1 << (i & 0x1F);
          }
          k += 1;
        }
        j += 1;
      }
      i += 1;
    }
    return new GF2Matrix(n, paramGF2mField);
  }
  
  public static GF2Vector syndromeDecode(GF2Vector paramGF2Vector, GF2mField paramGF2mField, PolynomialGF2mSmallM paramPolynomialGF2mSmallM, PolynomialGF2mSmallM[] paramArrayOfPolynomialGF2mSmallM)
  {
    int j = 1 << paramGF2mField.getDegree();
    GF2Vector localGF2Vector = new GF2Vector(j);
    if (!paramGF2Vector.isZero())
    {
      paramGF2Vector = new PolynomialGF2mSmallM(paramGF2Vector.toExtensionFieldVector(paramGF2mField)).modInverse(paramPolynomialGF2mSmallM).addMonomial(1).modSquareRootMatrix(paramArrayOfPolynomialGF2mSmallM).modPolynomialToFracton(paramPolynomialGF2mSmallM);
      int i = 0;
      paramGF2Vector = paramGF2Vector[0].multiply(paramGF2Vector[0]).add(paramGF2Vector[1].multiply(paramGF2Vector[1]).multWithMonomial(1));
      paramGF2Vector = paramGF2Vector.multWithElement(paramGF2mField.inverse(paramGF2Vector.getHeadCoefficient()));
      while (i < j)
      {
        if (paramGF2Vector.evaluateAt(i) == 0) {
          localGF2Vector.setBit(i);
        }
        i += 1;
      }
    }
    return localGF2Vector;
  }
  
  public static class MaMaPe
  {
    private GF2Matrix h;
    private Permutation p;
    private GF2Matrix s;
    
    public MaMaPe(GF2Matrix paramGF2Matrix1, GF2Matrix paramGF2Matrix2, Permutation paramPermutation)
    {
      this.s = paramGF2Matrix1;
      this.h = paramGF2Matrix2;
      this.p = paramPermutation;
    }
    
    public GF2Matrix getFirstMatrix()
    {
      return this.s;
    }
    
    public Permutation getPermutation()
    {
      return this.p;
    }
    
    public GF2Matrix getSecondMatrix()
    {
      return this.h;
    }
  }
  
  public static class MatrixSet
  {
    private GF2Matrix g;
    private int[] setJ;
    
    public MatrixSet(GF2Matrix paramGF2Matrix, int[] paramArrayOfInt)
    {
      this.g = paramGF2Matrix;
      this.setJ = paramArrayOfInt;
    }
    
    public GF2Matrix getG()
    {
      return this.g;
    }
    
    public int[] getSetJ()
    {
      return this.setJ;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GoppaCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */