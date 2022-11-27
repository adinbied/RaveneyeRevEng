package okhttp3.internal.platform;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.KeyStore;
import java.security.Provider;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.internal.Util;
import okhttp3.internal.tls.BasicCertificateChainCleaner;
import okhttp3.internal.tls.BasicTrustRootIndex;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;
import okio.Buffer;

@Metadata(bv={1, 0, 3}, d1={"\000t\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\004\n\002\020\016\n\000\n\002\020 \n\002\030\002\n\002\030\002\n\002\b\003\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\005\n\002\020\013\n\002\b\004\n\002\020\003\n\002\b\003\n\002\030\002\n\002\b\004\b\026\030\000 12\0020\001:\0011B\005¢\006\002\020\002J\020\020\003\032\0020\0042\006\020\005\032\0020\006H\026J\016\020\007\032\0020\b2\006\020\t\032\0020\nJ\020\020\007\032\0020\b2\006\020\013\032\0020\fH\026J\020\020\r\032\0020\0162\006\020\013\032\0020\fH\026J\020\020\017\032\0020\0042\006\020\020\032\0020\nH\026J-\020\021\032\0020\0042\006\020\005\032\0020\0062\b\020\022\032\004\030\0010\0232\021\020\024\032\r\022\t\022\0070\026¢\006\002\b\0270\025H\026J\022\020\030\032\0020\0042\b\020\013\032\004\030\0010\fH\026J \020\031\032\0020\0042\006\020\032\032\0020\0332\006\020\034\032\0020\0352\006\020\036\032\0020\037H\026J\006\020 \032\0020\023J\022\020!\032\004\030\0010\0232\006\020\005\032\0020\006H\026J\022\020\"\032\004\030\0010\0012\006\020#\032\0020\023H\026J\020\020$\032\0020%2\006\020\022\032\0020\023H\026J&\020&\032\0020\0042\006\020'\032\0020\0232\b\b\002\020(\032\0020\0372\n\b\002\020)\032\004\030\0010*H\026J\032\020+\032\0020\0042\006\020'\032\0020\0232\b\020,\032\004\030\0010\001H\026J\b\020-\032\0020.H\026J\b\020/\032\0020\fH\026J\b\0200\032\0020\023H\026J\022\020\013\032\004\030\0010\f2\006\020\t\032\0020\nH\024¨\0062"}, d2={"Lokhttp3/internal/platform/Platform;", "", "()V", "afterHandshake", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureSslSocketFactory", "socketFactory", "configureTlsExtensions", "hostname", "", "protocols", "", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "configureTrustManager", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getPrefix", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "newSSLContext", "Ljavax/net/ssl/SSLContext;", "platformTrustManager", "toString", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public class Platform
{
  public static final Companion Companion;
  public static final int INFO = 4;
  public static final int WARN = 5;
  private static final Logger logger = Logger.getLogger(OkHttpClient.class.getName());
  private static volatile Platform platform;
  
  static
  {
    Companion localCompanion = new Companion(null);
    Companion = localCompanion;
    platform = Companion.access$findPlatform(localCompanion);
  }
  
  @JvmStatic
  public static final Platform get()
  {
    return Companion.get();
  }
  
  public void afterHandshake(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
  }
  
  public final CertificateChainCleaner buildCertificateChainCleaner(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    Object localObject = trustManager(paramSSLSocketFactory);
    if (localObject != null) {
      return buildCertificateChainCleaner((X509TrustManager)localObject);
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Unable to extract the trust manager on ");
    ((StringBuilder)localObject).append(Companion.get());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append("sslSocketFactory is ");
    ((StringBuilder)localObject).append(paramSSLSocketFactory.getClass());
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject).toString()));
  }
  
  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
    return (CertificateChainCleaner)new BasicCertificateChainCleaner(buildTrustRootIndex(paramX509TrustManager));
  }
  
  public TrustRootIndex buildTrustRootIndex(X509TrustManager paramX509TrustManager)
  {
    Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
    paramX509TrustManager = paramX509TrustManager.getAcceptedIssuers();
    Intrinsics.checkExpressionValueIsNotNull(paramX509TrustManager, "trustManager.acceptedIssuers");
    return (TrustRootIndex)new BasicTrustRootIndex((X509Certificate[])Arrays.copyOf(paramX509TrustManager, paramX509TrustManager.length));
  }
  
  public void configureSslSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "socketFactory");
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
  }
  
  public void configureTrustManager(X509TrustManager paramX509TrustManager) {}
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
    Intrinsics.checkParameterIsNotNull(paramInetSocketAddress, "address");
    paramSocket.connect((SocketAddress)paramInetSocketAddress, paramInt);
  }
  
  public final String getPrefix()
  {
    return "OkHttp";
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    return null;
  }
  
  public Object getStackTraceForCloseable(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "closer");
    if (logger.isLoggable(Level.FINE)) {
      return new Throwable(paramString);
    }
    return null;
  }
  
  public boolean isCleartextTrafficPermitted(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    return true;
  }
  
  public void log(String paramString, int paramInt, Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Level localLevel;
    if (paramInt == 5) {
      localLevel = Level.WARNING;
    } else {
      localLevel = Level.INFO;
    }
    logger.log(localLevel, paramString, paramThrowable);
  }
  
  public void logCloseableLeak(String paramString, Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    Object localObject = paramString;
    if (paramObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
      localObject = ((StringBuilder)localObject).toString();
    }
    log((String)localObject, 5, (Throwable)paramObject);
  }
  
  public SSLContext newSSLContext()
  {
    SSLContext localSSLContext = SSLContext.getInstance("TLS");
    Intrinsics.checkExpressionValueIsNotNull(localSSLContext, "SSLContext.getInstance(\"TLS\")");
    return localSSLContext;
  }
  
  public X509TrustManager platformTrustManager()
  {
    Object localObject1 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
    ((TrustManagerFactory)localObject1).init((KeyStore)null);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "factory");
    Object localObject2 = ((TrustManagerFactory)localObject1).getTrustManagers();
    if (localObject2 == null) {
      Intrinsics.throwNpe();
    }
    int j = localObject2.length;
    int i = 1;
    if ((j != 1) || (!(localObject2[0] instanceof X509TrustManager))) {
      i = 0;
    }
    if (i != 0)
    {
      localObject1 = localObject2[0];
      if (localObject1 != null) {
        return (X509TrustManager)localObject1;
      }
      throw new TypeCastException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Unexpected default trust managers: ");
    localObject2 = Arrays.toString((Object[])localObject2);
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.util.Arrays.toString(this)");
    ((StringBuilder)localObject1).append((String)localObject2);
    throw ((Throwable)new IllegalStateException(((StringBuilder)localObject1).toString().toString()));
  }
  
  public String toString()
  {
    String str = getClass().getSimpleName();
    Intrinsics.checkExpressionValueIsNotNull(str, "javaClass.simpleName");
    return str;
  }
  
  protected X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    Object localObject1 = null;
    try
    {
      Object localObject2 = Class.forName("sun.security.ssl.SSLContextImpl");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "sslContextClass");
      localObject2 = Util.readFieldOrNull(paramSSLSocketFactory, (Class)localObject2, "context");
      paramSSLSocketFactory = (SSLSocketFactory)localObject1;
      if (localObject2 != null) {
        paramSSLSocketFactory = (X509TrustManager)Util.readFieldOrNull(localObject2, X509TrustManager.class, "trustManager");
      }
      return paramSSLSocketFactory;
    }
    catch (ClassNotFoundException paramSSLSocketFactory) {}
    return null;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000H\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\b\n\002\b\002\n\002\020\013\n\002\b\004\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020 \n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\022\n\002\b\003\n\002\020\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\032\020\020\032\b\022\004\022\0020\0220\0212\f\020\023\032\b\022\004\022\0020\0240\021J\024\020\025\032\0020\0262\f\020\023\032\b\022\004\022\0020\0240\021J\b\020\027\032\0020\017H\002J\b\020\030\032\0020\017H\007J\020\020\031\032\0020\0322\b\b\002\020\016\032\0020\017R\016\020\003\032\0020\004XT¢\006\002\n\000R\016\020\005\032\0020\004XT¢\006\002\n\000R\024\020\006\032\0020\0078BX\004¢\006\006\032\004\b\006\020\bR\024\020\t\032\0020\0078BX\004¢\006\006\032\004\b\t\020\bR\024\020\n\032\0020\0078BX\004¢\006\006\032\004\b\n\020\bR\026\020\013\032\n \r*\004\030\0010\f0\fX\004¢\006\002\n\000R\016\020\016\032\0020\017X\016¢\006\002\n\000¨\006\033"}, d2={"Lokhttp3/internal/platform/Platform$Companion;", "", "()V", "INFO", "", "WARN", "isBouncyCastlePreferred", "", "()Z", "isConscryptPreferred", "isOpenJSSEPreferred", "logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "platform", "Lokhttp3/internal/platform/Platform;", "alpnProtocolNames", "", "", "protocols", "Lokhttp3/Protocol;", "concatLengthPrefixed", "", "findPlatform", "get", "resetForTests", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    private final Platform findPlatform()
    {
      Object localObject1 = Android10Platform.Companion.buildIfSupported();
      if (localObject1 != null) {
        return (Platform)localObject1;
      }
      localObject1 = AndroidPlatform.Companion.buildIfSupported();
      if (localObject1 != null) {
        return (Platform)localObject1;
      }
      localObject1 = (Companion)this;
      Object localObject2;
      if (((Companion)localObject1).isConscryptPreferred())
      {
        localObject2 = ConscryptPlatform.Companion.buildIfSupported();
        if (localObject2 != null) {
          return (Platform)localObject2;
        }
      }
      if (((Companion)localObject1).isBouncyCastlePreferred())
      {
        localObject2 = BouncyCastlePlatform.Companion.buildIfSupported();
        if (localObject2 != null) {
          return (Platform)localObject2;
        }
      }
      if (((Companion)localObject1).isOpenJSSEPreferred())
      {
        localObject1 = OpenJSSEPlatform.Companion.buildIfSupported();
        if (localObject1 != null) {
          return (Platform)localObject1;
        }
      }
      localObject1 = Jdk9Platform.Companion.buildIfSupported();
      if (localObject1 != null) {
        return (Platform)localObject1;
      }
      localObject1 = Jdk8WithJettyBootPlatform.Companion.buildIfSupported();
      if (localObject1 != null) {
        return (Platform)localObject1;
      }
      return new Platform();
    }
    
    private final boolean isBouncyCastlePreferred()
    {
      return Intrinsics.areEqual(System.getProperty("okhttp.platform"), "bouncycastle");
    }
    
    private final boolean isConscryptPreferred()
    {
      Provider localProvider = java.security.Security.getProviders()[0];
      Intrinsics.checkExpressionValueIsNotNull(localProvider, "Security.getProviders()[0]");
      return Intrinsics.areEqual("Conscrypt", localProvider.getName());
    }
    
    private final boolean isOpenJSSEPreferred()
    {
      Provider localProvider = java.security.Security.getProviders()[0];
      Intrinsics.checkExpressionValueIsNotNull(localProvider, "Security.getProviders()[0]");
      return Intrinsics.areEqual("OpenJSSE", localProvider.getName());
    }
    
    public final List<String> alpnProtocolNames(List<? extends Protocol> paramList)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "protocols");
      Object localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        int i;
        if ((Protocol)localObject2 != Protocol.HTTP_1_0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i != 0) {
          paramList.add(localObject2);
        }
      }
      localObject1 = (Iterable)paramList;
      paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext()) {
        paramList.add(((Protocol)((Iterator)localObject1).next()).toString());
      }
      return (List)paramList;
    }
    
    public final byte[] concatLengthPrefixed(List<? extends Protocol> paramList)
    {
      Intrinsics.checkParameterIsNotNull(paramList, "protocols");
      Buffer localBuffer = new Buffer();
      paramList = ((Companion)this).alpnProtocolNames(paramList).iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localBuffer.writeByte(str.length());
        localBuffer.writeUtf8(str);
      }
      return localBuffer.readByteArray();
    }
    
    @JvmStatic
    public final Platform get()
    {
      return Platform.access$getPlatform$cp();
    }
    
    public final void resetForTests(Platform paramPlatform)
    {
      Intrinsics.checkParameterIsNotNull(paramPlatform, "platform");
      Platform.access$setPlatform$cp(paramPlatform);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */