package dji.thirdparty.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.List;

public final class Buffer
  implements BufferedSource, BufferedSink, Cloneable
{
  private static final byte[] DIGITS = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  static final int REPLACEMENT_CHARACTER = 65533;
  Segment head;
  long size;
  
  private ByteString digest(String paramString)
  {
    return null;
  }
  
  private boolean rangeEquals(Segment paramSegment, int paramInt1, ByteString paramByteString, int paramInt2, int paramInt3)
  {
    return false;
  }
  
  /* Error */
  private void readFrom(InputStream arg1, long arg2, boolean arg4)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Buffer buffer()
  {
    return this;
  }
  
  /* Error */
  public void clear()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Buffer clone()
  {
    return null;
  }
  
  public void close() {}
  
  public long completeSegmentByteCount()
  {
    return 277961656L;
  }
  
  public Buffer copyTo(Buffer paramBuffer, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  public Buffer copyTo(OutputStream paramOutputStream)
    throws IOException
  {
    return null;
  }
  
  public Buffer copyTo(OutputStream paramOutputStream, long paramLong1, long paramLong2)
    throws IOException
  {
    return null;
  }
  
  public BufferedSink emit()
  {
    return this;
  }
  
  public Buffer emitCompleteSegments()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public boolean exhausted()
  {
    return false;
  }
  
  public void flush() {}
  
  public byte getByte(long paramLong)
  {
    return 0;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public long indexOf(byte paramByte)
  {
    return indexOf(paramByte, 0L);
  }
  
  public long indexOf(byte paramByte, long paramLong)
  {
    return 277961775L;
  }
  
  public long indexOf(ByteString paramByteString)
    throws IOException
  {
    return indexOf(paramByteString, 0L);
  }
  
  public long indexOf(ByteString paramByteString, long paramLong)
    throws IOException
  {
    return 277961803L;
  }
  
  public long indexOfElement(ByteString paramByteString)
  {
    return indexOfElement(paramByteString, 0L);
  }
  
  public long indexOfElement(ByteString paramByteString, long paramLong)
  {
    return 277961838L;
  }
  
  public InputStream inputStream()
  {
    new InputStream()
    {
      public int available()
      {
        return 0;
      }
      
      public void close() {}
      
      public int read()
      {
        return 0;
      }
      
      public int read(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return Buffer.this.read(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
      
      public String toString()
      {
        return null;
      }
    };
  }
  
  public ByteString md5()
  {
    return digest("MD5");
  }
  
  public OutputStream outputStream()
  {
    new OutputStream()
    {
      public void close() {}
      
      public void flush() {}
      
      public String toString()
      {
        return null;
      }
      
      public void write(int paramAnonymousInt)
      {
        Buffer.this.writeByte((byte)paramAnonymousInt);
      }
      
      public void write(byte[] paramAnonymousArrayOfByte, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        Buffer.this.write(paramAnonymousArrayOfByte, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
  }
  
  boolean rangeEquals(long paramLong, ByteString paramByteString)
  {
    return false;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return 0;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    return 277961917L;
  }
  
  public long readAll(Sink paramSink)
    throws IOException
  {
    return 277961929L;
  }
  
  public byte readByte()
  {
    return 0;
  }
  
  public byte[] readByteArray()
  {
    return null;
  }
  
  public byte[] readByteArray(long paramLong)
    throws EOFException
  {
    return null;
  }
  
  public ByteString readByteString()
  {
    return null;
  }
  
  public ByteString readByteString(long paramLong)
    throws EOFException
  {
    return null;
  }
  
  public long readDecimalLong()
  {
    return 277961981L;
  }
  
  public Buffer readFrom(InputStream paramInputStream)
    throws IOException
  {
    return null;
  }
  
  public Buffer readFrom(InputStream paramInputStream, long paramLong)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void readFully(Buffer arg1, long arg2)
    throws EOFException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void readFully(byte[] arg1)
    throws EOFException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long readHexadecimalUnsignedLong()
  {
    return 277962044L;
  }
  
  public int readInt()
  {
    return 0;
  }
  
  public int readIntLe()
  {
    return 0;
  }
  
  public long readLong()
  {
    return 277962106L;
  }
  
  public long readLongLe()
  {
    return 277962127L;
  }
  
  public short readShort()
  {
    return 0;
  }
  
  public short readShortLe()
  {
    return 0;
  }
  
  public String readString(long paramLong, Charset paramCharset)
    throws EOFException
  {
    return null;
  }
  
  public String readString(Charset paramCharset)
  {
    return null;
  }
  
  public String readUtf8()
  {
    return null;
  }
  
  public String readUtf8(long paramLong)
    throws EOFException
  {
    return readString(paramLong, Util.UTF_8);
  }
  
  public int readUtf8CodePoint()
    throws EOFException
  {
    return 0;
  }
  
  public String readUtf8Line()
    throws EOFException
  {
    return null;
  }
  
  String readUtf8Line(long paramLong)
    throws EOFException
  {
    return null;
  }
  
  public String readUtf8LineStrict()
    throws EOFException
  {
    return null;
  }
  
  public boolean request(long paramLong)
  {
    return false;
  }
  
  /* Error */
  public void require(long arg1)
    throws EOFException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  List<Integer> segmentSizes()
  {
    return null;
  }
  
  public ByteString sha1()
  {
    return digest("SHA-1");
  }
  
  public ByteString sha256()
  {
    return digest("SHA-256");
  }
  
  public long size()
  {
    return this.size;
  }
  
  /* Error */
  public void skip(long arg1)
    throws EOFException
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public ByteString snapshot()
  {
    return null;
  }
  
  public ByteString snapshot(int paramInt)
  {
    return null;
  }
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public String toString()
  {
    return null;
  }
  
  Segment writableSegment(int paramInt)
  {
    return null;
  }
  
  public Buffer write(ByteString paramByteString)
  {
    return null;
  }
  
  public Buffer write(byte[] paramArrayOfByte)
  {
    return null;
  }
  
  public Buffer write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public BufferedSink write(Source paramSource, long paramLong)
    throws IOException
  {
    return null;
  }
  
  /* Error */
  public void write(Buffer arg1, long arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public long writeAll(Source paramSource)
    throws IOException
  {
    return 277962442L;
  }
  
  public Buffer writeByte(int paramInt)
  {
    return null;
  }
  
  public Buffer writeDecimalLong(long paramLong)
  {
    return null;
  }
  
  public Buffer writeHexadecimalUnsignedLong(long paramLong)
  {
    return null;
  }
  
  public Buffer writeInt(int paramInt)
  {
    return null;
  }
  
  public Buffer writeIntLe(int paramInt)
  {
    return writeInt(Util.reverseBytesInt(paramInt));
  }
  
  public Buffer writeLong(long paramLong)
  {
    return null;
  }
  
  public Buffer writeLongLe(long paramLong)
  {
    return writeLong(Util.reverseBytesLong(paramLong));
  }
  
  public Buffer writeShort(int paramInt)
  {
    return null;
  }
  
  public Buffer writeShortLe(int paramInt)
  {
    return writeShort(Util.reverseBytesShort((short)paramInt));
  }
  
  public Buffer writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
  {
    return null;
  }
  
  public Buffer writeString(String paramString, Charset paramCharset)
  {
    return null;
  }
  
  public Buffer writeTo(OutputStream paramOutputStream)
    throws IOException
  {
    return writeTo(paramOutputStream, this.size);
  }
  
  public Buffer writeTo(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    return null;
  }
  
  public Buffer writeUtf8(String paramString)
  {
    return null;
  }
  
  public Buffer writeUtf8(String paramString, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public Buffer writeUtf8CodePoint(int paramInt)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okio\Buffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */