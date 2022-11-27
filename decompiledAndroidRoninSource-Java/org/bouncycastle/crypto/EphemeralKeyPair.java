package org.bouncycastle.crypto;

public class EphemeralKeyPair
{
  private AsymmetricCipherKeyPair keyPair;
  private KeyEncoder publicKeyEncoder;
  
  public EphemeralKeyPair(AsymmetricCipherKeyPair paramAsymmetricCipherKeyPair, KeyEncoder paramKeyEncoder)
  {
    this.keyPair = paramAsymmetricCipherKeyPair;
    this.publicKeyEncoder = paramKeyEncoder;
  }
  
  public byte[] getEncodedPublicKey()
  {
    return this.publicKeyEncoder.getEncoded(this.keyPair.getPublic());
  }
  
  public AsymmetricCipherKeyPair getKeyPair()
  {
    return this.keyPair;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\EphemeralKeyPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */