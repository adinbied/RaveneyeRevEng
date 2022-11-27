package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat576;

public class SecT571Field
{
  private static final long M59 = 576460752303423487L;
  private static final long RM = -1190112520884487202L;
  private static final long[] ROOT_Z = { 3161836309350906777L, -7642453882179322845L, -3821226941089661423L, 7312758566309945096L, -556661012383879292L, 8945041530681231562L, -4750851271514160027L, 6847946401097695794L, 541669439031730457L };
  
  private static void add(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, long[] paramArrayOfLong3, int paramInt3)
  {
    int i = 0;
    while (i < 9)
    {
      paramArrayOfLong1[(paramInt1 + i)] ^= paramArrayOfLong2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  public static void add(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    int i = 0;
    while (i < 9)
    {
      paramArrayOfLong1[i] ^= paramArrayOfLong2[i];
      i += 1;
    }
  }
  
  private static void addBothTo(long[] paramArrayOfLong1, int paramInt1, long[] paramArrayOfLong2, int paramInt2, long[] paramArrayOfLong3, int paramInt3)
  {
    int i = 0;
    while (i < 9)
    {
      int j = paramInt3 + i;
      paramArrayOfLong3[j] ^= paramArrayOfLong1[(paramInt1 + i)] ^ paramArrayOfLong2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  public static void addBothTo(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    int i = 0;
    while (i < 9)
    {
      paramArrayOfLong3[i] ^= paramArrayOfLong1[i] ^ paramArrayOfLong2[i];
      i += 1;
    }
  }
  
  public static void addExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    int i = 0;
    while (i < 18)
    {
      paramArrayOfLong1[i] ^= paramArrayOfLong2[i];
      i += 1;
    }
  }
  
  public static void addOne(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    int i = 1;
    while (i < 9)
    {
      paramArrayOfLong2[i] = paramArrayOfLong1[i];
      i += 1;
    }
  }
  
  public static long[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat576.fromBigInteger64(paramBigInteger);
    reduce5(paramBigInteger, 0);
    return paramBigInteger;
  }
  
  protected static void implMultiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    implMultiplyPrecomp(paramArrayOfLong1, precompMultiplicand(paramArrayOfLong2), paramArrayOfLong3);
  }
  
  protected static void implMultiplyPrecomp(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    int k = 56;
    int i = 56;
    int j;
    for (;;)
    {
      j = k;
      if (i < 0) {
        break;
      }
      j = 1;
      while (j < 9)
      {
        int m = (int)(paramArrayOfLong1[j] >>> i);
        addBothTo(paramArrayOfLong2, (m & 0xF) * 9, paramArrayOfLong2, ((m >>> 4 & 0xF) + 16) * 9, paramArrayOfLong3, j - 1);
        j += 2;
      }
      Nat.shiftUpBits64(16, paramArrayOfLong3, 0, 8, 0L);
      i -= 8;
    }
    while (j >= 0)
    {
      i = 0;
      while (i < 9)
      {
        k = (int)(paramArrayOfLong1[i] >>> j);
        addBothTo(paramArrayOfLong2, (k & 0xF) * 9, paramArrayOfLong2, ((k >>> 4 & 0xF) + 16) * 9, paramArrayOfLong3, i);
        i += 2;
      }
      if (j > 0) {
        Nat.shiftUpBits64(18, paramArrayOfLong3, 0, 8, 0L);
      }
      j -= 8;
    }
  }
  
  protected static void implMulwAcc(long[] paramArrayOfLong1, long paramLong, long[] paramArrayOfLong2, int paramInt)
  {
    long[] arrayOfLong = new long[32];
    arrayOfLong[1] = paramLong;
    int i = 2;
    while (i < 32)
    {
      arrayOfLong[i] = (arrayOfLong[(i >>> 1)] << 1);
      arrayOfLong[(i + 1)] = (arrayOfLong[i] ^ paramLong);
      i += 2;
    }
    long l1 = 0L;
    i = 0;
    while (i < 9)
    {
      long l4 = paramArrayOfLong1[i];
      long l2 = l1 ^ arrayOfLong[((int)l4 & 0x1F)];
      int j = 60;
      l1 = 0L;
      long l3;
      long l5;
      int k;
      do
      {
        l3 = arrayOfLong[((int)(l4 >>> j) & 0x1F)];
        l5 = l2 ^ l3 << j;
        l3 = l1 ^ l3 >>> -j;
        k = j - 5;
        l2 = l5;
        j = k;
        l1 = l3;
      } while (k > 0);
      j = 0;
      l1 = l3;
      l2 = l4;
      while (j < 4)
      {
        l2 = (l2 & 0xEF7BDEF7BDEF7BDE) >>> 1;
        l1 ^= paramLong << j >> 63 & l2;
        j += 1;
      }
      j = paramInt + i;
      paramArrayOfLong2[j] = (l5 ^ paramArrayOfLong2[j]);
      i += 1;
    }
    paramInt += 9;
    paramArrayOfLong2[paramInt] ^= l1;
  }
  
  protected static void implSquare(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 0;
    while (i < 9)
    {
      Interleave.expand64To128(paramArrayOfLong1[i], paramArrayOfLong2, i << 1);
      i += 1;
    }
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat576.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat576.create64();
      long[] arrayOfLong2 = Nat576.create64();
      long[] arrayOfLong3 = Nat576.create64();
      square(paramArrayOfLong1, arrayOfLong3);
      square(arrayOfLong3, arrayOfLong1);
      square(arrayOfLong1, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 2, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong3, arrayOfLong1);
      squareN(arrayOfLong1, 5, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong2, 5, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 15, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong3);
      squareN(arrayOfLong3, 30, arrayOfLong1);
      squareN(arrayOfLong1, 30, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 60, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong2, 60, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 180, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong2, 180, arrayOfLong2);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong3, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat576.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat576.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyPrecomp(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat576.createExt64();
    implMultiplyPrecomp(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyPrecompAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat576.createExt64();
    implMultiplyPrecomp(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static long[] precompMultiplicand(long[] paramArrayOfLong)
  {
    long[] arrayOfLong = new long['Ġ'];
    int j = 0;
    System.arraycopy(paramArrayOfLong, 0, arrayOfLong, 9, 9);
    int i = 7;
    while (i > 0)
    {
      j += 18;
      Nat.shiftUpBit64(9, arrayOfLong, j >>> 1, 0L, arrayOfLong, j);
      reduce5(arrayOfLong, j);
      add(arrayOfLong, 9, arrayOfLong, j, arrayOfLong, j + 9);
      i -= 1;
    }
    Nat.shiftUpBits64(144, arrayOfLong, 0, 4, 0L, arrayOfLong, 144);
    return arrayOfLong;
  }
  
  public static void reduce(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l2 = paramArrayOfLong1[9];
    long l1 = paramArrayOfLong1[17];
    l2 = l2 ^ l1 >>> 59 ^ l1 >>> 57 ^ l1 >>> 54 ^ l1 >>> 49;
    l1 = l1 << 15 ^ paramArrayOfLong1[8] ^ l1 << 5 ^ l1 << 7 ^ l1 << 10;
    int i = 16;
    while (i >= 10)
    {
      l3 = paramArrayOfLong1[i];
      paramArrayOfLong2[(i - 8)] = (l1 ^ l3 >>> 59 ^ l3 >>> 57 ^ l3 >>> 54 ^ l3 >>> 49);
      l1 = paramArrayOfLong1[(i - 9)] ^ l3 << 5 ^ l3 << 7 ^ l3 << 10 ^ l3 << 15;
      i -= 1;
    }
    paramArrayOfLong2[1] = (l1 ^ l2 >>> 59 ^ l2 >>> 57 ^ l2 >>> 54 ^ l2 >>> 49);
    l1 = paramArrayOfLong1[0];
    long l3 = paramArrayOfLong2[8];
    long l4 = l3 >>> 59;
    paramArrayOfLong2[0] = (l2 << 15 ^ l1 ^ l2 << 5 ^ l2 << 7 ^ l2 << 10 ^ l4 ^ l4 << 2 ^ l4 << 5 ^ l4 << 10);
    paramArrayOfLong2[8] = (0x7FFFFFFFFFFFFFF & l3);
  }
  
  public static void reduce5(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 8;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 59;
    paramArrayOfLong[paramInt] = (l2 << 10 ^ l2 << 2 ^ l2 ^ l2 << 5 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFFFFFFFFFF);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong1 = Nat576.create64();
    long[] arrayOfLong2 = Nat576.create64();
    int i = 0;
    int j = 0;
    while (i < 4)
    {
      int k = j + 1;
      l1 = Interleave.unshuffle(paramArrayOfLong1[j]);
      j = k + 1;
      long l2 = Interleave.unshuffle(paramArrayOfLong1[k]);
      arrayOfLong1[i] = (0xFFFFFFFF & l1 | l2 << 32);
      arrayOfLong2[i] = (l1 >>> 32 | 0xFFFFFFFF00000000 & l2);
      i += 1;
    }
    long l1 = Interleave.unshuffle(paramArrayOfLong1[j]);
    arrayOfLong1[4] = (0xFFFFFFFF & l1);
    arrayOfLong2[4] = (l1 >>> 32);
    multiply(arrayOfLong2, ROOT_Z, paramArrayOfLong2);
    add(paramArrayOfLong2, arrayOfLong1, paramArrayOfLong2);
  }
  
  public static void square(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat576.createExt64();
    implSquare(paramArrayOfLong1, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat576.createExt64();
    implSquare(paramArrayOfLong1, arrayOfLong);
    addExt(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareN(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat576.createExt64();
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[8] >>> 49 ^ paramArrayOfLong[8] >>> 57) & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT571Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */