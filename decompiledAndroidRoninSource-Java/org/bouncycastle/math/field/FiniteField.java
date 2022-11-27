package org.bouncycastle.math.field;

import java.math.BigInteger;

public abstract interface FiniteField
{
  public abstract BigInteger getCharacteristic();
  
  public abstract int getDimension();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\field\FiniteField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */