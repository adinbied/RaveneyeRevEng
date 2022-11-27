package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.LongRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import okhttp3.Headers;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(bv={1, 0, 3}, d1={"\000´\001\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\016\n\002\b\003\n\002\020#\n\002\020\b\n\002\b\f\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\007\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020%\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\013\n\002\020 \n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\035\n\002\030\002\n\002\b\024\030\000 \0012\0020\001:\b\001\001\001\001B\017\b\000\022\006\020\002\032\0020\003¢\006\002\020\004J\006\020P\032\0020QJ\b\020R\032\0020QH\026J'\020R\032\0020Q2\006\020S\032\0020T2\006\020U\032\0020T2\b\020V\032\004\030\0010WH\000¢\006\002\bXJ\022\020Y\032\0020Q2\b\020Z\032\004\030\0010WH\002J\006\020[\032\0020QJ\020\020\\\032\004\030\0010B2\006\020]\032\0020\022J\016\020^\032\0020\t2\006\020_\032\0020\006J&\020`\032\0020B2\006\020a\032\0020\0222\f\020b\032\b\022\004\022\0020d0c2\006\020e\032\0020\tH\002J\034\020`\032\0020B2\f\020b\032\b\022\004\022\0020d0c2\006\020e\032\0020\tJ\006\020f\032\0020\022J-\020g\032\0020Q2\006\020h\032\0020\0222\006\020i\032\0020j2\006\020k\032\0020\0222\006\020l\032\0020\tH\000¢\006\002\bmJ+\020n\032\0020Q2\006\020h\032\0020\0222\f\020b\032\b\022\004\022\0020d0c2\006\020l\032\0020\tH\000¢\006\002\boJ#\020p\032\0020Q2\006\020h\032\0020\0222\f\020b\032\b\022\004\022\0020d0cH\000¢\006\002\bqJ\035\020r\032\0020Q2\006\020h\032\0020\0222\006\020s\032\0020TH\000¢\006\002\btJ$\020u\032\0020B2\006\020a\032\0020\0222\f\020b\032\b\022\004\022\0020d0c2\006\020e\032\0020\tJ\025\020v\032\0020\t2\006\020h\032\0020\022H\000¢\006\002\bwJ\027\020x\032\004\030\0010B2\006\020h\032\0020\022H\000¢\006\002\byJ\r\020z\032\0020QH\000¢\006\002\b{J\016\020|\032\0020Q2\006\020}\032\0020&J\016\020~\032\0020Q2\006\020\032\0020TJ\024\020\001\032\0020Q2\t\b\002\020\001\032\0020\tH\007J\030\020\001\032\0020Q2\007\020\001\032\0020\006H\000¢\006\003\b\001J,\020\001\032\0020Q2\006\020h\032\0020\0222\007\020\001\032\0020\t2\n\020\001\032\005\030\0010\0012\006\020k\032\0020\006J/\020\001\032\0020Q2\006\020h\032\0020\0222\007\020\001\032\0020\t2\r\020\001\032\b\022\004\022\0020d0cH\000¢\006\003\b\001J\007\020\001\032\0020QJ\"\020\001\032\0020Q2\007\020\001\032\0020\t2\007\020\001\032\0020\0222\007\020\001\032\0020\022J\007\020\001\032\0020QJ\037\020\001\032\0020Q2\006\020h\032\0020\0222\006\020\032\0020TH\000¢\006\003\b\001J\037\020\001\032\0020Q2\006\020h\032\0020\0222\006\020s\032\0020TH\000¢\006\003\b\001J \020\001\032\0020Q2\006\020h\032\0020\0222\007\020\001\032\0020\006H\000¢\006\003\b\001R\016\020\005\032\0020\006X\016¢\006\002\n\000R\016\020\007\032\0020\006X\016¢\006\002\n\000R\024\020\b\032\0020\tX\004¢\006\b\n\000\032\004\b\n\020\013R\024\020\f\032\0020\rX\004¢\006\b\n\000\032\004\b\016\020\017R\024\020\020\032\b\022\004\022\0020\0220\021X\004¢\006\002\n\000R\016\020\023\032\0020\006X\016¢\006\002\n\000R\016\020\024\032\0020\006X\016¢\006\002\n\000R\016\020\025\032\0020\006X\016¢\006\002\n\000R\016\020\026\032\0020\006X\016¢\006\002\n\000R\016\020\027\032\0020\006X\016¢\006\002\n\000R\016\020\030\032\0020\tX\016¢\006\002\n\000R\032\020\031\032\0020\022X\016¢\006\016\n\000\032\004\b\032\020\033\"\004\b\034\020\035R\024\020\036\032\0020\037X\004¢\006\b\n\000\032\004\b \020!R\032\020\"\032\0020\022X\016¢\006\016\n\000\032\004\b#\020\033\"\004\b$\020\035R\021\020%\032\0020&¢\006\b\n\000\032\004\b'\020(R\032\020)\032\0020&X\016¢\006\016\n\000\032\004\b*\020(\"\004\b+\020,R\016\020-\032\0020.X\004¢\006\002\n\000R\016\020/\032\00200X\004¢\006\002\n\000R\036\0202\032\0020\0062\006\0201\032\0020\006@BX\016¢\006\b\n\000\032\004\b3\0204R\036\0205\032\0020\0062\006\0201\032\0020\006@BX\016¢\006\b\n\000\032\004\b6\0204R\025\0207\032\00608R\0020\000¢\006\b\n\000\032\004\b9\020:R\016\020;\032\00200X\004¢\006\002\n\000R\024\020<\032\0020=X\004¢\006\b\n\000\032\004\b>\020?R \020@\032\016\022\004\022\0020\022\022\004\022\0020B0AX\004¢\006\b\n\000\032\004\bC\020DR\016\020E\032\0020FX\004¢\006\002\n\000R\036\020G\032\0020\0062\006\0201\032\0020\006@BX\016¢\006\b\n\000\032\004\bH\0204R\036\020I\032\0020\0062\006\0201\032\0020\006@BX\016¢\006\b\n\000\032\004\bJ\0204R\021\020K\032\0020L¢\006\b\n\000\032\004\bM\020NR\016\020O\032\00200X\004¢\006\002\n\000¨\006\001"}, d2={"Lokhttp3/internal/http2/Http2Connection;", "Ljava/io/Closeable;", "builder", "Lokhttp3/internal/http2/Http2Connection$Builder;", "(Lokhttp3/internal/http2/Http2Connection$Builder;)V", "awaitPingsSent", "", "awaitPongsReceived", "client", "", "getClient$okhttp", "()Z", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "currentPushRequests", "", "", "degradedPingsSent", "degradedPongDeadlineNs", "degradedPongsReceived", "intervalPingsSent", "intervalPongsReceived", "isShutdown", "lastGoodStreamId", "getLastGoodStreamId$okhttp", "()I", "setLastGoodStreamId$okhttp", "(I)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "nextStreamId", "getNextStreamId$okhttp", "setNextStreamId$okhttp", "okHttpSettings", "Lokhttp3/internal/http2/Settings;", "getOkHttpSettings", "()Lokhttp3/internal/http2/Settings;", "peerSettings", "getPeerSettings", "setPeerSettings", "(Lokhttp3/internal/http2/Settings;)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "pushQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "<set-?>", "readBytesAcknowledged", "getReadBytesAcknowledged", "()J", "readBytesTotal", "getReadBytesTotal", "readerRunnable", "Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "getReaderRunnable", "()Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "settingsListenerQueue", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "streams", "", "Lokhttp3/internal/http2/Http2Stream;", "getStreams$okhttp", "()Ljava/util/Map;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "writeBytesMaximum", "getWriteBytesMaximum", "writeBytesTotal", "getWriteBytesTotal", "writer", "Lokhttp3/internal/http2/Http2Writer;", "getWriter", "()Lokhttp3/internal/http2/Http2Writer;", "writerQueue", "awaitPong", "", "close", "connectionCode", "Lokhttp3/internal/http2/ErrorCode;", "streamCode", "cause", "Ljava/io/IOException;", "close$okhttp", "failConnection", "e", "flush", "getStream", "id", "isHealthy", "nowNs", "newStream", "associatedStreamId", "requestHeaders", "", "Lokhttp3/internal/http2/Header;", "out", "openStreamCount", "pushDataLater", "streamId", "source", "Lokio/BufferedSource;", "byteCount", "inFinished", "pushDataLater$okhttp", "pushHeadersLater", "pushHeadersLater$okhttp", "pushRequestLater", "pushRequestLater$okhttp", "pushResetLater", "errorCode", "pushResetLater$okhttp", "pushStream", "pushedStream", "pushedStream$okhttp", "removeStream", "removeStream$okhttp", "sendDegradedPingLater", "sendDegradedPingLater$okhttp", "setSettings", "settings", "shutdown", "statusCode", "start", "sendConnectionPreface", "updateConnectionFlowControl", "read", "updateConnectionFlowControl$okhttp", "writeData", "outFinished", "buffer", "Lokio/Buffer;", "writeHeaders", "alternating", "writeHeaders$okhttp", "writePing", "reply", "payload1", "payload2", "writePingAndAwaitPong", "writeSynReset", "writeSynReset$okhttp", "writeSynResetLater", "writeSynResetLater$okhttp", "writeWindowUpdateLater", "unacknowledgedBytesRead", "writeWindowUpdateLater$okhttp", "Builder", "Companion", "Listener", "ReaderRunnable", "okhttp"}, k=1, mv={1, 1, 16})
public final class Http2Connection
  implements Closeable
{
  public static final int AWAIT_PING = 3;
  public static final Companion Companion = new Companion(null);
  private static final Settings DEFAULT_SETTINGS;
  public static final int DEGRADED_PING = 2;
  public static final int DEGRADED_PONG_TIMEOUT_NS = 1000000000;
  public static final int INTERVAL_PING = 1;
  public static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
  private long awaitPingsSent;
  private long awaitPongsReceived;
  private final boolean client;
  private final String connectionName;
  private final Set<Integer> currentPushRequests;
  private long degradedPingsSent;
  private long degradedPongDeadlineNs;
  private long degradedPongsReceived;
  private long intervalPingsSent;
  private long intervalPongsReceived;
  private boolean isShutdown;
  private int lastGoodStreamId;
  private final Listener listener;
  private int nextStreamId;
  private final Settings okHttpSettings;
  private Settings peerSettings;
  private final PushObserver pushObserver;
  private final TaskQueue pushQueue;
  private long readBytesAcknowledged;
  private long readBytesTotal;
  private final ReaderRunnable readerRunnable;
  private final TaskQueue settingsListenerQueue;
  private final Socket socket;
  private final Map<Integer, Http2Stream> streams;
  private final TaskRunner taskRunner;
  private long writeBytesMaximum;
  private long writeBytesTotal;
  private final Http2Writer writer;
  private final TaskQueue writerQueue;
  
  static
  {
    Settings localSettings = new Settings();
    localSettings.set(7, 65535);
    localSettings.set(5, 16384);
    DEFAULT_SETTINGS = localSettings;
  }
  
  public Http2Connection(Builder paramBuilder)
  {
    this.client = paramBuilder.getClient$okhttp();
    this.listener = paramBuilder.getListener$okhttp();
    this.streams = ((Map)new LinkedHashMap());
    this.connectionName = paramBuilder.getConnectionName$okhttp();
    int i;
    if (paramBuilder.getClient$okhttp()) {
      i = 3;
    } else {
      i = 2;
    }
    this.nextStreamId = i;
    Object localObject = paramBuilder.getTaskRunner$okhttp();
    this.taskRunner = ((TaskRunner)localObject);
    this.writerQueue = ((TaskRunner)localObject).newQueue();
    this.pushQueue = this.taskRunner.newQueue();
    this.settingsListenerQueue = this.taskRunner.newQueue();
    this.pushObserver = paramBuilder.getPushObserver$okhttp();
    localObject = new Settings();
    if (paramBuilder.getClient$okhttp()) {
      ((Settings)localObject).set(7, 16777216);
    }
    this.okHttpSettings = ((Settings)localObject);
    localObject = DEFAULT_SETTINGS;
    this.peerSettings = ((Settings)localObject);
    this.writeBytesMaximum = ((Settings)localObject).getInitialWindowSize();
    this.socket = paramBuilder.getSocket$okhttp();
    this.writer = new Http2Writer(paramBuilder.getSink$okhttp(), this.client);
    this.readerRunnable = new ReaderRunnable(new Http2Reader(paramBuilder.getSource$okhttp(), this.client));
    this.currentPushRequests = ((Set)new LinkedHashSet());
    if (paramBuilder.getPingIntervalMillis$okhttp() != 0)
    {
      final long l = TimeUnit.MILLISECONDS.toNanos(paramBuilder.getPingIntervalMillis$okhttp());
      paramBuilder = this.writerQueue;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.connectionName);
      ((StringBuilder)localObject).append(" ping");
      localObject = ((StringBuilder)localObject).toString();
      paramBuilder.schedule((Task)new Task((String)localObject, (String)localObject, this, l)
      {
        public long runOnce()
        {
          synchronized (jdField_this)
          {
            int i;
            if (Http2Connection.access$getIntervalPongsReceived$p(jdField_this) < Http2Connection.access$getIntervalPingsSent$p(jdField_this))
            {
              i = 1;
            }
            else
            {
              Http2Connection localHttp2Connection2 = jdField_this;
              Http2Connection.access$setIntervalPingsSent$p(localHttp2Connection2, Http2Connection.access$getIntervalPingsSent$p(localHttp2Connection2) + 1L);
              i = 0;
            }
            if (i != 0)
            {
              Http2Connection.access$failConnection(jdField_this, null);
              return -1L;
            }
            jdField_this.writePing(false, 1, 0);
            return l;
          }
        }
      }, l);
    }
  }
  
  private final void failConnection(IOException paramIOException)
  {
    close$okhttp(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR, paramIOException);
  }
  
  private final Http2Stream newStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    boolean bool = paramBoolean ^ true;
    for (;;)
    {
      synchronized (this.writer)
      {
        try
        {
          if (this.nextStreamId > 1073741823) {
            shutdown(ErrorCode.REFUSED_STREAM);
          }
          if (!this.isShutdown)
          {
            int j = this.nextStreamId;
            this.nextStreamId += 2;
            Http2Stream localHttp2Stream = new Http2Stream(j, this, bool, false, null);
            if ((!paramBoolean) || (this.writeBytesTotal >= this.writeBytesMaximum)) {
              break label243;
            }
            if (localHttp2Stream.getWriteBytesTotal() >= localHttp2Stream.getWriteBytesMaximum())
            {
              break label243;
              if (localHttp2Stream.isOpen()) {
                this.streams.put(Integer.valueOf(j), localHttp2Stream);
              }
              Unit localUnit = Unit.INSTANCE;
              if (paramInt == 0)
              {
                this.writer.headers(bool, j, paramList);
              }
              else
              {
                if (!(true ^ this.client)) {
                  continue;
                }
                this.writer.pushPromise(paramInt, j, paramList);
              }
              paramList = Unit.INSTANCE;
              if (i != 0) {
                this.writer.flush();
              }
              return localHttp2Stream;
              throw ((Throwable)new IllegalArgumentException("client streams shouldn't have associated stream IDs".toString()));
            }
          }
          else
          {
            throw ((Throwable)new ConnectionShutdownException());
          }
        }
        finally {}
      }
      int i = 0;
      continue;
      label243:
      i = 1;
    }
  }
  
  public final void awaitPong()
    throws InterruptedException
  {
    try
    {
      while (this.awaitPongsReceived < this.awaitPingsSent) {
        ((Object)this).wait();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void close()
  {
    close$okhttp(ErrorCode.NO_ERROR, ErrorCode.CANCEL, null);
  }
  
  /* Error */
  public final void close$okhttp(ErrorCode paramErrorCode1, ErrorCode paramErrorCode2, IOException paramIOException)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 509
    //   4: invokestatic 248	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_2
    //   8: ldc_w 510
    //   11: invokestatic 248	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   14: getstatic 515	okhttp3/internal/Util:assertionsEnabled	Z
    //   17: ifeq +78 -> 95
    //   20: aload_0
    //   21: invokestatic 521	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
    //   24: ifne +6 -> 30
    //   27: goto +68 -> 95
    //   30: new 354	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   37: astore_1
    //   38: aload_1
    //   39: ldc_w 523
    //   42: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: invokestatic 527	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   49: astore_2
    //   50: aload_2
    //   51: ldc_w 529
    //   54: invokestatic 532	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   57: aload_1
    //   58: aload_2
    //   59: invokevirtual 535	java/lang/Thread:getName	()Ljava/lang/String;
    //   62: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: pop
    //   66: aload_1
    //   67: ldc_w 537
    //   70: invokevirtual 359	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_1
    //   75: aload_0
    //   76: invokevirtual 540	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: new 542	java/lang/AssertionError
    //   83: dup
    //   84: aload_1
    //   85: invokevirtual 364	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 545	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
    //   91: checkcast 484	java/lang/Throwable
    //   94: athrow
    //   95: aload_0
    //   96: aload_1
    //   97: invokevirtual 434	okhttp3/internal/http2/Http2Connection:shutdown	(Lokhttp3/internal/http2/ErrorCode;)V
    //   100: aconst_null
    //   101: checkcast 547	[Lokhttp3/internal/http2/Http2Stream;
    //   104: astore_1
    //   105: aload_0
    //   106: monitorenter
    //   107: aload_0
    //   108: getfield 264	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   111: invokeinterface 550 1 0
    //   116: istore 6
    //   118: iconst_0
    //   119: istore 4
    //   121: iload 6
    //   123: iconst_1
    //   124: ixor
    //   125: ifeq +54 -> 179
    //   128: aload_0
    //   129: getfield 264	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   132: invokeinterface 554 1 0
    //   137: iconst_0
    //   138: anewarray 436	okhttp3/internal/http2/Http2Stream
    //   141: invokeinterface 560 2 0
    //   146: astore_1
    //   147: aload_1
    //   148: ifnull +20 -> 168
    //   151: aload_1
    //   152: checkcast 547	[Lokhttp3/internal/http2/Http2Stream;
    //   155: astore_1
    //   156: aload_0
    //   157: getfield 264	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   160: invokeinterface 563 1 0
    //   165: goto +14 -> 179
    //   168: new 565	kotlin/TypeCastException
    //   171: dup
    //   172: ldc_w 567
    //   175: invokespecial 568	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   178: athrow
    //   179: getstatic 464	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   182: astore 7
    //   184: aload_0
    //   185: monitorexit
    //   186: aload_1
    //   187: ifnull +36 -> 223
    //   190: aload_1
    //   191: arraylength
    //   192: istore 5
    //   194: iload 4
    //   196: iload 5
    //   198: if_icmpge +25 -> 223
    //   201: aload_1
    //   202: iload 4
    //   204: aaload
    //   205: astore 7
    //   207: aload 7
    //   209: aload_2
    //   210: aload_3
    //   211: invokevirtual 571	okhttp3/internal/http2/Http2Stream:close	(Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V
    //   214: iload 4
    //   216: iconst_1
    //   217: iadd
    //   218: istore 4
    //   220: goto -26 -> 194
    //   223: aload_0
    //   224: getfield 318	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   227: invokevirtual 573	okhttp3/internal/http2/Http2Writer:close	()V
    //   230: aload_0
    //   231: getfield 307	okhttp3/internal/http2/Http2Connection:socket	Ljava/net/Socket;
    //   234: invokevirtual 576	java/net/Socket:close	()V
    //   237: aload_0
    //   238: getfield 284	okhttp3/internal/http2/Http2Connection:writerQueue	Lokhttp3/internal/concurrent/TaskQueue;
    //   241: invokevirtual 578	okhttp3/internal/concurrent/TaskQueue:shutdown	()V
    //   244: aload_0
    //   245: getfield 286	okhttp3/internal/http2/Http2Connection:pushQueue	Lokhttp3/internal/concurrent/TaskQueue;
    //   248: invokevirtual 578	okhttp3/internal/concurrent/TaskQueue:shutdown	()V
    //   251: aload_0
    //   252: getfield 288	okhttp3/internal/http2/Http2Connection:settingsListenerQueue	Lokhttp3/internal/concurrent/TaskQueue;
    //   255: invokevirtual 578	okhttp3/internal/concurrent/TaskQueue:shutdown	()V
    //   258: return
    //   259: astore_1
    //   260: aload_0
    //   261: monitorexit
    //   262: aload_1
    //   263: athrow
    //   264: astore_1
    //   265: goto -165 -> 100
    //   268: astore 7
    //   270: goto -56 -> 214
    //   273: astore_1
    //   274: goto -44 -> 230
    //   277: astore_1
    //   278: goto -41 -> 237
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	this	Http2Connection
    //   0	281	1	paramErrorCode1	ErrorCode
    //   0	281	2	paramErrorCode2	ErrorCode
    //   0	281	3	paramIOException	IOException
    //   119	100	4	i	int
    //   192	7	5	j	int
    //   116	9	6	bool	boolean
    //   182	26	7	localUnit	Unit
    //   268	1	7	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   107	118	259	finally
    //   128	147	259	finally
    //   151	165	259	finally
    //   168	179	259	finally
    //   179	184	259	finally
    //   95	100	264	java/io/IOException
    //   207	214	268	java/io/IOException
    //   223	230	273	java/io/IOException
    //   230	237	277	java/io/IOException
  }
  
  public final void flush()
    throws IOException
  {
    this.writer.flush();
  }
  
  public final boolean getClient$okhttp()
  {
    return this.client;
  }
  
  public final String getConnectionName$okhttp()
  {
    return this.connectionName;
  }
  
  public final int getLastGoodStreamId$okhttp()
  {
    return this.lastGoodStreamId;
  }
  
  public final Listener getListener$okhttp()
  {
    return this.listener;
  }
  
  public final int getNextStreamId$okhttp()
  {
    return this.nextStreamId;
  }
  
  public final Settings getOkHttpSettings()
  {
    return this.okHttpSettings;
  }
  
  public final Settings getPeerSettings()
  {
    return this.peerSettings;
  }
  
  public final long getReadBytesAcknowledged()
  {
    return this.readBytesAcknowledged;
  }
  
  public final long getReadBytesTotal()
  {
    return this.readBytesTotal;
  }
  
  public final ReaderRunnable getReaderRunnable()
  {
    return this.readerRunnable;
  }
  
  public final Socket getSocket$okhttp()
  {
    return this.socket;
  }
  
  public final Http2Stream getStream(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.get(Integer.valueOf(paramInt));
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final Map<Integer, Http2Stream> getStreams$okhttp()
  {
    return this.streams;
  }
  
  public final long getWriteBytesMaximum()
  {
    return this.writeBytesMaximum;
  }
  
  public final long getWriteBytesTotal()
  {
    return this.writeBytesTotal;
  }
  
  public final Http2Writer getWriter()
  {
    return this.writer;
  }
  
  public final boolean isHealthy(long paramLong)
  {
    try
    {
      boolean bool = this.isShutdown;
      if (bool) {
        return false;
      }
      if (this.degradedPongsReceived < this.degradedPingsSent)
      {
        long l = this.degradedPongDeadlineNs;
        if (paramLong >= l) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public final Http2Stream newStream(List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "requestHeaders");
    return newStream(0, paramList, paramBoolean);
  }
  
  public final int openStreamCount()
  {
    try
    {
      int i = this.streams.size();
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void pushDataLater$okhttp(final int paramInt1, BufferedSource paramBufferedSource, final int paramInt2, final boolean paramBoolean)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
    final Buffer localBuffer = new Buffer();
    long l = paramInt2;
    paramBufferedSource.require(l);
    paramBufferedSource.read(localBuffer, l);
    paramBufferedSource = this.pushQueue;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.connectionName);
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append("] onData");
    localObject = ((StringBuilder)localObject).toString();
    paramBufferedSource.schedule((Task)new Task((String)localObject, true)
    {
      public long runOnce()
      {
        try
        {
          boolean bool = Http2Connection.access$getPushObserver$p(jdField_this).onData(paramInt1, (BufferedSource)localBuffer, paramInt2, paramBoolean);
          if (bool) {
            jdField_this.getWriter().rstStream(paramInt1, ErrorCode.CANCEL);
          }
          if ((bool) || (paramBoolean)) {
            synchronized (jdField_this)
            {
              Http2Connection.access$getCurrentPushRequests$p(jdField_this).remove(Integer.valueOf(paramInt1));
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        return -1L;
      }
    }, 0L);
  }
  
  public final void pushHeadersLater$okhttp(final int paramInt, final List<Header> paramList, final boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "requestHeaders");
    TaskQueue localTaskQueue = this.pushQueue;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.connectionName);
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] onHeaders");
    localObject = ((StringBuilder)localObject).toString();
    localTaskQueue.schedule((Task)new Task((String)localObject, true)
    {
      public long runOnce()
      {
        boolean bool = Http2Connection.access$getPushObserver$p(jdField_this).onHeaders(paramInt, paramList, paramBoolean);
        if (bool) {}
        try
        {
          jdField_this.getWriter().rstStream(paramInt, ErrorCode.CANCEL);
          if ((bool) || (paramBoolean)) {
            synchronized (jdField_this)
            {
              Http2Connection.access$getCurrentPushRequests$p(jdField_this).remove(Integer.valueOf(paramInt));
            }
          }
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
        return -1L;
      }
    }, 0L);
  }
  
  public final void pushRequestLater$okhttp(final int paramInt, final List<Header> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "requestHeaders");
    try
    {
      if (this.currentPushRequests.contains(Integer.valueOf(paramInt)))
      {
        writeSynResetLater$okhttp(paramInt, ErrorCode.PROTOCOL_ERROR);
        return;
      }
      this.currentPushRequests.add(Integer.valueOf(paramInt));
      TaskQueue localTaskQueue = this.pushQueue;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.connectionName);
      ((StringBuilder)localObject).append('[');
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("] onRequest");
      localObject = ((StringBuilder)localObject).toString();
      localTaskQueue.schedule((Task)new Task((String)localObject, true)
      {
        public long runOnce()
        {
          if (Http2Connection.access$getPushObserver$p(jdField_this).onRequest(paramInt, paramList)) {}
          try
          {
            jdField_this.getWriter().rstStream(paramInt, ErrorCode.CANCEL);
            synchronized (jdField_this)
            {
              Http2Connection.access$getCurrentPushRequests$p(jdField_this).remove(Integer.valueOf(paramInt));
            }
          }
          catch (IOException localIOException)
          {
            for (;;) {}
          }
          return -1L;
        }
      }, 0L);
      return;
    }
    finally {}
  }
  
  public final void pushResetLater$okhttp(final int paramInt, final ErrorCode paramErrorCode)
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCode, "errorCode");
    TaskQueue localTaskQueue = this.pushQueue;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.connectionName);
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] onReset");
    localObject = ((StringBuilder)localObject).toString();
    localTaskQueue.schedule((Task)new Task((String)localObject, true)
    {
      public long runOnce()
      {
        Http2Connection.access$getPushObserver$p(jdField_this).onReset(paramInt, paramErrorCode);
        synchronized (jdField_this)
        {
          Http2Connection.access$getCurrentPushRequests$p(jdField_this).remove(Integer.valueOf(paramInt));
          return -1L;
        }
      }
    }, 0L);
  }
  
  public final Http2Stream pushStream(int paramInt, List<Header> paramList, boolean paramBoolean)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "requestHeaders");
    if ((this.client ^ true)) {
      return newStream(paramInt, paramList, paramBoolean);
    }
    throw ((Throwable)new IllegalStateException("Client cannot push requests.".toString()));
  }
  
  public final boolean pushedStream$okhttp(int paramInt)
  {
    return (paramInt != 0) && ((paramInt & 0x1) == 0);
  }
  
  public final Http2Stream removeStream$okhttp(int paramInt)
  {
    try
    {
      Http2Stream localHttp2Stream = (Http2Stream)this.streams.remove(Integer.valueOf(paramInt));
      ((Object)this).notifyAll();
      return localHttp2Stream;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void sendDegradedPingLater$okhttp()
  {
    try
    {
      long l1 = this.degradedPongsReceived;
      long l2 = this.degradedPingsSent;
      if (l1 < l2) {
        return;
      }
      this.degradedPingsSent += 1L;
      this.degradedPongDeadlineNs = (System.nanoTime() + 1000000000);
      Object localObject1 = Unit.INSTANCE;
      localObject1 = this.writerQueue;
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(this.connectionName);
      ((StringBuilder)localObject3).append(" ping");
      localObject3 = ((StringBuilder)localObject3).toString();
      ((TaskQueue)localObject1).schedule((Task)new Task((String)localObject3, true)
      {
        public long runOnce()
        {
          jdField_this.writePing(false, 2, 0);
          return -1L;
        }
      }, 0L);
      return;
    }
    finally {}
  }
  
  public final void setLastGoodStreamId$okhttp(int paramInt)
  {
    this.lastGoodStreamId = paramInt;
  }
  
  public final void setNextStreamId$okhttp(int paramInt)
  {
    this.nextStreamId = paramInt;
  }
  
  public final void setPeerSettings(Settings paramSettings)
  {
    Intrinsics.checkParameterIsNotNull(paramSettings, "<set-?>");
    this.peerSettings = paramSettings;
  }
  
  public final void setSettings(Settings paramSettings)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSettings, "settings");
    synchronized (this.writer)
    {
      try
      {
        if (!this.isShutdown)
        {
          this.okHttpSettings.merge(paramSettings);
          Unit localUnit = Unit.INSTANCE;
          this.writer.settings(paramSettings);
          paramSettings = Unit.INSTANCE;
          return;
        }
        throw ((Throwable)new ConnectionShutdownException());
      }
      finally {}
    }
  }
  
  public final void shutdown(ErrorCode paramErrorCode)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCode, "statusCode");
    synchronized (this.writer)
    {
      try
      {
        boolean bool = this.isShutdown;
        if (bool) {
          return;
        }
        this.isShutdown = true;
        int i = this.lastGoodStreamId;
        Unit localUnit = Unit.INSTANCE;
        this.writer.goAway(i, paramErrorCode, Util.EMPTY_BYTE_ARRAY);
        paramErrorCode = Unit.INSTANCE;
        return;
      }
      finally {}
    }
  }
  
  public final void start()
    throws IOException
  {
    start$default(this, false, 1, null);
  }
  
  public final void start(boolean paramBoolean)
    throws IOException
  {
    if (paramBoolean)
    {
      this.writer.connectionPreface();
      this.writer.settings(this.okHttpSettings);
      int i = this.okHttpSettings.getInitialWindowSize();
      if (i != 65535) {
        this.writer.windowUpdate(0, i - 65535);
      }
    }
    new Thread((Runnable)this.readerRunnable, this.connectionName).start();
  }
  
  public final void updateConnectionFlowControl$okhttp(long paramLong)
  {
    try
    {
      paramLong = this.readBytesTotal + paramLong;
      this.readBytesTotal = paramLong;
      paramLong -= this.readBytesAcknowledged;
      if (paramLong >= this.okHttpSettings.getInitialWindowSize() / 2)
      {
        writeWindowUpdateLater$okhttp(0, paramLong);
        this.readBytesAcknowledged += paramLong;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public final void writeData(int paramInt, boolean paramBoolean, Buffer paramBuffer, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: lload 4
    //   2: lstore 7
    //   4: lload 4
    //   6: lconst_0
    //   7: lcmp
    //   8: ifne +15 -> 23
    //   11: aload_0
    //   12: getfield 318	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   15: iload_2
    //   16: iload_1
    //   17: aload_3
    //   18: iconst_0
    //   19: invokevirtual 716	okhttp3/internal/http2/Http2Writer:data	(ZILokio/Buffer;I)V
    //   22: return
    //   23: lload 7
    //   25: lconst_0
    //   26: lcmp
    //   27: ifle +207 -> 234
    //   30: new 718	kotlin/jvm/internal/Ref$IntRef
    //   33: dup
    //   34: invokespecial 719	kotlin/jvm/internal/Ref$IntRef:<init>	()V
    //   37: astore 9
    //   39: aload_0
    //   40: monitorenter
    //   41: aload_0
    //   42: getfield 441	okhttp3/internal/http2/Http2Connection:writeBytesTotal	J
    //   45: aload_0
    //   46: getfield 303	okhttp3/internal/http2/Http2Connection:writeBytesMaximum	J
    //   49: lcmp
    //   50: iflt +43 -> 93
    //   53: aload_0
    //   54: getfield 264	okhttp3/internal/http2/Http2Connection:streams	Ljava/util/Map;
    //   57: iload_1
    //   58: invokestatic 454	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   61: invokeinterface 722 2 0
    //   66: ifeq +13 -> 79
    //   69: aload_0
    //   70: checkcast 4	java/lang/Object
    //   73: invokevirtual 502	java/lang/Object:wait	()V
    //   76: goto -35 -> 41
    //   79: new 427	java/io/IOException
    //   82: dup
    //   83: ldc_w 724
    //   86: invokespecial 725	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   89: checkcast 484	java/lang/Throwable
    //   92: athrow
    //   93: aload 9
    //   95: lload 7
    //   97: aload_0
    //   98: getfield 303	okhttp3/internal/http2/Http2Connection:writeBytesMaximum	J
    //   101: aload_0
    //   102: getfield 441	okhttp3/internal/http2/Http2Connection:writeBytesTotal	J
    //   105: lsub
    //   106: invokestatic 731	java/lang/Math:min	(JJ)J
    //   109: l2i
    //   110: putfield 734	kotlin/jvm/internal/Ref$IntRef:element	I
    //   113: aload 9
    //   115: aload 9
    //   117: getfield 734	kotlin/jvm/internal/Ref$IntRef:element	I
    //   120: aload_0
    //   121: getfield 318	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   124: invokevirtual 737	okhttp3/internal/http2/Http2Writer:maxDataLength	()I
    //   127: invokestatic 740	java/lang/Math:min	(II)I
    //   130: putfield 734	kotlin/jvm/internal/Ref$IntRef:element	I
    //   133: aload_0
    //   134: aload_0
    //   135: getfield 441	okhttp3/internal/http2/Http2Connection:writeBytesTotal	J
    //   138: aload 9
    //   140: getfield 734	kotlin/jvm/internal/Ref$IntRef:element	I
    //   143: i2l
    //   144: ladd
    //   145: putfield 441	okhttp3/internal/http2/Http2Connection:writeBytesTotal	J
    //   148: getstatic 464	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   151: astore 10
    //   153: aload_0
    //   154: monitorexit
    //   155: lload 7
    //   157: aload 9
    //   159: getfield 734	kotlin/jvm/internal/Ref$IntRef:element	I
    //   162: i2l
    //   163: lsub
    //   164: lstore 7
    //   166: aload_0
    //   167: getfield 318	okhttp3/internal/http2/Http2Connection:writer	Lokhttp3/internal/http2/Http2Writer;
    //   170: astore 10
    //   172: iload_2
    //   173: ifeq +16 -> 189
    //   176: lload 7
    //   178: lconst_0
    //   179: lcmp
    //   180: ifne +9 -> 189
    //   183: iconst_1
    //   184: istore 6
    //   186: goto +6 -> 192
    //   189: iconst_0
    //   190: istore 6
    //   192: aload 10
    //   194: iload 6
    //   196: iload_1
    //   197: aload_3
    //   198: aload 9
    //   200: getfield 734	kotlin/jvm/internal/Ref$IntRef:element	I
    //   203: invokevirtual 716	okhttp3/internal/http2/Http2Writer:data	(ZILokio/Buffer;I)V
    //   206: goto -183 -> 23
    //   209: astore_3
    //   210: goto +20 -> 230
    //   213: invokestatic 527	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   216: invokevirtual 743	java/lang/Thread:interrupt	()V
    //   219: new 745	java/io/InterruptedIOException
    //   222: dup
    //   223: invokespecial 746	java/io/InterruptedIOException:<init>	()V
    //   226: checkcast 484	java/lang/Throwable
    //   229: athrow
    //   230: aload_0
    //   231: monitorexit
    //   232: aload_3
    //   233: athrow
    //   234: return
    //   235: astore_3
    //   236: goto -23 -> 213
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	239	0	this	Http2Connection
    //   0	239	1	paramInt	int
    //   0	239	2	paramBoolean	boolean
    //   0	239	3	paramBuffer	Buffer
    //   0	239	4	paramLong	long
    //   184	11	6	bool	boolean
    //   2	175	7	l	long
    //   37	162	9	localIntRef	kotlin.jvm.internal.Ref.IntRef
    //   151	42	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   41	76	209	finally
    //   79	93	209	finally
    //   93	153	209	finally
    //   213	230	209	finally
    //   41	76	235	java/lang/InterruptedException
    //   79	93	235	java/lang/InterruptedException
  }
  
  public final void writeHeaders$okhttp(int paramInt, boolean paramBoolean, List<Header> paramList)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "alternating");
    this.writer.headers(paramBoolean, paramInt, paramList);
  }
  
  public final void writePing()
    throws InterruptedException
  {
    try
    {
      this.awaitPingsSent += 1L;
      writePing(false, 3, 1330343787);
      return;
    }
    finally {}
  }
  
  public final void writePing(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    try
    {
      this.writer.ping(paramBoolean, paramInt1, paramInt2);
      return;
    }
    catch (IOException localIOException)
    {
      failConnection(localIOException);
    }
  }
  
  public final void writePingAndAwaitPong()
    throws InterruptedException
  {
    writePing();
    awaitPong();
  }
  
  public final void writeSynReset$okhttp(int paramInt, ErrorCode paramErrorCode)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCode, "statusCode");
    this.writer.rstStream(paramInt, paramErrorCode);
  }
  
  public final void writeSynResetLater$okhttp(final int paramInt, final ErrorCode paramErrorCode)
  {
    Intrinsics.checkParameterIsNotNull(paramErrorCode, "errorCode");
    TaskQueue localTaskQueue = this.writerQueue;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.connectionName);
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] writeSynReset");
    localObject = ((StringBuilder)localObject).toString();
    localTaskQueue.schedule((Task)new Task((String)localObject, true)
    {
      public long runOnce()
      {
        try
        {
          jdField_this.writeSynReset$okhttp(paramInt, paramErrorCode);
        }
        catch (IOException localIOException)
        {
          Http2Connection.access$failConnection(jdField_this, localIOException);
        }
        return -1L;
      }
    }, 0L);
  }
  
  public final void writeWindowUpdateLater$okhttp(final int paramInt, final long paramLong)
  {
    TaskQueue localTaskQueue = this.writerQueue;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.connectionName);
    ((StringBuilder)localObject).append('[');
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("] windowUpdate");
    localObject = ((StringBuilder)localObject).toString();
    localTaskQueue.schedule((Task)new Task((String)localObject, true)
    {
      public long runOnce()
      {
        try
        {
          jdField_this.getWriter().windowUpdate(paramInt, paramLong);
        }
        catch (IOException localIOException)
        {
          Http2Connection.access$failConnection(jdField_this, localIOException);
        }
        return -1L;
      }
    }, 0L);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000X\n\002\030\002\n\002\020\000\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\006\n\002\020\016\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\002\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\006\0207\032\00208J\016\020\021\032\0020\0002\006\020\021\032\0020\022J\016\020\027\032\0020\0002\006\020\027\032\0020\030J\016\020\035\032\0020\0002\006\020\035\032\0020\036J.\020)\032\0020\0002\006\020)\032\0020*2\b\b\002\0209\032\0020\f2\b\b\002\020/\032\002002\b\b\002\020#\032\0020$H\007R\032\020\002\032\0020\003X\016¢\006\016\n\000\032\004\b\007\020\b\"\004\b\t\020\nR\032\020\013\032\0020\fX.¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\020R\032\020\021\032\0020\022X\016¢\006\016\n\000\032\004\b\023\020\024\"\004\b\025\020\026R\032\020\027\032\0020\030X\016¢\006\016\n\000\032\004\b\031\020\032\"\004\b\033\020\034R\032\020\035\032\0020\036X\016¢\006\016\n\000\032\004\b\037\020 \"\004\b!\020\"R\032\020#\032\0020$X.¢\006\016\n\000\032\004\b%\020&\"\004\b'\020(R\032\020)\032\0020*X.¢\006\016\n\000\032\004\b+\020,\"\004\b-\020.R\032\020/\032\00200X.¢\006\016\n\000\032\004\b1\0202\"\004\b3\0204R\024\020\004\032\0020\005X\004¢\006\b\n\000\032\004\b5\0206¨\006:"}, d2={"Lokhttp3/internal/http2/Http2Connection$Builder;", "", "client", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(ZLokhttp3/internal/concurrent/TaskRunner;)V", "getClient$okhttp", "()Z", "setClient$okhttp", "(Z)V", "connectionName", "", "getConnectionName$okhttp", "()Ljava/lang/String;", "setConnectionName$okhttp", "(Ljava/lang/String;)V", "listener", "Lokhttp3/internal/http2/Http2Connection$Listener;", "getListener$okhttp", "()Lokhttp3/internal/http2/Http2Connection$Listener;", "setListener$okhttp", "(Lokhttp3/internal/http2/Http2Connection$Listener;)V", "pingIntervalMillis", "", "getPingIntervalMillis$okhttp", "()I", "setPingIntervalMillis$okhttp", "(I)V", "pushObserver", "Lokhttp3/internal/http2/PushObserver;", "getPushObserver$okhttp", "()Lokhttp3/internal/http2/PushObserver;", "setPushObserver$okhttp", "(Lokhttp3/internal/http2/PushObserver;)V", "sink", "Lokio/BufferedSink;", "getSink$okhttp", "()Lokio/BufferedSink;", "setSink$okhttp", "(Lokio/BufferedSink;)V", "socket", "Ljava/net/Socket;", "getSocket$okhttp", "()Ljava/net/Socket;", "setSocket$okhttp", "(Ljava/net/Socket;)V", "source", "Lokio/BufferedSource;", "getSource$okhttp", "()Lokio/BufferedSource;", "setSource$okhttp", "(Lokio/BufferedSource;)V", "getTaskRunner$okhttp", "()Lokhttp3/internal/concurrent/TaskRunner;", "build", "Lokhttp3/internal/http2/Http2Connection;", "peerName", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Builder
  {
    private boolean client;
    public String connectionName;
    private Http2Connection.Listener listener;
    private int pingIntervalMillis;
    private PushObserver pushObserver;
    public BufferedSink sink;
    public Socket socket;
    public BufferedSource source;
    private final TaskRunner taskRunner;
    
    public Builder(boolean paramBoolean, TaskRunner paramTaskRunner)
    {
      this.client = paramBoolean;
      this.taskRunner = paramTaskRunner;
      this.listener = Http2Connection.Listener.REFUSE_INCOMING_STREAMS;
      this.pushObserver = PushObserver.CANCEL;
    }
    
    public final Http2Connection build()
    {
      return new Http2Connection(this);
    }
    
    public final boolean getClient$okhttp()
    {
      return this.client;
    }
    
    public final String getConnectionName$okhttp()
    {
      String str = this.connectionName;
      if (str == null) {
        Intrinsics.throwUninitializedPropertyAccessException("connectionName");
      }
      return str;
    }
    
    public final Http2Connection.Listener getListener$okhttp()
    {
      return this.listener;
    }
    
    public final int getPingIntervalMillis$okhttp()
    {
      return this.pingIntervalMillis;
    }
    
    public final PushObserver getPushObserver$okhttp()
    {
      return this.pushObserver;
    }
    
    public final BufferedSink getSink$okhttp()
    {
      BufferedSink localBufferedSink = this.sink;
      if (localBufferedSink == null) {
        Intrinsics.throwUninitializedPropertyAccessException("sink");
      }
      return localBufferedSink;
    }
    
    public final Socket getSocket$okhttp()
    {
      Socket localSocket = this.socket;
      if (localSocket == null) {
        Intrinsics.throwUninitializedPropertyAccessException("socket");
      }
      return localSocket;
    }
    
    public final BufferedSource getSource$okhttp()
    {
      BufferedSource localBufferedSource = this.source;
      if (localBufferedSource == null) {
        Intrinsics.throwUninitializedPropertyAccessException("source");
      }
      return localBufferedSource;
    }
    
    public final TaskRunner getTaskRunner$okhttp()
    {
      return this.taskRunner;
    }
    
    public final Builder listener(Http2Connection.Listener paramListener)
    {
      Intrinsics.checkParameterIsNotNull(paramListener, "listener");
      Builder localBuilder = (Builder)this;
      localBuilder.listener = paramListener;
      return localBuilder;
    }
    
    public final Builder pingIntervalMillis(int paramInt)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.pingIntervalMillis = paramInt;
      return localBuilder;
    }
    
    public final Builder pushObserver(PushObserver paramPushObserver)
    {
      Intrinsics.checkParameterIsNotNull(paramPushObserver, "pushObserver");
      Builder localBuilder = (Builder)this;
      localBuilder.pushObserver = paramPushObserver;
      return localBuilder;
    }
    
    public final void setClient$okhttp(boolean paramBoolean)
    {
      this.client = paramBoolean;
    }
    
    public final void setConnectionName$okhttp(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
      this.connectionName = paramString;
    }
    
    public final void setListener$okhttp(Http2Connection.Listener paramListener)
    {
      Intrinsics.checkParameterIsNotNull(paramListener, "<set-?>");
      this.listener = paramListener;
    }
    
    public final void setPingIntervalMillis$okhttp(int paramInt)
    {
      this.pingIntervalMillis = paramInt;
    }
    
    public final void setPushObserver$okhttp(PushObserver paramPushObserver)
    {
      Intrinsics.checkParameterIsNotNull(paramPushObserver, "<set-?>");
      this.pushObserver = paramPushObserver;
    }
    
    public final void setSink$okhttp(BufferedSink paramBufferedSink)
    {
      Intrinsics.checkParameterIsNotNull(paramBufferedSink, "<set-?>");
      this.sink = paramBufferedSink;
    }
    
    public final void setSocket$okhttp(Socket paramSocket)
    {
      Intrinsics.checkParameterIsNotNull(paramSocket, "<set-?>");
      this.socket = paramSocket;
    }
    
    public final void setSource$okhttp(BufferedSource paramBufferedSource)
    {
      Intrinsics.checkParameterIsNotNull(paramBufferedSource, "<set-?>");
      this.source = paramBufferedSource;
    }
    
    public final Builder socket(Socket paramSocket)
      throws IOException
    {
      return socket$default(this, paramSocket, null, null, null, 14, null);
    }
    
    public final Builder socket(Socket paramSocket, String paramString)
      throws IOException
    {
      return socket$default(this, paramSocket, paramString, null, null, 12, null);
    }
    
    public final Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource)
      throws IOException
    {
      return socket$default(this, paramSocket, paramString, paramBufferedSource, null, 8, null);
    }
    
    public final Builder socket(Socket paramSocket, String paramString, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
      Intrinsics.checkParameterIsNotNull(paramString, "peerName");
      Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
      Intrinsics.checkParameterIsNotNull(paramBufferedSink, "sink");
      Builder localBuilder = (Builder)this;
      localBuilder.socket = paramSocket;
      if (localBuilder.client)
      {
        paramSocket = new StringBuilder();
        paramSocket.append(Util.okHttpName);
        paramSocket.append(' ');
        paramSocket.append(paramString);
        paramSocket = paramSocket.toString();
      }
      else
      {
        paramSocket = new StringBuilder();
        paramSocket.append("MockWebServer ");
        paramSocket.append(paramString);
        paramSocket = paramSocket.toString();
      }
      localBuilder.connectionName = paramSocket;
      localBuilder.source = paramBufferedSource;
      localBuilder.sink = paramBufferedSink;
      return localBuilder;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\002\b\007\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\021\020\005\032\0020\006¢\006\b\n\000\032\004\b\007\020\bR\016\020\t\032\0020\004XT¢\006\002\n\000R\016\020\n\032\0020\004XT¢\006\002\n\000R\016\020\013\032\0020\004XT¢\006\002\n\000R\016\020\f\032\0020\004XT¢\006\002\n\000¨\006\r"}, d2={"Lokhttp3/internal/http2/Http2Connection$Companion;", "", "()V", "AWAIT_PING", "", "DEFAULT_SETTINGS", "Lokhttp3/internal/http2/Settings;", "getDEFAULT_SETTINGS", "()Lokhttp3/internal/http2/Settings;", "DEGRADED_PING", "DEGRADED_PONG_TIMEOUT_NS", "INTERVAL_PING", "OKHTTP_CLIENT_WINDOW_SIZE", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Settings getDEFAULT_SETTINGS()
    {
      return Http2Connection.access$getDEFAULT_SETTINGS$cp();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\b&\030\000 \f2\0020\001:\001\fB\005¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bH\026J\020\020\t\032\0020\0042\006\020\n\032\0020\013H&¨\006\r"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener;", "", "()V", "onSettings", "", "connection", "Lokhttp3/internal/http2/Http2Connection;", "settings", "Lokhttp3/internal/http2/Settings;", "onStream", "stream", "Lokhttp3/internal/http2/Http2Stream;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract class Listener
  {
    public static final Companion Companion = new Companion(null);
    public static final Listener REFUSE_INCOMING_STREAMS = (Listener)new Http2Connection.Listener.Companion.REFUSE_INCOMING_STREAMS.1();
    
    public void onSettings(Http2Connection paramHttp2Connection, Settings paramSettings)
    {
      Intrinsics.checkParameterIsNotNull(paramHttp2Connection, "connection");
      Intrinsics.checkParameterIsNotNull(paramSettings, "settings");
    }
    
    public abstract void onStream(Http2Stream paramHttp2Stream)
      throws IOException;
    
    @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/internal/http2/Http2Connection$Listener$Companion;", "", "()V", "REFUSE_INCOMING_STREAMS", "Lokhttp3/internal/http2/Http2Connection$Listener;", "okhttp"}, k=1, mv={1, 1, 16})
    public static final class Companion {}
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000d\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\002\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\003\n\002\020\t\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\020 \n\002\030\002\n\002\b\020\b\004\030\0002\0020\0012\0020\002B\017\b\000\022\006\020\003\032\0020\004¢\006\002\020\005J\b\020\b\032\0020\tH\026J8\020\n\032\0020\t2\006\020\013\032\0020\f2\006\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\0162\006\020\022\032\0020\f2\006\020\023\032\0020\024H\026J\026\020\025\032\0020\t2\006\020\026\032\0020\0272\006\020\030\032\0020\031J(\020\032\032\0020\t2\006\020\033\032\0020\0272\006\020\013\032\0020\f2\006\020\034\032\0020\0352\006\020\036\032\0020\fH\026J \020\037\032\0020\t2\006\020 \032\0020\f2\006\020!\032\0020\"2\006\020#\032\0020\020H\026J.\020$\032\0020\t2\006\020\033\032\0020\0272\006\020\013\032\0020\f2\006\020%\032\0020\f2\f\020&\032\b\022\004\022\0020(0'H\026J \020)\032\0020\t2\006\020*\032\0020\0272\006\020+\032\0020\f2\006\020,\032\0020\fH\026J(\020-\032\0020\t2\006\020\013\032\0020\f2\006\020.\032\0020\f2\006\020/\032\0020\f2\006\0200\032\0020\027H\026J&\0201\032\0020\t2\006\020\013\032\0020\f2\006\0202\032\0020\f2\f\0203\032\b\022\004\022\0020(0'H\026J\030\0204\032\0020\t2\006\020\013\032\0020\f2\006\020!\032\0020\"H\026J\b\0205\032\0020\tH\026J\030\020\030\032\0020\t2\006\020\026\032\0020\0272\006\020\030\032\0020\031H\026J\030\0206\032\0020\t2\006\020\013\032\0020\f2\006\0207\032\0020\024H\026R\024\020\003\032\0020\004X\004¢\006\b\n\000\032\004\b\006\020\007¨\0068"}, d2={"Lokhttp3/internal/http2/Http2Connection$ReaderRunnable;", "Ljava/lang/Runnable;", "Lokhttp3/internal/http2/Http2Reader$Handler;", "reader", "Lokhttp3/internal/http2/Http2Reader;", "(Lokhttp3/internal/http2/Http2Connection;Lokhttp3/internal/http2/Http2Reader;)V", "getReader$okhttp", "()Lokhttp3/internal/http2/Http2Reader;", "ackSettings", "", "alternateService", "streamId", "", "origin", "", "protocol", "Lokio/ByteString;", "host", "port", "maxAge", "", "applyAndAckSettings", "clearPrevious", "", "settings", "Lokhttp3/internal/http2/Settings;", "data", "inFinished", "source", "Lokio/BufferedSource;", "length", "goAway", "lastGoodStreamId", "errorCode", "Lokhttp3/internal/http2/ErrorCode;", "debugData", "headers", "associatedStreamId", "headerBlock", "", "Lokhttp3/internal/http2/Header;", "ping", "ack", "payload1", "payload2", "priority", "streamDependency", "weight", "exclusive", "pushPromise", "promisedStreamId", "requestHeaders", "rstStream", "run", "windowUpdate", "windowSizeIncrement", "okhttp"}, k=1, mv={1, 1, 16})
  public final class ReaderRunnable
    implements Runnable, Http2Reader.Handler
  {
    private final Http2Reader reader;
    
    public ReaderRunnable()
    {
      this.reader = ((Http2Reader)localObject);
    }
    
    public void ackSettings() {}
    
    public void alternateService(int paramInt1, String paramString1, ByteString paramByteString, String paramString2, int paramInt2, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "origin");
      Intrinsics.checkParameterIsNotNull(paramByteString, "protocol");
      Intrinsics.checkParameterIsNotNull(paramString2, "host");
    }
    
    /* Error */
    public final void applyAndAckSettings(final boolean paramBoolean, Settings arg2)
    {
      // Byte code:
      //   0: aload_2
      //   1: ldc 110
      //   3: invokestatic 92	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   6: new 112	kotlin/jvm/internal/Ref$LongRef
      //   9: dup
      //   10: invokespecial 113	kotlin/jvm/internal/Ref$LongRef:<init>	()V
      //   13: astore 7
      //   15: new 115	kotlin/jvm/internal/Ref$ObjectRef
      //   18: dup
      //   19: invokespecial 116	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
      //   22: astore 9
      //   24: new 115	kotlin/jvm/internal/Ref$ObjectRef
      //   27: dup
      //   28: invokespecial 116	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
      //   31: astore 10
      //   33: aload_0
      //   34: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   37: invokevirtual 120	okhttp3/internal/http2/Http2Connection:getWriter	()Lokhttp3/internal/http2/Http2Writer;
      //   40: astore 6
      //   42: aload 6
      //   44: monitorenter
      //   45: aload_0
      //   46: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   49: astore 8
      //   51: aload 8
      //   53: monitorenter
      //   54: aload_0
      //   55: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   58: invokevirtual 124	okhttp3/internal/http2/Http2Connection:getPeerSettings	()Lokhttp3/internal/http2/Settings;
      //   61: astore 5
      //   63: iload_1
      //   64: ifeq +12 -> 76
      //   67: aload 10
      //   69: aload_2
      //   70: putfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   73: goto +32 -> 105
      //   76: new 130	okhttp3/internal/http2/Settings
      //   79: dup
      //   80: invokespecial 131	okhttp3/internal/http2/Settings:<init>	()V
      //   83: astore 11
      //   85: aload 11
      //   87: aload 5
      //   89: invokevirtual 135	okhttp3/internal/http2/Settings:merge	(Lokhttp3/internal/http2/Settings;)V
      //   92: aload 11
      //   94: aload_2
      //   95: invokevirtual 135	okhttp3/internal/http2/Settings:merge	(Lokhttp3/internal/http2/Settings;)V
      //   98: aload 10
      //   100: aload 11
      //   102: putfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   105: aload 7
      //   107: aload 10
      //   109: getfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   112: checkcast 130	okhttp3/internal/http2/Settings
      //   115: invokevirtual 139	okhttp3/internal/http2/Settings:getInitialWindowSize	()I
      //   118: i2l
      //   119: aload 5
      //   121: invokevirtual 139	okhttp3/internal/http2/Settings:getInitialWindowSize	()I
      //   124: i2l
      //   125: lsub
      //   126: putfield 142	kotlin/jvm/internal/Ref$LongRef:element	J
      //   129: aload 7
      //   131: getfield 142	kotlin/jvm/internal/Ref$LongRef:element	J
      //   134: lconst_0
      //   135: lcmp
      //   136: ifeq +308 -> 444
      //   139: aload_0
      //   140: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   143: invokevirtual 146	okhttp3/internal/http2/Http2Connection:getStreams$okhttp	()Ljava/util/Map;
      //   146: invokeinterface 152 1 0
      //   151: ifeq +6 -> 157
      //   154: goto +290 -> 444
      //   157: aload_0
      //   158: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   161: invokevirtual 146	okhttp3/internal/http2/Http2Connection:getStreams$okhttp	()Ljava/util/Map;
      //   164: invokeinterface 156 1 0
      //   169: iconst_0
      //   170: anewarray 158	okhttp3/internal/http2/Http2Stream
      //   173: invokeinterface 164 2 0
      //   178: astore 5
      //   180: aload 5
      //   182: ifnull +13 -> 195
      //   185: aload 5
      //   187: checkcast 166	[Lokhttp3/internal/http2/Http2Stream;
      //   190: astore 5
      //   192: goto +13 -> 205
      //   195: new 168	kotlin/TypeCastException
      //   198: dup
      //   199: ldc -86
      //   201: invokespecial 173	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
      //   204: athrow
      //   205: aload 9
      //   207: aload 5
      //   209: putfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   212: aload_0
      //   213: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   216: aload 10
      //   218: getfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   221: checkcast 130	okhttp3/internal/http2/Settings
      //   224: invokevirtual 176	okhttp3/internal/http2/Http2Connection:setPeerSettings	(Lokhttp3/internal/http2/Settings;)V
      //   227: aload_0
      //   228: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   231: invokestatic 180	okhttp3/internal/http2/Http2Connection:access$getSettingsListenerQueue$p	(Lokhttp3/internal/http2/Http2Connection;)Lokhttp3/internal/concurrent/TaskQueue;
      //   234: astore 5
      //   236: new 182	java/lang/StringBuilder
      //   239: dup
      //   240: invokespecial 183	java/lang/StringBuilder:<init>	()V
      //   243: astore 11
      //   245: aload 11
      //   247: aload_0
      //   248: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   251: invokevirtual 187	okhttp3/internal/http2/Http2Connection:getConnectionName$okhttp	()Ljava/lang/String;
      //   254: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   257: pop
      //   258: aload 11
      //   260: ldc -63
      //   262: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   265: pop
      //   266: aload 11
      //   268: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   271: astore 11
      //   273: aload 5
      //   275: new 13	okhttp3/internal/http2/Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1
      //   278: dup
      //   279: aload 11
      //   281: iconst_1
      //   282: aload 11
      //   284: iconst_1
      //   285: aload_0
      //   286: iload_1
      //   287: aload 10
      //   289: aload_2
      //   290: aload 7
      //   292: aload 9
      //   294: invokespecial 199	okhttp3/internal/http2/Http2Connection$ReaderRunnable$applyAndAckSettings$$inlined$synchronized$lambda$1:<init>	(Ljava/lang/String;ZLjava/lang/String;ZLokhttp3/internal/http2/Http2Connection$ReaderRunnable;ZLkotlin/jvm/internal/Ref$ObjectRef;Lokhttp3/internal/http2/Settings;Lkotlin/jvm/internal/Ref$LongRef;Lkotlin/jvm/internal/Ref$ObjectRef;)V
      //   297: checkcast 201	okhttp3/internal/concurrent/Task
      //   300: lconst_0
      //   301: invokevirtual 207	okhttp3/internal/concurrent/TaskQueue:schedule	(Lokhttp3/internal/concurrent/Task;J)V
      //   304: getstatic 213	kotlin/Unit:INSTANCE	Lkotlin/Unit;
      //   307: astore_2
      //   308: aload 8
      //   310: monitorexit
      //   311: aload_0
      //   312: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   315: invokevirtual 120	okhttp3/internal/http2/Http2Connection:getWriter	()Lokhttp3/internal/http2/Http2Writer;
      //   318: aload 10
      //   320: getfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   323: checkcast 130	okhttp3/internal/http2/Settings
      //   326: invokevirtual 217	okhttp3/internal/http2/Http2Writer:applyAndAckSettings	(Lokhttp3/internal/http2/Settings;)V
      //   329: goto +12 -> 341
      //   332: astore_2
      //   333: aload_0
      //   334: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   337: aload_2
      //   338: invokestatic 221	okhttp3/internal/http2/Http2Connection:access$failConnection	(Lokhttp3/internal/http2/Http2Connection;Ljava/io/IOException;)V
      //   341: getstatic 213	kotlin/Unit:INSTANCE	Lkotlin/Unit;
      //   344: astore_2
      //   345: aload 6
      //   347: monitorexit
      //   348: aload 9
      //   350: getfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   353: checkcast 166	[Lokhttp3/internal/http2/Http2Stream;
      //   356: ifnull +71 -> 427
      //   359: aload 9
      //   361: getfield 128	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
      //   364: checkcast 166	[Lokhttp3/internal/http2/Http2Stream;
      //   367: astore 5
      //   369: aload 5
      //   371: ifnonnull +6 -> 377
      //   374: invokestatic 224	kotlin/jvm/internal/Intrinsics:throwNpe	()V
      //   377: aload 5
      //   379: arraylength
      //   380: istore 4
      //   382: iconst_0
      //   383: istore_3
      //   384: iload_3
      //   385: iload 4
      //   387: if_icmpge +40 -> 427
      //   390: aload 5
      //   392: iload_3
      //   393: aaload
      //   394: astore_2
      //   395: aload_2
      //   396: monitorenter
      //   397: aload_2
      //   398: aload 7
      //   400: getfield 142	kotlin/jvm/internal/Ref$LongRef:element	J
      //   403: invokevirtual 228	okhttp3/internal/http2/Http2Stream:addBytesToWriteWindow	(J)V
      //   406: getstatic 213	kotlin/Unit:INSTANCE	Lkotlin/Unit;
      //   409: astore 6
      //   411: aload_2
      //   412: monitorexit
      //   413: iload_3
      //   414: iconst_1
      //   415: iadd
      //   416: istore_3
      //   417: goto -33 -> 384
      //   420: astore 5
      //   422: aload_2
      //   423: monitorexit
      //   424: aload 5
      //   426: athrow
      //   427: return
      //   428: astore_2
      //   429: goto +4 -> 433
      //   432: astore_2
      //   433: aload 8
      //   435: monitorexit
      //   436: aload_2
      //   437: athrow
      //   438: astore_2
      //   439: aload 6
      //   441: monitorexit
      //   442: aload_2
      //   443: athrow
      //   444: aconst_null
      //   445: astore 5
      //   447: goto -242 -> 205
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	450	0	this	ReaderRunnable
      //   0	450	1	paramBoolean	boolean
      //   383	34	3	i	int
      //   380	8	4	j	int
      //   61	330	5	localObject1	Object
      //   420	5	5	localObject2	Object
      //   445	1	5	localObject3	Object
      //   40	400	6	localObject4	Object
      //   13	386	7	localLongRef	Ref.LongRef
      //   49	385	8	localHttp2Connection	Http2Connection
      //   22	338	9	localObjectRef1	Ref.ObjectRef
      //   31	288	10	localObjectRef2	Ref.ObjectRef
      //   83	200	11	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   311	329	332	java/io/IOException
      //   397	411	420	finally
      //   273	308	428	finally
      //   54	63	432	finally
      //   67	73	432	finally
      //   76	105	432	finally
      //   105	154	432	finally
      //   157	180	432	finally
      //   185	192	432	finally
      //   195	205	432	finally
      //   205	273	432	finally
      //   45	54	438	finally
      //   308	311	438	finally
      //   311	329	438	finally
      //   333	341	438	finally
      //   341	345	438	finally
      //   433	438	438	finally
    }
    
    public void data(boolean paramBoolean, int paramInt1, BufferedSource paramBufferedSource, int paramInt2)
      throws IOException
    {
      Intrinsics.checkParameterIsNotNull(paramBufferedSource, "source");
      if (Http2Connection.this.pushedStream$okhttp(paramInt1))
      {
        Http2Connection.this.pushDataLater$okhttp(paramInt1, paramBufferedSource, paramInt2, paramBoolean);
        return;
      }
      Object localObject = Http2Connection.this.getStream(paramInt1);
      if (localObject == null)
      {
        Http2Connection.this.writeSynResetLater$okhttp(paramInt1, ErrorCode.PROTOCOL_ERROR);
        localObject = Http2Connection.this;
        long l = paramInt2;
        ((Http2Connection)localObject).updateConnectionFlowControl$okhttp(l);
        paramBufferedSource.skip(l);
        return;
      }
      ((Http2Stream)localObject).receiveData(paramBufferedSource, paramInt2);
      if (paramBoolean) {
        ((Http2Stream)localObject).receiveHeaders(Util.EMPTY_HEADERS, true);
      }
    }
    
    public final Http2Reader getReader$okhttp()
    {
      return this.reader;
    }
    
    public void goAway(int paramInt, ErrorCode arg2, ByteString paramByteString)
    {
      Intrinsics.checkParameterIsNotNull(???, "errorCode");
      Intrinsics.checkParameterIsNotNull(paramByteString, "debugData");
      paramByteString.size();
      synchronized (Http2Connection.this)
      {
        paramByteString = Http2Connection.this.getStreams$okhttp().values();
        int i = 0;
        paramByteString = paramByteString.toArray(new Http2Stream[0]);
        if (paramByteString != null)
        {
          paramByteString = (Http2Stream[])paramByteString;
          Http2Connection.access$setShutdown$p(Http2Connection.this, true);
          Unit localUnit = Unit.INSTANCE;
          int j = paramByteString.length;
          while (i < j)
          {
            ??? = paramByteString[i];
            if ((???.getId() > paramInt) && (???.isLocallyInitiated()))
            {
              ???.receiveRstStream(ErrorCode.REFUSED_STREAM);
              Http2Connection.this.removeStream$okhttp(???.getId());
            }
            i += 1;
          }
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
      }
    }
    
    public void headers(final boolean paramBoolean, final int paramInt1, int paramInt2, final List<Header> paramList)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "headerBlock");
      if (Http2Connection.this.pushedStream$okhttp(paramInt1))
      {
        Http2Connection.this.pushHeadersLater$okhttp(paramInt1, paramList, paramBoolean);
        return;
      }
      synchronized (Http2Connection.this)
      {
        final Http2Stream localHttp2Stream = Http2Connection.this.getStream(paramInt1);
        if (localHttp2Stream == null)
        {
          boolean bool = Http2Connection.access$isShutdown$p(Http2Connection.this);
          if (bool) {
            return;
          }
          paramInt2 = Http2Connection.this.getLastGoodStreamId$okhttp();
          if (paramInt1 <= paramInt2) {
            return;
          }
          paramInt2 = Http2Connection.this.getNextStreamId$okhttp();
          if (paramInt1 % 2 == paramInt2 % 2) {
            return;
          }
          localObject1 = Util.toHeaders(paramList);
          localObject1 = new Http2Stream(paramInt1, Http2Connection.this, false, paramBoolean, (Headers)localObject1);
          Http2Connection.this.setLastGoodStreamId$okhttp(paramInt1);
          Http2Connection.this.getStreams$okhttp().put(Integer.valueOf(paramInt1), localObject1);
          TaskQueue localTaskQueue = Http2Connection.access$getTaskRunner$p(Http2Connection.this).newQueue();
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(Http2Connection.this.getConnectionName$okhttp());
          ((StringBuilder)localObject2).append('[');
          ((StringBuilder)localObject2).append(paramInt1);
          ((StringBuilder)localObject2).append("] onStream");
          localObject2 = ((StringBuilder)localObject2).toString();
          localTaskQueue.schedule((Task)new Task((String)localObject2, true)
          {
            public long runOnce()
            {
              try
              {
                jdField_this.this$0.getListener$okhttp().onStream(localObject1);
              }
              catch (IOException localIOException1)
              {
                Platform localPlatform = Platform.Companion.get();
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("Http2Connection.Listener failure for ");
                localStringBuilder.append(jdField_this.this$0.getConnectionName$okhttp());
                localPlatform.log(localStringBuilder.toString(), 4, (Throwable)localIOException1);
              }
              try
              {
                localObject1.close(ErrorCode.PROTOCOL_ERROR, localIOException1);
                return -1L;
              }
              catch (IOException localIOException2)
              {
                for (;;) {}
              }
            }
          }, 0L);
          return;
        }
        final Object localObject1 = Unit.INSTANCE;
        localHttp2Stream.receiveHeaders(Util.toHeaders(paramList), paramBoolean);
        return;
      }
    }
    
    public void ping(boolean paramBoolean, final int paramInt1, final int paramInt2)
    {
      if (paramBoolean)
      {
        localObject1 = Http2Connection.this;
        if ((paramInt1 == 1) || ((paramInt1 == 2) || (paramInt1 != 3))) {}
        try
        {
          for (;;)
          {
            localObject2 = Unit.INSTANCE;
            break label134;
            localObject2 = Http2Connection.this;
            Http2Connection.access$setAwaitPongsReceived$p((Http2Connection)localObject2, Http2Connection.access$getAwaitPongsReceived$p((Http2Connection)localObject2) + 1L);
            localObject2 = Http2Connection.this;
            if (localObject2 == null) {
              break;
            }
            ((Object)localObject2).notifyAll();
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
          Object localObject2 = Http2Connection.this;
          long l = Http2Connection.access$getDegradedPongsReceived$p((Http2Connection)localObject2);
          Http2Connection.access$setDegradedPongsReceived$p((Http2Connection)localObject2, 1L + l);
          break label134;
          localObject2 = Http2Connection.this;
          l = Http2Connection.access$getIntervalPongsReceived$p((Http2Connection)localObject2);
          Http2Connection.access$setIntervalPongsReceived$p((Http2Connection)localObject2, 1L + l);
          label134:
          return;
        }
        finally {}
      }
      Object localObject1 = Http2Connection.access$getWriterQueue$p(Http2Connection.this);
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append(Http2Connection.this.getConnectionName$okhttp());
      ((StringBuilder)localObject4).append(" ping");
      localObject4 = ((StringBuilder)localObject4).toString();
      ((TaskQueue)localObject1).schedule((Task)new Task((String)localObject4, true)
      {
        public long runOnce()
        {
          jdField_this.this$0.writePing(true, paramInt1, paramInt2);
          return -1L;
        }
      }, 0L);
    }
    
    public void priority(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean) {}
    
    public void pushPromise(int paramInt1, int paramInt2, List<Header> paramList)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "requestHeaders");
      Http2Connection.this.pushRequestLater$okhttp(paramInt2, paramList);
    }
    
    public void rstStream(int paramInt, ErrorCode paramErrorCode)
    {
      Intrinsics.checkParameterIsNotNull(paramErrorCode, "errorCode");
      if (Http2Connection.this.pushedStream$okhttp(paramInt))
      {
        Http2Connection.this.pushResetLater$okhttp(paramInt, paramErrorCode);
        return;
      }
      Http2Stream localHttp2Stream = Http2Connection.this.removeStream$okhttp(paramInt);
      if (localHttp2Stream != null) {
        localHttp2Stream.receiveRstStream(paramErrorCode);
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: getstatic 409	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   3: astore_3
      //   4: getstatic 409	okhttp3/internal/http2/ErrorCode:INTERNAL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   7: astore 7
      //   9: aconst_null
      //   10: checkcast 109	java/io/IOException
      //   13: astore 5
      //   15: aload_3
      //   16: astore_1
      //   17: aload 5
      //   19: astore 4
      //   21: aload_3
      //   22: astore_2
      //   23: aload_0
      //   24: getfield 99	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   27: aload_0
      //   28: checkcast 8	okhttp3/internal/http2/Http2Reader$Handler
      //   31: invokevirtual 415	okhttp3/internal/http2/Http2Reader:readConnectionPreface	(Lokhttp3/internal/http2/Http2Reader$Handler;)V
      //   34: aload_3
      //   35: astore_1
      //   36: aload 5
      //   38: astore 4
      //   40: aload_3
      //   41: astore_2
      //   42: aload_0
      //   43: getfield 99	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   46: iconst_0
      //   47: aload_0
      //   48: checkcast 8	okhttp3/internal/http2/Http2Reader$Handler
      //   51: invokevirtual 419	okhttp3/internal/http2/Http2Reader:nextFrame	(ZLokhttp3/internal/http2/Http2Reader$Handler;)Z
      //   54: ifeq +6 -> 60
      //   57: goto -23 -> 34
      //   60: aload_3
      //   61: astore_1
      //   62: aload 5
      //   64: astore 4
      //   66: aload_3
      //   67: astore_2
      //   68: getstatic 422	okhttp3/internal/http2/ErrorCode:NO_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   71: astore_3
      //   72: aload_3
      //   73: astore_1
      //   74: aload 5
      //   76: astore 4
      //   78: aload_3
      //   79: astore_2
      //   80: getstatic 425	okhttp3/internal/http2/ErrorCode:CANCEL	Lokhttp3/internal/http2/ErrorCode;
      //   83: astore 6
      //   85: aload_3
      //   86: astore_2
      //   87: aload 6
      //   89: astore_1
      //   90: aload 5
      //   92: astore_3
      //   93: goto +30 -> 123
      //   96: astore_2
      //   97: goto +47 -> 144
      //   100: astore_3
      //   101: aload_2
      //   102: astore_1
      //   103: aload_3
      //   104: astore 4
      //   106: getstatic 247	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   109: astore_2
      //   110: aload_2
      //   111: astore_1
      //   112: aload_3
      //   113: astore 4
      //   115: getstatic 247	okhttp3/internal/http2/ErrorCode:PROTOCOL_ERROR	Lokhttp3/internal/http2/ErrorCode;
      //   118: astore 5
      //   120: aload 5
      //   122: astore_1
      //   123: aload_0
      //   124: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   127: aload_2
      //   128: aload_1
      //   129: aload_3
      //   130: invokevirtual 429	okhttp3/internal/http2/Http2Connection:close$okhttp	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V
      //   133: aload_0
      //   134: getfield 99	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   137: checkcast 431	java/io/Closeable
      //   140: invokestatic 435	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   143: return
      //   144: aload_0
      //   145: getfield 94	okhttp3/internal/http2/Http2Connection$ReaderRunnable:this$0	Lokhttp3/internal/http2/Http2Connection;
      //   148: aload_1
      //   149: aload 7
      //   151: aload 4
      //   153: invokevirtual 429	okhttp3/internal/http2/Http2Connection:close$okhttp	(Lokhttp3/internal/http2/ErrorCode;Lokhttp3/internal/http2/ErrorCode;Ljava/io/IOException;)V
      //   156: aload_0
      //   157: getfield 99	okhttp3/internal/http2/Http2Connection$ReaderRunnable:reader	Lokhttp3/internal/http2/Http2Reader;
      //   160: checkcast 431	java/io/Closeable
      //   163: invokestatic 435	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
      //   166: aload_2
      //   167: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	168	0	this	ReaderRunnable
      //   16	133	1	localObject1	Object
      //   22	65	2	localObject2	Object
      //   96	6	2	localObject3	Object
      //   109	58	2	localErrorCode1	ErrorCode
      //   3	90	3	localObject4	Object
      //   100	30	3	localIOException	IOException
      //   19	133	4	localObject5	Object
      //   13	108	5	localObject6	Object
      //   83	5	6	localErrorCode2	ErrorCode
      //   7	143	7	localErrorCode3	ErrorCode
      // Exception table:
      //   from	to	target	type
      //   23	34	96	finally
      //   42	57	96	finally
      //   68	72	96	finally
      //   80	85	96	finally
      //   106	110	96	finally
      //   115	120	96	finally
      //   23	34	100	java/io/IOException
      //   42	57	100	java/io/IOException
      //   68	72	100	java/io/IOException
      //   80	85	100	java/io/IOException
    }
    
    public void settings(final boolean paramBoolean, final Settings paramSettings)
    {
      Intrinsics.checkParameterIsNotNull(paramSettings, "settings");
      TaskQueue localTaskQueue = Http2Connection.access$getWriterQueue$p(Http2Connection.this);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Http2Connection.this.getConnectionName$okhttp());
      ((StringBuilder)localObject).append(" applyAndAckSettings");
      localObject = ((StringBuilder)localObject).toString();
      localTaskQueue.schedule((Task)new Task((String)localObject, true)
      {
        public long runOnce()
        {
          jdField_this.applyAndAckSettings(paramBoolean, paramSettings);
          return -1L;
        }
      }, 0L);
    }
    
    public void windowUpdate(int paramInt, long paramLong)
    {
      if (paramInt == 0) {
        synchronized (Http2Connection.this)
        {
          Object localObject2 = Http2Connection.this;
          Http2Connection.access$setWriteBytesMaximum$p((Http2Connection)localObject2, ((Http2Connection)localObject2).getWriteBytesMaximum() + paramLong);
          localObject2 = Http2Connection.this;
          if (localObject2 != null)
          {
            ((Object)localObject2).notifyAll();
            localObject2 = Unit.INSTANCE;
            return;
          }
          throw new TypeCastException("null cannot be cast to non-null type java.lang.Object");
        }
      }
      ??? = Http2Connection.this.getStream(paramInt);
      if (??? != null) {
        try
        {
          ((Http2Stream)???).addBytesToWriteWindow(paramLong);
          Unit localUnit = Unit.INSTANCE;
          return;
        }
        finally
        {
          localObject4 = finally;
          throw ((Throwable)localObject4);
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Http2Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */