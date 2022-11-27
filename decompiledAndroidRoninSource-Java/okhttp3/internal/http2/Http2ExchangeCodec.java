package okhttp3.internal.http2;

import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.internal.Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http.ExchangeCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.RealInterceptorChain;
import okhttp3.internal.http.RequestLine;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.http.StatusLine.Companion;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000n\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\t\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\030\000 (2\0020\001:\001(B%\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t¢\006\002\020\nJ\b\020\023\032\0020\024H\026J\030\020\025\032\0020\0262\006\020\027\032\0020\0302\006\020\031\032\0020\032H\026J\b\020\033\032\0020\024H\026J\b\020\034\032\0020\024H\026J\020\020\035\032\0020\0362\006\020\037\032\0020 H\026J\022\020!\032\004\030\0010\"2\006\020#\032\0020\fH\026J\020\020$\032\0020\0322\006\020\037\032\0020 H\026J\b\020%\032\0020&H\026J\020\020'\032\0020\0242\006\020\027\032\0020\030H\026R\016\020\013\032\0020\fX\016¢\006\002\n\000R\016\020\006\032\0020\007X\004¢\006\002\n\000R\024\020\004\032\0020\005X\004¢\006\b\n\000\032\004\b\r\020\016R\016\020\b\032\0020\tX\004¢\006\002\n\000R\016\020\017\032\0020\020X\004¢\006\002\n\000R\020\020\021\032\004\030\0010\022X\016¢\006\002\n\000¨\006)"}, d2={"Lokhttp3/internal/http2/Http2ExchangeCodec;", "Lokhttp3/internal/http/ExchangeCodec;", "client", "Lokhttp3/OkHttpClient;", "connection", "Lokhttp3/internal/connection/RealConnection;", "chain", "Lokhttp3/internal/http/RealInterceptorChain;", "http2Connection", "Lokhttp3/internal/http2/Http2Connection;", "(Lokhttp3/OkHttpClient;Lokhttp3/internal/connection/RealConnection;Lokhttp3/internal/http/RealInterceptorChain;Lokhttp3/internal/http2/Http2Connection;)V", "canceled", "", "getConnection", "()Lokhttp3/internal/connection/RealConnection;", "protocol", "Lokhttp3/Protocol;", "stream", "Lokhttp3/internal/http2/Http2Stream;", "cancel", "", "createRequestBody", "Lokio/Sink;", "request", "Lokhttp3/Request;", "contentLength", "", "finishRequest", "flushRequest", "openResponseBodySource", "Lokio/Source;", "response", "Lokhttp3/Response;", "readResponseHeaders", "Lokhttp3/Response$Builder;", "expectContinue", "reportedContentLength", "trailers", "Lokhttp3/Headers;", "writeRequestHeaders", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Http2ExchangeCodec
  implements ExchangeCodec
{
  private static final String CONNECTION = "connection";
  public static final Companion Companion = new Companion(null);
  private static final String ENCODING = "encoding";
  private static final String HOST = "host";
  private static final List<String> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableListOf(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade", ":method", ":path", ":scheme", ":authority" });
  private static final List<String> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableListOf(new String[] { "connection", "host", "keep-alive", "proxy-connection", "te", "transfer-encoding", "encoding", "upgrade" });
  private static final String KEEP_ALIVE = "keep-alive";
  private static final String PROXY_CONNECTION = "proxy-connection";
  private static final String TE = "te";
  private static final String TRANSFER_ENCODING = "transfer-encoding";
  private static final String UPGRADE = "upgrade";
  private volatile boolean canceled;
  private final RealInterceptorChain chain;
  private final RealConnection connection;
  private final Http2Connection http2Connection;
  private final Protocol protocol;
  private volatile Http2Stream stream;
  
  public Http2ExchangeCodec(OkHttpClient paramOkHttpClient, RealConnection paramRealConnection, RealInterceptorChain paramRealInterceptorChain, Http2Connection paramHttp2Connection)
  {
    this.connection = paramRealConnection;
    this.chain = paramRealInterceptorChain;
    this.http2Connection = paramHttp2Connection;
    if (paramOkHttpClient.protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
      paramOkHttpClient = Protocol.H2_PRIOR_KNOWLEDGE;
    } else {
      paramOkHttpClient = Protocol.HTTP_2;
    }
    this.protocol = paramOkHttpClient;
  }
  
  public void cancel()
  {
    this.canceled = true;
    Http2Stream localHttp2Stream = this.stream;
    if (localHttp2Stream != null) {
      localHttp2Stream.closeLater(ErrorCode.CANCEL);
    }
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    paramRequest = this.stream;
    if (paramRequest == null) {
      Intrinsics.throwNpe();
    }
    return paramRequest.getSink();
  }
  
  public void finishRequest()
  {
    Http2Stream localHttp2Stream = this.stream;
    if (localHttp2Stream == null) {
      Intrinsics.throwNpe();
    }
    localHttp2Stream.getSink().close();
  }
  
  public void flushRequest()
  {
    this.http2Connection.flush();
  }
  
  public RealConnection getConnection()
  {
    return this.connection;
  }
  
  public Source openResponseBodySource(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    paramResponse = this.stream;
    if (paramResponse == null) {
      Intrinsics.throwNpe();
    }
    return (Source)paramResponse.getSource$okhttp();
  }
  
  public Response.Builder readResponseHeaders(boolean paramBoolean)
  {
    Object localObject = this.stream;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((Http2Stream)localObject).takeHeaders();
    Response.Builder localBuilder = Companion.readHttp2HeadersList((Headers)localObject, this.protocol);
    localObject = localBuilder;
    if (paramBoolean)
    {
      localObject = localBuilder;
      if (localBuilder.getCode$okhttp() == 100) {
        localObject = null;
      }
    }
    return (Response.Builder)localObject;
  }
  
  public long reportedContentLength(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    if (!HttpHeaders.promisesBody(paramResponse)) {
      return 0L;
    }
    return Util.headersContentLength(paramResponse);
  }
  
  public Headers trailers()
  {
    Http2Stream localHttp2Stream = this.stream;
    if (localHttp2Stream == null) {
      Intrinsics.throwNpe();
    }
    return localHttp2Stream.trailers();
  }
  
  public void writeRequestHeaders(Request paramRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    if (this.stream != null) {
      return;
    }
    boolean bool;
    if (paramRequest.body() != null) {
      bool = true;
    } else {
      bool = false;
    }
    paramRequest = Companion.http2HeadersList(paramRequest);
    this.stream = this.http2Connection.newStream(paramRequest, bool);
    if (this.canceled)
    {
      paramRequest = this.stream;
      if (paramRequest == null) {
        Intrinsics.throwNpe();
      }
      paramRequest.closeLater(ErrorCode.CANCEL);
      throw ((Throwable)new IOException("Canceled"));
    }
    paramRequest = this.stream;
    if (paramRequest == null) {
      Intrinsics.throwNpe();
    }
    paramRequest.readTimeout().timeout(this.chain.getReadTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
    paramRequest = this.stream;
    if (paramRequest == null) {
      Intrinsics.throwNpe();
    }
    paramRequest.writeTimeout().timeout(this.chain.getWriteTimeoutMillis$okhttp(), TimeUnit.MILLISECONDS);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000:\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020 \n\002\b\007\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\024\020\017\032\b\022\004\022\0020\0200\b2\006\020\021\032\0020\022J\026\020\023\032\0020\0242\006\020\025\032\0020\0262\006\020\027\032\0020\030R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\016\020\006\032\0020\004XT¢\006\002\n\000R\024\020\007\032\b\022\004\022\0020\0040\bX\004¢\006\002\n\000R\024\020\t\032\b\022\004\022\0020\0040\bX\004¢\006\002\n\000R\016\020\n\032\0020\004XT¢\006\002\n\000R\016\020\013\032\0020\004XT¢\006\002\n\000R\016\020\f\032\0020\004XT¢\006\002\n\000R\016\020\r\032\0020\004XT¢\006\002\n\000R\016\020\016\032\0020\004XT¢\006\002\n\000¨\006\031"}, d2={"Lokhttp3/internal/http2/Http2ExchangeCodec$Companion;", "", "()V", "CONNECTION", "", "ENCODING", "HOST", "HTTP_2_SKIPPED_REQUEST_HEADERS", "", "HTTP_2_SKIPPED_RESPONSE_HEADERS", "KEEP_ALIVE", "PROXY_CONNECTION", "TE", "TRANSFER_ENCODING", "UPGRADE", "http2HeadersList", "Lokhttp3/internal/http2/Header;", "request", "Lokhttp3/Request;", "readHttp2HeadersList", "Lokhttp3/Response$Builder;", "headerBlock", "Lokhttp3/Headers;", "protocol", "Lokhttp3/Protocol;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final List<Header> http2HeadersList(Request paramRequest)
    {
      Intrinsics.checkParameterIsNotNull(paramRequest, "request");
      Headers localHeaders = paramRequest.headers();
      ArrayList localArrayList = new ArrayList(localHeaders.size() + 4);
      localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
      localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.INSTANCE.requestPath(paramRequest.url())));
      Object localObject = paramRequest.header("Host");
      if (localObject != null) {
        localArrayList.add(new Header(Header.TARGET_AUTHORITY, (String)localObject));
      }
      localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
      int i = 0;
      int j = localHeaders.size();
      while (i < j)
      {
        paramRequest = localHeaders.name(i);
        localObject = Locale.US;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "Locale.US");
        if (paramRequest != null)
        {
          paramRequest = paramRequest.toLowerCase((Locale)localObject);
          Intrinsics.checkExpressionValueIsNotNull(paramRequest, "(this as java.lang.String).toLowerCase(locale)");
          if ((!Http2ExchangeCodec.access$getHTTP_2_SKIPPED_REQUEST_HEADERS$cp().contains(paramRequest)) || ((Intrinsics.areEqual(paramRequest, "te")) && (Intrinsics.areEqual(localHeaders.value(i), "trailers")))) {
            localArrayList.add(new Header(paramRequest, localHeaders.value(i)));
          }
          i += 1;
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      return (List)localArrayList;
    }
    
    public final Response.Builder readHttp2HeadersList(Headers paramHeaders, Protocol paramProtocol)
    {
      Intrinsics.checkParameterIsNotNull(paramHeaders, "headerBlock");
      Intrinsics.checkParameterIsNotNull(paramProtocol, "protocol");
      Object localObject1 = (StatusLine)null;
      Headers.Builder localBuilder = new Headers.Builder();
      int j = paramHeaders.size();
      int i = 0;
      while (i < j)
      {
        String str2 = paramHeaders.name(i);
        String str1 = paramHeaders.value(i);
        Object localObject2;
        if (Intrinsics.areEqual(str2, ":status"))
        {
          localObject1 = StatusLine.Companion;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("HTTP/1.1 ");
          ((StringBuilder)localObject2).append(str1);
          localObject2 = ((StatusLine.Companion)localObject1).parse(((StringBuilder)localObject2).toString());
        }
        else
        {
          localObject2 = localObject1;
          if (!Http2ExchangeCodec.access$getHTTP_2_SKIPPED_RESPONSE_HEADERS$cp().contains(str2))
          {
            localBuilder.addLenient$okhttp(str2, str1);
            localObject2 = localObject1;
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      if (localObject1 != null) {
        return new Response.Builder().protocol(paramProtocol).code(((StatusLine)localObject1).code).message(((StatusLine)localObject1).message).headers(localBuilder.build());
      }
      throw ((Throwable)new ProtocolException("Expected ':status' header not present"));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http2\Http2ExchangeCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */