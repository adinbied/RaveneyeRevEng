package okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.platform.Platform.Companion;

@Metadata(bv={1, 0, 3}, d1={"\000 \n\002\030\002\n\002\020\000\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\016\n\002\b\002\b&\030\000 \t2\0020\001:\001\tB\005¢\006\002\020\002J$\020\003\032\b\022\004\022\0020\0050\0042\f\020\006\032\b\022\004\022\0020\0050\0042\006\020\007\032\0020\bH&¨\006\n"}, d2={"Lokhttp3/internal/tls/CertificateChainCleaner;", "", "()V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public abstract class CertificateChainCleaner
{
  public static final Companion Companion = new Companion(null);
  
  public abstract List<Certificate> clean(List<? extends Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException;
  
  @Metadata(bv={1, 0, 3}, d1={"\000$\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\021\n\002\030\002\n\002\b\002\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\016\020\003\032\0020\0042\006\020\005\032\0020\006J\037\020\003\032\0020\0042\022\020\007\032\n\022\006\b\001\022\0020\t0\b\"\0020\t¢\006\002\020\n¨\006\013"}, d2={"Lokhttp3/internal/tls/CertificateChainCleaner$Companion;", "", "()V", "get", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "caCerts", "", "Ljava/security/cert/X509Certificate;", "([Ljava/security/cert/X509Certificate;)Lokhttp3/internal/tls/CertificateChainCleaner;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final CertificateChainCleaner get(X509TrustManager paramX509TrustManager)
    {
      Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
      return Platform.Companion.get().buildCertificateChainCleaner(paramX509TrustManager);
    }
    
    public final CertificateChainCleaner get(X509Certificate... paramVarArgs)
    {
      Intrinsics.checkParameterIsNotNull(paramVarArgs, "caCerts");
      return (CertificateChainCleaner)new BasicCertificateChainCleaner((TrustRootIndex)new BasicTrustRootIndex((X509Certificate[])Arrays.copyOf(paramVarArgs, paramVarArgs.length)));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\tls\CertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */