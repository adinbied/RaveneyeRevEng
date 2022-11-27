package org.bouncycastle.math.field;

import org.bouncycastle.util.Arrays;

class GF2Polynomial
  implements Polynomial
{
  protected final int[] exponents;
  
  GF2Polynomial(int[] paramArrayOfInt)
  {
    this.exponents = Arrays.clone(paramArrayOfInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof GF2Polynomial)) {
      return false;
    }
    paramObject = (GF2Polynomial)paramObject;
    return Arrays.areEqual(this.exponents, ((GF2Polynomial)paramObject).exponents);
  }
  
  public int getDegree()
  {
    int[] arrayOfInt = this.exponents;
    return arrayOfInt[(arrayOfInt.length - 1)];
  }
  
  public int[] getExponentsPresent()
  {
    return Arrays.clone(this.exponents);
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.exponents);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\field\GF2Polynomial.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */