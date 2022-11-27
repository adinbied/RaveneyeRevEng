package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat448
{
  public static void copy64(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong2[0] = paramArrayOfLong1[0];
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
    paramArrayOfLong2[4] = paramArrayOfLong1[4];
    paramArrayOfLong2[5] = paramArrayOfLong1[5];
    paramArrayOfLong2[6] = paramArrayOfLong1[6];
  }
  
  public static long[] create64()
  {
    return new long[7];
  }
  
  public static long[] createExt64()
  {
    return new long[14];
  }
  
  public static boolean eq64(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 6;
    while (i >= 0)
    {
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public static long[] fromBigInteger64(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 448))
    {
      long[] arrayOfLong = create64();
      int i = 0;
      while (paramBigInteger.signum() != 0)
      {
        arrayOfLong[i] = paramBigInteger.longValue();
        paramBigInteger = paramBigInteger.shiftRight(64);
        i += 1;
      }
      return arrayOfLong;
    }
    throw new IllegalArgumentException();
  }
  
  public static boolean isOne64(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0] != 1L) {
      return false;
    }
    int i = 1;
    while (i < 7)
    {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isZero64(long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < 7)
    {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static BigInteger toBigInteger64(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[56];
    int i = 0;
    while (i < 7)
    {
      long l = paramArrayOfLong[i];
      if (l != 0L) {
        Pack.longToBigEndian(l, arrayOfByte, 6 - i << 3);
      }
      i += 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Nat448.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */