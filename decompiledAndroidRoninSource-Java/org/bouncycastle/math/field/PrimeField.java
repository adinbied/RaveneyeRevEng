package org.bouncycastle.math.field;

import java.math.BigInteger;

class PrimeField
  implements FiniteField
{
  protected final BigInteger characteristic;
  
  PrimeField(BigInteger paramBigInteger)
  {
    this.characteristic = paramBigInteger;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof PrimeField)) {
      return false;
    }
    paramObject = (PrimeField)paramObject;
    return this.characteristic.equals(((PrimeField)paramObject).characteristic);
  }
  
  public BigInteger getCharacteristic()
  {
    return this.characteristic;
  }
  
  public int getDimension()
  {
    return 1;
  }
  
  public int hashCode()
  {
    return this.characteristic.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\field\PrimeField.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */