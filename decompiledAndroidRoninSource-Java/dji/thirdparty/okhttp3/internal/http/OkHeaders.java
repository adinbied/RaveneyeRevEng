package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Challenge;
import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Headers.Builder;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okhttp3.internal.Platform;
import dji.thirdparty.okhttp3.internal.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public final class OkHeaders
{
  static final String PREFIX = Platform.get().getPrefix();
  public static final String RECEIVED_MILLIS;
  public static final String RESPONSE_SOURCE;
  public static final String SELECTED_PROTOCOL;
  public static final String SENT_MILLIS;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(PREFIX);
    localStringBuilder.append("-Sent-Millis");
    SENT_MILLIS = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PREFIX);
    localStringBuilder.append("-Received-Millis");
    RECEIVED_MILLIS = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PREFIX);
    localStringBuilder.append("-Selected-Protocol");
    SELECTED_PROTOCOL = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(PREFIX);
    localStringBuilder.append("-Response-Source");
    RESPONSE_SOURCE = localStringBuilder.toString();
  }
  
  public static long contentLength(Headers paramHeaders)
  {
    return stringToLong(paramHeaders.get("Content-Length"));
  }
  
  public static long contentLength(Request paramRequest)
  {
    return contentLength(paramRequest.headers());
  }
  
  public static long contentLength(Response paramResponse)
  {
    return contentLength(paramResponse.headers());
  }
  
  public static boolean hasVaryAll(Headers paramHeaders)
  {
    return varyFields(paramHeaders).contains("*");
  }
  
  public static boolean hasVaryAll(Response paramResponse)
  {
    return hasVaryAll(paramResponse.headers());
  }
  
  static boolean isEndToEnd(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }
  
  public static List<Challenge> parseChallenges(Headers paramHeaders, String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    int k = paramHeaders.size();
    int i = 0;
    while (i < k)
    {
      if (paramString.equalsIgnoreCase(paramHeaders.name(i)))
      {
        String str1 = paramHeaders.value(i);
        int j = 0;
        while (j < str1.length())
        {
          int m = HeaderParser.skipUntil(str1, j, " ");
          String str2 = str1.substring(j, m).trim();
          j = HeaderParser.skipWhitespace(str1, m);
          if (!str1.regionMatches(true, j, "realm=\"", 0, 7)) {
            break;
          }
          j += 7;
          m = HeaderParser.skipUntil(str1, j, "\"");
          String str3 = str1.substring(j, m);
          j = HeaderParser.skipWhitespace(str1, HeaderParser.skipUntil(str1, m + 1, ",") + 1);
          localArrayList.add(new Challenge(str2, str3));
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static long stringToLong(String paramString)
  {
    if (paramString == null) {
      return -1L;
    }
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (NumberFormatException paramString) {}
    return -1L;
  }
  
  public static Set<String> varyFields(Headers paramHeaders)
  {
    Object localObject2 = Collections.emptySet();
    int k = paramHeaders.size();
    int i = 0;
    while (i < k)
    {
      if ("Vary".equalsIgnoreCase(paramHeaders.name(i)))
      {
        Object localObject3 = paramHeaders.value(i);
        Object localObject1 = localObject2;
        if (((Set)localObject2).isEmpty()) {
          localObject1 = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        }
        localObject3 = ((String)localObject3).split(",");
        int m = localObject3.length;
        int j = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (j >= m) {
            break;
          }
          ((Set)localObject1).add(localObject3[j].trim());
          j += 1;
        }
      }
      i += 1;
    }
    return (Set<String>)localObject2;
  }
  
  private static Set<String> varyFields(Response paramResponse)
  {
    return varyFields(paramResponse.headers());
  }
  
  public static Headers varyHeaders(Headers paramHeaders1, Headers paramHeaders2)
  {
    paramHeaders2 = varyFields(paramHeaders2);
    if (paramHeaders2.isEmpty()) {
      return new Headers.Builder().build();
    }
    Headers.Builder localBuilder = new Headers.Builder();
    int i = 0;
    int j = paramHeaders1.size();
    while (i < j)
    {
      String str = paramHeaders1.name(i);
      if (paramHeaders2.contains(str)) {
        localBuilder.add(str, paramHeaders1.value(i));
      }
      i += 1;
    }
    return localBuilder.build();
  }
  
  public static Headers varyHeaders(Response paramResponse)
  {
    return varyHeaders(paramResponse.networkResponse().request().headers(), paramResponse.headers());
  }
  
  public static boolean varyMatches(Response paramResponse, Headers paramHeaders, Request paramRequest)
  {
    paramResponse = varyFields(paramResponse).iterator();
    while (paramResponse.hasNext())
    {
      String str = (String)paramResponse.next();
      if (!Util.equal(paramHeaders.values(str), paramRequest.headers(str))) {
        return false;
      }
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\OkHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */