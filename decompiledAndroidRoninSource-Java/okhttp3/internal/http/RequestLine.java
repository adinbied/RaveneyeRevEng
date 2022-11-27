package okhttp3.internal.http;

import java.net.Proxy.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import okhttp3.Request;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\016\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\013\n\002\b\002\n\002\030\002\n\000\bÆ\002\030\0002\0020\001B\007\b\002¢\006\002\020\002J\026\020\003\032\0020\0042\006\020\005\032\0020\0062\006\020\007\032\0020\bJ\030\020\t\032\0020\n2\006\020\005\032\0020\0062\006\020\007\032\0020\bH\002J\016\020\013\032\0020\0042\006\020\f\032\0020\r¨\006\016"}, d2={"Lokhttp3/internal/http/RequestLine;", "", "()V", "get", "", "request", "Lokhttp3/Request;", "proxyType", "Ljava/net/Proxy$Type;", "includeAuthorityInRequestLine", "", "requestPath", "url", "Lokhttp3/HttpUrl;", "okhttp"}, k=1, mv={1, 1, 16})
public final class RequestLine
{
  public static final RequestLine INSTANCE = new RequestLine();
  
  private final boolean includeAuthorityInRequestLine(Request paramRequest, Proxy.Type paramType)
  {
    return (!paramRequest.isHttps()) && (paramType == Proxy.Type.HTTP);
  }
  
  public final String get(Request paramRequest, Proxy.Type paramType)
  {
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
    Intrinsics.checkParameterIsNotNull(paramType, "proxyType");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRequest.method());
    localStringBuilder.append(' ');
    if (INSTANCE.includeAuthorityInRequestLine(paramRequest, paramType)) {
      localStringBuilder.append(paramRequest.url());
    } else {
      localStringBuilder.append(INSTANCE.requestPath(paramRequest.url()));
    }
    localStringBuilder.append(" HTTP/1.1");
    paramRequest = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramRequest, "StringBuilder().apply(builderAction).toString()");
    return paramRequest;
  }
  
  public final String requestPath(HttpUrl paramHttpUrl)
  {
    Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
    String str1 = paramHttpUrl.encodedPath();
    String str2 = paramHttpUrl.encodedQuery();
    paramHttpUrl = str1;
    if (str2 != null)
    {
      paramHttpUrl = new StringBuilder();
      paramHttpUrl.append(str1);
      paramHttpUrl.append('?');
      paramHttpUrl.append(str2);
      paramHttpUrl = paramHttpUrl.toString();
    }
    return paramHttpUrl;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\RequestLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */