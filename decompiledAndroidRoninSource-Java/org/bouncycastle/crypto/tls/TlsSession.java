package org.bouncycastle.crypto.tls;

public abstract interface TlsSession
{
  public abstract SessionParameters exportSessionParameters();
  
  public abstract byte[] getSessionID();
  
  public abstract void invalidate();
  
  public abstract boolean isResumable();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */