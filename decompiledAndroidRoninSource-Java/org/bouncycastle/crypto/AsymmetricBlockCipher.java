package org.bouncycastle.crypto;

public abstract interface AsymmetricBlockCipher
{
  public abstract int getInputBlockSize();
  
  public abstract int getOutputBlockSize();
  
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters);
  
  public abstract byte[] processBlock(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws InvalidCipherTextException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\AsymmetricBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */