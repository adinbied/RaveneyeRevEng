package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class TBCPadding
  implements BlockCipherPadding
{
  public int addPadding(byte[] paramArrayOfByte, int paramInt)
  {
    int k = paramArrayOfByte.length;
    int j = 255;
    if (paramInt > 0 ? (paramArrayOfByte[(paramInt - 1)] & 0x1) != 0 : (paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0x1) != 0) {
      j = 0;
    }
    int i = (byte)j;
    j = paramInt;
    while (j < paramArrayOfByte.length)
    {
      paramArrayOfByte[j] = i;
      j += 1;
    }
    return k - paramInt;
  }
  
  public String getPaddingName()
  {
    return "TBC";
  }
  
  public void init(SecureRandom paramSecureRandom)
    throws IllegalArgumentException
  {}
  
  public int padCount(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    int j = paramArrayOfByte[(paramArrayOfByte.length - 1)];
    int i = paramArrayOfByte.length - 1;
    while ((i > 0) && (paramArrayOfByte[(i - 1)] == j)) {
      i -= 1;
    }
    return paramArrayOfByte.length - i;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\paddings\TBCPadding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */