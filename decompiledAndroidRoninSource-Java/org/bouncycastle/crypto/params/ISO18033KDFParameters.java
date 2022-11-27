package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.DerivationParameters;

public class ISO18033KDFParameters
  implements DerivationParameters
{
  byte[] seed;
  
  public ISO18033KDFParameters(byte[] paramArrayOfByte)
  {
    this.seed = paramArrayOfByte;
  }
  
  public byte[] getSeed()
  {
    return this.seed;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ISO18033KDFParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */