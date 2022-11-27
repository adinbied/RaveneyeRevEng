package org.bouncycastle.crypto.prng;

public abstract interface RandomGenerator
{
  public abstract void addSeedMaterial(long paramLong);
  
  public abstract void addSeedMaterial(byte[] paramArrayOfByte);
  
  public abstract void nextBytes(byte[] paramArrayOfByte);
  
  public abstract void nextBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\RandomGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */