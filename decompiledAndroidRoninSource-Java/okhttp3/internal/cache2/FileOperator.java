package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;

@Metadata(bv={1, 0, 3}, d1={"\000&\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\004\b\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\036\020\005\032\0020\0062\006\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\bJ\036\020\f\032\0020\0062\006\020\007\032\0020\b2\006\020\r\032\0020\n2\006\020\013\032\0020\bR\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\016"}, d2={"Lokhttp3/internal/cache2/FileOperator;", "", "fileChannel", "Ljava/nio/channels/FileChannel;", "(Ljava/nio/channels/FileChannel;)V", "read", "", "pos", "", "sink", "Lokio/Buffer;", "byteCount", "write", "source", "okhttp"}, k=1, mv={1, 1, 16})
public final class FileOperator
{
  private final FileChannel fileChannel;
  
  public FileOperator(FileChannel paramFileChannel)
  {
    this.fileChannel = paramFileChannel;
  }
  
  public final void read(long paramLong1, Buffer paramBuffer, long paramLong2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    if (paramLong2 >= 0L)
    {
      while (paramLong2 > 0L)
      {
        long l = this.fileChannel.transferTo(paramLong1, paramLong2, (WritableByteChannel)paramBuffer);
        paramLong1 += l;
        paramLong2 -= l;
      }
      return;
    }
    throw ((Throwable)new IndexOutOfBoundsException());
  }
  
  public final void write(long paramLong1, Buffer paramBuffer, long paramLong2)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    if ((paramLong2 >= 0L) && (paramLong2 <= paramBuffer.size()))
    {
      long l = paramLong1;
      for (paramLong1 = paramLong2; paramLong1 > 0L; paramLong1 -= paramLong2)
      {
        paramLong2 = this.fileChannel.transferFrom((ReadableByteChannel)paramBuffer, l, paramLong1);
        l += paramLong2;
      }
      return;
    }
    throw ((Throwable)new IndexOutOfBoundsException());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\cache2\FileOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */