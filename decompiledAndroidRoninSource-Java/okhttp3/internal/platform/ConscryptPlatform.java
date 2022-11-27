package okhttp3.internal.platform;

import java.security.Provider;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import org.conscrypt.Conscrypt;
import org.conscrypt.Conscrypt.ProviderBuilder;
import org.conscrypt.Conscrypt.Version;
import org.conscrypt.ConscryptHostnameVerifier;

@Metadata(bv={1, 0, 3}, d1={"\000L\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\002\n\002\030\002\n\002\b\004\030\000 \0322\0020\001:\001\032B\007\b\002¢\006\002\020\002J\020\020\005\032\0020\0062\006\020\007\032\0020\bH\026J-\020\t\032\0020\0062\006\020\n\032\0020\0132\b\020\f\032\004\030\0010\r2\021\020\016\032\r\022\t\022\0070\020¢\006\002\b\0210\017H\026J\022\020\022\032\0020\0062\b\020\023\032\004\030\0010\024H\026J\022\020\025\032\004\030\0010\r2\006\020\n\032\0020\013H\026J\b\020\026\032\0020\027H\026J\b\020\030\032\0020\024H\026J\022\020\023\032\004\030\0010\0242\006\020\031\032\0020\bH\026R\016\020\003\032\0020\004X\004¢\006\002\n\000¨\006\033"}, d2={"Lokhttp3/internal/platform/ConscryptPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "provider", "Ljava/security/Provider;", "configureSslSocketFactory", "", "socketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "configureTlsExtensions", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "configureTrustManager", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "getSelectedProtocol", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "sslSocketFactory", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class ConscryptPlatform
  extends Platform
{
  public static final Companion Companion = new Companion(null);
  private static final boolean isSupported;
  private final Provider provider;
  
  static
  {
    bool2 = false;
    try
    {
      Class.forName("org.conscrypt.Conscrypt$Version");
      bool1 = bool2;
      if (Conscrypt.isAvailable())
      {
        boolean bool3 = Companion.atLeastVersion(2, 1, 0);
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
    }
    catch (NoClassDefFoundError|ClassNotFoundException localNoClassDefFoundError)
    {
      for (;;)
      {
        boolean bool1 = bool2;
      }
    }
    isSupported = bool1;
  }
  
  private ConscryptPlatform()
  {
    Provider localProvider = Conscrypt.newProviderBuilder().provideTrustManager(true).build();
    Intrinsics.checkExpressionValueIsNotNull(localProvider, "Conscrypt.newProviderBui…rustManager(true).build()");
    this.provider = localProvider;
  }
  
  public void configureSslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "socketFactory");
    if (Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      Conscrypt.setUseEngineSocket(paramSSLSocketFactory, true);
    }
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    if (Conscrypt.isConscrypt(paramSSLSocket))
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
    super.configureTlsExtensions(paramSSLSocket, paramString, paramList);
  }
  
  public void configureTrustManager(X509TrustManager paramX509TrustManager)
  {
    paramX509TrustManager = (TrustManager)paramX509TrustManager;
    if (Conscrypt.isConscrypt(paramX509TrustManager)) {
      Conscrypt.setHostnameVerifier(paramX509TrustManager, (ConscryptHostnameVerifier)configureTrustManager.1.INSTANCE);
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    if (Conscrypt.isConscrypt(paramSSLSocket)) {
      return Conscrypt.getApplicationProtocol(paramSSLSocket);
    }
    return super.getSelectedProtocol(paramSSLSocket);
  }
  
  public SSLContext newSSLContext()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS", this.provider);
    Intrinsics.checkExpressionValueIsNotNull(localSSLContext, "SSLContext.getInstance(\"TLS\", provider)");
    return localSSLContext;
  }
  
  public X509TrustManager platformTrustManager()
  {
    X509TrustManager localX509TrustManager = Conscrypt.getDefaultX509TrustManager();
    Intrinsics.checkExpressionValueIsNotNull(localX509TrustManager, "Conscrypt.getDefaultX509TrustManager()");
    return localX509TrustManager;
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    if (!Conscrypt.isConscrypt(paramSSLSocketFactory)) {
      return super.trustManager(paramSSLSocketFactory);
    }
    try
    {
      paramSSLSocketFactory = Util.readFieldOrNull(paramSSLSocketFactory, Object.class, "sslParameters");
      if (paramSSLSocketFactory != null)
      {
        paramSSLSocketFactory = (X509TrustManager)Util.readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
        return paramSSLSocketFactory;
      }
      return null;
    }
    catch (Exception paramSSLSocketFactory)
    {
      throw ((Throwable)new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported on Conscrypt", (Throwable)paramSSLSocketFactory));
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\"\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\b\n\002\b\003\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\"\020\006\032\0020\0042\006\020\007\032\0020\b2\b\b\002\020\t\032\0020\b2\b\b\002\020\n\032\0020\bJ\b\020\013\032\004\030\0010\fR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\003\020\005¨\006\r"}, d2={"Lokhttp3/internal/platform/ConscryptPlatform$Companion;", "", "()V", "isSupported", "", "()Z", "atLeastVersion", "major", "", "minor", "patch", "buildIfSupported", "Lokhttp3/internal/platform/ConscryptPlatform;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final boolean atLeastVersion(int paramInt1, int paramInt2, int paramInt3)
    {
      Conscrypt.Version localVersion = Conscrypt.version();
      if (localVersion.major() != paramInt1) {
        return localVersion.major() > paramInt1;
      }
      if (localVersion.minor() != paramInt2) {
        return localVersion.minor() > paramInt2;
      }
      return localVersion.patch() >= paramInt3;
    }
    
    public final ConscryptPlatform buildIfSupported()
    {
      boolean bool = ((Companion)this).isSupported();
      ConscryptPlatform localConscryptPlatform = null;
      if (bool) {
        localConscryptPlatform = new ConscryptPlatform(null);
      }
      return localConscryptPlatform;
    }
    
    public final boolean isSupported()
    {
      return ConscryptPlatform.access$isSupported$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\ConscryptPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */