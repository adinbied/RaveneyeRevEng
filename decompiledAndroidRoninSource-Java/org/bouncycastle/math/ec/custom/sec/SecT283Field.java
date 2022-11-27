package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Interleave;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat320;

public class SecT283Field
{
  private static final long M27 = 134217727L;
  private static final long M57 = 144115188075855871L;
  private static final long[] ROOT_Z = { 878416384462358536L, 3513665537849438403L, -9076969306111048948L, 585610922974906400L, 34087042L };
  
  public static void add(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    paramArrayOfLong1[0] ^= paramArrayOfLong2[0];
    paramArrayOfLong1[1] ^= paramArrayOfLong2[1];
    paramArrayOfLong1[2] ^= paramArrayOfLong2[2];
    paramArrayOfLong1[3] ^= paramArrayOfLong2[3];
    long l = paramArrayOfLong1[4];
    paramArrayOfLong2[4] ^= l;
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
    paramArrayOfLong1[7] ^= paramArrayOfLong2[7];
    long l = paramArrayOfLong1[8];
    paramArrayOfLong2[8] ^= l;
  }
  
  public static void addOne(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong1[0] ^= 1L;
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
    paramArrayOfLong2[3] = paramArrayOfLong1[3];
    paramArrayOfLong2[4] = paramArrayOfLong1[4];
  }
  
  public static long[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat320.fromBigInteger64(paramBigInteger);
    reduce37(paramBigInteger, 0);
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
    paramArrayOfLong[0] = (l1 ^ l2 << 57);
    paramArrayOfLong[1] = (l2 >>> 7 ^ l3 << 50);
    paramArrayOfLong[2] = (l3 >>> 14 ^ l4 << 43);
    paramArrayOfLong[3] = (l4 >>> 21 ^ l5 << 36);
    paramArrayOfLong[4] = (l5 >>> 28 ^ l6 << 29);
    paramArrayOfLong[5] = (l6 >>> 35 ^ l7 << 22);
    paramArrayOfLong[6] = (l7 >>> 42 ^ l8 << 15);
    paramArrayOfLong[7] = (l8 >>> 49 ^ l9 << 8);
    paramArrayOfLong[8] = (l9 >>> 56 ^ l10 << 1);
    paramArrayOfLong[9] = (l10 >>> 63);
  }
  
  protected static void implExpand(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l5 = paramArrayOfLong1[4];
    paramArrayOfLong2[0] = (l1 & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[1] = ((l1 >>> 57 ^ l2 << 7) & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[2] = ((l2 >>> 50 ^ l3 << 14) & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[3] = ((l3 >>> 43 ^ l4 << 21) & 0x1FFFFFFFFFFFFFF);
    paramArrayOfLong2[4] = (l4 >>> 36 ^ l5 << 28);
  }
  
  protected static void implMultiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong1 = new long[5];
    long[] arrayOfLong2 = new long[5];
    implExpand(paramArrayOfLong1, arrayOfLong1);
    implExpand(paramArrayOfLong2, arrayOfLong2);
    paramArrayOfLong1 = new long[26];
    implMulw(arrayOfLong1[0], arrayOfLong2[0], paramArrayOfLong1, 0);
    implMulw(arrayOfLong1[1], arrayOfLong2[1], paramArrayOfLong1, 2);
    implMulw(arrayOfLong1[2], arrayOfLong2[2], paramArrayOfLong1, 4);
    implMulw(arrayOfLong1[3], arrayOfLong2[3], paramArrayOfLong1, 6);
    implMulw(arrayOfLong1[4], arrayOfLong2[4], paramArrayOfLong1, 8);
    long l1 = arrayOfLong1[0] ^ arrayOfLong1[1];
    long l2 = arrayOfLong2[0] ^ arrayOfLong2[1];
    long l3 = arrayOfLong1[0] ^ arrayOfLong1[2];
    long l4 = arrayOfLong2[0] ^ arrayOfLong2[2];
    long l5 = arrayOfLong1[2] ^ arrayOfLong1[4];
    long l6 = arrayOfLong2[2] ^ arrayOfLong2[4];
    long l7 = arrayOfLong1[3] ^ arrayOfLong1[4];
    long l8 = arrayOfLong2[3] ^ arrayOfLong2[4];
    implMulw(l3 ^ arrayOfLong1[3], l4 ^ arrayOfLong2[3], paramArrayOfLong1, 18);
    implMulw(l5 ^ arrayOfLong1[1], l6 ^ arrayOfLong2[1], paramArrayOfLong1, 20);
    long l9 = l1 ^ l7;
    long l10 = l2 ^ l8;
    long l11 = arrayOfLong1[2];
    long l12 = arrayOfLong2[2];
    implMulw(l9, l10, paramArrayOfLong1, 22);
    implMulw(l9 ^ l11, l12 ^ l10, paramArrayOfLong1, 24);
    implMulw(l1, l2, paramArrayOfLong1, 10);
    implMulw(l3, l4, paramArrayOfLong1, 12);
    implMulw(l5, l6, paramArrayOfLong1, 14);
    implMulw(l7, l8, paramArrayOfLong1, 16);
    paramArrayOfLong3[0] = paramArrayOfLong1[0];
    paramArrayOfLong3[9] = paramArrayOfLong1[9];
    l3 = paramArrayOfLong1[0] ^ paramArrayOfLong1[1];
    l2 = paramArrayOfLong1[2] ^ l3;
    l1 = paramArrayOfLong1[10] ^ l2;
    paramArrayOfLong3[1] = l1;
    l4 = paramArrayOfLong1[3] ^ paramArrayOfLong1[4];
    l2 ^= l4 ^ paramArrayOfLong1[11] ^ paramArrayOfLong1[12];
    paramArrayOfLong3[2] = l2;
    l6 = paramArrayOfLong1[5] ^ paramArrayOfLong1[6];
    l3 = l3 ^ l4 ^ l6 ^ paramArrayOfLong1[8];
    l4 = paramArrayOfLong1[13] ^ paramArrayOfLong1[14];
    paramArrayOfLong3[3] = (l3 ^ l4 ^ paramArrayOfLong1[18] ^ paramArrayOfLong1[22] ^ paramArrayOfLong1[24]);
    l7 = paramArrayOfLong1[7] ^ paramArrayOfLong1[8] ^ paramArrayOfLong1[9];
    l5 = l7 ^ paramArrayOfLong1[17];
    paramArrayOfLong3[8] = l5;
    l6 = l7 ^ l6 ^ paramArrayOfLong1[15] ^ paramArrayOfLong1[16];
    paramArrayOfLong3[7] = l6;
    l9 = paramArrayOfLong1[19];
    l10 = paramArrayOfLong1[20];
    l11 = paramArrayOfLong1[25];
    l12 = paramArrayOfLong1[24];
    l7 = paramArrayOfLong1[18];
    l8 = paramArrayOfLong1[23];
    l9 = l9 ^ l10 ^ l11 ^ l12;
    paramArrayOfLong3[4] = (l9 ^ l7 ^ l8 ^ l1 ^ l6);
    paramArrayOfLong3[5] = (l2 ^ l5 ^ l9 ^ paramArrayOfLong1[21] ^ paramArrayOfLong1[22]);
    l1 = paramArrayOfLong1[0];
    paramArrayOfLong3[6] = (paramArrayOfLong1[9] ^ l3 ^ l1 ^ l4 ^ paramArrayOfLong1[21] ^ paramArrayOfLong1[23] ^ paramArrayOfLong1[25]);
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
    int i = 0;
    while (i < 4)
    {
      Interleave.expand64To128(paramArrayOfLong1[i], paramArrayOfLong2, i << 1);
      i += 1;
    }
    paramArrayOfLong2[8] = Interleave.expand32to64((int)paramArrayOfLong1[4]);
  }
  
  public static void invert(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    if (!Nat320.isZero64(paramArrayOfLong1))
    {
      long[] arrayOfLong1 = Nat320.create64();
      long[] arrayOfLong2 = Nat320.create64();
      square(paramArrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 2, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 4, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      squareN(arrayOfLong1, 8, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      square(arrayOfLong2, arrayOfLong2);
      multiply(arrayOfLong2, paramArrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 17, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      square(arrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 35, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      squareN(arrayOfLong2, 70, arrayOfLong1);
      multiply(arrayOfLong1, arrayOfLong2, arrayOfLong1);
      square(arrayOfLong1, arrayOfLong1);
      multiply(arrayOfLong1, paramArrayOfLong1, arrayOfLong1);
      squareN(arrayOfLong1, 141, arrayOfLong2);
      multiply(arrayOfLong2, arrayOfLong1, arrayOfLong2);
      square(arrayOfLong2, paramArrayOfLong2);
      return;
    }
    throw new IllegalStateException();
  }
  
  public static void multiply(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat320.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong3);
  }
  
  public static void multiplyAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2, long[] paramArrayOfLong3)
  {
    long[] arrayOfLong = Nat320.createExt64();
    implMultiply(paramArrayOfLong1, paramArrayOfLong2, arrayOfLong);
    addExt(paramArrayOfLong3, arrayOfLong, paramArrayOfLong3);
  }
  
  public static void reduce(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long l1 = paramArrayOfLong1[0];
    long l2 = paramArrayOfLong1[1];
    long l3 = paramArrayOfLong1[2];
    long l4 = paramArrayOfLong1[3];
    long l9 = paramArrayOfLong1[4];
    long l5 = paramArrayOfLong1[5];
    long l6 = paramArrayOfLong1[6];
    long l7 = paramArrayOfLong1[7];
    long l8 = paramArrayOfLong1[8];
    l9 ^= l8 >>> 27 ^ l8 >>> 22 ^ l8 >>> 20 ^ l8 >>> 15;
    long l10 = l9 >>> 27;
    paramArrayOfLong2[0] = (l1 ^ l5 << 37 ^ l5 << 42 ^ l5 << 44 ^ l5 << 49 ^ l10 ^ l10 << 5 ^ l10 << 7 ^ l10 << 12);
    paramArrayOfLong2[1] = (l2 ^ l6 << 37 ^ l6 << 42 ^ l6 << 44 ^ l6 << 49 ^ l5 >>> 27 ^ l5 >>> 22 ^ l5 >>> 20 ^ l5 >>> 15);
    paramArrayOfLong2[2] = (l3 ^ l7 << 37 ^ l7 << 42 ^ l7 << 44 ^ l7 << 49 ^ l6 >>> 27 ^ l6 >>> 22 ^ l6 >>> 20 ^ l6 >>> 15);
    paramArrayOfLong2[3] = (l4 ^ l8 << 37 ^ l8 << 42 ^ l8 << 44 ^ l8 << 49 ^ l7 >>> 27 ^ l7 >>> 22 ^ l7 >>> 20 ^ l7 >>> 15);
    paramArrayOfLong2[4] = (0x7FFFFFF & l9);
  }
  
  public static void reduce37(long[] paramArrayOfLong, int paramInt)
  {
    int i = paramInt + 4;
    long l1 = paramArrayOfLong[i];
    long l2 = l1 >>> 27;
    paramArrayOfLong[paramInt] = (l2 << 12 ^ l2 << 5 ^ l2 ^ l2 << 7 ^ paramArrayOfLong[paramInt]);
    paramArrayOfLong[i] = (l1 & 0x7FFFFFF);
  }
  
  public static void sqrt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat320.create64();
    long l1 = Interleave.unshuffle(paramArrayOfLong1[0]);
    long l2 = Interleave.unshuffle(paramArrayOfLong1[1]);
    arrayOfLong[0] = (l1 >>> 32 | l2 & 0xFFFFFFFF00000000);
    long l3 = Interleave.unshuffle(paramArrayOfLong1[2]);
    long l4 = Interleave.unshuffle(paramArrayOfLong1[3]);
    arrayOfLong[1] = (l3 >>> 32 | 0xFFFFFFFF00000000 & l4);
    long l5 = Interleave.unshuffle(paramArrayOfLong1[4]);
    arrayOfLong[2] = (l5 >>> 32);
    multiply(arrayOfLong, ROOT_Z, paramArrayOfLong2);
    paramArrayOfLong2[0] ^= (l1 & 0xFFFFFFFF | l2 << 32);
    paramArrayOfLong2[1] ^= (l3 & 0xFFFFFFFF | l4 << 32);
    paramArrayOfLong2[2] ^= 0xFFFFFFFF & l5;
  }
  
  public static void square(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(9);
    implSquare(paramArrayOfLong1, arrayOfLong);
    reduce(arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareAddToExt(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(9);
    implSquare(paramArrayOfLong1, arrayOfLong);
    addExt(paramArrayOfLong2, arrayOfLong, paramArrayOfLong2);
  }
  
  public static void squareN(long[] paramArrayOfLong1, int paramInt, long[] paramArrayOfLong2)
  {
    long[] arrayOfLong = Nat.create64(9);
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
    return (int)(paramArrayOfLong[0] ^ paramArrayOfLong[4] >>> 15) & 0x1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecT283Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */