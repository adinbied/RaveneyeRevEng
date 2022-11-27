package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;

public class RandUtils
{
  static int nextInt(SecureRandom paramSecureRandom, int paramInt)
  {
    if ((-paramInt & paramInt) == paramInt) {
      return (int)(paramInt * (paramSecureRandom.nextInt() >>> 1) >> 31);
    }
    int i;
    int j;
    do
    {
      i = paramSecureRandom.nextInt() >>> 1;
      j = i % paramInt;
    } while (i - j + (paramInt - 1) < 0);
    return j;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\math\linearalgebra\RandUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */