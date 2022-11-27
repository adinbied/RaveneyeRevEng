package okhttp3.internal.platform.android;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv={1, 0, 3}, d1={"\000>\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\000\n\002\020\000\n\000\n\002\020\b\n\002\b\002\b\000\030\000 \0232\0020\001:\001\023B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J$\020\007\032\b\022\004\022\0020\t0\b2\f\020\n\032\b\022\004\022\0020\t0\b2\006\020\013\032\0020\fH\026J\023\020\r\032\0020\0162\b\020\017\032\004\030\0010\020H\002J\b\020\021\032\0020\022H\026R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006\024"}, d2={"Lokhttp3/internal/platform/android/Android10CertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerExtensions", "Landroid/net/http/X509TrustManagerExtensions;", "(Ljavax/net/ssl/X509TrustManager;Landroid/net/http/X509TrustManagerExtensions;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "", "hashCode", "", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Android10CertificateChainCleaner
  extends CertificateChainCleaner
{
  public static final Companion Companion = new Companion(null);
  private final X509TrustManager trustManager;
  private final X509TrustManagerExtensions x509TrustManagerExtensions;
  
  public Android10CertificateChainCleaner(X509TrustManager paramX509TrustManager, X509TrustManagerExtensions paramX509TrustManagerExtensions)
  {
    this.trustManager = paramX509TrustManager;
    this.x509TrustManagerExtensions = paramX509TrustManagerExtensions;
  }
  
  public List<Certificate> clean(List<? extends Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "chain");
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    paramList = ((Collection)paramList).toArray(new X509Certificate[0]);
    if (paramList != null)
    {
      paramList = (X509Certificate[])paramList;
      try
      {
        paramList = this.x509TrustManagerExtensions.checkServerTrusted(paramList, "RSA", paramString);
        Intrinsics.checkExpressionValueIsNotNull(paramList, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
        return paramList;
      }
      catch (CertificateException paramList)
      {
        paramString = new SSLPeerUnverifiedException(paramList.getMessage());
        paramString.initCause((Throwable)paramList);
        throw ((Throwable)paramString);
      }
    }
    throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof Android10CertificateChainCleaner)) && (((Android10CertificateChainCleaner)paramObject).trustManager == this.trustManager);
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.trustManager);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\004\030\0010\0042\006\020\005\032\0020\006¨\006\007"}, d2={"Lokhttp3/internal/platform/android/Android10CertificateChainCleaner$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/Android10CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Android10CertificateChainCleaner buildIfSupported(X509TrustManager paramX509TrustManager)
    {
      Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
      Android10CertificateChainCleaner localAndroid10CertificateChainCleaner = null;
      try
      {
        localX509TrustManagerExtensions = new X509TrustManagerExtensions(paramX509TrustManager);
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        X509TrustManagerExtensions localX509TrustManagerExtensions;
        for (;;) {}
      }
      localX509TrustManagerExtensions = null;
      if (localX509TrustManagerExtensions != null) {
        localAndroid10CertificateChainCleaner = new Android10CertificateChainCleaner(paramX509TrustManager, localX509TrustManagerExtensions);
      }
      return localAndroid10CertificateChainCleaner;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\Android10CertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */