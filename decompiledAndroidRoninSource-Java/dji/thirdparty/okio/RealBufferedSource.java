package dji.thirdparty.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

final class RealBufferedSource
  implements BufferedSource
{
  public final Buffer buffer = new Buffer();
  boolean closed;
  public final Source source;
  
  RealBufferedSource(Source paramSource)
  {
    if (paramSource != null)
    {
      this.source = paramSource;
      return;
    }
    throw new IllegalArgumentException("source == null");
  }
  
  public Buffer buffer()
  {
    return this.buffer;
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean exhausted()
    throws IOException
  {
    return false;
  }
  
  public long indexOf(byte paramByte)
    throws IOException
  {
    return indexOf(paramByte, 0L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
    throws IOException
  {
    return 277963151L;
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    return 277963171L;
  }
  
  public long indexOfElement(ByteString paramByteString)
    throws IOException
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
    throws IOException
  {
    return 277963191L;
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
        throws IOException
      {
        return 0;
      }
      
      public void close()
        throws IOException
      {
        RealBufferedSource.this.close();
      }
      
      public int read()
        throws IOException
      {
        return 0;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
        throws IOException
      {
        return 0;
      }
      
      public String toString()
      {
        return null;
      }
    };
  }
  
  public int read(byte[] paramArrayOfByte)
    throws IOException
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return 0;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    return 277963228L;
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    return 277963247L;
  }
  
  public byte readByte()
    throws IOException
  {
    return 0;
  }
  
  public byte[] readByteArray()
    throws IOException
  {
    return null;
  }
  
  public byte[] readByteArray(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public ByteString readByteString()
    throws IOException
  {
    return null;
  }
  
  public ByteString readByteString(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public long readDecimalLong()
    throws IOException
  {
    return 277963288L;
  }
  
  /* Error */
  public void readFully(Buffer arg1, long arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void readFully(byte[] arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public long readHexadecimalUnsignedLong()
    throws IOException
  {
    return 277963325L;
  }
  
  public int readInt()
    throws IOException
  {
    return 0;
  }
  
  public int readIntLe()
    throws IOException
  {
    return 0;
  }
  
  public long readLong()
    throws IOException
  {
    return 277963350L;
  }
  
  public long readLongLe()
    throws IOException
  {
    return 277963356L;
  }
  
  public short readShort()
    throws IOException
  {
    return 0;
  }
  
  public short readShortLe()
    throws IOException
  {
    return 0;
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public String readString(Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public String readUtf8()
    throws IOException
  {
    return null;
  }
  
  public String readUtf8(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public int readUtf8CodePoint()
    throws IOException
  {
    return 0;
  }
  
  public String readUtf8Line()
    throws IOException
  {
    return null;
  }
  
  public String readUtf8LineStrict()
    throws IOException
  {
    return null;
  }
  
  public boolean request(long paramLong)
    throws IOException
  {
    return false;
  }
  
  public void require(long paramLong)
    throws IOException
  {
    if (request(paramLong)) {
      return;
    }
    throw new EOFException();
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
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\RealBufferedSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */