package org.bouncycastle.math.raw;

import java.math.BigInteger;
import org.bouncycastle.util.Pack;

public abstract class Nat
{
  private static final long M = 4294967295L;
  
  public static int add(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int add33At(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = paramInt3 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) + (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    paramInt2 = paramInt3 + 1;
    l = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[paramInt2]) + 1L);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3 + 2);
  }
  
  public static int add33At(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4)
  {
    int i = paramInt3 + paramInt4;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) + (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    paramInt2 = i + 1;
    l = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[paramInt2]) + 1L);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3, paramInt4 + 2);
  }
  
  public static int add33To(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) + (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l);
    l = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[1]) + 1L);
    paramArrayOfInt[1] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, 2);
  }
  
  public static int add33To(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = paramInt3 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) + (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    paramInt2 = paramInt3 + 1;
    l = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[paramInt2]) + 1L);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3, 2);
  }
  
  public static int addBothTo(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    long l1 = 0L;
    int i = 0;
    while (i < paramInt1)
    {
      long l2 = paramArrayOfInt1[(paramInt2 + i)];
      long l3 = paramArrayOfInt2[(paramInt3 + i)];
      int j = paramInt4 + i;
      l1 += (l2 & 0xFFFFFFFF) + (l3 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt3[j]);
      paramArrayOfInt3[j] = ((int)l1);
      l1 >>>= 32;
      i += 1;
    }
    return (int)l1;
  }
  
  public static int addBothTo(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (paramArrayOfInt2[i] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt3[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int addDWordAt(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramInt2 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) + (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    i = paramInt2 + 1;
    paramLong = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[i]) + (paramLong >>> 32));
    paramArrayOfInt[i] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt2 + 2);
  }
  
  public static int addDWordAt(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int i = paramInt2 + paramInt3;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) + (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    i += 1;
    paramLong = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[i]) + (paramLong >>> 32));
    paramArrayOfInt[i] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt2, paramInt3 + 2);
  }
  
  public static int addDWordTo(int paramInt, long paramLong, int[] paramArrayOfInt)
  {
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) + (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l);
    paramLong = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[1]) + (paramLong >>> 32));
    paramArrayOfInt[1] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt, paramArrayOfInt, 2);
  }
  
  public static int addDWordTo(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramInt2 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) + (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    i = paramInt2 + 1;
    paramLong = (l >>> 32) + ((0xFFFFFFFF & paramArrayOfInt[i]) + (paramLong >>> 32));
    paramArrayOfInt[i] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt2, 2);
  }
  
  public static int addTo(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    long l1 = 0L;
    int i = 0;
    while (i < paramInt1)
    {
      long l2 = paramArrayOfInt1[(paramInt2 + i)];
      int j = paramInt3 + i;
      l1 += (l2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[j]);
      paramArrayOfInt2[j] = ((int)l1);
      l1 >>>= 32;
      i += 1;
    }
    return (int)l1;
  }
  
  public static int addTo(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt2[i] = ((int)l);
      l >>>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int addWordAt(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l = (paramInt2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt[paramInt3]);
    paramArrayOfInt[paramInt3] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3 + 1);
  }
  
  public static int addWordAt(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4)
  {
    long l = paramInt2;
    paramInt2 = paramInt3 + paramInt4;
    l = (l & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt[paramInt2]);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3, paramInt4 + 1);
  }
  
  public static int addWordTo(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    long l = (paramInt2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt[0]);
    paramArrayOfInt[0] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, 1);
  }
  
  public static int addWordTo(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l = (paramInt2 & 0xFFFFFFFF) + (0xFFFFFFFF & paramArrayOfInt[paramInt3]);
    paramArrayOfInt[paramInt3] = ((int)l);
    if (l >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3, 1);
  }
  
  public static void copy(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    System.arraycopy(paramArrayOfInt1, 0, paramArrayOfInt2, 0, paramInt);
  }
  
  public static int[] copy(int paramInt, int[] paramArrayOfInt)
  {
    int[] arrayOfInt = new int[paramInt];
    System.arraycopy(paramArrayOfInt, 0, arrayOfInt, 0, paramInt);
    return arrayOfInt;
  }
  
  public static int[] create(int paramInt)
  {
    return new int[paramInt];
  }
  
  public static long[] create64(int paramInt)
  {
    return new long[paramInt];
  }
  
  public static int dec(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfInt[i] - 1;
      paramArrayOfInt[i] = j;
      if (j != -1) {
        return 0;
      }
      i += 1;
    }
    return -1;
  }
  
  public static int dec(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    while (i < paramInt)
    {
      int k = paramArrayOfInt1[i] - 1;
      paramArrayOfInt2[i] = k;
      int j = i + 1;
      i = j;
      if (k != -1)
      {
        while (j < paramInt)
        {
          paramArrayOfInt2[j] = paramArrayOfInt1[j];
          j += 1;
        }
        return 0;
      }
    }
    return -1;
  }
  
  public static int decAt(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    while (paramInt2 < paramInt1)
    {
      int i = paramArrayOfInt[paramInt2] - 1;
      paramArrayOfInt[paramInt2] = i;
      if (i != -1) {
        return 0;
      }
      paramInt2 += 1;
    }
    return -1;
  }
  
  public static int decAt(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    while (paramInt3 < paramInt1)
    {
      int i = paramInt2 + paramInt3;
      int j = paramArrayOfInt[i] - 1;
      paramArrayOfInt[i] = j;
      if (j != -1) {
        return 0;
      }
      paramInt3 += 1;
    }
    return -1;
  }
  
  public static boolean eq(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    paramInt -= 1;
    while (paramInt >= 0)
    {
      if (paramArrayOfInt1[paramInt] != paramArrayOfInt2[paramInt]) {
        return false;
      }
      paramInt -= 1;
    }
    return true;
  }
  
  public static int[] fromBigInteger(int paramInt, BigInteger paramBigInteger)
  {
    if ((paramBigInteger.signum() >= 0) && (paramBigInteger.bitLength() <= paramInt))
    {
      int[] arrayOfInt = create(paramInt + 31 >> 5);
      paramInt = 0;
      while (paramBigInteger.signum() != 0)
      {
        arrayOfInt[paramInt] = paramBigInteger.intValue();
        paramBigInteger = paramBigInteger.shiftRight(32);
        paramInt += 1;
      }
      return arrayOfInt;
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
      if (i >= paramArrayOfInt.length) {
        return 0;
      }
    }
    return 0;
  }
  
  public static boolean gte(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    paramInt -= 1;
    while (paramInt >= 0)
    {
      int i = paramArrayOfInt1[paramInt] ^ 0x80000000;
      int j = 0x80000000 ^ paramArrayOfInt2[paramInt];
      if (i < j) {
        return false;
      }
      if (i > j) {
        return true;
      }
      paramInt -= 1;
    }
    return true;
  }
  
  public static int inc(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfInt[i] + 1;
      paramArrayOfInt[i] = j;
      if (j != 0) {
        return 0;
      }
      i += 1;
    }
    return 1;
  }
  
  public static int inc(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int i = 0;
    while (i < paramInt)
    {
      int k = paramArrayOfInt1[i] + 1;
      paramArrayOfInt2[i] = k;
      int j = i + 1;
      i = j;
      if (k != 0)
      {
        while (j < paramInt)
        {
          paramArrayOfInt2[j] = paramArrayOfInt1[j];
          j += 1;
        }
        return 0;
      }
    }
    return 1;
  }
  
  public static int incAt(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    while (paramInt2 < paramInt1)
    {
      int i = paramArrayOfInt[paramInt2] + 1;
      paramArrayOfInt[paramInt2] = i;
      if (i != 0) {
        return 0;
      }
      paramInt2 += 1;
    }
    return 1;
  }
  
  public static int incAt(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    while (paramInt3 < paramInt1)
    {
      int i = paramInt2 + paramInt3;
      int j = paramArrayOfInt[i] + 1;
      paramArrayOfInt[i] = j;
      if (j != 0) {
        return 0;
      }
      paramInt3 += 1;
    }
    return 1;
  }
  
  public static boolean isOne(int paramInt, int[] paramArrayOfInt)
  {
    if (paramArrayOfInt[0] != 1) {
      return false;
    }
    int i = 1;
    while (i < paramInt)
    {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static boolean isZero(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramArrayOfInt[i] != 0) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public static void mul(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    paramArrayOfInt3[(paramInt4 + paramInt1)] = mulWord(paramInt1, paramArrayOfInt1[paramInt2], paramArrayOfInt2, paramInt3, paramArrayOfInt3, paramInt4);
    int i = 1;
    while (i < paramInt1)
    {
      int j = paramInt4 + i;
      paramArrayOfInt3[(j + paramInt1)] = mulWordAddTo(paramInt1, paramArrayOfInt1[(paramInt2 + i)], paramArrayOfInt2, paramInt3, paramArrayOfInt3, j);
      i += 1;
    }
  }
  
  public static void mul(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    paramArrayOfInt3[paramInt] = mulWord(paramInt, paramArrayOfInt1[0], paramArrayOfInt2, paramArrayOfInt3);
    int i = 1;
    while (i < paramInt)
    {
      paramArrayOfInt3[(i + paramInt)] = mulWordAddTo(paramInt, paramArrayOfInt1[i], paramArrayOfInt2, 0, paramArrayOfInt3, i);
      i += 1;
    }
  }
  
  public static int mul31BothAdd(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int[] paramArrayOfInt3, int paramInt4)
  {
    long l3 = paramInt2;
    long l4 = paramInt3;
    long l1 = 0L;
    paramInt2 = 0;
    long l2;
    do
    {
      l2 = paramArrayOfInt1[paramInt2];
      long l5 = paramArrayOfInt2[paramInt2];
      paramInt3 = paramInt4 + paramInt2;
      l1 += (l2 & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF) + (l5 & 0xFFFFFFFF) * (l4 & 0xFFFFFFFF) + (paramArrayOfInt3[paramInt3] & 0xFFFFFFFF);
      paramArrayOfInt3[paramInt3] = ((int)l1);
      l2 = l1 >>> 32;
      paramInt3 = paramInt2 + 1;
      l1 = l2;
      paramInt2 = paramInt3;
    } while (paramInt3 < paramInt1);
    return (int)l2;
  }
  
  public static int mulAddTo(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    int i = paramInt4;
    long l1 = 0L;
    paramInt4 = 0;
    while (paramInt4 < paramInt1)
    {
      long l2 = mulWordAddTo(paramInt1, paramArrayOfInt1[(paramInt2 + paramInt4)], paramArrayOfInt2, paramInt3, paramArrayOfInt3, i);
      int j = i + paramInt1;
      l1 = (l2 & 0xFFFFFFFF) + (l1 + (0xFFFFFFFF & paramArrayOfInt3[j]));
      paramArrayOfInt3[j] = ((int)l1);
      l1 >>>= 32;
      i += 1;
      paramInt4 += 1;
    }
    return (int)l1;
  }
  
  public static int mulAddTo(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l1 = 0L;
    int i = 0;
    while (i < paramInt)
    {
      long l2 = mulWordAddTo(paramInt, paramArrayOfInt1[i], paramArrayOfInt2, 0, paramArrayOfInt3, i);
      int j = i + paramInt;
      l1 = (l2 & 0xFFFFFFFF) + (l1 + (0xFFFFFFFF & paramArrayOfInt3[j]));
      paramArrayOfInt3[j] = ((int)l1);
      l1 >>>= 32;
      i += 1;
    }
    return (int)l1;
  }
  
  public static int mulWord(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int paramInt4)
  {
    long l3 = paramInt2;
    long l1 = 0L;
    paramInt2 = 0;
    long l2;
    int i;
    do
    {
      l1 += (paramArrayOfInt1[(paramInt3 + paramInt2)] & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF);
      paramArrayOfInt2[(paramInt4 + paramInt2)] = ((int)l1);
      l2 = l1 >>> 32;
      i = paramInt2 + 1;
      l1 = l2;
      paramInt2 = i;
    } while (i < paramInt1);
    return (int)l2;
  }
  
  public static int mulWord(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l3 = paramInt2;
    long l1 = 0L;
    paramInt2 = 0;
    long l2;
    int i;
    do
    {
      l1 += (paramArrayOfInt1[paramInt2] & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF);
      paramArrayOfInt2[paramInt2] = ((int)l1);
      l2 = l1 >>> 32;
      i = paramInt2 + 1;
      l1 = l2;
      paramInt2 = i;
    } while (i < paramInt1);
    return (int)l2;
  }
  
  public static int mulWordAddTo(int paramInt1, int paramInt2, int[] paramArrayOfInt1, int paramInt3, int[] paramArrayOfInt2, int paramInt4)
  {
    long l3 = paramInt2;
    long l1 = 0L;
    paramInt2 = 0;
    long l2;
    int i;
    do
    {
      l2 = paramArrayOfInt1[(paramInt3 + paramInt2)];
      i = paramInt4 + paramInt2;
      l1 += (l2 & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF) + (paramArrayOfInt2[i] & 0xFFFFFFFF);
      paramArrayOfInt2[i] = ((int)l1);
      l2 = l1 >>> 32;
      i = paramInt2 + 1;
      l1 = l2;
      paramInt2 = i;
    } while (i < paramInt1);
    return (int)l2;
  }
  
  public static int mulWordDwordAddAt(int paramInt1, int paramInt2, long paramLong, int[] paramArrayOfInt, int paramInt3)
  {
    long l1 = paramInt2 & 0xFFFFFFFF;
    paramInt2 = paramInt3 + 0;
    long l2 = (paramLong & 0xFFFFFFFF) * l1 + (paramArrayOfInt[paramInt2] & 0xFFFFFFFF) + 0L;
    paramArrayOfInt[paramInt2] = ((int)l2);
    paramInt2 = paramInt3 + 1;
    paramLong = (l2 >>> 32) + (l1 * (paramLong >>> 32) + (paramArrayOfInt[paramInt2] & 0xFFFFFFFF));
    paramArrayOfInt[paramInt2] = ((int)paramLong);
    paramInt2 = paramInt3 + 2;
    paramLong = (paramLong >>> 32) + (paramArrayOfInt[paramInt2] & 0xFFFFFFFF);
    paramArrayOfInt[paramInt2] = ((int)paramLong);
    if (paramLong >>> 32 == 0L) {
      return 0;
    }
    return incAt(paramInt1, paramArrayOfInt, paramInt3 + 3);
  }
  
  public static int shiftDownBit(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = (paramInt2 << 31 | i >>> 1);
      paramInt2 = i;
    }
    return paramInt2 << 31;
  }
  
  public static int shiftDownBit(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int j = paramInt2 + paramInt1;
      int i = paramArrayOfInt[j];
      paramArrayOfInt[j] = (paramInt3 << 31 | i >>> 1);
      paramInt3 = i;
    }
    return paramInt3 << 31;
  }
  
  public static int shiftDownBit(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt1[(paramInt2 + paramInt1)];
      paramArrayOfInt2[(paramInt4 + paramInt1)] = (paramInt3 << 31 | i >>> 1);
      paramInt3 = i;
    }
    return paramInt3 << 31;
  }
  
  public static int shiftDownBit(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt1[paramInt1];
      paramArrayOfInt2[paramInt1] = (paramInt2 << 31 | i >>> 1);
      paramInt2 = i;
    }
    return paramInt2 << 31;
  }
  
  public static int shiftDownBits(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = (paramInt3 << -paramInt2 | i >>> paramInt2);
      paramInt3 = i;
    }
    return paramInt3 << -paramInt2;
  }
  
  public static int shiftDownBits(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int j = paramInt2 + paramInt1;
      int i = paramArrayOfInt[j];
      paramArrayOfInt[j] = (paramInt4 << -paramInt3 | i >>> paramInt3);
      paramInt4 = i;
    }
    return paramInt4 << -paramInt3;
  }
  
  public static int shiftDownBits(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt2, int paramInt5)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt1[(paramInt2 + paramInt1)];
      paramArrayOfInt2[(paramInt5 + paramInt1)] = (paramInt4 << -paramInt3 | i >>> paramInt3);
      paramInt4 = i;
    }
    return paramInt4 << -paramInt3;
  }
  
  public static int shiftDownBits(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt1[paramInt1];
      paramArrayOfInt2[paramInt1] = (paramInt3 << -paramInt2 | i >>> paramInt2);
      paramInt3 = i;
    }
    return paramInt3 << -paramInt2;
  }
  
  public static int shiftDownWord(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    for (;;)
    {
      paramInt1 -= 1;
      if (paramInt1 < 0) {
        break;
      }
      int i = paramArrayOfInt[paramInt1];
      paramArrayOfInt[paramInt1] = paramInt2;
      paramInt2 = i;
    }
    return paramInt2;
  }
  
  public static int shiftUpBit(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      j = paramArrayOfInt[paramInt2];
      paramArrayOfInt[paramInt2] = (i >>> 31 | j << 1);
      paramInt2 += 1;
      i = j;
    }
    return i >>> 31;
  }
  
  public static int shiftUpBit(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = paramInt3;
    paramInt3 = j;
    while (paramInt3 < paramInt1)
    {
      int k = paramInt2 + paramInt3;
      j = paramArrayOfInt[k];
      paramArrayOfInt[k] = (i >>> 31 | j << 1);
      paramInt3 += 1;
      i = j;
    }
    return i >>> 31;
  }
  
  public static int shiftUpBit(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2, int paramInt4)
  {
    int j = 0;
    int i = paramInt3;
    paramInt3 = j;
    while (paramInt3 < paramInt1)
    {
      j = paramArrayOfInt1[(paramInt2 + paramInt3)];
      paramArrayOfInt2[(paramInt4 + paramInt3)] = (i >>> 31 | j << 1);
      paramInt3 += 1;
      i = j;
    }
    return i >>> 31;
  }
  
  public static int shiftUpBit(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    int j = 0;
    int i = paramInt2;
    paramInt2 = j;
    while (paramInt2 < paramInt1)
    {
      j = paramArrayOfInt1[paramInt2];
      paramArrayOfInt2[paramInt2] = (i >>> 31 | j << 1);
      paramInt2 += 1;
      i = j;
    }
    return i >>> 31;
  }
  
  public static long shiftUpBit64(int paramInt1, long[] paramArrayOfLong1, int paramInt2, long paramLong, long[] paramArrayOfLong2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt1)
    {
      long l = paramArrayOfLong1[(paramInt2 + i)];
      paramArrayOfLong2[(paramInt3 + i)] = (paramLong >>> 63 | l << 1);
      i += 1;
      paramLong = l;
    }
    return paramLong >>> 63;
  }
  
  public static int shiftUpBits(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int j = 0;
    int i = paramInt3;
    paramInt3 = j;
    while (paramInt3 < paramInt1)
    {
      j = paramArrayOfInt[paramInt3];
      paramArrayOfInt[paramInt3] = (i >>> -paramInt2 | j << paramInt2);
      paramInt3 += 1;
      i = j;
    }
    return i >>> -paramInt2;
  }
  
  public static int shiftUpBits(int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    int i = paramInt4;
    paramInt4 = j;
    while (paramInt4 < paramInt1)
    {
      int k = paramInt2 + paramInt4;
      j = paramArrayOfInt[k];
      paramArrayOfInt[k] = (i >>> -paramInt3 | j << paramInt3);
      paramInt4 += 1;
      i = j;
    }
    return i >>> -paramInt3;
  }
  
  public static int shiftUpBits(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int paramInt4, int[] paramArrayOfInt2, int paramInt5)
  {
    int j = 0;
    int i = paramInt4;
    paramInt4 = j;
    while (paramInt4 < paramInt1)
    {
      j = paramArrayOfInt1[(paramInt2 + paramInt4)];
      paramArrayOfInt2[(paramInt5 + paramInt4)] = (i >>> -paramInt3 | j << paramInt3);
      paramInt4 += 1;
      i = j;
    }
    return i >>> -paramInt3;
  }
  
  public static int shiftUpBits(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt2)
  {
    int j = 0;
    int i = paramInt3;
    paramInt3 = j;
    while (paramInt3 < paramInt1)
    {
      j = paramArrayOfInt1[paramInt3];
      paramArrayOfInt2[paramInt3] = (i >>> -paramInt2 | j << paramInt2);
      paramInt3 += 1;
      i = j;
    }
    return i >>> -paramInt2;
  }
  
  public static long shiftUpBits64(int paramInt1, long[] paramArrayOfLong, int paramInt2, int paramInt3, long paramLong)
  {
    int i = 0;
    while (i < paramInt1)
    {
      int j = paramInt2 + i;
      long l = paramArrayOfLong[j];
      paramArrayOfLong[j] = (paramLong >>> -paramInt3 | l << paramInt3);
      i += 1;
      paramLong = l;
    }
    return paramLong >>> -paramInt3;
  }
  
  public static long shiftUpBits64(int paramInt1, long[] paramArrayOfLong1, int paramInt2, int paramInt3, long paramLong, long[] paramArrayOfLong2, int paramInt4)
  {
    int i = 0;
    while (i < paramInt1)
    {
      long l = paramArrayOfLong1[(paramInt2 + i)];
      paramArrayOfLong2[(paramInt4 + i)] = (paramLong >>> -paramInt3 | l << paramInt3);
      i += 1;
      paramLong = l;
    }
    return paramLong >>> -paramInt3;
  }
  
  public static void square(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    int m = paramInt1 << 1;
    int i = 0;
    int j = paramInt1;
    int k = m;
    int n;
    int i1;
    do
    {
      n = j - 1;
      long l = paramArrayOfInt1[(paramInt2 + n)] & 0xFFFFFFFF;
      l *= l;
      j = k - 1;
      paramArrayOfInt2[(paramInt3 + j)] = (i << 31 | (int)(l >>> 33));
      k = j - 1;
      i1 = 1;
      paramArrayOfInt2[(paramInt3 + k)] = ((int)(l >>> 1));
      i = (int)l;
      j = n;
    } while (n > 0);
    i = i1;
    while (i < paramInt1)
    {
      addWordAt(m, squareWordAdd(paramArrayOfInt1, paramInt2, i, paramArrayOfInt2, paramInt3), paramArrayOfInt2, paramInt3, i << 1);
      i += 1;
    }
    shiftUpBit(m, paramArrayOfInt2, paramInt3, paramArrayOfInt1[paramInt2] << 31);
  }
  
  public static void square(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int m = paramInt << 1;
    int i = 0;
    int k = paramInt;
    int j = m;
    for (;;)
    {
      k -= 1;
      long l = paramArrayOfInt1[k] & 0xFFFFFFFF;
      l *= l;
      j -= 1;
      paramArrayOfInt2[j] = (i << 31 | (int)(l >>> 33));
      j -= 1;
      i = 1;
      paramArrayOfInt2[j] = ((int)(l >>> 1));
      int n = (int)l;
      if (k <= 0)
      {
        while (i < paramInt)
        {
          addWordAt(m, squareWordAdd(paramArrayOfInt1, i, paramArrayOfInt2), paramArrayOfInt2, i << 1);
          i += 1;
        }
        shiftUpBit(m, paramArrayOfInt2, paramArrayOfInt1[0] << 31);
        return;
      }
      i = n;
    }
  }
  
  public static int squareWordAdd(int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    long l3 = paramArrayOfInt1[(paramInt1 + paramInt2)];
    long l1 = 0L;
    int j = 0;
    int i = paramInt3;
    paramInt3 = j;
    long l2;
    do
    {
      l2 = paramArrayOfInt1[(paramInt1 + paramInt3)];
      j = paramInt2 + i;
      l1 += (l2 & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF);
      paramArrayOfInt2[j] = ((int)l1);
      l2 = l1 >>> 32;
      i += 1;
      j = paramInt3 + 1;
      l1 = l2;
      paramInt3 = j;
    } while (j < paramInt2);
    return (int)l2;
  }
  
  public static int squareWordAdd(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    long l3 = paramArrayOfInt1[paramInt];
    long l1 = 0L;
    int i = 0;
    long l2;
    int j;
    do
    {
      l2 = paramArrayOfInt1[i];
      j = paramInt + i;
      l1 += (l2 & 0xFFFFFFFF) * (l3 & 0xFFFFFFFF) + (paramArrayOfInt2[j] & 0xFFFFFFFF);
      paramArrayOfInt2[j] = ((int)l1);
      l2 = l1 >>> 32;
      j = i + 1;
      l1 = l2;
      i = j;
    } while (j < paramInt);
    return (int)l2;
  }
  
  public static int sub(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt1)
    {
      l += (paramArrayOfInt1[(paramInt2 + i)] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[(paramInt3 + i)]);
      paramArrayOfInt3[(paramInt4 + i)] = ((int)l);
      l >>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int sub(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += (paramArrayOfInt1[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int sub33At(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = paramInt3 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    paramInt2 = paramInt3 + 1;
    l = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[paramInt2]) - 1L);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt3 + 2);
  }
  
  public static int sub33At(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4)
  {
    int i = paramInt3 + paramInt4;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    paramInt2 = i + 1;
    l = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[paramInt2]) - 1L);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt3, paramInt4 + 2);
  }
  
  public static int sub33From(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) - (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l);
    l = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[1]) - 1L);
    paramArrayOfInt[1] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, 2);
  }
  
  public static int sub33From(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = paramInt3 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (paramInt2 & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    paramInt2 = paramInt3 + 1;
    l = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[paramInt2]) - 1L);
    paramArrayOfInt[paramInt2] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt3, 2);
  }
  
  public static int subBothFrom(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3, int[] paramArrayOfInt3, int paramInt4)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt1)
    {
      int j = paramInt4 + i;
      l += (paramArrayOfInt3[j] & 0xFFFFFFFF) - (paramArrayOfInt1[(paramInt2 + i)] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[(paramInt3 + i)]);
      paramArrayOfInt3[j] = ((int)l);
      l >>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int subBothFrom(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += (paramArrayOfInt3[i] & 0xFFFFFFFF) - (paramArrayOfInt1[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt2[i]);
      paramArrayOfInt3[i] = ((int)l);
      l >>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int subDWordAt(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramInt2 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    i = paramInt2 + 1;
    paramLong = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[i]) - (paramLong >>> 32));
    paramArrayOfInt[i] = ((int)paramLong);
    if (paramLong >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt2 + 2);
  }
  
  public static int subDWordAt(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2, int paramInt3)
  {
    int i = paramInt2 + paramInt3;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    i += 1;
    paramLong = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[i]) - (paramLong >>> 32));
    paramArrayOfInt[i] = ((int)paramLong);
    if (paramLong >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt2, paramInt3 + 2);
  }
  
  public static int subDWordFrom(int paramInt, long paramLong, int[] paramArrayOfInt)
  {
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) - (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[0] = ((int)l);
    paramLong = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[1]) - (paramLong >>> 32));
    paramArrayOfInt[1] = ((int)paramLong);
    if (paramLong >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt, paramArrayOfInt, 2);
  }
  
  public static int subDWordFrom(int paramInt1, long paramLong, int[] paramArrayOfInt, int paramInt2)
  {
    int i = paramInt2 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (paramLong & 0xFFFFFFFF);
    paramArrayOfInt[i] = ((int)l);
    i = paramInt2 + 1;
    paramLong = (l >> 32) + ((0xFFFFFFFF & paramArrayOfInt[i]) - (paramLong >>> 32));
    paramArrayOfInt[i] = ((int)paramLong);
    if (paramLong >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt2, 2);
  }
  
  public static int subFrom(int paramInt1, int[] paramArrayOfInt1, int paramInt2, int[] paramArrayOfInt2, int paramInt3)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt1)
    {
      int j = paramInt3 + i;
      l += (paramArrayOfInt2[j] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[(paramInt2 + i)]);
      paramArrayOfInt2[j] = ((int)l);
      l >>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int subFrom(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l = 0L;
    int i = 0;
    while (i < paramInt)
    {
      l += (paramArrayOfInt2[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramArrayOfInt1[i]);
      paramArrayOfInt2[i] = ((int)l);
      l >>= 32;
      i += 1;
    }
    return (int)l;
  }
  
  public static int subWordAt(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    long l = (paramArrayOfInt[paramInt3] & 0xFFFFFFFF) - (0xFFFFFFFF & paramInt2);
    paramArrayOfInt[paramInt3] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt3 + 1);
  }
  
  public static int subWordAt(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3, int paramInt4)
  {
    int i = paramInt3 + paramInt4;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramInt2);
    paramArrayOfInt[i] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt3, paramInt4 + 1);
  }
  
  public static int subWordFrom(int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    long l = (paramArrayOfInt[0] & 0xFFFFFFFF) - (0xFFFFFFFF & paramInt2);
    paramArrayOfInt[0] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, 1);
  }
  
  public static int subWordFrom(int paramInt1, int paramInt2, int[] paramArrayOfInt, int paramInt3)
  {
    int i = paramInt3 + 0;
    long l = (paramArrayOfInt[i] & 0xFFFFFFFF) - (0xFFFFFFFF & paramInt2);
    paramArrayOfInt[i] = ((int)l);
    if (l >> 32 == 0L) {
      return 0;
    }
    return decAt(paramInt1, paramArrayOfInt, paramInt3, 1);
  }
  
  public static BigInteger toBigInteger(int paramInt, int[] paramArrayOfInt)
  {
    byte[] arrayOfByte = new byte[paramInt << 2];
    int i = 0;
    while (i < paramInt)
    {
      int j = paramArrayOfInt[i];
      if (j != 0) {
        Pack.intToBigEndian(j, arrayOfByte, paramInt - 1 - i << 2);
      }
      i += 1;
    }
    return new BigInteger(1, arrayOfByte);
  }
  
  public static void zero(int paramInt, int[] paramArrayOfInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramArrayOfInt[i] = 0;
      i += 1;
    }
  }
  
  public static void zero64(int paramInt, long[] paramArrayOfLong)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramArrayOfLong[i] = 0L;
      i += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\raw\Nat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */