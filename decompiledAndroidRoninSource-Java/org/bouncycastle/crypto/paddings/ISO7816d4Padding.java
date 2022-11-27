package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class ISO7816d4Padding
  implements BlockCipherPadding
{
  public int addPadding(byte[] paramArrayOfByte, int paramInt)
  {
    int j = paramArrayOfByte.length;
    paramArrayOfByte[paramInt] = Byte.MIN_VALUE;
    int i = paramInt;
    for (;;)
    {
      i += 1;
      if (i >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[i] = 0;
    }
    return j - paramInt;
  }
  
  public String getPaddingName()
  {
    return "ISO7816-4";
  }
  
  public void init(SecureRandom paramSecureRandom)
    throws IllegalArgumentException
  {}
  
  public int padCount(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    int i = paramArrayOfByte.length - 1;
    while ((i > 0) && (paramArrayOfByte[i] == 0)) {
      i -= 1;
    }
    if (paramArrayOfByte[i] == Byte.MIN_VALUE) {
      return paramArrayOfByte.length - i;
    }
    throw new InvalidCipherTextException("pad block corrupted");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\paddings\ISO7816d4Padding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */