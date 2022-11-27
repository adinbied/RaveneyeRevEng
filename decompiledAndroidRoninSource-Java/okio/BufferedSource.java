package okio;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(bv={1, 0, 3}, d1={"\000v\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\020\t\n\000\n\002\020\005\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\020\b\n\002\b\003\n\002\020\022\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\006\n\002\020\n\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\002\b\t\n\002\030\002\n\002\b\002\bf\030\0002\0020\0012\0020\002J\b\020\003\032\0020\004H'J\b\020\007\032\0020\bH&J\020\020\t\032\0020\n2\006\020\013\032\0020\fH&J\030\020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\nH&J \020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\n2\006\020\016\032\0020\nH&J\020\020\t\032\0020\n2\006\020\017\032\0020\020H&J\030\020\t\032\0020\n2\006\020\017\032\0020\0202\006\020\r\032\0020\nH&J\020\020\021\032\0020\n2\006\020\022\032\0020\020H&J\030\020\021\032\0020\n2\006\020\022\032\0020\0202\006\020\r\032\0020\nH&J\b\020\023\032\0020\024H&J\b\020\025\032\0020\000H&J\030\020\026\032\0020\b2\006\020\027\032\0020\n2\006\020\017\032\0020\020H&J(\020\026\032\0020\b2\006\020\027\032\0020\n2\006\020\017\032\0020\0202\006\020\030\032\0020\0312\006\020\032\032\0020\031H&J\020\020\033\032\0020\0312\006\020\034\032\0020\035H&J \020\033\032\0020\0312\006\020\034\032\0020\0352\006\020\027\032\0020\0312\006\020\032\032\0020\031H&J\020\020\036\032\0020\n2\006\020\034\032\0020\037H&J\b\020 \032\0020\fH&J\b\020!\032\0020\035H&J\020\020!\032\0020\0352\006\020\032\032\0020\nH&J\b\020\"\032\0020\020H&J\020\020\"\032\0020\0202\006\020\032\032\0020\nH&J\b\020#\032\0020\nH&J\020\020$\032\0020%2\006\020\034\032\0020\035H&J\030\020$\032\0020%2\006\020\034\032\0020\0042\006\020\032\032\0020\nH&J\b\020&\032\0020\nH&J\b\020'\032\0020\031H&J\b\020(\032\0020\031H&J\b\020)\032\0020\nH&J\b\020*\032\0020\nH&J\b\020+\032\0020,H&J\b\020-\032\0020,H&J\020\020.\032\0020/2\006\0200\032\00201H&J\030\020.\032\0020/2\006\020\032\032\0020\n2\006\0200\032\00201H&J\b\0202\032\0020/H&J\020\0202\032\0020/2\006\020\032\032\0020\nH&J\b\0203\032\0020\031H&J\n\0204\032\004\030\0010/H&J\b\0205\032\0020/H&J\020\0205\032\0020/2\006\0206\032\0020\nH&J\020\0207\032\0020\b2\006\020\032\032\0020\nH&J\020\0208\032\0020%2\006\020\032\032\0020\nH&J\020\0209\032\0020\0312\006\020:\032\0020;H&J\020\020<\032\0020%2\006\020\032\032\0020\nH&R\022\020\003\032\0020\004X¦\004¢\006\006\032\004\b\005\020\006¨\006="}, d2={"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "exhausted", "", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", "request", "require", "select", "options", "Lokio/Options;", "skip", "okio"}, k=1, mv={1, 1, 16})
public abstract interface BufferedSource
  extends Source, ReadableByteChannel
{
  @Deprecated(level=DeprecationLevel.WARNING, message="moved to val: use getBuffer() instead", replaceWith=@ReplaceWith(expression="buffer", imports={}))
  public abstract Buffer buffer();
  
  public abstract boolean exhausted()
    throws IOException;
  
  public abstract Buffer getBuffer();
  
  public abstract long indexOf(byte paramByte)
    throws IOException;
  
  public abstract long indexOf(byte paramByte, long paramLong)
    throws IOException;
  
  public abstract long indexOf(byte paramByte, long paramLong1, long paramLong2)
    throws IOException;
  
  public abstract long indexOf(ByteString paramByteString)
    throws IOException;
  
  public abstract long indexOf(ByteString paramByteString, long paramLong)
    throws IOException;
  
  public abstract long indexOfElement(ByteString paramByteString)
    throws IOException;
  
  public abstract long indexOfElement(ByteString paramByteString, long paramLong)
    throws IOException;
  
  public abstract InputStream inputStream();
  
  public abstract BufferedSource peek();
  
  public abstract boolean rangeEquals(long paramLong, ByteString paramByteString)
    throws IOException;
  
  public abstract boolean rangeEquals(long paramLong, ByteString paramByteString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract long readAll(Sink paramSink)
    throws IOException;
  
  public abstract byte readByte()
    throws IOException;
  
  public abstract byte[] readByteArray()
    throws IOException;
  
  public abstract byte[] readByteArray(long paramLong)
    throws IOException;
  
  public abstract ByteString readByteString()
    throws IOException;
  
  public abstract ByteString readByteString(long paramLong)
    throws IOException;
  
  public abstract long readDecimalLong()
    throws IOException;
  
  public abstract void readFully(Buffer paramBuffer, long paramLong)
    throws IOException;
  
  public abstract void readFully(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract long readHexadecimalUnsignedLong()
    throws IOException;
  
  public abstract int readInt()
    throws IOException;
  
  public abstract int readIntLe()
    throws IOException;
  
  public abstract long readLong()
    throws IOException;
  
  public abstract long readLongLe()
    throws IOException;
  
  public abstract short readShort()
    throws IOException;
  
  public abstract short readShortLe()
    throws IOException;
  
  public abstract String readString(long paramLong, Charset paramCharset)
    throws IOException;
  
  public abstract String readString(Charset paramCharset)
    throws IOException;
  
  public abstract String readUtf8()
    throws IOException;
  
  public abstract String readUtf8(long paramLong)
    throws IOException;
  
  public abstract int readUtf8CodePoint()
    throws IOException;
  
  public abstract String readUtf8Line()
    throws IOException;
  
  public abstract String readUtf8LineStrict()
    throws IOException;
  
  public abstract String readUtf8LineStrict(long paramLong)
    throws IOException;
  
  public abstract boolean request(long paramLong)
    throws IOException;
  
  public abstract void require(long paramLong)
    throws IOException;
  
  public abstract int select(Options paramOptions)
    throws IOException;
  
  public abstract void skip(long paramLong)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\BufferedSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */