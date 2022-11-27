package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\bf\030\0002\0020\001J\b\020\002\032\0020\003H&J\030\020\004\032\0020\0052\006\020\006\032\0020\0072\006\020\b\032\0020\005H&J\b\020\t\032\0020\nH&¨\006\013"}, d2={"Lokio/Source;", "Ljava/io/Closeable;", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 1, 16})
public abstract interface Source
  extends Closeable
{
  public abstract void close()
    throws IOException;
  
  public abstract long read(Buffer paramBuffer, long paramLong)
    throws IOException;
  
  public abstract Timeout timeout();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Source.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */