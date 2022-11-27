package okhttp3.internal.http1;

import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Address;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http.StatusLine.Companion;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ForwardingTimeout;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000\001\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\t\n\000\n\002\020\013\n\002\b\002\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\007\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\017\030\000 @2\0020\001:\007=>?@ABCB'\022\b\020\002\032\004\030\0010\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t¢\006\002\020\nJ\b\020\033\032\0020\034H\026J\030\020\035\032\0020\0362\006\020\037\032\0020\0272\006\020 \032\0020\016H\026J\020\020!\032\0020\0342\006\020\"\032\0020#H\002J\b\020$\032\0020\034H\026J\b\020%\032\0020\034H\026J\b\020&\032\0020\036H\002J\020\020'\032\0020(2\006\020)\032\0020*H\002J\020\020+\032\0020(2\006\020,\032\0020\016H\002J\b\020-\032\0020\036H\002J\b\020.\032\0020(H\002J\020\020/\032\0020(2\006\0200\032\0020\031H\026J\b\0201\032\00202H\002J\b\0203\032\0020\025H\002J\022\0204\032\004\030\001052\006\0206\032\0020\020H\026J\020\0207\032\0020\0162\006\0200\032\0020\031H\026J\016\0208\032\0020\0342\006\0200\032\0020\031J\b\020\024\032\0020\025H\026J\026\0209\032\0020\0342\006\020:\032\0020\0252\006\020;\032\00202J\020\020<\032\0020\0342\006\020\037\032\0020\027H\026R\020\020\002\032\004\030\0010\003X\004¢\006\002\n\000R\024\020\004\032\0020\005X\004¢\006\b\n\000\032\004\b\013\020\fR\016\020\r\032\0020\016X\016¢\006\002\n\000R\021\020\017\032\0020\0208F¢\006\006\032\004\b\017\020\021R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\022\032\0020\023X\016¢\006\002\n\000R\020\020\024\032\004\030\0010\025X\016¢\006\002\n\000R\030\020\026\032\0020\020*\0020\0278BX\004¢\006\006\032\004\b\026\020\030R\030\020\026\032\0020\020*\0020\0318BX\004¢\006\006\032\004\b\026\020\032¨\006D"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "source", "Lokio/BufferedSource;", "sink", "Lokio/BufferedSink;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokio/BufferedSource;Lokio/BufferedSink;)V", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "headerLimit", "", "isClosed", "", "()Z", "state", "", "trailers", "Lokhttp3/Headers;", "isChunked", "Lokhttp3/Request;", "(Lokhttp3/Request;)Z", "Lokhttp3/Response;", "(Lokhttp3/Response;)Z", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "contentLength", "detachTimeout", "timeout", "Lokio/ForwardingTimeout;", "finishRequest", "flushRequest", "newChunkedSink", "newChunkedSource", "Lokio/Source;", "url", "Lokhttp3/HttpUrl;", "newFixedLengthSource", "length", "newKnownLengthSink", "newUnknownLengthSource", "openResponseBodySource", "response", "readHeaderLine", "", "readHeaders", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "skipConnectBody", "writeRequest", "headers", "requestLine", "writeRequestHeaders", "AbstractSource", "ChunkedSink", "ChunkedSource", "Companion", "FixedLengthSource", "KnownLengthSink", "UnknownLengthSource", "okhttp"}, k=1, mv={1, 1, 16})
public final class Http1ExchangeCodec
  implements ExchangeCodec
{
  public static final Companion Companion = new Companion(null);
  private static final int HEADER_LIMIT = 262144;
  private static final long NO_CHUNK_YET = -1L;
  private static final int STATE_CLOSED = 6;
  private static final int STATE_IDLE = 0;
  private static final int STATE_OPEN_REQUEST_BODY = 1;
  private static final int STATE_OPEN_RESPONSE_BODY = 4;
  private static final int STATE_READING_RESPONSE_BODY = 5;
  private static final int STATE_READ_RESPONSE_HEADERS = 3;
  private static final int STATE_WRITING_REQUEST_BODY = 2;
  private final OkHttpClient client;
  private final RealConnection connection;
  private long headerLimit;
  private final BufferedSink sink;
  private final BufferedSource source;
  private int state;
  private Headers trailers;
  
  public Http1ExchangeCodec(OkHttpClient paramOkHttpClient, RealConnection paramRealConnection, BufferedSource paramBufferedSource, BufferedSink paramBufferedSink)
  {
    this.client = paramOkHttpClient;
    this.connection = paramRealConnection;
    this.source = paramBufferedSource;
    this.sink = paramBufferedSink;
    this.headerLimit = 262144;
  }
  
  private final void detachTimeout(ForwardingTimeout paramForwardingTimeout)
  {
    Timeout localTimeout = paramForwardingTimeout.delegate();
    paramForwardingTimeout.setDelegate(Timeout.NONE);
    localTimeout.clearDeadline();
    localTimeout.clearTimeout();
  }
  
  private final boolean isChunked(Request paramRequest)
  {
    return StringsKt.equals("chunked", paramRequest.header("Transfer-Encoding"), true);
  }
  
  private final boolean isChunked(Response paramResponse)
  {
    return StringsKt.equals("chunked", Response.header$default(paramResponse, "Transfer-Encoding", null, 2, null), true);
  }
  
  private final Sink newChunkedSink()
  {
    int j = this.state;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      this.state = 2;
      return (Sink)new ChunkedSink();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private final Source newChunkedSource(HttpUrl paramHttpUrl)
  {
    int i;
    if (this.state == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.state = 5;
      return (Source)new ChunkedSource(paramHttpUrl);
    }
    paramHttpUrl = new StringBuilder();
    paramHttpUrl.append("state: ");
    paramHttpUrl.append(this.state);
    throw ((Throwable)new IllegalStateException(paramHttpUrl.toString().toString()));
  }
  
  private final Source newFixedLengthSource(long paramLong)
  {
    int i;
    if (this.state == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.state = 5;
      return (Source)new FixedLengthSource(paramLong);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private final Sink newKnownLengthSink()
  {
    int j = this.state;
    int i = 1;
    if (j != 1) {
      i = 0;
    }
    if (i != 0)
    {
      this.state = 2;
      return (Sink)new KnownLengthSink();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private final Source newUnknownLengthSource()
  {
    int i;
    if (this.state == 4) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.state = 5;
      getConnection().noNewExchanges();
      return (Source)new UnknownLengthSource();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("state: ");
    localStringBuilder.append(this.state);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  private final String readHeaderLine()
  {
    String str = this.source.readUtf8LineStrict(this.headerLimit);
    this.headerLimit -= str.length();
    return str;
  }
  
  private final Headers readHeaders()
  {
    Headers.Builder localBuilder = new Headers.Builder();
    for (String str = readHeaderLine();; str = readHeaderLine())
    {
      int i;
      if (((CharSequence)str).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {
        break;
      }
      localBuilder.addLenient$okhttp(str);
    }
    return localBuilder.build();
  }
  
  public void cancel()
  {
    getConnection().cancel();
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    if ((paramRequest.body() != null) && (paramRequest.body().isDuplex())) {
      throw ((Throwable)new ProtocolException("Duplex connections are not supported for HTTP/1"));
    }
    if (isChunked(paramRequest)) {
      return newChunkedSink();
    }
    if (paramLong != -1L) {
      return newKnownLengthSink();
    }
    throw ((Throwable)new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!"));
  }
  
  public void finishRequest()
  {
    this.sink.flush();
  }
  
  public void flushRequest()
  {
    this.sink.flush();
  }
  
  public RealConnection getConnection()
  {
    return this.connection;
  }
  
  public final boolean isClosed()
  {
    return this.state == 6;
  }
  
  public Source openResponseBodySource(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    if (!HttpHeaders.promisesBody(paramResponse)) {
      return newFixedLengthSource(0L);
    }
    if (isChunked(paramResponse)) {
      return newChunkedSource(paramResponse.request().url());
    }
    long l = Util.headersContentLength(paramResponse);
    if (l != -1L) {
      return newFixedLengthSource(l);
    }
    return newUnknownLengthSource();
  }
  
  public Response.Builder readResponseHeaders(boolean paramBoolean)
  {
    int k = this.state;
    int j = 1;
    int i = j;
    if (k != 1) {
      if (k == 3) {
        i = j;
      } else {
        i = 0;
      }
    }
    if (i != 0) {
      try
      {
        StatusLine localStatusLine = StatusLine.Companion.parse(readHeaderLine());
        localObject = new Response.Builder().protocol(localStatusLine.protocol).code(localStatusLine.code).message(localStatusLine.message).headers(readHeaders());
        if ((paramBoolean) && (localStatusLine.code == 100)) {
          return null;
        }
        if (localStatusLine.code == 100)
        {
          this.state = 3;
          return (Response.Builder)localObject;
        }
        this.state = 4;
        return (Response.Builder)localObject;
      }
      catch (EOFException localEOFException)
      {
        Object localObject = getConnection().route().address().url().redact();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("unexpected end of stream on ");
        localStringBuilder2.append((String)localObject);
        throw ((Throwable)new IOException(localStringBuilder2.toString(), (Throwable)localEOFException));
      }
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("state: ");
    localStringBuilder1.append(this.state);
    throw ((Throwable)new IllegalStateException(localStringBuilder1.toString().toString()));
  }
  
  public long reportedContentLength(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    if (!HttpHeaders.promisesBody(paramResponse)) {
      return 0L;
    }
    if (isChunked(paramResponse)) {
      return -1L;
    }
    return Util.headersContentLength(paramResponse);
  }
  
  public final void skipConnectBody(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    long l = Util.headersContentLength(paramResponse);
    if (l == -1L) {
      return;
    }
    paramResponse = newFixedLengthSource(l);
    Util.skipAll(paramResponse, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
    paramResponse.close();
  }
  
  public Headers trailers()
  {
    int i;
    if (this.state == 6) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Headers localHeaders = this.trailers;
      if (localHeaders != null) {
        return localHeaders;
      }
      return Util.EMPTY_HEADERS;
    }
    throw ((Throwable)new IllegalStateException("too early; can't read the trailers yet".toString()));
  }
  
  public final void writeRequest(Headers paramHeaders, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramHeaders, "headers");
    Intrinsics.checkParameterIsNotNull(paramString, "requestLine");
    int i = this.state;
    int j = 0;
    if (i == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.sink.writeUtf8(paramString).writeUtf8("\r\n");
      int k = paramHeaders.size();
      i = j;
      while (i < k)
      {
        this.sink.writeUtf8(paramHeaders.name(i)).writeUtf8(": ").writeUtf8(paramHeaders.value(i)).writeUtf8("\r\n");
        i += 1;
      }
      this.sink.writeUtf8("\r\n");
      this.state = 1;
      return;
    }
    paramHeaders = new StringBuilder();
    paramHeaders.append("state: ");
    paramHeaders.append(this.state);
    throw ((Throwable)new IllegalStateException(paramHeaders.toString().toString()));
  }
  
  public void writeRequestHeaders(Request paramRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    Object localObject = RequestLine.INSTANCE;
    Proxy.Type localType = getConnection().route().proxy().type();
    Intrinsics.checkExpressionValueIsNotNull(localType, "connection.route().proxy.type()");
    localObject = ((RequestLine)localObject).get(paramRequest, localType);
    writeRequest(paramRequest.headers(), (String)localObject);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0006\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\005\n\002\030\002\n\002\b\003\n\002\020\t\n\000\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\b¢\004\030\0002\0020\001B\005¢\006\002\020\002J\030\020\r\032\0020\0162\006\020\017\032\0020\0202\006\020\021\032\0020\016H\026J\r\020\022\032\0020\023H\000¢\006\002\b\024J\b\020\t\032\0020\025H\026R\032\020\003\032\0020\004X\016¢\006\016\n\000\032\004\b\005\020\006\"\004\b\007\020\bR\024\020\t\032\0020\nX\004¢\006\b\n\000\032\004\b\013\020\f¨\006\026"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokio/Source;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "timeout", "Lokio/ForwardingTimeout;", "getTimeout", "()Lokio/ForwardingTimeout;", "read", "", "sink", "Lokio/Buffer;", "byteCount", "responseBodyComplete", "", "responseBodyComplete$okhttp", "Lokio/Timeout;", "okhttp"}, k=1, mv={1, 1, 16})
  private abstract class AbstractSource
    implements Source
  {
    private boolean closed;
    private final ForwardingTimeout timeout;
    
    public AbstractSource()
    {
      this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSource$p(this$1).timeout());
    }
    
    protected final boolean getClosed()
    {
      return this.closed;
    }
    
    protected final ForwardingTimeout getTimeout()
    {
      return this.timeout;
    }
    
    public long read(Buffer paramBuffer, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
      try
      {
        paramLong = Http1ExchangeCodec.access$getSource$p(this.this$0).read(paramBuffer, paramLong);
        return paramLong;
      }
      catch (IOException paramBuffer)
      {
        this.this$0.getConnection().noNewExchanges();
        responseBodyComplete$okhttp();
        throw ((Throwable)paramBuffer);
      }
    }
    
    public final void responseBodyComplete$okhttp()
    {
      if (Http1ExchangeCodec.access$getState$p(this.this$0) == 6) {
        return;
      }
      if (Http1ExchangeCodec.access$getState$p(this.this$0) == 5)
      {
        Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
        Http1ExchangeCodec.access$setState$p(this.this$0, 6);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("state: ");
      localStringBuilder.append(Http1ExchangeCodec.access$getState$p(this.this$0));
      throw ((Throwable)new IllegalStateException(localStringBuilder.toString()));
    }
    
    protected final void setClosed(boolean paramBoolean)
    {
      this.closed = paramBoolean;
    }
    
    public Timeout timeout()
    {
      return (Timeout)this.timeout;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\000\b\004\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\0020\bH\026J\b\020\t\032\0020\bH\026J\b\020\005\032\0020\nH\026J\030\020\013\032\0020\b2\006\020\f\032\0020\r2\006\020\016\032\0020\017H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\020"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"}, k=1, mv={1, 1, 16})
  private final class ChunkedSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout;
    
    public ChunkedSink()
    {
      this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(this$1).timeout());
    }
    
    public void close()
    {
      try
      {
        boolean bool = this.closed;
        if (bool) {
          return;
        }
        this.closed = true;
        Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("0\r\n\r\n");
        Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
        Http1ExchangeCodec.access$setState$p(this.this$0, 3);
        return;
      }
      finally {}
    }
    
    public void flush()
    {
      try
      {
        boolean bool = this.closed;
        if (bool) {
          return;
        }
        Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
        return;
      }
      finally {}
    }
    
    public Timeout timeout()
    {
      return (Timeout)this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
      if ((this.closed ^ true))
      {
        if (paramLong == 0L) {
          return;
        }
        Http1ExchangeCodec.access$getSink$p(this.this$0).writeHexadecimalUnsignedLong(paramLong);
        Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("\r\n");
        Http1ExchangeCodec.access$getSink$p(this.this$0).write(paramBuffer, paramLong);
        Http1ExchangeCodec.access$getSink$p(this.this$0).writeUtf8("\r\n");
        return;
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\t\n\000\n\002\020\013\n\000\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\003\b\004\030\0002\0060\001R\0020\002B\017\b\000\022\006\020\003\032\0020\004¢\006\002\020\005J\b\020\n\032\0020\013H\026J\030\020\f\032\0020\0072\006\020\r\032\0020\0162\006\020\017\032\0020\007H\026J\b\020\020\032\0020\013H\002R\016\020\006\032\0020\007X\016¢\006\002\n\000R\016\020\b\032\0020\tX\016¢\006\002\n\000R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\021"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$ChunkedSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "url", "Lokhttp3/HttpUrl;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;Lokhttp3/HttpUrl;)V", "bytesRemainingInChunk", "", "hasMoreChunks", "", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "readChunkSize", "okhttp"}, k=1, mv={1, 1, 16})
  private final class ChunkedSource
    extends Http1ExchangeCodec.AbstractSource
  {
    private long bytesRemainingInChunk;
    private boolean hasMoreChunks;
    private final HttpUrl url;
    
    public ChunkedSource()
    {
      super();
      this.url = ((HttpUrl)localObject);
      this.bytesRemainingInChunk = -1L;
      this.hasMoreChunks = true;
    }
    
    private final void readChunkSize()
    {
      if (this.bytesRemainingInChunk != -1L) {
        Http1ExchangeCodec.access$getSource$p(Http1ExchangeCodec.this).readUtf8LineStrict();
      }
      for (;;)
      {
        try
        {
          this.bytesRemainingInChunk = Http1ExchangeCodec.access$getSource$p(Http1ExchangeCodec.this).readHexadecimalUnsignedLong();
          Object localObject1 = Http1ExchangeCodec.access$getSource$p(Http1ExchangeCodec.this).readUtf8LineStrict();
          if (localObject1 != null)
          {
            localObject1 = StringsKt.trim((CharSequence)localObject1).toString();
            if (this.bytesRemainingInChunk >= 0L)
            {
              if (((CharSequence)localObject1).length() <= 0) {
                break label287;
              }
              i = 1;
              if (i != 0)
              {
                boolean bool = StringsKt.startsWith$default((String)localObject1, ";", false, 2, null);
                if (!bool) {}
              }
              else
              {
                if (this.bytesRemainingInChunk == 0L)
                {
                  this.hasMoreChunks = false;
                  localObject1 = Http1ExchangeCodec.this;
                  Http1ExchangeCodec.access$setTrailers$p((Http1ExchangeCodec)localObject1, Http1ExchangeCodec.access$readHeaders((Http1ExchangeCodec)localObject1));
                  localObject1 = Http1ExchangeCodec.access$getClient$p(Http1ExchangeCodec.this);
                  if (localObject1 == null) {
                    Intrinsics.throwNpe();
                  }
                  localObject1 = ((OkHttpClient)localObject1).cookieJar();
                  localObject2 = this.url;
                  Headers localHeaders = Http1ExchangeCodec.access$getTrailers$p(Http1ExchangeCodec.this);
                  if (localHeaders == null) {
                    Intrinsics.throwNpe();
                  }
                  HttpHeaders.receiveHeaders((CookieJar)localObject1, (HttpUrl)localObject2, localHeaders);
                  responseBodyComplete$okhttp();
                }
                return;
              }
            }
            Object localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("expected chunk size and optional extensions");
            ((StringBuilder)localObject2).append(" but was \"");
            ((StringBuilder)localObject2).append(this.bytesRemainingInChunk);
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append('"');
            throw ((Throwable)new ProtocolException(((StringBuilder)localObject2).toString()));
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw ((Throwable)new ProtocolException(localNumberFormatException.getMessage()));
        }
        label287:
        int i = 0;
      }
    }
    
    public void close()
    {
      if (getClosed()) {
        return;
      }
      if ((this.hasMoreChunks) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
      {
        Http1ExchangeCodec.this.getConnection().noNewExchanges();
        responseBodyComplete$okhttp();
      }
      setClosed(true);
    }
    
    public long read(Buffer paramBuffer, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((true ^ getClosed()))
        {
          if (!this.hasMoreChunks) {
            return -1L;
          }
          long l = this.bytesRemainingInChunk;
          if ((l == 0L) || (l == -1L))
          {
            readChunkSize();
            if (!this.hasMoreChunks) {
              return -1L;
            }
          }
          paramLong = super.read(paramBuffer, Math.min(paramLong, this.bytesRemainingInChunk));
          if (paramLong != -1L)
          {
            this.bytesRemainingInChunk -= paramLong;
            return paramLong;
          }
          Http1ExchangeCodec.this.getConnection().noNewExchanges();
          paramBuffer = new ProtocolException("unexpected end of stream");
          responseBodyComplete$okhttp();
          throw ((Throwable)paramBuffer);
        }
        throw ((Throwable)new IllegalStateException("closed".toString()));
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\000\n\002\020\t\n\002\b\b\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\006XT¢\006\002\n\000R\016\020\007\032\0020\004XT¢\006\002\n\000R\016\020\b\032\0020\004XT¢\006\002\n\000R\016\020\t\032\0020\004XT¢\006\002\n\000R\016\020\n\032\0020\004XT¢\006\002\n\000R\016\020\013\032\0020\004XT¢\006\002\n\000R\016\020\f\032\0020\004XT¢\006\002\n\000R\016\020\r\032\0020\004XT¢\006\002\n\000¨\006\016"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$Companion;", "", "()V", "HEADER_LIMIT", "", "NO_CHUNK_YET", "", "STATE_CLOSED", "STATE_IDLE", "STATE_OPEN_REQUEST_BODY", "STATE_OPEN_RESPONSE_BODY", "STATE_READING_RESPONSE_BODY", "STATE_READ_RESPONSE_HEADERS", "STATE_WRITING_REQUEST_BODY", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={"\000&\n\002\030\002\n\002\030\002\n\002\030\002\n\000\n\002\020\t\n\002\b\002\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\002\b\004\030\0002\0060\001R\0020\002B\017\b\000\022\006\020\003\032\0020\004¢\006\002\020\005J\b\020\006\032\0020\007H\026J\030\020\b\032\0020\0042\006\020\t\032\0020\n2\006\020\013\032\0020\004H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000¨\006\f"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$FixedLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "bytesRemaining", "", "(Lokhttp3/internal/http1/Http1ExchangeCodec;J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 1, 16})
  private final class FixedLengthSource
    extends Http1ExchangeCodec.AbstractSource
  {
    private long bytesRemaining;
    
    public FixedLengthSource()
    {
      super();
      Object localObject;
      this.bytesRemaining = localObject;
      if (localObject == 0L) {
        responseBodyComplete$okhttp();
      }
    }
    
    public void close()
    {
      if (getClosed()) {
        return;
      }
      if ((this.bytesRemaining != 0L) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
      {
        Http1ExchangeCodec.this.getConnection().noNewExchanges();
        responseBodyComplete$okhttp();
      }
      setClosed(true);
    }
    
    public long read(Buffer paramBuffer, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((true ^ getClosed()))
        {
          long l = this.bytesRemaining;
          if (l == 0L) {
            return -1L;
          }
          paramLong = super.read(paramBuffer, Math.min(l, paramLong));
          if (paramLong != -1L)
          {
            l = this.bytesRemaining - paramLong;
            this.bytesRemaining = l;
            if (l == 0L) {
              responseBodyComplete$okhttp();
            }
            return paramLong;
          }
          Http1ExchangeCodec.this.getConnection().noNewExchanges();
          paramBuffer = new ProtocolException("unexpected end of stream");
          responseBodyComplete$okhttp();
          throw ((Throwable)paramBuffer);
        }
        throw ((Throwable)new IllegalStateException("closed".toString()));
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\t\n\000\b\004\030\0002\0020\001B\005¢\006\002\020\002J\b\020\007\032\0020\bH\026J\b\020\t\032\0020\bH\026J\b\020\005\032\0020\nH\026J\030\020\013\032\0020\b2\006\020\f\032\0020\r2\006\020\016\032\0020\017H\026R\016\020\003\032\0020\004X\016¢\006\002\n\000R\016\020\005\032\0020\006X\004¢\006\002\n\000¨\006\020"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$KnownLengthSink;", "Lokio/Sink;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "closed", "", "timeout", "Lokio/ForwardingTimeout;", "close", "", "flush", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "", "okhttp"}, k=1, mv={1, 1, 16})
  private final class KnownLengthSink
    implements Sink
  {
    private boolean closed;
    private final ForwardingTimeout timeout;
    
    public KnownLengthSink()
    {
      this.timeout = new ForwardingTimeout(Http1ExchangeCodec.access$getSink$p(this$1).timeout());
    }
    
    public void close()
    {
      if (this.closed) {
        return;
      }
      this.closed = true;
      Http1ExchangeCodec.access$detachTimeout(this.this$0, this.timeout);
      Http1ExchangeCodec.access$setState$p(this.this$0, 3);
    }
    
    public void flush()
    {
      if (this.closed) {
        return;
      }
      Http1ExchangeCodec.access$getSink$p(this.this$0).flush();
    }
    
    public Timeout timeout()
    {
      return (Timeout)this.timeout;
    }
    
    public void write(Buffer paramBuffer, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "source");
      if ((this.closed ^ true))
      {
        Util.checkOffsetAndCount(paramBuffer.size(), 0L, paramLong);
        Http1ExchangeCodec.access$getSink$p(this.this$0).write(paramBuffer, paramLong);
        return;
      }
      throw ((Throwable)new IllegalStateException("closed".toString()));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\020\002\n\000\n\002\020\t\n\000\n\002\030\002\n\002\b\002\b\004\030\0002\0060\001R\0020\002B\005¢\006\002\020\003J\b\020\006\032\0020\007H\026J\030\020\b\032\0020\t2\006\020\n\032\0020\0132\006\020\f\032\0020\tH\026R\016\020\004\032\0020\005X\016¢\006\002\n\000¨\006\r"}, d2={"Lokhttp3/internal/http1/Http1ExchangeCodec$UnknownLengthSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec$AbstractSource;", "Lokhttp3/internal/http1/Http1ExchangeCodec;", "(Lokhttp3/internal/http1/Http1ExchangeCodec;)V", "inputExhausted", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "okhttp"}, k=1, mv={1, 1, 16})
  private final class UnknownLengthSource
    extends Http1ExchangeCodec.AbstractSource
  {
    private boolean inputExhausted;
    
    public UnknownLengthSource()
    {
      super();
    }
    
    public void close()
    {
      if (getClosed()) {
        return;
      }
      if (!this.inputExhausted) {
        responseBodyComplete$okhttp();
      }
      setClosed(true);
    }
    
    public long read(Buffer paramBuffer, long paramLong)
    {
      Intrinsics.checkParameterIsNotNull(paramBuffer, "sink");
      int i;
      if (paramLong >= 0L) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        if ((getClosed() ^ true))
        {
          if (this.inputExhausted) {
            return -1L;
          }
          paramLong = super.read(paramBuffer, paramLong);
          if (paramLong == -1L)
          {
            this.inputExhausted = true;
            responseBodyComplete$okhttp();
            return -1L;
          }
          return paramLong;
        }
        throw ((Throwable)new IllegalStateException("closed".toString()));
      }
      paramBuffer = new StringBuilder();
      paramBuffer.append("byteCount < 0: ");
      paramBuffer.append(paramLong);
      throw ((Throwable)new IllegalArgumentException(paramBuffer.toString().toString()));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http1\Http1ExchangeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */