package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

public class SecT131Field
{
  private static final long M03 = 7L;
  private static final long M44 = 17592186044415L;
  private static final long[] ROOT_Z = { 2791191049453778211L, 2791191049453778402L, 6L };
  
  public static void add(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    long l = paramArrayOfLong1[2];
    paramArrayOfLong2[2] ^= l;
  }
  
  public static void addExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    paramArrayOfLong1[3] ^= paramArrayOfLong2[3];
    long l = paramArrayOfLong1[4];
    paramArrayOfLong2[4] ^= l;
  }
  
  public static void addOne(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
  }
  
  public static long[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat192.fromBigInteger64(paramBigInteger);
    reduce61(paramBigInteger, 0);
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
    paramArrayOfLong[0] = (l1 ^ l2 << 44);
    paramArrayOfLong[1] = (l2 >>> 20 ^ l3 << 24);
    paramArrayOfLong[2] = (l3 >>> 40 ^ l4 << 4 ^ l5 << 48);
    paramArrayOfLong[3] = (l4 >>> 60 ^ l6 << 28 ^ l5 >>> 16);
    paramArrayOfLong[4] = (l6 >>> 36);
    paramArrayOfLong[5] = 0L;
  }
  
  protected static void implMultiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long l2 = paramArrayOfLong1[0];
    long l3 = paramArrayOfLong1[1];
    long l1 = (paramArrayOfLong1[2] << 40 ^ l3 >>> 24) & 0xFFFFFFFFFFF;
    l3 = (l3 << 20 ^ l2 >>> 44) & 0xFFFFFFFFFFF;
    l2 &= 0xFFFFFFFFFFF;
    long l6 = paramArrayOfLong2[0];
    long l5 = paramArrayOfLong2[1];
    long l4 = (l5 >>> 24 ^ paramArrayOfLong2[2] << 40) & 0xFFFFFFFFFFF;
    l5 = (l6 >>> 44 ^ l5 << 20) & 0xFFFFFFFFFFF;
    l6 &= 0xFFFFFFFFFFF;
    paramArrayOfLong1 = new long[10];
    implMulw(l2, l6, paramArrayOfLong1, 0);
    implMulw(l1, l4, paramArrayOfLong1, 2);
    long l7 = l2 ^ l3 ^ l1;
    long l8 = l6 ^ l5 ^ l4;
    implMulw(l7, l8, paramArrayOfLong1, 4);
    l1 = l3 << 1 ^ l1 << 2;
    l3 = l5 << 1 ^ l4 << 2;
    implMulw(l2 ^ l1, l6 ^ l3, paramArrayOfLong1, 6);
    implMulw(l7 ^ l1, l8 ^ l3, paramArrayOfLong1, 8);
    l6 = paramArrayOfLong1[6] ^ paramArrayOfLong1[8];
    l4 = paramArrayOfLong1[7] ^ paramArrayOfLong1[9];
    l5 = paramArrayOfLong1[6];
    l7 = paramArrayOfLong1[7];
    l1 = paramArrayOfLong1[0];
    l2 = paramArrayOfLong1[1] ^ paramArrayOfLong1[0] ^ paramArrayOfLong1[4];
    l3 = paramArrayOfLong1[1] ^ paramArrayOfLong1[5];
    l5 = l6 << 1 ^ l5 ^ l1 ^ paramArrayOfLong1[2] << 4 ^ paramArrayOfLong1[2] << 1;
    l6 = l2 ^ l6 ^ l4 << 1 ^ l7 ^ paramArrayOfLong1[3] << 4 ^ paramArrayOfLong1[3] << 1 ^ l5 >>> 44;
    l4 = l3 ^ l4 ^ l6 >>> 44;
    l6 &= 0xFFFFFFFFFFF;
    l5 = (l5 & 0xFFFFFFFFFFF) >>> 1 ^ (l6 & 1L) << 43;
    l5 ^= l5 << 1;
    l5 ^= l5 << 2;
    l5 ^= l5 << 4;
    l5 ^= l5 << 8;
    l5 ^= l5 << 16;
    l5 = (l5 ^ l5 << 32) & 0xFFFFFFFFFFF;
    l6 = l6 >>> 1 ^ (l4 & 1L) << 43 ^ l5 >>> 43;
    l6 ^= l6 << 1;
    l6 ^= l6 << 2;
    l6 ^= l6 << 4;
    l6 ^= l6 << 8;
    l6 ^= l6 << 16;
    l6 = (l6 ^ l6 << 32) & 0xFFFFFFFFFFF;
    l4 = l6 >>> 43 ^ l4 >>> 1;
    l4 ^= l4 << 1;
    l4 ^= l4 << 2;
    l4 ^= l4 << 4;
    l4 ^= l4 << 8;
    l4 ^= l4 << 16;
    l4 ^= l4 << 32;
    paramArrayOfLong3[0] = l1;
    paramArrayOfLong3[1] = (l2 ^ l5 ^ paramArrayOfLong1[2]);
    paramArrayOfLong3[2] = (l3 ^ l6 ^ l5 ^ paramArrayOfLong1[3]);
    paramArrayOfLong3[3] = (l4 ^ l6);
    paramArrayOfLong3[4] = (paramArrayOfLong1[2] ^ l4);
    paramArrayOfLong3[5] = paramArrayOfLong1[3];
    implCompactExt(paramArrayOfLong3);
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
    int i = (int)paramLong1;
    paramLong2 = arrayOfLong[(i & 0x7)];
    long l1 = arrayOfLong[(i >>> 3 & 0x7)];
    l1 = arrayOfLong[(i >>> 6 & 0x7)] << 6 ^ paramLong2 ^ l1 << 3;
    paramLong2 = 0L;
    i = 33;
    int j;
    long l2;
    long l3;
    do
    {
      j = (int)(paramLong1 >>> i);
      l2 = arrayOfLong[(j & 0x7)];
      l3 = arrayOfLong[(j >>> 3 & 0x7)];
      long l4 = arrayOfLong[(j >>> 6 & 0x7)];
      l3 = arrayOfLong[(j >>> 9 & 0x7)] << 9 ^ l2 ^ l3 << 3 ^ l4 << 6;
      l2 = l1 ^ l3 << i;
      l3 = paramLong2 ^ l3 >>> -i;
      j = i - 12;
      l1 = l2;
      paramLong2 = l3;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] = (0xFFFFFFFFFFF & l2);
    paramArrayOfLong[(paramInt + 1)] = (l2 >>> 44 ^ l3 << 20);
  }
  
  protected static void implSquare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Interleave.expand64To128(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    Interleave.expand64To128(paramArrayOfLong1[1], paramArrayOfLong2, 2);
    paramArrayOfLong2[4] = (Interleave.expand8to16((int)paramArrayOfLong1[2]) & 0xFFFFFFFF);
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat192.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat192.create64();
      long[] arrayOfLong2 = Nat192.create64();
      square(paramArrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 2, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 4, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 8, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 16, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 32, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      square(arrayOfLong2, arrayOfLong2);
      multiply(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 65, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      square(arrayOfLong1, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat192.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat192.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void reduce(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l5 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l3 = paramArrayOfLong1[4];
    l4 ^= l3 >>> 59;
    l5 = l5 ^ l3 >>> 3 ^ l3 >>> 1 ^ l3 ^ l3 << 5 ^ l4 >>> 59;
    long l6 = l5 >>> 3;
    paramArrayOfLong2[0] = (l1 ^ l4 << 61 ^ l4 << 63 ^ l6 ^ l6 << 2 ^ l6 << 3 ^ l6 << 8);
    paramArrayOfLong2[1] = (l6 >>> 56 ^ l2 ^ l3 << 61 ^ l3 << 63 ^ l4 >>> 3 ^ l4 >>> 1 ^ l4 ^ l4 << 5);
    paramArrayOfLong2[2] = (0x7 & l5);
  }
  
  public static void reduce61(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 2;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 3;
    paramArrayOfLong[paramInt] ^= l2 << 2 ^ l2 ^ l2 << 3 ^ l2 << 8;
    paramInt += 1;
    paramArrayOfLong[paramInt] = (l2 >>> 56 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat192.create64();
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    arrayOfLong[0] = (l1 >>> 32 | l2 & 0xFFFFFFFF00000000);
    long l3 = Interleave.unshuffle(paramArrayOfLong1[2]);
    arrayOfLong[1] = (l3 >>> 32);
    multiply(arrayOfLong, ROOT_Z, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= l3 & 0xFFFFFFFF;
  }
  
  public static void square(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(5);
    implSquare(paramArrayOfLong1, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(5);
    implSquare(paramArrayOfLong1, arrayOfLong);
    addExt(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareN(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(5);
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[1] >>> 59 ^ paramArrayOfLong[2] >>> 1) & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT131Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */