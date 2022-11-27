package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.params.SRP6GroupParameters;

public abstract interface TlsSRPGroupVerifier
{
  public abstract boolean accept(SRP6GroupParameters paramSRP6GroupParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSRPGroupVerifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */