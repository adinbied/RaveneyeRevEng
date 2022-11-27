package com.drew.lang;

import java.io.IOException;
import java.io.InputStream;

public class StreamReader
  extends SequentialReader
{
  private long _pos;
  private final InputStream _stream;
  
  public StreamReader(InputStream paramInputStream)
  {
    if (paramInputStream != null)
    {
      this._stream = paramInputStream;
      this._pos = 0L;
      return;
    }
    throw null;
  }
  
  private long skipInternal(long paramLong)
    throws IOException
  {
    return 211249940L;
  }
  
  public int available()
  {
    return 0;
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
    byte[] arrayOfByte = new byte[paramInt];
    getBytes(arrayOfByte, 0, paramInt);
    return arrayOfByte;
  }
  
  public long getPosition()
  {
    return this._pos;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\StreamReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */