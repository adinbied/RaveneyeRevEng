package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class ParametersWithSBox
  implements CipherParameters
{
  private CipherParameters parameters;
  private byte[] sBox;
  
  public ParametersWithSBox(CipherParameters paramCipherParameters, byte[] paramArrayOfByte)
  {
    this.parameters = paramCipherParameters;
    this.sBox = paramArrayOfByte;
  }
  
  public CipherParameters getParameters()
  {
    return this.parameters;
  }
  
  public byte[] getSBox()
  {
    return this.sBox;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ParametersWithSBox.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */