package org.bouncycastle.crypto;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class AsymmetricCipherKeyPair
{
  private AsymmetricKeyParameter privateParam;
  private AsymmetricKeyParameter publicParam;
  
  public AsymmetricCipherKeyPair(CipherParameters paramCipherParameters1, CipherParameters paramCipherParameters2)
  {
    this.publicParam = ((AsymmetricKeyParameter)paramCipherParameters1);
    this.privateParam = ((AsymmetricKeyParameter)paramCipherParameters2);
  }
  
  public AsymmetricCipherKeyPair(AsymmetricKeyParameter paramAsymmetricKeyParameter1, AsymmetricKeyParameter paramAsymmetricKeyParameter2)
  {
    this.publicParam = paramAsymmetricKeyParameter1;
    this.privateParam = paramAsymmetricKeyParameter2;
  }
  
  public AsymmetricKeyParameter getPrivate()
  {
    return this.privateParam;
  }
  
  public AsymmetricKeyParameter getPublic()
  {
    return this.publicParam;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\AsymmetricCipherKeyPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */