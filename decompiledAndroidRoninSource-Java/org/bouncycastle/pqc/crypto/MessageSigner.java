package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;

public abstract interface MessageSigner
{
  public abstract byte[] generateSignature(byte[] paramArrayOfByte);
  
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters);
  
  public abstract boolean verifySignature(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\MessageSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */