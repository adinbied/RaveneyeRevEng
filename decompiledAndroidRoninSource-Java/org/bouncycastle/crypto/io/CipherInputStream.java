package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.BufferedBlockCipher;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.SkippingCipher;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.util.Arrays;

public class CipherInputStream
  extends FilterInputStream
{
  private static final int INPUT_BUF_SIZE = 2048;
  private AEADBlockCipher aeadBlockCipher;
  private byte[] buf;
  private int bufOff;
  private BufferedBlockCipher bufferedBlockCipher;
  private boolean finalized;
  private byte[] inBuf;
  private byte[] markBuf;
  private int markBufOff;
  private long markPosition;
  private int maxBuf;
  private SkippingCipher skippingCipher;
  private StreamCipher streamCipher;
  
  public CipherInputStream(InputStream paramInputStream, BufferedBlockCipher paramBufferedBlockCipher)
  {
    this(paramInputStream, paramBufferedBlockCipher, 2048);
  }
  
  public CipherInputStream(InputStream paramInputStream, BufferedBlockCipher paramBufferedBlockCipher, int paramInt)
  {
    super(paramInputStream);
    this.bufferedBlockCipher = paramBufferedBlockCipher;
    this.inBuf = new byte[paramInt];
    if ((paramBufferedBlockCipher instanceof SkippingCipher)) {
      paramInputStream = (SkippingCipher)paramBufferedBlockCipher;
    } else {
      paramInputStream = null;
    }
    this.skippingCipher = paramInputStream;
  }
  
  public CipherInputStream(InputStream paramInputStream, StreamCipher paramStreamCipher)
  {
    this(paramInputStream, paramStreamCipher, 2048);
  }
  
  public CipherInputStream(InputStream paramInputStream, StreamCipher paramStreamCipher, int paramInt)
  {
    super(paramInputStream);
    this.streamCipher = paramStreamCipher;
    this.inBuf = new byte[paramInt];
    if ((paramStreamCipher instanceof SkippingCipher)) {
      paramInputStream = (SkippingCipher)paramStreamCipher;
    } else {
      paramInputStream = null;
    }
    this.skippingCipher = paramInputStream;
  }
  
  public CipherInputStream(InputStream paramInputStream, AEADBlockCipher paramAEADBlockCipher)
  {
    this(paramInputStream, paramAEADBlockCipher, 2048);
  }
  
  public CipherInputStream(InputStream paramInputStream, AEADBlockCipher paramAEADBlockCipher, int paramInt)
  {
    super(paramInputStream);
    this.aeadBlockCipher = paramAEADBlockCipher;
    this.inBuf = new byte[paramInt];
    if ((paramAEADBlockCipher instanceof SkippingCipher)) {
      paramInputStream = (SkippingCipher)paramAEADBlockCipher;
    } else {
      paramInputStream = null;
    }
    this.skippingCipher = paramInputStream;
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
  
  private void finaliseCipher()
    throws IOException
  {
    try
    {
      this.finalized = true;
      ensureCapacity(0, true);
      if (this.bufferedBlockCipher != null) {}
      for (int i = this.bufferedBlockCipher.doFinal(this.buf, 0);; i = this.aeadBlockCipher.doFinal(this.buf, 0))
      {
        this.maxBuf = i;
        return;
        if (this.aeadBlockCipher == null) {
          break;
        }
      }
      this.maxBuf = 0;
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Error finalising cipher ");
      localStringBuilder.append(localException);
      throw new IOException(localStringBuilder.toString());
    }
    catch (InvalidCipherTextException localInvalidCipherTextException)
    {
      throw new InvalidCipherTextIOException("Error finalising cipher", localInvalidCipherTextException);
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
    for (;;)
    {
      i = this.maxBuf;
      if (i == 0)
      {
        i = this.in.read(this.inBuf);
        if (i == -1)
        {
          finaliseCipher();
          i = this.maxBuf;
          if (i == 0) {
            return -1;
          }
          return i;
        }
        try
        {
          ensureCapacity(i, false);
          if (this.bufferedBlockCipher != null) {
            i = this.bufferedBlockCipher.processBytes(this.inBuf, 0, i, this.buf, 0);
          }
          for (;;)
          {
            this.maxBuf = i;
            break;
            if (this.aeadBlockCipher != null) {
              i = this.aeadBlockCipher.processBytes(this.inBuf, 0, i, this.buf, 0);
            } else {
              this.streamCipher.processBytes(this.inBuf, 0, i, this.buf, 0);
            }
          }
          return i;
        }
        catch (Exception localException)
        {
          throw new CipherIOException("Error processing stream ", localException);
        }
      }
    }
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
      this.markBufOff = 0;
      this.markPosition = 0L;
      byte[] arrayOfByte = this.markBuf;
      if (arrayOfByte != null)
      {
        Arrays.fill(arrayOfByte, (byte)0);
        this.markBuf = null;
      }
      arrayOfByte = this.buf;
      if (arrayOfByte != null)
      {
        Arrays.fill(arrayOfByte, (byte)0);
        this.buf = null;
      }
      Arrays.fill(this.inBuf, (byte)0);
      return;
    }
    finally
    {
      if (!this.finalized) {
        finaliseCipher();
      }
    }
  }
  
  public void mark(int paramInt)
  {
    this.in.mark(paramInt);
    Object localObject = this.skippingCipher;
    if (localObject != null) {
      this.markPosition = ((SkippingCipher)localObject).getPosition();
    }
    localObject = this.buf;
    if (localObject != null)
    {
      byte[] arrayOfByte = new byte[localObject.length];
      this.markBuf = arrayOfByte;
      System.arraycopy(localObject, 0, arrayOfByte, 0, localObject.length);
    }
    this.markBufOff = this.bufOff;
  }
  
  public boolean markSupported()
  {
    if (this.skippingCipher != null) {
      return this.in.markSupported();
    }
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
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
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
  {
    if (this.skippingCipher != null)
    {
      this.in.reset();
      this.skippingCipher.seekTo(this.markPosition);
      byte[] arrayOfByte = this.markBuf;
      if (arrayOfByte != null) {
        this.buf = arrayOfByte;
      }
      this.bufOff = this.markBufOff;
      return;
    }
    throw new IOException("cipher must implement SkippingCipher to be used with reset()");
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    if (paramLong <= 0L) {
      return 0L;
    }
    if (this.skippingCipher != null)
    {
      long l = available();
      if (paramLong <= l)
      {
        this.bufOff = ((int)(this.bufOff + paramLong));
        return paramLong;
      }
      this.bufOff = this.maxBuf;
      paramLong = this.in.skip(paramLong - l);
      if (paramLong == this.skippingCipher.skip(paramLong)) {
        return paramLong + l;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to skip cipher ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" bytes.");
      throw new IOException(localStringBuilder.toString());
    }
    int i = (int)Math.min(paramLong, available());
    this.bufOff += i;
    return i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\io\CipherInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */