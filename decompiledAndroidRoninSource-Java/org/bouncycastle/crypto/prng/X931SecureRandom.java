package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class X931SecureRandom
  extends SecureRandom
{
  private final X931RNG drbg;
  private final boolean predictionResistant;
  private final SecureRandom randomSource;
  
  X931SecureRandom(SecureRandom paramSecureRandom, X931RNG paramX931RNG, boolean paramBoolean)
  {
    this.randomSource = paramSecureRandom;
    this.drbg = paramX931RNG;
    this.predictionResistant = paramBoolean;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    return EntropyUtil.generateSeed(this.drbg.getEntropySource(), paramInt);
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.drbg.generate(paramArrayOfByte, this.predictionResistant) < 0)
      {
        this.drbg.reseed();
        this.drbg.generate(paramArrayOfByte, this.predictionResistant);
      }
      return;
    }
    finally {}
  }
  
  public void setSeed(long paramLong)
  {
    try
    {
      if (this.randomSource != null) {
        this.randomSource.setSeed(paramLong);
      }
      return;
    }
    finally {}
  }
  
  public void setSeed(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.randomSource != null) {
        this.randomSource.setSeed(paramArrayOfByte);
      }
      return;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\X931SecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */