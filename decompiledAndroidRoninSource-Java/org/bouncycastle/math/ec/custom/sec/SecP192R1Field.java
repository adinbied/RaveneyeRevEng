package org.bouncycastle.math.ec.custom.sec;

import java.math.BigInteger;
import org.bouncycastle.math.raw.Nat;
import org.bouncycastle.math.raw.Nat192;

public class SecP192R1Field
{
  private static final long M = 4294967295L;
  static final int[] P = { -1, -1, -2, -1, -1, -1 };
  private static final int P5 = -1;
  static final int[] PExt = { 1, 0, 2, 0, 1, 0, -2, -1, -3, -1, -1, -1 };
  private static final int PExt11 = -1;
  private static final int[] PExtInv = { -1, -1, -3, -1, -2, -1, 1, 0, 2 };
  
  public static void add(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat192.add(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[5] == -1) && (Nat192.gte(paramArrayOfInt3, P)))) {
      addPInvTo(paramArrayOfInt3);
    }
  }
  
  public static void addExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat.add(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (Nat.gte(12, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(12, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void addOne(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.inc(6, paramArrayOfInt1, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (Nat192.gte(paramArrayOfInt2, P)))) {
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
      l1 >>= 32;
    }
    l1 += (0xFFFFFFFF & paramArrayOfInt[2]) + 1L;
    paramArrayOfInt[2] = ((int)l1);
    if (l1 >> 32 != 0L) {
      Nat.incAt(6, paramArrayOfInt, 3);
    }
  }
  
  public static int[] fromBigInteger(BigInteger paramBigInteger)
  {
    paramBigInteger = Nat192.fromBigInteger(paramBigInteger);
    if ((paramBigInteger[5] == -1) && (Nat192.gte(paramBigInteger, P))) {
      Nat192.subFrom(P, paramBigInteger);
    }
    return paramBigInteger;
  }
  
  public static void half(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((paramArrayOfInt1[0] & 0x1) == 0)
    {
      Nat.shiftDownBit(6, paramArrayOfInt1, 0, paramArrayOfInt2);
      return;
    }
    Nat.shiftDownBit(6, paramArrayOfInt2, Nat192.add(paramArrayOfInt1, P, paramArrayOfInt2));
  }
  
  public static void multiply(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    int[] arrayOfInt = Nat192.createExt();
    Nat192.mul(paramArrayOfInt1, paramArrayOfInt2, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt3);
  }
  
  public static void multiplyAddToExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((Nat192.mulAddTo(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) || ((paramArrayOfInt3[11] == -1) && (Nat.gte(12, paramArrayOfInt3, PExt))))
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.addTo(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.incAt(12, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void negate(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (Nat192.isZero(paramArrayOfInt1))
    {
      Nat192.zero(paramArrayOfInt2);
      return;
    }
    Nat192.sub(P, paramArrayOfInt1, paramArrayOfInt2);
  }
  
  public static void reduce(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    long l2 = paramArrayOfInt1[6] & 0xFFFFFFFF;
    long l1 = paramArrayOfInt1[7] & 0xFFFFFFFF;
    long l4 = paramArrayOfInt1[8];
    long l3 = paramArrayOfInt1[9];
    long l5 = paramArrayOfInt1[10];
    long l6 = paramArrayOfInt1[11];
    l5 = (l5 & 0xFFFFFFFF) + l2;
    l6 = (l6 & 0xFFFFFFFF) + l1;
    long l7 = (paramArrayOfInt1[0] & 0xFFFFFFFF) + l5 + 0L;
    int i = (int)l7;
    l7 = (l7 >> 32) + ((paramArrayOfInt1[1] & 0xFFFFFFFF) + l6);
    paramArrayOfInt2[1] = ((int)l7);
    l4 = l5 + (l4 & 0xFFFFFFFF);
    l5 = l6 + (l3 & 0xFFFFFFFF);
    l3 = (l7 >> 32) + ((paramArrayOfInt1[2] & 0xFFFFFFFF) + l4);
    l6 = (l3 >> 32) + ((paramArrayOfInt1[3] & 0xFFFFFFFF) + l5);
    paramArrayOfInt2[3] = ((int)l6);
    l2 = (l6 >> 32) + ((paramArrayOfInt1[4] & 0xFFFFFFFF) + (l4 - l2));
    paramArrayOfInt2[4] = ((int)l2);
    l1 = (l2 >> 32) + ((paramArrayOfInt1[5] & 0xFFFFFFFF) + (l5 - l1));
    paramArrayOfInt2[5] = ((int)l1);
    l1 >>= 32;
    l2 = (l3 & 0xFFFFFFFF) + l1;
    l1 += (i & 0xFFFFFFFF);
    paramArrayOfInt2[0] = ((int)l1);
    l3 = l1 >> 32;
    l1 = l2;
    if (l3 != 0L)
    {
      l1 = l3 + (0xFFFFFFFF & paramArrayOfInt2[1]);
      paramArrayOfInt2[1] = ((int)l1);
      l1 = l2 + (l1 >> 32);
    }
    paramArrayOfInt2[2] = ((int)l1);
    if (((l1 >> 32 != 0L) && (Nat.incAt(6, paramArrayOfInt2, 3) != 0)) || ((paramArrayOfInt2[5] == -1) && (Nat192.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
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
        l1 >>= 32;
      }
      l1 += (0xFFFFFFFF & paramArrayOfInt[2]) + l3;
      paramArrayOfInt[2] = ((int)l1);
      l1 >>= 32;
    }
    else
    {
      l1 = 0L;
    }
    if (((l1 != 0L) && (Nat.incAt(6, paramArrayOfInt, 3) != 0)) || ((paramArrayOfInt[5] == -1) && (Nat192.gte(paramArrayOfInt, P)))) {
      addPInvTo(paramArrayOfInt);
    }
  }
  
  public static void square(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat192.createExt();
    Nat192.square(paramArrayOfInt1, arrayOfInt);
    reduce(arrayOfInt, paramArrayOfInt2);
  }
  
  public static void squareN(int[] paramArrayOfInt1, int paramInt, int[] paramArrayOfInt2)
  {
    int[] arrayOfInt = Nat192.createExt();
    Nat192.square(paramArrayOfInt1, arrayOfInt);
    for (;;)
    {
      reduce(arrayOfInt, paramArrayOfInt2);
      paramInt -= 1;
      if (paramInt <= 0) {
        break;
      }
      Nat192.square(paramArrayOfInt2, arrayOfInt);
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
      l1 >>= 32;
    }
    l1 += (0xFFFFFFFF & paramArrayOfInt[2]) - 1L;
    paramArrayOfInt[2] = ((int)l1);
    if (l1 >> 32 != 0L) {
      Nat.decAt(6, paramArrayOfInt, 3);
    }
  }
  
  public static void subtract(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat192.sub(paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0) {
      subPInvFrom(paramArrayOfInt3);
    }
  }
  
  public static void subtractExt(int[] paramArrayOfInt1, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if (Nat.sub(12, paramArrayOfInt1, paramArrayOfInt2, paramArrayOfInt3) != 0)
    {
      paramArrayOfInt1 = PExtInv;
      if (Nat.subFrom(paramArrayOfInt1.length, paramArrayOfInt1, paramArrayOfInt3) != 0) {
        Nat.decAt(12, paramArrayOfInt3, PExtInv.length);
      }
    }
  }
  
  public static void twice(int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if ((Nat.shiftUpBit(6, paramArrayOfInt1, 0, paramArrayOfInt2) != 0) || ((paramArrayOfInt2[5] == -1) && (Nat192.gte(paramArrayOfInt2, P)))) {
      addPInvTo(paramArrayOfInt2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\math\ec\custom\sec\SecP192R1Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */