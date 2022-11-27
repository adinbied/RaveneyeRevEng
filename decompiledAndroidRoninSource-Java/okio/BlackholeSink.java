package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\000\b\000\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026J\b\020\005\032\0020\004H\026J\b\020\006\032\0020\007H\026J\030\020\b\032\0020\0042\006\020\t\032\0020\n2\006\020\013\032\0020\fH\026¨\006\r"}, d2={"Lokio/BlackholeSink;", "Lokio/Sink;", "()V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public final class BlackholeSink
  implements Sink
{
  public void close() {}
  
  public void flush() {}
  
  public Timeout timeout()
  {
    return Timeout.NONE;
  }
  
  public void write(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    paramBuffer.skip(paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\BlackholeSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */