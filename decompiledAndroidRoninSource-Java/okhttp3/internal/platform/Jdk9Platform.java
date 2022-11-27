package okhttp3.internal.platform;

import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\002\b\002\b\026\030\000 \0222\0020\001:\001\022B\005¢\006\002\020\002J-\020\003\032\0020\0042\006\020\005\032\0020\0062\b\020\007\032\004\030\0010\b2\021\020\t\032\r\022\t\022\0070\013¢\006\002\b\f0\nH\026J\022\020\r\032\004\030\0010\b2\006\020\005\032\0020\006H\026J\022\020\016\032\004\030\0010\0172\006\020\020\032\0020\021H\026¨\006\023"}, d2={"Lokhttp3/internal/platform/Jdk9Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "getSelectedProtocol", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public class Jdk9Platform
  extends Platform
{
  public static final Companion Companion = new Companion(null);
  private static final boolean isAvailable;
  
  static
  {
    Integer localInteger = Integer.getInteger("java.specification.version");
    int i;
    if (localInteger != null) {
      i = localInteger.intValue();
    } else {
      i = 8;
    }
    boolean bool;
    if (i >= 9) {
      bool = true;
    } else {
      bool = false;
    }
    isAvailable = bool;
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    paramString = paramSSLSocket.getSSLParameters();
    paramList = Platform.Companion.alpnProtocolNames(paramList);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "sslParameters");
    paramList = ((Collection)paramList).toArray(new String[0]);
    if (paramList != null)
    {
      paramString.setApplicationProtocols((String[])paramList);
      paramSSLSocket.setSSLParameters(paramString);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    String str = paramSSLSocket.getApplicationProtocol();
    if (str != null)
    {
      paramSSLSocket = str;
      if (!Intrinsics.areEqual(str, "")) {}
    }
    else
    {
      paramSSLSocket = null;
    }
    return paramSSLSocket;
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    throw ((Throwable)new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on JDK 9+"));
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\006\032\004\030\0010\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\003\020\005¨\006\b"}, d2={"Lokhttp3/internal/platform/Jdk9Platform$Companion;", "", "()V", "isAvailable", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Jdk9Platform;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Jdk9Platform buildIfSupported()
    {
      if (((Companion)this).isAvailable()) {
        return new Jdk9Platform();
      }
      return null;
    }
    
    public final boolean isAvailable()
    {
      return Jdk9Platform.access$isAvailable$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\Jdk9Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */