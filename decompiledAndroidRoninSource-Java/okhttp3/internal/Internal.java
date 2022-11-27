package okhttp3.internal;

import javax.net.ssl.SSLSocket;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Cache;
import okhttp3.ConnectionSpec;
import okhttp3.Cookie;
import okhttp3.Cookie.Companion;
import okhttp3.Headers.Builder;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv={1, 0, 3}, d1={"\000T\n\000\n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\003\n\002\020\t\n\000\n\002\030\002\n\002\b\002\032\026\020\000\032\0020\0012\006\020\002\032\0020\0012\006\020\003\032\0020\004\032\036\020\000\032\0020\0012\006\020\002\032\0020\0012\006\020\005\032\0020\0042\006\020\006\032\0020\004\032\036\020\007\032\0020\b2\006\020\t\032\0020\n2\006\020\013\032\0020\f2\006\020\r\032\0020\016\032\030\020\017\032\004\030\0010\0202\006\020\021\032\0020\0222\006\020\023\032\0020\024\032\026\020\025\032\0020\0042\006\020\026\032\0020\0272\006\020\030\032\0020\016\032 \020\031\032\004\030\0010\0272\006\020\032\032\0020\0332\006\020\034\032\0020\0352\006\020\036\032\0020\004¨\006\037"}, d2={"addHeaderLenient", "Lokhttp3/Headers$Builder;", "builder", "line", "", "name", "value", "applyConnectionSpec", "", "connectionSpec", "Lokhttp3/ConnectionSpec;", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "isFallback", "", "cacheGet", "Lokhttp3/Response;", "cache", "Lokhttp3/Cache;", "request", "Lokhttp3/Request;", "cookieToString", "cookie", "Lokhttp3/Cookie;", "forObsoleteRfc2965", "parseCookie", "currentTimeMillis", "", "url", "Lokhttp3/HttpUrl;", "setCookie", "okhttp"}, k=2, mv={1, 1, 16})
public final class Internal
{
  public static final Headers.Builder addHeaderLenient(Headers.Builder paramBuilder, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramBuilder, "builder");
    Intrinsics.checkParameterIsNotNull(paramString, "line");
    return paramBuilder.addLenient$okhttp(paramString);
  }
  
  public static final Headers.Builder addHeaderLenient(Headers.Builder paramBuilder, String paramString1, String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramBuilder, "builder");
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    return paramBuilder.addLenient$okhttp(paramString1, paramString2);
  }
  
  public static final void applyConnectionSpec(ConnectionSpec paramConnectionSpec, SSLSocket paramSSLSocket, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramConnectionSpec, "connectionSpec");
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    paramConnectionSpec.apply$okhttp(paramSSLSocket, paramBoolean);
  }
  
  public static final Response cacheGet(Cache paramCache, Request paramRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramCache, "cache");
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    return paramCache.get$okhttp(paramRequest);
  }
  
  public static final String cookieToString(Cookie paramCookie, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramCookie, "cookie");
    return paramCookie.toString$okhttp(paramBoolean);
  }
  
  public static final Cookie parseCookie(long paramLong, HttpUrl paramHttpUrl, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
    Intrinsics.checkParameterIsNotNull(paramString, "setCookie");
    return Cookie.Companion.parse$okhttp(paramLong, paramHttpUrl, paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\Internal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */