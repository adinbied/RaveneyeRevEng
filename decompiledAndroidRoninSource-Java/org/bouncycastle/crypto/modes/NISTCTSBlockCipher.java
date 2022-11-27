package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class NISTCTSBlockCipher
  extends BufferedBlockCipher
{
  public static final int CS1 = 1;
  public static final int CS2 = 2;
  public static final int CS3 = 3;
  private final int blockSize;
  private final int type;
  
  public NISTCTSBlockCipher(int paramInt, BlockCipher paramBlockCipher)
  {
    this.type = paramInt;
    this.cipher = new CBCBlockCipher(paramBlockCipher);
    paramInt = paramBlockCipher.getBlockSize();
    this.blockSize = paramInt;
    this.buf = new byte[paramInt * 2];
    this.bufOff = 0;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException, InvalidCipherTextException
  {
    if (this.bufOff + paramInt <= paramArrayOfByte.length)
    {
      int j = this.cipher.getBlockSize();
      int k = this.bufOff - j;
      byte[] arrayOfByte1 = new byte[j];
      byte[] arrayOfByte2;
      int i;
      if (this.forEncryption)
      {
        if (this.bufOff >= j)
        {
          if (this.bufOff > j)
          {
            arrayOfByte2 = new byte[j];
            i = this.type;
            if ((i != 2) && (i != 3))
            {
              System.arraycopy(this.buf, 0, arrayOfByte1, 0, j);
              this.cipher.processBlock(arrayOfByte1, 0, arrayOfByte1, 0);
              System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, k);
              System.arraycopy(this.buf, this.bufOff - k, arrayOfByte2, 0, k);
              this.cipher.processBlock(arrayOfByte2, 0, arrayOfByte2, 0);
              System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt + k, j);
              break label673;
            }
            this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
            System.arraycopy(this.buf, j, arrayOfByte2, 0, k);
            this.cipher.processBlock(arrayOfByte2, 0, arrayOfByte2, 0);
            if ((this.type == 2) && (k == j))
            {
              System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, j);
              System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt + j, k);
              break label673;
            }
            System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt, j);
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt + j, k);
            break label673;
          }
          this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
        }
        else
        {
          throw new DataLengthException("need at least one block of input for NISTCTS");
        }
      }
      else
      {
        if (this.bufOff < j) {
          break label684;
        }
        arrayOfByte2 = new byte[j];
        if (this.bufOff > j)
        {
          i = this.type;
          if ((i != 3) && ((i != 2) || ((this.buf.length - this.bufOff) % j == 0)))
          {
            ((CBCBlockCipher)this.cipher).getUnderlyingCipher().processBlock(this.buf, this.bufOff - j, arrayOfByte2, 0);
            System.arraycopy(this.buf, 0, arrayOfByte1, 0, j);
            if (k != j) {
              System.arraycopy(arrayOfByte2, k, arrayOfByte1, k, j - k);
            }
            this.cipher.processBlock(arrayOfByte1, 0, arrayOfByte1, 0);
            System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, j);
            i = 0;
          }
          while (i != k)
          {
            arrayOfByte2[i] = ((byte)(arrayOfByte2[i] ^ this.buf[i]));
            i += 1;
            continue;
            if ((this.cipher instanceof CBCBlockCipher)) {
              ((CBCBlockCipher)this.cipher).getUnderlyingCipher().processBlock(this.buf, 0, arrayOfByte1, 0);
            } else {
              this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
            }
            i = j;
            while (i != this.bufOff)
            {
              int m = i - j;
              arrayOfByte2[m] = ((byte)(arrayOfByte1[m] ^ this.buf[i]));
              i += 1;
            }
            System.arraycopy(this.buf, j, arrayOfByte1, 0, k);
            this.cipher.processBlock(arrayOfByte1, 0, paramArrayOfByte, paramInt);
          }
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt + j, k);
          break label673;
        }
        this.cipher.processBlock(this.buf, 0, arrayOfByte1, 0);
      }
      System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, j);
      label673:
      paramInt = this.bufOff;
      reset();
      return paramInt;
      label684:
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\NISTCTSBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */