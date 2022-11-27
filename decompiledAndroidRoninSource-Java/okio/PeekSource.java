package okio;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\t\n\000\n\002\020\002\n\002\b\004\n\002\030\002\n\000\b\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\b\020\017\032\0020\020H\026J\030\020\021\032\0020\0162\006\020\022\032\0020\0062\006\020\023\032\0020\016H\026J\b\020\024\032\0020\025H\026R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\007\032\0020\bX\016¢\006\002\n\000R\016\020\t\032\0020\nX\016¢\006\002\n\000R\020\020\013\032\004\030\0010\fX\016¢\006\002\n\000R\016\020\r\032\0020\016X\016¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\026"}, d2={"Lokio/PeekSource;", "Lokio/Source;", "upstream", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "buffer", "Lokio/Buffer;", "closed", "", "expectedPos", "", "expectedSegment", "Lokio/Segment;", "pos", "", "close", "", "read", "sink", "byteCount", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 1, 16})
public final class PeekSource
  implements Source
{
  private final Buffer buffer;
  private boolean closed;
  private int expectedPos;
  private Segment expectedSegment;
  private long pos;
  private final BufferedSource upstream;
  
  public PeekSource(BufferedSource paramBufferedSource)
  {
    this.upstream = paramBufferedSource;
    paramBufferedSource = paramBufferedSource.getBuffer();
    this.buffer = paramBufferedSource;
    this.expectedSegment = paramBufferedSource.head;
    paramBufferedSource = this.buffer.head;
    int i;
    if (paramBufferedSource != null) {
      i = paramBufferedSource.pos;
    } else {
      i = -1;
    }
    this.expectedPos = i;
  }
  
  public void close()
  {
    this.closed = true;
  }
  
  public long read(Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    int j = 0;
    boolean bool = paramLong < 0L;
    int i;
    if (!bool) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if ((this.closed ^ true))
      {
        Segment localSegment = this.expectedSegment;
        if (localSegment != null)
        {
          i = j;
          if (localSegment == this.buffer.head)
          {
            int k = this.expectedPos;
            localSegment = this.buffer.head;
            if (localSegment == null) {
              Intrinsics.throwNpe();
            }
            i = j;
            if (k != localSegment.pos) {}
          }
        }
        else
        {
          i = 1;
        }
        if (i != 0)
        {
          if (!bool) {
            return 0L;
          }
          if (!this.upstream.request(this.pos + 1L)) {
            return -1L;
          }
          if ((this.expectedSegment == null) && (this.buffer.head != null))
          {
            this.expectedSegment = this.buffer.head;
            localSegment = this.buffer.head;
            if (localSegment == null) {
              Intrinsics.throwNpe();
            }
            this.expectedPos = localSegment.pos;
          }
          paramLong = Math.min(paramLong, this.buffer.size() - this.pos);
          this.buffer.copyTo(paramBuffer, this.pos, paramLong);
          this.pos += paramLong;
          return paramLong;
        }
        throw ((Throwable)new IllegalStateException("Peek source is invalid because upstream source was used".toString()));
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
  
  public Timeout timeout()
  {
    return this.upstream.timeout();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\PeekSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */