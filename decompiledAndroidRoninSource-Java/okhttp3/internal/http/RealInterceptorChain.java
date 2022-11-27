package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.connection.Exchange;
import okhttp3.internal.connection.RealCall;
import okhttp3.internal.connection.RealConnection;

@Metadata(bv={1, 0, 3}, d1={"\000L\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\020\b\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\017\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\003\030\0002\0020\001BM\022\006\020\002\032\0020\003\022\f\020\004\032\b\022\004\022\0020\0060\005\022\006\020\007\032\0020\b\022\b\020\t\032\004\030\0010\n\022\006\020\013\032\0020\f\022\006\020\r\032\0020\b\022\006\020\016\032\0020\b\022\006\020\017\032\0020\b¢\006\002\020\020J\b\020\002\032\0020\034H\026J\b\020\r\032\0020\bH\026J\n\020\035\032\004\030\0010\036H\026JK\020\037\032\0020\0002\b\b\002\020\007\032\0020\b2\n\b\002\020\t\032\004\030\0010\n2\b\b\002\020\013\032\0020\f2\b\b\002\020\r\032\0020\b2\b\b\002\020\016\032\0020\b2\b\b\002\020\017\032\0020\bH\000¢\006\002\b J\020\020!\032\0020\"2\006\020\013\032\0020\fH\026J\b\020\016\032\0020\bH\026J\b\020\013\032\0020\fH\026J\030\020#\032\0020\0012\006\020$\032\0020\b2\006\020%\032\0020&H\026J\030\020'\032\0020\0012\006\020$\032\0020\b2\006\020%\032\0020&H\026J\030\020(\032\0020\0012\006\020$\032\0020\b2\006\020%\032\0020&H\026J\b\020\017\032\0020\bH\026R\024\020\002\032\0020\003X\004¢\006\b\n\000\032\004\b\021\020\022R\016\020\023\032\0020\bX\016¢\006\002\n\000R\024\020\r\032\0020\bX\004¢\006\b\n\000\032\004\b\024\020\025R\026\020\t\032\004\030\0010\nX\004¢\006\b\n\000\032\004\b\026\020\027R\016\020\007\032\0020\bX\004¢\006\002\n\000R\024\020\004\032\b\022\004\022\0020\0060\005X\004¢\006\002\n\000R\024\020\016\032\0020\bX\004¢\006\b\n\000\032\004\b\030\020\025R\024\020\013\032\0020\fX\004¢\006\b\n\000\032\004\b\031\020\032R\024\020\017\032\0020\bX\004¢\006\b\n\000\032\004\b\033\020\025¨\006)"}, d2={"Lokhttp3/internal/http/RealInterceptorChain;", "Lokhttp3/Interceptor$Chain;", "call", "Lokhttp3/internal/connection/RealCall;", "interceptors", "", "Lokhttp3/Interceptor;", "index", "", "exchange", "Lokhttp3/internal/connection/Exchange;", "request", "Lokhttp3/Request;", "connectTimeoutMillis", "readTimeoutMillis", "writeTimeoutMillis", "(Lokhttp3/internal/connection/RealCall;Ljava/util/List;ILokhttp3/internal/connection/Exchange;Lokhttp3/Request;III)V", "getCall$okhttp", "()Lokhttp3/internal/connection/RealCall;", "calls", "getConnectTimeoutMillis$okhttp", "()I", "getExchange$okhttp", "()Lokhttp3/internal/connection/Exchange;", "getReadTimeoutMillis$okhttp", "getRequest$okhttp", "()Lokhttp3/Request;", "getWriteTimeoutMillis$okhttp", "Lokhttp3/Call;", "connection", "Lokhttp3/Connection;", "copy", "copy$okhttp", "proceed", "Lokhttp3/Response;", "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "withReadTimeout", "withWriteTimeout", "okhttp"}, k=1, mv={1, 1, 16})
public final class RealInterceptorChain
  implements Interceptor.Chain
{
  private final RealCall call;
  private int calls;
  private final int connectTimeoutMillis;
  private final Exchange exchange;
  private final int index;
  private final List<Interceptor> interceptors;
  private final int readTimeoutMillis;
  private final Request request;
  private final int writeTimeoutMillis;
  
  public RealInterceptorChain(RealCall paramRealCall, List<? extends Interceptor> paramList, int paramInt1, Exchange paramExchange, Request paramRequest, int paramInt2, int paramInt3, int paramInt4)
  {
    this.call = paramRealCall;
    this.interceptors = paramList;
    this.index = paramInt1;
    this.exchange = paramExchange;
    this.request = paramRequest;
    this.connectTimeoutMillis = paramInt2;
    this.readTimeoutMillis = paramInt3;
    this.writeTimeoutMillis = paramInt4;
  }
  
  public Call call()
  {
    return (Call)this.call;
  }
  
  public int connectTimeoutMillis()
  {
    return this.connectTimeoutMillis;
  }
  
  public Connection connection()
  {
    Object localObject = this.exchange;
    if (localObject != null) {
      localObject = ((Exchange)localObject).getConnection$okhttp();
    } else {
      localObject = null;
    }
    return (Connection)localObject;
  }
  
  public final RealInterceptorChain copy$okhttp(int paramInt1, Exchange paramExchange, Request paramRequest, int paramInt2, int paramInt3, int paramInt4)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    return new RealInterceptorChain(this.call, this.interceptors, paramInt1, paramExchange, paramRequest, paramInt2, paramInt3, paramInt4);
  }
  
  public final RealCall getCall$okhttp()
  {
    return this.call;
  }
  
  public final int getConnectTimeoutMillis$okhttp()
  {
    return this.connectTimeoutMillis;
  }
  
  public final Exchange getExchange$okhttp()
  {
    return this.exchange;
  }
  
  public final int getReadTimeoutMillis$okhttp()
  {
    return this.readTimeoutMillis;
  }
  
  public final Request getRequest$okhttp()
  {
    return this.request;
  }
  
  public final int getWriteTimeoutMillis$okhttp()
  {
    return this.writeTimeoutMillis;
  }
  
  public Response proceed(Request paramRequest)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    int i = this.index;
    int k = this.interceptors.size();
    int j = 0;
    if (i < k) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.calls += 1;
      Object localObject = this.exchange;
      if (localObject != null) {
        if (((Exchange)localObject).getConnection$okhttp().supportsUrl(paramRequest.url()))
        {
          if (this.calls == 1) {
            i = 1;
          } else {
            i = 0;
          }
          if (i == 0)
          {
            paramRequest = new StringBuilder();
            paramRequest.append("network interceptor ");
            paramRequest.append((Interceptor)this.interceptors.get(this.index - 1));
            paramRequest.append(" must call proceed() exactly once");
            throw ((Throwable)new IllegalStateException(paramRequest.toString().toString()));
          }
        }
        else
        {
          paramRequest = new StringBuilder();
          paramRequest.append("network interceptor ");
          paramRequest.append((Interceptor)this.interceptors.get(this.index - 1));
          paramRequest.append(" must retain the same host and port");
          throw ((Throwable)new IllegalStateException(paramRequest.toString().toString()));
        }
      }
      localObject = copy$okhttp$default(this, this.index + 1, null, paramRequest, 0, 0, 0, 58, null);
      paramRequest = (Interceptor)this.interceptors.get(this.index);
      Response localResponse = paramRequest.intercept((Interceptor.Chain)localObject);
      if (localResponse != null)
      {
        if (this.exchange != null)
        {
          if ((this.index + 1 < this.interceptors.size()) && (((RealInterceptorChain)localObject).calls != 1)) {
            i = 0;
          } else {
            i = 1;
          }
          if (i == 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("network interceptor ");
            ((StringBuilder)localObject).append(paramRequest);
            ((StringBuilder)localObject).append(" must call proceed() exactly once");
            throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
          }
        }
        i = j;
        if (localResponse.body() != null) {
          i = 1;
        }
        if (i != 0) {
          return localResponse;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("interceptor ");
        ((StringBuilder)localObject).append(paramRequest);
        ((StringBuilder)localObject).append(" returned a response with no body");
        throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString().toString()));
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("interceptor ");
      ((StringBuilder)localObject).append(paramRequest);
      ((StringBuilder)localObject).append(" returned null");
      throw ((Throwable)new NullPointerException(((StringBuilder)localObject).toString()));
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
  }
  
  public int readTimeoutMillis()
  {
    return this.readTimeoutMillis;
  }
  
  public Request request()
  {
    return this.request;
  }
  
  public Interceptor.Chain withConnectTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return (Interceptor.Chain)copy$okhttp$default(this, 0, null, null, Util.checkDuration("connectTimeout", paramInt, paramTimeUnit), 0, 0, 55, null);
  }
  
  public Interceptor.Chain withReadTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return (Interceptor.Chain)copy$okhttp$default(this, 0, null, null, 0, Util.checkDuration("readTimeout", paramInt, paramTimeUnit), 0, 47, null);
  }
  
  public Interceptor.Chain withWriteTimeout(int paramInt, TimeUnit paramTimeUnit)
  {
    Intrinsics.checkParameterIsNotNull(paramTimeUnit, "unit");
    return (Interceptor.Chain)copy$okhttp$default(this, 0, null, null, 0, 0, Util.checkDuration("writeTimeout", paramInt, paramTimeUnit), 31, null);
  }
  
  public int writeTimeoutMillis()
  {
    return this.writeTimeoutMillis;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\RealInterceptorChain.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */