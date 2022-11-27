package org.bouncycastle.crypto.tls;

import java.io.IOException;

public abstract interface TlsCipherFactory
{
  public abstract TlsCipher createCipher(TlsContext paramTlsContext, int paramInt1, int paramInt2)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsCipherFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */