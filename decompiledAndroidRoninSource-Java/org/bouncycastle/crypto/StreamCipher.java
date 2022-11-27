package org.bouncycastle.crypto;

public abstract interface StreamCipher
{
  public abstract String getAlgorithmName();
  
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException;
  
  public abstract int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException;
  
  public abstract void reset();
  
  public abstract byte returnByte(byte paramByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\StreamCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */