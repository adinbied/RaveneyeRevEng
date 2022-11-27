package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithSalt
  implements CipherParameters
{
  private CipherParameters parameters;
  private byte[] salt;
  
  public ParametersWithSalt(CipherParameters paramCipherParameters, byte[] paramArrayOfByte)
  {
    this(paramCipherParameters, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public ParametersWithSalt(CipherParameters paramCipherParameters, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    this.salt = arrayOfByte;
    this.parameters = paramCipherParameters;
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
  }
  
  public CipherParameters getParameters()
  {
    return this.parameters;
  }
  
  public byte[] getSalt()
  {
    return this.salt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ParametersWithSalt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */