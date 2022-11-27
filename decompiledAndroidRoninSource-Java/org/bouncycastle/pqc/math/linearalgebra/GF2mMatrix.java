package org.bouncycastle.pqc.math.linearalgebra;

import java.lang.reflect.Array;

public class GF2mMatrix
  extends Matrix
{
  protected GF2mField field;
  protected int[][] matrix;
  
  public GF2mMatrix(GF2mField paramGF2mField, byte[] paramArrayOfByte)
  {
    this.field = paramGF2mField;
    int i = 8;
    int j = 1;
    while (paramGF2mField.getDegree() > i)
    {
      j += 1;
      i += 8;
    }
    if (paramArrayOfByte.length >= 5)
    {
      this.numRows = ((paramArrayOfByte[3] & 0xFF) << 24 ^ (paramArrayOfByte[2] & 0xFF) << 16 ^ (paramArrayOfByte[1] & 0xFF) << 8 ^ paramArrayOfByte[0] & 0xFF);
      j *= this.numRows;
      if (this.numRows > 0)
      {
        int k = paramArrayOfByte.length;
        int m = 4;
        if ((k - 4) % j == 0)
        {
          this.numColumns = ((paramArrayOfByte.length - 4) / j);
          this.matrix = ((int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.numColumns }));
          j = 0;
          while (j < this.numRows)
          {
            k = 0;
            while (k < this.numColumns)
            {
              int n = 0;
              while (n < i)
              {
                paramGF2mField = this.matrix[j];
                int i1 = paramGF2mField[k];
                paramGF2mField[k] = ((paramArrayOfByte[m] & 0xFF) << n ^ i1);
                n += 8;
                m += 1;
              }
              if (this.field.isElementOfThisField(this.matrix[j][k])) {
                k += 1;
              } else {
                throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
              }
            }
            j += 1;
          }
          return;
        }
      }
      throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
    }
    throw new IllegalArgumentException(" Error: given array is not encoded matrix over GF(2^m)");
  }
  
  protected GF2mMatrix(GF2mField paramGF2mField, int[][] paramArrayOfInt)
  {
    this.field = paramGF2mField;
    this.matrix = paramArrayOfInt;
    this.numRows = paramArrayOfInt.length;
    this.numColumns = paramArrayOfInt[0].length;
  }
  
  public GF2mMatrix(GF2mMatrix paramGF2mMatrix)
  {
    this.numRows = paramGF2mMatrix.numRows;
    this.numColumns = paramGF2mMatrix.numColumns;
    this.field = paramGF2mMatrix.field;
    this.matrix = new int[this.numRows][];
    int i = 0;
    while (i < this.numRows)
    {
      this.matrix[i] = IntUtils.clone(paramGF2mMatrix.matrix[i]);
      i += 1;
    }
  }
  
  private void addToRow(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = paramArrayOfInt2.length - 1;
    while (i >= 0)
    {
      paramArrayOfInt2[i] = this.field.add(paramArrayOfInt1[i], paramArrayOfInt2[i]);
      i -= 1;
    }
  }
  
  private int[] multRowWithElement(int[] paramArrayOfInt, int paramInt)
  {
    int[] arrayOfInt = new int[paramArrayOfInt.length];
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      arrayOfInt[i] = this.field.mult(paramArrayOfInt[i], paramInt);
      i -= 1;
    }
    return arrayOfInt;
  }
  
  private void multRowWithElementThis(int[] paramArrayOfInt, int paramInt)
  {
    int i = paramArrayOfInt.length - 1;
    while (i >= 0)
    {
      paramArrayOfInt[i] = this.field.mult(paramArrayOfInt[i], paramInt);
      i -= 1;
    }
  }
  
  private static void swapColumns(int[][] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = paramArrayOfInt[paramInt1];
    paramArrayOfInt[paramInt1] = paramArrayOfInt[paramInt2];
    paramArrayOfInt[paramInt2] = arrayOfInt;
  }
  
  public Matrix computeInverse()
  {
    if (this.numRows == this.numColumns)
    {
      int[][] arrayOfInt1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.numRows });
      int i = this.numRows - 1;
      while (i >= 0)
      {
        arrayOfInt1[i] = IntUtils.clone(this.matrix[i]);
        i -= 1;
      }
      int[][] arrayOfInt2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { this.numRows, this.numRows });
      i = this.numRows - 1;
      while (i >= 0)
      {
        arrayOfInt2[i][i] = 1;
        i -= 1;
      }
      int j = 0;
      while (j < this.numRows)
      {
        int k;
        if (arrayOfInt1[j][j] == 0)
        {
          i = j + 1;
          k = 0;
          while (i < this.numRows)
          {
            int m = i;
            if (arrayOfInt1[i][j] != 0)
            {
              swapColumns(arrayOfInt1, j, i);
              swapColumns(arrayOfInt2, j, i);
              m = this.numRows;
              k = 1;
            }
            i = m + 1;
          }
          if (k == 0) {
            throw new ArithmeticException("Matrix is not invertible.");
          }
        }
        i = arrayOfInt1[j][j];
        i = this.field.inverse(i);
        multRowWithElementThis(arrayOfInt1[j], i);
        multRowWithElementThis(arrayOfInt2[j], i);
        i = 0;
        while (i < this.numRows)
        {
          if (i != j)
          {
            k = arrayOfInt1[i][j];
            if (k != 0)
            {
              int[] arrayOfInt3 = multRowWithElement(arrayOfInt1[j], k);
              int[] arrayOfInt4 = multRowWithElement(arrayOfInt2[j], k);
              addToRow(arrayOfInt3, arrayOfInt1[i]);
              addToRow(arrayOfInt4, arrayOfInt2[i]);
            }
          }
          i += 1;
        }
        j += 1;
      }
      return new GF2mMatrix(this.field, arrayOfInt2);
    }
    throw new ArithmeticException("Matrix is not invertible.");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject != null)
    {
      if (!(paramObject instanceof GF2mMatrix)) {
        return false;
      }
      paramObject = (GF2mMatrix)paramObject;
      if ((this.field.equals(((GF2mMatrix)paramObject).field)) && (((GF2mMatrix)paramObject).numRows == this.numColumns))
      {
        if (((GF2mMatrix)paramObject).numColumns != this.numColumns) {
          return false;
        }
        int i = 0;
        while (i < this.numRows)
        {
          int j = 0;
          while (j < this.numColumns)
          {
            if (this.matrix[i][j] != paramObject.matrix[i][j]) {
              return false;
            }
            j += 1;
          }
          i += 1;
        }
        return true;
      }
    }
    return false;
  }
  
  public byte[] getEncoded()
  {
    int i = 8;
    int j = 1;
    while (this.field.getDegree() > i)
    {
      j += 1;
      i += 8;
    }
    int k = this.numRows;
    int n = this.numColumns;
    int m = 4;
    byte[] arrayOfByte = new byte[k * n * j + 4];
    arrayOfByte[0] = ((byte)(this.numRows & 0xFF));
    arrayOfByte[1] = ((byte)(this.numRows >>> 8 & 0xFF));
    arrayOfByte[2] = ((byte)(this.numRows >>> 16 & 0xFF));
    arrayOfByte[3] = ((byte)(this.numRows >>> 24 & 0xFF));
    j = 0;
    while (j < this.numRows)
    {
      k = 0;
      while (k < this.numColumns)
      {
        n = 0;
        while (n < i)
        {
          arrayOfByte[m] = ((byte)(this.matrix[j][k] >>> n));
          n += 8;
          m += 1;
        }
        k += 1;
      }
      j += 1;
    }
    return arrayOfByte;
  }
  
  public int hashCode()
  {
    int j = (this.field.hashCode() * 31 + this.numRows) * 31 + this.numColumns;
    int i = 0;
    while (i < this.numRows)
    {
      int k = 0;
      while (k < this.numColumns)
      {
        j = j * 31 + this.matrix[i][k];
        k += 1;
      }
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
      while (j < this.numColumns)
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
  
  public Vector leftMultiply(Vector paramVector)
  {
    throw new RuntimeException("Not implemented.");
  }
  
  public Matrix rightMultiply(Matrix paramMatrix)
  {
    throw new RuntimeException("Not implemented.");
  }
  
  public Matrix rightMultiply(Permutation paramPermutation)
  {
    throw new RuntimeException("Not implemented.");
  }
  
  public Vector rightMultiply(Vector paramVector)
  {
    throw new RuntimeException("Not implemented.");
  }
  
  public String toString()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.numRows);
    ((StringBuilder)localObject).append(" x ");
    ((StringBuilder)localObject).append(this.numColumns);
    ((StringBuilder)localObject).append(" Matrix over ");
    ((StringBuilder)localObject).append(this.field.toString());
    ((StringBuilder)localObject).append(": \n");
    localObject = ((StringBuilder)localObject).toString();
    int i = 0;
    while (i < this.numRows)
    {
      int j = 0;
      while (j < this.numColumns)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(this.field.elementToStr(this.matrix[i][j]));
        localStringBuilder.append(" : ");
        localObject = localStringBuilder.toString();
        j += 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      localObject = localStringBuilder.toString();
      i += 1;
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2mMatrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */