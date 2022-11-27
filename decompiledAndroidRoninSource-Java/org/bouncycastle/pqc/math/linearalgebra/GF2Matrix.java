package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;
import java.security.SecureRandom;

public class GF2Matrix
  extends Matrix
{
  private int length;
  private int[][] matrix;
  
  public GF2Matrix(int paramInt, char paramChar)
  {
    this(paramInt, paramChar, new SecureRandom());
  }
  
  public GF2Matrix(int paramInt, char paramChar, SecureRandom paramSecureRandom)
  {
    if (paramInt > 0)
    {
      if (paramChar != 'I')
      {
        if (paramChar != 'L')
        {
          if (paramChar != 'R')
          {
            if (paramChar != 'U')
            {
              if (paramChar == 'Z')
              {
                assignZeroMatrix(paramInt, paramInt);
                return;
              }
              throw new ArithmeticException("Unknown matrix type.");
            }
            assignRandomUpperTriangularMatrix(paramInt, paramSecureRandom);
            return;
          }
          assignRandomRegularMatrix(paramInt, paramSecureRandom);
          return;
        }
        assignRandomLowerTriangularMatrix(paramInt, paramSecureRandom);
        return;
      }
      assignUnitMatrix(paramInt);
      return;
    }
    throw new ArithmeticException("Size of matrix is non-positive.");
  }
  
  private GF2Matrix(int paramInt1, int paramInt2)
  {
    if ((paramInt2 > 0) && (paramInt1 > 0))
    {
      assignZeroMatrix(paramInt1, paramInt2);
      return;
    }
    throw new ArithmeticException("size of matrix is non-positive");
  }
  
  public GF2Matrix(int paramInt, int[][] paramArrayOfInt)
  {
    int i = 0;
    if (paramArrayOfInt[0].length == paramInt + 31 >> 5)
    {
      this.numColumns = paramInt;
      this.numRows = paramArrayOfInt.length;
      this.length = paramArrayOfInt[0].length;
      paramInt &= 0x1F;
      if (paramInt == 0) {
        paramInt = -1;
      } else {
        paramInt = (1 << paramInt) - 1;
      }
      while (i < this.numRows)
      {
        int[] arrayOfInt = paramArrayOfInt[i];
        int j = this.length - 1;
        arrayOfInt[j] &= paramInt;
        i += 1;
      }
      this.matrix = paramArrayOfInt;
      return;
    }
    throw new ArithmeticException("Int array does not match given number of columns.");
  }
  
  public GF2Matrix(GF2Matrix paramGF2Matrix)
  {
    this.numColumns = paramGF2Matrix.getNumColumns();
    this.numRows = paramGF2Matrix.getNumRows();
    this.length = paramGF2Matrix.length;
    this.matrix = new int[paramGF2Matrix.matrix.length][];
    int i = 0;
    for (;;)
    {
      int[][] arrayOfInt = this.matrix;
      if (i >= arrayOfInt.length) {
        break;
      }
      arrayOfInt[i] = IntUtils.clone(paramGF2Matrix.matrix[i]);
      i += 1;
    }
  }
  
  public GF2Matrix(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length >= 9)
    {
      this.numRows = LittleEndianConversions.OS2IP(paramArrayOfByte, 0);
      this.numColumns = LittleEndianConversions.OS2IP(paramArrayOfByte, 4);
      int j = this.numColumns;
      int k = this.numRows;
      if (this.numRows > 0)
      {
        int m = paramArrayOfByte.length;
        int i = 8;
        if ((j + 7 >>> 3) * k == m - 8)
        {
          this.length = (this.numColumns + 31 >>> 5);
          this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length }));
          m = this.numColumns >> 5;
          int n = this.numColumns;
          j = 0;
          while (j < this.numRows)
          {
            k = 0;
            while (k < m)
            {
              this.matrix[j][k] = LittleEndianConversions.OS2IP(paramArrayOfByte, i);
              k += 1;
              i += 4;
            }
            k = 0;
            while (k < (n & 0x1F))
            {
              int[] arrayOfInt = this.matrix[j];
              int i1 = arrayOfInt[m];
              arrayOfInt[m] = ((paramArrayOfByte[i] & 0xFF) << k ^ i1);
              k += 8;
              i += 1;
            }
            j += 1;
          }
          return;
        }
      }
      throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
    }
    throw new ArithmeticException("given array is not an encoded matrix over GF(2)");
  }
  
  private static void addToRow(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt)
  {
    int i = paramArrayOfInt2.length - 1;
    while (i >= paramInt)
    {
      paramArrayOfInt1[i] ^= paramArrayOfInt2[i];
      i -= 1;
    }
  }
  
  private void assignRandomLowerTriangularMatrix(int paramInt, SecureRandom paramSecureRandom)
  {
    this.numRows = paramInt;
    this.numColumns = paramInt;
    this.length = (paramInt + 31 >>> 5);
    this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length }));
    paramInt = 0;
    while (paramInt < this.numRows)
    {
      int j = paramInt >>> 5;
      int k = paramInt & 0x1F;
      int i = 0;
      while (i < j)
      {
        this.matrix[paramInt][i] = paramSecureRandom.nextInt();
        i += 1;
      }
      this.matrix[paramInt][j] = (1 << k | paramSecureRandom.nextInt() >>> 31 - k);
      i = j;
      for (;;)
      {
        i += 1;
        if (i >= this.length) {
          break;
        }
        this.matrix[paramInt][i] = 0;
      }
      paramInt += 1;
    }
  }
  
  private void assignRandomRegularMatrix(int paramInt, SecureRandom paramSecureRandom)
  {
    this.numRows = paramInt;
    this.numColumns = paramInt;
    this.length = (paramInt + 31 >>> 5);
    this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length }));
    GF2Matrix localGF2Matrix = (GF2Matrix)new GF2Matrix(paramInt, 'L', paramSecureRandom).rightMultiply(new GF2Matrix(paramInt, 'U', paramSecureRandom));
    paramSecureRandom = new Permutation(paramInt, paramSecureRandom).getVector();
    int i = 0;
    while (i < paramInt)
    {
      System.arraycopy(localGF2Matrix.matrix[i], 0, this.matrix[paramSecureRandom[i]], 0, this.length);
      i += 1;
    }
  }
  
  private void assignRandomUpperTriangularMatrix(int paramInt, SecureRandom paramSecureRandom)
  {
    this.numRows = paramInt;
    this.numColumns = paramInt;
    this.length = (paramInt + 31 >>> 5);
    this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length }));
    paramInt &= 0x1F;
    if (paramInt == 0) {
      paramInt = -1;
    } else {
      paramInt = (1 << paramInt) - 1;
    }
    int i = 0;
    while (i < this.numRows)
    {
      int k = i >>> 5;
      int m = i & 0x1F;
      int j = 0;
      while (j < k)
      {
        this.matrix[i][j] = 0;
        j += 1;
      }
      this.matrix[i][k] = (paramSecureRandom.nextInt() << m | 1 << m);
      j = k;
      for (;;)
      {
        j += 1;
        k = this.length;
        if (j >= k) {
          break;
        }
        this.matrix[i][j] = paramSecureRandom.nextInt();
      }
      int[] arrayOfInt = this.matrix[i];
      j = k - 1;
      arrayOfInt[j] &= paramInt;
      i += 1;
    }
  }
  
  private void assignUnitMatrix(int paramInt)
  {
    this.numRows = paramInt;
    this.numColumns = paramInt;
    this.length = (paramInt + 31 >>> 5);
    paramInt = this.numRows;
    int i = this.length;
    int j = 0;
    this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt, i }));
    paramInt = 0;
    for (;;)
    {
      i = j;
      if (paramInt >= this.numRows) {
        break;
      }
      i = 0;
      while (i < this.length)
      {
        this.matrix[paramInt][i] = 0;
        i += 1;
      }
      paramInt += 1;
    }
    while (i < this.numRows)
    {
      this.matrix[i][(i >>> 5)] = (1 << (i & 0x1F));
      i += 1;
    }
  }
  
  private void assignZeroMatrix(int paramInt1, int paramInt2)
  {
    this.numRows = paramInt1;
    this.numColumns = paramInt2;
    this.length = (paramInt2 + 31 >>> 5);
    this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length }));
    paramInt1 = 0;
    while (paramInt1 < this.numRows)
    {
      paramInt2 = 0;
      while (paramInt2 < this.length)
      {
        this.matrix[paramInt1][paramInt2] = 0;
        paramInt2 += 1;
      }
      paramInt1 += 1;
    }
  }
  
  public static GF2Matrix[] createRandomRegularMatrixAndItsInverse(int paramInt, SecureRandom paramSecureRandom)
  {
    int n = paramInt + 31 >> 5;
    GF2Matrix localGF2Matrix2 = new GF2Matrix(paramInt, 'L', paramSecureRandom);
    GF2Matrix localGF2Matrix1 = new GF2Matrix(paramInt, 'U', paramSecureRandom);
    GF2Matrix localGF2Matrix3 = (GF2Matrix)localGF2Matrix2.rightMultiply(localGF2Matrix1);
    paramSecureRandom = new Permutation(paramInt, paramSecureRandom);
    Object localObject = paramSecureRandom.getVector();
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { paramInt, n });
    int i = 0;
    while (i < paramInt)
    {
      System.arraycopy(localGF2Matrix3.matrix[localObject[i]], 0, arrayOfInt[i], 0, n);
      i += 1;
    }
    localGF2Matrix3 = new GF2Matrix(paramInt, arrayOfInt);
    localObject = new GF2Matrix(paramInt, 'I');
    int j;
    int k;
    int m;
    int[] arrayOfInt1;
    for (i = 0; i < paramInt; i = j)
    {
      int i1 = i >>> 5;
      j = i + 1;
      k = j;
      while (k < paramInt)
      {
        if ((localGF2Matrix2.matrix[k][i1] & 1 << (i & 0x1F)) != 0)
        {
          m = 0;
          while (m <= i1)
          {
            arrayOfInt = ((GF2Matrix)localObject).matrix;
            arrayOfInt1 = arrayOfInt[k];
            arrayOfInt1[m] ^= arrayOfInt[i][m];
            m += 1;
          }
        }
        k += 1;
      }
    }
    localGF2Matrix2 = new GF2Matrix(paramInt, 'I');
    paramInt -= 1;
    while (paramInt >= 0)
    {
      k = paramInt >>> 5;
      i = paramInt - 1;
      while (i >= 0)
      {
        if ((localGF2Matrix1.matrix[i][k] & 1 << (paramInt & 0x1F)) != 0)
        {
          j = k;
          while (j < n)
          {
            arrayOfInt = localGF2Matrix2.matrix;
            arrayOfInt1 = arrayOfInt[i];
            m = arrayOfInt1[j];
            arrayOfInt1[j] = (arrayOfInt[paramInt][j] ^ m);
            j += 1;
          }
        }
        i -= 1;
      }
      paramInt -= 1;
    }
    return new GF2Matrix[] { localGF2Matrix3, (GF2Matrix)localGF2Matrix2.rightMultiply(((GF2Matrix)localObject).rightMultiply(paramSecureRandom)) };
  }
  
  private static void swapRows(int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = paramArrayOfInt[paramInt1];
    paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt2] = arrayOfInt;
  }
  
  public Matrix computeInverse()
  {
    if (this.numRows == this.numColumns)
    {
      int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length });
      int i = this.numRows - 1;
      while (i >= 0)
      {
        arrayOfInt1[i] = IntUtils.clone(this.matrix[i]);
        i -= 1;
      }
      int[][] arrayOfInt2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.length });
      i = this.numRows - 1;
      while (i >= 0)
      {
        arrayOfInt2[i][(i >> 5)] = (1 << (i & 0x1F));
        i -= 1;
      }
      int j = 0;
      while (j < this.numRows)
      {
        int n = j >> 5;
        int i1 = 1 << (j & 0x1F);
        if ((arrayOfInt1[j][n] & i1) == 0)
        {
          i = j + 1;
          int k = 0;
          while (i < this.numRows)
          {
            int m = i;
            if ((arrayOfInt1[i][n] & i1) != 0)
            {
              swapRows(arrayOfInt1, j, i);
              swapRows(arrayOfInt2, j, i);
              m = this.numRows;
              k = 1;
            }
            i = m + 1;
          }
          if (k == 0) {
            throw new ArithmeticException("Matrix is not invertible.");
          }
        }
        i = this.numRows - 1;
        while (i >= 0)
        {
          if ((i != j) && ((arrayOfInt1[i][n] & i1) != 0))
          {
            addToRow(arrayOfInt1[j], arrayOfInt1[i], n);
            addToRow(arrayOfInt2[j], arrayOfInt2[i], 0);
          }
          i -= 1;
        }
        j += 1;
      }
      return new GF2Matrix(this.numColumns, arrayOfInt2);
    }
    throw new ArithmeticException("Matrix is not invertible.");
  }
  
  public Matrix computeTranspose()
  {
    int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.numColumns, this.numRows + 31 >>> 5 });
    int i = 0;
    while (i < this.numRows)
    {
      int j = 0;
      while (j < this.numColumns)
      {
        int k = this.matrix[i][(j >>> 5)];
        int m = i >>> 5;
        if ((k >>> (j & 0x1F) & 0x1) == 1)
        {
          int[] arrayOfInt1 = arrayOfInt[j];
          arrayOfInt1[m] = (1 << (i & 0x1F) | arrayOfInt1[m]);
        }
        j += 1;
      }
      i += 1;
    }
    return new GF2Matrix(this.numRows, arrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GF2Matrix)) {
      return false;
    }
    paramObject = (GF2Matrix)paramObject;
    if ((this.numRows == ((GF2Matrix)paramObject).numRows) && (this.numColumns == ((GF2Matrix)paramObject).numColumns))
    {
      if (this.length != ((GF2Matrix)paramObject).length) {
        return false;
      }
      int i = 0;
      while (i < this.numRows)
      {
        if (!IntUtils.equals(this.matrix[i], paramObject.matrix[i])) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  public GF2Matrix extendLeftCompactForm()
  {
    int i = this.numColumns;
    int j = this.numRows;
    GF2Matrix localGF2Matrix = new GF2Matrix(this.numRows, i + j);
    i = this.numRows - 1 + this.numColumns;
    j = this.numRows - 1;
    while (j >= 0)
    {
      System.arraycopy(this.matrix[j], 0, localGF2Matrix.matrix[j], 0, this.length);
      int[] arrayOfInt = localGF2Matrix.matrix[j];
      int k = i >> 5;
      arrayOfInt[k] |= 1 << (i & 0x1F);
      j -= 1;
      i -= 1;
    }
    return localGF2Matrix;
  }
  
  public GF2Matrix extendRightCompactForm()
  {
    GF2Matrix localGF2Matrix = new GF2Matrix(this.numRows, this.numRows + this.numColumns);
    int m = this.numRows >> 5;
    int i1 = this.numRows & 0x1F;
    int i = this.numRows - 1;
    while (i >= 0)
    {
      Object localObject1 = localGF2Matrix.matrix;
      Object localObject2 = localObject1[i];
      int j = i >> 5;
      localObject2[j] |= 1 << (i & 0x1F);
      int k = 0;
      if (i1 != 0)
      {
        for (j = m;; j = n)
        {
          n = this.length;
          if (k >= n - 1) {
            break;
          }
          int i2 = this.matrix[i][k];
          localObject1 = localGF2Matrix.matrix;
          localObject2 = localObject1[i];
          n = j + 1;
          localObject2[j] |= i2 << i1;
          localObject1 = localObject1[i];
          localObject1[n] = (i2 >>> 32 - i1 | localObject1[n]);
          k += 1;
        }
        k = this.matrix[i][(n - 1)];
        localObject1 = localGF2Matrix.matrix;
        localObject2 = localObject1[i];
        int n = j + 1;
        localObject2[j] |= k << i1;
        if (n < localGF2Matrix.length)
        {
          localObject1 = localObject1[i];
          localObject1[n] = (k >>> 32 - i1 | localObject1[n]);
        }
      }
      else
      {
        System.arraycopy(this.matrix[i], 0, localObject1[i], m, this.length);
      }
      i -= 1;
    }
    return localGF2Matrix;
  }
  
  public byte[] getEncoded()
  {
    int j = this.numColumns;
    int k = this.numRows;
    int i = 8;
    byte[] arrayOfByte = new byte[(j + 7 >>> 3) * k + 8];
    LittleEndianConversions.I2OSP(this.numRows, arrayOfByte, 0);
    LittleEndianConversions.I2OSP(this.numColumns, arrayOfByte, 4);
    int m = this.numColumns >>> 5;
    int n = this.numColumns;
    j = 0;
    while (j < this.numRows)
    {
      k = 0;
      while (k < m)
      {
        LittleEndianConversions.I2OSP(this.matrix[j][k], arrayOfByte, i);
        k += 1;
        i += 4;
      }
      k = 0;
      while (k < (n & 0x1F))
      {
        arrayOfByte[i] = ((byte)(this.matrix[j][m] >>> k & 0xFF));
        k += 8;
        i += 1;
      }
      j += 1;
    }
    return arrayOfByte;
  }
  
  public double getHammingWeight()
  {
    int n = this.numColumns & 0x1F;
    int i = this.length;
    if (n != 0) {
      i -= 1;
    }
    double d2 = 0.0D;
    double d1 = 0.0D;
    int j = 0;
    while (j < this.numRows)
    {
      int k = 0;
      while (k < i)
      {
        int i1 = this.matrix[j][k];
        m = 0;
        while (m < 32)
        {
          d2 += (i1 >>> m & 0x1);
          d1 += 1.0D;
          m += 1;
        }
        k += 1;
      }
      int m = this.matrix[j][(this.length - 1)];
      k = 0;
      while (k < n)
      {
        d2 += (m >>> k & 0x1);
        d1 += 1.0D;
        k += 1;
      }
      j += 1;
    }
    return d2 / d1;
  }
  
  public int[][] getIntArray()
  {
    return this.matrix;
  }
  
  public GF2Matrix getLeftSubMatrix()
  {
    if (this.numColumns > this.numRows)
    {
      int k = this.numRows + 31 >> 5;
      int[][] arrayOfInt = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, k });
      int j = (1 << (this.numRows & 0x1F)) - 1;
      int i = j;
      if (j == 0) {
        i = -1;
      }
      j = this.numRows - 1;
      while (j >= 0)
      {
        System.arraycopy(this.matrix[j], 0, arrayOfInt[j], 0, k);
        int[] arrayOfInt1 = arrayOfInt[j];
        int m = k - 1;
        arrayOfInt1[m] &= i;
        j -= 1;
      }
      return new GF2Matrix(this.numRows, arrayOfInt);
    }
    throw new ArithmeticException("empty submatrix");
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public GF2Matrix getRightSubMatrix()
  {
    if (this.numColumns > this.numRows)
    {
      int m = this.numRows >> 5;
      int i1 = this.numRows & 0x1F;
      GF2Matrix localGF2Matrix = new GF2Matrix(this.numRows, this.numColumns - this.numRows);
      int i = this.numRows - 1;
      while (i >= 0)
      {
        int k = 0;
        if (i1 != 0)
        {
          int n;
          for (int j = m;; j = n)
          {
            n = localGF2Matrix.length;
            if (k >= n - 1) {
              break;
            }
            localObject1 = localGF2Matrix.matrix[i];
            localObject2 = this.matrix;
            localObject3 = localObject2[i];
            n = j + 1;
            localObject1[k] = (localObject3[j] >>> i1 | localObject2[i][n] << 32 - i1);
            k += 1;
          }
          Object localObject2 = localGF2Matrix.matrix;
          Object localObject3 = localObject2[i];
          Object localObject1 = this.matrix;
          Object localObject4 = localObject1[i];
          k = j + 1;
          localObject3[(n - 1)] = (localObject4[j] >>> i1);
          if (k < this.length)
          {
            localObject2 = localObject2[i];
            j = n - 1;
            localObject2[j] |= localObject1[i][k] << 32 - i1;
          }
        }
        else
        {
          System.arraycopy(this.matrix[i], m, localGF2Matrix.matrix[i], 0, localGF2Matrix.length);
        }
        i -= 1;
      }
      return localGF2Matrix;
    }
    throw new ArithmeticException("empty submatrix");
  }
  
  public int[] getRow(int paramInt)
  {
    return this.matrix[paramInt];
  }
  
  public int hashCode()
  {
    int j = (this.numRows * 31 + this.numColumns) * 31 + this.length;
    int i = 0;
    while (i < this.numRows)
    {
      j = j * 31 + this.matrix[i].hashCode();
      i += 1;
    }
    return j;
  }
  
  public boolean isZero()
  {
    int i = 0;
    while (i < this.numRows)
    {
      int j = 0;
      while (j < this.length)
      {
        if (this.matrix[i][j] != 0) {
          return false;
        }
        j += 1;
      }
      i += 1;
    }
    return true;
  }
  
  public Matrix leftMultiply(Permutation paramPermutation)
  {
    paramPermutation = paramPermutation.getVector();
    if (paramPermutation.length == this.numRows)
    {
      int[][] arrayOfInt = new int[this.numRows][];
      int i = this.numRows - 1;
      while (i >= 0)
      {
        arrayOfInt[i] = IntUtils.clone(this.matrix[paramPermutation[i]]);
        i -= 1;
      }
      return new GF2Matrix(this.numRows, arrayOfInt);
    }
    throw new ArithmeticException("length mismatch");
  }
  
  public Vector leftMultiply(Vector paramVector)
  {
    if ((paramVector instanceof GF2Vector))
    {
      if (paramVector.length == this.numRows)
      {
        paramVector = ((GF2Vector)paramVector).getVecArray();
        int[] arrayOfInt = new int[this.length];
        int i2 = this.numRows >> 5;
        int i3 = this.numRows;
        int n = 1;
        int j = 0;
        int k;
        int m;
        for (int i = 0;; i = m)
        {
          k = n;
          m = i;
          if (j >= i2) {
            break;
          }
          k = 1;
          int i1;
          do
          {
            if ((paramVector[j] & k) != 0)
            {
              m = 0;
              while (m < this.length)
              {
                arrayOfInt[m] ^= this.matrix[i][m];
                m += 1;
              }
            }
            m = i + 1;
            i1 = k << 1;
            i = m;
            k = i1;
          } while (i1 != 0);
          j += 1;
        }
        while (k != 1 << (i3 & 0x1F))
        {
          if ((paramVector[i2] & k) != 0)
          {
            i = 0;
            while (i < this.length)
            {
              arrayOfInt[i] ^= this.matrix[m][i];
              i += 1;
            }
          }
          m += 1;
          k <<= 1;
        }
        return new GF2Vector(arrayOfInt, this.numColumns);
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("vector is not defined over GF(2)");
  }
  
  public Vector leftMultiplyLeftCompactForm(Vector paramVector)
  {
    if ((paramVector instanceof GF2Vector))
    {
      if (paramVector.length == this.numRows)
      {
        paramVector = ((GF2Vector)paramVector).getVecArray();
        int[] arrayOfInt = new int[this.numRows + this.numColumns + 31 >>> 5];
        int i1 = this.numRows >>> 5;
        int j = 0;
        int k;
        for (int i = 0; j < i1; i = m)
        {
          k = 1;
          int n;
          do
          {
            if ((paramVector[j] & k) != 0)
            {
              m = 0;
              while (m < this.length)
              {
                arrayOfInt[m] ^= this.matrix[i][m];
                m += 1;
              }
              m = this.numColumns + i >>> 5;
              arrayOfInt[m] = (1 << (this.numColumns + i & 0x1F) | arrayOfInt[m]);
            }
            m = i + 1;
            n = k << 1;
            i = m;
            k = n;
          } while (n != 0);
          j += 1;
        }
        int m = this.numRows;
        j = 1;
        while (j != 1 << (m & 0x1F))
        {
          if ((paramVector[i1] & j) != 0)
          {
            k = 0;
            while (k < this.length)
            {
              arrayOfInt[k] ^= this.matrix[i][k];
              k += 1;
            }
            k = this.numColumns + i >>> 5;
            arrayOfInt[k] = (1 << (this.numColumns + i & 0x1F) | arrayOfInt[k]);
          }
          i += 1;
          j <<= 1;
        }
        return new GF2Vector(arrayOfInt, this.numRows + this.numColumns);
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("vector is not defined over GF(2)");
  }
  
  public Matrix rightMultiply(Matrix paramMatrix)
  {
    if ((paramMatrix instanceof GF2Matrix))
    {
      if (paramMatrix.numRows == this.numColumns)
      {
        GF2Matrix localGF2Matrix = (GF2Matrix)paramMatrix;
        paramMatrix = new GF2Matrix(this.numRows, paramMatrix.numColumns);
        int i2 = this.numColumns & 0x1F;
        int j = this.length;
        if (i2 != 0) {
          j -= 1;
        }
        int k = 0;
        while (k < this.numRows)
        {
          int m = 0;
          int i = 0;
          int n;
          int[] arrayOfInt;
          while (m < j)
          {
            int i3 = this.matrix[k][m];
            n = 0;
            while (n < 32)
            {
              if ((1 << n & i3) != 0)
              {
                i1 = 0;
                while (i1 < localGF2Matrix.length)
                {
                  arrayOfInt = paramMatrix.matrix[k];
                  arrayOfInt[i1] ^= localGF2Matrix.matrix[i][i1];
                  i1 += 1;
                }
              }
              i += 1;
              n += 1;
            }
            m += 1;
          }
          int i1 = this.matrix[k][(this.length - 1)];
          m = 0;
          while (m < i2)
          {
            if ((1 << m & i1) != 0)
            {
              n = 0;
              while (n < localGF2Matrix.length)
              {
                arrayOfInt = paramMatrix.matrix[k];
                arrayOfInt[n] ^= localGF2Matrix.matrix[i][n];
                n += 1;
              }
            }
            i += 1;
            m += 1;
          }
          k += 1;
        }
        return paramMatrix;
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("matrix is not defined over GF(2)");
  }
  
  public Matrix rightMultiply(Permutation paramPermutation)
  {
    paramPermutation = paramPermutation.getVector();
    if (paramPermutation.length == this.numColumns)
    {
      GF2Matrix localGF2Matrix = new GF2Matrix(this.numRows, this.numColumns);
      int i = this.numColumns - 1;
      while (i >= 0)
      {
        int k = i >>> 5;
        int m = paramPermutation[i];
        int n = paramPermutation[i];
        int j = this.numRows - 1;
        while (j >= 0)
        {
          int[] arrayOfInt = localGF2Matrix.matrix[j];
          arrayOfInt[k] |= (this.matrix[j][(m >>> 5)] >>> (n & 0x1F) & 0x1) << (i & 0x1F);
          j -= 1;
        }
        i -= 1;
      }
      return localGF2Matrix;
    }
    throw new ArithmeticException("length mismatch");
  }
  
  public Vector rightMultiply(Vector paramVector)
  {
    if ((paramVector instanceof GF2Vector))
    {
      if (paramVector.length == this.numColumns)
      {
        paramVector = ((GF2Vector)paramVector).getVecArray();
        int[] arrayOfInt = new int[this.numRows + 31 >>> 5];
        int i = 0;
        while (i < this.numRows)
        {
          int k = 0;
          int j = 0;
          while (k < this.length)
          {
            j ^= this.matrix[i][k] & paramVector[k];
            k += 1;
          }
          k = 0;
          int m = 0;
          while (k < 32)
          {
            m ^= j >>> k & 0x1;
            k += 1;
          }
          if (m == 1)
          {
            j = i >>> 5;
            arrayOfInt[j] |= 1 << (i & 0x1F);
          }
          i += 1;
        }
        return new GF2Vector(arrayOfInt, this.numRows);
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("vector is not defined over GF(2)");
  }
  
  public Vector rightMultiplyRightCompactForm(Vector paramVector)
  {
    if ((paramVector instanceof GF2Vector))
    {
      if (paramVector.length == this.numColumns + this.numRows)
      {
        paramVector = ((GF2Vector)paramVector).getVecArray();
        int[] arrayOfInt = new int[this.numRows + 31 >>> 5];
        int i3 = this.numRows;
        int i4 = this.numRows & 0x1F;
        int k = 0;
        while (k < this.numRows)
        {
          int i5 = k >> 5;
          int i = paramVector[i5];
          int i6 = k & 0x1F;
          int j = i >>> i6 & 0x1;
          int i1 = i3 >> 5;
          int m = 0;
          int i2 = 0;
          i = j;
          int n = i1;
          if (i4 != 0)
          {
            m = i2;
            i = j;
            while (m < this.length - 1)
            {
              j = i1 + 1;
              i ^= (paramVector[i1] >>> i4 | paramVector[j] << 32 - i4) & this.matrix[k][m];
              m += 1;
              i1 = j;
            }
            n = i1 + 1;
            m = paramVector[i1] >>> i4;
            j = m;
            if (n < paramVector.length) {
              j = m | paramVector[n] << 32 - i4;
            }
            j = i ^ this.matrix[k][(this.length - 1)] & j;
          }
          else
          {
            for (;;)
            {
              j = i;
              if (m >= this.length) {
                break;
              }
              j = this.matrix[k][m];
              i ^= paramVector[n] & j;
              m += 1;
              n += 1;
            }
          }
          i = 0;
          m = 0;
          while (i < 32)
          {
            m ^= j & 0x1;
            j >>>= 1;
            i += 1;
          }
          if (m == 1) {
            arrayOfInt[i5] |= 1 << i6;
          }
          k += 1;
        }
        return new GF2Vector(arrayOfInt, this.numRows);
      }
      throw new ArithmeticException("length mismatch");
    }
    throw new ArithmeticException("vector is not defined over GF(2)");
  }
  
  public String toString()
  {
    int n = this.numColumns & 0x1F;
    int i = this.length;
    if (n != 0) {
      i -= 1;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = 0;
    while (j < this.numRows)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(j);
      localStringBuilder.append(": ");
      localStringBuffer.append(localStringBuilder.toString());
      int k = 0;
      while (k < i)
      {
        int i1 = this.matrix[j][k];
        m = 0;
        while (m < 32)
        {
          if ((i1 >>> m & 0x1) == 0) {
            localStringBuffer.append('0');
          } else {
            localStringBuffer.append('1');
          }
          m += 1;
        }
        localStringBuffer.append(' ');
        k += 1;
      }
      int m = this.matrix[j][(this.length - 1)];
      k = 0;
      while (k < n)
      {
        if ((m >>> k & 0x1) == 0) {
          localStringBuffer.append('0');
        } else {
          localStringBuffer.append('1');
        }
        k += 1;
      }
      localStringBuffer.append('\n');
      j += 1;
    }
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2Matrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */