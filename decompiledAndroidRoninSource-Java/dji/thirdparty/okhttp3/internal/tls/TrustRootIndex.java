package dji.thirdparty.okhttp3.internal.tls;

import java.security.cert.X509Certificate;

public abstract interface TrustRootIndex
{
  public abstract X509Certificate findByIssuerAndSignature(X509Certificate paramX509Certificate);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\tls\TrustRootIndex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */