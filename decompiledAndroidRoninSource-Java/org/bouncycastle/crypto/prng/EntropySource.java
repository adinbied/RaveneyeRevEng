package org.bouncycastle.crypto.prng;

public abstract interface EntropySource
{
  public abstract int entropySize();
  
  public abstract byte[] getEntropy();
  
  public abstract boolean isPredictionResistant();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\EntropySource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */