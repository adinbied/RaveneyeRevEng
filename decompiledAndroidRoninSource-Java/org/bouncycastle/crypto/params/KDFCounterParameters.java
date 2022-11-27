package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFCounterParameters
  implements DerivationParameters
{
  private byte[] fixedInputDataCounterPrefix;
  private byte[] fixedInputDataCounterSuffix;
  private byte[] ki;
  private int r;
  
  public KDFCounterParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    this(paramArrayOfByte1, null, paramArrayOfByte2, paramInt);
  }
  
  public KDFCounterParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    if (paramArrayOfByte1 != null)
    {
      this.ki = Arrays.clone(paramArrayOfByte1);
      if (paramArrayOfByte2 == null) {
        this.fixedInputDataCounterPrefix = new byte[0];
      } else {
        this.fixedInputDataCounterPrefix = Arrays.clone(paramArrayOfByte2);
      }
      if (paramArrayOfByte3 == null) {
        this.fixedInputDataCounterSuffix = new byte[0];
      } else {
        this.fixedInputDataCounterSuffix = Arrays.clone(paramArrayOfByte3);
      }
      if ((paramInt != 8) && (paramInt != 16) && (paramInt != 24) && (paramInt != 32)) {
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
      }
      this.r = paramInt;
      return;
    }
    throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
  }
  
  public byte[] getFixedInputData()
  {
    return Arrays.clone(this.fixedInputDataCounterSuffix);
  }
  
  public byte[] getFixedInputDataCounterPrefix()
  {
    return Arrays.clone(this.fixedInputDataCounterPrefix);
  }
  
  public byte[] getFixedInputDataCounterSuffix()
  {
    return Arrays.clone(this.fixedInputDataCounterSuffix);
  }
  
  public byte[] getKI()
  {
    return this.ki;
  }
  
  public int getR()
  {
    return this.r;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\KDFCounterParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */