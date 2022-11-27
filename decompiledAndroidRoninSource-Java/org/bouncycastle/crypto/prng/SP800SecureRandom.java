package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandom
  extends SecureRandom
{
  private SP80090DRBG drbg;
  private final DRBGProvider drbgProvider;
  private final EntropySource entropySource;
  private final boolean predictionResistant;
  private final SecureRandom randomSource;
  
  SP800SecureRandom(SecureRandom paramSecureRandom, EntropySource paramEntropySource, DRBGProvider paramDRBGProvider, boolean paramBoolean)
  {
    this.randomSource = paramSecureRandom;
    this.entropySource = paramEntropySource;
    this.drbgProvider = paramDRBGProvider;
    this.predictionResistant = paramBoolean;
  }
  
  public byte[] generateSeed(int paramInt)
  {
    return EntropyUtil.generateSeed(this.entropySource, paramInt);
  }
  
  public void nextBytes(byte[] paramArrayOfByte)
  {
    try
    {
      if (this.drbg == null) {
        this.drbg = this.drbgProvider.get(this.entropySource);
      }
      if (this.drbg.generate(paramArrayOfByte, null, this.predictionResistant) < 0)
      {
        this.drbg.reseed(null);
        this.drbg.generate(paramArrayOfByte, null, this.predictionResistant);
      }
      return;
    }
    finally {}
  }
  
  public void reseed(byte[] paramArrayOfByte)
  {
    this.drbg.reseed(paramArrayOfByte);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\SP800SecureRandom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */