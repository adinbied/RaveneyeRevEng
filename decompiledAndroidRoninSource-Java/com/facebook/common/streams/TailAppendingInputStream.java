package com.facebook.common.streams;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TailAppendingInputStream
  extends FilterInputStream
{
  private int mMarkedTailOffset;
  private final byte[] mTail;
  private int mTailOffset;
  
  public TailAppendingInputStream(InputStream paramInputStream, byte[] paramArrayOfByte)
  {
    super(paramInputStream);
    if (paramInputStream != null)
    {
      if (paramArrayOfByte != null)
      {
        this.mTail = paramArrayOfByte;
        return;
      }
      throw null;
    }
    throw null;
  }
  
  private int readNextTailByte()
  {
    int i = this.mTailOffset;
    byte[] arrayOfByte = this.mTail;
    if (i >= arrayOfByte.length) {
      return -1;
    }
    this.mTailOffset = (i + 1);
    return arrayOfByte[i] & 0xFF;
  }
  
  public void mark(int paramInt)
  {
    if (this.in.markSupported())
    {
      super.mark(paramInt);
      this.mMarkedTailOffset = this.mTailOffset;
    }
  }
  
  public int read()
    throws IOException
  {
    int i = this.in.read();
    if (i != -1) {
      return i;
    }
    return readNextTailByte();
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = this.in.read(paramArrayOfByte, paramInt1, paramInt2);
    int j = -1;
    if (i != -1) {
      return i;
    }
    i = 0;
    if (paramInt2 == 0) {
      return 0;
    }
    while (i < paramInt2)
    {
      int k = readNextTailByte();
      if (k == -1) {
        break;
      }
      paramArrayOfByte[(paramInt1 + i)] = ((byte)k);
      i += 1;
    }
    paramInt1 = j;
    if (i > 0) {
      paramInt1 = i;
    }
    return paramInt1;
  }
  
  public void reset()
    throws IOException
  {
    if (this.in.markSupported())
    {
      this.in.reset();
      this.mTailOffset = this.mMarkedTailOffset;
      return;
    }
    throw new IOException("mark is not supported");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\common\streams\TailAppendingInputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */