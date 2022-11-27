package com.drew.lang;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class RandomAccessStreamReader
  extends RandomAccessReader
{
  public static final int DEFAULT_CHUNK_LENGTH = 2048;
  private final int _chunkLength;
  private final ArrayList<byte[]> _chunks = new ArrayList();
  private boolean _isStreamFinished;
  private final InputStream _stream;
  private long _streamLength;
  
  public RandomAccessStreamReader(InputStream paramInputStream)
  {
    this(paramInputStream, 2048, -1L);
  }
  
  public RandomAccessStreamReader(InputStream paramInputStream, int paramInt)
  {
    this(paramInputStream, paramInt, -1L);
  }
  
  public RandomAccessStreamReader(InputStream paramInputStream, int paramInt, long paramLong)
  {
    if (paramInputStream != null)
    {
      if (paramInt > 0)
      {
        this._chunkLength = paramInt;
        this._stream = paramInputStream;
        this._streamLength = paramLong;
        return;
      }
      throw new IllegalArgumentException("chunkLength must be greater than zero");
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
    throws IOException
  {
    return 211249820L;
  }
  
  protected boolean isValidIndex(int paramInt1, int paramInt2)
    throws IOException
  {
    return false;
  }
  
  public int toUnshiftedOffset(int paramInt)
  {
    return paramInt;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\RandomAccessStreamReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */