package org.bouncycastle.crypto.tls;

public abstract interface TlsPSKIdentityManager
{
  public abstract byte[] getHint();
  
  public abstract byte[] getPSK(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\TlsPSKIdentityManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */