package org.bouncycastle.jcajce.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

public class CipherInputStream
  extends FilterInputStream
{
  private byte[] buf;
  private int bufOff;
  private final Cipher cipher;
  private boolean finalized = false;
  private final byte[] inputBuffer = new byte['Ȁ'];
  private int maxBuf;
  
  public CipherInputStream(InputStream paramInputStream, Cipher paramCipher)
  {
    super(paramInputStream);
    this.cipher = paramCipher;
  }
  
  private byte[] finaliseCipher()
    throws InvalidCipherTextIOException
  {
    try
    {
      this.finalized = true;
      byte[] arrayOfByte = this.cipher.doFinal();
      return arrayOfByte;
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      throw new InvalidCipherTextIOException("Error finalising cipher", localGeneralSecurityException);
    }
  }
  
  private int nextChunk()
    throws IOException
  {
    if (this.finalized) {
      return -1;
    }
    this.bufOff = 0;
    this.maxBuf = 0;
    int i;
    for (;;)
    {
      i = this.maxBuf;
      if (i != 0) {
        break;
      }
      i = this.in.read(this.inputBuffer);
      if (i == -1)
      {
        arrayOfByte = finaliseCipher();
        this.buf = arrayOfByte;
        if (arrayOfByte != null)
        {
          if (arrayOfByte.length == 0) {
            return -1;
          }
          i = arrayOfByte.length;
          this.maxBuf = i;
          return i;
        }
        return -1;
      }
      byte[] arrayOfByte = this.cipher.update(this.inputBuffer, 0, i);
      this.buf = arrayOfByte;
      if (arrayOfByte != null) {
        this.maxBuf = arrayOfByte.length;
      }
    }
    return i;
  }
  
  public int available()
    throws IOException
  {
    return this.maxBuf - this.bufOff;
  }
  
  public void close()
    throws IOException
  {
    try
    {
      this.in.close();
      if (!this.finalized) {
        finaliseCipher();
      }
      this.bufOff = 0;
      this.maxBuf = 0;
      return;
    }
    finally
    {
      if (!this.finalized) {
        finaliseCipher();
      }
    }
  }
  
  public void mark(int paramInt) {}
  
  public boolean markSupported()
  {
    return false;
  }
  
  public int read()
    throws IOException
  {
    if ((this.bufOff >= this.maxBuf) && (nextChunk() < 0)) {
      return -1;
    }
    byte[] arrayOfByte = this.buf;
    int i = this.bufOff;
    this.bufOff = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    if ((this.bufOff >= this.maxBuf) && (nextChunk() < 0)) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, available());
    System.arraycopy(this.buf, this.bufOff, paramArrayOfByte, paramInt1, paramInt2);
    this.bufOff += paramInt2;
    return paramInt2;
  }
  
  public void reset()
    throws IOException
  {}
  
  public long skip(long paramLong)
    throws IOException
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    int i = (int)Math.min(paramLong, available());
    this.bufOff += i;
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\io\CipherInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */