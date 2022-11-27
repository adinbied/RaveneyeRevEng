package com.drew.lang;

import java.io.IOException;

public class SequentialByteArrayReader
  extends SequentialReader
{
  private final byte[] _bytes;
  private int _index;
  
  public SequentialByteArrayReader(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public SequentialByteArrayReader(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte != null)
    {
      this._bytes = paramArrayOfByte;
      this._index = paramInt;
      return;
    }
    throw null;
  }
  
  public int available()
  {
    return this._bytes.length - this._index;
  }
  
  public byte getByte()
    throws IOException
  {
    return 0;
  }
  
  /* Error */
  public void getBytes(byte[] arg1, int arg2, int arg3)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public byte[] getBytes(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public long getPosition()
  {
    return this._index;
  }
  
  /* Error */
  public void skip(long arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public boolean trySkip(long paramLong)
    throws IOException
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\SequentialByteArrayReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */