package org.bouncycastle.crypto;

public abstract interface AsymmetricCipherKeyPairGenerator
{
  public abstract AsymmetricCipherKeyPair generateKeyPair();
  
  public abstract void init(KeyGenerationParameters paramKeyGenerationParameters);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\AsymmetricCipherKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */