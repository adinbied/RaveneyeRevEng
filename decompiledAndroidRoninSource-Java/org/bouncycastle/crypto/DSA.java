package org.bouncycastle.crypto;

import java.math.BigInteger;

public abstract interface DSA
{
  public abstract BigInteger[] generateSignature(byte[] paramArrayOfByte);
  
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters);
  
  public abstract boolean verifySignature(byte[] paramArrayOfByte, BigInteger paramBigInteger1, BigInteger paramBigInteger2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\DSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */