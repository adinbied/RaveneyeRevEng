package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;

class TlsServerContextImpl
  extends AbstractTlsContext
  implements TlsServerContext
{
  TlsServerContextImpl(SecureRandom paramSecureRandom, SecurityParameters paramSecurityParameters)
  {
    super(paramSecureRandom, paramSecurityParameters);
  }
  
  public boolean isServer()
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsServerContextImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */