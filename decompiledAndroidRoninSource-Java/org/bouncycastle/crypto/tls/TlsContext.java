package org.bouncycastle.crypto.tls;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.RandomGenerator;

public abstract interface TlsContext
{
  public abstract byte[] exportKeyingMaterial(String paramString, byte[] paramArrayOfByte, int paramInt);
  
  public abstract ProtocolVersion getClientVersion();
  
  public abstract RandomGenerator getNonceRandomGenerator();
  
  public abstract TlsSession getResumableSession();
  
  public abstract SecureRandom getSecureRandom();
  
  public abstract SecurityParameters getSecurityParameters();
  
  public abstract ProtocolVersion getServerVersion();
  
  public abstract Object getUserObject();
  
  public abstract boolean isServer();
  
  public abstract void setUserObject(Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */