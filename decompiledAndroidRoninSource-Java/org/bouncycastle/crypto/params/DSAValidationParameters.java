package org.bouncycastle.crypto.params;

import org.bouncycastle.util.Arrays;

public class DSAValidationParameters
{
  private int counter;
  private byte[] seed;
  private int usageIndex;
  
  public DSAValidationParameters(byte[] paramArrayOfByte, int paramInt)
  {
    this(paramArrayOfByte, paramInt, -1);
  }
  
  public DSAValidationParameters(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.seed = paramArrayOfByte;
    this.counter = paramInt1;
    this.usageIndex = paramInt2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DSAValidationParameters)) {
      return false;
    }
    paramObject = (DSAValidationParameters)paramObject;
    if (((DSAValidationParameters)paramObject).counter != this.counter) {
      return false;
    }
    return Arrays.areEqual(this.seed, ((DSAValidationParameters)paramObject).seed);
  }
  
  public int getCounter()
  {
    return this.counter;
  }
  
  public byte[] getSeed()
  {
    return this.seed;
  }
  
  public int getUsageIndex()
  {
    return this.usageIndex;
  }
  
  public int hashCode()
  {
    return this.counter ^ Arrays.hashCode(this.seed);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAValidationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */