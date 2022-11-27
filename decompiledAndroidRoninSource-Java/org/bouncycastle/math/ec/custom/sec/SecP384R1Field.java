package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat384;

public class SecP384R1Field
{
  private static final long M = 4294967295L;
  static final int[] P = { -1, 0, 0, -1, -2, -1, -1, -1, -1, -1, -1, -1 };
  private static final int P11 = -1;
  static final int[] PExt = { 1, -2, 0, 2, 0, -2, 0, 2, 1, 0, 0, 0, -2, 1, 0, -2, -3, -1, -1, -1, -1, -1, -1, -1 };
  private static final int PExt23 = -1;
  private static final int[] PExtInv = { -1, 1, -1, -3, -1, 1, -1, -3, -2, -1, -1, -1, 1, -2, -1, 1, 2 };
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (Nat.gte(12, paramArrayOfInt3, P)))) {
      addPInvTo(paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(24, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[23] == -1) && (Nat.gte(24, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(24, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(12, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[11] == -1) && (Nat.gte(12, paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
  
  private static void addPInvTo(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[0] = ((int)l1);
    l1 = (l1 >> 32) + ((paramArrayOfInt[1] & 0xFFFFFFFF) - 1L);
    paramArrayOfInt[1] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[3] = ((int)l1);
    l1 = (l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[4]) + 1L);
    paramArrayOfInt[4] = ((int)l1);
    if (l1 >> 32 != 0L) {
      Nat.incAt(12, paramArrayOfInt, 5);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat.fromBigInteger(384, paramBigInteger);
    if ((paramBigInteger[11] == -1) && (Nat.gte(12, paramBigInteger, P))) {
      Nat.subFrom(12, P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(12, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(12, paramArrayOfInt2, Nat.add(12, paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat.create(24);
    Nat384.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat.isZero(12, paramArrayOfInt1))
    {
      Nat.zero(12, paramArrayOfInt2);
      return;
    }
    Nat.sub(12, P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l7 = paramArrayOfInt1[16] & 0xFFFFFFFF;
    long l8 = paramArrayOfInt1[17] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[18] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt1[19] & 0xFFFFFFFF;
    long l2 = paramArrayOfInt1[20] & 0xFFFFFFFF;
    long l12 = paramArrayOfInt1[21] & 0xFFFFFFFF;
    long l5 = paramArrayOfInt1[22] & 0xFFFFFFFF;
    long l14 = paramArrayOfInt1[23] & 0xFFFFFFFF;
    long l15 = (paramArrayOfInt1[12] & 0xFFFFFFFF) + l2 - 1L;
    long l11 = (paramArrayOfInt1[13] & 0xFFFFFFFF) + l5;
    long l10 = (paramArrayOfInt1[14] & 0xFFFFFFFF) + l5 + l14;
    long l9 = (paramArrayOfInt1[15] & 0xFFFFFFFF) + l14;
    long l6 = l8 + l12;
    long l4 = l12 - l14;
    l5 -= l14;
    long l13 = l15 + l4;
    long l16 = (paramArrayOfInt1[0] & 0xFFFFFFFF) + l13 + 0L;
    paramArrayOfInt2[0] = ((int)l16);
    l14 = (l16 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + l14 - l15 + l11);
    paramArrayOfInt2[1] = ((int)l14);
    l14 = (l14 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) - l12 - l11 + l10);
    paramArrayOfInt2[2] = ((int)l14);
    l14 = (l14 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) - l10 + l9 + l13);
    paramArrayOfInt2[3] = ((int)l14);
    l12 = (l14 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + l7 + l12 + l11 - l9 + l13);
    paramArrayOfInt2[4] = ((int)l12);
    l11 = (l12 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) - l7 + l11 + l10 + l6);
    paramArrayOfInt2[5] = ((int)l11);
    l10 = (l11 >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + l3 - l8 + l10 + l9);
    paramArrayOfInt2[6] = ((int)l10);
    l9 = (l10 >> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) + l7 + l1 - l3 + l9);
    paramArrayOfInt2[7] = ((int)l9);
    l7 = (l9 >> 32) + ((paramArrayOfInt1[8] & 0xFFFFFFFF) + l7 + l8 + l2 - l1);
    paramArrayOfInt2[8] = ((int)l7);
    l6 = (l7 >> 32) + ((paramArrayOfInt1[9] & 0xFFFFFFFF) + l3 - l2 + l6);
    paramArrayOfInt2[9] = ((int)l6);
    l3 = (l6 >> 32) + ((paramArrayOfInt1[10] & 0xFFFFFFFF) + l3 + l1 - l4 + l5);
    paramArrayOfInt2[10] = ((int)l3);
    l1 = (l3 >> 32) + ((paramArrayOfInt1[11] & 0xFFFFFFFF) + l1 + l2 - l5);
    paramArrayOfInt2[11] = ((int)l1);
    reduce32((int)((l1 >> 32) + 1L), paramArrayOfInt2);
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    long l1;
    if (paramInt != 0)
    {
      long l3 = paramInt & 0xFFFFFFFF;
      l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + l3 + 0L;
      paramArrayOfInt[0] = ((int)l1);
      l1 = (l1 >> 32) + ((paramArrayOfInt[1] & 0xFFFFFFFF) - l3);
      paramArrayOfInt[1] = ((int)l1);
      long l2 = l1 >> 32;
      l1 = l2;
      if (l2 != 0L)
      {
        l1 = l2 + (paramArrayOfInt[2] & 0xFFFFFFFF);
        paramArrayOfInt[2] = ((int)l1);
        l1 >>= 32;
      }
      l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) + l3;
      paramArrayOfInt[3] = ((int)l1);
      l1 = (l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[4]) + l3);
      paramArrayOfInt[4] = ((int)l1);
      l1 >>= 32;
    }
    else
    {
      l1 = 0L;
    }
    if (((l1 != 0L) && (Nat.incAt(12, paramArrayOfInt, 5) != 0)) || ((paramArrayOfInt[11] == -1) && (Nat.gte(12, paramArrayOfInt, P)))) {
      addPInvTo(paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat.create(24);
    Nat384.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat.create(24);
    Nat384.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat384.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static void subPInvFrom(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[0] = ((int)l1);
    l1 = (l1 >> 32) + ((paramArrayOfInt[1] & 0xFFFFFFFF) + 1L);
    paramArrayOfInt[1] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[3] = ((int)l1);
    l1 = (l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[4]) - 1L);
    paramArrayOfInt[4] = ((int)l1);
    if (l1 >> 32 != 0L) {
      Nat.decAt(12, paramArrayOfInt, 5);
    }
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      subPInvFrom(paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(24, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.decAt(24, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(12, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[11] == -1) && (Nat.gte(12, paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP384R1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */