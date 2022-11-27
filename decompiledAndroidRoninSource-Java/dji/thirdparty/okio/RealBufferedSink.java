package dji.thirdparty.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

final class RealBufferedSink
  implements BufferedSink
{
  public final Buffer buffer = new Buffer();
  boolean closed;
  public final Sink sink;
  
  RealBufferedSink(Sink paramSink)
  {
    if (paramSink != null)
    {
      this.sink = paramSink;
      return;
    }
    throw new IllegalArgumentException("sink == null");
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
    //   2: return
  }
  
  public BufferedSink emit()
    throws IOException
  {
    return null;
  }
  
  public BufferedSink emitCompleteSegments()
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void flush()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close()
        throws IOException
      {
        RealBufferedSink.this.close();
      }
      
      /* Error */
      public void flush()
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      public String toString()
      {
        return null;
      }
      
      /* Error */
      public void write(int arg1)
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_2
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void write(byte[] arg1, int arg2, int arg3)
        throws IOException
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    return null;
  }
  
  public BufferedSink write(ByteString paramByteString)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink write(byte[] paramArrayOfByte)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void write(Buffer arg1, long arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    return 277962986L;
  }
  
  public BufferedSink writeByte(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeDecimalLong(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeHexadecimalUnsignedLong(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeInt(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeIntLe(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeLong(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeLongLe(long paramLong)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeShort(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeShortLe(int paramInt)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeString(String paramString, Charset paramCharset)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeUtf8(String paramString)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeUtf8(String paramString, int paramInt1, int paramInt2)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink writeUtf8CodePoint(int paramInt)
    throws IOException
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\RealBufferedSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */