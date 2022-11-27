package org.bouncycastle.pqc.math.linearalgebra;

public abstract class Vector
{
  protected int length;
  
  public abstract Vector add(Vector paramVector);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract byte[] getEncoded();
  
  public final int getLength()
  {
    return this.length;
  }
  
  public abstract int hashCode();
  
  public abstract boolean isZero();
  
  public abstract Vector multiply(Permutation paramPermutation);
  
  public abstract String toString();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\Vector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */