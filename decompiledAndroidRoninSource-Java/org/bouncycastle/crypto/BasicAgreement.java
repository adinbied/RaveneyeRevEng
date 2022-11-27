package org.bouncycastle.crypto;

import java.math.BigInteger;

public abstract interface BasicAgreement
{
  public abstract BigInteger calculateAgreement(CipherParameters paramCipherParameters);
  
  public abstract int getFieldSize();
  
  public abstract void init(CipherParameters paramCipherParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\BasicAgreement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */