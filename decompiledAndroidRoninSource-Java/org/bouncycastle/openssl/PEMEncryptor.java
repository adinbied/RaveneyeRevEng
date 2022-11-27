package org.bouncycastle.openssl;

public abstract interface PEMEncryptor
{
  public abstract byte[] encrypt(byte[] paramArrayOfByte)
    throws PEMException;
  
  public abstract String getAlgorithm();
  
  public abstract byte[] getIV();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMEncryptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */