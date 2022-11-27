package org.bouncycastle.crypto;

public abstract interface KeyEncapsulation
{
  public abstract CipherParameters decrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract CipherParameters encrypt(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract void init(CipherParameters paramCipherParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\KeyEncapsulation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */