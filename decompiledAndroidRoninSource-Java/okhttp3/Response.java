package okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.http.HttpHeaders;
import okio.Buffer;
import okio.BufferedSource;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\000p\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\t\n\002\b\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\007\n\002\020\013\n\002\b\013\n\002\020 \n\002\030\002\n\000\n\002\020\002\n\002\b\t\n\002\030\002\n\002\b\013\030\0002\0020\001:\001FB{\b\000\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007\022\006\020\b\032\0020\t\022\b\020\n\032\004\030\0010\013\022\006\020\f\032\0020\r\022\b\020\016\032\004\030\0010\017\022\b\020\020\032\004\030\0010\000\022\b\020\021\032\004\030\0010\000\022\b\020\022\032\004\030\0010\000\022\006\020\023\032\0020\024\022\006\020\025\032\0020\024\022\b\020\026\032\004\030\0010\027¢\006\002\020\030J\017\020\016\032\004\030\0010\017H\007¢\006\002\b+J\r\020\032\032\0020\033H\007¢\006\002\b,J\017\020\021\032\004\030\0010\000H\007¢\006\002\b-J\f\020.\032\b\022\004\022\002000/J\b\0201\032\00202H\026J\r\020\b\032\0020\tH\007¢\006\002\b3J\017\020\n\032\004\030\0010\013H\007¢\006\002\b4J\036\0205\032\004\030\0010\0072\006\0206\032\0020\0072\n\b\002\0207\032\004\030\0010\007H\007J\r\020\f\032\0020\rH\007¢\006\002\b8J\024\020\f\032\b\022\004\022\0020\0070/2\006\0206\032\0020\007J\r\020\006\032\0020\007H\007¢\006\002\b9J\017\020\020\032\004\030\0010\000H\007¢\006\002\b:J\006\020;\032\0020<J\016\020=\032\0020\0172\006\020>\032\0020\024J\017\020\022\032\004\030\0010\000H\007¢\006\002\b?J\r\020\004\032\0020\005H\007¢\006\002\b@J\r\020\025\032\0020\024H\007¢\006\002\bAJ\r\020\002\032\0020\003H\007¢\006\002\bBJ\r\020\023\032\0020\024H\007¢\006\002\bCJ\b\020D\032\0020\007H\026J\006\020E\032\0020\rR\025\020\016\032\004\030\0010\0178\007¢\006\b\n\000\032\004\b\016\020\031R\021\020\032\032\0020\0338G¢\006\006\032\004\b\032\020\034R\025\020\021\032\004\030\0010\0008\007¢\006\b\n\000\032\004\b\021\020\035R\023\020\b\032\0020\t8\007¢\006\b\n\000\032\004\b\b\020\036R\030\020\026\032\004\030\0010\0278\001X\004¢\006\b\n\000\032\004\b\026\020\037R\025\020\n\032\004\030\0010\0138\007¢\006\b\n\000\032\004\b\n\020 R\023\020\f\032\0020\r8\007¢\006\b\n\000\032\004\b\f\020!R\021\020\"\032\0020#8F¢\006\006\032\004\b\"\020$R\021\020%\032\0020#8F¢\006\006\032\004\b%\020$R\020\020&\032\004\030\0010\033X\016¢\006\002\n\000R\023\020\006\032\0020\0078\007¢\006\b\n\000\032\004\b\006\020'R\025\020\020\032\004\030\0010\0008\007¢\006\b\n\000\032\004\b\020\020\035R\025\020\022\032\004\030\0010\0008\007¢\006\b\n\000\032\004\b\022\020\035R\023\020\004\032\0020\0058\007¢\006\b\n\000\032\004\b\004\020(R\023\020\025\032\0020\0248\007¢\006\b\n\000\032\004\b\025\020)R\023\020\002\032\0020\0038\007¢\006\b\n\000\032\004\b\002\020*R\023\020\023\032\0020\0248\007¢\006\b\n\000\032\004\b\023\020)¨\006G"}, d2={"Lokhttp3/Response;", "Ljava/io/Closeable;", "request", "Lokhttp3/Request;", "protocol", "Lokhttp3/Protocol;", "message", "", "code", "", "handshake", "Lokhttp3/Handshake;", "headers", "Lokhttp3/Headers;", "body", "Lokhttp3/ResponseBody;", "networkResponse", "cacheResponse", "priorResponse", "sentRequestAtMillis", "", "receivedResponseAtMillis", "exchange", "Lokhttp3/internal/connection/Exchange;", "(Lokhttp3/Request;Lokhttp3/Protocol;Ljava/lang/String;ILokhttp3/Handshake;Lokhttp3/Headers;Lokhttp3/ResponseBody;Lokhttp3/Response;Lokhttp3/Response;Lokhttp3/Response;JJLokhttp3/internal/connection/Exchange;)V", "()Lokhttp3/ResponseBody;", "cacheControl", "Lokhttp3/CacheControl;", "()Lokhttp3/CacheControl;", "()Lokhttp3/Response;", "()I", "()Lokhttp3/internal/connection/Exchange;", "()Lokhttp3/Handshake;", "()Lokhttp3/Headers;", "isRedirect", "", "()Z", "isSuccessful", "lazyCacheControl", "()Ljava/lang/String;", "()Lokhttp3/Protocol;", "()J", "()Lokhttp3/Request;", "-deprecated_body", "-deprecated_cacheControl", "-deprecated_cacheResponse", "challenges", "", "Lokhttp3/Challenge;", "close", "", "-deprecated_code", "-deprecated_handshake", "header", "name", "defaultValue", "-deprecated_headers", "-deprecated_message", "-deprecated_networkResponse", "newBuilder", "Lokhttp3/Response$Builder;", "peekBody", "byteCount", "-deprecated_priorResponse", "-deprecated_protocol", "-deprecated_receivedResponseAtMillis", "-deprecated_request", "-deprecated_sentRequestAtMillis", "toString", "trailers", "Builder", "okhttp"}, k=1, mv={1, 1, 16})
public final class Response
  implements Closeable
{
  private final ResponseBody body;
  private final Response cacheResponse;
  private final int code;
  private final Exchange exchange;
  private final Handshake handshake;
  private final Headers headers;
  private CacheControl lazyCacheControl;
  private final String message;
  private final Response networkResponse;
  private final Response priorResponse;
  private final Protocol protocol;
  private final long receivedResponseAtMillis;
  private final Request request;
  private final long sentRequestAtMillis;
  
  public Response(Request paramRequest, Protocol paramProtocol, String paramString, int paramInt, Handshake paramHandshake, Headers paramHeaders, ResponseBody paramResponseBody, Response paramResponse1, Response paramResponse2, Response paramResponse3, long paramLong1, long paramLong2, Exchange paramExchange)
  {
    this.request = paramRequest;
    this.protocol = paramProtocol;
    this.message = paramString;
    this.code = paramInt;
    this.handshake = paramHandshake;
    this.headers = paramHeaders;
    this.body = paramResponseBody;
    this.networkResponse = paramResponse1;
    this.cacheResponse = paramResponse2;
    this.priorResponse = paramResponse3;
    this.sentRequestAtMillis = paramLong1;
    this.receivedResponseAtMillis = paramLong2;
    this.exchange = paramExchange;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="body", imports={}))
  public final ResponseBody -deprecated_body()
  {
    return this.body;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cacheControl", imports={}))
  public final CacheControl -deprecated_cacheControl()
  {
    return cacheControl();
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="cacheResponse", imports={}))
  public final Response -deprecated_cacheResponse()
  {
    return this.cacheResponse;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="code", imports={}))
  public final int -deprecated_code()
  {
    return this.code;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="handshake", imports={}))
  public final Handshake -deprecated_handshake()
  {
    return this.handshake;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="headers", imports={}))
  public final Headers -deprecated_headers()
  {
    return this.headers;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="message", imports={}))
  public final String -deprecated_message()
  {
    return this.message;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="networkResponse", imports={}))
  public final Response -deprecated_networkResponse()
  {
    return this.networkResponse;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="priorResponse", imports={}))
  public final Response -deprecated_priorResponse()
  {
    return this.priorResponse;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="protocol", imports={}))
  public final Protocol -deprecated_protocol()
  {
    return this.protocol;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="receivedResponseAtMillis", imports={}))
  public final long -deprecated_receivedResponseAtMillis()
  {
    return this.receivedResponseAtMillis;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="request", imports={}))
  public final Request -deprecated_request()
  {
    return this.request;
  }
  
  @Deprecated(level=DeprecationLevel.ERROR, message="moved to val", replaceWith=@ReplaceWith(expression="sentRequestAtMillis", imports={}))
  public final long -deprecated_sentRequestAtMillis()
  {
    return this.sentRequestAtMillis;
  }
  
  public final ResponseBody body()
  {
    return this.body;
  }
  
  public final CacheControl cacheControl()
  {
    CacheControl localCacheControl2 = this.lazyCacheControl;
    CacheControl localCacheControl1 = localCacheControl2;
    if (localCacheControl2 == null)
    {
      localCacheControl1 = CacheControl.Companion.parse(this.headers);
      this.lazyCacheControl = localCacheControl1;
    }
    return localCacheControl1;
  }
  
  public final Response cacheResponse()
  {
    return this.cacheResponse;
  }
  
  public final List<Challenge> challenges()
  {
    Headers localHeaders = this.headers;
    int i = this.code;
    String str;
    if (i != 401)
    {
      if (i != 407) {
        return CollectionsKt.emptyList();
      }
      str = "Proxy-Authenticate";
    }
    else
    {
      str = "WWW-Authenticate";
    }
    return HttpHeaders.parseChallenges(localHeaders, str);
  }
  
  public void close()
  {
    ResponseBody localResponseBody = this.body;
    if (localResponseBody != null)
    {
      localResponseBody.close();
      return;
    }
    throw ((Throwable)new IllegalStateException("response is not eligible for a body and must not be closed".toString()));
  }
  
  public final int code()
  {
    return this.code;
  }
  
  public final Exchange exchange()
  {
    return this.exchange;
  }
  
  public final Handshake handshake()
  {
    return this.handshake;
  }
  
  public final String header(String paramString)
  {
    return header$default(this, paramString, null, 2, null);
  }
  
  public final String header(String paramString1, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    paramString1 = this.headers.get(paramString1);
    if (paramString1 != null) {
      paramString2 = paramString1;
    }
    return paramString2;
  }
  
  public final List<String> headers(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    return this.headers.values(paramString);
  }
  
  public final Headers headers()
  {
    return this.headers;
  }
  
  public final boolean isRedirect()
  {
    int i = this.code;
    if ((i != 307) && (i != 308)) {
      switch (i)
      {
      default: 
        return false;
      }
    }
    return true;
  }
  
  public final boolean isSuccessful()
  {
    int i = this.code;
    return (200 <= i) && (299 >= i);
  }
  
  public final String message()
  {
    return this.message;
  }
  
  public final Response networkResponse()
  {
    return this.networkResponse;
  }
  
  public final Builder newBuilder()
  {
    return new Builder(this);
  }
  
  public final ResponseBody peekBody(long paramLong)
    throws IOException
  {
    Object localObject = this.body;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((ResponseBody)localObject).source().peek();
    Buffer localBuffer = new Buffer();
    ((BufferedSource)localObject).request(paramLong);
    localBuffer.write((Source)localObject, Math.min(paramLong, ((BufferedSource)localObject).getBuffer().size()));
    return ResponseBody.Companion.create((BufferedSource)localBuffer, this.body.contentType(), localBuffer.size());
  }
  
  public final Response priorResponse()
  {
    return this.priorResponse;
  }
  
  public final Protocol protocol()
  {
    return this.protocol;
  }
  
  public final long receivedResponseAtMillis()
  {
    return this.receivedResponseAtMillis;
  }
  
  public final Request request()
  {
    return this.request;
  }
  
  public final long sentRequestAtMillis()
  {
    return this.sentRequestAtMillis;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Response{protocol=");
    localStringBuilder.append(this.protocol);
    localStringBuilder.append(", code=");
    localStringBuilder.append(this.code);
    localStringBuilder.append(", message=");
    localStringBuilder.append(this.message);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.request.url());
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public final Headers trailers()
    throws IOException
  {
    Exchange localExchange = this.exchange;
    if (localExchange != null) {
      return localExchange.trailers();
    }
    throw ((Throwable)new IllegalStateException("trailers not available".toString()));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000l\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\t\n\002\020\b\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\030\002\n\002\b\005\n\002\020\016\n\002\b\013\n\002\030\002\n\002\b\005\n\002\020\t\n\002\b\005\n\002\030\002\n\002\b\f\n\002\020\002\n\002\b\002\n\002\030\002\n\002\b\005\b\026\030\0002\0020\001B\007\b\026¢\006\002\020\002B\017\b\020\022\006\020\003\032\0020\004¢\006\002\020\005J\030\020I\032\0020\0002\006\020J\032\0020)2\006\020K\032\0020)H\026J\022\020\006\032\0020\0002\b\020\006\032\004\030\0010\007H\026J\b\020L\032\0020\004H\026J\022\020\f\032\0020\0002\b\020\f\032\004\030\0010\004H\026J\022\020M\032\0020N2\b\020\003\032\004\030\0010\004H\002J\032\020O\032\0020N2\006\020J\032\0020)2\b\020\003\032\004\030\0010\004H\002J\020\020\020\032\0020\0002\006\020\020\032\0020\021H\026J\022\020\034\032\0020\0002\b\020\034\032\004\030\0010\035H\026J\030\020P\032\0020\0002\006\020J\032\0020)2\006\020K\032\0020)H\026J\020\020\"\032\0020\0002\006\020\"\032\0020QH\026J\025\020R\032\0020N2\006\020S\032\0020\027H\000¢\006\002\bTJ\020\020(\032\0020\0002\006\020(\032\0020)H\026J\022\020.\032\0020\0002\b\020.\032\004\030\0010\004H\026J\022\0201\032\0020\0002\b\0201\032\004\030\0010\004H\026J\020\0204\032\0020\0002\006\0204\032\00205H\026J\020\020:\032\0020\0002\006\020:\032\0020;H\026J\020\020U\032\0020\0002\006\020J\032\0020)H\026J\020\020@\032\0020\0002\006\020@\032\0020AH\026J\020\020F\032\0020\0002\006\020F\032\0020;H\026R\034\020\006\032\004\030\0010\007X\016¢\006\016\n\000\032\004\b\b\020\t\"\004\b\n\020\013R\034\020\f\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b\r\020\016\"\004\b\017\020\005R\032\020\020\032\0020\021X\016¢\006\016\n\000\032\004\b\022\020\023\"\004\b\024\020\025R\034\020\026\032\004\030\0010\027X\016¢\006\016\n\000\032\004\b\030\020\031\"\004\b\032\020\033R\034\020\034\032\004\030\0010\035X\016¢\006\016\n\000\032\004\b\036\020\037\"\004\b \020!R\032\020\"\032\0020#X\016¢\006\016\n\000\032\004\b$\020%\"\004\b&\020'R\034\020(\032\004\030\0010)X\016¢\006\016\n\000\032\004\b*\020+\"\004\b,\020-R\034\020.\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b/\020\016\"\004\b0\020\005R\034\0201\032\004\030\0010\004X\016¢\006\016\n\000\032\004\b2\020\016\"\004\b3\020\005R\034\0204\032\004\030\00105X\016¢\006\016\n\000\032\004\b6\0207\"\004\b8\0209R\032\020:\032\0020;X\016¢\006\016\n\000\032\004\b<\020=\"\004\b>\020?R\034\020@\032\004\030\0010AX\016¢\006\016\n\000\032\004\bB\020C\"\004\bD\020ER\032\020F\032\0020;X\016¢\006\016\n\000\032\004\bG\020=\"\004\bH\020?¨\006V"}, d2={"Lokhttp3/Response$Builder;", "", "()V", "response", "Lokhttp3/Response;", "(Lokhttp3/Response;)V", "body", "Lokhttp3/ResponseBody;", "getBody$okhttp", "()Lokhttp3/ResponseBody;", "setBody$okhttp", "(Lokhttp3/ResponseBody;)V", "cacheResponse", "getCacheResponse$okhttp", "()Lokhttp3/Response;", "setCacheResponse$okhttp", "code", "", "getCode$okhttp", "()I", "setCode$okhttp", "(I)V", "exchange", "Lokhttp3/internal/connection/Exchange;", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "setExchange$okhttp", "(Lokhttp3/internal/connection/Exchange;)V", "handshake", "Lokhttp3/Handshake;", "getHandshake$okhttp", "()Lokhttp3/Handshake;", "setHandshake$okhttp", "(Lokhttp3/Handshake;)V", "headers", "Lokhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "message", "", "getMessage$okhttp", "()Ljava/lang/String;", "setMessage$okhttp", "(Ljava/lang/String;)V", "networkResponse", "getNetworkResponse$okhttp", "setNetworkResponse$okhttp", "priorResponse", "getPriorResponse$okhttp", "setPriorResponse$okhttp", "protocol", "Lokhttp3/Protocol;", "getProtocol$okhttp", "()Lokhttp3/Protocol;", "setProtocol$okhttp", "(Lokhttp3/Protocol;)V", "receivedResponseAtMillis", "", "getReceivedResponseAtMillis$okhttp", "()J", "setReceivedResponseAtMillis$okhttp", "(J)V", "request", "Lokhttp3/Request;", "getRequest$okhttp", "()Lokhttp3/Request;", "setRequest$okhttp", "(Lokhttp3/Request;)V", "sentRequestAtMillis", "getSentRequestAtMillis$okhttp", "setSentRequestAtMillis$okhttp", "addHeader", "name", "value", "build", "checkPriorResponse", "", "checkSupportResponse", "header", "Lokhttp3/Headers;", "initExchange", "deferredTrailers", "initExchange$okhttp", "removeHeader", "okhttp"}, k=1, mv={1, 1, 16})
  public static class Builder
  {
    private ResponseBody body;
    private Response cacheResponse;
    private int code = -1;
    private Exchange exchange;
    private Handshake handshake;
    private Headers.Builder headers;
    private String message;
    private Response networkResponse;
    private Response priorResponse;
    private Protocol protocol;
    private long receivedResponseAtMillis;
    private Request request;
    private long sentRequestAtMillis;
    
    public Builder()
    {
      this.headers = new Headers.Builder();
    }
    
    public Builder(Response paramResponse)
    {
      this.request = paramResponse.request();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.handshake = paramResponse.handshake();
      this.headers = paramResponse.headers().newBuilder();
      this.body = paramResponse.body();
      this.networkResponse = paramResponse.networkResponse();
      this.cacheResponse = paramResponse.cacheResponse();
      this.priorResponse = paramResponse.priorResponse();
      this.sentRequestAtMillis = paramResponse.sentRequestAtMillis();
      this.receivedResponseAtMillis = paramResponse.receivedResponseAtMillis();
      this.exchange = paramResponse.exchange();
    }
    
    private final void checkPriorResponse(Response paramResponse)
    {
      if (paramResponse != null)
      {
        int i;
        if (paramResponse.body() == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          return;
        }
        throw ((Throwable)new IllegalArgumentException("priorResponse.body != null".toString()));
      }
    }
    
    private final void checkSupportResponse(String paramString, Response paramResponse)
    {
      if (paramResponse != null)
      {
        ResponseBody localResponseBody = paramResponse.body();
        int j = 1;
        int i;
        if (localResponseBody == null) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0)
        {
          if (paramResponse.networkResponse() == null) {
            i = 1;
          } else {
            i = 0;
          }
          if (i != 0)
          {
            if (paramResponse.cacheResponse() == null) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              if (paramResponse.priorResponse() == null) {
                i = j;
              } else {
                i = 0;
              }
              if (i != 0) {
                return;
              }
              paramResponse = new StringBuilder();
              paramResponse.append(paramString);
              paramResponse.append(".priorResponse != null");
              throw ((Throwable)new IllegalArgumentException(paramResponse.toString().toString()));
            }
            paramResponse = new StringBuilder();
            paramResponse.append(paramString);
            paramResponse.append(".cacheResponse != null");
            throw ((Throwable)new IllegalArgumentException(paramResponse.toString().toString()));
          }
          paramResponse = new StringBuilder();
          paramResponse.append(paramString);
          paramResponse.append(".networkResponse != null");
          throw ((Throwable)new IllegalArgumentException(paramResponse.toString().toString()));
        }
        paramResponse = new StringBuilder();
        paramResponse.append(paramString);
        paramResponse.append(".body != null");
        throw ((Throwable)new IllegalArgumentException(paramResponse.toString().toString()));
      }
    }
    
    public Builder addHeader(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.headers.add(paramString1, paramString2);
      return localBuilder;
    }
    
    public Builder body(ResponseBody paramResponseBody)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.body = paramResponseBody;
      return localBuilder;
    }
    
    public Response build()
    {
      int i;
      if (this.code >= 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0)
      {
        localObject = this.request;
        if (localObject != null)
        {
          Protocol localProtocol = this.protocol;
          if (localProtocol != null)
          {
            String str = this.message;
            if (str != null) {
              return new Response((Request)localObject, localProtocol, str, this.code, this.handshake, this.headers.build(), this.body, this.networkResponse, this.cacheResponse, this.priorResponse, this.sentRequestAtMillis, this.receivedResponseAtMillis, this.exchange);
            }
            throw ((Throwable)new IllegalStateException("message == null".toString()));
          }
          throw ((Throwable)new IllegalStateException("protocol == null".toString()));
        }
        throw ((Throwable)new IllegalStateException("request == null".toString()));
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("code < 0: ");
      ((StringBuilder)localObject).append(this.code);
      throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
    }
    
    public Builder cacheResponse(Response paramResponse)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.checkSupportResponse("cacheResponse", paramResponse);
      localBuilder.cacheResponse = paramResponse;
      return localBuilder;
    }
    
    public Builder code(int paramInt)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.code = paramInt;
      return localBuilder;
    }
    
    public final ResponseBody getBody$okhttp()
    {
      return this.body;
    }
    
    public final Response getCacheResponse$okhttp()
    {
      return this.cacheResponse;
    }
    
    public final int getCode$okhttp()
    {
      return this.code;
    }
    
    public final Exchange getExchange$okhttp()
    {
      return this.exchange;
    }
    
    public final Handshake getHandshake$okhttp()
    {
      return this.handshake;
    }
    
    public final Headers.Builder getHeaders$okhttp()
    {
      return this.headers;
    }
    
    public final String getMessage$okhttp()
    {
      return this.message;
    }
    
    public final Response getNetworkResponse$okhttp()
    {
      return this.networkResponse;
    }
    
    public final Response getPriorResponse$okhttp()
    {
      return this.priorResponse;
    }
    
    public final Protocol getProtocol$okhttp()
    {
      return this.protocol;
    }
    
    public final long getReceivedResponseAtMillis$okhttp()
    {
      return this.receivedResponseAtMillis;
    }
    
    public final Request getRequest$okhttp()
    {
      return this.request;
    }
    
    public final long getSentRequestAtMillis$okhttp()
    {
      return this.sentRequestAtMillis;
    }
    
    public Builder handshake(Handshake paramHandshake)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.handshake = paramHandshake;
      return localBuilder;
    }
    
    public Builder header(String paramString1, String paramString2)
    {
      Intrinsics.checkParameterIsNotNull(paramString1, "name");
      Intrinsics.checkParameterIsNotNull(paramString2, "value");
      Builder localBuilder = (Builder)this;
      localBuilder.headers.set(paramString1, paramString2);
      return localBuilder;
    }
    
    public Builder headers(Headers paramHeaders)
    {
      Intrinsics.checkParameterIsNotNull(paramHeaders, "headers");
      Builder localBuilder = (Builder)this;
      localBuilder.headers = paramHeaders.newBuilder();
      return localBuilder;
    }
    
    public final void initExchange$okhttp(Exchange paramExchange)
    {
      Intrinsics.checkParameterIsNotNull(paramExchange, "deferredTrailers");
      this.exchange = paramExchange;
    }
    
    public Builder message(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "message");
      Builder localBuilder = (Builder)this;
      localBuilder.message = paramString;
      return localBuilder;
    }
    
    public Builder networkResponse(Response paramResponse)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.checkSupportResponse("networkResponse", paramResponse);
      localBuilder.networkResponse = paramResponse;
      return localBuilder;
    }
    
    public Builder priorResponse(Response paramResponse)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.checkPriorResponse(paramResponse);
      localBuilder.priorResponse = paramResponse;
      return localBuilder;
    }
    
    public Builder protocol(Protocol paramProtocol)
    {
      Intrinsics.checkParameterIsNotNull(paramProtocol, "protocol");
      Builder localBuilder = (Builder)this;
      localBuilder.protocol = paramProtocol;
      return localBuilder;
    }
    
    public Builder receivedResponseAtMillis(long paramLong)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.receivedResponseAtMillis = paramLong;
      return localBuilder;
    }
    
    public Builder removeHeader(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "name");
      Builder localBuilder = (Builder)this;
      localBuilder.headers.removeAll(paramString);
      return localBuilder;
    }
    
    public Builder request(Request paramRequest)
    {
      Intrinsics.checkParameterIsNotNull(paramRequest, "request");
      Builder localBuilder = (Builder)this;
      localBuilder.request = paramRequest;
      return localBuilder;
    }
    
    public Builder sentRequestAtMillis(long paramLong)
    {
      Builder localBuilder = (Builder)this;
      localBuilder.sentRequestAtMillis = paramLong;
      return localBuilder;
    }
    
    public final void setBody$okhttp(ResponseBody paramResponseBody)
    {
      this.body = paramResponseBody;
    }
    
    public final void setCacheResponse$okhttp(Response paramResponse)
    {
      this.cacheResponse = paramResponse;
    }
    
    public final void setCode$okhttp(int paramInt)
    {
      this.code = paramInt;
    }
    
    public final void setExchange$okhttp(Exchange paramExchange)
    {
      this.exchange = paramExchange;
    }
    
    public final void setHandshake$okhttp(Handshake paramHandshake)
    {
      this.handshake = paramHandshake;
    }
    
    public final void setHeaders$okhttp(Headers.Builder paramBuilder)
    {
      Intrinsics.checkParameterIsNotNull(paramBuilder, "<set-?>");
      this.headers = paramBuilder;
    }
    
    public final void setMessage$okhttp(String paramString)
    {
      this.message = paramString;
    }
    
    public final void setNetworkResponse$okhttp(Response paramResponse)
    {
      this.networkResponse = paramResponse;
    }
    
    public final void setPriorResponse$okhttp(Response paramResponse)
    {
      this.priorResponse = paramResponse;
    }
    
    public final void setProtocol$okhttp(Protocol paramProtocol)
    {
      this.protocol = paramProtocol;
    }
    
    public final void setReceivedResponseAtMillis$okhttp(long paramLong)
    {
      this.receivedResponseAtMillis = paramLong;
    }
    
    public final void setRequest$okhttp(Request paramRequest)
    {
      this.request = paramRequest;
    }
    
    public final void setSentRequestAtMillis$okhttp(long paramLong)
    {
      this.sentRequestAtMillis = paramLong;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */