package okhttp3.internal.platform.android;

import android.net.SSLCertificateSocketFactory;
import android.os.Build.VERSION;
import java.net.Socket;
import java.util.Collection;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Protocol;
import okhttp3.internal.platform.AndroidPlatform;
import okhttp3.internal.platform.AndroidPlatform.Companion;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

@Metadata(bv={1, 0, 3}, d1={"\000F\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\002\b\002\030\000 \0272\0020\001:\001\027B\005¢\006\002\020\002J(\020\005\032\0020\0062\006\020\007\032\0020\b2\b\020\t\032\004\030\0010\n2\f\020\013\032\b\022\004\022\0020\r0\fH\026J\022\020\016\032\004\030\0010\n2\006\020\007\032\0020\bH\026J\b\020\017\032\0020\020H\026J\020\020\021\032\0020\0202\006\020\007\032\0020\bH\026J\020\020\022\032\0020\0202\006\020\023\032\0020\024H\026J\022\020\025\032\004\030\0010\0262\006\020\023\032\0020\024H\026R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\030"}, d2={"Lokhttp3/internal/platform/android/Android10SocketAdapter;", "Lokhttp3/internal/platform/android/SocketAdapter;", "()V", "socketFactory", "Landroid/net/SSLCertificateSocketFactory;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "matchesSocketFactory", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Android10SocketAdapter
  implements SocketAdapter
{
  public static final Companion Companion = new Companion(null);
  private final SSLCertificateSocketFactory socketFactory;
  
  public Android10SocketAdapter()
  {
    SocketFactory localSocketFactory = SSLCertificateSocketFactory.getDefault(10000);
    if (localSocketFactory != null)
    {
      this.socketFactory = ((SSLCertificateSocketFactory)localSocketFactory);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.net.SSLCertificateSocketFactory");
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<? extends Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    this.socketFactory.setUseSessionTickets((Socket)paramSSLSocket, true);
    paramString = paramSSLSocket.getSSLParameters();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "sslParameters");
    paramList = ((Collection)Platform.Companion.alpnProtocolNames(paramList)).toArray(new String[0]);
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
  
  public boolean isSupported()
  {
    return Companion.isSupported();
  }
  
  public boolean matchesSocket(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    paramSSLSocket = paramSSLSocket.getClass().getName();
    Intrinsics.checkExpressionValueIsNotNull(paramSSLSocket, "sslSocket.javaClass.name");
    return StringsKt.startsWith$default(paramSSLSocket, "com.android.org.conscrypt", false, 2, null);
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
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\013\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\003\032\004\030\0010\004J\006\020\005\032\0020\006¨\006\007"}, d2={"Lokhttp3/internal/platform/android/Android10SocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "isSupported", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final SocketAdapter buildIfSupported()
    {
      if (((Companion)this).isSupported()) {
        return (SocketAdapter)new Android10SocketAdapter();
      }
      return null;
    }
    
    public final boolean isSupported()
    {
      return (AndroidPlatform.Companion.isAndroid()) && (Build.VERSION.SDK_INT >= 29);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\Android10SocketAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */