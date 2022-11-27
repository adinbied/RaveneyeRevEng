package org.bouncycastle.crypto.modes.gcm;

import org.bouncycastle.util.Pack;

public abstract class GCMUtil
{
  private static final int E1 = -520093696;
  private static final long E1L = -2233785415175766016L;
  private static final int[] LOOKUP = ;
  
  public static void asBytes(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    Pack.intToBigEndian(paramArrayOfInt, paramArrayOfByte, 0);
  }
  
  public static void asBytes(long[] paramArrayOfLong, byte[] paramArrayOfByte)
  {
    Pack.longToBigEndian(paramArrayOfLong, paramArrayOfByte, 0);
  }
  
  public static byte[] asBytes(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[16];
    Pack.intToBigEndian(paramArrayOfInt, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static byte[] asBytes(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[16];
    Pack.longToBigEndian(paramArrayOfLong, arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public static void asInts(byte[] paramArrayOfByte, int[] paramArrayOfInt)
  {
    Pack.bigEndianToInt(paramArrayOfByte, 0, paramArrayOfInt);
  }
  
  public static int[] asInts(byte[] paramArrayOfByte)
  {
    int[] arrayOfInt = new int[4];
    Pack.bigEndianToInt(paramArrayOfByte, 0, arrayOfInt);
    return arrayOfInt;
  }
  
  public static void asLongs(byte[] paramArrayOfByte, long[] paramArrayOfLong)
  {
    Pack.bigEndianToLong(paramArrayOfByte, 0, paramArrayOfLong);
  }
  
  public static long[] asLongs(byte[] paramArrayOfByte)
  {
    long[] arrayOfLong = new long[2];
    Pack.bigEndianToLong(paramArrayOfByte, 0, arrayOfLong);
    return arrayOfLong;
  }
  
  private static int[] generateLookup()
  {
    int[] arrayOfInt = new int['Ā'];
    int i = 0;
    while (i < 256)
    {
      int j = 7;
      int m;
      for (int k = 0; j >= 0; k = m)
      {
        m = k;
        if ((1 << j & i) != 0) {
          m = k ^ -520093696 >>> 7 - j;
        }
        j -= 1;
      }
      arrayOfInt[i] = k;
      i += 1;
    }
    return arrayOfInt;
  }
  
  public static void multiply(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int[] arrayOfInt = asInts(paramArrayOfByte1);
    multiply(arrayOfInt, asInts(paramArrayOfByte2));
    asBytes(arrayOfInt, paramArrayOfByte1);
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i2 = paramArrayOfInt1[0];
    int i3 = paramArrayOfInt1[1];
    int i4 = paramArrayOfInt1[2];
    int i = paramArrayOfInt1[3];
    int j = 0;
    int i5 = 0;
    int i1 = 0;
    int n = 0;
    int m = 0;
    while (j < 4)
    {
      int i6 = paramArrayOfInt2[j];
      int k = 0;
      while (k < 32)
      {
        int i7 = i6 >> 31;
        i6 <<= 1;
        i5 ^= i2 & i7;
        i1 ^= i3 & i7;
        n ^= i4 & i7;
        m ^= i7 & i;
        i7 = i >>> 1 | i4 << 31;
        i4 = i4 >>> 1 | i3 << 31;
        i3 = i3 >>> 1 | i2 << 31;
        i2 = i2 >>> 1 ^ i << 31 >> 8 & 0xE1000000;
        k += 1;
        i = i7;
      }
      j += 1;
    }
    paramArrayOfInt1[0] = i5;
    paramArrayOfInt1[1] = i1;
    paramArrayOfInt1[2] = n;
    paramArrayOfInt1[3] = m;
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l3 = paramArrayOfLong1[0];
    long l1 = paramArrayOfLong1[1];
    long l4 = 0L;
    long l2 = 0L;
    int i = 0;
    while (i < 2)
    {
      long l5 = paramArrayOfLong2[i];
      int j = 0;
      while (j < 64)
      {
        long l6 = l5 >> 63;
        l5 <<= 1;
        l4 ^= l3 & l6;
        l2 ^= l6 & l1;
        l6 = l1 >>> 1 | l3 << 63;
        l3 = l3 >>> 1 ^ l1 << 63 >> 8 & 0xE100000000000000;
        j += 1;
        l1 = l6;
      }
      i += 1;
    }
    paramArrayOfLong1[0] = l4;
    paramArrayOfLong1[1] = l2;
  }
  
  public static void multiplyP(int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] = (shiftRight(paramArrayOfInt) >> 8 & 0xE1000000 ^ paramArrayOfInt[0]);
  }
  
  public static void multiplyP(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    paramArrayOfInt2[0] = (shiftRight(paramArrayOfInt1, paramArrayOfInt2) >> 8 & 0xE1000000 ^ paramArrayOfInt2[0]);
  }
  
  public static void multiplyP8(int[] paramArrayOfInt)
  {
    int i = shiftRightN(paramArrayOfInt, 8);
    int j = paramArrayOfInt[0];
    paramArrayOfInt[0] = (LOOKUP[(i >>> 24)] ^ j);
  }
  
  public static void multiplyP8(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = shiftRightN(paramArrayOfInt1, 8, paramArrayOfInt2);
    int j = paramArrayOfInt2[0];
    paramArrayOfInt2[0] = (LOOKUP[(i >>> 24)] ^ j);
  }
  
  public static byte[] oneAsBytes()
  {
    byte[] arrayOfByte = new byte[16];
    arrayOfByte[0] = Byte.MIN_VALUE;
    return arrayOfByte;
  }
  
  public static int[] oneAsInts()
  {
    int[] arrayOfInt = new int[4];
    arrayOfInt[0] = Integer.MIN_VALUE;
    return arrayOfInt;
  }
  
  public static long[] oneAsLongs()
  {
    long[] arrayOfLong = new long[2];
    arrayOfLong[0] = Long.MIN_VALUE;
    return arrayOfLong;
  }
  
  static int shiftRight(int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt[0];
    paramArrayOfInt[0] = (j >>> 1);
    int i = paramArrayOfInt[1];
    paramArrayOfInt[1] = (j << 31 | i >>> 1);
    j = paramArrayOfInt[2];
    paramArrayOfInt[2] = (i << 31 | j >>> 1);
    i = paramArrayOfInt[3];
    paramArrayOfInt[3] = (j << 31 | i >>> 1);
    return i << 31;
  }
  
  static int shiftRight(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int j = paramArrayOfInt1[0];
    paramArrayOfInt2[0] = (j >>> 1);
    int i = paramArrayOfInt1[1];
    paramArrayOfInt2[1] = (j << 31 | i >>> 1);
    j = paramArrayOfInt1[2];
    paramArrayOfInt2[2] = (i << 31 | j >>> 1);
    i = paramArrayOfInt1[3];
    paramArrayOfInt2[3] = (j << 31 | i >>> 1);
    return i << 31;
  }
  
  static long shiftRight(long[] paramArrayOfLong)
  {
    long l1 = paramArrayOfLong[0];
    paramArrayOfLong[0] = (l1 >>> 1);
    long l2 = paramArrayOfLong[1];
    paramArrayOfLong[1] = (l1 << 63 | l2 >>> 1);
    return l2 << 63;
  }
  
  static long shiftRight(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    paramArrayOfLong2[0] = (l1 >>> 1);
    long l2 = paramArrayOfLong1[1];
    paramArrayOfLong2[1] = (l1 << 63 | l2 >>> 1);
    return l2 << 63;
  }
  
  static int shiftRightN(int[] paramArrayOfInt, int paramInt)
  {
    int k = paramArrayOfInt[0];
    int i = 32 - paramInt;
    paramArrayOfInt[0] = (k >>> paramInt);
    int j = paramArrayOfInt[1];
    paramArrayOfInt[1] = (k << i | j >>> paramInt);
    k = paramArrayOfInt[2];
    paramArrayOfInt[2] = (j << i | k >>> paramInt);
    j = paramArrayOfInt[3];
    paramArrayOfInt[3] = (j >>> paramInt | k << i);
    return j << i;
  }
  
  static int shiftRightN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int k = paramArrayOfInt1[0];
    int i = 32 - paramInt;
    paramArrayOfInt2[0] = (k >>> paramInt);
    int j = paramArrayOfInt1[1];
    paramArrayOfInt2[1] = (k << i | j >>> paramInt);
    k = paramArrayOfInt1[2];
    paramArrayOfInt2[2] = (j << i | k >>> paramInt);
    j = paramArrayOfInt1[3];
    paramArrayOfInt2[3] = (j >>> paramInt | k << i);
    return j << i;
  }
  
  public static void xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 0;
    int j;
    do
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      j = i + 1;
      i = j;
    } while (j < 16);
  }
  
  public static void xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    for (;;)
    {
      paramInt2 -= 1;
      if (paramInt2 < 0) {
        break;
      }
      paramArrayOfByte1[paramInt2] = ((byte)(paramArrayOfByte1[paramInt2] ^ paramArrayOfByte2[(paramInt1 + paramInt2)]));
    }
  }
  
  public static void xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    int i = 0;
    int j;
    do
    {
      paramArrayOfByte3[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
      paramArrayOfByte3[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
      paramArrayOfByte3[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i += 1;
      paramArrayOfByte3[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      j = i + 1;
      i = j;
    } while (j < 16);
  }
  
  public static void xor(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    paramArrayOfInt1[0] ^= paramArrayOfInt2[0];
    paramArrayOfInt1[1] ^= paramArrayOfInt2[1];
    paramArrayOfInt1[2] ^= paramArrayOfInt2[2];
    int i = paramArrayOfInt1[3];
    paramArrayOfInt2[3] ^= i;
  }
  
  public static void xor(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    paramArrayOfInt1[0] ^= paramArrayOfInt2[0];
    paramArrayOfInt1[1] ^= paramArrayOfInt2[1];
    paramArrayOfInt1[2] ^= paramArrayOfInt2[2];
    paramArrayOfInt1[3] ^= paramArrayOfInt2[3];
  }
  
  public static void xor(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
  }
  
  public static void xor(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    long l = paramArrayOfLong1[1];
    paramArrayOfLong2[1] ^= l;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\gcm\GCMUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */