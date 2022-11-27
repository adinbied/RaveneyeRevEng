package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat448;

public class SecT409Field
{
  private static final long M25 = 33554431L;
  private static final long M59 = 576460752303423487L;
  
  public static void add(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    paramArrayOfLong1[3] ^= paramArrayOfLong2[3];
    paramArrayOfLong1[4] ^= paramArrayOfLong2[4];
    paramArrayOfLong1[5] ^= paramArrayOfLong2[5];
    long l = paramArrayOfLong1[6];
    paramArrayOfLong2[6] ^= l;
  }
  
  public static void addExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    int i = 0;
    while (i < 13)
    {
      paramArrayOfLong1[i] ^= paramArrayOfLong2[i];
      i += 1;
    }
  }
  
  public static void addOne(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
    paramArrayOfLong2[4] = paramArrayOfLong1[4];
    paramArrayOfLong2[5] = paramArrayOfLong1[5];
    paramArrayOfLong2[6] = paramArrayOfLong1[6];
  }
  
  public static long[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat448.fromBigInteger64(paramBigInteger);
    reduce39(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  protected static void implCompactExt(long[] paramArrayOfLong)
  {
    long l1 = paramArrayOfLong[0];
    long l2 = paramArrayOfLong[1];
    long l3 = paramArrayOfLong[2];
    long l4 = paramArrayOfLong[3];
    long l5 = paramArrayOfLong[4];
    long l6 = paramArrayOfLong[5];
    long l7 = paramArrayOfLong[6];
    long l8 = paramArrayOfLong[7];
    long l9 = paramArrayOfLong[8];
    long l10 = paramArrayOfLong[9];
    long l11 = paramArrayOfLong[10];
    long l12 = paramArrayOfLong[11];
    long l13 = paramArrayOfLong[12];
    long l14 = paramArrayOfLong[13];
    paramArrayOfLong[0] = (l1 ^ l2 << 59);
    paramArrayOfLong[1] = (l2 >>> 5 ^ l3 << 54);
    paramArrayOfLong[2] = (l3 >>> 10 ^ l4 << 49);
    paramArrayOfLong[3] = (l4 >>> 15 ^ l5 << 44);
    paramArrayOfLong[4] = (l5 >>> 20 ^ l6 << 39);
    paramArrayOfLong[5] = (l6 >>> 25 ^ l7 << 34);
    paramArrayOfLong[6] = (l7 >>> 30 ^ l8 << 29);
    paramArrayOfLong[7] = (l8 >>> 35 ^ l9 << 24);
    paramArrayOfLong[8] = (l9 >>> 40 ^ l10 << 19);
    paramArrayOfLong[9] = (l10 >>> 45 ^ l11 << 14);
    paramArrayOfLong[10] = (l11 >>> 50 ^ l12 << 9);
    paramArrayOfLong[11] = (l12 >>> 55 ^ l13 << 4 ^ l14 << 63);
    paramArrayOfLong[12] = (l13 >>> 60 ^ l14 >>> 1);
    paramArrayOfLong[13] = 0L;
  }
  
  protected static void implExpand(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    long l6 = paramArrayOfLong1[5];
    long l7 = paramArrayOfLong1[6];
    paramArrayOfLong2[0] = (l1 & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 59 ^ l2 << 5) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 54 ^ l3 << 10) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = ((l3 >>> 49 ^ l4 << 15) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[4] = ((l4 >>> 44 ^ l5 << 20) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[5] = ((l5 >>> 39 ^ l6 << 25) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[6] = (l6 >>> 34 ^ l7 << 30);
  }
  
  protected static void implMultiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong1 = new long[7];
    long[] arrayOfLong2 = new long[7];
    implExpand(paramArrayOfLong1, arrayOfLong1);
    implExpand(paramArrayOfLong2, arrayOfLong2);
    int i = 0;
    while (i < 7)
    {
      implMulwAcc(arrayOfLong1, arrayOfLong2[i], paramArrayOfLong3, i);
      i += 1;
    }
    implCompactExt(paramArrayOfLong3);
  }
  
  protected static void implMulwAcc(long[] paramArrayOfLong1, long paramLong, long[] paramArrayOfLong2, int paramInt)
  {
    long[] arrayOfLong = new long[8];
    arrayOfLong[1] = paramLong;
    arrayOfLong[2] = (arrayOfLong[1] << 1);
    arrayOfLong[3] = (arrayOfLong[2] ^ paramLong);
    arrayOfLong[4] = (arrayOfLong[2] << 1);
    arrayOfLong[5] = (arrayOfLong[4] ^ paramLong);
    arrayOfLong[6] = (arrayOfLong[3] << 1);
    arrayOfLong[7] = (arrayOfLong[6] ^ paramLong);
    int i = 0;
    while (i < 7)
    {
      long l4 = paramArrayOfLong1[i];
      int j = (int)l4;
      long l1 = 0L;
      paramLong = arrayOfLong[(j & 0x7)] ^ arrayOfLong[(j >>> 3 & 0x7)] << 3;
      j = 54;
      int k;
      long l2;
      long l3;
      do
      {
        k = (int)(l4 >>> j);
        l2 = arrayOfLong[(k & 0x7)];
        l3 = arrayOfLong[(k >>> 3 & 0x7)] << 3 ^ l2;
        l2 = paramLong ^ l3 << j;
        l3 = l1 ^ l3 >>> -j;
        k = j - 6;
        j = k;
        l1 = l3;
        paramLong = l2;
      } while (k > 0);
      j = paramInt + i;
      paramArrayOfLong2[j] ^= 0x7FFFFFFFFFFFFFF & l2;
      j += 1;
      paramArrayOfLong2[j] ^= l3 << 5 ^ l2 >>> 59;
      i += 1;
    }
  }
  
  protected static void implSquare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 0;
    while (i < 6)
    {
      Interleave.expand64To128(paramArrayOfLong1[i], paramArrayOfLong2, i << 1);
      i += 1;
    }
    paramArrayOfLong2[12] = Interleave.expand32to64((int)paramArrayOfLong1[6]);
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat448.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat448.create64();
      long[] arrayOfLong2 = Nat448.create64();
      long[] arrayOfLong3 = Nat448.create64();
      square(paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 1, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong2, 1, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 3, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 6, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 12, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong3);
      squareN(arrayOfLong3, 24, arrayOfLong1);
      squareN(arrayOfLong1, 24, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 48, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 96, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 192, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong3, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat448.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat448.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void reduce(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    long l6 = paramArrayOfLong1[5];
    long l10 = paramArrayOfLong1[6];
    long l8 = paramArrayOfLong1[7];
    long l7 = paramArrayOfLong1[12];
    l8 ^= l7 >>> 2;
    long l9 = paramArrayOfLong1[11];
    l10 = l10 ^ l7 >>> 25 ^ l7 << 62 ^ l9 >>> 2;
    long l11 = paramArrayOfLong1[10];
    long l12 = paramArrayOfLong1[9];
    long l13 = paramArrayOfLong1[8];
    long l14 = l10 >>> 25;
    paramArrayOfLong2[0] = (l1 ^ l8 << 39 ^ l14);
    paramArrayOfLong2[1] = (l14 << 23 ^ l2 ^ l13 << 39 ^ l8 >>> 25 ^ l8 << 62);
    paramArrayOfLong2[2] = (l3 ^ l12 << 39 ^ l13 >>> 25 ^ l13 << 62 ^ l8 >>> 2);
    paramArrayOfLong2[3] = (l4 ^ l11 << 39 ^ l12 >>> 25 ^ l12 << 62 ^ l13 >>> 2);
    paramArrayOfLong2[4] = (l5 ^ l9 << 39 ^ l11 >>> 25 ^ l11 << 62 ^ l12 >>> 2);
    paramArrayOfLong2[5] = (l6 ^ l7 << 39 ^ l9 >>> 25 ^ l9 << 62 ^ l11 >>> 2);
    paramArrayOfLong2[6] = (l10 & 0x1FFFFFF);
  }
  
  public static void reduce39(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 6;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 25;
    paramArrayOfLong[paramInt] ^= l2;
    paramInt += 1;
    paramArrayOfLong[paramInt] = (l2 << 23 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x1FFFFFF);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = Interleave.unshuffle(paramArrayOfLong1[2]);
    long l5 = Interleave.unshuffle(paramArrayOfLong1[3]);
    long l6 = l4 >>> 32 | l5 & 0xFFFFFFFF00000000;
    long l7 = Interleave.unshuffle(paramArrayOfLong1[4]);
    long l8 = Interleave.unshuffle(paramArrayOfLong1[5]);
    long l9 = l7 >>> 32 | l8 & 0xFFFFFFFF00000000;
    long l10 = Interleave.unshuffle(paramArrayOfLong1[6]);
    long l11 = l10 >>> 32;
    paramArrayOfLong2[0] = ((l1 & 0xFFFFFFFF | l2 << 32) ^ l3 << 44);
    paramArrayOfLong2[1] = ((l4 & 0xFFFFFFFF | l5 << 32) ^ l6 << 44 ^ l3 >>> 20);
    paramArrayOfLong2[2] = ((l7 & 0xFFFFFFFF | l8 << 32) ^ l9 << 44 ^ l6 >>> 20);
    paramArrayOfLong2[3] = (l11 << 44 ^ l10 & 0xFFFFFFFF ^ l9 >>> 20 ^ l3 << 13);
    paramArrayOfLong2[4] = (l3 >>> 51 ^ l11 >>> 20 ^ l6 << 13);
    paramArrayOfLong2[5] = (l9 << 13 ^ l6 >>> 51);
    paramArrayOfLong2[6] = (l11 << 13 ^ l9 >>> 51);
  }
  
  public static void square(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(13);
    implSquare(paramArrayOfLong1, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(13);
    implSquare(paramArrayOfLong1, arrayOfLong);
    addExt(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareN(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(13);
    implSquare(paramArrayOfLong1, arrayOfLong);
    for (;;)
    {
      reduce(arrayOfLong, paramArrayOfLong2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      implSquare(paramArrayOfLong2, arrayOfLong);
    }
  }
  
  public static int trace(long[] paramArrayOfLong)
  {
    return (int)paramArrayOfLong[0] & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT409Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */