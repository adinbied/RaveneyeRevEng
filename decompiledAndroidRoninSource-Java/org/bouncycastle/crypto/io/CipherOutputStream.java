package org.bouncycastle.crypto.io;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;

public class CipherOutputStream
  extends FilterOutputStream
{
  private AEADBlockCipher aeadBlockCipher;
  private byte[] buf;
  private BufferedBlockCipher bufferedBlockCipher;
  private final byte[] oneByte = new byte[1];
  private StreamCipher streamCipher;
  
  public CipherOutputStream(OutputStream paramOutputStream, BufferedBlockCipher paramBufferedBlockCipher)
  {
    super(paramOutputStream);
    this.bufferedBlockCipher = paramBufferedBlockCipher;
  }
  
  public CipherOutputStream(OutputStream paramOutputStream, StreamCipher paramStreamCipher)
  {
    super(paramOutputStream);
    this.streamCipher = paramStreamCipher;
  }
  
  public CipherOutputStream(OutputStream paramOutputStream, AEADBlockCipher paramAEADBlockCipher)
  {
    super(paramOutputStream);
    this.aeadBlockCipher = paramAEADBlockCipher;
  }
  
  private void ensureCapacity(int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      localObject = this.bufferedBlockCipher;
      if (localObject != null)
      {
        i = ((BufferedBlockCipher)localObject).getOutputSize(paramInt);
      }
      else
      {
        localObject = this.aeadBlockCipher;
        i = paramInt;
        if (localObject != null) {
          i = ((AEADBlockCipher)localObject).getOutputSize(paramInt);
        }
      }
    }
    else
    {
      localObject = this.bufferedBlockCipher;
      if (localObject != null)
      {
        i = ((BufferedBlockCipher)localObject).getUpdateOutputSize(paramInt);
      }
      else
      {
        localObject = this.aeadBlockCipher;
        i = paramInt;
        if (localObject != null) {
          i = ((AEADBlockCipher)localObject).getUpdateOutputSize(paramInt);
        }
      }
    }
    Object localObject = this.buf;
    if ((localObject == null) || (localObject.length < i)) {
      this.buf = new byte[i];
    }
  }
  
  public void close()
    throws IOException
  {
    ensureCapacity(0, true);
    InvalidCipherTextIOException localInvalidCipherTextIOException;
    try
    {
      int i;
      if (this.bufferedBlockCipher != null)
      {
        i = this.bufferedBlockCipher.doFinal(this.buf, 0);
        if (i != 0) {
          this.out.write(this.buf, 0, i);
        }
      }
      else if (this.aeadBlockCipher != null)
      {
        i = this.aeadBlockCipher.doFinal(this.buf, 0);
        if (i != 0) {
          this.out.write(this.buf, 0, i);
        }
      }
      else if (this.streamCipher != null)
      {
        this.streamCipher.reset();
      }
      Object localObject1 = null;
    }
    catch (Exception localException)
    {
      CipherIOException localCipherIOException = new CipherIOException("Error closing stream: ", localException);
    }
    catch (InvalidCipherTextException localInvalidCipherTextException)
    {
      localInvalidCipherTextIOException = new InvalidCipherTextIOException("Error finalising cipher data", localInvalidCipherTextException);
    }
    Object localObject2;
    try
    {
      flush();
      this.out.close();
      localObject2 = localInvalidCipherTextIOException;
    }
    catch (IOException localIOException)
    {
      localObject2 = localInvalidCipherTextIOException;
      if (localInvalidCipherTextIOException == null) {
        localObject2 = localIOException;
      }
    }
    if (localObject2 == null) {
      return;
    }
    throw ((Throwable)localObject2);
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
    byte b = (byte)paramInt;
    arrayOfByte[0] = b;
    if (this.streamCipher != null)
    {
      this.out.write(this.streamCipher.returnByte(b));
      return;
    }
    write(arrayOfByte, 0, 1);
  }
  
  public void write(byte[] paramArrayOfByte)
    throws IOException
  {
    write(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    ensureCapacity(paramInt2, false);
    Object localObject = this.bufferedBlockCipher;
    if (localObject != null)
    {
      paramInt1 = ((BufferedBlockCipher)localObject).processBytes(paramArrayOfByte, paramInt1, paramInt2, this.buf, 0);
      if (paramInt1 != 0) {
        this.out.write(this.buf, 0, paramInt1);
      }
    }
    else
    {
      localObject = this.aeadBlockCipher;
      if (localObject != null)
      {
        paramInt1 = ((AEADBlockCipher)localObject).processBytes(paramArrayOfByte, paramInt1, paramInt2, this.buf, 0);
        if (paramInt1 != 0) {
          this.out.write(this.buf, 0, paramInt1);
        }
      }
      else
      {
        this.streamCipher.processBytes(paramArrayOfByte, paramInt1, paramInt2, this.buf, 0);
        this.out.write(this.buf, 0, paramInt2);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\io\CipherOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */