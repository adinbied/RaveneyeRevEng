package com.facebook.common.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.references.ResourceReleaser;
import java.io.IOException;
import java.io.InputStream;

public class PooledByteArrayBufferedInputStream
  extends InputStream
{
  private static final String TAG = "PooledByteInputStream";
  private int mBufferOffset;
  private int mBufferedSize;
  private final byte[] mByteArray;
  private boolean mClosed;
  private final InputStream mInputStream;
  private final ResourceReleaser<byte[]> mResourceReleaser;
  
  public PooledByteArrayBufferedInputStream(InputStream paramInputStream, byte[] paramArrayOfByte, ResourceReleaser<byte[]> paramResourceReleaser)
  {
    this.mInputStream = ((InputStream)Preconditions.checkNotNull(paramInputStream));
    this.mByteArray = ((byte[])Preconditions.checkNotNull(paramArrayOfByte));
    this.mResourceReleaser = ((ResourceReleaser)Preconditions.checkNotNull(paramResourceReleaser));
    this.mBufferedSize = 0;
    this.mBufferOffset = 0;
    this.mClosed = false;
  }
  
  private boolean ensureDataInBuffer()
    throws IOException
  {
    if (this.mBufferOffset < this.mBufferedSize) {
      return true;
    }
    int i = this.mInputStream.read(this.mByteArray);
    if (i <= 0) {
      return false;
    }
    this.mBufferedSize = i;
    this.mBufferOffset = 0;
    return true;
  }
  
  private void ensureNotClosed()
    throws IOException
  {
    if (!this.mClosed) {
      return;
    }
    throw new IOException("stream already closed");
  }
  
  public int available()
    throws IOException
  {
    boolean bool;
    if (this.mBufferOffset <= this.mBufferedSize) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    ensureNotClosed();
    return this.mBufferedSize - this.mBufferOffset + this.mInputStream.available();
  }
  
  public void close()
    throws IOException
  {
    if (!this.mClosed)
    {
      this.mClosed = true;
      this.mResourceReleaser.release(this.mByteArray);
      super.close();
    }
  }
  
  protected void finalize()
    throws Throwable
  {
    if (!this.mClosed)
    {
      FLog.e("PooledByteInputStream", "Finalized without closing");
      close();
    }
    super.finalize();
  }
  
  public int read()
    throws IOException
  {
    boolean bool;
    if (this.mBufferOffset <= this.mBufferedSize) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    ensureNotClosed();
    if (!ensureDataInBuffer()) {
      return -1;
    }
    byte[] arrayOfByte = this.mByteArray;
    int i = this.mBufferOffset;
    this.mBufferOffset = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    boolean bool;
    if (this.mBufferOffset <= this.mBufferedSize) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    ensureNotClosed();
    if (!ensureDataInBuffer()) {
      return -1;
    }
    paramInt2 = Math.min(this.mBufferedSize - this.mBufferOffset, paramInt2);
    System.arraycopy(this.mByteArray, this.mBufferOffset, paramArrayOfByte, paramInt1, paramInt2);
    this.mBufferOffset += paramInt2;
    return paramInt2;
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    boolean bool;
    if (this.mBufferOffset <= this.mBufferedSize) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    ensureNotClosed();
    int i = this.mBufferedSize;
    int j = this.mBufferOffset;
    long l = i - j;
    if (l >= paramLong)
    {
      this.mBufferOffset = ((int)(j + paramLong));
      return paramLong;
    }
    this.mBufferOffset = i;
    return l + this.mInputStream.skip(paramLong - l);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\memory\PooledByteArrayBufferedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */