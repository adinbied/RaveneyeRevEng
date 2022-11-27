package okhttp3.internal.ws;

import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.Util;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.ByteString.Companion;
import okio.Okio;

@Metadata(bv={1, 0, 3}, d1={"\000°\001\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\t\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\002\b\003\n\002\020\016\n\002\b\003\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\002\n\002\030\002\n\002\030\002\n\002\b\033\030\000 \\2\0020\0012\0020\002:\005[\\]^_B-\022\006\020\003\032\0020\004\022\006\020\005\032\0020\006\022\006\020\007\032\0020\b\022\006\020\t\032\0020\n\022\006\020\013\032\0020\f¢\006\002\020\rJ\026\020/\032\002002\006\0201\032\0020\f2\006\0202\032\00203J\b\0204\032\00200H\026J\037\0205\032\002002\006\0206\032\002072\b\0208\032\004\030\00109H\000¢\006\002\b:J\032\020;\032\0020\0172\006\020<\032\0020\"2\b\020=\032\004\030\0010\025H\026J \020;\032\0020\0172\006\020<\032\0020\"2\b\020=\032\004\030\0010\0252\006\020>\032\0020\fJ\016\020?\032\002002\006\020@\032\0020AJ\034\020B\032\002002\n\020C\032\0060Dj\002`E2\b\0206\032\004\030\00107J\026\020F\032\002002\006\020\033\032\0020\0252\006\020'\032\0020(J\006\020G\032\00200J\030\020H\032\002002\006\020<\032\0020\"2\006\020=\032\0020\025H\026J\020\020I\032\002002\006\020J\032\0020\025H\026J\020\020I\032\002002\006\020K\032\0020\035H\026J\020\020L\032\002002\006\020M\032\0020\035H\026J\020\020N\032\002002\006\020M\032\0020\035H\026J\016\020O\032\0020\0172\006\020M\032\0020\035J\006\020P\032\0020\017J\b\020\036\032\0020\fH\026J\006\020$\032\0020\"J\006\020%\032\0020\"J\b\020Q\032\0020\006H\026J\b\020R\032\00200H\002J\020\020S\032\0020\0172\006\020J\032\0020\025H\026J\020\020S\032\0020\0172\006\020K\032\0020\035H\026J\030\020S\032\0020\0172\006\020T\032\0020\0352\006\020U\032\0020\"H\002J\006\020&\032\0020\"J\006\020V\032\00200J\r\020W\032\0020\017H\000¢\006\002\bXJ\r\020Y\032\00200H\000¢\006\002\bZR\016\020\016\032\0020\017X\016¢\006\002\n\000R\020\020\020\032\004\030\0010\021X\016¢\006\002\n\000R\016\020\022\032\0020\017X\016¢\006\002\n\000R\016\020\023\032\0020\017X\016¢\006\002\n\000R\016\020\024\032\0020\025X\004¢\006\002\n\000R\024\020\007\032\0020\bX\004¢\006\b\n\000\032\004\b\026\020\027R\024\020\030\032\b\022\004\022\0020\0320\031X\004¢\006\002\n\000R\020\020\033\032\004\030\0010\025X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000R\016\020\013\032\0020\fX\004¢\006\002\n\000R\024\020\034\032\b\022\004\022\0020\0350\031X\004¢\006\002\n\000R\016\020\036\032\0020\fX\016¢\006\002\n\000R\016\020\t\032\0020\nX\004¢\006\002\n\000R\020\020\037\032\004\030\0010 X\016¢\006\002\n\000R\016\020!\032\0020\"X\016¢\006\002\n\000R\020\020#\032\004\030\0010\025X\016¢\006\002\n\000R\016\020$\032\0020\"X\016¢\006\002\n\000R\016\020%\032\0020\"X\016¢\006\002\n\000R\016\020&\032\0020\"X\016¢\006\002\n\000R\020\020'\032\004\030\0010(X\016¢\006\002\n\000R\016\020)\032\0020*X\016¢\006\002\n\000R\020\020+\032\004\030\0010,X\016¢\006\002\n\000R\020\020-\032\004\030\0010.X\016¢\006\002\n\000¨\006`"}, d2={"Lokhttp3/internal/ws/RealWebSocket;", "Lokhttp3/WebSocket;", "Lokhttp3/internal/ws/WebSocketReader$FrameCallback;", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "originalRequest", "Lokhttp3/Request;", "listener", "Lokhttp3/WebSocketListener;", "random", "Ljava/util/Random;", "pingIntervalMillis", "", "(Lokhttp3/internal/concurrent/TaskRunner;Lokhttp3/Request;Lokhttp3/WebSocketListener;Ljava/util/Random;J)V", "awaitingPong", "", "call", "Lokhttp3/Call;", "enqueuedClose", "failed", "key", "", "getListener$okhttp", "()Lokhttp3/WebSocketListener;", "messageAndCloseQueue", "Ljava/util/ArrayDeque;", "", "name", "pongQueue", "Lokio/ByteString;", "queueSize", "reader", "Lokhttp3/internal/ws/WebSocketReader;", "receivedCloseCode", "", "receivedCloseReason", "receivedPingCount", "receivedPongCount", "sentPingCount", "streams", "Lokhttp3/internal/ws/RealWebSocket$Streams;", "taskQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "writer", "Lokhttp3/internal/ws/WebSocketWriter;", "writerTask", "Lokhttp3/internal/concurrent/Task;", "awaitTermination", "", "timeout", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "cancel", "checkUpgradeSuccess", "response", "Lokhttp3/Response;", "exchange", "Lokhttp3/internal/connection/Exchange;", "checkUpgradeSuccess$okhttp", "close", "code", "reason", "cancelAfterCloseMillis", "connect", "client", "Lokhttp3/OkHttpClient;", "failWebSocket", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "initReaderAndWriter", "loopReader", "onReadClose", "onReadMessage", "text", "bytes", "onReadPing", "payload", "onReadPong", "pong", "processNextFrame", "request", "runWriter", "send", "data", "formatOpcode", "tearDown", "writeOneFrame", "writeOneFrame$okhttp", "writePingFrame", "writePingFrame$okhttp", "Close", "Companion", "Message", "Streams", "WriterTask", "okhttp"}, k=1, mv={1, 1, 16})
public final class RealWebSocket
  implements WebSocket, WebSocketReader.FrameCallback
{
  private static final long CANCEL_AFTER_CLOSE_MILLIS = 60000L;
  public static final Companion Companion = new Companion(null);
  private static final long MAX_QUEUE_SIZE = 16777216L;
  private static final List<Protocol> ONLY_HTTP1 = CollectionsKt.listOf(Protocol.HTTP_1_1);
  private boolean awaitingPong;
  private Call call;
  private boolean enqueuedClose;
  private boolean failed;
  private final String key;
  private final WebSocketListener listener;
  private final ArrayDeque<Object> messageAndCloseQueue;
  private String name;
  private final Request originalRequest;
  private final long pingIntervalMillis;
  private final ArrayDeque<ByteString> pongQueue;
  private long queueSize;
  private final Random random;
  private WebSocketReader reader;
  private int receivedCloseCode;
  private String receivedCloseReason;
  private int receivedPingCount;
  private int receivedPongCount;
  private int sentPingCount;
  private Streams streams;
  private TaskQueue taskQueue;
  private WebSocketWriter writer;
  private Task writerTask;
  
  public RealWebSocket(TaskRunner paramTaskRunner, Request paramRequest, WebSocketListener paramWebSocketListener, Random paramRandom, long paramLong)
  {
    this.originalRequest = paramRequest;
    this.listener = paramWebSocketListener;
    this.random = paramRandom;
    this.pingIntervalMillis = paramLong;
    this.taskQueue = paramTaskRunner.newQueue();
    this.pongQueue = new ArrayDeque();
    this.messageAndCloseQueue = new ArrayDeque();
    this.receivedCloseCode = -1;
    if (Intrinsics.areEqual("GET", this.originalRequest.method()))
    {
      paramTaskRunner = ByteString.Companion;
      paramRequest = new byte[16];
      this.random.nextBytes(paramRequest);
      this.key = ByteString.Companion.of$default(paramTaskRunner, paramRequest, 0, 0, 3, null).base64();
      return;
    }
    paramTaskRunner = new StringBuilder();
    paramTaskRunner.append("Request must be GET: ");
    paramTaskRunner.append(this.originalRequest.method());
    throw ((Throwable)new IllegalArgumentException(paramTaskRunner.toString().toString()));
  }
  
  private final void runWriter()
  {
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(this)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      ((StringBuilder)localObject).append(localThread.getName());
      ((StringBuilder)localObject).append(" MUST hold lock on ");
      ((StringBuilder)localObject).append(this);
      throw ((Throwable)new AssertionError(((StringBuilder)localObject).toString()));
    }
    Object localObject = this.writerTask;
    if (localObject != null) {
      TaskQueue.schedule$default(this.taskQueue, (Task)localObject, 0L, 2, null);
    }
  }
  
  private final boolean send(ByteString paramByteString, int paramInt)
  {
    try
    {
      if ((!this.failed) && (!this.enqueuedClose))
      {
        if (this.queueSize + paramByteString.size() > 16777216L)
        {
          close(1001, null);
          return false;
        }
        this.queueSize += paramByteString.size();
        this.messageAndCloseQueue.add(new Message(paramInt, paramByteString));
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public final void awaitTermination(long paramLong, TimeUnit paramTimeUnit)
    throws InterruptedException
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "timeUnit");
    this.taskQueue.idleLatch().await(paramLong, paramTimeUnit);
  }
  
  public void cancel()
  {
    Call localCall = this.call;
    if (localCall == null) {
      Intrinsics.throwNpe();
    }
    localCall.cancel();
  }
  
  public final void checkUpgradeSuccess$okhttp(Response paramResponse, Exchange paramExchange)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    if (paramResponse.code() == 101)
    {
      Object localObject = Response.header$default(paramResponse, "Connection", null, 2, null);
      if (StringsKt.equals("Upgrade", (String)localObject, true))
      {
        localObject = Response.header$default(paramResponse, "Upgrade", null, 2, null);
        if (StringsKt.equals("websocket", (String)localObject, true))
        {
          paramResponse = Response.header$default(paramResponse, "Sec-WebSocket-Accept", null, 2, null);
          localObject = ByteString.Companion;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.key);
          localStringBuilder.append("258EAFA5-E914-47DA-95CA-C5AB0DC85B11");
          localObject = ((ByteString.Companion)localObject).encodeUtf8(localStringBuilder.toString()).sha1().base64();
          if (!(Intrinsics.areEqual(localObject, paramResponse) ^ true))
          {
            if (paramExchange != null) {
              return;
            }
            throw ((Throwable)new ProtocolException("Web Socket exchange missing: bad interceptor?"));
          }
          paramExchange = new StringBuilder();
          paramExchange.append("Expected 'Sec-WebSocket-Accept' header value '");
          paramExchange.append((String)localObject);
          paramExchange.append("' but was '");
          paramExchange.append(paramResponse);
          paramExchange.append('\'');
          throw ((Throwable)new ProtocolException(paramExchange.toString()));
        }
        paramResponse = new StringBuilder();
        paramResponse.append("Expected 'Upgrade' header value 'websocket' but was '");
        paramResponse.append((String)localObject);
        paramResponse.append('\'');
        throw ((Throwable)new ProtocolException(paramResponse.toString()));
      }
      paramResponse = new StringBuilder();
      paramResponse.append("Expected 'Connection' header value 'Upgrade' but was '");
      paramResponse.append((String)localObject);
      paramResponse.append('\'');
      throw ((Throwable)new ProtocolException(paramResponse.toString()));
    }
    paramExchange = new StringBuilder();
    paramExchange.append("Expected HTTP 101 response but was '");
    paramExchange.append(paramResponse.code());
    paramExchange.append(' ');
    paramExchange.append(paramResponse.message());
    paramExchange.append('\'');
    throw ((Throwable)new ProtocolException(paramExchange.toString()));
  }
  
  public boolean close(int paramInt, String paramString)
  {
    return close(paramInt, paramString, 60000L);
  }
  
  public final boolean close(int paramInt, String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        WebSocketProtocol.INSTANCE.validateCloseCode(paramInt);
        Object localObject = (ByteString)null;
        if (paramString != null)
        {
          localObject = ByteString.Companion.encodeUtf8(paramString);
          if (((ByteString)localObject).size() <= 123L)
          {
            i = 1;
            break label152;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("reason.size() > 123: ");
            ((StringBuilder)localObject).append(paramString);
            throw ((Throwable)new IllegalArgumentException(((StringBuilder)localObject).toString().toString()));
          }
        }
        else
        {
          if ((!this.failed) && (!this.enqueuedClose))
          {
            this.enqueuedClose = true;
            this.messageAndCloseQueue.add(new Close(paramInt, (ByteString)localObject, paramLong));
            runWriter();
            return true;
          }
          return false;
        }
      }
      finally {}
      int i = 0;
      label152:
      if (i == 0) {}
    }
  }
  
  public final void connect(final OkHttpClient paramOkHttpClient)
  {
    Intrinsics.checkParameterIsNotNull(paramOkHttpClient, "client");
    Object localObject = paramOkHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(ONLY_HTTP1).build();
    paramOkHttpClient = this.originalRequest.newBuilder().header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
    localObject = (Call)new RealCall((OkHttpClient)localObject, paramOkHttpClient, true);
    this.call = ((Call)localObject);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((Call)localObject).enqueue((Callback)new Callback()
    {
      public void onFailure(Call paramAnonymousCall, IOException paramAnonymousIOException)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousIOException, "e");
        this.this$0.failWebSocket((Exception)paramAnonymousIOException, null);
      }
      
      public void onResponse(Call paramAnonymousCall, Response paramAnonymousResponse)
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousCall, "call");
        Intrinsics.checkParameterIsNotNull(paramAnonymousResponse, "response");
        Object localObject = paramAnonymousResponse.exchange();
        try
        {
          this.this$0.checkUpgradeSuccess$okhttp(paramAnonymousResponse, (Exchange)localObject);
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          paramAnonymousCall = ((Exchange)localObject).newWebSocketStreams();
          try
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(Util.okHttpName);
            ((StringBuilder)localObject).append(" WebSocket ");
            ((StringBuilder)localObject).append(paramOkHttpClient.url().redact());
            localObject = ((StringBuilder)localObject).toString();
            this.this$0.initReaderAndWriter((String)localObject, paramAnonymousCall);
            this.this$0.getListener$okhttp().onOpen((WebSocket)this.this$0, paramAnonymousResponse);
            this.this$0.loopReader();
            return;
          }
          catch (Exception paramAnonymousCall)
          {
            this.this$0.failWebSocket(paramAnonymousCall, null);
            return;
          }
          return;
        }
        catch (IOException paramAnonymousCall)
        {
          if (localObject != null) {
            ((Exchange)localObject).webSocketUpgradeFailed();
          }
          this.this$0.failWebSocket((Exception)paramAnonymousCall, paramAnonymousResponse);
          Util.closeQuietly((Closeable)paramAnonymousResponse);
        }
      }
    });
  }
  
  /* Error */
  public final void failWebSocket(Exception paramException, Response paramResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 494
    //   4: invokestatic 173	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   7: aload_0
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 309	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   13: istore_3
    //   14: iload_3
    //   15: ifeq +6 -> 21
    //   18: aload_0
    //   19: monitorexit
    //   20: return
    //   21: aload_0
    //   22: iconst_1
    //   23: putfield 309	okhttp3/internal/ws/RealWebSocket:failed	Z
    //   26: aload_0
    //   27: getfield 496	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   30: astore 4
    //   32: aload_0
    //   33: aconst_null
    //   34: checkcast 19	okhttp3/internal/ws/RealWebSocket$Streams
    //   37: putfield 496	okhttp3/internal/ws/RealWebSocket:streams	Lokhttp3/internal/ws/RealWebSocket$Streams;
    //   40: aload_0
    //   41: getfield 194	okhttp3/internal/ws/RealWebSocket:taskQueue	Lokhttp3/internal/concurrent/TaskQueue;
    //   44: invokevirtual 499	okhttp3/internal/concurrent/TaskQueue:shutdown	()V
    //   47: getstatic 504	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   50: astore 5
    //   52: aload_0
    //   53: monitorexit
    //   54: aload_0
    //   55: getfield 182	okhttp3/internal/ws/RealWebSocket:listener	Lokhttp3/WebSocketListener;
    //   58: aload_0
    //   59: checkcast 6	okhttp3/WebSocket
    //   62: aload_1
    //   63: checkcast 257	java/lang/Throwable
    //   66: aload_2
    //   67: invokevirtual 510	okhttp3/WebSocketListener:onFailure	(Lokhttp3/WebSocket;Ljava/lang/Throwable;Lokhttp3/Response;)V
    //   70: aload 4
    //   72: ifnull +11 -> 83
    //   75: aload 4
    //   77: checkcast 512	java/io/Closeable
    //   80: invokestatic 516	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   83: return
    //   84: astore_1
    //   85: aload 4
    //   87: ifnull +11 -> 98
    //   90: aload 4
    //   92: checkcast 512	java/io/Closeable
    //   95: invokestatic 516	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   98: aload_1
    //   99: athrow
    //   100: astore_1
    //   101: aload_0
    //   102: monitorexit
    //   103: aload_1
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	RealWebSocket
    //   0	105	1	paramException	Exception
    //   0	105	2	paramResponse	Response
    //   13	2	3	bool	boolean
    //   30	61	4	localStreams	Streams
    //   50	1	5	localUnit	Unit
    // Exception table:
    //   from	to	target	type
    //   54	70	84	finally
    //   9	14	100	finally
    //   21	52	100	finally
  }
  
  public final WebSocketListener getListener$okhttp()
  {
    return this.listener;
  }
  
  public final void initReaderAndWriter(final String paramString, final Streams paramStreams)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    Intrinsics.checkParameterIsNotNull(paramStreams, "streams");
    try
    {
      this.name = paramString;
      this.streams = paramStreams;
      this.writer = new WebSocketWriter(paramStreams.getClient(), paramStreams.getSink(), this.random);
      this.writerTask = ((Task)new WriterTask());
      if (this.pingIntervalMillis != 0L)
      {
        final long l = TimeUnit.MILLISECONDS.toNanos(this.pingIntervalMillis);
        TaskQueue localTaskQueue = this.taskQueue;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" ping");
        localObject = ((StringBuilder)localObject).toString();
        localTaskQueue.schedule((Task)new Task((String)localObject, (String)localObject, l, this)
        {
          public long runOnce()
          {
            paramString.writePingFrame$okhttp();
            return l;
          }
        }, l);
      }
      if ((((Collection)this.messageAndCloseQueue).isEmpty() ^ true)) {
        runWriter();
      }
      paramString = Unit.INSTANCE;
      this.reader = new WebSocketReader(paramStreams.getClient(), paramStreams.getSource(), (WebSocketReader.FrameCallback)this);
      return;
    }
    finally {}
  }
  
  public final void loopReader()
    throws IOException
  {
    while (this.receivedCloseCode == -1)
    {
      WebSocketReader localWebSocketReader = this.reader;
      if (localWebSocketReader == null) {
        Intrinsics.throwNpe();
      }
      localWebSocketReader.processNextFrame();
    }
  }
  
  public void onReadClose(int paramInt, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reason");
    int j = 1;
    int i;
    if (paramInt != -1) {
      i = 1;
    } else {
      i = 0;
    }
    Object localObject2;
    if (i != 0) {
      localObject2 = (Streams)null;
    }
    for (;;)
    {
      try
      {
        if (this.receivedCloseCode != -1) {
          break label215;
        }
        i = j;
        if (i != 0)
        {
          this.receivedCloseCode = paramInt;
          this.receivedCloseReason = paramString;
          Object localObject1 = localObject2;
          if (this.enqueuedClose)
          {
            localObject1 = localObject2;
            if (this.messageAndCloseQueue.isEmpty())
            {
              localObject1 = this.streams;
              this.streams = ((Streams)null);
              this.taskQueue.shutdown();
            }
          }
          localObject2 = Unit.INSTANCE;
          try
          {
            this.listener.onClosing((WebSocket)this, paramInt, paramString);
            if (localObject1 != null) {
              this.listener.onClosed((WebSocket)this, paramInt, paramString);
            }
            return;
          }
          finally
          {
            if (localObject1 != null) {
              Util.closeQuietly((Closeable)localObject1);
            }
          }
        }
        throw ((Throwable)new IllegalStateException("already closed".toString()));
      }
      finally {}
      throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
      label215:
      i = 0;
    }
  }
  
  public void onReadMessage(String paramString)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    this.listener.onMessage((WebSocket)this, paramString);
  }
  
  public void onReadMessage(ByteString paramByteString)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    this.listener.onMessage((WebSocket)this, paramByteString);
  }
  
  public void onReadPing(ByteString paramByteString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "payload");
      if ((!this.failed) && ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())))
      {
        this.pongQueue.add(paramByteString);
        runWriter();
        this.receivedPingCount += 1;
        return;
      }
      return;
    }
    finally {}
  }
  
  public void onReadPong(ByteString paramByteString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "payload");
      this.receivedPongCount += 1;
      this.awaitingPong = false;
      return;
    }
    finally
    {
      paramByteString = finally;
      throw paramByteString;
    }
  }
  
  public final boolean pong(ByteString paramByteString)
  {
    try
    {
      Intrinsics.checkParameterIsNotNull(paramByteString, "payload");
      if ((!this.failed) && ((!this.enqueuedClose) || (!this.messageAndCloseQueue.isEmpty())))
      {
        this.pongQueue.add(paramByteString);
        runWriter();
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public final boolean processNextFrame()
    throws IOException
  {
    try
    {
      WebSocketReader localWebSocketReader = this.reader;
      if (localWebSocketReader == null) {
        Intrinsics.throwNpe();
      }
      localWebSocketReader.processNextFrame();
      int i = this.receivedCloseCode;
      if (i == -1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      failWebSocket(localException, null);
    }
    return false;
  }
  
  public long queueSize()
  {
    try
    {
      long l = this.queueSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int receivedPingCount()
  {
    try
    {
      int i = this.receivedPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final int receivedPongCount()
  {
    try
    {
      int i = this.receivedPongCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  public boolean send(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "text");
    return send(ByteString.Companion.encodeUtf8(paramString), 1);
  }
  
  public boolean send(ByteString paramByteString)
  {
    Intrinsics.checkParameterIsNotNull(paramByteString, "bytes");
    return send(paramByteString, 2);
  }
  
  public final int sentPingCount()
  {
    try
    {
      int i = this.sentPingCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final void tearDown()
    throws InterruptedException
  {
    this.taskQueue.shutdown();
    this.taskQueue.idleLatch().await(10L, TimeUnit.SECONDS);
  }
  
  public final boolean writeOneFrame$okhttp()
    throws IOException
  {
    final Ref.ObjectRef localObjectRef2 = new Ref.ObjectRef();
    localObjectRef2.element = null;
    final Object localObject9 = new Ref.IntRef();
    ((Ref.IntRef)localObject9).element = -1;
    final Ref.ObjectRef localObjectRef1 = new Ref.ObjectRef();
    localObjectRef1.element = ((String)null);
    final Object localObject7 = new Ref.ObjectRef();
    ((Ref.ObjectRef)localObject7).element = ((Streams)null);
    label693:
    for (;;)
    {
      try
      {
        boolean bool = this.failed;
        if (bool) {
          return false;
        }
        final Object localObject8 = this.writer;
        final Object localObject1 = (ByteString)this.pongQueue.poll();
        if (localObject1 == null)
        {
          localObjectRef2.element = this.messageAndCloseQueue.poll();
          if ((localObjectRef2.element instanceof Close))
          {
            ((Ref.IntRef)localObject9).element = this.receivedCloseCode;
            localObjectRef1.element = this.receivedCloseReason;
            if (((Ref.IntRef)localObject9).element != -1)
            {
              ((Ref.ObjectRef)localObject7).element = this.streams;
              this.streams = ((Streams)null);
              this.taskQueue.shutdown();
            }
            else
            {
              localObject10 = localObjectRef2.element;
              if (localObject10 != null)
              {
                long l = ((Close)localObject10).getCancelAfterCloseMillis();
                localObject10 = this.taskQueue;
                Object localObject11 = new StringBuilder();
                ((StringBuilder)localObject11).append(this.name);
                ((StringBuilder)localObject11).append(" cancel");
                localObject11 = ((StringBuilder)localObject11).toString();
                l = TimeUnit.MILLISECONDS.toNanos(l);
                ((TaskQueue)localObject10).schedule((Task)new Task((String)localObject11, true)
                {
                  public long runOnce()
                  {
                    jdField_this.cancel();
                    return -1L;
                  }
                }, l);
              }
              else
              {
                throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
              }
            }
          }
          else
          {
            localObject10 = localObjectRef2.element;
            if (localObject10 == null) {
              return false;
            }
          }
        }
        Object localObject10 = Unit.INSTANCE;
        if ((localObject1 == null) || (localObject8 == null)) {}
        try
        {
          Intrinsics.throwNpe();
          ((WebSocketWriter)localObject8).writePong((ByteString)localObject1);
          break label693;
        }
        finally {}
        if ((localObjectRef2.element instanceof Message))
        {
          localObject1 = localObjectRef2.element;
          if (localObject1 != null)
          {
            localObject1 = ((Message)localObject1).getData();
            if (localObject8 == null) {
              Intrinsics.throwNpe();
            }
            localObject9 = localObjectRef2.element;
            if (localObject9 != null)
            {
              localObject8 = Okio.buffer(((WebSocketWriter)localObject8).newMessageSink(((Message)localObject9).getFormatOpcode(), ((ByteString)localObject1).size()));
              ((BufferedSink)localObject8).write((ByteString)localObject1);
              ((BufferedSink)localObject8).close();
              try
              {
                this.queueSize -= ((ByteString)localObject1).size();
                localObject1 = Unit.INSTANCE;
                break label693;
              }
              finally
              {
                localObject2 = finally;
                throw ((Throwable)localObject2);
              }
            }
            throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
          }
          throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Message");
        }
        Object localObject3;
        if ((localObjectRef2.element instanceof Close))
        {
          localObject3 = localObjectRef2.element;
          if (localObject3 != null)
          {
            localObject3 = (Close)localObject3;
            if (localObject8 == null) {
              Intrinsics.throwNpe();
            }
            ((WebSocketWriter)localObject8).writeClose(((Close)localObject3).getCode(), ((Close)localObject3).getReason());
          }
        }
        try
        {
          if ((Streams)((Ref.ObjectRef)localObject7).element != null)
          {
            localObject3 = this.listener;
            localObject8 = (WebSocket)this;
            int i = ((Ref.IntRef)localObject9).element;
            localObject9 = (String)localObjectRef1.element;
            if (localObject9 == null) {
              Intrinsics.throwNpe();
            }
            ((WebSocketListener)localObject3).onClosed((WebSocket)localObject8, i, (String)localObject9);
          }
          localObject3 = (Streams)((Ref.ObjectRef)localObject7).element;
          if (localObject3 != null) {
            Util.closeQuietly((Closeable)localObject3);
          }
          return true;
        }
        finally
        {
          continue;
        }
        throw new TypeCastException("null cannot be cast to non-null type okhttp3.internal.ws.RealWebSocket.Close");
        throw ((Throwable)new AssertionError());
      }
      finally {}
      localObject7 = (Streams)((Ref.ObjectRef)localObject7).element;
      if (localObject7 != null) {
        Util.closeQuietly((Closeable)localObject7);
      }
      throw ((Throwable)localObject5);
    }
  }
  
  public final void writePingFrame$okhttp()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.failed;
        if (bool) {
          return;
        }
        Object localObject1 = this.writer;
        if (this.awaitingPong)
        {
          i = this.sentPingCount;
          this.sentPingCount += 1;
          this.awaitingPong = true;
          Unit localUnit = Unit.INSTANCE;
          if (i != -1)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sent ping but didn't receive pong within ");
            ((StringBuilder)localObject1).append(this.pingIntervalMillis);
            ((StringBuilder)localObject1).append("ms (after ");
            ((StringBuilder)localObject1).append(i - 1);
            ((StringBuilder)localObject1).append(" successful ping/pongs)");
            failWebSocket((Exception)new SocketTimeoutException(((StringBuilder)localObject1).toString()), null);
            return;
          }
          if (localObject1 == null) {}
          try
          {
            Intrinsics.throwNpe();
            ((WebSocketWriter)localObject1).writePing(ByteString.EMPTY);
            return;
          }
          catch (IOException localIOException)
          {
            failWebSocket((Exception)localIOException, null);
            return;
          }
        }
        int i = -1;
      }
      finally {}
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\020\t\n\002\b\b\b\000\030\0002\0020\001B\037\022\006\020\002\032\0020\003\022\b\020\004\032\004\030\0010\005\022\006\020\006\032\0020\007¢\006\002\020\bR\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\t\020\nR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\013\020\fR\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\r\020\016¨\006\017"}, d2={"Lokhttp3/internal/ws/RealWebSocket$Close;", "", "code", "", "reason", "Lokio/ByteString;", "cancelAfterCloseMillis", "", "(ILokio/ByteString;J)V", "getCancelAfterCloseMillis", "()J", "getCode", "()I", "getReason", "()Lokio/ByteString;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Close
  {
    private final long cancelAfterCloseMillis;
    private final int code;
    private final ByteString reason;
    
    public Close(int paramInt, ByteString paramByteString, long paramLong)
    {
      this.code = paramInt;
      this.reason = paramByteString;
      this.cancelAfterCloseMillis = paramLong;
    }
    
    public final long getCancelAfterCloseMillis()
    {
      return this.cancelAfterCloseMillis;
    }
    
    public final int getCode()
    {
      return this.code;
    }
    
    public final ByteString getReason()
    {
      return this.reason;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\t\n\002\b\002\n\002\020 \n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\024\020\006\032\b\022\004\022\0020\b0\007X\004¢\006\002\n\000¨\006\t"}, d2={"Lokhttp3/internal/ws/RealWebSocket$Companion;", "", "()V", "CANCEL_AFTER_CLOSE_MILLIS", "", "MAX_QUEUE_SIZE", "ONLY_HTTP1", "", "Lokhttp3/Protocol;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\000\n\002\020\b\n\000\n\002\030\002\n\002\b\006\b\000\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\007\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\n¨\006\013"}, d2={"Lokhttp3/internal/ws/RealWebSocket$Message;", "", "formatOpcode", "", "data", "Lokio/ByteString;", "(ILokio/ByteString;)V", "getData", "()Lokio/ByteString;", "getFormatOpcode", "()I", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Message
  {
    private final ByteString data;
    private final int formatOpcode;
    
    public Message(int paramInt, ByteString paramByteString)
    {
      this.formatOpcode = paramInt;
      this.data = paramByteString;
    }
    
    public final ByteString getData()
    {
      return this.data;
    }
    
    public final int getFormatOpcode()
    {
      return this.formatOpcode;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\b\b&\030\0002\0020\001B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bR\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\t\020\nR\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\013\020\fR\021\020\004\032\0020\005¢\006\b\n\000\032\004\b\r\020\016¨\006\017"}, d2={"Lokhttp3/internal/ws/RealWebSocket$Streams;", "Ljava/io/Closeable;", "client", "", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(ZLokio/BufferedSource;Lokio/BufferedSink;)V", "getClient", "()Z", "getSink", "()Lokio/BufferedSink;", "getSource", "()Lokio/BufferedSource;", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract class Streams
    implements Closeable
  {
    private final boolean client;
    private final BufferedSink sink;
    private final BufferedSource source;
    
    public Streams(boolean paramBoolean, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
    {
      this.client = paramBoolean;
      this.source = paramBufferedSource;
      this.sink = paramBufferedSink;
    }
    
    public final boolean getClient()
    {
      return this.client;
    }
    
    public final BufferedSink getSink()
    {
      return this.sink;
    }
    
    public final BufferedSource getSource()
    {
      return this.source;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\t\n\000\b\004\030\0002\0020\001B\005¢\006\002\020\002J\b\020\003\032\0020\004H\026¨\006\005"}, d2={"Lokhttp3/internal/ws/RealWebSocket$WriterTask;", "Lokhttp3/internal/concurrent/Task;", "(Lokhttp3/internal/ws/RealWebSocket;)V", "runOnce", "", "okhttp"}, k=1, mv={1, 1, 16})
  private final class WriterTask
    extends Task
  {
    public WriterTask()
    {
      super(false, 2, null);
    }
    
    public long runOnce()
    {
      try
      {
        boolean bool = this.this$0.writeOneFrame$okhttp();
        if (bool) {
          return 0L;
        }
      }
      catch (IOException localIOException)
      {
        this.this$0.failWebSocket((Exception)localIOException, null);
      }
      return -1L;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\ws\RealWebSocket.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */