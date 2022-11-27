package okhttp3.internal.platform;

import android.os.Build.VERSION;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.security.cert.TrustAnchor;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Protocol;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner;
import okhttp3.internal.platform.android.AndroidCertificateChainCleaner.Companion;
import okhttp3.internal.platform.android.CloseGuard;
import okhttp3.internal.platform.android.CloseGuard.Companion;
import okhttp3.internal.platform.android.ConscryptSocketAdapter;
import okhttp3.internal.platform.android.ConscryptSocketAdapter.Companion;
import okhttp3.internal.platform.android.DeferredSocketAdapter;
import okhttp3.internal.platform.android.SocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter;
import okhttp3.internal.platform.android.StandardAndroidSocketAdapter.Companion;
import okhttp3.internal.platform.android.UtilKt;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.TrustRootIndex;

@Metadata(bv={1, 0, 3}, d1={"\000\001\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\020 \n\002\030\002\n\000\n\002\020\013\n\000\n\002\020\016\n\000\n\002\030\002\n\000\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\b\n\002\b\b\n\002\020\003\n\002\b\003\n\002\030\002\n\002\b\003\030\000 22\0020\001:\00223B\005¢\006\002\020\002J$\020\b\032\0020\t2\006\020\n\032\0020\0132\n\020\f\032\006\022\002\b\0030\r2\006\020\016\032\0020\017H\002J$\020\020\032\0020\t2\006\020\n\032\0020\0132\n\020\f\032\006\022\002\b\0030\r2\006\020\016\032\0020\017H\002J\020\020\021\032\0020\0222\006\020\023\032\0020\024H\026J\020\020\025\032\0020\0262\006\020\023\032\0020\024H\026J-\020\027\032\0020\0302\006\020\031\032\0020\0322\b\020\n\032\004\030\0010\0132\021\020\033\032\r\022\t\022\0070\034¢\006\002\b\0350\006H\026J \020\036\032\0020\0302\006\020\037\032\0020 2\006\020!\032\0020\"2\006\020#\032\0020$H\026J\022\020%\032\004\030\0010\0132\006\020\031\032\0020\032H\026J\022\020&\032\004\030\0010\0172\006\020'\032\0020\013H\026J\020\020(\032\0020\t2\006\020\n\032\0020\013H\026J\"\020)\032\0020\0302\006\020*\032\0020\0132\006\020+\032\0020$2\b\020,\032\004\030\0010-H\026J\032\020.\032\0020\0302\006\020*\032\0020\0132\b\020/\032\004\030\0010\017H\026J\022\020\023\032\004\030\0010\0242\006\0200\032\00201H\024R\016\020\003\032\0020\004X\004¢\006\002\n\000R\024\020\005\032\b\022\004\022\0020\0070\006X\004¢\006\002\n\000¨\0064"}, d2={"Lokhttp3/internal/platform/AndroidPlatform;", "Lokhttp3/internal/platform/Platform;", "()V", "closeGuard", "Lokhttp3/internal/platform/android/CloseGuard;", "socketAdapters", "", "Lokhttp3/internal/platform/android/SocketAdapter;", "api23IsCleartextTrafficPermitted", "", "hostname", "", "networkPolicyClass", "Ljava/lang/Class;", "networkSecurityPolicy", "", "api24IsCleartextTrafficPermitted", "buildCertificateChainCleaner", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "buildTrustRootIndex", "Lokhttp3/internal/tls/TrustRootIndex;", "configureTlsExtensions", "", "sslSocket", "Ljavax/net/ssl/SSLSocket;", "protocols", "Lokhttp3/Protocol;", "Lkotlin/jvm/JvmSuppressWildcards;", "connectSocket", "socket", "Ljava/net/Socket;", "address", "Ljava/net/InetSocketAddress;", "connectTimeout", "", "getSelectedProtocol", "getStackTraceForCloseable", "closer", "isCleartextTrafficPermitted", "log", "message", "level", "t", "", "logCloseableLeak", "stackTrace", "sslSocketFactory", "Ljavax/net/ssl/SSLSocketFactory;", "Companion", "CustomTrustRootIndex", "okhttp"}, k=1, mv={1, 1, 16})
public final class AndroidPlatform
  extends Platform
{
  public static final Companion Companion = new Companion(null);
  private static final boolean isAndroid;
  private static final boolean isSupported;
  private final CloseGuard closeGuard;
  private final List<SocketAdapter> socketAdapters;
  
  static
  {
    boolean bool2 = true;
    int j = 0;
    try
    {
      Class.forName("com.android.org.conscrypt.OpenSSLSocketImpl");
      if (Build.VERSION.SDK_INT <= 0) {
        break label136;
      }
      i = 1;
    }
    catch (ClassNotFoundException|UnsatisfiedLinkError localClassNotFoundException)
    {
      for (;;)
      {
        boolean bool1;
        StringBuilder localStringBuilder;
        continue;
        int i = 0;
        if (i != 0) {
          bool1 = true;
        }
      }
    }
    throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    bool1 = false;
    isAndroid = bool1;
    if (!bool1)
    {
      bool1 = false;
    }
    else
    {
      i = j;
      if (Build.VERSION.SDK_INT >= 21) {
        i = 1;
      }
      if (i == 0) {
        break label86;
      }
      bool1 = bool2;
    }
    isSupported = bool1;
    return;
    label86:
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Expected Android API level 21+ but was ");
    localStringBuilder.append(Build.VERSION.SDK_INT);
    throw ((Throwable)new IllegalStateException(localStringBuilder.toString().toString()));
  }
  
  public AndroidPlatform()
  {
    Object localObject1 = (Iterable)CollectionsKt.listOfNotNull(new SocketAdapter[] { StandardAndroidSocketAdapter.Companion.buildIfSupported$default(StandardAndroidSocketAdapter.Companion, null, 1, null), ConscryptSocketAdapter.Companion.buildIfSupported(), (SocketAdapter)new DeferredSocketAdapter("com.google.android.gms.org.conscrypt") });
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
    this.closeGuard = CloseGuard.Companion.get();
  }
  
  private final boolean api23IsCleartextTrafficPermitted(String paramString, Class<?> paramClass, Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      paramClass = paramClass.getMethod("isCleartextTrafficPermitted", new Class[0]).invoke(paramObject, new Object[0]);
      if (paramClass != null) {
        return ((Boolean)paramClass).booleanValue();
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
    catch (NoSuchMethodException paramClass)
    {
      for (;;) {}
    }
    return super.isCleartextTrafficPermitted(paramString);
  }
  
  private final boolean api24IsCleartextTrafficPermitted(String paramString, Class<?> paramClass, Object paramObject)
    throws InvocationTargetException, IllegalAccessException
  {
    try
    {
      Object localObject = paramClass.getMethod("isCleartextTrafficPermitted", new Class[] { String.class }).invoke(paramObject, new Object[] { paramString });
      if (localObject != null) {
        return ((Boolean)localObject).booleanValue();
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Boolean");
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return api23IsCleartextTrafficPermitted(paramString, paramClass, paramObject);
  }
  
  public CertificateChainCleaner buildCertificateChainCleaner(X509TrustManager paramX509TrustManager)
  {
    Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
    AndroidCertificateChainCleaner localAndroidCertificateChainCleaner = AndroidCertificateChainCleaner.Companion.build(paramX509TrustManager);
    if (localAndroidCertificateChainCleaner != null) {
      return (CertificateChainCleaner)localAndroidCertificateChainCleaner;
    }
    return super.buildCertificateChainCleaner(paramX509TrustManager);
  }
  
  public TrustRootIndex buildTrustRootIndex(X509TrustManager paramX509TrustManager)
  {
    Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
    try
    {
      Object localObject = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      Intrinsics.checkExpressionValueIsNotNull(localObject, "method");
      ((Method)localObject).setAccessible(true);
      localObject = (TrustRootIndex)new CustomTrustRootIndex(paramX509TrustManager, (Method)localObject);
      return (TrustRootIndex)localObject;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return super.buildTrustRootIndex(paramX509TrustManager);
  }
  
  public void configureTlsExtensions(SSLSocket paramSSLSocket, String paramString, List<Protocol> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocket, "sslSocket");
    Intrinsics.checkParameterIsNotNull(paramList, "protocols");
    Iterator localIterator = ((Iterable)this.socketAdapters).iterator();
    while (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((SocketAdapter)localObject).matchesSocket(paramSSLSocket)) {
        break label67;
      }
    }
    Object localObject = null;
    label67:
    localObject = (SocketAdapter)localObject;
    if (localObject != null) {
      ((SocketAdapter)localObject).configureTlsExtensions(paramSSLSocket, paramString, paramList);
    }
  }
  
  public void connectSocket(Socket paramSocket, InetSocketAddress paramInetSocketAddress, int paramInt)
    throws IOException
  {
    Intrinsics.checkParameterIsNotNull(paramSocket, "socket");
    Intrinsics.checkParameterIsNotNull(paramInetSocketAddress, "address");
    try
    {
      paramSocket.connect((SocketAddress)paramInetSocketAddress, paramInt);
      return;
    }
    catch (ClassCastException paramSocket)
    {
      if (Build.VERSION.SDK_INT == 26) {
        throw ((Throwable)new IOException("Exception in connect", (Throwable)paramSocket));
      }
      throw ((Throwable)paramSocket);
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
    break label62;
    Object localObject1 = null;
    label62:
    localObject3 = (SocketAdapter)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((SocketAdapter)localObject3).getSelectedProtocol(paramSSLSocket);
    }
    return (String)localObject1;
  }
  
  public Object getStackTraceForCloseable(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "closer");
    return this.closeGuard.createAndOpen(paramString);
  }
  
  public boolean isCleartextTrafficPermitted(String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    try
    {
      Class localClass = Class.forName("android.security.NetworkSecurityPolicy");
      Object localObject = localClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
      Intrinsics.checkExpressionValueIsNotNull(localClass, "networkPolicyClass");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "networkSecurityPolicy");
      boolean bool = api24IsCleartextTrafficPermitted(paramString, localClass, localObject);
      return bool;
    }
    catch (InvocationTargetException paramString)
    {
      throw ((Throwable)new AssertionError("unable to determine cleartext support", (Throwable)paramString));
    }
    catch (IllegalArgumentException paramString)
    {
      throw ((Throwable)new AssertionError("unable to determine cleartext support", (Throwable)paramString));
    }
    catch (IllegalAccessException paramString)
    {
      throw ((Throwable)new AssertionError("unable to determine cleartext support", (Throwable)paramString));
      return super.isCleartextTrafficPermitted(paramString);
      return super.isCleartextTrafficPermitted(paramString);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
  }
  
  public void log(String paramString, int paramInt, Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    UtilKt.androidLog(paramInt, paramString, paramThrowable);
  }
  
  public void logCloseableLeak(String paramString, Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "message");
    if (!this.closeGuard.warnIfOpen(paramObject)) {
      Platform.log$default(this, paramString, 5, null, 4, null);
    }
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
    break label62;
    Object localObject1 = null;
    label62:
    localObject3 = (SocketAdapter)localObject1;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = ((SocketAdapter)localObject3).trustManager(paramSSLSocketFactory);
    }
    return (X509TrustManager)localObject1;
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\032\n\002\030\002\n\002\020\000\n\002\b\002\n\002\020\013\n\002\b\003\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\b\020\007\032\004\030\0010\bR\021\020\003\032\0020\004¢\006\b\n\000\032\004\b\003\020\005R\021\020\006\032\0020\004¢\006\b\n\000\032\004\b\006\020\005¨\006\t"}, d2={"Lokhttp3/internal/platform/AndroidPlatform$Companion;", "", "()V", "isAndroid", "", "()Z", "isSupported", "buildIfSupported", "Lokhttp3/internal/platform/Platform;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final Platform buildIfSupported()
    {
      if (((Companion)this).isSupported()) {
        return (Platform)new AndroidPlatform();
      }
      return null;
    }
    
    public final boolean isAndroid()
    {
      return AndroidPlatform.access$isAndroid$cp();
    }
    
    public final boolean isSupported()
    {
      return AndroidPlatform.access$isSupported$cp();
    }
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\0008\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\030\002\n\002\b\005\n\002\020\013\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020\b\n\000\n\002\020\016\n\000\b\b\030\0002\0020\001B\025\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005¢\006\002\020\006J\t\020\007\032\0020\003HÂ\003J\t\020\b\032\0020\005HÂ\003J\035\020\t\032\0020\0002\b\b\002\020\002\032\0020\0032\b\b\002\020\004\032\0020\005HÆ\001J\023\020\n\032\0020\0132\b\020\f\032\004\030\0010\rHÖ\003J\022\020\016\032\004\030\0010\0172\006\020\020\032\0020\017H\026J\t\020\021\032\0020\022HÖ\001J\t\020\023\032\0020\024HÖ\001R\016\020\004\032\0020\005X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000¨\006\025"}, d2={"Lokhttp3/internal/platform/AndroidPlatform$CustomTrustRootIndex;", "Lokhttp3/internal/tls/TrustRootIndex;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "findByIssuerAndSignatureMethod", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/reflect/Method;)V", "component1", "component2", "copy", "equals", "", "other", "", "findByIssuerAndSignature", "Ljava/security/cert/X509Certificate;", "cert", "hashCode", "", "toString", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class CustomTrustRootIndex
    implements TrustRootIndex
  {
    private final Method findByIssuerAndSignatureMethod;
    private final X509TrustManager trustManager;
    
    public CustomTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      this.trustManager = paramX509TrustManager;
      this.findByIssuerAndSignatureMethod = paramMethod;
    }
    
    private final X509TrustManager component1()
    {
      return this.trustManager;
    }
    
    private final Method component2()
    {
      return this.findByIssuerAndSignatureMethod;
    }
    
    public final CustomTrustRootIndex copy(X509TrustManager paramX509TrustManager, Method paramMethod)
    {
      Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
      Intrinsics.checkParameterIsNotNull(paramMethod, "findByIssuerAndSignatureMethod");
      return new CustomTrustRootIndex(paramX509TrustManager, paramMethod);
    }
    
    public boolean equals(Object paramObject)
    {
      if (this != paramObject) {
        if ((paramObject instanceof CustomTrustRootIndex))
        {
          paramObject = (CustomTrustRootIndex)paramObject;
          if ((Intrinsics.areEqual(this.trustManager, ((CustomTrustRootIndex)paramObject).trustManager)) && (Intrinsics.areEqual(this.findByIssuerAndSignatureMethod, ((CustomTrustRootIndex)paramObject).findByIssuerAndSignatureMethod))) {}
        }
        else
        {
          return false;
        }
      }
      return true;
    }
    
    public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
    {
      Intrinsics.checkParameterIsNotNull(paramX509Certificate, "cert");
      try
      {
        paramX509Certificate = this.findByIssuerAndSignatureMethod.invoke(this.trustManager, new Object[] { paramX509Certificate });
        if (paramX509Certificate != null) {
          return ((TrustAnchor)paramX509Certificate).getTrustedCert();
        }
        throw new TypeCastException("null cannot be cast to non-null type java.security.cert.TrustAnchor");
      }
      catch (IllegalAccessException paramX509Certificate)
      {
        throw ((Throwable)new AssertionError("unable to get issues and signature", (Throwable)paramX509Certificate));
      }
      catch (InvocationTargetException paramX509Certificate)
      {
        for (;;) {}
      }
      return null;
    }
    
    public int hashCode()
    {
      Object localObject = this.trustManager;
      int j = 0;
      int i;
      if (localObject != null) {
        i = localObject.hashCode();
      } else {
        i = 0;
      }
      localObject = this.findByIssuerAndSignatureMethod;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      return i * 31 + j;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CustomTrustRootIndex(trustManager=");
      localStringBuilder.append(this.trustManager);
      localStringBuilder.append(", findByIssuerAndSignatureMethod=");
      localStringBuilder.append(this.findByIssuerAndSignatureMethod);
      localStringBuilder.append(")");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\AndroidPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */