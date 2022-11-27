package org.bouncycastle.jcajce.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.bouncycastle.crypto.io.InvalidCipherTextIOException;

public class CipherOutputStream
  extends FilterOutputStream
{
  private final Cipher cipher;
  private final byte[] oneByte = new byte[1];
  
  public CipherOutputStream(OutputStream paramOutputStream, Cipher paramCipher)
  {
    super(paramOutputStream);
    this.cipher = paramCipher;
  }
  
  public void close()
    throws IOException
  {
    Object localObject;
    InvalidCipherTextIOException localInvalidCipherTextIOException;
    try
    {
      byte[] arrayOfByte = this.cipher.doFinal();
      if (arrayOfByte != null) {
        this.out.write(arrayOfByte);
      }
      arrayOfByte = null;
    }
    catch (Exception localException)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Error closing stream: ");
      ((StringBuilder)localObject).append(localException);
      IOException localIOException1 = new IOException(((StringBuilder)localObject).toString());
    }
    catch (GeneralSecurityException localGeneralSecurityException)
    {
      localInvalidCipherTextIOException = new InvalidCipherTextIOException("Error during cipher finalisation", localGeneralSecurityException);
    }
    try
    {
      flush();
      this.out.close();
      localObject = localInvalidCipherTextIOException;
    }
    catch (IOException localIOException2)
    {
      localObject = localInvalidCipherTextIOException;
      if (localInvalidCipherTextIOException == null) {
        localObject = localIOException2;
      }
    }
    if (localObject == null) {
      return;
    }
    throw ((Throwable)localObject);
  }
  
  public void flush()
    throws IOException
  {
    this.out.flush();
  }
  
  public void write(int paramInt)
    throws IOException
  {
    byte[] arrayOfByte = this.oneByte;
    arrayOfByte[0] = ((byte)paramInt);
    write(arrayOfByte, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    paramArrayOfByte = this.cipher.update(paramArrayOfByte, paramInt1, paramInt2);
    if (paramArrayOfByte != null) {
      this.out.write(paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\io\CipherOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */