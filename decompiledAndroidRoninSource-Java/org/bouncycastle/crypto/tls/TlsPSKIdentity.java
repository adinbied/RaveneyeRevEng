package org.bouncycastle.crypto.tls;

public abstract interface TlsPSKIdentity
{
  public abstract byte[] getPSK();
  
  public abstract byte[] getPSKIdentity();
  
  public abstract void notifyIdentityHint(byte[] paramArrayOfByte);
  
  public abstract void skipIdentityHint();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsPSKIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */