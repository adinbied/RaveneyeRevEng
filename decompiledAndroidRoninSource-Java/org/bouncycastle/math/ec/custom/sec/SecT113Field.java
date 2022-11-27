package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat128;

public class SecT113Field
{
  private static final long M49 = 562949953421311L;
  private static final long M57 = 144115188075855871L;
  
  public static void add(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    long l = paramArrayOfLong1[1];
    paramArrayOfLong2[1] ^= l;
  }
  
  public static void addExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    long l = paramArrayOfLong1[3];
    paramArrayOfLong2[3] ^= l;
  }
  
  public static void addOne(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
  }
  
  public static long[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat128.fromBigInteger64(paramBigInteger);
    reduce15(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  protected static void implMultiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long l2 = paramArrayOfLong1[0];
    long l1 = (paramArrayOfLong1[1] << 7 ^ l2 >>> 57) & 0x1FFFFFFFFFFFFFF;
    l2 &= 0x1FFFFFFFFFFFFFF;
    long l4 = paramArrayOfLong2[0];
    long l3 = (paramArrayOfLong2[1] << 7 ^ l4 >>> 57) & 0x1FFFFFFFFFFFFFF;
    l4 = 0x1FFFFFFFFFFFFFF & l4;
    paramArrayOfLong1 = new long[6];
    implMulw(l2, l4, paramArrayOfLong1, 0);
    implMulw(l1, l3, paramArrayOfLong1, 2);
    implMulw(l2 ^ l1, l4 ^ l3, paramArrayOfLong1, 4);
    l4 = paramArrayOfLong1[1] ^ paramArrayOfLong1[2];
    l1 = paramArrayOfLong1[0];
    l2 = paramArrayOfLong1[3];
    l3 = paramArrayOfLong1[4] ^ l1 ^ l4;
    l4 ^= paramArrayOfLong1[5] ^ l2;
    paramArrayOfLong3[0] = (l1 ^ l3 << 57);
    paramArrayOfLong3[1] = (l3 >>> 7 ^ l4 << 50);
    paramArrayOfLong3[2] = (l4 >>> 14 ^ l2 << 43);
    paramArrayOfLong3[3] = (l2 >>> 21);
  }
  
  protected static void implMulw(long paramLong1, long paramLong2, long[] paramArrayOfLong, int paramInt)
  {
    long[] arrayOfLong = new long[8];
    arrayOfLong[1] = paramLong2;
    arrayOfLong[2] = (arrayOfLong[1] << 1);
    arrayOfLong[3] = (arrayOfLong[2] ^ paramLong2);
    arrayOfLong[4] = (arrayOfLong[2] << 1);
    arrayOfLong[5] = (arrayOfLong[4] ^ paramLong2);
    arrayOfLong[6] = (arrayOfLong[3] << 1);
    arrayOfLong[7] = (arrayOfLong[6] ^ paramLong2);
    long l2 = arrayOfLong[((int)paramLong1 & 0x7)];
    long l1 = 0L;
    int i = 48;
    int j;
    long l3;
    long l4;
    do
    {
      j = (int)(paramLong1 >>> i);
      l3 = arrayOfLong[(j & 0x7)];
      l4 = arrayOfLong[(j >>> 3 & 0x7)];
      l4 = arrayOfLong[(j >>> 6 & 0x7)] << 6 ^ l3 ^ l4 << 3;
      l3 = l2 ^ l4 << i;
      l4 = l1 ^ l4 >>> -i;
      j = i - 9;
      l2 = l3;
      l1 = l4;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] = (0x1FFFFFFFFFFFFFF & l3);
    paramArrayOfLong[(paramInt + 1)] = (((paramLong1 & 0x100804020100800 & paramLong2 << 7 >> 63) >>> 8 ^ l4) << 7 ^ l3 >>> 57);
  }
  
  protected static void implSquare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Interleave.expand64To128(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    Interleave.expand64To128(paramArrayOfLong1[1], paramArrayOfLong2, 2);
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat128.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat128.create64();
      long[] arrayOfLong2 = Nat128.create64();
      square(paramArrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      square(arrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 3, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      square(arrayOfLong2, arrayOfLong2);
      multiply(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 7, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 14, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 28, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 56, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      square(arrayOfLong2, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat128.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat128.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void reduce(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l3 = paramArrayOfLong1[1];
    long l2 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    l2 ^= l4 >>> 40 ^ l4 >>> 49;
    l3 = l3 ^ l4 << 15 ^ l4 << 24 ^ l2 >>> 40 ^ l2 >>> 49;
    l4 = l3 >>> 49;
    paramArrayOfLong2[0] = (l1 ^ l2 << 15 ^ l2 << 24 ^ l4 ^ l4 << 9);
    paramArrayOfLong2[1] = (0x1FFFFFFFFFFFF & l3);
  }
  
  public static void reduce15(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 1;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 49;
    paramArrayOfLong[paramInt] = (l2 ^ l2 << 9 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x1FFFFFFFFFFFF);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    paramArrayOfLong2[0] = (l3 << 57 ^ (0xFFFFFFFF & l1 | l2 << 32) ^ l3 << 5);
    paramArrayOfLong2[1] = (l3 >>> 59 ^ l3 >>> 7);
  }
  
  public static void square(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat128.createExt64();
    implSquare(paramArrayOfLong1, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat128.createExt64();
    implSquare(paramArrayOfLong1, arrayOfLong);
    addExt(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareN(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat128.createExt64();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT113Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */