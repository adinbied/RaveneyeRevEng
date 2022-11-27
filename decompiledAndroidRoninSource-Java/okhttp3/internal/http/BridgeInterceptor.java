package okhttp3.internal.http;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okio.GzipSource;
import okio.Okio;
import okio.Source;

@Metadata(bv={1, 0, 3}, d1={"\000.\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\030\0002\0020\001B\r\022\006\020\002\032\0020\003¢\006\002\020\004J\026\020\005\032\0020\0062\f\020\007\032\b\022\004\022\0020\t0\bH\002J\020\020\n\032\0020\0132\006\020\f\032\0020\rH\026R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\016"}, d2={"Lokhttp3/internal/http/BridgeInterceptor;", "Lokhttp3/Interceptor;", "cookieJar", "Lokhttp3/CookieJar;", "(Lokhttp3/CookieJar;)V", "cookieHeader", "", "cookies", "", "Lokhttp3/Cookie;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "okhttp"}, k=1, mv={1, 1, 16})
public final class BridgeInterceptor
  implements Interceptor
{
  private final CookieJar cookieJar;
  
  public BridgeInterceptor(CookieJar paramCookieJar)
  {
    this.cookieJar = paramCookieJar;
  }
  
  private final String cookieHeader(List<Cookie> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = ((Iterable)paramList).iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = paramList.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      localObject = (Cookie)localObject;
      if (i > 0) {
        localStringBuilder.append("; ");
      }
      localStringBuilder.append(((Cookie)localObject).name());
      localStringBuilder.append('=');
      localStringBuilder.append(((Cookie)localObject).value());
      i += 1;
    }
    paramList = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "StringBuilder().apply(builderAction).toString()");
    return paramList;
  }
  
  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramChain, "chain");
    Object localObject1 = paramChain.request();
    Object localObject2 = ((Request)localObject1).newBuilder();
    Object localObject3 = ((Request)localObject1).body();
    if (localObject3 != null)
    {
      MediaType localMediaType = ((RequestBody)localObject3).contentType();
      if (localMediaType != null) {
        ((Request.Builder)localObject2).header("Content-Type", localMediaType.toString());
      }
      long l = ((RequestBody)localObject3).contentLength();
      if (l != -1L)
      {
        ((Request.Builder)localObject2).header("Content-Length", String.valueOf(l));
        ((Request.Builder)localObject2).removeHeader("Transfer-Encoding");
      }
      else
      {
        ((Request.Builder)localObject2).header("Transfer-Encoding", "chunked");
        ((Request.Builder)localObject2).removeHeader("Content-Length");
      }
    }
    localObject3 = ((Request)localObject1).header("Host");
    int j = 0;
    if (localObject3 == null) {
      ((Request.Builder)localObject2).header("Host", Util.toHostHeader$default(((Request)localObject1).url(), false, 1, null));
    }
    if (((Request)localObject1).header("Connection") == null) {
      ((Request.Builder)localObject2).header("Connection", "Keep-Alive");
    }
    int i = j;
    if (((Request)localObject1).header("Accept-Encoding") == null)
    {
      i = j;
      if (((Request)localObject1).header("Range") == null)
      {
        ((Request.Builder)localObject2).header("Accept-Encoding", "gzip");
        i = 1;
      }
    }
    localObject3 = this.cookieJar.loadForRequest(((Request)localObject1).url());
    if ((((Collection)localObject3).isEmpty() ^ true)) {
      ((Request.Builder)localObject2).header("Cookie", cookieHeader((List)localObject3));
    }
    if (((Request)localObject1).header("User-Agent") == null) {
      ((Request.Builder)localObject2).header("User-Agent", "okhttp/4.4.0");
    }
    paramChain = paramChain.proceed(((Request.Builder)localObject2).build());
    HttpHeaders.receiveHeaders(this.cookieJar, ((Request)localObject1).url(), paramChain.headers());
    localObject1 = paramChain.newBuilder().request((Request)localObject1);
    if ((i != 0) && (StringsKt.equals("gzip", Response.header$default(paramChain, "Content-Encoding", null, 2, null), true)) && (HttpHeaders.promisesBody(paramChain)))
    {
      localObject2 = paramChain.body();
      if (localObject2 != null)
      {
        localObject2 = new GzipSource((Source)((ResponseBody)localObject2).source());
        ((Response.Builder)localObject1).headers(paramChain.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
        ((Response.Builder)localObject1).body((ResponseBody)new RealResponseBody(Response.header$default(paramChain, "Content-Type", null, 2, null), -1L, Okio.buffer((Source)localObject2)));
      }
    }
    return ((Response.Builder)localObject1).build();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\BridgeInterceptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */