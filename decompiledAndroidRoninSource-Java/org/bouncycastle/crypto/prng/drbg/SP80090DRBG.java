package org.bouncycastle.crypto.prng.drbg;

public abstract interface SP80090DRBG
{
  public abstract int generate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean);
  
  public abstract int getBlockSize();
  
  public abstract void reseed(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\SP80090DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */