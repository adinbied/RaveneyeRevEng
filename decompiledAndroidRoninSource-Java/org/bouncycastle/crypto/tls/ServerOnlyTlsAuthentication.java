package org.bouncycastle.crypto.tls;

public abstract class ServerOnlyTlsAuthentication
  implements TlsAuthentication
{
  public final TlsCredentials getClientCredentials(CertificateRequest paramCertificateRequest)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\ServerOnlyTlsAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */