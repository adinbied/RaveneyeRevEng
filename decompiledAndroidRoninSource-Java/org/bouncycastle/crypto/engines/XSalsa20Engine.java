package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

public class XSalsa20Engine
  extends Salsa20Engine
{
  public String getAlgorithmName()
  {
    return "XSalsa20";
  }
  
  protected int getNonceSize()
  {
    return 24;
  }
  
  protected void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte1.length == 32)
      {
        super.setKey(paramArrayOfByte1, paramArrayOfByte2);
        Pack.littleEndianToInt(paramArrayOfByte2, 8, this.engineState, 8, 2);
        paramArrayOfByte1 = new int[this.engineState.length];
        salsaCore(20, this.engineState, paramArrayOfByte1);
        this.engineState[1] = (paramArrayOfByte1[0] - this.engineState[0]);
        this.engineState[2] = (paramArrayOfByte1[5] - this.engineState[5]);
        this.engineState[3] = (paramArrayOfByte1[10] - this.engineState[10]);
        this.engineState[4] = (paramArrayOfByte1[15] - this.engineState[15]);
        this.engineState[11] = (paramArrayOfByte1[6] - this.engineState[6]);
        this.engineState[12] = (paramArrayOfByte1[7] - this.engineState[7]);
        this.engineState[13] = (paramArrayOfByte1[8] - this.engineState[8]);
        this.engineState[14] = (paramArrayOfByte1[9] - this.engineState[9]);
        Pack.littleEndianToInt(paramArrayOfByte2, 16, this.engineState, 6, 2);
        return;
      }
      paramArrayOfByte1 = new StringBuilder();
      paramArrayOfByte1.append(getAlgorithmName());
      paramArrayOfByte1.append(" requires a 256 bit key");
      throw new IllegalArgumentException(paramArrayOfByte1.toString());
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append(getAlgorithmName());
    paramArrayOfByte1.append(" doesn't support re-init with null key");
    throw new IllegalArgumentException(paramArrayOfByte1.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\XSalsa20Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */