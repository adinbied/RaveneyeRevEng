package org.bouncycastle.crypto.engines;

import org.bouncycastle.util.Pack;

public class ChaCha7539Engine
  extends Salsa20Engine
{
  protected void advanceCounter()
  {
    int[] arrayOfInt = this.engineState;
    int i = arrayOfInt[12] + 1;
    arrayOfInt[12] = i;
    if (i != 0) {
      return;
    }
    throw new IllegalStateException("attempt to increase counter past 2^32.");
  }
  
  protected void advanceCounter(long paramLong)
  {
    int j = (int)(paramLong >>> 32);
    int i = (int)paramLong;
    if (j <= 0)
    {
      j = this.engineState[12];
      int[] arrayOfInt = this.engineState;
      arrayOfInt[12] += i;
      if (j != 0)
      {
        if (this.engineState[12] >= j) {
          return;
        }
        throw new IllegalStateException("attempt to increase counter past 2^32.");
      }
      return;
    }
    throw new IllegalStateException("attempt to increase counter past 2^32.");
  }
  
  protected void generateKeyStream(byte[] paramArrayOfByte)
  {
    ChaChaEngine.chachaCore(this.rounds, this.engineState, this.x);
    Pack.intToLittleEndian(this.x, paramArrayOfByte, 0);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChaCha7539-");
    localStringBuilder.append(this.rounds);
    return localStringBuilder.toString();
  }
  
  protected long getCounter()
  {
    return this.engineState[12] & 0xFFFFFFFF;
  }
  
  protected int getNonceSize()
  {
    return 12;
  }
  
  protected void resetCounter()
  {
    this.engineState[12] = 0;
  }
  
  protected void retreatCounter()
  {
    if (this.engineState[12] != 0)
    {
      int[] arrayOfInt = this.engineState;
      arrayOfInt[12] -= 1;
      return;
    }
    throw new IllegalStateException("attempt to reduce counter past zero.");
  }
  
  protected void retreatCounter(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    if (i == 0)
    {
      if ((this.engineState[12] & 0xFFFFFFFF) >= (0xFFFFFFFF & j))
      {
        int[] arrayOfInt = this.engineState;
        arrayOfInt[12] -= j;
        return;
      }
      throw new IllegalStateException("attempt to reduce counter past zero.");
    }
    throw new IllegalStateException("attempt to reduce counter past zero.");
  }
  
  protected void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null) {
      if (paramArrayOfByte1.length == 32)
      {
        packTauOrSigma(paramArrayOfByte1.length, this.engineState, 0);
        Pack.littleEndianToInt(paramArrayOfByte1, 0, this.engineState, 4, 8);
      }
      else
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append(getAlgorithmName());
        paramArrayOfByte1.append(" requires 256 bit key");
        throw new IllegalArgumentException(paramArrayOfByte1.toString());
      }
    }
    Pack.littleEndianToInt(paramArrayOfByte2, 0, this.engineState, 13, 3);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\ChaCha7539Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */