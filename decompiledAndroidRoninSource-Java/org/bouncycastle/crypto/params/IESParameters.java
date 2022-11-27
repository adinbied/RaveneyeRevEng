package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class IESParameters
  implements CipherParameters
{
  private byte[] derivation;
  private byte[] encoding;
  private int macKeySize;
  
  public IESParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    this.derivation = paramArrayOfByte1;
    this.encoding = paramArrayOfByte2;
    this.macKeySize = paramInt;
  }
  
  public byte[] getDerivationV()
  {
    return this.derivation;
  }
  
  public byte[] getEncodingV()
  {
    return this.encoding;
  }
  
  public int getMacKeySize()
  {
    return this.macKeySize;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\IESParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */