package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat256;

public class SecT193Field
{
  private static final long M01 = 1L;
  private static final long M49 = 562949953421311L;
  
  public static void add(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    long l = paramArrayOfLong1[3];
    paramArrayOfLong2[3] ^= l;
  }
  
  public static void addExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
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
  
  public static void addOne(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
  }
  
  public static long[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat256.fromBigInteger64(paramBigInteger);
    reduce63(paramBigInteger, 0);
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
    paramArrayOfLong[0] = (l1 ^ l2 << 49);
    paramArrayOfLong[1] = (l2 >>> 15 ^ l3 << 34);
    paramArrayOfLong[2] = (l3 >>> 30 ^ l4 << 19);
    paramArrayOfLong[3] = (l4 >>> 45 ^ l5 << 4 ^ l6 << 53);
    paramArrayOfLong[4] = (l5 >>> 60 ^ l7 << 38 ^ l6 >>> 11);
    paramArrayOfLong[5] = (l7 >>> 26 ^ l8 << 23);
    paramArrayOfLong[6] = (l8 >>> 41);
    paramArrayOfLong[7] = 0L;
  }
  
  protected static void implExpand(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    paramArrayOfLong2[0] = (l1 & 0x1FFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 49 ^ l2 << 15) & 0x1FFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 34 ^ l3 << 30) & 0x1FFFFFFFFFFFF);
    paramArrayOfLong2[3] = (l3 >>> 19 ^ l4 << 45);
  }
  
  protected static void implMultiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong1 = new long[4];
    long[] arrayOfLong2 = new long[4];
    implExpand(paramArrayOfLong1, arrayOfLong1);
    implExpand(paramArrayOfLong2, arrayOfLong2);
    implMulwAcc(arrayOfLong1[0], arrayOfLong2[0], paramArrayOfLong3, 0);
    implMulwAcc(arrayOfLong1[1], arrayOfLong2[1], paramArrayOfLong3, 1);
    implMulwAcc(arrayOfLong1[2], arrayOfLong2[2], paramArrayOfLong3, 2);
    implMulwAcc(arrayOfLong1[3], arrayOfLong2[3], paramArrayOfLong3, 3);
    int i = 5;
    while (i > 0)
    {
      paramArrayOfLong3[i] ^= paramArrayOfLong3[(i - 1)];
      i -= 1;
    }
    implMulwAcc(arrayOfLong1[0] ^ arrayOfLong1[1], arrayOfLong2[0] ^ arrayOfLong2[1], paramArrayOfLong3, 1);
    implMulwAcc(arrayOfLong1[2] ^ arrayOfLong1[3], arrayOfLong2[2] ^ arrayOfLong2[3], paramArrayOfLong3, 3);
    i = 7;
    while (i > 1)
    {
      paramArrayOfLong3[i] ^= paramArrayOfLong3[(i - 2)];
      i -= 1;
    }
    long l1 = arrayOfLong1[0] ^ arrayOfLong1[2];
    long l2 = arrayOfLong1[1] ^ arrayOfLong1[3];
    long l3 = arrayOfLong2[0] ^ arrayOfLong2[2];
    long l4 = arrayOfLong2[1] ^ arrayOfLong2[3];
    implMulwAcc(l1 ^ l2, l3 ^ l4, paramArrayOfLong3, 3);
    paramArrayOfLong1 = new long[3];
    implMulwAcc(l1, l3, paramArrayOfLong1, 0);
    implMulwAcc(l2, l4, paramArrayOfLong1, 1);
    l1 = paramArrayOfLong1[0];
    l2 = paramArrayOfLong1[1];
    l3 = paramArrayOfLong1[2];
    paramArrayOfLong3[2] ^= l1;
    paramArrayOfLong3[3] = (l1 ^ l2 ^ paramArrayOfLong3[3]);
    paramArrayOfLong3[4] ^= l3 ^ l2;
    paramArrayOfLong3[5] ^= l3;
    implCompactExt(paramArrayOfLong3);
  }
  
  protected static void implMulwAcc(long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong = new long[8];
    arrayOfLong[1] = paramLong2;
    arrayOfLong[2] = (arrayOfLong[1] << 1);
    arrayOfLong[3] = (arrayOfLong[2] ^ paramLong2);
    arrayOfLong[4] = (arrayOfLong[2] << 1);
    arrayOfLong[5] = (arrayOfLong[4] ^ paramLong2);
    arrayOfLong[6] = (arrayOfLong[3] << 1);
    arrayOfLong[7] = (arrayOfLong[6] ^ paramLong2);
    int i = (int)paramLong1;
    paramLong2 = arrayOfLong[(i & 0x7)];
    long l1 = arrayOfLong[(i >>> 3 & 0x7)] << 3 ^ paramLong2;
    paramLong2 = 0L;
    i = 36;
    int j;
    long l2;
    long l3;
    do
    {
      j = (int)(paramLong1 >>> i);
      l2 = arrayOfLong[(j & 0x7)];
      l3 = arrayOfLong[(j >>> 3 & 0x7)];
      long l4 = arrayOfLong[(j >>> 6 & 0x7)];
      long l5 = arrayOfLong[(j >>> 9 & 0x7)];
      l3 = arrayOfLong[(j >>> 12 & 0x7)] << 12 ^ l2 ^ l3 << 3 ^ l4 << 6 ^ l5 << 9;
      l2 = l1 ^ l3 << i;
      l3 = paramLong2 ^ l3 >>> -i;
      j = i - 15;
      l1 = l2;
      paramLong2 = l3;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] ^= 0x1FFFFFFFFFFFF & l2;
    paramInt += 1;
    paramArrayOfLong[paramInt] ^= l2 >>> 49 ^ l3 << 15;
  }
  
  protected static void implSquare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Interleave.expand64To128(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    Interleave.expand64To128(paramArrayOfLong1[1], paramArrayOfLong2, 2);
    Interleave.expand64To128(paramArrayOfLong1[2], paramArrayOfLong2, 4);
    paramArrayOfLong2[6] = (paramArrayOfLong1[3] & 1L);
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat256.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat256.create64();
      long[] arrayOfLong2 = Nat256.create64();
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
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 24, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 48, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 96, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat256.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat256.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void reduce(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l7 = paramArrayOfLong1[3];
    long l6 = paramArrayOfLong1[4];
    long l4 = paramArrayOfLong1[5];
    long l5 = paramArrayOfLong1[6];
    l6 ^= l5 >>> 50;
    l7 = l7 ^ l5 >>> 1 ^ l5 << 14 ^ l4 >>> 50;
    long l8 = l7 >>> 1;
    paramArrayOfLong2[0] = (l1 ^ l6 << 63 ^ l8 ^ l8 << 15);
    paramArrayOfLong2[1] = (l8 >>> 49 ^ l2 ^ l4 << 63 ^ l6 >>> 1 ^ l6 << 14);
    paramArrayOfLong2[2] = (l3 ^ l5 << 63 ^ l4 >>> 1 ^ l4 << 14 ^ l6 >>> 50);
    paramArrayOfLong2[3] = (1L & l7);
  }
  
  public static void reduce63(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 1;
    paramArrayOfLong[paramInt] ^= l2 << 15 ^ l2;
    paramInt += 1;
    paramArrayOfLong[paramInt] = (l2 >>> 49 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 1L);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = Interleave.unshuffle(paramArrayOfLong1[2]);
    long l5 = paramArrayOfLong1[3];
    long l6 = l4 >>> 32;
    paramArrayOfLong2[0] = ((l1 & 0xFFFFFFFF | l2 << 32) ^ l3 << 8);
    paramArrayOfLong2[1] = (l4 & 0xFFFFFFFF ^ l5 << 32 ^ l6 << 8 ^ l3 >>> 56 ^ l3 << 33);
    paramArrayOfLong2[2] = (l3 >>> 31 ^ l6 >>> 56 ^ l6 << 33);
    paramArrayOfLong2[3] = (l6 >>> 31);
  }
  
  public static void square(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat256.createExt64();
    implSquare(paramArrayOfLong1, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat256.createExt64();
    implSquare(paramArrayOfLong1, arrayOfLong);
    addExt(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareN(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat256.createExt64();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT193Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */