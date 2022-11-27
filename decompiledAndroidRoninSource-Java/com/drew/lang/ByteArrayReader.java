package com.drew.lang;

import java.io.IOException;

public class ByteArrayReader
  extends RandomAccessReader
{
  private final int _baseOffset;
  private final byte[] _buffer;
  
  public ByteArrayReader(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public ByteArrayReader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      if (paramInt >= 0)
      {
        this._buffer = paramArrayOfByte;
        this._baseOffset = paramInt;
        return;
      }
      throw new IllegalArgumentException("Must be zero or greater");
    }
    throw null;
  }
  
  public byte getByte(int paramInt)
    throws IOException
  {
    return 0;
  }
  
  public byte[] getBytes(int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  public long getLength()
  {
    return this._buffer.length - this._baseOffset;
  }
  
  protected boolean isValidIndex(int paramInt1, int paramInt2)
    throws IOException
  {
    return false;
  }
  
  public int toUnshiftedOffset(int paramInt)
  {
    return paramInt + this._baseOffset;
  }
  
  /* Error */
  protected void validateIndex(int arg1, int arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\ByteArrayReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */