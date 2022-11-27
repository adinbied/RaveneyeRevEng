package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFDoublePipelineIterationParameters
  implements DerivationParameters
{
  private static final int UNUSED_R = 32;
  private final byte[] fixedInputData;
  private final byte[] ki;
  private final int r;
  private final boolean useCounter;
  
  private KDFDoublePipelineIterationParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      this.ki = Arrays.clone(paramArrayOfByte1);
      if (paramArrayOfByte2 == null) {
        this.fixedInputData = new byte[0];
      } else {
        this.fixedInputData = Arrays.clone(paramArrayOfByte2);
      }
      if ((paramInt != 8) && (paramInt != 16) && (paramInt != 24) && (paramInt != 32)) {
        throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
      }
      this.r = paramInt;
      this.useCounter = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
  }
  
  public static KDFDoublePipelineIterationParameters createWithCounter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    return new KDFDoublePipelineIterationParameters(paramArrayOfByte1, paramArrayOfByte2, paramInt, true);
  }
  
  public static KDFDoublePipelineIterationParameters createWithoutCounter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return new KDFDoublePipelineIterationParameters(paramArrayOfByte1, paramArrayOfByte2, 32, false);
  }
  
  public byte[] getFixedInputData()
  {
    return Arrays.clone(this.fixedInputData);
  }
  
  public byte[] getKI()
  {
    return this.ki;
  }
  
  public int getR()
  {
    return this.r;
  }
  
  public boolean useCounter()
  {
    return this.useCounter;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\KDFDoublePipelineIterationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */