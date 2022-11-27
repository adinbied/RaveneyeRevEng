package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class KDFParameters
  implements DerivationParameters
{
  byte[] iv;
  byte[] shared;
  
  public KDFParameters(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.shared = paramArrayOfByte1;
    this.iv = paramArrayOfByte2;
  }
  
  public byte[] getIV()
  {
    return this.iv;
  }
  
  public byte[] getSharedSecret()
  {
    return this.shared;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\KDFParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */