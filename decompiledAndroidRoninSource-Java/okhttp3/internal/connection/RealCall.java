package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.CertificatePinner;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.EventListener;
import okhttp3.EventListener.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import okio.AsyncTimeout;

@Metadata(bv={1, 0, 3}, d1={"\000\001\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\020\000\n\002\b\004\n\002\030\002\n\002\b\005\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\r\n\002\b\004\n\002\020\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\007\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\n\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\007*\001)\030\0002\0020\001:\002`aB\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ\016\020,\032\0020-2\006\020\016\032\0020\017J\b\020.\032\0020-H\002J\b\020/\032\0020-H\026J\b\0200\032\0020\000H\026J\020\0201\032\002022\006\0203\032\00204H\002J\020\0205\032\0020-2\006\0206\032\00207H\026J\026\0208\032\0020-2\006\0209\032\0020\0052\006\020:\032\0020\007J\b\020;\032\0020<H\026J\025\020=\032\0020-2\006\020>\032\0020\007H\000¢\006\002\b?J\r\020@\032\0020<H\000¢\006\002\bAJ\025\020B\032\0020\0312\006\020C\032\0020DH\000¢\006\002\bEJ\b\020F\032\0020\007H\026J\b\020G\032\0020\007H\026J)\020H\032\002HI\"\n\b\000\020I*\004\030\0010J2\006\020K\032\002HI2\006\020L\032\0020\007H\002¢\006\002\020MJ;\020N\032\002HI\"\n\b\000\020I*\004\030\0010J2\006\020\030\032\0020\0312\006\020O\032\0020\0072\006\020P\032\0020\0072\006\020K\032\002HIH\000¢\006\004\bQ\020RJ\031\020%\032\004\030\0010J2\b\020K\032\004\030\0010JH\000¢\006\002\bSJ\r\020T\032\0020UH\000¢\006\002\bVJ\017\020W\032\004\030\0010XH\000¢\006\002\bYJ\b\0209\032\0020\005H\026J\006\020Z\032\0020\007J\b\020(\032\0020[H\026J\006\020+\032\0020-J!\020\\\032\002HI\"\n\b\000\020I*\004\030\0010J2\006\020]\032\002HIH\002¢\006\002\020^J\b\020_\032\0020UH\002R\020\020\t\032\004\030\0010\nX\016¢\006\002\n\000R\016\020\013\032\0020\007X\016¢\006\002\n\000R\021\020\002\032\0020\003¢\006\b\n\000\032\004\b\f\020\rR\034\020\016\032\004\030\0010\017X\016¢\006\016\n\000\032\004\b\020\020\021\"\004\b\022\020\023R\016\020\024\032\0020\025X\004¢\006\002\n\000R\016\020\026\032\0020\027X\004¢\006\002\n\000R\020\020\030\032\004\030\0010\031X\016¢\006\002\n\000R\020\020\032\032\004\030\0010\033X\016¢\006\002\n\000R\016\020\034\032\0020\007X\016¢\006\002\n\000R\016\020\035\032\0020\007X\016¢\006\002\n\000R\016\020\036\032\0020\007X\016¢\006\002\n\000R\021\020\006\032\0020\007¢\006\b\n\000\032\004\b\037\020 R\"\020\"\032\004\030\0010\0312\b\020!\032\004\030\0010\031@BX\016¢\006\b\n\000\032\004\b#\020$R\016\020%\032\0020\007X\016¢\006\002\n\000R\021\020\004\032\0020\005¢\006\b\n\000\032\004\b&\020'R\020\020(\032\0020)X\004¢\006\004\n\002\020*R\016\020+\032\0020\007X\016¢\006\002\n\000¨\006b"}, d2={"Lokhttp3/internal/connection/RealCall;", "Lokhttp3/Call;", "client", "Lokhttp3/OkHttpClient;", "originalRequest", "Lokhttp3/Request;", "forWebSocket", "", "(Lokhttp3/OkHttpClient;Lokhttp3/Request;Z)V", "callStackTrace", "", "canceled", "getClient", "()Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "setConnection", "(Lokhttp3/internal/connection/RealConnection;)V", "connectionPool", "Lokhttp3/internal/connection/RealConnectionPool;", "eventListener", "Lokhttp3/EventListener;", "exchange", "Lokhttp3/internal/connection/Exchange;", "exchangeFinder", "Lokhttp3/internal/connection/ExchangeFinder;", "exchangeRequestDone", "exchangeResponseDone", "executed", "getForWebSocket", "()Z", "<set-?>", "interceptorScopedExchange", "getInterceptorScopedExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "noMoreExchanges", "getOriginalRequest", "()Lokhttp3/Request;", "timeout", "okhttp3/internal/connection/RealCall$timeout$1", "Lokhttp3/internal/connection/RealCall$timeout$1;", "timeoutEarlyExit", "acquireConnectionNoEvents", "", "callStart", "cancel", "clone", "createAddress", "Lokhttp3/Address;", "url", "Lokhttp3/HttpUrl;", "enqueue", "responseCallback", "Lokhttp3/Callback;", "enterNetworkInterceptorExchange", "request", "newExchangeFinder", "execute", "Lokhttp3/Response;", "exitNetworkInterceptorExchange", "closeExchange", "exitNetworkInterceptorExchange$okhttp", "getResponseWithInterceptorChain", "getResponseWithInterceptorChain$okhttp", "initExchange", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "initExchange$okhttp", "isCanceled", "isExecuted", "maybeReleaseConnection", "E", "Ljava/io/IOException;", "e", "force", "(Ljava/io/IOException;Z)Ljava/io/IOException;", "messageDone", "requestDone", "responseDone", "messageDone$okhttp", "(Lokhttp3/internal/connection/Exchange;ZZLjava/io/IOException;)Ljava/io/IOException;", "noMoreExchanges$okhttp", "redactedUrl", "", "redactedUrl$okhttp", "releaseConnectionNoEvents", "Ljava/net/Socket;", "releaseConnectionNoEvents$okhttp", "retryAfterFailure", "Lokio/AsyncTimeout;", "timeoutExit", "cause", "(Ljava/io/IOException;)Ljava/io/IOException;", "toLoggableString", "AsyncCall", "CallReference", "okhttp"}, k=1, mv={1, 1, 16})
public final class RealCall
  implements Call
{
  private Object callStackTrace;
  private boolean canceled;
  private final OkHttpClient client;
  private RealConnection connection;
  private final RealConnectionPool connectionPool;
  private final EventListener eventListener;
  private Exchange exchange;
  private ExchangeFinder exchangeFinder;
  private boolean exchangeRequestDone;
  private boolean exchangeResponseDone;
  private boolean executed;
  private final boolean forWebSocket;
  private Exchange interceptorScopedExchange;
  private boolean noMoreExchanges;
  private final Request originalRequest;
  private final timeout.1 timeout;
  private boolean timeoutEarlyExit;
  
  public RealCall(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean)
  {
    this.client = paramOkHttpClient;
    this.originalRequest = paramRequest;
    this.forWebSocket = paramBoolean;
    this.connectionPool = paramOkHttpClient.connectionPool().getDelegate$okhttp();
    this.eventListener = this.client.eventListenerFactory().create((Call)this);
    paramOkHttpClient = new AsyncTimeout()
    {
      protected void timedOut()
      {
        this.this$0.cancel();
      }
    };
    paramOkHttpClient.timeout(this.client.callTimeoutMillis(), TimeUnit.MILLISECONDS);
    this.timeout = paramOkHttpClient;
  }
  
  private final void callStart()
  {
    this.callStackTrace = Platform.Companion.get().getStackTraceForCloseable("response.body().close()");
    this.eventListener.callStart((Call)this);
  }
  
  private final Address createAddress(HttpUrl paramHttpUrl)
  {
    SSLSocketFactory localSSLSocketFactory = (SSLSocketFactory)null;
    HostnameVerifier localHostnameVerifier = (HostnameVerifier)null;
    CertificatePinner localCertificatePinner = (CertificatePinner)null;
    if (paramHttpUrl.isHttps())
    {
      localSSLSocketFactory = this.client.sslSocketFactory();
      localHostnameVerifier = this.client.hostnameVerifier();
      localCertificatePinner = this.client.certificatePinner();
    }
    return new Address(paramHttpUrl.host(), paramHttpUrl.port(), this.client.dns(), this.client.socketFactory(), localSSLSocketFactory, localHostnameVerifier, localCertificatePinner, this.client.proxyAuthenticator(), this.client.proxy(), this.client.protocols(), this.client.connectionSpecs(), this.client.proxySelector());
  }
  
  private final <E extends IOException> E maybeReleaseConnection(E paramE, boolean paramBoolean)
  {
    Object localObject2 = new Ref.ObjectRef();
    Object localObject3 = this.connectionPool;
    int j = 0;
    int i;
    Object localObject1;
    if (paramBoolean)
    {
      try
      {
        if (this.exchange != null) {
          break label281;
        }
      }
      finally
      {
        label85:
        for (;;) {}
      }
      if (i != 0)
      {
        ((Ref.ObjectRef)localObject2).element = ((Connection)this.connection);
        if ((this.connection == null) || (this.exchange != null) || ((!paramBoolean) && (!this.noMoreExchanges))) {
          break label295;
        }
        localObject1 = releaseConnectionNoEvents$okhttp();
        if (this.connection != null) {
          ((Ref.ObjectRef)localObject2).element = ((Connection)null);
        }
        if ((!this.noMoreExchanges) || (this.exchange != null)) {
          break label301;
        }
        i = 1;
      }
    }
    for (;;)
    {
      Unit localUnit = Unit.INSTANCE;
      if (localObject1 != null) {
        Util.closeQuietly((Socket)localObject1);
      }
      if ((Connection)((Ref.ObjectRef)localObject2).element != null)
      {
        localObject1 = this.eventListener;
        localObject3 = (Call)this;
        localObject2 = (Connection)((Ref.ObjectRef)localObject2).element;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        ((EventListener)localObject1).connectionReleased((Call)localObject3, (Connection)localObject2);
      }
      localObject1 = paramE;
      if (i != 0)
      {
        i = j;
        if (paramE != null) {
          i = 1;
        }
        localObject1 = timeoutExit(paramE);
        if (i != 0)
        {
          paramE = this.eventListener;
          localObject2 = (Call)this;
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          paramE.callFailed((Call)localObject2, (IOException)localObject1);
          return (E)localObject1;
        }
        this.eventListener.callEnd((Call)this);
      }
      return (E)localObject1;
      throw ((Throwable)new IllegalStateException("cannot release connection while it is in use".toString()));
      throw paramE;
      label281:
      i = 0;
      break;
      i = 1;
      break;
      label295:
      localObject1 = null;
      break label85;
      label301:
      i = 0;
    }
  }
  
  private final <E extends IOException> E timeoutExit(E paramE)
  {
    if (this.timeoutEarlyExit) {
      return paramE;
    }
    if (!this.timeout.exit()) {
      return paramE;
    }
    InterruptedIOException localInterruptedIOException = new InterruptedIOException("timeout");
    if (paramE != null) {
      localInterruptedIOException.initCause((Throwable)paramE);
    }
    return (IOException)localInterruptedIOException;
  }
  
  private final String toLoggableString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    String str;
    if (isCanceled()) {
      str = "canceled ";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    if (this.forWebSocket) {
      str = "web socket";
    } else {
      str = "call";
    }
    localStringBuilder.append(str);
    localStringBuilder.append(" to ");
    localStringBuilder.append(redactedUrl$okhttp());
    return localStringBuilder.toString();
  }
  
  public final void acquireConnectionNoEvents(RealConnection paramRealConnection)
  {
    Intrinsics.checkParameterIsNotNull(paramRealConnection, "connection");
    RealConnectionPool localRealConnectionPool = this.connectionPool;
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(localRealConnectionPool)))
    {
      paramRealConnection = new StringBuilder();
      paramRealConnection.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      paramRealConnection.append(localThread.getName());
      paramRealConnection.append(" MUST hold lock on ");
      paramRealConnection.append(localRealConnectionPool);
      throw ((Throwable)new AssertionError(paramRealConnection.toString()));
    }
    int i;
    if (this.connection == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.connection = paramRealConnection;
      paramRealConnection.getCalls().add(new CallReference(this, this.callStackTrace));
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public void cancel()
  {
    synchronized (this.connectionPool)
    {
      boolean bool = this.canceled;
      if (bool) {
        return;
      }
      this.canceled = true;
      Exchange localExchange = this.exchange;
      Object localObject1 = this.exchangeFinder;
      if (localObject1 != null)
      {
        localObject1 = ((ExchangeFinder)localObject1).connectingConnection();
        if (localObject1 != null) {}
      }
      else
      {
        localObject1 = this.connection;
      }
      Unit localUnit = Unit.INSTANCE;
      if (localExchange != null) {
        localExchange.cancel();
      } else if (localObject1 != null) {
        ((RealConnection)localObject1).cancel();
      }
      this.eventListener.canceled((Call)this);
      return;
    }
  }
  
  public RealCall clone()
  {
    return new RealCall(this.client, this.originalRequest, this.forWebSocket);
  }
  
  public void enqueue(Callback paramCallback)
  {
    Intrinsics.checkParameterIsNotNull(paramCallback, "responseCallback");
    try
    {
      if ((this.executed ^ true))
      {
        this.executed = true;
        Unit localUnit = Unit.INSTANCE;
        callStart();
        this.client.dispatcher().enqueue$okhttp(new AsyncCall(paramCallback));
        return;
      }
      throw ((Throwable)new IllegalStateException("Already Executed".toString()));
    }
    finally {}
  }
  
  public final void enterNetworkInterceptorExchange(Request paramRequest, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    Exchange localExchange = this.interceptorScopedExchange;
    int j = 1;
    int i;
    if (localExchange == null) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      if (this.exchange == null) {
        i = j;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if (paramBoolean) {
          this.exchangeFinder = new ExchangeFinder(this.connectionPool, createAddress(paramRequest.url()), this, this.eventListener);
        }
        return;
      }
      throw ((Throwable)new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()".toString()));
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public Response execute()
  {
    try
    {
      if ((this.executed ^ true))
      {
        this.executed = true;
        Object localObject1 = Unit.INSTANCE;
        this.timeout.enter();
        callStart();
        try
        {
          this.client.dispatcher().executed$okhttp(this);
          localObject1 = getResponseWithInterceptorChain$okhttp();
          return (Response)localObject1;
        }
        finally
        {
          this.client.dispatcher().finished$okhttp(this);
        }
      }
      throw ((Throwable)new IllegalStateException("Already Executed".toString()));
    }
    finally {}
  }
  
  public final void exitNetworkInterceptorExchange$okhttp(boolean paramBoolean)
  {
    boolean bool = this.noMoreExchanges;
    int i = 1;
    if ((bool ^ true))
    {
      if (paramBoolean)
      {
        Exchange localExchange = this.exchange;
        if (localExchange != null) {
          localExchange.detachWithViolence();
        }
        if (this.exchange != null) {
          i = 0;
        }
        if (i == 0) {
          throw ((Throwable)new IllegalStateException("Check failed.".toString()));
        }
      }
      this.interceptorScopedExchange = ((Exchange)null);
      return;
    }
    throw ((Throwable)new IllegalStateException("released".toString()));
  }
  
  public final OkHttpClient getClient()
  {
    return this.client;
  }
  
  public final RealConnection getConnection()
  {
    return this.connection;
  }
  
  public final boolean getForWebSocket()
  {
    return this.forWebSocket;
  }
  
  public final Exchange getInterceptorScopedExchange$okhttp()
  {
    return this.interceptorScopedExchange;
  }
  
  public final Request getOriginalRequest()
  {
    return this.originalRequest;
  }
  
  /* Error */
  public final Response getResponseWithInterceptorChain$okhttp()
    throws IOException
  {
    // Byte code:
    //   0: new 501	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 502	java/util/ArrayList:<init>	()V
    //   7: checkcast 416	java/util/List
    //   10: astore 4
    //   12: aload 4
    //   14: checkcast 504	java/util/Collection
    //   17: astore 5
    //   19: aload 5
    //   21: aload_0
    //   22: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   25: invokevirtual 507	okhttp3/OkHttpClient:interceptors	()Ljava/util/List;
    //   28: checkcast 509	java/lang/Iterable
    //   31: invokestatic 515	kotlin/collections/CollectionsKt:addAll	(Ljava/util/Collection;Ljava/lang/Iterable;)Z
    //   34: pop
    //   35: aload 5
    //   37: new 517	okhttp3/internal/http/RetryAndFollowUpInterceptor
    //   40: dup
    //   41: aload_0
    //   42: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   45: invokespecial 520	okhttp3/internal/http/RetryAndFollowUpInterceptor:<init>	(Lokhttp3/OkHttpClient;)V
    //   48: invokeinterface 521 2 0
    //   53: pop
    //   54: aload 5
    //   56: new 523	okhttp3/internal/http/BridgeInterceptor
    //   59: dup
    //   60: aload_0
    //   61: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   64: invokevirtual 527	okhttp3/OkHttpClient:cookieJar	()Lokhttp3/CookieJar;
    //   67: invokespecial 530	okhttp3/internal/http/BridgeInterceptor:<init>	(Lokhttp3/CookieJar;)V
    //   70: invokeinterface 521 2 0
    //   75: pop
    //   76: aload 5
    //   78: new 532	okhttp3/internal/cache/CacheInterceptor
    //   81: dup
    //   82: aload_0
    //   83: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   86: invokevirtual 536	okhttp3/OkHttpClient:cache	()Lokhttp3/Cache;
    //   89: invokespecial 539	okhttp3/internal/cache/CacheInterceptor:<init>	(Lokhttp3/Cache;)V
    //   92: invokeinterface 521 2 0
    //   97: pop
    //   98: aload 5
    //   100: getstatic 544	okhttp3/internal/connection/ConnectInterceptor:INSTANCE	Lokhttp3/internal/connection/ConnectInterceptor;
    //   103: invokeinterface 521 2 0
    //   108: pop
    //   109: aload_0
    //   110: getfield 138	okhttp3/internal/connection/RealCall:forWebSocket	Z
    //   113: ifne +19 -> 132
    //   116: aload 5
    //   118: aload_0
    //   119: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   122: invokevirtual 547	okhttp3/OkHttpClient:networkInterceptors	()Ljava/util/List;
    //   125: checkcast 509	java/lang/Iterable
    //   128: invokestatic 515	kotlin/collections/CollectionsKt:addAll	(Ljava/util/Collection;Ljava/lang/Iterable;)Z
    //   131: pop
    //   132: aload 5
    //   134: new 549	okhttp3/internal/http/CallServerInterceptor
    //   137: dup
    //   138: aload_0
    //   139: getfield 138	okhttp3/internal/connection/RealCall:forWebSocket	Z
    //   142: invokespecial 551	okhttp3/internal/http/CallServerInterceptor:<init>	(Z)V
    //   145: invokeinterface 521 2 0
    //   150: pop
    //   151: new 553	okhttp3/internal/http/RealInterceptorChain
    //   154: dup
    //   155: aload_0
    //   156: aload 4
    //   158: iconst_0
    //   159: aconst_null
    //   160: aload_0
    //   161: getfield 136	okhttp3/internal/connection/RealCall:originalRequest	Lokhttp3/Request;
    //   164: aload_0
    //   165: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   168: invokevirtual 556	okhttp3/OkHttpClient:connectTimeoutMillis	()I
    //   171: aload_0
    //   172: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   175: invokevirtual 559	okhttp3/OkHttpClient:readTimeoutMillis	()I
    //   178: aload_0
    //   179: getfield 134	okhttp3/internal/connection/RealCall:client	Lokhttp3/OkHttpClient;
    //   182: invokevirtual 562	okhttp3/OkHttpClient:writeTimeoutMillis	()I
    //   185: invokespecial 565	okhttp3/internal/http/RealInterceptorChain:<init>	(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V
    //   188: astore 4
    //   190: iconst_0
    //   191: istore_2
    //   192: iload_2
    //   193: istore_1
    //   194: aload 4
    //   196: aload_0
    //   197: getfield 136	okhttp3/internal/connection/RealCall:originalRequest	Lokhttp3/Request;
    //   200: invokevirtual 569	okhttp3/internal/http/RealInterceptorChain:proceed	(Lokhttp3/Request;)Lokhttp3/Response;
    //   203: astore 4
    //   205: iload_2
    //   206: istore_1
    //   207: aload_0
    //   208: invokevirtual 356	okhttp3/internal/connection/RealCall:isCanceled	()Z
    //   211: istore_3
    //   212: iload_3
    //   213: ifne +12 -> 225
    //   216: aload_0
    //   217: aconst_null
    //   218: invokevirtual 571	okhttp3/internal/connection/RealCall:noMoreExchanges$okhttp	(Ljava/io/IOException;)Ljava/io/IOException;
    //   221: pop
    //   222: aload 4
    //   224: areturn
    //   225: iload_2
    //   226: istore_1
    //   227: aload 4
    //   229: checkcast 573	java/io/Closeable
    //   232: invokestatic 576	okhttp3/internal/Util:closeQuietly	(Ljava/io/Closeable;)V
    //   235: iload_2
    //   236: istore_1
    //   237: new 350	java/io/IOException
    //   240: dup
    //   241: ldc_w 578
    //   244: invokespecial 579	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   247: checkcast 333	java/lang/Throwable
    //   250: athrow
    //   251: astore 4
    //   253: goto +43 -> 296
    //   256: astore 4
    //   258: iconst_1
    //   259: istore_2
    //   260: iload_2
    //   261: istore_1
    //   262: aload_0
    //   263: aload 4
    //   265: invokevirtual 571	okhttp3/internal/connection/RealCall:noMoreExchanges$okhttp	(Ljava/io/IOException;)Ljava/io/IOException;
    //   268: astore 4
    //   270: aload 4
    //   272: ifnonnull +16 -> 288
    //   275: iload_2
    //   276: istore_1
    //   277: new 581	kotlin/TypeCastException
    //   280: dup
    //   281: ldc_w 583
    //   284: invokespecial 584	kotlin/TypeCastException:<init>	(Ljava/lang/String;)V
    //   287: athrow
    //   288: iload_2
    //   289: istore_1
    //   290: aload 4
    //   292: checkcast 333	java/lang/Throwable
    //   295: athrow
    //   296: iload_1
    //   297: ifne +9 -> 306
    //   300: aload_0
    //   301: aconst_null
    //   302: invokevirtual 571	okhttp3/internal/connection/RealCall:noMoreExchanges$okhttp	(Ljava/io/IOException;)Ljava/io/IOException;
    //   305: pop
    //   306: aload 4
    //   308: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	309	0	this	RealCall
    //   193	104	1	i	int
    //   191	98	2	j	int
    //   211	2	3	bool	boolean
    //   10	218	4	localObject1	Object
    //   251	1	4	localObject2	Object
    //   256	8	4	localIOException1	IOException
    //   268	39	4	localIOException2	IOException
    //   17	116	5	localCollection	java.util.Collection
    // Exception table:
    //   from	to	target	type
    //   194	205	251	finally
    //   207	212	251	finally
    //   227	235	251	finally
    //   237	251	251	finally
    //   262	270	251	finally
    //   277	288	251	finally
    //   290	296	251	finally
    //   194	205	256	java/io/IOException
    //   207	212	256	java/io/IOException
    //   227	235	256	java/io/IOException
    //   237	251	256	java/io/IOException
  }
  
  public final Exchange initExchange$okhttp(RealInterceptorChain arg1)
  {
    Intrinsics.checkParameterIsNotNull(???, "chain");
    for (;;)
    {
      synchronized (this.connectionPool)
      {
        boolean bool = this.noMoreExchanges;
        i = 1;
        if ((bool ^ true))
        {
          if (this.exchange == null)
          {
            if (i != 0)
            {
              Object localObject3 = Unit.INSTANCE;
              ??? = this.exchangeFinder;
              if (??? == null) {
                Intrinsics.throwNpe();
              }
              ??? = ((ExchangeFinder)???).find(this.client, ???);
              ??? = this.eventListener;
              localObject3 = this.exchangeFinder;
              if (localObject3 == null) {
                Intrinsics.throwNpe();
              }
              ??? = new Exchange(this, (EventListener)???, (ExchangeFinder)localObject3, ???);
              this.interceptorScopedExchange = ((Exchange)???);
              synchronized (this.connectionPool)
              {
                this.exchange = ((Exchange)???);
                this.exchangeRequestDone = false;
                this.exchangeResponseDone = false;
                return (Exchange)???;
              }
            }
            throw ((Throwable)new IllegalStateException("Check failed.".toString()));
          }
        }
        else {
          throw ((Throwable)new IllegalStateException("released".toString()));
        }
      }
      int i = 0;
    }
  }
  
  public boolean isCanceled()
  {
    synchronized (this.connectionPool)
    {
      boolean bool = this.canceled;
      return bool;
    }
  }
  
  public boolean isExecuted()
  {
    try
    {
      boolean bool = this.executed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public final <E extends IOException> E messageDone$okhttp(Exchange paramExchange, boolean paramBoolean1, boolean paramBoolean2, E paramE)
  {
    Intrinsics.checkParameterIsNotNull(paramExchange, "exchange");
    for (;;)
    {
      synchronized (this.connectionPool)
      {
        boolean bool4 = Intrinsics.areEqual(paramExchange, this.exchange);
        boolean bool3 = true;
        if ((bool4 ^ true)) {
          return paramE;
        }
        if (paramBoolean1)
        {
          bool1 = this.exchangeRequestDone ^ true;
          this.exchangeRequestDone = true;
          boolean bool2 = bool1;
          if (paramBoolean2)
          {
            if (!this.exchangeResponseDone) {
              bool1 = true;
            }
            this.exchangeResponseDone = true;
            bool2 = bool1;
          }
          if ((!this.exchangeRequestDone) || (!this.exchangeResponseDone) || (!bool2)) {
            break label187;
          }
          paramExchange = this.exchange;
          if (paramExchange == null) {
            Intrinsics.throwNpe();
          }
          paramExchange = paramExchange.getConnection$okhttp();
          paramExchange.setSuccessCount$okhttp(paramExchange.getSuccessCount$okhttp() + 1);
          this.exchange = ((Exchange)null);
          bool1 = bool3;
          paramExchange = Unit.INSTANCE;
          paramExchange = paramE;
          if (bool1) {
            paramExchange = maybeReleaseConnection(paramE, false);
          }
          return paramExchange;
        }
      }
      boolean bool1 = false;
      continue;
      label187:
      bool1 = false;
    }
  }
  
  public final IOException noMoreExchanges$okhttp(IOException paramIOException)
  {
    synchronized (this.connectionPool)
    {
      this.noMoreExchanges = true;
      Unit localUnit = Unit.INSTANCE;
      return maybeReleaseConnection(paramIOException, false);
    }
  }
  
  public final String redactedUrl$okhttp()
  {
    return this.originalRequest.url().redact();
  }
  
  public final Socket releaseConnectionNoEvents$okhttp()
  {
    Object localObject = this.connectionPool;
    if ((Util.assertionsEnabled) && (!Thread.holdsLock(localObject)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Thread ");
      Thread localThread = Thread.currentThread();
      Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
      localStringBuilder.append(localThread.getName());
      localStringBuilder.append(" MUST hold lock on ");
      localStringBuilder.append(localObject);
      throw ((Throwable)new AssertionError(localStringBuilder.toString()));
    }
    localObject = this.connection;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((RealConnection)localObject).getCalls().iterator();
    int j = 0;
    int i = 0;
    while (((Iterator)localObject).hasNext())
    {
      if (Intrinsics.areEqual((RealCall)((Reference)((Iterator)localObject).next()).get(), (RealCall)this)) {
        break label167;
      }
      i += 1;
    }
    i = -1;
    label167:
    if (i != -1) {
      j = 1;
    }
    if (j != 0)
    {
      localObject = this.connection;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      ((RealConnection)localObject).getCalls().remove(i);
      this.connection = ((RealConnection)null);
      if (((RealConnection)localObject).getCalls().isEmpty())
      {
        ((RealConnection)localObject).setIdleAtNs$okhttp(System.nanoTime());
        if (this.connectionPool.connectionBecameIdle((RealConnection)localObject)) {
          return ((RealConnection)localObject).socket();
        }
      }
      return null;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public Request request()
  {
    return this.originalRequest;
  }
  
  public final boolean retryAfterFailure()
  {
    ExchangeFinder localExchangeFinder = this.exchangeFinder;
    if (localExchangeFinder == null) {
      Intrinsics.throwNpe();
    }
    return localExchangeFinder.retryAfterFailure();
  }
  
  public final void setConnection(RealConnection paramRealConnection)
  {
    this.connection = paramRealConnection;
  }
  
  public AsyncTimeout timeout()
  {
    return (AsyncTimeout)this.timeout;
  }
  
  public final void timeoutEarlyExit()
  {
    if ((this.timeoutEarlyExit ^ true))
    {
      this.timeoutEarlyExit = true;
      this.timeout.exit();
      return;
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\020\016\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\b\004\b\004\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\016\020\026\032\0020\0272\006\020\030\032\0020\031J\022\020\032\032\0020\0272\n\020\033\032\0060\000R\0020\006J\b\020\034\032\0020\027H\026R\021\020\005\032\0020\0068F¢\006\006\032\004\b\007\020\bR\036\020\013\032\0020\n2\006\020\t\032\0020\n@BX\016¢\006\b\n\000\032\004\b\f\020\rR\021\020\016\032\0020\0178F¢\006\006\032\004\b\020\020\021R\021\020\022\032\0020\0238F¢\006\006\032\004\b\024\020\025R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\035"}, d2={"Lokhttp3/internal/connection/RealCall$AsyncCall;", "Ljava/lang/Runnable;", "responseCallback", "Lokhttp3/Callback;", "(Lokhttp3/internal/connection/RealCall;Lokhttp3/Callback;)V", "call", "Lokhttp3/internal/connection/RealCall;", "getCall", "()Lokhttp3/internal/connection/RealCall;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicInteger;", "callsPerHost", "getCallsPerHost", "()Ljava/util/concurrent/atomic/AtomicInteger;", "host", "", "getHost", "()Ljava/lang/String;", "request", "Lokhttp3/Request;", "getRequest", "()Lokhttp3/Request;", "executeOn", "", "executorService", "Ljava/util/concurrent/ExecutorService;", "reuseCallsPerHostFrom", "other", "run", "okhttp"}, k=1, mv={1, 1, 16})
  public final class AsyncCall
    implements Runnable
  {
    private volatile AtomicInteger callsPerHost;
    private final Callback responseCallback;
    
    public AsyncCall()
    {
      this.responseCallback = ((Callback)localObject);
      this.callsPerHost = new AtomicInteger(0);
    }
    
    /* Error */
    public final void executeOn(java.util.concurrent.ExecutorService paramExecutorService)
    {
      // Byte code:
      //   0: aload_1
      //   1: ldc 79
      //   3: invokestatic 58	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   6: aload_0
      //   7: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   10: invokevirtual 83	okhttp3/internal/connection/RealCall:getClient	()Lokhttp3/OkHttpClient;
      //   13: invokevirtual 89	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   16: astore_2
      //   17: getstatic 95	okhttp3/internal/Util:assertionsEnabled	Z
      //   20: ifeq +75 -> 95
      //   23: aload_2
      //   24: invokestatic 101	java/lang/Thread:holdsLock	(Ljava/lang/Object;)Z
      //   27: ifne +6 -> 33
      //   30: goto +65 -> 95
      //   33: new 103	java/lang/StringBuilder
      //   36: dup
      //   37: invokespecial 104	java/lang/StringBuilder:<init>	()V
      //   40: astore_1
      //   41: aload_1
      //   42: ldc 106
      //   44: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   47: pop
      //   48: invokestatic 114	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   51: astore_3
      //   52: aload_3
      //   53: ldc 116
      //   55: invokestatic 119	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   58: aload_1
      //   59: aload_3
      //   60: invokevirtual 122	java/lang/Thread:getName	()Ljava/lang/String;
      //   63: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   66: pop
      //   67: aload_1
      //   68: ldc 124
      //   70: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: pop
      //   74: aload_1
      //   75: aload_2
      //   76: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   79: pop
      //   80: new 129	java/lang/AssertionError
      //   83: dup
      //   84: aload_1
      //   85: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   88: invokespecial 135	java/lang/AssertionError:<init>	(Ljava/lang/Object;)V
      //   91: checkcast 137	java/lang/Throwable
      //   94: athrow
      //   95: aload_1
      //   96: aload_0
      //   97: checkcast 6	java/lang/Runnable
      //   100: invokeinterface 143 2 0
      //   105: return
      //   106: astore_1
      //   107: goto +70 -> 177
      //   110: astore_1
      //   111: new 145	java/io/InterruptedIOException
      //   114: dup
      //   115: ldc -109
      //   117: invokespecial 150	java/io/InterruptedIOException:<init>	(Ljava/lang/String;)V
      //   120: astore_2
      //   121: aload_2
      //   122: aload_1
      //   123: checkcast 137	java/lang/Throwable
      //   126: invokevirtual 154	java/io/InterruptedIOException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
      //   129: pop
      //   130: aload_0
      //   131: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   134: aload_2
      //   135: checkcast 156	java/io/IOException
      //   138: invokevirtual 160	okhttp3/internal/connection/RealCall:noMoreExchanges$okhttp	(Ljava/io/IOException;)Ljava/io/IOException;
      //   141: pop
      //   142: aload_0
      //   143: getfield 65	okhttp3/internal/connection/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   146: aload_0
      //   147: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   150: checkcast 162	okhttp3/Call
      //   153: aload_2
      //   154: checkcast 156	java/io/IOException
      //   157: invokeinterface 168 3 0
      //   162: aload_0
      //   163: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   166: invokevirtual 83	okhttp3/internal/connection/RealCall:getClient	()Lokhttp3/OkHttpClient;
      //   169: invokevirtual 89	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   172: aload_0
      //   173: invokevirtual 174	okhttp3/Dispatcher:finished$okhttp	(Lokhttp3/internal/connection/RealCall$AsyncCall;)V
      //   176: return
      //   177: aload_0
      //   178: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   181: invokevirtual 83	okhttp3/internal/connection/RealCall:getClient	()Lokhttp3/OkHttpClient;
      //   184: invokevirtual 89	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   187: aload_0
      //   188: invokevirtual 174	okhttp3/Dispatcher:finished$okhttp	(Lokhttp3/internal/connection/RealCall$AsyncCall;)V
      //   191: aload_1
      //   192: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	193	0	this	AsyncCall
      //   0	193	1	paramExecutorService	java.util.concurrent.ExecutorService
      //   16	138	2	localObject	Object
      //   51	9	3	localThread	Thread
      // Exception table:
      //   from	to	target	type
      //   95	105	106	finally
      //   111	162	106	finally
      //   95	105	110	java/util/concurrent/RejectedExecutionException
    }
    
    public final RealCall getCall()
    {
      return RealCall.this;
    }
    
    public final AtomicInteger getCallsPerHost()
    {
      return this.callsPerHost;
    }
    
    public final String getHost()
    {
      return RealCall.this.getOriginalRequest().url().host();
    }
    
    public final Request getRequest()
    {
      return RealCall.this.getOriginalRequest();
    }
    
    public final void reuseCallsPerHostFrom(AsyncCall paramAsyncCall)
    {
      Intrinsics.checkParameterIsNotNull(paramAsyncCall, "other");
      this.callsPerHost = paramAsyncCall.callsPerHost;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: new 103	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 104	java/lang/StringBuilder:<init>	()V
      //   7: astore_3
      //   8: aload_3
      //   9: ldc -66
      //   11: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   14: pop
      //   15: aload_3
      //   16: aload_0
      //   17: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   20: invokevirtual 193	okhttp3/internal/connection/RealCall:redactedUrl$okhttp	()Ljava/lang/String;
      //   23: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   26: pop
      //   27: aload_3
      //   28: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   31: astore_3
      //   32: invokestatic 114	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   35: astore 4
      //   37: aload 4
      //   39: ldc -62
      //   41: invokestatic 119	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   44: aload 4
      //   46: invokevirtual 122	java/lang/Thread:getName	()Ljava/lang/String;
      //   49: astore 5
      //   51: aload 4
      //   53: aload_3
      //   54: invokevirtual 197	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   57: aload_0
      //   58: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   61: invokestatic 201	okhttp3/internal/connection/RealCall:access$getTimeout$p	(Lokhttp3/internal/connection/RealCall;)Lokhttp3/internal/connection/RealCall$timeout$1;
      //   64: invokevirtual 206	okhttp3/internal/connection/RealCall$timeout$1:enter	()V
      //   67: aload_0
      //   68: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   71: invokevirtual 210	okhttp3/internal/connection/RealCall:getResponseWithInterceptorChain$okhttp	()Lokhttp3/Response;
      //   74: astore_3
      //   75: iconst_1
      //   76: istore_2
      //   77: iconst_1
      //   78: istore_1
      //   79: aload_0
      //   80: getfield 65	okhttp3/internal/connection/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   83: aload_0
      //   84: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   87: checkcast 162	okhttp3/Call
      //   90: aload_3
      //   91: invokeinterface 214 3 0
      //   96: aload_0
      //   97: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   100: invokevirtual 83	okhttp3/internal/connection/RealCall:getClient	()Lokhttp3/OkHttpClient;
      //   103: invokevirtual 89	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   106: astore_3
      //   107: aload_3
      //   108: aload_0
      //   109: invokevirtual 174	okhttp3/Dispatcher:finished$okhttp	(Lokhttp3/internal/connection/RealCall$AsyncCall;)V
      //   112: goto +182 -> 294
      //   115: astore_3
      //   116: goto +12 -> 128
      //   119: astore_3
      //   120: iload_2
      //   121: istore_1
      //   122: goto +81 -> 203
      //   125: astore_3
      //   126: iconst_0
      //   127: istore_1
      //   128: aload_0
      //   129: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   132: invokevirtual 217	okhttp3/internal/connection/RealCall:cancel	()V
      //   135: iload_1
      //   136: ifne +65 -> 201
      //   139: new 103	java/lang/StringBuilder
      //   142: dup
      //   143: invokespecial 104	java/lang/StringBuilder:<init>	()V
      //   146: astore 6
      //   148: aload 6
      //   150: ldc -37
      //   152: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   155: pop
      //   156: aload 6
      //   158: aload_3
      //   159: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   162: pop
      //   163: new 156	java/io/IOException
      //   166: dup
      //   167: aload 6
      //   169: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   172: invokespecial 220	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   175: astore 6
      //   177: aload 6
      //   179: aload_3
      //   180: invokevirtual 224	java/io/IOException:addSuppressed	(Ljava/lang/Throwable;)V
      //   183: aload_0
      //   184: getfield 65	okhttp3/internal/connection/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   187: aload_0
      //   188: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   191: checkcast 162	okhttp3/Call
      //   194: aload 6
      //   196: invokeinterface 168 3 0
      //   201: aload_3
      //   202: athrow
      //   203: iload_1
      //   204: ifeq +59 -> 263
      //   207: getstatic 230	okhttp3/internal/platform/Platform:Companion	Lokhttp3/internal/platform/Platform$Companion;
      //   210: invokevirtual 236	okhttp3/internal/platform/Platform$Companion:get	()Lokhttp3/internal/platform/Platform;
      //   213: astore 6
      //   215: new 103	java/lang/StringBuilder
      //   218: dup
      //   219: invokespecial 104	java/lang/StringBuilder:<init>	()V
      //   222: astore 7
      //   224: aload 7
      //   226: ldc -18
      //   228: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   231: pop
      //   232: aload 7
      //   234: aload_0
      //   235: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   238: invokestatic 242	okhttp3/internal/connection/RealCall:access$toLoggableString	(Lokhttp3/internal/connection/RealCall;)Ljava/lang/String;
      //   241: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   244: pop
      //   245: aload 6
      //   247: aload 7
      //   249: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   252: iconst_4
      //   253: aload_3
      //   254: checkcast 137	java/lang/Throwable
      //   257: invokevirtual 246	okhttp3/internal/platform/Platform:log	(Ljava/lang/String;ILjava/lang/Throwable;)V
      //   260: goto +20 -> 280
      //   263: aload_0
      //   264: getfield 65	okhttp3/internal/connection/RealCall$AsyncCall:responseCallback	Lokhttp3/Callback;
      //   267: aload_0
      //   268: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   271: checkcast 162	okhttp3/Call
      //   274: aload_3
      //   275: invokeinterface 168 3 0
      //   280: aload_0
      //   281: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   284: invokevirtual 83	okhttp3/internal/connection/RealCall:getClient	()Lokhttp3/OkHttpClient;
      //   287: invokevirtual 89	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   290: astore_3
      //   291: goto -184 -> 107
      //   294: aload 4
      //   296: aload 5
      //   298: invokevirtual 197	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   301: return
      //   302: aload_0
      //   303: getfield 60	okhttp3/internal/connection/RealCall$AsyncCall:this$0	Lokhttp3/internal/connection/RealCall;
      //   306: invokevirtual 83	okhttp3/internal/connection/RealCall:getClient	()Lokhttp3/OkHttpClient;
      //   309: invokevirtual 89	okhttp3/OkHttpClient:dispatcher	()Lokhttp3/Dispatcher;
      //   312: aload_0
      //   313: invokevirtual 174	okhttp3/Dispatcher:finished$okhttp	(Lokhttp3/internal/connection/RealCall$AsyncCall;)V
      //   316: aload_3
      //   317: athrow
      //   318: astore_3
      //   319: aload 4
      //   321: aload 5
      //   323: invokevirtual 197	java/lang/Thread:setName	(Ljava/lang/String;)V
      //   326: aload_3
      //   327: athrow
      //   328: astore_3
      //   329: goto -27 -> 302
      //   332: astore_3
      //   333: iconst_0
      //   334: istore_1
      //   335: goto -132 -> 203
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	338	0	this	AsyncCall
      //   78	257	1	i	int
      //   76	45	2	j	int
      //   7	101	3	localObject1	Object
      //   115	1	3	localObject2	Object
      //   119	1	3	localIOException1	IOException
      //   125	150	3	localObject3	Object
      //   290	27	3	localDispatcher	Dispatcher
      //   318	9	3	localObject4	Object
      //   328	1	3	localObject5	Object
      //   332	1	3	localIOException2	IOException
      //   35	285	4	localThread	Thread
      //   49	273	5	str	String
      //   146	100	6	localObject6	Object
      //   222	26	7	localStringBuilder	StringBuilder
      // Exception table:
      //   from	to	target	type
      //   79	96	115	finally
      //   79	96	119	java/io/IOException
      //   67	75	125	finally
      //   57	67	318	finally
      //   96	107	318	finally
      //   107	112	318	finally
      //   280	291	318	finally
      //   302	318	318	finally
      //   128	135	328	finally
      //   139	201	328	finally
      //   201	203	328	finally
      //   207	260	328	finally
      //   263	280	328	finally
      //   67	75	332	java/io/IOException
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\000\n\002\b\004\b\000\030\0002\b\022\004\022\0020\0020\001B\027\022\006\020\003\032\0020\002\022\b\020\004\032\004\030\0010\005¢\006\002\020\006R\023\020\004\032\004\030\0010\005¢\006\b\n\000\032\004\b\007\020\b¨\006\t"}, d2={"Lokhttp3/internal/connection/RealCall$CallReference;", "Ljava/lang/ref/WeakReference;", "Lokhttp3/internal/connection/RealCall;", "referent", "callStackTrace", "", "(Lokhttp3/internal/connection/RealCall;Ljava/lang/Object;)V", "getCallStackTrace", "()Ljava/lang/Object;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class CallReference
    extends WeakReference<RealCall>
  {
    private final Object callStackTrace;
    
    public CallReference(RealCall paramRealCall, Object paramObject)
    {
      super();
      this.callStackTrace = paramObject;
    }
    
    public final Object getCallStackTrace()
    {
      return this.callStackTrace;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\connection\RealCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */