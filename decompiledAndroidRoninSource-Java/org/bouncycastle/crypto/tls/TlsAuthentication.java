package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract interface TlsAuthentication
{
  public abstract TlsCredentials getClientCredentials(CertificateRequest paramCertificateRequest)
    throws IOException;
  
  public abstract void notifyServerCertificate(Certificate paramCertificate)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsAuthentication.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */