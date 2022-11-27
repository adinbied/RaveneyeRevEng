package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;

public class NullEngine
  implements BlockCipher
{
  protected static final int DEFAULT_BLOCK_SIZE = 1;
  private final int blockSize;
  private boolean initialised;
  
  public NullEngine()
  {
    this(1);
  }
  
  public NullEngine(int paramInt)
  {
    this.blockSize = paramInt;
  }
  
  public String getAlgorithmName()
  {
    return "Null";
  }
  
  public int getBlockSize()
  {
    return this.blockSize;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.initialised = true;
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.initialised)
    {
      int i = this.blockSize;
      if (paramInt1 + i <= paramArrayOfByte1.length)
      {
        if (i + paramInt2 <= paramArrayOfByte2.length)
        {
          i = 0;
          int j;
          for (;;)
          {
            j = this.blockSize;
            if (i >= j) {
              break;
            }
            paramArrayOfByte2[(paramInt2 + i)] = paramArrayOfByte1[(paramInt1 + i)];
            i += 1;
          }
          return j;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("Null engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\NullEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */