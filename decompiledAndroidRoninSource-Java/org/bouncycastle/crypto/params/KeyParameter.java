package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;

public class KeyParameter
  implements CipherParameters
{
  private byte[] key;
  
  public KeyParameter(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public KeyParameter(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    this.key = arrayOfByte;
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
  }
  
  public byte[] getKey()
  {
    return this.key;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\KeyParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */