package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.Digest;

public abstract interface TlsHandshakeHash
  extends Digest
{
  public abstract Digest forkPRFHash();
  
  public abstract byte[] getFinalHash(short paramShort);
  
  public abstract void init(TlsContext paramTlsContext);
  
  public abstract TlsHandshakeHash notifyPRFDetermined();
  
  public abstract void sealHashAlgorithms();
  
  public abstract TlsHandshakeHash stopTracking();
  
  public abstract void trackHashAlgorithm(short paramShort);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsHandshakeHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */