package org.bouncycastle.crypto.paddings;

import java.security.SecureRandom;
import org.bouncycastle.crypto.InvalidCipherTextException;

public class PKCS7Padding
  implements BlockCipherPadding
{
  public int addPadding(byte[] paramArrayOfByte, int paramInt)
  {
    int i = (byte)(paramArrayOfByte.length - paramInt);
    while (paramInt < paramArrayOfByte.length)
    {
      paramArrayOfByte[paramInt] = i;
      paramInt += 1;
    }
    return i;
  }
  
  public String getPaddingName()
  {
    return "PKCS7";
  }
  
  public void init(SecureRandom paramSecureRandom)
    throws IllegalArgumentException
  {}
  
  public int padCount(byte[] paramArrayOfByte)
    throws InvalidCipherTextException
  {
    int n = paramArrayOfByte[(paramArrayOfByte.length - 1)] & 0xFF;
    int i1 = (byte)n;
    if (n > paramArrayOfByte.length) {
      i = 1;
    } else {
      i = 0;
    }
    if (n == 0) {
      j = 1;
    } else {
      j = 0;
    }
    int j = i | j;
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int k;
      if (paramArrayOfByte.length - i <= n) {
        k = 1;
      } else {
        k = 0;
      }
      int m;
      if (paramArrayOfByte[i] != i1) {
        m = 1;
      } else {
        m = 0;
      }
      j |= k & m;
      i += 1;
    }
    if (j == 0) {
      return n;
    }
    throw new InvalidCipherTextException("pad block corrupted");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\paddings\PKCS7Padding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */