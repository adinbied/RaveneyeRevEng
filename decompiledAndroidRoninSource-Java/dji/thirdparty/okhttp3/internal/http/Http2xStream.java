package dji.thirdparty.okhttp3.internal.http;

import dji.thirdparty.okhttp3.Headers;
import dji.thirdparty.okhttp3.Headers.Builder;
import dji.thirdparty.okhttp3.HttpUrl;
import dji.thirdparty.okhttp3.Protocol;
import dji.thirdparty.okhttp3.Request;
import dji.thirdparty.okhttp3.Response;
import dji.thirdparty.okhttp3.Response.Builder;
import dji.thirdparty.okhttp3.ResponseBody;
import dji.thirdparty.okhttp3.internal.Util;
import dji.thirdparty.okhttp3.internal.framed.FramedConnection;
import dji.thirdparty.okhttp3.internal.framed.FramedStream;
import dji.thirdparty.okhttp3.internal.framed.Header;
import dji.thirdparty.okio.ByteString;
import dji.thirdparty.okio.ForwardingSource;
import dji.thirdparty.okio.Sink;
import dji.thirdparty.okio.Source;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class Http2xStream
  implements HttpStream
{
  private static final ByteString CONNECTION = ByteString.encodeUtf8("connection");
  private static final ByteString ENCODING;
  private static final ByteString HOST = ByteString.encodeUtf8("host");
  private static final List<ByteString> HTTP_2_SKIPPED_REQUEST_HEADERS = Util.immutableList(new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION });
  private static final List<ByteString> HTTP_2_SKIPPED_RESPONSE_HEADERS = Util.immutableList(new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TE, TRANSFER_ENCODING, ENCODING, UPGRADE });
  private static final ByteString KEEP_ALIVE = ByteString.encodeUtf8("keep-alive");
  private static final ByteString PROXY_CONNECTION = ByteString.encodeUtf8("proxy-connection");
  private static final List<ByteString> SPDY_3_SKIPPED_REQUEST_HEADERS;
  private static final List<ByteString> SPDY_3_SKIPPED_RESPONSE_HEADERS;
  private static final ByteString TE;
  private static final ByteString TRANSFER_ENCODING = ByteString.encodeUtf8("transfer-encoding");
  private static final ByteString UPGRADE;
  private final FramedConnection framedConnection;
  private HttpEngine httpEngine;
  private FramedStream stream;
  private final StreamAllocation streamAllocation;
  
  static
  {
    TE = ByteString.encodeUtf8("te");
    ENCODING = ByteString.encodeUtf8("encoding");
    UPGRADE = ByteString.encodeUtf8("upgrade");
    SPDY_3_SKIPPED_REQUEST_HEADERS = Util.immutableList(new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING, Header.TARGET_METHOD, Header.TARGET_PATH, Header.TARGET_SCHEME, Header.TARGET_AUTHORITY, Header.TARGET_HOST, Header.VERSION });
    SPDY_3_SKIPPED_RESPONSE_HEADERS = Util.immutableList(new ByteString[] { CONNECTION, HOST, KEEP_ALIVE, PROXY_CONNECTION, TRANSFER_ENCODING });
  }
  
  public Http2xStream(StreamAllocation paramStreamAllocation, FramedConnection paramFramedConnection)
  {
    this.streamAllocation = paramStreamAllocation;
    this.framedConnection = paramFramedConnection;
  }
  
  public static List<Header> http2HeadersList(Request paramRequest)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(localHeaders.size() + 4);
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    ByteString localByteString = Header.TARGET_AUTHORITY;
    HttpUrl localHttpUrl = paramRequest.url();
    int i = 0;
    localArrayList.add(new Header(localByteString, Util.hostHeader(localHttpUrl, false)));
    localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    int j = localHeaders.size();
    while (i < j)
    {
      paramRequest = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      if (!HTTP_2_SKIPPED_REQUEST_HEADERS.contains(paramRequest)) {
        localArrayList.add(new Header(paramRequest, localHeaders.value(i)));
      }
      i += 1;
    }
    return localArrayList;
  }
  
  private static String joinOnNull(String paramString1, String paramString2)
  {
    paramString1 = new StringBuilder(paramString1);
    paramString1.append('\000');
    paramString1.append(paramString2);
    return paramString1.toString();
  }
  
  public static Response.Builder readHttp2HeadersList(List<Header> paramList)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int j = paramList.size();
    Object localObject1 = null;
    int i = 0;
    while (i < j)
    {
      ByteString localByteString = ((Header)paramList.get(i)).name;
      String str = ((Header)paramList.get(i)).value.utf8();
      Object localObject2;
      if (localByteString.equals(Header.RESPONSE_STATUS))
      {
        localObject2 = str;
      }
      else
      {
        localObject2 = localObject1;
        if (!HTTP_2_SKIPPED_RESPONSE_HEADERS.contains(localByteString))
        {
          localBuilder.add(localByteString.utf8(), str);
          localObject2 = localObject1;
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (localObject1 != null)
    {
      paramList = new StringBuilder();
      paramList.append("HTTP/1.1 ");
      paramList.append((String)localObject1);
      paramList = StatusLine.parse(paramList.toString());
      return new Response.Builder().protocol(Protocol.HTTP_2).code(paramList.code).message(paramList.message).headers(localBuilder.build());
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static Response.Builder readSpdy3HeadersList(List<Header> paramList)
    throws IOException
  {
    Headers.Builder localBuilder = new Headers.Builder();
    int n = paramList.size();
    Object localObject2 = null;
    Object localObject1 = "HTTP/1.1";
    int i = 0;
    while (i < n)
    {
      ByteString localByteString = ((Header)paramList.get(i)).name;
      String str2 = ((Header)paramList.get(i)).value.utf8();
      int j = 0;
      while (j < str2.length())
      {
        int m = str2.indexOf(0, j);
        int k = m;
        if (m == -1) {
          k = str2.length();
        }
        String str1 = str2.substring(j, k);
        Object localObject3;
        Object localObject4;
        if (localByteString.equals(Header.RESPONSE_STATUS))
        {
          localObject3 = str1;
          localObject4 = localObject1;
        }
        else if (localByteString.equals(Header.VERSION))
        {
          localObject3 = localObject2;
          localObject4 = str1;
        }
        else
        {
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (!SPDY_3_SKIPPED_RESPONSE_HEADERS.contains(localByteString))
          {
            localBuilder.add(localByteString.utf8(), str1);
            localObject4 = localObject1;
            localObject3 = localObject2;
          }
        }
        j = k + 1;
        localObject2 = localObject3;
        localObject1 = localObject4;
      }
      i += 1;
    }
    if (localObject2 != null)
    {
      paramList = new StringBuilder();
      paramList.append((String)localObject1);
      paramList.append(" ");
      paramList.append((String)localObject2);
      paramList = StatusLine.parse(paramList.toString());
      return new Response.Builder().protocol(Protocol.SPDY_3).code(paramList.code).message(paramList.message).headers(localBuilder.build());
    }
    throw new ProtocolException("Expected ':status' header not present");
  }
  
  public static List<Header> spdy3HeadersList(Request paramRequest)
  {
    Headers localHeaders = paramRequest.headers();
    ArrayList localArrayList = new ArrayList(localHeaders.size() + 5);
    localArrayList.add(new Header(Header.TARGET_METHOD, paramRequest.method()));
    localArrayList.add(new Header(Header.TARGET_PATH, RequestLine.requestPath(paramRequest.url())));
    localArrayList.add(new Header(Header.VERSION, "HTTP/1.1"));
    localArrayList.add(new Header(Header.TARGET_HOST, Util.hostHeader(paramRequest.url(), false)));
    localArrayList.add(new Header(Header.TARGET_SCHEME, paramRequest.url().scheme()));
    paramRequest = new LinkedHashSet();
    int k = localHeaders.size();
    int i = 0;
    while (i < k)
    {
      ByteString localByteString = ByteString.encodeUtf8(localHeaders.name(i).toLowerCase(Locale.US));
      if (!SPDY_3_SKIPPED_REQUEST_HEADERS.contains(localByteString))
      {
        String str = localHeaders.value(i);
        if (paramRequest.add(localByteString))
        {
          localArrayList.add(new Header(localByteString, str));
        }
        else
        {
          int j = 0;
          while (j < localArrayList.size())
          {
            if (((Header)localArrayList.get(j)).name.equals(localByteString))
            {
              localArrayList.set(j, new Header(localByteString, joinOnNull(((Header)localArrayList.get(j)).value.utf8(), str)));
              break;
            }
            j += 1;
          }
        }
      }
      i += 1;
    }
    return localArrayList;
  }
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Sink createRequestBody(Request paramRequest, long paramLong)
    throws IOException
  {
    return this.stream.getSink();
  }
  
  /* Error */
  public void finishRequest()
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public ResponseBody openResponseBody(Response paramResponse)
    throws IOException
  {
    return null;
  }
  
  public Response.Builder readResponseHeaders()
    throws IOException
  {
    return null;
  }
  
  public void setHttpEngine(HttpEngine paramHttpEngine)
  {
    this.httpEngine = paramHttpEngine;
  }
  
  /* Error */
  public void writeRequestBody(RetryableSink arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void writeRequestHeaders(Request arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  class StreamFinishingSource
    extends ForwardingSource
  {
    public StreamFinishingSource(Source paramSource)
    {
      super();
    }
    
    /* Error */
    public void close()
      throws IOException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\http\Http2xStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */