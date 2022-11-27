package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

class TlsClientContextImpl
  extends AbstractTlsContext
  implements TlsClientContext
{
  TlsClientContextImpl(SecureRandom paramSecureRandom, SecurityParameters paramSecurityParameters)
  {
    super(paramSecureRandom, paramSecurityParameters);
  }
  
  public boolean isServer()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsClientContextImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */