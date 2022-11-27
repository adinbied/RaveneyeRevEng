package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat256;

public class SecT233Field
{
  private static final long M41 = 2199023255551L;
  private static final long M59 = 576460752303423487L;
  
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
    reduce23(paramBigInteger, 0);
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
    paramArrayOfLong[0] = (l1 ^ l2 << 59);
    paramArrayOfLong[1] = (l2 >>> 5 ^ l3 << 54);
    paramArrayOfLong[2] = (l3 >>> 10 ^ l4 << 49);
    paramArrayOfLong[3] = (l4 >>> 15 ^ l5 << 44);
    paramArrayOfLong[4] = (l5 >>> 20 ^ l6 << 39);
    paramArrayOfLong[5] = (l6 >>> 25 ^ l7 << 34);
    paramArrayOfLong[6] = (l7 >>> 30 ^ l8 << 29);
    paramArrayOfLong[7] = (l8 >>> 35);
  }
  
  protected static void implExpand(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    paramArrayOfLong2[0] = (l1 & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 59 ^ l2 << 5) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 54 ^ l3 << 10) & 0x7FFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = (l3 >>> 49 ^ l4 << 15);
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
    i = 54;
    int j;
    long l2;
    long l3;
    do
    {
      j = (int)(paramLong1 >>> i);
      l2 = arrayOfLong[(j & 0x7)];
      l3 = arrayOfLong[(j >>> 3 & 0x7)] << 3 ^ l2;
      l2 = l1 ^ l3 << i;
      l3 = paramLong2 ^ l3 >>> -i;
      j = i - 6;
      l1 = l2;
      paramLong2 = l3;
      i = j;
    } while (j > 0);
    paramArrayOfLong[paramInt] ^= 0x7FFFFFFFFFFFFFF & l2;
    paramInt += 1;
    paramArrayOfLong[paramInt] ^= l2 >>> 59 ^ l3 << 5;
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
      squareN(arrayOfLong1, 58, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 116, arrayOfLong1);
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
    long l6 = paramArrayOfLong1[3];
    long l8 = paramArrayOfLong1[4];
    long l5 = paramArrayOfLong1[5];
    long l4 = paramArrayOfLong1[6];
    long l7 = paramArrayOfLong1[7];
    l5 ^= l7 >>> 31;
    l8 = l8 ^ l7 >>> 41 ^ l7 << 33 ^ l4 >>> 31;
    l6 = l6 ^ l7 << 23 ^ l4 >>> 41 ^ l4 << 33 ^ l5 >>> 31;
    l7 = l6 >>> 41;
    paramArrayOfLong2[0] = (l1 ^ l8 << 23 ^ l7);
    paramArrayOfLong2[1] = (l7 << 10 ^ l2 ^ l5 << 23 ^ l8 >>> 41 ^ l8 << 33);
    paramArrayOfLong2[2] = (l3 ^ l4 << 23 ^ l5 >>> 41 ^ l5 << 33 ^ l8 >>> 31);
    paramArrayOfLong2[3] = (0x1FFFFFFFFFF & l6);
  }
  
  public static void reduce23(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 3;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 41;
    paramArrayOfLong[paramInt] ^= l2;
    paramInt += 1;
    paramArrayOfLong[paramInt] = (l2 << 10 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x1FFFFFFFFFF);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    long l7 = l1 >>> 32 | l2 & 0xFFFFFFFF00000000;
    long l3 = Interleave.unshuffle(paramArrayOfLong1[2]);
    long l4 = Interleave.unshuffle(paramArrayOfLong1[3]);
    long l6 = l3 >>> 32 | l4 & 0xFFFFFFFF00000000;
    long l5 = l6 >>> 27;
    l6 ^= (l7 >>> 27 | l6 << 37);
    l7 ^= l7 << 37;
    paramArrayOfLong1 = Nat256.createExt64();
    int[] arrayOfInt = new int[3];
    int[] tmp104_102 = arrayOfInt;
    tmp104_102[0] = 32;
    int[] tmp109_104 = tmp104_102;
    tmp109_104[1] = 117;
    int[] tmp114_109 = tmp109_104;
    tmp114_109[2] = '¿';
    tmp114_109;
    int i = 0;
    while (i < 3)
    {
      int k = arrayOfInt[i] >>> 6;
      int m = arrayOfInt[i] & 0x3F;
      paramArrayOfLong1[k] ^= l7 << m;
      int n = k + 1;
      long l8 = paramArrayOfLong1[n];
      int j = -m;
      paramArrayOfLong1[n] = (l8 ^ (tmp109_104 << m | l7 >>> j));
      n = k + 2;
      paramArrayOfLong1[n] ^= (l5 << m | tmp109_104 >>> j);
      k += 3;
      paramArrayOfLong1[k] ^= l5 >>> j;
      i += 1;
    }
    reduce(paramArrayOfLong1, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= (0xFFFFFFFF & l3 | l4 << 32);
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[2] >>> 31) & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT233Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */