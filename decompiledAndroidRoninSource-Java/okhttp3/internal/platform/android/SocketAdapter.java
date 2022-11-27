package okhttp3.internal.platform.android;

import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import okhttp3.Protocol;

@Metadata(bv={1, 0, 3}, d1={"\000<\n\002\030\002\n\002\020\000\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\bf\030\0002\0020\001J(\020\002\032\0020\0032\006\020\004\032\0020\0052\b\020\006\032\004\030\0010\0072\f\020\b\032\b\022\004\022\0020\n0\tH&J\022\020\013\032\004\030\0010\0072\006\020\004\032\0020\005H&J\b\020\f\032\0020\rH&J\020\020\016\032\0020\r2\006\020\004\032\0020\005H&J\020\020\017\032\0020\r2\006\020\020\032\0020\021H&J\022\020\022\032\004\030\0010\0232\006\020\020\032\0020\021H&¨\006\024"}, d2={"Lokhttp3/internal/platform/android/SocketAdapter;", "", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "getSelectedProtocol", "isSupported", "", "matchesSocket", "matchesSocketFactory", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k=1, mv={1, 1, 16})
public abstract interface SocketAdapter
{
  public abstract void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<? extends Protocol> paramList);
  
  public abstract String getSelectedProtocol(SSLSocket paramSSLSocket);
  
  public abstract boolean isSupported();
  
  public abstract boolean matchesSocket(SSLSocket paramSSLSocket);
  
  public abstract boolean matchesSocketFactory(SSLSocketFactory paramSSLSocketFactory);
  
  public abstract X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\SocketAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */