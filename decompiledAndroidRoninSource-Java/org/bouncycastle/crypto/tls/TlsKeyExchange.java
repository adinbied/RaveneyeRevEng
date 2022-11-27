package org.bouncycastle.crypto.tls;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface TlsKeyExchange
{
  public abstract void generateClientKeyExchange(OutputStream paramOutputStream)
    throws IOException;
  
  public abstract byte[] generatePremasterSecret()
    throws IOException;
  
  public abstract byte[] generateServerKeyExchange()
    throws IOException;
  
  public abstract void init(TlsContext paramTlsContext);
  
  public abstract void processClientCertificate(Certificate paramCertificate)
    throws IOException;
  
  public abstract void processClientCredentials(TlsCredentials paramTlsCredentials)
    throws IOException;
  
  public abstract void processClientKeyExchange(InputStream paramInputStream)
    throws IOException;
  
  public abstract void processServerCertificate(Certificate paramCertificate)
    throws IOException;
  
  public abstract void processServerCredentials(TlsCredentials paramTlsCredentials)
    throws IOException;
  
  public abstract void processServerKeyExchange(InputStream paramInputStream)
    throws IOException;
  
  public abstract boolean requiresServerKeyExchange();
  
  public abstract void skipClientCredentials()
    throws IOException;
  
  public abstract void skipServerCredentials()
    throws IOException;
  
  public abstract void skipServerKeyExchange()
    throws IOException;
  
  public abstract void validateCertificateRequest(CertificateRequest paramCertificateRequest)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsKeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */