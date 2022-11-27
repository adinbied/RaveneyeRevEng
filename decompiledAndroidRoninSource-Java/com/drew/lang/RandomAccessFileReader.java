package com.drew.lang;

import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileReader
  extends RandomAccessReader
{
  private final int _baseOffset;
  private int _currentIndex;
  private final RandomAccessFile _file;
  private final long _length;
  
  public RandomAccessFileReader(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    this(paramRandomAccessFile, 0);
  }
  
  public RandomAccessFileReader(RandomAccessFile paramRandomAccessFile, int paramInt)
    throws IOException
  {
    if (paramRandomAccessFile != null)
    {
      this._file = paramRandomAccessFile;
      this._baseOffset = paramInt;
      this._length = paramRandomAccessFile.length();
      return;
    }
    throw null;
  }
  
  /* Error */
  private void seek(int arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
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
    return this._length;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\RandomAccessFileReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */