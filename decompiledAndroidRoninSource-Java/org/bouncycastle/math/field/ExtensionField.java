package org.bouncycastle.math.field;

public abstract interface ExtensionField
  extends FiniteField
{
  public abstract int getDegree();
  
  public abstract FiniteField getSubfield();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\field\ExtensionField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */