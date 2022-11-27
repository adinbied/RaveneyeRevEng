package org.bouncycastle.crypto;

public abstract interface SignerWithRecovery
  extends Signer
{
  public abstract byte[] getRecoveredMessage();
  
  public abstract boolean hasFullMessage();
  
  public abstract void updateWithRecoveredMessage(byte[] paramArrayOfByte)
    throws InvalidCipherTextException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\SignerWithRecovery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */