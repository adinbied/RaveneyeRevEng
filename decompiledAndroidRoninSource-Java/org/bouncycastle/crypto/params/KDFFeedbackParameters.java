package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.util.Arrays;

public final class KDFFeedbackParameters
  implements DerivationParameters
{
  private static final int UNUSED_R = -1;
  private final byte[] fixedInputData;
  private final byte[] iv;
  private final byte[] ki;
  private final int r;
  private final boolean useCounter;
  
  private KDFFeedbackParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      this.ki = Arrays.clone(paramArrayOfByte1);
      if (paramArrayOfByte3 == null) {
        this.fixedInputData = new byte[0];
      } else {
        this.fixedInputData = Arrays.clone(paramArrayOfByte3);
      }
      this.r = paramInt;
      if (paramArrayOfByte2 == null) {
        this.iv = new byte[0];
      } else {
        this.iv = Arrays.clone(paramArrayOfByte2);
      }
      this.useCounter = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("A KDF requires Ki (a seed) as input");
  }
  
  public static KDFFeedbackParameters createWithCounter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, int paramInt)
  {
    if ((paramInt != 8) && (paramInt != 16) && (paramInt != 24) && (paramInt != 32)) {
      throw new IllegalArgumentException("Length of counter should be 8, 16, 24 or 32");
    }
    return new KDFFeedbackParameters(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, paramInt, true);
  }
  
  public static KDFFeedbackParameters createWithoutCounter(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return new KDFFeedbackParameters(paramArrayOfByte1, paramArrayOfByte2, paramArrayOfByte3, -1, false);
  }
  
  public byte[] getFixedInputData()
  {
    return Arrays.clone(this.fixedInputData);
  }
  
  public byte[] getIV()
  {
    return this.iv;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\KDFFeedbackParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */