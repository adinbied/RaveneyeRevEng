package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000\001\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\006\n\002\020\t\n\002\b\t\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\013\n\002\020\002\n\002\b\f\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\b\n\002\020 \n\002\030\002\n\002\b\006\030\000 _2\0020\001:\004_`abB1\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\007\022\b\020\t\032\004\030\0010\n¢\006\002\020\013J\016\020@\032\0020A2\006\020B\032\0020#J\r\020C\032\0020AH\000¢\006\002\bDJ\r\020E\032\0020AH\000¢\006\002\bFJ\030\020G\032\0020A2\006\020H\032\0020\0172\b\020\024\032\004\030\0010\025J\032\020I\032\0020\0072\006\020\016\032\0020\0172\b\020\024\032\004\030\0010\025H\002J\016\020J\032\0020A2\006\020\016\032\0020\017J\016\020K\032\0020A2\006\020L\032\0020\nJ\006\020M\032\0020NJ\006\020O\032\0020PJ\006\020,\032\0020QJ\026\020R\032\0020A2\006\0204\032\0020S2\006\020T\032\0020\003J\026\020U\032\0020A2\006\020\t\032\0020\n2\006\020\b\032\0020\007J\016\020V\032\0020A2\006\020\016\032\0020\017J\006\020W\032\0020\nJ\006\020L\032\0020\nJ\r\020X\032\0020AH\000¢\006\002\bYJ$\020Z\032\0020A2\f\020[\032\b\022\004\022\0020]0\\2\006\020\006\032\0020\0072\006\020^\032\0020\007J\006\020>\032\0020QR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\f\020\rR\036\020\016\032\004\030\0010\0178@X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\034\020\024\032\004\030\0010\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031R\016\020\032\032\0020\007X\016¢\006\002\n\000R\024\020\033\032\b\022\004\022\0020\n0\034X\004¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\035\020\036R\021\020\037\032\0020\0078F¢\006\006\032\004\b\037\020 R\021\020!\032\0020\0078F¢\006\006\032\004\b!\020 R$\020$\032\0020#2\006\020\"\032\0020#@@X\016¢\006\016\n\000\032\004\b%\020&\"\004\b'\020(R$\020)\032\0020#2\006\020\"\032\0020#@@X\016¢\006\016\n\000\032\004\b*\020&\"\004\b+\020(R\030\020,\032\0060-R\0020\000X\004¢\006\b\n\000\032\004\b.\020/R\030\0200\032\00601R\0020\000X\004¢\006\b\n\000\032\004\b2\0203R\030\0204\032\00605R\0020\000X\004¢\006\b\n\000\032\004\b6\0207R$\0208\032\0020#2\006\020\"\032\0020#@@X\016¢\006\016\n\000\032\004\b9\020&\"\004\b:\020(R$\020;\032\0020#2\006\020\"\032\0020#@@X\016¢\006\016\n\000\032\004\b<\020&\"\004\b=\020(R\030\020>\032\0060-R\0020\000X\004¢\006\b\n\000\032\004\b?\020/¨\006c"}, d2={"Lokhttp3/internal/http2/Http2Stream;", "", "id", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "outFinished", "", "inFinished", "headers", "Lokhttp3/Headers;", "(ILokhttp3/internal/http2/Http2Connection;ZZLokhttp3/Headers;)V", "getConnection", "()Lokhttp3/internal/http2/Http2Connection;", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "getErrorCode$okhttp", "()Lokhttp3/internal/http2/ErrorCode;", "setErrorCode$okhttp", "(Lokhttp3/internal/http2/ErrorCode;)V", "errorException", "Ljava/io/IOException;", "getErrorException$okhttp", "()Ljava/io/IOException;", "setErrorException$okhttp", "(Ljava/io/IOException;)V", "hasResponseHeaders", "headersQueue", "Ljava/util/ArrayDeque;", "getId", "()I", "isLocallyInitiated", "()Z", "isOpen", "<set-?>", "", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "setReadBytesAcknowledged$okhttp", "(J)V", "readBytesTotal", "getReadBytesTotal", "setReadBytesTotal$okhttp", "readTimeout", "Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "getReadTimeout$okhttp", "()Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "sink", "Lokhttp3/internal/http2/Http2Stream$FramingSink;", "getSink$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSink;", "source", "Lokhttp3/internal/http2/Http2Stream$FramingSource;", "getSource$okhttp", "()Lokhttp3/internal/http2/Http2Stream$FramingSource;", "writeBytesMaximum", "getWriteBytesMaximum", "setWriteBytesMaximum$okhttp", "writeBytesTotal", "getWriteBytesTotal", "setWriteBytesTotal$okhttp", "writeTimeout", "getWriteTimeout$okhttp", "addBytesToWriteWindow", "", "delta", "cancelStreamIfNecessary", "cancelStreamIfNecessary$okhttp", "checkOutNotClosed", "checkOutNotClosed$okhttp", "close", "rstStatusCode", "closeInternal", "closeLater", "enqueueTrailers", "trailers", "getSink", "Lokio/Sink;", "getSource", "Lokio/Source;", "Lokio/Timeout;", "receiveData", "Lokio/BufferedSource;", "length", "receiveHeaders", "receiveRstStream", "takeHeaders", "waitForIo", "waitForIo$okhttp", "writeHeaders", "responseHeaders", "", "Lokhttp3/internal/http2/Header;", "flushHeaders", "Companion", "FramingSink", "FramingSource", "StreamTimeout", "okhttp"}, k=1, mv={1, 1, 16})
public final class Http2Stream
{
  public static final Companion Companion = new Companion(null);
  public static final long EMIT_BUFFER_SIZE = 16384L;
  private final Http2Connection connection;
  private ErrorCode errorCode;
  private IOException errorException;
  private boolean hasResponseHeaders;
  private final ArrayDeque<Headers> headersQueue;
  private final int id;
  private long readBytesAcknowledged;
  private long readBytesTotal;
  private final StreamTimeout readTimeout;
  private final FramingSink sink;
  private final FramingSource source;
  private long writeBytesMaximum;
  private long writeBytesTotal;
  private final StreamTimeout writeTimeout;
  
  public Http2Stream(int paramInt, Http2Connection paramHttp2Connection, boolean paramBoolean1, boolean paramBoolean2, Headers paramHeaders)
  {
    this.id = paramInt;
    this.connection = paramHttp2Connection;
    this.writeBytesMaximum = paramHttp2Connection.getPeerSettings().getInitialWindowSize();
    this.headersQueue = new ArrayDeque();
    this.source = new FramingSource(this.connection.getOkHttpSettings().getInitialWindowSize(), paramBoolean2);
    this.sink = new FramingSink(paramBoolean1);
    this.readTimeout = new StreamTimeout();
    this.writeTimeout = new StreamTimeout();
    if (paramHeaders != null)
    {
      if ((isLocallyInitiated() ^ true))
      {
        ((Collection)this.headersQueue).add(paramHeaders);
        return;
      }
      throw ((Throwable)new IllegalStateException("locally-initiated streams shouldn't have headers yet".toString()));
    }
    if (isLocallyInitiated()) {
      return;
    }
    throw ((Throwable)new IllegalStateException("remotely-initiated streams should have headers".toString()));
  }
  
  private final boolean closeInternal(ErrorCode paramErrorCode, IOException paramIOException)
  {
    if ((Util.assertionsEnabled) && (Thread.holdsLock(this)))
    {
      paramErrorCode = new StringBuilder();
      paramErrorCode.append("Thread ");
      paramIOException = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(paramIOException, "Thread.currentThread()");
      paramErrorCode.append(paramIOException.getName());
      paramErrorCode.append(" MUST NOT hold lock on ");
      paramErrorCode.append(this);
      throw ((Throwable)new AssertionError(paramErrorCode.toString()));
    }
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      if (localErrorCode != null) {
        return false;
      }
      if (this.source.getFinished$okhttp())
      {
        boolean bool = this.sink.getFinished();
        if (bool) {
          return false;
        }
      }
      this.errorCode = paramErrorCode;
      this.errorException = paramIOException;
      ((Object)this).notifyAll();
      paramErrorCode = Unit.INSTANCE;
      this.connection.removeStream$okhttp(this.id);
      return true;
    }
    finally {}
  }
  
  public final void addBytesToWriteWindow(long paramLong)
  {
    this.writeBytesMaximum += paramLong;
    if (paramLong > 0L) {
      ((Object)this).notifyAll();
    }
  }
  
  public final void cancelStreamIfNecessary$okhttp()
    throws IOException
  {
    Object localObject1;
    if ((Util.assertionsEnabled) && (Thread.holdsLock(this)))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      ((StringBuilder)localObject1).append(localThread.getName());
      ((StringBuilder)localObject1).append(" MUST NOT hold lock on ");
      ((StringBuilder)localObject1).append(this);
      throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
    }
    for (;;)
    {
      try
      {
        if ((this.source.getFinished$okhttp()) || (!this.source.getClosed$okhttp())) {
          break label177;
        }
        if (this.sink.getFinished()) {
          break label172;
        }
        if (!this.sink.getClosed()) {
          break label177;
        }
      }
      finally {}
      boolean bool = isOpen();
      localObject1 = Unit.INSTANCE;
      if (i != 0)
      {
        close(ErrorCode.CANCEL, null);
        return;
      }
      if (!bool) {
        this.connection.removeStream$okhttp(this.id);
      }
      return;
      label172:
      int i = 1;
      continue;
      label177:
      i = 0;
    }
  }
  
  public final void checkOutNotClosed$okhttp()
    throws IOException
  {
    if (!this.sink.getClosed())
    {
      if (!this.sink.getFinished())
      {
        if (this.errorCode != null)
        {
          IOException localIOException = this.errorException;
          Object localObject = localIOException;
          if (localIOException == null)
          {
            localObject = this.errorCode;
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            localObject = new StreamResetException((ErrorCode)localObject);
          }
          throw ((Throwable)localObject);
        }
        return;
      }
      throw ((Throwable)new IOException("stream finished"));
    }
    throw ((Throwable)new IOException("stream closed"));
  }
  
  public final void close(ErrorCode paramErrorCode, IOException paramIOException)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCode, "rstStatusCode");
    if (!closeInternal(paramErrorCode, paramIOException)) {
      return;
    }
    this.connection.writeSynReset$okhttp(this.id, paramErrorCode);
  }
  
  public final void closeLater(ErrorCode paramErrorCode)
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCode, "errorCode");
    if (!closeInternal(paramErrorCode, null)) {
      return;
    }
    this.connection.writeSynResetLater$okhttp(this.id, paramErrorCode);
  }
  
  public final void enqueueTrailers(Headers paramHeaders)
  {
    Intrinsics.checkParameterIsNotNull(paramHeaders, "trailers");
    for (;;)
    {
      try
      {
        boolean bool = this.sink.getFinished();
        i = 1;
        if ((bool ^ true))
        {
          if (paramHeaders.size() != 0)
          {
            if (i != 0)
            {
              this.sink.setTrailers(paramHeaders);
              paramHeaders = Unit.INSTANCE;
              return;
            }
            throw ((Throwable)new IllegalArgumentException("trailers.size() == 0".toString()));
          }
        }
        else {
          throw ((Throwable)new IllegalStateException("already finished".toString()));
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final Http2Connection getConnection()
  {
    return this.connection;
  }
  
  public final ErrorCode getErrorCode$okhttp()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      return localErrorCode;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final IOException getErrorException$okhttp()
  {
    return this.errorException;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final long getReadBytesAcknowledged()
  {
    return this.readBytesAcknowledged;
  }
  
  public final long getReadBytesTotal()
  {
    return this.readBytesTotal;
  }
  
  public final StreamTimeout getReadTimeout$okhttp()
  {
    return this.readTimeout;
  }
  
  public final Sink getSink()
  {
    for (;;)
    {
      try
      {
        if (this.hasResponseHeaders) {
          break label64;
        }
        if (!isLocallyInitiated()) {
          break label59;
        }
      }
      finally {}
      if (i != 0)
      {
        Unit localUnit = Unit.INSTANCE;
        return (Sink)this.sink;
      }
      throw ((Throwable)new IllegalStateException("reply before requesting the sink".toString()));
      label59:
      int i = 0;
      continue;
      label64:
      i = 1;
    }
  }
  
  public final FramingSink getSink$okhttp()
  {
    return this.sink;
  }
  
  public final Source getSource()
  {
    return (Source)this.source;
  }
  
  public final FramingSource getSource$okhttp()
  {
    return this.source;
  }
  
  public final long getWriteBytesMaximum()
  {
    return this.writeBytesMaximum;
  }
  
  public final long getWriteBytesTotal()
  {
    return this.writeBytesTotal;
  }
  
  public final StreamTimeout getWriteTimeout$okhttp()
  {
    return this.writeTimeout;
  }
  
  public final boolean isLocallyInitiated()
  {
    int i;
    if ((this.id & 0x1) == 1) {
      i = 1;
    } else {
      i = 0;
    }
    return this.connection.getClient$okhttp() == i;
  }
  
  public final boolean isOpen()
  {
    try
    {
      ErrorCode localErrorCode = this.errorCode;
      if (localErrorCode != null) {
        return false;
      }
      if (((this.source.getFinished$okhttp()) || (this.source.getClosed$okhttp())) && ((this.sink.getFinished()) || (this.sink.getClosed())))
      {
        boolean bool = this.hasResponseHeaders;
        if (bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public final Timeout readTimeout()
  {
    return (Timeout)this.readTimeout;
  }
  
  public final void receiveData(BufferedSource paramBufferedSource, int paramInt)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    if ((Util.assertionsEnabled) && (Thread.holdsLock(this)))
    {
      paramBufferedSource = new StringBuilder();
      paramBufferedSource.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      paramBufferedSource.append(localThread.getName());
      paramBufferedSource.append(" MUST NOT hold lock on ");
      paramBufferedSource.append(this);
      throw ((Throwable)new AssertionError(paramBufferedSource.toString()));
    }
    this.source.receive$okhttp(paramBufferedSource, paramInt);
  }
  
  public final void receiveHeaders(Headers paramHeaders, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramHeaders, "headers");
    if ((Util.assertionsEnabled) && (Thread.holdsLock(this)))
    {
      paramHeaders = new StringBuilder();
      paramHeaders.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      paramHeaders.append(localThread.getName());
      paramHeaders.append(" MUST NOT hold lock on ");
      paramHeaders.append(this);
      throw ((Throwable)new AssertionError(paramHeaders.toString()));
    }
    try
    {
      if ((this.hasResponseHeaders) && (paramBoolean))
      {
        this.source.setTrailers(paramHeaders);
      }
      else
      {
        this.hasResponseHeaders = true;
        ((Collection)this.headersQueue).add(paramHeaders);
      }
      if (paramBoolean) {
        this.source.setFinished$okhttp(true);
      }
      paramBoolean = isOpen();
      ((Object)this).notifyAll();
      paramHeaders = Unit.INSTANCE;
      if (!paramBoolean) {
        this.connection.removeStream$okhttp(this.id);
      }
      return;
    }
    finally {}
  }
  
  public final void receiveRstStream(ErrorCode paramErrorCode)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramErrorCode, "errorCode");
      if (this.errorCode == null)
      {
        this.errorCode = paramErrorCode;
        ((Object)this).notifyAll();
      }
      return;
    }
    finally
    {
      paramErrorCode = finally;
      throw paramErrorCode;
    }
  }
  
  public final void setErrorCode$okhttp(ErrorCode paramErrorCode)
  {
    this.errorCode = paramErrorCode;
  }
  
  public final void setErrorException$okhttp(IOException paramIOException)
  {
    this.errorException = paramIOException;
  }
  
  public final void setReadBytesAcknowledged$okhttp(long paramLong)
  {
    this.readBytesAcknowledged = paramLong;
  }
  
  public final void setReadBytesTotal$okhttp(long paramLong)
  {
    this.readBytesTotal = paramLong;
  }
  
  public final void setWriteBytesMaximum$okhttp(long paramLong)
  {
    this.writeBytesMaximum = paramLong;
  }
  
  public final void setWriteBytesTotal$okhttp(long paramLong)
  {
    this.writeBytesTotal = paramLong;
  }
  
  /* Error */
  public final Headers takeHeaders()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 184	okhttp3/internal/http2/Http2Stream:readTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   6: invokevirtual 373	okhttp3/internal/http2/Http2Stream$StreamTimeout:enter	()V
    //   9: aload_0
    //   10: getfield 166	okhttp3/internal/http2/Http2Stream:headersQueue	Ljava/util/ArrayDeque;
    //   13: invokevirtual 376	java/util/ArrayDeque:isEmpty	()Z
    //   16: ifeq +17 -> 33
    //   19: aload_0
    //   20: getfield 254	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   23: ifnonnull +10 -> 33
    //   26: aload_0
    //   27: invokevirtual 378	okhttp3/internal/http2/Http2Stream:waitForIo$okhttp	()V
    //   30: goto -21 -> 9
    //   33: aload_0
    //   34: getfield 184	okhttp3/internal/http2/Http2Stream:readTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   37: invokevirtual 381	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   40: aload_0
    //   41: getfield 166	okhttp3/internal/http2/Http2Stream:headersQueue	Ljava/util/ArrayDeque;
    //   44: checkcast 190	java/util/Collection
    //   47: invokeinterface 382 1 0
    //   52: iconst_1
    //   53: ixor
    //   54: ifeq +27 -> 81
    //   57: aload_0
    //   58: getfield 166	okhttp3/internal/http2/Http2Stream:headersQueue	Ljava/util/ArrayDeque;
    //   61: invokevirtual 386	java/util/ArrayDeque:removeFirst	()Ljava/lang/Object;
    //   64: astore_1
    //   65: aload_1
    //   66: ldc_w 388
    //   69: invokestatic 238	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   72: aload_1
    //   73: checkcast 321	okhttp3/Headers
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_1
    //   80: areturn
    //   81: aload_0
    //   82: getfield 262	okhttp3/internal/http2/Http2Stream:errorException	Ljava/io/IOException;
    //   85: astore_2
    //   86: aload_2
    //   87: astore_1
    //   88: aload_2
    //   89: ifnonnull +24 -> 113
    //   92: aload_0
    //   93: getfield 254	okhttp3/internal/http2/Http2Stream:errorCode	Lokhttp3/internal/http2/ErrorCode;
    //   96: astore_1
    //   97: aload_1
    //   98: ifnonnull +6 -> 104
    //   101: invokestatic 297	kotlin/jvm/internal/Intrinsics:throwNpe	()V
    //   104: new 299	okhttp3/internal/http2/StreamResetException
    //   107: dup
    //   108: aload_1
    //   109: invokespecial 301	okhttp3/internal/http2/StreamResetException:<init>	(Lokhttp3/internal/http2/ErrorCode;)V
    //   112: astore_1
    //   113: aload_1
    //   114: checkcast 207	java/lang/Throwable
    //   117: athrow
    //   118: astore_1
    //   119: aload_0
    //   120: getfield 184	okhttp3/internal/http2/Http2Stream:readTimeout	Lokhttp3/internal/http2/Http2Stream$StreamTimeout;
    //   123: invokevirtual 381	okhttp3/internal/http2/Http2Stream$StreamTimeout:exitAndThrowIfTimedOut	()V
    //   126: aload_1
    //   127: athrow
    //   128: astore_1
    //   129: aload_0
    //   130: monitorexit
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	Http2Stream
    //   64	50	1	localObject1	Object
    //   118	9	1	localObject2	Object
    //   128	4	1	localObject3	Object
    //   85	4	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   9	30	118	finally
    //   2	9	128	finally
    //   33	77	128	finally
    //   81	86	128	finally
    //   92	97	128	finally
    //   101	104	128	finally
    //   104	113	128	finally
    //   113	118	128	finally
    //   119	128	128	finally
  }
  
  public final Headers trailers()
    throws IOException
  {
    for (;;)
    {
      try
      {
        Object localObject1;
        if (this.errorCode != null)
        {
          IOException localIOException = this.errorException;
          localObject1 = localIOException;
          if (localIOException == null)
          {
            localObject1 = this.errorCode;
            if (localObject1 == null) {
              Intrinsics.throwNpe();
            }
            localObject1 = new StreamResetException((ErrorCode)localObject1);
          }
          throw ((Throwable)localObject1);
        }
        if ((this.source.getFinished$okhttp()) && (this.source.getReceiveBuffer().exhausted()) && (this.source.getReadBuffer().exhausted()))
        {
          i = 1;
          if (i != 0)
          {
            localObject1 = this.source.getTrailers();
            if (localObject1 == null) {
              localObject1 = Util.EMPTY_HEADERS;
            }
            return (Headers)localObject1;
          }
          throw ((Throwable)new IllegalStateException("too early; can't read the trailers yet".toString()));
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public final void waitForIo$okhttp()
    throws InterruptedIOException
  {
    try
    {
      ((Object)this).wait();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;) {}
    }
    Thread.currentThread().interrupt();
    throw ((Throwable)new InterruptedIOException());
  }
  
  public final void writeHeaders(List<Header> paramList, boolean paramBoolean1, boolean paramBoolean2)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "responseHeaders");
    if ((Util.assertionsEnabled) && (Thread.holdsLock(this)))
    {
      paramList = new StringBuilder();
      paramList.append("Thread ");
      ??? = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(???, "Thread.currentThread()");
      paramList.append(((Thread)???).getName());
      paramList.append(" MUST NOT hold lock on ");
      paramList.append(this);
      throw ((Throwable)new AssertionError(paramList.toString()));
    }
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        this.hasResponseHeaders = true;
        if (paramBoolean1) {
          this.sink.setFinished(true);
        }
        ??? = Unit.INSTANCE;
        boolean bool1 = paramBoolean2;
        if (!paramBoolean2) {
          synchronized (this.connection)
          {
            if (this.connection.getWriteBytesTotal() < this.connection.getWriteBytesMaximum()) {
              break label208;
            }
            paramBoolean2 = bool2;
            Unit localUnit = Unit.INSTANCE;
            bool1 = paramBoolean2;
          }
        }
        this.connection.writeHeaders$okhttp(this.id, paramBoolean1, paramList);
        if (bool1) {
          this.connection.flush();
        }
        return;
      }
      finally {}
      label208:
      paramBoolean2 = false;
    }
  }
  
  public final Timeout writeTimeout()
  {
    return (Timeout)this.writeTimeout;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/internal/http2/Http2Stream$Companion;", "", "()V", "EMIT_BUFFER_SIZE", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\t\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\t\n\000\b\004\030\0002\0020\001B\017\022\b\b\002\020\002\032\0020\003¢\006\002\020\004J\b\020\024\032\0020\025H\026J\020\020\026\032\0020\0252\006\020\027\032\0020\003H\002J\b\020\030\032\0020\025H\026J\b\020\031\032\0020\032H\026J\030\020\033\032\0020\0252\006\020\034\032\0020\r2\006\020\035\032\0020\036H\026R\032\020\005\032\0020\003X\016¢\006\016\n\000\032\004\b\006\020\007\"\004\b\b\020\tR\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\n\020\007\"\004\b\013\020\tR\016\020\f\032\0020\rX\004¢\006\002\n\000R\034\020\016\032\004\030\0010\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023¨\006\037"}, d2={"Lokhttp3/internal/http2/Http2Stream$FramingSink;", "Lokio/Sink;", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;Z)V", "closed", "getClosed", "()Z", "setClosed", "(Z)V", "getFinished", "setFinished", "sendBuffer", "Lokio/Buffer;", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "emitFrame", "outFinishedOnLastFrame", "flush", "timeout", "Lokio/Timeout;", "write", "source", "byteCount", "", "okhttp"}, k=1, mv={1, 1, 16})
  public final class FramingSink
    implements Sink
  {
    private boolean closed;
    private boolean finished;
    private final Buffer sendBuffer;
    private Headers trailers;
    
    public FramingSink()
    {
      boolean bool;
      this.finished = bool;
      this.sendBuffer = new Buffer();
    }
    
    private final void emitFrame(boolean paramBoolean)
      throws IOException
    {
      for (;;)
      {
        synchronized (Http2Stream.this)
        {
          Http2Stream.this.getWriteTimeout$okhttp().enter();
          try
          {
            if ((Http2Stream.this.getWriteBytesTotal() >= Http2Stream.this.getWriteBytesMaximum()) && (!this.finished) && (!this.closed) && (Http2Stream.this.getErrorCode$okhttp() == null))
            {
              Http2Stream.this.waitForIo$okhttp();
              continue;
            }
            Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
            Http2Stream.this.checkOutNotClosed$okhttp();
            long l = Math.min(Http2Stream.this.getWriteBytesMaximum() - Http2Stream.this.getWriteBytesTotal(), this.sendBuffer.size());
            Object localObject2 = Http2Stream.this;
            ((Http2Stream)localObject2).setWriteBytesTotal$okhttp(((Http2Stream)localObject2).getWriteBytesTotal() + l);
            if ((paramBoolean) && (l == this.sendBuffer.size()) && (Http2Stream.this.getErrorCode$okhttp() == null))
            {
              paramBoolean = true;
              localObject2 = Unit.INSTANCE;
              Http2Stream.this.getWriteTimeout$okhttp().enter();
              try
              {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), paramBoolean, this.sendBuffer, l);
                return;
              }
              finally
              {
                Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
              }
              localObject4 = finally;
            }
          }
          finally
          {
            Http2Stream.this.getWriteTimeout$okhttp().exitAndThrowIfTimedOut();
          }
        }
        paramBoolean = false;
      }
    }
    
    public void close()
      throws IOException
    {
      ??? = Http2Stream.this;
      Object localObject2;
      if ((Util.assertionsEnabled) && (Thread.holdsLock(???)))
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Thread ");
        Thread localThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
        ((StringBuilder)localObject2).append(localThread.getName());
        ((StringBuilder)localObject2).append(" MUST NOT hold lock on ");
        ((StringBuilder)localObject2).append(???);
        throw ((Throwable)new AssertionError(((StringBuilder)localObject2).toString()));
      }
      for (;;)
      {
        synchronized (Http2Stream.this)
        {
          bool = this.closed;
          if (bool) {
            return;
          }
          if (Http2Stream.this.getErrorCode$okhttp() == null)
          {
            bool = true;
            localObject2 = Unit.INSTANCE;
            if (!Http2Stream.this.getSink$okhttp().finished)
            {
              int i;
              if (this.sendBuffer.size() > 0L) {
                i = 1;
              } else {
                i = 0;
              }
              int j;
              if (this.trailers != null) {
                j = 1;
              } else {
                j = 0;
              }
              if (j != 0)
              {
                if (this.sendBuffer.size() > 0L)
                {
                  emitFrame(false);
                  continue;
                }
                ??? = Http2Stream.this.getConnection();
                i = Http2Stream.this.getId();
                localObject2 = this.trailers;
                if (localObject2 == null) {
                  Intrinsics.throwNpe();
                }
                ((Http2Connection)???).writeHeaders$okhttp(i, bool, Util.toHeaderList((Headers)localObject2));
              }
              else if (i != 0)
              {
                if (this.sendBuffer.size() > 0L)
                {
                  emitFrame(true);
                  continue;
                }
              }
              else if (bool)
              {
                Http2Stream.this.getConnection().writeData(Http2Stream.this.getId(), true, null, 0L);
              }
            }
            synchronized (Http2Stream.this)
            {
              this.closed = true;
              localObject2 = Unit.INSTANCE;
              Http2Stream.this.getConnection().flush();
              Http2Stream.this.cancelStreamIfNecessary$okhttp();
              return;
            }
          }
        }
        boolean bool = false;
      }
    }
    
    public void flush()
      throws IOException
    {
      ??? = Http2Stream.this;
      Object localObject1;
      if ((Util.assertionsEnabled) && (Thread.holdsLock(???)))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Thread ");
        Thread localThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
        ((StringBuilder)localObject1).append(localThread.getName());
        ((StringBuilder)localObject1).append(" MUST NOT hold lock on ");
        ((StringBuilder)localObject1).append(???);
        throw ((Throwable)new AssertionError(((StringBuilder)localObject1).toString()));
      }
      synchronized (Http2Stream.this)
      {
        Http2Stream.this.checkOutNotClosed$okhttp();
        localObject1 = Unit.INSTANCE;
        while (this.sendBuffer.size() > 0L)
        {
          emitFrame(false);
          Http2Stream.this.getConnection().flush();
        }
        return;
      }
    }
    
    public final boolean getClosed()
    {
      return this.closed;
    }
    
    public final boolean getFinished()
    {
      return this.finished;
    }
    
    public final Headers getTrailers()
    {
      return this.trailers;
    }
    
    public final void setClosed(boolean paramBoolean)
    {
      this.closed = paramBoolean;
    }
    
    public final void setFinished(boolean paramBoolean)
    {
      this.finished = paramBoolean;
    }
    
    public final void setTrailers(Headers paramHeaders)
    {
      this.trailers = paramHeaders;
    }
    
    public Timeout timeout()
    {
      return (Timeout)Http2Stream.this.getWriteTimeout$okhttp();
    }
    
    public void write(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
      Http2Stream localHttp2Stream = Http2Stream.this;
      if ((Util.assertionsEnabled) && (Thread.holdsLock(localHttp2Stream)))
      {
        paramBuffer = new StringBuilder();
        paramBuffer.append("Thread ");
        Thread localThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
        paramBuffer.append(localThread.getName());
        paramBuffer.append(" MUST NOT hold lock on ");
        paramBuffer.append(localHttp2Stream);
        throw ((Throwable)new AssertionError(paramBuffer.toString()));
      }
      this.sendBuffer.write(paramBuffer, paramLong);
      while (this.sendBuffer.size() >= 16384L) {
        emitFrame(false);
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\000\n\002\020\t\n\000\n\002\020\013\n\002\b\t\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\002\n\002\b\005\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b\004\030\0002\0020\001B\027\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\b\020\032\032\0020\033H\026J\030\020\034\032\0020\0032\006\020\035\032\0020\0172\006\020\036\032\0020\003H\026J\035\020\037\032\0020\0332\006\020 \032\0020!2\006\020\036\032\0020\003H\000¢\006\002\b\"J\b\020#\032\0020$H\026J\020\020%\032\0020\0332\006\020\034\032\0020\003H\002R\032\020\007\032\0020\005X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\032\020\004\032\0020\005X\016¢\006\016\n\000\032\004\b\f\020\t\"\004\b\r\020\013R\016\020\002\032\0020\003X\004¢\006\002\n\000R\021\020\016\032\0020\017¢\006\b\n\000\032\004\b\020\020\021R\021\020\022\032\0020\017¢\006\b\n\000\032\004\b\023\020\021R\034\020\024\032\004\030\0010\025X\016¢\006\016\n\000\032\004\b\026\020\027\"\004\b\030\020\031¨\006&"}, d2={"Lokhttp3/internal/http2/Http2Stream$FramingSource;", "Lokio/Source;", "maxByteCount", "", "finished", "", "(Lokhttp3/internal/http2/Http2Stream;JZ)V", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getFinished$okhttp", "setFinished$okhttp", "readBuffer", "Lokio/Buffer;", "getReadBuffer", "()Lokio/Buffer;", "receiveBuffer", "getReceiveBuffer", "trailers", "Lokhttp3/Headers;", "getTrailers", "()Lokhttp3/Headers;", "setTrailers", "(Lokhttp3/Headers;)V", "close", "", "read", "sink", "byteCount", "receive", "source", "Lokio/BufferedSource;", "receive$okhttp", "timeout", "Lokio/Timeout;", "updateConnectionFlowControl", "okhttp"}, k=1, mv={1, 1, 16})
  public final class FramingSource
    implements Source
  {
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final Buffer readBuffer;
    private final Buffer receiveBuffer;
    private Headers trailers;
    
    public FramingSource(boolean paramBoolean)
    {
      this.maxByteCount = ???;
      boolean bool1;
      this.finished = bool1;
      this.receiveBuffer = new Buffer();
      this.readBuffer = new Buffer();
    }
    
    private final void updateConnectionFlowControl(long paramLong)
    {
      Http2Stream localHttp2Stream = Http2Stream.this;
      if ((Util.assertionsEnabled) && (Thread.holdsLock(localHttp2Stream)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Thread ");
        Thread localThread = Thread.currentThread();
        Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
        localStringBuilder.append(localThread.getName());
        localStringBuilder.append(" MUST NOT hold lock on ");
        localStringBuilder.append(localHttp2Stream);
        throw ((Throwable)new AssertionError(localStringBuilder.toString()));
      }
      Http2Stream.this.getConnection().updateConnectionFlowControl$okhttp(paramLong);
    }
    
    public void close()
      throws IOException
    {
      synchronized (Http2Stream.this)
      {
        this.closed = true;
        long l = this.readBuffer.size();
        this.readBuffer.clear();
        Object localObject1 = Http2Stream.this;
        if (localObject1 != null)
        {
          ((Object)localObject1).notifyAll();
          localObject1 = Unit.INSTANCE;
          if (l > 0L) {
            updateConnectionFlowControl(l);
          }
          Http2Stream.this.cancelStreamIfNecessary$okhttp();
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
      }
    }
    
    public final boolean getClosed$okhttp()
    {
      return this.closed;
    }
    
    public final boolean getFinished$okhttp()
    {
      return this.finished;
    }
    
    public final Buffer getReadBuffer()
    {
      return this.readBuffer;
    }
    
    public final Buffer getReceiveBuffer()
    {
      return this.receiveBuffer;
    }
    
    public final Headers getTrailers()
    {
      return this.trailers;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        for (;;)
        {
          Object localObject1 = (IOException)null;
          synchronized (Http2Stream.this)
          {
            Http2Stream.this.getReadTimeout$okhttp().enter();
            try
            {
              if (Http2Stream.this.getErrorCode$okhttp() != null)
              {
                localObject1 = Http2Stream.this.getErrorException$okhttp();
                if (localObject1 == null)
                {
                  localObject1 = Http2Stream.this.getErrorCode$okhttp();
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  localObject1 = (IOException)new StreamResetException((ErrorCode)localObject1);
                }
              }
              if (!this.closed)
              {
                long l1;
                if (this.readBuffer.size() > 0L)
                {
                  long l2 = this.readBuffer.read(paramBuffer, Math.min(paramLong, this.readBuffer.size()));
                  localObject2 = Http2Stream.this;
                  ((Http2Stream)localObject2).setReadBytesTotal$okhttp(((Http2Stream)localObject2).getReadBytesTotal() + l2);
                  long l3 = Http2Stream.this.getReadBytesTotal() - Http2Stream.this.getReadBytesAcknowledged();
                  l1 = l2;
                  if (localObject1 == null)
                  {
                    l1 = l2;
                    if (l3 >= Http2Stream.this.getConnection().getOkHttpSettings().getInitialWindowSize() / 2)
                    {
                      Http2Stream.this.getConnection().writeWindowUpdateLater$okhttp(Http2Stream.this.getId(), l3);
                      Http2Stream.this.setReadBytesAcknowledged$okhttp(Http2Stream.this.getReadBytesTotal());
                      l1 = l2;
                    }
                  }
                }
                else
                {
                  if ((!this.finished) && (localObject1 == null))
                  {
                    Http2Stream.this.waitForIo$okhttp();
                    l1 = -1L;
                    i = 1;
                    break label298;
                  }
                  l1 = -1L;
                }
                i = 0;
                label298:
                Http2Stream.this.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
                Object localObject2 = Unit.INSTANCE;
                if (i == 0)
                {
                  if (l1 != -1L)
                  {
                    updateConnectionFlowControl(l1);
                    return l1;
                  }
                  if (localObject1 != null)
                  {
                    if (localObject1 == null) {
                      Intrinsics.throwNpe();
                    }
                    throw ((Throwable)localObject1);
                  }
                  return -1L;
                }
              }
              else
              {
                throw ((Throwable)new IOException("stream closed"));
              }
            }
            finally
            {
              Http2Stream.this.getReadTimeout$okhttp().exitAndThrowIfTimedOut();
            }
          }
        }
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
    
    public final void receive$okhttp(BufferedSource paramBufferedSource, long paramLong)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
      ??? = Http2Stream.this;
      long l1 = paramLong;
      Object localObject;
      if (Util.assertionsEnabled) {
        if (!Thread.holdsLock(???))
        {
          l1 = paramLong;
        }
        else
        {
          paramBufferedSource = new StringBuilder();
          paramBufferedSource.append("Thread ");
          localObject = Thread.currentThread();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
          paramBufferedSource.append(((Thread)localObject).getName());
          paramBufferedSource.append(" MUST NOT hold lock on ");
          paramBufferedSource.append(???);
          throw ((Throwable)new AssertionError(paramBufferedSource.toString()));
        }
      }
      if (l1 > 0L) {}
      for (;;)
      {
        synchronized (Http2Stream.this)
        {
          boolean bool = this.finished;
          paramLong = this.readBuffer.size();
          long l2 = this.maxByteCount;
          int j = 1;
          if (paramLong + l1 <= l2) {
            break label389;
          }
          i = 1;
          localObject = Unit.INSTANCE;
          if (i != 0)
          {
            paramBufferedSource.skip(l1);
            Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
            return;
          }
          if (bool)
          {
            paramBufferedSource.skip(l1);
            return;
          }
          paramLong = paramBufferedSource.read(this.receiveBuffer, l1);
          if (paramLong != -1L)
          {
            l2 = l1 - paramLong;
            synchronized (Http2Stream.this)
            {
              if (this.closed)
              {
                paramLong = this.receiveBuffer.size();
                this.receiveBuffer.clear();
              }
              else
              {
                if (this.readBuffer.size() != 0L) {
                  break label395;
                }
                i = j;
                this.readBuffer.writeAll((Source)this.receiveBuffer);
                if (i == 0) {
                  break label401;
                }
                localObject = Http2Stream.this;
                if (localObject != null)
                {
                  ((Object)localObject).notifyAll();
                  break label401;
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
              }
              localObject = Unit.INSTANCE;
              l1 = l2;
              if (paramLong <= 0L) {
                break;
              }
              updateConnectionFlowControl(paramLong);
              l1 = l2;
            }
          }
          throw ((Throwable)new EOFException());
        }
        return;
        label389:
        int i = 0;
        continue;
        label395:
        i = 0;
        continue;
        label401:
        paramLong = 0L;
      }
    }
    
    public final void setClosed$okhttp(boolean paramBoolean)
    {
      this.closed = paramBoolean;
    }
    
    public final void setFinished$okhttp(boolean paramBoolean)
    {
      this.finished = paramBoolean;
    }
    
    public final void setTrailers(Headers paramHeaders)
    {
      this.trailers = paramHeaders;
    }
    
    public Timeout timeout()
    {
      return (Timeout)Http2Stream.this.getReadTimeout$okhttp();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\003\b\004\030\0002\0020\001B\005¢\006\002\020\002J\006\020\003\032\0020\004J\022\020\005\032\0020\0062\b\020\007\032\004\030\0010\006H\024J\b\020\b\032\0020\004H\024¨\006\t"}, d2={"Lokhttp3/internal/http2/Http2Stream$StreamTimeout;", "Lokio/AsyncTimeout;", "(Lokhttp3/internal/http2/Http2Stream;)V", "exitAndThrowIfTimedOut", "", "newTimeoutException", "Ljava/io/IOException;", "cause", "timedOut", "okhttp"}, k=1, mv={1, 1, 16})
  public final class StreamTimeout
    extends AsyncTimeout
  {
    public final void exitAndThrowIfTimedOut()
      throws IOException
    {
      if (!exit()) {
        return;
      }
      throw ((Throwable)newTimeoutException(null));
    }
    
    protected IOException newTimeoutException(IOException paramIOException)
    {
      SocketTimeoutException localSocketTimeoutException = new SocketTimeoutException("timeout");
      if (paramIOException != null) {
        localSocketTimeoutException.initCause((Throwable)paramIOException);
      }
      return (IOException)localSocketTimeoutException;
    }
    
    protected void timedOut()
    {
      this.this$0.closeLater(ErrorCode.CANCEL);
      this.this$0.getConnection().sendDegradedPingLater$okhttp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Http2Stream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */