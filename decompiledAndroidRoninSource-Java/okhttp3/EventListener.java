package okhttp3;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={"\000|\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\003\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\n\002\020\t\n\002\b\004\n\002\030\002\n\002\b\006\n\002\030\002\n\002\b\003\n\002\030\002\n\002\b\004\b&\030\000 :2\0020\001:\002:;B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026J\030\020\007\032\0020\0042\006\020\005\032\0020\0062\006\020\b\032\0020\tH\026J\020\020\n\032\0020\0042\006\020\005\032\0020\006H\026J\020\020\013\032\0020\0042\006\020\005\032\0020\006H\026J*\020\f\032\0020\0042\006\020\005\032\0020\0062\006\020\r\032\0020\0162\006\020\017\032\0020\0202\b\020\021\032\004\030\0010\022H\026J2\020\023\032\0020\0042\006\020\005\032\0020\0062\006\020\r\032\0020\0162\006\020\017\032\0020\0202\b\020\021\032\004\030\0010\0222\006\020\b\032\0020\tH\026J \020\024\032\0020\0042\006\020\005\032\0020\0062\006\020\r\032\0020\0162\006\020\017\032\0020\020H\026J\030\020\025\032\0020\0042\006\020\005\032\0020\0062\006\020\026\032\0020\027H\026J\030\020\030\032\0020\0042\006\020\005\032\0020\0062\006\020\026\032\0020\027H\026J+\020\031\032\0020\0042\006\020\005\032\0020\0062\006\020\032\032\0020\0332\021\020\034\032\r\022\t\022\0070\036¢\006\002\b\0370\035H\026J\030\020 \032\0020\0042\006\020\005\032\0020\0062\006\020\032\032\0020\033H\026J+\020!\032\0020\0042\006\020\005\032\0020\0062\006\020\"\032\0020#2\021\020$\032\r\022\t\022\0070\020¢\006\002\b\0370\035H\026J\030\020%\032\0020\0042\006\020\005\032\0020\0062\006\020\"\032\0020#H\026J\030\020&\032\0020\0042\006\020\005\032\0020\0062\006\020'\032\0020(H\026J\020\020)\032\0020\0042\006\020\005\032\0020\006H\026J\030\020*\032\0020\0042\006\020\005\032\0020\0062\006\020\b\032\0020\tH\026J\030\020+\032\0020\0042\006\020\005\032\0020\0062\006\020,\032\0020-H\026J\020\020.\032\0020\0042\006\020\005\032\0020\006H\026J\030\020/\032\0020\0042\006\020\005\032\0020\0062\006\020'\032\0020(H\026J\020\0200\032\0020\0042\006\020\005\032\0020\006H\026J\030\0201\032\0020\0042\006\020\005\032\0020\0062\006\020\b\032\0020\tH\026J\030\0202\032\0020\0042\006\020\005\032\0020\0062\006\0203\032\00204H\026J\020\0205\032\0020\0042\006\020\005\032\0020\006H\026J\032\0206\032\0020\0042\006\020\005\032\0020\0062\b\0207\032\004\030\00108H\026J\020\0209\032\0020\0042\006\020\005\032\0020\006H\026¨\006<"}, d2={"Lokhttp3/EventListener;", "", "()V", "callEnd", "", "call", "Lokhttp3/Call;", "callFailed", "ioe", "Ljava/io/IOException;", "callStart", "canceled", "connectEnd", "inetSocketAddress", "Ljava/net/InetSocketAddress;", "proxy", "Ljava/net/Proxy;", "protocol", "Lokhttp3/Protocol;", "connectFailed", "connectStart", "connectionAcquired", "connection", "Lokhttp3/Connection;", "connectionReleased", "dnsEnd", "domainName", "", "inetAddressList", "", "Ljava/net/InetAddress;", "Lkotlin/jvm/JvmSuppressWildcards;", "dnsStart", "proxySelectEnd", "url", "Lokhttp3/HttpUrl;", "proxies", "proxySelectStart", "requestBodyEnd", "byteCount", "", "requestBodyStart", "requestFailed", "requestHeadersEnd", "request", "Lokhttp3/Request;", "requestHeadersStart", "responseBodyEnd", "responseBodyStart", "responseFailed", "responseHeadersEnd", "response", "Lokhttp3/Response;", "responseHeadersStart", "secureConnectEnd", "handshake", "Lokhttp3/Handshake;", "secureConnectStart", "Companion", "Factory", "okhttp"}, k=1, mv={1, 1, 16})
public abstract class EventListener
{
  public static final Companion Companion = new Companion(null);
  public static final EventListener NONE = (EventListener)new EventListener.Companion.NONE.1();
  
  public void callEnd(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void callFailed(Call paramCall, IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramIOException, "ioe");
  }
  
  public void callStart(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void canceled(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void connectEnd(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, Protocol paramProtocol)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramInetSocketAddress, "inetSocketAddress");
    Intrinsics.checkParameterIsNotNull(paramProxy, "proxy");
  }
  
  public void connectFailed(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy, Protocol paramProtocol, IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramInetSocketAddress, "inetSocketAddress");
    Intrinsics.checkParameterIsNotNull(paramProxy, "proxy");
    Intrinsics.checkParameterIsNotNull(paramIOException, "ioe");
  }
  
  public void connectStart(Call paramCall, InetSocketAddress paramInetSocketAddress, Proxy paramProxy)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramInetSocketAddress, "inetSocketAddress");
    Intrinsics.checkParameterIsNotNull(paramProxy, "proxy");
  }
  
  public void connectionAcquired(Call paramCall, Connection paramConnection)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramConnection, "connection");
  }
  
  public void connectionReleased(Call paramCall, Connection paramConnection)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramConnection, "connection");
  }
  
  public void dnsEnd(Call paramCall, String paramString, List<InetAddress> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramString, "domainName");
    Intrinsics.checkParameterIsNotNull(paramList, "inetAddressList");
  }
  
  public void dnsStart(Call paramCall, String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramString, "domainName");
  }
  
  public void proxySelectEnd(Call paramCall, HttpUrl paramHttpUrl, List<Proxy> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
    Intrinsics.checkParameterIsNotNull(paramList, "proxies");
  }
  
  public void proxySelectStart(Call paramCall, HttpUrl paramHttpUrl)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramHttpUrl, "url");
  }
  
  public void requestBodyEnd(Call paramCall, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void requestBodyStart(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void requestFailed(Call paramCall, IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramIOException, "ioe");
  }
  
  public void requestHeadersEnd(Call paramCall, Request paramRequest)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramRequest, "request");
  }
  
  public void requestHeadersStart(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void responseBodyEnd(Call paramCall, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void responseBodyStart(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void responseFailed(Call paramCall, IOException paramIOException)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramIOException, "ioe");
  }
  
  public void responseHeadersEnd(Call paramCall, Response paramResponse)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
    Intrinsics.checkParameterIsNotNull(paramResponse, "response");
  }
  
  public void responseHeadersStart(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void secureConnectEnd(Call paramCall, Handshake paramHandshake)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  public void secureConnectStart(Call paramCall)
  {
    Intrinsics.checkParameterIsNotNull(paramCall, "call");
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002R\020\020\003\032\0020\0048\006X\004¢\006\002\n\000¨\006\005"}, d2={"Lokhttp3/EventListener$Companion;", "", "()V", "NONE", "Lokhttp3/EventListener;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion {}
  
  @Metadata(bv={1, 0, 3}, d1={"\000\026\n\002\030\002\n\002\020\000\n\000\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J\020\020\002\032\0020\0032\006\020\004\032\0020\005H&¨\006\006"}, d2={"Lokhttp3/EventListener$Factory;", "", "create", "Lokhttp3/EventListener;", "call", "Lokhttp3/Call;", "okhttp"}, k=1, mv={1, 1, 16})
  public static abstract interface Factory
  {
    public abstract EventListener create(Call paramCall);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\EventListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */