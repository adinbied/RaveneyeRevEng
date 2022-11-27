package org.bouncycastle.crypto;

public abstract interface Signer
{
  public abstract byte[] generateSignature()
    throws CryptoException, DataLengthException;
  
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters);
  
  public abstract void reset();
  
  public abstract void update(byte paramByte);
  
  public abstract void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract boolean verifySignature(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */