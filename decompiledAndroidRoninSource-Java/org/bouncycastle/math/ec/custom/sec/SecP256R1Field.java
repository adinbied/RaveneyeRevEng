package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat256;

public class SecP256R1Field
{
  private static final long M = 4294967295L;
  static final int[] P = { -1, -1, -1, 0, 0, 0, 1, -1 };
  private static final int P7 = -1;
  static final int[] PExt = { 1, 0, 0, -2, -1, -1, -2, 1, -2, 1, -2, 1, 1, -2, 2, -2 };
  private static final int PExt15 = -1;
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat256.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[7] == -1) && (Nat256.gte(paramArrayOfInt3, P)))) {
      addPInvTo(paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[15] == -1) && (Nat.gte(16, paramArrayOfInt3, PExt)))) {
      Nat.subFrom(16, PExt, paramArrayOfInt3);
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(8, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] == -1) && (Nat256.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
  
  private static void addPInvTo(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
      paramArrayOfInt[1] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[3] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[4] & 0xFFFFFFFF);
      paramArrayOfInt[4] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[5] & 0xFFFFFFFF);
      paramArrayOfInt[5] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[6] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[6] = ((int)l1);
    paramArrayOfInt[7] = ((int)((l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[7]) + 1L)));
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat256.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[7] == -1) && (Nat256.gte(paramBigInteger, P))) {
      Nat256.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(8, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(8, paramArrayOfInt2, Nat256.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat256.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[15] == -1) && (Nat.gte(16, paramArrayOfInt3, PExt)))) {
      Nat.subFrom(16, PExt, paramArrayOfInt3);
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat256.isZero(paramArrayOfInt1))
    {
      Nat256.zero(paramArrayOfInt2);
      return;
    }
    Nat256.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l2 = paramArrayOfInt1[8];
    long l10 = paramArrayOfInt1[9] & 0xFFFFFFFF;
    long l3 = paramArrayOfInt1[10] & 0xFFFFFFFF;
    long l8 = paramArrayOfInt1[11] & 0xFFFFFFFF;
    long l6 = paramArrayOfInt1[12] & 0xFFFFFFFF;
    long l7 = paramArrayOfInt1[13] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt1[14] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt1[15] & 0xFFFFFFFF;
    l2 = (l2 & 0xFFFFFFFF) - 6L;
    long l5 = l10 + l3;
    l3 = l3 + l8 - l1;
    l8 += l6;
    l6 += l7;
    long l9 = l7 + l4;
    l7 = l4 + l1;
    l10 = l9 - (l2 + l10);
    long l11 = (paramArrayOfInt1[0] & 0xFFFFFFFF) - l8 - l10 + 0L;
    paramArrayOfInt2[0] = ((int)l11);
    l11 = (l11 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + l5 - l6 - l7);
    paramArrayOfInt2[1] = ((int)l11);
    l11 = (l11 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + l3 - l9);
    paramArrayOfInt2[2] = ((int)l11);
    l8 = (l11 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + (l8 << 1) + l10 - l7);
    paramArrayOfInt2[3] = ((int)l8);
    l4 = (l8 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (l6 << 1) + l4 - l5);
    paramArrayOfInt2[4] = ((int)l4);
    l4 = (l4 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (l9 << 1) - l3);
    paramArrayOfInt2[5] = ((int)l4);
    l4 = (l4 >> 32) + ((paramArrayOfInt1[6] & 0xFFFFFFFF) + (l7 << 1) + l10);
    paramArrayOfInt2[6] = ((int)l4);
    l1 = (l4 >> 32) + ((paramArrayOfInt1[7] & 0xFFFFFFFF) + (l1 << 1) + l2 - l3 - l6);
    paramArrayOfInt2[7] = ((int)l1);
    reduce32((int)((l1 >> 32) + 6L), paramArrayOfInt2);
  }
  
  public static void reduce32(int paramInt, int[] paramArrayOfInt)
  {
    long l1;
    if (paramInt != 0)
    {
      long l3 = paramInt & 0xFFFFFFFF;
      l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) + l3 + 0L;
      paramArrayOfInt[0] = ((int)l1);
      long l2 = l1 >> 32;
      l1 = l2;
      if (l2 != 0L)
      {
        l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
        paramArrayOfInt[1] = ((int)l1);
        l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
        paramArrayOfInt[2] = ((int)l1);
        l1 >>= 32;
      }
      l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) - l3;
      paramArrayOfInt[3] = ((int)l1);
      l2 = l1 >> 32;
      l1 = l2;
      if (l2 != 0L)
      {
        l1 = l2 + (paramArrayOfInt[4] & 0xFFFFFFFF);
        paramArrayOfInt[4] = ((int)l1);
        l1 = (l1 >> 32) + (paramArrayOfInt[5] & 0xFFFFFFFF);
        paramArrayOfInt[5] = ((int)l1);
        l1 >>= 32;
      }
      l1 += (paramArrayOfInt[6] & 0xFFFFFFFF) - l3;
      paramArrayOfInt[6] = ((int)l1);
      l1 = (l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[7]) + l3);
      paramArrayOfInt[7] = ((int)l1);
      l1 >>= 32;
    }
    else
    {
      l1 = 0L;
    }
    if ((l1 != 0L) || ((paramArrayOfInt[7] == -1) && (Nat256.gte(paramArrayOfInt, P)))) {
      addPInvTo(paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat256.createExt();
    Nat256.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat256.square(paramArrayOfInt2, arrayOfInt);
    }
  }
  
  private static void subPInvFrom(int[] paramArrayOfInt)
  {
    long l1 = (paramArrayOfInt[0] & 0xFFFFFFFF) - 1L;
    paramArrayOfInt[0] = ((int)l1);
    long l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[1] & 0xFFFFFFFF);
      paramArrayOfInt[1] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[2] & 0xFFFFFFFF);
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[3] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[3] = ((int)l1);
    l2 = l1 >> 32;
    l1 = l2;
    if (l2 != 0L)
    {
      l1 = l2 + (paramArrayOfInt[4] & 0xFFFFFFFF);
      paramArrayOfInt[4] = ((int)l1);
      l1 = (l1 >> 32) + (paramArrayOfInt[5] & 0xFFFFFFFF);
      paramArrayOfInt[5] = ((int)l1);
      l1 >>= 32;
    }
    l1 += (paramArrayOfInt[6] & 0xFFFFFFFF) + 1L;
    paramArrayOfInt[6] = ((int)l1);
    paramArrayOfInt[7] = ((int)((l1 >> 32) + ((0xFFFFFFFF & paramArrayOfInt[7]) - 1L)));
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat256.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      subPInvFrom(paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(16, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      Nat.addTo(16, PExt, paramArrayOfInt3);
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(8, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[7] == -1) && (Nat256.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP256R1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */