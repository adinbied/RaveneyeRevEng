package okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.Cookie.Companion;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import okio.Buffer;
import okio.ByteString;
import okio.ByteString.Companion;

@Metadata(bv={1, 0, 3}, d1={"\000R\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\000\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\000\n\002\020\016\n\002\b\002\n\002\020\002\n\002\030\002\n\000\n\002\020!\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\005\n\000\032\020\020\003\032\0020\0042\006\020\005\032\0020\006H\007\032\030\020\007\032\b\022\004\022\0020\t0\b*\0020\n2\006\020\013\032\0020\f\032\n\020\r\032\0020\004*\0020\006\032\032\020\016\032\0020\017*\0020\0202\f\020\021\032\b\022\004\022\0020\t0\022H\002\032\016\020\023\032\004\030\0010\f*\0020\020H\002\032\016\020\024\032\004\030\0010\f*\0020\020H\002\032\032\020\025\032\0020\017*\0020\0262\006\020\027\032\0020\0302\006\020\031\032\0020\n\032\f\020\032\032\0020\004*\0020\020H\002\032\024\020\033\032\0020\004*\0020\0202\006\020\034\032\0020\035H\002\"\016\020\000\032\0020\001X\004¢\006\002\n\000\"\016\020\002\032\0020\001X\004¢\006\002\n\000¨\006\036"}, d2={"QUOTED_STRING_DELIMITERS", "Lokio/ByteString;", "TOKEN_DELIMITERS", "hasBody", "", "response", "Lokhttp3/Response;", "parseChallenges", "", "Lokhttp3/Challenge;", "Lokhttp3/Headers;", "headerName", "", "promisesBody", "readChallengeHeader", "", "Lokio/Buffer;", "result", "", "readQuotedString", "readToken", "receiveHeaders", "Lokhttp3/CookieJar;", "url", "Lokhttp3/HttpUrl;", "headers", "skipCommasAndWhitespace", "startsWith", "prefix", "", "okhttp"}, k=2, mv={1, 1, 16})
public final class HttpHeaders
{
  private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
  private static final ByteString TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");
  
  @Deprecated(level=DeprecationLevel.ERROR, message="No longer supported", replaceWith=@ReplaceWith(expression="response.promisesBody()", imports={}))
  public static final boolean hasBody(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
    return promisesBody(paramResponse);
  }
  
  public static final List<Challenge> parseChallenges(Headers paramHeaders, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramHeaders, "$this$parseChallenges");
    Intrinsics.checkParameterIsNotNull(paramString, "headerName");
    List localList = (List)new ArrayList();
    int j = paramHeaders.size();
    int i = 0;
    while (i < j)
    {
      if (StringsKt.equals(paramString, paramHeaders.name(i), true))
      {
        Buffer localBuffer = new Buffer().writeUtf8(paramHeaders.value(i));
        try
        {
          readChallengeHeader(localBuffer, localList);
        }
        catch (EOFException localEOFException)
        {
          Platform.Companion.get().log("Unable to parse challenge", 5, (Throwable)localEOFException);
        }
      }
      i += 1;
    }
    return localList;
  }
  
  public static final boolean promisesBody(Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramResponse, "$this$promisesBody");
    if (Intrinsics.areEqual(paramResponse.request().method(), "HEAD")) {
      return false;
    }
    int i = paramResponse.code();
    if (((i < 100) || (i >= 200)) && (i != 204) && (i != 304)) {
      return true;
    }
    if (Util.headersContentLength(paramResponse) == -1L) {
      return StringsKt.equals("chunked", Response.header$default(paramResponse, "Transfer-Encoding", null, 2, null), true);
    }
    return true;
  }
  
  private static final void readChallengeHeader(Buffer paramBuffer, List<Challenge> paramList)
    throws EOFException
  {
    String str2 = (String)null;
    Object localObject1;
    Object localObject2;
    String str1;
    byte b;
    int i;
    for (;;)
    {
      localObject1 = str2;
      localObject2 = localObject1;
      if (localObject1 == null)
      {
        skipCommasAndWhitespace(paramBuffer);
        localObject1 = readToken(paramBuffer);
        localObject2 = localObject1;
        if (localObject1 == null) {
          return;
        }
      }
      boolean bool1 = skipCommasAndWhitespace(paramBuffer);
      str1 = readToken(paramBuffer);
      if (str1 == null)
      {
        if (!paramBuffer.exhausted()) {
          return;
        }
        paramList.add(new Challenge((String)localObject2, MapsKt.emptyMap()));
        return;
      }
      b = (byte)61;
      i = Util.skipAll(paramBuffer, b);
      boolean bool2 = skipCommasAndWhitespace(paramBuffer);
      if ((bool1) || ((!bool2) && (!paramBuffer.exhausted()))) {
        break;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(str1);
      ((StringBuilder)localObject1).append(StringsKt.repeat((CharSequence)"=", i));
      localObject1 = Collections.singletonMap(null, ((StringBuilder)localObject1).toString());
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "Collections.singletonMap…ek + \"=\".repeat(eqCount))");
      paramList.add(new Challenge((String)localObject2, (Map)localObject1));
    }
    Map localMap = (Map)new LinkedHashMap();
    i += Util.skipAll(paramBuffer, b);
    for (;;)
    {
      localObject1 = str1;
      if (str1 == null)
      {
        localObject1 = readToken(paramBuffer);
        if (!skipCommasAndWhitespace(paramBuffer)) {
          i = Util.skipAll(paramBuffer, b);
        }
      }
      else
      {
        if (i != 0) {
          break label265;
        }
      }
      paramList.add(new Challenge((String)localObject2, localMap));
      break;
      label265:
      if (i > 1) {
        return;
      }
      if (skipCommasAndWhitespace(paramBuffer)) {
        return;
      }
      if (startsWith(paramBuffer, (byte)34)) {
        str1 = readQuotedString(paramBuffer);
      } else {
        str1 = readToken(paramBuffer);
      }
      if (str1 == null) {
        return;
      }
      if ((String)localMap.put(localObject1, str1) != null) {
        return;
      }
      if ((!skipCommasAndWhitespace(paramBuffer)) && (!paramBuffer.exhausted())) {
        return;
      }
      str1 = str2;
    }
  }
  
  private static final String readQuotedString(Buffer paramBuffer)
    throws EOFException
  {
    int i = paramBuffer.readByte();
    int j = (byte)34;
    if (i == j) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      Buffer localBuffer = new Buffer();
      for (;;)
      {
        long l = paramBuffer.indexOfElement(QUOTED_STRING_DELIMITERS);
        if (l == -1L) {
          return null;
        }
        if (paramBuffer.getByte(l) == j)
        {
          localBuffer.write(paramBuffer, l);
          paramBuffer.readByte();
          return localBuffer.readUtf8();
        }
        if (paramBuffer.size() == l + 1L) {
          return null;
        }
        localBuffer.write(paramBuffer, l);
        paramBuffer.readByte();
        localBuffer.write(paramBuffer, 1L);
      }
    }
    throw ((Throwable)new IllegalArgumentException("Failed requirement.".toString()));
  }
  
  private static final String readToken(Buffer paramBuffer)
  {
    long l2 = paramBuffer.indexOfElement(TOKEN_DELIMITERS);
    long l1 = l2;
    if (l2 == -1L) {
      l1 = paramBuffer.size();
    }
    if (l1 != 0L) {
      return paramBuffer.readUtf8(l1);
    }
    return null;
  }
  
  public static final void receiveHeaders(CookieJar paramCookieJar, HttpUrl paramHttpUrl, Headers paramHeaders)
  {
    Intrinsics.checkParameterIsNotNull(paramCookieJar, "$this$receiveHeaders");
    Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
    Intrinsics.checkParameterIsNotNull(paramHeaders, "headers");
    if (paramCookieJar == CookieJar.NO_COOKIES) {
      return;
    }
    paramHeaders = Cookie.Companion.parseAll(paramHttpUrl, paramHeaders);
    if (paramHeaders.isEmpty()) {
      return;
    }
    paramCookieJar.saveFromResponse(paramHttpUrl, paramHeaders);
  }
  
  private static final boolean skipCommasAndWhitespace(Buffer paramBuffer)
  {
    boolean bool = false;
    while (!paramBuffer.exhausted())
    {
      int i = paramBuffer.getByte(0L);
      if ((i != 9) && (i != 32))
      {
        if (i != 44) {
          return bool;
        }
        paramBuffer.readByte();
        bool = true;
      }
      else
      {
        paramBuffer.readByte();
      }
    }
    return bool;
  }
  
  private static final boolean startsWith(Buffer paramBuffer, byte paramByte)
  {
    return (!paramBuffer.exhausted()) && (paramBuffer.getByte(0L) == paramByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\http\HttpHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */