package org.bouncycastle.crypto.modes.gcm;

public abstract interface GCMMultiplier
{
  public abstract void init(byte[] paramArrayOfByte);
  
  public abstract void multiplyH(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\GCMMultiplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */