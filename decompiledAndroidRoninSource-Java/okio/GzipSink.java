package okio;

import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000H\n\002\030\002\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\000\n\002\020\002\n\002\b\003\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\002\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\001¢\006\002\020\003J\b\020\016\032\0020\017H\026J\r\020\b\032\0020\tH\007¢\006\002\b\020J\b\020\021\032\0020\017H\026J\b\020\022\032\0020\023H\026J\030\020\024\032\0020\0172\006\020\025\032\0020\0262\006\020\027\032\0020\030H\002J\030\020\031\032\0020\0172\006\020\032\032\0020\0262\006\020\027\032\0020\030H\026J\b\020\033\032\0020\017H\002R\016\020\004\032\0020\005X\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\023\020\b\032\0020\t8G¢\006\b\n\000\032\004\b\b\020\nR\016\020\013\032\0020\fX\004¢\006\002\n\000R\016\020\002\032\0020\rX\004¢\006\002\n\000¨\006\034"}, d2={"Lokio/GzipSink;", "Lokio/Sink;", "sink", "(Lokio/Sink;)V", "closed", "", "crc", "Ljava/util/zip/CRC32;", "deflater", "Ljava/util/zip/Deflater;", "()Ljava/util/zip/Deflater;", "deflaterSink", "Lokio/DeflaterSink;", "Lokio/RealBufferedSink;", "close", "", "-deprecated_deflater", "flush", "timeout", "Lokio/Timeout;", "updateCrc", "buffer", "Lokio/Buffer;", "byteCount", "", "write", "source", "writeFooter", "okio"}, k=1, mv={1, 1, 16})
public final class GzipSink
  implements Sink
{
  private boolean closed;
  private final CRC32 crc;
  private final Deflater deflater;
  private final DeflaterSink deflaterSink;
  private final RealBufferedSink sink;
  
  public GzipSink(Sink paramSink)
  {
    this.sink = new RealBufferedSink(paramSink);
    paramSink = new Deflater(-1, true);
    this.deflater = paramSink;
    this.deflaterSink = new DeflaterSink((BufferedSink)this.sink, paramSink);
    this.crc = new CRC32();
    paramSink = this.sink.bufferField;
    paramSink.writeShort(8075);
    paramSink.writeByte(8);
    paramSink.writeByte(0);
    paramSink.writeInt(0);
    paramSink.writeByte(0);
    paramSink.writeByte(0);
  }
  
  private final void updateCrc(Buffer paramBuffer, long paramLong)
  {
    Segment localSegment = paramBuffer.head;
    paramBuffer = localSegment;
    long l = paramLong;
    if (localSegment == null)
    {
      Intrinsics.throwNpe();
      l = paramLong;
      paramBuffer = localSegment;
    }
    while (l > 0L)
    {
      int i = (int)Math.min(l, paramBuffer.limit - paramBuffer.pos);
      this.crc.update(paramBuffer.data, paramBuffer.pos, i);
      paramLong = l - i;
      localSegment = paramBuffer.next;
      paramBuffer = localSegment;
      l = paramLong;
      if (localSegment == null)
      {
        Intrinsics.throwNpe();
        paramBuffer = localSegment;
        l = paramLong;
      }
    }
  }
  
  private final void writeFooter()
  {
    this.sink.writeIntLe((int)this.crc.getValue());
    this.sink.writeIntLe((int)this.deflater.getBytesRead());
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="deflater", imports={}))
  public final Deflater -deprecated_deflater()
  {
    return this.deflater;
  }
  
  /* Error */
  public void close()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 159	okio/GzipSink:closed	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: aconst_null
    //   9: checkcast 161	java/lang/Throwable
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 78	okio/GzipSink:deflaterSink	Lokio/DeflaterSink;
    //   17: invokevirtual 164	okio/DeflaterSink:finishDeflate$okio	()V
    //   20: aload_0
    //   21: invokespecial 166	okio/GzipSink:writeFooter	()V
    //   24: goto +4 -> 28
    //   27: astore_2
    //   28: aload_0
    //   29: getfield 69	okio/GzipSink:deflater	Ljava/util/zip/Deflater;
    //   32: invokevirtual 169	java/util/zip/Deflater:end	()V
    //   35: aload_2
    //   36: astore_1
    //   37: goto +12 -> 49
    //   40: astore_3
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: ifnonnull +5 -> 49
    //   47: aload_3
    //   48: astore_1
    //   49: aload_0
    //   50: getfield 62	okio/GzipSink:sink	Lokio/RealBufferedSink;
    //   53: invokevirtual 171	okio/RealBufferedSink:close	()V
    //   56: aload_1
    //   57: astore_2
    //   58: goto +12 -> 70
    //   61: astore_3
    //   62: aload_1
    //   63: astore_2
    //   64: aload_1
    //   65: ifnonnull +5 -> 70
    //   68: aload_3
    //   69: astore_2
    //   70: aload_0
    //   71: iconst_1
    //   72: putfield 159	okio/GzipSink:closed	Z
    //   75: aload_2
    //   76: ifnonnull +4 -> 80
    //   79: return
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	GzipSink
    //   36	29	1	localObject1	Object
    //   12	1	2	localThrowable	Throwable
    //   27	17	2	localObject2	Object
    //   57	24	2	localObject3	Object
    //   40	8	3	localObject4	Object
    //   61	8	3	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   13	24	27	finally
    //   28	35	40	finally
    //   49	56	61	finally
  }
  
  public final Deflater deflater()
  {
    return this.deflater;
  }
  
  public void flush()
    throws IOException
  {
    this.deflaterSink.flush();
  }
  
  public Timeout timeout()
  {
    return this.sink.timeout();
  }
  
  public void write(Buffer paramBuffer, long paramLong)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    boolean bool = paramLong < 0L;
    int i;
    if (!bool) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (!bool) {
        return;
      }
      updateCrc(paramBuffer, paramLong);
      this.deflaterSink.write(paramBuffer, paramLong);
      return;
    }
    paramBuffer = new StringBuilder();
    paramBuffer.append("byteCount < 0: ");
    paramBuffer.append(paramLong);
    throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\GzipSink.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */