package okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;

@Metadata(bv={1, 0, 3}, d1={"\000P\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\020\022\n\000\n\002\020\b\n\002\b\002\n\002\030\002\n\002\030\002\n\002\020\t\n\002\b\020\n\002\020\016\n\000\n\002\030\002\n\002\b\006\bf\030\0002\0020\0012\0020\002J\b\020\003\032\0020\004H'J\b\020\007\032\0020\000H&J\b\020\b\032\0020\000H&J\b\020\t\032\0020\nH&J\b\020\013\032\0020\fH&J\020\020\r\032\0020\0002\006\020\016\032\0020\017H&J \020\r\032\0020\0002\006\020\016\032\0020\0172\006\020\020\032\0020\0212\006\020\022\032\0020\021H&J\020\020\r\032\0020\0002\006\020\023\032\0020\024H&J \020\r\032\0020\0002\006\020\023\032\0020\0242\006\020\020\032\0020\0212\006\020\022\032\0020\021H&J\030\020\r\032\0020\0002\006\020\016\032\0020\0252\006\020\022\032\0020\026H&J\020\020\027\032\0020\0262\006\020\016\032\0020\025H&J\020\020\030\032\0020\0002\006\020\031\032\0020\021H&J\020\020\032\032\0020\0002\006\020\033\032\0020\026H&J\020\020\034\032\0020\0002\006\020\033\032\0020\026H&J\020\020\035\032\0020\0002\006\020\036\032\0020\021H&J\020\020\037\032\0020\0002\006\020\036\032\0020\021H&J\020\020 \032\0020\0002\006\020\033\032\0020\026H&J\020\020!\032\0020\0002\006\020\033\032\0020\026H&J\020\020\"\032\0020\0002\006\020#\032\0020\021H&J\020\020$\032\0020\0002\006\020#\032\0020\021H&J\030\020%\032\0020\0002\006\020&\032\0020'2\006\020(\032\0020)H&J(\020%\032\0020\0002\006\020&\032\0020'2\006\020*\032\0020\0212\006\020+\032\0020\0212\006\020(\032\0020)H&J\020\020,\032\0020\0002\006\020&\032\0020'H&J \020,\032\0020\0002\006\020&\032\0020'2\006\020*\032\0020\0212\006\020+\032\0020\021H&J\020\020-\032\0020\0002\006\020.\032\0020\021H&R\022\020\003\032\0020\004X¦\004¢\006\006\032\004\b\005\020\006¨\006/"}, d2={"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "emit", "emitCompleteSegments", "flush", "", "outputStream", "Ljava/io/OutputStream;", "write", "source", "", "offset", "", "byteCount", "byteString", "Lokio/ByteString;", "Lokio/Source;", "", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", "i", "writeIntLe", "writeLong", "writeLongLe", "writeShort", "s", "writeShortLe", "writeString", "string", "", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, k=1, mv={1, 1, 16})
public abstract interface BufferedSink
  extends Sink, WritableByteChannel
{
  @Deprecated(level=DeprecationLevel.WARNING, message="moved to val: use getBuffer() instead", replaceWith=@ReplaceWith(expression="buffer", imports={}))
  public abstract Buffer buffer();
  
  public abstract BufferedSink emit()
    throws IOException;
  
  public abstract BufferedSink emitCompleteSegments()
    throws IOException;
  
  public abstract void flush()
    throws IOException;
  
  public abstract Buffer getBuffer();
  
  public abstract OutputStream outputStream();
  
  public abstract BufferedSink write(ByteString paramByteString)
    throws IOException;
  
  public abstract BufferedSink write(ByteString paramByteString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract BufferedSink write(Source paramSource, long paramLong)
    throws IOException;
  
  public abstract BufferedSink write(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract BufferedSink write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract long writeAll(Source paramSource)
    throws IOException;
  
  public abstract BufferedSink writeByte(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeDecimalLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeHexadecimalUnsignedLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeInt(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeIntLe(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeLong(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeLongLe(long paramLong)
    throws IOException;
  
  public abstract BufferedSink writeShort(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeShortLe(int paramInt)
    throws IOException;
  
  public abstract BufferedSink writeString(String paramString, int paramInt1, int paramInt2, Charset paramCharset)
    throws IOException;
  
  public abstract BufferedSink writeString(String paramString, Charset paramCharset)
    throws IOException;
  
  public abstract BufferedSink writeUtf8(String paramString)
    throws IOException;
  
  public abstract BufferedSink writeUtf8(String paramString, int paramInt1, int paramInt2)
    throws IOException;
  
  public abstract BufferedSink writeUtf8CodePoint(int paramInt)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\BufferedSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */