package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.Request;
import java.net.Proxy.Type;

public final class RequestLine
{
  static String get(Request paramRequest, Proxy.Type paramType)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramRequest.method());
    localStringBuilder.append(' ');
    if (includeAuthorityInRequestLine(paramRequest, paramType)) {
      localStringBuilder.append(paramRequest.url());
    } else {
      localStringBuilder.append(requestPath(paramRequest.url()));
    }
    localStringBuilder.append(" HTTP/1.1");
    return localStringBuilder.toString();
  }
  
  private static boolean includeAuthorityInRequestLine(Request paramRequest, Proxy.Type paramType)
  {
    return (!paramRequest.isHttps()) && (paramType == Proxy.Type.HTTP);
  }
  
  public static String requestPath(HttpUrl paramHttpUrl)
  {
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\RequestLine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */