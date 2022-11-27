package org.bouncycastle.pqc.math.linearalgebra;

public abstract class Matrix
{
  public static final char MATRIX_TYPE_RANDOM_LT = 'L';
  public static final char MATRIX_TYPE_RANDOM_REGULAR = 'R';
  public static final char MATRIX_TYPE_RANDOM_UT = 'U';
  public static final char MATRIX_TYPE_UNIT = 'I';
  public static final char MATRIX_TYPE_ZERO = 'Z';
  protected int numColumns;
  protected int numRows;
  
  public abstract Matrix computeInverse();
  
  public abstract byte[] getEncoded();
  
  public int getNumColumns()
  {
    return this.numColumns;
  }
  
  public int getNumRows()
  {
    return this.numRows;
  }
  
  public abstract boolean isZero();
  
  public abstract Vector leftMultiply(Vector paramVector);
  
  public abstract Matrix rightMultiply(Matrix paramMatrix);
  
  public abstract Matrix rightMultiply(Permutation paramPermutation);
  
  public abstract Vector rightMultiply(Vector paramVector);
  
  public abstract String toString();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\Matrix.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */