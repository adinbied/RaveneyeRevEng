package okhttp3.internal.platform.android;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;

@Metadata(bv={1, 0, 3}, d1={"\000,\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\030\002\n\002\b\003\n\002\020\013\n\002\b\002\n\002\030\002\n\002\b\002\030\000 \0162\0020\001:\001\016B1\022\016\020\002\032\n\022\006\b\000\022\0020\0040\003\022\016\020\005\032\n\022\006\b\000\022\0020\0060\003\022\n\020\007\032\006\022\002\b\0030\003¢\006\002\020\bJ\020\020\t\032\0020\n2\006\020\013\032\0020\006H\026J\022\020\f\032\004\030\0010\r2\006\020\013\032\0020\006H\026R\022\020\007\032\006\022\002\b\0030\003X\004¢\006\002\n\000R\026\020\005\032\n\022\006\b\000\022\0020\0060\003X\004¢\006\002\n\000¨\006\017"}, d2={"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter;", "Lokhttp3/internal/platform/android/AndroidSocketAdapter;", "sslSocketClass", "Ljava/lang/Class;", "Ljavax/net/ssl/SSLSocket;", "sslSocketFactoryClass", "Ljavax/net/ssl/SSLSocketFactory;", "paramClass", "(Ljava/lang/Class;Ljava/lang/Class;Ljava/lang/Class;)V", "matchesSocketFactory", "", "sslSocketFactory", "trustManager", "Ljavax/net/ssl/X509TrustManager;", "Companion", "okhttp"}, k=1, mv={1, 1, 16})
public final class StandardAndroidSocketAdapter
  extends AndroidSocketAdapter
{
  public static final Companion Companion = new Companion(null);
  private final Class<?> paramClass;
  private final Class<? super SSLSocketFactory> sslSocketFactoryClass;
  
  public StandardAndroidSocketAdapter(Class<? super SSLSocket> paramClass1, Class<? super SSLSocketFactory> paramClass2, Class<?> paramClass3)
  {
    super(paramClass1);
    this.sslSocketFactoryClass = paramClass2;
    this.paramClass = paramClass3;
  }
  
  public boolean matchesSocketFactory(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    return this.sslSocketFactoryClass.isInstance(paramSSLSocketFactory);
  }
  
  public X509TrustManager trustManager(SSLSocketFactory paramSSLSocketFactory)
  {
    Intrinsics.checkParameterIsNotNull(paramSSLSocketFactory, "sslSocketFactory");
    paramSSLSocketFactory = Util.readFieldOrNull(paramSSLSocketFactory, this.paramClass, "sslParameters");
    if (paramSSLSocketFactory == null) {
      Intrinsics.throwNpe();
    }
    X509TrustManager localX509TrustManager = (X509TrustManager)Util.readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "x509TrustManager");
    if (localX509TrustManager != null) {
      return localX509TrustManager;
    }
    return (X509TrustManager)Util.readFieldOrNull(paramSSLSocketFactory, X509TrustManager.class, "trustManager");
  }
  
  @Metadata(bv={1, 0, 3}, d1={"\000\030\n\002\030\002\n\002\020\000\n\002\b\002\n\002\030\002\n\000\n\002\020\016\n\000\b\003\030\0002\0020\001B\007\b\002¢\006\002\020\002J\022\020\003\032\004\030\0010\0042\b\b\002\020\005\032\0020\006¨\006\007"}, d2={"Lokhttp3/internal/platform/android/StandardAndroidSocketAdapter$Companion;", "", "()V", "buildIfSupported", "Lokhttp3/internal/platform/android/SocketAdapter;", "packageName", "", "okhttp"}, k=1, mv={1, 1, 16})
  public static final class Companion
  {
    public final SocketAdapter buildIfSupported(String paramString)
    {
      Intrinsics.checkParameterIsNotNull(paramString, "packageName");
      try
      {
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append(".OpenSSLSocketImpl");
        localObject1 = Class.forName(((StringBuilder)localObject1).toString());
        if (localObject1 != null)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramString);
          ((StringBuilder)localObject2).append(".OpenSSLSocketFactoryImpl");
          localObject2 = Class.forName(((StringBuilder)localObject2).toString());
          if (localObject2 != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramString);
            localStringBuilder.append(".SSLParametersImpl");
            paramString = Class.forName(localStringBuilder.toString());
            Intrinsics.checkExpressionValueIsNotNull(paramString, "paramsClass");
            paramString = new StandardAndroidSocketAdapter((Class)localObject1, (Class)localObject2, paramString);
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocketFactory>");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.Class<in javax.net.ssl.SSLSocket>");
        }
      }
      catch (Exception paramString)
      {
        UtilKt.androidLog(5, "unable to load android socket classes", (Throwable)paramString);
        paramString = null;
      }
      return (SocketAdapter)paramString;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\okhttp3\internal\platform\android\StandardAndroidSocketAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */