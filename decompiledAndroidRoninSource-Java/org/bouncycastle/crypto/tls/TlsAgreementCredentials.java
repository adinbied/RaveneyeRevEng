package org.bouncycastle.crypto.tls;

import java.io.IOException;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public abstract interface TlsAgreementCredentials
  extends TlsCredentials
{
  public abstract byte[] generateAgreement(AsymmetricKeyParameter paramAsymmetricKeyParameter)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsAgreementCredentials.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */