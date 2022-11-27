package okhttp3.internal.platform.android;

import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.ConscryptPlatform;
import okhttp3.internal.platform.ConscryptPlatform.Companion;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;
import org.conscrypt.Conscrypt;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\000 \0252\0020\001:\001\025B\005¢\006\002\020\002J(\020\003\032\0020\0042\006\020\005\032\0020\0062\b\020\007\032\004\030\0010\b2\f\020\t\032\b\022\004\022\0020\0130\nH\026J\022\020\f\032\004\030\0010\b2\006\020\005\032\0020\006H\026J\b\020\r\032\0020\016H\026J\020\020\017\032\0020\0162\006\020\005\032\0020\006H\026J\020\020\020\032\0020\0162\006\020\021\032\0020\022H\026J\022\020\023\032\004\030\0010\0242\006\020\021\032\0020\022H\026¨\006\026"}, d2={"Lokhttp3/internal/platform/android/ConscryptSocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "matchesSocketFactory", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class ConscryptSocketAdapter
  implements SocketAdapter
{
  public static final Companion Companion = new Companion(null);
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<? extends Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    if (matchesSocket(paramSSLSocket))
    {
      Conscrypt.setUseSessionTickets(paramSSLSocket, true);
      paramString = ((Collection)Platform.Companion.alpnProtocolNames(paramList)).toArray(new String[0]);
      if (paramString != null)
      {
        Conscrypt.setApplicationProtocols(paramSSLSocket, (String[])paramString);
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    if (matchesSocket(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return null;
  }
  
  public boolean isSupported()
  {
    return ConscryptPlatform.Companion.isSupported();
  }
  
  public boolean matchesSocket(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    return Conscrypt.isConscrypt(paramSSLSocket);
  }
  
  public boolean matchesSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    return false;
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    return null;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\022\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\003\032\004\030\0010\004¨\006\005"}, d2={"Lokhttp3/internal/platform/android/ConscryptSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final SocketAdapter buildIfSupported()
    {
      if (ConscryptPlatform.Companion.isSupported()) {
        return (SocketAdapter)new ConscryptSocketAdapter();
      }
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\ConscryptSocketAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */