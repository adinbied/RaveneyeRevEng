package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.InvalidCipherTextException;

public abstract interface MessageEncryptor
{
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters);
  
  public abstract byte[] messageDecrypt(byte[] paramArrayOfByte)
    throws InvalidCipherTextException;
  
  public abstract byte[] messageEncrypt(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\MessageEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */