package org.bouncycastle.pqc.math.linearalgebra;

public abstract class GF2nElement
  implements GFElement
{
  protected int mDegree;
  protected GF2nField mField;
  
  abstract void assignOne();
  
  abstract void assignZero();
  
  public abstract Object clone();
  
  public final GF2nElement convert(GF2nField paramGF2nField)
    throws RuntimeException
  {
    return this.mField.convert(this, paramGF2nField);
  }
  
  public final GF2nField getField()
  {
    return this.mField;
  }
  
  public abstract GF2nElement increase();
  
  public abstract void increaseThis();
  
  public abstract GF2nElement solveQuadraticEquation()
    throws RuntimeException;
  
  public abstract GF2nElement square();
  
  public abstract GF2nElement squareRoot();
  
  public abstract void squareRootThis();
  
  public abstract void squareThis();
  
  public final GFElement subtract(GFElement paramGFElement)
    throws RuntimeException
  {
    return add(paramGFElement);
  }
  
  public final void subtractFromThis(GFElement paramGFElement)
  {
    addToThis(paramGFElement);
  }
  
  abstract boolean testBit(int paramInt);
  
  public abstract boolean testRightmostBit();
  
  public abstract int trace();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\GF2nElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */