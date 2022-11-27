package okio;

import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\b\002\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\007\032\0020\bH\026J\030\020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\nH\026J\b\020\004\032\0020\005H\026J\b\020\016\032\0020\017H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006\020"}, d2={"Lokio/InputStreamSource;", "Lokio/Source;", "input", "Ljava/io/InputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/InputStream;Lokio/Timeout;)V", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "toString", "", "okio"}, k=1, mv={1, 1, 16})
final class InputStreamSource
  implements Source
{
  private final InputStream input;
  private final Timeout timeout;
  
  public InputStreamSource(InputStream paramInputStream, Timeout paramTimeout)
  {
    this.input = paramInputStream;
    this.timeout = paramTimeout;
  }
  
  public void close()
  {
    this.input.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    boolean bool = paramLong < 0L;
    if (!bool) {
      return 0L;
    }
    if (!bool) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool) {
      try
      {
        this.timeout.throwIfReached();
        Segment localSegment = paramBuffer.writableSegment$okio(1);
        int i = (int)Math.min(paramLong, 8192 - localSegment.limit);
        i = this.input.read(localSegment.data, localSegment.limit, i);
        if (i == -1)
        {
          if (localSegment.pos != localSegment.limit) {
            break label229;
          }
          paramBuffer.head = localSegment.pop();
          SegmentPool.INSTANCE.recycle(localSegment);
          break label229;
        }
        localSegment.limit += i;
        paramLong = paramBuffer.size();
        long l = i;
        paramBuffer.setSize$okio(paramLong + l);
        return l;
      }
      catch (AssertionError paramBuffer)
      {
        if (Okio.isAndroidGetsocknameError(paramBuffer)) {
          throw ((Throwable)new IOException((Throwable)paramBuffer));
        }
        throw ((Throwable)paramBuffer);
      }
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    label229:
    return -1L;
  }
  
  public Timeout timeout()
  {
    return this.timeout;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("source(");
    localStringBuilder.append(this.input);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\InputStreamSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */