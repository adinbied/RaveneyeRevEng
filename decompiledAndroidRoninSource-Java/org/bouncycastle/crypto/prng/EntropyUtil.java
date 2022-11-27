package org.bouncycastle.crypto.prng;

public class EntropyUtil
{
  public static byte[] generateSeed(EntropySource paramEntropySource, int paramInt)
  {
    byte[] arrayOfByte1 = new byte[paramInt];
    if (paramInt * 8 <= paramEntropySource.entropySize())
    {
      System.arraycopy(paramEntropySource.getEntropy(), 0, arrayOfByte1, 0, paramInt);
      return arrayOfByte1;
    }
    int j = paramEntropySource.entropySize() / 8;
    int i = 0;
    while (i < paramInt)
    {
      byte[] arrayOfByte2 = paramEntropySource.getEntropy();
      int k = arrayOfByte2.length;
      int m = paramInt - i;
      if (k <= m) {
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
      } else {
        System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, m);
      }
      i += j;
    }
    return arrayOfByte1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\EntropyUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */