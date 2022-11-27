package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LimitedInputStream
  extends FilterInputStream
{
  private int mBytesToRead;
  private int mBytesToReadWhenMarked;
  
  public LimitedInputStream(InputStream paramInputStream, int paramInt)
  {
    super(paramInputStream);
    if (paramInputStream != null)
    {
      if (paramInt >= 0)
      {
        this.mBytesToRead = paramInt;
        this.mBytesToReadWhenMarked = -1;
        return;
      }
      throw new IllegalArgumentException("limit must be >= 0");
    }
    throw null;
  }
  
  public int available()
    throws IOException
  {
    return Math.min(this.in.available(), this.mBytesToRead);
  }
  
  public void mark(int paramInt)
  {
    if (this.in.markSupported())
    {
      this.in.mark(paramInt);
      this.mBytesToReadWhenMarked = this.mBytesToRead;
    }
  }
  
  public int read()
    throws IOException
  {
    if (this.mBytesToRead == 0) {
      return -1;
    }
    int i = this.in.read();
    if (i != -1) {
      this.mBytesToRead -= 1;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.mBytesToRead;
    if (i == 0) {
      return -1;
    }
    paramInt2 = Math.min(paramInt2, i);
    paramInt1 = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt1 > 0) {
      this.mBytesToRead -= paramInt1;
    }
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    if (this.in.markSupported())
    {
      if (this.mBytesToReadWhenMarked != -1)
      {
        this.in.reset();
        this.mBytesToRead = this.mBytesToReadWhenMarked;
        return;
      }
      throw new IOException("mark not set");
    }
    throw new IOException("mark is not supported");
  }
  
  public long skip(long paramLong)
    throws IOException
  {
    paramLong = Math.min(paramLong, this.mBytesToRead);
    paramLong = this.in.skip(paramLong);
    this.mBytesToRead = ((int)(this.mBytesToRead - paramLong));
    return paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\streams\LimitedInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */