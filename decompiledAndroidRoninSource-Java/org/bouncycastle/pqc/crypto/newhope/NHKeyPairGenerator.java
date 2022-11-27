package org.bouncycastle.pqc.crypto.newhope;

import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.KeyGenerationParameters;

public class NHKeyPairGenerator
  implements AsymmetricCipherKeyPairGenerator
{
  private SecureRandom random;
  
  public AsymmetricCipherKeyPair generateKeyPair()
  {
    byte[] arrayOfByte = new byte['ܠ'];
    short[] arrayOfShort = new short['Ѐ'];
    NewHope.keygen(this.random, arrayOfByte, arrayOfShort);
    return new AsymmetricCipherKeyPair(new NHPublicKeyParameters(arrayOfByte), new NHPrivateKeyParameters(arrayOfShort));
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.random = paramKeyGenerationParameters.getRandom();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\NHKeyPairGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */