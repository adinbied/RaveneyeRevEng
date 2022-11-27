package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithID
  implements CipherParameters
{
  private byte[] id;
  private CipherParameters parameters;
  
  public ParametersWithID(CipherParameters paramCipherParameters, byte[] paramArrayOfByte)
  {
    this.parameters = paramCipherParameters;
    this.id = paramArrayOfByte;
  }
  
  public byte[] getID()
  {
    return this.id;
  }
  
  public CipherParameters getParameters()
  {
    return this.parameters;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ParametersWithID.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */