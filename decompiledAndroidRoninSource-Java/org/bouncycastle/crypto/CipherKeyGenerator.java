package org.bouncycastle.crypto;

import java.security.SecureRandom;

public class CipherKeyGenerator
{
  protected SecureRandom random;
  protected int strength;
  
  public byte[] generateKey()
  {
    byte[] arrayOfByte = new byte[this.strength];
    this.random.nextBytes(arrayOfByte);
    return arrayOfByte;
  }
  
  public void init(KeyGenerationParameters paramKeyGenerationParameters)
  {
    this.random = paramKeyGenerationParameters.getRandom();
    this.strength = ((paramKeyGenerationParameters.getStrength() + 7) / 8);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\CipherKeyGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */