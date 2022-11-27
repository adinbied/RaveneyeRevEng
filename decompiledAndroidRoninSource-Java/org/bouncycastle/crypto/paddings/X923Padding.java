package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class X923Padding
  implements BlockCipherPadding
{
  SecureRandom random = null;
  
  public int addPadding(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (byte)(paramArrayOfByte.length - paramInt);
    while (paramInt < paramArrayOfByte.length - 1)
    {
      SecureRandom localSecureRandom = this.random;
      if (localSecureRandom == null) {
        paramArrayOfByte[paramInt] = 0;
      } else {
        paramArrayOfByte[paramInt] = ((byte)localSecureRandom.nextInt());
      }
      paramInt += 1;
    }
    paramArrayOfByte[paramInt] = i;
    return i;
  }
  
  public String getPaddingName()
  {
    return "X9.23";
  }
  
  public void init(SecureRandom paramSecureRandom)
    throws IllegalArgumentException
  {
    this.random = paramSecureRandom;
  }
  
  public int padCount(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    int i = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
    if (i <= paramArrayOfByte.length) {
      return i;
    }
    throw new InvalidCipherTextException("pad block corrupted");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\paddings\X923Padding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */