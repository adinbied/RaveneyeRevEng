package okio.internal;

import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000D\n\000\n\002\020\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\022\n\000\n\002\020\b\n\000\n\002\030\002\n\002\020\t\n\000\n\002\030\002\n\002\030\002\n\002\b\025\032\r\020\000\032\0020\001*\0020\002H\b\032\r\020\003\032\0020\004*\0020\002H\b\032\r\020\005\032\0020\004*\0020\002H\b\032\r\020\006\032\0020\001*\0020\002H\b\032\r\020\007\032\0020\b*\0020\002H\b\032\r\020\t\032\0020\n*\0020\002H\b\032\025\020\013\032\0020\004*\0020\0022\006\020\f\032\0020\rH\b\032%\020\013\032\0020\004*\0020\0022\006\020\f\032\0020\r2\006\020\016\032\0020\0172\006\020\020\032\0020\017H\b\032\035\020\013\032\0020\001*\0020\0022\006\020\f\032\0020\0212\006\020\020\032\0020\022H\b\032\025\020\013\032\0020\004*\0020\0022\006\020\023\032\0020\024H\b\032%\020\013\032\0020\004*\0020\0022\006\020\023\032\0020\0242\006\020\016\032\0020\0172\006\020\020\032\0020\017H\b\032\035\020\013\032\0020\004*\0020\0022\006\020\f\032\0020\0252\006\020\020\032\0020\022H\b\032\025\020\026\032\0020\022*\0020\0022\006\020\f\032\0020\025H\b\032\025\020\027\032\0020\004*\0020\0022\006\020\030\032\0020\017H\b\032\025\020\031\032\0020\004*\0020\0022\006\020\032\032\0020\022H\b\032\025\020\033\032\0020\004*\0020\0022\006\020\032\032\0020\022H\b\032\025\020\034\032\0020\004*\0020\0022\006\020\035\032\0020\017H\b\032\025\020\036\032\0020\004*\0020\0022\006\020\035\032\0020\017H\b\032\025\020\037\032\0020\004*\0020\0022\006\020\032\032\0020\022H\b\032\025\020 \032\0020\004*\0020\0022\006\020\032\032\0020\022H\b\032\025\020!\032\0020\004*\0020\0022\006\020\"\032\0020\017H\b\032\025\020#\032\0020\004*\0020\0022\006\020\"\032\0020\017H\b\032\025\020$\032\0020\004*\0020\0022\006\020%\032\0020\nH\b\032%\020$\032\0020\004*\0020\0022\006\020%\032\0020\n2\006\020&\032\0020\0172\006\020'\032\0020\017H\b\032\025\020(\032\0020\004*\0020\0022\006\020)\032\0020\017H\b¨\006*"}, d2={"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", "i", "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", "s", "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, k=2, mv={1, 1, 16})
public final class RealBufferedSinkKt
{
  /* Error */
  public static final void commonClose(RealBufferedSink paramRealBufferedSink)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 58
    //   3: invokestatic 64	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   6: aload_0
    //   7: getfield 70	okio/RealBufferedSink:closed	Z
    //   10: ifeq +4 -> 14
    //   13: return
    //   14: aconst_null
    //   15: checkcast 72	java/lang/Throwable
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: getfield 75	okio/RealBufferedSink:bufferField	Lokio/Buffer;
    //   25: invokevirtual 81	okio/Buffer:size	()J
    //   28: lconst_0
    //   29: lcmp
    //   30: ifle +29 -> 59
    //   33: aload_0
    //   34: getfield 85	okio/RealBufferedSink:sink	Lokio/Sink;
    //   37: aload_0
    //   38: getfield 75	okio/RealBufferedSink:bufferField	Lokio/Buffer;
    //   41: aload_0
    //   42: getfield 75	okio/RealBufferedSink:bufferField	Lokio/Buffer;
    //   45: invokevirtual 81	okio/Buffer:size	()J
    //   48: invokeinterface 91 4 0
    //   53: aload_2
    //   54: astore_1
    //   55: goto +4 -> 59
    //   58: astore_1
    //   59: aload_0
    //   60: getfield 85	okio/RealBufferedSink:sink	Lokio/Sink;
    //   63: invokeinterface 95 1 0
    //   68: aload_1
    //   69: astore_2
    //   70: goto +12 -> 82
    //   73: astore_3
    //   74: aload_1
    //   75: astore_2
    //   76: aload_1
    //   77: ifnonnull +5 -> 82
    //   80: aload_3
    //   81: astore_2
    //   82: aload_0
    //   83: iconst_1
    //   84: putfield 70	okio/RealBufferedSink:closed	Z
    //   87: aload_2
    //   88: ifnonnull +4 -> 92
    //   91: return
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	paramRealBufferedSink	RealBufferedSink
    //   20	35	1	localObject1	Object
    //   58	19	1	localObject2	Object
    //   18	75	2	localObject3	Object
    //   73	8	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   21	53	58	finally
    //   59	68	73	finally
  }
  
  public static final BufferedSink commonEmit(RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonEmit");
    if ((paramRealBufferedSink.closed ^ true))
    {
      long l = paramRealBufferedSink.bufferField.size();
      if (l > 0L) {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, l);
      }
      return (BufferedSink)paramRealBufferedSink;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonEmitCompleteSegments(RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonEmitCompleteSegments");
    if ((paramRealBufferedSink.closed ^ true))
    {
      long l = paramRealBufferedSink.bufferField.completeSegmentByteCount();
      if (l > 0L) {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, l);
      }
      return (BufferedSink)paramRealBufferedSink;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final void commonFlush(RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonFlush");
    if ((paramRealBufferedSink.closed ^ true))
    {
      if (paramRealBufferedSink.bufferField.size() > 0L) {
        paramRealBufferedSink.sink.write(paramRealBufferedSink.bufferField, paramRealBufferedSink.bufferField.size());
      }
      paramRealBufferedSink.sink.flush();
      return;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final Timeout commonTimeout(RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonTimeout");
    return paramRealBufferedSink.sink.timeout();
  }
  
  public static final String commonToString(RealBufferedSink paramRealBufferedSink)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonToString");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("buffer(");
    localStringBuilder.append(paramRealBufferedSink.sink);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public static final BufferedSink commonWrite(RealBufferedSink paramRealBufferedSink, ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramByteString);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWrite(RealBufferedSink paramRealBufferedSink, ByteString paramByteString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramByteString, "byteString");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramByteString, paramInt1, paramInt2);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWrite(RealBufferedSink paramRealBufferedSink, Source paramSource, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    while (paramLong > 0L)
    {
      long l = paramSource.read(paramRealBufferedSink.bufferField, paramLong);
      if (l != -1L)
      {
        paramLong -= l;
        paramRealBufferedSink.emitCompleteSegments();
      }
      else
      {
        throw ((Throwable)new EOFException());
      }
    }
    return (BufferedSink)paramRealBufferedSink;
  }
  
  public static final BufferedSink commonWrite(RealBufferedSink paramRealBufferedSink, byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramArrayOfByte);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWrite(RealBufferedSink paramRealBufferedSink, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "source");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramArrayOfByte, paramInt1, paramInt2);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final void commonWrite(RealBufferedSink paramRealBufferedSink, Buffer paramBuffer, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWrite");
    Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.write(paramBuffer, paramLong);
      paramRealBufferedSink.emitCompleteSegments();
      return;
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final long commonWriteAll(RealBufferedSink paramRealBufferedSink, Source paramSource)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteAll");
    Intrinsics.checkParameterIsNotNull(paramSource, "source");
    long l1 = 0L;
    for (;;)
    {
      long l2 = paramSource.read(paramRealBufferedSink.bufferField, ' ');
      if (l2 == -1L) {
        return l1;
      }
      l1 += l2;
      paramRealBufferedSink.emitCompleteSegments();
    }
  }
  
  public static final BufferedSink commonWriteByte(RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteByte");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeByte(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteDecimalLong(RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteDecimalLong");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeDecimalLong(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteHexadecimalUnsignedLong(RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeHexadecimalUnsignedLong(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteInt(RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteInt");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeInt(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteIntLe(RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteIntLe");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeIntLe(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteLong(RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteLong");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeLong(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteLongLe(RealBufferedSink paramRealBufferedSink, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteLongLe");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeLongLe(paramLong);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteShort(RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteShort");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeShort(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteShortLe(RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteShortLe");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeShortLe(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteUtf8(RealBufferedSink paramRealBufferedSink, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteUtf8");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeUtf8(paramString);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteUtf8(RealBufferedSink paramRealBufferedSink, String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteUtf8");
    Intrinsics.checkParameterIsNotNull(paramString, "string");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeUtf8(paramString, paramInt1, paramInt2);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
  
  public static final BufferedSink commonWriteUtf8CodePoint(RealBufferedSink paramRealBufferedSink, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramRealBufferedSink, "$this$commonWriteUtf8CodePoint");
    if ((paramRealBufferedSink.closed ^ true))
    {
      paramRealBufferedSink.bufferField.writeUtf8CodePoint(paramInt);
      return paramRealBufferedSink.emitCompleteSegments();
    }
    throw ((Throwable)new IllegalStateException("closed".toString()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okio\internal\RealBufferedSinkKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */