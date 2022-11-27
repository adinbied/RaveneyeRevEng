package okio;

import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000B\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\002\b\006\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\000\030\0002\0020\001B\027\b\026\022\006\020\002\032\0020\001\022\006\020\003\032\0020\004¢\006\002\020\005B\027\b\000\022\006\020\002\032\0020\006\022\006\020\003\032\0020\004¢\006\002\020\007J\b\020\n\032\0020\013H\026J\020\020\f\032\0020\0132\006\020\r\032\0020\tH\003J\r\020\016\032\0020\013H\000¢\006\002\b\017J\b\020\020\032\0020\013H\026J\b\020\021\032\0020\022H\026J\b\020\023\032\0020\024H\026J\030\020\025\032\0020\0132\006\020\026\032\0020\0272\006\020\030\032\0020\031H\026R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000R\016\020\002\032\0020\006X\004¢\006\002\n\000¨\006\032"}, d2={"Lokio/DeflaterSink;", "Lokio/Sink;", "sink", "deflater", "Ljava/util/zip/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)V", "Lokio/BufferedSink;", "(Lokio/BufferedSink;Ljava/util/zip/Deflater;)V", "closed", "", "close", "", "deflate", "syncFlush", "finishDeflate", "finishDeflate$okio", "flush", "timeout", "Lokio/Timeout;", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, k=1, mv={1, 1, 16})
public final class DeflaterSink
  implements Sink
{
  private boolean closed;
  private final Deflater deflater;
  private final BufferedSink sink;
  
  public DeflaterSink(BufferedSink paramBufferedSink, Deflater paramDeflater)
  {
    this.sink = paramBufferedSink;
    this.deflater = paramDeflater;
  }
  
  public DeflaterSink(Sink paramSink, Deflater paramDeflater)
  {
    this(Okio.buffer(paramSink), paramDeflater);
  }
  
  private final void deflate(boolean paramBoolean)
  {
    Buffer localBuffer = this.sink.getBuffer();
    Segment localSegment;
    do
    {
      for (;;)
      {
        localSegment = localBuffer.writableSegment$okio(1);
        int i;
        if (paramBoolean) {
          i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit, 2);
        } else {
          i = this.deflater.deflate(localSegment.data, localSegment.limit, 8192 - localSegment.limit);
        }
        if (i <= 0) {
          break;
        }
        localSegment.limit += i;
        localBuffer.setSize$okio(localBuffer.size() + i);
        this.sink.emitCompleteSegments();
      }
    } while (!this.deflater.needsInput());
    if (localSegment.pos == localSegment.limit)
    {
      localBuffer.head = localSegment.pop();
      SegmentPool.INSTANCE.recycle(localSegment);
    }
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	okio/DeflaterSink:closed	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: checkcast 141	java/lang/Throwable
    //   12: astore_2
    //   13: aload_0
    //   14: invokevirtual 143	okio/DeflaterSink:finishDeflate$okio	()V
    //   17: goto +4 -> 21
    //   20: astore_2
    //   21: aload_0
    //   22: getfield 58	okio/DeflaterSink:deflater	Ljava/util/zip/Deflater;
    //   25: invokevirtual 146	java/util/zip/Deflater:end	()V
    //   28: aload_2
    //   29: astore_1
    //   30: goto +12 -> 42
    //   33: astore_3
    //   34: aload_2
    //   35: astore_1
    //   36: aload_2
    //   37: ifnonnull +5 -> 42
    //   40: aload_3
    //   41: astore_1
    //   42: aload_0
    //   43: getfield 56	okio/DeflaterSink:sink	Lokio/BufferedSink;
    //   46: invokeinterface 148 1 0
    //   51: aload_1
    //   52: astore_2
    //   53: goto +12 -> 65
    //   56: astore_3
    //   57: aload_1
    //   58: astore_2
    //   59: aload_1
    //   60: ifnonnull +5 -> 65
    //   63: aload_3
    //   64: astore_2
    //   65: aload_0
    //   66: iconst_1
    //   67: putfield 139	okio/DeflaterSink:closed	Z
    //   70: aload_2
    //   71: ifnonnull +4 -> 75
    //   74: return
    //   75: aload_2
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	DeflaterSink
    //   29	31	1	localObject1	Object
    //   12	1	2	localThrowable	Throwable
    //   20	17	2	localObject2	Object
    //   52	24	2	localObject3	Object
    //   33	8	3	localObject4	Object
    //   56	8	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   13	17	20	finally
    //   21	28	33	finally
    //   42	51	56	finally
  }
  
  public final void finishDeflate$okio()
  {
    this.deflater.finish();
    deflate(false);
  }
  
  public void flush()
    throws IOException
  {
    deflate(true);
    this.sink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeflaterSink(");
    localStringBuilder.append(this.sink);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    -Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
    while (paramLong > 0L)
    {
      Segment localSegment = paramBuffer.head;
      if (localSegment == null) {
        Intrinsics.throwNpe();
      }
      int i = (int)Math.min(paramLong, localSegment.limit - localSegment.pos);
      this.deflater.setInput(localSegment.data, localSegment.pos, i);
      deflate(false);
      long l1 = paramBuffer.size();
      long l2 = i;
      paramBuffer.setSize$okio(l1 - l2);
      localSegment.pos += i;
      if (localSegment.pos == localSegment.limit)
      {
        paramBuffer.head = localSegment.pop();
        SegmentPool.INSTANCE.recycle(localSegment);
      }
      paramLong -= l2;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\DeflaterSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */