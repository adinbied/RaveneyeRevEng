package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class PGPCFBBlockCipher
  implements BlockCipher
{
  private byte[] FR;
  private byte[] FRE;
  private byte[] IV;
  private int blockSize;
  private BlockCipher cipher;
  private int count;
  private boolean forEncryption;
  private boolean inlineIv;
  private byte[] tmp;
  
  public PGPCFBBlockCipher(BlockCipher paramBlockCipher, boolean paramBoolean)
  {
    this.cipher = paramBlockCipher;
    this.inlineIv = paramBoolean;
    int i = paramBlockCipher.getBlockSize();
    this.blockSize = i;
    this.IV = new byte[i];
    this.FR = new byte[i];
    this.FRE = new byte[i];
    this.tmp = new byte[i];
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.blockSize;
    if (paramInt1 + i <= paramArrayOfByte1.length)
    {
      if (i + paramInt2 <= paramArrayOfByte2.length)
      {
        BlockCipher localBlockCipher = this.cipher;
        byte[] arrayOfByte1 = this.FR;
        byte[] arrayOfByte2 = this.FRE;
        int k = 0;
        localBlockCipher.processBlock(arrayOfByte1, 0, arrayOfByte2, 0);
        int j = 0;
        for (;;)
        {
          i = k;
          if (j >= this.blockSize) {
            break;
          }
          paramArrayOfByte2[(paramInt2 + j)] = encryptByte(paramArrayOfByte1[(paramInt1 + j)], j);
          j += 1;
        }
        for (;;)
        {
          paramInt2 = this.blockSize;
          if (i >= paramInt2) {
            break;
          }
          this.FR[i] = paramArrayOfByte1[(paramInt1 + i)];
          i += 1;
        }
        return paramInt2;
      }
      throw new DataLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private int decryptBlockWithIV(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.blockSize;
    if (paramInt1 + i <= paramArrayOfByte1.length)
    {
      if (paramInt2 + i <= paramArrayOfByte2.length)
      {
        int j = this.count;
        if (j == 0)
        {
          paramInt2 = 0;
          while (paramInt2 < this.blockSize)
          {
            this.FR[paramInt2] = paramArrayOfByte1[(paramInt1 + paramInt2)];
            paramInt2 += 1;
          }
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          this.count += this.blockSize;
          return 0;
        }
        if (j == i)
        {
          System.arraycopy(paramArrayOfByte1, paramInt1, this.tmp, 0, i);
          paramArrayOfByte1 = this.FR;
          System.arraycopy(paramArrayOfByte1, 2, paramArrayOfByte1, 0, this.blockSize - 2);
          paramArrayOfByte1 = this.FR;
          paramInt1 = this.blockSize;
          byte[] arrayOfByte = this.tmp;
          paramArrayOfByte1[(paramInt1 - 2)] = arrayOfByte[0];
          paramArrayOfByte1[(paramInt1 - 1)] = arrayOfByte[1];
          this.cipher.processBlock(paramArrayOfByte1, 0, this.FRE, 0);
          paramInt1 = 0;
          for (;;)
          {
            i = this.blockSize;
            if (paramInt1 >= i - 2) {
              break;
            }
            paramArrayOfByte2[(paramInt2 + paramInt1)] = encryptByte(this.tmp[(paramInt1 + 2)], paramInt1);
            paramInt1 += 1;
          }
          System.arraycopy(this.tmp, 2, this.FR, 0, i - 2);
          this.count += 2;
          return this.blockSize - 2;
        }
        if (j >= i + 2)
        {
          System.arraycopy(paramArrayOfByte1, paramInt1, this.tmp, 0, i);
          paramArrayOfByte2[(paramInt2 + 0)] = encryptByte(this.tmp[0], this.blockSize - 2);
          paramArrayOfByte2[(paramInt2 + 1)] = encryptByte(this.tmp[1], this.blockSize - 1);
          System.arraycopy(this.tmp, 0, this.FR, this.blockSize - 2, 2);
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          paramInt1 = 0;
          for (;;)
          {
            i = this.blockSize;
            if (paramInt1 >= i - 2) {
              break;
            }
            paramArrayOfByte2[(paramInt2 + paramInt1 + 2)] = encryptByte(this.tmp[(paramInt1 + 2)], paramInt1);
            paramInt1 += 1;
          }
          System.arraycopy(this.tmp, 2, this.FR, 0, i - 2);
        }
        return this.blockSize;
      }
      throw new DataLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.blockSize;
    if (paramInt1 + i <= paramArrayOfByte1.length)
    {
      if (i + paramInt2 <= paramArrayOfByte2.length)
      {
        BlockCipher localBlockCipher = this.cipher;
        byte[] arrayOfByte1 = this.FR;
        byte[] arrayOfByte2 = this.FRE;
        int k = 0;
        localBlockCipher.processBlock(arrayOfByte1, 0, arrayOfByte2, 0);
        int j = 0;
        for (;;)
        {
          i = k;
          if (j >= this.blockSize) {
            break;
          }
          paramArrayOfByte2[(paramInt2 + j)] = encryptByte(paramArrayOfByte1[(paramInt1 + j)], j);
          j += 1;
        }
        for (;;)
        {
          paramInt1 = this.blockSize;
          if (i >= paramInt1) {
            break;
          }
          this.FR[i] = paramArrayOfByte2[(paramInt2 + i)];
          i += 1;
        }
        return paramInt1;
      }
      throw new DataLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private int encryptBlockWithIV(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = this.blockSize;
    if (paramInt1 + i <= paramArrayOfByte1.length)
    {
      int j = this.count;
      if (j == 0)
      {
        if (i * 2 + paramInt2 + 2 <= paramArrayOfByte2.length)
        {
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          i = 0;
          for (;;)
          {
            j = this.blockSize;
            if (i >= j) {
              break;
            }
            paramArrayOfByte2[(paramInt2 + i)] = encryptByte(this.IV[i], i);
            i += 1;
          }
          System.arraycopy(paramArrayOfByte2, paramInt2, this.FR, 0, j);
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          i = this.blockSize;
          paramArrayOfByte2[(paramInt2 + i)] = encryptByte(this.IV[(i - 2)], 0);
          i = this.blockSize;
          paramArrayOfByte2[(paramInt2 + i + 1)] = encryptByte(this.IV[(i - 1)], 1);
          System.arraycopy(paramArrayOfByte2, paramInt2 + 2, this.FR, 0, this.blockSize);
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          i = 0;
          for (;;)
          {
            j = this.blockSize;
            if (i >= j) {
              break;
            }
            paramArrayOfByte2[(j + paramInt2 + 2 + i)] = encryptByte(paramArrayOfByte1[(paramInt1 + i)], i);
            i += 1;
          }
          System.arraycopy(paramArrayOfByte2, paramInt2 + j + 2, this.FR, 0, j);
          paramInt1 = this.count;
          paramInt2 = this.blockSize;
          this.count = (paramInt1 + (paramInt2 * 2 + 2));
          return paramInt2 * 2 + 2;
        }
        throw new DataLengthException("output buffer too short");
      }
      if (j >= i + 2) {
        if (i + paramInt2 <= paramArrayOfByte2.length)
        {
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          i = 0;
          for (;;)
          {
            j = this.blockSize;
            if (i >= j) {
              break;
            }
            paramArrayOfByte2[(paramInt2 + i)] = encryptByte(paramArrayOfByte1[(paramInt1 + i)], i);
            i += 1;
          }
          System.arraycopy(paramArrayOfByte2, paramInt2, this.FR, 0, j);
        }
        else
        {
          throw new DataLengthException("output buffer too short");
        }
      }
      return this.blockSize;
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private byte encryptByte(byte paramByte, int paramInt)
  {
    return (byte)(paramByte ^ this.FRE[paramInt]);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder;
    if (this.inlineIv)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.cipher.getAlgorithmName());
    }
    for (String str = "/PGPCFBwithIV";; str = "/PGPCFB")
    {
      localStringBuilder.append(str);
      return localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.cipher.getAlgorithmName());
    }
  }
  
  public int getBlockSize()
  {
    return this.cipher.getBlockSize();
  }
  
  public BlockCipher getUnderlyingCipher()
  {
    return this.cipher;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.forEncryption = paramBoolean;
    Object localObject1;
    Object localObject2;
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      localObject1 = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject1).getIV();
      int i = paramCipherParameters.length;
      localObject2 = this.IV;
      if (i < localObject2.length)
      {
        System.arraycopy(paramCipherParameters, 0, localObject2, localObject2.length - paramCipherParameters.length, paramCipherParameters.length);
        i = 0;
        for (;;)
        {
          localObject2 = this.IV;
          if (i >= localObject2.length - paramCipherParameters.length) {
            break;
          }
          localObject2[i] = 0;
          i += 1;
        }
      }
      System.arraycopy(paramCipherParameters, 0, localObject2, 0, localObject2.length);
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
    if (this.inlineIv)
    {
      if (this.forEncryption) {
        return encryptBlockWithIV(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
      }
      return decryptBlockWithIV(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    }
    if (this.forEncryption) {
      return encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    }
    return decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public void reset()
  {
    this.count = 0;
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.FR;
      if (i == arrayOfByte.length) {
        break;
      }
      if (this.inlineIv) {
        arrayOfByte[i] = 0;
      } else {
        arrayOfByte[i] = this.IV[i];
      }
      i += 1;
    }
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\PGPCFBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */