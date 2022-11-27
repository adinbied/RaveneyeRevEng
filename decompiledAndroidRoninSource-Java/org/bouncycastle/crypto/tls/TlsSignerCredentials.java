package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract interface TlsSignerCredentials
  extends TlsCredentials
{
  public abstract byte[] generateCertificateSignature(byte[] paramArrayOfByte)
    throws IOException;
  
  public abstract SignatureAndHashAlgorithm getSignatureAndHashAlgorithm();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSignerCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */