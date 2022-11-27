package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public abstract interface ExchangePairGenerator
{
  public abstract ExchangePair GenerateExchange(AsymmetricKeyParameter paramAsymmetricKeyParameter);
  
  public abstract ExchangePair generateExchange(AsymmetricKeyParameter paramAsymmetricKeyParameter);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\ExchangePairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */