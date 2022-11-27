package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat192
{
  private static final long M = 4294967295L;
  
  public static int add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (paramArrayOfInt2[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int addBothTo(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + (paramArrayOfInt3[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF) + (paramArrayOfInt3[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF) + (paramArrayOfInt3[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF) + (paramArrayOfInt3[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF) + (paramArrayOfInt3[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (paramArrayOfInt2[5] & 0xFFFFFFFF) + (paramArrayOfInt3[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int addTo(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int paramInt3)
  {
    long l1 = paramInt3;
    long l2 = paramArrayOfInt1[(paramInt1 + 0)];
    paramInt3 = paramInt2 + 0;
    l1 = (l1 & 0xFFFFFFFF) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l1);
    l2 = paramArrayOfInt1[(paramInt1 + 1)];
    paramInt3 = paramInt2 + 1;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l1);
    l2 = paramArrayOfInt1[(paramInt1 + 2)];
    paramInt3 = paramInt2 + 2;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l1);
    l2 = paramArrayOfInt1[(paramInt1 + 3)];
    paramInt3 = paramInt2 + 3;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l1);
    l2 = paramArrayOfInt1[(paramInt1 + 4)];
    paramInt3 = paramInt2 + 4;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt3] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt3] = ((int)l1);
    l2 = paramArrayOfInt1[(paramInt1 + 5)];
    paramInt1 = paramInt2 + 5;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[paramInt1]));
    paramArrayOfInt2[paramInt1] = ((int)l1);
    return (int)(l1 >>> 32);
  }
  
  public static int addTo(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) + (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt2[3] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt2[4] = ((int)l);
    l = (l >>> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[5]));
    paramArrayOfInt2[5] = ((int)l);
    return (int)(l >>> 32);
  }
  
  public static int addToEachOther(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    int i = paramInt1 + 0;
    long l1 = paramArrayOfInt1[i];
    int j = paramInt2 + 0;
    l1 = (l1 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF) + 0L;
    int k = (int)l1;
    paramArrayOfInt1[i] = k;
    paramArrayOfInt2[j] = k;
    i = paramInt1 + 1;
    long l2 = paramArrayOfInt1[i];
    j = paramInt2 + 1;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF));
    k = (int)l1;
    paramArrayOfInt1[i] = k;
    paramArrayOfInt2[j] = k;
    i = paramInt1 + 2;
    l2 = paramArrayOfInt1[i];
    j = paramInt2 + 2;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF));
    k = (int)l1;
    paramArrayOfInt1[i] = k;
    paramArrayOfInt2[j] = k;
    i = paramInt1 + 3;
    l2 = paramArrayOfInt1[i];
    j = paramInt2 + 3;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF));
    k = (int)l1;
    paramArrayOfInt1[i] = k;
    paramArrayOfInt2[j] = k;
    i = paramInt1 + 4;
    l2 = paramArrayOfInt1[i];
    j = paramInt2 + 4;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF));
    k = (int)l1;
    paramArrayOfInt1[i] = k;
    paramArrayOfInt2[j] = k;
    paramInt1 += 5;
    l2 = paramArrayOfInt1[paramInt1];
    paramInt2 += 5;
    l1 = (l1 >>> 32) + ((l2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[paramInt2]));
    i = (int)l1;
    paramArrayOfInt1[paramInt1] = i;
    paramArrayOfInt2[paramInt2] = i;
    return (int)(l1 >>> 32);
  }
  
  public static void copy(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    paramArrayOfInt2[0] = paramArrayOfInt1[0];
    paramArrayOfInt2[1] = paramArrayOfInt1[1];
    paramArrayOfInt2[2] = paramArrayOfInt1[2];
    paramArrayOfInt2[3] = paramArrayOfInt1[3];
    paramArrayOfInt2[4] = paramArrayOfInt1[4];
    paramArrayOfInt2[5] = paramArrayOfInt1[5];
  }
  
  public static void copy64(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    paramArrayOfLong2[0] = paramArrayOfLong1[0];
    paramArrayOfLong2[1] = paramArrayOfLong1[1];
    paramArrayOfLong2[2] = paramArrayOfLong1[2];
  }
  
  public static int[] create()
  {
    return new int[6];
  }
  
  public static long[] create64()
  {
    return new long[3];
  }
  
  public static int[] createExt()
  {
    return new int[12];
  }
  
  public static long[] createExt64()
  {
    return new long[6];
  }
  
  public static boolean diff(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    boolean bool = gte(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2);
    if (bool)
    {
      sub(paramArrayOfInt1, paramInt1, paramArrayOfInt2, paramInt2, paramArrayOfInt3, paramInt3);
      return bool;
    }
    sub(paramArrayOfInt2, paramInt2, paramArrayOfInt1, paramInt1, paramArrayOfInt3, paramInt3);
    return bool;
  }
  
  public static boolean eq(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 5;
    while (i >= 0)
    {
      if (paramArrayOfInt1[i] != paramArrayOfInt2[i]) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public static boolean eq64(long[] paramArrayOfLong1, long[] paramArrayOfLong2)
  {
    int i = 2;
    while (i >= 0)
    {
      if (paramArrayOfLong1[i] != paramArrayOfLong2[i]) {
        return false;
      }
      i -= 1;
    }
    return true;
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 192))
    {
      int[] arrayOfInt = create();
      int i = 0;
      while (paramBigInteger.signum() != 0)
      {
        arrayOfInt[i] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
        i += 1;
      }
      return arrayOfInt;
    }
    throw new IllegalArgumentException();
  }
  
  public static long[] fromBigInteger64(BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= 192))
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
  
  public static int getBit(int[] paramArrayOfInt, int paramInt)
  {
    if (paramInt == 0) {}
    int i;
    for (paramInt = paramArrayOfInt[0];; paramInt = paramArrayOfInt[i] >>> (paramInt & 0x1F))
    {
      return paramInt & 0x1;
      i = paramInt >> 5;
      if (i < 0) {
        break;
      }
      if (i >= 6) {
        return 0;
      }
    }
    return 0;
  }
  
  public static boolean gte(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    int i = 5;
    while (i >= 0)
    {
      int j = paramArrayOfInt1[(paramInt1 + i)] ^ 0x80000000;
      int k = 0x80000000 ^ paramArrayOfInt2[(paramInt2 + i)];
      if (j < k) {
        return false;
      }
      if (j > k) {
        return true;
      }
      i -= 1;
    }
    return true;
  }
  
  public static boolean gte(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 5;
    while (i >= 0)
    {
      int j = paramArrayOfInt1[i] ^ 0x80000000;
      int k = 0x80000000 ^ paramArrayOfInt2[i];
      if (j < k) {
        return false;
      }
      if (j > k) {
        return true;
      }
      i -= 1;
    }
    return true;
  }
  
  public static boolean isOne(int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    int i = 1;
    while (i < 6)
    {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isOne64(long[] paramArrayOfLong)
  {
    if (paramArrayOfLong[0] != 1L) {
      return false;
    }
    int i = 1;
    while (i < 3)
    {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isZero(int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < 6)
    {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isZero64(long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < 3)
    {
      if (paramArrayOfLong[i] != 0L) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void mul(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    long l3 = paramArrayOfInt2[(paramInt2 + 0)] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[(paramInt2 + 1)] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[(paramInt2 + 2)] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt2[(paramInt2 + 3)] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt2[(paramInt2 + 4)] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt2[(paramInt2 + 5)] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF;
    long l8 = l7 * l3 + 0L;
    paramArrayOfInt3[(paramInt3 + 0)] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l4;
    paramArrayOfInt3[(paramInt3 + 1)] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l2;
    paramArrayOfInt3[(paramInt3 + 2)] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l5;
    paramArrayOfInt3[(paramInt3 + 3)] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l6;
    paramArrayOfInt3[(paramInt3 + 4)] = ((int)l8);
    l7 = (l8 >>> 32) + l7 * l1;
    paramArrayOfInt3[(paramInt3 + 5)] = ((int)l7);
    paramArrayOfInt3[(paramInt3 + 6)] = ((int)(l7 >>> 32));
    paramInt2 = 1;
    while (paramInt2 < 6)
    {
      paramInt3 += 1;
      l7 = paramArrayOfInt1[(paramInt1 + paramInt2)] & 0xFFFFFFFF;
      int i = paramInt3 + 0;
      l8 = l7 * l3 + (paramArrayOfInt3[i] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[i] = ((int)l8);
      i = paramInt3 + 1;
      l8 = (l8 >>> 32) + (l7 * l4 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l8);
      i = paramInt3 + 2;
      l8 = (l8 >>> 32) + (l7 * l2 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l8);
      i = paramInt3 + 3;
      l8 = (l8 >>> 32) + (l7 * l5 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l8);
      i = paramInt3 + 4;
      l8 = (l8 >>> 32) + (l7 * l6 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l8);
      i = paramInt3 + 5;
      l7 = (l8 >>> 32) + (l7 * l1 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l7);
      paramArrayOfInt3[(paramInt3 + 6)] = ((int)(l7 >>> 32));
      paramInt2 += 1;
    }
  }
  
  public static void mul(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l3 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt2[2] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt2[3] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt2[4] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt2[5] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    long l8 = l7 * l3 + 0L;
    paramArrayOfInt3[0] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l2;
    paramArrayOfInt3[1] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l4;
    paramArrayOfInt3[2] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l5;
    paramArrayOfInt3[3] = ((int)l8);
    l8 = (l8 >>> 32) + l7 * l6;
    paramArrayOfInt3[4] = ((int)l8);
    l7 = (l8 >>> 32) + l7 * l1;
    paramArrayOfInt3[5] = ((int)l7);
    paramArrayOfInt3[6] = ((int)(l7 >>> 32));
    int j;
    for (int i = 1; i < 6; i = j)
    {
      l7 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      j = i + 0;
      l8 = l7 * l3 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l8);
      j = i + 1;
      l8 = (l8 >>> 32) + (l7 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l8);
      int k = i + 2;
      l8 = (l8 >>> 32) + (l7 * l4 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l8);
      k = i + 3;
      l8 = (l8 >>> 32) + (l7 * l5 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l8);
      k = i + 4;
      l8 = (l8 >>> 32) + (l7 * l6 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l8);
      k = i + 5;
      l7 = (l8 >>> 32) + (l7 * l1 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l7);
      paramArrayOfInt3[(i + 6)] = ((int)(l7 >>> 32));
    }
  }
  
  public static long mul33Add(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[(paramInt2 + 0)] & 0xFFFFFFFF;
    long l4 = l1 * l3 + (paramArrayOfInt2[(paramInt3 + 0)] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[(paramInt4 + 0)] = ((int)l4);
    long l2 = paramArrayOfInt1[(paramInt2 + 1)] & 0xFFFFFFFF;
    l4 = (l4 >>> 32) + (l1 * l2 + l3 + (paramArrayOfInt2[(paramInt3 + 1)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 1)] = ((int)l4);
    l3 = paramArrayOfInt1[(paramInt2 + 2)] & 0xFFFFFFFF;
    l4 = (l4 >>> 32) + (l1 * l3 + l2 + (paramArrayOfInt2[(paramInt3 + 2)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 2)] = ((int)l4);
    l2 = paramArrayOfInt1[(paramInt2 + 3)] & 0xFFFFFFFF;
    l4 = (l4 >>> 32) + (l1 * l2 + l3 + (paramArrayOfInt2[(paramInt3 + 3)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 3)] = ((int)l4);
    l3 = paramArrayOfInt1[(paramInt2 + 4)] & 0xFFFFFFFF;
    l4 = (l4 >>> 32) + (l1 * l3 + l2 + (paramArrayOfInt2[(paramInt3 + 4)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt4 + 4)] = ((int)l4);
    l2 = paramArrayOfInt1[(paramInt2 + 5)] & 0xFFFFFFFF;
    l1 = (l4 >>> 32) + (l1 * l2 + l3 + (0xFFFFFFFF & paramArrayOfInt2[(paramInt3 + 5)]));
    paramArrayOfInt3[(paramInt4 + 5)] = ((int)l1);
    return (l1 >>> 32) + l2;
  }
  
  public static int mul33DWordAdd(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l2 = paramLong & 0xFFFFFFFF;
    paramInt1 = paramInt2 + 0;
    long l3 = l1 * l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l3);
    paramLong >>>= 32;
    paramInt1 = paramInt2 + 1;
    l1 = (l3 >>> 32) + (l1 * paramLong + l2 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)l1);
    paramInt1 = paramInt2 + 2;
    paramLong = (l1 >>> 32) + (paramLong + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    paramInt1 = paramInt2 + 3;
    paramLong = (paramLong >>> 32) + (0xFFFFFFFF & paramArrayOfInt[paramInt1]);
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return Nat.incAt(6, paramArrayOfInt, paramInt2, 4);
  }
  
  public static int mul33WordAdd(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l2 = paramInt1;
    long l1 = paramInt2 & 0xFFFFFFFF;
    paramInt1 = paramInt3 + 0;
    l2 = (l2 & 0xFFFFFFFF) * l1 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l2);
    paramInt1 = paramInt3 + 1;
    l1 = (l2 >>> 32) + (l1 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)l1);
    paramInt1 = paramInt3 + 2;
    l1 = (l1 >>> 32) + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF);
    paramArrayOfInt[paramInt1] = ((int)l1);
    if (l1 >>> 32 == 0L) {
      return 0;
    }
    return Nat.incAt(6, paramArrayOfInt, paramInt3, 3);
  }
  
  public static int mulAddTo(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    long l3 = paramArrayOfInt2[(paramInt2 + 0)] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[(paramInt2 + 1)] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt2[(paramInt2 + 2)] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt2[(paramInt2 + 3)];
    long l6 = paramArrayOfInt2[(paramInt2 + 4)];
    long l7 = paramArrayOfInt2[(paramInt2 + 5)];
    paramInt2 = 0;
    long l4 = 0L;
    while (paramInt2 < 6)
    {
      long l8 = paramArrayOfInt1[(paramInt1 + paramInt2)] & 0xFFFFFFFF;
      int i = paramInt3 + 0;
      long l9 = l8 * l3 + (paramArrayOfInt3[i] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[i] = ((int)l9);
      i = paramInt3 + 1;
      l9 = (l9 >>> 32) + (l8 * l2 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l9);
      int j = paramInt3 + 2;
      l9 = (l9 >>> 32) + (l8 * l1 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l9);
      j = paramInt3 + 3;
      l9 = (l9 >>> 32) + (l8 * (l5 & 0xFFFFFFFF) + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l9);
      j = paramInt3 + 4;
      l9 = (l9 >>> 32) + (l8 * (l6 & 0xFFFFFFFF) + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l9);
      j = paramInt3 + 5;
      l8 = (l9 >>> 32) + (l8 * (l7 & 0xFFFFFFFF) + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l8);
      paramInt3 += 6;
      l4 = (l8 >>> 32) + (l4 + (paramArrayOfInt3[paramInt3] & 0xFFFFFFFF));
      paramArrayOfInt3[paramInt3] = ((int)l4);
      l4 >>>= 32;
      paramInt2 += 1;
      paramInt3 = i;
    }
    return (int)l4;
  }
  
  public static int mulAddTo(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int i = 0;
    long l3 = paramArrayOfInt2[0] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt2[1] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt2[2] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt2[3];
    long l7 = paramArrayOfInt2[4];
    long l4 = paramArrayOfInt2[5] & 0xFFFFFFFF;
    long l5 = 0L;
    while (i < 6)
    {
      long l8 = paramArrayOfInt1[i] & 0xFFFFFFFF;
      int j = i + 0;
      long l9 = l8 * l3 + (paramArrayOfInt3[j] & 0xFFFFFFFF) + 0L;
      paramArrayOfInt3[j] = ((int)l9);
      j = i + 1;
      l9 = (l9 >>> 32) + (l8 * l2 + (paramArrayOfInt3[j] & 0xFFFFFFFF));
      paramArrayOfInt3[j] = ((int)l9);
      int k = i + 2;
      l9 = (l9 >>> 32) + (l8 * l1 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l9);
      k = i + 3;
      l9 = (l9 >>> 32) + (l8 * (l6 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l9);
      k = i + 4;
      l9 = (l9 >>> 32) + (l8 * (l7 & 0xFFFFFFFF) + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l9);
      k = i + 5;
      l8 = (l9 >>> 32) + (l8 * l4 + (paramArrayOfInt3[k] & 0xFFFFFFFF));
      paramArrayOfInt3[k] = ((int)l8);
      i += 6;
      l5 = (l8 >>> 32) + (l5 + (paramArrayOfInt3[i] & 0xFFFFFFFF));
      paramArrayOfInt3[i] = ((int)l5);
      l5 >>>= 32;
      i = j;
    }
    return (int)l5;
  }
  
  public static int mulWord(int paramInt1, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    long l3 = paramInt1;
    long l1 = 0L;
    paramInt1 = 0;
    long l2;
    int i;
    do
    {
      l1 += (paramArrayOfInt1[paramInt1] & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF);
      paramArrayOfInt2[(paramInt2 + paramInt1)] = ((int)l1);
      l2 = l1 >>> 32;
      i = paramInt1 + 1;
      l1 = l2;
      paramInt1 = i;
    } while (i < 6);
    return (int)l2;
  }
  
  public static int mulWordAddExt(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[(paramInt2 + 0)];
    paramInt1 = paramInt3 + 0;
    l2 = (l2 & 0xFFFFFFFF) * l1 + (paramArrayOfInt2[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[paramInt1] = ((int)l2);
    long l3 = paramArrayOfInt1[(paramInt2 + 1)];
    paramInt1 = paramInt3 + 1;
    l2 = (l2 >>> 32) + ((l3 & 0xFFFFFFFF) * l1 + (paramArrayOfInt2[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt1] = ((int)l2);
    l3 = paramArrayOfInt1[(paramInt2 + 2)];
    paramInt1 = paramInt3 + 2;
    l2 = (l2 >>> 32) + ((l3 & 0xFFFFFFFF) * l1 + (paramArrayOfInt2[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt1] = ((int)l2);
    l3 = paramArrayOfInt1[(paramInt2 + 3)];
    paramInt1 = paramInt3 + 3;
    l2 = (l2 >>> 32) + ((l3 & 0xFFFFFFFF) * l1 + (paramArrayOfInt2[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt1] = ((int)l2);
    l3 = paramArrayOfInt1[(paramInt2 + 4)];
    paramInt1 = paramInt3 + 4;
    l2 = (l2 >>> 32) + ((l3 & 0xFFFFFFFF) * l1 + (paramArrayOfInt2[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt1] = ((int)l2);
    l3 = paramArrayOfInt1[(paramInt2 + 5)];
    paramInt1 = paramInt3 + 5;
    l1 = (l2 >>> 32) + (l1 * (l3 & 0xFFFFFFFF) + (paramArrayOfInt2[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt1] = ((int)l1);
    return (int)(l1 >>> 32);
  }
  
  public static int mulWordDwordAdd(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    long l1 = paramInt1 & 0xFFFFFFFF;
    paramInt1 = paramInt2 + 0;
    long l2 = (paramLong & 0xFFFFFFFF) * l1 + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt1] = ((int)l2);
    paramInt1 = paramInt2 + 1;
    paramLong = (l2 >>> 32) + (l1 * (paramLong >>> 32) + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    paramInt1 = paramInt2 + 2;
    paramLong = (paramLong >>> 32) + (paramArrayOfInt[paramInt1] & 0xFFFFFFFF);
    paramArrayOfInt[paramInt1] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return Nat.incAt(6, paramArrayOfInt, paramInt2, 3);
  }
  
  public static void square(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    long l1 = paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF;
    int i = 0;
    int j = 12;
    int m;
    for (int k = 5;; k = m)
    {
      m = k - 1;
      long l2 = paramArrayOfInt1[(paramInt1 + k)] & 0xFFFFFFFF;
      l2 *= l2;
      j -= 1;
      paramArrayOfInt2[(paramInt2 + j)] = (i << 31 | (int)(l2 >>> 33));
      j -= 1;
      paramArrayOfInt2[(paramInt2 + j)] = ((int)(l2 >>> 1));
      i = (int)l2;
      if (m <= 0)
      {
        long l3 = l1 * l1;
        long l5 = i << 31;
        paramArrayOfInt2[(paramInt2 + 0)] = ((int)l3);
        j = (int)(l3 >>> 32);
        l2 = paramArrayOfInt1[(paramInt1 + 1)] & 0xFFFFFFFF;
        i = paramInt2 + 2;
        long l4 = paramArrayOfInt2[i];
        long l7 = (l5 & 0xFFFFFFFF | l3 >>> 33) + l2 * l1;
        k = (int)l7;
        paramArrayOfInt2[(paramInt2 + 1)] = (k << 1 | j & 0x1);
        l3 = paramArrayOfInt1[(paramInt1 + 2)] & 0xFFFFFFFF;
        j = paramInt2 + 3;
        long l6 = paramArrayOfInt2[j];
        int n = paramInt2 + 4;
        l5 = paramArrayOfInt2[n];
        l4 = (l4 & 0xFFFFFFFF) + (l7 >>> 32) + l3 * l1;
        m = (int)l4;
        paramArrayOfInt2[i] = (m << 1 | k >>> 31);
        l7 = (l6 & 0xFFFFFFFF) + ((l4 >>> 32) + l3 * l2);
        long l8 = (l5 & 0xFFFFFFFF) + (l7 >>> 32);
        l4 = paramArrayOfInt1[(paramInt1 + 3)] & 0xFFFFFFFF;
        k = paramInt2 + 5;
        l5 = (paramArrayOfInt2[k] & 0xFFFFFFFF) + (l8 >>> 32);
        i = paramInt2 + 6;
        l6 = paramArrayOfInt2[i];
        l7 = (l7 & 0xFFFFFFFF) + l4 * l1;
        int i2 = (int)l7;
        paramArrayOfInt2[j] = (i2 << 1 | m >>> 31);
        long l9 = (l8 & 0xFFFFFFFF) + ((l7 >>> 32) + l4 * l2);
        l8 = (l5 & 0xFFFFFFFF) + ((l9 >>> 32) + l4 * l3);
        long l11 = (l6 & 0xFFFFFFFF) + (l5 >>> 32) + (l8 >>> 32);
        l5 = paramArrayOfInt1[(paramInt1 + 4)] & 0xFFFFFFFF;
        m = paramInt2 + 7;
        l6 = (paramArrayOfInt2[m] & 0xFFFFFFFF) + (l11 >>> 32);
        j = paramInt2 + 8;
        l7 = paramArrayOfInt2[j];
        l9 = (l9 & 0xFFFFFFFF) + l5 * l1;
        int i1 = (int)l9;
        paramArrayOfInt2[n] = (i2 >>> 31 | i1 << 1);
        long l10 = (l8 & 0xFFFFFFFF) + ((l9 >>> 32) + l5 * l2);
        l11 = (l11 & 0xFFFFFFFF) + ((l10 >>> 32) + l5 * l3);
        l8 = (l6 & 0xFFFFFFFF) + ((l11 >>> 32) + l5 * l4);
        long l12 = (l7 & 0xFFFFFFFF) + (l6 >>> 32) + (l8 >>> 32);
        l9 = paramArrayOfInt1[(paramInt1 + 5)] & 0xFFFFFFFF;
        n = paramInt2 + 9;
        l6 = (paramArrayOfInt2[n] & 0xFFFFFFFF) + (l12 >>> 32);
        paramInt1 = paramInt2 + 10;
        l7 = paramArrayOfInt2[paramInt1];
        l1 = (l10 & 0xFFFFFFFF) + l1 * l9;
        i2 = (int)l1;
        paramArrayOfInt2[k] = (i2 << 1 | i1 >>> 31);
        l1 = (l11 & 0xFFFFFFFF) + ((l1 >>> 32) + l9 * l2);
        l2 = (l8 & 0xFFFFFFFF) + ((l1 >>> 32) + l9 * l3);
        l3 = (l12 & 0xFFFFFFFF) + ((l2 >>> 32) + l9 * l4);
        l4 = (l6 & 0xFFFFFFFF) + ((l3 >>> 32) + l9 * l5);
        l5 = (l7 & 0xFFFFFFFF) + (l6 >>> 32) + (l4 >>> 32);
        k = (int)l1;
        paramArrayOfInt2[i] = (i2 >>> 31 | k << 1);
        i = (int)l2;
        paramArrayOfInt2[m] = (k >>> 31 | i << 1);
        k = (int)l3;
        paramArrayOfInt2[j] = (i >>> 31 | k << 1);
        i = (int)l4;
        paramArrayOfInt2[n] = (k >>> 31 | i << 1);
        j = (int)l5;
        paramArrayOfInt2[paramInt1] = (i >>> 31 | j << 1);
        paramInt1 = paramInt2 + 11;
        paramArrayOfInt2[paramInt1] = (j >>> 31 | paramArrayOfInt2[paramInt1] + (int)(l5 >>> 32) << 1);
        return;
      }
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l1 = paramArrayOfInt1[0] & 0xFFFFFFFF;
    int j = 12;
    int k = 5;
    int i = 0;
    for (;;)
    {
      int m = k - 1;
      long l2 = paramArrayOfInt1[k] & 0xFFFFFFFF;
      l2 *= l2;
      j -= 1;
      paramArrayOfInt2[j] = (i << 31 | (int)(l2 >>> 33));
      j -= 1;
      paramArrayOfInt2[j] = ((int)(l2 >>> 1));
      i = (int)l2;
      if (m <= 0)
      {
        long l3 = l1 * l1;
        long l5 = i << 31;
        paramArrayOfInt2[0] = ((int)l3);
        j = (int)(l3 >>> 32);
        l2 = paramArrayOfInt1[1] & 0xFFFFFFFF;
        long l4 = paramArrayOfInt2[2];
        long l7 = (l5 & 0xFFFFFFFF | l3 >>> 33) + l2 * l1;
        i = (int)l7;
        paramArrayOfInt2[1] = (i << 1 | j & 0x1);
        l3 = paramArrayOfInt1[2] & 0xFFFFFFFF;
        long l6 = paramArrayOfInt2[3];
        l5 = paramArrayOfInt2[4];
        l4 = (l4 & 0xFFFFFFFF) + (l7 >>> 32) + l3 * l1;
        j = (int)l4;
        paramArrayOfInt2[2] = (j << 1 | i >>> 31);
        l7 = (l6 & 0xFFFFFFFF) + ((l4 >>> 32) + l3 * l2);
        long l8 = (l5 & 0xFFFFFFFF) + (l7 >>> 32);
        l4 = paramArrayOfInt1[3] & 0xFFFFFFFF;
        l5 = (paramArrayOfInt2[5] & 0xFFFFFFFF) + (l8 >>> 32);
        l6 = paramArrayOfInt2[6];
        l7 = (l7 & 0xFFFFFFFF) + l4 * l1;
        i = (int)l7;
        paramArrayOfInt2[3] = (i << 1 | j >>> 31);
        long l9 = (l8 & 0xFFFFFFFF) + ((l7 >>> 32) + l4 * l2);
        l8 = (l5 & 0xFFFFFFFF) + ((l9 >>> 32) + l4 * l3);
        long l11 = (l6 & 0xFFFFFFFF) + (l5 >>> 32) + (l8 >>> 32);
        l5 = paramArrayOfInt1[4] & 0xFFFFFFFF;
        l6 = (paramArrayOfInt2[7] & 0xFFFFFFFF) + (l11 >>> 32);
        l7 = paramArrayOfInt2[8];
        l9 = (l9 & 0xFFFFFFFF) + l5 * l1;
        j = (int)l9;
        paramArrayOfInt2[4] = (j << 1 | i >>> 31);
        long l10 = (l8 & 0xFFFFFFFF) + ((l9 >>> 32) + l5 * l2);
        l11 = (l11 & 0xFFFFFFFF) + ((l10 >>> 32) + l5 * l3);
        l8 = (l6 & 0xFFFFFFFF) + ((l11 >>> 32) + l5 * l4);
        long l12 = (l7 & 0xFFFFFFFF) + (l6 >>> 32) + (l8 >>> 32);
        l9 = paramArrayOfInt1[5] & 0xFFFFFFFF;
        l6 = (paramArrayOfInt2[9] & 0xFFFFFFFF) + (l12 >>> 32);
        l7 = paramArrayOfInt2[10];
        l1 = (l10 & 0xFFFFFFFF) + l1 * l9;
        i = (int)l1;
        paramArrayOfInt2[5] = (i << 1 | j >>> 31);
        l1 = (l11 & 0xFFFFFFFF) + ((l1 >>> 32) + l9 * l2);
        l2 = (l8 & 0xFFFFFFFF) + ((l1 >>> 32) + l9 * l3);
        l3 = (l12 & 0xFFFFFFFF) + ((l2 >>> 32) + l9 * l4);
        l4 = (0xFFFFFFFF & l6) + ((l3 >>> 32) + l9 * l5);
        l5 = (l7 & 0xFFFFFFFF) + (l6 >>> 32) + (l4 >>> 32);
        j = (int)l1;
        paramArrayOfInt2[6] = (i >>> 31 | j << 1);
        i = (int)l2;
        paramArrayOfInt2[7] = (j >>> 31 | i << 1);
        j = (int)l3;
        paramArrayOfInt2[8] = (i >>> 31 | j << 1);
        i = (int)l4;
        paramArrayOfInt2[9] = (j >>> 31 | i << 1);
        j = (int)l5;
        paramArrayOfInt2[10] = (i >>> 31 | j << 1);
        paramArrayOfInt2[11] = (j >>> 31 | paramArrayOfInt2[11] + (int)(l5 >>> 32) << 1);
        return;
      }
      k = m;
    }
  }
  
  public static int sub(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2, int[] paramArrayOfInt3, int paramInt3)
  {
    long l = (paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 0)] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[(paramInt3 + 0)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 1)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 1)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 1)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 2)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 2)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 2)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 3)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 3)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 3)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 4)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 4)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 4)] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[(paramInt1 + 5)] & 0xFFFFFFFF) - (paramArrayOfInt2[(paramInt2 + 5)] & 0xFFFFFFFF));
    paramArrayOfInt3[(paramInt3 + 5)] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int sub(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt1[0] & 0xFFFFFFFF) - (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) - (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) - (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) - (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) - (paramArrayOfInt2[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int subBothFrom(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = (paramArrayOfInt3[0] & 0xFFFFFFFF) - (paramArrayOfInt1[0] & 0xFFFFFFFF) - (paramArrayOfInt2[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt3[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt3[1] & 0xFFFFFFFF) - (paramArrayOfInt1[1] & 0xFFFFFFFF) - (paramArrayOfInt2[1] & 0xFFFFFFFF));
    paramArrayOfInt3[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt3[2] & 0xFFFFFFFF) - (paramArrayOfInt1[2] & 0xFFFFFFFF) - (paramArrayOfInt2[2] & 0xFFFFFFFF));
    paramArrayOfInt3[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt3[3] & 0xFFFFFFFF) - (paramArrayOfInt1[3] & 0xFFFFFFFF) - (paramArrayOfInt2[3] & 0xFFFFFFFF));
    paramArrayOfInt3[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt3[4] & 0xFFFFFFFF) - (paramArrayOfInt1[4] & 0xFFFFFFFF) - (paramArrayOfInt2[4] & 0xFFFFFFFF));
    paramArrayOfInt3[4] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt3[5] & 0xFFFFFFFF) - (paramArrayOfInt1[5] & 0xFFFFFFFF) - (paramArrayOfInt2[5] & 0xFFFFFFFF));
    paramArrayOfInt3[5] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int subFrom(int[] paramArrayOfInt1, int paramInt1, int[] paramArrayOfInt2, int paramInt2)
  {
    int i = paramInt2 + 0;
    long l = (paramArrayOfInt2[i] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt1 + 0)] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[i] = ((int)l);
    i = paramInt2 + 1;
    l = (l >> 32) + ((paramArrayOfInt2[i] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt1 + 1)] & 0xFFFFFFFF));
    paramArrayOfInt2[i] = ((int)l);
    i = paramInt2 + 2;
    l = (l >> 32) + ((paramArrayOfInt2[i] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt1 + 2)] & 0xFFFFFFFF));
    paramArrayOfInt2[i] = ((int)l);
    i = paramInt2 + 3;
    l = (l >> 32) + ((paramArrayOfInt2[i] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt1 + 3)] & 0xFFFFFFFF));
    paramArrayOfInt2[i] = ((int)l);
    i = paramInt2 + 4;
    l = (l >> 32) + ((paramArrayOfInt2[i] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt1 + 4)] & 0xFFFFFFFF));
    paramArrayOfInt2[i] = ((int)l);
    paramInt2 += 5;
    l = (l >> 32) + ((paramArrayOfInt2[paramInt2] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt1 + 5)] & 0xFFFFFFFF));
    paramArrayOfInt2[paramInt2] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static int subFrom(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = (paramArrayOfInt2[0] & 0xFFFFFFFF) - (paramArrayOfInt1[0] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt2[0] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[1] & 0xFFFFFFFF) - (paramArrayOfInt1[1] & 0xFFFFFFFF));
    paramArrayOfInt2[1] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[2] & 0xFFFFFFFF) - (paramArrayOfInt1[2] & 0xFFFFFFFF));
    paramArrayOfInt2[2] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[3] & 0xFFFFFFFF) - (paramArrayOfInt1[3] & 0xFFFFFFFF));
    paramArrayOfInt2[3] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[4] & 0xFFFFFFFF) - (paramArrayOfInt1[4] & 0xFFFFFFFF));
    paramArrayOfInt2[4] = ((int)l);
    l = (l >> 32) + ((paramArrayOfInt2[5] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[5]));
    paramArrayOfInt2[5] = ((int)l);
    return (int)(l >> 32);
  }
  
  public static BigInteger toBigInteger(int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[24];
    int i = 0;
    while (i < 6)
    {
      int j = paramArrayOfInt[i];
      if (j != 0) {
        Pack.intToBigEndian(j, arrayOfByte, 5 - i << 2);
      }
      i += 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static BigInteger toBigInteger64(long[] paramArrayOfLong)
  {
    byte[] arrayOfByte = new byte[24];
    int i = 0;
    while (i < 3)
    {
      long l = paramArrayOfLong[i];
      if (l != 0L) {
        Pack.longToBigEndian(l, arrayOfByte, 2 - i << 3);
      }
      i += 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static void zero(int[] paramArrayOfInt)
  {
    paramArrayOfInt[0] = 0;
    paramArrayOfInt[1] = 0;
    paramArrayOfInt[2] = 0;
    paramArrayOfInt[3] = 0;
    paramArrayOfInt[4] = 0;
    paramArrayOfInt[5] = 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Nat192.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */