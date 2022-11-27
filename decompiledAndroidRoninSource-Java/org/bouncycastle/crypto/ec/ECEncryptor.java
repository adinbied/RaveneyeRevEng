package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.math.ec.ECPoint;

public abstract interface ECEncryptor
{
  public abstract ECPair encrypt(ECPoint paramECPoint);
  
  public abstract void init(CipherParameters paramCipherParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */