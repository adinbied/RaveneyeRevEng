package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cache;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;

@Metadata(bv={1, 0, 3}, d1={"\000(\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\002\030\000 \0172\0020\001:\001\017B\017\022\b\020\002\032\004\030\0010\003¢\006\002\020\004J\032\020\007\032\0020\b2\b\020\t\032\004\030\0010\n2\006\020\013\032\0020\bH\002J\020\020\f\032\0020\b2\006\020\r\032\0020\016H\026R\026\020\002\032\004\030\0010\003X\004¢\006\b\n\000\032\004\b\005\020\006¨\006\020"}, d2={"Lokhttp3/internal/cache/CacheInterceptor;", "Lokhttp3/Interceptor;", "cache", "Lokhttp3/Cache;", "(Lokhttp3/Cache;)V", "getCache$okhttp", "()Lokhttp3/Cache;", "cacheWritingResponse", "Lokhttp3/Response;", "cacheRequest", "Lokhttp3/internal/cache/CacheRequest;", "response", "intercept", "chain", "Lokhttp3/Interceptor$Chain;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class CacheInterceptor
  implements Interceptor
{
  public static final Companion Companion = new Companion(null);
  private final Cache cache;
  
  public CacheInterceptor(Cache paramCache)
  {
    this.cache = paramCache;
  }
  
  private final Response cacheWritingResponse(final CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    if (paramCacheRequest == null) {
      return paramResponse;
    }
    Object localObject = paramCacheRequest.body();
    ResponseBody localResponseBody = paramResponse.body();
    if (localResponseBody == null) {
      Intrinsics.throwNpe();
    }
    paramCacheRequest = new Source()
    {
      private boolean cacheRequestClosed;
      
      public void close()
        throws IOException
      {
        if ((!this.cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.cacheRequestClosed = true;
          paramCacheRequest.abort();
        }
        this.$source.close();
      }
      
      public final boolean getCacheRequestClosed()
      {
        return this.cacheRequestClosed;
      }
      
      public long read(Buffer paramAnonymousBuffer, long paramAnonymousLong)
        throws IOException
      {
        Intrinsics.checkParameterIsNotNull(paramAnonymousBuffer, "sink");
        try
        {
          paramAnonymousLong = this.$source.read(paramAnonymousBuffer, paramAnonymousLong);
          if (paramAnonymousLong == -1L)
          {
            if (!this.cacheRequestClosed)
            {
              this.cacheRequestClosed = true;
              this.$cacheBody.close();
            }
            return -1L;
          }
          paramAnonymousBuffer.copyTo(this.$cacheBody.getBuffer(), paramAnonymousBuffer.size() - paramAnonymousLong, paramAnonymousLong);
          this.$cacheBody.emitCompleteSegments();
          return paramAnonymousLong;
        }
        catch (IOException paramAnonymousBuffer)
        {
          if (!this.cacheRequestClosed)
          {
            this.cacheRequestClosed = true;
            paramCacheRequest.abort();
          }
          throw ((Throwable)paramAnonymousBuffer);
        }
      }
      
      public final void setCacheRequestClosed(boolean paramAnonymousBoolean)
      {
        this.cacheRequestClosed = paramAnonymousBoolean;
      }
      
      public Timeout timeout()
      {
        return this.$source.timeout();
      }
    };
    localObject = Response.header$default(paramResponse, "Content-Type", null, 2, null);
    long l = paramResponse.body().contentLength();
    return paramResponse.newBuilder().body((ResponseBody)new RealResponseBody((String)localObject, l, Okio.buffer((Source)paramCacheRequest))).build();
  }
  
  public final Cache getCache$okhttp()
  {
    return this.cache;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramChain, "chain");
    Object localObject1 = this.cache;
    if (localObject1 != null) {
      localObject1 = ((Cache)localObject1).get$okhttp(paramChain.request());
    } else {
      localObject1 = null;
    }
    Object localObject2 = new CacheStrategy.Factory(System.currentTimeMillis(), paramChain.request(), (Response)localObject1).compute();
    Request localRequest = ((CacheStrategy)localObject2).getNetworkRequest();
    Response localResponse = ((CacheStrategy)localObject2).getCacheResponse();
    Cache localCache = this.cache;
    if (localCache != null) {
      localCache.trackResponse$okhttp((CacheStrategy)localObject2);
    }
    if ((localObject1 != null) && (localResponse == null))
    {
      localObject2 = ((Response)localObject1).body();
      if (localObject2 != null) {
        Util.closeQuietly((Closeable)localObject2);
      }
    }
    if ((localRequest == null) && (localResponse == null)) {
      return new Response.Builder().request(paramChain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
    }
    if (localRequest == null)
    {
      if (localResponse == null) {
        Intrinsics.throwNpe();
      }
      return localResponse.newBuilder().cacheResponse(Companion.access$stripBody(Companion, localResponse)).build();
    }
    localObject2 = (Response)null;
    try
    {
      paramChain = paramChain.proceed(localRequest);
      if ((paramChain == null) && (localObject1 != null))
      {
        localObject1 = ((Response)localObject1).body();
        if (localObject1 != null) {
          Util.closeQuietly((Closeable)localObject1);
        }
      }
      if (localResponse != null)
      {
        if ((paramChain != null) && (paramChain.code() == 304))
        {
          localObject1 = localResponse.newBuilder().headers(Companion.access$combine(Companion, localResponse.headers(), paramChain.headers())).sentRequestAtMillis(paramChain.sentRequestAtMillis()).receivedResponseAtMillis(paramChain.receivedResponseAtMillis()).cacheResponse(Companion.access$stripBody(Companion, localResponse)).networkResponse(Companion.access$stripBody(Companion, paramChain)).build();
          paramChain = paramChain.body();
          if (paramChain == null) {
            Intrinsics.throwNpe();
          }
          paramChain.close();
          paramChain = this.cache;
          if (paramChain == null) {
            Intrinsics.throwNpe();
          }
          paramChain.trackConditionalCacheHit$okhttp();
          this.cache.update$okhttp(localResponse, (Response)localObject1);
          return (Response)localObject1;
        }
        localObject1 = localResponse.body();
        if (localObject1 != null) {
          Util.closeQuietly((Closeable)localObject1);
        }
      }
      if (paramChain == null) {
        Intrinsics.throwNpe();
      }
      paramChain = paramChain.newBuilder().cacheResponse(Companion.access$stripBody(Companion, localResponse)).networkResponse(Companion.access$stripBody(Companion, paramChain)).build();
      if (this.cache != null)
      {
        if ((HttpHeaders.promisesBody(paramChain)) && (CacheStrategy.Companion.isCacheable(paramChain, localRequest))) {
          return cacheWritingResponse(this.cache.put$okhttp(paramChain), paramChain);
        }
        if (!HttpMethod.INSTANCE.invalidatesCache(localRequest.method())) {}
      }
      return paramChain;
    }
    finally
    {
      try
      {
        this.cache.remove$okhttp(localRequest);
        return paramChain;
      }
      catch (IOException localIOException) {}
      paramChain = finally;
      if (localObject1 != null)
      {
        localObject1 = ((Response)localObject1).body();
        if (localObject1 != null) {
          Util.closeQuietly((Closeable)localObject1);
        }
      }
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000*\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\013\n\000\n\002\020\016\n\002\b\002\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\030\020\003\032\0020\0042\006\020\005\032\0020\0042\006\020\006\032\0020\004H\002J\020\020\007\032\0020\b2\006\020\t\032\0020\nH\002J\020\020\013\032\0020\b2\006\020\t\032\0020\nH\002J\024\020\f\032\004\030\0010\r2\b\020\016\032\004\030\0010\rH\002¨\006\017"}, d2={"Lokhttp3/internal/cache/CacheInterceptor$Companion;", "", "()V", "combine", "Lokhttp3/Headers;", "cachedHeaders", "networkHeaders", "isContentSpecificHeader", "", "fieldName", "", "isEndToEnd", "stripBody", "Lokhttp3/Response;", "response", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final Headers combine(Headers paramHeaders1, Headers paramHeaders2)
    {
      Headers.Builder localBuilder = new Headers.Builder();
      int k = paramHeaders1.size();
      int j = 0;
      int i = 0;
      Object localObject;
      while (i < k)
      {
        localObject = paramHeaders1.name(i);
        String str = paramHeaders1.value(i);
        if ((!StringsKt.equals("Warning", (String)localObject, true)) || (!StringsKt.startsWith$default(str, "1", false, 2, null)))
        {
          Companion localCompanion = (Companion)this;
          if ((localCompanion.isContentSpecificHeader((String)localObject)) || (!localCompanion.isEndToEnd((String)localObject)) || (paramHeaders2.get((String)localObject) == null)) {
            localBuilder.addLenient$okhttp((String)localObject, str);
          }
        }
        i += 1;
      }
      k = paramHeaders2.size();
      i = j;
      while (i < k)
      {
        paramHeaders1 = paramHeaders2.name(i);
        localObject = (Companion)this;
        if ((!((Companion)localObject).isContentSpecificHeader(paramHeaders1)) && (((Companion)localObject).isEndToEnd(paramHeaders1))) {
          localBuilder.addLenient$okhttp(paramHeaders1, paramHeaders2.value(i));
        }
        i += 1;
      }
      return localBuilder.build();
    }
    
    private final boolean isContentSpecificHeader(String paramString)
    {
      boolean bool2 = true;
      boolean bool1 = bool2;
      if (!StringsKt.equals("Content-Length", paramString, true))
      {
        bool1 = bool2;
        if (!StringsKt.equals("Content-Encoding", paramString, true))
        {
          if (StringsKt.equals("Content-Type", paramString, true)) {
            return true;
          }
          bool1 = false;
        }
      }
      return bool1;
    }
    
    private final boolean isEndToEnd(String paramString)
    {
      return (!StringsKt.equals("Connection", paramString, true)) && (!StringsKt.equals("Keep-Alive", paramString, true)) && (!StringsKt.equals("Proxy-Authenticate", paramString, true)) && (!StringsKt.equals("Proxy-Authorization", paramString, true)) && (!StringsKt.equals("TE", paramString, true)) && (!StringsKt.equals("Trailers", paramString, true)) && (!StringsKt.equals("Transfer-Encoding", paramString, true)) && (!StringsKt.equals("Upgrade", paramString, true));
    }
    
    private final Response stripBody(Response paramResponse)
    {
      ResponseBody localResponseBody;
      if (paramResponse != null) {
        localResponseBody = paramResponse.body();
      } else {
        localResponseBody = null;
      }
      Response localResponse = paramResponse;
      if (localResponseBody != null) {
        localResponse = paramResponse.newBuilder().body(null).build();
      }
      return localResponse;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\cache\CacheInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */