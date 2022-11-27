package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;

public class OpenPGPCFBBlockCipher
  implements BlockCipher
{
  private byte[] FR;
  private byte[] FRE;
  private byte[] IV;
  private int blockSize;
  private BlockCipher cipher;
  private int count;
  private boolean forEncryption;
  
  public OpenPGPCFBBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = paramBlockCipher;
    int i = paramBlockCipher.getBlockSize();
    this.blockSize = i;
    this.IV = new byte[i];
    this.FR = new byte[i];
    this.FRE = new byte[i];
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int k = this.blockSize;
    if (paramInt1 + k <= paramArrayOfByte1.length)
    {
      if (paramInt2 + k <= paramArrayOfByte2.length)
      {
        int m = this.count;
        int i = 2;
        int j = 0;
        byte b1;
        byte[] arrayOfByte;
        if (m > k)
        {
          b1 = paramArrayOfByte1[paramInt1];
          this.FR[(k - 2)] = b1;
          paramArrayOfByte2[paramInt2] = encryptByte(b1, k - 2);
          b1 = paramArrayOfByte1[(paramInt1 + 1)];
          arrayOfByte = this.FR;
          j = this.blockSize;
          arrayOfByte[(j - 1)] = b1;
          paramArrayOfByte2[(paramInt2 + 1)] = encryptByte(b1, j - 1);
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          while (i < this.blockSize)
          {
            b1 = paramArrayOfByte1[(paramInt1 + i)];
            arrayOfByte = this.FR;
            j = i - 2;
            arrayOfByte[j] = b1;
            paramArrayOfByte2[(paramInt2 + i)] = encryptByte(b1, j);
            i += 1;
          }
        }
        if (m == 0)
        {
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          paramInt2 = j;
          for (;;)
          {
            i = this.blockSize;
            if (paramInt2 >= i) {
              break;
            }
            arrayOfByte = this.FR;
            i = paramInt1 + paramInt2;
            arrayOfByte[paramInt2] = paramArrayOfByte1[i];
            paramArrayOfByte2[paramInt2] = encryptByte(paramArrayOfByte1[i], paramInt2);
            paramInt2 += 1;
          }
        }
        for (paramInt1 = this.count + i;; paramInt1 = this.count + j)
        {
          this.count = paramInt1;
          break;
          if (m != k) {
            break;
          }
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          b1 = paramArrayOfByte1[paramInt1];
          byte b2 = paramArrayOfByte1[(paramInt1 + 1)];
          paramArrayOfByte2[paramInt2] = encryptByte(b1, 0);
          paramArrayOfByte2[(paramInt2 + 1)] = encryptByte(b2, 1);
          arrayOfByte = this.FR;
          System.arraycopy(arrayOfByte, 2, arrayOfByte, 0, this.blockSize - 2);
          arrayOfByte = this.FR;
          j = this.blockSize;
          arrayOfByte[(j - 2)] = b1;
          arrayOfByte[(j - 1)] = b2;
          this.cipher.processBlock(arrayOfByte, 0, this.FRE, 0);
          for (;;)
          {
            j = this.blockSize;
            if (i >= j) {
              break;
            }
            b1 = paramArrayOfByte1[(paramInt1 + i)];
            arrayOfByte = this.FR;
            j = i - 2;
            arrayOfByte[j] = b1;
            paramArrayOfByte2[(paramInt2 + i)] = encryptByte(b1, j);
            i += 1;
          }
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
    int m = this.blockSize;
    if (paramInt1 + m <= paramArrayOfByte1.length)
    {
      if (paramInt2 + m <= paramArrayOfByte2.length)
      {
        int n = this.count;
        int j = 2;
        int k = 0;
        byte[] arrayOfByte;
        int i;
        if (n > m)
        {
          arrayOfByte = this.FR;
          i = encryptByte(paramArrayOfByte1[paramInt1], m - 2);
          paramArrayOfByte2[paramInt2] = i;
          arrayOfByte[(m - 2)] = i;
          arrayOfByte = this.FR;
          k = this.blockSize;
          i = encryptByte(paramArrayOfByte1[(paramInt1 + 1)], k - 1);
          paramArrayOfByte2[(paramInt2 + 1)] = i;
          arrayOfByte[(k - 1)] = i;
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          while (j < this.blockSize)
          {
            arrayOfByte = this.FR;
            k = j - 2;
            i = encryptByte(paramArrayOfByte1[(paramInt1 + j)], k);
            paramArrayOfByte2[(paramInt2 + j)] = i;
            arrayOfByte[k] = i;
            j += 1;
          }
        }
        if (n == 0)
        {
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          for (;;)
          {
            m = this.blockSize;
            j = m;
            if (k >= m) {
              break;
            }
            arrayOfByte = this.FR;
            i = encryptByte(paramArrayOfByte1[(paramInt1 + k)], k);
            paramArrayOfByte2[(paramInt2 + k)] = i;
            arrayOfByte[k] = i;
            k += 1;
          }
          this.count += j;
        }
        else if (n == m)
        {
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          paramArrayOfByte2[paramInt2] = encryptByte(paramArrayOfByte1[paramInt1], 0);
          paramArrayOfByte2[(paramInt2 + 1)] = encryptByte(paramArrayOfByte1[(paramInt1 + 1)], 1);
          arrayOfByte = this.FR;
          System.arraycopy(arrayOfByte, 2, arrayOfByte, 0, this.blockSize - 2);
          System.arraycopy(paramArrayOfByte2, paramInt2, this.FR, this.blockSize - 2, 2);
          this.cipher.processBlock(this.FR, 0, this.FRE, 0);
          k = j;
          for (;;)
          {
            m = this.blockSize;
            j = m;
            if (k >= m) {
              break;
            }
            arrayOfByte = this.FR;
            j = k - 2;
            i = encryptByte(paramArrayOfByte1[(paramInt1 + k)], j);
            paramArrayOfByte2[(paramInt2 + k)] = i;
            arrayOfByte[j] = i;
            k += 1;
          }
        }
        return this.blockSize;
      }
      throw new DataLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private byte encryptByte(byte paramByte, int paramInt)
  {
    return (byte)(paramByte ^ this.FRE[paramInt]);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/OpenPGPCFB");
    return localStringBuilder.toString();
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
    reset();
    this.cipher.init(true, paramCipherParameters);
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.forEncryption) {
      return encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    }
    return decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public void reset()
  {
    this.count = 0;
    byte[] arrayOfByte1 = this.IV;
    byte[] arrayOfByte2 = this.FR;
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, arrayOfByte2.length);
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\OpenPGPCFBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */