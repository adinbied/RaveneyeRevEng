package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\013\n\000\n\002\020\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\030\0002\0020\001B\027\b\026\022\006\020\002\032\0020\001\022\006\020\003\032\0020\004¢\006\002\020\005B\027\b\000\022\006\020\002\032\0020\006\022\006\020\003\032\0020\004¢\006\002\020\007J\b\020\f\032\0020\rH\026J\030\020\016\032\0020\0172\006\020\020\032\0020\0212\006\020\022\032\0020\017H\026J\006\020\023\032\0020\013J\b\020\024\032\0020\rH\002J\b\020\025\032\0020\026H\026R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\n\032\0020\013X\016¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\002\032\0020\006X\004¢\006\002\n\000¨\006\027"}, d2={"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "refill", "releaseInflatedBytes", "timeout", "Lokio/Timeout;", "okio"}, k=1, mv={1, 1, 16})
public final class InflaterSource
  implements Source
{
  private int bufferBytesHeldByInflater;
  private boolean closed;
  private final Inflater inflater;
  private final BufferedSource source;
  
  public InflaterSource(BufferedSource paramBufferedSource, Inflater paramInflater)
  {
    this.source = paramBufferedSource;
    this.inflater = paramInflater;
  }
  
  public InflaterSource(Source paramSource, Inflater paramInflater)
  {
    this(Okio.buffer(paramSource), paramInflater);
  }
  
  private final void releaseInflatedBytes()
  {
    int i = this.bufferBytesHeldByInflater;
    if (i == 0) {
      return;
    }
    i -= this.inflater.getRemaining();
    this.bufferBytesHeldByInflater -= i;
    this.source.skip(i);
  }
  
  public void close()
    throws IOException
  {
    if (this.closed) {
      return;
    }
    this.inflater.end();
    this.closed = true;
    this.source.close();
  }
  
  public long read(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
    boolean bool1 = paramLong < 0L;
    int i;
    if (!bool1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      if ((this.closed ^ true)) {
        if (!bool1) {
          return 0L;
        }
      }
    }
    for (;;)
    {
      boolean bool2 = refill();
      label172:
      do
      {
        try
        {
          Segment localSegment = paramBuffer.writableSegment$okio(1);
          i = (int)Math.min(paramLong, 8192 - localSegment.limit);
          i = this.inflater.inflate(localSegment.data, localSegment.limit, i);
          if (i > 0)
          {
            localSegment.limit += i;
            paramLong = paramBuffer.size();
            long l = i;
            paramBuffer.setSize$okio(paramLong + l);
            return l;
          }
          if (!this.inflater.finished())
          {
            if (!this.inflater.needsDictionary()) {
              continue;
            }
            break label172;
            throw ((Throwable)new EOFException("source exhausted prematurely"));
          }
          releaseInflatedBytes();
          if (localSegment.pos == localSegment.limit)
          {
            paramBuffer.head = localSegment.pop();
            SegmentPool.INSTANCE.recycle(localSegment);
          }
          return -1L;
        }
        catch (DataFormatException paramBuffer)
        {
          throw ((Throwable)new IOException((Throwable)paramBuffer));
        }
        throw ((Throwable)new IllegalStateException("closed".toString()));
        paramBuffer = new StringBuilder();
        paramBuffer.append("byteCount < 0: ");
        paramBuffer.append(paramLong);
        throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
      } while (bool2);
    }
  }
  
  public final boolean refill()
    throws IOException
  {
    if (!this.inflater.needsInput()) {
      return false;
    }
    releaseInflatedBytes();
    int i;
    if (this.inflater.getRemaining() == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.source.exhausted()) {
        return true;
      }
      Segment localSegment = this.source.getBuffer().head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      this.bufferBytesHeldByInflater = (localSegment.limit - localSegment.pos);
      this.inflater.setInput(localSegment.data, localSegment.pos, this.bufferBytesHeldByInflater);
      return false;
    }
    throw ((Throwable)new IllegalStateException("?".toString()));
  }
  
  public Timeout timeout()
  {
    return this.source.timeout();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\InflaterSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */