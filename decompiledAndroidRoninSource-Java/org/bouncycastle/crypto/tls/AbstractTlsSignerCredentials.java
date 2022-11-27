package org.bouncycastle.crypto.tls;

public abstract class AbstractTlsSignerCredentials
  extends AbstractTlsCredentials
  implements TlsSignerCredentials
{
  public SignatureAndHashAlgorithm getSignatureAndHashAlgorithm()
  {
    throw new IllegalStateException("TlsSignerCredentials implementation does not support (D)TLS 1.2+");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\AbstractTlsSignerCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */