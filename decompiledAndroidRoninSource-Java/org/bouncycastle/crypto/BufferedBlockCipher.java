package org.bouncycastle.crypto;

public class BufferedBlockCipher
{
  protected byte[] buf;
  protected int bufOff;
  protected BlockCipher cipher;
  protected boolean forEncryption;
  protected boolean partialBlockOkay;
  protected boolean pgpCFB;
  
  protected BufferedBlockCipher() {}
  
  public BufferedBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = paramBlockCipher;
    this.buf = new byte[paramBlockCipher.getBlockSize()];
    boolean bool2 = false;
    this.bufOff = 0;
    String str = paramBlockCipher.getAlgorithmName();
    int i = str.indexOf('/') + 1;
    boolean bool1;
    if ((i > 0) && (str.startsWith("PGP", i))) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.pgpCFB = bool1;
    if ((!bool1) && (!(paramBlockCipher instanceof StreamCipher)))
    {
      bool1 = bool2;
      if (i > 0)
      {
        bool1 = bool2;
        if (str.startsWith("OpenPGP", i)) {
          bool1 = true;
        }
      }
      this.partialBlockOkay = bool1;
      return;
    }
    this.partialBlockOkay = true;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException, InvalidCipherTextException
  {
    try
    {
      if (this.bufOff + paramInt <= paramArrayOfByte.length)
      {
        int j = this.bufOff;
        int i = 0;
        if (j != 0) {
          if (this.partialBlockOkay)
          {
            this.cipher.processBlock(this.buf, 0, this.buf, 0);
            i = this.bufOff;
            this.bufOff = 0;
            System.arraycopy(this.buf, 0, paramArrayOfByte, paramInt, i);
          }
          else
          {
            throw new DataLengthException("data not block size aligned");
          }
        }
        return i;
      }
      throw new OutputLengthException("output buffer too short for doFinal()");
    }
    finally
    {
      reset();
    }
  }
  
  public int getBlockSize()
  {
    return this.cipher.getBlockSize();
  }
  
  public int getOutputSize(int paramInt)
  {
    return paramInt + this.bufOff;
  }
  
  public BlockCipher getUnderlyingCipher()
  {
    return this.cipher;
  }
  
  public int getUpdateOutputSize(int paramInt)
  {
    int i = paramInt + this.bufOff;
    if (this.pgpCFB)
    {
      if (this.forEncryption)
      {
        paramInt = i % this.buf.length - (this.cipher.getBlockSize() + 2);
        break label63;
      }
      paramInt = this.buf.length;
    }
    else
    {
      paramInt = this.buf.length;
    }
    paramInt = i % paramInt;
    label63:
    return i - paramInt;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.forEncryption = paramBoolean;
    reset();
    this.cipher.init(paramBoolean, paramCipherParameters);
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    byte[] arrayOfByte = this.buf;
    int i = this.bufOff;
    int j = i + 1;
    this.bufOff = j;
    arrayOfByte[i] = paramByte;
    int k = arrayOfByte.length;
    i = 0;
    if (j == k)
    {
      i = this.cipher.processBlock(arrayOfByte, 0, paramArrayOfByte, paramInt);
      this.bufOff = 0;
    }
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
        throw new OutputLengthException("output buffer too short");
      }
      byte[] arrayOfByte = this.buf;
      int j = arrayOfByte.length;
      i = this.bufOff;
      j -= i;
      if (paramInt2 > j)
      {
        System.arraycopy(paramArrayOfByte1, paramInt1, arrayOfByte, i, j);
        i = this.cipher.processBlock(this.buf, 0, paramArrayOfByte2, paramInt3) + 0;
        this.bufOff = 0;
        paramInt2 -= j;
        paramInt1 += j;
        for (;;)
        {
          j = i;
          m = paramInt1;
          k = paramInt2;
          if (paramInt2 <= this.buf.length) {
            break;
          }
          i += this.cipher.processBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt3 + i);
          paramInt2 -= n;
          paramInt1 += n;
        }
      }
      j = 0;
      int k = paramInt2;
      int m = paramInt1;
      System.arraycopy(paramArrayOfByte1, m, this.buf, this.bufOff, k);
      paramInt2 = this.bufOff + k;
      this.bufOff = paramInt2;
      paramArrayOfByte1 = this.buf;
      paramInt1 = j;
      if (paramInt2 == paramArrayOfByte1.length)
      {
        paramInt1 = j + this.cipher.processBlock(paramArrayOfByte1, 0, paramArrayOfByte2, paramInt3 + j);
        this.bufOff = 0;
      }
      return paramInt1;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
  
  public void reset()
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.buf;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
    this.bufOff = 0;
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\BufferedBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */