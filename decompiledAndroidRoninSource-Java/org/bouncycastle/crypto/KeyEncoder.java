package org.bouncycastle.crypto;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public abstract interface KeyEncoder
{
  public abstract byte[] getEncoded(AsymmetricKeyParameter paramAsymmetricKeyParameter);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\KeyEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */