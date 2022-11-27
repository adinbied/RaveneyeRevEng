package okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealConnection;
import okio.BufferedSink;
import okio.Okio;

@Metadata(bv={1, 0, 3}, d1={"\000\036\n\002\030\002\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\t"}, d2={"Lokhttp3/internal/http/CallServerInterceptor;", "Lokhttp3/Interceptor;", "forWebSocket", "", "(Z)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k=1, mv={1, 1, 16})
public final class CallServerInterceptor
  implements Interceptor
{
  private final boolean forWebSocket;
  
  public CallServerInterceptor(boolean paramBoolean)
  {
    this.forWebSocket = paramBoolean;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramChain, "chain");
    paramChain = (RealInterceptorChain)paramChain;
    Object localObject3 = paramChain.getExchange$okhttp();
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    Request localRequest = paramChain.getRequest$okhttp();
    RequestBody localRequestBody = localRequest.body();
    long l = System.currentTimeMillis();
    ((Exchange)localObject3).writeRequestHeaders(localRequest);
    Object localObject2 = null;
    paramChain = (Response.Builder)null;
    Object localObject1;
    if ((HttpMethod.permitsRequestBody(localRequest.method())) && (localRequestBody != null))
    {
      if (StringsKt.equals("100-continue", localRequest.header("Expect"), true))
      {
        ((Exchange)localObject3).flushRequest();
        paramChain = ((Exchange)localObject3).readResponseHeaders(true);
        ((Exchange)localObject3).responseHeadersStart();
        j = 0;
      }
      else
      {
        j = 1;
      }
      if (paramChain == null)
      {
        if (localRequestBody.isDuplex())
        {
          ((Exchange)localObject3).flushRequest();
          localRequestBody.writeTo(Okio.buffer(((Exchange)localObject3).createRequestBody(localRequest, true)));
          localObject1 = paramChain;
          i = j;
        }
        else
        {
          localObject1 = Okio.buffer(((Exchange)localObject3).createRequestBody(localRequest, false));
          localRequestBody.writeTo((BufferedSink)localObject1);
          ((BufferedSink)localObject1).close();
          localObject1 = paramChain;
          i = j;
        }
      }
      else
      {
        ((Exchange)localObject3).noRequestBody();
        localObject1 = paramChain;
        i = j;
        if (!((Exchange)localObject3).getConnection$okhttp().isMultiplexed())
        {
          ((Exchange)localObject3).noNewExchangesOnConnection();
          localObject1 = paramChain;
          i = j;
        }
      }
    }
    else
    {
      ((Exchange)localObject3).noRequestBody();
      i = 1;
      localObject1 = paramChain;
    }
    if ((localRequestBody == null) || (!localRequestBody.isDuplex())) {
      ((Exchange)localObject3).finishRequest();
    }
    paramChain = (Interceptor.Chain)localObject1;
    int j = i;
    if (localObject1 == null)
    {
      localObject1 = ((Exchange)localObject3).readResponseHeaders(false);
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      paramChain = (Interceptor.Chain)localObject1;
      j = i;
      if (i != 0)
      {
        ((Exchange)localObject3).responseHeadersStart();
        j = 0;
        paramChain = (Interceptor.Chain)localObject1;
      }
    }
    paramChain = paramChain.request(localRequest).handshake(((Exchange)localObject3).getConnection$okhttp().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
    int k = paramChain.code();
    int i = k;
    if (k == 100)
    {
      paramChain = ((Exchange)localObject3).readResponseHeaders(false);
      if (paramChain == null) {
        Intrinsics.throwNpe();
      }
      if (j != 0) {
        ((Exchange)localObject3).responseHeadersStart();
      }
      paramChain = paramChain.request(localRequest).handshake(((Exchange)localObject3).getConnection$okhttp().handshake()).sentRequestAtMillis(l).receivedResponseAtMillis(System.currentTimeMillis()).build();
      i = paramChain.code();
    }
    ((Exchange)localObject3).responseHeadersEnd(paramChain);
    if ((this.forWebSocket) && (i == 101)) {
      paramChain = paramChain.newBuilder().body(Util.EMPTY_RESPONSE).build();
    } else {
      paramChain = paramChain.newBuilder().body(((Exchange)localObject3).openResponseBody(paramChain)).build();
    }
    if ((StringsKt.equals("close", paramChain.request().header("Connection"), true)) || (StringsKt.equals("close", Response.header$default(paramChain, "Connection", null, 2, null), true))) {
      ((Exchange)localObject3).noNewExchangesOnConnection();
    }
    if ((i == 204) || (i == 205))
    {
      localObject1 = paramChain.body();
      if (localObject1 != null) {
        l = ((ResponseBody)localObject1).contentLength();
      } else {
        l = -1L;
      }
      if (l > 0L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("HTTP ");
        ((StringBuilder)localObject1).append(i);
        ((StringBuilder)localObject1).append(" had non-zero Content-Length: ");
        localObject3 = paramChain.body();
        paramChain = (Interceptor.Chain)localObject2;
        if (localObject3 != null) {
          paramChain = Long.valueOf(((ResponseBody)localObject3).contentLength());
        }
        ((StringBuilder)localObject1).append(paramChain);
        throw ((Throwable)new ProtocolException(((StringBuilder)localObject1).toString()));
      }
    }
    return paramChain;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\CallServerInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */