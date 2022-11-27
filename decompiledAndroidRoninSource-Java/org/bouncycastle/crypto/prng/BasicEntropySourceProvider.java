package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;

public class BasicEntropySourceProvider
  implements EntropySourceProvider
{
  private final boolean _predictionResistant;
  private final SecureRandom _sr;
  
  public BasicEntropySourceProvider(SecureRandom paramSecureRandom, boolean paramBoolean)
  {
    this._sr = paramSecureRandom;
    this._predictionResistant = paramBoolean;
  }
  
  public EntropySource get(final int paramInt)
  {
    new EntropySource()
    {
      public int entropySize()
      {
        return paramInt;
      }
      
      public byte[] getEntropy()
      {
        if ((!(BasicEntropySourceProvider.this._sr instanceof SP800SecureRandom)) && (!(BasicEntropySourceProvider.this._sr instanceof X931SecureRandom))) {
          return BasicEntropySourceProvider.this._sr.generateSeed((paramInt + 7) / 8);
        }
        byte[] arrayOfByte = new byte[(paramInt + 7) / 8];
        BasicEntropySourceProvider.this._sr.nextBytes(arrayOfByte);
        return arrayOfByte;
      }
      
      public boolean isPredictionResistant()
      {
        return BasicEntropySourceProvider.this._predictionResistant;
      }
    };
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\BasicEntropySourceProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */