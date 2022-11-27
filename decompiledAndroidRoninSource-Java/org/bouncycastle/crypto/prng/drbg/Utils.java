package org.bouncycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.util.Integers;

class Utils
{
  static final Hashtable maxSecurityStrengths;
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    maxSecurityStrengths = localHashtable;
    localHashtable.put("SHA-1", Integers.valueOf(128));
    maxSecurityStrengths.put("SHA-224", Integers.valueOf(192));
    maxSecurityStrengths.put("SHA-256", Integers.valueOf(256));
    maxSecurityStrengths.put("SHA-384", Integers.valueOf(256));
    maxSecurityStrengths.put("SHA-512", Integers.valueOf(256));
    maxSecurityStrengths.put("SHA-512/224", Integers.valueOf(192));
    maxSecurityStrengths.put("SHA-512/256", Integers.valueOf(256));
  }
  
  static int getMaxSecurityStrength(Digest paramDigest)
  {
    return ((Integer)maxSecurityStrengths.get(paramDigest.getAlgorithmName())).intValue();
  }
  
  static int getMaxSecurityStrength(Mac paramMac)
  {
    paramMac = paramMac.getAlgorithmName();
    return ((Integer)maxSecurityStrengths.get(paramMac.substring(0, paramMac.indexOf("/")))).intValue();
  }
  
  static byte[] hash_df(Digest paramDigest, byte[] paramArrayOfByte, int paramInt)
  {
    int i2 = (paramInt + 7) / 8;
    byte[] arrayOfByte1 = new byte[i2];
    int i3 = i2 / paramDigest.getDigestSize();
    int n = paramDigest.getDigestSize();
    byte[] arrayOfByte2 = new byte[n];
    int j = 1;
    int m = 0;
    int i = 0;
    int k;
    while (i <= i3)
    {
      paramDigest.update((byte)j);
      paramDigest.update((byte)(paramInt >> 24));
      paramDigest.update((byte)(paramInt >> 16));
      paramDigest.update((byte)(paramInt >> 8));
      paramDigest.update((byte)paramInt);
      paramDigest.update(paramArrayOfByte, 0, paramArrayOfByte.length);
      paramDigest.doFinal(arrayOfByte2, 0);
      int i4 = i * n;
      int i1 = i2 - i4;
      k = i1;
      if (i1 > n) {
        k = n;
      }
      System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i4, k);
      j += 1;
      i += 1;
    }
    paramInt %= 8;
    if (paramInt != 0)
    {
      k = 8 - paramInt;
      i = 0;
      paramInt = m;
      while (paramInt != i2)
      {
        j = arrayOfByte1[paramInt] & 0xFF;
        arrayOfByte1[paramInt] = ((byte)(i << 8 - k | j >>> k));
        paramInt += 1;
        i = j;
      }
    }
    return arrayOfByte1;
  }
  
  static boolean isTooLarge(byte[] paramArrayOfByte, int paramInt)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */