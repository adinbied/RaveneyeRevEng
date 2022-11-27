package dji.thirdparty.okhttp3.internal.tls;

import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public final class AndroidTrustRootIndex
  implements TrustRootIndex
{
  private final Method findByIssuerAndSignatureMethod;
  private final X509TrustManager trustManager;
  
  public AndroidTrustRootIndex(X509TrustManager paramX509TrustManager, Method paramMethod)
  {
    this.findByIssuerAndSignatureMethod = paramMethod;
    this.trustManager = paramX509TrustManager;
  }
  
  public static TrustRootIndex get(X509TrustManager paramX509TrustManager)
  {
    try
    {
      Method localMethod = paramX509TrustManager.getClass().getDeclaredMethod("findTrustAnchorByIssuerAndSignature", new Class[] { X509Certificate.class });
      localMethod.setAccessible(true);
      paramX509TrustManager = new AndroidTrustRootIndex(paramX509TrustManager, localMethod);
      return paramX509TrustManager;
    }
    catch (NoSuchMethodException paramX509TrustManager)
    {
      for (;;) {}
    }
    return null;
  }
  
  public X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\tls\AndroidTrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */