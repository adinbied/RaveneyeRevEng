package org.bouncycastle.crypto;

import java.security.SecureRandom;

public class KeyGenerationParameters
{
  private SecureRandom random;
  private int strength;
  
  public KeyGenerationParameters(SecureRandom paramSecureRandom, int paramInt)
  {
    this.random = paramSecureRandom;
    this.strength = paramInt;
  }
  
  public SecureRandom getRandom()
  {
    return this.random;
  }
  
  public int getStrength()
  {
    return this.strength;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\KeyGenerationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */