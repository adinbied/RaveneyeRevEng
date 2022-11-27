package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class RC5Parameters
  implements CipherParameters
{
  private byte[] key;
  private int rounds;
  
  public RC5Parameters(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length <= 255)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte.length];
      this.key = arrayOfByte;
      this.rounds = paramInt;
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      return;
    }
    throw new IllegalArgumentException("RC5 key length can be no greater than 255");
  }
  
  public byte[] getKey()
  {
    return this.key;
  }
  
  public int getRounds()
  {
    return this.rounds;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\RC5Parameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */