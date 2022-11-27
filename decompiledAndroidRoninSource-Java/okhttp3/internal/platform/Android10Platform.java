package okhttp3.internal.platform;

import android.os.Build.VERSION;
import android.security.NetworkSecurityPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.Android10CertificateChainCleaner;
import okhttp3.internal.platform.android.Android10CertificateChainCleaner.Companion;
import okhttp3.internal.platform.android.Android10SocketAdapter;
import okhttp3.internal.platform.android.Android10SocketAdapter.Companion;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter.Companion;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.UtilKt;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv={1, 0, 3}, d1={"\000X\n\002\030\002\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\020\016\n\000\n\002\030\002\n\002\b\002\n\002\020\013\n\002\b\003\n\002\020\b\n\000\n\002\020\003\n\000\n\002\030\002\n\002\b\002\030\000 \0352\0020\001:\001\035B\005¢\006\002\020\002J\020\020\006\032\0020\0072\006\020\b\032\0020\tH\026J(\020\n\032\0020\0132\006\020\f\032\0020\r2\b\020\016\032\004\030\0010\0172\f\020\020\032\b\022\004\022\0020\0210\004H\026J\022\020\022\032\004\030\0010\0172\006\020\f\032\0020\rH\026J\020\020\023\032\0020\0242\006\020\016\032\0020\017H\026J\"\020\025\032\0020\0132\006\020\026\032\0020\0172\006\020\027\032\0020\0302\b\020\031\032\004\030\0010\032H\026J\022\020\b\032\004\030\0010\t2\006\020\033\032\0020\034H\024R\024\020\003\032\b\022\004\022\0020\0050\004X\004¢\006\002\n\000¨\006\036"}, d2={"Lokhttp3/internal/platform/Android10Platform;", "Lokhttp3/internal/platform/Platform;", "()V", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "hostname", "", "protocols", "Lokhttp3/Protocol;", "getSelectedProtocol", "isCleartextTrafficPermitted", "", "log", "message", "level", "", "t", "", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class Android10Platform
  extends Platform
{
  public static final Companion Companion = new Companion(null);
  private static final boolean isSupported;
  private final List<SocketAdapter> socketAdapters;
  
  static
  {
    boolean bool;
    if ((AndroidPlatform.Companion.isAndroid()) && (Build.VERSION.SDK_INT >= 29)) {
      bool = true;
    } else {
      bool = false;
    }
    isSupported = bool;
  }
  
  public Android10Platform()
  {
    Object localObject1 = (Iterable)CollectionsKt.listOfNotNull(new SocketAdapter[] { Android10SocketAdapter.Companion.buildIfSupported(), ConscryptSocketAdapter.Companion.buildIfSupported(), (SocketAdapter)new DeferredSocketAdapter("com.google.android.gms.org.conscrypt") });
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      if (((SocketAdapter)localObject2).isSupported()) {
        localCollection.add(localObject2);
      }
    }
    this.socketAdapters = ((List)localCollection);
  }
  
  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
    Android10CertificateChainCleaner localAndroid10CertificateChainCleaner = Android10CertificateChainCleaner.Companion.buildIfSupported(paramX509TrustManager);
    if (localAndroid10CertificateChainCleaner != null) {
      return (CertificateChainCleaner)localAndroid10CertificateChainCleaner;
    }
    return super.buildCertificateChainCleaner(paramX509TrustManager);
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<? extends Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    Iterator localIterator = ((Iterable)this.socketAdapters).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((SocketAdapter)localObject).matchesSocket(paramSSLSocket)) {
        break label65;
      }
    }
    Object localObject = null;
    label65:
    localObject = (SocketAdapter)localObject;
    if (localObject != null) {
      ((SocketAdapter)localObject).configureTlsExtensions(paramSSLSocket, paramString, paramList);
    }
  }
  
  public String getSelectedProtocol(SSLSocket paramSSLSocket)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Object localObject3 = ((Iterable)this.socketAdapters).iterator();
    Object localObject2;
    do
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      localObject1 = ((Iterator)localObject3).next();
    } while (!((SocketAdapter)localObject1).matchesSocket(paramSSLSocket));
    break label61;
    Object localObject1 = null;
    label61:
    localObject3 = (SocketAdapter)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((SocketAdapter)localObject3).getSelectedProtocol(paramSSLSocket);
    }
    return (String)localObject1;
  }
  
  public boolean isCleartextTrafficPermitted(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    return NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted(paramString);
  }
  
  public void log(String paramString, int paramInt, Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    UtilKt.androidLog(paramInt, paramString, paramThrowable);
  }
  
  protected X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    Object localObject3 = ((Iterable)this.socketAdapters).iterator();
    Object localObject2;
    do
    {
      boolean bool = ((Iterator)localObject3).hasNext();
      localObject2 = null;
      if (!bool) {
        break;
      }
      localObject1 = ((Iterator)localObject3).next();
    } while (!((SocketAdapter)localObject1).matchesSocketFactory(paramSSLSocketFactory));
    break label61;
    Object localObject1 = null;
    label61:
    localObject3 = (SocketAdapter)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((SocketAdapter)localObject3).trustManager(paramSSLSocketFactory);
    }
    return (X509TrustManager)localObject1;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\002\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\006\032\004\030\0010\007R\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\003\020\005¨\006\b"}, d2={"Lokhttp3/internal/platform/Android10Platform$Companion;", "", "()V", "isSupported", "", "()Z", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Platform buildIfSupported()
    {
      if (((Companion)this).isSupported()) {
        return (Platform)new Android10Platform();
      }
      return null;
    }
    
    public final boolean isSupported()
    {
      return Android10Platform.access$isSupported$cp();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\Android10Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */