package okhttp3.internal.platform.android;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.tls.CertificateChainCleaner;

@Metadata(bv={1, 0, 3}, d1={"\000@\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\000\n\002\020\000\n\000\n\002\030\002\n\002\b\002\n\002\020 \n\002\030\002\n\002\b\002\n\002\020\016\n\000\n\002\020\013\n\002\b\002\n\002\020\b\n\002\b\002\b\000\030\000 \0242\0020\001:\001\024B\035\022\006\020\002\032\0020\003\022\006\020\004\032\0020\005\022\006\020\006\032\0020\007¢\006\002\020\bJ$\020\t\032\b\022\004\022\0020\0130\n2\f\020\f\032\b\022\004\022\0020\0130\n2\006\020\r\032\0020\016H\026J\023\020\017\032\0020\0202\b\020\021\032\004\030\0010\005H\002J\b\020\022\032\0020\023H\026R\016\020\006\032\0020\007X\004¢\006\002\n\000R\016\020\002\032\0020\003X\004¢\006\002\n\000R\016\020\004\032\0020\005X\004¢\006\002\n\000¨\006\025"}, d2={"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "Lokhttp3/internal/tls/CertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "x509TrustManagerExtensions", "", "checkServerTrusted", "Ljava/lang/reflect/Method;", "(Ljavax/net/ssl/X509TrustManager;Ljava/lang/Object;Ljava/lang/reflect/Method;)V", "clean", "", "Ljava/security/cert/Certificate;", "chain", "hostname", "", "equals", "", "other", "hashCode", "", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class AndroidCertificateChainCleaner
  extends CertificateChainCleaner
{
  public static final Companion Companion = new Companion(null);
  private final Method checkServerTrusted;
  private final X509TrustManager trustManager;
  private final Object x509TrustManagerExtensions;
  
  public AndroidCertificateChainCleaner(X509TrustManager paramX509TrustManager, Object paramObject, Method paramMethod)
  {
    this.trustManager = paramX509TrustManager;
    this.x509TrustManagerExtensions = paramObject;
    this.checkServerTrusted = paramMethod;
  }
  
  public List<Certificate> clean(List<? extends Certificate> paramList, String paramString)
    throws SSLPeerUnverifiedException
  {
    Intrinsics.checkParameterIsNotNull(paramList, "chain");
    Intrinsics.checkParameterIsNotNull(paramString, "hostname");
    try
    {
      paramList = ((Collection)paramList).toArray(new X509Certificate[0]);
      if (paramList != null)
      {
        paramList = (X509Certificate[])paramList;
        paramList = this.checkServerTrusted.invoke(this.x509TrustManagerExtensions, new Object[] { paramList, "RSA", paramString });
        if (paramList != null) {
          return (List)paramList;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.List<java.security.cert.Certificate>");
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
    catch (IllegalAccessException paramList)
    {
      throw ((Throwable)new AssertionError(paramList));
    }
    catch (InvocationTargetException paramList)
    {
      paramString = new SSLPeerUnverifiedException(paramList.getMessage());
      paramString.initCause((Throwable)paramList);
      throw ((Throwable)paramString);
    }
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof AndroidCertificateChainCleaner)) && (((AndroidCertificateChainCleaner)paramObject).trustManager == this.trustManager);
  }
  
  public int hashCode()
  {
    return System.identityHashCode(this.trustManager);
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\030\002\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\020\020\003\032\004\030\0010\0042\006\020\005\032\0020\006¨\006\007"}, d2={"Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner$Companion;", "", "()V", "build", "Lokhttp3/internal/platform/android/AndroidCertificateChainCleaner;", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final AndroidCertificateChainCleaner build(X509TrustManager paramX509TrustManager)
    {
      Intrinsics.checkParameterIsNotNull(paramX509TrustManager, "trustManager");
      try
      {
        Object localObject2 = Class.forName("android.net.http.X509TrustManagerExtensions");
        Object localObject1 = ((Class)localObject2).getConstructor(new Class[] { X509TrustManager.class }).newInstance(new Object[] { paramX509TrustManager });
        localObject2 = ((Class)localObject2).getMethod("checkServerTrusted", new Class[] { X509Certificate[].class, String.class, String.class });
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "extensions");
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "checkServerTrusted");
        paramX509TrustManager = new AndroidCertificateChainCleaner(paramX509TrustManager, localObject1, (Method)localObject2);
        return paramX509TrustManager;
      }
      catch (Exception paramX509TrustManager)
      {
        for (;;) {}
      }
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\AndroidCertificateChainCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */