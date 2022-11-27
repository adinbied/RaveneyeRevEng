package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Address;
import dji.thirdparty.okhttp3.CertificatePinner;
import dji.thirdparty.okhttp3.Connection;
import dji.thirdparty.okhttp3.Cookie;
import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Headers.Builder;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.Interceptor.Chain;
import dji.thirdparty.okhttp3.MediaType;
import dji.thirdparty.okhttp3.OkHttpClient;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okhttp3.Response.Builder;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.okio.Buffer;
import dji.thirdparty.okio.BufferedSink;
import dji.thirdparty.okio.BufferedSource;
import dji.thirdparty.okio.Sink;
import dji.thirdparty.okio.Source;
import dji.thirdparty.okio.Timeout;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class HttpEngine
{
  private static final ResponseBody EMPTY_BODY = new ResponseBody()
  {
    public long contentLength()
    {
      return 0L;
    }
    
    public MediaType contentType()
    {
      return null;
    }
    
    public BufferedSource source()
    {
      return new Buffer();
    }
  };
  public static final int MAX_FOLLOW_UPS = 20;
  public final boolean bufferRequestBody;
  private BufferedSink bufferedRequestBody;
  private Response cacheResponse;
  private CacheStrategy cacheStrategy;
  private final boolean callerWritesRequestBody;
  final OkHttpClient client;
  private final boolean forWebSocket;
  private HttpStream httpStream;
  private Request networkRequest;
  private final Response priorResponse;
  private Sink requestBodyOut;
  long sentRequestMillis = -1L;
  private CacheRequest storeRequest;
  public final StreamAllocation streamAllocation;
  private boolean transparentGzip;
  private final Request userRequest;
  private Response userResponse;
  
  public HttpEngine(OkHttpClient paramOkHttpClient, Request paramRequest, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, StreamAllocation paramStreamAllocation, RetryableSink paramRetryableSink, Response paramResponse)
  {
    this.client = paramOkHttpClient;
    this.userRequest = paramRequest;
    this.bufferRequestBody = paramBoolean1;
    this.callerWritesRequestBody = paramBoolean2;
    this.forWebSocket = paramBoolean3;
    if (paramStreamAllocation == null) {
      paramStreamAllocation = new StreamAllocation(paramOkHttpClient.connectionPool(), createAddress(paramOkHttpClient, paramRequest));
    }
    this.streamAllocation = paramStreamAllocation;
    this.requestBodyOut = paramRetryableSink;
    this.priorResponse = paramResponse;
  }
  
  private Response cacheWritingResponse(CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int k = paramHeaders1.size();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      String str1 = paramHeaders1.name(i);
      String str2 = paramHeaders1.value(i);
      if (((!"Warning".equalsIgnoreCase(str1)) || (!str2.startsWith("1"))) && ((!OkHeaders.isEndToEnd(str1)) || (paramHeaders2.get(str1) == null))) {
        localBuilder.add(str1, str2);
      }
      i += 1;
    }
    k = paramHeaders2.size();
    i = j;
    while (i < k)
    {
      paramHeaders1 = paramHeaders2.name(i);
      if ((!"Content-Length".equalsIgnoreCase(paramHeaders1)) && (OkHeaders.isEndToEnd(paramHeaders1))) {
        localBuilder.add(paramHeaders1, paramHeaders2.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  private HttpStream connect()
    throws RouteException, RequestException, IOException
  {
    return null;
  }
  
  private String cookieHeader(List<Cookie> paramList)
  {
    return null;
  }
  
  private static Address createAddress(OkHttpClient paramOkHttpClient, Request paramRequest)
  {
    Object localObject2;
    Object localObject1;
    CertificatePinner localCertificatePinner;
    Object localObject3;
    if (paramRequest.isHttps())
    {
      localObject2 = paramOkHttpClient.sslSocketFactory();
      localObject1 = paramOkHttpClient.hostnameVerifier();
      localCertificatePinner = paramOkHttpClient.certificatePinner();
      localObject3 = localCertificatePinner;
    }
    else
    {
      localCertificatePinner = null;
      localObject1 = localCertificatePinner;
      localObject3 = localObject1;
      localObject2 = localCertificatePinner;
    }
    return new Address(paramRequest.url().host(), paramRequest.url().port(), paramOkHttpClient.dns(), paramOkHttpClient.socketFactory(), (SSLSocketFactory)localObject2, (HostnameVerifier)localObject1, (CertificatePinner)localObject3, paramOkHttpClient.proxyAuthenticator(), paramOkHttpClient.proxy(), paramOkHttpClient.protocols(), paramOkHttpClient.connectionSpecs(), paramOkHttpClient.proxySelector());
  }
  
  public static boolean hasBody(Response paramResponse)
  {
    if (paramResponse.request().method().equals("HEAD")) {
      return false;
    }
    int i = paramResponse.code();
    if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
      return true;
    }
    if (OkHeaders.contentLength(paramResponse) == -1L) {
      return "chunked".equalsIgnoreCase(paramResponse.header("Transfer-Encoding"));
    }
    return true;
  }
  
  /* Error */
  private void maybeCache()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private Request networkRequest(Request paramRequest)
    throws IOException
  {
    return null;
  }
  
  private Response readNetworkResponse()
    throws IOException
  {
    return null;
  }
  
  private static Response stripBody(Response paramResponse)
  {
    Response localResponse = paramResponse;
    if (paramResponse != null)
    {
      localResponse = paramResponse;
      if (paramResponse.body() != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
    }
    return localResponse;
  }
  
  private Response unzip(Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  private static boolean validate(Response paramResponse1, Response paramResponse2)
  {
    if (paramResponse2.code() == 304) {
      return true;
    }
    paramResponse1 = paramResponse1.headers().getDate("Last-Modified");
    if (paramResponse1 != null)
    {
      paramResponse2 = paramResponse2.headers().getDate("Last-Modified");
      if ((paramResponse2 != null) && (paramResponse2.getTime() < paramResponse1.getTime())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean writeRequestHeadersEagerly()
  {
    return false;
  }
  
  public void cancel()
  {
    this.streamAllocation.cancel();
  }
  
  public StreamAllocation close()
  {
    return null;
  }
  
  public Request followUpRequest()
    throws IOException
  {
    return null;
  }
  
  public BufferedSink getBufferedRequestBody()
  {
    return null;
  }
  
  public Connection getConnection()
  {
    return this.streamAllocation.connection();
  }
  
  public Request getRequest()
  {
    return this.userRequest;
  }
  
  public Sink getRequestBody()
  {
    return null;
  }
  
  public Response getResponse()
  {
    return null;
  }
  
  public boolean hasResponse()
  {
    return this.userResponse != null;
  }
  
  boolean permitsRequestBody(Request paramRequest)
  {
    return HttpMethod.permitsRequestBody(paramRequest.method());
  }
  
  /* Error */
  public void readResponse()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void receiveHeaders(Headers arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public HttpEngine recover(IOException paramIOException)
  {
    return recover(paramIOException, this.requestBodyOut);
  }
  
  public HttpEngine recover(IOException paramIOException, Sink paramSink)
  {
    return null;
  }
  
  public void releaseStreamAllocation()
    throws IOException
  {
    this.streamAllocation.release();
  }
  
  public boolean sameConnection(HttpUrl paramHttpUrl)
  {
    return false;
  }
  
  /* Error */
  public void sendRequest()
    throws RequestException, RouteException, IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void writingRequestHeaders()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  class NetworkInterceptorChain
    implements Interceptor.Chain
  {
    private int calls;
    private final int index;
    private final Request request;
    
    NetworkInterceptorChain(int paramInt, Request paramRequest)
    {
      this.index = paramInt;
      this.request = paramRequest;
    }
    
    public Connection connection()
    {
      return null;
    }
    
    public Response proceed(Request paramRequest)
      throws IOException
    {
      return null;
    }
    
    public Request request()
    {
      return this.request;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\HttpEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */