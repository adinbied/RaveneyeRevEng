package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

class MacCFBBlockCipher
{
  private byte[] IV;
  private int blockSize;
  private byte[] cfbOutV;
  private byte[] cfbV;
  private BlockCipher cipher = null;
  
  public MacCFBBlockCipher(BlockCipher paramBlockCipher, int paramInt)
  {
    this.cipher = paramBlockCipher;
    this.blockSize = (paramInt / 8);
    this.IV = new byte[paramBlockCipher.getBlockSize()];
    this.cfbV = new byte[paramBlockCipher.getBlockSize()];
    this.cfbOutV = new byte[paramBlockCipher.getBlockSize()];
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/CFB");
    localStringBuilder.append(this.blockSize * 8);
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.blockSize;
  }
  
  void getMacBlock(byte[] paramArrayOfByte)
  {
    this.cipher.processBlock(this.cfbV, 0, paramArrayOfByte, 0);
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    Object localObject1;
    Object localObject2;
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      localObject1 = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject1).getIV();
      int i = paramCipherParameters.length;
      localObject2 = this.IV;
      if (i < localObject2.length) {
        System.arraycopy(paramCipherParameters, 0, localObject2, localObject2.length - paramCipherParameters.length, paramCipherParameters.length);
      } else {
        System.arraycopy(paramCipherParameters, 0, localObject2, 0, localObject2.length);
      }
      reset();
      paramCipherParameters = this.cipher;
      localObject1 = ((ParametersWithIV)localObject1).getParameters();
    }
    else
    {
      reset();
      localObject2 = this.cipher;
      localObject1 = paramCipherParameters;
      paramCipherParameters = (CipherParameters)localObject2;
    }
    paramCipherParameters.init(true, (CipherParameters)localObject1);
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.blockSize;
    if (paramInt1 + i <= paramArrayOfByte1.length)
    {
      if (i + paramInt2 <= paramArrayOfByte2.length)
      {
        this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
        i = 0;
        int j;
        for (;;)
        {
          j = this.blockSize;
          if (i >= j) {
            break;
          }
          paramArrayOfByte2[(paramInt2 + i)] = ((byte)(this.cfbOutV[i] ^ paramArrayOfByte1[(paramInt1 + i)]));
          i += 1;
        }
        paramArrayOfByte1 = this.cfbV;
        System.arraycopy(paramArrayOfByte1, j, paramArrayOfByte1, 0, paramArrayOfByte1.length - j);
        paramArrayOfByte1 = this.cfbV;
        paramInt1 = paramArrayOfByte1.length;
        i = this.blockSize;
        System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1 - i, i);
        return this.blockSize;
      }
      throw new DataLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  public void reset()
  {
    byte[] arrayOfByte = this.IV;
    System.arraycopy(arrayOfByte, 0, this.cfbV, 0, arrayOfByte.length);
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\MacCFBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */