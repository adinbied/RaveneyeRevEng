package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat256;

public class SecT239Field
{
  private static final long M47 = 140737488355327L;
  private static final long M60 = 1152921504606846975L;
  
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
    paramArrayOfLong1[6] ^= paramArrayOfLong2[6];
    long l = paramArrayOfLong1[7];
    paramArrayOfLong2[7] ^= l;
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
    reduce17(paramBigInteger, 0);
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
    paramArrayOfLong[0] = (l1 ^ l2 << 60);
    paramArrayOfLong[1] = (l2 >>> 4 ^ l3 << 56);
    paramArrayOfLong[2] = (l3 >>> 8 ^ l4 << 52);
    paramArrayOfLong[3] = (l4 >>> 12 ^ l5 << 48);
    paramArrayOfLong[4] = (l5 >>> 16 ^ l6 << 44);
    paramArrayOfLong[5] = (l6 >>> 20 ^ l7 << 40);
    paramArrayOfLong[6] = (l7 >>> 24 ^ l8 << 36);
    paramArrayOfLong[7] = (l8 >>> 28);
  }
  
  protected static void implExpand(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    paramArrayOfLong2[0] = (l1 & 0xFFFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 60 ^ l2 << 4) & 0xFFFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 56 ^ l3 << 8) & 0xFFFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = (l3 >>> 52 ^ l4 << 12);
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
    long l1 = arrayOfLong[(i & 0x7)];
    long l2 = arrayOfLong[(i >>> 3 & 0x7)] << 3 ^ l1;
    l1 = 0L;
    i = 54;
    int j;
    long l3;
    long l4;
    do
    {
      j = (int)(paramLong1 >>> i);
      l3 = arrayOfLong[(j & 0x7)];
      l4 = arrayOfLong[(j >>> 3 & 0x7)] << 3 ^ l3;
      l3 = l2 ^ l4 << i;
      l4 = l1 ^ l4 >>> -i;
      j = i - 6;
      l2 = l3;
      l1 = l4;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] ^= 0xFFFFFFFFFFFFFFF & l3;
    paramInt += 1;
    paramArrayOfLong[paramInt] = (((paramLong1 & 0x820820820820820 & paramLong2 << 4 >> 63) >>> 5 ^ l4) << 4 ^ l3 >>> 60 ^ paramArrayOfLong[paramInt]);
  }
  
  protected static void implSquare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    Interleave.expand64To128(paramArrayOfLong1[0], paramArrayOfLong2, 0);
    Interleave.expand64To128(paramArrayOfLong1[1], paramArrayOfLong2, 2);
    Interleave.expand64To128(paramArrayOfLong1[2], paramArrayOfLong2, 4);
    long l = paramArrayOfLong1[3];
    paramArrayOfLong2[6] = Interleave.expand32to64((int)l);
    paramArrayOfLong2[7] = (Interleave.expand16to32((int)(l >>> 32)) & 0xFFFFFFFF);
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat256.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat256.create64();
      long[] arrayOfLong2 = Nat256.create64();
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
      square(arrayOfLong2, arrayOfLong2);
      multiply(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 29, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      square(arrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 59, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      square(arrayOfLong2, arrayOfLong2);
      multiply(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 119, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      square(arrayOfLong1, paramArrayOfLong2);
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
    long l5 = paramArrayOfLong1[3];
    long l8 = paramArrayOfLong1[4];
    long l7 = paramArrayOfLong1[5];
    long l4 = paramArrayOfLong1[6];
    long l6 = paramArrayOfLong1[7];
    l4 ^= l6 >>> 17;
    l7 = l7 ^ l6 << 47 ^ l4 >>> 17;
    l8 = l8 ^ l6 >>> 47 ^ l4 << 47 ^ l7 >>> 17;
    l5 = l5 ^ l6 << 17 ^ l4 >>> 47 ^ l7 << 47 ^ l8 >>> 17;
    l6 = l5 >>> 47;
    paramArrayOfLong2[0] = (l1 ^ l8 << 17 ^ l6);
    paramArrayOfLong2[1] = (l2 ^ l7 << 17 ^ l8 >>> 47);
    paramArrayOfLong2[2] = (l6 << 30 ^ l3 ^ l4 << 17 ^ l7 >>> 47 ^ l8 << 47);
    paramArrayOfLong2[3] = (0x7FFFFFFFFFFF & l5);
  }
  
  public static void reduce17(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 47;
    paramArrayOfLong[paramInt] ^= l2;
    paramInt += 2;
    paramArrayOfLong[paramInt] = (l2 << 30 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFFFFFFF);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 0;
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    long l3 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l4 = Interleave.unshuffle(paramArrayOfLong1[2]);
    long l5 = Interleave.unshuffle(paramArrayOfLong1[3]);
    long l8 = l5 & 0xFFFFFFFF00000000 | l4 >>> 32;
    long l6 = l8 >>> 49;
    long l7 = l3 >>> 49 | l8 << 15;
    l8 ^= l3 << 15;
    long[] arrayOfLong = Nat256.createExt64();
    paramArrayOfLong1 = new int[2];
    paramArrayOfLong1[0] = 39;
    paramArrayOfLong1[1] = 120;
    paramArrayOfLong1;
    while (i < 2)
    {
      int k = paramArrayOfLong1[i] >>> 6;
      int m = paramArrayOfLong1[i] & 0x3F;
      arrayOfLong[k] ^= l3 << m;
      int n = k + 1;
      long l9 = arrayOfLong[n];
      int j = -m;
      arrayOfLong[n] = (l9 ^ (l8 << m | l3 >>> j));
      n = k + 2;
      arrayOfLong[n] ^= (l7 << m | l8 >>> j);
      n = k + 3;
      arrayOfLong[n] ^= (l6 << m | l7 >>> j);
      k += 4;
      arrayOfLong[k] ^= l6 >>> j;
      i += 1;
    }
    reduce(arrayOfLong, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= (l4 & 0xFFFFFFFF | l5 << 32);
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[1] >>> 17 ^ paramArrayOfLong[2] >>> 34) & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT239Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */