package org.bouncycastle.openssl;

public abstract interface PEMDecryptor
{
  public abstract byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws PEMException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMDecryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */