package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class PaddedBlockCipher
  extends BufferedBlockCipher
{
  public PaddedBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = paramBlockCipher;
    this.buf = new byte[paramBlockCipher.getBlockSize()];
    this.bufOff = 0;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException, InvalidCipherTextException
  {
    int k = this.cipher.getBlockSize();
    int j;
    if (this.forEncryption)
    {
      if (this.bufOff == k)
      {
        if (k * 2 + paramInt <= paramArrayOfByte.length)
        {
          j = this.cipher.processBlock(this.buf, 0, paramArrayOfByte, paramInt);
          this.bufOff = 0;
        }
        else
        {
          throw new DataLengthException("output buffer too short");
        }
      }
      else {
        j = 0;
      }
      int i = (byte)(k - this.bufOff);
      while (this.bufOff < k)
      {
        this.buf[this.bufOff] = i;
        this.bufOff += 1;
      }
      paramInt = j + this.cipher.processBlock(this.buf, 0, paramArrayOfByte, paramInt + j);
    }
    else
    {
      if (this.bufOff != k) {
        break label244;
      }
      j = this.cipher.processBlock(this.buf, 0, this.buf, 0);
      this.bufOff = 0;
      int m = this.buf[(k - 1)] & 0xFF;
      if ((m < 0) || (m > k)) {
        break label234;
      }
      j -= m;
      System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, j);
      paramInt = j;
    }
    reset();
    return paramInt;
    label234:
    throw new InvalidCipherTextException("pad block corrupted");
    label244:
    throw new DataLengthException("last block incomplete in decryption");
  }
  
  public int getOutputSize(int paramInt)
  {
    paramInt += this.bufOff;
    int i = paramInt % this.buf.length;
    int j;
    if (i == 0)
    {
      i = paramInt;
      if (this.forEncryption)
      {
        j = this.buf.length;
        i = paramInt;
      }
    }
    for (paramInt = j;; paramInt = this.buf.length)
    {
      i += paramInt;
      return i;
      i = paramInt - i;
    }
  }
  
  public int getUpdateOutputSize(int paramInt)
  {
    paramInt += this.bufOff;
    int i = paramInt % this.buf.length;
    if (i == 0) {
      return paramInt - this.buf.length;
    }
    return paramInt - i;
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    int j = this.bufOff;
    int k = this.buf.length;
    int i = 0;
    if (j == k)
    {
      i = this.cipher.processBlock(this.buf, 0, paramArrayOfByte, paramInt);
      this.bufOff = 0;
    }
    paramArrayOfByte = this.buf;
    paramInt = this.bufOff;
    this.bufOff = (paramInt + 1);
    paramArrayOfByte[paramInt] = paramByte;
    return i;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException, IllegalStateException
  {
    if (paramInt2 >= 0)
    {
      int n = getBlockSize();
      int i = getUpdateOutputSize(paramInt2);
      if ((i > 0) && (i + paramInt3 > paramArrayOfByte2.length)) {
        throw new DataLengthException("output buffer too short");
      }
      i = this.buf.length - this.bufOff;
      int j = 0;
      int k = paramInt1;
      int m = paramInt2;
      if (paramInt2 > i)
      {
        System.arraycopy(paramArrayOfByte1, paramInt1, this.buf, this.bufOff, i);
        j = this.cipher.processBlock(this.buf, 0, paramArrayOfByte2, paramInt3);
        this.bufOff = 0;
        paramInt2 -= i;
        paramInt1 += i;
        i = j + 0;
        for (;;)
        {
          j = i;
          k = paramInt1;
          m = paramInt2;
          if (paramInt2 <= this.buf.length) {
            break;
          }
          i += this.cipher.processBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt3 + i);
          paramInt2 -= n;
          paramInt1 += n;
        }
      }
      System.arraycopy(paramArrayOfByte1, k, this.buf, this.bufOff, m);
      this.bufOff += m;
      return j;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\PaddedBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */