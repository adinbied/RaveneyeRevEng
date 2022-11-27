package org.bouncycastle.crypto;

public abstract interface SkippingCipher
{
  public abstract long getPosition();
  
  public abstract long seekTo(long paramLong);
  
  public abstract long skip(long paramLong);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\SkippingCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */