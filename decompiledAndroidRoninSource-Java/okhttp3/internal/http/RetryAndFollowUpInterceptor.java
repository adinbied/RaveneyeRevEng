package okhttp3.internal.http;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import okhttp3.Authenticator;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.Route;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteException;
import okhttp3.internal.http2.ConnectionShutdownException;

@Metadata(bv={1, 0, 3}, d1={"\000R\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\020\b\n\002\b\003\030\000 \0362\0020\001:\001\036B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\032\020\005\032\004\030\0010\0062\006\020\007\032\0020\b2\006\020\t\032\0020\nH\002J\034\020\013\032\004\030\0010\0062\006\020\007\032\0020\b2\b\020\f\032\004\030\0010\rH\002J\020\020\016\032\0020\b2\006\020\017\032\0020\020H\026J\030\020\021\032\0020\0222\006\020\023\032\0020\0242\006\020\025\032\0020\022H\002J(\020\026\032\0020\0222\006\020\023\032\0020\0242\006\020\027\032\0020\0302\006\020\031\032\0020\0062\006\020\025\032\0020\022H\002J\030\020\032\032\0020\0222\006\020\023\032\0020\0242\006\020\031\032\0020\006H\002J\030\020\033\032\0020\0342\006\020\007\032\0020\b2\006\020\035\032\0020\034H\002R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\037"}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor;", "Lokhttp3/Interceptor;", "client", "Lokhttp3/OkHttpClient;", "(Lokhttp3/OkHttpClient;)V", "buildRedirectRequest", "Lokhttp3/Request;", "userResponse", "Lokhttp3/Response;", "method", "", "followUpRequest", "exchange", "Lokhttp3/internal/connection/Exchange;", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "isRecoverable", "", "e", "Ljava/io/IOException;", "requestSendStarted", "recover", "call", "Lokhttp3/internal/connection/RealCall;", "userRequest", "requestIsOneShot", "retryAfter", "", "defaultDelay", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class RetryAndFollowUpInterceptor
  implements Interceptor
{
  public static final Companion Companion = new Companion(null);
  private static final int MAX_FOLLOW_UPS = 20;
  private final OkHttpClient client;
  
  public RetryAndFollowUpInterceptor(OkHttpClient paramOkHttpClient)
  {
    this.client = paramOkHttpClient;
  }
  
  private final Request buildRedirectRequest(Response paramResponse, String paramString)
  {
    boolean bool = this.client.followRedirects();
    RequestBody localRequestBody = null;
    if (!bool) {
      return null;
    }
    Object localObject = Response.header$default(paramResponse, "Location", null, 2, null);
    if (localObject != null)
    {
      localObject = paramResponse.request().url().resolve((String)localObject);
      if (localObject != null)
      {
        if ((!Intrinsics.areEqual(((HttpUrl)localObject).scheme(), paramResponse.request().url().scheme())) && (!this.client.followSslRedirects())) {
          return null;
        }
        Request.Builder localBuilder = paramResponse.request().newBuilder();
        if (HttpMethod.permitsRequestBody(paramString))
        {
          bool = HttpMethod.INSTANCE.redirectsWithBody(paramString);
          if (HttpMethod.INSTANCE.redirectsToGet(paramString))
          {
            localBuilder.method("GET", null);
          }
          else
          {
            if (bool) {
              localRequestBody = paramResponse.request().body();
            }
            localBuilder.method(paramString, localRequestBody);
          }
          if (!bool)
          {
            localBuilder.removeHeader("Transfer-Encoding");
            localBuilder.removeHeader("Content-Length");
            localBuilder.removeHeader("Content-Type");
          }
        }
        if (!Util.canReuseConnectionFor(paramResponse.request().url(), (HttpUrl)localObject)) {
          localBuilder.removeHeader("Authorization");
        }
        return localBuilder.url((HttpUrl)localObject).build();
      }
    }
    return null;
  }
  
  private final Request followUpRequest(Response paramResponse, Exchange paramExchange)
    throws IOException
  {
    if (paramExchange != null)
    {
      localObject = paramExchange.getConnection$okhttp();
      if (localObject != null)
      {
        localObject = ((RealConnection)localObject).route();
        break label28;
      }
    }
    Object localObject = null;
    label28:
    int i = paramResponse.code();
    String str = paramResponse.request().method();
    if ((i != 307) && (i != 308))
    {
      if (i != 401)
      {
        if (i != 421)
        {
          if (i != 503)
          {
            if (i != 407)
            {
              if (i != 408)
              {
                switch (i)
                {
                default: 
                  return null;
                }
                return buildRedirectRequest(paramResponse, str);
              }
              if (!this.client.retryOnConnectionFailure()) {
                return null;
              }
              paramExchange = paramResponse.request().body();
              if ((paramExchange != null) && (paramExchange.isOneShot())) {
                return null;
              }
              paramExchange = paramResponse.priorResponse();
              if ((paramExchange != null) && (paramExchange.code() == 408)) {
                return null;
              }
              if (retryAfter(paramResponse, 0) > 0) {
                return null;
              }
              return paramResponse.request();
            }
            if (localObject == null) {
              Intrinsics.throwNpe();
            }
            if (((Route)localObject).proxy().type() == Proxy.Type.HTTP) {
              return this.client.proxyAuthenticator().authenticate((Route)localObject, paramResponse);
            }
            throw ((Throwable)new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy"));
          }
          paramExchange = paramResponse.priorResponse();
          if ((paramExchange != null) && (paramExchange.code() == 503)) {
            return null;
          }
          if (retryAfter(paramResponse, Integer.MAX_VALUE) == 0) {
            return paramResponse.request();
          }
          return null;
        }
        localObject = paramResponse.request().body();
        if ((localObject != null) && (((RequestBody)localObject).isOneShot())) {
          return null;
        }
        if (paramExchange != null)
        {
          if (!paramExchange.isCoalescedConnection$okhttp()) {
            return null;
          }
          paramExchange.getConnection$okhttp().noCoalescedConnections();
          return paramResponse.request();
        }
        return null;
      }
      return this.client.authenticator().authenticate((Route)localObject, paramResponse);
    }
    if (((Intrinsics.areEqual(str, "GET") ^ true)) && ((Intrinsics.areEqual(str, "HEAD") ^ true))) {
      return null;
    }
    return buildRedirectRequest(paramResponse, str);
  }
  
  private final boolean isRecoverable(IOException paramIOException, boolean paramBoolean)
  {
    boolean bool1 = paramIOException instanceof ProtocolException;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    if ((paramIOException instanceof InterruptedIOException))
    {
      bool1 = bool2;
      if ((paramIOException instanceof SocketTimeoutException))
      {
        bool1 = bool2;
        if (!paramBoolean) {
          bool1 = true;
        }
      }
      return bool1;
    }
    if (((paramIOException instanceof SSLHandshakeException)) && ((paramIOException.getCause() instanceof CertificateException))) {
      return false;
    }
    return !(paramIOException instanceof SSLPeerUnverifiedException);
  }
  
  private final boolean recover(IOException paramIOException, RealCall paramRealCall, Request paramRequest, boolean paramBoolean)
  {
    if (!this.client.retryOnConnectionFailure()) {
      return false;
    }
    if ((paramBoolean) && (requestIsOneShot(paramIOException, paramRequest))) {
      return false;
    }
    if (!isRecoverable(paramIOException, paramBoolean)) {
      return false;
    }
    return paramRealCall.retryAfterFailure();
  }
  
  private final boolean requestIsOneShot(IOException paramIOException, Request paramRequest)
  {
    paramRequest = paramRequest.body();
    return ((paramRequest != null) && (paramRequest.isOneShot())) || ((paramIOException instanceof FileNotFoundException));
  }
  
  private final int retryAfter(Response paramResponse, int paramInt)
  {
    paramResponse = Response.header$default(paramResponse, "Retry-After", null, 2, null);
    if (paramResponse != null)
    {
      CharSequence localCharSequence = (CharSequence)paramResponse;
      if (new Regex("\\d+").matches(localCharSequence))
      {
        paramResponse = Integer.valueOf(paramResponse);
        Intrinsics.checkExpressionValueIsNotNull(paramResponse, "Integer.valueOf(header)");
        return paramResponse.intValue();
      }
      return Integer.MAX_VALUE;
    }
    return paramInt;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramChain, "chain");
    RealInterceptorChain localRealInterceptorChain = (RealInterceptorChain)paramChain;
    Request localRequest = localRealInterceptorChain.getRequest$okhttp();
    RealCall localRealCall = localRealInterceptorChain.getCall$okhttp();
    Object localObject = (Response)null;
    boolean bool = true;
    int i = 0;
    localRealCall.enterNetworkInterceptorExchange(localRequest, bool);
    for (;;)
    {
      try
      {
        bool = localRealCall.isCanceled();
        if (!bool) {
          try
          {
            Response localResponse = localRealInterceptorChain.proceed(localRequest);
            paramChain = localResponse;
            if (localObject != null) {
              paramChain = localResponse.newBuilder().priorResponse(((Response)localObject).newBuilder().body(null).build()).build();
            }
            localObject = localRealCall.getInterceptorScopedExchange$okhttp();
            localRequest = followUpRequest(paramChain, (Exchange)localObject);
            if (localRequest == null)
            {
              if ((localObject != null) && (((Exchange)localObject).isDuplex$okhttp())) {
                localRealCall.timeoutEarlyExit();
              }
              localRealCall.exitNetworkInterceptorExchange$okhttp(false);
              return paramChain;
            }
            localObject = localRequest.body();
            if (localObject != null)
            {
              bool = ((RequestBody)localObject).isOneShot();
              if (bool)
              {
                localRealCall.exitNetworkInterceptorExchange$okhttp(false);
                return paramChain;
              }
            }
            localObject = paramChain.body();
            if (localObject != null) {
              Util.closeQuietly((Closeable)localObject);
            }
            i += 1;
            if (i <= 20)
            {
              localRealCall.exitNetworkInterceptorExchange$okhttp(true);
              bool = true;
              localObject = paramChain;
              break;
            }
            paramChain = new StringBuilder();
            paramChain.append("Too many follow-up requests: ");
            paramChain.append(i);
            throw ((Throwable)new ProtocolException(paramChain.toString()));
          }
          catch (IOException paramChain)
          {
            if ((paramChain instanceof ConnectionShutdownException)) {
              break label348;
            }
            bool = true;
            if (!recover(paramChain, localRealCall, localRequest, bool)) {
              throw ((Throwable)paramChain);
            }
          }
          catch (RouteException paramChain)
          {
            bool = recover(paramChain.getLastConnectException(), localRealCall, localRequest, false);
            if (bool)
            {
              localRealCall.exitNetworkInterceptorExchange$okhttp(true);
              bool = false;
              break;
            }
            throw ((Throwable)paramChain.getFirstConnectException());
          }
        }
        throw ((Throwable)new IOException("Canceled"));
      }
      finally
      {
        localRealCall.exitNetworkInterceptorExchange$okhttp(true);
      }
      label348:
      bool = false;
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\016\020\003\032\0020\004XT¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/internal/http/RetryAndFollowUpInterceptor$Companion;", "", "()V", "MAX_FOLLOW_UPS", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\RetryAndFollowUpInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */