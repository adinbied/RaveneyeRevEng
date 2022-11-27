package org.bouncycastle.crypto.generators;

import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.EphemeralKeyPair;
import org.bouncycastle.crypto.KeyEncoder;

public class EphemeralKeyPairGenerator
{
  private AsymmetricCipherKeyPairGenerator gen;
  private KeyEncoder keyEncoder;
  
  public EphemeralKeyPairGenerator(AsymmetricCipherKeyPairGenerator paramAsymmetricCipherKeyPairGenerator, KeyEncoder paramKeyEncoder)
  {
    this.gen = paramAsymmetricCipherKeyPairGenerator;
    this.keyEncoder = paramKeyEncoder;
  }
  
  public EphemeralKeyPair generate()
  {
    return new EphemeralKeyPair(this.gen.generateKeyPair(), this.keyEncoder);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\generators\EphemeralKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */