package org.bouncycastle.pqc.math.linearalgebra;

import java.math.BigInteger;

public abstract interface GFElement
{
  public abstract GFElement add(GFElement paramGFElement)
    throws RuntimeException;
  
  public abstract void addToThis(GFElement paramGFElement)
    throws RuntimeException;
  
  public abstract Object clone();
  
  public abstract boolean equals(Object paramObject);
  
  public abstract int hashCode();
  
  public abstract GFElement invert()
    throws ArithmeticException;
  
  public abstract boolean isOne();
  
  public abstract boolean isZero();
  
  public abstract GFElement multiply(GFElement paramGFElement)
    throws RuntimeException;
  
  public abstract void multiplyThisBy(GFElement paramGFElement)
    throws RuntimeException;
  
  public abstract GFElement subtract(GFElement paramGFElement)
    throws RuntimeException;
  
  public abstract void subtractFromThis(GFElement paramGFElement);
  
  public abstract byte[] toByteArray();
  
  public abstract BigInteger toFlexiBigInt();
  
  public abstract String toString();
  
  public abstract String toString(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GFElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */