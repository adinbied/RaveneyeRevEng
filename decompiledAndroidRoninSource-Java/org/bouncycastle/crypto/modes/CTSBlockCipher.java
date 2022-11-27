package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.StreamBlockCipher;

public class CTSBlockCipher
  extends BufferedBlockCipher
{
  private int blockSize;
  
  public CTSBlockCipher(BlockCipher paramBlockCipher)
  {
    if (!(paramBlockCipher instanceof StreamBlockCipher))
    {
      this.cipher = paramBlockCipher;
      int i = paramBlockCipher.getBlockSize();
      this.blockSize = i;
      this.buf = new byte[i * 2];
      this.bufOff = 0;
      return;
    }
    throw new IllegalArgumentException("CTSBlockCipher can only accept ECB, or CBC ciphers");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException, InvalidCipherTextException
  {
    if (this.bufOff + paramInt <= paramArrayOfByte.length)
    {
      int i = this.cipher.getBlockSize();
      int k = this.bufOff - i;
      byte[] arrayOfByte1 = new byte[i];
      int j;
      byte[] arrayOfByte2;
      if (this.forEncryption)
      {
        if (this.bufOff >= i)
        {
          this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
          if (this.bufOff > i)
          {
            j = this.bufOff;
            while (j != this.buf.length)
            {
              this.buf[j] = arrayOfByte1[(j - i)];
              j += 1;
            }
            j = i;
            while (j != this.bufOff)
            {
              arrayOfByte2 = this.buf;
              arrayOfByte2[j] = ((byte)(arrayOfByte2[j] ^ arrayOfByte1[(j - i)]));
              j += 1;
            }
            if ((this.cipher instanceof CBCBlockCipher)) {
              ((CBCBlockCipher)this.cipher).getUnderlyingCipher().processBlock(this.buf, i, paramArrayOfByte, paramInt);
            } else {
              this.cipher.processBlock(this.buf, i, paramArrayOfByte, paramInt);
            }
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt + i, k);
            break label430;
          }
        }
        else
        {
          throw new DataLengthException("need at least one block of input for CTS");
        }
      }
      else
      {
        if (this.bufOff < i) {
          break label441;
        }
        arrayOfByte2 = new byte[i];
        if (this.bufOff > i)
        {
          if ((this.cipher instanceof CBCBlockCipher)) {
            ((CBCBlockCipher)this.cipher).getUnderlyingCipher().processBlock(this.buf, 0, arrayOfByte1, 0);
          } else {
            this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
          }
          j = i;
          while (j != this.bufOff)
          {
            int m = j - i;
            arrayOfByte2[m] = ((byte)(arrayOfByte1[m] ^ this.buf[j]));
            j += 1;
          }
          System.arraycopy(this.buf, i, arrayOfByte1, 0, k);
          this.cipher.processBlock(arrayOfByte1, 0, paramArrayOfByte, paramInt);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt + i, k);
          break label430;
        }
        this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
      }
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, i);
      label430:
      paramInt = this.bufOff;
      reset();
      return paramInt;
      label441:
      throw new DataLengthException("need at least one block of input for CTS");
    }
    throw new DataLengthException("output buffer to small in doFinal");
  }
  
  public int getOutputSize(int paramInt)
  {
    return paramInt + this.bufOff;
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
      System.arraycopy(this.buf, this.blockSize, this.buf, 0, this.blockSize);
      this.bufOff = this.blockSize;
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
      int m = getBlockSize();
      int i = getUpdateOutputSize(paramInt2);
      if ((i > 0) && (i + paramInt3 > paramArrayOfByte2.length)) {
        throw new DataLengthException("output buffer too short");
      }
      int n = this.buf.length - this.bufOff;
      int k = 0;
      int j = paramInt1;
      i = paramInt2;
      if (paramInt2 > n)
      {
        System.arraycopy(paramArrayOfByte1, paramInt1, this.buf, this.bufOff, n);
        i = this.cipher.processBlock(this.buf, 0, paramArrayOfByte2, paramInt3) + 0;
        System.arraycopy(this.buf, m, this.buf, 0, m);
        this.bufOff = m;
        paramInt2 -= n;
        paramInt1 += n;
        while (paramInt2 > m)
        {
          System.arraycopy(paramArrayOfByte1, paramInt1, this.buf, this.bufOff, m);
          i += this.cipher.processBlock(this.buf, 0, paramArrayOfByte2, paramInt3 + i);
          System.arraycopy(this.buf, m, this.buf, 0, m);
          paramInt2 -= m;
          paramInt1 += m;
        }
        k = i;
        i = paramInt2;
        j = paramInt1;
      }
      System.arraycopy(paramArrayOfByte1, j, this.buf, this.bufOff, i);
      this.bufOff += i;
      return k;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\CTSBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */