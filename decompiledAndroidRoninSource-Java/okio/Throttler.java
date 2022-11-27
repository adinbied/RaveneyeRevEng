package okio;

import java.io.IOException;
import java.io.InterruptedIOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\002\b\b\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\007\030\0002\0020\001B\007\b\026¢\006\002\020\002B\017\b\000\022\006\020\003\032\0020\004¢\006\002\020\005J\035\020\t\032\0020\0042\006\020\n\032\0020\0042\006\020\013\032\0020\004H\000¢\006\002\b\fJ$\020\006\032\0020\r2\006\020\006\032\0020\0042\b\b\002\020\b\032\0020\0042\b\b\002\020\007\032\0020\004H\007J\016\020\016\032\0020\0172\006\020\016\032\0020\017J\016\020\020\032\0020\0212\006\020\020\032\0020\021J\025\020\022\032\0020\0042\006\020\013\032\0020\004H\000¢\006\002\b\023J\020\020\024\032\0020\r2\006\020\025\032\0020\004H\002J\f\020\026\032\0020\004*\0020\004H\002J\f\020\027\032\0020\004*\0020\004H\002R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\006\032\0020\004X\016¢\006\002\n\000R\016\020\007\032\0020\004X\016¢\006\002\n\000R\016\020\b\032\0020\004X\016¢\006\002\n\000¨\006\030"}, d2={"Lokio/Throttler;", "", "()V", "allocatedUntil", "", "(J)V", "bytesPerSecond", "maxByteCount", "waitByteCount", "byteCountOrWaitNanos", "now", "byteCount", "byteCountOrWaitNanos$okio", "", "sink", "Lokio/Sink;", "source", "Lokio/Source;", "take", "take$okio", "waitNanos", "nanosToWait", "bytesToNanos", "nanosToBytes", "okio"}, k=1, mv={1, 1, 16})
public final class Throttler
{
  private long allocatedUntil;
  private long bytesPerSecond;
  private long maxByteCount;
  private long waitByteCount;
  
  public Throttler()
  {
    this(System.nanoTime());
  }
  
  public Throttler(long paramLong)
  {
    this.allocatedUntil = paramLong;
    this.waitByteCount = 8192L;
    this.maxByteCount = 262144L;
  }
  
  private final long bytesToNanos(long paramLong)
  {
    return paramLong * 1000000000L / this.bytesPerSecond;
  }
  
  private final long nanosToBytes(long paramLong)
  {
    return paramLong * this.bytesPerSecond / 1000000000L;
  }
  
  private final void waitNanos(long paramLong)
  {
    long l = paramLong / 1000000L;
    ((Object)this).wait(l, (int)(paramLong - 1000000L * l));
  }
  
  public final long byteCountOrWaitNanos$okio(long paramLong1, long paramLong2)
  {
    if (this.bytesPerSecond == 0L) {
      return paramLong2;
    }
    long l1 = Math.max(this.allocatedUntil - paramLong1, 0L);
    long l2 = this.maxByteCount - nanosToBytes(l1);
    if (l2 >= paramLong2)
    {
      this.allocatedUntil = (paramLong1 + l1 + bytesToNanos(paramLong2));
      return paramLong2;
    }
    long l3 = this.waitByteCount;
    if (l2 >= l3)
    {
      this.allocatedUntil = (paramLong1 + bytesToNanos(this.maxByteCount));
      return l2;
    }
    paramLong2 = Math.min(l3, paramLong2);
    l1 += bytesToNanos(paramLong2 - this.maxByteCount);
    if (l1 == 0L)
    {
      this.allocatedUntil = (paramLong1 + bytesToNanos(this.maxByteCount));
      return paramLong2;
    }
    return -l1;
  }
  
  public final void bytesPerSecond(long paramLong)
  {
    bytesPerSecond$default(this, paramLong, 0L, 0L, 6, null);
  }
  
  public final void bytesPerSecond(long paramLong1, long paramLong2)
  {
    bytesPerSecond$default(this, paramLong1, paramLong2, 0L, 4, null);
  }
  
  public final void bytesPerSecond(long paramLong1, long paramLong2, long paramLong3)
  {
    int j = 1;
    int i;
    if (paramLong1 >= 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (paramLong2 > 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramLong3 >= paramLong2) {
          i = j;
        } else {
          i = 0;
        }
        if (i == 0) {}
      }
    }
    try
    {
      this.bytesPerSecond = paramLong1;
      this.waitByteCount = paramLong2;
      this.maxByteCount = paramLong3;
      ((Object)this).notifyAll();
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally {}
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  public final Sink sink(final Sink paramSink)
  {
    Intrinsics.checkParameterIsNotNull(paramSink, "sink");
    (Sink)new ForwardingSink(paramSink)
    {
      public void write(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousBuffer, "source");
        for (;;)
        {
          if (paramAnonymousLong <= 0L) {
            break label56;
          }
          try
          {
            long l = this.this$0.take$okio(paramAnonymousLong);
            super.write(paramAnonymousBuffer, l);
            paramAnonymousLong -= l;
          }
          catch (InterruptedException paramAnonymousBuffer)
          {
            for (;;) {}
          }
        }
        Thread.currentThread().interrupt();
        throw ((Throwable)new InterruptedIOException("interrupted"));
        label56:
      }
    };
  }
  
  public final Source source(final Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    (Source)new ForwardingSource(paramSource)
    {
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousBuffer, "sink");
        try
        {
          paramAnonymousLong = super.read(paramAnonymousBuffer, this.this$0.take$okio(paramAnonymousLong));
          return paramAnonymousLong;
        }
        catch (InterruptedException paramAnonymousBuffer)
        {
          for (;;) {}
        }
        Thread.currentThread().interrupt();
        throw ((Throwable)new InterruptedIOException("interrupted"));
      }
    };
  }
  
  public final long take$okio(long paramLong)
  {
    int i;
    if (paramLong > 0L) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      try
      {
        for (;;)
        {
          long l = byteCountOrWaitNanos$okio(System.nanoTime(), paramLong);
          if (l >= 0L) {
            return l;
          }
          l = -l;
          waitNanos(l);
        }
        throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      }
      finally {}
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\Throttler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */