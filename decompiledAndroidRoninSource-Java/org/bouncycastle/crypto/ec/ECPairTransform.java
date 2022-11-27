package org.bouncycastle.crypto.ec;

import org.bouncycastle.crypto.CipherParameters;

public abstract interface ECPairTransform
{
  public abstract void init(CipherParameters paramCipherParameters);
  
  public abstract ECPair transform(ECPair paramECPair);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\ec\ECPairTransform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */